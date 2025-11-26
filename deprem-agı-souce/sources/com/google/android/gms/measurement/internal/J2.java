package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C1243v7;
import j$.util.Objects;
import java.util.List;

final class J2 implements C1243v7 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ P2 f5934a;

    J2(P2 p22) {
        Objects.requireNonNull(p22);
        this.f5934a = p22;
    }

    public final void a(int i5, String str, List list, boolean z4, boolean z5) {
        C1388o2 o2Var;
        int i6 = i5 - 1;
        if (i6 == 0) {
            o2Var = this.f5934a.f5730a.a().v();
        } else if (i6 != 1) {
            if (i6 == 3) {
                o2Var = this.f5934a.f5730a.a().w();
            } else if (i6 != 4) {
                o2Var = this.f5934a.f5730a.a().u();
            } else if (z4) {
                o2Var = this.f5934a.f5730a.a().s();
            } else if (!z5) {
                o2Var = this.f5934a.f5730a.a().t();
            } else {
                o2Var = this.f5934a.f5730a.a().r();
            }
        } else if (z4) {
            o2Var = this.f5934a.f5730a.a().p();
        } else if (!z5) {
            o2Var = this.f5934a.f5730a.a().q();
        } else {
            o2Var = this.f5934a.f5730a.a().o();
        }
        int size = list.size();
        if (size == 1) {
            o2Var.b(str, list.get(0));
        } else if (size == 2) {
            o2Var.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            o2Var.a(str);
        } else {
            o2Var.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
