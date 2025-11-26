package androidx.customview.poolingcontainer;

import X2.C2250q;
import java.util.ArrayList;
import kotlin.jvm.internal.t;

final class PoolingContainerListenerHolder {
    private final ArrayList<PoolingContainerListener> listeners = new ArrayList<>();

    public final void addListener(PoolingContainerListener poolingContainerListener) {
        t.e(poolingContainerListener, "listener");
        this.listeners.add(poolingContainerListener);
    }

    public final void onRelease() {
        for (int i5 = C2250q.i(this.listeners); -1 < i5; i5--) {
            this.listeners.get(i5).onRelease();
        }
    }

    public final void removeListener(PoolingContainerListener poolingContainerListener) {
        t.e(poolingContainerListener, "listener");
        this.listeners.remove(poolingContainerListener);
    }
}
