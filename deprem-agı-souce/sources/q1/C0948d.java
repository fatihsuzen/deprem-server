package Q1;

import U1.C2201a;
import android.widget.CompoundButton;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;

/* renamed from: Q1.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0948d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2201a f3943a;

    public /* synthetic */ C0948d(C2201a aVar) {
        this.f3943a = aVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        AdvancedPreferencesActivity.d4(this.f3943a, compoundButton, z4);
    }
}
