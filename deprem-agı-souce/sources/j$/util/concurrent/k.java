package j$.util.concurrent;

import j$.com.android.tools.r8.a;
import java.util.Map;

public final class k implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1320a;

    /* renamed from: b  reason: collision with root package name */
    public Object f1321b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap f1322c;

    public k(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
        this.f1320a = obj;
        this.f1321b = obj2;
        this.f1322c = concurrentHashMap;
    }

    public final Object getKey() {
        return this.f1320a;
    }

    public final Object getValue() {
        return this.f1321b;
    }

    public final int hashCode() {
        return this.f1320a.hashCode() ^ this.f1321b.hashCode();
    }

    public final String toString() {
        return a.D(this.f1320a, this.f1321b);
    }

    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
            return false;
        }
        Object obj2 = this.f1320a;
        if (key != obj2 && !key.equals(obj2)) {
            return false;
        }
        Object obj3 = this.f1321b;
        return value == obj3 || value.equals(obj3);
    }

    public final Object setValue(Object obj) {
        obj.getClass();
        Object obj2 = this.f1321b;
        this.f1321b = obj;
        this.f1322c.put(this.f1320a, obj);
        return obj2;
    }
}
