package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.net.Uri;

public abstract /* synthetic */ class l {
    public static /* synthetic */ JobInfo.TriggerContentUri a(Uri uri, int i5) {
        return new JobInfo.TriggerContentUri(uri, i5);
    }
}
