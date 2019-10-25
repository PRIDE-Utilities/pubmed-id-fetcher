package uk.ac.ebi.pride.pubmed.model;

/**
 * Models a 'request' used in a EU PMC response.
 */
public class EupmcRequest {
  String queryString;
  String resultType;
  boolean synonym;
  String cursorMark;
  int pageSize;
  String sort;

  /**
   * Sets new pageSize.
   *
   * @param pageSize New value of pageSize.
   */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  /**
   * Sets new resultType.
   *
   * @param resultType New value of resultType.
   */
  public void setResultType(String resultType) {
    this.resultType = resultType;
  }

  /**
   * Gets resultType.
   *
   * @return Value of resultType.
   */
  public String getResultType() {
    return resultType;
  }

  /**
   * Gets pageSize.
   *
   * @return Value of pageSize.
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * Sets new sort.
   *
   * @param sort New value of sort.
   */
  public void setSort(String sort) {
    this.sort = sort;
  }

  /**
   * Gets queryString.
   *
   * @return Value of queryString.
   */
  public String getQueryString() {
    return queryString;
  }

  /**
   * Gets sort.
   *
   * @return Value of sort.
   */
  public String getSort() {
    return sort;
  }

  /**
   * Gets cursorMark.
   *
   * @return Value of cursorMark.
   */
  public String getCursorMark() {
    return cursorMark;
  }

  /**
   * Sets new synonym.
   *
   * @param synonym New value of synonym.
   */
  public void setSynonym(boolean synonym) {
    this.synonym = synonym;
  }

  /**
   * Sets new cursorMark.
   *
   * @param cursorMark New value of cursorMark.
   */
  public void setCursorMark(String cursorMark) {
    this.cursorMark = cursorMark;
  }

  /**
   * Gets synonym.
   *
   * @return Value of synonym.
   */
  public boolean isSynonym() {
    return synonym;
  }

  /**
   * Sets new queryString.
   *
   * @param queryString New value of queryString.
   */
  public void setQueryString(String queryString) {
    this.queryString = queryString;
  }
}
