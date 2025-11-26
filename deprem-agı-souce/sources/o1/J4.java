package O1;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import g2.C2395q;
import java.util.ArrayList;
import k2.T;
import k2.W;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import z2.O;
import z3.D;
import z3.F;
import z3.w;

public final class J4 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f3302a;

    /* renamed from: b  reason: collision with root package name */
    private final D f3303b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final w f3304c;

    /* renamed from: d  reason: collision with root package name */
    private final D f3305d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3306e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3307f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f3308g;

    public static final class a implements T {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ J4 f3309a;

        a(J4 j42) {
            this.f3309a = j42;
        }

        public void c() {
            this.f3309a.f3304c.setValue(Boolean.FALSE);
        }

        public void g() {
            this.f3309a.f3304c.setValue(Boolean.TRUE);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f3310a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ J4 f3311b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f3312c;

        public static final class a implements W {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ J4 f3313a;

            a(J4 j42) {
                this.f3313a = j42;
            }

            public void a() {
                this.f3313a.f3302a.setValue(new O.c(new ArrayList()));
                this.f3313a.l(false);
            }

            public void b(ArrayList arrayList, boolean z4, int i5) {
                t.e(arrayList, "userList");
                if (!arrayList.isEmpty()) {
                    J4 j42 = this.f3313a;
                    j42.f3308g = j42.f3308g + arrayList.size();
                    this.f3313a.f3302a.setValue(new O.c(arrayList));
                    this.f3313a.f3304c.setValue(Boolean.valueOf(z4));
                } else if (this.f3313a.f3308g == 0) {
                    this.f3313a.f3302a.setValue(new O.c(new ArrayList()));
                } else {
                    this.f3313a.k(true);
                    this.f3313a.f3302a.setValue(O.b.f26508a);
                }
                this.f3313a.l(false);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(J4 j42, Context context, C2308e eVar) {
            super(2, eVar);
            this.f3311b = j42;
            this.f3312c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f3311b, this.f3312c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f3310a == 0) {
                u.b(obj);
                this.f3311b.l(true);
                this.f3311b.f3302a.setValue(O.a.f26507a);
                new C2395q(this.f3312c, ViewModelKt.getViewModelScope(this.f3311b)).d(30, this.f3311b.f3308g, new a(this.f3311b));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public J4() {
        w a5 = F.a(O.a.f26507a);
        this.f3302a = a5;
        this.f3303b = a5;
        w a6 = F.a(Boolean.TRUE);
        this.f3304c = a6;
        this.f3305d = a6;
    }

    public final void e(Context context) {
        t.e(context, "context");
        a aVar = new a(this);
        if (((Boolean) this.f3304c.getValue()).booleanValue()) {
            new C2395q(context, ViewModelKt.getViewModelScope(this)).g(aVar);
        } else {
            new C2395q(context, ViewModelKt.getViewModelScope(this)).f(aVar);
        }
    }

    public final void f(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(this, context, (C2308e) null), 2, (Object) null);
    }

    public final boolean g() {
        return this.f3306e;
    }

    public final boolean h() {
        return this.f3307f;
    }

    public final D i() {
        return this.f3303b;
    }

    public final D j() {
        return this.f3305d;
    }

    public final void k(boolean z4) {
        this.f3306e = z4;
    }

    public final void l(boolean z4) {
        this.f3307f = z4;
    }
}
