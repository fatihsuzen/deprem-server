package v2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.tv.ui.activity.TvMainActivity;

public final /* synthetic */ class d implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvMainActivity f26042a;

    public /* synthetic */ d(TvMainActivity tvMainActivity) {
        this.f26042a = tvMainActivity;
    }

    public final void onActivityResult(Object obj) {
        TvMainActivity.z(this.f26042a, (ActivityResult) obj);
    }
}
