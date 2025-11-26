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
import com.uptodown.util.views.UsernameTextView;

public final class N0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22529a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22530b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22531c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22532d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f22533e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f22534f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f22535g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f22536h;

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f22537i;

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f22538j;

    /* renamed from: k  reason: collision with root package name */
    public final LinearLayout f22539k;

    /* renamed from: l  reason: collision with root package name */
    public final UsernameTextView f22540l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f22541m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f22542n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f22543o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f22544p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f22545q;

    private N0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, UsernameTextView usernameTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f22529a = relativeLayout;
        this.f22530b = imageView;
        this.f22531c = imageView2;
        this.f22532d = imageView3;
        this.f22533e = imageView4;
        this.f22534f = imageView5;
        this.f22535g = imageView6;
        this.f22536h = imageView7;
        this.f22537i = linearLayout;
        this.f22538j = linearLayout2;
        this.f22539k = linearLayout3;
        this.f22540l = usernameTextView;
        this.f22541m = textView;
        this.f22542n = textView2;
        this.f22543o = textView3;
        this.f22544p = textView4;
        this.f22545q = textView5;
    }

    public static N0 a(View view) {
        View view2 = view;
        int i5 = R.id.iv_avatar_review;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_avatar_review);
        if (imageView != null) {
            i5 = R.id.iv_likes_counter_review;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_likes_counter_review);
            if (imageView2 != null) {
                i5 = R.id.iv_star1_review;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star1_review);
                if (imageView3 != null) {
                    i5 = R.id.iv_star2_review;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star2_review);
                    if (imageView4 != null) {
                        i5 = R.id.iv_star3_review;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star3_review);
                        if (imageView5 != null) {
                            i5 = R.id.iv_star4_review;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star4_review);
                            if (imageView6 != null) {
                                i5 = R.id.iv_star5_review;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star5_review);
                                if (imageView7 != null) {
                                    i5 = R.id.ll_likes_review;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_likes_review);
                                    if (linearLayout != null) {
                                        i5 = R.id.ll_reviews_counter_review;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_reviews_counter_review);
                                        if (linearLayout2 != null) {
                                            i5 = R.id.ll_stars_review;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_stars_review);
                                            if (linearLayout3 != null) {
                                                i5 = R.id.tv_app_name_review;
                                                UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_app_name_review);
                                                if (usernameTextView != null) {
                                                    i5 = R.id.tv_body_review;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_body_review);
                                                    if (textView != null) {
                                                        i5 = R.id.tv_date_review;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_date_review);
                                                        if (textView2 != null) {
                                                            i5 = R.id.tv_likes_counter_review;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_likes_counter_review);
                                                            if (textView3 != null) {
                                                                i5 = R.id.tv_replies_counter_review;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_replies_counter_review);
                                                                if (textView4 != null) {
                                                                    i5 = R.id.tv_show_more_review;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_show_more_review);
                                                                    if (textView5 != null) {
                                                                        return new N0((RelativeLayout) view2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout, linearLayout2, linearLayout3, usernameTextView, textView, textView2, textView3, textView4, textView5);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i5)));
    }

    public static N0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static N0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.review_mini, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22529a;
    }
}
