package androidx.work;

import X2.C2250q;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import j3.C2582a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class OneTimeWorkRequest extends WorkRequest {
    public static final Companion Companion = new Companion((C2633k) null);

    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(Class<? extends ListenableWorker> cls) {
            super(cls);
            t.e(cls, "workerClass");
        }

        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        public final Builder setInputMerger(Class<? extends InputMerger> cls) {
            t.e(cls, "inputMerger");
            WorkSpec workSpec$work_runtime_release = getWorkSpec$work_runtime_release();
            String name = cls.getName();
            t.d(name, "getName(...)");
            workSpec$work_runtime_release.inputMergerClassName = name;
            return this;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(C2733c cVar) {
            this((Class<? extends ListenableWorker>) C2582a.a(cVar));
            t.e(cVar, "workerClass");
        }

        public OneTimeWorkRequest buildInternal$work_runtime_release() {
            if (!getBackoffCriteriaSet$work_runtime_release() || !getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle()) {
                return new OneTimeWorkRequest(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final OneTimeWorkRequest from(Class<? extends ListenableWorker> cls) {
            t.e(cls, "workerClass");
            return (OneTimeWorkRequest) new Builder(cls).build();
        }

        private Companion() {
        }

        public final List<OneTimeWorkRequest> from(List<? extends Class<? extends ListenableWorker>> list) {
            t.e(list, "workerClasses");
            Iterable<Class> iterable = list;
            ArrayList arrayList = new ArrayList(C2250q.p(iterable, 10));
            for (Class builder : iterable) {
                arrayList.add((OneTimeWorkRequest) new Builder((Class<? extends ListenableWorker>) builder).build());
            }
            return arrayList;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneTimeWorkRequest(Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        t.e(builder, "builder");
    }

    public static final OneTimeWorkRequest from(Class<? extends ListenableWorker> cls) {
        return Companion.from(cls);
    }

    public static final List<OneTimeWorkRequest> from(List<? extends Class<? extends ListenableWorker>> list) {
        return Companion.from(list);
    }
}
