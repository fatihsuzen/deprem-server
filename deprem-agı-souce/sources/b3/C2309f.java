package b3;

import b.w;
import b3.C2312i;
import kotlin.jvm.internal.t;

/* renamed from: b3.f  reason: case insensitive filesystem */
public interface C2309f extends C2312i.b {

    /* renamed from: a0  reason: collision with root package name */
    public static final b f20792a0 = b.f20793a;

    /* renamed from: b3.f$a */
    public static final class a {
        public static C2312i.b a(C2309f fVar, C2312i.c cVar) {
            t.e(cVar, "key");
            if (cVar instanceof C2305b) {
                C2305b bVar = (C2305b) cVar;
                if (bVar.a(fVar.getKey())) {
                    C2312i.b b5 = bVar.b(fVar);
                    if (w.a(b5)) {
                        return b5;
                    }
                }
                return null;
            } else if (C2309f.f20792a0 != cVar) {
                return null;
            } else {
                t.c(fVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return fVar;
            }
        }

        public static C2312i b(C2309f fVar, C2312i.c cVar) {
            t.e(cVar, "key");
            if (cVar instanceof C2305b) {
                C2305b bVar = (C2305b) cVar;
                if (!bVar.a(fVar.getKey()) || bVar.b(fVar) == null) {
                    return fVar;
                }
                return C2313j.f20794a;
            } else if (C2309f.f20792a0 == cVar) {
                return C2313j.f20794a;
            } else {
                return fVar;
            }
        }
    }

    /* renamed from: b3.f$b */
    public static final class b implements C2312i.c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f20793a = new b();

        private b() {
        }
    }

    C2308e interceptContinuation(C2308e eVar);

    void releaseInterceptedContinuation(C2308e eVar);
}
