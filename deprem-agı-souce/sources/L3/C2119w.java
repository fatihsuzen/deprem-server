package L3;

import H3.b;
import J3.f;
import K3.c;
import K3.d;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: L3.w  reason: case insensitive filesystem */
public abstract class C2119w extends C2076a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f18597a;

    public /* synthetic */ C2119w(b bVar, C2633k kVar) {
        this(bVar);
    }

    /* access modifiers changed from: protected */
    public final void g(c cVar, Object obj, int i5, int i6) {
        t.e(cVar, "decoder");
        if (i6 >= 0) {
            for (int i7 = 0; i7 < i6; i7++) {
                h(cVar, i5 + i7, obj, false);
            }
            return;
        }
        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
    }

    public abstract f getDescriptor();

    /* access modifiers changed from: protected */
    public void h(c cVar, int i5, Object obj, boolean z4) {
        t.e(cVar, "decoder");
        int i6 = i5;
        n(obj, i6, c.a.c(cVar, getDescriptor(), i6, this.f18597a, (Object) null, 8, (Object) null));
    }

    /* access modifiers changed from: protected */
    public abstract void n(Object obj, int i5, Object obj2);

    public void serialize(K3.f fVar, Object obj) {
        t.e(fVar, "encoder");
        int e5 = e(obj);
        f descriptor = getDescriptor();
        d beginCollection = fVar.beginCollection(descriptor, e5);
        Iterator d5 = d(obj);
        for (int i5 = 0; i5 < e5; i5++) {
            beginCollection.encodeSerializableElement(getDescriptor(), i5, this.f18597a, d5.next());
        }
        beginCollection.endStructure(descriptor);
    }

    private C2119w(b bVar) {
        super((C2633k) null);
        this.f18597a = bVar;
    }
}
