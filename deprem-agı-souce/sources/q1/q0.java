package Q1;

import android.widget.CompoundButton;
import com.uptodown.activities.preferences.PreferencesActivity;

public final /* synthetic */ class q0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3976a;

    public /* synthetic */ q0(PreferencesActivity preferencesActivity) {
        this.f3976a = preferencesActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        PreferencesActivity.q4(this.f3976a, compoundButton, z4);
    }
}
