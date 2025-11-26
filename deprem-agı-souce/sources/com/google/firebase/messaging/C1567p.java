package com.google.firebase.messaging;

import android.content.Intent;

/* renamed from: com.google.firebase.messaging.p  reason: case insensitive filesystem */
public final /* synthetic */ class C1567p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1568q f7468a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f7469b;

    public /* synthetic */ C1567p(C1568q qVar, Intent intent) {
        this.f7468a = qVar;
        this.f7469b = intent;
    }

    public final void run() {
        this.f7468a.b(this.f7469b);
    }
}
