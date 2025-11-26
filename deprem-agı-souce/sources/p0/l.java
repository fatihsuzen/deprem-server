package P0;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;

public final /* synthetic */ class l implements k3.l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f3888a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3889b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f3890c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Preferences.Key f3891d;

    public /* synthetic */ l(p pVar, String str, String str2, Preferences.Key key) {
        this.f3888a = pVar;
        this.f3889b = str;
        this.f3890c = str2;
        this.f3891d = key;
    }

    public final Object invoke(Object obj) {
        return p.b(this.f3888a, this.f3889b, this.f3890c, this.f3891d, (MutablePreferences) obj);
    }
}
