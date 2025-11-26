package androidx.room;

import X2.T;
import androidx.room.InvalidationTracker;
import b.w;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.t;
import t3.s;

public final class ObserverWrapper {
    private final InvalidationTracker.Observer observer;
    private final Set<String> singleTableSet;
    private final int[] tableIds;
    private final String[] tableNames;

    public ObserverWrapper(InvalidationTracker.Observer observer2, int[] iArr, String[] strArr) {
        boolean z4;
        Set<String> set;
        t.e(observer2, "observer");
        t.e(iArr, "tableIds");
        t.e(strArr, "tableNames");
        this.observer = observer2;
        this.tableIds = iArr;
        this.tableNames = strArr;
        if (iArr.length == strArr.length) {
            if (strArr.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                set = T.c(strArr[0]);
            } else {
                set = T.d();
            }
            this.singleTableSet = set;
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final InvalidationTracker.Observer getObserver$room_runtime_release() {
        return this.observer;
    }

    public final int[] getTableIds$room_runtime_release() {
        return this.tableIds;
    }

    public final void notifyByTableIds$room_runtime_release(Set<Integer> set) {
        Set<String> set2;
        t.e(set, "invalidatedTablesIds");
        int[] iArr = this.tableIds;
        int length = iArr.length;
        if (length != 0) {
            int i5 = 0;
            if (length != 1) {
                Set b5 = T.b();
                int[] iArr2 = this.tableIds;
                int length2 = iArr2.length;
                int i6 = 0;
                while (i5 < length2) {
                    int i7 = i6 + 1;
                    if (set.contains(Integer.valueOf(iArr2[i5]))) {
                        b5.add(this.tableNames[i6]);
                    }
                    i5++;
                    i6 = i7;
                }
                set2 = T.a(b5);
            } else if (set.contains(Integer.valueOf(iArr[0]))) {
                set2 = this.singleTableSet;
            } else {
                set2 = T.d();
            }
        } else {
            set2 = T.d();
        }
        if (!set2.isEmpty()) {
            this.observer.onInvalidated(set2);
        }
    }

    public final void notifyByTableNames$room_runtime_release(Set<String> set) {
        Set<String> set2;
        t.e(set, "invalidatedTablesNames");
        int length = this.tableNames.length;
        if (length == 0) {
            set2 = T.d();
        } else if (length != 1) {
            Set b5 = T.b();
            for (String str : set) {
                String[] strArr = this.tableNames;
                int length2 = strArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        break;
                    }
                    String str2 = strArr[i5];
                    if (s.E(str2, str, true)) {
                        b5.add(str2);
                        break;
                    }
                    i5++;
                }
            }
            set2 = T.a(b5);
        } else {
            if (!w.a(set) || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (s.E((String) it.next(), this.tableNames[0], true)) {
                            set2 = this.singleTableSet;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            set2 = T.d();
        }
        if (!set2.isEmpty()) {
            this.observer.onInvalidated(set2);
        }
    }
}
