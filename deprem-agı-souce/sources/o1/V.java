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

public final class V extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f3491a;

    /* renamed from: b  reason: collision with root package name */
    private final D f3492b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f3493c;

    /* renamed from: d  reason: collision with root package name */
    private final D f3494d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3495e;

    /* renamed from: f  reason: collision with root package name */
    private int f3496f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3497g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3498h;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f3499a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ V f3500b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f3501c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f3502d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(V v5, Context context, String str, C2308e eVar) {
            super(2, eVar);
            this.f3500b = v5;
            this.f3501c = context;
            this.f3502d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f3500b, this.f3501c, this.f3502d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            C2316b.f();
            if (this.f3499a == 0) {
                u.b(obj);
                this.f3500b.f3493c.setValue(kotlin.coroutines.jvm.internal.b.b(0));
                M k5 = new Z(this.f3501c).k(this.f3502d);
                if (!(k5.b() || (d5 = k5.d()) == null || d5.length() == 0)) {
                    this.f3500b.f3493c.setValue(kotlin.coroutines.jvm.internal.b.b(1));
                }
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
        int f3503a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ V f3504b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f3505c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f3506d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(V v5, Context context, String str, C2308e eVar) {
            super(2, eVar);
            this.f3504b = v5;
            this.f3505c = context;
            this.f3506d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f3504b, this.f3505c, this.f3506d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            JSONArray jSONArray;
            C2316b.f();
            if (this.f3503a == 0) {
                u.b(obj);
                this.f3504b.n(true);
                ArrayList arrayList = new ArrayList();
                M B4 = new Z(this.f3505c).B(40, this.f3504b.j(), this.f3506d);
                if (B4.b() || B4.e() == null) {
                    this.f3504b.m(false);
                } else {
                    JSONObject e5 = B4.e();
                    if (e5 != null) {
                        jSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    } else {
                        jSONArray = null;
                    }
                    if (jSONArray != null) {
                        arrayList.addAll(l2.V.f24870q.g(jSONArray));
                        V v5 = this.f3504b;
                        v5.o(v5.j() + arrayList.size());
                    }
                }
                this.f3504b.f3491a.setValue(new O.c(arrayList));
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
        int f3507a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ V f3508b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f3509c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f3510d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(V v5, Context context, String str, C2308e eVar) {
            super(2, eVar);
            this.f3508b = v5;
            this.f3509c = context;
            this.f3510d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f3508b, this.f3509c, this.f3510d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            JSONArray jSONArray;
            C2316b.f();
            if (this.f3507a == 0) {
                u.b(obj);
                this.f3508b.n(true);
                ArrayList arrayList = new ArrayList();
                M C4 = new Z(this.f3509c).C(40, this.f3508b.j(), this.f3510d);
                if (C4.b() || C4.e() == null) {
                    this.f3508b.m(false);
                } else {
                    JSONObject e5 = C4.e();
                    if (e5 != null) {
                        jSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    } else {
                        jSONArray = null;
                    }
                    if (jSONArray != null) {
                        arrayList.addAll(l2.V.f24870q.g(jSONArray));
                        V v5 = this.f3508b;
                        v5.o(v5.j() + arrayList.size());
                    }
                }
                this.f3508b.f3491a.setValue(new O.c(arrayList));
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
        int f3511a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ V f3512b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f3513c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f3514d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(V v5, Context context, String str, C2308e eVar) {
            super(2, eVar);
            this.f3512b = v5;
            this.f3513c = context;
            this.f3514d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f3512b, this.f3513c, this.f3514d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            C2316b.f();
            if (this.f3511a == 0) {
                u.b(obj);
                this.f3512b.f3493c.setValue(kotlin.coroutines.jvm.internal.b.b(0));
                M q12 = new Z(this.f3513c).q1(this.f3514d);
                if (!(q12.b() || (d5 = q12.d()) == null || d5.length() == 0)) {
                    this.f3512b.f3493c.setValue(kotlin.coroutines.jvm.internal.b.b(0));
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public V() {
        w a5 = F.a(O.a.f26507a);
        this.f3491a = a5;
        this.f3492b = a5;
        w a6 = F.a(0);
        this.f3493c = a6;
        this.f3494d = a6;
    }

    public final void c(Context context, String str) {
        t.e(context, "context");
        t.e(str, "userID");
        this.f3495e = true;
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new a(this, context, str, (C2308e) null), 2, (Object) null);
    }

    public final boolean d() {
        return this.f3495e;
    }

    public final D e() {
        return this.f3494d;
    }

    public final void f(Context context, String str) {
        t.e(context, "context");
        t.e(str, "userID");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, context, str, (C2308e) null), 2, (Object) null);
    }

    public final void g(Context context, String str) {
        t.e(context, "context");
        t.e(str, "userID");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new c(this, context, str, (C2308e) null), 2, (Object) null);
    }

    public final boolean h() {
        return this.f3497g;
    }

    public final boolean i() {
        return this.f3498h;
    }

    public final int j() {
        return this.f3496f;
    }

    public final D k() {
        return this.f3492b;
    }

    public final void l(boolean z4) {
        this.f3495e = z4;
    }

    public final void m(boolean z4) {
        this.f3497g = z4;
    }

    public final void n(boolean z4) {
        this.f3498h = z4;
    }

    public final void o(int i5) {
        this.f3496f = i5;
    }

    public final void p(Context context, String str) {
        t.e(context, "context");
        t.e(str, "userID");
        this.f3495e = true;
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new d(this, context, str, (C2308e) null), 2, (Object) null);
    }
}
