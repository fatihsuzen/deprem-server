package com.google.android.gms.internal.measurement;

import j$.util.DesugarCollections;
import java.util.List;

public final class V2 extends C1071c5 implements G5 {
    /* synthetic */ V2(byte[] bArr) {
        super(Y2.zzh);
    }

    public final String A() {
        return ((Y2) this.f5319b).J();
    }

    public final V2 B(String str) {
        j();
        ((Y2) this.f5319b).S(str);
        return this;
    }

    public final V2 C(String str) {
        j();
        ((Y2) this.f5319b).T(str);
        return this;
    }

    public final List r() {
        return DesugarCollections.unmodifiableList(((Y2) this.f5319b).F());
    }

    public final int s() {
        return ((Y2) this.f5319b).G();
    }

    public final C1051a3 t(int i5) {
        return ((Y2) this.f5319b).H(i5);
    }

    public final V2 w(int i5, Z2 z22) {
        j();
        ((Y2) this.f5319b).O(i5, (C1051a3) z22.o());
        return this;
    }

    public final V2 x(Z2 z22) {
        j();
        ((Y2) this.f5319b).P((C1051a3) z22.o());
        return this;
    }

    public final V2 y(Iterable iterable) {
        j();
        ((Y2) this.f5319b).Q(iterable);
        return this;
    }

    public final V2 z() {
        j();
        ((Y2) this.f5319b).R();
        return this;
    }
}
