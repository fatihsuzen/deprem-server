package v2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.tv.ui.activity.TvMainActivity;

public final /* synthetic */ class e implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvMainActivity f26043a;

    public /* synthetic */ e(TvMainActivity tvMainActivity) {
        this.f26043a = tvMainActivity;
    }

    public final void onActivityResult(Object obj) {
        TvMainActivity.x(this.f26043a, (ActivityResult) obj);
    }
}
