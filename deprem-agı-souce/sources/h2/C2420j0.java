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

/* renamed from: h2.j0  reason: case insensitive filesystem */
public final class C2420j0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23245a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23246b;

    /* renamed from: c  reason: collision with root package name */
    public final C2422k0 f23247c;

    /* renamed from: d  reason: collision with root package name */
    public final NestedScrollView f23248d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f23249e;

    /* renamed from: f  reason: collision with root package name */
    public final SearchView f23250f;

    /* renamed from: g  reason: collision with root package name */
    public final Toolbar f23251g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23252h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23253i;

    private C2420j0(RelativeLayout relativeLayout, View view, C2422k0 k0Var, NestedScrollView nestedScrollView, RecyclerView recyclerView, SearchView searchView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f23245a = relativeLayout;
        this.f23246b = view;
        this.f23247c = k0Var;
        this.f23248d = nestedScrollView;
        this.f23249e = recyclerView;
        this.f23250f = searchView;
        this.f23251g = toolbar;
        this.f23252h = textView;
        this.f23253i = textView2;
    }

    public static C2420j0 a(View view) {
        int i5 = R.id.loading_view_my_downloads;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_my_downloads);
        if (findChildViewById != null) {
            i5 = R.id.my_downloads_filters;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.my_downloads_filters);
            if (findChildViewById2 != null) {
                C2422k0 a5 = C2422k0.a(findChildViewById2);
                i5 = R.id.nsv_my_downloads;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nsv_my_downloads);
                if (nestedScrollView != null) {
                    i5 = R.id.recyclerview;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerview);
                    if (recyclerView != null) {
                        i5 = R.id.search_view_my_downloads;
                        SearchView searchView = (SearchView) ViewBindings.findChildViewById(view, R.id.search_view_my_downloads);
                        if (searchView != null) {
                            i5 = R.id.toolbar_downloads;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_downloads);
                            if (toolbar != null) {
                                i5 = R.id.tv_no_items;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items);
                                if (textView != null) {
                                    i5 = R.id.tv_toolbar_title_downloads;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_title_downloads);
                                    if (textView2 != null) {
                                        return new C2420j0((RelativeLayout) view, findChildViewById, a5, nestedScrollView, recyclerView, searchView, toolbar, textView, textView2);
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

    public static C2420j0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2420j0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.my_downloads, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23245a;
    }
}
