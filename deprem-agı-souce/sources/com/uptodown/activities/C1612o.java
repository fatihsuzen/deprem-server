package com.uptodown.activities;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import g2.C2395q;
import java.util.ArrayList;
import k2.W;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2647G;
import l2.C2671u;
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

/* renamed from: com.uptodown.activities.o  reason: case insensitive filesystem */
public final class C1612o extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15086a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15087b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15088c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final w f15089d;

    /* renamed from: e  reason: collision with root package name */
    private final D f15090e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15091f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final w f15092g;

    /* renamed from: h  reason: collision with root package name */
    private final D f15093h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15094i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final w f15095j;

    /* renamed from: k  reason: collision with root package name */
    private final D f15096k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f15097l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final int f15098m = 6;

    /* renamed from: com.uptodown.activities.o$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f15099a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15100b;

        public a(ArrayList arrayList, int i5) {
            t.e(arrayList, "list");
            this.f15099a = arrayList;
            this.f15100b = i5;
        }

        public final int a() {
            return this.f15100b;
        }

        public final ArrayList b() {
            return this.f15099a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.a(this.f15099a, aVar.f15099a) && this.f15100b == aVar.f15100b;
        }

        public int hashCode() {
            return (this.f15099a.hashCode() * 31) + this.f15100b;
        }

        public String toString() {
            return "UserListData(list=" + this.f15099a + ", appsCount=" + this.f15100b + ')';
        }
    }

    /* renamed from: com.uptodown.activities.o$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f15101a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15102b;

        public b(ArrayList arrayList, int i5) {
            t.e(arrayList, "list");
            this.f15101a = arrayList;
            this.f15102b = i5;
        }

        public final int a() {
            return this.f15102b;
        }

        public final ArrayList b() {
            return this.f15101a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return t.a(this.f15101a, bVar.f15101a) && this.f15102b == bVar.f15102b;
        }

        public int hashCode() {
            return (this.f15101a.hashCode() * 31) + this.f15102b;
        }

        public String toString() {
            return "UserPreregisterListData(list=" + this.f15101a + ", appsCount=" + this.f15102b + ')';
        }
    }

    /* renamed from: com.uptodown.activities.o$c */
    public static final class c implements W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1612o f15103a;

        c(C1612o oVar) {
            this.f15103a = oVar;
        }

        public void a() {
            this.f15103a.f15089d.setValue(new O.c(new a(new ArrayList(), 0)));
        }

        public void b(ArrayList arrayList, boolean z4, int i5) {
            t.e(arrayList, "userList");
            if (!arrayList.isEmpty()) {
                this.f15103a.f15089d.setValue(new O.c(new a(arrayList, i5)));
            } else {
                this.f15103a.f15089d.setValue(new O.c(new a(new ArrayList(), 0)));
            }
        }
    }

    /* renamed from: com.uptodown.activities.o$d */
    public static final class d implements W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1612o f15104a;

        d(C1612o oVar) {
            this.f15104a = oVar;
        }

        public void a() {
            this.f15104a.f15086a.setValue(new O.c(new a(new ArrayList(), 0)));
        }

        public void b(ArrayList arrayList, boolean z4, int i5) {
            t.e(arrayList, "userList");
            if (!arrayList.isEmpty()) {
                this.f15104a.f15086a.setValue(new O.c(new a(new ArrayList(arrayList), i5)));
            } else {
                this.f15104a.f15086a.setValue(new O.c(new a(new ArrayList(), 0)));
            }
        }
    }

    /* renamed from: com.uptodown.activities.o$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15105a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15106b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f15107c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1612o f15108d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, ArrayList arrayList, C1612o oVar, C2308e eVar) {
            super(2, eVar);
            this.f15106b = context;
            this.f15107c = arrayList;
            this.f15108d = oVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f15106b, this.f15107c, this.f15108d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15105a == 0) {
                u.b(obj);
                M v5 = new Z(this.f15106b).v();
                if (!v5.b() && v5.e() != null) {
                    JSONObject e5 = v5.e();
                    t.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                            C2671u.a aVar = C2671u.f25197e;
                            t.b(optJSONObject);
                            this.f15107c.add(aVar.a(optJSONObject));
                        }
                    }
                }
                this.f15108d.f15095j.setValue(new O.c(this.f15107c));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.o$f */
    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15109a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15110b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1612o f15111c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f15112d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Context context, C1612o oVar, ArrayList arrayList, C2308e eVar) {
            super(2, eVar);
            this.f15110b = context;
            this.f15111c = oVar;
            this.f15112d = arrayList;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f15110b, this.f15111c, this.f15112d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15109a == 0) {
                u.b(obj);
                M V4 = new Z(this.f15110b).V(this.f15111c.f15098m);
                int i5 = 0;
                if (!V4.b() && V4.e() != null) {
                    JSONObject e5 = V4.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("apps");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            while (i5 < length) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                                C2647G.a aVar = C2647G.f24762f;
                                t.b(optJSONObject2);
                                this.f15112d.add(aVar.b(optJSONObject2));
                                i5++;
                            }
                        }
                        i5 = optJSONObject.optInt("countApps");
                    }
                }
                this.f15111c.f15092g.setValue(new O.c(new b(this.f15112d, i5)));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C1612o() {
        O.a aVar = O.a.f26507a;
        w a5 = F.a(aVar);
        this.f15086a = a5;
        this.f15087b = a5;
        w a6 = F.a(aVar);
        this.f15089d = a6;
        this.f15090e = a6;
        w a7 = F.a(aVar);
        this.f15092g = a7;
        this.f15093h = a7;
        w a8 = F.a(aVar);
        this.f15095j = a8;
        this.f15096k = a8;
    }

    private final void h(Context context) {
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new e(context, new ArrayList(), this, (C2308e) null), 2, (Object) null);
    }

    private final void k(Context context) {
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new f(context, this, new ArrayList(), (C2308e) null), 2, (Object) null);
    }

    public final void f(Context context) {
        t.e(context, "context");
        new g2.w(context, ViewModelKt.getViewModelScope(this)).j(this.f15098m, 0, new d(this));
        new C2395q(context, ViewModelKt.getViewModelScope(this)).d(this.f15098m, 0, new c(this));
        k(context);
        h(context);
    }

    public final D g() {
        return this.f15096k;
    }

    public final D i() {
        return this.f15093h;
    }

    public final D j() {
        return this.f15090e;
    }

    public final D l() {
        return this.f15087b;
    }

    public final boolean m() {
        return this.f15097l;
    }

    public final boolean n() {
        return this.f15094i;
    }

    public final boolean o() {
        return this.f15091f;
    }

    public final boolean p() {
        return this.f15088c;
    }

    public final void q(boolean z4) {
        this.f15097l = z4;
    }

    public final void r(boolean z4) {
        this.f15094i = z4;
    }

    public final void s(boolean z4) {
        this.f15091f = z4;
    }

    public final void t(boolean z4) {
        this.f15088c = z4;
    }
}
