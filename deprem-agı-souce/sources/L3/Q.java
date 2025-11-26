package L3;

import H3.b;
import J3.f;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.t;

public final class Q extends C2121x {

    /* renamed from: b  reason: collision with root package name */
    private final f f18478b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Q(b bVar) {
        super(bVar);
        t.e(bVar, "eSerializer");
        this.f18478b = new P(bVar.getDescriptor());
    }

    public f getDescriptor() {
        return this.f18478b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public HashSet a() {
        return new HashSet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int b(HashSet hashSet) {
        t.e(hashSet, "<this>");
        return hashSet.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void c(HashSet hashSet, int i5) {
        t.e(hashSet, "<this>");
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void n(HashSet hashSet, int i5, Object obj) {
        t.e(hashSet, "<this>");
        hashSet.add(obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public HashSet k(Set set) {
        HashSet hashSet;
        t.e(set, "<this>");
        if (set instanceof HashSet) {
            hashSet = (HashSet) set;
        } else {
            hashSet = null;
        }
        if (hashSet == null) {
            return new HashSet(set);
        }
        return hashSet;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public Set l(HashSet hashSet) {
        t.e(hashSet, "<this>");
        return hashSet;
    }
}
