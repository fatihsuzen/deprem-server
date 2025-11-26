package Q1;

import android.widget.CompoundButton;
import com.uptodown.activities.preferences.PreferencesActivity;

public final /* synthetic */ class W implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3931a;

    public /* synthetic */ W(PreferencesActivity preferencesActivity) {
        this.f3931a = preferencesActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        PreferencesActivity.N4(this.f3931a, compoundButton, z4);
    }
}
