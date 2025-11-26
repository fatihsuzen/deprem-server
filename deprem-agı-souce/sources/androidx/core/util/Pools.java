package androidx.core.util;

import androidx.annotation.IntRange;
import kotlin.jvm.internal.t;

public final class Pools {

    public interface Pool<T> {
        T acquire();

        boolean release(T t5);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] pool;
        private int poolSize;

        public SimplePool(@IntRange(from = 1) int i5) {
            if (i5 > 0) {
                this.pool = new Object[i5];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private final boolean isInPool(T t5) {
            int i5 = this.poolSize;
            for (int i6 = 0; i6 < i5; i6++) {
                if (this.pool[i6] == t5) {
                    return true;
                }
            }
            return false;
        }

        public T acquire() {
            int i5 = this.poolSize;
            if (i5 <= 0) {
                return null;
            }
            int i6 = i5 - 1;
            T t5 = this.pool[i6];
            t.c(t5, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.pool[i6] = null;
            this.poolSize--;
            return t5;
        }

        public boolean release(T t5) {
            t.e(t5, "instance");
            if (!isInPool(t5)) {
                int i5 = this.poolSize;
                Object[] objArr = this.pool;
                if (i5 >= objArr.length) {
                    return false;
                }
                objArr[i5] = t5;
                this.poolSize = i5 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object lock = new Object();

        public SynchronizedPool(int i5) {
            super(i5);
        }

        public T acquire() {
            T acquire;
            synchronized (this.lock) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(T t5) {
            boolean release;
            t.e(t5, "instance");
            synchronized (this.lock) {
                release = super.release(t5);
            }
            return release;
        }
    }

    private Pools() {
    }
}
