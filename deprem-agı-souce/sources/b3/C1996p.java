package B3;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: B3.p  reason: case insensitive filesystem */
public class C1996p {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17413a = AtomicReferenceFieldUpdater.newUpdater(C1996p.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile;

    public C1996p(boolean z4) {
        this._cur$volatile = new C1997q(8, z4);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater d5 = f17413a;
        while (true) {
            C1997q qVar = (C1997q) d5.get(this);
            int a5 = qVar.a(obj);
            if (a5 == 0) {
                return true;
            }
            if (a5 == 1) {
                a.a(f17413a, this, qVar, qVar.l());
            } else if (a5 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater d5 = f17413a;
        while (true) {
            C1997q qVar = (C1997q) d5.get(this);
            if (!qVar.d()) {
                a.a(f17413a, this, qVar, qVar.l());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((C1997q) f17413a.get(this)).g();
    }

    public final Object e() {
        AtomicReferenceFieldUpdater d5 = f17413a;
        while (true) {
            C1997q qVar = (C1997q) d5.get(this);
            Object m5 = qVar.m();
            if (m5 != C1997q.f17417h) {
                return m5;
            }
            a.a(f17413a, this, qVar, qVar.l());
        }
    }
}
