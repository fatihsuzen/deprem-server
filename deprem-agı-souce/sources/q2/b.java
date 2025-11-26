package Q2;

import W2.J;
import W2.u;
import android.graphics.Bitmap;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.C2865c0;
import w3.C2872g;
import w3.I0;
import w3.M;

public final class b extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f18903a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bitmap f18904b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m f18905c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Bitmap bitmap, m mVar, C2308e eVar) {
        super(2, eVar);
        this.f18904b = bitmap;
        this.f18905c = mVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new b(this.f18904b, this.f18905c, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new b(this.f18904b, this.f18905c, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f18903a;
        if (i5 == 0) {
            u.b(obj);
            I0 F4 = C2865c0.c().F();
            a aVar = new a(this.f18904b, this.f18905c, (C2308e) null);
            this.f18903a = 1;
            if (C2872g.g(F4, aVar, this) == f5) {
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
