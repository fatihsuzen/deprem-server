package L3;

import H3.b;
import H3.k;
import J3.f;
import K3.c;
import K3.d;
import K3.e;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class Z implements b {

    /* renamed from: a  reason: collision with root package name */
    private final b f18503a;

    /* renamed from: b  reason: collision with root package name */
    private final b f18504b;

    public /* synthetic */ Z(b bVar, b bVar2, C2633k kVar) {
        this(bVar, bVar2);
    }

    /* access modifiers changed from: protected */
    public abstract Object a(Object obj);

    /* access modifiers changed from: protected */
    public final b b() {
        return this.f18503a;
    }

    /* access modifiers changed from: protected */
    public abstract Object c(Object obj);

    /* access modifiers changed from: protected */
    public final b d() {
        return this.f18504b;
    }

    public Object deserialize(e eVar) {
        Object obj;
        t.e(eVar, "decoder");
        f descriptor = getDescriptor();
        c beginStructure = eVar.beginStructure(descriptor);
        if (beginStructure.decodeSequentially()) {
            obj = e(c.a.c(beginStructure, getDescriptor(), 0, b(), (Object) null, 8, (Object) null), c.a.c(beginStructure, getDescriptor(), 1, d(), (Object) null, 8, (Object) null));
        } else {
            Object a5 = c1.f18513a;
            Object a6 = c1.f18513a;
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
                if (decodeElementIndex != -1) {
                    if (decodeElementIndex == 0) {
                        a5 = c.a.c(beginStructure, getDescriptor(), 0, b(), (Object) null, 8, (Object) null);
                    } else if (decodeElementIndex == 1) {
                        a6 = c.a.c(beginStructure, getDescriptor(), 1, d(), (Object) null, 8, (Object) null);
                    } else {
                        throw new k("Invalid index: " + decodeElementIndex);
                    }
                } else if (a5 == c1.f18513a) {
                    throw new k("Element 'key' is missing");
                } else if (a6 != c1.f18513a) {
                    obj = e(a5, a6);
                } else {
                    throw new k("Element 'value' is missing");
                }
            }
        }
        beginStructure.endStructure(descriptor);
        return obj;
    }

    /* access modifiers changed from: protected */
    public abstract Object e(Object obj, Object obj2);

    public void serialize(K3.f fVar, Object obj) {
        t.e(fVar, "encoder");
        d beginStructure = fVar.beginStructure(getDescriptor());
        beginStructure.encodeSerializableElement(getDescriptor(), 0, this.f18503a, a(obj));
        beginStructure.encodeSerializableElement(getDescriptor(), 1, this.f18504b, c(obj));
        beginStructure.endStructure(getDescriptor());
    }

    private Z(b bVar, b bVar2) {
        this.f18503a = bVar;
        this.f18504b = bVar2;
    }
}
