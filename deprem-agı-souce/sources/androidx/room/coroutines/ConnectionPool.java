package androidx.room.coroutines;

import b3.C2308e;
import k3.p;

public interface ConnectionPool extends AutoCloseable {

    public static final class RollbackException extends Throwable {
        private final Object result;

        public RollbackException(Object obj) {
            this.result = obj;
        }

        public final Object getResult() {
            return this.result;
        }
    }

    void close();

    <R> Object useConnection(boolean z4, p pVar, C2308e eVar);
}
