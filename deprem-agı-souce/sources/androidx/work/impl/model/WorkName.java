package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, indices = {@Index({"work_spec_id"})}, primaryKeys = {"name", "work_spec_id"})
public final class WorkName {
    @ColumnInfo(name = "name")
    private final String name;
    @ColumnInfo(name = "work_spec_id")
    private final String workSpecId;

    public WorkName(String str, String str2) {
        t.e(str, RewardPlus.NAME);
        t.e(str2, "workSpecId");
        this.name = str;
        this.workSpecId = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getWorkSpecId() {
        return this.workSpecId;
    }
}
