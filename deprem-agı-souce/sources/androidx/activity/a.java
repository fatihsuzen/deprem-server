package androidx.activity;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f181a;

    public /* synthetic */ a(ComponentActivity componentActivity) {
        this.f181a = componentActivity;
    }

    public final void run() {
        this.f181a.invalidateMenu();
    }
}
