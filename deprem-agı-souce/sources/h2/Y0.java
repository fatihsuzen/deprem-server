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

public final class Y0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22715a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22716b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22717c;

    private Y0(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.f22715a = linearLayout;
        this.f22716b = imageView;
        this.f22717c = textView;
    }

    public static Y0 a(View view) {
        int i5 = R.id.iv_user_says;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_user_says);
        if (imageView != null) {
            i5 = R.id.tv_user_says;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_user_says);
            if (textView != null) {
                return new Y0((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static Y0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static Y0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.tv_user_says, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22715a;
    }
}
