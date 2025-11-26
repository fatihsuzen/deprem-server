package O1;

import android.widget.CompoundButton;
import com.uptodown.activities.GdprPrivacySettings;

/* renamed from: O1.e0  reason: case insensitive filesystem */
public final /* synthetic */ class C0771e0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GdprPrivacySettings f3604a;

    public /* synthetic */ C0771e0(GdprPrivacySettings gdprPrivacySettings) {
        this.f3604a = gdprPrivacySettings;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        GdprPrivacySettings.s3(this.f3604a, compoundButton, z4);
    }
}
