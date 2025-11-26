package androidx.work;

import android.content.Context;
import java.util.UUID;
import n0.C1722d;

public interface ForegroundUpdater {
    C1722d setForegroundAsync(Context context, UUID uuid, ForegroundInfo foregroundInfo);
}
