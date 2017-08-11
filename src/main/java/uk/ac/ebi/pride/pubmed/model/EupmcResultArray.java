package uk.ac.ebi.pride.pubmed.model;

/**
 * Models the 'resultList' from a EU PMC response.
 */
public class EupmcResultArray {
  EupmcResult[] result;

  /**
   * Gets result.
   *
   * @return Value of result.
   */
  public EupmcResult[] getResult() {
    return result;
  }

  /**
   * Sets new result.
   *
   * @param result New value of result.
   */
  public void setResult(EupmcResult[] result) {
    this.result = result;
  }
}