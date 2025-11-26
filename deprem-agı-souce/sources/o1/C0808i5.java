package O1;

import androidx.core.widget.NestedScrollView;
import com.uptodown.activities.ReviewsActivity;

/* renamed from: O1.i5  reason: case insensitive filesystem */
public final /* synthetic */ class C0808i5 implements NestedScrollView.OnScrollChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f3653a;

    public /* synthetic */ C0808i5(ReviewsActivity reviewsActivity) {
        this.f3653a = reviewsActivity;
    }

    public final void onScrollChange(NestedScrollView nestedScrollView, int i5, int i6, int i7, int i8) {
        ReviewsActivity.F3(this.f3653a, nestedScrollView, i5, i6, i7, i8);
    }
}
