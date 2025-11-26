package k4;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

public final class v extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f24660a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f24661b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f24662c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f24663d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(String str, String str2, String str3, C2308e eVar) {
        super(2, eVar);
        this.f24661b = str;
        this.f24662c = str2;
        this.f24663d = str3;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new v(this.f24661b, this.f24662c, this.f24663d, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((v) create((M) obj, (C2308e) obj2)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f24660a;
        if (i5 == 0) {
            u.b(obj);
            l lVar = z.f24677b;
            Boolean a5 = b.a(false);
            String str = this.f24661b;
            String str2 = this.f24662c;
            String str3 = this.f24663d;
            this.f24660a = 1;
            if (l.e(lVar, a5, str, str2, str3, true, this, 16) == f5) {
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
