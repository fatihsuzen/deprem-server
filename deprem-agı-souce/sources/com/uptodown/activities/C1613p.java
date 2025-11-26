package com.uptodown.activities;

import W2.u;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.regex.Pattern;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.M;
import l2.V;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import z2.F;
import z2.O;
import z2.Z;
import z3.D;
import z3.w;

/* renamed from: com.uptodown.activities.p  reason: case insensitive filesystem */
public final class C1613p extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15113a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15114b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f15115c;

    /* renamed from: d  reason: collision with root package name */
    private final D f15116d;

    /* renamed from: com.uptodown.activities.p$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f15117a;

        /* renamed from: b  reason: collision with root package name */
        private final String f15118b;

        /* renamed from: c  reason: collision with root package name */
        private final String f15119c;

        public a(int i5, String str, String str2) {
            this.f15117a = i5;
            this.f15118b = str;
            this.f15119c = str2;
        }

        public final String a() {
            return this.f15118b;
        }

        public final String b() {
            return this.f15119c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f15117a == aVar.f15117a && t.a(this.f15118b, aVar.f15118b) && t.a(this.f15119c, aVar.f15119c);
        }

        public int hashCode() {
            int i5 = this.f15117a * 31;
            String str = this.f15118b;
            int i6 = 0;
            int hashCode = (i5 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f15119c;
            if (str2 != null) {
                i6 = str2.hashCode();
            }
            return hashCode + i6;
        }

        public String toString() {
            return "LoginData(loginResult=" + this.f15117a + ", loginMessage=" + this.f15118b + ", regErrors=" + this.f15119c + ')';
        }
    }

    /* renamed from: com.uptodown.activities.p$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f15120a;

        /* renamed from: b  reason: collision with root package name */
        private final String f15121b;

        /* renamed from: c  reason: collision with root package name */
        private final String f15122c;

        public b(int i5, String str, String str2) {
            this.f15120a = i5;
            this.f15121b = str;
            this.f15122c = str2;
        }

        public final String a() {
            return this.f15122c;
        }

        public final String b() {
            return this.f15121b;
        }

        public final int c() {
            return this.f15120a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f15120a == bVar.f15120a && t.a(this.f15121b, bVar.f15121b) && t.a(this.f15122c, bVar.f15122c);
        }

        public int hashCode() {
            int i5 = this.f15120a * 31;
            String str = this.f15121b;
            int i6 = 0;
            int hashCode = (i5 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f15122c;
            if (str2 != null) {
                i6 = str2.hashCode();
            }
            return hashCode + i6;
        }

        public String toString() {
            return "SignUpData(success=" + this.f15120a + ", signUpMessage=" + this.f15121b + ", regErrors=" + this.f15122c + ')';
        }
    }

    /* renamed from: com.uptodown.activities.p$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15123a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1613p f15124b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f15125c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f15126d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f15127e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ L f15128f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ J f15129g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ L f15130h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ L f15131i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C1613p pVar, Context context, String str, String str2, L l5, J j5, L l6, L l7, C2308e eVar) {
            super(2, eVar);
            this.f15124b = pVar;
            this.f15125c = context;
            this.f15126d = str;
            this.f15127e = str2;
            this.f15128f = l5;
            this.f15129g = j5;
            this.f15130h = l6;
            this.f15131i = l7;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f15124b, this.f15125c, this.f15126d, this.f15127e, this.f15128f, this.f15129g, this.f15130h, this.f15131i, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15123a == 0) {
                u.b(obj);
                this.f15124b.f15113a.setValue(O.a.f26507a);
                M P02 = new Z(this.f15125c).P0(this.f15126d, this.f15127e);
                if (P02.e() != null) {
                    JSONObject e5 = P02.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        L l5 = this.f15128f;
                        V v5 = new V();
                        v5.g(this.f15125c, optJSONObject);
                        l5.f24690a = v5;
                        String L4 = com.uptodown.activities.preferences.a.f15150a.L(this.f15125c);
                        if (L4 == null || L4.length() == 0) {
                            V.f24870q.c(this.f15125c);
                        } else {
                            V v6 = (V) this.f15128f.f24690a;
                            if (v6 != null) {
                                v6.s(this.f15125c);
                            }
                            this.f15129g.f24688a = 1;
                        }
                        if (!optJSONObject.isNull("message")) {
                            this.f15130h.f24690a = optJSONObject.optString("message");
                        }
                    }
                    this.f15131i.f24690a = P02.g(e5);
                }
                if (this.f15128f.f24690a != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
                    bundle.putString("loginSource", "signin");
                    new F(this.f15125c).d("login", bundle);
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("responseCode", String.valueOf(P02.f()));
                    String c5 = P02.c();
                    if (!(c5 == null || c5.length() == 0)) {
                        String c6 = P02.c();
                        t.b(c6);
                        bundle2.putString("exception", c6);
                    }
                    bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
                    bundle2.putString("loginSource", "signin");
                    new F(this.f15125c).d("login", bundle2);
                }
                this.f15124b.f15113a.setValue(new O.c(new a(this.f15129g.f24688a, (String) this.f15130h.f24690a, (String) this.f15131i.f24690a)));
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.p$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15132a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1613p f15133b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f15134c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f15135d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f15136e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f15137f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ J f15138g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ L f15139h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ L f15140i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C1613p pVar, Context context, String str, String str2, String str3, J j5, L l5, L l6, C2308e eVar) {
            super(2, eVar);
            this.f15133b = pVar;
            this.f15134c = context;
            this.f15135d = str;
            this.f15136e = str2;
            this.f15137f = str3;
            this.f15138g = j5;
            this.f15139h = l5;
            this.f15140i = l6;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f15133b, this.f15134c, this.f15135d, this.f15136e, this.f15137f, this.f15138g, this.f15139h, this.f15140i, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15132a == 0) {
                u.b(obj);
                this.f15133b.f15115c.setValue(O.a.f26507a);
                M n12 = new Z(this.f15134c).n1(this.f15135d, this.f15136e, this.f15137f);
                if (n12.e() != null) {
                    JSONObject e5 = n12.e();
                    t.b(e5);
                    if (!e5.isNull("success")) {
                        this.f15138g.f24688a = e5.optInt("success");
                    }
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null && !optJSONObject.isNull("message")) {
                        this.f15139h.f24690a = optJSONObject.optString("message");
                    }
                    this.f15140i.f24690a = n12.g(e5);
                }
                if (this.f15138g.f24688a == 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
                    bundle.putString("loginSource", "signup");
                    new F(this.f15134c).d("login", bundle);
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
                    bundle2.putString("loginSource", "signup");
                    bundle2.putString("responseCode", String.valueOf(n12.f()));
                    if (n12.c() != null) {
                        String c5 = n12.c();
                        t.b(c5);
                        bundle2.putString("exception", c5);
                    }
                    new F(this.f15134c).d("login", bundle2);
                }
                this.f15133b.f15115c.setValue(new O.c(new b(this.f15138g.f24688a, (String) this.f15139h.f24690a, (String) this.f15140i.f24690a)));
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public C1613p() {
        O.b bVar = O.b.f26508a;
        w a5 = z3.F.a(bVar);
        this.f15113a = a5;
        this.f15114b = a5;
        w a6 = z3.F.a(bVar);
        this.f15115c = a6;
        this.f15116d = a6;
    }

    public final void c(Context context, String str, String str2) {
        t.e(context, "context");
        t.e(str, "username");
        t.e(str2, "password");
        J j5 = new J();
        j5.f24688a = -2;
        L l5 = new L();
        L l6 = new L();
        L l7 = new L();
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new c(this, context, str, str2, l7, j5, l5, l6, (C2308e) null), 2, (Object) null);
    }

    public final void d(Context context, String str, String str2, String str3) {
        t.e(context, "context");
        t.e(str, "username");
        t.e(str2, NotificationCompat.CATEGORY_EMAIL);
        String str4 = str3;
        t.e(str4, "pass");
        L l5 = new L();
        J j5 = new J();
        L l6 = new L();
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new d(this, context, str, str4, str2, j5, l5, l6, (C2308e) null), 2, (Object) null);
    }

    public final D e() {
        return this.f15114b;
    }

    public final D f() {
        return this.f15116d;
    }

    public final boolean g(String str, String str2) {
        t.e(str, "username");
        t.e(str2, "password");
        if (str.length() <= 0 || str2.length() <= 0) {
            return false;
        }
        return true;
    }

    public final boolean h(String str, String str2, String str3) {
        t.e(str, "username");
        t.e(str2, NotificationCompat.CATEGORY_EMAIL);
        t.e(str3, "password");
        if (str.length() <= 0 || str2.length() <= 0 || str3.length() <= 5) {
            return false;
        }
        return true;
    }

    public final boolean i(String str) {
        t.e(str, NotificationCompat.CATEGORY_EMAIL);
        return Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@“]+(\\.[^<>()\\[\\]\\\\.,;:\\s@“]+)*)|(“.+“))@((\\[\\d{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(str).matches();
    }
}
