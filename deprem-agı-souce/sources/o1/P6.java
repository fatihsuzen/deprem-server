package O1;

import android.view.View;
import com.uptodown.activities.UserDevicesActivity;
import l2.X;

public final /* synthetic */ class P6 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserDevicesActivity f3397a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ X f3398b;

    public /* synthetic */ P6(UserDevicesActivity userDevicesActivity, X x4) {
        this.f3397a = userDevicesActivity;
        this.f3398b = x4;
    }

    public final void onClick(View view) {
        UserDevicesActivity.s3(this.f3397a, this.f3398b, view);
    }
}
