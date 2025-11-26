package u4;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import java.util.ArrayList;
import k3.p;
import k4.g;
import k4.o;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import m.h;
import r4.a;
import w3.M;

public final class e extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f26028a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f26029b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f26030c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(f fVar, boolean z4, C2308e eVar) {
        super(2, eVar);
        this.f26029b = fVar;
        this.f26030c = z4;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new e(this.f26029b, this.f26030c, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new e(this.f26029b, this.f26030c, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        ArrayList arrayList;
        Object f5 = C2316b.f();
        int i5 = this.f26028a;
        if (i5 == 0) {
            u.b(obj);
            k4.l lVar = this.f26029b.f26035e;
            Boolean a5 = b.a(!this.f26030c);
            String k5 = this.f26029b.f26031a.k(r4.b.PRIVACY_STRING);
            Boolean a6 = b.a(true);
            this.f26028a = 1;
            lVar.getClass();
            if (t.a(a5, b.a(true))) {
                str = "All";
            } else {
                str = "Reject";
            }
            String str3 = str;
            if (t.a(a5, b.a(true))) {
                str2 = "none";
            } else {
                str2 = "all";
            }
            String str4 = str2;
            String e5 = m.l.e();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(lVar.f24607h);
            if (m.l.f960a) {
                arrayList = new ArrayList();
                m.l.f961b.forEach(new h(arrayList));
            } else {
                arrayList = null;
            }
            o oVar = new o(arrayList2, str3, str4, (String) null, (String) null, (String) null, (String) null, (String) null, k5, e5, arrayList, (Boolean) null, 2296);
            if (t.a(a6, b.a(true))) {
                lVar.f24605f.j(r4.b.CCPA_CONSENT_EXPLICITLY, true);
            }
            a aVar = lVar.f24605f;
            r4.b bVar = r4.b.GBC_STATUS;
            if (e5 == null) {
                e5 = "";
            }
            aVar.i(bVar, e5);
            lVar.f24607h.clear();
            if (lVar.b(g.DONE, oVar, k4.h.CCPA, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }
}
