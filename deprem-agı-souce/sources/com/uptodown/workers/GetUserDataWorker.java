package com.uptodown.workers;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import k2.P;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.M;
import l2.V;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.N;
import w3.O;
import z2.Z;

public final class GetUserDataWorker extends Worker {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21373b = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f21374a;

    public static final class a {

        /* renamed from: com.uptodown.workers.GetUserDataWorker$a$a  reason: collision with other inner class name */
        static final class C0217a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21375a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f21376b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ P f21377c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0217a(Context context, P p5, C2308e eVar) {
                super(2, eVar);
                this.f21376b = context;
                this.f21377c = p5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0217a(this.f21376b, this.f21377c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                String d5;
                JSONObject optJSONObject;
                C2316b.f();
                if (this.f21375a == 0) {
                    u.b(obj);
                    V.b bVar = V.f24870q;
                    V h5 = bVar.h(this.f21376b);
                    if (h5 != null && h5.p(this.f21376b)) {
                        M w02 = new Z(this.f21376b).w0();
                        if (!(w02.b() || (d5 = w02.d()) == null || d5.length() == 0)) {
                            String d6 = w02.d();
                            t.b(d6);
                            JSONObject jSONObject = new JSONObject(d6);
                            if (jSONObject.optInt("success") == 1 && !jSONObject.isNull(DataSchemeDataSource.SCHEME_DATA) && (optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
                                h5.g(this.f21376b, optJSONObject);
                                h5.s(this.f21376b);
                                P p5 = this.f21377c;
                                if (p5 != null) {
                                    p5.a();
                                }
                            }
                        }
                        if (w02.f() == 401) {
                            bVar.b(this.f21376b);
                        }
                    }
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(w3.M m5, C2308e eVar) {
                return ((C0217a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public static /* synthetic */ Object b(a aVar, Context context, P p5, C2308e eVar, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                p5 = null;
            }
            return aVar.a(context, p5, eVar);
        }

        public final Object a(Context context, P p5, C2308e eVar) {
            Object g5 = C2872g.g(C2865c0.b(), new C0217a(context, p5, (C2308e) null), eVar);
            if (g5 == C2316b.f()) {
                return g5;
            }
            return J.f19942a;
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21378a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GetUserDataWorker f21379b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(GetUserDataWorker getUserDataWorker, C2308e eVar) {
            super(2, eVar);
            this.f21379b = getUserDataWorker;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21379b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21378a;
            if (i5 == 0) {
                u.b(obj);
                a aVar = GetUserDataWorker.f21373b;
                Context d5 = this.f21379b.f21374a;
                this.f21378a = 1;
                if (a.b(aVar, d5, (P) null, this, 2, (Object) null) == f5) {
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
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetUserDataWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        t.e(context, "context");
        t.e(workerParameters, "params");
        this.f21374a = context;
    }

    public ListenableWorker.Result doWork() {
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new b(this, (C2308e) null), 3, (Object) null);
        ListenableWorker.Result success = ListenableWorker.Result.success();
        t.d(success, "success(...)");
        return success;
    }
}
