package Q1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.HashMap;

public final /* synthetic */ class a0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3936a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f3937b;

    public /* synthetic */ a0(PreferencesActivity preferencesActivity, HashMap hashMap) {
        this.f3936a = preferencesActivity;
        this.f3937b = hashMap;
    }

    public final void onClick(View view) {
        PreferencesActivity.g4(this.f3936a, this.f3937b, view);
    }
}
