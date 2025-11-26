package androidx.appcompat.widget;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Toolbar f210a;

    public /* synthetic */ w(Toolbar toolbar) {
        this.f210a = toolbar;
    }

    public final void run() {
        this.f210a.invalidateMenu();
    }
}
