package com.mbridge.msdk.dycreator.bus;

import android.util.Log;

final class BackgroundPoster implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final PendingPostQueue f8642a = new PendingPostQueue();

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f8643b;

    /* renamed from: c  reason: collision with root package name */
    private final EventBus f8644c;

    BackgroundPoster(EventBus eventBus) {
        this.f8644c = eventBus;
    }

    public final void enqueue(Subscription subscription, Object obj) {
        PendingPost a5 = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f8642a.a(a5);
                if (!this.f8643b) {
                    this.f8643b = true;
                    EventBus.f8645a.execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void run() {
        while (true) {
            try {
                PendingPost a5 = this.f8642a.a(1000);
                if (a5 == null) {
                    synchronized (this) {
                        a5 = this.f8642a.a();
                        if (a5 == null) {
                            this.f8643b = false;
                            this.f8643b = false;
                            return;
                        }
                    }
                }
                this.f8644c.a(a5);
            } catch (InterruptedException e5) {
                try {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e5);
                    this.f8643b = false;
                    return;
                } catch (Throwable th) {
                    this.f8643b = false;
                    throw th;
                }
            }
        }
    }
}
