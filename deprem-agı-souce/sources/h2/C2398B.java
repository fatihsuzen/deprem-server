package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.B  reason: case insensitive filesystem */
public final class C2398B implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22262a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f22263b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f22264c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f22265d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f22266e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f22267f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f22268g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f22269h;

    /* renamed from: i  reason: collision with root package name */
    public final ImageView f22270i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f22271j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f22272k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f22273l;

    private C2398B(LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2, TextView textView3) {
        this.f22262a = linearLayout;
        this.f22263b = linearLayout2;
        this.f22264c = editText;
        this.f22265d = imageView;
        this.f22266e = imageView2;
        this.f22267f = imageView3;
        this.f22268g = imageView4;
        this.f22269h = imageView5;
        this.f22270i = imageView6;
        this.f22271j = textView;
        this.f22272k = textView2;
        this.f22273l = textView3;
    }

    public static C2398B a(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i5 = R.id.et_review;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et_review);
        if (editText != null) {
            i5 = R.id.iv_avatar_dialog_review;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_avatar_dialog_review);
            if (imageView != null) {
                i5 = R.id.iv_star1_dialog_review;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star1_dialog_review);
                if (imageView2 != null) {
                    i5 = R.id.iv_star2_dialog_review;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star2_dialog_review);
                    if (imageView3 != null) {
                        i5 = R.id.iv_star3_dialog_review;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star3_dialog_review);
                        if (imageView4 != null) {
                            i5 = R.id.iv_star4_dialog_review;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star4_dialog_review);
                            if (imageView5 != null) {
                                i5 = R.id.iv_star5_dialog_review;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_star5_dialog_review);
                                if (imageView6 != null) {
                                    i5 = R.id.tv_app_name_dialog_review;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_app_name_dialog_review);
                                    if (textView != null) {
                                        i5 = R.id.tv_cancel;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel);
                                        if (textView2 != null) {
                                            i5 = R.id.tv_ok;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ok);
                                            if (textView3 != null) {
                                                return new C2398B(linearLayout, linearLayout, editText, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView, textView2, textView3);
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

    public static C2398B c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2398B d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_review_stars, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22262a;
    }
}
