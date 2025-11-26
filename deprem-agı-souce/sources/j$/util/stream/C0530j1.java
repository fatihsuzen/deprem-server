package j$.util.stream;

import j$.util.Spliterator;
import java.util.Deque;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.j1  reason: case insensitive filesystem */
public final class C0530j1 extends C0535k1 {
    public final boolean tryAdvance(Consumer consumer) {
        H0 a5;
        if (!c()) {
            return false;
        }
        boolean tryAdvance = this.f1732d.tryAdvance(consumer);
        if (!tryAdvance) {
            if (this.f1731c != null || (a5 = C0535k1.a(this.f1733e)) == null) {
                this.f1729a = null;
            } else {
                Spliterator spliterator = a5.spliterator();
                this.f1732d = spliterator;
                return spliterator.tryAdvance(consumer);
            }
        }
        return tryAdvance;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (this.f1729a != null) {
            if (this.f1732d == null) {
                Spliterator spliterator = this.f1731c;
                if (spliterator == null) {
                    Deque b5 = b();
                    while (true) {
                        H0 a5 = C0535k1.a(b5);
                        if (a5 != null) {
                            a5.forEach(consumer);
                        } else {
                            this.f1729a = null;
                            return;
                        }
                    }
                } else {
                    spliterator.forEachRemaining(consumer);
                }
            } else {
                do {
                } while (tryAdvance(consumer));
            }
        }
    }
}
