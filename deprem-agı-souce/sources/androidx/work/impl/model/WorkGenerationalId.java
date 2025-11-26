package androidx.work.impl.model;

import kotlin.jvm.internal.t;

public final class WorkGenerationalId {
    private final int generation;
    private final String workSpecId;

    public WorkGenerationalId(String str, int i5) {
        t.e(str, "workSpecId");
        this.workSpecId = str;
        this.generation = i5;
    }

    public static /* synthetic */ WorkGenerationalId copy$default(WorkGenerationalId workGenerationalId, String str, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = workGenerationalId.workSpecId;
        }
        if ((i6 & 2) != 0) {
            i5 = workGenerationalId.generation;
        }
        return workGenerationalId.copy(str, i5);
    }

    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    public final WorkGenerationalId copy(String str, int i5) {
        t.e(str, "workSpecId");
        return new WorkGenerationalId(str, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkGenerationalId)) {
            return false;
        }
        WorkGenerationalId workGenerationalId = (WorkGenerationalId) obj;
        return t.a(this.workSpecId, workGenerationalId.workSpecId) && this.generation == workGenerationalId.generation;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final String getWorkSpecId() {
        return this.workSpecId;
    }

    public int hashCode() {
        return (this.workSpecId.hashCode() * 31) + this.generation;
    }

    public String toString() {
        return "WorkGenerationalId(workSpecId=" + this.workSpecId + ", generation=" + this.generation + ')';
    }
}
