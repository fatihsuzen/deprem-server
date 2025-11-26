package O2;

import android.view.View;
import android.widget.PopupWindow;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f18809a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f18810b;

    public /* synthetic */ d(PopupWindow popupWindow, i iVar) {
        this.f18809a = popupWindow;
        this.f18810b = iVar;
    }

    public final void onClick(View view) {
        i.k(this.f18809a, this.f18810b, view);
    }
}
