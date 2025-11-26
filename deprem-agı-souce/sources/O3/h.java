package O3;

import H3.b;
import O3.a;
import X2.M;
import k3.l;
import kotlin.jvm.internal.t;
import r3.C2733c;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static final d f18862a = new b(M.h(), M.h(), M.h(), M.h(), M.h(), false);

    public static final class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f18863a;

        a(e eVar) {
            this.f18863a = eVar;
        }

        public void a(C2733c cVar, l lVar) {
            t.e(cVar, "baseClass");
            t.e(lVar, "defaultDeserializerProvider");
            this.f18863a.h(cVar, lVar, true);
        }

        public void b(C2733c cVar, l lVar) {
            t.e(cVar, "baseClass");
            t.e(lVar, "defaultSerializerProvider");
            this.f18863a.i(cVar, lVar, true);
        }

        public void c(C2733c cVar, l lVar) {
            t.e(cVar, "kClass");
            t.e(lVar, "provider");
            this.f18863a.l(cVar, new a.b(lVar), true);
        }

        public void d(C2733c cVar, C2733c cVar2, b bVar) {
            t.e(cVar, "baseClass");
            t.e(cVar2, "actualClass");
            t.e(bVar, "actualSerializer");
            this.f18863a.j(cVar, cVar2, bVar, true);
        }

        public void e(C2733c cVar, b bVar) {
            t.e(cVar, "kClass");
            t.e(bVar, "serializer");
            this.f18863a.l(cVar, new a.C0179a(bVar), true);
        }
    }

    public static final d a() {
        return f18862a;
    }

    public static final d b(d dVar, d dVar2) {
        t.e(dVar, "<this>");
        t.e(dVar2, "other");
        e eVar = new e();
        eVar.g(dVar);
        dVar2.a(new a(eVar));
        return eVar.f();
    }

    public static final d c(d dVar, d dVar2) {
        t.e(dVar, "<this>");
        t.e(dVar2, "other");
        e eVar = new e();
        eVar.g(dVar);
        eVar.g(dVar2);
        return eVar.f();
    }
}
