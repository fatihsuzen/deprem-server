package androidx.lifecycle;

import W2.J;
import W2.u;
import androidx.lifecycle.Lifecycle;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;
import y3.v;
import y3.y;
import z3.C2972e;
import z3.C2973f;

@f(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {90}, m = "invokeSuspend")
final class FlowExtKt$flowWithLifecycle$1 extends l implements p {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ C2972e $this_flowWithLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    @f(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {90}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends l implements p {
        int label;

        public final C2308e create(Object obj, C2308e eVar) {
            return new AnonymousClass1(eVar, vVar2, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.label;
            if (i5 == 0) {
                u.b(obj);
                C2972e eVar = eVar;
                final v vVar = vVar2;
                AnonymousClass1 r12 = new C2973f() {
                    public final Object emit(T t5, C2308e eVar) {
                        Object e5 = vVar.e(t5, eVar);
                        if (e5 == C2316b.f()) {
                            return e5;
                        }
                        return J.f19942a;
                    }
                };
                this.label = 1;
                if (eVar.collect(r12, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((AnonymousClass1) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowExtKt$flowWithLifecycle$1(Lifecycle lifecycle, Lifecycle.State state, C2972e eVar, C2308e eVar2) {
        super(2, eVar2);
        this.$lifecycle = lifecycle;
        this.$minActiveState = state;
        this.$this_flowWithLifecycle = eVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        FlowExtKt$flowWithLifecycle$1 flowExtKt$flowWithLifecycle$1 = new FlowExtKt$flowWithLifecycle$1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, eVar);
        flowExtKt$flowWithLifecycle$1.L$0 = obj;
        return flowExtKt$flowWithLifecycle$1;
    }

    public final Object invokeSuspend(Object obj) {
        v vVar;
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            final v vVar2 = (v) this.L$0;
            Lifecycle lifecycle = this.$lifecycle;
            Lifecycle.State state = this.$minActiveState;
            final C2972e eVar = this.$this_flowWithLifecycle;
            AnonymousClass1 r5 = new AnonymousClass1((C2308e) null);
            this.L$0 = vVar2;
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, (p) r5, (C2308e) this) == f5) {
                return f5;
            }
            vVar = vVar2;
        } else if (i5 == 1) {
            vVar = (v) this.L$0;
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        y.a.a(vVar, (Throwable) null, 1, (Object) null);
        return J.f19942a;
    }

    public final Object invoke(v vVar, C2308e eVar) {
        return ((FlowExtKt$flowWithLifecycle$1) create(vVar, eVar)).invokeSuspend(J.f19942a);
    }
}
