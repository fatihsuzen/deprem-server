package androidx.room;

import b3.C2309f;
import b3.C2312i;
import java.util.concurrent.atomic.AtomicInteger;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class TransactionElement implements C2312i.b {
    public static final Key Key = new Key((C2633k) null);
    private final AtomicInteger referenceCount = new AtomicInteger(0);
    private final C2309f transactionDispatcher;

    public static final class Key implements C2312i.c {
        public /* synthetic */ Key(C2633k kVar) {
            this();
        }

        private Key() {
        }
    }

    public TransactionElement(C2309f fVar) {
        t.e(fVar, "transactionDispatcher");
        this.transactionDispatcher = fVar;
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    public <R> R fold(R r5, p pVar) {
        return C2312i.b.a.a(this, r5, pVar);
    }

    public <E extends C2312i.b> E get(C2312i.c cVar) {
        return C2312i.b.a.b(this, cVar);
    }

    public C2312i.c getKey() {
        return Key;
    }

    public final C2309f getTransactionDispatcher$room_runtime_release() {
        return this.transactionDispatcher;
    }

    public C2312i minusKey(C2312i.c cVar) {
        return C2312i.b.a.c(this, cVar);
    }

    public C2312i plus(C2312i iVar) {
        return C2312i.b.a.d(this, iVar);
    }

    public final void release() {
        if (this.referenceCount.decrementAndGet() < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
    }
}
