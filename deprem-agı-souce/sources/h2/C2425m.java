package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.m  reason: case insensitive filesystem */
public final class C2425m implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23338a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23339b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23340c;

    private C2425m(RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        this.f23338a = relativeLayout;
        this.f23339b = imageView;
        this.f23340c = textView;
    }

    public static C2425m a(View view) {
        int i5 = R.id.iv_icon_deep_link_available;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_icon_deep_link_available);
        if (imageView != null) {
            i5 = R.id.tv_name_deep_link_available;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_name_deep_link_available);
            if (textView != null) {
                return new C2425m((RelativeLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2425m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2425m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.deep_link_available_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23338a;
    }
}
