package com.uptodown.activities;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import java.util.ArrayList;
import java.util.Iterator;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.T;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import z2.O;
import z3.D;
import z3.F;
import z3.w;

public final class a0 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f14890a;

    /* renamed from: b  reason: collision with root package name */
    private final D f14891b;

    /* renamed from: c  reason: collision with root package name */
    private final w f14892c;

    /* renamed from: d  reason: collision with root package name */
    private final w f14893d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f14894a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f14895b;

        public a(boolean z4, boolean z5) {
            this.f14894a = z4;
            this.f14895b = z5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f14894a == aVar.f14894a && this.f14895b == aVar.f14895b;
        }

        public int hashCode() {
            return (androidx.privacysandbox.ads.adservices.adid.a.a(this.f14894a) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f14895b);
        }

        public String toString() {
            return "DownloadAllButtonData(hasUpdates=" + this.f14894a + ", allCompleted=" + this.f14895b + ')';
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f14896a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f14897b;

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList f14898c;

        /* renamed from: d  reason: collision with root package name */
        private final ArrayList f14899d;

        /* renamed from: e  reason: collision with root package name */
        private final a f14900e;

        public b(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, a aVar) {
            t.e(arrayList, "updates");
            t.e(arrayList2, "disabled");
            t.e(arrayList3, "ignored");
            t.e(arrayList4, "recentlyUpdated");
            t.e(aVar, "downloadAllButtonData");
            this.f14896a = arrayList;
            this.f14897b = arrayList2;
            this.f14898c = arrayList3;
            this.f14899d = arrayList4;
            this.f14900e = aVar;
        }

        public final ArrayList a() {
            return this.f14897b;
        }

        public final ArrayList b() {
            return this.f14898c;
        }

        public final ArrayList c() {
            return this.f14899d;
        }

        public final ArrayList d() {
            return this.f14896a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return t.a(this.f14896a, bVar.f14896a) && t.a(this.f14897b, bVar.f14897b) && t.a(this.f14898c, bVar.f14898c) && t.a(this.f14899d, bVar.f14899d) && t.a(this.f14900e, bVar.f14900e);
        }

        public int hashCode() {
            return (((((((this.f14896a.hashCode() * 31) + this.f14897b.hashCode()) * 31) + this.f14898c.hashCode()) * 31) + this.f14899d.hashCode()) * 31) + this.f14900e.hashCode();
        }

        public String toString() {
            return "UpdatesData(updates=" + this.f14896a + ", disabled=" + this.f14897b + ", ignored=" + this.f14898c + ", recentlyUpdated=" + this.f14899d + ", downloadAllButtonData=" + this.f14900e + ')';
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f14901a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f14902b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a0 f14903c;

        /* renamed from: d  reason: collision with root package name */
        int f14904d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a0 a0Var, C2308e eVar) {
            super(eVar);
            this.f14903c = a0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.f14902b = obj;
            this.f14904d |= Integer.MIN_VALUE;
            return this.f14903c.d((Context) null, (ArrayList) null, false, this);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14905a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f14906b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f14907c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f14908d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ I f14909e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(boolean z4, ArrayList arrayList, Context context, I i5, C2308e eVar) {
            super(2, eVar);
            this.f14906b = z4;
            this.f14907c = arrayList;
            this.f14908d = context;
            this.f14909e = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14906b, this.f14907c, this.f14908d, this.f14909e, eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x003d A[EDGE_INSN: B:18:0x003d->B:12:0x003d ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x001f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r3) {
            /*
                r2 = this;
                c3.C2316b.f()
                int r0 = r2.f14905a
                if (r0 != 0) goto L_0x0040
                W2.u.b(r3)
                boolean r3 = r2.f14906b
                if (r3 == 0) goto L_0x003d
                java.util.ArrayList r3 = r2.f14907c
                java.util.Iterator r3 = r3.iterator()
                java.lang.String r0 = "iterator(...)"
                kotlin.jvm.internal.t.d(r3, r0)
            L_0x0019:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x003d
                java.lang.Object r0 = r3.next()
                java.lang.String r1 = "next(...)"
                kotlin.jvm.internal.t.d(r0, r1)
                l2.T r0 = (l2.T) r0
                android.content.Context r1 = r2.f14908d
                l2.q r0 = r0.b(r1)
                if (r0 == 0) goto L_0x0038
                boolean r0 = r0.f()
                if (r0 != 0) goto L_0x0019
            L_0x0038:
                kotlin.jvm.internal.I r3 = r2.f14909e
                r0 = 0
                r3.f24687a = r0
            L_0x003d:
                W2.J r3 = W2.J.f19942a
                return r3
            L_0x0040:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.a0.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f14910a;

        /* renamed from: b  reason: collision with root package name */
        Object f14911b;

        /* renamed from: c  reason: collision with root package name */
        Object f14912c;

        /* renamed from: d  reason: collision with root package name */
        Object f14913d;

        /* renamed from: e  reason: collision with root package name */
        Object f14914e;

        /* renamed from: f  reason: collision with root package name */
        boolean f14915f;

        /* renamed from: g  reason: collision with root package name */
        int f14916g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f14917h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ a0 f14918i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Context f14919j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(boolean z4, a0 a0Var, Context context, C2308e eVar) {
            super(2, eVar);
            this.f14917h = z4;
            this.f14918i = a0Var;
            this.f14919j = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f14917h, this.f14918i, this.f14919j, eVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:56:0x01e1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) {
            /*
                r23 = this;
                r0 = r23
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.f14916g
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0053
                if (r2 == r4) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                boolean r1 = r0.f14915f
                java.lang.Object r2 = r0.f14913d
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                java.lang.Object r3 = r0.f14912c
                java.util.ArrayList r3 = (java.util.ArrayList) r3
                java.lang.Object r4 = r0.f14911b
                java.util.ArrayList r4 = (java.util.ArrayList) r4
                java.lang.Object r5 = r0.f14910a
                java.util.ArrayList r5 = (java.util.ArrayList) r5
                W2.u.b(r24)
                r7 = r24
                r9 = r2
                r11 = r4
            L_0x0029:
                r12 = r3
                r10 = r5
                goto L_0x01e6
            L_0x002d:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0035:
                java.lang.Object r2 = r0.f14914e
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                java.lang.Object r4 = r0.f14913d
                java.util.ArrayList r4 = (java.util.ArrayList) r4
                java.lang.Object r5 = r0.f14912c
                java.util.ArrayList r5 = (java.util.ArrayList) r5
                java.lang.Object r6 = r0.f14911b
                java.util.ArrayList r6 = (java.util.ArrayList) r6
                java.lang.Object r7 = r0.f14910a
                java.util.ArrayList r7 = (java.util.ArrayList) r7
                W2.u.b(r24)
                r10 = r2
                r3 = r5
                r2 = r24
            L_0x0050:
                r5 = r7
                goto L_0x01c0
            L_0x0053:
                W2.u.b(r24)
                boolean r2 = r0.f14917h
                if (r2 == 0) goto L_0x0065
                com.uptodown.activities.a0 r2 = r0.f14918i
                z3.w r2 = r2.f14890a
                z2.O$a r5 = z2.O.a.f26507a
                r2.setValue(r5)
            L_0x0065:
                z2.m r2 = new z2.m
                r2.<init>()
                android.content.Context r5 = r0.f14919j
                java.util.ArrayList r2 = r2.D(r5)
                z2.B$a r5 = z2.C2940B.f26458v
                android.content.Context r6 = r0.f14919j
                z2.B r5 = r5.a(r6)
                r5.a()
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                java.util.Iterator r2 = r2.iterator()
                java.lang.String r10 = "iterator(...)"
                kotlin.jvm.internal.t.d(r2, r10)
            L_0x0098:
                boolean r10 = r2.hasNext()
                if (r10 == 0) goto L_0x0132
                java.lang.Object r10 = r2.next()
                java.lang.String r11 = "next(...)"
                kotlin.jvm.internal.t.d(r10, r11)
                l2.d r10 = (l2.C2655d) r10
                long r11 = r10.b()
                r13 = 0
                int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r11 <= 0) goto L_0x0098
                android.content.Context r11 = r0.f14919j
                boolean r11 = r10.C(r11)
                if (r11 == 0) goto L_0x0098
                int r11 = r10.e()
                if (r11 != r4) goto L_0x00ce
                l2.d$c r11 = l2.C2655d.c.OUTDATED
                r10.c0(r11)
                boolean r10 = r8.add(r10)
                kotlin.coroutines.jvm.internal.b.a(r10)
                goto L_0x0098
            L_0x00ce:
                java.lang.String r11 = r10.o()
                kotlin.jvm.internal.t.b(r11)
                l2.T r11 = r5.G0(r11)
                if (r11 != 0) goto L_0x00ea
                boolean r12 = r10.D()
                if (r12 == 0) goto L_0x0122
                l2.d$c r12 = l2.C2655d.c.UPDATED
                r10.c0(r12)
                r9.add(r10)
                goto L_0x0122
            L_0x00ea:
                int r12 = r11.e()
                if (r12 != r4) goto L_0x00f8
                boolean r10 = r8.add(r10)
                kotlin.coroutines.jvm.internal.b.a(r10)
                goto L_0x0122
            L_0x00f8:
                l2.d$c r12 = l2.C2655d.c.OUTDATED
                r10.c0(r12)
                b2.j r12 = new b2.j
                r12.<init>()
                android.content.Context r13 = r0.f14919j
                java.lang.String r14 = r10.o()
                kotlin.jvm.internal.t.b(r14)
                boolean r12 = r12.p(r13, r14)
                if (r12 == 0) goto L_0x0119
                boolean r10 = r7.add(r10)
                kotlin.coroutines.jvm.internal.b.a(r10)
                goto L_0x0122
            L_0x0119:
                int r12 = r11.e()
                if (r12 != 0) goto L_0x0122
                r6.add(r10)
            L_0x0122:
                if (r11 == 0) goto L_0x0098
                int r10 = r11.g()
                if (r10 != 0) goto L_0x0098
                r11.s(r4)
                r5.C1(r11)
                goto L_0x0098
            L_0x0132:
                z2.m$a r2 = z2.C2954m.f26533a
                android.content.Context r10 = r0.f14919j
                r2.l(r6, r10)
                r2.q(r9)
                android.content.Context r10 = r0.f14919j
                r2.l(r8, r10)
                android.content.Context r10 = r0.f14919j
                r2.l(r7, r10)
                java.util.ArrayList r2 = r5.I0()
                r5.m()
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                int r11 = r2.size()
                r13 = 0
            L_0x015c:
                if (r13 >= r11) goto L_0x01a5
                java.lang.Object r14 = r2.get(r13)
                int r13 = r13 + 1
                l2.T r14 = (l2.T) r14
                int r15 = r6.size()
                r12 = 0
            L_0x016b:
                if (r12 >= r15) goto L_0x015c
                java.lang.Object r16 = r6.get(r12)
                int r12 = r12 + 1
                l2.d r16 = (l2.C2655d) r16
                java.lang.String r3 = r14.h()
                java.lang.String r4 = r16.o()
                boolean r3 = kotlin.jvm.internal.t.a(r3, r4)
                if (r3 == 0) goto L_0x019c
                r10.add(r14)
                r3 = r15
                R1.L$a r15 = new R1.L$a
                r21 = 28
                r22 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r17 = r14
                r15.<init>(r16, r17, r18, r19, r20, r21, r22)
                r5.add(r15)
                goto L_0x019f
            L_0x019c:
                r17 = r14
                r3 = r15
            L_0x019f:
                r15 = r3
                r14 = r17
                r3 = 2
                r4 = 1
                goto L_0x016b
            L_0x01a5:
                com.uptodown.activities.a0 r3 = r0.f14918i
                r0.f14910a = r7
                r0.f14911b = r8
                r0.f14912c = r9
                r0.f14913d = r5
                r0.f14914e = r10
                r4 = 1
                r0.f14916g = r4
                java.lang.Object r2 = r3.i(r2, r6, r0)
                if (r2 != r1) goto L_0x01bb
                goto L_0x01e0
            L_0x01bb:
                r4 = r5
                r6 = r8
                r3 = r9
                goto L_0x0050
            L_0x01c0:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                com.uptodown.activities.a0 r7 = r0.f14918i
                android.content.Context r8 = r0.f14919j
                r0.f14910a = r5
                r0.f14911b = r6
                r0.f14912c = r3
                r0.f14913d = r4
                r9 = 0
                r0.f14914e = r9
                r0.f14915f = r2
                r9 = 2
                r0.f14916g = r9
                java.lang.Object r7 = r7.d(r8, r10, r2, r0)
                if (r7 != r1) goto L_0x01e1
            L_0x01e0:
                return r1
            L_0x01e1:
                r1 = r2
                r9 = r4
                r11 = r6
                goto L_0x0029
            L_0x01e6:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r2 = r7.booleanValue()
                com.uptodown.activities.a0 r3 = r0.f14918i
                z3.w r3 = r3.f14890a
                z2.O$c r4 = new z2.O$c
                com.uptodown.activities.a0$b r8 = new com.uptodown.activities.a0$b
                com.uptodown.activities.a0$a r13 = new com.uptodown.activities.a0$a
                r13.<init>(r1, r2)
                r8.<init>(r9, r10, r11, r12, r13)
                r4.<init>(r8)
                r3.setValue(r4)
                W2.J r1 = W2.J.f19942a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.a0.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f14920a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f14921b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a0 f14922c;

        /* renamed from: d  reason: collision with root package name */
        int f14923d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a0 a0Var, C2308e eVar) {
            super(eVar);
            this.f14922c = a0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.f14921b = obj;
            this.f14923d |= Integer.MIN_VALUE;
            return this.f14922c.i((ArrayList) null, (ArrayList) null, this);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14924a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f14925b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f14926c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f14927d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, C2308e eVar) {
            super(2, eVar);
            this.f14925b = arrayList;
            this.f14926c = arrayList2;
            this.f14927d = arrayList3;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f14925b, this.f14926c, this.f14927d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14924a == 0) {
                u.b(obj);
                ArrayList arrayList = new ArrayList(this.f14925b);
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Iterator it = this.f14926c.iterator();
                    t.d(it, "iterator(...)");
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        t.d(next, "next(...)");
                        T t5 = (T) next;
                        String o5 = ((C2655d) arrayList.get(i5)).o();
                        if (o5 != null && s.E(o5, t5.h(), true) && ((C2655d) arrayList.get(i5)).e() == 0) {
                            this.f14927d.add(t5);
                            break;
                        }
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public a0() {
        w a5 = F.a(O.a.f26507a);
        this.f14890a = a5;
        this.f14891b = a5;
        Boolean bool = Boolean.FALSE;
        this.f14892c = F.a(bool);
        this.f14893d = F.a(bool);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(android.content.Context r11, java.util.ArrayList r12, boolean r13, b3.C2308e r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.uptodown.activities.a0.c
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.uptodown.activities.a0$c r0 = (com.uptodown.activities.a0.c) r0
            int r1 = r0.f14904d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f14904d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.a0$c r0 = new com.uptodown.activities.a0$c
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f14902b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f14904d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r11 = r0.f14901a
            kotlin.jvm.internal.I r11 = (kotlin.jvm.internal.I) r11
            W2.u.b(r14)
            goto L_0x0058
        L_0x002d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0035:
            W2.u.b(r14)
            kotlin.jvm.internal.I r8 = new kotlin.jvm.internal.I
            r8.<init>()
            r8.f24687a = r3
            w3.I r14 = w3.C2865c0.b()
            com.uptodown.activities.a0$d r4 = new com.uptodown.activities.a0$d
            r9 = 0
            r7 = r11
            r6 = r12
            r5 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f14901a = r8
            r0.f14904d = r3
            java.lang.Object r11 = w3.C2872g.g(r14, r4, r0)
            if (r11 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r11 = r8
        L_0x0058:
            boolean r11 = r11.f24687a
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.b.a(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.a0.d(android.content.Context, java.util.ArrayList, boolean, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(java.util.ArrayList r7, java.util.ArrayList r8, b3.C2308e r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.uptodown.activities.a0.f
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.uptodown.activities.a0$f r0 = (com.uptodown.activities.a0.f) r0
            int r1 = r0.f14923d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f14923d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.a0$f r0 = new com.uptodown.activities.a0$f
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f14921b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f14923d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r7 = r0.f14920a
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            W2.u.b(r9)
            goto L_0x0053
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            W2.u.b(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            w3.I r2 = w3.C2865c0.b()
            com.uptodown.activities.a0$g r4 = new com.uptodown.activities.a0$g
            r5 = 0
            r4.<init>(r8, r7, r9, r5)
            r0.f14920a = r9
            r0.f14923d = r3
            java.lang.Object r7 = w3.C2872g.g(r2, r4, r0)
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            r7 = r9
        L_0x0053:
            int r7 = r7.size()
            if (r7 <= 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r3 = 0
        L_0x005b:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.a0.i(java.util.ArrayList, java.util.ArrayList, b3.e):java.lang.Object");
    }

    public final void e(Context context, boolean z4) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new e(z4, this, context, (C2308e) null), 2, (Object) null);
    }

    public final w f() {
        return this.f14893d;
    }

    public final D g() {
        return this.f14891b;
    }

    public final w h() {
        return this.f14892c;
    }
}
