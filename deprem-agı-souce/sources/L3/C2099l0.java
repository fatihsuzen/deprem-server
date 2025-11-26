package L3;

import H3.b;
import J3.e;
import J3.f;
import K3.c;
import K3.d;
import X2.M;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2726b;
import q3.C2729e;

/* renamed from: L3.l0  reason: case insensitive filesystem */
public abstract class C2099l0 extends C2076a {

    /* renamed from: a  reason: collision with root package name */
    private final b f18555a;

    /* renamed from: b  reason: collision with root package name */
    private final b f18556b;

    public /* synthetic */ C2099l0(b bVar, b bVar2, C2633k kVar) {
        this(bVar, bVar2);
    }

    public abstract f getDescriptor();

    public final b m() {
        return this.f18555a;
    }

    public final b n() {
        return this.f18556b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final void g(c cVar, Map map, int i5, int i6) {
        t.e(cVar, "decoder");
        t.e(map, "builder");
        if (i6 >= 0) {
            C2726b k5 = C2729e.k(C2729e.l(0, i6 * 2), 2);
            int c5 = k5.c();
            int f5 = k5.f();
            int g5 = k5.g();
            if ((g5 > 0 && c5 <= f5) || (g5 < 0 && f5 <= c5)) {
                while (true) {
                    h(cVar, i5 + c5, map, false);
                    if (c5 != f5) {
                        c5 += g5;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public final void h(c cVar, int i5, Map map, boolean z4) {
        int i6;
        Object obj;
        t.e(cVar, "decoder");
        t.e(map, "builder");
        c cVar2 = cVar;
        int i7 = i5;
        Object c5 = c.a.c(cVar2, getDescriptor(), i7, this.f18555a, (Object) null, 8, (Object) null);
        c cVar3 = cVar2;
        if (z4) {
            i6 = cVar3.decodeElementIndex(getDescriptor());
            if (i6 != i7 + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i7 + ", returned index for value: " + i6).toString());
            }
        } else {
            i6 = i7 + 1;
        }
        int i8 = i6;
        if (!map.containsKey(c5) || (this.f18556b.getDescriptor().getKind() instanceof e)) {
            obj = c.a.c(cVar3, getDescriptor(), i8, this.f18556b, (Object) null, 8, (Object) null);
        } else {
            obj = cVar3.decodeSerializableElement(getDescriptor(), i8, this.f18556b, M.i(map, c5));
        }
        map.put(c5, obj);
    }

    public void serialize(K3.f fVar, Object obj) {
        t.e(fVar, "encoder");
        int e5 = e(obj);
        f descriptor = getDescriptor();
        d beginCollection = fVar.beginCollection(descriptor, e5);
        Iterator d5 = d(obj);
        int i5 = 0;
        while (d5.hasNext()) {
            Map.Entry entry = (Map.Entry) d5.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i6 = i5 + 1;
            beginCollection.encodeSerializableElement(getDescriptor(), i5, m(), key);
            i5 += 2;
            beginCollection.encodeSerializableElement(getDescriptor(), i6, n(), value);
        }
        beginCollection.endStructure(descriptor);
    }

    private C2099l0(b bVar, b bVar2) {
        super((C2633k) null);
        this.f18555a = bVar;
        this.f18556b = bVar2;
    }
}
