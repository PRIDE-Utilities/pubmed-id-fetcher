package uk.ac.ebi.pride.pubmed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Models a 'result' used in an array of EU PMC results.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EupmcResult{
  private String id;
  private String source;
  private String pmid;
  private String pmcid;
  private String doi;
  private String title;
  private String authorString;
  private String journalTitle;
  private String issue;
  private String journalVolume;
  private String pubYear;
  private String journalIssn;
  private String pageInfo;
  private String pubType;
  private BookOrReportDetails bookOrReportDetails;
  private String isOpenAccess;
  private String inEPMC;
  private String inPMC;
  private String hasPDF;
  private String hasBook;
  private String hasSuppl;
  private int citedByCount;
  private String hasReferences;
  private String hasTextMinedTerms;
  private String hasDbCrossReferences;
  private EupmcDbCrossReferenceArray dbCrossReferenceList;
  private String hasLabsLinks;
  private String hasTMAccessionNumbers;
  private EupmcTmAccessionTypeArray tmAccessionTypeList;
  private String firstIndexDate;
  private String firstPublicationDate;
}
