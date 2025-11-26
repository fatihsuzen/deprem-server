package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.UserEditProfileActivity;

public final /* synthetic */ class U6 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserEditProfileActivity f3490a;

    public /* synthetic */ U6(UserEditProfileActivity userEditProfileActivity) {
        this.f3490a = userEditProfileActivity;
    }

    public final void onActivityResult(Object obj) {
        UserEditProfileActivity.v3(this.f3490a, (ActivityResult) obj);
    }
}
