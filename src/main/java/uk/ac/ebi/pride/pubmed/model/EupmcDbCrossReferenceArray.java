package uk.ac.ebi.pride.pubmed.model;

/**
 * Models a 'dbCrossReferenceList' use in a EU PMC result.
 */
public class EupmcDbCrossReferenceArray {
  String[] dbName;

  /**
   * Gets dbName.
   *
   * @return Value of dbName.
   */
  public String[] getDbName() {
    return dbName;
  }

  /**
   * Sets new dbName.
   *
   * @param dbName New value of dbName.
   */
  public void setDbName(String[] dbName) {
    this.dbName = dbName;
  }
}
