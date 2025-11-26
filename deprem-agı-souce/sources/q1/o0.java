package Q1;

import android.widget.CompoundButton;
import com.uptodown.activities.preferences.PreferencesActivity;

public final /* synthetic */ class o0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3971a;

    public /* synthetic */ o0(PreferencesActivity preferencesActivity) {
        this.f3971a = preferencesActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        PreferencesActivity.n4(this.f3971a, compoundButton, z4);
    }
}
