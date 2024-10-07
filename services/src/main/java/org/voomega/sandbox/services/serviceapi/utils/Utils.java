package org.voomega.sandbox.services.serviceapi.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String toTrimmedDocument(String input, Optional<Charset> charset) {
        Pattern trimmerPattern = Pattern.compile("(?m)^[\\s&&[^\\n]]+|[\\s+&&[^\\n]]+$");
        Matcher matcher = trimmerPattern.matcher(input);
        StringBuffer out = new StringBuffer();
        AtomicLong stringBufferPointer = new AtomicLong(0L);
        while (matcher.find()) {
            matcher.appendReplacement(out, "");
            charset.ifPresent(ch -> {
                long start = stringBufferPointer.get();
                long end = out.length();
                if (0 <= start && start < end && end < input.length()) {
                   out.replace((int) start, (int) end, toCharset(out.substring((int) start, (int) end), ch));
                }
                stringBufferPointer.set(end);
            });
        }
        matcher.appendTail(out);
        return out.toString();
    }

    public static File toTrimmedDocument(String input, String path, Optional<Charset> charset)
            throws IOException {
        String content = toTrimmedDocument(input, charset);
        Path p = Paths.get(path).normalize();
        Files.write(p, content.getBytes());
        return p.toFile();
    }

    public static String toAsciiString(String input) {
        String temp = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");
        return pattern.matcher(temp).replaceAll("");
    }

    public static String toCharset(String input, Charset charset) {
        switch (charset) {
            case ASCII:
                String out = toAsciiString(input);
                return out;
            case UTF8:
            default:
                //throw new Exception("not implemented yet");
                return input;
        }
    }
}
