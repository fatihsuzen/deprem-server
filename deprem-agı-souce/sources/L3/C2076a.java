package L3;

import H3.b;
import K3.c;
import K3.e;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: L3.a  reason: case insensitive filesystem */
public abstract class C2076a implements b {
    public /* synthetic */ C2076a(C2633k kVar) {
        this();
    }

    public static /* synthetic */ void i(C2076a aVar, c cVar, int i5, Object obj, boolean z4, int i6, Object obj2) {
        if (obj2 == null) {
            if ((i6 & 8) != 0) {
                z4 = true;
            }
            aVar.h(cVar, i5, obj, z4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
    }

    private final int j(c cVar, Object obj) {
        int decodeCollectionSize = cVar.decodeCollectionSize(getDescriptor());
        c(obj, decodeCollectionSize);
        return decodeCollectionSize;
    }

    /* access modifiers changed from: protected */
    public abstract Object a();

    /* access modifiers changed from: protected */
    public abstract int b(Object obj);

    /* access modifiers changed from: protected */
    public abstract void c(Object obj, int i5);

    /* access modifiers changed from: protected */
    public abstract Iterator d(Object obj);

    public Object deserialize(e eVar) {
        t.e(eVar, "decoder");
        return f(eVar, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract int e(Object obj);

    public final Object f(e eVar, Object obj) {
        Object a5;
        t.e(eVar, "decoder");
        if (obj == null || (a5 = k(obj)) == null) {
            a5 = a();
        }
        Object obj2 = a5;
        int b5 = b(obj2);
        c beginStructure = eVar.beginStructure(getDescriptor());
        if (!beginStructure.decodeSequentially()) {
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
                if (decodeElementIndex == -1) {
                    break;
                }
                i(this, beginStructure, b5 + decodeElementIndex, obj2, false, 8, (Object) null);
            }
        } else {
            g(beginStructure, obj2, b5, j(beginStructure, obj2));
        }
        beginStructure.endStructure(getDescriptor());
        return l(obj2);
    }

    /* access modifiers changed from: protected */
    public abstract void g(c cVar, Object obj, int i5, int i6);

    /* access modifiers changed from: protected */
    public abstract void h(c cVar, int i5, Object obj, boolean z4);

    /* access modifiers changed from: protected */
    public abstract Object k(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object l(Object obj);

    private C2076a() {
    }
}
