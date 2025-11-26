package com.google.android.gms.measurement.internal;

import N.C0722p;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.t2  reason: case insensitive filesystem */
final class C1422t2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final C1415s2 f6723a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6724b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f6725c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f6726d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6727e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f6728f;

    /* synthetic */ C1422t2(String str, C1415s2 s2Var, int i5, Throwable th, byte[] bArr, Map map, byte[] bArr2) {
        C0722p.k(s2Var);
        this.f6723a = s2Var;
        this.f6724b = i5;
        this.f6725c = th;
        this.f6726d = bArr;
        this.f6727e = str;
        this.f6728f = map;
    }

    public final void run() {
        this.f6723a.a(this.f6727e, this.f6724b, this.f6725c, this.f6726d, this.f6728f);
    }
}
