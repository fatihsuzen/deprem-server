package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class P0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22581a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f22582b;

    /* renamed from: c  reason: collision with root package name */
    public final HorizontalScrollView f22583c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22584d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f22585e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f22586f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f22587g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f22588h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f22589i;

    /* renamed from: j  reason: collision with root package name */
    public final ImageView f22590j;

    /* renamed from: k  reason: collision with root package name */
    public final LinearLayout f22591k;

    /* renamed from: l  reason: collision with root package name */
    public final LinearLayout f22592l;

    /* renamed from: m  reason: collision with root package name */
    public final View f22593m;

    /* renamed from: n  reason: collision with root package name */
    public final NestedScrollView f22594n;

    /* renamed from: o  reason: collision with root package name */
    public final RelativeLayout f22595o;

    /* renamed from: p  reason: collision with root package name */
    public final RelativeLayout f22596p;

    /* renamed from: q  reason: collision with root package name */
    public final RecyclerView f22597q;

    /* renamed from: r  reason: collision with root package name */
    public final Toolbar f22598r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f22599s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f22600t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f22601u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f22602v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f22603w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f22604x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f22605y;

    private P0(RelativeLayout relativeLayout, EditText editText, HorizontalScrollView horizontalScrollView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout, LinearLayout linearLayout2, View view, NestedScrollView nestedScrollView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f22581a = relativeLayout;
        this.f22582b = editText;
        this.f22583c = horizontalScrollView;
        this.f22584d = imageView;
        this.f22585e = imageView2;
        this.f22586f = imageView3;
        this.f22587g = imageView4;
        this.f22588h = imageView5;
        this.f22589i = imageView6;
        this.f22590j = imageView7;
        this.f22591k = linearLayout;
        this.f22592l = linearLayout2;
        this.f22593m = view;
        this.f22594n = nestedScrollView;
        this.f22595o = relativeLayout2;
        this.f22596p = relativeLayout3;
        this.f22597q = recyclerView;
        this.f22598r = toolbar;
        this.f22599s = textView;
        this.f22600t = textView2;
        this.f22601u = textView3;
        this.f22602v = textView4;
        this.f22603w = textView5;
        this.f22604x = textView6;
        this.f22605y = textView7;
    }

    public static P0 a(View view) {
        View view2 = view;
        int i5 = R.id.et_review;
        EditText editText = (EditText) ViewBindings.findChildViewById(view2, R.id.et_review);
        if (editText != null) {
            i5 = R.id.hsv_order_reviews;
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view2, R.id.hsv_order_reviews);
            if (horizontalScrollView != null) {
                i5 = R.id.iv_app_icon_reviews;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_app_icon_reviews);
                if (imageView != null) {
                    i5 = R.id.iv_send_review;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_send_review);
                    if (imageView2 != null) {
                        i5 = R.id.iv_star1_reviews;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star1_reviews);
                        if (imageView3 != null) {
                            i5 = R.id.iv_star2_reviews;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star2_reviews);
                            if (imageView4 != null) {
                                i5 = R.id.iv_star3_reviews;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star3_reviews);
                                if (imageView5 != null) {
                                    i5 = R.id.iv_star4_reviews;
                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star4_reviews);
                                    if (imageView6 != null) {
                                        i5 = R.id.iv_star5_reviews;
                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_star5_reviews);
                                        if (imageView7 != null) {
                                            i5 = R.id.ll_bottom_box_review;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_bottom_box_review);
                                            if (linearLayout != null) {
                                                i5 = R.id.ll_order_reviews;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_order_reviews);
                                                if (linearLayout2 != null) {
                                                    i5 = R.id.loading_view_reviews;
                                                    View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_reviews);
                                                    if (findChildViewById != null) {
                                                        i5 = R.id.nsv_reviews;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.nsv_reviews);
                                                        if (nestedScrollView != null) {
                                                            i5 = R.id.rl_bottom_box_shadow;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_bottom_box_shadow);
                                                            if (relativeLayout != null) {
                                                                i5 = R.id.rl_header_reviews;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_header_reviews);
                                                                if (relativeLayout2 != null) {
                                                                    i5 = R.id.rv_reviews;
                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rv_reviews);
                                                                    if (recyclerView != null) {
                                                                        i5 = R.id.toolbar_reviews;
                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_reviews);
                                                                        if (toolbar != null) {
                                                                            i5 = R.id.tv_app_author_reviews;
                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_author_reviews);
                                                                            if (textView != null) {
                                                                                i5 = R.id.tv_app_name_reviews;
                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_name_reviews);
                                                                                if (textView2 != null) {
                                                                                    i5 = R.id.tv_app_version_reviews;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_version_reviews);
                                                                                    if (textView3 != null) {
                                                                                        i5 = R.id.tv_order_by_best_reviews;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_order_by_best_reviews);
                                                                                        if (textView4 != null) {
                                                                                            i5 = R.id.tv_order_by_date_reviews;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_order_by_date_reviews);
                                                                                            if (textView5 != null) {
                                                                                                i5 = R.id.tv_order_by_most_reviews;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_order_by_most_reviews);
                                                                                                if (textView6 != null) {
                                                                                                    i5 = R.id.tv_toolbar_reviews;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_toolbar_reviews);
                                                                                                    if (textView7 != null) {
                                                                                                        return new P0((RelativeLayout) view2, editText, horizontalScrollView, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout, linearLayout2, findChildViewById, nestedScrollView, relativeLayout, relativeLayout2, recyclerView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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

    public static P0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static P0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.reviews_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22581a;
    }
}
