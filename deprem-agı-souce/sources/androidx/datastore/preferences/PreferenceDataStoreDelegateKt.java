package androidx.datastore.preferences;

import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.Preferences;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import k3.l;
import kotlin.jvm.internal.t;
import n3.C2700a;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.T0;

public final class PreferenceDataStoreDelegateKt {
    public static final C2700a preferencesDataStore(String str, ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, l lVar, M m5) {
        t.e(str, RewardPlus.NAME);
        t.e(lVar, "produceMigrations");
        t.e(m5, "scope");
        return new PreferenceDataStoreSingletonDelegate(str, replaceFileCorruptionHandler, lVar, m5);
    }

    public static /* synthetic */ C2700a preferencesDataStore$default(String str, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, l lVar, M m5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i5 & 4) != 0) {
            lVar = PreferenceDataStoreDelegateKt$preferencesDataStore$1.INSTANCE;
        }
        if ((i5 & 8) != 0) {
            m5 = N.a(C2865c0.b().plus(T0.b((C2908y0) null, 1, (Object) null)));
        }
        return preferencesDataStore(str, replaceFileCorruptionHandler, lVar, m5);
    }
}
