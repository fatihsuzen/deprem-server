package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Spliterator;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.p1  reason: case insensitive filesystem */
public final class C0560p1 extends C0574s1 implements C0536k2 {

    /* renamed from: h  reason: collision with root package name */
    public final int[] f1760h;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void d(Integer num) {
        C0594w1.F(this, num);
    }

    public C0560p1(Spliterator spliterator, C0594w1 w1Var, int[] iArr) {
        super(spliterator, w1Var, iArr.length);
        this.f1760h = iArr;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0560p1(j$.util.stream.C0560p1 r10, j$.util.Spliterator r11, long r12, long r14) {
        /*
            r9 = this;
            int[] r0 = r10.f1760h
            int r8 = r0.length
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r14
            r1.<init>(r2, r3, r4, r6, r8)
            int[] r10 = r2.f1760h
            r1.f1760h = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0560p1.<init>(j$.util.stream.p1, j$.util.Spliterator, long, long):void");
    }

    public final C0574s1 a(Spliterator spliterator, long j5, long j6) {
        return new C0560p1(this, spliterator, j5, j6);
    }

    public final void accept(int i5) {
        int i6 = this.f1781f;
        if (i6 < this.f1782g) {
            int[] iArr = this.f1760h;
            this.f1781f = i6 + 1;
            iArr[i6] = i5;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f1781f));
    }
}
