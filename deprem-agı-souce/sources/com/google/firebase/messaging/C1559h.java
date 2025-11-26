package com.google.firebase.messaging;

import android.content.Intent;
import k0.C1699m;

/* renamed from: com.google.firebase.messaging.h  reason: case insensitive filesystem */
public final /* synthetic */ class C1559h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1560i f7434a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f7435b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C1699m f7436c;

    public /* synthetic */ C1559h(C1560i iVar, Intent intent, C1699m mVar) {
        this.f7434a = iVar;
        this.f7435b = intent;
        this.f7436c = mVar;
    }

    public final void run() {
        C1560i.a(this.f7434a, this.f7435b, this.f7436c);
    }
}
