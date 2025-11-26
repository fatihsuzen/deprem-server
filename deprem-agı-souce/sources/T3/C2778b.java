package t3;

import java.util.Locale;
import kotlin.jvm.internal.t;
import q3.C2728d;

/* renamed from: t3.b  reason: case insensitive filesystem */
abstract class C2778b {
    public static int a(int i5) {
        if (2 <= i5 && i5 < 37) {
            return i5;
        }
        throw new IllegalArgumentException("radix " + i5 + " was not in valid range " + new C2728d(2, 36));
    }

    public static final int b(char c5, int i5) {
        return Character.digit(c5, i5);
    }

    public static final boolean c(char c5) {
        if (Character.isWhitespace(c5) || Character.isSpaceChar(c5)) {
            return true;
        }
        return false;
    }

    public static String d(char c5, Locale locale) {
        t.e(locale, "locale");
        String e5 = e(c5, locale);
        if (e5.length() <= 1) {
            String valueOf = String.valueOf(c5);
            t.c(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            t.d(upperCase, "toUpperCase(...)");
            if (t.a(e5, upperCase)) {
                return String.valueOf(Character.toTitleCase(c5));
            }
        } else if (c5 != 329) {
            char charAt = e5.charAt(0);
            t.c(e5, "null cannot be cast to non-null type java.lang.String");
            String substring = e5.substring(1);
            t.d(substring, "substring(...)");
            t.c(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase(Locale.ROOT);
            t.d(lowerCase, "toLowerCase(...)");
            return charAt + lowerCase;
        }
        return e5;
    }

    public static final String e(char c5, Locale locale) {
        t.e(locale, "locale");
        String valueOf = String.valueOf(c5);
        t.c(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        t.d(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
