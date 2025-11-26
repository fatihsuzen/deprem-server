package B3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.t;
import w3.Q;

/* renamed from: B3.o  reason: case insensitive filesystem */
public class C1995o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17410a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17411b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17412c;
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    /* renamed from: B3.o$a */
    /* synthetic */ class a extends C {
        a(Object obj) {
            super(obj, Q.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1);
        }

        public Object get() {
            return Q.a(this.receiver);
        }
    }

    static {
        Class<C1995o> cls = C1995o.class;
        Class<Object> cls2 = Object.class;
        f17410a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next$volatile");
        f17411b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev$volatile");
        f17412c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_removedRef$volatile");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: B3.o} */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (androidx.concurrent.futures.a.a(m(), r3, r2, ((B3.x) r4).f17428a) != false) goto L_0x0042;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final B3.C1995o g() {
        /*
            r7 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f17411b
            java.lang.Object r0 = r0.get(r7)
            B3.o r0 = (B3.C1995o) r0
            r1 = 0
            r2 = r0
        L_0x000c:
            r3 = r1
        L_0x000d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f17410a
            java.lang.Object r4 = r4.get(r2)
            if (r4 != r7) goto L_0x0026
            if (r0 != r2) goto L_0x001a
            goto L_0x0025
        L_0x001a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f17411b
            boolean r0 = androidx.concurrent.futures.a.a(r1, r7, r0, r2)
            if (r0 != 0) goto L_0x0025
            goto L_0x0000
        L_0x0025:
            return r2
        L_0x0026:
            boolean r5 = r7.p()
            if (r5 == 0) goto L_0x002d
            return r1
        L_0x002d:
            boolean r5 = r4 instanceof B3.x
            if (r5 == 0) goto L_0x004f
            if (r3 == 0) goto L_0x0044
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f17410a
            B3.x r4 = (B3.x) r4
            B3.o r4 = r4.f17428a
            boolean r2 = androidx.concurrent.futures.a.a(r5, r3, r2, r4)
            if (r2 != 0) goto L_0x0042
            goto L_0x0000
        L_0x0042:
            r2 = r3
            goto L_0x000c
        L_0x0044:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f17411b
            java.lang.Object r2 = r4.get(r2)
            B3.o r2 = (B3.C1995o) r2
            goto L_0x000d
        L_0x004f:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.t.c(r4, r3)
            r3 = r4
            B3.o r3 = (B3.C1995o) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.C1995o.g():B3.o");
    }

    private final C1995o h(C1995o oVar) {
        while (oVar.p()) {
            oVar = (C1995o) f17411b.get(oVar);
        }
        return oVar;
    }

    private final void i(C1995o oVar) {
        C1995o oVar2;
        AtomicReferenceFieldUpdater n5 = f17411b;
        do {
            oVar2 = (C1995o) n5.get(oVar);
            if (j() != oVar) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f17411b, oVar, oVar2, this));
        if (p()) {
            oVar.g();
        }
    }

    private final x s() {
        x xVar = (x) f17412c.get(this);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(this);
        f17412c.set(this, xVar2);
        return xVar2;
    }

    public final boolean c(C1995o oVar, int i5) {
        C1995o l5;
        do {
            l5 = l();
            if (l5 instanceof C1993m) {
                if ((((C1993m) l5).f17409d & i5) != 0 || !l5.c(oVar, i5)) {
                    return false;
                }
                return true;
            }
        } while (!l5.d(oVar, this));
        return true;
    }

    public final boolean d(C1995o oVar, C1995o oVar2) {
        f17411b.set(oVar, this);
        f17410a.set(oVar, oVar2);
        if (!androidx.concurrent.futures.a.a(f17410a, this, oVar2, oVar)) {
            return false;
        }
        oVar.i(oVar2);
        return true;
    }

    public final boolean e(C1995o oVar) {
        f17411b.set(oVar, this);
        f17410a.set(oVar, this);
        while (j() == this) {
            if (androidx.concurrent.futures.a.a(f17410a, this, this, oVar)) {
                oVar.i(this);
                return true;
            }
        }
        return false;
    }

    public final void f(int i5) {
        c(new C1993m(i5), i5);
    }

    public final Object j() {
        return f17410a.get(this);
    }

    public final C1995o k() {
        x xVar;
        C1995o oVar;
        Object j5 = j();
        if (j5 instanceof x) {
            xVar = (x) j5;
        } else {
            xVar = null;
        }
        if (xVar != null && (oVar = xVar.f17428a) != null) {
            return oVar;
        }
        t.c(j5, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (C1995o) j5;
    }

    public final C1995o l() {
        C1995o g5 = g();
        if (g5 == null) {
            return h((C1995o) f17411b.get(this));
        }
        return g5;
    }

    public boolean p() {
        return j() instanceof x;
    }

    public boolean q() {
        if (r() == null) {
            return true;
        }
        return false;
    }

    public final C1995o r() {
        Object j5;
        C1995o oVar;
        do {
            j5 = j();
            if (j5 instanceof x) {
                return ((x) j5).f17428a;
            }
            if (j5 == this) {
                return (C1995o) j5;
            }
            t.c(j5, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            oVar = (C1995o) j5;
        } while (!androidx.concurrent.futures.a.a(f17410a, this, j5, oVar.s()));
        oVar.g();
        return null;
    }

    public String toString() {
        return new a(this) + '@' + Q.b(this);
    }
}
