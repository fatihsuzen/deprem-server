package B3;

import b3.C2312i;
import b3.C2313j;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import w3.C2869e0;
import w3.C2882l;
import w3.I;
import w3.K;
import w3.T;
import w3.W;

/* renamed from: B3.k  reason: case insensitive filesystem */
public final class C1991k extends I implements W {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17400g = AtomicIntegerFieldUpdater.newUpdater(C1991k.class, "runningWorkers$volatile");

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ W f17401a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final I f17402b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17403c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17404d;

    /* renamed from: e  reason: collision with root package name */
    private final C1996p f17405e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f17406f;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* renamed from: B3.k$a */
    private final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f17407a;

        public a(Runnable runnable) {
            this.f17407a = runnable;
        }

        public void run() {
            int i5 = 0;
            while (true) {
                try {
                    this.f17407a.run();
                } catch (Throwable th) {
                    K.a(C2313j.f20794a, th);
                }
                Runnable G4 = C1991k.this.I();
                if (G4 != null) {
                    this.f17407a = G4;
                    i5++;
                    if (i5 >= 16 && C1991k.this.f17402b.isDispatchNeeded(C1991k.this)) {
                        C1991k.this.f17402b.dispatch(C1991k.this, this);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public C1991k(I i5, int i6, String str) {
        W w4;
        if (i5 instanceof W) {
            w4 = (W) i5;
        } else {
            w4 = null;
        }
        this.f17401a = w4 == null ? T.a() : w4;
        this.f17402b = i5;
        this.f17403c = i6;
        this.f17404d = str;
        this.f17405e = new C1996p(false);
        this.f17406f = new Object();
    }

    /* access modifiers changed from: private */
    public final Runnable I() {
        while (true) {
            Runnable runnable = (Runnable) this.f17405e.e();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f17406f) {
                f17400g.decrementAndGet(this);
                if (this.f17405e.c() == 0) {
                    return null;
                }
                f17400g.incrementAndGet(this);
            }
        }
    }

    private final boolean J() {
        synchronized (this.f17406f) {
            if (f17400g.get(this) >= this.f17403c) {
                return false;
            }
            f17400g.incrementAndGet(this);
            return true;
        }
    }

    public void dispatch(C2312i iVar, Runnable runnable) {
        Runnable I4;
        this.f17405e.a(runnable);
        if (f17400g.get(this) < this.f17403c && J() && (I4 = I()) != null) {
            this.f17402b.dispatch(this, new a(I4));
        }
    }

    public void dispatchYield(C2312i iVar, Runnable runnable) {
        Runnable I4;
        this.f17405e.a(runnable);
        if (f17400g.get(this) < this.f17403c && J() && (I4 = I()) != null) {
            this.f17402b.dispatchYield(this, new a(I4));
        }
    }

    public I limitedParallelism(int i5, String str) {
        C1992l.a(i5);
        if (i5 >= this.f17403c) {
            return C1992l.b(this, str);
        }
        return super.limitedParallelism(i5, str);
    }

    public void o(long j5, C2882l lVar) {
        this.f17401a.o(j5, lVar);
    }

    public C2869e0 q(long j5, Runnable runnable, C2312i iVar) {
        return this.f17401a.q(j5, runnable, iVar);
    }

    public String toString() {
        String str = this.f17404d;
        if (str != null) {
            return str;
        }
        return this.f17402b + ".limitedParallelism(" + this.f17403c + ')';
    }
}
