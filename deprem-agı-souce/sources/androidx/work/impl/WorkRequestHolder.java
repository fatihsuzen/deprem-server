package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.Set;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkRequestHolder extends WorkRequest {
    public WorkRequestHolder(UUID uuid, WorkSpec workSpec, Set<String> set) {
        super(uuid, workSpec, set);
    }
}
