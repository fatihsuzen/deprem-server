package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

final class d0 {

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference f7400d;

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f7401a;

    /* renamed from: b  reason: collision with root package name */
    private Z f7402b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f7403c;

    private d0(SharedPreferences sharedPreferences, Executor executor) {
        this.f7403c = executor;
        this.f7401a = sharedPreferences;
    }

    public static synchronized d0 a(Context context, Executor executor) {
        d0 d0Var;
        synchronized (d0.class) {
            try {
                WeakReference weakReference = f7400d;
                if (weakReference != null) {
                    d0Var = (d0) weakReference.get();
                } else {
                    d0Var = null;
                }
                if (d0Var == null) {
                    d0Var = new d0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                    d0Var.c();
                    f7400d = new WeakReference(d0Var);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return d0Var;
    }

    private synchronized void c() {
        this.f7402b = Z.c(this.f7401a, "topic_operation_queue", ",", this.f7403c);
    }

    /* access modifiers changed from: package-private */
    public synchronized c0 b() {
        return c0.a(this.f7402b.e());
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean d(c0 c0Var) {
        return this.f7402b.f(c0Var.e());
    }
}
