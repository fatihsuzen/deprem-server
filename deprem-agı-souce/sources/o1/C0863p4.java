package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.PublicProfileActivity;

/* renamed from: O1.p4  reason: case insensitive filesystem */
public final /* synthetic */ class C0863p4 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f3762a;

    public /* synthetic */ C0863p4(PublicProfileActivity publicProfileActivity) {
        this.f3762a = publicProfileActivity;
    }

    public final void onActivityResult(Object obj) {
        PublicProfileActivity.N3(this.f3762a, (ActivityResult) obj);
    }
}
