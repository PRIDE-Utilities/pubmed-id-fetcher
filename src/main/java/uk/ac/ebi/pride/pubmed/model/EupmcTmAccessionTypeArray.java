package uk.ac.ebi.pride.pubmed.model;

/**
 * Models the 'tmAccessionTypeList' field from a EU PMC result.
 */
public class EupmcTmAccessionTypeArray {
  String[] accessionType;

  /**
   * Sets new accessionType.
   *
   * @param accessionType New value of accessionType.
   */
  public void setAccessionType(String[] accessionType) {
    this.accessionType = accessionType;
  }

  /**
   * Gets accessionType.
   *
   * @return Value of accessionType.
   */
  public String[] getAccessionType() {
    return accessionType;
  }
}