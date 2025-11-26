package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class X implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f22695a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f22696b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f22697c;

    /* renamed from: d  reason: collision with root package name */
    public final View f22698d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f22699e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22700f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22701g;

    private X(FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, View view, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f22695a = frameLayout;
        this.f22696b = frameLayout2;
        this.f22697c = linearLayout;
        this.f22698d = view;
        this.f22699e = recyclerView;
        this.f22700f = textView;
        this.f22701g = textView2;
    }

    public static X a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i5 = R.id.ll_no_data_home_fragment;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_no_data_home_fragment);
        if (linearLayout != null) {
            i5 = R.id.loading_view_home_fragment;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_home_fragment);
            if (findChildViewById != null) {
                i5 = R.id.recycler_view_home;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view_home);
                if (recyclerView != null) {
                    i5 = R.id.tv_no_data_home_fragment;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_home_fragment);
                    if (textView != null) {
                        i5 = R.id.tv_reload_home_fragment;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_reload_home_fragment);
                        if (textView2 != null) {
                            return new X(frameLayout, frameLayout, linearLayout, findChildViewById, recyclerView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static X c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static X d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.home_fragment, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f22695a;
    }
}
