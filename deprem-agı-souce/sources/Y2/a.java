package Y2;

import X2.C2239f;
import java.util.Map;
import kotlin.jvm.internal.t;

public abstract class a extends C2239f {
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return f((Map.Entry) obj);
    }

    public final boolean f(Map.Entry entry) {
        t.e(entry, "element");
        return g(entry);
    }

    public abstract boolean g(Map.Entry entry);

    public abstract /* bridge */ boolean i(Map.Entry entry);

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return i((Map.Entry) obj);
    }
}
