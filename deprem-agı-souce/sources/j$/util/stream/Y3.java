package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C0469e;
import j$.util.Spliterator;
import j$.util.W;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class Y3 extends c4 implements DoubleConsumer, W {

    /* renamed from: e  reason: collision with root package name */
    public double f1618e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f1619f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Y3(Spliterator spliterator, int i5) {
        super(spliterator);
        this.f1619f = i5;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Y3(Spliterator spliterator, c4 c4Var, int i5) {
        super(spliterator, c4Var);
        this.f1619f = i5;
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.a(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.f(this, consumer);
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        do {
        } while (tryAdvance(doubleConsumer));
    }

    public final void accept(double d5) {
        this.f1687d = (this.f1687d + 1) & 63;
        this.f1618e = d5;
    }

    public final Spliterator b(Spliterator spliterator) {
        switch (this.f1619f) {
            case 0:
                return new Y3((W) spliterator, this, 0);
            default:
                return new Y3((W) spliterator, this, 1);
        }
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.Throwable, java.util.function.DoublePredicate] */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.lang.Throwable, java.util.function.DoublePredicate] */
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        switch (this.f1619f) {
            case 0:
                boolean z4 = this.f1686c;
                Spliterator spliterator = this.f1684a;
                if (!z4) {
                    return ((W) spliterator).tryAdvance(doubleConsumer);
                }
                this.f1686c = false;
                boolean tryAdvance = ((W) spliterator).tryAdvance(this);
                if (tryAdvance && a()) {
                    ? r42 = 0;
                    r42.test(this.f1618e);
                    throw r42;
                } else if (!tryAdvance) {
                    return tryAdvance;
                } else {
                    doubleConsumer.accept(this.f1618e);
                    return tryAdvance;
                }
            default:
                if (!this.f1686c || !a() || !((W) this.f1684a).tryAdvance(this)) {
                    this.f1686c = false;
                    return false;
                }
                ? r43 = 0;
                r43.test(this.f1618e);
                throw r43;
        }
    }

    public W trySplit() {
        switch (this.f1619f) {
            case 1:
                if (this.f1685b.get()) {
                    return null;
                }
                return (W) super.trySplit();
            default:
                return super.trySplit();
        }
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.f1619f) {
            case 1:
                tryAdvance((DoubleConsumer) obj);
                return false;
            default:
                return tryAdvance((DoubleConsumer) obj);
        }
    }
}
