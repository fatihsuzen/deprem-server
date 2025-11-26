package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.views.FullWidthImageView;

/* renamed from: h2.p0  reason: case insensitive filesystem */
public final class C2432p0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23425a;

    /* renamed from: b  reason: collision with root package name */
    public final FullWidthImageView f23426b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23427c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f23428d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f23429e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f23430f;

    /* renamed from: g  reason: collision with root package name */
    public final View f23431g;

    /* renamed from: h  reason: collision with root package name */
    public final RelativeLayout f23432h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f23433i;

    /* renamed from: j  reason: collision with root package name */
    public final RecyclerView f23434j;

    /* renamed from: k  reason: collision with root package name */
    public final ScrollView f23435k;

    /* renamed from: l  reason: collision with root package name */
    public final Toolbar f23436l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f23437m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f23438n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f23439o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f23440p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f23441q;

    /* renamed from: r  reason: collision with root package name */
    public final View f23442r;

    private C2432p0(RelativeLayout relativeLayout, FullWidthImageView fullWidthImageView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RecyclerView recyclerView, ScrollView scrollView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2) {
        this.f23425a = relativeLayout;
        this.f23426b = fullWidthImageView;
        this.f23427c = imageView;
        this.f23428d = imageView2;
        this.f23429e = imageView3;
        this.f23430f = imageView4;
        this.f23431g = view;
        this.f23432h = relativeLayout2;
        this.f23433i = relativeLayout3;
        this.f23434j = recyclerView;
        this.f23435k = scrollView;
        this.f23436l = toolbar;
        this.f23437m = textView;
        this.f23438n = textView2;
        this.f23439o = textView3;
        this.f23440p = textView4;
        this.f23441q = textView5;
        this.f23442r = view2;
    }

    public static C2432p0 a(View view) {
        View view2 = view;
        int i5 = R.id.iv_feature_organization;
        FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(view2, R.id.iv_feature_organization);
        if (fullWidthImageView != null) {
            i5 = R.id.iv_instagram_organization;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_instagram_organization);
            if (imageView != null) {
                i5 = R.id.iv_logo_organization;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_logo_organization);
                if (imageView2 != null) {
                    i5 = R.id.iv_tiktok_organization;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_tiktok_organization);
                    if (imageView3 != null) {
                        i5 = R.id.iv_twitter_organization;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_twitter_organization);
                        if (imageView4 != null) {
                            i5 = R.id.loading_view_organization;
                            View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_organization);
                            if (findChildViewById != null) {
                                i5 = R.id.rl_description_organization;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_description_organization);
                                if (relativeLayout != null) {
                                    i5 = R.id.rl_details_organization;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_details_organization);
                                    if (relativeLayout2 != null) {
                                        i5 = R.id.rv_organization;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rv_organization);
                                        if (recyclerView != null) {
                                            i5 = R.id.sv_organization;
                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view2, R.id.sv_organization);
                                            if (scrollView != null) {
                                                i5 = R.id.toolbar_organization;
                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_organization);
                                                if (toolbar != null) {
                                                    i5 = R.id.tv_description_organization;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_description_organization);
                                                    if (textView != null) {
                                                        i5 = R.id.tv_name_organization;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_name_organization);
                                                        if (textView2 != null) {
                                                            i5 = R.id.tv_read_more_organization;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_read_more_organization);
                                                            if (textView3 != null) {
                                                                i5 = R.id.tv_toolbar_title_organization;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_toolbar_title_organization);
                                                                if (textView4 != null) {
                                                                    i5 = R.id.tv_web_organization;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_web_organization);
                                                                    if (textView5 != null) {
                                                                        i5 = R.id.v_description_shadow_organization;
                                                                        View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.v_description_shadow_organization);
                                                                        if (findChildViewById2 != null) {
                                                                            return new C2432p0((RelativeLayout) view2, fullWidthImageView, imageView, imageView2, imageView3, imageView4, findChildViewById, relativeLayout, relativeLayout2, recyclerView, scrollView, toolbar, textView, textView2, textView3, textView4, textView5, findChildViewById2);
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

    public static C2432p0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2432p0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.organization_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23425a;
    }
}
