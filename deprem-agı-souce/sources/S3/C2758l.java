package s3;

import java.util.Iterator;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.t;

/* renamed from: s3.l  reason: case insensitive filesystem */
abstract class C2758l extends C2756j {

    /* renamed from: s3.l$a */
    public static final class a implements C2751e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f25842a;

        public a(Iterator it) {
            this.f25842a = it;
        }

        public Iterator iterator() {
            return this.f25842a;
        }
    }

    public static C2751e d(Iterator it) {
        t.e(it, "<this>");
        return e(new a(it));
    }

    public static C2751e e(C2751e eVar) {
        t.e(eVar, "<this>");
        if (eVar instanceof C2747a) {
            return eVar;
        }
        return new C2747a(eVar);
    }

    public static C2751e f(Object obj, l lVar) {
        t.e(lVar, "nextFunction");
        if (obj == null) {
            return C2748b.f25823a;
        }
        return new C2750d(new C2757k(obj), lVar);
    }

    public static C2751e g(C2616a aVar, l lVar) {
        t.e(aVar, "seedFunction");
        t.e(lVar, "nextFunction");
        return new C2750d(aVar, lVar);
    }

    /* access modifiers changed from: private */
    public static final Object h(Object obj) {
        return obj;
    }
}
