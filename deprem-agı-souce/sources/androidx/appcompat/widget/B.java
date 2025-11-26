package androidx.appcompat.widget;

public final /* synthetic */ class B implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TooltipCompatHandler f208a;

    public /* synthetic */ B(TooltipCompatHandler tooltipCompatHandler) {
        this.f208a = tooltipCompatHandler;
    }

    public final void run() {
        this.f208a.hide();
    }
}
