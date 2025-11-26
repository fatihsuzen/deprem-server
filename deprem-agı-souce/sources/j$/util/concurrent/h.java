package j$.util.concurrent;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class h extends a implements Iterator, Enumeration {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f1317k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(l[] lVarArr, int i5, int i6, ConcurrentHashMap concurrentHashMap, int i7) {
        super(lVarArr, i5, i6, concurrentHashMap);
        this.f1317k = i7;
    }

    public final Object next() {
        switch (this.f1317k) {
            case 0:
                l lVar = this.f1332b;
                if (lVar != null) {
                    Object obj = lVar.f1324b;
                    this.f1312j = lVar;
                    a();
                    return obj;
                }
                throw new NoSuchElementException();
            default:
                l lVar2 = this.f1332b;
                if (lVar2 != null) {
                    Object obj2 = lVar2.f1325c;
                    this.f1312j = lVar2;
                    a();
                    return obj2;
                }
                throw new NoSuchElementException();
        }
    }

    public final Object nextElement() {
        switch (this.f1317k) {
            case 0:
                return next();
            default:
                return next();
        }
    }
}
