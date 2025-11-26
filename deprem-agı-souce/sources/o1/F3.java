package O1;

import android.widget.CompoundButton;
import com.uptodown.activities.OldVersionsActivity;

public final /* synthetic */ class F3 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OldVersionsActivity f3254a;

    public /* synthetic */ F3(OldVersionsActivity oldVersionsActivity) {
        this.f3254a = oldVersionsActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        OldVersionsActivity.B3(this.f3254a, compoundButton, z4);
    }
}
