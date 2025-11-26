package Q1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.HashMap;

public final /* synthetic */ class D implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3908a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f3909b;

    public /* synthetic */ D(PreferencesActivity preferencesActivity, HashMap hashMap) {
        this.f3908a = preferencesActivity;
        this.f3909b = hashMap;
    }

    public final void onClick(View view) {
        PreferencesActivity.t4(this.f3908a, this.f3909b, view);
    }
}
