package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class e0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f7405a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f7406b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f7407c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ I f7408d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ D f7409e;

    public /* synthetic */ e0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, I i5, D d5) {
        this.f7405a = context;
        this.f7406b = scheduledExecutorService;
        this.f7407c = firebaseMessaging;
        this.f7408d = i5;
        this.f7409e = d5;
    }

    public final Object call() {
        return f0.a(this.f7405a, this.f7406b, this.f7407c, this.f7408d, this.f7409e);
    }
}
