package androidx.work.impl.constraints;

import A3.j;
import W2.J;
import W2.u;
import androidx.work.impl.constraints.ConstraintsState;
import b3.C2308e;
import c3.C2316b;
import k3.C2616a;
import k3.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import z3.C2972e;
import z3.C2973f;

public final class WorkConstraintsTracker$track$$inlined$combine$1 implements C2972e {
    final /* synthetic */ C2972e[] $flowArray$inlined;

    @f(c = "androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3", f = "WorkConstraintsTracker.kt", l = {288}, m = "invokeSuspend")
    /* renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3  reason: invalid class name */
    public static final class AnonymousClass3 extends l implements q {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public final Object invokeSuspend(Object obj) {
            ConstraintsState constraintsState;
            Object f5 = C2316b.f();
            int i5 = this.label;
            if (i5 == 0) {
                u.b(obj);
                C2973f fVar = (C2973f) this.L$0;
                ConstraintsState[] constraintsStateArr = (ConstraintsState[]) ((Object[]) this.L$1);
                int length = constraintsStateArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        constraintsState = null;
                        break;
                    }
                    constraintsState = constraintsStateArr[i6];
                    if (!t.a(constraintsState, ConstraintsState.ConstraintsMet.INSTANCE)) {
                        break;
                    }
                    i6++;
                }
                if (constraintsState == null) {
                    constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                }
                this.label = 1;
                if (fVar.emit(constraintsState, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(C2973f fVar, ConstraintsState[] constraintsStateArr, C2308e eVar) {
            AnonymousClass3 r02 = new AnonymousClass3(eVar);
            r02.L$0 = fVar;
            r02.L$1 = constraintsStateArr;
            return r02.invokeSuspend(J.f19942a);
        }
    }

    public WorkConstraintsTracker$track$$inlined$combine$1(C2972e[] eVarArr) {
        this.$flowArray$inlined = eVarArr;
    }

    public Object collect(C2973f fVar, C2308e eVar) {
        final C2972e[] eVarArr = this.$flowArray$inlined;
        Object a5 = j.a(fVar, eVarArr, new C2616a() {
            public final ConstraintsState[] invoke() {
                return new ConstraintsState[eVarArr.length];
            }
        }, new AnonymousClass3((C2308e) null), eVar);
        if (a5 == C2316b.f()) {
            return a5;
        }
        return J.f19942a;
    }
}
