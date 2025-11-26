package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.t  reason: case insensitive filesystem */
public final class C2438t implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23547a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23548b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23549c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23550d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23551e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23552f;

    private C2438t(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.f23547a = relativeLayout;
        this.f23548b = textView;
        this.f23549c = textView2;
        this.f23550d = textView3;
        this.f23551e = textView4;
        this.f23552f = textView5;
    }

    public static C2438t a(View view) {
        int i5 = R.id.tv_cancel_dialog_no_wifi_connection;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel_dialog_no_wifi_connection);
        if (textView != null) {
            i5 = R.id.tv_description_dialog_no_wifi_connection;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_description_dialog_no_wifi_connection);
            if (textView2 != null) {
                i5 = R.id.tv_ok_dialog_no_wifi_connection;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ok_dialog_no_wifi_connection);
                if (textView3 != null) {
                    i5 = R.id.tv_settings_dialog_no_wifi_connection;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_settings_dialog_no_wifi_connection);
                    if (textView4 != null) {
                        i5 = R.id.tv_title_dialog_no_wifi_connection;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_dialog_no_wifi_connection);
                        if (textView5 != null) {
                            return new C2438t((RelativeLayout) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2438t c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2438t d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_no_wifi_connection, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23547a;
    }
}
