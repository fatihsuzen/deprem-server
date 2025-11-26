package Q1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.HashMap;

public final /* synthetic */ class S implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3926a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f3927b;

    public /* synthetic */ S(PreferencesActivity preferencesActivity, HashMap hashMap) {
        this.f3926a = preferencesActivity;
        this.f3927b = hashMap;
    }

    public final void onClick(View view) {
        PreferencesActivity.J4(this.f3926a, this.f3927b, view);
    }
}
