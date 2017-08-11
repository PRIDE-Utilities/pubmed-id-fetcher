package uk.ac.ebi.pride.pubmed.model;

/**
 * Models a response from the EU PMC.
 */
public class EupmcResponse {
  String version;
  int hitCount;
  String nextCursorMark;
  EupmcRequest request;
  EupmcResultArray resultList;

  /**
   * Sets new request.
   *
   * @param request New value of request.
   */
  public void setRequest(EupmcRequest request) {
    this.request = request;
  }

  /**
   * Gets hitCount.
   *
   * @return Value of hitCount.
   */
  public int getHitCount() {
    return hitCount;
  }

  /**
   * Sets new hitCount.
   *
   * @param hitCount New value of hitCount.
   */
  public void setHitCount(int hitCount) {
    this.hitCount = hitCount;
  }

  /**
   * Gets nextCursorMark.
   *
   * @return Value of nextCursorMark.
   */
  public String getNextCursorMark() {
    return nextCursorMark;
  }

  /**
   * Sets new resultList.
   *
   * @param resultList New value of resultList.
   */
  public void setResultList(EupmcResultArray resultList) {
    this.resultList = resultList;
  }

  /**
   * Gets version.
   *
   * @return Value of version.
   */
  public String getVersion() {
    return version;
  }

  /**
   * Sets new version.
   *
   * @param version New value of version.
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * Gets resultList.
   *
   * @return Value of resultList.
   */
  public EupmcResultArray getResultList() {
    return resultList;
  }

  /**
   * Sets new nextCursorMark.
   *
   * @param nextCursorMark New value of nextCursorMark.
   */
  public void setNextCursorMark(String nextCursorMark) {
    this.nextCursorMark = nextCursorMark;
  }

  /**
   * Gets request.
   *
   * @return Value of request.
   */
  public EupmcRequest getRequest() {
    return request;
  }
}
