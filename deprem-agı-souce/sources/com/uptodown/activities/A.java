package com.uptodown.activities;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.UptodownApp;
import g2.C2387i;
import java.io.File;
import java.util.ArrayList;
import k2.C2584A;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import l2.C2668q;
import t3.s;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import z2.C2940B;
import z2.C2954m;
import z2.O;
import z3.D;
import z3.F;
import z3.w;

public final class A extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f13532a;

    /* renamed from: b  reason: collision with root package name */
    private final D f13533b;

    /* renamed from: c  reason: collision with root package name */
    private final w f13534c = F.a((Object) null);

    /* renamed from: d  reason: collision with root package name */
    private final w f13535d = F.a((Object) null);

    /* renamed from: e  reason: collision with root package name */
    private boolean f13536e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13537f;

    /* renamed from: g  reason: collision with root package name */
    private int f13538g;

    /* renamed from: h  reason: collision with root package name */
    private int f13539h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final C2655d f13540a;

        /* renamed from: b  reason: collision with root package name */
        private final C2657f f13541b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f13542c;

        public a(C2655d dVar, C2657f fVar, boolean z4) {
            t.e(fVar, "appInfo");
            this.f13540a = dVar;
            this.f13541b = fVar;
            this.f13542c = z4;
        }

        public final C2655d a() {
            return this.f13540a;
        }

        public final C2657f b() {
            return this.f13541b;
        }

        public final boolean c() {
            return this.f13542c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return t.a(this.f13540a, aVar.f13540a) && t.a(this.f13541b, aVar.f13541b) && this.f13542c == aVar.f13542c;
        }

        public int hashCode() {
            C2655d dVar = this.f13540a;
            return ((((dVar == null ? 0 : dVar.hashCode()) * 31) + this.f13541b.hashCode()) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f13542c);
        }

        public String toString() {
            return "OldVersionsData(app=" + this.f13540a + ", appInfo=" + this.f13541b + ", isOldVersionsAvailable=" + this.f13542c + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f13543a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ A f13544b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f13545c;

        public static final class a implements C2584A {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ A f13546a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2655d f13547b;

            a(A a5, C2655d dVar) {
                this.f13546a = a5;
                this.f13547b = dVar;
            }

            public void a(ArrayList arrayList) {
                t.e(arrayList, "oldVersions");
                Object value = this.f13546a.d().getValue();
                t.b(value);
                ((C2657f) value).U0(arrayList);
                w a5 = this.f13546a.f13532a;
                C2655d dVar = this.f13547b;
                Object value2 = this.f13546a.d().getValue();
                t.b(value2);
                a5.setValue(new O.c(new a(dVar, (C2657f) value2, true)));
            }

            public void b() {
                w a5 = this.f13546a.f13532a;
                C2655d dVar = this.f13547b;
                Object value = this.f13546a.d().getValue();
                t.b(value);
                a5.setValue(new O.c(new a(dVar, (C2657f) value, false)));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(A a5, Context context, C2308e eVar) {
            super(2, eVar);
            this.f13544b = a5;
            this.f13545c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f13544b, this.f13545c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            C2316b.f();
            if (this.f13543a == 0) {
                u.b(obj);
                if (this.f13544b.g()) {
                    this.f13544b.f13532a.setValue(O.a.f26507a);
                }
                C2954m mVar = new C2954m();
                Context context = this.f13545c;
                C2657f fVar = (C2657f) this.f13544b.d().getValue();
                if (fVar != null) {
                    str = fVar.S();
                } else {
                    str = null;
                }
                C2655d C4 = mVar.C(context, str);
                M viewModelScope = ViewModelKt.getViewModelScope(this.f13544b);
                Context context2 = this.f13545c;
                Object value = this.f13544b.d().getValue();
                t.b(value);
                new C2387i(viewModelScope, context2, (C2657f) value, new a(this.f13544b, C4), this.f13544b.h());
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
        int f13548a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ A f13549b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13550c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f13551d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(A a5, String str, Context context, C2308e eVar) {
            super(2, eVar);
            this.f13549b = a5;
            this.f13550c = str;
            this.f13551d = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f13549b, this.f13550c, this.f13551d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            File n5;
            C2316b.f();
            if (this.f13548a == 0) {
                u.b(obj);
                Object value = this.f13549b.d().getValue();
                t.b(value);
                if (((C2657f) value).S() != null) {
                    Object value2 = this.f13549b.d().getValue();
                    t.b(value2);
                    if (s.E(((C2657f) value2).S(), this.f13550c, true)) {
                        int i5 = com.uptodown.activities.preferences.a.f15150a.i(this.f13551d);
                        C2940B a5 = C2940B.f26458v.a(this.f13551d);
                        a5.a();
                        C2668q i02 = a5.i0(i5);
                        a5.m();
                        if (!(i02 == null || !s.E(i02.w(), this.f13550c, true) || (n5 = i02.n()) == null)) {
                            UptodownApp.a aVar = UptodownApp.f13477F;
                            Context context = this.f13551d;
                            Object value3 = this.f13549b.d().getValue();
                            t.b(value3);
                            aVar.W(n5, context, ((C2657f) value3).O());
                        }
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public A() {
        w a5 = F.a(O.a.f26507a);
        this.f13532a = a5;
        this.f13533b = a5;
    }

    public final void b(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, context, (C2308e) null), 2, (Object) null);
    }

    public final w c() {
        return this.f13534c;
    }

    public final w d() {
        return this.f13535d;
    }

    public final D e() {
        return this.f13533b;
    }

    public final boolean f() {
        return this.f13537f;
    }

    public final boolean g() {
        return this.f13536e;
    }

    public final int h() {
        return this.f13538g;
    }

    public final int i() {
        return this.f13539h;
    }

    public final void j(Context context, String str) {
        t.e(context, "context");
        t.e(str, "packageName");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new c(this, str, context, (C2308e) null), 2, (Object) null);
    }

    public final void k(boolean z4) {
        this.f13537f = z4;
    }

    public final void l(boolean z4) {
        this.f13536e = z4;
    }

    public final void m(int i5) {
        this.f13538g = i5;
    }

    public final void n(int i5) {
        this.f13539h = i5;
    }
}
