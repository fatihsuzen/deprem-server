package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.os.Process;
import androidx.work.WorkRequest;
import j$.util.Objects;
import java.util.concurrent.BlockingQueue;

final class S2 extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Object f6069a;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue f6070b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6071c = false;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ T2 f6072d;

    public S2(T2 t22, String str, BlockingQueue blockingQueue) {
        Objects.requireNonNull(t22);
        this.f6072d = t22;
        C0722p.k(str);
        C0722p.k(blockingQueue);
        this.f6069a = new Object();
        this.f6070b = blockingQueue;
        setName(str);
    }

    private final void b() {
        T2 t22 = this.f6072d;
        synchronized (t22.B()) {
            try {
                if (!this.f6071c) {
                    t22.C().release();
                    t22.B().notifyAll();
                    if (this == t22.x()) {
                        t22.y((S2) null);
                    } else if (this == t22.z()) {
                        t22.A((S2) null);
                    } else {
                        t22.f5730a.a().o().a("Current scheduler thread is neither worker nor network");
                    }
                    this.f6071c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c(InterruptedException interruptedException) {
        this.f6072d.f5730a.a().r().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void a() {
        Object obj = this.f6069a;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public final void run() {
        int i5;
        boolean z4 = false;
        while (!z4) {
            try {
                this.f6072d.C().acquire();
                z4 = true;
            } catch (InterruptedException e5) {
                c(e5);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                BlockingQueue blockingQueue = this.f6070b;
                R2 r22 = (R2) blockingQueue.poll();
                if (r22 != null) {
                    if (true != r22.f6050b) {
                        i5 = 10;
                    } else {
                        i5 = threadPriority;
                    }
                    Process.setThreadPriority(i5);
                    r22.run();
                } else {
                    Object obj = this.f6069a;
                    synchronized (obj) {
                        if (blockingQueue.peek() == null) {
                            this.f6072d.D();
                            try {
                                obj.wait(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                            } catch (InterruptedException e6) {
                                c(e6);
                            }
                        }
                    }
                    synchronized (this.f6072d.B()) {
                        if (this.f6070b.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
