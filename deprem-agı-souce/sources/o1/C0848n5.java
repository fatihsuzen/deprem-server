package O1;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.uptodown.activities.ReviewsActivity;

/* renamed from: O1.n5  reason: case insensitive filesystem */
public final /* synthetic */ class C0848n5 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f3739a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f3740b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f3741c;

    public /* synthetic */ C0848n5(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2) {
        this.f3739a = reviewsActivity;
        this.f3740b = drawable;
        this.f3741c = drawable2;
    }

    public final void onClick(View view) {
        ReviewsActivity.K3(this.f3739a, this.f3740b, this.f3741c, view);
    }
}
