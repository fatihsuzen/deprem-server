package o;

import android.view.View;
import android.widget.PopupWindow;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f968a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f969b;

    public /* synthetic */ e(PopupWindow popupWindow, i iVar) {
        this.f968a = popupWindow;
        this.f969b = iVar;
    }

    public final void onClick(View view) {
        i.q(this.f968a, this.f969b, view);
    }
}
