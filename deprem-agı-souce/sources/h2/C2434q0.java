package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.q0  reason: case insensitive filesystem */
public final class C2434q0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23454a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f23455b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23456c;

    private C2434q0(LinearLayout linearLayout, RecyclerView recyclerView, TextView textView) {
        this.f23454a = linearLayout;
        this.f23455b = recyclerView;
        this.f23456c = textView;
    }

    public static C2434q0 a(View view) {
        int i5 = R.id.rv_most_popular_apps_organization;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_most_popular_apps_organization);
        if (recyclerView != null) {
            i5 = R.id.tv_most_popular_apps_organization;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_most_popular_apps_organization);
            if (textView != null) {
                return new C2434q0((LinearLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2434q0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.organization_carousel_apps_rv, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f23454a;
    }
}
