package y3;

import B3.A;
import B3.D;
import B3.w;
import b3.C2312i;
import java.util.concurrent.atomic.AtomicReferenceArray;
import k3.l;
import kotlin.jvm.internal.t;
import w3.d1;

public final class m extends A {

    /* renamed from: e  reason: collision with root package name */
    private final C2932e f26441e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f26442f = new AtomicReferenceArray(C2933f.f26414b * 2);

    public m(long j5, m mVar, C2932e eVar, int i5) {
        super(j5, mVar, i5);
        this.f26441e = eVar;
    }

    private final void E(int i5, Object obj) {
        z().set(i5 * 2, obj);
    }

    private final /* synthetic */ AtomicReferenceArray z() {
        return this.f26442f;
    }

    public final Object A(int i5) {
        return z().get(i5 * 2);
    }

    public final Object B(int i5) {
        return z().get((i5 * 2) + 1);
    }

    public final void C(int i5, boolean z4) {
        if (z4) {
            y().n1((this.f17367c * ((long) C2933f.f26414b)) + ((long) i5));
        }
        t();
    }

    public final Object D(int i5) {
        Object A4 = A(i5);
        w(i5);
        return A4;
    }

    public final void F(int i5, Object obj) {
        z().set((i5 * 2) + 1, obj);
    }

    public final void G(int i5, Object obj) {
        E(i5, obj);
    }

    public int r() {
        return C2933f.f26414b;
    }

    public void s(int i5, Throwable th, C2312i iVar) {
        boolean z4;
        D d5;
        l lVar;
        l lVar2;
        int i6 = C2933f.f26414b;
        if (i5 >= i6) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            i5 -= i6;
        }
        Object A4 = A(i5);
        while (true) {
            Object B4 = B(i5);
            if ((B4 instanceof d1) || (B4 instanceof z)) {
                if (z4) {
                    d5 = C2933f.f26422j;
                } else {
                    d5 = C2933f.f26423k;
                }
                if (v(i5, B4, d5)) {
                    w(i5);
                    C(i5, !z4);
                    if (z4 && (lVar = y().f26398b) != null) {
                        w.a(lVar, A4, iVar);
                        return;
                    }
                    return;
                }
            } else if (B4 == C2933f.f26422j || B4 == C2933f.f26423k) {
                w(i5);
            } else if (!(B4 == C2933f.f26419g || B4 == C2933f.f26418f)) {
                if (B4 != C2933f.f26421i && B4 != C2933f.f26416d && B4 != C2933f.z()) {
                    throw new IllegalStateException(("unexpected state: " + B4).toString());
                }
                return;
            }
        }
        w(i5);
        if (z4 && (lVar2 = y().f26398b) != null) {
            w.a(lVar2, A4, iVar);
        }
    }

    public final boolean v(int i5, Object obj, Object obj2) {
        return l.a(z(), (i5 * 2) + 1, obj, obj2);
    }

    public final void w(int i5) {
        E(i5, (Object) null);
    }

    public final Object x(int i5, Object obj) {
        return z().getAndSet((i5 * 2) + 1, obj);
    }

    public final C2932e y() {
        C2932e eVar = this.f26441e;
        t.b(eVar);
        return eVar;
    }
}
