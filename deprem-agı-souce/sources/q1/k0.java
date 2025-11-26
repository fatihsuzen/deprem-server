package Q1;

import android.view.View;
import com.uptodown.activities.preferences.PreferencesActivity;
import k3.l;
import kotlin.jvm.internal.J;

public final /* synthetic */ class k0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f3960a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ J f3961b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PreferencesActivity f3962c;

    public /* synthetic */ k0(l lVar, J j5, PreferencesActivity preferencesActivity) {
        this.f3960a = lVar;
        this.f3961b = j5;
        this.f3962c = preferencesActivity;
    }

    public final void onClick(View view) {
        PreferencesActivity.Y3(this.f3960a, this.f3961b, this.f3962c, view);
    }
}
