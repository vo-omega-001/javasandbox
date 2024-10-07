package org.voomega.sandbox.services.tika.extractor;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class TikaExtractorTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TikaExtractorTest.class);

    @Test
    public void whenInputUrlIsString() {
        try {
            TikaExtractor.parseRemoteDocument1("http://localhost:8080/api/stub/resource/00000004");

        } catch (Exception e) {
            LOGGER.error("whenInputUrlIsString error: ", e);
        }
    }

    @Test
    public void whenInputUrlIsURL() {
        try {
            TikaExtractor.parseRemoteDocument2(new URL("http://localhost:8080/api/stub/resource/00000004"));

        } catch (Exception e) {
            LOGGER.error("whenInputUrlIsURL error: ", e);
        }
    }

    @Test
    public void whenInputUrlIsURLAndMetaDataAsResult() {
        try {
            TikaExtractor.parseRemoteDocument3(new URL("http://localhost:8080/api/stub/resource/00000004"));

        } catch (Exception e) {
            LOGGER.error("whenInputUrlIsURLAndMetaDataAsResult error: ", e);
        }
    }

    @Test
    public void whenInputUrlIsURLAndMetaDataAsResult2() {
        try {
            TikaExtractor.parseRemoteDocument4(new URL("http://localhost:8080/api/stub/resource/00000004"));

        } catch (Exception e) {
            LOGGER.error("whenInputUrlIsURLAndMetaDataAsResult error: ", e);
        }
    }
}
