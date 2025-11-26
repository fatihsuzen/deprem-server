package L3;

import H3.b;
import J3.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: L3.b0  reason: case insensitive filesystem */
public final class C2079b0 extends C2099l0 {

    /* renamed from: c  reason: collision with root package name */
    private final f f18508c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2079b0(b bVar, b bVar2) {
        super(bVar, bVar2, (C2633k) null);
        t.e(bVar, "kSerializer");
        t.e(bVar2, "vSerializer");
        this.f18508c = new C2077a0(bVar.getDescriptor(), bVar2.getDescriptor());
    }

    public f getDescriptor() {
        return this.f18508c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public LinkedHashMap a() {
        return new LinkedHashMap();
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int b(LinkedHashMap linkedHashMap) {
        t.e(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void c(LinkedHashMap linkedHashMap, int i5) {
        t.e(linkedHashMap, "<this>");
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
    public LinkedHashMap k(Map map) {
        LinkedHashMap linkedHashMap;
        t.e(map, "<this>");
        if (map instanceof LinkedHashMap) {
            linkedHashMap = (LinkedHashMap) map;
        } else {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return new LinkedHashMap(map);
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public Map l(LinkedHashMap linkedHashMap) {
        t.e(linkedHashMap, "<this>");
        return linkedHashMap;
    }
}
