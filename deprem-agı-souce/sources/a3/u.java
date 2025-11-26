package A3;

import b3.C2308e;
import k3.q;
import kotlin.jvm.internal.C2639q;
import kotlin.jvm.internal.S;
import kotlin.jvm.internal.t;
import z3.C2973f;

public abstract class u {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final q f17319a;

    /* synthetic */ class a extends C2639q implements q {

        /* renamed from: a  reason: collision with root package name */
        public static final a f17320a = new a();

        a() {
            super(3, C2973f.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        /* renamed from: g */
        public final Object invoke(C2973f fVar, Object obj, C2308e eVar) {
            return fVar.emit(obj, eVar);
        }
    }

    static {
        a aVar = a.f17320a;
        t.c(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f17319a = (q) S.c(aVar, 3);
    }
}
