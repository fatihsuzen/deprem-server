package j$.util.stream;

import j$.util.F;
import j$.util.Objects;

/* renamed from: j$.util.stream.v  reason: case insensitive filesystem */
public final class C0587v extends C0511f2 {

    /* renamed from: b  reason: collision with root package name */
    public boolean f1802b;

    /* renamed from: c  reason: collision with root package name */
    public final F f1803c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ C0592w f1804d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0587v(C0592w wVar, C0546m2 m2Var) {
        super(m2Var);
        this.f1804d = wVar;
        C0546m2 m2Var2 = this.f1706a;
        Objects.requireNonNull(m2Var2);
        this.f1803c = new F(m2Var2, 1);
    }

    public final void c(long j5) {
        this.f1706a.c(-1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026 A[Catch:{ all -> 0x001c, all -> 0x0039 }, LOOP:0: B:11:0x0026->B:14:0x0032, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(double r3) {
        /*
            r2 = this;
            j$.util.stream.w r0 = r2.f1804d
            java.lang.Object r0 = r0.f1813t
            j$.util.q r0 = (j$.util.C0481q) r0
            java.lang.Object r3 = r0.apply(r3)
            j$.util.stream.D r3 = (j$.util.stream.D) r3
            if (r3 == 0) goto L_0x003e
            boolean r4 = r2.f1802b     // Catch:{ all -> 0x001c }
            j$.util.F r0 = r2.f1803c
            if (r4 != 0) goto L_0x001e
            j$.util.stream.D r4 = r3.sequential()     // Catch:{ all -> 0x001c }
            r4.forEach(r0)     // Catch:{ all -> 0x001c }
            goto L_0x003e
        L_0x001c:
            r4 = move-exception
            goto L_0x0035
        L_0x001e:
            j$.util.stream.D r4 = r3.sequential()     // Catch:{ all -> 0x001c }
            j$.util.W r4 = r4.spliterator()     // Catch:{ all -> 0x001c }
        L_0x0026:
            j$.util.stream.m2 r1 = r2.f1706a     // Catch:{ all -> 0x001c }
            boolean r1 = r1.e()     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x003e
            boolean r1 = r4.tryAdvance(r0)     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0026
            goto L_0x003e
        L_0x0035:
            r3.close()     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r3 = move-exception
            r4.addSuppressed(r3)
        L_0x003d:
            throw r4
        L_0x003e:
            if (r3 == 0) goto L_0x0043
            r3.close()
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0587v.accept(double):void");
    }

    public final boolean e() {
        this.f1802b = true;
        return this.f1706a.e();
    }
}
