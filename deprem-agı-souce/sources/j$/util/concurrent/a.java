package j$.util.concurrent;

public abstract class a extends p {

    /* renamed from: i  reason: collision with root package name */
    public final ConcurrentHashMap f1311i;

    /* renamed from: j  reason: collision with root package name */
    public l f1312j;

    public a(l[] lVarArr, int i5, int i6, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i5, 0, i6);
        this.f1311i = concurrentHashMap;
        a();
    }

    public final boolean hasNext() {
        return this.f1332b != null;
    }

    public final boolean hasMoreElements() {
        return this.f1332b != null;
    }

    public final void remove() {
        l lVar = this.f1312j;
        if (lVar != null) {
            this.f1312j = null;
            this.f1311i.g(lVar.f1324b, (Object) null, (Object) null);
            return;
        }
        throw new IllegalStateException();
    }
}
