package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import j$.util.Objects;

final class V3 extends ContentObserver {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    V3(X3 x32, Handler handler) {
        super((Handler) null);
        Objects.requireNonNull(x32);
    }

    public final void onChange(boolean z4) {
        C1160m4.c();
    }
}
