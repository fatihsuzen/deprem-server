package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.AppDetailActivity;

/* renamed from: O1.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0753c implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppDetailActivity f3584a;

    public /* synthetic */ C0753c(AppDetailActivity appDetailActivity) {
        this.f3584a = appDetailActivity;
    }

    public final void onActivityResult(Object obj) {
        AppDetailActivity.n3(this.f3584a, (ActivityResult) obj);
    }
}
