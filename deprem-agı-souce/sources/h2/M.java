package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class M implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22487a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22488b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22489c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22490d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f22491e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f22492f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f22493g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f22494h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22495i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22496j;

    private M(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.f22487a = relativeLayout;
        this.f22488b = imageView;
        this.f22489c = imageView2;
        this.f22490d = imageView3;
        this.f22491e = imageView4;
        this.f22492f = imageView5;
        this.f22493g = imageView6;
        this.f22494h = linearLayout;
        this.f22495i = textView;
        this.f22496j = textView2;
    }

    public static M a(View view) {
        int i5 = R.id.iv_icon_feed_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_icon_feed_item);
        if (imageView != null) {
            i5 = R.id.iv_star1_review_feed_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star1_review_feed_item);
            if (imageView2 != null) {
                i5 = R.id.iv_star2_review_feed_item;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star2_review_feed_item);
                if (imageView3 != null) {
                    i5 = R.id.iv_star3_review_feed_item;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star3_review_feed_item);
                    if (imageView4 != null) {
                        i5 = R.id.iv_star4_review_feed_item;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star4_review_feed_item);
                        if (imageView5 != null) {
                            i5 = R.id.iv_star5_review_feed_item;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star5_review_feed_item);
                            if (imageView6 != null) {
                                i5 = R.id.ll_stars_review_feed_item;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_stars_review_feed_item);
                                if (linearLayout != null) {
                                    i5 = R.id.tv_app_name_feed_item;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_name_feed_item);
                                    if (textView != null) {
                                        i5 = R.id.tv_body_feed_item;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_body_feed_item);
                                        if (textView2 != null) {
                                            return new M((RelativeLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout, textView, textView2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static M c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static M d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.feed_item_comment_view, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22487a;
    }
}
