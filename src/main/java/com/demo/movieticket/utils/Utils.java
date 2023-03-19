package com.demo.movieticket.utils;

import java.util.Locale;
import java.util.UUID;

public final class Utils {

    private Utils() {}

    public static String generateUUID(int length) {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid.substring(0, length).toUpperCase(Locale.ENGLISH);
    }
}
