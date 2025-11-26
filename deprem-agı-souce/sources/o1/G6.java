package O1;

import android.widget.RadioGroup;
import com.uptodown.activities.UserDeviceDetailsActivity;
import l2.X;

public final /* synthetic */ class G6 implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserDeviceDetailsActivity f3274a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ X f3275b;

    public /* synthetic */ G6(UserDeviceDetailsActivity userDeviceDetailsActivity, X x4) {
        this.f3274a = userDeviceDetailsActivity;
        this.f3275b = x4;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i5) {
        UserDeviceDetailsActivity.A3(this.f3274a, this.f3275b, radioGroup, i5);
    }
}
