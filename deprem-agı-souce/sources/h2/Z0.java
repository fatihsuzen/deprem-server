package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class Z0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22721a;

    /* renamed from: b  reason: collision with root package name */
    public final View f22722b;

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f22723c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f22724d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f22725e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f22726f;

    /* renamed from: g  reason: collision with root package name */
    public final RecyclerView f22727g;

    /* renamed from: h  reason: collision with root package name */
    public final SwipeRefreshLayout f22728h;

    /* renamed from: i  reason: collision with root package name */
    public final Toolbar f22729i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22730j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f22731k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f22732l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f22733m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f22734n;

    private Z0(RelativeLayout relativeLayout, View view, ProgressBar progressBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f22721a = relativeLayout;
        this.f22722b = view;
        this.f22723c = progressBar;
        this.f22724d = relativeLayout2;
        this.f22725e = relativeLayout3;
        this.f22726f = relativeLayout4;
        this.f22727g = recyclerView;
        this.f22728h = swipeRefreshLayout;
        this.f22729i = toolbar;
        this.f22730j = textView;
        this.f22731k = textView2;
        this.f22732l = textView3;
        this.f22733m = textView4;
        this.f22734n = textView5;
    }

    public static Z0 a(View view) {
        View view2 = view;
        int i5 = R.id.loading_view_updates;
        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_updates);
        if (findChildViewById != null) {
            i5 = R.id.pb_update_all;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.pb_update_all);
            if (progressBar != null) {
                i5 = R.id.rl_bottom_box_download_button_updates;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_bottom_box_download_button_updates);
                if (relativeLayout != null) {
                    i5 = R.id.rl_bottom_box_shadow;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_bottom_box_shadow);
                    if (relativeLayout2 != null) {
                        i5 = R.id.rl_update_all_progress_bottom;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_update_all_progress_bottom);
                        if (relativeLayout3 != null) {
                            i5 = R.id.rv_updates;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rv_updates);
                            if (recyclerView != null) {
                                i5 = R.id.srl_updates;
                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view2, R.id.srl_updates);
                                if (swipeRefreshLayout != null) {
                                    i5 = R.id.toolbar_updates;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_updates);
                                    if (toolbar != null) {
                                        i5 = R.id.tv_cancel_update_all;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_cancel_update_all);
                                        if (textView != null) {
                                            i5 = R.id.tv_description_update_all;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_description_update_all);
                                            if (textView2 != null) {
                                                i5 = R.id.tv_install_all_updates;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_install_all_updates);
                                                if (textView3 != null) {
                                                    i5 = R.id.tv_title_update_all;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_update_all);
                                                    if (textView4 != null) {
                                                        i5 = R.id.tv_toolbar_title_updates;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_toolbar_title_updates);
                                                        if (textView5 != null) {
                                                            return new Z0((RelativeLayout) view2, findChildViewById, progressBar, relativeLayout, relativeLayout2, relativeLayout3, recyclerView, swipeRefreshLayout, toolbar, textView, textView2, textView3, textView4, textView5);
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

    public static Z0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static Z0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.updates, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22721a;
    }
}
