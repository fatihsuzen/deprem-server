package com.mbridge.msdk.dycreator.bus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

final class HandlerPoster extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final PendingPostQueue f8665a = new PendingPostQueue();

    /* renamed from: b  reason: collision with root package name */
    private final int f8666b;

    /* renamed from: c  reason: collision with root package name */
    private final EventBus f8667c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8668d;

    HandlerPoster(EventBus eventBus, Looper looper, int i5) {
        super(looper);
        this.f8667c = eventBus;
        this.f8666b = i5;
    }

    /* access modifiers changed from: package-private */
    public final void a(Subscription subscription, Object obj) {
        PendingPost a5 = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f8665a.a(a5);
                if (!this.f8668d) {
                    this.f8668d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new EventBusException("Could not send handler message");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost a5 = this.f8665a.a();
                if (a5 == null) {
                    synchronized (this) {
                        a5 = this.f8665a.a();
                        if (a5 == null) {
                            this.f8668d = false;
                            return;
                        }
                    }
                }
                this.f8667c.a(a5);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f8666b));
            if (sendMessage(obtainMessage())) {
                this.f8668d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } catch (Throwable th) {
            this.f8668d = false;
            throw th;
        }
    }
}
