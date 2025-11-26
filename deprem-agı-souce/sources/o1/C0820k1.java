package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MainActivity;

/* renamed from: O1.k1  reason: case insensitive filesystem */
public final /* synthetic */ class C0820k1 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f3667a;

    public /* synthetic */ C0820k1(MainActivity mainActivity) {
        this.f3667a = mainActivity;
    }

    public final void onActivityResult(Object obj) {
        MainActivity.a6(this.f3667a, (ActivityResult) obj);
    }
}
