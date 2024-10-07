package org.voomega.sandbox.solr.client;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class EmbeddedSolrClientTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedSolrClientTest.class);

    @Test
    public void getClientTest() {
        try {
            SolrClient client = EmbeddedSolrClient.getClient();
            LOGGER.info("######################");

        } catch (IOException e) {
            LOGGER.error("IOException: ", e);
            e.printStackTrace();

        } catch (SolrServerException e) {
            LOGGER.error("SolrServerException: ", e);
            e.printStackTrace();
        }
    }

    @Test
    public void getClientByContainer() throws IOException {
        SolrClient client = EmbeddedSolrClient.getClientByContainer();
    }
}
