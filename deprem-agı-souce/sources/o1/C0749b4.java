package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.PreregistrationActivity;

/* renamed from: O1.b4  reason: case insensitive filesystem */
public final /* synthetic */ class C0749b4 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreregistrationActivity f3580a;

    public /* synthetic */ C0749b4(PreregistrationActivity preregistrationActivity) {
        this.f3580a = preregistrationActivity;
    }

    public final void onActivityResult(Object obj) {
        PreregistrationActivity.I3(this.f3580a, (ActivityResult) obj);
    }
}
