package androidx.datastore.core;

import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {121, 121}, m = "invokeSuspend")
final class SimpleActor$offer$2 extends l implements p {
    Object L$0;
    int label;
    final /* synthetic */ SimpleActor<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleActor$offer$2(SimpleActor<T> simpleActor, C2308e eVar) {
        super(2, eVar);
        this.this$0 = simpleActor;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new SimpleActor$offer$2(this.this$0, eVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004e, code lost:
        if (r6 == r0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        if (r1.invoke(r6, r5) == r0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005c, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = c3.C2316b.f()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            W2.u.b(r6)
            goto L_0x005d
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.L$0
            k3.p r1 = (k3.p) r1
            W2.u.b(r6)
            goto L_0x0051
        L_0x0022:
            W2.u.b(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            androidx.datastore.core.AtomicInt r6 = r6.remainingMessages
            int r6 = r6.get()
            if (r6 <= 0) goto L_0x006c
        L_0x0031:
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            w3.M r6 = r6.scope
            w3.N.e(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            k3.p r1 = r6.consumeMessage
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            y3.g r6 = r6.messageQueue
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r6 = r6.j(r5)
            if (r6 != r0) goto L_0x0051
            goto L_0x005c
        L_0x0051:
            r4 = 0
            r5.L$0 = r4
            r5.label = r2
            java.lang.Object r6 = r1.invoke(r6, r5)
            if (r6 != r0) goto L_0x005d
        L_0x005c:
            return r0
        L_0x005d:
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            androidx.datastore.core.AtomicInt r6 = r6.remainingMessages
            int r6 = r6.decrementAndGet()
            if (r6 != 0) goto L_0x0031
            W2.J r6 = W2.J.f19942a
            return r6
        L_0x006c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((SimpleActor$offer$2) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
