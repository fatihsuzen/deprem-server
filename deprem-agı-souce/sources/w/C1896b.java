package w;

/* renamed from: w.b  reason: case insensitive filesystem */
public abstract class C1896b {
    public static Object a(int i5, Object obj, C1895a aVar, C1897c cVar) {
        Object apply;
        if (i5 < 1) {
            return aVar.apply(obj);
        }
        do {
            apply = aVar.apply(obj);
            obj = cVar.a(obj, apply);
            if (obj == null || i5 - 1 < 1) {
                return apply;
            }
            apply = aVar.apply(obj);
            obj = cVar.a(obj, apply);
            break;
        } while (i5 - 1 < 1);
        return apply;
    }
}
