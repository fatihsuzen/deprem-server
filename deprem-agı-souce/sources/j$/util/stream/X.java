package j$.util.stream;

import j$.util.J;
import j$.util.Objects;

public final class X extends C0516g2 {

    /* renamed from: b  reason: collision with root package name */
    public boolean f1605b;

    /* renamed from: c  reason: collision with root package name */
    public final J f1606c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ V f1607d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public X(V v5, C0546m2 m2Var) {
        super(m2Var);
        this.f1607d = v5;
        C0546m2 m2Var2 = this.f1710a;
        Objects.requireNonNull(m2Var2);
        this.f1606c = new J(m2Var2, 1);
    }

    public final void c(long j5) {
        this.f1710a.c(-1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026 A[Catch:{ all -> 0x001c, all -> 0x0039 }, LOOP:0: B:11:0x0026->B:14:0x0032, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(int r4) {
        /*
            r3 = this;
            j$.util.stream.V r0 = r3.f1607d
            java.lang.Object r0 = r0.f1594t
            j$.util.stream.L r0 = (j$.util.stream.L) r0
            java.lang.Object r4 = r0.apply(r4)
            j$.util.stream.IntStream r4 = (j$.util.stream.IntStream) r4
            if (r4 == 0) goto L_0x003e
            boolean r0 = r3.f1605b     // Catch:{ all -> 0x001c }
            j$.util.J r1 = r3.f1606c
            if (r0 != 0) goto L_0x001e
            j$.util.stream.IntStream r0 = r4.sequential()     // Catch:{ all -> 0x001c }
            r0.forEach(r1)     // Catch:{ all -> 0x001c }
            goto L_0x003e
        L_0x001c:
            r0 = move-exception
            goto L_0x0035
        L_0x001e:
            j$.util.stream.IntStream r0 = r4.sequential()     // Catch:{ all -> 0x001c }
            j$.util.Z r0 = r0.spliterator()     // Catch:{ all -> 0x001c }
        L_0x0026:
            j$.util.stream.m2 r2 = r3.f1710a     // Catch:{ all -> 0x001c }
            boolean r2 = r2.e()     // Catch:{ all -> 0x001c }
            if (r2 != 0) goto L_0x003e
            boolean r2 = r0.tryAdvance(r1)     // Catch:{ all -> 0x001c }
            if (r2 != 0) goto L_0x0026
            goto L_0x003e
        L_0x0035:
            r4.close()     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r4 = move-exception
            r0.addSuppressed(r4)
        L_0x003d:
            throw r0
        L_0x003e:
            if (r4 == 0) goto L_0x0043
            r4.close()
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.X.accept(int):void");
    }

    public final boolean e() {
        this.f1605b = true;
        return this.f1710a.e();
    }
}
