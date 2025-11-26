package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public abstract class B {
    private static String a(int i5) {
        if (i5 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i5 == 1) {
            return "MMMM d, yyyy";
        }
        if (i5 == 2) {
            return "MMM d, yyyy";
        }
        if (i5 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i5);
    }

    private static String b(int i5) {
        if (i5 == 0 || i5 == 1) {
            return "h:mm:ss a z";
        }
        if (i5 == 2) {
            return "h:mm:ss a";
        }
        if (i5 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i5);
    }

    public static DateFormat c(int i5, int i6) {
        return new SimpleDateFormat(a(i5) + " " + b(i6), Locale.US);
    }
}
