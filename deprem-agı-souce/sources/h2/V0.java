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

public final class V0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22661a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f22662b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f22663c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f22664d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22665e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f22666f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f22667g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f22668h;

    private V0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f22661a = relativeLayout;
        this.f22662b = imageView;
        this.f22663c = imageView2;
        this.f22664d = linearLayout;
        this.f22665e = textView;
        this.f22666f = textView2;
        this.f22667g = textView3;
        this.f22668h = textView4;
    }

    public static V0 a(View view) {
        int i5 = R.id.iv_background_sign_in_popup;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_background_sign_in_popup);
        if (imageView != null) {
            i5 = R.id.iv_close_sign_in_popup;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close_sign_in_popup);
            if (imageView2 != null) {
                i5 = R.id.ll_content_sign_in_popup;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_content_sign_in_popup);
                if (linearLayout != null) {
                    i5 = R.id.tv_continue_sign_in_popup;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_continue_sign_in_popup);
                    if (textView != null) {
                        i5 = R.id.tv_description_sign_in_popup;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_sign_in_popup);
                        if (textView2 != null) {
                            i5 = R.id.tv_footer_sign_in_popup;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_footer_sign_in_popup);
                            if (textView3 != null) {
                                i5 = R.id.tv_title_sign_in_popup;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_sign_in_popup);
                                if (textView4 != null) {
                                    return new V0((RelativeLayout) view, imageView, imageView2, linearLayout, textView, textView2, textView3, textView4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static V0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static V0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.sign_in_popup, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22661a;
    }
}
