package uk.ac.ebi.pride.pubmed.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Models a 'request' used in a EU PMC response.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EupmcRequest {
  private String queryString;
  private String internalQuery;
  private String resultType;
  private boolean synonym;
  private String cursorMark;
  private int pageSize;
  private String sort;
}
