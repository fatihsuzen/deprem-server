package z3;

import A3.b;
import A3.o;
import A3.r;
import B3.D;
import W2.J;
import b3.C2308e;
import b3.C2312i;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.d;
import y3.C2928a;

final class E extends b implements w, C2972e, o {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f26591e = AtomicReferenceFieldUpdater.newUpdater(E.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: d  reason: collision with root package name */
    private int f26592d;

    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f26593a;

        /* renamed from: b  reason: collision with root package name */
        Object f26594b;

        /* renamed from: c  reason: collision with root package name */
        Object f26595c;

        /* renamed from: d  reason: collision with root package name */
        Object f26596d;

        /* renamed from: e  reason: collision with root package name */
        Object f26597e;

        /* renamed from: f  reason: collision with root package name */
        /* synthetic */ Object f26598f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ E f26599g;

        /* renamed from: h  reason: collision with root package name */
        int f26600h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(E e5, C2308e eVar) {
            super(eVar);
            this.f26599g = e5;
        }

        public final Object invokeSuspend(Object obj) {
            this.f26598f = obj;
            this.f26600h |= Integer.MIN_VALUE;
            return this.f26599g.collect((C2973f) null, this);
        }
    }

    public E(Object obj) {
        this._state$volatile = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        r8 = (z3.G[]) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        if (r8 == null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        r2 = r8.length;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        if (r3 >= r2) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        r4 = r8[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        if (r4 == null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        r4.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0045, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0048, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r8 = r6.f26592d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004b, code lost:
        if (r8 != r7) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004d, code lost:
        r6.f26592d = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0050, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0051, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r7 = j();
        r2 = W2.J.f19942a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005a, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005b, code lost:
        r5 = r8;
        r8 = r7;
        r7 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean n(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f26591e     // Catch:{ all -> 0x0014 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0014 }
            r1 = 0
            if (r7 == 0) goto L_0x0016
            boolean r7 = kotlin.jvm.internal.t.a(r0, r7)     // Catch:{ all -> 0x0014 }
            if (r7 != 0) goto L_0x0016
            monitor-exit(r6)
            return r1
        L_0x0014:
            r7 = move-exception
            goto L_0x0067
        L_0x0016:
            boolean r7 = kotlin.jvm.internal.t.a(r0, r8)     // Catch:{ all -> 0x0014 }
            r0 = 1
            if (r7 == 0) goto L_0x001f
            monitor-exit(r6)
            return r0
        L_0x001f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = f26591e     // Catch:{ all -> 0x0014 }
            r7.set(r6, r8)     // Catch:{ all -> 0x0014 }
            int r7 = r6.f26592d     // Catch:{ all -> 0x0014 }
            r8 = r7 & 1
            if (r8 != 0) goto L_0x0061
            int r7 = r7 + r0
            r6.f26592d = r7     // Catch:{ all -> 0x0014 }
            A3.d[] r8 = r6.j()     // Catch:{ all -> 0x0014 }
            W2.J r2 = W2.J.f19942a     // Catch:{ all -> 0x0014 }
            monitor-exit(r6)
        L_0x0036:
            z3.G[] r8 = (z3.G[]) r8
            if (r8 == 0) goto L_0x0048
            int r2 = r8.length
            r3 = r1
        L_0x003c:
            if (r3 >= r2) goto L_0x0048
            r4 = r8[r3]
            if (r4 == 0) goto L_0x0045
            r4.g()
        L_0x0045:
            int r3 = r3 + 1
            goto L_0x003c
        L_0x0048:
            monitor-enter(r6)
            int r8 = r6.f26592d     // Catch:{ all -> 0x0052 }
            if (r8 != r7) goto L_0x0054
            int r7 = r7 + r0
            r6.f26592d = r7     // Catch:{ all -> 0x0052 }
            monitor-exit(r6)
            return r0
        L_0x0052:
            r7 = move-exception
            goto L_0x005f
        L_0x0054:
            A3.d[] r7 = r6.j()     // Catch:{ all -> 0x0052 }
            W2.J r2 = W2.J.f19942a     // Catch:{ all -> 0x0052 }
            monitor-exit(r6)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x0036
        L_0x005f:
            monitor-exit(r6)
            throw r7
        L_0x0061:
            int r7 = r7 + 2
            r6.f26592d = r7     // Catch:{ all -> 0x0014 }
            monitor-exit(r6)
            return r0
        L_0x0067:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.E.n(java.lang.Object, java.lang.Object):boolean");
    }

    public boolean a(Object obj, Object obj2) {
        if (obj == null) {
            obj = r.f17311a;
        }
        if (obj2 == null) {
            obj2 = r.f17311a;
        }
        return n(obj, obj2);
    }

    public C2972e b(C2312i iVar, int i5, C2928a aVar) {
        return F.d(this, iVar, i5, aVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: z3.G} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: z3.E} */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d5, code lost:
        if (r6.e(r0) == r1) goto L_0x00d7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099 A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8 A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00aa A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bd A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00be A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c5 A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(z3.C2973f r11, b3.C2308e r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof z3.E.a
            if (r0 == 0) goto L_0x0013
            r0 = r12
            z3.E$a r0 = (z3.E.a) r0
            int r1 = r0.f26600h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f26600h = r1
            goto L_0x0018
        L_0x0013:
            z3.E$a r0 = new z3.E$a
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f26598f
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f26600h
            r3 = 0
            r4 = 3
            r5 = 2
            if (r2 == 0) goto L_0x0075
            r11 = 1
            if (r2 == r11) goto L_0x0063
            if (r2 == r5) goto L_0x004d
            if (r2 != r4) goto L_0x0045
            java.lang.Object r11 = r0.f26597e
            java.lang.Object r2 = r0.f26596d
            w3.y0 r2 = (w3.C2908y0) r2
            java.lang.Object r6 = r0.f26595c
            z3.G r6 = (z3.G) r6
            java.lang.Object r7 = r0.f26594b
            z3.f r7 = (z3.C2973f) r7
            java.lang.Object r8 = r0.f26593a
            z3.E r8 = (z3.E) r8
            W2.u.b(r12)     // Catch:{ all -> 0x0042 }
            goto L_0x008f
        L_0x0042:
            r11 = move-exception
            goto L_0x00d8
        L_0x0045:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x004d:
            java.lang.Object r11 = r0.f26597e
            java.lang.Object r2 = r0.f26596d
            w3.y0 r2 = (w3.C2908y0) r2
            java.lang.Object r6 = r0.f26595c
            z3.G r6 = (z3.G) r6
            java.lang.Object r7 = r0.f26594b
            z3.f r7 = (z3.C2973f) r7
            java.lang.Object r8 = r0.f26593a
            z3.E r8 = (z3.E) r8
            W2.u.b(r12)     // Catch:{ all -> 0x0042 }
            goto L_0x00bf
        L_0x0063:
            java.lang.Object r11 = r0.f26595c
            r6 = r11
            z3.G r6 = (z3.G) r6
            java.lang.Object r11 = r0.f26594b
            z3.f r11 = (z3.C2973f) r11
            java.lang.Object r2 = r0.f26593a
            r8 = r2
            z3.E r8 = (z3.E) r8
            W2.u.b(r12)     // Catch:{ all -> 0x0042 }
            goto L_0x0080
        L_0x0075:
            W2.u.b(r12)
            A3.d r12 = r10.e()
            z3.G r12 = (z3.G) r12
            r8 = r10
            r6 = r12
        L_0x0080:
            b3.i r12 = r0.getContext()     // Catch:{ all -> 0x0042 }
            w3.y0$b r2 = w3.C2908y0.f26320k0     // Catch:{ all -> 0x0042 }
            b3.i$b r12 = r12.get(r2)     // Catch:{ all -> 0x0042 }
            w3.y0 r12 = (w3.C2908y0) r12     // Catch:{ all -> 0x0042 }
            r7 = r11
            r2 = r12
            r11 = r3
        L_0x008f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = f26591e     // Catch:{ all -> 0x0042 }
            java.lang.Object r12 = r12.get(r8)     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x009c
            w3.B0.h(r2)     // Catch:{ all -> 0x0042 }
        L_0x009c:
            if (r11 == 0) goto L_0x00a4
            boolean r9 = kotlin.jvm.internal.t.a(r11, r12)     // Catch:{ all -> 0x0042 }
            if (r9 != 0) goto L_0x00bf
        L_0x00a4:
            B3.D r11 = A3.r.f17311a     // Catch:{ all -> 0x0042 }
            if (r12 != r11) goto L_0x00aa
            r11 = r3
            goto L_0x00ab
        L_0x00aa:
            r11 = r12
        L_0x00ab:
            r0.f26593a = r8     // Catch:{ all -> 0x0042 }
            r0.f26594b = r7     // Catch:{ all -> 0x0042 }
            r0.f26595c = r6     // Catch:{ all -> 0x0042 }
            r0.f26596d = r2     // Catch:{ all -> 0x0042 }
            r0.f26597e = r12     // Catch:{ all -> 0x0042 }
            r0.f26600h = r5     // Catch:{ all -> 0x0042 }
            java.lang.Object r11 = r7.emit(r11, r0)     // Catch:{ all -> 0x0042 }
            if (r11 != r1) goto L_0x00be
            goto L_0x00d7
        L_0x00be:
            r11 = r12
        L_0x00bf:
            boolean r12 = r6.h()     // Catch:{ all -> 0x0042 }
            if (r12 != 0) goto L_0x008f
            r0.f26593a = r8     // Catch:{ all -> 0x0042 }
            r0.f26594b = r7     // Catch:{ all -> 0x0042 }
            r0.f26595c = r6     // Catch:{ all -> 0x0042 }
            r0.f26596d = r2     // Catch:{ all -> 0x0042 }
            r0.f26597e = r11     // Catch:{ all -> 0x0042 }
            r0.f26600h = r4     // Catch:{ all -> 0x0042 }
            java.lang.Object r12 = r6.e(r0)     // Catch:{ all -> 0x0042 }
            if (r12 != r1) goto L_0x008f
        L_0x00d7:
            return r1
        L_0x00d8:
            r8.h(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.E.collect(z3.f, b3.e):java.lang.Object");
    }

    public Object emit(Object obj, C2308e eVar) {
        setValue(obj);
        return J.f19942a;
    }

    public Object getValue() {
        D d5 = r.f17311a;
        Object obj = f26591e.get(this);
        if (obj == d5) {
            return null;
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public G f() {
        return new G();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public G[] g(int i5) {
        return new G[i5];
    }

    public void setValue(Object obj) {
        if (obj == null) {
            obj = r.f17311a;
        }
        n((Object) null, obj);
    }
}
