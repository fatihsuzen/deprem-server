package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.AppDetailActivity;

/* renamed from: O1.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0744b implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppDetailActivity f3571a;

    public /* synthetic */ C0744b(AppDetailActivity appDetailActivity) {
        this.f3571a = appDetailActivity;
    }

    public final void onActivityResult(Object obj) {
        AppDetailActivity.t3(this.f3571a, (ActivityResult) obj);
    }
}
