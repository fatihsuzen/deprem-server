package g2;

import W2.J;
import W2.u;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import b2.C2301u;
import b3.C2308e;
import c3.C2316b;
import java.util.ArrayList;
import k2.C2597g;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2655d;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.C2954m;

/* renamed from: g2.a  reason: case insensitive filesystem */
public final class C2379a {

    /* renamed from: g2.a$a  reason: collision with other inner class name */
    static final class C0224a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21664a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f21665b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2597g f21666c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0224a(Context context, C2597g gVar, C2308e eVar) {
            super(2, eVar);
            this.f21665b = context;
            this.f21666c = gVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C0224a(this.f21665b, this.f21666c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            ApplicationInfo applicationInfo;
            C2316b.f();
            if (this.f21664a == 0) {
                u.b(obj);
                ArrayList D4 = new C2954m().D(this.f21665b);
                C2940B a5 = C2940B.f26458v.a(this.f21665b);
                a5.a();
                Context context = this.f21665b;
                C2597g gVar = this.f21666c;
                int size = D4.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj2 = D4.get(i5);
                    i5++;
                    C2655d dVar = (C2655d) obj2;
                    String o5 = dVar.o();
                    if (!(o5 == null || o5.length() == 0)) {
                        try {
                            PackageManager packageManager = context.getPackageManager();
                            t.d(packageManager, "getPackageManager(...)");
                            String o6 = dVar.o();
                            t.b(o6);
                            applicationInfo = C2301u.a(packageManager, o6, 128);
                        } catch (PackageManager.NameNotFoundException unused) {
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            long d5 = new C2954m().d(applicationInfo);
                            if (dVar.t() != d5) {
                                dVar.b0(d5);
                                a5.y1(dVar);
                                String o7 = dVar.o();
                                t.b(o7);
                                gVar.a(o7, d5);
                            }
                        }
                    }
                }
                a5.m();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((C0224a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C2379a(C2597g gVar, M m5, Context context) {
        t.e(gVar, "listener");
        t.e(m5, "scope");
        t.e(context, "context");
        C2908y0 unused = C2876i.d(m5, C2865c0.b(), (O) null, new C0224a(context, gVar, (C2308e) null), 2, (Object) null);
    }
}
