package j$.util.concurrent;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class d extends a implements Iterator {
    public final Object next() {
        l lVar = this.f1332b;
        if (lVar != null) {
            Object obj = lVar.f1324b;
            Object obj2 = lVar.f1325c;
            this.f1312j = lVar;
            a();
            return new k(obj, obj2, this.f1311i);
        }
        throw new NoSuchElementException();
    }
}
