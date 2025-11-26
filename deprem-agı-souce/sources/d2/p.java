package D2;

import android.widget.LinearLayout;
import android.widget.PopupWindow;

public final /* synthetic */ class p implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f18029a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f18030b;

    public /* synthetic */ p(q qVar, LinearLayout linearLayout) {
        this.f18029a = qVar;
        this.f18030b = linearLayout;
    }

    public final void onDismiss() {
        q.e(this.f18029a, this.f18030b);
    }
}
