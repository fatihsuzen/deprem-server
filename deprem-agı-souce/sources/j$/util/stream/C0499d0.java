package j$.util.stream;

import java.util.function.LongConsumer;
import java.util.function.LongFunction;

/* renamed from: j$.util.stream.d0  reason: case insensitive filesystem */
public final class C0499d0 extends C0521h2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1695b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C0483a f1696c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0499d0(C0483a aVar, C0546m2 m2Var, int i5) {
        super(m2Var);
        this.f1695b = i5;
        this.f1696c = aVar;
    }

    public void c(long j5) {
        switch (this.f1695b) {
            case 4:
                this.f1713a.c(-1);
                return;
            default:
                super.c(j5);
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.Throwable, java.util.function.LongUnaryOperator] */
    /* JADX WARNING: type inference failed for: r0v10, types: [java.lang.Throwable, java.util.function.LongToIntFunction] */
    /* JADX WARNING: type inference failed for: r0v13, types: [java.lang.Throwable, java.util.function.LongToDoubleFunction] */
    /* JADX WARNING: type inference failed for: r0v16, types: [java.lang.Throwable, java.util.function.LongPredicate] */
    public final void accept(long j5) {
        switch (this.f1695b) {
            case 0:
                this.f1713a.accept(((LongFunction) ((r) this.f1696c).f1770t).apply(j5));
                return;
            case 1:
                ((C0582u) this.f1696c).getClass();
                ? r02 = 0;
                r02.applyAsLong(j5);
                throw r02;
            case 2:
                ((C0577t) this.f1696c).getClass();
                ? r03 = 0;
                r03.applyAsInt(j5);
                throw r03;
            case 3:
                ((C0572s) this.f1696c).getClass();
                ? r04 = 0;
                r04.applyAsDouble(j5);
                throw r04;
            case 4:
                ((C0582u) this.f1696c).getClass();
                ? r05 = 0;
                r05.test(j5);
                throw r05;
            default:
                ((LongConsumer) ((C0514g0) this.f1696c).f1709t).accept(j5);
                this.f1713a.accept(j5);
                return;
        }
    }
}
