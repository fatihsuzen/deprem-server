package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

public final /* synthetic */ class K implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f318a;

    public /* synthetic */ K(ViewConfiguration viewConfiguration) {
        this.f318a = viewConfiguration;
    }

    public final Object get() {
        return Integer.valueOf(this.f318a.getScaledMinimumFlingVelocity());
    }
}
