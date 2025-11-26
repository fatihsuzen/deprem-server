package androidx.activity;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentDialog f186a;

    public /* synthetic */ g(ComponentDialog componentDialog) {
        this.f186a = componentDialog;
    }

    public final void run() {
        ComponentDialog.onBackPressedDispatcher$lambda$1(this.f186a);
    }
}
