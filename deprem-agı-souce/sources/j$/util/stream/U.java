package j$.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;

public final class U extends C0516g2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1585b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C0483a f1586c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ U(C0483a aVar, C0546m2 m2Var, int i5) {
        super(m2Var);
        this.f1585b = i5;
        this.f1586c = aVar;
    }

    public void c(long j5) {
        switch (this.f1585b) {
            case 5:
                this.f1710a.c(-1);
                return;
            default:
                super.c(j5);
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [java.lang.Throwable, java.util.function.IntUnaryOperator] */
    /* JADX WARNING: type inference failed for: r0v16, types: [java.lang.Throwable, java.util.function.IntToLongFunction] */
    /* JADX WARNING: type inference failed for: r0v19, types: [java.lang.Throwable, java.util.function.IntToDoubleFunction] */
    /* JADX WARNING: type inference failed for: r0v22, types: [java.lang.Throwable, java.util.function.IntPredicate] */
    public final void accept(int i5) {
        switch (this.f1585b) {
            case 0:
                this.f1710a.accept(((IntFunction) ((r) this.f1586c).f1770t).apply(i5));
                return;
            case 1:
                ((IntConsumer) ((V) this.f1586c).f1594t).accept(i5);
                this.f1710a.accept(i5);
                return;
            case 2:
                ((C0577t) this.f1586c).getClass();
                ? r02 = 0;
                r02.applyAsInt(i5);
                throw r02;
            case 3:
                ((C0582u) this.f1586c).getClass();
                ? r03 = 0;
                r03.applyAsLong(i5);
                throw r03;
            case 4:
                ((C0572s) this.f1586c).getClass();
                ? r04 = 0;
                r04.applyAsDouble(i5);
                throw r04;
            default:
                ((C0577t) this.f1586c).getClass();
                ? r05 = 0;
                r05.test(i5);
                throw r05;
        }
    }
}
