package x;

import A.C0620b;
import T2.a;
import java.util.concurrent.Executor;
import s.e;
import t.C1876b;
import y.x;
import z.C1952d;

/* renamed from: x.d  reason: case insensitive filesystem */
public final class C1902d implements C1876b {

    /* renamed from: a  reason: collision with root package name */
    private final a f16776a;

    /* renamed from: b  reason: collision with root package name */
    private final a f16777b;

    /* renamed from: c  reason: collision with root package name */
    private final a f16778c;

    /* renamed from: d  reason: collision with root package name */
    private final a f16779d;

    /* renamed from: e  reason: collision with root package name */
    private final a f16780e;

    public C1902d(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.f16776a = aVar;
        this.f16777b = aVar2;
        this.f16778c = aVar3;
        this.f16779d = aVar4;
        this.f16780e = aVar5;
    }

    public static C1902d a(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new C1902d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static C1901c c(Executor executor, e eVar, x xVar, C1952d dVar, C0620b bVar) {
        return new C1901c(executor, eVar, xVar, dVar, bVar);
    }

    /* renamed from: b */
    public C1901c get() {
        return c((Executor) this.f16776a.get(), (e) this.f16777b.get(), (x) this.f16778c.get(), (C1952d) this.f16779d.get(), (C0620b) this.f16780e.get());
    }
}
