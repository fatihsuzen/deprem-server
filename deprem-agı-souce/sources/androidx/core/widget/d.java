package androidx.core.widget;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f337a;

    public /* synthetic */ d(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f337a = contentLoadingProgressBar;
    }

    public final void run() {
        this.f337a.hideOnUiThread();
    }
}
