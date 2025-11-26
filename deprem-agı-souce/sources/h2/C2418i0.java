package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.i0  reason: case insensitive filesystem */
public final class C2418i0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23227a;

    /* renamed from: b  reason: collision with root package name */
    public final G f23228b;

    /* renamed from: c  reason: collision with root package name */
    public final View f23229c;

    /* renamed from: d  reason: collision with root package name */
    public final NestedScrollView f23230d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f23231e;

    /* renamed from: f  reason: collision with root package name */
    public final SearchView f23232f;

    /* renamed from: g  reason: collision with root package name */
    public final Toolbar f23233g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23234h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23235i;

    private C2418i0(RelativeLayout relativeLayout, G g5, View view, NestedScrollView nestedScrollView, RecyclerView recyclerView, SearchView searchView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f23227a = relativeLayout;
        this.f23228b = g5;
        this.f23229c = view;
        this.f23230d = nestedScrollView;
        this.f23231e = recyclerView;
        this.f23232f = searchView;
        this.f23233g = toolbar;
        this.f23234h = textView;
        this.f23235i = textView2;
    }

    public static C2418i0 a(View view) {
        int i5 = R.id.ll_order_my_apps;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.ll_order_my_apps);
        if (findChildViewById != null) {
            G a5 = G.a(findChildViewById);
            i5 = R.id.loading_view_my_apps;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.loading_view_my_apps);
            if (findChildViewById2 != null) {
                i5 = R.id.nsv_my_apps;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nsv_my_apps);
                if (nestedScrollView != null) {
                    i5 = R.id.rv_my_apps;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_my_apps);
                    if (recyclerView != null) {
                        i5 = R.id.search_view_my_apps;
                        SearchView searchView = (SearchView) ViewBindings.findChildViewById(view, R.id.search_view_my_apps);
                        if (searchView != null) {
                            i5 = R.id.toolbar_my_apps;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_my_apps);
                            if (toolbar != null) {
                                i5 = R.id.tv_no_items_filtered_my_apps;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_filtered_my_apps);
                                if (textView != null) {
                                    i5 = R.id.tv_toolbar_title_my_apps;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_my_apps);
                                    if (textView2 != null) {
                                        return new C2418i0((RelativeLayout) view, a5, findChildViewById2, nestedScrollView, recyclerView, searchView, toolbar, textView, textView2);
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

    public static C2418i0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2418i0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.my_apps, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23227a;
    }
}
