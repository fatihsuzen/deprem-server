package androidx.datastore.preferences;

import X2.C2250q;
import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.preferences.core.Preferences;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class PreferenceDataStoreDelegateKt$preferencesDataStore$1 extends u implements l {
    public static final PreferenceDataStoreDelegateKt$preferencesDataStore$1 INSTANCE = new PreferenceDataStoreDelegateKt$preferencesDataStore$1();

    PreferenceDataStoreDelegateKt$preferencesDataStore$1() {
        super(1);
    }

    public final List<DataMigration<Preferences>> invoke(Context context) {
        t.e(context, "it");
        return C2250q.g();
    }
}
