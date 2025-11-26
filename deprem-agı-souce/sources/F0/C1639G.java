package f0;

import j$.util.Objects;
import java.util.AbstractMap;
import java.util.Map;

/* renamed from: f0.G  reason: case insensitive filesystem */
public abstract /* synthetic */ class C1639G {
    public static /* synthetic */ Map.Entry a(Object obj, Object obj2) {
        Objects.requireNonNull(obj);
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }
}
