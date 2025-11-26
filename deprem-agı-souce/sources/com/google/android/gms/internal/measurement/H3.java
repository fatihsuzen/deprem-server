package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import j$.util.Objects;

final class H3 extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ J3 f4957a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    H3(J3 j32, Handler handler) {
        super((Handler) null);
        Objects.requireNonNull(j32);
        this.f4957a = j32;
    }

    public final void onChange(boolean z4) {
        this.f4957a.b().set(true);
    }
}
