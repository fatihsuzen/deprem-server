package androidx.lifecycle;

import W2.q;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import d3.C2344a;
import d3.C2345b;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z3.C2974g;
import z3.D;
import z3.F;
import z3.w;

public abstract class Lifecycle {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private AtomicReference<Object> internalScopeRef = new AtomicReference<>(null);

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;
        
        public static final Companion Companion = null;

        public static final class Companion {

            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
                static {
                    /*
                        androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED     // Catch:{ NoSuchFieldError -> 0x002b }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                        r2 = 4
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                    L_0x002b:
                        androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0034 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                        r2 = 5
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                    L_0x0034:
                        $EnumSwitchMapping$0 = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.Lifecycle.Event.Companion.WhenMappings.<clinit>():void");
                }
            }

            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final Event downFrom(State state) {
                t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
                int i5 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i5 == 1) {
                    return Event.ON_DESTROY;
                }
                if (i5 == 2) {
                    return Event.ON_STOP;
                }
                if (i5 != 3) {
                    return null;
                }
                return Event.ON_PAUSE;
            }

            public final Event downTo(State state) {
                t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
                int i5 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i5 == 1) {
                    return Event.ON_STOP;
                }
                if (i5 == 2) {
                    return Event.ON_PAUSE;
                }
                if (i5 != 4) {
                    return null;
                }
                return Event.ON_DESTROY;
            }

            public final Event upFrom(State state) {
                t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
                int i5 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i5 == 1) {
                    return Event.ON_START;
                }
                if (i5 == 2) {
                    return Event.ON_RESUME;
                }
                if (i5 != 5) {
                    return null;
                }
                return Event.ON_CREATE;
            }

            public final Event upTo(State state) {
                t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
                int i5 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i5 == 1) {
                    return Event.ON_CREATE;
                }
                if (i5 == 2) {
                    return Event.ON_START;
                }
                if (i5 != 3) {
                    return null;
                }
                return Event.ON_RESUME;
            }

            private Companion() {
            }
        }

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x003d }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                    r2 = 6
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
                L_0x003d:
                    androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0046 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                    r2 = 7
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
                L_0x0046:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.Lifecycle.Event.WhenMappings.<clinit>():void");
            }
        }

        static {
            Event[] $values;
            $ENTRIES = C2345b.a($values);
            Companion = new Companion((C2633k) null);
        }

        public static final Event downFrom(State state) {
            return Companion.downFrom(state);
        }

        public static final Event downTo(State state) {
            return Companion.downTo(state);
        }

        public static C2344a getEntries() {
            return $ENTRIES;
        }

        public static final Event upFrom(State state) {
            return Companion.upFrom(state);
        }

        public static final Event upTo(State state) {
            return Companion.upTo(state);
        }

        public final State getTargetState() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                case 7:
                    throw new IllegalArgumentException(this + " has no target state");
                default:
                    throw new q();
            }
        }
    }

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        static {
            State[] $values;
            $ENTRIES = C2345b.a($values);
        }

        public static C2344a getEntries() {
            return $ENTRIES;
        }

        public final boolean isAtLeast(State state) {
            t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
            if (compareTo(state) >= 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static final void _get_currentStateFlow_$lambda$0(w wVar, LifecycleOwner lifecycleOwner, Event event) {
        t.e(lifecycleOwner, "<unused var>");
        t.e(event, NotificationCompat.CATEGORY_EVENT);
        wVar.setValue(event.getTargetState());
    }

    @MainThread
    public abstract void addObserver(LifecycleObserver lifecycleObserver);

    @MainThread
    public abstract State getCurrentState();

    public D getCurrentStateFlow() {
        w a5 = F.a(getCurrentState());
        addObserver(new j(a5));
        return C2974g.a(a5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    @MainThread
    public abstract void removeObserver(LifecycleObserver lifecycleObserver);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setInternalScopeRef(AtomicReference<Object> atomicReference) {
        t.e(atomicReference, "<set-?>");
        this.internalScopeRef = atomicReference;
    }
}
