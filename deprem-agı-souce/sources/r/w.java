package r;

import B.C0628a;
import T2.a;
import t.C1876b;
import x.e;
import y.r;
import y.v;

public final class w implements C1876b {

    /* renamed from: a  reason: collision with root package name */
    private final a f16305a;

    /* renamed from: b  reason: collision with root package name */
    private final a f16306b;

    /* renamed from: c  reason: collision with root package name */
    private final a f16307c;

    /* renamed from: d  reason: collision with root package name */
    private final a f16308d;

    /* renamed from: e  reason: collision with root package name */
    private final a f16309e;

    public w(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.f16305a = aVar;
        this.f16306b = aVar2;
        this.f16307c = aVar3;
        this.f16308d = aVar4;
        this.f16309e = aVar5;
    }

    public static w a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new w(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static u c(C0628a aVar, C0628a aVar2, e eVar, r rVar, v vVar) {
        return new u(aVar, aVar2, eVar, rVar, vVar);
    }

    /* renamed from: b */
    public u get() {
        return c((C0628a) this.f16305a.get(), (C0628a) this.f16306b.get(), (e) this.f16307c.get(), (r) this.f16308d.get(), (v) this.f16309e.get());
    }
}
