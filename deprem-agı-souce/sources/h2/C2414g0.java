package h2;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.g0  reason: case insensitive filesystem */
public final class C2414g0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23074a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f23075b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f23076c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f23077d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f23078e;

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f23079f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23080g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23081h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23082i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f23083j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f23084k;

    private C2414g0(LinearLayout linearLayout, EditText editText, EditText editText2, ImageView imageView, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f23074a = linearLayout;
        this.f23075b = editText;
        this.f23076c = editText2;
        this.f23077d = imageView;
        this.f23078e = linearLayout2;
        this.f23079f = relativeLayout;
        this.f23080g = textView;
        this.f23081h = textView2;
        this.f23082i = textView3;
        this.f23083j = textView4;
        this.f23084k = textView5;
    }

    public static C2414g0 a(View view) {
        int i5 = R.id.et_pass_login;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_pass_login);
        if (editText != null) {
            i5 = R.id.et_user_login;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.et_user_login);
            if (editText2 != null) {
                i5 = R.id.iv_google;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_google);
                if (imageView != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i5 = R.id.rl_google_login;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_google_login);
                    if (relativeLayout != null) {
                        i5 = R.id.tv_continue_with_login;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_continue_with_login);
                        if (textView != null) {
                            i5 = R.id.tv_login;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_login);
                            if (textView2 != null) {
                                i5 = R.id.tv_login_google;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_login_google);
                                if (textView3 != null) {
                                    i5 = R.id.tv_msg_sign_up;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_msg_sign_up);
                                    if (textView4 != null) {
                                        i5 = R.id.tv_pass_forget_login;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_pass_forget_login);
                                        if (textView5 != null) {
                                            return new C2414g0(linearLayout, editText, editText2, imageView, linearLayout, relativeLayout, textView, textView2, textView3, textView4, textView5);
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
        return this.f23074a;
    }
}
