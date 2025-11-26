package L3;

import H3.b;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: L3.x  reason: case insensitive filesystem */
public abstract class C2121x extends C2119w {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2121x(b bVar) {
        super(bVar, (C2633k) null);
        t.e(bVar, "element");
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public Iterator d(Collection collection) {
        t.e(collection, "<this>");
        return collection.iterator();
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public int e(Collection collection) {
        t.e(collection, "<this>");
        return collection.size();
    }
}
