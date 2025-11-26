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

public final class G0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22373a;

    /* renamed from: b  reason: collision with root package name */
    public final View f22374b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f22375c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f22376d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22377e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22378f;

    private G0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f22373a = relativeLayout;
        this.f22374b = view;
        this.f22375c = recyclerView;
        this.f22376d = toolbar;
        this.f22377e = textView;
        this.f22378f = textView2;
    }

    public static G0 a(View view) {
        int i5 = R.id.loading_view_public_list;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_public_list);
        if (findChildViewById != null) {
            i5 = R.id.rv_public_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_public_list);
            if (recyclerView != null) {
                i5 = R.id.toolbar_public_list;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_public_list);
                if (toolbar != null) {
                    i5 = R.id.tv_no_items_public_list;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_items_public_list);
                    if (textView != null) {
                        i5 = R.id.tv_title_public_list;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_public_list);
                        if (textView2 != null) {
                            return new G0((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static G0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static G0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.public_list_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22373a;
    }
}
