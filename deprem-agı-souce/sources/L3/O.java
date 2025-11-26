package L3;

import H3.b;
import J3.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class O extends C2099l0 {

    /* renamed from: c  reason: collision with root package name */
    private final f f18474c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public O(b bVar, b bVar2) {
        super(bVar, bVar2, (C2633k) null);
        t.e(bVar, "kSerializer");
        t.e(bVar2, "vSerializer");
        this.f18474c = new N(bVar.getDescriptor(), bVar2.getDescriptor());
    }

    public f getDescriptor() {
        return this.f18474c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public HashMap a() {
        return new HashMap();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int b(HashMap hashMap) {
        t.e(hashMap, "<this>");
        return hashMap.size() * 2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void c(HashMap hashMap, int i5) {
        t.e(hashMap, "<this>");
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public Iterator d(Map map) {
        t.e(map, "<this>");
        return map.entrySet().iterator();
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public int e(Map map) {
        t.e(map, "<this>");
        return map.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public HashMap k(Map map) {
        HashMap hashMap;
        t.e(map, "<this>");
        if (map instanceof HashMap) {
            hashMap = (HashMap) map;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            return new HashMap(map);
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public Map l(HashMap hashMap) {
        t.e(hashMap, "<this>");
        return hashMap;
    }
}
