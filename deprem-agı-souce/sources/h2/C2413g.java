package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.g  reason: case insensitive filesystem */
public final class C2413g implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f23068a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f23069b;

    /* renamed from: c  reason: collision with root package name */
    public final View f23070c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f23071d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23072e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23073f;

    private C2413g(FrameLayout frameLayout, FrameLayout frameLayout2, View view, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f23068a = frameLayout;
        this.f23069b = frameLayout2;
        this.f23070c = view;
        this.f23071d = recyclerView;
        this.f23072e = textView;
        this.f23073f = textView2;
    }

    public static C2413g a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i5 = R.id.loading_view_apps_category_fragment;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_apps_category_fragment);
        if (findChildViewById != null) {
            i5 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
            if (recyclerView != null) {
                i5 = R.id.tv_no_data_apps_category_fragment;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_apps_category_fragment);
                if (textView != null) {
                    i5 = R.id.tv_reload_apps_category_fragment;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_reload_apps_category_fragment);
                    if (textView2 != null) {
                        return new C2413g(frameLayout, frameLayout, findChildViewById, recyclerView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2413g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2413g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.apps_category_fragment, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f23068a;
    }
}
