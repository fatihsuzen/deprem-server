package t3;

import X2.X;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import k3.l;
import kotlin.jvm.internal.t;
import q3.C2728d;
import q3.C2729e;

/* renamed from: t3.K  reason: case insensitive filesystem */
abstract class C2774K extends C2772I {
    public static List Y0(CharSequence charSequence, int i5) {
        t.e(charSequence, "<this>");
        return e1(charSequence, i5, i5, true);
    }

    public static String Z0(String str, int i5) {
        t.e(str, "<this>");
        if (i5 >= 0) {
            String substring = str.substring(C2729e.e(i5, str.length()));
            t.d(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i5 + " is less than zero.").toString());
    }

    public static char a1(CharSequence charSequence) {
        t.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(C2771H.Z(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char b1(CharSequence charSequence) {
        t.e(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        } else if (length == 1) {
            return charSequence.charAt(0);
        } else {
            throw new IllegalArgumentException("Char sequence has more than one element.");
        }
    }

    public static String c1(String str, C2728d dVar) {
        t.e(str, "<this>");
        t.e(dVar, "indices");
        if (dVar.isEmpty()) {
            return "";
        }
        return C2771H.K0(str, dVar);
    }

    public static String d1(String str, int i5) {
        t.e(str, "<this>");
        if (i5 >= 0) {
            String substring = str.substring(0, C2729e.e(i5, str.length()));
            t.d(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i5 + " is less than zero.").toString());
    }

    public static final List e1(CharSequence charSequence, int i5, int i6, boolean z4) {
        t.e(charSequence, "<this>");
        return f1(charSequence, i5, i6, z4, new C2773J());
    }

    public static final List f1(CharSequence charSequence, int i5, int i6, boolean z4, l lVar) {
        int i7;
        t.e(charSequence, "<this>");
        t.e(lVar, "transform");
        X.a(i5, i6);
        int length = charSequence.length();
        int i8 = length / i6;
        int i9 = 0;
        if (length % i6 == 0) {
            i7 = 0;
        } else {
            i7 = 1;
        }
        ArrayList arrayList = new ArrayList(i8 + i7);
        while (i9 >= 0 && i9 < length) {
            int i10 = i9 + i5;
            if (i10 < 0 || i10 > length) {
                if (!z4) {
                    break;
                }
                i10 = length;
            }
            arrayList.add(lVar.invoke(charSequence.subSequence(i9, i10)));
            i9 += i6;
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final String g1(CharSequence charSequence) {
        t.e(charSequence, "it");
        return charSequence.toString();
    }
}
