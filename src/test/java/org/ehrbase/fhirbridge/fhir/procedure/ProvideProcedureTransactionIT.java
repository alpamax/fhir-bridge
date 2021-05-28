package org.ehrbase.fhirbridge.fhir.procedure;

import ca.uhn.fhir.rest.api.MethodOutcome;
import org.ehrbase.fhirbridge.fhir.AbstractTransactionIT;
import org.hl7.fhir.r4.model.Procedure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Integration Tests that validate "Provide Procedure" transaction.
 */
class ProvideProcedureTransactionIT extends AbstractTransactionIT {

    @Test
    void provideProcedureCreate() throws Exception {
        var outcome = create("Procedure/transactions/provide-procedure-create.json");

        Assertions.assertEquals(true, outcome.getCreated());
        Assertions.assertNotNull(outcome.getId().getValue());
    }

    @Test
    void provideProcedureConditionalUpdate() throws Exception {
        MethodOutcome outcome;

        outcome = create("Procedure/transactions/provide-procedure-create.json");
        var id = outcome.getId();

        outcome = update("Procedure/transactions/provide-procedure-update.json", "Procedure?_id=" + id.getIdPart() + "&subject.identifier=" + PATIENT_ID);

        Assertions.assertEquals(id.getIdPart(), outcome.getId().getIdPart());
        Assertions.assertEquals(id.getVersionIdPartAsLong() + 1, outcome.getId().getVersionIdPartAsLong());

        var procedure = (Procedure) outcome.getResource();

        Assertions.assertEquals(PATIENT_ID, procedure.getSubject().getIdentifier().getValue());
        Assertions.assertEquals(Procedure.ProcedureStatus.ONHOLD, procedure.getStatus());
    }
}
