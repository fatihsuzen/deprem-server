package B3;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.t;

/* renamed from: B3.b  reason: case insensitive filesystem */
public abstract class C1982b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17388a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17389b;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    static {
        Class<C1982b> cls = C1982b.class;
        Class<Object> cls2 = Object.class;
        f17388a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next$volatile");
        f17389b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev$volatile");
    }

    public C1982b(C1982b bVar) {
        this._prev$volatile = bVar;
    }

    private final C1982b d() {
        C1982b h5 = h();
        while (h5 != null && h5.k()) {
            h5 = (C1982b) f17389b.get(h5);
        }
        return h5;
    }

    private final C1982b e() {
        C1982b f5;
        C1982b f6 = f();
        t.b(f6);
        while (f6.k() && (f5 = f6.f()) != null) {
            f6 = f5;
        }
        return f6;
    }

    /* access modifiers changed from: private */
    public final Object g() {
        return f17388a.get(this);
    }

    public final void c() {
        f17389b.set(this, (Object) null);
    }

    public final C1982b f() {
        Object b5 = g();
        if (b5 == C1981a.f17387a) {
            return null;
        }
        return (C1982b) b5;
    }

    public final C1982b h() {
        return (C1982b) f17389b.get(this);
    }

    public abstract boolean k();

    public final boolean l() {
        if (f() == null) {
            return true;
        }
        return false;
    }

    public final boolean m() {
        return a.a(f17388a, this, (Object) null, C1981a.f17387a);
    }

    public final void n() {
        Object obj;
        C1982b bVar;
        if (!l()) {
            while (true) {
                C1982b d5 = d();
                C1982b e5 = e();
                AtomicReferenceFieldUpdater j5 = f17389b;
                do {
                    obj = j5.get(e5);
                    if (((C1982b) obj) == null) {
                        bVar = null;
                    } else {
                        bVar = d5;
                    }
                } while (!a.a(j5, e5, obj, bVar));
                if (d5 != null) {
                    f17388a.set(d5, e5);
                }
                if ((!e5.k() || e5.l()) && (d5 == null || !d5.k())) {
                    return;
                }
            }
        }
    }

    public final boolean o(C1982b bVar) {
        return a.a(f17388a, this, (Object) null, bVar);
    }
}
