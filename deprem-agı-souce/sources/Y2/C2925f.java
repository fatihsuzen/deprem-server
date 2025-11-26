package y2;

import S1.k;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import s2.C2745b;

/* renamed from: y2.f  reason: case insensitive filesystem */
public final class C2925f extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f26363a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f26364b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2925f(View view) {
        super(view);
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        View findViewById = view.findViewById(R.id.iv_icon);
        t.d(findViewById, "findViewById(...)");
        this.f26363a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name);
        t.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f26364b = textView;
        textView.setTypeface(k.f32g.w());
    }

    public final void a(C2745b bVar) {
        t.e(bVar, "tvManageAppsItem");
        this.f26364b.setText(bVar.c());
        this.f26363a.setImageResource(bVar.a());
    }
}
