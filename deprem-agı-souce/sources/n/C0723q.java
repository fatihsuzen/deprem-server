package N;

/* renamed from: N.q  reason: case insensitive filesystem */
public final class C0723q {

    /* renamed from: b  reason: collision with root package name */
    private static C0723q f3132b;

    /* renamed from: c  reason: collision with root package name */
    private static final r f3133c = new r(0, false, false, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private r f3134a;

    private C0723q() {
    }

    public static synchronized C0723q b() {
        C0723q qVar;
        synchronized (C0723q.class) {
            try {
                if (f3132b == null) {
                    f3132b = new C0723q();
                }
                qVar = f3132b;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return qVar;
    }

    public r a() {
        return this.f3134a;
    }

    public final synchronized void c(r rVar) {
        if (rVar == null) {
            this.f3134a = f3133c;
            return;
        }
        r rVar2 = this.f3134a;
        if (rVar2 == null || rVar2.i() < rVar.i()) {
            this.f3134a = rVar;
        }
    }
}
