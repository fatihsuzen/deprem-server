package androidx.work;

import android.content.ComponentName;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import androidx.work.impl.utils.EnqueueUtilsKt;
import java.util.UUID;
import kotlin.jvm.internal.t;

public final class WorkerParametersExtensions {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Data buildDelegatedRemoteRequestData(String str, ComponentName componentName, Data data) {
        t.e(str, "delegatedWorkerName");
        t.e(componentName, "componentName");
        t.e(data, "inputData");
        Data.Builder builder = new Data.Builder();
        builder.putAll(data).putString(EnqueueUtilsKt.ARGUMENT_SERVICE_PACKAGE_NAME, componentName.getPackageName()).putString(EnqueueUtilsKt.ARGUMENT_SERVICE_CLASS_NAME, componentName.getClassName()).putString(EnqueueUtilsKt.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, str);
        return builder.build();
    }

    public static final boolean isRemoteWorkRequest(WorkerParameters workerParameters) {
        t.e(workerParameters, "<this>");
        Data inputData = workerParameters.getInputData();
        t.d(inputData, "getInputData(...)");
        return isRemoteWorkRequest(inputData);
    }

    public static final /* synthetic */ <T extends ListenableWorker> WorkerParameters usingRemoteService(WorkerParameters workerParameters, ComponentName componentName) {
        t.e(workerParameters, "<this>");
        t.e(componentName, "componentName");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        String name = ListenableWorker.class.getName();
        t.d(name, "getName(...)");
        return usingRemoteService(workerParameters, name, componentName);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isRemoteWorkRequest(Data data) {
        t.e(data, "<this>");
        Class<String> cls = String.class;
        return data.hasKeyWithValueOfType(EnqueueUtilsKt.ARGUMENT_SERVICE_PACKAGE_NAME, cls) && data.hasKeyWithValueOfType(EnqueueUtilsKt.ARGUMENT_SERVICE_CLASS_NAME, cls) && data.hasKeyWithValueOfType(EnqueueUtilsKt.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, cls);
    }

    public static final WorkerParameters usingRemoteService(WorkerParameters workerParameters, String str, ComponentName componentName) {
        String str2 = str;
        ComponentName componentName2 = componentName;
        t.e(workerParameters, "<this>");
        t.e(str2, "workerClassName");
        t.e(componentName2, "componentName");
        UUID id = workerParameters.getId();
        Data inputData = workerParameters.getInputData();
        t.d(inputData, "getInputData(...)");
        return new WorkerParameters(id, buildDelegatedRemoteRequestData(str2, componentName2, inputData), workerParameters.getTags(), workerParameters.getRuntimeExtras(), workerParameters.getRunAttemptCount(), workerParameters.getGeneration(), workerParameters.getBackgroundExecutor(), workerParameters.getWorkerContext(), workerParameters.getTaskExecutor(), workerParameters.getWorkerFactory(), workerParameters.getProgressUpdater(), workerParameters.getForegroundUpdater());
    }
}
