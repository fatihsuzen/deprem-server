package h2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class G implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22369a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22370b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22371c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22372d;

    private G(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.f22369a = linearLayout;
        this.f22370b = imageView;
        this.f22371c = textView;
        this.f22372d = textView2;
    }

    public static G a(View view) {
        int i5 = R.id.iv_version_details_update_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_version_details_update_item);
        if (imageView != null) {
            i5 = R.id.tv_order_label_selector;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_order_label_selector);
            if (textView != null) {
                i5 = R.id.tv_order_selector;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_order_selector);
                if (textView2 != null) {
                    return new G((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22369a;
    }
}
