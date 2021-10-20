package org.ehrbase.fhirbridge.ehr.opt.befundderblutgasanalysecomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DvCodedText;
import java.lang.Double;
import java.lang.String;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

public class SauerstoffsaettigungClusterContainment extends Containment {
  public SelectAqlField<SauerstoffsaettigungCluster> SAUERSTOFFSAETTIGUNG_CLUSTER = new AqlFieldImp<SauerstoffsaettigungCluster>(SauerstoffsaettigungCluster.class, "", "SauerstoffsaettigungCluster", SauerstoffsaettigungCluster.class, this);

  public SelectAqlField<DvCodedText> BEZEICHNUNG_DES_ANALYTS = new AqlFieldImp<DvCodedText>(SauerstoffsaettigungCluster.class, "/items[at0024]/value", "bezeichnungDesAnalyts", DvCodedText.class, this);

  public SelectAqlField<NullFlavour> BEZEICHNUNG_DES_ANALYTS_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(SauerstoffsaettigungCluster.class, "/items[at0024]/null_flavour|defining_code", "bezeichnungDesAnalytsNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<Double> ANALYT_ERGEBNIS_MAGNITUDE = new AqlFieldImp<Double>(SauerstoffsaettigungCluster.class, "/items[at0001]/value|magnitude", "analytErgebnisMagnitude", Double.class, this);

  public SelectAqlField<String> ANALYT_ERGEBNIS_UNITS = new AqlFieldImp<String>(SauerstoffsaettigungCluster.class, "/items[at0001]/value|units", "analytErgebnisUnits", String.class, this);

  public SelectAqlField<NullFlavour> ANALYT_ERGEBNIS_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(SauerstoffsaettigungCluster.class, "/items[at0001]/null_flavour|defining_code", "analytErgebnisNullFlavourDefiningCode", NullFlavour.class, this);

  public ListSelectAqlField<Cluster> ANALYSEERGEBNIS_DETAIL = new ListAqlFieldImp<Cluster>(SauerstoffsaettigungCluster.class, "/items[at0014]", "analyseergebnisDetail", Cluster.class, this);

  public SelectAqlField<NullFlavour> TESTMETHODE_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(SauerstoffsaettigungCluster.class, "/items[at0028]/null_flavour|defining_code", "testmethodeNullFlavourDefiningCode", NullFlavour.class, this);

  public ListSelectAqlField<SauerstoffpartialdruckErgebnisStatusElement> ERGEBNIS_STATUS = new ListAqlFieldImp<SauerstoffpartialdruckErgebnisStatusElement>(SauerstoffsaettigungCluster.class, "/items[at0005]", "ergebnisStatus", SauerstoffpartialdruckErgebnisStatusElement.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(SauerstoffsaettigungCluster.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  public SelectAqlField<KohlendioxidpartialdruckTestmethodeChoice> TESTMETHODE = new AqlFieldImp<KohlendioxidpartialdruckTestmethodeChoice>(SauerstoffsaettigungCluster.class, "/items[at0028]/value", "testmethode", KohlendioxidpartialdruckTestmethodeChoice.class, this);

  private SauerstoffsaettigungClusterContainment() {
    super("openEHR-EHR-CLUSTER.laboratory_test_analyte.v1");
  }

  public static SauerstoffsaettigungClusterContainment getInstance() {
    return new SauerstoffsaettigungClusterContainment();
  }
}
