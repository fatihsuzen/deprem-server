package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.impl.workers.DiagnosticsWorker;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DiagnosticsReceiver extends BroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Logger.get().debug(TAG, "Requesting diagnostics");
            try {
                WorkManager.getInstance(context).enqueue((WorkRequest) OneTimeWorkRequest.from((Class<? extends ListenableWorker>) DiagnosticsWorker.class));
            } catch (IllegalStateException e5) {
                Logger.get().error(TAG, "WorkManager is not initialized", e5);
            }
        }
    }
}
