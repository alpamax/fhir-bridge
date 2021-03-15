package org.ehrbase.fhirbridge.config;

import org.ehrbase.fhirbridge.ehr.converter.specificconverters.bloodpressure.BloodPressureCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.BodyHeightCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.bodytemperature.BodyTemperatureCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.BodyWeightCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.ConversionService;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.CoronavirusNachweisTestCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.DiagnoseCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.DiagnosticReportLabCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.FiO2CompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.heartrate.HeartRateCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.patient.PatientCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.PregnancyStatusCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.ProcedureCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.RespiratoryRateCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.bloodgas.BloodGasPanelCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.clinicalFrailty.ClinicalFrailtyScaleScoreCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.d4lquestionnaire.D4lQuestionnaireCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.geccoDiagnose.GECCODiagnoseCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.historyoftravel.HistoryOfTravelConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.observationlab.ObservationLabCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.patientinicu.PatientInIcuCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.pulseoximetry.PulseOximetryConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.radiologischerBefund.RadiologischerBefundConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.smokingstatus.SmokingStatusCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.sofascore.SofaScoreCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specificconverters.symptom.SymptomCompositionConverter;
import org.ehrbase.fhirbridge.fhir.common.Profile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConversionConfiguration {

    @Bean(name = "fhirResourceConversionService")
    public ConversionService conversionService() {
        ConversionService conversionService = new ConversionService();

        // Register Resource Converters
        registerConditionConverters(conversionService);
        registerConsentConverters(conversionService);
        registerDiagnosticReportConverters(conversionService);
        registerObservationConverters(conversionService);
        registerPatientConverters(conversionService);
        registerQuestionnaireResponseConverter(conversionService);

        return conversionService;
    }

    private void registerConditionConverters(ConversionService conversionService) {
        conversionService.registerConverter(Profile.DEFAULT_CONDITION, new DiagnoseCompositionConverter());
        conversionService.registerConverter(Profile.SYMPTOMS_COVID_19, new SymptomCompositionConverter());
        GECCODiagnoseCompositionConverter diagnoseCommonConverter = new GECCODiagnoseCompositionConverter();
        conversionService.registerConverter(Profile.DIAGNOSE_LIVER_DISEASE, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_LUNG_DISEASE, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_DIABETES_MELLITUS, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_COVID_19, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_MALIGNANT_NEOPLASTIC_DISEASE, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_RHEUMATOLOGICAL_IMMUNOLOGICAL_DISEASE, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_CARDIOVASCULAR_DISEASE, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_CHRONIC_KIDNEY_DISEASE, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_CHRONIC_NEUROLOGICAL_MENTAL_DISEASE, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_GASTROINTESTINAL_ULCERS, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_HIV, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_ORGAN_RECIPIENT, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_COMPLICATIONS_COVID_19, diagnoseCommonConverter);
        conversionService.registerConverter(Profile.DIAGNOSE_DEPENDENCE_ON_VENTILATOR, diagnoseCommonConverter);
    }

    private void registerConsentConverters(ConversionService conversionService) {
        conversionService.registerConverter(Profile.DO_NOT_RESUSCITATE_ORDER, null); // TODO: @ErikTute, add your converter
    }

    private void registerDiagnosticReportConverters(ConversionService conversionService) {
        conversionService.registerConverter(Profile.DIAGNOSTIC_REPORT_LAB, new DiagnosticReportLabCompositionConverter());
        conversionService.registerConverter(Profile.DIAGNOSTIC_REPORT_RADIOLOGY, new RadiologischerBefundConverter());
    }

    private void registerObservationConverters(ConversionService conversionService) {
        conversionService.registerConverter(Profile.BODY_HEIGHT, new BodyHeightCompositionConverter());
        conversionService.registerConverter(Profile.BLOOD_GAS_PANEL, new BloodGasPanelCompositionConverter());
        conversionService.registerConverter(Profile.BLOOD_PRESSURE, new BloodPressureCompositionConverter());
        conversionService.registerConverter(Profile.BODY_TEMP, new BodyTemperatureCompositionConverter());
        conversionService.registerConverter(Profile.BODY_WEIGHT, new BodyWeightCompositionConverter());
        conversionService.registerConverter(Profile.CLINICAL_FRAILTY_SCALE, new ClinicalFrailtyScaleScoreCompositionConverter());
        conversionService.registerConverter(Profile.CORONARIRUS_NACHWEIS_TEST, new CoronavirusNachweisTestCompositionConverter());
        conversionService.registerConverter(Profile.FIO2, new FiO2CompositionConverter());
        conversionService.registerConverter(Profile.HEART_RATE, new HeartRateCompositionConverter());
        conversionService.registerConverter(Profile.PATIENT_IN_ICU, new PatientInIcuCompositionConverter());
        conversionService.registerConverter(Profile.PREGNANCY_STATUS, new PregnancyStatusCompositionConverter());
        conversionService.registerConverter(Profile.OBSERVATION_LAB, new ObservationLabCompositionConverter());
        conversionService.registerConverter(Profile.RESPIRATORY_RATE, new RespiratoryRateCompositionConverter());
        conversionService.registerConverter(Profile.SOFA_SCORE, new SofaScoreCompositionConverter());
        conversionService.registerConverter(Profile.SMOKING_STATUS, new SmokingStatusCompositionConverter());
        conversionService.registerConverter(Profile.PROCEDURE, new ProcedureCompositionConverter());
        conversionService.registerConverter(Profile.TRAVEL_HISTORY, new HistoryOfTravelConverter());
        conversionService.registerConverter(Profile.OXYGEN_SATURATION, new PulseOximetryConverter());
    }

    private void registerPatientConverters(ConversionService conversionService) {
        conversionService.registerConverter(Profile.PATIENT, new PatientCompositionConverter());
    }

    private void registerQuestionnaireResponseConverter(ConversionService conversionService) {
        conversionService.registerConverter(Profile.DEFAULT_QUESTIONNAIRE_RESPONSE, new D4lQuestionnaireCompositionConverter());
    }
}
