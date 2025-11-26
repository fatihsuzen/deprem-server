package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.y  reason: case insensitive filesystem */
public final class C2448y implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f23675a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23676b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23677c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f23678d;

    private C2448y(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.f23675a = linearLayout;
        this.f23676b = textView;
        this.f23677c = textView2;
        this.f23678d = textView3;
    }

    public static C2448y a(View view) {
        int i5 = R.id.tv_download_latest_version;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_download_latest_version);
        if (textView != null) {
            i5 = R.id.tv_download_selected_version;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_download_selected_version);
            if (textView2 != null) {
                i5 = R.id.tv_msg;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_msg);
                if (textView3 != null) {
                    return new C2448y((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2448y c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2448y d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.dialog_recent_version_available, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f23675a;
    }
}
