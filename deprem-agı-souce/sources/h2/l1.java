package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class l1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23329a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23330b;

    /* renamed from: c  reason: collision with root package name */
    public final NestedScrollView f23331c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f23332d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f23333e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23334f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23335g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23336h;

    /* renamed from: i  reason: collision with root package name */
    public final k1 f23337i;

    private l1(RelativeLayout relativeLayout, View view, NestedScrollView nestedScrollView, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, k1 k1Var) {
        this.f23329a = relativeLayout;
        this.f23330b = view;
        this.f23331c = nestedScrollView;
        this.f23332d = recyclerView;
        this.f23333e = toolbar;
        this.f23334f = textView;
        this.f23335g = textView2;
        this.f23336h = textView3;
        this.f23337i = k1Var;
    }

    public static l1 a(View view) {
        int i5 = R.id.loading_view_user_devices;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_user_devices);
        if (findChildViewById != null) {
            i5 = R.id.nsv_user_devices;
            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.nsv_user_devices);
            if (nestedScrollView != null) {
                i5 = R.id.rv_user_devices;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_user_devices);
                if (recyclerView != null) {
                    i5 = R.id.toolbar_user_devices;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_user_devices);
                    if (toolbar != null) {
                        i5 = R.id.tv_other_devices_user_devices;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_other_devices_user_devices);
                        if (textView != null) {
                            i5 = R.id.tv_this_device_user_devices;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_this_device_user_devices);
                            if (textView2 != null) {
                                i5 = R.id.tv_user_devices;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_user_devices);
                                if (textView3 != null) {
                                    i5 = R.id.user_device;
                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.user_device);
                                    if (findChildViewById2 != null) {
                                        return new l1((RelativeLayout) view, findChildViewById, nestedScrollView, recyclerView, toolbar, textView, textView2, textView3, k1.a(findChildViewById2));
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

    public static l1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static l1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_devices_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23329a;
    }
}
