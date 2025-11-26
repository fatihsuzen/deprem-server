package F3;

import b3.C2308e;

public interface a {

    /* renamed from: F3.a$a  reason: collision with other inner class name */
    public static final class C0176a {
        public static /* synthetic */ boolean a(a aVar, Object obj, int i5, Object obj2) {
            if (obj2 == null) {
                if ((i5 & 1) != 0) {
                    obj = null;
                }
                return aVar.tryLock(obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }

        public static /* synthetic */ void b(a aVar, Object obj, int i5, Object obj2) {
            if (obj2 == null) {
                if ((i5 & 1) != 0) {
                    obj = null;
                }
                aVar.unlock(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }

    E3.a getOnLock();

    boolean holdsLock(Object obj);

    boolean isLocked();

    Object lock(Object obj, C2308e eVar);

    boolean tryLock(Object obj);

    void unlock(Object obj);
}
