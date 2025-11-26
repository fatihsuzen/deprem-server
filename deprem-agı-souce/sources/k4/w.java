package k4;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.L;
import w3.M;

public final class w extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f24664a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ L f24665b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ L f24666c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f24667d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ boolean f24668e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(L l5, L l6, String str, boolean z4, C2308e eVar) {
        super(2, eVar);
        this.f24665b = l5;
        this.f24666c = l6;
        this.f24667d = str;
        this.f24668e = z4;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new w(this.f24665b, this.f24666c, this.f24667d, this.f24668e, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((w) create((M) obj, (C2308e) obj2)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f24664a;
        if (i5 == 0) {
            u.b(obj);
            l lVar = z.f24677b;
            this.f24664a = 1;
            if (lVar.d((h) this.f24665b.f24690a, (e) this.f24666c.f24690a, this.f24667d, !this.f24668e, this) == f5) {
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
