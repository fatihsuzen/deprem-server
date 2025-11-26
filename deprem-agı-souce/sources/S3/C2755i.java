package s3;

import c3.C2316b;
import java.util.Iterator;
import k3.p;
import kotlin.jvm.internal.t;

/* renamed from: s3.i  reason: case insensitive filesystem */
abstract class C2755i {

    /* renamed from: s3.i$a */
    public static final class a implements C2751e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f25840a;

        public a(p pVar) {
            this.f25840a = pVar;
        }

        public Iterator iterator() {
            return C2755i.a(this.f25840a);
        }
    }

    public static Iterator a(p pVar) {
        t.e(pVar, "block");
        C2752f fVar = new C2752f();
        fVar.j(C2316b.a(pVar, fVar, fVar));
        return fVar;
    }

    public static C2751e b(p pVar) {
        t.e(pVar, "block");
        return new a(pVar);
    }
}
