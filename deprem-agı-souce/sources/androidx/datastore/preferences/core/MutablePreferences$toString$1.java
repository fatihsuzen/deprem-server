package androidx.datastore.preferences.core;

import X2.C2242i;
import androidx.datastore.preferences.core.Preferences;
import java.util.Map;
import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class MutablePreferences$toString$1 extends u implements l {
    public static final MutablePreferences$toString$1 INSTANCE = new MutablePreferences$toString$1();

    MutablePreferences$toString$1() {
        super(1);
    }

    public final CharSequence invoke(Map.Entry<Preferences.Key<?>, Object> entry) {
        String str;
        t.e(entry, "entry");
        Object value = entry.getValue();
        if (value instanceof byte[]) {
            str = C2242i.d0((byte[]) value, ", ", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
        } else {
            str = String.valueOf(entry.getValue());
        }
        return "  " + entry.getKey().getName() + " = " + str;
    }
}
