package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.UserActivity;

/* renamed from: O1.j6  reason: case insensitive filesystem */
public final /* synthetic */ class C0817j6 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserActivity f3661a;

    public /* synthetic */ C0817j6(UserActivity userActivity) {
        this.f3661a = userActivity;
    }

    public final void onActivityResult(Object obj) {
        UserActivity.I4(this.f3661a, (ActivityResult) obj);
    }
}
