package C;

import android.util.SparseArray;
import java.util.HashMap;
import p.f;

/* renamed from: C.a  reason: case insensitive filesystem */
public abstract class C0634a {

    /* renamed from: a  reason: collision with root package name */
    private static SparseArray f2325a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap f2326b;

    static {
        HashMap hashMap = new HashMap();
        f2326b = hashMap;
        hashMap.put(f.DEFAULT, 0);
        f2326b.put(f.VERY_LOW, 1);
        f2326b.put(f.HIGHEST, 2);
        for (f fVar : f2326b.keySet()) {
            f2325a.append(((Integer) f2326b.get(fVar)).intValue(), fVar);
        }
    }

    public static int a(f fVar) {
        Integer num = (Integer) f2326b.get(fVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + fVar);
    }

    public static f b(int i5) {
        f fVar = (f) f2325a.get(i5);
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i5);
    }
}
