package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

public final /* synthetic */ class V0 implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat.Impl30 f322a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat.OnControllableInsetsChangedListener f323b;

    public /* synthetic */ V0(WindowInsetsControllerCompat.Impl30 impl30, WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f322a = impl30;
        this.f323b = onControllableInsetsChangedListener;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i5) {
        WindowInsetsControllerCompat.Impl30.a(this.f322a, this.f323b, windowInsetsController, i5);
    }
}
