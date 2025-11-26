package Q1;

import android.widget.CompoundButton;
import com.uptodown.activities.preferences.PreferencesActivity;

public final /* synthetic */ class G implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3912a;

    public /* synthetic */ G(PreferencesActivity preferencesActivity) {
        this.f3912a = preferencesActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        PreferencesActivity.w4(this.f3912a, compoundButton, z4);
    }
}
