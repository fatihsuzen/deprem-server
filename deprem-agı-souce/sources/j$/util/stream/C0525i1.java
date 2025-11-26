package j$.util.stream;

import j$.util.Spliterator;
import j$.util.f0;
import java.util.Deque;

/* renamed from: j$.util.stream.i1  reason: case insensitive filesystem */
public abstract class C0525i1 extends C0535k1 implements f0 {
    public final boolean tryAdvance(Object obj) {
        G0 g02;
        if (!c()) {
            return false;
        }
        boolean tryAdvance = ((f0) this.f1732d).tryAdvance(obj);
        if (!tryAdvance) {
            if (this.f1731c != null || (g02 = (G0) C0535k1.a(this.f1733e)) == null) {
                this.f1729a = null;
            } else {
                f0 spliterator = g02.spliterator();
                this.f1732d = spliterator;
                return spliterator.tryAdvance(obj);
            }
        }
        return tryAdvance;
    }

    public final void forEachRemaining(Object obj) {
        if (this.f1729a != null) {
            if (this.f1732d == null) {
                Spliterator spliterator = this.f1731c;
                if (spliterator == null) {
                    Deque b5 = b();
                    while (true) {
                        G0 g02 = (G0) C0535k1.a(b5);
                        if (g02 != null) {
                            g02.g(obj);
                        } else {
                            this.f1729a = null;
                            return;
                        }
                    }
                } else {
                    ((f0) spliterator).forEachRemaining(obj);
                }
            } else {
                do {
                } while (tryAdvance(obj));
            }
        }
    }
}
