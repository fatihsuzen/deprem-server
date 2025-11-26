package androidx.work;

import android.content.Context;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DefaultWorkerFactory extends WorkerFactory {
    public static final DefaultWorkerFactory INSTANCE = new DefaultWorkerFactory();

    private DefaultWorkerFactory() {
    }

    public Void createWorker(Context context, String str, WorkerParameters workerParameters) {
        t.e(context, "appContext");
        t.e(str, "workerClassName");
        t.e(workerParameters, "workerParameters");
        return null;
    }
}
