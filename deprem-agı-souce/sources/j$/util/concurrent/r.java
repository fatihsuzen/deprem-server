package j$.util.concurrent;

public final class r extends l {

    /* renamed from: e  reason: collision with root package name */
    public r f1344e;

    /* renamed from: f  reason: collision with root package name */
    public r f1345f;

    /* renamed from: g  reason: collision with root package name */
    public r f1346g;

    /* renamed from: h  reason: collision with root package name */
    public r f1347h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1348i;

    public r(int i5, Object obj, Object obj2, l lVar, r rVar) {
        super(i5, obj, obj2, lVar);
        this.f1344e = rVar;
    }

    public final l a(int i5, Object obj) {
        return b(i5, obj, (Class) null);
    }

    public final r b(int i5, Object obj, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        r rVar = this;
        do {
            r rVar2 = rVar.f1345f;
            r rVar3 = rVar.f1346g;
            int i6 = rVar.f1323a;
            if (i6 <= i5) {
                if (i6 >= i5) {
                    Object obj2 = rVar.f1324b;
                    if (obj2 == obj || (obj2 != null && obj.equals(obj2))) {
                        return rVar;
                    }
                    if (rVar2 != null) {
                        if (rVar3 != null) {
                            if (!(cls == null && (cls = ConcurrentHashMap.c(obj)) == null)) {
                                int i7 = ConcurrentHashMap.f1289g;
                                int compareTo = (obj2 == null || obj2.getClass() != cls) ? 0 : ((Comparable) obj).compareTo(obj2);
                                if (compareTo != 0) {
                                    if (compareTo >= 0) {
                                        rVar2 = rVar3;
                                    }
                                }
                            }
                            r b5 = rVar3.b(i5, obj, cls);
                            if (b5 != null) {
                                return b5;
                            }
                        }
                    }
                }
                rVar = rVar3;
                continue;
            }
            rVar = rVar2;
            continue;
        } while (rVar != null);
        return null;
    }
}
