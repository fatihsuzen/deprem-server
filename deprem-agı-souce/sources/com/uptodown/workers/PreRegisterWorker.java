package com.uptodown.workers;

import S1.k;
import W2.J;
import W2.u;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.squareup.picasso.s;
import com.uptodown.UptodownApp;
import g2.C2388j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2610u;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2647G;
import l2.C2657f;
import l2.M;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.N;
import w3.O;
import z2.C2940B;
import z2.Z;

public final class PreRegisterWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21382b = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f21383a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21384a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PreRegisterWorker f21385b;

        public static final class a implements C2610u {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PreRegisterWorker f21386a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2647G f21387b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f21388c;

            a(PreRegisterWorker preRegisterWorker, C2647G g5, int i5) {
                this.f21386a = preRegisterWorker;
                this.f21387b = g5;
                this.f21388c = i5;
            }

            public void c(C2657f fVar) {
                t.e(fVar, "appInfo");
                this.f21386a.j(this.f21387b, fVar, this.f21388c);
                if (this.f21387b.d() == 1 && fVar.G0()) {
                    UptodownApp.f13477F.b0(fVar, this.f21386a.f21383a);
                }
            }

            public void d(int i5) {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PreRegisterWorker preRegisterWorker, C2308e eVar) {
            super(2, eVar);
            this.f21385b = preRegisterWorker;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21385b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            JSONArray optJSONArray;
            C2316b.f();
            if (this.f21384a == 0) {
                u.b(obj);
                ArrayList arrayList = new ArrayList();
                M U4 = new Z(this.f21385b.f21383a).U();
                if (!U4.b() && U4.e() != null) {
                    JSONObject e5 = U4.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    int i5 = 0;
                    if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("apps")) == null)) {
                        int length = optJSONArray.length();
                        for (int i6 = 0; i6 < length; i6++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                            C2647G.a aVar = C2647G.f24762f;
                            t.b(optJSONObject2);
                            C2647G b5 = aVar.b(optJSONObject2);
                            arrayList.add(b5);
                            b5.i(this.f21385b.f21383a);
                        }
                    }
                    C2940B a5 = C2940B.f26458v.a(this.f21385b.f21383a);
                    a5.a();
                    ArrayList<C2647G> A02 = a5.A0();
                    a5.m();
                    for (C2647G g5 : A02) {
                        int i7 = i5 + 1;
                        Iterator it = arrayList.iterator();
                        t.d(it, "iterator(...)");
                        while (true) {
                            if (!it.hasNext()) {
                                new C2388j(this.f21385b.f21383a, g5.b(), new a(this.f21385b, g5, i5), N.a(C2865c0.b()));
                                break;
                            }
                            Object next = it.next();
                            t.d(next, "next(...)");
                            if (g5.b() == ((C2647G) next).b()) {
                                break;
                            }
                        }
                        i5 = i7;
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21389a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PreRegisterWorker f21390b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(PreRegisterWorker preRegisterWorker, C2308e eVar) {
            super(2, eVar);
            this.f21390b = preRegisterWorker;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f21390b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21389a;
            if (i5 == 0) {
                u.b(obj);
                PreRegisterWorker preRegisterWorker = this.f21390b;
                this.f21389a = 1;
                if (preRegisterWorker.h(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21391a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21392b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PreRegisterWorker f21393c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2657f f21394d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f21395e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C2647G f21396f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, PreRegisterWorker preRegisterWorker, C2657f fVar, int i5, C2647G g5, C2308e eVar) {
            super(2, eVar);
            this.f21392b = str;
            this.f21393c = preRegisterWorker;
            this.f21394d = fVar;
            this.f21395e = i5;
            this.f21396f = g5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f21392b, this.f21393c, this.f21394d, this.f21395e, this.f21396f, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Bitmap bitmap;
            C2316b.f();
            if (this.f21391a == 0) {
                u.b(obj);
                try {
                    bitmap = s.h().l(this.f21392b).g();
                } catch (IOException unused) {
                    bitmap = null;
                }
                z2.M.f26506a.q(this.f21393c.f21383a, this.f21394d, this.f21395e, bitmap, this.f21396f);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class e implements M1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PreRegisterWorker f21397a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21398b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2647G f21399c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2657f f21400d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f21401e;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21402a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ PreRegisterWorker f21403b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f21404c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ C2647G f21405d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ C2657f f21406e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ int f21407f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(PreRegisterWorker preRegisterWorker, String str, C2647G g5, C2657f fVar, int i5, C2308e eVar) {
                super(2, eVar);
                this.f21403b = preRegisterWorker;
                this.f21404c = str;
                this.f21405d = g5;
                this.f21406e = fVar;
                this.f21407f = i5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21403b, this.f21404c, this.f21405d, this.f21406e, this.f21407f, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object f5 = C2316b.f();
                int i5 = this.f21402a;
                if (i5 == 0) {
                    u.b(obj);
                    PreRegisterWorker preRegisterWorker = this.f21403b;
                    String str = this.f21404c;
                    C2647G g5 = this.f21405d;
                    C2657f fVar = this.f21406e;
                    int i6 = this.f21407f;
                    this.f21402a = 1;
                    if (preRegisterWorker.i(str, g5, fVar, i6, this) == f5) {
                        return f5;
                    }
                } else if (i5 == 1) {
                    u.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return J.f19942a;
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        e(PreRegisterWorker preRegisterWorker, String str, C2647G g5, C2657f fVar, int i5) {
            this.f21397a = preRegisterWorker;
            this.f21398b = str;
            this.f21399c = g5;
            this.f21400d = fVar;
            this.f21401e = i5;
        }

        public void a(Exception exc) {
            z2.M.f26506a.q(this.f21397a.f21383a, this.f21400d, this.f21401e, (Bitmap) null, this.f21399c);
        }

        public void onSuccess() {
            C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new a(this.f21397a, this.f21398b, this.f21399c, this.f21400d, this.f21401e, (C2308e) null), 3, (Object) null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreRegisterWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "params");
        this.f21383a = context;
        this.f21383a = k.f32g.a(context);
    }

    /* access modifiers changed from: private */
    public final Object h(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new b(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final Object i(String str, C2647G g5, C2657f fVar, int i5, C2308e eVar) {
        Object g6 = C2872g.g(C2865c0.b(), new d(str, this, fVar, i5, g5, (C2308e) null), eVar);
        if (g6 == C2316b.f()) {
            return g6;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void j(C2647G g5, C2657f fVar, int i5) {
        String G4 = fVar.G();
        if (G4 != null) {
            s.h().l(G4).e(new e(this, G4, g5, fVar, i5));
            return;
        }
        z2.M.f26506a.q(this.f21383a, fVar, i5, (Bitmap) null, g5);
    }

    public ListenableWorker.Result doWork() {
        ListenableWorker.Result success = ListenableWorker.Result.success();
        try {
            C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new c(this, (C2308e) null), 3, (Object) null);
        } catch (Exception e5) {
            e5.printStackTrace();
            success = ListenableWorker.Result.failure();
        }
        t.b(success);
        return success;
    }
}
