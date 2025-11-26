package Q1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.preferences.PreferencesActivity;

public final /* synthetic */ class L implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3920a;

    public /* synthetic */ L(PreferencesActivity preferencesActivity) {
        this.f3920a = preferencesActivity;
    }

    public final void onActivityResult(Object obj) {
        PreferencesActivity.e4(this.f3920a, (ActivityResult) obj);
    }
}
