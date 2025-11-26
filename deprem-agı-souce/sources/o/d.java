package o;

import android.view.View;
import android.widget.PopupWindow;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f966a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f967b;

    public /* synthetic */ d(PopupWindow popupWindow, i iVar) {
        this.f966a = popupWindow;
        this.f967b = iVar;
    }

    public final void onClick(View view) {
        i.n(this.f966a, this.f967b, view);
    }
}
