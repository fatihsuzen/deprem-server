package com.uptodown.activities;

import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.M;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.O;
import z2.Z;
import z3.D;
import z3.F;
import z3.w;

public final class C extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f13656a;

    /* renamed from: b  reason: collision with root package name */
    private final D f13657b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f13658a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f13659b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13660c;

        public a(int i5, boolean z4, String str) {
            this.f13658a = i5;
            this.f13659b = z4;
            this.f13660c = str;
        }

        public final boolean a() {
            return this.f13659b;
        }

        public final String b() {
            return this.f13660c;
        }

        public final int c() {
            return this.f13658a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f13658a == aVar.f13658a && this.f13659b == aVar.f13659b && t.a(this.f13660c, aVar.f13660c);
        }

        public int hashCode() {
            int a5 = ((this.f13658a * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f13659b)) * 31;
            String str = this.f13660c;
            return a5 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "PasswordEditData(success=" + this.f13658a + ", error=" + this.f13659b + ", regErrors=" + this.f13660c + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13661a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C f13662b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f13663c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13664d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f13665e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ L f13666f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ J f13667g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C c5, Context context, String str, String str2, L l5, J j5, C2308e eVar) {
            super(2, eVar);
            this.f13662b = c5;
            this.f13663c = context;
            this.f13664d = str;
            this.f13665e = str2;
            this.f13666f = l5;
            this.f13667g = j5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f13662b, this.f13663c, this.f13664d, this.f13665e, this.f13666f, this.f13667g, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f13661a == 0) {
                u.b(obj);
                this.f13662b.f13656a.setValue(O.a.f26507a);
                M g5 = new Z(this.f13663c).g(this.f13664d, this.f13665e);
                if (!g5.b() && g5.e() != null) {
                    JSONObject e5 = g5.e();
                    t.b(e5);
                    this.f13666f.f24690a = g5.g(e5);
                    this.f13667g.f24688a = e5.optInt("success");
                }
                this.f13662b.f13656a.setValue(new O.c(new a(this.f13667g.f24688a, g5.b(), (String) this.f13666f.f24690a)));
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public C() {
        w a5 = F.a(O.b.f26508a);
        this.f13656a = a5;
        this.f13657b = a5;
    }

    public final void b(Context context, String str, String str2) {
        t.e(context, "context");
        t.e(str, "newPassword");
        t.e(str2, "confirmNewPassword");
        J j5 = new J();
        L l5 = new L();
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, context, str, str2, l5, j5, (C2308e) null), 2, (Object) null);
    }

    public final D c() {
        return this.f13657b;
    }
}
