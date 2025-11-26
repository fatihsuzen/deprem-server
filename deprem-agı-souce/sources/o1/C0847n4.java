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

/* renamed from: O1.n4  reason: case insensitive filesystem */
public final class C0847n4 extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f3729a;

    /* renamed from: b  reason: collision with root package name */
    private final D f3730b;

    /* renamed from: c  reason: collision with root package name */
    private w f3731c = F.a("");

    /* renamed from: d  reason: collision with root package name */
    private boolean f3732d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3733e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f3734f;

    /* renamed from: O1.n4$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f3735a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C0847n4 f3736b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f3737c;

        /* renamed from: O1.n4$a$a  reason: collision with other inner class name */
        public static final class C0054a implements W {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C0847n4 f3738a;

            C0054a(C0847n4 n4Var) {
                this.f3738a = n4Var;
            }

            public void a() {
                this.f3738a.f3729a.setValue(O.b.f26508a);
                this.f3738a.j(false);
            }

            public void b(ArrayList arrayList, boolean z4, int i5) {
                t.e(arrayList, "userList");
                if (arrayList.size() > 0) {
                    C0847n4 n4Var = this.f3738a;
                    n4Var.f3734f = n4Var.f3734f + arrayList.size();
                    this.f3738a.f3729a.setValue(new O.c(arrayList));
                } else if (this.f3738a.f3734f == 0) {
                    this.f3738a.f3729a.setValue(new O.c(new ArrayList()));
                } else {
                    this.f3738a.i(true);
                    this.f3738a.f3729a.setValue(O.b.f26508a);
                }
                this.f3738a.j(false);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C0847n4 n4Var, Context context, C2308e eVar) {
            super(2, eVar);
            this.f3736b = n4Var;
            this.f3737c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f3736b, this.f3737c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f3735a == 0) {
                u.b(obj);
                this.f3736b.j(true);
                this.f3736b.f3729a.setValue(O.a.f26507a);
                new C2395q(this.f3737c, ViewModelKt.getViewModelScope(this.f3736b)).e((String) this.f3736b.h().getValue(), 30, this.f3736b.f3734f, new C0054a(this.f3736b));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C0847n4() {
        w a5 = F.a(O.a.f26507a);
        this.f3729a = a5;
        this.f3730b = a5;
    }

    public final void d(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new a(this, context, (C2308e) null), 2, (Object) null);
    }

    public final boolean e() {
        return this.f3732d;
    }

    public final boolean f() {
        return this.f3733e;
    }

    public final D g() {
        return this.f3730b;
    }

    public final w h() {
        return this.f3731c;
    }

    public final void i(boolean z4) {
        this.f3732d = z4;
    }

    public final void j(boolean z4) {
        this.f3733e = z4;
    }
}
