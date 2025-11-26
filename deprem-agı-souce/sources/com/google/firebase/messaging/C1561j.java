package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.messaging.j  reason: case insensitive filesystem */
public final /* synthetic */ class C1561j implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7447a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f7448b;

    public /* synthetic */ C1561j(Context context, Intent intent) {
        this.f7447a = context;
        this.f7448b = intent;
    }

    public final Object call() {
        return Integer.valueOf(X.b().g(this.f7447a, this.f7448b));
    }
}
