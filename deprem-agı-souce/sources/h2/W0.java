package h2;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class W0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22683a;

    /* renamed from: b  reason: collision with root package name */
    public final CheckBox f22684b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f22685c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f22686d;

    /* renamed from: e  reason: collision with root package name */
    public final EditText f22687e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f22688f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f22689g;

    /* renamed from: h  reason: collision with root package name */
    public final RelativeLayout f22690h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f22691i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22692j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f22693k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f22694l;

    private W0(LinearLayout linearLayout, CheckBox checkBox, EditText editText, EditText editText2, EditText editText3, ImageView imageView, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f22683a = linearLayout;
        this.f22684b = checkBox;
        this.f22685c = editText;
        this.f22686d = editText2;
        this.f22687e = editText3;
        this.f22688f = imageView;
        this.f22689g = linearLayout2;
        this.f22690h = relativeLayout;
        this.f22691i = textView;
        this.f22692j = textView2;
        this.f22693k = textView3;
        this.f22694l = textView4;
    }

    public static W0 a(View view) {
        int i5 = R.id.cb_condiciones;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.cb_condiciones);
        if (checkBox != null) {
            i5 = R.id.et_email_sign_up;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_email_sign_up);
            if (editText != null) {
                i5 = R.id.et_pass_sign_up;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.et_pass_sign_up);
                if (editText2 != null) {
                    i5 = R.id.et_user_sign_up;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, R.id.et_user_sign_up);
                    if (editText3 != null) {
                        i5 = R.id.iv_google;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_google);
                        if (imageView != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            i5 = R.id.rl_google_login;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_google_login);
                            if (relativeLayout != null) {
                                i5 = R.id.tv_already_signed_up;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_already_signed_up);
                                if (textView != null) {
                                    i5 = R.id.tv_continue_with_login;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_continue_with_login);
                                    if (textView2 != null) {
                                        i5 = R.id.tv_login_google;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_login_google);
                                        if (textView3 != null) {
                                            i5 = R.id.tv_sign_up;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_sign_up);
                                            if (textView4 != null) {
                                                return new W0(linearLayout, checkBox, editText, editText2, editText3, imageView, linearLayout, relativeLayout, textView, textView2, textView3, textView4);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22683a;
    }
}
