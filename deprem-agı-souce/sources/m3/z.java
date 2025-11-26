package M3;

import H3.b;
import H3.j;
import N3.S;
import X2.C2250q;
import j$.util.Map;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l3.C2677a;

@j(with = A.class)
public final class z extends h implements Map<String, h>, C2677a, j$.util.Map {
    public static final a Companion = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Map f18703a;

    public static final class a {
        private a() {
        }

        public final b serializer() {
            return A.f18653a;
        }

        public /* synthetic */ a(C2633k kVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(Map map) {
        super((C2633k) null);
        t.e(map, "content");
        this.f18703a = map;
    }

    /* access modifiers changed from: private */
    public static final CharSequence p(Map.Entry entry) {
        t.e(entry, "<destruct>");
        StringBuilder sb = new StringBuilder();
        S.c(sb, (String) entry.getKey());
        sb.append(':');
        sb.append((h) entry.getValue());
        String sb2 = sb.toString();
        t.d(sb2, "toString(...)");
        return sb2;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return f((String) obj);
    }

    public final /* bridge */ boolean containsValue(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        return g((h) obj);
    }

    public final /* bridge */ Set entrySet() {
        return j();
    }

    public boolean equals(Object obj) {
        return t.a(this.f18703a, obj);
    }

    public boolean f(String str) {
        t.e(str, "key");
        return this.f18703a.containsKey(str);
    }

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    public boolean g(h hVar) {
        t.e(hVar, "value");
        return this.f18703a.containsValue(hVar);
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return i((String) obj);
    }

    public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return Map.CC.$default$getOrDefault(this, obj, obj2);
    }

    public int hashCode() {
        return this.f18703a.hashCode();
    }

    public h i(String str) {
        t.e(str, "key");
        return (h) this.f18703a.get(str);
    }

    public boolean isEmpty() {
        return this.f18703a.isEmpty();
    }

    public Set j() {
        return this.f18703a.entrySet();
    }

    public Set k() {
        return this.f18703a.keySet();
    }

    public final /* bridge */ Set keySet() {
        return k();
    }

    public int l() {
        return this.f18703a.size();
    }

    public /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Collection n() {
        return this.f18703a.values();
    }

    /* renamed from: o */
    public h remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(java.util.Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return l();
    }

    public String toString() {
        return C2250q.V(this.f18703a.entrySet(), ",", "{", "}", 0, (CharSequence) null, new y(), 24, (Object) null);
    }

    public final /* bridge */ Collection values() {
        return n();
    }

    public /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
