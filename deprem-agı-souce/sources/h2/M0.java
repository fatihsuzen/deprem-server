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

public final class M0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22497a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22498b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22499c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22500d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f22501e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f22502f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f22503g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f22504h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f22505i;

    /* renamed from: j  reason: collision with root package name */
    public final ImageView f22506j;

    /* renamed from: k  reason: collision with root package name */
    public final ImageView f22507k;

    /* renamed from: l  reason: collision with root package name */
    public final LinearLayout f22508l;

    /* renamed from: m  reason: collision with root package name */
    public final LinearLayout f22509m;

    /* renamed from: n  reason: collision with root package name */
    public final LinearLayout f22510n;

    /* renamed from: o  reason: collision with root package name */
    public final LinearLayout f22511o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f22512p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f22513q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f22514r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f22515s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f22516t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f22517u;

    /* renamed from: v  reason: collision with root package name */
    public final UsernameTextView f22518v;

    private M0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, UsernameTextView usernameTextView) {
        this.f22497a = relativeLayout;
        this.f22498b = imageView;
        this.f22499c = imageView2;
        this.f22500d = imageView3;
        this.f22501e = imageView4;
        this.f22502f = imageView5;
        this.f22503g = imageView6;
        this.f22504h = imageView7;
        this.f22505i = imageView8;
        this.f22506j = imageView9;
        this.f22507k = imageView10;
        this.f22508l = linearLayout;
        this.f22509m = linearLayout2;
        this.f22510n = linearLayout3;
        this.f22511o = linearLayout4;
        this.f22512p = textView;
        this.f22513q = textView2;
        this.f22514r = textView3;
        this.f22515s = textView4;
        this.f22516t = textView5;
        this.f22517u = textView6;
        this.f22518v = usernameTextView;
    }

    public static M0 a(View view) {
        View view2 = view;
        int i5 = R.id.iv_author_verified_review;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_author_verified_review);
        if (imageView != null) {
            i5 = R.id.iv_avatar_review;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_avatar_review);
            if (imageView2 != null) {
                i5 = R.id.iv_follow_user_review;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_follow_user_review);
                if (imageView3 != null) {
                    i5 = R.id.iv_likes_counter_review;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_likes_counter_review);
                    if (imageView4 != null) {
                        i5 = R.id.iv_star1_review;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star1_review);
                        if (imageView5 != null) {
                            i5 = R.id.iv_star2_review;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star2_review);
                            if (imageView6 != null) {
                                i5 = R.id.iv_star3_review;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star3_review);
                                if (imageView7 != null) {
                                    i5 = R.id.iv_star4_review;
                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star4_review);
                                    if (imageView8 != null) {
                                        i5 = R.id.iv_star5_review;
                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star5_review);
                                        if (imageView9 != null) {
                                            i5 = R.id.iv_turbo_mark_review;
                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_turbo_mark_review);
                                            if (imageView10 != null) {
                                                i5 = R.id.ll_likes_review;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_likes_review);
                                                if (linearLayout != null) {
                                                    i5 = R.id.ll_reviews_counter_review;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_reviews_counter_review);
                                                    if (linearLayout2 != null) {
                                                        i5 = R.id.ll_stars_review;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_stars_review);
                                                        if (linearLayout3 != null) {
                                                            i5 = R.id.ll_username_review;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_username_review);
                                                            if (linearLayout4 != null) {
                                                                i5 = R.id.tv_body_review;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_body_review);
                                                                if (textView != null) {
                                                                    i5 = R.id.tv_date_review;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_date_review);
                                                                    if (textView2 != null) {
                                                                        i5 = R.id.tv_likes_counter_review;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_likes_counter_review);
                                                                        if (textView3 != null) {
                                                                            i5 = R.id.tv_reply_review;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reply_review);
                                                                            if (textView4 != null) {
                                                                                i5 = R.id.tv_reviews_counter_review;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_counter_review);
                                                                                if (textView5 != null) {
                                                                                    i5 = R.id.tv_show_more_review;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_show_more_review);
                                                                                    if (textView6 != null) {
                                                                                        i5 = R.id.tv_username_review;
                                                                                        UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_username_review);
                                                                                        if (usernameTextView != null) {
                                                                                            return new M0((RelativeLayout) view2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView, textView2, textView3, textView4, textView5, textView6, usernameTextView);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i5)));
    }

    public static M0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static M0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.review, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22497a;
    }
}
