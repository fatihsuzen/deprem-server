package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ArchTaskExecutor;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import j$.time.Duration;
import k3.p;
import kotlin.jvm.internal.t;
import z3.C2972e;
import z3.C2974g;
import z3.D;

public final class FlowLiveDataConversions {
    public static final <T> C2972e asFlow(LiveData<T> liveData) {
        t.e(liveData, "<this>");
        return C2974g.i(C2974g.d(new FlowLiveDataConversions$asFlow$1(liveData, (C2308e) null)));
    }

    public static final <T> LiveData<T> asLiveData(C2972e eVar) {
        t.e(eVar, "<this>");
        return asLiveData$default(eVar, (C2312i) null, 0, 3, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(C2972e eVar, C2312i iVar, long j5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            iVar = C2313j.f20794a;
        }
        if ((i5 & 2) != 0) {
            j5 = 5000;
        }
        return asLiveData(eVar, iVar, j5);
    }

    public static final <T> LiveData<T> asLiveData(C2972e eVar, C2312i iVar) {
        t.e(eVar, "<this>");
        t.e(iVar, "context");
        return asLiveData$default(eVar, iVar, 0, 2, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(C2972e eVar, C2312i iVar, long j5) {
        t.e(eVar, "<this>");
        t.e(iVar, "context");
        LiveData<T> liveData = CoroutineLiveDataKt.liveData(iVar, j5, (p) new FlowLiveDataConversions$asLiveData$1(eVar, (C2308e) null));
        if (eVar instanceof D) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                liveData.setValue(((D) eVar).getValue());
                return liveData;
            }
            liveData.postValue(((D) eVar).getValue());
        }
        return liveData;
    }

    public static /* synthetic */ LiveData asLiveData$default(C2972e eVar, Duration duration, C2312i iVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            iVar = C2313j.f20794a;
        }
        return asLiveData(eVar, duration, iVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(C2972e eVar, Duration duration, C2312i iVar) {
        t.e(eVar, "<this>");
        t.e(duration, "timeout");
        t.e(iVar, "context");
        return asLiveData(eVar, iVar, Api26Impl.INSTANCE.toMillis(duration));
    }
}
