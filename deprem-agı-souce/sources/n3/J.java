package N3;

import M3.B;
import M3.C2129c;
import M3.f;
import M3.h;
import M3.s;
import M3.w;
import M3.z;
import W2.C2212a;
import W2.C2213b;
import W2.C2214c;
import W2.C2219h;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import k3.q;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.k;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class J {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final C2131a f18728a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18729b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18730c;

    /* renamed from: d  reason: collision with root package name */
    private int f18731d;

    static final class a extends k implements q {

        /* renamed from: a  reason: collision with root package name */
        int f18732a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f18733b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ J f18734c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(J j5, C2308e eVar) {
            super(3, eVar);
            this.f18734c = j5;
        }

        /* renamed from: b */
        public final Object invoke(C2214c cVar, W2.J j5, C2308e eVar) {
            a aVar = new a(this.f18734c, eVar);
            aVar.f18733b = cVar;
            return aVar.invokeSuspend(W2.J.f19942a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f18732a;
            if (i5 == 0) {
                u.b(obj);
                C2214c cVar = (C2214c) this.f18733b;
                byte F4 = this.f18734c.f18728a.F();
                if (F4 == 1) {
                    return this.f18734c.j(true);
                }
                if (F4 == 0) {
                    return this.f18734c.j(false);
                }
                if (F4 == 6) {
                    J j5 = this.f18734c;
                    this.f18732a = 1;
                    obj = j5.i(cVar, this);
                    if (obj == f5) {
                        return f5;
                    }
                } else if (F4 == 8) {
                    return this.f18734c.f();
                } else {
                    C2131a.x(this.f18734c.f18728a, "Can't begin reading element, unexpected token", 0, (String) null, 6, (Object) null);
                    throw new C2219h();
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return (h) obj;
        }
    }

    static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f18735a;

        /* renamed from: b  reason: collision with root package name */
        Object f18736b;

        /* renamed from: c  reason: collision with root package name */
        Object f18737c;

        /* renamed from: d  reason: collision with root package name */
        Object f18738d;

        /* renamed from: e  reason: collision with root package name */
        /* synthetic */ Object f18739e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ J f18740f;

        /* renamed from: g  reason: collision with root package name */
        int f18741g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(J j5, C2308e eVar) {
            super(eVar);
            this.f18740f = j5;
        }

        public final Object invokeSuspend(Object obj) {
            this.f18739e = obj;
            this.f18741g |= Integer.MIN_VALUE;
            return this.f18740f.i((C2214c) null, this);
        }
    }

    public J(f fVar, C2131a aVar) {
        t.e(fVar, "configuration");
        t.e(aVar, "lexer");
        this.f18728a = aVar;
        this.f18729b = fVar.q();
        this.f18730c = fVar.d();
    }

    /* access modifiers changed from: private */
    public final h f() {
        boolean z4;
        byte j5 = this.f18728a.j();
        if (this.f18728a.F() != 4) {
            ArrayList arrayList = new ArrayList();
            while (this.f18728a.e()) {
                arrayList.add(e());
                j5 = this.f18728a.j();
                if (j5 != 4) {
                    C2131a aVar = this.f18728a;
                    if (j5 == 9) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    int i5 = aVar.f18775a;
                    if (!z4) {
                        C2131a.x(aVar, "Expected end of the array or comma", i5, (String) null, 4, (Object) null);
                        throw new C2219h();
                    }
                }
            }
            if (j5 == 8) {
                this.f18728a.k((byte) 9);
            } else if (j5 == 4) {
                if (this.f18730c) {
                    this.f18728a.k((byte) 9);
                } else {
                    z.g(this.f18728a, "array");
                    throw new C2219h();
                }
            }
            return new C2129c(arrayList);
        }
        C2131a.x(this.f18728a, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
        throw new C2219h();
    }

    private final h g() {
        return (h) C2213b.b(new C2212a(new a(this, (C2308e) null)), W2.J.f19942a);
    }

    private final h h() {
        String str;
        byte k5 = this.f18728a.k((byte) 6);
        if (this.f18728a.F() != 4) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!this.f18728a.e()) {
                    break;
                }
                if (this.f18729b) {
                    str = this.f18728a.q();
                } else {
                    str = this.f18728a.o();
                }
                this.f18728a.k((byte) 5);
                linkedHashMap.put(str, e());
                k5 = this.f18728a.j();
                if (k5 != 4) {
                    if (k5 != 7) {
                        C2131a.x(this.f18728a, "Expected end of the object or comma", 0, (String) null, 6, (Object) null);
                        throw new C2219h();
                    }
                }
            }
            if (k5 == 6) {
                this.f18728a.k((byte) 7);
            } else if (k5 == 4) {
                if (this.f18730c) {
                    this.f18728a.k((byte) 7);
                } else {
                    z.h(this.f18728a, (String) null, 1, (Object) null);
                    throw new C2219h();
                }
            }
            return new z(linkedHashMap);
        }
        C2131a.x(this.f18728a, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
        throw new C2219h();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(W2.C2214c r20, b3.C2308e r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            boolean r2 = r1 instanceof N3.J.b
            if (r2 == 0) goto L_0x0017
            r2 = r1
            N3.J$b r2 = (N3.J.b) r2
            int r3 = r2.f18741g
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f18741g = r3
            goto L_0x001c
        L_0x0017:
            N3.J$b r2 = new N3.J$b
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f18739e
            java.lang.Object r3 = c3.C2316b.f()
            int r4 = r2.f18741g
            r5 = 6
            r6 = 7
            r7 = 4
            r8 = 1
            if (r4 == 0) goto L_0x0048
            if (r4 != r8) goto L_0x0040
            java.lang.Object r4 = r2.f18738d
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r9 = r2.f18737c
            java.util.LinkedHashMap r9 = (java.util.LinkedHashMap) r9
            java.lang.Object r10 = r2.f18736b
            N3.J r10 = (N3.J) r10
            java.lang.Object r11 = r2.f18735a
            W2.c r11 = (W2.C2214c) r11
            W2.u.b(r1)
            goto L_0x00a0
        L_0x0040:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0048:
            W2.u.b(r1)
            N3.a r1 = r0.f18728a
            byte r1 = r1.k(r5)
            N3.a r4 = r0.f18728a
            byte r4 = r4.F()
            if (r4 == r7) goto L_0x00ee
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            r10 = r0
            r9 = r4
            r4 = r2
            r2 = r1
            r1 = r20
        L_0x0064:
            N3.a r11 = r10.f18728a
            boolean r11 = r11.e()
            if (r11 == 0) goto L_0x00c8
            boolean r2 = r10.f18729b
            if (r2 == 0) goto L_0x0077
            N3.a r2 = r10.f18728a
            java.lang.String r2 = r2.q()
            goto L_0x007d
        L_0x0077:
            N3.a r2 = r10.f18728a
            java.lang.String r2 = r2.o()
        L_0x007d:
            N3.a r11 = r10.f18728a
            r12 = 5
            r11.k(r12)
            W2.J r11 = W2.J.f19942a
            r4.f18735a = r1
            r4.f18736b = r10
            r4.f18737c = r9
            r4.f18738d = r2
            r4.f18741g = r8
            java.lang.Object r11 = r1.a(r11, r4)
            if (r11 != r3) goto L_0x0096
            return r3
        L_0x0096:
            r18 = r11
            r11 = r1
            r1 = r18
            r18 = r4
            r4 = r2
            r2 = r18
        L_0x00a0:
            M3.h r1 = (M3.h) r1
            r9.put(r4, r1)
            N3.a r1 = r10.f18728a
            byte r1 = r1.j()
            if (r1 == r7) goto L_0x00c4
            if (r1 != r6) goto L_0x00b1
            r2 = r1
            goto L_0x00c8
        L_0x00b1:
            N3.a r12 = r10.f18728a
            r16 = 6
            r17 = 0
            java.lang.String r13 = "Expected end of the object or comma"
            r14 = 0
            r15 = 0
            N3.C2131a.x(r12, r13, r14, r15, r16, r17)
            W2.h r1 = new W2.h
            r1.<init>()
            throw r1
        L_0x00c4:
            r4 = r2
            r2 = r1
            r1 = r11
            goto L_0x0064
        L_0x00c8:
            if (r2 != r5) goto L_0x00d0
            N3.a r1 = r10.f18728a
            r1.k(r6)
            goto L_0x00e8
        L_0x00d0:
            if (r2 != r7) goto L_0x00e8
            boolean r1 = r10.f18730c
            if (r1 == 0) goto L_0x00dc
            N3.a r1 = r10.f18728a
            r1.k(r6)
            goto L_0x00e8
        L_0x00dc:
            N3.a r1 = r10.f18728a
            r2 = 0
            N3.z.h(r1, r2, r8, r2)
            W2.h r1 = new W2.h
            r1.<init>()
            throw r1
        L_0x00e8:
            M3.z r1 = new M3.z
            r1.<init>(r9)
            return r1
        L_0x00ee:
            N3.a r2 = r0.f18728a
            r6 = 6
            r7 = 0
            java.lang.String r3 = "Unexpected leading comma"
            r4 = 0
            r5 = 0
            N3.C2131a.x(r2, r3, r4, r5, r6, r7)
            W2.h r1 = new W2.h
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.J.i(W2.c, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final B j(boolean z4) {
        String q5;
        if (this.f18729b || !z4) {
            q5 = this.f18728a.q();
        } else {
            q5 = this.f18728a.o();
        }
        String str = q5;
        if (z4 || !t.a(str, "null")) {
            return new s(str, z4, (J3.f) null, 4, (C2633k) null);
        }
        return w.INSTANCE;
    }

    public final h e() {
        h hVar;
        byte F4 = this.f18728a.F();
        if (F4 == 1) {
            return j(true);
        }
        if (F4 == 0) {
            return j(false);
        }
        if (F4 == 6) {
            int i5 = this.f18731d + 1;
            this.f18731d = i5;
            if (i5 == 200) {
                hVar = g();
            } else {
                hVar = h();
            }
            this.f18731d--;
            return hVar;
        } else if (F4 == 8) {
            return f();
        } else {
            C2131a.x(this.f18728a, "Cannot read Json element because of unexpected " + C2132b.c(F4), 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
    }
}
