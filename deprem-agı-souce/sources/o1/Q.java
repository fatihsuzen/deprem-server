package O1;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2672v;
import l2.M;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class Q extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f3399a;

    /* renamed from: b  reason: collision with root package name */
    private final D f3400b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f3401c;

    /* renamed from: d  reason: collision with root package name */
    private final D f3402d;

    /* renamed from: e  reason: collision with root package name */
    private int f3403e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3404f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3405g;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f3406a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Q f3407b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f3408c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Q q5, Context context, C2308e eVar) {
            super(2, eVar);
            this.f3407b = q5;
            this.f3408c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f3407b, this.f3408c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            JSONArray jSONArray;
            C2316b.f();
            if (this.f3406a == 0) {
                u.b(obj);
                this.f3407b.l(true);
                this.f3407b.f3399a.setValue(O.a.f26507a);
                ArrayList arrayList = new ArrayList();
                M x4 = new Z(this.f3408c).x(20, this.f3407b.j());
                if (x4.b() || x4.e() == null) {
                    this.f3407b.k(false);
                } else {
                    JSONObject e5 = x4.e();
                    if (e5 != null) {
                        jSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    } else {
                        jSONArray = null;
                    }
                    if (jSONArray != null) {
                        arrayList.addAll(C2672v.f25202y.b(jSONArray));
                        Q q5 = this.f3407b;
                        q5.m(q5.j() + arrayList.size());
                    }
                }
                this.f3407b.f3399a.setValue(new O.c(arrayList));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f3409a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Q f3410b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f3411c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f3412d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Q q5, Context context, String str, C2308e eVar) {
            super(2, eVar);
            this.f3410b = q5;
            this.f3411c = context;
            this.f3412d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f3410b, this.f3411c, this.f3412d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            C2316b.f();
            if (this.f3409a == 0) {
                u.b(obj);
                this.f3410b.f3401c.setValue(kotlin.coroutines.jvm.internal.b.b(0));
                M k5 = new Z(this.f3411c).k(this.f3412d);
                if (!k5.b() && (d5 = k5.d()) != null && d5.length() != 0) {
                    this.f3410b.f3401c.setValue(kotlin.coroutines.jvm.internal.b.b(1));
                } else if (k5.f() == 409) {
                    this.f3410b.f3401c.setValue(kotlin.coroutines.jvm.internal.b.b(2));
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public Q() {
        w a5 = F.a(O.b.f26508a);
        this.f3399a = a5;
        this.f3400b = a5;
        w a6 = F.a(0);
        this.f3401c = a6;
        this.f3402d = a6;
    }

    public final void c(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new a(this, context, (C2308e) null), 2, (Object) null);
    }

    public final void d(Context context) {
        t.e(context, "context");
        this.f3403e = 0;
        this.f3404f = true;
        c(context);
    }

    public final void e(Context context, String str) {
        t.e(context, "context");
        t.e(str, "userID");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, context, str, (C2308e) null), 2, (Object) null);
    }

    public final D f() {
        return this.f3400b;
    }

    public final D g() {
        return this.f3402d;
    }

    public final boolean h() {
        return this.f3404f;
    }

    public final boolean i() {
        return this.f3405g;
    }

    public final int j() {
        return this.f3403e;
    }

    public final void k(boolean z4) {
        this.f3404f = z4;
    }

    public final void l(boolean z4) {
        this.f3405g = z4;
    }

    public final void m(int i5) {
        this.f3403e = i5;
    }
}
