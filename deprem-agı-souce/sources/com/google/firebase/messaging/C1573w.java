package com.google.firebase.messaging;

import k0.C1699m;

/* renamed from: com.google.firebase.messaging.w  reason: case insensitive filesystem */
public final /* synthetic */ class C1573w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f7475a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1699m f7476b;

    public /* synthetic */ C1573w(FirebaseMessaging firebaseMessaging, C1699m mVar) {
        this.f7475a = firebaseMessaging;
        this.f7476b = mVar;
    }

    public final void run() {
        FirebaseMessaging.c(this.f7475a, this.f7476b);
    }
}
