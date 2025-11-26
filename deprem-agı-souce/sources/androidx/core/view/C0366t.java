package androidx.core.view;

import android.view.View;

/* renamed from: androidx.core.view.t  reason: case insensitive filesystem */
public final /* synthetic */ class C0366t implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DragStartHelper f326a;

    public /* synthetic */ C0366t(DragStartHelper dragStartHelper) {
        this.f326a = dragStartHelper;
    }

    public final boolean onLongClick(View view) {
        return this.f326a.onLongClick(view);
    }
}
