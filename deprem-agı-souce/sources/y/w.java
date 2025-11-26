package y;

import A.C0620b;
import T2.a;
import java.util.concurrent.Executor;
import t.C1876b;
import z.C1952d;

public final class w implements C1876b {

    /* renamed from: a  reason: collision with root package name */
    private final a f17069a;

    /* renamed from: b  reason: collision with root package name */
    private final a f17070b;

    /* renamed from: c  reason: collision with root package name */
    private final a f17071c;

    /* renamed from: d  reason: collision with root package name */
    private final a f17072d;

    public w(a aVar, a aVar2, a aVar3, a aVar4) {
        this.f17069a = aVar;
        this.f17070b = aVar2;
        this.f17071c = aVar3;
        this.f17072d = aVar4;
    }

    public static w a(a aVar, a aVar2, a aVar3, a aVar4) {
        return new w(aVar, aVar2, aVar3, aVar4);
    }

    public static v c(Executor executor, C1952d dVar, x xVar, C0620b bVar) {
        return new v(executor, dVar, xVar, bVar);
    }

    /* renamed from: b */
    public v get() {
        return c((Executor) this.f17069a.get(), (C1952d) this.f17070b.get(), (x) this.f17071c.get(), (C0620b) this.f17072d.get());
    }
}
