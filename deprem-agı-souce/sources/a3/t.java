package A3;

import W2.J;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import c3.C2316b;
import k3.q;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.e;
import kotlin.coroutines.jvm.internal.h;
import t3.s;
import w3.B0;
import z3.C2973f;

public final class t extends d implements C2973f, e {

    /* renamed from: a  reason: collision with root package name */
    public final C2973f f17314a;

    /* renamed from: b  reason: collision with root package name */
    public final C2312i f17315b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17316c;

    /* renamed from: d  reason: collision with root package name */
    private C2312i f17317d;

    /* renamed from: e  reason: collision with root package name */
    private C2308e f17318e;

    public t(C2973f fVar, C2312i iVar) {
        super(p.f17308a, C2313j.f20794a);
        this.f17314a = fVar;
        this.f17315b = iVar;
        this.f17316c = ((Number) iVar.fold(0, new s())).intValue();
    }

    private final void d(C2312i iVar, C2312i iVar2, Object obj) {
        if (iVar2 instanceof k) {
            j((k) iVar2, obj);
        }
        w.b(this, iVar);
    }

    /* access modifiers changed from: private */
    public static final int e(int i5, C2312i.b bVar) {
        return i5 + 1;
    }

    private final Object f(C2308e eVar, Object obj) {
        C2312i context = eVar.getContext();
        B0.g(context);
        C2312i iVar = this.f17317d;
        if (iVar != context) {
            d(context, iVar, obj);
            this.f17317d = context;
        }
        this.f17318e = eVar;
        q a5 = u.f17319a;
        C2973f fVar = this.f17314a;
        kotlin.jvm.internal.t.c(fVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        kotlin.jvm.internal.t.c(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object invoke = a5.invoke(fVar, obj, this);
        if (!kotlin.jvm.internal.t.a(invoke, C2316b.f())) {
            this.f17318e = null;
        }
        return invoke;
    }

    private final void j(k kVar, Object obj) {
        throw new IllegalStateException(s.n("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + kVar.f17307b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    public Object emit(Object obj, C2308e eVar) {
        try {
            Object f5 = f(eVar, obj);
            if (f5 == C2316b.f()) {
                h.c(eVar);
            }
            if (f5 == C2316b.f()) {
                return f5;
            }
            return J.f19942a;
        } catch (Throwable th) {
            this.f17317d = new k(th, eVar.getContext());
            throw th;
        }
    }

    public e getCallerFrame() {
        C2308e eVar = this.f17318e;
        if (eVar instanceof e) {
            return (e) eVar;
        }
        return null;
    }

    public C2312i getContext() {
        C2312i iVar = this.f17317d;
        if (iVar == null) {
            return C2313j.f20794a;
        }
        return iVar;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Object invokeSuspend(Object obj) {
        Throwable e5 = W2.t.e(obj);
        if (e5 != null) {
            this.f17317d = new k(e5, getContext());
        }
        C2308e eVar = this.f17318e;
        if (eVar != null) {
            eVar.resumeWith(obj);
        }
        return C2316b.f();
    }

    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
