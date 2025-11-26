package androidx.lifecycle;

import W2.J;
import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import k3.l;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;

public final class Transformations {
    @CheckResult
    @MainThread
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        MediatorLiveData mediatorLiveData;
        t.e(liveData, "<this>");
        I i5 = new I();
        i5.f24687a = true;
        if (liveData.isInitialized()) {
            i5.f24687a = false;
            mediatorLiveData = new MediatorLiveData(liveData.getValue());
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new t(mediatorLiveData, i5)));
        return mediatorLiveData;
    }

    /* access modifiers changed from: private */
    public static final J distinctUntilChanged$lambda$4(MediatorLiveData mediatorLiveData, I i5, Object obj) {
        Object value = mediatorLiveData.getValue();
        if (i5.f24687a || ((value == null && obj != null) || (value != null && !t.a(value, obj)))) {
            i5.f24687a = false;
            mediatorLiveData.setValue(obj);
        }
        return J.f19942a;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, l lVar) {
        MediatorLiveData mediatorLiveData;
        t.e(liveData, "<this>");
        t.e(lVar, "transform");
        if (liveData.isInitialized()) {
            mediatorLiveData = new MediatorLiveData(lVar.invoke(liveData.getValue()));
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new s(mediatorLiveData, lVar)));
        return mediatorLiveData;
    }

    /* access modifiers changed from: private */
    public static final J map$lambda$0(MediatorLiveData mediatorLiveData, l lVar, Object obj) {
        mediatorLiveData.setValue(lVar.invoke(obj));
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J map$lambda$1(MediatorLiveData mediatorLiveData, Function function, Object obj) {
        mediatorLiveData.setValue(function.apply(obj));
        return J.f19942a;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, l lVar) {
        MediatorLiveData mediatorLiveData;
        t.e(liveData, "<this>");
        t.e(lVar, "transform");
        L l5 = new L();
        if (liveData.isInitialized()) {
            LiveData liveData2 = (LiveData) lVar.invoke(liveData.getValue());
            if (liveData2 == null || !liveData2.isInitialized()) {
                mediatorLiveData = new MediatorLiveData();
            } else {
                mediatorLiveData = new MediatorLiveData(liveData2.getValue());
            }
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new r(lVar, l5, mediatorLiveData)));
        return mediatorLiveData;
    }

    /* access modifiers changed from: private */
    public static final J switchMap$lambda$3(l lVar, L l5, MediatorLiveData mediatorLiveData, Object obj) {
        LiveData liveData = (LiveData) lVar.invoke(obj);
        Object obj2 = l5.f24690a;
        if (obj2 != liveData) {
            if (obj2 != null) {
                t.b(obj2);
                mediatorLiveData.removeSource((LiveData) obj2);
            }
            l5.f24690a = liveData;
            if (liveData != null) {
                t.b(liveData);
                mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new v(mediatorLiveData)));
            }
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J switchMap$lambda$3$lambda$2(MediatorLiveData mediatorLiveData, Object obj) {
        mediatorLiveData.setValue(obj);
        return J.f19942a;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, Function function) {
        t.e(liveData, "<this>");
        t.e(function, "mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new u(mediatorLiveData, function)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, Function function) {
        t.e(liveData, "<this>");
        t.e(function, "switchMapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$switchMap$2(function, mediatorLiveData));
        return mediatorLiveData;
    }
}
