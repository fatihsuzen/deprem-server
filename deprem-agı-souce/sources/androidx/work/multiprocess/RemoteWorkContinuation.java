package androidx.work.multiprocess;

import androidx.annotation.RestrictTo;
import androidx.work.OneTimeWorkRequest;
import java.util.Collections;
import java.util.List;
import n0.C1722d;

public abstract class RemoteWorkContinuation {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected RemoteWorkContinuation() {
    }

    public static RemoteWorkContinuation combine(List<RemoteWorkContinuation> list) {
        return list.get(0).combineInternal(list);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract RemoteWorkContinuation combineInternal(List<RemoteWorkContinuation> list);

    public abstract C1722d enqueue();

    public final RemoteWorkContinuation then(OneTimeWorkRequest oneTimeWorkRequest) {
        return then((List<OneTimeWorkRequest>) Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract RemoteWorkContinuation then(List<OneTimeWorkRequest> list);
}
