package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class T0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22639a;

    /* renamed from: b  reason: collision with root package name */
    public final AppCompatImageView f22640b;

    /* renamed from: c  reason: collision with root package name */
    public final View f22641c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f22642d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f22643e;

    /* renamed from: f  reason: collision with root package name */
    public final Toolbar f22644f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22645g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22646h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22647i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22648j;

    private T0(RelativeLayout relativeLayout, AppCompatImageView appCompatImageView, View view, LinearLayout linearLayout, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f22639a = relativeLayout;
        this.f22640b = appCompatImageView;
        this.f22641c = view;
        this.f22642d = linearLayout;
        this.f22643e = recyclerView;
        this.f22644f = toolbar;
        this.f22645g = textView;
        this.f22646h = textView2;
        this.f22647i = textView3;
        this.f22648j = textView4;
    }

    public static T0 a(View view) {
        int i5 = R.id.iv_positives;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, R.id.iv_positives);
        if (appCompatImageView != null) {
            i5 = R.id.loading_view_security;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_security);
            if (findChildViewById != null) {
                i5 = R.id.rl_free_positives;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rl_free_positives);
                if (linearLayout != null) {
                    i5 = R.id.rv_positives;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_positives);
                    if (recyclerView != null) {
                        i5 = R.id.toolbar_positives;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_positives);
                        if (toolbar != null) {
                            i5 = R.id.tv_button_analysis_free_positives;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_button_analysis_free_positives);
                            if (textView != null) {
                                i5 = R.id.tv_last_analysis_free_positives;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_last_analysis_free_positives);
                                if (textView2 != null) {
                                    i5 = R.id.tv_title_free_positives;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_free_positives);
                                    if (textView3 != null) {
                                        i5 = R.id.tv_toolbar_title_positives;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_positives);
                                        if (textView4 != null) {
                                            return new T0((RelativeLayout) view, appCompatImageView, findChildViewById, linearLayout, recyclerView, toolbar, textView, textView2, textView3, textView4);
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

    public static T0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static T0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.security_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22639a;
    }
}
