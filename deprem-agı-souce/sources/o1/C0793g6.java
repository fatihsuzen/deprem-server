package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.UserActivity;

/* renamed from: O1.g6  reason: case insensitive filesystem */
public final /* synthetic */ class C0793g6 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserActivity f3633a;

    public /* synthetic */ C0793g6(UserActivity userActivity) {
        this.f3633a = userActivity;
    }

    public final void onActivityResult(Object obj) {
        UserActivity.x4(this.f3633a, (ActivityResult) obj);
    }
}
