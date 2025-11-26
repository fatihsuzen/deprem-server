package com.uptodown.activities;

import W2.J;
import W2.u;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2668q;
import l2.T;
import l2.V;
import org.json.JSONObject;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import z2.C2962v;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class g0 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15011a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15012b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f15013c;

    /* renamed from: d  reason: collision with root package name */
    private final D f15014d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final w f15015e;

    /* renamed from: f  reason: collision with root package name */
    private final D f15016f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f15017a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15018b;

        public a(int i5, int i6) {
            this.f15017a = i5;
            this.f15018b = i6;
        }

        public final int a() {
            return this.f15017a;
        }

        public final int b() {
            return this.f15018b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f15017a == aVar.f15017a && this.f15018b == aVar.f15018b;
        }

        public int hashCode() {
            return (this.f15017a * 31) + this.f15018b;
        }

        public String toString() {
            return "UserNotifiersData(downloadsCount=" + this.f15017a + ", updatesCount=" + this.f15018b + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15019a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15020b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, C2308e eVar) {
            super(2, eVar);
            this.f15020b = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f15020b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15019a == 0) {
                u.b(obj);
                V.f24870q.b(this.f15020b);
                AccountManager accountManager = AccountManager.get(this.f15020b);
                String string = this.f15020b.getString(R.string.account);
                t.d(string, "getString(...)");
                Account[] accountsByType = accountManager.getAccountsByType(string);
                t.d(accountsByType, "getAccountsByType(...)");
                for (Account account : accountsByType) {
                    if (s.E(account.type, string, true)) {
                        accountManager.removeAccount(account, (Activity) null, (AccountManagerCallback) null, (Handler) null);
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

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15021a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15022b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g0 f15023c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, g0 g0Var, C2308e eVar) {
            super(2, eVar);
            this.f15022b = context;
            this.f15023c = g0Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f15022b, this.f15023c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15021a == 0) {
                u.b(obj);
                int a5 = T.f24856k.a(this.f15022b);
                this.f15023c.f15011a.setValue(new O.c(new a(C2668q.f25155w.a(this.f15022b), a5)));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15024a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15025b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g0 f15026c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, g0 g0Var, C2308e eVar) {
            super(2, eVar);
            this.f15025b = context;
            this.f15026c = g0Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f15025b, this.f15026c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15024a == 0) {
                u.b(obj);
                l2.M Y4 = new Z(this.f15025b).Y();
                if (!Y4.b() && Y4.e() != null) {
                    JSONObject e5 = Y4.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null && !optJSONObject.isNull("url")) {
                        this.f15026c.f15015e.setValue(new O.c(optJSONObject.optString("url")));
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15027a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15028b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g0 f15029c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, g0 g0Var, C2308e eVar) {
            super(2, eVar);
            this.f15028b = context;
            this.f15029c = g0Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f15028b, this.f15029c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String j5;
            String d5;
            C2316b.f();
            if (this.f15027a == 0) {
                u.b(obj);
                Z z4 = new Z(this.f15028b);
                V h5 = V.f24870q.h(this.f15028b);
                if (h5 == null || (j5 = h5.j()) == null || j5.length() == 0 || !h5.q()) {
                    this.f15029c.f15013c.setValue(new O.c(new C2962v().c(Z.f26527b.c(this.f15028b))));
                } else {
                    String j6 = h5.j();
                    t.b(j6);
                    l2.M j02 = z4.j0(j6);
                    if (!(j02.b() || (d5 = j02.d()) == null || d5.length() == 0)) {
                        String d6 = j02.d();
                        t.b(d6);
                        JSONObject optJSONObject = new JSONObject(d6).optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        if (optJSONObject != null && !optJSONObject.isNull("url")) {
                            this.f15029c.f15013c.setValue(new O.c(optJSONObject.optString("url")));
                        }
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public g0() {
        w a5 = F.a(O.b.f26508a);
        this.f15011a = a5;
        this.f15012b = a5;
        O.a aVar = O.a.f26507a;
        w a6 = F.a(aVar);
        this.f15013c = a6;
        this.f15014d = a6;
        w a7 = F.a(aVar);
        this.f15015e = a7;
        this.f15016f = a7;
    }

    public final void d(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(context, (C2308e) null), 2, (Object) null);
    }

    public final void e(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new c(context, this, (C2308e) null), 2, (Object) null);
    }

    public final D f() {
        return this.f15016f;
    }

    public final void g(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new d(context, this, (C2308e) null), 2, (Object) null);
    }

    public final D h() {
        return this.f15014d;
    }

    public final void i(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new e(context, this, (C2308e) null), 2, (Object) null);
    }

    public final D j() {
        return this.f15012b;
    }
}
