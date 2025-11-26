package j$.time.format;

import j$.util.stream.Y2;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1137a;

    public void b(Y2 y22) {
        ((EnumMap) this.f1137a).put(y22, 1);
    }

    public r(int i5, Map map) {
        switch (i5) {
            case 1:
                this.f1137a = map;
                return;
            default:
                this.f1137a = map;
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                        q qVar = b.f1099b;
                        hashMap2.put((String) entry2.getValue(), new AbstractMap.SimpleImmutableEntry((String) entry2.getValue(), (Long) entry2.getKey()));
                    }
                    ArrayList arrayList2 = new ArrayList(hashMap2.values());
                    Collections.sort(arrayList2, b.f1099b);
                    hashMap.put((v) entry.getKey(), arrayList2);
                    arrayList.addAll(arrayList2);
                    hashMap.put((Object) null, arrayList);
                }
                Collections.sort(arrayList, b.f1099b);
                return;
        }
    }

    public String a(long j5, v vVar) {
        Map map = (Map) this.f1137a.get(vVar);
        if (map != null) {
            return (String) map.get(Long.valueOf(j5));
        }
        return null;
    }
}
