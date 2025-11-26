package k4;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

public final class x extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f24669a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f24670b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f24671c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f24672d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(String str, h hVar, boolean z4, C2308e eVar) {
        super(2, eVar);
        this.f24670b = str;
        this.f24671c = hVar;
        this.f24672d = z4;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new x(this.f24670b, this.f24671c, this.f24672d, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((x) create((M) obj, (C2308e) obj2)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f24669a;
        if (i5 == 0) {
            u.b(obj);
            l lVar = z.f24677b;
            String str = this.f24670b;
            h hVar = this.f24671c;
            boolean z4 = this.f24672d;
            this.f24669a = 1;
            if (lVar.a(str, hVar, z4, this) == f5) {
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
