package y;

import A.C0620b;
import java.util.concurrent.Executor;
import r.p;
import z.C1952d;

public class v {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f17065a;

    /* renamed from: b  reason: collision with root package name */
    private final C1952d f17066b;

    /* renamed from: c  reason: collision with root package name */
    private final x f17067c;

    /* renamed from: d  reason: collision with root package name */
    private final C0620b f17068d;

    v(Executor executor, C1952d dVar, x xVar, C0620b bVar) {
        this.f17065a = executor;
        this.f17066b = dVar;
        this.f17067c = xVar;
        this.f17068d = bVar;
    }

    public static /* synthetic */ Object a(v vVar) {
        for (p b5 : vVar.f17066b.i()) {
            vVar.f17067c.b(b5, 1);
        }
        return null;
    }

    public void c() {
        this.f17065a.execute(new t(this));
    }
}
