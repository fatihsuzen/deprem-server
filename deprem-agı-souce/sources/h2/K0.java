package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.util.views.MaxHeightRecyclerView;

public final class K0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22447a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22448b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f22449c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f22450d;

    /* renamed from: e  reason: collision with root package name */
    public final MaxHeightRecyclerView f22451e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22452f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22453g;

    /* renamed from: h  reason: collision with root package name */
    public final View f22454h;

    private K0(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout2, MaxHeightRecyclerView maxHeightRecyclerView, TextView textView, TextView textView2, View view) {
        this.f22447a = relativeLayout;
        this.f22448b = imageView;
        this.f22449c = linearLayout;
        this.f22450d = relativeLayout2;
        this.f22451e = maxHeightRecyclerView;
        this.f22452f = textView;
        this.f22453g = textView2;
        this.f22454h = view;
    }

    public static K0 a(View view) {
        int i5 = R.id.iv_close_remote_install_devices;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close_remote_install_devices);
        if (imageView != null) {
            i5 = R.id.rl_remote_install_devices;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.rl_remote_install_devices);
            if (linearLayout != null) {
                i5 = R.id.rlp_remote_install_devices;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rlp_remote_install_devices);
                if (relativeLayout != null) {
                    i5 = R.id.rv_remote_install_devices;
                    MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) ViewBindings.findChildViewById(view, R.id.rv_remote_install_devices);
                    if (maxHeightRecyclerView != null) {
                        i5 = R.id.tv_remote_install_devices;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_remote_install_devices);
                        if (textView != null) {
                            i5 = R.id.tv_title_remote_install_devices;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_remote_install_devices);
                            if (textView2 != null) {
                                i5 = R.id.v_background_remote_install_devices;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.v_background_remote_install_devices);
                                if (findChildViewById != null) {
                                    return new K0((RelativeLayout) view, imageView, linearLayout, relativeLayout, maxHeightRecyclerView, textView, textView2, findChildViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static K0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static K0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.remote_install_devices_popup, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22447a;
    }
}
