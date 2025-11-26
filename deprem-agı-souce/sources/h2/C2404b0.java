package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.b0  reason: case insensitive filesystem */
public final class C2404b0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22837a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22838b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22839c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22840d;

    private C2404b0(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.f22837a = linearLayout;
        this.f22838b = imageView;
        this.f22839c = textView;
        this.f22840d = textView2;
    }

    public static C2404b0 a(View view) {
        int i5 = R.id.iv_app_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_app_icon);
        if (imageView != null) {
            i5 = R.id.tv_app_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_name);
            if (textView != null) {
                i5 = R.id.tv_app_version;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_version);
                if (textView2 != null) {
                    return new C2404b0((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2404b0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2404b0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.item_pending_install, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22837a;
    }
}
