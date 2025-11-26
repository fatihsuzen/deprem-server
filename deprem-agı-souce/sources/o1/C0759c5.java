package O1;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.uptodown.activities.ReviewsActivity;

/* renamed from: O1.c5  reason: case insensitive filesystem */
public final /* synthetic */ class C0759c5 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f3590a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f3591b;

    public /* synthetic */ C0759c5(ReviewsActivity reviewsActivity, Drawable drawable) {
        this.f3590a = reviewsActivity;
        this.f3591b = drawable;
    }

    public final void onClick(View view) {
        ReviewsActivity.M3(this.f3590a, this.f3591b, view);
    }
}
