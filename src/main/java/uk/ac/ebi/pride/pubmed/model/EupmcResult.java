package uk.ac.ebi.pride.pubmed.model;

public class EupmcResult {
  String id;
  String source;
  String pmid;
  String pmcid;
  String doi;
  String title;
  String authorString;
  String journalTitle;
  String issue;
  String journalVolume;
  String pubYear;
  String journalIssn;
  String pageInfo;
  String pubType;
  String isOpenAccess;
  String inEPMC;
  String inPMC;
  String hasPDF;
  String hasBook;
  String hasSuppl;
  int citedByCount;
  String hasReferences;
  String hasTextMinedTerms;
  String hasDbCrossReferences;
  EupmcDbCrossReferenceArray dbCrossReferenceList;
  String hasLabsLinks;
  String hasTMAccessionNumbers;
  EupmcTmAccessionTypeArray tmAccessionTypeList;
  String firstPublicationDate;

  /**
   * Sets new firstPublicationDate.
   *
   * @param firstPublicationDate New value of firstPublicationDate.
   */
  public void setFirstPublicationDate(String firstPublicationDate) {
    this.firstPublicationDate = firstPublicationDate;
  }

  /**
   * Sets new source.
   *
   * @param source New value of source.
   */
  public void setSource(String source) {
    this.source = source;
  }

  /**
   * Gets hasTMAccessionNumbers.
   *
   * @return Value of hasTMAccessionNumbers.
   */
  public String getHasTMAccessionNumbers() {
    return hasTMAccessionNumbers;
  }

  /**
   * Sets new title.
   *
   * @param title New value of title.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets hasDbCrossReferences.
   *
   * @return Value of hasDbCrossReferences.
   */
  public String getHasDbCrossReferences() {
    return hasDbCrossReferences;
  }

  /**
   * Gets firstPublicationDate.
   *
   * @return Value of firstPublicationDate.
   */
  public String getFirstPublicationDate() {
    return firstPublicationDate;
  }

  /**
   * Sets new dbCrossReferenceList.
   *
   * @param dbCrossReferenceList New value of dbCrossReferenceList.
   */
  public void setDbCrossReferenceList(EupmcDbCrossReferenceArray dbCrossReferenceList) {
    this.dbCrossReferenceList = dbCrossReferenceList;
  }

  /**
   * Sets new pmid.
   *
   * @param pmid New value of pmid.
   */
  public void setPmid(String pmid) {
    this.pmid = pmid;
  }

  /**
   * Gets source.
   *
   * @return Value of source.
   */
  public String getSource() {
    return source;
  }

  /**
   * Gets dbCrossReferenceList.
   *
   * @return Value of dbCrossReferenceList.
   */
  public EupmcDbCrossReferenceArray getDbCrossReferenceList() {
    return dbCrossReferenceList;
  }

  /**
   * Sets new inEPMC.
   *
   * @param inEPMC New value of inEPMC.
   */
  public void setInEPMC(String inEPMC) {
    this.inEPMC = inEPMC;
  }

  /**
   * Gets journalVolume.
   *
   * @return Value of journalVolume.
   */
  public String getJournalVolume() {
    return journalVolume;
  }

  /**
   * Gets inPMC.
   *
   * @return Value of inPMC.
   */
  public String getInPMC() {
    return inPMC;
  }

  /**
   * Sets new journalIssn.
   *
   * @param journalIssn New value of journalIssn.
   */
  public void setJournalIssn(String journalIssn) {
    this.journalIssn = journalIssn;
  }

  /**
   * Sets new hasBook.
   *
   * @param hasBook New value of hasBook.
   */
  public void setHasBook(String hasBook) {
    this.hasBook = hasBook;
  }

  /**
   * Sets new hasReferences.
   *
   * @param hasReferences New value of hasReferences.
   */
  public void setHasReferences(String hasReferences) {
    this.hasReferences = hasReferences;
  }

  /**
   * Gets id.
   *
   * @return Value of id.
   */
  public String getId() {
    return id;
  }

  /**
   * Gets pmid.
   *
   * @return Value of pmid.
   */
  public String getPmid() {
    return pmid;
  }

  /**
   * Sets new pubType.
   *
   * @param pubType New value of pubType.
   */
  public void setPubType(String pubType) {
    this.pubType = pubType;
  }

  /**
   * Gets issue.
   *
   * @return Value of issue.
   */
  public String getIssue() {
    return issue;
  }

  /**
   * Sets new issue.
   *
   * @param issue New value of issue.
   */
  public void setIssue(String issue) {
    this.issue = issue;
  }

  /**
   * Gets hasPDF.
   *
   * @return Value of hasPDF.
   */
  public String getHasPDF() {
    return hasPDF;
  }

  /**
   * Gets hasTextMinedTerms.
   *
   * @return Value of hasTextMinedTerms.
   */
  public String getHasTextMinedTerms() {
    return hasTextMinedTerms;
  }

  /**
   * Sets new doi.
   *
   * @param doi New value of doi.
   */
  public void setDoi(String doi) {
    this.doi = doi;
  }

  /**
   * Gets pubYear.
   *
   * @return Value of pubYear.
   */
  public String getPubYear() {
    return pubYear;
  }

  /**
   * Sets new hasLabsLinks.
   *
   * @param hasLabsLinks New value of hasLabsLinks.
   */
  public void setHasLabsLinks(String hasLabsLinks) {
    this.hasLabsLinks = hasLabsLinks;
  }

  /**
   * Sets new hasTextMinedTerms.
   *
   * @param hasTextMinedTerms New value of hasTextMinedTerms.
   */
  public void setHasTextMinedTerms(String hasTextMinedTerms) {
    this.hasTextMinedTerms = hasTextMinedTerms;
  }

  /**
   * Gets journalIssn.
   *
   * @return Value of journalIssn.
   */
  public String getJournalIssn() {
    return journalIssn;
  }

  /**
   * Gets pageInfo.
   *
   * @return Value of pageInfo.
   */
  public String getPageInfo() {
    return pageInfo;
  }

  /**
   * Sets new hasDbCrossReferences.
   *
   * @param hasDbCrossReferences New value of hasDbCrossReferences.
   */
  public void setHasDbCrossReferences(String hasDbCrossReferences) {
    this.hasDbCrossReferences = hasDbCrossReferences;
  }

  /**
   * Sets new journalTitle.
   *
   * @param journalTitle New value of journalTitle.
   */
  public void setJournalTitle(String journalTitle) {
    this.journalTitle = journalTitle;
  }

  /**
   * Sets new inPMC.
   *
   * @param inPMC New value of inPMC.
   */
  public void setInPMC(String inPMC) {
    this.inPMC = inPMC;
  }

  /**
   * Sets new pubYear.
   *
   * @param pubYear New value of pubYear.
   */
  public void setPubYear(String pubYear) {
    this.pubYear = pubYear;
  }

  /**
   * Gets doi.
   *
   * @return Value of doi.
   */
  public String getDoi() {
    return doi;
  }

  /**
   * Gets citedByCount.
   *
   * @return Value of citedByCount.
   */
  public int getCitedByCount() {
    return citedByCount;
  }

  /**
   * Gets hasReferences.
   *
   * @return Value of hasReferences.
   */
  public String getHasReferences() {
    return hasReferences;
  }

  /**
   * Gets isOpenAccess.
   *
   * @return Value of isOpenAccess.
   */
  public String getIsOpenAccess() {
    return isOpenAccess;
  }

  /**
   * Sets new authorString.
   *
   * @param authorString New value of authorString.
   */
  public void setAuthorString(String authorString) {
    this.authorString = authorString;
  }

  /**
   * Sets new citedByCount.
   *
   * @param citedByCount New value of citedByCount.
   */
  public void setCitedByCount(int citedByCount) {
    this.citedByCount = citedByCount;
  }

  /**
   * Gets hasBook.
   *
   * @return Value of hasBook.
   */
  public String getHasBook() {
    return hasBook;
  }

  /**
   * Sets new isOpenAccess.
   *
   * @param isOpenAccess New value of isOpenAccess.
   */
  public void setIsOpenAccess(String isOpenAccess) {
    this.isOpenAccess = isOpenAccess;
  }

  /**
   * Gets pubType.
   *
   * @return Value of pubType.
   */
  public String getPubType() {
    return pubType;
  }

  /**
   * Gets hasLabsLinks.
   *
   * @return Value of hasLabsLinks.
   */
  public String getHasLabsLinks() {
    return hasLabsLinks;
  }

  /**
   * Sets new journalVolume.
   *
   * @param journalVolume New value of journalVolume.
   */
  public void setJournalVolume(String journalVolume) {
    this.journalVolume = journalVolume;
  }

  /**
   * Gets inEPMC.
   *
   * @return Value of inEPMC.
   */
  public String getInEPMC() {
    return inEPMC;
  }

  /**
   * Gets journalTitle.
   *
   * @return Value of journalTitle.
   */
  public String getJournalTitle() {
    return journalTitle;
  }

  /**
   * Sets new pageInfo.
   *
   * @param pageInfo New value of pageInfo.
   */
  public void setPageInfo(String pageInfo) {
    this.pageInfo = pageInfo;
  }

  /**
   * Gets title.
   *
   * @return Value of title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets new id.
   *
   * @param id New value of id.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Sets new hasPDF.
   *
   * @param hasPDF New value of hasPDF.
   */
  public void setHasPDF(String hasPDF) {
    this.hasPDF = hasPDF;
  }

  /**
   * Gets authorString.
   *
   * @return Value of authorString.
   */
  public String getAuthorString() {
    return authorString;
  }

  /**
   * Sets new hasTMAccessionNumbers.
   *
   * @param hasTMAccessionNumbers New value of hasTMAccessionNumbers.
   */
  public void setHasTMAccessionNumbers(String hasTMAccessionNumbers) {
    this.hasTMAccessionNumbers = hasTMAccessionNumbers;
  }

  /**
   * Sets new pmcid.
   *
   * @param pmcid New value of pmcid.
   */
  public void setPmcid(String pmcid) {
    this.pmcid = pmcid;
  }

  /**
   * Gets pmcid.
   *
   * @return Value of pmcid.
   */
  public String getPmcid() {
    return pmcid;
  }

  /**
   * Sets new hasSuppl.
   *
   * @param hasSuppl New value of hasSuppl.
   */
  public void setHasSuppl(String hasSuppl) {
    this.hasSuppl = hasSuppl;
  }

  /**
   * Gets hasSuppl.
   *
   * @return Value of hasSuppl.
   */
  public String getHasSuppl() {
    return hasSuppl;
  }

  /**
   * Gets tmAccessionTypeList.
   *
   * @return Value of tmAccessionTypeList.
   */
  public EupmcTmAccessionTypeArray getTmAccessionTypeList() {
    return tmAccessionTypeList;
  }

  /**
   * Sets new tmAccessionTypeList.
   *
   * @param tmAccessionTypeList New value of tmAccessionTypeList.
   */
  public void setTmAccessionTypeList(EupmcTmAccessionTypeArray tmAccessionTypeList) {
    this.tmAccessionTypeList = tmAccessionTypeList;
  }
}
