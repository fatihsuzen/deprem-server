package com.google.firebase.messaging;

import android.content.Context;
import k0.C1699m;

public final /* synthetic */ class N implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7307a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f7308b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C1699m f7309c;

    public /* synthetic */ N(Context context, boolean z4, C1699m mVar) {
        this.f7307a = context;
        this.f7308b = z4;
        this.f7309c = mVar;
    }

    public final void run() {
        O.a(this.f7307a, this.f7308b, this.f7309c);
    }
}
