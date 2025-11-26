package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C1214s5;
import java.util.concurrent.Callable;

final /* synthetic */ class O2 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ P2 f6004a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f6005b;

    /* synthetic */ O2(P2 p22, String str) {
        this.f6004a = p22;
        this.f6005b = str;
    }

    public final /* synthetic */ Object call() {
        return new C1214s5("internal.remoteConfig", new K2(this.f6004a, this.f6005b));
    }
}
