package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C0469e;
import j$.util.Spliterator;
import j$.util.c0;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class a4 extends c4 implements LongConsumer, c0 {

    /* renamed from: e  reason: collision with root package name */
    public long f1660e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f1661f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a4(Spliterator spliterator, int i5) {
        super(spliterator);
        this.f1661f = i5;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a4(Spliterator spliterator, c4 c4Var, int i5) {
        super(spliterator, c4Var);
        this.f1661f = i5;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0469e.c(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return C0469e.h(this, consumer);
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        do {
        } while (tryAdvance(longConsumer));
    }

    public final void accept(long j5) {
        this.f1687d = (this.f1687d + 1) & 63;
        this.f1660e = j5;
    }

    public final Spliterator b(Spliterator spliterator) {
        switch (this.f1661f) {
            case 0:
                return new a4((c0) spliterator, this, 0);
            default:
                return new a4((c0) spliterator, this, 1);
        }
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.Throwable, java.util.function.LongPredicate] */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.lang.Throwable, java.util.function.LongPredicate] */
    public final boolean tryAdvance(LongConsumer longConsumer) {
        switch (this.f1661f) {
            case 0:
                boolean z4 = this.f1686c;
                Spliterator spliterator = this.f1684a;
                if (!z4) {
                    return ((c0) spliterator).tryAdvance(longConsumer);
                }
                this.f1686c = false;
                boolean tryAdvance = ((c0) spliterator).tryAdvance(this);
                if (tryAdvance && a()) {
                    ? r42 = 0;
                    r42.test(this.f1660e);
                    throw r42;
                } else if (!tryAdvance) {
                    return tryAdvance;
                } else {
                    longConsumer.accept(this.f1660e);
                    return tryAdvance;
                }
            default:
                if (!this.f1686c || !a() || !((c0) this.f1684a).tryAdvance(this)) {
                    this.f1686c = false;
                    return false;
                }
                ? r43 = 0;
                r43.test(this.f1660e);
                throw r43;
        }
    }

    public c0 trySplit() {
        switch (this.f1661f) {
            case 1:
                if (this.f1685b.get()) {
                    return null;
                }
                return (c0) super.trySplit();
            default:
                return super.trySplit();
        }
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.f1661f) {
            case 1:
                tryAdvance((LongConsumer) obj);
                return false;
            default:
                return tryAdvance((LongConsumer) obj);
        }
    }
}
