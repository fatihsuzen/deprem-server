package com.finazzi.distquake;

import java.util.Calendar;
import java.util.TimeZone;
import u2.I1;

class b0 {

    /* renamed from: a  reason: collision with root package name */
    private I1 f13690a;

    /* renamed from: b  reason: collision with root package name */
    private a0 f13691b;

    public b0(I1 i12, TimeZone timeZone) {
        this.f13690a = i12;
        this.f13691b = new a0(i12, timeZone);
    }

    public Calendar a(Calendar calendar) {
        return this.f13691b.c(h0.f13709e, calendar);
    }

    public Calendar b(Calendar calendar) {
        return this.f13691b.d(h0.f13709e, calendar);
    }
}
