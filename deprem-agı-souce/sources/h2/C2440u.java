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

/* renamed from: h2.u  reason: case insensitive filesystem */
public final class C2440u implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23564a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23565b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f23566c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f23567d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f23568e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f23569f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23570g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23571h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23572i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f23573j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f23574k;

    private C2440u(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f23564a = relativeLayout;
        this.f23565b = imageView;
        this.f23566c = linearLayout;
        this.f23567d = linearLayout2;
        this.f23568e = linearLayout3;
        this.f23569f = linearLayout4;
        this.f23570g = textView;
        this.f23571h = textView2;
        this.f23572i = textView3;
        this.f23573j = textView4;
        this.f23574k = textView5;
    }

    public static C2440u a(View view) {
        int i5 = R.id.iv_close_dialog_pending_installs;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_close_dialog_pending_installs);
        if (imageView != null) {
            i5 = R.id.ll_downloads_list;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_downloads_list);
            if (linearLayout != null) {
                i5 = R.id.ll_downloads_section;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_downloads_section);
                if (linearLayout2 != null) {
                    i5 = R.id.ll_updates_list;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_updates_list);
                    if (linearLayout3 != null) {
                        i5 = R.id.ll_updates_section;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_updates_section);
                        if (linearLayout4 != null) {
                            i5 = R.id.tv_downloads_title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_downloads_title);
                            if (textView != null) {
                                i5 = R.id.tv_go_to_downloads;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_go_to_downloads);
                                if (textView2 != null) {
                                    i5 = R.id.tv_go_to_updates;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_go_to_updates);
                                    if (textView3 != null) {
                                        i5 = R.id.tv_title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                        if (textView4 != null) {
                                            i5 = R.id.tv_updates_title;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_updates_title);
                                            if (textView5 != null) {
                                                return new C2440u((RelativeLayout) view, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView, textView2, textView3, textView4, textView5);
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

    public static C2440u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2440u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_pending_installs, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23564a;
    }
}
