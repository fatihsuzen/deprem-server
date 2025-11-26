package androidx.appcompat.widget;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Toolbar f209a;

    public /* synthetic */ v(Toolbar toolbar) {
        this.f209a = toolbar;
    }

    public final void run() {
        this.f209a.collapseActionView();
    }
}
