package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

public abstract class H4 implements Iterable, Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final H4 f4958b = new G4(C1152l5.f5434b);

    /* renamed from: a  reason: collision with root package name */
    private int f4959a = 0;

    static {
        int i5 = C1231u4.f5596a;
    }

    H4() {
    }

    public static H4 k(byte[] bArr, int i5, int i6) {
        n(i5, i5 + i6, bArr.length);
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, i5, bArr2, 0, i6);
        return new G4(bArr2);
    }

    static int n(int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if ((i5 | i6 | i8 | (i7 - i6)) >= 0) {
            return i8;
        }
        if (i5 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i5);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i6 < i5) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i5).length() + 44 + String.valueOf(i6).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i5);
            sb2.append(", ");
            sb2.append(i6);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(String.valueOf(i6).length() + 15 + String.valueOf(i7).length());
            sb3.append("End index: ");
            sb3.append(i6);
            sb3.append(" >= ");
            sb3.append(i7);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public abstract byte c(int i5);

    /* access modifiers changed from: package-private */
    public abstract byte d(int i5);

    public abstract boolean equals(Object obj);

    public abstract int f();

    public abstract H4 g(int i5, int i6);

    public final int hashCode() {
        int i5 = this.f4959a;
        if (i5 == 0) {
            int f5 = f();
            i5 = j(f5, 0, f5);
            if (i5 == 0) {
                i5 = 1;
            }
            this.f4959a = i5;
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public abstract void i(C1266y4 y4Var);

    public final /* synthetic */ Iterator iterator() {
        return new A4(this);
    }

    /* access modifiers changed from: protected */
    public abstract int j(int i5, int i6, int i7);

    /* access modifiers changed from: protected */
    public final int l() {
        return this.f4959a;
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer valueOf = Integer.valueOf(f());
        if (f() <= 50) {
            str = Z5.a(this);
        } else {
            str = Z5.a(g(0, 47)).concat("...");
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{hexString, valueOf, str});
    }
}
