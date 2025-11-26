package P0;

import androidx.datastore.preferences.core.MutablePreferences;
import k3.l;

public final /* synthetic */ class o implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f3895a;

    public /* synthetic */ o(long j5) {
        this.f3895a = j5;
    }

    public final Object invoke(Object obj) {
        return ((MutablePreferences) obj).set(p.f3896b, Long.valueOf(this.f3895a));
    }
}
