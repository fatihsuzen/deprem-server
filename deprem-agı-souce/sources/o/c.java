package o;

import android.view.View;
import android.widget.PopupWindow;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f964a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f965b;

    public /* synthetic */ c(PopupWindow popupWindow, i iVar) {
        this.f964a = popupWindow;
        this.f965b = iVar;
    }

    public final void onClick(View view) {
        i.i(this.f964a, this.f965b, view);
    }
}
