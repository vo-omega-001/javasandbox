package org.voomega.sandbox.solr.client;

import org.apache.commons.io.FileUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.request.CoreAdminRequest;
import org.apache.solr.core.CoreContainer;
import org.apache.solr.core.NodeConfig;
import org.apache.solr.core.SolrResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class EmbeddedSolrClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedSolrClient.class);

    private static final String SOLR_CORE_NAME = "books";
    private static final String SOLR_HOME_PATH = "src/main/resources/conf/myEmbeddedSolr";
    private static final String SOLR_DATA_PATH = "target/embedded-solr";

    private static final String SOLR_HOME_PATH2 = "target/classes/conf/myEmbeddedSolr";


    private static Path createSolrDataPath(String strPath) throws IOException {
        final File solrHomeDir = new File(strPath);
        if (solrHomeDir.exists()) {
            FileUtils.deleteDirectory(solrHomeDir);
            solrHomeDir.mkdirs();
        } else {
            solrHomeDir.mkdirs();
        }
        return solrHomeDir.toPath();
    }

    public static SolrClient getClient()
            throws IOException, SolrServerException {

        final SolrResourceLoader loader = new SolrResourceLoader(createSolrDataPath(SOLR_DATA_PATH));
        final Path configSetPath = Paths.get(String.format("%s/cores", SOLR_HOME_PATH)).toAbsolutePath();

        final NodeConfig config = new NodeConfig.NodeConfigBuilder("embeddedSolrServerNode", loader.getInstancePath())
                .setConfigSetBaseDirectory(configSetPath.toString())
                .build();

        final EmbeddedSolrServer embeddedSolrServer = new EmbeddedSolrServer(config, SOLR_CORE_NAME);

        final CoreAdminRequest.Create createRequest = new CoreAdminRequest.Create();
        createRequest.setCoreName(SOLR_CORE_NAME);
        createRequest.setConfigSet(SOLR_CORE_NAME);
        embeddedSolrServer.request(createRequest);

        return embeddedSolrServer;
    }

    public static SolrClient getClientByContainer() throws IOException {

        //Path solrDataPath = createSolrDataPath(SOLR_DATA_PATH);

        CoreContainer container = CoreContainer.createAndLoad(Paths.get(SOLR_HOME_PATH2));

        //container.getNodeConfig().

        EmbeddedSolrServer server = new EmbeddedSolrServer( container, container.getCores().get(0).getName());


        return server;
    }
}
