package O1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.uptodown.activities.ReviewsActivity;

/* renamed from: O1.g5  reason: case insensitive filesystem */
public final /* synthetic */ class C0792g5 implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f3632a;

    public /* synthetic */ C0792g5(ReviewsActivity reviewsActivity) {
        this.f3632a = reviewsActivity;
    }

    public final void onActivityResult(Object obj) {
        ReviewsActivity.P3(this.f3632a, (ActivityResult) obj);
    }
}
