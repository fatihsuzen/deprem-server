package androidx.datastore.core;

import W2.J;
import b3.C2308e;
import b3.C2312i;
import k3.l;
import k3.p;
import kotlin.jvm.internal.t;
import w3.C2908y0;
import w3.M;
import w3.O;
import y3.C2928a;
import y3.C2934g;
import y3.C2937j;
import y3.C2938k;
import y3.r;

public final class SimpleActor<T> {
    /* access modifiers changed from: private */
    public final p consumeMessage;
    /* access modifiers changed from: private */
    public final C2934g messageQueue = C2937j.b(Integer.MAX_VALUE, (C2928a) null, (l) null, 6, (Object) null);
    /* access modifiers changed from: private */
    public final AtomicInt remainingMessages = new AtomicInt(0);
    /* access modifiers changed from: private */
    public final M scope;

    public SimpleActor(M m5, final l lVar, final p pVar, p pVar2) {
        t.e(m5, "scope");
        t.e(lVar, "onComplete");
        t.e(pVar, "onUndeliveredElement");
        t.e(pVar2, "consumeMessage");
        this.scope = m5;
        this.consumeMessage = pVar2;
        C2908y0 y0Var = (C2908y0) m5.getCoroutineContext().get(C2908y0.f26320k0);
        if (y0Var != null) {
            y0Var.s(new l() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return J.f19942a;
                }

                public final void invoke(Throwable th) {
                    J j5;
                    lVar.invoke(th);
                    this.messageQueue.i(th);
                    do {
                        Object f5 = C2938k.f(this.messageQueue.f());
                        if (f5 != null) {
                            pVar.invoke(f5, th);
                            j5 = J.f19942a;
                            continue;
                        } else {
                            j5 = null;
                            continue;
                        }
                    } while (j5 != null);
                }
            });
        }
    }

    public final void offer(T t5) {
        Object r5 = this.messageQueue.r(t5);
        if (r5 instanceof C2938k.a) {
            Throwable e5 = C2938k.e(r5);
            if (e5 == null) {
                e5 = new r("Channel was closed normally");
            }
            throw e5;
        } else if (!C2938k.i(r5)) {
            throw new IllegalStateException("Check failed.");
        } else if (this.remainingMessages.getAndIncrement() == 0) {
            C2908y0 unused = C2876i.d(this.scope, (C2312i) null, (O) null, new SimpleActor$offer$2(this, (C2308e) null), 3, (Object) null);
        }
    }
}
