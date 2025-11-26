package j$.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;

/* renamed from: j$.util.stream.q  reason: case insensitive filesystem */
public final class C0563q extends C0511f2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1764b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C0483a f1765c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0563q(C0483a aVar, C0546m2 m2Var, int i5) {
        super(m2Var);
        this.f1764b = i5;
        this.f1765c = aVar;
    }

    public void c(long j5) {
        switch (this.f1764b) {
            case 4:
                this.f1706a.c(-1);
                return;
            default:
                super.c(j5);
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.Throwable, java.util.function.DoubleUnaryOperator] */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.lang.Throwable, java.util.function.DoubleToIntFunction] */
    /* JADX WARNING: type inference failed for: r0v13, types: [java.lang.Throwable, java.util.function.DoubleToLongFunction] */
    /* JADX WARNING: type inference failed for: r0v16, types: [java.lang.Throwable, java.util.function.DoublePredicate] */
    public final void accept(double d5) {
        switch (this.f1764b) {
            case 0:
                this.f1706a.accept(((DoubleFunction) ((r) this.f1765c).f1770t).apply(d5));
                return;
            case 1:
                ((C0572s) this.f1765c).getClass();
                ? r02 = 0;
                r02.applyAsDouble(d5);
                throw r02;
            case 2:
                ((C0577t) this.f1765c).getClass();
                ? r03 = 0;
                r03.applyAsInt(d5);
                throw r03;
            case 3:
                ((C0582u) this.f1765c).getClass();
                ? r04 = 0;
                r04.applyAsLong(d5);
                throw r04;
            case 4:
                ((C0572s) this.f1765c).getClass();
                ? r05 = 0;
                r05.test(d5);
                throw r05;
            default:
                ((DoubleConsumer) ((C0592w) this.f1765c).f1813t).accept(d5);
                this.f1706a.accept(d5);
                return;
        }
    }
}
