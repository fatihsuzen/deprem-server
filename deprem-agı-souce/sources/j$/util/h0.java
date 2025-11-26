package j$.util;

import j$.util.function.Consumer$CC;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public final class h0 implements Iterator, Consumer {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1387a = false;

    /* renamed from: b  reason: collision with root package name */
    public Object f1388b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Spliterator f1389c;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public h0(Spliterator spliterator) {
        this.f1389c = spliterator;
    }

    public final void accept(Object obj) {
        this.f1387a = true;
        this.f1388b = obj;
    }

    public final boolean hasNext() {
        if (!this.f1387a) {
            this.f1389c.tryAdvance(this);
        }
        return this.f1387a;
    }

    public final Object next() {
        if (this.f1387a || hasNext()) {
            this.f1387a = false;
            return this.f1388b;
        }
        throw new NoSuchElementException();
    }
}
