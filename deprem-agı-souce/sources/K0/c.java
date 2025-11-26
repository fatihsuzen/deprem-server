package K0;

import j$.util.DesugarCollections;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f2739a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f2740b;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f2741a;

        /* renamed from: b  reason: collision with root package name */
        private Map f2742b = null;

        b(String str) {
            this.f2741a = str;
        }

        public c a() {
            Map map;
            String str = this.f2741a;
            if (this.f2742b == null) {
                map = Collections.EMPTY_MAP;
            } else {
                map = DesugarCollections.unmodifiableMap(new HashMap(this.f2742b));
            }
            return new c(str, map);
        }

        public b b(Annotation annotation) {
            if (this.f2742b == null) {
                this.f2742b = new HashMap();
            }
            this.f2742b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public static b a(String str) {
        return new b(str);
    }

    public static c d(String str) {
        return new c(str, Collections.EMPTY_MAP);
    }

    public String b() {
        return this.f2739a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.f2740b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f2739a.equals(cVar.f2739a) || !this.f2740b.equals(cVar.f2740b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f2739a.hashCode() * 31) + this.f2740b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f2739a + ", properties=" + this.f2740b.values() + "}";
    }

    private c(String str, Map map) {
        this.f2739a = str;
        this.f2740b = map;
    }
}
