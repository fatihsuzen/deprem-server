package com.google.firebase.messaging;

/* renamed from: com.google.firebase.messaging.t  reason: case insensitive filesystem */
public final /* synthetic */ class C1570t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f7472a;

    public /* synthetic */ C1570t(FirebaseMessaging firebaseMessaging) {
        this.f7472a = firebaseMessaging;
    }

    public final void run() {
        FirebaseMessaging.b(this.f7472a);
    }
}
