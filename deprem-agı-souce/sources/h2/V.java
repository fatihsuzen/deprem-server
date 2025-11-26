package h2;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class V implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22657a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22658b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22659c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22660d;

    private V(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.f22657a = relativeLayout;
        this.f22658b = imageView;
        this.f22659c = textView;
        this.f22660d = textView2;
    }

    public static V a(View view) {
        int i5 = R.id.iv_logo_app;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_logo_app);
        if (imageView != null) {
            i5 = R.id.tv_app_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_name);
            if (textView != null) {
                i5 = R.id.tv_app_version;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_version);
                if (textView2 != null) {
                    return new V((RelativeLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22657a;
    }
}
