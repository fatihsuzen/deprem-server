package com.uptodown.workers;

import S1.k;
import W2.J;
import W2.u;
import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import b2.C2290j;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import com.uptodown.workers.GenerateQueueWorker;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2642B;
import l2.C2653b;
import l2.C2655d;
import l2.C2667p;
import l2.C2668q;
import l2.T;
import l2.r;
import org.json.JSONArray;
import org.json.JSONObject;
import t3.s;
import w3.C2865c0;
import w3.C2872g;
import w3.M;
import z2.C2940B;
import z2.C2954m;
import z2.C2962v;
import z2.F;
import z2.K;
import z2.Q;

public final class TrackingWorker extends Worker {

    /* renamed from: h  reason: collision with root package name */
    public static final a f21412h = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f21413a = k.f32g.a(this.f21413a);

    /* renamed from: b  reason: collision with root package name */
    private boolean f21414b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21415c;

    /* renamed from: d  reason: collision with root package name */
    private String f21416d;

    /* renamed from: e  reason: collision with root package name */
    private final F f21417e = new F(this.f21413a);

    /* renamed from: f  reason: collision with root package name */
    private boolean f21418f;

    /* renamed from: g  reason: collision with root package name */
    private int f21419g;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21420a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f21421b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, C2308e eVar) {
            super(2, eVar);
            this.f21421b = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21421b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21420a;
            if (i5 == 0) {
                u.b(obj);
                ArrayList D4 = new C2954m().D(this.f21421b);
                C2954m mVar = new C2954m();
                Context context = this.f21421b;
                this.f21420a = 1;
                if (mVar.f(D4, context, this) == f5) {
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
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21422a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TrackingWorker f21423b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(TrackingWorker trackingWorker, C2308e eVar) {
            super(2, eVar);
            this.f21423b = trackingWorker;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f21423b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21422a;
            if (i5 == 0) {
                u.b(obj);
                TrackingWorker trackingWorker = this.f21423b;
                Context d5 = trackingWorker.f21413a;
                this.f21422a = 1;
                if (trackingWorker.l(d5, this) == f5) {
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
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "params");
        this.f21413a = context;
        this.f21414b = workerParameters.getInputData().getBoolean("isCompressed", true);
        for (String next : getTags()) {
            if (next.equals("TrackingWorkerPeriodic") || next.equals("TrackingWorkerSingle")) {
                this.f21416d = next;
            }
        }
    }

    private final void f(T t5, C2655d dVar, Context context, C2940B b5) {
        T G02 = b5.G0(t5.h());
        if (G02 == null) {
            b5.c1(t5);
            i(t5);
            if (!new C2290j().p(context, t5.h())) {
                this.f21418f = true;
                this.f21419g++;
            }
            new C2653b().l(dVar, t5, b5);
        } else if (G02.l(t5)) {
            b5.R(t5.h());
            b5.c1(t5);
            i(t5);
            new C2653b().l(dVar, t5, b5);
        }
    }

    private final void g(l2.M m5) {
        if (m5.f() == 401) {
            this.f21415c = true;
        } else if (m5.f() == 0) {
            this.f21415c = true;
        }
    }

    private final String h(String str) {
        if (s.E(str, "TrackingWorkerPeriodic", true)) {
            return "periodic";
        }
        return "oneTime";
    }

    private final void i(T t5) {
        ArrayList i5 = t5.i();
        if (i5 != null && !i5.isEmpty()) {
            C2667p pVar = new C2667p();
            ArrayList i6 = t5.i();
            t.b(i6);
            ArrayList e5 = pVar.e(i6, this.f21413a);
            if (!e5.isEmpty()) {
                Iterator it = e5.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    Bundle bundle = new Bundle();
                    bundle.putInt("update", 1);
                    bundle.putString("feature", (String) next);
                    this.f21417e.d("required_features_not_supported", bundle);
                }
            }
        }
    }

    private final void j(JSONObject jSONObject) {
        C2668q qVar;
        C2940B a5 = C2940B.f26458v.a(this.f21413a);
        a5.a();
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("updates");
        if (optJSONArray != null) {
            arrayList.addAll(k(optJSONArray, a5, this.f21413a, false));
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("partialUpdates");
        if (optJSONArray2 != null) {
            arrayList.addAll(k(new K().a(optJSONArray2, optJSONArray), a5, this.f21413a, true));
        }
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        boolean z4 = false;
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            if (s.E(this.f21413a.getPackageName(), ((T) next).h(), true)) {
                z4 = true;
            }
        }
        Iterator it2 = a5.I0().iterator();
        t.d(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next2 = it2.next();
            t.d(next2, "next(...)");
            T t5 = (T) next2;
            Iterator it3 = arrayList.iterator();
            t.d(it3, "iterator(...)");
            while (true) {
                if (!it3.hasNext()) {
                    a5.R(t5.h());
                    break;
                }
                Object next3 = it3.next();
                t.d(next3, "next(...)");
                if (s.E(t5.h(), ((T) next3).h(), true)) {
                    break;
                }
            }
        }
        a5.m();
        a.C0147a aVar = com.uptodown.activities.preferences.a.f15150a;
        if (aVar.j0(this.f21413a)) {
            z2.M.f26506a.k(this.f21413a);
            if (z4) {
                GenerateQueueWorker.a aVar2 = GenerateQueueWorker.f21366e;
                Context context = this.f21413a;
                aVar2.b(context, true, context.getPackageName(), true);
                return;
            }
            return;
        }
        String str = null;
        if (aVar.Y(this.f21413a) || s.E(aVar.j(this.f21413a), "2", true)) {
            GenerateQueueWorker.f21366e.a(this.f21413a, false, (String) null);
        } else {
            z2.M.f26506a.G(this.f21413a);
            UploadFileWorker.f21424c.a(this.f21413a);
        }
        if (z4) {
            a5.a();
            String packageName = this.f21413a.getPackageName();
            t.d(packageName, "getPackageName(...)");
            T G02 = a5.G0(packageName);
            a5.m();
            if (G02 != null) {
                qVar = G02.a();
            } else {
                qVar = null;
            }
            if (qVar == null || !qVar.f()) {
                UptodownApp.f13477F.B().send(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR, (Bundle) null);
                return;
            }
            C2642B a6 = C2642B.f24727g.a(this.f21413a);
            if (a6 != null) {
                str = a6.e();
            }
            if (str != null && !qVar.o().isEmpty() && ((r) qVar.o().get(0)).a() != null && qVar.f()) {
                String a7 = ((r) qVar.o().get(0)).a();
                t.b(a7);
                File file = new File(a7);
                if (file.exists()) {
                    String e5 = a6.e();
                    t.b(e5);
                    if (System.currentTimeMillis() - Long.parseLong(e5) > 604800000) {
                        z2.M.f26506a.C(this.f21413a, new C2962v().w(file, this.f21413a));
                    }
                }
            }
        }
    }

    private final ArrayList k(JSONArray jSONArray, C2940B b5, Context context, boolean z4) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i5 = 0; i5 < length; i5++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i5);
            if (!optJSONObject.isNull("packagename")) {
                String optString = optJSONObject.optString("packagename");
                t.b(optString);
                C2655d Y4 = b5.Y(optString);
                if (Y4 != null) {
                    T.b bVar = T.f24856k;
                    t.b(optJSONObject);
                    T c5 = bVar.c(Y4, optJSONObject);
                    if (c5 != null) {
                        if (z4) {
                            c5.t(1);
                        }
                        f(c5, Y4, context, b5);
                        arrayList.add(c5);
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final Object l(Context context, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(context, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x027d A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02cc A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02e3 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0325 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0105 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0199 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c9 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01d3 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01f1 A[Catch:{ Exception -> 0x0021 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0208 A[Catch:{ Exception -> 0x0021 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m() {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "error"
            java.lang.String r2 = "sha256Status"
            com.uptodown.UptodownApp$a r3 = com.uptodown.UptodownApp.f13477F     // Catch:{ Exception -> 0x0021 }
            m2.i r4 = r3.B()     // Catch:{ Exception -> 0x0021 }
            r5 = 600(0x258, float:8.41E-43)
            r6 = 0
            r4.send(r5, r6)     // Catch:{ Exception -> 0x0021 }
            z2.F r4 = r1.f21417e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r5 = "start"
            java.lang.String r7 = r1.f21416d     // Catch:{ Exception -> 0x0021 }
            java.lang.String r8 = "currentTag"
            if (r7 != 0) goto L_0x0024
            kotlin.jvm.internal.t.w(r8)     // Catch:{ Exception -> 0x0021 }
            r7 = r6
            goto L_0x0024
        L_0x0021:
            r0 = move-exception
            goto L_0x036f
        L_0x0024:
            java.lang.String r7 = r1.h(r7)     // Catch:{ Exception -> 0x0021 }
            r4.g(r5, r6, r6, r7)     // Catch:{ Exception -> 0x0021 }
            w3.I r4 = w3.C2865c0.b()     // Catch:{ Exception -> 0x0021 }
            w3.M r9 = w3.N.a(r4)     // Catch:{ Exception -> 0x0021 }
            com.uptodown.workers.TrackingWorker$c r12 = new com.uptodown.workers.TrackingWorker$c     // Catch:{ Exception -> 0x0021 }
            r12.<init>(r1, r6)     // Catch:{ Exception -> 0x0021 }
            r13 = 3
            r14 = 0
            r10 = 0
            r11 = 0
            w3.C2908y0 unused = w3.C2876i.d(r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0021 }
            l2.p r4 = new l2.p     // Catch:{ Exception -> 0x0021 }
            r4.<init>()     // Catch:{ Exception -> 0x0021 }
            m2.d$a r5 = m2.C2684d.f25289a     // Catch:{ Exception -> 0x0021 }
            r5.a()     // Catch:{ Exception -> 0x0021 }
            z2.Z r5 = new z2.Z     // Catch:{ Exception -> 0x0021 }
            android.content.Context r7 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r5.<init>(r7, r6)     // Catch:{ Exception -> 0x0021 }
            android.content.Context r7 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r4.k(r7)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r7 = r4.a()     // Catch:{ Exception -> 0x0021 }
            com.uptodown.activities.preferences.a$a r9 = com.uptodown.activities.preferences.a.f15150a     // Catch:{ Exception -> 0x0021 }
            android.content.Context r10 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            java.lang.String r10 = r9.h(r10)     // Catch:{ Exception -> 0x0021 }
            r11 = 1
            boolean r12 = t3.s.E(r7, r10, r11)     // Catch:{ Exception -> 0x0021 }
            if (r12 == 0) goto L_0x006a
            r12 = 0
            goto L_0x00d0
        L_0x006a:
            java.lang.String r12 = r4.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r12)     // Catch:{ Exception -> 0x0021 }
            l2.M r12 = r5.u(r12)     // Catch:{ Exception -> 0x0021 }
            z2.F r15 = r1.f21417e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r14 = "getDevice"
            java.lang.String r13 = r1.f21416d     // Catch:{ Exception -> 0x0021 }
            if (r13 != 0) goto L_0x0081
            kotlin.jvm.internal.t.w(r8)     // Catch:{ Exception -> 0x0021 }
            r13 = r6
        L_0x0081:
            java.lang.String r13 = r1.h(r13)     // Catch:{ Exception -> 0x0021 }
            r15.g(r14, r6, r12, r13)     // Catch:{ Exception -> 0x0021 }
            boolean r13 = r5.i(r12)     // Catch:{ Exception -> 0x0021 }
            if (r13 == 0) goto L_0x00b9
            int r13 = r12.f()     // Catch:{ Exception -> 0x0021 }
            r14 = 200(0xc8, float:2.8E-43)
            if (r13 != r14) goto L_0x00b9
            android.content.Context r13 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            boolean r13 = r9.R(r13)     // Catch:{ Exception -> 0x0021 }
            if (r13 != 0) goto L_0x00ac
            android.content.Context r13 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r9.A0(r13, r11)     // Catch:{ Exception -> 0x0021 }
            m2.i r13 = r3.B()     // Catch:{ Exception -> 0x0021 }
            r14 = 603(0x25b, float:8.45E-43)
            r13.send(r14, r6)     // Catch:{ Exception -> 0x0021 }
        L_0x00ac:
            java.lang.String r12 = r12.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r12)     // Catch:{ Exception -> 0x0021 }
            boolean r12 = r4.b(r12)     // Catch:{ Exception -> 0x0021 }
            r12 = r12 ^ r11
            goto L_0x00d0
        L_0x00b9:
            int r13 = r12.f()     // Catch:{ Exception -> 0x0021 }
            r14 = 404(0x194, float:5.66E-43)
            if (r13 != r14) goto L_0x036b
            android.content.Context r12 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            boolean r12 = r9.R(r12)     // Catch:{ Exception -> 0x0021 }
            if (r12 == 0) goto L_0x00cf
            android.content.Context r12 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r13 = 0
            r9.A0(r12, r13)     // Catch:{ Exception -> 0x0021 }
        L_0x00cf:
            r12 = r11
        L_0x00d0:
            java.lang.String r13 = "success"
            if (r12 == 0) goto L_0x0137
            boolean r10 = r1.f21414b     // Catch:{ Exception -> 0x0021 }
            l2.M r10 = r5.d1(r4, r10)     // Catch:{ Exception -> 0x0021 }
            z2.F r12 = r1.f21417e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r14 = "saveDevice"
            java.lang.String r15 = r1.f21416d     // Catch:{ Exception -> 0x0021 }
            if (r15 != 0) goto L_0x00e6
            kotlin.jvm.internal.t.w(r8)     // Catch:{ Exception -> 0x0021 }
            r15 = r6
        L_0x00e6:
            java.lang.String r15 = r1.h(r15)     // Catch:{ Exception -> 0x0021 }
            r12.g(r14, r6, r10, r15)     // Catch:{ Exception -> 0x0021 }
            boolean r12 = r5.i(r10)     // Catch:{ Exception -> 0x0021 }
            if (r12 == 0) goto L_0x0133
            java.lang.String r12 = r10.d()     // Catch:{ Exception -> 0x0021 }
            if (r12 == 0) goto L_0x0102
            int r12 = r12.length()     // Catch:{ Exception -> 0x0021 }
            if (r12 != 0) goto L_0x0100
            goto L_0x0102
        L_0x0100:
            r12 = 0
            goto L_0x0103
        L_0x0102:
            r12 = r11
        L_0x0103:
            if (r12 != 0) goto L_0x0133
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x0021 }
            java.lang.String r10 = r10.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r10)     // Catch:{ Exception -> 0x0021 }
            r12.<init>(r10)     // Catch:{ Exception -> 0x0021 }
            int r10 = r12.optInt(r13)     // Catch:{ Exception -> 0x0021 }
            if (r10 != r11) goto L_0x0299
            android.content.Context r10 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r9.z0(r10, r7)     // Catch:{ Exception -> 0x0021 }
            android.content.Context r7 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            boolean r7 = r9.R(r7)     // Catch:{ Exception -> 0x0021 }
            if (r7 != 0) goto L_0x013e
            android.content.Context r7 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r9.A0(r7, r11)     // Catch:{ Exception -> 0x0021 }
            m2.i r3 = r3.B()     // Catch:{ Exception -> 0x0021 }
            r14 = 603(0x25b, float:8.45E-43)
            r3.send(r14, r6)     // Catch:{ Exception -> 0x0021 }
            goto L_0x013e
        L_0x0133:
            r1.g(r10)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x0137:
            if (r10 != 0) goto L_0x013e
            android.content.Context r3 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r9.z0(r3, r7)     // Catch:{ Exception -> 0x0021 }
        L_0x013e:
            z2.m r3 = new z2.m     // Catch:{ Exception -> 0x0021 }
            r3.<init>()     // Catch:{ Exception -> 0x0021 }
            android.content.Context r7 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            java.util.ArrayList r3 = r3.D(r7)     // Catch:{ Exception -> 0x0021 }
            z2.m r7 = new z2.m     // Catch:{ Exception -> 0x0021 }
            r7.<init>()     // Catch:{ Exception -> 0x0021 }
            java.util.ArrayList r3 = r7.g(r3)     // Catch:{ Exception -> 0x0021 }
            z2.J r7 = z2.J.f26502a     // Catch:{ Exception -> 0x0021 }
            android.content.Context r10 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            z2.F r12 = r1.f21417e     // Catch:{ Exception -> 0x0021 }
            r7.b(r10, r12)     // Catch:{ Exception -> 0x0021 }
            boolean r7 = r3.isEmpty()     // Catch:{ Exception -> 0x0021 }
            if (r7 != 0) goto L_0x0343
            java.lang.String r0 = r4.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r0)     // Catch:{ Exception -> 0x0021 }
            l2.M r0 = r5.i0(r0)     // Catch:{ Exception -> 0x0021 }
            z2.F r7 = r1.f21417e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r10 = "getStatus"
            java.lang.String r12 = r1.f21416d     // Catch:{ Exception -> 0x0021 }
            if (r12 != 0) goto L_0x0178
            kotlin.jvm.internal.t.w(r8)     // Catch:{ Exception -> 0x0021 }
            r12 = r6
        L_0x0178:
            java.lang.String r12 = r1.h(r12)     // Catch:{ Exception -> 0x0021 }
            r7.g(r10, r6, r0, r12)     // Catch:{ Exception -> 0x0021 }
            boolean r7 = r0.b()     // Catch:{ Exception -> 0x0021 }
            java.lang.String r10 = "data"
            if (r7 != 0) goto L_0x01be
            java.lang.String r7 = r0.d()     // Catch:{ Exception -> 0x0021 }
            if (r7 == 0) goto L_0x0196
            int r7 = r7.length()     // Catch:{ Exception -> 0x0021 }
            if (r7 != 0) goto L_0x0194
            goto L_0x0196
        L_0x0194:
            r7 = 0
            goto L_0x0197
        L_0x0196:
            r7 = r11
        L_0x0197:
            if (r7 != 0) goto L_0x01be
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0021 }
            java.lang.String r0 = r0.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r0)     // Catch:{ Exception -> 0x0021 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0021 }
            int r0 = r7.optInt(r13)     // Catch:{ Exception -> 0x0021 }
            if (r0 != r11) goto L_0x0299
            org.json.JSONObject r0 = r7.optJSONObject(r10)     // Catch:{ Exception -> 0x0021 }
            if (r0 == 0) goto L_0x01bc
            boolean r7 = r0.isNull(r2)     // Catch:{ Exception -> 0x0021 }
            if (r7 != 0) goto L_0x01bc
            java.lang.String r0 = r0.optString(r2)     // Catch:{ Exception -> 0x0021 }
            goto L_0x01c7
        L_0x01bc:
            r0 = r6
            goto L_0x01c7
        L_0x01be:
            int r2 = r0.f()     // Catch:{ Exception -> 0x0021 }
            r14 = 404(0x194, float:5.66E-43)
            if (r2 != r14) goto L_0x033f
            goto L_0x01bc
        L_0x01c7:
            if (r0 == 0) goto L_0x01d3
            z2.m r2 = new z2.m     // Catch:{ Exception -> 0x0021 }
            r2.<init>()     // Catch:{ Exception -> 0x0021 }
            java.lang.String r2 = r2.r(r3)     // Catch:{ Exception -> 0x0021 }
            goto L_0x01d4
        L_0x01d3:
            r2 = r6
        L_0x01d4:
            if (r2 == 0) goto L_0x01dc
            boolean r0 = kotlin.jvm.internal.t.a(r2, r0)     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x021c
        L_0x01dc:
            java.lang.String r0 = r4.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r0)     // Catch:{ Exception -> 0x0021 }
            boolean r2 = r1.f21414b     // Catch:{ Exception -> 0x0021 }
            l2.M r0 = r5.e1(r3, r0, r2)     // Catch:{ Exception -> 0x0021 }
            z2.F r2 = r1.f21417e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r7 = "saveTracking"
            java.lang.String r12 = r1.f21416d     // Catch:{ Exception -> 0x0021 }
            if (r12 != 0) goto L_0x01f5
            kotlin.jvm.internal.t.w(r8)     // Catch:{ Exception -> 0x0021 }
            r12 = r6
        L_0x01f5:
            java.lang.String r12 = r1.h(r12)     // Catch:{ Exception -> 0x0021 }
            r2.g(r7, r6, r0, r12)     // Catch:{ Exception -> 0x0021 }
            boolean r2 = r5.i(r0)     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0325
            java.lang.String r2 = r0.d()     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0325
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0021 }
            java.lang.String r0 = r0.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r0)     // Catch:{ Exception -> 0x0021 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0021 }
            int r0 = r2.optInt(r13)     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x021c
            goto L_0x0299
        L_0x021c:
            android.content.Context r0 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            java.lang.String r0 = r9.j(r0)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r2 = "0"
            boolean r0 = t3.s.E(r0, r2, r11)     // Catch:{ Exception -> 0x0021 }
            if (r0 == 0) goto L_0x0247
            l2.M r0 = new l2.M     // Catch:{ Exception -> 0x0021 }
            r0.<init>()     // Catch:{ Exception -> 0x0021 }
            r14 = 404(0x194, float:5.66E-43)
            r0.k(r14)     // Catch:{ Exception -> 0x0021 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0021 }
            r2.<init>()     // Catch:{ Exception -> 0x0021 }
            r2.put(r13, r11)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r7 = r2.toString()     // Catch:{ Exception -> 0x0021 }
            r0.i(r7)     // Catch:{ Exception -> 0x0021 }
            r0.j(r2)     // Catch:{ Exception -> 0x0021 }
            goto L_0x0265
        L_0x0247:
            java.lang.String r0 = r4.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r0)     // Catch:{ Exception -> 0x0021 }
            l2.M r0 = r5.q0(r0)     // Catch:{ Exception -> 0x0021 }
            z2.F r2 = r1.f21417e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r7 = "getUpdates"
            java.lang.String r12 = r1.f21416d     // Catch:{ Exception -> 0x0021 }
            if (r12 != 0) goto L_0x025e
            kotlin.jvm.internal.t.w(r8)     // Catch:{ Exception -> 0x0021 }
            r12 = r6
        L_0x025e:
            java.lang.String r8 = r1.h(r12)     // Catch:{ Exception -> 0x0021 }
            r2.g(r7, r6, r0, r8)     // Catch:{ Exception -> 0x0021 }
        L_0x0265:
            boolean r2 = r5.i(r0)     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x029a
            java.lang.String r2 = r0.d()     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x027a
            int r2 = r2.length()     // Catch:{ Exception -> 0x0021 }
            if (r2 != 0) goto L_0x0278
            goto L_0x027a
        L_0x0278:
            r15 = 0
            goto L_0x027b
        L_0x027a:
            r15 = r11
        L_0x027b:
            if (r15 != 0) goto L_0x029a
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0021 }
            java.lang.String r0 = r0.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r0)     // Catch:{ Exception -> 0x0021 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0021 }
            int r0 = r2.optInt(r13)     // Catch:{ Exception -> 0x0021 }
            if (r0 != r11) goto L_0x0299
            org.json.JSONObject r0 = r2.optJSONObject(r10)     // Catch:{ Exception -> 0x0021 }
            if (r0 == 0) goto L_0x02c4
            r1.j(r0)     // Catch:{ Exception -> 0x0021 }
            goto L_0x02c4
        L_0x0299:
            return
        L_0x029a:
            int r2 = r0.f()     // Catch:{ Exception -> 0x0021 }
            r14 = 404(0x194, float:5.66E-43)
            if (r2 != r14) goto L_0x0321
            z2.B$a r0 = z2.C2940B.f26458v     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            z2.B r0 = r0.a(r2)     // Catch:{ Exception -> 0x0021 }
            r0.a()     // Catch:{ Exception -> 0x0021 }
            java.util.ArrayList r2 = r0.I0()     // Catch:{ Exception -> 0x0021 }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0021 }
            if (r2 != 0) goto L_0x02ba
            r0.S()     // Catch:{ Exception -> 0x0021 }
        L_0x02ba:
            r0.m()     // Catch:{ Exception -> 0x0021 }
            com.uptodown.workers.UploadFileWorker$a r0 = com.uptodown.workers.UploadFileWorker.f21424c     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r0.a(r2)     // Catch:{ Exception -> 0x0021 }
        L_0x02c4:
            android.content.Context r0 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            boolean r0 = r9.j0(r0)     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x02db
            g2.l r0 = new g2.l     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            w3.I r5 = w3.C2865c0.b()     // Catch:{ Exception -> 0x0021 }
            w3.M r5 = w3.N.a(r5)     // Catch:{ Exception -> 0x0021 }
            r0.<init>(r3, r2, r5)     // Catch:{ Exception -> 0x0021 }
        L_0x02db:
            android.content.Context r0 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            boolean r0 = r9.j0(r0)     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x0319
            android.content.Context r0 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            boolean r0 = r9.g0(r0)     // Catch:{ Exception -> 0x0021 }
            if (r0 != 0) goto L_0x02f7
            l2.Q r0 = new l2.Q     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r0.j(r2, r4)     // Catch:{ Exception -> 0x0021 }
        L_0x02f7:
            android.content.Context r0 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            long r2 = r9.p(r0)     // Catch:{ Exception -> 0x0021 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0021 }
            r0 = 7200000(0x6ddd00, float:1.0089349E-38)
            long r7 = (long) r0     // Catch:{ Exception -> 0x0021 }
            long r2 = r2 + r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0319
            g2.c r0 = new g2.c     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            w3.I r3 = w3.C2865c0.b()     // Catch:{ Exception -> 0x0021 }
            w3.M r3 = w3.N.a(r3)     // Catch:{ Exception -> 0x0021 }
            r0.<init>(r2, r6, r3)     // Catch:{ Exception -> 0x0021 }
        L_0x0319:
            g2.r r0 = new g2.r     // Catch:{ Exception -> 0x0021 }
            android.content.Context r2 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x0321:
            r1.g(r0)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x0325:
            int r2 = r0.f()     // Catch:{ Exception -> 0x0021 }
            r14 = 404(0x194, float:5.66E-43)
            if (r2 != r14) goto L_0x033b
            android.content.Context r0 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r9.z0(r0, r6)     // Catch:{ Exception -> 0x0021 }
            android.content.Context r0 = r1.f21413a     // Catch:{ Exception -> 0x0021 }
            r13 = 0
            r9.A0(r0, r13)     // Catch:{ Exception -> 0x0021 }
            r1.f21415c = r11     // Catch:{ Exception -> 0x0021 }
            return
        L_0x033b:
            r1.g(r0)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x033f:
            r1.g(r0)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x0343:
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x0021 }
            r2.<init>()     // Catch:{ Exception -> 0x0021 }
            java.lang.String r3 = "identifier"
            java.lang.String r4 = r4.d()     // Catch:{ Exception -> 0x0021 }
            kotlin.jvm.internal.t.b(r4)     // Catch:{ Exception -> 0x0021 }
            r2.putString(r3, r4)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r3 = "noApps"
            r2.putString(r0, r3)     // Catch:{ Exception -> 0x0021 }
            z2.F r3 = r1.f21417e     // Catch:{ Exception -> 0x0021 }
            java.lang.String r4 = r1.f21416d     // Catch:{ Exception -> 0x0021 }
            if (r4 != 0) goto L_0x0363
            kotlin.jvm.internal.t.w(r8)     // Catch:{ Exception -> 0x0021 }
            r4 = r6
        L_0x0363:
            java.lang.String r4 = r1.h(r4)     // Catch:{ Exception -> 0x0021 }
            r3.g(r0, r2, r6, r4)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x036b:
            r1.g(r12)     // Catch:{ Exception -> 0x0021 }
            return
        L_0x036f:
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.workers.TrackingWorker.m():void");
    }

    public ListenableWorker.Result doWork() {
        if (getRunAttemptCount() > 1) {
            ListenableWorker.Result success = ListenableWorker.Result.success();
            t.d(success, "success(...)");
            return success;
        }
        String str = this.f21416d;
        if (str == null) {
            t.w("currentTag");
            str = null;
        }
        if (s.E(str, "TrackingWorkerPeriodic", true)) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.S("TrackingWorkerSingle", this.f21413a) || aVar.S("GenerateQueueWorker", this.f21413a) || aVar.S("DownloadUpdatesWorker", this.f21413a)) {
                ListenableWorker.Result success2 = ListenableWorker.Result.success();
                t.d(success2, "success(...)");
                return success2;
            }
        } else {
            String str2 = this.f21416d;
            if (str2 == null) {
                t.w("currentTag");
                str2 = null;
            }
            if (s.E(str2, "TrackingWorkerSingle", true)) {
                UptodownApp.a aVar2 = UptodownApp.f13477F;
                if (aVar2.S("TrackingWorkerPeriodic", this.f21413a) || aVar2.S("GenerateQueueWorker", this.f21413a) || aVar2.S("DownloadUpdatesWorker", this.f21413a)) {
                    ListenableWorker.Result success3 = ListenableWorker.Result.success();
                    t.d(success3, "success(...)");
                    return success3;
                }
            }
        }
        if (new Q(this.f21413a).b()) {
            UptodownApp.a aVar3 = UptodownApp.f13477F;
            aVar3.B().send(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, (Bundle) null);
            if (!aVar3.K()) {
                ListenableWorker.Result success4 = ListenableWorker.Result.success();
                t.d(success4, "success(...)");
                return success4;
            }
        }
        k.f32g.b();
        a.C0147a aVar4 = com.uptodown.activities.preferences.a.f15150a;
        if (!aVar4.l0(this.f21413a) && aVar4.k0(this.f21413a)) {
            m();
            if (this.f21415c) {
                ListenableWorker.Result retry = ListenableWorker.Result.retry();
                t.d(retry, "retry(...)");
                return retry;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("newUpdatesAvailable", this.f21418f);
        bundle.putInt("newUpdatesAvailableCount", this.f21419g);
        UptodownApp.f13477F.B().send(601, bundle);
        aVar4.Y0(this.f21413a, System.currentTimeMillis());
        ListenableWorker.Result success5 = ListenableWorker.Result.success();
        t.d(success5, "success(...)");
        return success5;
    }
}
