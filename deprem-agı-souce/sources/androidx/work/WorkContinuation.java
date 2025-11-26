package androidx.work;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.List;
import n0.C1722d;

public abstract class WorkContinuation {
    public static WorkContinuation combine(List<WorkContinuation> list) {
        return list.get(0).combineInternal(list);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract WorkContinuation combineInternal(List<WorkContinuation> list);

    public abstract Operation enqueue();

    public abstract C1722d getWorkInfos();

    public abstract LiveData<List<WorkInfo>> getWorkInfosLiveData();

    public final WorkContinuation then(OneTimeWorkRequest oneTimeWorkRequest) {
        return then((List<OneTimeWorkRequest>) Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract WorkContinuation then(List<OneTimeWorkRequest> list);
}
