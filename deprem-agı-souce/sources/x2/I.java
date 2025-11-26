package X2;

import java.util.Iterator;
import kotlin.jvm.internal.t;
import l3.C2677a;

public final class I implements Iterator, C2677a {

    /* renamed from: a  reason: collision with root package name */
    private final Iterator f20053a;

    /* renamed from: b  reason: collision with root package name */
    private int f20054b;

    public I(Iterator it) {
        t.e(it, "iterator");
        this.f20053a = it;
    }

    /* renamed from: a */
    public final G next() {
        int i5 = this.f20054b;
        this.f20054b = i5 + 1;
        if (i5 < 0) {
            C2251s.o();
        }
        return new G(i5, this.f20053a.next());
    }

    public final boolean hasNext() {
        return this.f20053a.hasNext();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
