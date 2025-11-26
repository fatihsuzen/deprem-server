package Q1;

import U1.C2201a;
import android.widget.CompoundButton;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;

/* renamed from: Q1.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0946b implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2201a f3938a;

    public /* synthetic */ C0946b(C2201a aVar) {
        this.f3938a = aVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        AdvancedPreferencesActivity.b4(this.f3938a, compoundButton, z4);
    }
}
