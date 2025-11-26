package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.UserActivity;

/* renamed from: O1.i6  reason: case insensitive filesystem */
public final /* synthetic */ class C0809i6 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserActivity f3654a;

    public /* synthetic */ C0809i6(UserActivity userActivity) {
        this.f3654a = userActivity;
    }

    public final void onActivityResult(Object obj) {
        UserActivity.X3(this.f3654a, (ActivityResult) obj);
    }
}
