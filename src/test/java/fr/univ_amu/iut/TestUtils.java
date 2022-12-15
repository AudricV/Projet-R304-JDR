package fr.univ_amu.iut;

import java.io.*;
import java.net.*;
import java.nio.charset.*;

public class TestUtils {
    private TestUtils() {
    }

    public static String getResourcePath(final String resourceName) {
        final URL url = Thread.currentThread().getContextClassLoader().getResource("fr/univ_amu/iut/" + resourceName);

        if (url == null) {
            throw new RuntimeException(new FileNotFoundException(resourceName + " not found"));
        }

        return URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8);
    }
}
