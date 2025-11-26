package L3;

import H3.b;
import J3.f;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.t;

/* renamed from: L3.d0  reason: case insensitive filesystem */
public final class C2083d0 extends C2121x {

    /* renamed from: b  reason: collision with root package name */
    private final f f18514b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2083d0(b bVar) {
        super(bVar);
        t.e(bVar, "eSerializer");
        this.f18514b = new C2081c0(bVar.getDescriptor());
    }

    public f getDescriptor() {
        return this.f18514b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public LinkedHashSet a() {
        return new LinkedHashSet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int b(LinkedHashSet linkedHashSet) {
        t.e(linkedHashSet, "<this>");
        return linkedHashSet.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void c(LinkedHashSet linkedHashSet, int i5) {
        t.e(linkedHashSet, "<this>");
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void n(LinkedHashSet linkedHashSet, int i5, Object obj) {
        t.e(linkedHashSet, "<this>");
        linkedHashSet.add(obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public LinkedHashSet k(Set set) {
        LinkedHashSet linkedHashSet;
        t.e(set, "<this>");
        if (set instanceof LinkedHashSet) {
            linkedHashSet = (LinkedHashSet) set;
        } else {
            linkedHashSet = null;
        }
        if (linkedHashSet == null) {
            return new LinkedHashSet(set);
        }
        return linkedHashSet;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public Set l(LinkedHashSet linkedHashSet) {
        t.e(linkedHashSet, "<this>");
        return linkedHashSet;
    }
}
