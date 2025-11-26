package t3;

import kotlin.jvm.internal.t;

/* renamed from: t3.h  reason: case insensitive filesystem */
public abstract class C2784h {
    /* access modifiers changed from: private */
    public static final boolean b(String str) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (t.g(charAt, 128) >= 0 || Character.isLetter(charAt)) {
                return true;
            }
        }
        return false;
    }
}
