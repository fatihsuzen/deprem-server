package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import j$.util.Objects;

final class R3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6053a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f6054b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f6055c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Bundle f6056d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f6057e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ boolean f6058f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ boolean f6059g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ String f6060h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ C1452x4 f6061i;

    R3(C1452x4 x4Var, String str, String str2, long j5, Bundle bundle, boolean z4, boolean z5, boolean z6, String str3) {
        this.f6053a = str;
        this.f6054b = str2;
        this.f6055c = j5;
        this.f6056d = bundle;
        this.f6057e = z4;
        this.f6058f = z5;
        this.f6059g = z6;
        this.f6060h = str3;
        Objects.requireNonNull(x4Var);
        this.f6061i = x4Var;
    }

    public final void run() {
        this.f6061i.v(this.f6053a, this.f6054b, this.f6055c, this.f6056d, this.f6057e, this.f6058f, this.f6059g, this.f6060h);
    }
}
