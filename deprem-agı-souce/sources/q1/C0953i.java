package Q1;

import android.view.View;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;
import h2.C2449y0;
import kotlin.jvm.internal.J;

/* renamed from: Q1.i  reason: case insensitive filesystem */
public final /* synthetic */ class C0953i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ J f3954a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AdvancedPreferencesActivity f3955b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C2449y0 f3956c;

    public /* synthetic */ C0953i(J j5, AdvancedPreferencesActivity advancedPreferencesActivity, C2449y0 y0Var) {
        this.f3954a = j5;
        this.f3955b = advancedPreferencesActivity;
        this.f3956c = y0Var;
    }

    public final void onClick(View view) {
        AdvancedPreferencesActivity.I3(this.f3954a, this.f3955b, this.f3956c, view);
    }
}
