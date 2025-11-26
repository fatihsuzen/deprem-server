package j$.util;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/* renamed from: j$.util.m  reason: case insensitive filesystem */
public final class C0477m implements Iterator, C0618z {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1409a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Iterator f1410b;

    public C0477m(C0478n nVar) {
        this.f1410b = nVar.f1415a.iterator();
    }

    public C0477m(C0612t tVar) {
        this.f1410b = tVar.f1415a.iterator();
    }

    public final boolean hasNext() {
        switch (this.f1409a) {
            case 0:
                return this.f1410b.hasNext();
            default:
                return this.f1410b.hasNext();
        }
    }

    public final Object next() {
        switch (this.f1409a) {
            case 0:
                return this.f1410b.next();
            default:
                return new r((Map.Entry) this.f1410b.next());
        }
    }

    public final void remove() {
        switch (this.f1409a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final void forEachRemaining(Consumer consumer) {
        switch (this.f1409a) {
            case 0:
                C0469e.r(this.f1410b, consumer);
                return;
            default:
                C0469e.r(this.f1410b, new C0481q(0, consumer));
                return;
        }
    }
}
