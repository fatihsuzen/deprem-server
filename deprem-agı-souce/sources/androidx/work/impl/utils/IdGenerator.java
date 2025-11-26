package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import kotlin.jvm.internal.t;

public final class IdGenerator {
    private final WorkDatabase workDatabase;

    public IdGenerator(WorkDatabase workDatabase2) {
        t.e(workDatabase2, "workDatabase");
        this.workDatabase = workDatabase2;
    }

    /* access modifiers changed from: private */
    public static final Integer nextAlarmManagerId$lambda$1(IdGenerator idGenerator) {
        return Integer.valueOf(IdGeneratorKt.nextId(idGenerator.workDatabase, IdGeneratorKt.NEXT_ALARM_MANAGER_ID_KEY));
    }

    /* access modifiers changed from: private */
    public static final Integer nextJobSchedulerIdWithRange$lambda$0(IdGenerator idGenerator, int i5, int i6) {
        int access$nextId = IdGeneratorKt.nextId(idGenerator.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY);
        if (i5 > access$nextId || access$nextId > i6) {
            IdGeneratorKt.updatePreference(idGenerator.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY, i5 + 1);
        } else {
            i5 = access$nextId;
        }
        return Integer.valueOf(i5);
    }

    public final int nextAlarmManagerId() {
        Object runInTransaction = this.workDatabase.runInTransaction(new m(this));
        t.d(runInTransaction, "runInTransaction(...)");
        return ((Number) runInTransaction).intValue();
    }

    public final int nextJobSchedulerIdWithRange(int i5, int i6) {
        Object runInTransaction = this.workDatabase.runInTransaction(new n(this, i5, i6));
        t.d(runInTransaction, "runInTransaction(...)");
        return ((Number) runInTransaction).intValue();
    }
}
