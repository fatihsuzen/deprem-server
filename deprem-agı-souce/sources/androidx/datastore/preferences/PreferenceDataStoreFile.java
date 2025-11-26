package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import kotlin.jvm.internal.t;

public final class PreferenceDataStoreFile {
    public static final File preferencesDataStoreFile(Context context, String str) {
        t.e(context, "<this>");
        t.e(str, RewardPlus.NAME);
        return DataStoreFile.dataStoreFile(context, str + ".preferences_pb");
    }
}
