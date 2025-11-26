package androidx.work.impl.utils;

import androidx.work.ListenableFutureKt;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import java.util.UUID;
import k3.l;
import kotlin.jvm.internal.t;
import n0.C1722d;

public final class StatusRunnable {
    public static final C1722d forStringIds(WorkDatabase workDatabase, TaskExecutor taskExecutor, List<String> list) {
        t.e(workDatabase, "<this>");
        t.e(taskExecutor, "executor");
        t.e(list, "ids");
        return loadStatusFuture(workDatabase, taskExecutor, new A(list));
    }

    /* access modifiers changed from: private */
    public static final List forStringIds$lambda$0(List list, WorkDatabase workDatabase) {
        t.e(workDatabase, "db");
        List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForIds(list));
        t.d(apply, "apply(...)");
        return apply;
    }

    public static final C1722d forTag(WorkDatabase workDatabase, TaskExecutor taskExecutor, String str) {
        t.e(workDatabase, "<this>");
        t.e(taskExecutor, "executor");
        t.e(str, "tag");
        return loadStatusFuture(workDatabase, taskExecutor, new y(str));
    }

    /* access modifiers changed from: private */
    public static final List forTag$lambda$2(String str, WorkDatabase workDatabase) {
        t.e(workDatabase, "db");
        List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForTag(str));
        t.d(apply, "apply(...)");
        return apply;
    }

    public static final C1722d forUUID(WorkDatabase workDatabase, TaskExecutor taskExecutor, UUID uuid) {
        t.e(workDatabase, "<this>");
        t.e(taskExecutor, "executor");
        t.e(uuid, "id");
        return loadStatusFuture(workDatabase, taskExecutor, new w(uuid));
    }

    /* access modifiers changed from: private */
    public static final WorkInfo forUUID$lambda$1(UUID uuid, WorkDatabase workDatabase) {
        t.e(workDatabase, "db");
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        String uuid2 = uuid.toString();
        t.d(uuid2, "toString(...)");
        WorkSpec.WorkInfoPojo workStatusPojoForId = workSpecDao.getWorkStatusPojoForId(uuid2);
        if (workStatusPojoForId != null) {
            return workStatusPojoForId.toWorkInfo();
        }
        return null;
    }

    public static final C1722d forUniqueWork(WorkDatabase workDatabase, TaskExecutor taskExecutor, String str) {
        t.e(workDatabase, "<this>");
        t.e(taskExecutor, "executor");
        t.e(str, RewardPlus.NAME);
        return loadStatusFuture(workDatabase, taskExecutor, new x(str));
    }

    /* access modifiers changed from: private */
    public static final List forUniqueWork$lambda$3(String str, WorkDatabase workDatabase) {
        t.e(workDatabase, "db");
        List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForName(str));
        t.d(apply, "apply(...)");
        return apply;
    }

    public static final C1722d forWorkQuerySpec(WorkDatabase workDatabase, TaskExecutor taskExecutor, WorkQuery workQuery) {
        t.e(workDatabase, "<this>");
        t.e(taskExecutor, "executor");
        t.e(workQuery, "querySpec");
        return loadStatusFuture(workDatabase, taskExecutor, new z(workQuery));
    }

    /* access modifiers changed from: private */
    public static final List forWorkQuerySpec$lambda$4(WorkQuery workQuery, WorkDatabase workDatabase) {
        t.e(workDatabase, "db");
        List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.rawWorkInfoDao().getWorkInfoPojos(RawQueries.toRawQuery(workQuery)));
        t.d(apply, "apply(...)");
        return apply;
    }

    private static final <T> C1722d loadStatusFuture(WorkDatabase workDatabase, TaskExecutor taskExecutor, l lVar) {
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        t.d(serialTaskExecutor, "getSerialTaskExecutor(...)");
        return ListenableFutureKt.executeAsync(serialTaskExecutor, "loadStatusFuture", new v(lVar, workDatabase));
    }

    /* access modifiers changed from: private */
    public static final Object loadStatusFuture$lambda$5(l lVar, WorkDatabase workDatabase) {
        return lVar.invoke(workDatabase);
    }
}
