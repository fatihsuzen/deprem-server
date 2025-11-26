package com.google.android.gms.measurement.internal;

import N.C0722p;
import com.google.android.gms.internal.measurement.C1051a3;
import com.google.android.gms.internal.measurement.O2;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

final class m6 {

    /* renamed from: a  reason: collision with root package name */
    C1051a3 f6555a;

    /* renamed from: b  reason: collision with root package name */
    List f6556b;

    /* renamed from: c  reason: collision with root package name */
    List f6557c;

    /* renamed from: d  reason: collision with root package name */
    long f6558d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ q6 f6559e;

    /* synthetic */ m6(q6 q6Var, byte[] bArr) {
        Objects.requireNonNull(q6Var);
        this.f6559e = q6Var;
    }

    private static final long b(O2 o22) {
        return ((o22.K() / 1000) / 60) / 60;
    }

    public final boolean a(long j5, O2 o22) {
        C0722p.k(o22);
        if (this.f6557c == null) {
            this.f6557c = new ArrayList();
        }
        if (this.f6556b == null) {
            this.f6556b = new ArrayList();
        }
        if (!this.f6557c.isEmpty() && b((O2) this.f6557c.get(0)) != b(o22)) {
            return false;
        }
        long a5 = this.f6558d + ((long) o22.a());
        q6 q6Var = this.f6559e;
        if (!q6Var.B0().H((String) null, C1304d2.f6326e1)) {
            q6Var.B0();
            if (a5 >= ((long) C1371m.o())) {
                return false;
            }
        } else if (!this.f6557c.isEmpty()) {
            q6Var.B0();
            if (a5 >= ((long) C1371m.o())) {
                return false;
            }
        }
        this.f6558d = a5;
        this.f6557c.add(o22);
        this.f6556b.add(Long.valueOf(j5));
        int size = this.f6557c.size();
        q6Var.B0();
        if (size >= Math.max(1, ((Integer) C1304d2.f6342k.b((Object) null)).intValue())) {
            return false;
        }
        return true;
    }
}
