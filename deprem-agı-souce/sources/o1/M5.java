package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.Updates;

public final /* synthetic */ class M5 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Updates f3348a;

    public /* synthetic */ M5(Updates updates) {
        this.f3348a = updates;
    }

    public final void onActivityResult(Object obj) {
        Updates.E5(this.f3348a, (ActivityResult) obj);
    }
}
