package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* renamed from: androidx.core.view.y  reason: case insensitive filesystem */
public final /* synthetic */ class C0374y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f333a;

    public /* synthetic */ C0374y(View view) {
        this.f333a = view;
    }

    public final void run() {
        ((InputMethodManager) this.f333a.getContext().getSystemService("input_method")).showSoftInput(this.f333a, 0);
    }
}
