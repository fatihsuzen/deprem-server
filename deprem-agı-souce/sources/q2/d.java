package Q2;

import I2.i;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;

public final class d extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f18907a;

    public d(m mVar) {
        this.f18907a = mVar;
    }

    public final void onClick(View view) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        FragmentActivity activity = this.f18907a.getActivity();
        if (activity != null) {
            activity.getSupportFragmentManager().beginTransaction().add((Fragment) new i(), "e0.a").add((Fragment) new O2.i(), "h0.c").commit();
        }
    }
}
