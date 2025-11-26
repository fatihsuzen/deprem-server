package androidx.core.os;

import W2.s;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import java.util.Map;

public final class PersistableBundleKt {
    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf(s... sVarArr) {
        PersistableBundle createPersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(sVarArr.length);
        for (s sVar : sVarArr) {
            PersistableBundleApi21ImplKt.putValue(createPersistableBundle, (String) sVar.a(), sVar.b());
        }
        return createPersistableBundle;
    }

    @RequiresApi(21)
    public static final PersistableBundle toPersistableBundle(Map<String, ? extends Object> map) {
        PersistableBundle createPersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(map.size());
        for (Map.Entry next : map.entrySet()) {
            PersistableBundleApi21ImplKt.putValue(createPersistableBundle, (String) next.getKey(), next.getValue());
        }
        return createPersistableBundle;
    }

    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf() {
        return PersistableBundleApi21ImplKt.createPersistableBundle(0);
    }
}
