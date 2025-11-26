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

public final class r implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23485a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23486b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f23487c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23488d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23489e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23490f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23491g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23492h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23493i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f23494j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f23495k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f23496l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f23497m;

    /* renamed from: n  reason: collision with root package name */
    public final View f23498n;

    private r(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view) {
        this.f23485a = relativeLayout;
        this.f23486b = imageView;
        this.f23487c = relativeLayout2;
        this.f23488d = textView;
        this.f23489e = textView2;
        this.f23490f = textView3;
        this.f23491g = textView4;
        this.f23492h = textView5;
        this.f23493i = textView6;
        this.f23494j = textView7;
        this.f23495k = textView8;
        this.f23496l = textView9;
        this.f23497m = textView10;
        this.f23498n = view;
    }

    public static r a(View view) {
        View view2 = view;
        int i5 = R.id.iv_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_icon);
        if (imageView != null) {
            i5 = R.id.rl_header;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_header);
            if (relativeLayout != null) {
                i5 = R.id.tv_app_details_ddo;
                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_details_ddo);
                if (textView != null) {
                    i5 = R.id.tv_app_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_name);
                    if (textView2 != null) {
                        i5 = R.id.tv_delete_ddo;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_delete_ddo);
                        if (textView3 != null) {
                            i5 = R.id.tv_open_containing_folder_ddo;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_open_containing_folder_ddo);
                            if (textView4 != null) {
                                i5 = R.id.tv_open_ddo;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_open_ddo);
                                if (textView5 != null) {
                                    i5 = R.id.tv_pause_ddo;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_pause_ddo);
                                    if (textView6 != null) {
                                        i5 = R.id.tv_select_ddo;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_select_ddo);
                                        if (textView7 != null) {
                                            i5 = R.id.tv_share_ddo;
                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_share_ddo);
                                            if (textView8 != null) {
                                                i5 = R.id.tv_title_download_general_management;
                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_download_general_management);
                                                if (textView9 != null) {
                                                    i5 = R.id.tv_title_download_sharing;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_download_sharing);
                                                    if (textView10 != null) {
                                                        i5 = R.id.v_outside_header;
                                                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.v_outside_header);
                                                        if (findChildViewById != null) {
                                                            return new r((RelativeLayout) view2, imageView, relativeLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, findChildViewById);
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

    public static r c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static r d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_download_options, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23485a;
    }
}
