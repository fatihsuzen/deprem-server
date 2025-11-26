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

public final class i1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23236a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23237b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23238c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f23239d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f23240e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23241f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23242g;

    private i1(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.f23236a = relativeLayout;
        this.f23237b = imageView;
        this.f23238c = imageView2;
        this.f23239d = linearLayout;
        this.f23240e = relativeLayout2;
        this.f23241f = textView;
        this.f23242g = textView2;
    }

    public static i1 a(View view) {
        int i5 = R.id.iv_action_user_device_app_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_action_user_device_app_item);
        if (imageView != null) {
            i5 = R.id.iv_icon_user_device_app_item;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_icon_user_device_app_item);
            if (imageView2 != null) {
                i5 = R.id.ll_info_user_device_app_item;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_info_user_device_app_item);
                if (linearLayout != null) {
                    i5 = R.id.rl_container_user_device_app_item;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_container_user_device_app_item);
                    if (relativeLayout != null) {
                        i5 = R.id.tv_last_update_user_device_app_item;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_last_update_user_device_app_item);
                        if (textView != null) {
                            i5 = R.id.tv_name_user_device_app_item;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_name_user_device_app_item);
                            if (textView2 != null) {
                                return new i1((RelativeLayout) view, imageView, imageView2, linearLayout, relativeLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static i1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_device_app_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23236a;
    }
}
