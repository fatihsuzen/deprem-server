package com.mbridge.msdk.thrid.okio;

public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }

    public static long size(String str, int i5, int i6) {
        long j5;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i5 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i5);
        } else if (i6 < i5) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i6 + " < " + i5);
        } else if (i6 <= str.length()) {
            long j6 = 0;
            while (i5 < i6) {
                char charAt = str.charAt(i5);
                if (charAt < 128) {
                    j6++;
                } else {
                    if (charAt < 2048) {
                        j5 = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        j5 = 3;
                    } else {
                        int i7 = i5 + 1;
                        char charAt2 = i7 < i6 ? str.charAt(i7) : 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j6++;
                            i5 = i7;
                        } else {
                            j6 += 4;
                            i5 += 2;
                        }
                    }
                    j6 += j5;
                }
                i5++;
            }
            return j6;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i6 + " > " + str.length());
        }
    }
}
