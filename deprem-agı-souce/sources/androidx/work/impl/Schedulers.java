package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Schedulers {
    private static final String TAG = Logger.tagWithPrefix("Schedulers");

    private Schedulers() {
    }

    public static /* synthetic */ void b(List list, WorkGenerationalId workGenerationalId, Configuration configuration, WorkDatabase workDatabase) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Scheduler) it.next()).cancel(workGenerationalId.getWorkSpecId());
        }
        schedule(configuration, workDatabase, list);
    }

    static Scheduler createBestAvailableBackgroundScheduler(Context context, WorkDatabase workDatabase, Configuration configuration) {
        SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workDatabase, configuration);
        PackageManagerHelper.setComponentEnabled(context, SystemJobService.class, true);
        Logger.get().debug(TAG, "Created SystemJobScheduler and enabled SystemJobService");
        return systemJobScheduler;
    }

    private static void markScheduled(WorkSpecDao workSpecDao, Clock clock, List<WorkSpec> list) {
        if (list.size() > 0) {
            long currentTimeMillis = clock.currentTimeMillis();
            for (WorkSpec workSpec : list) {
                workSpecDao.markWorkSpecScheduled(workSpec.id, currentTimeMillis);
            }
        }
    }

    public static void registerRescheduling(List<Scheduler> list, Processor processor, Executor executor, WorkDatabase workDatabase, Configuration configuration) {
        processor.addExecutionListener(new C0423d(executor, list, configuration, workDatabase));
    }

    public static void schedule(Configuration configuration, WorkDatabase workDatabase, List<Scheduler> list) {
        List<WorkSpec> list2;
        if (list != null && list.size() != 0) {
            WorkSpecDao workSpecDao = workDatabase.workSpecDao();
            workDatabase.beginTransaction();
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    list2 = workSpecDao.getEligibleWorkForSchedulingWithContentUris();
                    markScheduled(workSpecDao, configuration.getClock(), list2);
                } else {
                    list2 = null;
                }
                List<WorkSpec> eligibleWorkForScheduling = workSpecDao.getEligibleWorkForScheduling(configuration.getMaxSchedulerLimit());
                markScheduled(workSpecDao, configuration.getClock(), eligibleWorkForScheduling);
                if (list2 != null) {
                    eligibleWorkForScheduling.addAll(list2);
                }
                List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao.getAllEligibleWorkSpecsForScheduling(200);
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (eligibleWorkForScheduling.size() > 0) {
                    WorkSpec[] workSpecArr = (WorkSpec[]) eligibleWorkForScheduling.toArray(new WorkSpec[eligibleWorkForScheduling.size()]);
                    for (Scheduler next : list) {
                        if (next.hasLimitedSchedulingSlots()) {
                            next.schedule(workSpecArr);
                        }
                    }
                }
                if (allEligibleWorkSpecsForScheduling.size() > 0) {
                    WorkSpec[] workSpecArr2 = (WorkSpec[]) allEligibleWorkSpecsForScheduling.toArray(new WorkSpec[allEligibleWorkSpecsForScheduling.size()]);
                    for (Scheduler next2 : list) {
                        if (!next2.hasLimitedSchedulingSlots()) {
                            next2.schedule(workSpecArr2);
                        }
                    }
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }
}
