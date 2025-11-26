package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import j$.time.Duration;
import k3.p;
import kotlin.jvm.internal.t;
import w3.C2865c0;
import w3.C2872g;

public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    public static final <T> Object addDisposableSource(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, C2308e eVar) {
        return C2872g.g(C2865c0.c().F(), new CoroutineLiveDataKt$addDisposableSource$2(mediatorLiveData, liveData, (C2308e) null), eVar);
    }

    public static final <T> LiveData<T> liveData(C2312i iVar, p pVar) {
        t.e(iVar, "context");
        t.e(pVar, "block");
        return liveData$default(iVar, 0, pVar, 2, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(C2312i iVar, long j5, p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            iVar = C2313j.f20794a;
        }
        if ((i5 & 2) != 0) {
            j5 = 5000;
        }
        return liveData(iVar, j5, pVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration duration, p pVar) {
        t.e(duration, "timeout");
        t.e(pVar, "block");
        return liveData$default(duration, (C2312i) null, pVar, 2, (Object) null);
    }

    public static final <T> LiveData<T> liveData(p pVar) {
        t.e(pVar, "block");
        return liveData$default((C2312i) null, 0, pVar, 3, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(Duration duration, C2312i iVar, p pVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            iVar = C2313j.f20794a;
        }
        return liveData(duration, iVar, pVar);
    }

    public static final <T> LiveData<T> liveData(C2312i iVar, long j5, p pVar) {
        t.e(iVar, "context");
        t.e(pVar, "block");
        return new CoroutineLiveData(iVar, j5, pVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration duration, C2312i iVar, p pVar) {
        t.e(duration, "timeout");
        t.e(iVar, "context");
        t.e(pVar, "block");
        return new CoroutineLiveData(iVar, Api26Impl.INSTANCE.toMillis(duration), pVar);
    }
}
