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

public final class I implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22407a;

    /* renamed from: b  reason: collision with root package name */
    public final View f22408b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f22409c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f22410d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22411e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22412f;

    private I(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f22407a = relativeLayout;
        this.f22408b = view;
        this.f22409c = recyclerView;
        this.f22410d = toolbar;
        this.f22411e = textView;
        this.f22412f = textView2;
    }

    public static I a(View view) {
        int i5 = R.id.loading_view_feed;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_feed);
        if (findChildViewById != null) {
            i5 = R.id.rv_feed;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_feed);
            if (recyclerView != null) {
                i5 = R.id.toolbar_feed;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_feed);
                if (toolbar != null) {
                    i5 = R.id.tv_no_data_feed;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_feed);
                    if (textView != null) {
                        i5 = R.id.tv_toolbar_feed;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_toolbar_feed);
                        if (textView2 != null) {
                            return new I((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static I c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static I d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.feed_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22407a;
    }
}
