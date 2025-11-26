package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.BackoffPolicy;
import androidx.work.Clock;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class SystemJobInfoConverter {
    static final String EXTRA_IS_PERIODIC = "EXTRA_IS_PERIODIC";
    static final String EXTRA_WORK_SPEC_GENERATION = "EXTRA_WORK_SPEC_GENERATION";
    static final String EXTRA_WORK_SPEC_ID = "EXTRA_WORK_SPEC_ID";
    private static final String TAG = Logger.tagWithPrefix("SystemJobInfoConverter");
    private final Clock mClock;
    private final boolean mMarkImportantWhileForeground;
    private final ComponentName mWorkServiceComponent;

    /* renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.work.NetworkType[] r0 = androidx.work.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$work$NetworkType = r0
                androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobInfoConverter.AnonymousClass1.<clinit>():void");
        }
    }

    SystemJobInfoConverter(Context context, Clock clock, boolean z4) {
        this.mClock = clock;
        this.mWorkServiceComponent = new ComponentName(context.getApplicationContext(), SystemJobService.class);
        this.mMarkImportantWhileForeground = z4;
    }

    @RequiresApi(24)
    private static JobInfo.TriggerContentUri convertContentUriTrigger(Constraints.ContentUriTrigger contentUriTrigger) {
        boolean isTriggeredForDescendants = contentUriTrigger.isTriggeredForDescendants();
        c.a();
        return l.a(contentUriTrigger.getUri(), isTriggeredForDescendants ? 1 : 0);
    }

    static int convertNetworkType(NetworkType networkType) {
        int i5 = AnonymousClass1.$SwitchMap$androidx$work$NetworkType[networkType.ordinal()];
        if (i5 == 1) {
            return 0;
        }
        if (i5 == 2) {
            return 1;
        }
        if (i5 == 3) {
            return 2;
        }
        if (i5 != 4) {
            if (i5 == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, "API version too low. Cannot convert network type value " + networkType);
        return 1;
    }

    static void setRequiredNetwork(JobInfo.Builder builder, NetworkType networkType) {
        if (Build.VERSION.SDK_INT < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(convertNetworkType(networkType));
        } else {
            JobInfo.Builder unused = builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    /* access modifiers changed from: package-private */
    public JobInfo convert(WorkSpec workSpec, int i5) {
        boolean z4;
        String traceTag;
        int i6;
        Constraints constraints = workSpec.constraints;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(EXTRA_WORK_SPEC_ID, workSpec.id);
        persistableBundle.putInt(EXTRA_WORK_SPEC_GENERATION, workSpec.getGeneration());
        persistableBundle.putBoolean(EXTRA_IS_PERIODIC, workSpec.isPeriodic());
        JobInfo.Builder extras = new JobInfo.Builder(i5, this.mWorkServiceComponent).setRequiresCharging(constraints.requiresCharging()).setRequiresDeviceIdle(constraints.requiresDeviceIdle()).setExtras(persistableBundle);
        NetworkRequest requiredNetworkRequest = constraints.getRequiredNetworkRequest();
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 28 || requiredNetworkRequest == null) {
            setRequiredNetwork(extras, constraints.getRequiredNetworkType());
        } else {
            SystemJobInfoConverterExtKt.setRequiredNetworkRequest(extras, requiredNetworkRequest);
        }
        boolean z5 = false;
        if (!constraints.requiresDeviceIdle()) {
            if (workSpec.backoffPolicy == BackoffPolicy.LINEAR) {
                i6 = 0;
            } else {
                i6 = 1;
            }
            extras.setBackoffCriteria(workSpec.backoffDelayDuration, i6);
        }
        long max = Math.max(workSpec.calculateNextRunTime() - this.mClock.currentTimeMillis(), 0);
        if (i7 <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!workSpec.expedited && this.mMarkImportantWhileForeground) {
            JobInfo.Builder unused = extras.setImportantWhileForeground(true);
        }
        if (i7 >= 24 && constraints.hasContentUriTriggers()) {
            for (Constraints.ContentUriTrigger convertContentUriTrigger : constraints.getContentUriTriggers()) {
                JobInfo.Builder unused2 = extras.addTriggerContentUri(convertContentUriTrigger(convertContentUriTrigger));
            }
            JobInfo.Builder unused3 = extras.setTriggerContentUpdateDelay(constraints.getContentTriggerUpdateDelayMillis());
            JobInfo.Builder unused4 = extras.setTriggerContentMaxDelay(constraints.getContentTriggerMaxDelayMillis());
        }
        extras.setPersisted(false);
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 26) {
            JobInfo.Builder unused5 = extras.setRequiresBatteryNotLow(constraints.requiresBatteryNotLow());
            JobInfo.Builder unused6 = extras.setRequiresStorageNotLow(constraints.requiresStorageNotLow());
        }
        if (workSpec.runAttemptCount > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (max > 0) {
            z5 = true;
        }
        if (i8 >= 31 && workSpec.expedited && !z4 && !z5) {
            JobInfo.Builder unused7 = extras.setExpedited(true);
        }
        if (i8 >= 35 && (traceTag = workSpec.getTraceTag()) != null) {
            JobInfo.Builder unused8 = extras.setTraceTag(traceTag);
        }
        return extras.build();
    }
}
