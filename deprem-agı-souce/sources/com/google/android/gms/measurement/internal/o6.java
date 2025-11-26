package com.google.android.gms.measurement.internal;

import N.C0722p;

final class o6 {

    /* renamed from: a  reason: collision with root package name */
    private final q6 f6601a;

    /* renamed from: b  reason: collision with root package name */
    private int f6602b = 1;

    /* renamed from: c  reason: collision with root package name */
    private long f6603c = d();

    public o6(q6 q6Var) {
        this.f6601a = q6Var;
    }

    private final long d() {
        q6 q6Var = this.f6601a;
        C0722p.k(q6Var);
        long longValue = ((Long) C1304d2.f6366v.b((Object) null)).longValue();
        long longValue2 = ((Long) C1304d2.f6368w.b((Object) null)).longValue();
        for (int i5 = 1; i5 < this.f6602b; i5++) {
            longValue += longValue;
            if (longValue >= longValue2) {
                break;
            }
        }
        return q6Var.f().currentTimeMillis() + Math.min(longValue, longValue2);
    }

    public final void a() {
        this.f6602b++;
        this.f6603c = d();
    }

    public final boolean b() {
        if (this.f6601a.f().currentTimeMillis() >= this.f6603c) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ long c() {
        return this.f6603c;
    }
}
