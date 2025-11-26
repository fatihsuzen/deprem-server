package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.UserDevicesActivity;

public final /* synthetic */ class S6 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserDevicesActivity f3437a;

    public /* synthetic */ S6(UserDevicesActivity userDevicesActivity) {
        this.f3437a = userDevicesActivity;
    }

    public final void onActivityResult(Object obj) {
        UserDevicesActivity.t3(this.f3437a, (ActivityResult) obj);
    }
}
