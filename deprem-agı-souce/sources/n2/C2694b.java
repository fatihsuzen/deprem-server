package n2;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import o2.C2702a;
import q2.C2717d;
import r2.C2730a;
import w3.M;

/* renamed from: n2.b  reason: case insensitive filesystem */
public final class C2694b extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f25502a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2693a f25503b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f25504c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C2702a f25505d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2694b(C2693a aVar, String str, C2702a aVar2, C2308e eVar) {
        super(2, eVar);
        this.f25503b = aVar;
        this.f25504c = str;
        this.f25505d = aVar2;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new C2694b(this.f25503b, this.f25504c, this.f25505d, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((C2694b) create((M) obj, (C2308e) obj2)).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.f25502a;
        if (i5 == 0) {
            u.b(obj);
            C2717d b5 = new C2730a(this.f25503b.f25501a).b(this.f25504c);
            C2693a aVar = this.f25503b;
            C2702a aVar2 = this.f25505d;
            this.f25502a = 1;
            if (C2693a.b(aVar, b5, aVar2, this) == f5) {
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
