package androidx.lifecycle;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComputableLiveData f374a;

    public /* synthetic */ b(ComputableLiveData computableLiveData) {
        this.f374a = computableLiveData;
    }

    public final void run() {
        ComputableLiveData.refreshRunnable$lambda$0(this.f374a);
    }
}
