package com.google.android.gms.common.api.internal;

import L.f;
import L.g;
import L.j;
import N.C0722p;
import Z.i;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends j> extends g {

    /* renamed from: m  reason: collision with root package name */
    static final ThreadLocal f4860m = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Object f4861a = new Object();

    /* renamed from: b  reason: collision with root package name */
    protected final a f4862b;

    /* renamed from: c  reason: collision with root package name */
    protected final WeakReference f4863c;

    /* renamed from: d  reason: collision with root package name */
    private final CountDownLatch f4864d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList f4865e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference f4866f = new AtomicReference();

    /* renamed from: g  reason: collision with root package name */
    private j f4867g;

    /* renamed from: h  reason: collision with root package name */
    private Status f4868h;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f4869i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4870j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4871k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f4872l = false;

    public static class a extends i {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == 1) {
                Pair pair = (Pair) message.obj;
                android.support.v4.media.a.a(pair.first);
                j jVar = (j) pair.second;
                try {
                    throw null;
                } catch (RuntimeException e5) {
                    BasePendingResult.j(jVar);
                    throw e5;
                }
            } else if (i5 != 2) {
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + i5, new Exception());
            } else {
                ((BasePendingResult) message.obj).d(Status.f4852i);
            }
        }
    }

    protected BasePendingResult(f fVar) {
        Looper looper;
        if (fVar != null) {
            looper = fVar.c();
        } else {
            looper = Looper.getMainLooper();
        }
        this.f4862b = new a(looper);
        this.f4863c = new WeakReference(fVar);
    }

    private final j g() {
        j jVar;
        synchronized (this.f4861a) {
            C0722p.o(!this.f4869i, "Result has already been consumed.");
            C0722p.o(e(), "Result is not ready.");
            jVar = this.f4867g;
            this.f4867g = null;
            this.f4869i = true;
        }
        android.support.v4.media.a.a(this.f4866f.getAndSet((Object) null));
        return (j) C0722p.k(jVar);
    }

    private final void h(j jVar) {
        this.f4867g = jVar;
        this.f4868h = jVar.getStatus();
        this.f4864d.countDown();
        ArrayList arrayList = this.f4865e;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((g.a) arrayList.get(i5)).a(this.f4868h);
        }
        this.f4865e.clear();
    }

    public final void a(g.a aVar) {
        boolean z4;
        if (aVar != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0722p.b(z4, "Callback cannot be null.");
        synchronized (this.f4861a) {
            try {
                if (e()) {
                    aVar.a(this.f4868h);
                } else {
                    this.f4865e.add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final j b(long j5, TimeUnit timeUnit) {
        if (j5 > 0) {
            C0722p.j("await must not be called on the UI thread when time is greater than zero.");
        }
        C0722p.o(!this.f4869i, "Result has already been consumed.");
        C0722p.o(true, "Cannot await if then() has been called.");
        try {
            if (!this.f4864d.await(j5, timeUnit)) {
                d(Status.f4852i);
            }
        } catch (InterruptedException unused) {
            d(Status.f4850g);
        }
        C0722p.o(e(), "Result is not ready.");
        return g();
    }

    /* access modifiers changed from: protected */
    public abstract j c(Status status);

    public final void d(Status status) {
        synchronized (this.f4861a) {
            try {
                if (!e()) {
                    f(c(status));
                    this.f4871k = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e() {
        if (this.f4864d.getCount() == 0) {
            return true;
        }
        return false;
    }

    public final void f(j jVar) {
        synchronized (this.f4861a) {
            try {
                if (this.f4871k || this.f4870j) {
                    j(jVar);
                    return;
                }
                e();
                C0722p.o(!e(), "Results have already been set");
                C0722p.o(!this.f4869i, "Result has already been consumed");
                h(jVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i() {
        boolean z4 = true;
        if (!this.f4872l && !((Boolean) f4860m.get()).booleanValue()) {
            z4 = false;
        }
        this.f4872l = z4;
    }

    public static void j(j jVar) {
    }
}
