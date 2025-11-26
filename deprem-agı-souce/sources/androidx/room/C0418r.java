package androidx.room;

/* renamed from: androidx.room.r  reason: case insensitive filesystem */
public final /* synthetic */ class C0418r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f447a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransactionExecutor f448b;

    public /* synthetic */ C0418r(Runnable runnable, TransactionExecutor transactionExecutor) {
        this.f447a = runnable;
        this.f448b = transactionExecutor;
    }

    public final void run() {
        TransactionExecutor.execute$lambda$1$lambda$0(this.f447a, this.f448b);
    }
}
