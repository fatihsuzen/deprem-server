package j$.util.stream;

import j$.util.C0481q;
import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;

public final class D3 extends C0492b3 {
    public final C0492b3 e(Spliterator spliterator) {
        return new C0492b3(this.f1665b, spliterator, this.f1664a);
    }

    public final void d() {
        W2 w22 = new W2();
        this.f1671h = w22;
        Objects.requireNonNull(w22);
        this.f1668e = this.f1665b.G0(new C3(w22, 0));
        this.f1669f = new C0481q(13, this);
    }

    public final boolean tryAdvance(Consumer consumer) {
        Object obj;
        Objects.requireNonNull(consumer);
        boolean a5 = a();
        if (!a5) {
            return a5;
        }
        W2 w22 = (W2) this.f1671h;
        long j5 = this.f1670g;
        if (w22.f1678c == 0) {
            if (j5 < ((long) w22.f1677b)) {
                obj = w22.f1598e[(int) j5];
            } else {
                throw new IndexOutOfBoundsException(Long.toString(j5));
            }
        } else if (j5 < w22.count()) {
            int i5 = 0;
            while (i5 <= w22.f1678c) {
                long j6 = w22.f1679d[i5];
                Object[] objArr = w22.f1599f[i5];
                if (j5 < ((long) objArr.length) + j6) {
                    obj = objArr[(int) (j5 - j6)];
                } else {
                    i5++;
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j5));
        } else {
            throw new IndexOutOfBoundsException(Long.toString(j5));
        }
        consumer.accept(obj);
        return a5;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (this.f1671h != null || this.f1672i) {
            do {
            } while (tryAdvance(consumer));
            return;
        }
        Objects.requireNonNull(consumer);
        c();
        Objects.requireNonNull(consumer);
        C3 c32 = new C3(consumer, 1);
        this.f1665b.F0(this.f1667d, c32);
        this.f1672i = true;
    }
}
