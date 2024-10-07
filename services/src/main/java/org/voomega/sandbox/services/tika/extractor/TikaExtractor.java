package org.voomega.sandbox.services.tika.extractor;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

public class TikaExtractor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TikaExtractor.class);

    public static void parseRemoteDocument1(String url) throws IOException, TikaException, SAXException {
        HttpGet httpget = new HttpGet(url);
        HttpEntity entity;
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(httpget);
        entity = response.getEntity();
        if (entity != null) {
            InputStream instream = entity.getContent();
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            Parser parser = new AutoDetectParser();
            parser.parse( instream, handler, metadata, new ParseContext());
            instream.close();
            String plainText = handler.toString();
            LOGGER.debug("##########> EXTRACTED TEXT <##########################");
            LOGGER.warn("plainText: {}", plainText);
//            FileWriter writer = new FileWriter( "/scratch/cache/output.txt");
//            writer.write( plainText );
//            writer.close();
            LOGGER.debug("##########> METADATA <##########################");
            Arrays.stream(metadata.names())
                    .forEach(m -> LOGGER.warn("metadata {}: {}", m, metadata.get(m)) );
            LOGGER.debug("##########> DONE <##########################");
        }
    }

    public static void parseRemoteDocument2(URL url) throws IOException, TikaException, SAXException {
        BodyContentHandler handler = new BodyContentHandler();
        TikaDetector detector = new TikaDetector();
        Metadata metadata = new Metadata();
        Parser parser = new AutoDetectParser();
        Tika tikaFacade = new Tika(detector, parser);
        //Detect MimiType
        String mimeType = tikaFacade.detect(url);
        LOGGER.warn("mimeType: {}", mimeType);
        //Parse
        try(InputStream is = TikaInputStream.get(url)) {
            parser.parse(is, handler, metadata, new ParseContext());
        }
        String plainText = handler.toString();
        LOGGER.debug("##########> EXTRACTED TEXT <##########################");
        //LOGGER.warn("plainText: {}", plainText);
        LOGGER.debug("##########> METADATA <##########################");
        Arrays.stream(metadata.names())
                .forEach(m -> LOGGER.warn("metadata {}: {}", m, metadata.get(m)) );
        LOGGER.debug("##########> DONE <##########################");
    }

    public static void parseRemoteDocument3(URL url) throws IOException, TikaException {
        Tika tikaFacade = new Tika();

        String plainText = tikaFacade.parseToString(url);
        LOGGER.debug("##########> EXTRACTED TEXT <##########################");
        LOGGER.warn("plainText: {}", plainText);
        LOGGER.debug("##########> DONE <##########################");
    }

    public static void parseRemoteDocument4(URL url) throws IOException, TikaException {
        Metadata metadata = new Metadata();
        TikaDetector detector = new TikaDetector();
        Parser parser = new AutoDetectParser();
        Tika tikaFacade = new Tika(detector, parser);
        //Detect MimiType
        String mimeType = tikaFacade.detect(url);
        LOGGER.warn("mimeType: {}", mimeType);
        //Parse
        String plainText = tikaFacade.parseToString(TikaInputStream.get(url), metadata);
        LOGGER.debug("##########> EXTRACTED TEXT <##########################");
        //LOGGER.warn("plainText: {}", plainText);
        LOGGER.debug("##########> METADATA <##########################");
        Arrays.stream(metadata.names())
                .forEach(m -> LOGGER.warn("metadata {}: {}", m, metadata.get(m)) );
        LOGGER.debug("##########> DONE <##########################");
    }
}
