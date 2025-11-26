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

public final class K implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22442a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22443b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f22444c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f22445d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22446e;

    private K(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.f22442a = relativeLayout;
        this.f22443b = imageView;
        this.f22444c = textView;
        this.f22445d = textView2;
        this.f22446e = textView3;
    }

    public static K a(View view) {
        int i5 = R.id.iv_icon_feed_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_icon_feed_item);
        if (imageView != null) {
            i5 = R.id.tv_app_name_feed_item;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_name_feed_item);
            if (textView != null) {
                i5 = R.id.tv_app_short_description_feed_item;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_short_description_feed_item);
                if (textView2 != null) {
                    i5 = R.id.tv_list_feed_item;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_list_feed_item);
                    if (textView3 != null) {
                        return new K((RelativeLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static K c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static K d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.feed_item_add_list, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22442a;
    }
}
