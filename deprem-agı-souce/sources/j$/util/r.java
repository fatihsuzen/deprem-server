package j$.util;

import java.util.Map;

public final class r implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final Map.Entry f1420a;

    public r(Map.Entry entry) {
        this.f1420a = (Map.Entry) Objects.requireNonNull(entry);
    }

    public final Object getKey() {
        return this.f1420a.getKey();
    }

    public final Object getValue() {
        return this.f1420a.getValue();
    }

    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        return this.f1420a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = this.f1420a.getKey();
                Object key2 = entry.getKey();
                if (key == null ? key2 == null : key.equals(key2)) {
                    Object value = this.f1420a.getValue();
                    Object value2 = entry.getValue();
                    if (value == null ? value2 == null : value.equals(value2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final String toString() {
        return this.f1420a.toString();
    }
}
