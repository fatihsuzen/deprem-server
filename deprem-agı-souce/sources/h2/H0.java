package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;

public final class H0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22381a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22382b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22383c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22384d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f22385e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f22386f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f22387g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f22388h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f22389i;

    /* renamed from: j  reason: collision with root package name */
    public final View f22390j;

    /* renamed from: k  reason: collision with root package name */
    public final I0 f22391k;

    /* renamed from: l  reason: collision with root package name */
    public final I0 f22392l;

    /* renamed from: m  reason: collision with root package name */
    public final ScrollView f22393m;

    /* renamed from: n  reason: collision with root package name */
    public final Toolbar f22394n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f22395o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f22396p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f22397q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f22398r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f22399s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f22400t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f22401u;

    /* renamed from: v  reason: collision with root package name */
    public final UsernameTextView f22402v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f22403w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f22404x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f22405y;

    /* renamed from: z  reason: collision with root package name */
    public final I0 f22406z;

    private H0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, RelativeLayout relativeLayout2, View view, I0 i02, I0 i03, ScrollView scrollView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, UsernameTextView usernameTextView, TextView textView8, TextView textView9, TextView textView10, I0 i04) {
        this.f22381a = relativeLayout;
        this.f22382b = imageView;
        this.f22383c = imageView2;
        this.f22384d = imageView3;
        this.f22385e = linearLayout;
        this.f22386f = linearLayout2;
        this.f22387g = linearLayout3;
        this.f22388h = linearLayout4;
        this.f22389i = relativeLayout2;
        this.f22390j = view;
        this.f22391k = i02;
        this.f22392l = i03;
        this.f22393m = scrollView;
        this.f22394n = toolbar;
        this.f22395o = textView;
        this.f22396p = textView2;
        this.f22397q = textView3;
        this.f22398r = textView4;
        this.f22399s = textView5;
        this.f22400t = textView6;
        this.f22401u = textView7;
        this.f22402v = usernameTextView;
        this.f22403w = textView8;
        this.f22404x = textView9;
        this.f22405y = textView10;
        this.f22406z = i04;
    }

    public static H0 a(View view) {
        View view2 = view;
        int i5 = R.id.iv_bg_public_profile;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_bg_public_profile);
        if (imageView != null) {
            i5 = R.id.iv_icon_public_profile;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_icon_public_profile);
            if (imageView2 != null) {
                i5 = R.id.iv_turbo_mark_public_profile;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_turbo_mark_public_profile);
                if (imageView3 != null) {
                    i5 = R.id.ll_actions_public_profile;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_actions_public_profile);
                    if (linearLayout != null) {
                        i5 = R.id.ll_followers_public_profile;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_followers_public_profile);
                        if (linearLayout2 != null) {
                            i5 = R.id.ll_followings_public_profile;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_followings_public_profile);
                            if (linearLayout3 != null) {
                                i5 = R.id.ll_reviews_public_profile;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_reviews_public_profile);
                                if (linearLayout4 != null) {
                                    i5 = R.id.ll_user_stats_public_profile;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.ll_user_stats_public_profile);
                                    if (relativeLayout != null) {
                                        i5 = R.id.loading_view_public_profile;
                                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_public_profile);
                                        if (findChildViewById != null) {
                                            i5 = R.id.recommended_apps_public_profile;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.recommended_apps_public_profile);
                                            if (findChildViewById2 != null) {
                                                I0 a5 = I0.a(findChildViewById2);
                                                i5 = R.id.reviews_public_profile;
                                                View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.reviews_public_profile);
                                                if (findChildViewById3 != null) {
                                                    I0 a6 = I0.a(findChildViewById3);
                                                    i5 = R.id.s_public_profile;
                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view2, R.id.s_public_profile);
                                                    if (scrollView != null) {
                                                        i5 = R.id.toolbar_public_profile;
                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_public_profile);
                                                        if (toolbar != null) {
                                                            i5 = R.id.tv_edit_public_profile;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_edit_public_profile);
                                                            if (textView != null) {
                                                                i5 = R.id.tv_feed_public_profile;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_feed_public_profile);
                                                                if (textView2 != null) {
                                                                    i5 = R.id.tv_follow_public_profile;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_follow_public_profile);
                                                                    if (textView3 != null) {
                                                                        i5 = R.id.tv_followers_label_public_profile;
                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_followers_label_public_profile);
                                                                        if (textView4 != null) {
                                                                            i5 = R.id.tv_followers_value_public_profile;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_followers_value_public_profile);
                                                                            if (textView5 != null) {
                                                                                i5 = R.id.tv_followings_label_public_profile;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_followings_label_public_profile);
                                                                                if (textView6 != null) {
                                                                                    i5 = R.id.tv_followings_value_public_profile;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_followings_value_public_profile);
                                                                                    if (textView7 != null) {
                                                                                        i5 = R.id.tv_name_public_profile;
                                                                                        UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_name_public_profile);
                                                                                        if (usernameTextView != null) {
                                                                                            i5 = R.id.tv_registered_public_profile;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_registered_public_profile);
                                                                                            if (textView8 != null) {
                                                                                                i5 = R.id.tv_reviews_label_public_profile;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_label_public_profile);
                                                                                                if (textView9 != null) {
                                                                                                    i5 = R.id.tv_reviews_value_public_profile;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_reviews_value_public_profile);
                                                                                                    if (textView10 != null) {
                                                                                                        i5 = R.id.wishlist_public_profile;
                                                                                                        View findChildViewById4 = ViewBindings.findChildViewById(view2, R.id.wishlist_public_profile);
                                                                                                        if (findChildViewById4 != null) {
                                                                                                            return new H0((RelativeLayout) view2, imageView, imageView2, imageView3, linearLayout, linearLayout2, linearLayout3, linearLayout4, relativeLayout, findChildViewById, a5, a6, scrollView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, usernameTextView, textView8, textView9, textView10, I0.a(findChildViewById4));
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i5)));
    }

    public static H0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static H0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.public_profile_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22381a;
    }
}
