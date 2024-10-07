package org.voomega.sandbox.services.serviceapi.utils;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class UtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilsTest.class);

    private String input;
    private String path;

    @Before
    public void init() {
        input = "\n àAAAAAAAAê  \n  öBBBBBBBBBBBü\n   ÿCCCCCCCCCCCCÿ         \n";
        path = ".//target";
    }

    @Test
    public void toTrimedDocumentTest() {
        String output = Utils.toTrimmedDocument(input, Optional.of(Charset.ASCII));
        LOGGER.warn("whenInputUrlIsString error: {}", output);
    }

    @Test
    public void toTrimedFileDocumentTest() {
        try {
            Files.deleteIfExists(Paths.get(path+"/test.txt").normalize());
            File file = Utils.toTrimmedDocument(input,path+"/test.txt", Optional.of(Charset.ASCII));

            LOGGER.warn("toTrimedFileDocumentTest file: {} exist? {}", file.getName(), file.exists());
        } catch (IOException e) {
            LOGGER.error("toTrimedFileDocumentTest error: ", e);
        }
    }
}
