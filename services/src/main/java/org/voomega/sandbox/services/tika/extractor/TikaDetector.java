package org.voomega.sandbox.services.tika.extractor;

import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class TikaDetector implements Detector {

    private static final Logger LOGGER = LoggerFactory.getLogger(TikaExtractor.class);

    public MediaType detect(InputStream inputStream, Metadata metadata) throws IOException {
        LOGGER.warn("TikaDetector: available metadata: {}", Arrays.toString(metadata.names()));
        Arrays.stream(metadata.names())
              .forEach(m -> LOGGER.warn("{}: {}", m, metadata.get(m)) );

        MediaType mediaType = new MediaType(metadata.get("Content-Type"), "");
        return mediaType;
    }
}
