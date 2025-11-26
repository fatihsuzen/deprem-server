package y2;

import android.view.View;
import android.widget.ImageView;
import androidx.leanback.widget.Presenter;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.s;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import l2.C2657f;

public final class i extends Presenter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f26376a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(View view) {
        super(view);
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        View findViewById = view.findViewById(R.id.iv_feature_program_day);
        t.d(findViewById, "findViewById(...)");
        this.f26376a = (ImageView) findViewById;
    }

    public final void a(C2657f fVar) {
        t.e(fVar, "appInfo");
        s.h().l(fVar.z()).i(this.f26376a);
    }
}
