package L3;

import H3.b;
import J3.f;
import J3.m;
import J3.o;
import W2.J;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l3.C2677a;

/* renamed from: L3.j0  reason: case insensitive filesystem */
public final class C2095j0 extends Z {

    /* renamed from: c  reason: collision with root package name */
    private final f f18542c;

    /* renamed from: L3.j0$a */
    private static final class a implements Map.Entry, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f18543a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f18544b;

        public a(Object obj, Object obj2) {
            this.f18543a = obj;
            this.f18544b = obj2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (t.a(this.f18543a, aVar.f18543a) && t.a(this.f18544b, aVar.f18544b)) {
                return true;
            }
            return false;
        }

        public Object getKey() {
            return this.f18543a;
        }

        public Object getValue() {
            return this.f18544b;
        }

        public int hashCode() {
            int i5;
            Object obj = this.f18543a;
            int i6 = 0;
            if (obj == null) {
                i5 = 0;
            } else {
                i5 = obj.hashCode();
            }
            int i7 = i5 * 31;
            Object obj2 = this.f18544b;
            if (obj2 != null) {
                i6 = obj2.hashCode();
            }
            return i7 + i6;
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public String toString() {
            return "MapEntry(key=" + this.f18543a + ", value=" + this.f18544b + ')';
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2095j0(b bVar, b bVar2) {
        super(bVar, bVar2, (C2633k) null);
        t.e(bVar, "keySerializer");
        t.e(bVar2, "valueSerializer");
        this.f18542c = m.h("kotlin.collections.Map.Entry", o.c.f18392a, new f[0], new C2093i0(bVar, bVar2));
    }

    /* access modifiers changed from: private */
    public static final J g(b bVar, b bVar2, J3.a aVar) {
        t.e(aVar, "$this$buildSerialDescriptor");
        J3.a aVar2 = aVar;
        J3.a.b(aVar2, "key", bVar.getDescriptor(), (List) null, false, 12, (Object) null);
        J3.a.b(aVar2, "value", bVar2.getDescriptor(), (List) null, false, 12, (Object) null);
        return J.f19942a;
    }

    public f getDescriptor() {
        return this.f18542c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public Object a(Map.Entry entry) {
        t.e(entry, "<this>");
        return entry.getKey();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public Object c(Map.Entry entry) {
        t.e(entry, "<this>");
        return entry.getValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Map.Entry e(Object obj, Object obj2) {
        return new a(obj, obj2);
    }
}
