package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class p1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23443a;

    /* renamed from: b  reason: collision with root package name */
    public final CheckBox f23444b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23445c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f23446d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23447e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23448f;

    private p1(RelativeLayout relativeLayout, CheckBox checkBox, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.f23443a = relativeLayout;
        this.f23444b = checkBox;
        this.f23445c = imageView;
        this.f23446d = linearLayout;
        this.f23447e = textView;
        this.f23448f = textView2;
    }

    public static p1 a(View view) {
        int i5 = R.id.cb_remote_install_device_item;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.cb_remote_install_device_item);
        if (checkBox != null) {
            i5 = R.id.iv_remote_install_device_item;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_remote_install_device_item);
            if (imageView != null) {
                i5 = R.id.ll_remote_install_device_item;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_remote_install_device_item);
                if (linearLayout != null) {
                    i5 = R.id.tv_remote_install_device_name_item;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_remote_install_device_name_item);
                    if (textView != null) {
                        i5 = R.id.tv_remote_install_status_item;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_remote_install_status_item);
                        if (textView2 != null) {
                            return new p1((RelativeLayout) view, checkBox, imageView, linearLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static p1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.user_remote_install_device_item, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23443a;
    }
}
