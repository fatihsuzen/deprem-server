package O1;

import W2.J;
import W2.u;
import X2.C2250q;
import a3.C2265a;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.Comparator;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2647G;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import z2.F;
import z2.O;
import z2.Z;
import z3.D;
import z3.w;

/* renamed from: O1.k4  reason: case insensitive filesystem */
public final class C0823k4 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f3670a;

    /* renamed from: b  reason: collision with root package name */
    private final D f3671b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3672c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3673d = true;

    /* renamed from: O1.k4$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f3674a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f3675b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2647G f3676c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2616a f3677d;

        /* renamed from: O1.k4$a$a  reason: collision with other inner class name */
        static final class C0053a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f3678a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2616a f3679b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0053a(C2616a aVar, C2308e eVar) {
                super(2, eVar);
                this.f3679b = aVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0053a(this.f3679b, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f3678a == 0) {
                    u.b(obj);
                    this.f3679b.invoke();
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0053a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, C2647G g5, C2616a aVar, C2308e eVar) {
            super(2, eVar);
            this.f3675b = context;
            this.f3676c = g5;
            this.f3677d = aVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f3675b, this.f3676c, this.f3677d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f3674a;
            if (i5 == 0) {
                u.b(obj);
                l2.M f6 = new Z(this.f3675b).f(this.f3676c.b());
                if (!f6.b() && f6.e() != null) {
                    JSONObject e5 = f6.e();
                    t.b(e5);
                    if (e5.optInt("success") == 1) {
                        Bundle bundle = new Bundle();
                        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "removed");
                        new F(this.f3675b).d("preregister", bundle);
                        this.f3676c.j(this.f3675b);
                        I0 c5 = C2865c0.c();
                        C0053a aVar = new C0053a(this.f3677d, (C2308e) null);
                        this.f3674a = 1;
                        if (C2872g.g(c5, aVar, this) == f5) {
                            return f5;
                        }
                    }
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: O1.k4$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f3680a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C0823k4 f3681b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f3682c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f3683d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C0823k4 k4Var, boolean z4, Context context, C2308e eVar) {
            super(2, eVar);
            this.f3681b = k4Var;
            this.f3682c = z4;
            this.f3683d = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f3681b, this.f3682c, this.f3683d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f3680a;
            if (i5 == 0) {
                u.b(obj);
                this.f3681b.h(true);
                this.f3681b.g(false);
                if (this.f3682c) {
                    this.f3681b.f3670a.setValue(O.a.f26507a);
                }
                C0823k4 k4Var = this.f3681b;
                Context context = this.f3683d;
                this.f3680a = 1;
                obj = k4Var.f(context, this);
                if (obj == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f3681b.f3670a.setValue(new O.c((ArrayList) obj));
            this.f3681b.h(false);
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: O1.k4$c */
    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f3684a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f3685b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C0823k4 f3686c;

        /* renamed from: d  reason: collision with root package name */
        int f3687d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C0823k4 k4Var, C2308e eVar) {
            super(eVar);
            this.f3686c = k4Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.f3685b = obj;
            this.f3687d |= Integer.MIN_VALUE;
            return this.f3686c.f((Context) null, this);
        }
    }

    /* renamed from: O1.k4$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f3688a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f3689b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f3690c;

        /* renamed from: O1.k4$d$a */
        public static final class a implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return C2265a.a(((C2647G) obj).f(), ((C2647G) obj2).f());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, ArrayList arrayList, C2308e eVar) {
            super(2, eVar);
            this.f3689b = context;
            this.f3690c = arrayList;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f3689b, this.f3690c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            JSONArray optJSONArray;
            C2316b.f();
            if (this.f3688a == 0) {
                u.b(obj);
                l2.M U4 = new Z(this.f3689b).U();
                if (!U4.b() && U4.e() != null) {
                    JSONObject e5 = U4.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("apps")) == null)) {
                        int length = optJSONArray.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                            C2647G.a aVar = C2647G.f24762f;
                            t.b(optJSONObject2);
                            this.f3690c.add(aVar.b(optJSONObject2));
                        }
                    }
                }
                ArrayList arrayList = this.f3690c;
                if (arrayList.size() > 1) {
                    C2250q.t(arrayList, new a());
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C0823k4() {
        w a5 = z3.F.a(O.a.f26507a);
        this.f3670a = a5;
        this.f3671b = a5;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(android.content.Context r7, b3.C2308e r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof O1.C0823k4.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            O1.k4$c r0 = (O1.C0823k4.c) r0
            int r1 = r0.f3687d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f3687d = r1
            goto L_0x0018
        L_0x0013:
            O1.k4$c r0 = new O1.k4$c
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f3685b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f3687d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r7 = r0.f3684a
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            W2.u.b(r8)
            return r7
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            W2.u.b(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            w3.I r2 = w3.C2865c0.b()
            O1.k4$d r4 = new O1.k4$d
            r5 = 0
            r4.<init>(r7, r8, r5)
            r0.f3684a = r8
            r0.f3687d = r3
            java.lang.Object r7 = w3.C2872g.g(r2, r4, r0)
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.C0823k4.f(android.content.Context, b3.e):java.lang.Object");
    }

    public final void c(Context context, C2647G g5, C2616a aVar) {
        t.e(context, "context");
        t.e(g5, "preRegister");
        t.e(aVar, "callback");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new a(context, g5, aVar, (C2308e) null), 2, (Object) null);
    }

    public final void d(Context context, boolean z4) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, z4, context, (C2308e) null), 2, (Object) null);
    }

    public final D e() {
        return this.f3671b;
    }

    public final void g(boolean z4) {
        this.f3672c = z4;
    }

    public final void h(boolean z4) {
        this.f3673d = z4;
    }
}
