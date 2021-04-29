package org.ehrbase.fhirbridge.ehr.converter.specific.impfstatus;

import org.ehrbase.fhirbridge.ehr.converter.generic.ImmunizationToCompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.ImpfstatusComposition;
import org.hl7.fhir.r4.model.Immunization;

public class ImpfstatusCompositionConverter extends ImmunizationToCompositionConverter<ImpfstatusComposition> {

    @Override
    protected ImpfstatusComposition convertInternal(Immunization resource) {
        ImpfstatusComposition impfstatusComposition = new ImpfstatusComposition();
        if(!resource.getOccurrenceDateTimeType().hasExtension() || resource.getVaccineCode().getCoding().get(0).getSystem().equals("http://hl7.org/fhir/uv/ips/CodeSystem/absent-unknown-uv-ips")){
            impfstatusComposition.setImpfung(new ImpfungActionConverter().convert(resource));
        }else{
            impfstatusComposition.setUnbekannterImpfstatus(new UnbekannterImpfstatusEvaluationConverter().convert(resource));
        }
        return impfstatusComposition;
    }
}
