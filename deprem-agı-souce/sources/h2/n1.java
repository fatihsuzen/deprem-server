package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class n1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23392a;

    /* renamed from: b  reason: collision with root package name */
    public final HorizontalScrollView f23393b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23394c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f23395d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f23396e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f23397f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f23398g;

    /* renamed from: h  reason: collision with root package name */
    public final ProgressBar f23399h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f23400i;

    /* renamed from: j  reason: collision with root package name */
    public final RelativeLayout f23401j;

    /* renamed from: k  reason: collision with root package name */
    public final RelativeLayout f23402k;

    /* renamed from: l  reason: collision with root package name */
    public final RelativeLayout f23403l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f23404m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f23405n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f23406o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f23407p;

    /* renamed from: q  reason: collision with root package name */
    public final o1 f23408q;

    private n1(RelativeLayout relativeLayout, HorizontalScrollView horizontalScrollView, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, TextView textView, TextView textView2, TextView textView3, TextView textView4, o1 o1Var) {
        this.f23392a = relativeLayout;
        this.f23393b = horizontalScrollView;
        this.f23394c = imageView;
        this.f23395d = imageView2;
        this.f23396e = imageView3;
        this.f23397f = linearLayout;
        this.f23398g = linearLayout2;
        this.f23399h = progressBar;
        this.f23400i = relativeLayout2;
        this.f23401j = relativeLayout3;
        this.f23402k = relativeLayout4;
        this.f23403l = relativeLayout5;
        this.f23404m = textView;
        this.f23405n = textView2;
        this.f23406o = textView3;
        this.f23407p = textView4;
        this.f23408q = o1Var;
    }

    public static n1 a(View view) {
        View view2 = view;
        int i5 = R.id.hsv_floating_tags_user_list_item;
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view2, R.id.hsv_floating_tags_user_list_item);
        if (horizontalScrollView != null) {
            i5 = R.id.iv_cancel_user_list_item;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_cancel_user_list_item);
            if (imageView != null) {
                i5 = R.id.iv_icon_platform_user_list_item;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_icon_platform_user_list_item);
                if (imageView2 != null) {
                    i5 = R.id.iv_icon_user_list_item;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_icon_user_list_item);
                    if (imageView3 != null) {
                        i5 = R.id.ll_info_user_list_item;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_info_user_list_item);
                        if (linearLayout != null) {
                            i5 = R.id.ll_user_list_item_floating_categories;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_user_list_item_floating_categories);
                            if (linearLayout2 != null) {
                                i5 = R.id.pb_progress_user_list_item;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_progress_user_list_item);
                                if (progressBar != null) {
                                    i5 = R.id.rl_actions_user_list_item;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_actions_user_list_item);
                                    if (relativeLayout != null) {
                                        i5 = R.id.rl_cancel_user_list_item;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_cancel_user_list_item);
                                        if (relativeLayout2 != null) {
                                            i5 = R.id.rl_container_user_list_item;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_container_user_list_item);
                                            if (relativeLayout3 != null) {
                                                i5 = R.id.rl_icon_progress_user_list_item;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_icon_progress_user_list_item);
                                                if (relativeLayout4 != null) {
                                                    i5 = R.id.tv_action_user_list_item;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_action_user_list_item);
                                                    if (textView != null) {
                                                        i5 = R.id.tv_date_user_list_item;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_date_user_list_item);
                                                        if (textView2 != null) {
                                                            i5 = R.id.tv_name_user_list_item;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_name_user_list_item);
                                                            if (textView3 != null) {
                                                                i5 = R.id.tv_pending_user_list_item;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_pending_user_list_item);
                                                                if (textView4 != null) {
                                                                    i5 = R.id.user_list_item_floating_tag;
                                                                    View findChildViewById = ViewBindings.findChildViewById(view2, R.id.user_list_item_floating_tag);
                                                                    if (findChildViewById != null) {
                                                                        return new n1((RelativeLayout) view2, horizontalScrollView, imageView, imageView2, imageView3, linearLayout, linearLayout2, progressBar, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, textView, textView2, textView3, textView4, o1.a(findChildViewById));
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

    public static n1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_list_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23392a;
    }
}
