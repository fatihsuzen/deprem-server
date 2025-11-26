package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class y1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23684a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23685b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f23686c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f23687d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23688e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23689f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23690g;

    private y1(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f23684a = relativeLayout;
        this.f23685b = view;
        this.f23686c = recyclerView;
        this.f23687d = toolbar;
        this.f23688e = textView;
        this.f23689f = textView2;
        this.f23690g = textView3;
    }

    public static y1 a(View view) {
        int i5 = R.id.loading_view_wishlist;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_wishlist);
        if (findChildViewById != null) {
            i5 = R.id.rv_wishlist;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_wishlist);
            if (recyclerView != null) {
                i5 = R.id.toolbar_wishlist;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_wishlist);
                if (toolbar != null) {
                    i5 = R.id.tv_explore_wishlist;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_explore_wishlist);
                    if (textView != null) {
                        i5 = R.id.tv_no_items_wishlist;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_wishlist);
                        if (textView2 != null) {
                            i5 = R.id.tv_title_wishlist;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_wishlist);
                            if (textView3 != null) {
                                return new y1((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static y1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static y1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.wishlist_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23684a;
    }
}
