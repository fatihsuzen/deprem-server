package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class s1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23532a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23533b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23534c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23535d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23536e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23537f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23538g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23539h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23540i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f23541j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f23542k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f23543l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f23544m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f23545n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f23546o;

    private s1(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14) {
        this.f23532a = linearLayout;
        this.f23533b = textView;
        this.f23534c = textView2;
        this.f23535d = textView3;
        this.f23536e = textView4;
        this.f23537f = textView5;
        this.f23538g = textView6;
        this.f23539h = textView7;
        this.f23540i = textView8;
        this.f23541j = textView9;
        this.f23542k = textView10;
        this.f23543l = textView11;
        this.f23544m = textView12;
        this.f23545n = textView13;
        this.f23546o = textView14;
    }

    public static s1 a(View view) {
        View view2 = view;
        int i5 = R.id.tv_app_name_vd;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_name_vd);
        if (textView != null) {
            i5 = R.id.tv_filename_vd;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_filename_vd);
            if (textView2 != null) {
                i5 = R.id.tv_installed_version_vd;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_installed_version_vd);
                if (textView3 != null) {
                    i5 = R.id.tv_label_app_name_vd;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_label_app_name_vd);
                    if (textView4 != null) {
                        i5 = R.id.tv_label_filename_vd;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_label_filename_vd);
                        if (textView5 != null) {
                            i5 = R.id.tv_label_installed_version_vd;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_label_installed_version_vd);
                            if (textView6 != null) {
                                i5 = R.id.tv_label_packagename_vd;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_label_packagename_vd);
                                if (textView7 != null) {
                                    i5 = R.id.tv_label_size_vd;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_label_size_vd);
                                    if (textView8 != null) {
                                        i5 = R.id.tv_label_update_version_vd;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_label_update_version_vd);
                                        if (textView9 != null) {
                                            i5 = R.id.tv_packagename_vd;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_packagename_vd);
                                            if (textView10 != null) {
                                                i5 = R.id.tv_size_vd;
                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_size_vd);
                                                if (textView11 != null) {
                                                    i5 = R.id.tv_title_vd;
                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_vd);
                                                    if (textView12 != null) {
                                                        i5 = R.id.tv_update_version_vd;
                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_update_version_vd);
                                                        if (textView13 != null) {
                                                            i5 = R.id.tv_version_details_accept;
                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_version_details_accept);
                                                            if (textView14 != null) {
                                                                return new s1((LinearLayout) view2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i5)));
    }

    public static s1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.version_details_dialog, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f23532a;
    }
}
