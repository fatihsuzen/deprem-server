package x;

import A.C0620b;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import p.k;
import r.i;
import r.p;
import r.u;
import s.e;
import s.m;
import y.x;
import z.C1952d;

/* renamed from: x.c  reason: case insensitive filesystem */
public class C1901c implements e {

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f16770f = Logger.getLogger(u.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final x f16771a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f16772b;

    /* renamed from: c  reason: collision with root package name */
    private final e f16773c;

    /* renamed from: d  reason: collision with root package name */
    private final C1952d f16774d;

    /* renamed from: e  reason: collision with root package name */
    private final C0620b f16775e;

    public C1901c(Executor executor, e eVar, x xVar, C1952d dVar, C0620b bVar) {
        this.f16772b = executor;
        this.f16773c = eVar;
        this.f16771a = xVar;
        this.f16774d = dVar;
        this.f16775e = bVar;
    }

    public static /* synthetic */ Object b(C1901c cVar, p pVar, i iVar) {
        cVar.f16774d.j(pVar, iVar);
        cVar.f16771a.b(pVar, 1);
        return null;
    }

    public static /* synthetic */ void c(C1901c cVar, p pVar, k kVar, i iVar) {
        cVar.getClass();
        try {
            m mVar = cVar.f16773c.get(pVar.b());
            if (mVar == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{pVar.b()});
                f16770f.warning(format);
                kVar.a(new IllegalArgumentException(format));
                return;
            }
            cVar.f16775e.m(new C1900b(cVar, pVar, mVar.b(iVar)));
            kVar.a((Exception) null);
        } catch (Exception e5) {
            Logger logger = f16770f;
            logger.warning("Error scheduling event " + e5.getMessage());
            kVar.a(e5);
        }
    }

    public void a(p pVar, i iVar, k kVar) {
        this.f16772b.execute(new C1899a(this, pVar, kVar, iVar));
    }
}
