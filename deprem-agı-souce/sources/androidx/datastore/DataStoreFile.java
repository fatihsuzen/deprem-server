package androidx.datastore;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.t;

public final class DataStoreFile {
    public static final File dataStoreFile(Context context, String str) {
        t.e(context, "<this>");
        t.e(str, "fileName");
        File filesDir = context.getApplicationContext().getFilesDir();
        return new File(filesDir, "datastore/" + str);
    }
}
