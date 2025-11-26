package com.uptodown.activities;

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
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2659h;
import l2.M;
import l2.V;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class c0 extends ViewModel {

    /* renamed from: f  reason: collision with root package name */
    public static final b f14933f = new b((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f14934a;

    /* renamed from: b  reason: collision with root package name */
    private final D f14935b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f14936c;

    /* renamed from: d  reason: collision with root package name */
    private final D f14937d;

    /* renamed from: e  reason: collision with root package name */
    private final w f14938e = F.a((Object) null);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f14939a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f14940b;

        public a(ArrayList arrayList, ArrayList arrayList2) {
            t.e(arrayList, "avatars");
            t.e(arrayList2, "turboAvatars");
            this.f14939a = arrayList;
            this.f14940b = arrayList2;
        }

        public final ArrayList a() {
            return this.f14939a;
        }

        public final ArrayList b() {
            return this.f14940b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.a(this.f14939a, aVar.f14939a) && t.a(this.f14940b, aVar.f14940b);
        }

        public int hashCode() {
            return (this.f14939a.hashCode() * 31) + this.f14940b.hashCode();
        }

        public String toString() {
            return "AvatarsData(avatars=" + this.f14939a + ", turboAvatars=" + this.f14940b + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private b() {
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f14941a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f14942b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f14943c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f14944d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c0 f14945e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, ArrayList arrayList, ArrayList arrayList2, c0 c0Var, C2308e eVar) {
            super(2, eVar);
            this.f14942b = context;
            this.f14943c = arrayList;
            this.f14944d = arrayList2;
            this.f14945e = c0Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f14942b, this.f14943c, this.f14944d, this.f14945e, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14941a == 0) {
                u.b(obj);
                M u02 = new Z(this.f14942b).u0();
                if (!u02.b() && u02.e() != null) {
                    JSONObject e5 = u02.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("basic");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i5 = 0; i5 < length; i5++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                                C2659h.a aVar = C2659h.f25088f;
                                t.b(optJSONObject2);
                                this.f14943c.add(aVar.a(optJSONObject2));
                            }
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("turbo");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i6 = 0; i6 < length2; i6++) {
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i6);
                                C2659h.a aVar2 = C2659h.f25088f;
                                t.b(optJSONObject3);
                                this.f14944d.add(aVar2.a(optJSONObject3));
                            }
                        }
                    }
                }
                this.f14945e.f14934a.setValue(new O.c(new a(this.f14943c, this.f14944d)));
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
        int f14946a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0 f14947b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f14948c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2659h f14949d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c0 c0Var, Context context, C2659h hVar, C2308e eVar) {
            super(2, eVar);
            this.f14947b = c0Var;
            this.f14948c = context;
            this.f14949d = hVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f14947b, this.f14948c, this.f14949d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14946a == 0) {
                u.b(obj);
                this.f14947b.f14936c.setValue(kotlin.coroutines.jvm.internal.b.a(false));
                M m12 = new Z(this.f14948c).m1(this.f14949d.d());
                if (!m12.b() && m12.e() != null) {
                    JSONObject e5 = m12.e();
                    t.b(e5);
                    if (e5.optInt("success") == 1) {
                        V v5 = (V) this.f14947b.f().getValue();
                        if (v5 != null) {
                            v5.u(this.f14949d.e());
                        }
                        V v6 = (V) this.f14947b.f().getValue();
                        if (v6 != null) {
                            v6.s(this.f14948c);
                        }
                        this.f14947b.f14936c.setValue(kotlin.coroutines.jvm.internal.b.a(true));
                    } else {
                        this.f14947b.f14936c.setValue(kotlin.coroutines.jvm.internal.b.a(false));
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public c0() {
        w a5 = F.a(O.a.f26507a);
        this.f14934a = a5;
        this.f14935b = a5;
        w a6 = F.a(Boolean.FALSE);
        this.f14936c = a6;
        this.f14937d = a6;
    }

    public final void c(Context context) {
        t.e(context, "context");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        w3.M viewModelScope = ViewModelKt.getViewModelScope(this);
        w3.M m5 = viewModelScope;
        C2908y0 unused = C2876i.d(m5, C2865c0.b(), (w3.O) null, new c(context, arrayList, arrayList2, this, (C2308e) null), 2, (Object) null);
    }

    public final D d() {
        return this.f14935b;
    }

    public final D e() {
        return this.f14937d;
    }

    public final w f() {
        return this.f14938e;
    }

    public final void g(Context context, C2659h hVar) {
        t.e(context, "context");
        t.e(hVar, "avatar");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new d(this, context, hVar, (C2308e) null), 2, (Object) null);
    }
}
