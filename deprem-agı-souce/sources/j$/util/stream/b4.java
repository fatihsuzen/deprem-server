package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class b4 extends c4 implements Consumer {

    /* renamed from: e  reason: collision with root package name */
    public final Predicate f1673e;

    /* renamed from: f  reason: collision with root package name */
    public Object f1674f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f1675g;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b4(Spliterator spliterator, Predicate predicate, int i5) {
        super(spliterator);
        this.f1675g = i5;
        this.f1673e = predicate;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b4(Spliterator spliterator, b4 b4Var, int i5) {
        super(spliterator, b4Var);
        this.f1675g = i5;
        this.f1673e = b4Var.f1673e;
    }

    public final void accept(Object obj) {
        this.f1687d = (this.f1687d + 1) & 63;
        this.f1674f = obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean tryAdvance(java.util.function.Consumer r7) {
        /*
            r6 = this;
            int r0 = r6.f1675g
            switch(r0) {
                case 0: goto L_0x0035;
                default: goto L_0x0005;
            }
        L_0x0005:
            boolean r0 = r6.f1686c
            r1 = 1
            if (r0 == 0) goto L_0x0028
            boolean r0 = r6.a()
            if (r0 == 0) goto L_0x0028
            j$.util.Spliterator r0 = r6.f1684a
            boolean r0 = r0.tryAdvance(r6)
            if (r0 == 0) goto L_0x0028
            java.util.function.Predicate r0 = r6.f1673e
            java.lang.Object r2 = r6.f1674f
            boolean r0 = r0.test(r2)
            if (r0 == 0) goto L_0x0029
            java.lang.Object r0 = r6.f1674f
            r7.accept(r0)
            goto L_0x0034
        L_0x0028:
            r0 = r1
        L_0x0029:
            r7 = 0
            r6.f1686c = r7
            if (r0 != 0) goto L_0x0033
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.f1685b
            r0.set(r1)
        L_0x0033:
            r1 = r7
        L_0x0034:
            return r1
        L_0x0035:
            boolean r0 = r6.f1686c
            j$.util.Spliterator r1 = r6.f1684a
            if (r0 == 0) goto L_0x0066
            r0 = 0
            r6.f1686c = r0
        L_0x003e:
            boolean r2 = r1.tryAdvance(r6)
            r3 = 1
            if (r2 == 0) goto L_0x0057
            boolean r4 = r6.a()
            if (r4 == 0) goto L_0x0057
            java.util.function.Predicate r4 = r6.f1673e
            java.lang.Object r5 = r6.f1674f
            boolean r4 = r4.test(r5)
            if (r4 == 0) goto L_0x0057
            r0 = r3
            goto L_0x003e
        L_0x0057:
            if (r2 == 0) goto L_0x006a
            if (r0 == 0) goto L_0x0060
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.f1685b
            r0.set(r3)
        L_0x0060:
            java.lang.Object r0 = r6.f1674f
            r7.accept(r0)
            goto L_0x006a
        L_0x0066:
            boolean r2 = r1.tryAdvance(r7)
        L_0x006a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.b4.tryAdvance(java.util.function.Consumer):boolean");
    }

    public Spliterator trySplit() {
        switch (this.f1675g) {
            case 1:
                if (this.f1685b.get()) {
                    return null;
                }
                return super.trySplit();
            default:
                return super.trySplit();
        }
    }

    public final Spliterator b(Spliterator spliterator) {
        switch (this.f1675g) {
            case 0:
                return new b4(spliterator, this, 0);
            default:
                return new b4(spliterator, this, 1);
        }
    }
}
