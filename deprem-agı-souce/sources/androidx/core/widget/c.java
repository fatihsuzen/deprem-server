package androidx.core.widget;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f336a;

    public /* synthetic */ c(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f336a = contentLoadingProgressBar;
    }

    public final void run() {
        this.f336a.showOnUiThread();
    }
}
