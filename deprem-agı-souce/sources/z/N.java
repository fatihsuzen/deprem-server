package z;

import B.C0628a;
import T2.a;
import t.C1876b;

public final class N implements C1876b {

    /* renamed from: a  reason: collision with root package name */
    private final a f17113a;

    /* renamed from: b  reason: collision with root package name */
    private final a f17114b;

    /* renamed from: c  reason: collision with root package name */
    private final a f17115c;

    /* renamed from: d  reason: collision with root package name */
    private final a f17116d;

    /* renamed from: e  reason: collision with root package name */
    private final a f17117e;

    public N(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.f17113a = aVar;
        this.f17114b = aVar2;
        this.f17115c = aVar3;
        this.f17116d = aVar4;
        this.f17117e = aVar5;
    }

    public static N a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new N(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static M c(C0628a aVar, C0628a aVar2, Object obj, Object obj2, a aVar3) {
        return new M(aVar, aVar2, (C1953e) obj, (W) obj2, aVar3);
    }

    /* renamed from: b */
    public M get() {
        return c((C0628a) this.f17113a.get(), (C0628a) this.f17114b.get(), this.f17115c.get(), this.f17116d.get(), this.f17117e);
    }
}
