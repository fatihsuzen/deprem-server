package androidx.work;

import X2.C2242i;
import X2.C2250q;
import android.annotation.SuppressLint;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class WorkQuery {
    public static final Companion Companion = new Companion((C2633k) null);
    private final List<UUID> ids;
    private final List<WorkInfo.State> states;
    private final List<String> tags;
    private final List<String> uniqueWorkNames;

    public static final class Builder {
        public static final Companion Companion = new Companion((C2633k) null);
        private final List<UUID> ids;
        private final List<WorkInfo.State> states;
        private final List<String> tags;
        private final List<String> uniqueWorkNames;

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromIds(List<UUID> list) {
                t.e(list, "ids");
                Builder builder = new Builder((C2633k) null);
                builder.addIds(list);
                return builder;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromStates(List<? extends WorkInfo.State> list) {
                t.e(list, "states");
                Builder builder = new Builder((C2633k) null);
                builder.addStates(list);
                return builder;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromTags(List<String> list) {
                t.e(list, "tags");
                Builder builder = new Builder((C2633k) null);
                builder.addTags(list);
                return builder;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder fromUniqueWorkNames(List<String> list) {
                t.e(list, "uniqueWorkNames");
                Builder builder = new Builder((C2633k) null);
                builder.addUniqueWorkNames(list);
                return builder;
            }

            private Companion() {
            }
        }

        public /* synthetic */ Builder(C2633k kVar) {
            this();
        }

        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromIds(List<UUID> list) {
            return Companion.fromIds(list);
        }

        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromStates(List<? extends WorkInfo.State> list) {
            return Companion.fromStates(list);
        }

        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromTags(List<String> list) {
            return Companion.fromTags(list);
        }

        @SuppressLint({"BuilderSetStyle"})
        public static final Builder fromUniqueWorkNames(List<String> list) {
            return Companion.fromUniqueWorkNames(list);
        }

        public final Builder addIds(List<UUID> list) {
            t.e(list, "ids");
            C2250q.u(this.ids, list);
            return this;
        }

        public final Builder addStates(List<? extends WorkInfo.State> list) {
            t.e(list, "states");
            C2250q.u(this.states, list);
            return this;
        }

        public final Builder addTags(List<String> list) {
            t.e(list, "tags");
            C2250q.u(this.tags, list);
            return this;
        }

        public final Builder addUniqueWorkNames(List<String> list) {
            t.e(list, "uniqueWorkNames");
            C2250q.u(this.uniqueWorkNames, list);
            return this;
        }

        public final WorkQuery build() {
            if (!this.ids.isEmpty() || !this.uniqueWorkNames.isEmpty() || !this.tags.isEmpty() || !this.states.isEmpty()) {
                return new WorkQuery(this.ids, this.uniqueWorkNames, this.tags, this.states);
            }
            throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
        }

        private Builder() {
            this.ids = new ArrayList();
            this.uniqueWorkNames = new ArrayList();
            this.tags = new ArrayList();
            this.states = new ArrayList();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final WorkQuery fromIds(List<UUID> list) {
            t.e(list, "ids");
            return new WorkQuery(list, (List) null, (List) null, (List) null, 14, (C2633k) null);
        }

        public final WorkQuery fromStates(List<? extends WorkInfo.State> list) {
            t.e(list, "states");
            return new WorkQuery((List) null, (List) null, (List) null, list, 7, (C2633k) null);
        }

        public final WorkQuery fromTags(List<String> list) {
            t.e(list, "tags");
            return new WorkQuery((List) null, (List) null, list, (List) null, 11, (C2633k) null);
        }

        public final WorkQuery fromUniqueWorkNames(String... strArr) {
            t.e(strArr, "uniqueWorkNames");
            return new WorkQuery((List) null, C2242i.q0(strArr), (List) null, (List) null, 13, (C2633k) null);
        }

        private Companion() {
        }

        public final WorkQuery fromIds(UUID... uuidArr) {
            t.e(uuidArr, "ids");
            return new WorkQuery(C2242i.q0(uuidArr), (List) null, (List) null, (List) null, 14, (C2633k) null);
        }

        public final WorkQuery fromStates(WorkInfo.State... stateArr) {
            t.e(stateArr, "states");
            return new WorkQuery((List) null, (List) null, (List) null, C2242i.q0(stateArr), 7, (C2633k) null);
        }

        public final WorkQuery fromTags(String... strArr) {
            t.e(strArr, "tags");
            return new WorkQuery((List) null, (List) null, C2242i.q0(strArr), (List) null, 11, (C2633k) null);
        }

        public final WorkQuery fromUniqueWorkNames(List<String> list) {
            t.e(list, "uniqueWorkNames");
            return new WorkQuery((List) null, list, (List) null, (List) null, 13, (C2633k) null);
        }
    }

    public WorkQuery() {
        this((List) null, (List) null, (List) null, (List) null, 15, (C2633k) null);
    }

    public static final WorkQuery fromIds(List<UUID> list) {
        return Companion.fromIds(list);
    }

    public static final WorkQuery fromStates(List<? extends WorkInfo.State> list) {
        return Companion.fromStates(list);
    }

    public static final WorkQuery fromTags(List<String> list) {
        return Companion.fromTags(list);
    }

    public static final WorkQuery fromUniqueWorkNames(List<String> list) {
        return Companion.fromUniqueWorkNames(list);
    }

    public final List<UUID> getIds() {
        return this.ids;
    }

    public final List<WorkInfo.State> getStates() {
        return this.states;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final List<String> getUniqueWorkNames() {
        return this.uniqueWorkNames;
    }

    public WorkQuery(List<UUID> list, List<String> list2, List<String> list3, List<? extends WorkInfo.State> list4) {
        t.e(list, "ids");
        t.e(list2, "uniqueWorkNames");
        t.e(list3, "tags");
        t.e(list4, "states");
        this.ids = list;
        this.uniqueWorkNames = list2;
        this.tags = list3;
        this.states = list4;
    }

    public static final WorkQuery fromIds(UUID... uuidArr) {
        return Companion.fromIds(uuidArr);
    }

    public static final WorkQuery fromStates(WorkInfo.State... stateArr) {
        return Companion.fromStates(stateArr);
    }

    public static final WorkQuery fromTags(String... strArr) {
        return Companion.fromTags(strArr);
    }

    public static final WorkQuery fromUniqueWorkNames(String... strArr) {
        return Companion.fromUniqueWorkNames(strArr);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WorkQuery(List list, List list2, List list3, List list4, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? C2250q.g() : list, (i5 & 2) != 0 ? C2250q.g() : list2, (i5 & 4) != 0 ? C2250q.g() : list3, (i5 & 8) != 0 ? C2250q.g() : list4);
    }
}
