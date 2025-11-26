package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MainActivity;

/* renamed from: O1.g1  reason: case insensitive filesystem */
public final /* synthetic */ class C0788g1 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f3626a;

    public /* synthetic */ C0788g1(MainActivity mainActivity) {
        this.f3626a = mainActivity;
    }

    public final void onActivityResult(Object obj) {
        MainActivity.J5(this.f3626a, (ActivityResult) obj);
    }
}
