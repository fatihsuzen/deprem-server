package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MainActivity;

/* renamed from: O1.j1  reason: case insensitive filesystem */
public final /* synthetic */ class C0812j1 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f3657a;

    public /* synthetic */ C0812j1(MainActivity mainActivity) {
        this.f3657a = mainActivity;
    }

    public final void onActivityResult(Object obj) {
        MainActivity.r8(this.f3657a, (ActivityResult) obj);
    }
}
