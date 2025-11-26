package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.s4  reason: case insensitive filesystem */
public abstract class C1213s4 implements F5 {
    protected int zza = 0;

    protected static void g(Iterable iterable, List list) {
        C1204r4.h(iterable, list);
    }

    public final byte[] e() {
        try {
            int a5 = a();
            byte[] bArr = new byte[a5];
            int i5 = M4.f5024d;
            K4 k42 = new K4(bArr, 0, a5);
            c(k42);
            k42.e();
            return bArr;
        } catch (IOException e5) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e5);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract int f(Q5 q5);
}
