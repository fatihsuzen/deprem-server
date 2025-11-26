package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MainActivity;

public final /* synthetic */ class U1 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f3482a;

    public /* synthetic */ U1(MainActivity mainActivity) {
        this.f3482a = mainActivity;
    }

    public final void onActivityResult(Object obj) {
        MainActivity.Q6(this.f3482a, (ActivityResult) obj);
    }
}
