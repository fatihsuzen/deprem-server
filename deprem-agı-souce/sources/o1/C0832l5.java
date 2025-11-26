package O1;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.uptodown.activities.ReviewsActivity;

/* renamed from: O1.l5  reason: case insensitive filesystem */
public final /* synthetic */ class C0832l5 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f3702a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f3703b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f3704c;

    public /* synthetic */ C0832l5(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2) {
        this.f3702a = reviewsActivity;
        this.f3703b = drawable;
        this.f3704c = drawable2;
    }

    public final void onClick(View view) {
        ReviewsActivity.I3(this.f3702a, this.f3703b, this.f3704c, view);
    }
}
