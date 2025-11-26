package com.mbridge.msdk.tracker.network;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private volatile ThreadPoolExecutor f11709a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f11710b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    private final Set<u<?>> f11711c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final PriorityBlockingQueue<u<?>> f11712d = new PriorityBlockingQueue<>();

    /* renamed from: e  reason: collision with root package name */
    private final int f11713e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final b f11714f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final n f11715g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final x f11716h;

    /* renamed from: i  reason: collision with root package name */
    private final List<a> f11717i = new ArrayList();

    public interface a {
        void a(u<?> uVar, int i5);
    }

    public v(n nVar, x xVar, int i5, b bVar) {
        this.f11713e = i5;
        this.f11714f = bVar;
        this.f11715g = nVar;
        this.f11716h = xVar;
    }

    private void a(int i5) {
        if (this.f11709a == null) {
            try {
                b(i5);
                if (this.f11709a != null) {
                    this.f11709a.allowCoreThreadTimeOut(true);
                }
            } catch (Throwable unused) {
                try {
                    b(5);
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    if (this.f11709a != null) {
                        this.f11709a.allowCoreThreadTimeOut(true);
                    }
                    throw th;
                }
                if (this.f11709a != null) {
                    this.f11709a.allowCoreThreadTimeOut(true);
                }
            }
        }
    }

    private void b(int i5) {
        int i6 = i5;
        this.f11709a = new ThreadPoolExecutor(i6, i5, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "NetworkDispatcher");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    /* access modifiers changed from: package-private */
    public final <T> void b(u<T> uVar) {
        synchronized (this.f11711c) {
            this.f11711c.remove(uVar);
        }
        a(uVar, 5);
    }

    public final <T> u<T> a(u<T> uVar) {
        uVar.a(this);
        synchronized (this.f11711c) {
            this.f11711c.add(uVar);
        }
        uVar.c(this.f11710b.incrementAndGet());
        a(uVar, 0);
        this.f11712d.add(uVar);
        if (this.f11709a == null) {
            a(this.f11713e);
        }
        this.f11709a.execute(new Runnable() {
            public final void run() {
                try {
                    new o(v.this.f11712d, v.this.f11715g, v.this.f11714f, v.this.f11716h).run();
                } catch (Throwable unused) {
                }
            }
        });
        return uVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(u<?> uVar, int i5) {
        synchronized (this.f11717i) {
            try {
                for (a a5 : this.f11717i) {
                    a5.a(uVar, i5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        this.f11709a = null;
        a(this.f11713e);
    }
}
