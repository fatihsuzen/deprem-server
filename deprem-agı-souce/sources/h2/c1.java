package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class c1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22854a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22855b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22856c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22857d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f22858e;

    /* renamed from: f  reason: collision with root package name */
    public final NestedScrollView f22859f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22860g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22861h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22862i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22863j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f22864k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f22865l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f22866m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f22867n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f22868o;

    private c1(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, NestedScrollView nestedScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.f22854a = relativeLayout;
        this.f22855b = imageView;
        this.f22856c = imageView2;
        this.f22857d = imageView3;
        this.f22858e = linearLayout;
        this.f22859f = nestedScrollView;
        this.f22860g = textView;
        this.f22861h = textView2;
        this.f22862i = textView3;
        this.f22863j = textView4;
        this.f22864k = textView5;
        this.f22865l = textView6;
        this.f22866m = textView7;
        this.f22867n = textView8;
        this.f22868o = textView9;
    }

    public static c1 a(View view) {
        View view2 = view;
        int i5 = R.id.iv_customization_turbo_welcome_popup;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_customization_turbo_welcome_popup);
        if (imageView != null) {
            i5 = R.id.iv_highlighted_comments_turbo_welcome_popup;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_highlighted_comments_turbo_welcome_popup);
            if (imageView2 != null) {
                i5 = R.id.iv_no_ads_turbo_welcome_popup;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_no_ads_turbo_welcome_popup);
                if (imageView3 != null) {
                    i5 = R.id.ll_content_turbo;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_content_turbo);
                    if (linearLayout != null) {
                        i5 = R.id.nsv_turbo_welcome_popup;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.nsv_turbo_welcome_popup);
                        if (nestedScrollView != null) {
                            i5 = R.id.tv_customization_desc_turbo_welcome_popup;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_customization_desc_turbo_welcome_popup);
                            if (textView != null) {
                                i5 = R.id.tv_customization_turbo_welcome_popup;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_customization_turbo_welcome_popup);
                                if (textView2 != null) {
                                    i5 = R.id.tv_desc_turbo_welcome_popup;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_desc_turbo_welcome_popup);
                                    if (textView3 != null) {
                                        i5 = R.id.tv_highlighted_comments_desc_turbo_welcome_popup;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_highlighted_comments_desc_turbo_welcome_popup);
                                        if (textView4 != null) {
                                            i5 = R.id.tv_highlighted_comments_turbo_welcome_popup;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_highlighted_comments_turbo_welcome_popup);
                                            if (textView5 != null) {
                                                i5 = R.id.tv_no_ads_desc_turbo_welcome_popup;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_no_ads_desc_turbo_welcome_popup);
                                                if (textView6 != null) {
                                                    i5 = R.id.tv_no_ads_turbo_welcome_popup;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_no_ads_turbo_welcome_popup);
                                                    if (textView7 != null) {
                                                        i5 = R.id.tv_start_turbo_welcome_popup;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_start_turbo_welcome_popup);
                                                        if (textView8 != null) {
                                                            i5 = R.id.tv_title_turbo_welcome_popup;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_turbo_welcome_popup);
                                                            if (textView9 != null) {
                                                                return new c1((RelativeLayout) view2, imageView, imageView2, imageView3, linearLayout, nestedScrollView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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

    public static c1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static c1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.uptodown_turbo_welcome_popup, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22854a;
    }
}
