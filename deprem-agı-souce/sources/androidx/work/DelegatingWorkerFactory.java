package androidx.work;

import android.content.Context;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.t;

public class DelegatingWorkerFactory extends WorkerFactory {
    private final List<WorkerFactory> factories = new CopyOnWriteArrayList();

    public final void addFactory(WorkerFactory workerFactory) {
        t.e(workerFactory, "workerFactory");
        this.factories.add(workerFactory);
    }

    public final ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters) {
        t.e(context, "appContext");
        t.e(str, "workerClassName");
        t.e(workerParameters, "workerParameters");
        for (WorkerFactory createWorker : this.factories) {
            try {
                ListenableWorker createWorker2 = createWorker.createWorker(context, str, workerParameters);
                if (createWorker2 != null) {
                    return createWorker2;
                }
            } catch (Throwable th) {
                Logger.get().error(DelegatingWorkerFactoryKt.TAG, "Unable to instantiate a ListenableWorker (" + str + ')', th);
                throw th;
            }
        }
        return null;
    }
}
