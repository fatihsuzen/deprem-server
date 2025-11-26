package O1;

import android.widget.CompoundButton;
import com.uptodown.activities.GdprPrivacySettings;

/* renamed from: O1.h0  reason: case insensitive filesystem */
public final /* synthetic */ class C0795h0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GdprPrivacySettings f3636a;

    public /* synthetic */ C0795h0(GdprPrivacySettings gdprPrivacySettings) {
        this.f3636a = gdprPrivacySettings;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        GdprPrivacySettings.v3(this.f3636a, compoundButton, z4);
    }
}
