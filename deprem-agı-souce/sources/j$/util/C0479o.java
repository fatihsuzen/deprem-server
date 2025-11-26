package j$.util;

import java.util.ListIterator;
import java.util.function.Consumer;

/* renamed from: j$.util.o  reason: case insensitive filesystem */
public final class C0479o implements ListIterator, C0618z {

    /* renamed from: a  reason: collision with root package name */
    public final ListIterator f1416a;

    public C0479o(C0480p pVar, int i5) {
        this.f1416a = pVar.f1417b.listIterator(i5);
    }

    public final boolean hasNext() {
        return this.f1416a.hasNext();
    }

    public final Object next() {
        return this.f1416a.next();
    }

    public final boolean hasPrevious() {
        return this.f1416a.hasPrevious();
    }

    public final Object previous() {
        return this.f1416a.previous();
    }

    public final int nextIndex() {
        return this.f1416a.nextIndex();
    }

    public final int previousIndex() {
        return this.f1416a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final void forEachRemaining(Consumer consumer) {
        C0469e.r(this.f1416a, consumer);
    }
}
