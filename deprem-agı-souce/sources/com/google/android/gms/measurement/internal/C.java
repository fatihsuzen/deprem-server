package com.google.android.gms.measurement.internal;

import N.C0722p;

final class C {

    /* renamed from: a  reason: collision with root package name */
    final String f5791a;

    /* renamed from: b  reason: collision with root package name */
    final String f5792b;

    /* renamed from: c  reason: collision with root package name */
    final long f5793c;

    /* renamed from: d  reason: collision with root package name */
    final long f5794d;

    /* renamed from: e  reason: collision with root package name */
    final long f5795e;

    /* renamed from: f  reason: collision with root package name */
    final long f5796f;

    /* renamed from: g  reason: collision with root package name */
    final long f5797g;

    /* renamed from: h  reason: collision with root package name */
    final Long f5798h;

    /* renamed from: i  reason: collision with root package name */
    final Long f5799i;

    /* renamed from: j  reason: collision with root package name */
    final Long f5800j;

    /* renamed from: k  reason: collision with root package name */
    final Boolean f5801k;

    C(String str, String str2, long j5, long j6, long j7, long j8, long j9, Long l5, Long l6, Long l7, Boolean bool) {
        boolean z4;
        boolean z5;
        boolean z6;
        long j10 = j5;
        long j11 = j6;
        long j12 = j7;
        long j13 = j9;
        C0722p.e(str);
        C0722p.e(str2);
        boolean z7 = false;
        if (j10 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0722p.a(z4);
        if (j11 >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        C0722p.a(z5);
        if (j12 >= 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        C0722p.a(z6);
        C0722p.a(j13 >= 0 ? true : z7);
        this.f5791a = str;
        this.f5792b = str2;
        this.f5793c = j10;
        this.f5794d = j11;
        this.f5795e = j12;
        this.f5796f = j8;
        this.f5797g = j13;
        this.f5798h = l5;
        this.f5799i = l6;
        this.f5800j = l7;
        this.f5801k = bool;
    }

    /* access modifiers changed from: package-private */
    public final C a(long j5) {
        long j6 = this.f5797g;
        Long l5 = this.f5798h;
        Long l6 = this.f5799i;
        Long l7 = this.f5800j;
        Boolean bool = this.f5801k;
        return new C(this.f5791a, this.f5792b, this.f5793c, this.f5794d, this.f5795e, j5, j6, l5, l6, l7, bool);
    }

    /* access modifiers changed from: package-private */
    public final C b(long j5, long j6) {
        Long valueOf = Long.valueOf(j6);
        Long l5 = this.f5799i;
        Long l6 = this.f5800j;
        return new C(this.f5791a, this.f5792b, this.f5793c, this.f5794d, this.f5795e, this.f5796f, j5, valueOf, l5, l6, this.f5801k);
    }

    /* access modifiers changed from: package-private */
    public final C c(Long l5, Long l6, Boolean bool) {
        return new C(this.f5791a, this.f5792b, this.f5793c, this.f5794d, this.f5795e, this.f5796f, this.f5797g, this.f5798h, l5, l6, bool);
    }
}
