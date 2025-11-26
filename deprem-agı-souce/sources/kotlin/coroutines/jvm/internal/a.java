package kotlin.coroutines.jvm.internal;

import W2.t;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import java.io.Serializable;
import kotlin.jvm.internal.t;

public abstract class a implements C2308e, e, Serializable {
    private final C2308e completion;

    public a(C2308e eVar) {
        this.completion = eVar;
    }

    public C2308e create(C2308e eVar) {
        t.e(eVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public e getCallerFrame() {
        C2308e eVar = this.completion;
        if (eVar instanceof e) {
            return (e) eVar;
        }
        return null;
    }

    public final C2308e getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    /* access modifiers changed from: protected */
    public abstract Object invokeSuspend(Object obj);

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
    }

    public final void resumeWith(Object obj) {
        C2308e eVar = this;
        while (true) {
            h.b(eVar);
            a aVar = (a) eVar;
            C2308e eVar2 = aVar.completion;
            t.b(eVar2);
            try {
                Object invokeSuspend = aVar.invokeSuspend(obj);
                if (invokeSuspend != C2316b.f()) {
                    obj = W2.t.b(invokeSuspend);
                    aVar.releaseIntercepted();
                    if (eVar2 instanceof a) {
                        eVar = eVar2;
                    } else {
                        eVar2.resumeWith(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                t.a aVar2 = W2.t.f19966b;
                obj = W2.t.b(u.a(th));
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public C2308e create(Object obj, C2308e eVar) {
        kotlin.jvm.internal.t.e(eVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
