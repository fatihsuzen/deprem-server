package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.KeyEventDispatcher;

public final /* synthetic */ class r implements KeyEventDispatcher.Component {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDialog f206a;

    public /* synthetic */ r(AppCompatDialog appCompatDialog) {
        this.f206a = appCompatDialog;
    }

    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f206a.superDispatchKeyEvent(keyEvent);
    }
}
