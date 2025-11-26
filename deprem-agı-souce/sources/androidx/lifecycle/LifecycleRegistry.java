package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z3.C2974g;
import z3.D;
import z3.F;
import z3.w;

public class LifecycleRegistry extends Lifecycle {
    public static final Companion Companion = new Companion((C2633k) null);
    private final w _currentStateFlow;
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;
    private final WeakReference<LifecycleOwner> lifecycleOwner;
    private boolean newEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> observerMap;
    private ArrayList<Lifecycle.State> parentStates;
    private Lifecycle.State state;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        @VisibleForTesting
        public final LifecycleRegistry createUnsafe(LifecycleOwner lifecycleOwner) {
            t.e(lifecycleOwner, "owner");
            return new LifecycleRegistry(lifecycleOwner, false, (C2633k) null);
        }

        public final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State state, Lifecycle.State state2) {
            t.e(state, "state1");
            if (state2 == null || state2.compareTo(state) >= 0) {
                return state;
            }
            return state2;
        }

        private Companion() {
        }
    }

    public static final class ObserverWithState {
        private LifecycleEventObserver lifecycleObserver;
        private Lifecycle.State state;

        public ObserverWithState(LifecycleObserver lifecycleObserver2, Lifecycle.State state2) {
            t.e(state2, "initialState");
            t.b(lifecycleObserver2);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver2);
            this.state = state2;
        }

        public final void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            t.e(event, NotificationCompat.CATEGORY_EVENT);
            Lifecycle.State targetState = event.getTargetState();
            this.state = LifecycleRegistry.Companion.min$lifecycle_runtime_release(this.state, targetState);
            LifecycleEventObserver lifecycleEventObserver = this.lifecycleObserver;
            t.b(lifecycleOwner);
            lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
            this.state = targetState;
        }

        public final LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        public final Lifecycle.State getState() {
            return this.state;
        }

        public final void setLifecycleObserver(LifecycleEventObserver lifecycleEventObserver) {
            t.e(lifecycleEventObserver, "<set-?>");
            this.lifecycleObserver = lifecycleEventObserver;
        }

        public final void setState(Lifecycle.State state2) {
            t.e(state2, "<set-?>");
            this.state = state2;
        }
    }

    public /* synthetic */ LifecycleRegistry(LifecycleOwner lifecycleOwner2, boolean z4, C2633k kVar) {
        this(lifecycleOwner2, z4);
    }

    private final void backwardPass(LifecycleOwner lifecycleOwner2) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.observerMap.descendingIterator();
        t.d(descendingIterator, "descendingIterator(...)");
        while (descendingIterator.hasNext() && !this.newEventOccurred) {
            Map.Entry next = descendingIterator.next();
            t.b(next);
            LifecycleObserver lifecycleObserver = (LifecycleObserver) next.getKey();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.getState().compareTo(this.state) > 0 && !this.newEventOccurred && this.observerMap.contains(lifecycleObserver)) {
                Lifecycle.Event downFrom = Lifecycle.Event.Companion.downFrom(observerWithState.getState());
                if (downFrom != null) {
                    pushParentState(downFrom.getTargetState());
                    observerWithState.dispatchEvent(lifecycleOwner2, downFrom);
                    popParentState();
                } else {
                    throw new IllegalStateException("no event down from " + observerWithState.getState());
                }
            }
        }
    }

    private final Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        Lifecycle.State state2;
        ObserverWithState value;
        Map.Entry<LifecycleObserver, ObserverWithState> ceil = this.observerMap.ceil(lifecycleObserver);
        Lifecycle.State state3 = null;
        if (ceil == null || (value = ceil.getValue()) == null) {
            state2 = null;
        } else {
            state2 = value.getState();
        }
        if (!this.parentStates.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.parentStates;
            state3 = arrayList.get(arrayList.size() - 1);
        }
        Companion companion = Companion;
        return companion.min$lifecycle_runtime_release(companion.min$lifecycle_runtime_release(this.state, state2), state3);
    }

    @VisibleForTesting
    public static final LifecycleRegistry createUnsafe(LifecycleOwner lifecycleOwner2) {
        return Companion.createUnsafe(lifecycleOwner2);
    }

    private final void enforceMainThreadIfNeeded(String str) {
        if (this.enforceMainThread && !LifecycleRegistry_androidKt.isMainThread()) {
            throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
        }
    }

    private final void forwardPass(LifecycleOwner lifecycleOwner2) {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = this.observerMap.iteratorWithAdditions();
        t.d(iteratorWithAdditions, "iteratorWithAdditions(...)");
        while (iteratorWithAdditions.hasNext() && !this.newEventOccurred) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            LifecycleObserver lifecycleObserver = (LifecycleObserver) entry.getKey();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.getState().compareTo(this.state) < 0 && !this.newEventOccurred && this.observerMap.contains(lifecycleObserver)) {
                pushParentState(observerWithState.getState());
                Lifecycle.Event upFrom = Lifecycle.Event.Companion.upFrom(observerWithState.getState());
                if (upFrom != null) {
                    observerWithState.dispatchEvent(lifecycleOwner2, upFrom);
                    popParentState();
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.getState());
                }
            }
        }
    }

    private final boolean isSynced() {
        if (this.observerMap.size() == 0) {
            return true;
        }
        Map.Entry<LifecycleObserver, ObserverWithState> eldest = this.observerMap.eldest();
        t.b(eldest);
        Lifecycle.State state2 = eldest.getValue().getState();
        Map.Entry<LifecycleObserver, ObserverWithState> newest = this.observerMap.newest();
        t.b(newest);
        Lifecycle.State state3 = newest.getValue().getState();
        if (state2 == state3 && this.state == state3) {
            return true;
        }
        return false;
    }

    public static final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State state2, Lifecycle.State state3) {
        return Companion.min$lifecycle_runtime_release(state2, state3);
    }

    private final void moveToState(Lifecycle.State state2) {
        if (this.state != state2) {
            LifecycleRegistryKt.checkLifecycleStateTransition(this.lifecycleOwner.get(), this.state, state2);
            this.state = state2;
            if (this.handlingEvent || this.addingObserverCounter != 0) {
                this.newEventOccurred = true;
                return;
            }
            this.handlingEvent = true;
            sync();
            this.handlingEvent = false;
            if (this.state == Lifecycle.State.DESTROYED) {
                this.observerMap = new FastSafeIterableMap<>();
            }
        }
    }

    private final void popParentState() {
        ArrayList<Lifecycle.State> arrayList = this.parentStates;
        arrayList.remove(arrayList.size() - 1);
    }

    private final void pushParentState(Lifecycle.State state2) {
        this.parentStates.add(state2);
    }

    private final void sync() {
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner.get();
        if (lifecycleOwner2 != null) {
            while (!isSynced()) {
                this.newEventOccurred = false;
                Lifecycle.State state2 = this.state;
                Map.Entry<LifecycleObserver, ObserverWithState> eldest = this.observerMap.eldest();
                t.b(eldest);
                if (state2.compareTo(eldest.getValue().getState()) < 0) {
                    backwardPass(lifecycleOwner2);
                }
                Map.Entry<LifecycleObserver, ObserverWithState> newest = this.observerMap.newest();
                if (!this.newEventOccurred && newest != null && this.state.compareTo(newest.getValue().getState()) > 0) {
                    forwardPass(lifecycleOwner2);
                }
            }
            this.newEventOccurred = false;
            this._currentStateFlow.setValue(getCurrentState());
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
    }

    @MainThread
    public void addObserver(LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner2;
        boolean z4;
        t.e(lifecycleObserver, "observer");
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state2 = this.state;
        Lifecycle.State state3 = Lifecycle.State.DESTROYED;
        if (state2 != state3) {
            state3 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state3);
        if (this.observerMap.putIfAbsent(lifecycleObserver, observerWithState) == null && (lifecycleOwner2 = this.lifecycleOwner.get()) != null) {
            if (this.addingObserverCounter != 0 || this.handlingEvent) {
                z4 = true;
            } else {
                z4 = false;
            }
            Lifecycle.State calculateTargetState = calculateTargetState(lifecycleObserver);
            this.addingObserverCounter++;
            while (observerWithState.getState().compareTo(calculateTargetState) < 0 && this.observerMap.contains(lifecycleObserver)) {
                pushParentState(observerWithState.getState());
                Lifecycle.Event upFrom = Lifecycle.Event.Companion.upFrom(observerWithState.getState());
                if (upFrom != null) {
                    observerWithState.dispatchEvent(lifecycleOwner2, upFrom);
                    popParentState();
                    calculateTargetState = calculateTargetState(lifecycleObserver);
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.getState());
                }
            }
            if (!z4) {
                sync();
            }
            this.addingObserverCounter--;
        }
    }

    public Lifecycle.State getCurrentState() {
        return this.state;
    }

    public D getCurrentStateFlow() {
        return C2974g.a(this._currentStateFlow);
    }

    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.observerMap.size();
    }

    public void handleLifecycleEvent(Lifecycle.Event event) {
        t.e(event, NotificationCompat.CATEGORY_EVENT);
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    @MainThread
    public void markState(Lifecycle.State state2) {
        t.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
        enforceMainThreadIfNeeded("markState");
        setCurrentState(state2);
    }

    @MainThread
    public void removeObserver(LifecycleObserver lifecycleObserver) {
        t.e(lifecycleObserver, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(lifecycleObserver);
    }

    public void setCurrentState(Lifecycle.State state2) {
        t.e(state2, MRAIDCommunicatorUtil.KEY_STATE);
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state2);
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner2, boolean z4) {
        this.enforceMainThread = z4;
        this.observerMap = new FastSafeIterableMap<>();
        Lifecycle.State state2 = Lifecycle.State.INITIALIZED;
        this.state = state2;
        this.parentStates = new ArrayList<>();
        this.lifecycleOwner = new WeakReference<>(lifecycleOwner2);
        this._currentStateFlow = F.a(state2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LifecycleRegistry(LifecycleOwner lifecycleOwner2) {
        this(lifecycleOwner2, true);
        t.e(lifecycleOwner2, "provider");
    }
}
