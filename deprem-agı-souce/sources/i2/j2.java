package i2;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import l2.M;
import l2.S;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class j2 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f24250a;

    /* renamed from: b  reason: collision with root package name */
    private final D f24251b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f24252c;

    /* renamed from: d  reason: collision with root package name */
    private final D f24253d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24254e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24255f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f24256g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24257h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f24258i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final S f24259a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f24260b;

        public a(S s5, boolean z4) {
            t.e(s5, "topByCategory");
            this.f24259a = s5;
            this.f24260b = z4;
        }

        public final boolean a() {
            return this.f24260b;
        }

        public final S b() {
            return this.f24259a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (t.a(this.f24259a, aVar.f24259a) && this.f24260b == aVar.f24260b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f24259a.hashCode() * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f24260b);
        }

        public String toString() {
            return "TopByCategoryData(topByCategory=" + this.f24259a + ", firstRequest=" + this.f24260b + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24261a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f24262b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f24263c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j2 f24264d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, int i5, j2 j2Var, C2308e eVar) {
            super(2, eVar);
            this.f24262b = context;
            this.f24263c = i5;
            this.f24264d = j2Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f24262b, this.f24263c, this.f24264d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24261a == 0) {
                u.b(obj);
                M a5 = new Z(this.f24262b).a(this.f24263c);
                if (!a5.b() && a5.e() != null) {
                    this.f24264d.p(this.f24262b, this.f24263c);
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
        int f24265a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j2 f24266b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f24267c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2660i f24268d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(j2 j2Var, Context context, C2660i iVar, C2308e eVar) {
            super(2, eVar);
            this.f24266b = j2Var;
            this.f24267c = context;
            this.f24268d = iVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f24266b, this.f24267c, this.f24268d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            C2316b.f();
            if (this.f24265a == 0) {
                u.b(obj);
                this.f24266b.u(true);
                int i5 = 0;
                this.f24266b.f24258i = 0;
                S a5 = this.f24266b.n(this.f24267c, this.f24268d);
                ArrayList a6 = a5.a();
                int size = a6.size();
                while (true) {
                    if (i5 >= size) {
                        obj2 = null;
                        break;
                    }
                    obj2 = a6.get(i5);
                    i5++;
                    if (((C2657f) obj2).N0()) {
                        break;
                    }
                }
                C2657f fVar = (C2657f) obj2;
                if (fVar != null) {
                    this.f24266b.t(true);
                    this.f24266b.q(this.f24267c, fVar, "impress");
                }
                this.f24266b.f24250a.setValue(new O.c(new a(a5, true)));
                if (a5.b().i()) {
                    this.f24266b.p(this.f24267c, a5.b().c());
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24269a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j2 f24270b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f24271c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2660i f24272d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(j2 j2Var, Context context, C2660i iVar, C2308e eVar) {
            super(2, eVar);
            this.f24270b = j2Var;
            this.f24271c = context;
            this.f24272d = iVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f24270b, this.f24271c, this.f24272d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24269a == 0) {
                u.b(obj);
                this.f24270b.u(true);
                S a5 = this.f24270b.n(this.f24271c, this.f24272d);
                if (a5.a().isEmpty()) {
                    this.f24270b.s(true);
                }
                this.f24270b.f24250a.setValue(new O.c(new a(a5, false)));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24273a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j2 f24274b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f24275c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f24276d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(j2 j2Var, Context context, int i5, C2308e eVar) {
            super(2, eVar);
            this.f24274b = j2Var;
            this.f24275c = context;
            this.f24276d = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f24274b, this.f24275c, this.f24276d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24273a == 0) {
                u.b(obj);
                this.f24274b.f24252c.setValue(O.a.f26507a);
                M I02 = new Z(this.f24275c).I0(this.f24276d);
                if (!I02.b() && I02.e() != null) {
                    JSONObject e5 = I02.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        w c5 = this.f24274b.f24252c;
                        boolean z4 = true;
                        if (optJSONObject.optInt("isCategoryFavorite") != 1) {
                            z4 = false;
                        }
                        c5.setValue(new O.c(kotlin.coroutines.jvm.internal.b.a(z4)));
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24277a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j2 f24278b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f24279c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2657f f24280d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f24281e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(j2 j2Var, Context context, C2657f fVar, String str, C2308e eVar) {
            super(2, eVar);
            this.f24278b = j2Var;
            this.f24279c = context;
            this.f24280d = fVar;
            this.f24281e = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f24278b, this.f24279c, this.f24280d, this.f24281e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24277a == 0) {
                u.b(obj);
                String i5 = this.f24278b.i();
                if (!(i5 == null || i5.length() == 0)) {
                    new Z(this.f24279c).O0(this.f24280d.e(), this.f24281e, i5);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24282a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f24283b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f24284c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j2 f24285d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Context context, int i5, j2 j2Var, C2308e eVar) {
            super(2, eVar);
            this.f24283b = context;
            this.f24284c = i5;
            this.f24285d = j2Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f24283b, this.f24284c, this.f24285d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24282a == 0) {
                u.b(obj);
                M b12 = new Z(this.f24283b).b1(this.f24284c);
                if (!b12.b() && b12.e() != null) {
                    this.f24285d.p(this.f24283b, this.f24284c);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public j2() {
        O.a aVar = O.a.f26507a;
        w a5 = F.a(aVar);
        this.f24250a = a5;
        this.f24251b = a5;
        w a6 = F.a(aVar);
        this.f24252c = a6;
        this.f24253d = a6;
    }

    /* access modifiers changed from: private */
    public final S n(Context context, C2660i iVar) {
        M m5;
        Z z4 = new Z(context);
        S s5 = new S((C2660i) null, (ArrayList) null, 0, 7, (C2633k) null);
        s5.e(iVar);
        if (iVar.c() > 0) {
            if (iVar.i()) {
                s5 = S.f24852d.a(z4.t(iVar.c(), 40, this.f24258i), iVar);
            } else if (iVar.k()) {
                s5.d(z4.V0(z4.m0(iVar.c(), 40, this.f24258i)));
            } else {
                s5.d(z4.V0(z4.l0(iVar.c(), 40, this.f24258i)));
            }
        } else if (iVar.c() == -1) {
            s5.d(z4.V0(z4.k0(40, this.f24258i)));
        } else if (iVar.c() == -2) {
            if (iVar.f() > 0) {
                m5 = z4.a0(iVar.f(), 40, this.f24258i);
            } else {
                m5 = z4.N(40, this.f24258i);
            }
            s5.d(z4.V0(m5));
        } else if (iVar.c() == -3) {
            s5.d(z4.V0(z4.J(40, this.f24258i)));
        }
        this.f24258i += s5.a().size();
        return s5;
    }

    public final void e(Context context, int i5) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(context, i5, this, (C2308e) null), 2, (Object) null);
    }

    public final void f(Context context, C2660i iVar) {
        t.e(context, "context");
        t.e(iVar, "category");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new c(this, context, iVar, (C2308e) null), 2, (Object) null);
    }

    public final void g(Context context, C2660i iVar) {
        t.e(context, "context");
        t.e(iVar, "category");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new d(this, context, iVar, (C2308e) null), 2, (Object) null);
    }

    public final boolean h() {
        return this.f24255f;
    }

    public final String i() {
        if (!(this.f24250a.getValue() instanceof O.c)) {
            return null;
        }
        Object value = this.f24250a.getValue();
        t.c(value, "null cannot be cast to non-null type com.uptodown.util.Result.Success<com.uptodown.fragments.TopByCategoryViewModel.TopByCategoryData>");
        if (((a) ((O.c) value).a()).b().b().i()) {
            return "floatingCategory";
        }
        return "leafCategory";
    }

    public final D j() {
        return this.f24251b;
    }

    public final boolean k() {
        return this.f24256g;
    }

    public final boolean l() {
        return this.f24254e;
    }

    public final boolean m() {
        return this.f24257h;
    }

    public final D o() {
        return this.f24253d;
    }

    public final void p(Context context, int i5) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new e(this, context, i5, (C2308e) null), 2, (Object) null);
    }

    public final void q(Context context, C2657f fVar, String str) {
        t.e(context, "context");
        t.e(fVar, "appInfo");
        t.e(str, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        if (fVar.N0()) {
            C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new f(this, context, fVar, str, (C2308e) null), 2, (Object) null);
        }
    }

    public final void r(Context context, int i5) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new g(context, i5, this, (C2308e) null), 2, (Object) null);
    }

    public final void s(boolean z4) {
        this.f24255f = z4;
    }

    public final void t(boolean z4) {
        this.f24256g = z4;
    }

    public final void u(boolean z4) {
        this.f24254e = z4;
    }

    public final void v(boolean z4) {
        this.f24257h = z4;
    }
}
