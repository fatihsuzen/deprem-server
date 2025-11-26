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

public final class U implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f22649a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f22650b;

    /* renamed from: c  reason: collision with root package name */
    public final View f22651c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f22652d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22653e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22654f;

    private U(FrameLayout frameLayout, FrameLayout frameLayout2, View view, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f22649a = frameLayout;
        this.f22650b = frameLayout2;
        this.f22651c = view;
        this.f22652d = recyclerView;
        this.f22653e = textView;
        this.f22654f = textView2;
    }

    public static U a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i5 = R.id.loading_view_games_category_fragment;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_games_category_fragment);
        if (findChildViewById != null) {
            i5 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
            if (recyclerView != null) {
                i5 = R.id.tv_no_data_games_category_fragment;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_games_category_fragment);
                if (textView != null) {
                    i5 = R.id.tv_reload_games_category_fragment;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_reload_games_category_fragment);
                    if (textView2 != null) {
                        return new U(frameLayout, frameLayout, findChildViewById, recyclerView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static U c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static U d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.games_category_fragment, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f22649a;
    }
}
