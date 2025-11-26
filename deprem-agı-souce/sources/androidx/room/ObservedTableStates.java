package androidx.room;

import W2.J;
import X2.C2242i;
import d3.C2344a;
import d3.C2345b;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.t;

public final class ObservedTableStates {
    private final ReentrantLock lock = new ReentrantLock();
    private boolean needsSync;
    private final boolean[] tableObservedState;
    private final long[] tableObserversCount;

    public enum ObserveOp {
        NO_OP,
        ADD,
        REMOVE;

        static {
            ObserveOp[] $values;
            $ENTRIES = C2345b.a($values);
        }

        public static C2344a getEntries() {
            return $ENTRIES;
        }
    }

    public ObservedTableStates(int i5) {
        this.tableObserversCount = new long[i5];
        this.tableObservedState = new boolean[i5];
    }

    public final void forceNeedSync$room_runtime_release() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.needsSync = true;
            J j5 = J.f19942a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final ObserveOp[] getTablesToSync$room_runtime_release() {
        boolean z4;
        ObserveOp observeOp;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            ObserveOp[] observeOpArr = null;
            if (!this.needsSync) {
                reentrantLock.unlock();
                return null;
            }
            this.needsSync = false;
            int length = this.tableObserversCount.length;
            ObserveOp[] observeOpArr2 = new ObserveOp[length];
            int i5 = 0;
            boolean z5 = false;
            while (i5 < length) {
                boolean z6 = true;
                if (this.tableObserversCount[i5] > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean[] zArr = this.tableObservedState;
                if (z4 != zArr[i5]) {
                    zArr[i5] = z4;
                    if (z4) {
                        observeOp = ObserveOp.ADD;
                    } else {
                        observeOp = ObserveOp.REMOVE;
                    }
                } else {
                    z6 = z5;
                    observeOp = ObserveOp.NO_OP;
                }
                observeOpArr2[i5] = observeOp;
                i5++;
                z5 = z6;
            }
            if (z5) {
                observeOpArr = observeOpArr2;
            }
            reentrantLock.unlock();
            return observeOpArr;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean onObserverAdded$room_runtime_release(int[] iArr) {
        t.e(iArr, "tableIds");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean z4 = false;
            for (int i5 : iArr) {
                long[] jArr = this.tableObserversCount;
                long j5 = jArr[i5];
                jArr[i5] = 1 + j5;
                if (j5 == 0) {
                    z4 = true;
                    this.needsSync = true;
                }
            }
            return z4;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean onObserverRemoved$room_runtime_release(int[] iArr) {
        t.e(iArr, "tableIds");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean z4 = false;
            for (int i5 : iArr) {
                long[] jArr = this.tableObserversCount;
                long j5 = jArr[i5];
                jArr[i5] = j5 - 1;
                if (j5 == 1) {
                    z4 = true;
                    this.needsSync = true;
                }
            }
            return z4;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void resetTriggerState$room_runtime_release() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            C2242i.A(this.tableObservedState, false, 0, 0, 6, (Object) null);
            this.needsSync = true;
            J j5 = J.f19942a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
