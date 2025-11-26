package O1;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.uptodown.activities.ReviewsActivity;

/* renamed from: O1.o5  reason: case insensitive filesystem */
public final /* synthetic */ class C0856o5 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f3752a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f3753b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Drawable f3754c;

    public /* synthetic */ C0856o5(ReviewsActivity reviewsActivity, Drawable drawable, Drawable drawable2) {
        this.f3752a = reviewsActivity;
        this.f3753b = drawable;
        this.f3754c = drawable2;
    }

    public final void onClick(View view) {
        ReviewsActivity.L3(this.f3752a, this.f3753b, this.f3754c, view);
    }
}
