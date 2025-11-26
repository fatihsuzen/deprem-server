package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MainActivity;

/* renamed from: O1.i1  reason: case insensitive filesystem */
public final /* synthetic */ class C0804i1 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainActivity f3648a;

    public /* synthetic */ C0804i1(MainActivity mainActivity) {
        this.f3648a = mainActivity;
    }

    public final void onActivityResult(Object obj) {
        MainActivity.J6(this.f3648a, (ActivityResult) obj);
    }
}
