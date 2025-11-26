package z2;

import W2.J;
import W2.u;
import X2.C2250q;
import a3.C2265a;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import b2.C2286f;
import b2.C2289i;
import b2.C2301u;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import java.io.File;
import java.lang.Character;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2673w;
import l2.T;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.M;

/* renamed from: z2.m  reason: case insensitive filesystem */
public final class C2954m {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26533a = new a((C2633k) null);

    /* renamed from: z2.m$a */
    public static final class a {

        /* renamed from: z2.m$a$a  reason: collision with other inner class name */
        public static final class C0265a implements Comparator {
            public final int compare(Object obj, Object obj2) {
                boolean z4;
                C2655d.c w4 = ((C2655d) obj).w();
                C2655d.c cVar = C2655d.c.OUTDATED;
                boolean z5 = false;
                if (w4 != cVar) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Boolean valueOf = Boolean.valueOf(z4);
                if (((C2655d) obj2).w() != cVar) {
                    z5 = true;
                }
                return C2265a.a(valueOf, Boolean.valueOf(z5));
            }
        }

        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private final void h(ArrayList arrayList, Context context) {
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            ArrayList I02 = a5.I0();
            a5.m();
            Iterator it = I02.iterator();
            t.d(it, "iterator(...)");
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                t.d(next, "next(...)");
                T t5 = (T) next;
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    long A4 = ((C2655d) arrayList.get(i5)).A();
                    if (s.E(t5.h(), ((C2655d) arrayList.get(i5)).o(), true) && t5.j() > A4) {
                        ((C2655d) arrayList.get(i5)).c0(C2655d.c.OUTDATED);
                    }
                }
            }
            int size2 = arrayList.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj = arrayList.get(i6);
                i6++;
                C2655d dVar = (C2655d) obj;
                int size3 = I02.size();
                int i7 = 0;
                while (i7 < size3) {
                    Object obj2 = I02.get(i7);
                    i7++;
                    T t6 = (T) obj2;
                    if (dVar.e() == 1 || (t.a(dVar.o(), t6.h()) && t6.m())) {
                        dVar.c0(C2655d.c.UPDATED);
                    }
                }
            }
            C2250q.t(arrayList, new C0265a());
            int i8 = 0;
            while (i8 < arrayList.size() && (!s.E(context.getPackageName(), ((C2655d) arrayList.get(i8)).o(), true) || ((C2655d) arrayList.get(i8)).w() != C2655d.c.OUTDATED)) {
                i8++;
            }
            if (i8 < arrayList.size()) {
                Object remove = arrayList.remove(i8);
                t.d(remove, "removeAt(...)");
                arrayList.add(0, (C2655d) remove);
            }
        }

        /* access modifiers changed from: private */
        public static final int j(C2655d dVar, C2655d dVar2) {
            t.e(dVar, "app1");
            t.e(dVar2, "app2");
            return t.h(dVar2.j(), dVar.j());
        }

        /* access modifiers changed from: private */
        public static final int k(p pVar, Object obj, Object obj2) {
            return ((Number) pVar.invoke(obj, obj2)).intValue();
        }

        /* access modifiers changed from: private */
        public static final int m(C2655d dVar, C2655d dVar2) {
            t.e(dVar, "app1");
            t.e(dVar2, "app2");
            if (dVar.m() == null) {
                return 1;
            }
            if (dVar2.m() == null) {
                return -1;
            }
            String m5 = dVar.m();
            t.b(m5);
            String m6 = dVar2.m();
            t.b(m6);
            return s.x(m5, m6, true);
        }

        /* access modifiers changed from: private */
        public static final int o(C2655d dVar, C2655d dVar2) {
            t.e(dVar, "app1");
            t.e(dVar2, "app2");
            return t.h(dVar2.t(), dVar.t());
        }

        /* access modifiers changed from: private */
        public static final int p(p pVar, Object obj, Object obj2) {
            return ((Number) pVar.invoke(obj, obj2)).intValue();
        }

        /* access modifiers changed from: private */
        public static final int r(C2655d dVar, C2655d dVar2) {
            t.e(dVar, "app1");
            t.e(dVar2, "app2");
            return t.h(dVar2.j(), dVar.j());
        }

        /* access modifiers changed from: private */
        public static final int s(p pVar, Object obj, Object obj2) {
            return ((Number) pVar.invoke(obj, obj2)).intValue();
        }

        public final void i(ArrayList arrayList, Context context) {
            t.e(arrayList, "tmpUserApps");
            t.e(context, "context");
            C2250q.t(arrayList, new C2951j(new C2950i()));
            h(arrayList, context);
        }

        public final void l(ArrayList arrayList, Context context) {
            t.e(arrayList, "tmpUserApps");
            t.e(context, "context");
            C2250q.t(arrayList, new C2949h());
            h(arrayList, context);
        }

        public final void n(ArrayList arrayList, Context context) {
            t.e(arrayList, "tmpUserApps");
            t.e(context, "context");
            C2250q.t(arrayList, new C2953l(new C2952k()));
            h(arrayList, context);
        }

        public final void q(ArrayList arrayList) {
            t.e(arrayList, "tmpUserApps");
            C2250q.t(arrayList, new C2948g(new C2947f()));
        }

        private a() {
        }
    }

    /* renamed from: z2.m$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f26534a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2655d f26535b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PackageManager f26536c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2940B f26537d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2655d dVar, PackageManager packageManager, C2940B b5, C2308e eVar) {
            super(2, eVar);
            this.f26535b = dVar;
            this.f26536c = packageManager;
            this.f26537d = b5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f26535b, this.f26536c, this.f26537d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            ArrayList a02;
            ApplicationInfo applicationInfo;
            C2316b.f();
            if (this.f26534a == 0) {
                u.b(obj);
                if (this.f26535b.f() == 0) {
                    try {
                        PackageManager packageManager = this.f26536c;
                        String o5 = this.f26535b.o();
                        t.b(o5);
                        applicationInfo = C2301u.a(packageManager, o5, 128);
                    } catch (PackageManager.NameNotFoundException unused) {
                        applicationInfo = null;
                    }
                    if (this.f26535b.r() == null && this.f26535b.f() == 0) {
                        if (applicationInfo != null) {
                            this.f26535b.Z(C2286f.f20690a.e(applicationInfo.sourceDir));
                        }
                        if (this.f26535b.r() != null) {
                            this.f26537d.B1(this.f26535b);
                        } else {
                            this.f26535b.O(1);
                            this.f26537d.z1(this.f26535b);
                        }
                    }
                }
                if (this.f26535b.f() == 0 && (a02 = this.f26537d.a0(this.f26535b)) != null) {
                    Iterator it = a02.iterator();
                    t.d(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        t.d(next, "next(...)");
                        C2673w wVar = (C2673w) next;
                        if (wVar.a() != null && wVar.c() == null) {
                            C2286f fVar = C2286f.f20690a;
                            String a5 = wVar.a();
                            t.b(a5);
                            wVar.f(fVar.e(a5));
                            this.f26537d.A1(wVar);
                        }
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: z2.m$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f26538a;

        /* renamed from: b  reason: collision with root package name */
        Object f26539b;

        /* renamed from: c  reason: collision with root package name */
        Object f26540c;

        /* renamed from: d  reason: collision with root package name */
        int f26541d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f26542e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f26543f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ C2954m f26544g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, ArrayList arrayList, C2954m mVar, C2308e eVar) {
            super(2, eVar);
            this.f26542e = context;
            this.f26543f = arrayList;
            this.f26544g = mVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f26542e, this.f26543f, this.f26544g, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            PackageManager packageManager;
            C2940B b5;
            Iterator it;
            Object f5 = C2316b.f();
            int i5 = this.f26541d;
            if (i5 == 0) {
                u.b(obj);
                PackageManager packageManager2 = this.f26542e.getPackageManager();
                C2940B a5 = C2940B.f26458v.a(this.f26542e);
                a5.a();
                Iterator it2 = this.f26543f.iterator();
                t.d(it2, "iterator(...)");
                Iterator it3 = it2;
                b5 = a5;
                it = it3;
                packageManager = packageManager2;
            } else if (i5 == 1) {
                it = (Iterator) this.f26540c;
                b5 = (C2940B) this.f26539b;
                packageManager = (PackageManager) this.f26538a;
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                C2954m mVar = this.f26544g;
                t.b(packageManager);
                this.f26538a = packageManager;
                this.f26539b = b5;
                this.f26540c = it;
                this.f26541d = 1;
                if (mVar.e((C2655d) next, b5, packageManager, this) == f5) {
                    return f5;
                }
            }
            b5.m();
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: z2.m$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f26545a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f26546b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ApplicationInfo f26547c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, ApplicationInfo applicationInfo, C2308e eVar) {
            super(2, eVar);
            this.f26546b = context;
            this.f26547c = applicationInfo;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f26546b, this.f26547c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f26545a;
            if (i5 == 0) {
                u.b(obj);
                P p5 = P.f26510a;
                Context context = this.f26546b;
                String str = this.f26547c.packageName;
                this.f26545a = 1;
                if (p5.k(context, str, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final l2.C2655d B(android.content.pm.ApplicationInfo r26, l2.C2655d r27, android.content.pm.PackageInfo r28, z2.C2940B r29, android.content.Context r30, android.content.pm.PackageManager r31, boolean r32, boolean r33) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r8 = r33
            w3.I r9 = w3.C2865c0.b()
            w3.M r10 = w3.N.a(r9)
            z2.m$d r13 = new z2.m$d
            r9 = 0
            r13.<init>(r5, r1, r9)
            r14 = 3
            r15 = 0
            r11 = 0
            r12 = 0
            w3.C2908y0 unused = w3.C2876i.d(r10, r11, r12, r13, r14, r15)
            b2.j r10 = new b2.j
            r10.<init>()
            long r10 = r10.m(r3)
            if (r2 == 0) goto L_0x003b
            long r12 = r2.A()
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            goto L_0x003c
        L_0x003b:
            r12 = r9
        L_0x003c:
            r15 = 0
            java.lang.String r9 = "com.android.vending.archive"
            r18 = 0
            r19 = -1
            r13 = -1
            r14 = 1
            if (r12 == 0) goto L_0x01a1
            long r21 = r2.A()
            int r12 = (r21 > r10 ? 1 : (r21 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0052
            goto L_0x01a1
        L_0x0052:
            java.lang.String r10 = r2.k()
            if (r10 != 0) goto L_0x0080
            java.lang.String r7 = r2.o()
            if (r7 == 0) goto L_0x0071
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0065
            goto L_0x0071
        L_0x0065:
            java.lang.String r7 = r2.o()
            kotlin.jvm.internal.t.b(r7)
            java.lang.String r9 = r0.i(r6, r7)
            goto L_0x0072
        L_0x0071:
            r9 = 0
        L_0x0072:
            if (r9 == 0) goto L_0x0079
            r2.U(r9)
            r6 = r14
            goto L_0x00c0
        L_0x0079:
            r2.O(r14)
            r4.z1(r2)
            goto L_0x00be
        L_0x0080:
            java.lang.String r6 = r2.o()
            boolean r6 = r0.z(r6)
            if (r6 != 0) goto L_0x0097
            int r6 = r2.f()
            if (r6 != 0) goto L_0x00be
            r2.O(r14)
            r4.z1(r2)
            goto L_0x00be
        L_0x0097:
            android.os.Bundle r6 = r1.metaData
            if (r6 == 0) goto L_0x00ae
            boolean r6 = r6.getBoolean(r9)
            if (r6 != r14) goto L_0x00ae
            int r6 = r2.f()
            if (r6 != 0) goto L_0x00be
            r2.O(r14)
            r4.z1(r2)
            goto L_0x00be
        L_0x00ae:
            int r6 = r2.f()
            r2.P(r7, r8)
            int r7 = r2.f()
            if (r6 == r7) goto L_0x00be
            r4.z1(r2)
        L_0x00be:
            r6 = r18
        L_0x00c0:
            java.lang.String r7 = r2.c()
            if (r7 != 0) goto L_0x00ca
            r0.F(r2, r3, r5)
            r6 = r14
        L_0x00ca:
            long r7 = r2.t()
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 != 0) goto L_0x00da
            long r6 = r25.d(r26)
            r2.b0(r6)
            r6 = r14
        L_0x00da:
            if (r6 == 0) goto L_0x00df
            r4.y1(r2)
        L_0x00df:
            java.lang.String r6 = r3.versionName
            r2.i0(r6)
            long r6 = r3.lastUpdateTime
            r2.T(r6)
            long r6 = r3.firstInstallTime
            r2.Q(r6)
            long r6 = r2.i()
            int r3 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x028c
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.J(r1, r4)
            java.util.ArrayList r1 = r2.v()
            if (r1 == 0) goto L_0x011b
            java.util.ArrayList r1 = r2.v()
            kotlin.jvm.internal.t.b(r1)
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x011b
            java.util.ArrayList r1 = r2.v()
            kotlin.jvm.internal.t.b(r1)
            r3.addAll(r1)
        L_0x011b:
            r2.I(r4)
            java.util.ArrayList r1 = r2.n()
            if (r1 == 0) goto L_0x013b
            java.util.ArrayList r1 = r2.n()
            kotlin.jvm.internal.t.b(r1)
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x013b
            java.util.ArrayList r1 = r2.n()
            kotlin.jvm.internal.t.b(r1)
            r3.addAll(r1)
        L_0x013b:
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x028c
            long r6 = r2.i()
            java.util.ArrayList r1 = r4.Z(r6)
            java.util.Iterator r1 = r1.iterator()
            java.lang.String r6 = "iterator(...)"
            kotlin.jvm.internal.t.d(r1, r6)
        L_0x0152:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x028c
            java.lang.Object r6 = r1.next()
            java.lang.String r7 = "next(...)"
            kotlin.jvm.internal.t.d(r6, r7)
            l2.w r6 = (l2.C2673w) r6
            java.util.Iterator r7 = r3.iterator()
            r8 = r18
        L_0x0169:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0194
            int r9 = r8 + 1
            java.lang.Object r10 = r7.next()
            l2.w r10 = (l2.C2673w) r10
            java.lang.String r11 = r6.a()
            java.lang.String r12 = r10.a()
            boolean r11 = t3.s.E(r11, r12, r14)
            if (r11 == 0) goto L_0x0192
            long r11 = r6.d()
            long r15 = r10.d()
            int r10 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r10 != 0) goto L_0x0192
            goto L_0x0195
        L_0x0192:
            r8 = r9
            goto L_0x0169
        L_0x0194:
            r8 = r13
        L_0x0195:
            if (r8 != r13) goto L_0x019b
            r4.v(r6)
            goto L_0x0152
        L_0x019b:
            if (r8 <= r13) goto L_0x0152
            r3.remove(r8)
            goto L_0x0152
        L_0x01a1:
            if (r2 == 0) goto L_0x01ba
            int r12 = r2.e()
            int r17 = r2.f()
            r21 = r15
            java.lang.String r15 = r2.o()
            kotlin.jvm.internal.t.b(r15)
            r4.t(r15)
            r15 = r17
            goto L_0x01be
        L_0x01ba:
            r21 = r15
            r12 = r13
            r15 = r12
        L_0x01be:
            l2.d r14 = new l2.d
            r14.<init>()
            if (r2 == 0) goto L_0x01d4
            long r23 = r2.b()
            int r17 = (r23 > r21 ? 1 : (r23 == r21 ? 0 : -1))
            if (r17 <= 0) goto L_0x01d4
            long r7 = r2.b()
            r14.K(r7)
        L_0x01d4:
            if (r12 == r13) goto L_0x01d9
            r14.N(r12)
        L_0x01d9:
            if (r15 == r13) goto L_0x01de
            r14.O(r15)
        L_0x01de:
            java.lang.String r2 = r1.packageName
            r14.W(r2)
            int r2 = r14.f()
            if (r2 != 0) goto L_0x01f8
            java.lang.String r2 = r14.o()
            boolean r2 = r0.z(r2)
            if (r2 != 0) goto L_0x01f8
            r2 = 1
            r14.O(r2)
            goto L_0x01f9
        L_0x01f8:
            r2 = 1
        L_0x01f9:
            b2.j r7 = new b2.j
            r7.<init>()
            boolean r7 = r7.r(r3)
            if (r7 == 0) goto L_0x0207
            r14.d0(r2)
        L_0x0207:
            java.lang.String r7 = r14.o()
            boolean r7 = r0.y(r7, r6)
            if (r7 == 0) goto L_0x0214
            r14.e0(r2)
        L_0x0214:
            r14.h0(r10)
            java.lang.String r2 = r3.versionName
            r14.i0(r2)
            long r7 = r3.lastUpdateTime
            r14.T(r7)
            long r7 = r3.firstInstallTime
            r14.Q(r7)
            r0.F(r14, r3, r5)
            java.lang.String r2 = r14.o()
            if (r2 == 0) goto L_0x0239
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0236
            goto L_0x0239
        L_0x0236:
            r2 = r18
            goto L_0x023a
        L_0x0239:
            r2 = 1
        L_0x023a:
            if (r2 != 0) goto L_0x024a
            java.lang.String r2 = r14.o()
            kotlin.jvm.internal.t.b(r2)
            java.lang.String r2 = r0.i(r6, r2)
            r14.U(r2)
        L_0x024a:
            java.lang.String r2 = r14.k()
            if (r2 != 0) goto L_0x0255
            r2 = 1
            r14.O(r2)
            goto L_0x0256
        L_0x0255:
            r2 = 1
        L_0x0256:
            int r3 = r14.f()
            if (r3 != 0) goto L_0x026d
            android.os.Bundle r3 = r1.metaData
            if (r3 == 0) goto L_0x0268
            boolean r3 = r3.getBoolean(r9)
            if (r3 != r2) goto L_0x0268
            r18 = r2
        L_0x0268:
            if (r18 == 0) goto L_0x026d
            r14.O(r2)
        L_0x026d:
            int r2 = r14.f()
            if (r2 != 0) goto L_0x027a
            r7 = r32
            r8 = r33
            r14.P(r7, r8)
        L_0x027a:
            l2.d r2 = r4.M0(r14)
            long r6 = r2.i()
            int r3 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r3 <= 0) goto L_0x028c
            r2.J(r1, r4)
            r2.I(r4)
        L_0x028c:
            java.lang.String r1 = r2.o()
            if (r1 == 0) goto L_0x02a5
            b2.j r1 = new b2.j
            r1.<init>()
            java.lang.String r3 = r2.o()
            kotlin.jvm.internal.t.b(r3)
            boolean r1 = r1.p(r5, r3)
            r2.M(r1)
        L_0x02a5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.C2954m.B(android.content.pm.ApplicationInfo, l2.d, android.content.pm.PackageInfo, z2.B, android.content.Context, android.content.pm.PackageManager, boolean, boolean):l2.d");
    }

    private final boolean E(String str) {
        if (s.P(str, "com.miui.", false, 2, (Object) null) || s.P(str, "com.xiaomi.", false, 2, (Object) null)) {
            return true;
        }
        return false;
    }

    private final String G(String str) {
        Normalizer.Form form = Normalizer.Form.NFD;
        if (Normalizer.isNormalized(str, form)) {
            return str;
        }
        return new t3.p("[\\p{InCombiningDiacriticalMarks}]").h(Normalizer.normalize(str, form), "");
    }

    /* access modifiers changed from: private */
    public final Object e(C2655d dVar, C2940B b5, PackageManager packageManager, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(dVar, packageManager, b5, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final byte[] l(PackageManager packageManager, String str) {
        boolean z4;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo a5 = C2301u.d(packageManager, str, 134217728).signingInfo;
                if (a5 == null) {
                    return null;
                }
                if (a5.hasPastSigningCertificates()) {
                    Signature[] a6 = a5.getSigningCertificateHistory();
                    t.d(a6, "getSigningCertificateHistory(...)");
                    if (a6.length == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        return a5.getSigningCertificateHistory()[a5.getSigningCertificateHistory().length - 1].toByteArray();
                    }
                }
                Signature[] a7 = a5.getApkContentsSigners();
                if (a7 == null) {
                    return null;
                }
                if (a7.length == 0) {
                    return null;
                }
                return a7[0].toByteArray();
            }
            Signature[] signatureArr = C2301u.d(packageManager, str, 64).signatures;
            if (signatureArr == null) {
                return null;
            }
            if (signatureArr.length == 0) {
                return null;
            }
            return signatureArr[0].toByteArray();
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private final String m(PackageManager packageManager, String str, String str2) {
        byte[] l5 = l(packageManager, str);
        if (l5 == null) {
            return null;
        }
        if (t.a(str2, SameMD5.TAG)) {
            return C2286f.f20690a.g(l5);
        }
        if (t.a(str2, "SHA256")) {
            return C2286f.f20690a.d(l5);
        }
        return null;
    }

    private final ArrayList n(PackageManager packageManager, String str) {
        boolean z4;
        ArrayList arrayList = new ArrayList();
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo a5 = C2301u.d(packageManager, str, 134217728).signingInfo;
                if (a5 != null) {
                    if (a5.hasPastSigningCertificates()) {
                        Signature[] a6 = a5.getSigningCertificateHistory();
                        t.d(a6, "getSigningCertificateHistory(...)");
                        if (a6.length == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4) {
                            Iterator a7 = C2625c.a(a5.getSigningCertificateHistory());
                            while (a7.hasNext()) {
                                arrayList.add(((Signature) a7.next()).toByteArray());
                            }
                        }
                    }
                    Signature[] a8 = a5.getApkContentsSigners();
                    if (a8 != null) {
                        if (a8.length != 0) {
                            Iterator a9 = C2625c.a(a8);
                            while (a9.hasNext()) {
                                arrayList.add(((Signature) a9.next()).toByteArray());
                            }
                        }
                    }
                    return arrayList;
                }
            } else {
                Signature[] signatureArr = C2301u.d(packageManager, str, 64).signatures;
                if (signatureArr != null) {
                    if (signatureArr.length != 0) {
                        Iterator a10 = C2625c.a(signatureArr);
                        while (a10.hasNext()) {
                            arrayList.add(((Signature) a10.next()).toByteArray());
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            return arrayList;
        }
    }

    private final ArrayList o(PackageManager packageManager, String str, String str2) {
        String d5;
        ArrayList arrayList = new ArrayList();
        Iterator it = n(packageManager, str).iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            byte[] bArr = (byte[]) next;
            if (t.a(str2, SameMD5.TAG)) {
                String g5 = C2286f.f20690a.g(bArr);
                if (g5 != null) {
                    arrayList.add(g5);
                }
            } else if (t.a(str2, "SHA256") && (d5 = C2286f.f20690a.d(bArr)) != null) {
                arrayList.add(d5);
            }
        }
        return arrayList;
    }

    private final long p(String str) {
        try {
            return new C2289i().l(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str + '/'));
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    private final long q(String str) {
        try {
            return new C2289i().l(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/" + str + '/'));
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static final int s(String str, String str2) {
        t.e(str, "app1");
        t.e(str2, "app2");
        return s.x(str, str2, true);
    }

    /* access modifiers changed from: private */
    public static final int t(p pVar, Object obj, Object obj2) {
        return ((Number) pVar.invoke(obj, obj2)).intValue();
    }

    private final boolean w(int i5) {
        if (Build.VERSION.SDK_INT < 24) {
            return Character.isIdeographic(i5);
        }
        if (Character.UnicodeScript.of(i5) == Character.UnicodeScript.HAN) {
            return true;
        }
        return false;
    }

    private final boolean x(C2655d dVar) {
        if (dVar.o() == null) {
            return false;
        }
        if (!dVar.F() && !dVar.H()) {
            return false;
        }
        String o5 = dVar.o();
        t.b(o5);
        if (E(o5)) {
            return true;
        }
        return false;
    }

    private final boolean y(String str, PackageManager packageManager) {
        if (str == null || packageManager.getLaunchIntentForPackage(str) == null) {
            return true;
        }
        return false;
    }

    public final boolean A(Context context) {
        t.e(context, "context");
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        if (s.E(str, "Xiaomi", true) || s.E(str2, "Xiaomi", true) || s.E(str, "Poco", true)) {
            return true;
        }
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        ArrayList d02 = a5.d0();
        a5.m();
        Iterator it = d02.iterator();
        t.d(it, "iterator(...)");
        int i5 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            if (x((C2655d) next) && (i5 = i5 + 1) > 5) {
                break;
            }
        }
        if (i5 > 5) {
            return true;
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    public final C2655d C(Context context, String str) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        t.e(context, "context");
        synchronized (UptodownApp.f13477F.h()) {
            C2655d dVar = null;
            if (str == null) {
                return null;
            }
            try {
                C2940B a5 = C2940B.f26458v.a(context);
                a5.a();
                PackageManager packageManager = context.getPackageManager();
                try {
                    PackageManager packageManager2 = context.getPackageManager();
                    t.d(packageManager2, "getPackageManager(...)");
                    packageInfo = C2301u.d(packageManager2, str, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
                    boolean h02 = aVar.h0(context);
                    boolean i02 = aVar.i0(context);
                    try {
                        PackageManager packageManager3 = context.getPackageManager();
                        t.d(packageManager3, "getPackageManager(...)");
                        applicationInfo = C2301u.a(packageManager3, str, 128);
                    } catch (PackageManager.NameNotFoundException unused2) {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        String str2 = applicationInfo.packageName;
                        t.d(str2, "packageName");
                        C2655d Y4 = a5.Y(str2);
                        t.b(packageManager);
                        dVar = B(applicationInfo, Y4, packageInfo, a5, context, packageManager, h02, i02);
                    }
                }
                a5.m();
                return dVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ArrayList D(Context context) {
        ArrayList arrayList;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo2;
        C2940B b5;
        C2655d dVar;
        Context context2 = context;
        t.e(context2, "context");
        synchronized (UptodownApp.f13477F.h()) {
            arrayList = new ArrayList();
            C2940B a5 = C2940B.f26458v.a(context2);
            a5.a();
            PackageManager packageManager = context2.getPackageManager();
            t.b(packageManager);
            List<ApplicationInfo> b6 = C2301u.b(packageManager, 128);
            ArrayList d02 = a5.d0();
            a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
            boolean h02 = aVar.h0(context2);
            boolean i02 = aVar.i0(context2);
            for (ApplicationInfo applicationInfo2 : b6) {
                try {
                    String str = applicationInfo2.packageName;
                    t.d(str, "packageName");
                    packageInfo = C2301u.d(packageManager, str, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    Iterator it = d02.iterator();
                    int i5 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            applicationInfo = applicationInfo2;
                            packageInfo2 = packageInfo;
                            b5 = a5;
                            i5 = -1;
                            dVar = null;
                            break;
                        }
                        int i6 = i5 + 1;
                        C2655d dVar2 = (C2655d) it.next();
                        applicationInfo = applicationInfo2;
                        packageInfo2 = packageInfo;
                        b5 = a5;
                        if (s.F(dVar2.o(), applicationInfo2.packageName, false, 2, (Object) null)) {
                            dVar = dVar2;
                            break;
                        }
                        i5 = i6;
                        a5 = b5;
                        applicationInfo2 = applicationInfo;
                        packageInfo = packageInfo2;
                    }
                    if (i5 >= 0) {
                        d02.remove(i5);
                    }
                    a5 = b5;
                    arrayList.add(B(applicationInfo, dVar, packageInfo2, a5, context2, packageManager, h02, i02));
                }
                context2 = context;
            }
            Iterator it2 = d02.iterator();
            t.d(it2, "iterator(...)");
            while (it2.hasNext()) {
                Object next = it2.next();
                t.d(next, "next(...)");
                C2655d dVar3 = (C2655d) next;
                a5.u(dVar3);
                if (dVar3.o() != null) {
                    String o5 = dVar3.o();
                    t.b(o5);
                    a5.R(o5);
                }
            }
            a5.m();
        }
        return arrayList;
    }

    public final void F(C2655d dVar, PackageInfo packageInfo, Context context) {
        t.e(dVar, "appTmp");
        t.e(packageInfo, "pInfo");
        t.e(context, "context");
        try {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                t.b(applicationInfo);
                dVar.V(applicationInfo.loadLabel(context.getPackageManager()).toString());
            }
        } catch (Exception unused) {
            dVar.V(dVar.o());
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setLocale(new Locale("xx"));
            if (packageInfo.applicationInfo != null) {
                PackageManager packageManager = context.getPackageManager();
                ApplicationInfo applicationInfo2 = packageInfo.applicationInfo;
                t.b(applicationInfo2);
                Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo2.packageName);
                t.d(resourcesForApplication, "getResourcesForApplication(...)");
                resourcesForApplication.updateConfiguration(configuration, context.getResources().getDisplayMetrics());
                ApplicationInfo applicationInfo3 = packageInfo.applicationInfo;
                t.b(applicationInfo3);
                dVar.L(resourcesForApplication.getString(applicationInfo3.labelRes));
            }
        } catch (Exception unused2) {
            dVar.L(dVar.m());
        }
        String c5 = dVar.c();
        t.b(c5);
        int length = c5.length();
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                String c6 = dVar.c();
                t.b(c6);
                dVar.L(G(c6));
                break;
            } else if (w(c5.charAt(i5))) {
                dVar.L(dVar.o());
                break;
            } else {
                i5++;
            }
        }
        if (s.E(dVar.c(), "null", true)) {
            dVar.O(1);
        }
    }

    public final long d(ApplicationInfo applicationInfo) {
        t.e(applicationInfo, "aPackage");
        File parentFile = new File(applicationInfo.sourceDir).getParentFile();
        if (parentFile == null || !parentFile.isDirectory()) {
            return 0;
        }
        long l5 = new C2289i().l(parentFile);
        String str = applicationInfo.packageName;
        t.d(str, "packageName");
        String str2 = applicationInfo.packageName;
        t.d(str2, "packageName");
        return l5 + q(str) + p(str2);
    }

    public final Object f(ArrayList arrayList, Context context, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new c(context, arrayList, this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    public final ArrayList g(ArrayList arrayList) {
        t.e(arrayList, "apps");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2655d dVar = (C2655d) next;
            if (dVar.f() == 0 && dVar.r() != null) {
                arrayList2.add(dVar);
            }
        }
        return arrayList2;
    }

    public final String h(Context context, String str) {
        t.e(context, "context");
        t.e(str, "packageName");
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                return context.getPackageManager().getInstallSourceInfo(str).getInstallingPackageName();
            }
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String i(PackageManager packageManager, String str) {
        t.e(packageManager, "pm");
        t.e(str, "packagename");
        return m(packageManager, str, SameMD5.TAG);
    }

    public final ArrayList j(PackageManager packageManager, String str) {
        t.e(packageManager, "pm");
        t.e(str, "packagename");
        return o(packageManager, str, SameMD5.TAG);
    }

    public final String k(PackageManager packageManager, String str) {
        t.e(packageManager, "pm");
        t.e(str, "packagename");
        return m(packageManager, str, "SHA256");
    }

    public final String r(ArrayList arrayList) {
        t.e(arrayList, "apps");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2655d dVar = (C2655d) next;
            if (dVar.r() != null) {
                String r5 = dVar.r();
                t.b(r5);
                arrayList2.add(r5);
                if (dVar.v() != null) {
                    ArrayList v5 = dVar.v();
                    t.b(v5);
                    if (!v5.isEmpty()) {
                        ArrayList v6 = dVar.v();
                        t.b(v6);
                        Iterator it2 = v6.iterator();
                        t.d(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            Object next2 = it2.next();
                            t.d(next2, "next(...)");
                            C2673w wVar = (C2673w) next2;
                            if (wVar.c() != null) {
                                String c5 = wVar.c();
                                t.b(c5);
                                arrayList2.add(c5);
                            }
                        }
                    }
                }
                if (dVar.n() != null) {
                    ArrayList n5 = dVar.n();
                    t.b(n5);
                    if (!n5.isEmpty()) {
                        ArrayList n6 = dVar.n();
                        t.b(n6);
                        Iterator it3 = n6.iterator();
                        t.d(it3, "iterator(...)");
                        while (it3.hasNext()) {
                            Object next3 = it3.next();
                            t.d(next3, "next(...)");
                            C2673w wVar2 = (C2673w) next3;
                            if (wVar2.c() != null) {
                                String c6 = wVar2.c();
                                t.b(c6);
                                arrayList2.add(c6);
                            }
                        }
                    }
                }
            }
        }
        C2250q.t(arrayList2, new C2946e(new C2945d()));
        Iterator it4 = arrayList2.iterator();
        t.d(it4, "iterator(...)");
        String str = null;
        while (it4.hasNext()) {
            Object next4 = it4.next();
            t.d(next4, "next(...)");
            String str2 = (String) next4;
            if (str == null) {
                str = str2;
            } else {
                Q q5 = Q.f24695a;
                str = String.format("%s%s", Arrays.copyOf(new Object[]{str, str2}, 2));
                t.d(str, "format(...)");
            }
        }
        if (str == null) {
            return str;
        }
        C2286f fVar = C2286f.f20690a;
        return fVar.f(str + Build.VERSION.SDK_INT);
    }

    public final String u(String str) {
        t.e(str, "sha256");
        return "https://www.virustotal.com/gui/file/" + str + "/detection";
    }

    public final boolean v(String str, Context context) {
        PackageInfo packageInfo = null;
        if (!(str == null || context == null)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfo = C2301u.d(packageManager, str, 0);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (packageInfo != null) {
            return true;
        }
        return false;
    }

    public final boolean z(String str) {
        if (str != null && !s.N(str, "org.chromium.webapk.", true)) {
            return Pattern.compile("^[a-zA-Z]\\w*(\\.\\w+)+$").matcher(str).matches();
        }
        return false;
    }
}
