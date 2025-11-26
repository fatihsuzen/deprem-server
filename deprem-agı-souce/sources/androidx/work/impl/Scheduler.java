package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.impl.model.WorkSpec;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface Scheduler {
    public static final int MAX_GREEDY_SCHEDULER_LIMIT = 200;
    public static final int MAX_SCHEDULER_LIMIT = 50;

    void cancel(String str);

    boolean hasLimitedSchedulingSlots();

    void schedule(WorkSpec... workSpecArr);
}
