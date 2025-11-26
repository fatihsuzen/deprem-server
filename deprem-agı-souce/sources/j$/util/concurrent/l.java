package j$.util.concurrent;

import j$.com.android.tools.r8.a;
import java.util.Map;

public class l implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    public final int f1323a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f1324b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Object f1325c;

    /* renamed from: d  reason: collision with root package name */
    public volatile l f1326d;

    public l(int i5, Object obj, Object obj2) {
        this.f1323a = i5;
        this.f1324b = obj;
        this.f1325c = obj2;
    }

    public l(int i5, Object obj, Object obj2, l lVar) {
        this(i5, obj, obj2);
        this.f1326d = lVar;
    }

    public final Object getKey() {
        return this.f1324b;
    }

    public final Object getValue() {
        return this.f1325c;
    }

    public final int hashCode() {
        return this.f1324b.hashCode() ^ this.f1325c.hashCode();
    }

    public final String toString() {
        return a.D(this.f1324b, this.f1325c);
    }

    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
            return false;
        }
        Object obj2 = this.f1324b;
        if (key != obj2 && !key.equals(obj2)) {
            return false;
        }
        Object obj3 = this.f1325c;
        return value == obj3 || value.equals(obj3);
    }

    public l a(int i5, Object obj) {
        Object obj2;
        l lVar = this;
        do {
            if (lVar.f1323a == i5 && ((obj2 = lVar.f1324b) == obj || (obj2 != null && obj.equals(obj2)))) {
                return lVar;
            }
            lVar = lVar.f1326d;
        } while (lVar != null);
        return null;
    }
}
