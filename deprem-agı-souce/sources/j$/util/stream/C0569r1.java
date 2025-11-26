package j$.util.stream;

import j$.util.Spliterator;

/* renamed from: j$.util.stream.r1  reason: case insensitive filesystem */
public final class C0569r1 extends C0574s1 {

    /* renamed from: h  reason: collision with root package name */
    public final Object[] f1771h;

    public C0569r1(Spliterator spliterator, C0594w1 w1Var, Object[] objArr) {
        super(spliterator, w1Var, objArr.length);
        this.f1771h = objArr;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0569r1(j$.util.stream.C0569r1 r10, j$.util.Spliterator r11, long r12, long r14) {
        /*
            r9 = this;
            java.lang.Object[] r0 = r10.f1771h
            int r8 = r0.length
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r14
            r1.<init>(r2, r3, r4, r6, r8)
            java.lang.Object[] r10 = r2.f1771h
            r1.f1771h = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0569r1.<init>(j$.util.stream.r1, j$.util.Spliterator, long, long):void");
    }

    public final C0574s1 a(Spliterator spliterator, long j5, long j6) {
        return new C0569r1(this, spliterator, j5, j6);
    }

    public final void accept(Object obj) {
        int i5 = this.f1781f;
        if (i5 < this.f1782g) {
            Object[] objArr = this.f1771h;
            this.f1781f = i5 + 1;
            objArr[i5] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f1781f));
    }
}
