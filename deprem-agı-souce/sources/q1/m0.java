package Q1;

import android.widget.CompoundButton;
import com.uptodown.activities.preferences.PreferencesActivity;

public final /* synthetic */ class m0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3966a;

    public /* synthetic */ m0(PreferencesActivity preferencesActivity) {
        this.f3966a = preferencesActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        PreferencesActivity.l4(this.f3966a, compoundButton, z4);
    }
}
