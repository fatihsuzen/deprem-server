package androidx.work.impl.foreground;

import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ForegroundProcessor {
    void startForeground(String str, ForegroundInfo foregroundInfo);
}
