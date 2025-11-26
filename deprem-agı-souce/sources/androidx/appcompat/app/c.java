package androidx.appcompat.app;

import androidx.appcompat.app.AppCompatDelegate;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegate.SerialExecutor f203a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f204b;

    public /* synthetic */ c(AppCompatDelegate.SerialExecutor serialExecutor, Runnable runnable) {
        this.f203a = serialExecutor;
        this.f204b = runnable;
    }

    public final void run() {
        AppCompatDelegate.SerialExecutor.a(this.f203a, this.f204b);
    }
}
