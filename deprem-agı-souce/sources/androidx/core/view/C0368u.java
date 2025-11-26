package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: androidx.core.view.u  reason: case insensitive filesystem */
public final /* synthetic */ class C0368u implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DragStartHelper f327a;

    public /* synthetic */ C0368u(DragStartHelper dragStartHelper) {
        this.f327a = dragStartHelper;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f327a.onTouch(view, motionEvent);
    }
}
