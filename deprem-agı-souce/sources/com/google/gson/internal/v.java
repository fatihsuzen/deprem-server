package com.google.gson.internal;

public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7780a = a();

    private static int a() {
        return e(System.getProperty("java.version"));
    }

    private static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i5 = 0; i5 < str.length(); i5++) {
                char charAt = str.charAt(i5);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean c() {
        if (f7780a >= 9) {
            return true;
        }
        return false;
    }

    private static int d(String str) {
        try {
            String[] split = str.split("[._]", 3);
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt != 1 || split.length <= 1) {
                return parseInt;
            }
            return Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    static int e(String str) {
        int d5 = d(str);
        if (d5 == -1) {
            d5 = b(str);
        }
        if (d5 == -1) {
            return 6;
        }
        return d5;
    }
}
