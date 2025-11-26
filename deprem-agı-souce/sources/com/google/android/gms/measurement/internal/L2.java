package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.R7;
import java.util.concurrent.Callable;

final /* synthetic */ class L2 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ P2 f5960a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f5961b;

    /* synthetic */ L2(P2 p22, String str) {
        this.f5960a = p22;
        this.f5961b = str;
    }

    public final /* synthetic */ Object call() {
        return new R7("internal.appMetadata", new N2(this.f5960a, this.f5961b));
    }
}
