package com.google.gson.internal;

import androidx.work.WorkRequest;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class z {
    private static void a(String str) {
        if (str.length() > 10000) {
            throw new NumberFormatException("Number string too large: " + str.substring(0, 30) + "...");
        }
    }

    public static BigDecimal b(String str) {
        a(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs((long) bigDecimal.scale()) < WorkRequest.MIN_BACKOFF_MILLIS) {
            return bigDecimal;
        }
        throw new NumberFormatException("Number has unsupported scale: " + str);
    }

    public static BigInteger c(String str) {
        a(str);
        return new BigInteger(str);
    }
}
