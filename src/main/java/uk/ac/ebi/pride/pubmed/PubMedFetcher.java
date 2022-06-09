package uk.ac.ebi.pride.pubmed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.pubmed.model.EupmcResponse;
import uk.ac.ebi.pride.pubmed.model.EupmcResult;
import uk.ac.ebi.pride.pubmed.model.Reference;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Fetches the reference details of a PubMed ID from the EU PMC REST WS, and also constructs a reference line ('refline')
 * with summary information in a single String.
 */
@Slf4j
public class PubMedFetcher {

  /**
   * Gets the PubMed reference from EU PMC or Pubmed. The method first check EU PMC and if it doesn't find it, then
   * looks into Pubmed.
   * @param pubmedId the PubMed ID to query for.
   * @return A {@link Reference}
   * @throws URISyntaxException problems querying the EU PMC WS
   * @throws IOException any problems returning results from the EU PMC WS
   */
  public static Reference getPubMedSummary(String pubmedId) throws Exception {
    Reference result;
    final String REQUEST_URL = "https://www.ebi.ac.uk/europepmc/webservices/rest/search?query=ext_id:" + pubmedId + "%20src:med&format=json";
    log.info("Requesting EUPMC WS using: " + REQUEST_URL);
    EupmcResponse response = performEupmcQuery(REQUEST_URL);
    if (response != null) {
      result = getReference(response);
    } else {
      ReferenceUtil.PubMedReference pubmedReference = ReferenceUtil.getPubmedReference(pubmedId);
      if (pubmedReference != null){
        result = getReference(pubmedReference);
      }else{
        throw new IOException("No proper response from EU PMC for: " + REQUEST_URL);
      }
    }
    log.debug("Refline result: " + result.getReferenceLine());
    return result;
  }

  /**
   * Gets the PubMed reference from Pubmed only
   * @param pubmedId the PubMed ID to query for.
   * @return A {@link Reference} object with the reference information.
   * @throws URISyntaxException problems querying the EU PMC WS
   * @throws IOException any problems returning results from the EU PMC WS
   */
  public static Reference getPubMedSummaryFromPubmed(String pubmedId) throws Exception {
    Reference result;
    ReferenceUtil.PubMedReference pubmedReference = ReferenceUtil.getPubmedReference(pubmedId);
    if (pubmedReference != null){
      result = getReference(pubmedReference);
    }else{
        throw new IOException("No proper response from Pubmed for: " + pubmedId);
    }
    log.debug("Refline result: " + result.getReferenceLine());
    return result;
  }

  /**
   *  This method checks if the publication is pre-print or not.
   *  If it is a pre-print, value in the PubType field in the response will be preprint
   * @param doi DOI
   * @return boolean results
   */
  public static boolean isPreprintPublication(String doi) throws URISyntaxException, IOException {
      Reference result;
      final String REQUEST_URL = "https://www.ebi.ac.uk/europepmc/webservices/rest/search?query=doi:" + doi + "&format=json";
      log.info("Requesting EUPMC WS using: " + REQUEST_URL);
      EupmcResponse response = performEupmcQuery(REQUEST_URL);
      if (response!=null) {
          result = getReference(response);
      } else {
          throw new IOException("No proper response from EU PMC for: " + REQUEST_URL);
      }
      return result.isPreprint();
  }

  /**
   * Performs the query to the EU PMC WS.
   * @param requestUrl the URL as a Struns, used for the  query.
   * @return the response from the EU PMC WS.
   * @throws URISyntaxException problems querying the EU PMC WS
   */
  private static EupmcResponse performEupmcQuery(String requestUrl) throws URISyntaxException {
    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
    clientHttpRequestFactory.setConnectTimeout(5000);
    RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
    EupmcResponse result;
    try {
      URI uri = new URI(requestUrl);
      result = restTemplate.getForObject(uri, EupmcResponse.class);
    } catch (URISyntaxException e) {
      log.error("Problem performing EU PMC request: " + requestUrl);
      throw e;
    }
    return result;
  }


  public static ReferenceUtil.PubMedReference performPubmedQuery(String pubmedID) throws Exception {
    return ReferenceUtil.getPubmedReference(pubmedID);
  }

  /**
   * Extracts the EU PMC response into a reference, and constructs a reference line ('refline')
   * @param response the EU PMC response.
   * @return the reference summary
   * @throws IOException exactly 1 hit is expected, otherwise this is a problem due to either no, or multiple, hits were returned.
   */
  private static Reference getReference(EupmcResponse response) throws IOException {
    int hitCount = response.getHitCount();
    if (hitCount!=1) {
      String message = "Error, expected 1 result back from EU PMC instead got: " + hitCount;
      log.error("Error, expected 1 result back from EU PMC instead got: " + hitCount);
      throw new IOException(message);
    }
    EupmcResult eupmcResult = response.getResultList().getResult()[0];
    return Reference.builder()
            .pmid(eupmcResult.getPmid())
            .pmcid(eupmcResult.getPmcid())
            .title(eupmcResult.getTitle())
            .authorString(eupmcResult.getAuthorString())
            .volume(eupmcResult.getJournalVolume())
            .issue(eupmcResult.getIssue())
            .pubYear(eupmcResult.getPubYear())
            .journalTitle(eupmcResult.getJournalTitle())
            .doi(eupmcResult.getDoi())
            .pageInfo(eupmcResult.getPageInfo())
            .pubType(eupmcResult.getPubType())
    .build();
  }

  /**
   * This function transform a {@link uk.ac.ebi.pride.pubmed.ReferenceUtil.PubMedReference} search output into a
   * {@link Reference}.
   * @param pubmedReference PubmedReference results
   * @return Reference
   */
  private static Reference getReference(ReferenceUtil.PubMedReference pubmedReference) {
    return Reference.builder()
            .pmid(pubmedReference.getPmid())
            .title(pubmedReference.getTitle())
            .authorString(pubmedReference.getAuthorString())
            .volume(pubmedReference.getVolume())
            .issue(pubmedReference.getIssue())
            .pubYear(pubmedReference.getDate())
            .journalTitle(pubmedReference.getSource())
            .doi(pubmedReference.getDoi())
            .pageInfo(pubmedReference.getPages())
            .build();
  }
}


