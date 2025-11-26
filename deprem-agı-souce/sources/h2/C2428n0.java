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

/* renamed from: h2.n0  reason: case insensitive filesystem */
public final class C2428n0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23386a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23387b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f23388c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f23389d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23390e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23391f;

    private C2428n0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f23386a = relativeLayout;
        this.f23387b = view;
        this.f23388c = recyclerView;
        this.f23389d = toolbar;
        this.f23390e = textView;
        this.f23391f = textView2;
    }

    public static C2428n0 a(View view) {
        int i5 = R.id.loading_view_notification_registry;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_notification_registry);
        if (findChildViewById != null) {
            i5 = R.id.rv_notifications_registry;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_notifications_registry);
            if (recyclerView != null) {
                i5 = R.id.toolbar_notifications_registry;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_notifications_registry);
                if (toolbar != null) {
                    i5 = R.id.tv_no_data_notifications_registry;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_no_data_notifications_registry);
                    if (textView != null) {
                        i5 = R.id.tv_title_notifications_registry;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_notifications_registry);
                        if (textView2 != null) {
                            return new C2428n0((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2428n0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2428n0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.notifications_registry_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23386a;
    }
}
