package androidx.savedstate;

import android.os.Bundle;
import java.util.Map;
import k3.l;

public final class SavedStateKt {
    public static final <T> T read(Bundle bundle, l lVar) {
        return SavedStateKt__SavedStateKt.read(bundle, lVar);
    }

    public static final Bundle savedState(Bundle bundle, l lVar) {
        return SavedStateKt__SavedState_androidKt.savedState(bundle, lVar);
    }

    public static final <T> T write(Bundle bundle, l lVar) {
        return SavedStateKt__SavedStateKt.write(bundle, lVar);
    }

    public static final Bundle savedState(Map<String, ? extends Object> map, l lVar) {
        return SavedStateKt__SavedState_androidKt.savedState(map, lVar);
    }
}
