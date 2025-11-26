package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import com.uptodown.R;

public final class U0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RadioButton f22655a;

    /* renamed from: b  reason: collision with root package name */
    public final RadioButton f22656b;

    private U0(RadioButton radioButton, RadioButton radioButton2) {
        this.f22655a = radioButton;
        this.f22656b = radioButton2;
    }

    public static U0 a(View view) {
        if (view != null) {
            RadioButton radioButton = (RadioButton) view;
            return new U0(radioButton, radioButton);
        }
        throw new NullPointerException("rootView");
    }

    public static U0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static U0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.settings_radio_button, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RadioButton getRoot() {
        return this.f22655a;
    }
}
