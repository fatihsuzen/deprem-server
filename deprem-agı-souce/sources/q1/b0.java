package Q1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.HashMap;

public final /* synthetic */ class b0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3939a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f3940b;

    public /* synthetic */ b0(PreferencesActivity preferencesActivity, HashMap hashMap) {
        this.f3939a = preferencesActivity;
        this.f3940b = hashMap;
    }

    public final void onClick(View view) {
        PreferencesActivity.i4(this.f3939a, this.f3940b, view);
    }
}
