package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.UserEditProfileActivity;

public final /* synthetic */ class V6 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserEditProfileActivity f3522a;

    public /* synthetic */ V6(UserEditProfileActivity userEditProfileActivity) {
        this.f3522a = userEditProfileActivity;
    }

    public final void onActivityResult(Object obj) {
        UserEditProfileActivity.w3(this.f3522a, (ActivityResult) obj);
    }
}
