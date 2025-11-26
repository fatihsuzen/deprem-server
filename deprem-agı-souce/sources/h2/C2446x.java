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

/* renamed from: h2.x  reason: case insensitive filesystem */
public final class C2446x implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23662a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23663b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23664c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23665d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23666e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23667f;

    private C2446x(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f23662a = relativeLayout;
        this.f23663b = imageView;
        this.f23664c = textView;
        this.f23665d = textView2;
        this.f23666e = textView3;
        this.f23667f = textView4;
    }

    public static C2446x a(View view) {
        int i5 = R.id.iv_close_dialog_pre_register;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close_dialog_pre_register);
        if (imageView != null) {
            i5 = R.id.tv_cancel_dialog_pre_register;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel_dialog_pre_register);
            if (textView != null) {
                i5 = R.id.tv_description_dialog_pre_register;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_dialog_pre_register);
                if (textView2 != null) {
                    i5 = R.id.tv_ok_dialog_pre_register;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ok_dialog_pre_register);
                    if (textView3 != null) {
                        i5 = R.id.tv_title_dialog_pre_register;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_pre_register);
                        if (textView4 != null) {
                            return new C2446x((RelativeLayout) view, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2446x c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2446x d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_pre_register, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23662a;
    }
}
