package O1;

import android.widget.CompoundButton;
import com.uptodown.activities.GdprPrivacySettings;

/* renamed from: O1.f0  reason: case insensitive filesystem */
public final /* synthetic */ class C0779f0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GdprPrivacySettings f3613a;

    public /* synthetic */ C0779f0(GdprPrivacySettings gdprPrivacySettings) {
        this.f3613a = gdprPrivacySettings;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        GdprPrivacySettings.t3(this.f3613a, compoundButton, z4);
    }
}
