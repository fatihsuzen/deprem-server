package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C0469e;
import j$.util.Spliterator;
import j$.util.Z;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class Z3 extends c4 implements IntConsumer, Z {

    /* renamed from: e  reason: collision with root package name */
    public int f1646e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f1647f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Z3(Spliterator spliterator, int i5) {
        super(spliterator);
        this.f1647f = i5;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Z3(Spliterator spliterator, c4 c4Var, int i5) {
        super(spliterator, c4Var);
        this.f1647f = i5;
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.b(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.g(this, consumer);
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        do {
        } while (tryAdvance(intConsumer));
    }

    public final void accept(int i5) {
        this.f1687d = (this.f1687d + 1) & 63;
        this.f1646e = i5;
    }

    public final Spliterator b(Spliterator spliterator) {
        switch (this.f1647f) {
            case 0:
                return new Z3((Z) spliterator, this, 0);
            default:
                return new Z3((Z) spliterator, this, 1);
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Throwable, java.util.function.IntPredicate] */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.lang.Throwable, java.util.function.IntPredicate] */
    public final boolean tryAdvance(IntConsumer intConsumer) {
        switch (this.f1647f) {
            case 0:
                boolean z4 = this.f1686c;
                Spliterator spliterator = this.f1684a;
                if (!z4) {
                    return ((Z) spliterator).tryAdvance(intConsumer);
                }
                this.f1686c = false;
                boolean tryAdvance = ((Z) spliterator).tryAdvance(this);
                if (tryAdvance && a()) {
                    ? r02 = 0;
                    r02.test(this.f1646e);
                    throw r02;
                } else if (!tryAdvance) {
                    return tryAdvance;
                } else {
                    intConsumer.accept(this.f1646e);
                    return tryAdvance;
                }
            default:
                if (!this.f1686c || !a() || !((Z) this.f1684a).tryAdvance(this)) {
                    this.f1686c = false;
                    return false;
                }
                ? r03 = 0;
                r03.test(this.f1646e);
                throw r03;
        }
    }

    public Z trySplit() {
        switch (this.f1647f) {
            case 1:
                if (this.f1685b.get()) {
                    return null;
                }
                return (Z) super.trySplit();
            default:
                return super.trySplit();
        }
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.f1647f) {
            case 1:
                tryAdvance((IntConsumer) obj);
                return false;
            default:
                return tryAdvance((IntConsumer) obj);
        }
    }
}
