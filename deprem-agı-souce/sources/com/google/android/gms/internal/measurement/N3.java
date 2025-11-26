package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import j$.util.Objects;

final class N3 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Q3 f5033a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    N3(Q3 q32, Handler handler) {
        super((Handler) null);
        Objects.requireNonNull(q32);
        this.f5033a = q32;
    }

    public final void onChange(boolean z4) {
        this.f5033a.d();
    }
}
