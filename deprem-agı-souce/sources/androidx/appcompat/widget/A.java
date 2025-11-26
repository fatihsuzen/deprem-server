package androidx.appcompat.widget;

public final /* synthetic */ class A implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TooltipCompatHandler f207a;

    public /* synthetic */ A(TooltipCompatHandler tooltipCompatHandler) {
        this.f207a = tooltipCompatHandler;
    }

    public final void run() {
        this.f207a.show(false);
    }
}
