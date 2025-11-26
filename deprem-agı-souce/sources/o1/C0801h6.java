package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.UserActivity;

/* renamed from: O1.h6  reason: case insensitive filesystem */
public final /* synthetic */ class C0801h6 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserActivity f3642a;

    public /* synthetic */ C0801h6(UserActivity userActivity) {
        this.f3642a = userActivity;
    }

    public final void onActivityResult(Object obj) {
        UserActivity.E4(this.f3642a, (ActivityResult) obj);
    }
}
