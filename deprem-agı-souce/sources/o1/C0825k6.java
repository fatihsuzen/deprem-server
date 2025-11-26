package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.UserActivity;

/* renamed from: O1.k6  reason: case insensitive filesystem */
public final /* synthetic */ class C0825k6 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserActivity f3692a;

    public /* synthetic */ C0825k6(UserActivity userActivity) {
        this.f3692a = userActivity;
    }

    public final void onActivityResult(Object obj) {
        UserActivity.H4(this.f3692a, (ActivityResult) obj);
    }
}
