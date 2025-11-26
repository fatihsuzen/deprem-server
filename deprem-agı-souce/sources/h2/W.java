package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class W implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22669a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22670b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22671c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f22672d;

    /* renamed from: e  reason: collision with root package name */
    public final ProgressBar f22673e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f22674f;

    /* renamed from: g  reason: collision with root package name */
    public final RelativeLayout f22675g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22676h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22677i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22678j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f22679k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f22680l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f22681m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f22682n;

    private W(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ProgressBar progressBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f22669a = relativeLayout;
        this.f22670b = imageView;
        this.f22671c = imageView2;
        this.f22672d = linearLayout;
        this.f22673e = progressBar;
        this.f22674f = relativeLayout2;
        this.f22675g = relativeLayout3;
        this.f22676h = textView;
        this.f22677i = textView2;
        this.f22678j = textView3;
        this.f22679k = textView4;
        this.f22680l = textView5;
        this.f22681m = textView6;
        this.f22682n = textView7;
    }

    public static W a(View view) {
        View view2 = view;
        int i5 = R.id.iv_home_card_featured_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_home_card_featured_item);
        if (imageView != null) {
            i5 = R.id.iv_logo_home_card_featured_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_logo_home_card_featured_item);
            if (imageView2 != null) {
                i5 = R.id.ll_progress_home_card_featured_item;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_progress_home_card_featured_item);
                if (linearLayout != null) {
                    i5 = R.id.pb_progress_home_card_featured_item;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_progress_home_card_featured_item);
                    if (progressBar != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view2;
                        i5 = R.id.rl_logo_home_card_featured_item;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_logo_home_card_featured_item);
                        if (relativeLayout2 != null) {
                            i5 = R.id.tv_desc_home_card_featured_item;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_desc_home_card_featured_item);
                            if (textView != null) {
                                i5 = R.id.tv_desc_home_card_featured_item_holder;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_desc_home_card_featured_item_holder);
                                if (textView2 != null) {
                                    i5 = R.id.tv_name_home_card_featured_item;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_name_home_card_featured_item);
                                    if (textView3 != null) {
                                        i5 = R.id.tv_name_home_card_featured_item_holder;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_name_home_card_featured_item_holder);
                                        if (textView4 != null) {
                                            i5 = R.id.tv_progress_home_card_featured_item;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_progress_home_card_featured_item);
                                            if (textView5 != null) {
                                                i5 = R.id.tv_status_home_card_featured_item;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_status_home_card_featured_item);
                                                if (textView6 != null) {
                                                    i5 = R.id.tv_verified_home_card_featured_item;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_verified_home_card_featured_item);
                                                    if (textView7 != null) {
                                                        return new W(relativeLayout, imageView, imageView2, linearLayout, progressBar, relativeLayout, relativeLayout2, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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

    public static W c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static W d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.home_card_featured_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22669a;
    }
}
