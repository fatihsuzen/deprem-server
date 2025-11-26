package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;

@RequiresApi(28)
public final class SystemJobInfoConverterExtKt {
    public static final void setRequiredNetworkRequest(JobInfo.Builder builder, NetworkRequest networkRequest) {
        t.e(builder, "builder");
        JobInfo.Builder unused = builder.setRequiredNetwork(networkRequest);
    }
}
