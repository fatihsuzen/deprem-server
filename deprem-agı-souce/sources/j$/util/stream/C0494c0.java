package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.A;
import j$.util.function.Consumer$CC;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.c0  reason: case insensitive filesystem */
public final /* synthetic */ class C0494c0 implements BiConsumer, IntFunction, LongFunction, Supplier, ObjLongConsumer, LongBinaryOperator, Consumer, BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1680a;

    public /* synthetic */ C0494c0(int i5) {
        this.f1680a = i5;
    }

    private final void accept$j$$util$stream$Node$$ExternalSyntheticLambda0(Object obj) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$$ExternalSyntheticLambda0(Object obj) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$$ExternalSyntheticLambda1(Object obj) {
    }

    public void accept(Object obj) {
        int i5 = this.f1680a;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f1680a) {
            case 0:
                return a.b(this, biConsumer);
            default:
                return a.b(this, biConsumer);
        }
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f1680a) {
            case 11:
                return a.c(this, function);
            case 13:
                return a.c(this, function);
            case 15:
                return a.c(this, function);
            default:
                return a.c(this, function);
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f1680a) {
            case 8:
                return Consumer$CC.$default$andThen(this, consumer);
            case 21:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public Object apply(long j5) {
        switch (this.f1680a) {
            case 2:
                return Long.valueOf(j5);
            case 10:
                return C0594w1.h0(j5);
            case 12:
                return C0594w1.s0(j5);
            default:
                return C0594w1.t0(j5);
        }
    }

    public long applyAsLong(long j5, long j6) {
        switch (this.f1680a) {
            case 6:
                return Math.max(j5, j6);
            default:
                return j5 + j6;
        }
    }

    public Object get() {
        return new long[2];
    }

    public void accept(Object obj, long j5) {
        long[] jArr = (long[]) obj;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + j5;
    }

    public void accept(Object obj, Object obj2) {
        switch (this.f1680a) {
            case 0:
                ((A) obj).a((A) obj2);
                return;
            default:
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                jArr[0] = jArr[0] + jArr2[0];
                jArr[1] = jArr[1] + jArr2[1];
                return;
        }
    }

    public Object apply(int i5) {
        switch (this.f1680a) {
            case 1:
                return new Long[i5];
            case 9:
                return new Object[i5];
            case 17:
                return new Object[i5];
            case 18:
                return new Integer[i5];
            case 19:
                return new Long[i5];
            case 20:
                return new Double[i5];
            case 23:
                return new Integer[i5];
            case 24:
                return new Integer[i5];
            case 25:
                return new Long[i5];
            case 26:
                return new Long[i5];
            case 27:
                return new Double[i5];
            default:
                return new Double[i5];
        }
    }

    public Object apply(Object obj, Object obj2) {
        switch (this.f1680a) {
            case 11:
                return new J0((B0) obj, (B0) obj2);
            case 13:
                return new J0((D0) obj, (D0) obj2);
            case 15:
                return new J0((F0) obj, (F0) obj2);
            default:
                return new J0((H0) obj, (H0) obj2);
        }
    }
}
