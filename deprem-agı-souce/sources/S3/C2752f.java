package s3;

import W2.J;
import W2.t;
import W2.u;
import b3.C2308e;
import b3.C2312i;
import b3.C2313j;
import c3.C2316b;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import l3.C2677a;

/* renamed from: s3.f  reason: case insensitive filesystem */
final class C2752f extends C2753g implements Iterator, C2308e, C2677a {

    /* renamed from: a  reason: collision with root package name */
    private int f25836a;

    /* renamed from: b  reason: collision with root package name */
    private Object f25837b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator f25838c;

    /* renamed from: d  reason: collision with root package name */
    private C2308e f25839d;

    private final Throwable f() {
        int i5 = this.f25836a;
        if (i5 == 4) {
            return new NoSuchElementException();
        }
        if (i5 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f25836a);
    }

    private final Object i() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public Object a(Object obj, C2308e eVar) {
        this.f25837b = obj;
        this.f25836a = 3;
        this.f25839d = eVar;
        Object f5 = C2316b.f();
        if (f5 == C2316b.f()) {
            h.c(eVar);
        }
        if (f5 == C2316b.f()) {
            return f5;
        }
        return J.f19942a;
    }

    public Object b(Iterator it, C2308e eVar) {
        if (!it.hasNext()) {
            return J.f19942a;
        }
        this.f25838c = it;
        this.f25836a = 2;
        this.f25839d = eVar;
        Object f5 = C2316b.f();
        if (f5 == C2316b.f()) {
            h.c(eVar);
        }
        if (f5 == C2316b.f()) {
            return f5;
        }
        return J.f19942a;
    }

    public C2312i getContext() {
        return C2313j.f20794a;
    }

    public boolean hasNext() {
        while (true) {
            int i5 = this.f25836a;
            if (i5 != 0) {
                if (i5 == 1) {
                    Iterator it = this.f25838c;
                    t.b(it);
                    if (it.hasNext()) {
                        this.f25836a = 2;
                        return true;
                    }
                    this.f25838c = null;
                } else if (i5 == 2 || i5 == 3) {
                    return true;
                } else {
                    if (i5 == 4) {
                        return false;
                    }
                    throw f();
                }
            }
            this.f25836a = 5;
            C2308e eVar = this.f25839d;
            t.b(eVar);
            this.f25839d = null;
            t.a aVar = W2.t.f19966b;
            eVar.resumeWith(W2.t.b(J.f19942a));
        }
    }

    public final void j(C2308e eVar) {
        this.f25839d = eVar;
    }

    public Object next() {
        int i5 = this.f25836a;
        if (i5 == 0 || i5 == 1) {
            return i();
        }
        if (i5 == 2) {
            this.f25836a = 1;
            Iterator it = this.f25838c;
            kotlin.jvm.internal.t.b(it);
            return it.next();
        } else if (i5 == 3) {
            this.f25836a = 0;
            Object obj = this.f25837b;
            this.f25837b = null;
            return obj;
        } else {
            throw f();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void resumeWith(Object obj) {
        u.b(obj);
        this.f25836a = 4;
    }
}
