package uk.ac.ebi.pride.pubmed.model;

public class ReferenceSummary {
    private String refLine;
    private EupmcResult eupmcResult;

  /**
   * Sets new refLine.
   *
   * @param refLine New value of refLine.
   */
  public void setRefLine(String refLine) {
    this.refLine = refLine;
  }

  /**
   * Gets eupmcResult.
   *
   * @return Value of eupmcResult.
   */
  public EupmcResult getEupmcResult() {
    return eupmcResult;
  }

  /**
   * Sets new eupmcResult.
   *
   * @param eupmcResult New value of eupmcResult.
   */
  public void setEupmcResult(EupmcResult eupmcResult) {
    this.eupmcResult = eupmcResult;
  }

  /**
   * Gets refLine.
   *
   * @return Value of refLine.
   */
  public String getRefLine() {
    return refLine;
  }
}
