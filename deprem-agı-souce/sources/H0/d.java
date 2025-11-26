package H0;

import androidx.datastore.preferences.core.Preferences;
import kotlin.jvm.internal.t;

public abstract class d {
    public static final Object a(Preferences preferences, Preferences.Key key, Object obj) {
        t.e(preferences, "<this>");
        t.e(key, "key");
        Object obj2 = preferences.get(key);
        if (obj2 == null) {
            return obj;
        }
        return obj2;
    }
}
