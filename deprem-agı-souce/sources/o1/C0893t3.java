package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.MyStatsActivity;

/* renamed from: O1.t3  reason: case insensitive filesystem */
public final /* synthetic */ class C0893t3 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyStatsActivity f3802a;

    public /* synthetic */ C0893t3(MyStatsActivity myStatsActivity) {
        this.f3802a = myStatsActivity;
    }

    public final void onActivityResult(Object obj) {
        MyStatsActivity.v3(this.f3802a, (ActivityResult) obj);
    }
}
