package Q1;

import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.preferences.PreferencesActivity;

public final /* synthetic */ class X implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3932a;

    public /* synthetic */ X(PreferencesActivity preferencesActivity) {
        this.f3932a = preferencesActivity;
    }

    public final void onActivityResult(Object obj) {
        PreferencesActivity.R4(this.f3932a, ((Boolean) obj).booleanValue());
    }
}
