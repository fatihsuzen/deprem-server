package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class E0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22335a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f22336b;

    /* renamed from: c  reason: collision with root package name */
    public final View f22337c;

    /* renamed from: d  reason: collision with root package name */
    public final NestedScrollView f22338d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f22339e;

    /* renamed from: f  reason: collision with root package name */
    public final Toolbar f22340f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22341g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22342h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22343i;

    private E0(RelativeLayout relativeLayout, LinearLayout linearLayout, View view, NestedScrollView nestedScrollView, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f22335a = relativeLayout;
        this.f22336b = linearLayout;
        this.f22337c = view;
        this.f22338d = nestedScrollView;
        this.f22339e = recyclerView;
        this.f22340f = toolbar;
        this.f22341g = textView;
        this.f22342h = textView2;
        this.f22343i = textView3;
    }

    public static E0 a(View view) {
        int i5 = R.id.ll_upcoming_releases;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_upcoming_releases);
        if (linearLayout != null) {
            i5 = R.id.loading_view_upcoming_releases;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_upcoming_releases);
            if (findChildViewById != null) {
                i5 = R.id.nsv_upcoming_releases;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nsv_upcoming_releases);
                if (nestedScrollView != null) {
                    i5 = R.id.rv_upcoming_releases;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_upcoming_releases);
                    if (recyclerView != null) {
                        i5 = R.id.toolbar_upcoming_releases;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_upcoming_releases);
                        if (toolbar != null) {
                            i5 = R.id.tv_discover_upcoming_releases;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_discover_upcoming_releases);
                            if (textView != null) {
                                i5 = R.id.tv_no_items_upcoming_releases;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_upcoming_releases);
                                if (textView2 != null) {
                                    i5 = R.id.tv_title_upcoming_releases;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_upcoming_releases);
                                    if (textView3 != null) {
                                        return new E0((RelativeLayout) view, linearLayout, findChildViewById, nestedScrollView, recyclerView, toolbar, textView, textView2, textView3);
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

    public static E0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static E0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preregistration_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22335a;
    }
}
