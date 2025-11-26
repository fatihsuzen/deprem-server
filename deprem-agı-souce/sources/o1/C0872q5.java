package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.RollbackActivity;

/* renamed from: O1.q5  reason: case insensitive filesystem */
public final /* synthetic */ class C0872q5 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RollbackActivity f3771a;

    public /* synthetic */ C0872q5(RollbackActivity rollbackActivity) {
        this.f3771a = rollbackActivity;
    }

    public final void onActivityResult(Object obj) {
        RollbackActivity.d5(this.f3771a, (ActivityResult) obj);
    }
}
