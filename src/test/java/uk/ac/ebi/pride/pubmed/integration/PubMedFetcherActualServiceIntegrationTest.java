package uk.ac.ebi.pride.pubmed.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import uk.ac.ebi.pride.pubmed.PubMedFetcher;
import uk.ac.ebi.pride.pubmed.model.PubMedSummary;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/pubmed-eutils-actual-context.xml"})
public class PubMedFetcherActualServiceIntegrationTest {

    // good examples of actual PUBMED_IDs
    public static final String PUBMED_ID_1 = "22147733";
    public static final String PUBMED_ID_2 = "22807455";
    public static final String PUBMED_ID_3 = "22825847";

    @Autowired
    private PubMedFetcher pubMedFetcher;

    @Test
    public void testActualService() throws Exception {
        assetResponseReference(pubMedFetcher.getPubMedSummary(PUBMED_ID_1));
        assetResponseReference(pubMedFetcher.getPubMedSummary(PUBMED_ID_2));
        assetResponseReference(pubMedFetcher.getPubMedSummary(PUBMED_ID_3));
    }

    private void assetResponseReference(PubMedSummary response) throws IOException {
        Assert.isTrue(response!=null, "Response cannot be null");
        System.out.println("Response reference: " + (response.getReference()!=null ? response.getReference() : "null"));
    }

}
