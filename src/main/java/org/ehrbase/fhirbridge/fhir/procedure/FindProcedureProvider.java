package org.ehrbase.fhirbridge.fhir.procedure;

import ca.uhn.fhir.rest.annotation.RequiredParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.param.ReferenceParam;
import ca.uhn.fhir.rest.param.TokenParam;
import org.ehrbase.client.aql.parameter.ParameterValue;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Procedure;
import org.openehealth.ipf.commons.ihe.fhir.AbstractPlainProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class FindProcedureProvider extends AbstractPlainProvider {

    private static final Logger LOG = LoggerFactory.getLogger(FindProcedureProvider.class);

    @Search
    @SuppressWarnings("unused")
    public List<Procedure> search(
            @RequiredParam(name = Procedure.SP_SUBJECT, chainWhitelist = {Patient.SP_IDENTIFIER}) ReferenceParam subject,
            RequestDetails requestDetails,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        LOG.trace("Searching procedure...");

        List<ParameterValue<?>> parameters = new ArrayList<>();
        String chain = subject.getChain();
        if (Patient.SP_IDENTIFIER.equals(chain)) {
            TokenParam tokenSubject = subject.toTokenParam(getFhirContext());
            parameters.add(new ParameterValue<>("subjectId", tokenSubject.getValue()));
        }

        return this.requestBundle(parameters, null, "Procedure", httpServletRequest, httpServletResponse, requestDetails);
    }
}
