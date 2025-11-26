package O1;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.uptodown.activities.ReviewsActivity;

/* renamed from: O1.m5  reason: case insensitive filesystem */
public final /* synthetic */ class C0840m5 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f3716a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f3717b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f3718c;

    public /* synthetic */ C0840m5(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2) {
        this.f3716a = reviewsActivity;
        this.f3717b = drawable;
        this.f3718c = drawable2;
    }

    public final void onClick(View view) {
        ReviewsActivity.J3(this.f3716a, this.f3717b, this.f3718c, view);
    }
}
