package com.google.android.gms.internal.measurement;

import j$.util.DesugarCollections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.f2  reason: case insensitive filesystem */
public final class C1095f2 extends C1071c5 implements G5 {
    /* synthetic */ C1095f2(byte[] bArr) {
        super(C1104g2.zzu);
    }

    public final String A() {
        return ((C1104g2) this.f5319b).Q();
    }

    public final int r() {
        return ((C1104g2) this.f5319b).K();
    }

    public final C1086e2 s(int i5) {
        return ((C1104g2) this.f5319b).L(i5);
    }

    public final C1095f2 t(int i5, C1077d2 d2Var) {
        j();
        ((C1104g2) this.f5319b).X(i5, (C1086e2) d2Var.o());
        return this;
    }

    public final List w() {
        return DesugarCollections.unmodifiableList(((C1104g2) this.f5319b).M());
    }

    public final C1095f2 x() {
        j();
        ((C1104g2) this.f5319b).Y();
        return this;
    }

    public final C1095f2 y() {
        j();
        ((C1104g2) this.f5319b).Z();
        return this;
    }

    public final List z() {
        return DesugarCollections.unmodifiableList(((C1104g2) this.f5319b).P());
    }
}
