package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MainActivity;

/* renamed from: O1.h1  reason: case insensitive filesystem */
public final /* synthetic */ class C0796h1 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f3637a;

    public /* synthetic */ C0796h1(MainActivity mainActivity) {
        this.f3637a = mainActivity;
    }

    public final void onActivityResult(Object obj) {
        MainActivity.t7(this.f3637a, (ActivityResult) obj);
    }
}
