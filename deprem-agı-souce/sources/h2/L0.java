package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

public final class L0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22465a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f22466b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22467c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22468d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f22469e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f22470f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f22471g;

    /* renamed from: h  reason: collision with root package name */
    public final View f22472h;

    /* renamed from: i  reason: collision with root package name */
    public final View f22473i;

    /* renamed from: j  reason: collision with root package name */
    public final NestedScrollView f22474j;

    /* renamed from: k  reason: collision with root package name */
    public final M0 f22475k;

    /* renamed from: l  reason: collision with root package name */
    public final O0 f22476l;

    /* renamed from: m  reason: collision with root package name */
    public final RelativeLayout f22477m;

    /* renamed from: n  reason: collision with root package name */
    public final RelativeLayout f22478n;

    /* renamed from: o  reason: collision with root package name */
    public final RelativeLayout f22479o;

    /* renamed from: p  reason: collision with root package name */
    public final RecyclerView f22480p;

    /* renamed from: q  reason: collision with root package name */
    public final View f22481q;

    /* renamed from: r  reason: collision with root package name */
    public final Toolbar f22482r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f22483s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f22484t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f22485u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f22486v;

    private L0(RelativeLayout relativeLayout, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, View view, View view2, NestedScrollView nestedScrollView, M0 m02, O0 o02, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RecyclerView recyclerView, View view3, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f22465a = relativeLayout;
        this.f22466b = editText;
        this.f22467c = imageView;
        this.f22468d = imageView2;
        this.f22469e = imageView3;
        this.f22470f = linearLayout;
        this.f22471g = linearLayout2;
        this.f22472h = view;
        this.f22473i = view2;
        this.f22474j = nestedScrollView;
        this.f22475k = m02;
        this.f22476l = o02;
        this.f22477m = relativeLayout2;
        this.f22478n = relativeLayout3;
        this.f22479o = relativeLayout4;
        this.f22480p = recyclerView;
        this.f22481q = view3;
        this.f22482r = toolbar;
        this.f22483s = textView;
        this.f22484t = textView2;
        this.f22485u = textView3;
        this.f22486v = textView4;
    }

    public static L0 a(View view) {
        View view2 = view;
        int i5 = R.id.et_reply;
        EditText editText = (EditText) ViewBindings.findChildViewById(view2, R.id.et_reply);
        if (editText != null) {
            i5 = R.id.iv_icon_app_replies_activity;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_icon_app_replies_activity);
            if (imageView != null) {
                i5 = R.id.iv_send_reply;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_send_reply);
                if (imageView2 != null) {
                    i5 = R.id.iv_user_avatar_reply;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_user_avatar_reply);
                    if (imageView3 != null) {
                        i5 = R.id.ll_about_replies_activity;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_about_replies_activity);
                        if (linearLayout != null) {
                            i5 = R.id.ll_app_replies_activity;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_app_replies_activity);
                            if (linearLayout2 != null) {
                                i5 = R.id.loading_view_replies;
                                View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_replies);
                                if (findChildViewById != null) {
                                    i5 = R.id.login_wall;
                                    View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.login_wall);
                                    if (findChildViewById2 != null) {
                                        i5 = R.id.nsv_replies;
                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.nsv_replies);
                                        if (nestedScrollView != null) {
                                            i5 = R.id.review;
                                            View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.review);
                                            if (findChildViewById3 != null) {
                                                M0 a5 = M0.a(findChildViewById3);
                                                i5 = R.id.review_turbo;
                                                View findChildViewById4 = ViewBindings.findChildViewById(view2, R.id.review_turbo);
                                                if (findChildViewById4 != null) {
                                                    O0 a6 = O0.a(findChildViewById4);
                                                    i5 = R.id.rl_bottom_box_shadow;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_bottom_box_shadow);
                                                    if (relativeLayout != null) {
                                                        i5 = R.id.rl_box_user_reply;
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_box_user_reply);
                                                        if (relativeLayout2 != null) {
                                                            i5 = R.id.rl_user_reply;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_user_reply);
                                                            if (relativeLayout3 != null) {
                                                                i5 = R.id.rv_reply;
                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rv_reply);
                                                                if (recyclerView != null) {
                                                                    i5 = R.id.shadow_description_app_detail;
                                                                    View findChildViewById5 = ViewBindings.findChildViewById(view2, R.id.shadow_description_app_detail);
                                                                    if (findChildViewById5 != null) {
                                                                        i5 = R.id.toolbar_reply;
                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_reply);
                                                                        if (toolbar != null) {
                                                                            i5 = R.id.tv_about_label_replies_activity;
                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_about_label_replies_activity);
                                                                            if (textView != null) {
                                                                                i5 = R.id.tv_app_name_replies_activity;
                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_name_replies_activity);
                                                                                if (textView2 != null) {
                                                                                    i5 = R.id.tv_no_answer;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_no_answer);
                                                                                    if (textView3 != null) {
                                                                                        i5 = R.id.tv_title_reply;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_reply);
                                                                                        if (textView4 != null) {
                                                                                            return new L0((RelativeLayout) view2, editText, imageView, imageView2, imageView3, linearLayout, linearLayout2, findChildViewById, findChildViewById2, nestedScrollView, a5, a6, relativeLayout, relativeLayout2, relativeLayout3, recyclerView, findChildViewById5, toolbar, textView, textView2, textView3, textView4);
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

    public static L0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static L0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.replies_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22465a;
    }
}
