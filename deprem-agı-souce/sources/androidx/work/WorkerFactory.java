package androidx.work;

import android.content.Context;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.t;

public abstract class WorkerFactory {
    private static final ListenableWorker createWorkerWithDefaultFallback$fallbackToReflection(Context context, String str, WorkerParameters workerParameters) {
        try {
            Object newInstance = createWorkerWithDefaultFallback$getWorkerClass(str).getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{context, workerParameters});
            t.b(newInstance);
            return (ListenableWorker) newInstance;
        } catch (Throwable th) {
            Logger logger = Logger.get();
            String access$getTAG$p = WorkerFactoryKt.TAG;
            logger.error(access$getTAG$p, "Could not instantiate " + str, th);
            throw th;
        }
    }

    private static final Class<? extends ListenableWorker> createWorkerWithDefaultFallback$getWorkerClass(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str).asSubclass(ListenableWorker.class);
            t.b(asSubclass);
            return asSubclass;
        } catch (Throwable th) {
            Logger logger = Logger.get();
            String access$getTAG$p = WorkerFactoryKt.TAG;
            logger.error(access$getTAG$p, "Invalid class: " + str, th);
            throw th;
        }
    }

    public abstract ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ListenableWorker createWorkerWithDefaultFallback(Context context, String str, WorkerParameters workerParameters) {
        t.e(context, "appContext");
        t.e(str, "workerClassName");
        t.e(workerParameters, "workerParameters");
        ListenableWorker createWorker = createWorker(context, str, workerParameters);
        if (createWorker == null) {
            createWorker = createWorkerWithDefaultFallback$fallbackToReflection(context, str, workerParameters);
        }
        if (!createWorker.isUsed()) {
            return createWorker;
        }
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
