package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.y  reason: case insensitive filesystem */
public abstract class C1261y {

    /* renamed from: a  reason: collision with root package name */
    final List f5629a = new ArrayList();

    protected C1261y() {
    }

    public abstract r a(String str, U1 u12, List list);

    /* access modifiers changed from: package-private */
    public final r b(String str) {
        if (this.f5629a.contains(C1238v2.e(str))) {
            throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
        }
        throw new IllegalArgumentException("Command not supported");
    }
}
