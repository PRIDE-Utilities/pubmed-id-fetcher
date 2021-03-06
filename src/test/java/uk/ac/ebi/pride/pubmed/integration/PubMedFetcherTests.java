package uk.ac.ebi.pride.pubmed.integration;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import uk.ac.ebi.pride.pubmed.PubMedFetcher;
import uk.ac.ebi.pride.pubmed.model.EupmcReferenceSummary;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Tests obtaining references from the EU PMC WS.
 */
public class PubMedFetcherTests {
  private static Logger log = LoggerFactory.getLogger(PubMedFetcherTests.class);

  /**
   * Test to obtain references from the EU PMC WS.
   * @throws Exception any problems obtaining the reference details.
   */
  @Test
  public void obtainReferences() throws Exception {
    assertSummaryReference(PubMedFetcher.getPubMedSummary("22147733"));
    assertSummaryReference(PubMedFetcher.getPubMedSummary("22807455"));
    assertSummaryReference(PubMedFetcher.getPubMedSummary("22825847"));
    assertSummaryReference(PubMedFetcher.getPubMedSummary("24607996"));
  }

  /**
   * Checks the reference summary information are not null.
   * @param summary the summary reference to check
   */
  private void assertSummaryReference(EupmcReferenceSummary summary) {
    Assert.isTrue(summary!=null, "Summary cannot be null!");
    Assert.isTrue(!StringUtils.isEmpty(summary.getRefLine()), "Summary RefLine cannot be null or empty!");
    Assert.isTrue(summary.getEupmcResult()!=null, "Summary Result cannot be null!");
    log.info("Summary reference: " + summary.getRefLine());
  }

    /**
     * Check publications are pre-print or not
     * @throws IOException
     * @throws URISyntaxException
     */
  @Test
  public void isPreprintPublication() throws IOException, URISyntaxException {
    Assert.isTrue(PubMedFetcher.isPreprintPublication("10.1101/846303"),"Not a Preprint");
    Assert.isTrue(! PubMedFetcher.isPreprintPublication("10.1074/mcp.M111.013797"),"A Preprint");
  }
}
