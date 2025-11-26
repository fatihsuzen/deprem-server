package Q1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import h2.C2451z0;
import java.util.HashMap;

public final /* synthetic */ class J implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3915a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f3916b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.J f3917c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C2451z0 f3918d;

    public /* synthetic */ J(PreferencesActivity preferencesActivity, HashMap hashMap, kotlin.jvm.internal.J j5, C2451z0 z0Var) {
        this.f3915a = preferencesActivity;
        this.f3916b = hashMap;
        this.f3917c = j5;
        this.f3918d = z0Var;
    }

    public final void onClick(View view) {
        PreferencesActivity.A4(this.f3915a, this.f3916b, this.f3917c, this.f3918d, view);
    }
}
