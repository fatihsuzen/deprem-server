package androidx.leanback.util;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class StateMachine {
    static final boolean DEBUG = false;
    public static final int STATUS_INVOKED = 1;
    public static final int STATUS_ZERO = 0;
    static final String TAG = "StateMachine";
    final ArrayList<State> mFinishedStates = new ArrayList<>();
    final ArrayList<State> mStates = new ArrayList<>();
    final ArrayList<State> mUnfinishedStates = new ArrayList<>();

    public static class Condition {
        final String mName;

        public Condition(String str) {
            this.mName = str;
        }

        public boolean canProceed() {
            return true;
        }
    }

    public static class Event {
        final String mName;

        public Event(String str) {
            this.mName = str;
        }
    }

    public static class State {
        final boolean mBranchEnd;
        final boolean mBranchStart;
        ArrayList<Transition> mIncomings;
        int mInvokedOutTransitions;
        final String mName;
        ArrayList<Transition> mOutgoings;
        int mStatus;

        public State(String str) {
            this(str, false, true);
        }

        /* access modifiers changed from: package-private */
        public void addIncoming(Transition transition) {
            if (this.mIncomings == null) {
                this.mIncomings = new ArrayList<>();
            }
            this.mIncomings.add(transition);
        }

        /* access modifiers changed from: package-private */
        public void addOutgoing(Transition transition) {
            if (this.mOutgoings == null) {
                this.mOutgoings = new ArrayList<>();
            }
            this.mOutgoings.add(transition);
        }

        /* access modifiers changed from: package-private */
        public final boolean checkPreCondition() {
            ArrayList<Transition> arrayList = this.mIncomings;
            if (arrayList == null) {
                return true;
            }
            if (this.mBranchEnd) {
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Transition transition = arrayList.get(i5);
                    i5++;
                    if (transition.mState != 1) {
                        return false;
                    }
                }
                return true;
            }
            int size2 = arrayList.size();
            int i6 = 0;
            while (i6 < size2) {
                Transition transition2 = arrayList.get(i6);
                i6++;
                if (transition2.mState == 1) {
                    return true;
                }
            }
            return false;
        }

        public final int getStatus() {
            return this.mStatus;
        }

        public void run() {
        }

        /* access modifiers changed from: package-private */
        public final boolean runIfNeeded() {
            if (this.mStatus == 1 || !checkPreCondition()) {
                return false;
            }
            this.mStatus = 1;
            run();
            signalAutoTransitionsAfterRun();
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void signalAutoTransitionsAfterRun() {
            Condition condition;
            ArrayList<Transition> arrayList = this.mOutgoings;
            if (arrayList != null) {
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Transition transition = arrayList.get(i5);
                    i5++;
                    Transition transition2 = transition;
                    if (transition2.mEvent == null && ((condition = transition2.mCondition) == null || condition.canProceed())) {
                        this.mInvokedOutTransitions++;
                        transition2.mState = 1;
                        if (!this.mBranchStart) {
                            return;
                        }
                    }
                }
            }
        }

        public String toString() {
            return "[" + this.mName + " " + this.mStatus + "]";
        }

        public State(String str, boolean z4, boolean z5) {
            this.mStatus = 0;
            this.mInvokedOutTransitions = 0;
            this.mName = str;
            this.mBranchStart = z4;
            this.mBranchEnd = z5;
        }
    }

    public void addState(State state) {
        if (!this.mStates.contains(state)) {
            this.mStates.add(state);
        }
    }

    public void addTransition(State state, State state2, Event event) {
        Transition transition = new Transition(state, state2, event);
        state2.addIncoming(transition);
        state.addOutgoing(transition);
    }

    public void fireEvent(Event event) {
        for (int i5 = 0; i5 < this.mFinishedStates.size(); i5++) {
            State state = this.mFinishedStates.get(i5);
            ArrayList<Transition> arrayList = state.mOutgoings;
            if (arrayList != null && (state.mBranchStart || state.mInvokedOutTransitions <= 0)) {
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    Transition transition = arrayList.get(i6);
                    i6++;
                    Transition transition2 = transition;
                    if (transition2.mState != 1 && transition2.mEvent == event) {
                        transition2.mState = 1;
                        state.mInvokedOutTransitions++;
                        if (!state.mBranchStart) {
                            break;
                        }
                    }
                }
            }
        }
        runUnfinishedStates();
    }

    public void reset() {
        this.mUnfinishedStates.clear();
        this.mFinishedStates.clear();
        ArrayList<State> arrayList = this.mStates;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            State state = arrayList.get(i5);
            i5++;
            State state2 = state;
            state2.mStatus = 0;
            state2.mInvokedOutTransitions = 0;
            ArrayList<Transition> arrayList2 = state2.mOutgoings;
            if (arrayList2 != null) {
                int size2 = arrayList2.size();
                int i6 = 0;
                while (i6 < size2) {
                    Transition transition = arrayList2.get(i6);
                    i6++;
                    transition.mState = 0;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void runUnfinishedStates() {
        boolean z4;
        do {
            z4 = false;
            for (int size = this.mUnfinishedStates.size() - 1; size >= 0; size--) {
                State state = this.mUnfinishedStates.get(size);
                if (state.runIfNeeded()) {
                    this.mUnfinishedStates.remove(size);
                    this.mFinishedStates.add(state);
                    z4 = true;
                }
            }
        } while (z4);
    }

    public void start() {
        this.mUnfinishedStates.addAll(this.mStates);
        runUnfinishedStates();
    }

    public void addTransition(State state, State state2, Condition condition) {
        Transition transition = new Transition(state, state2, condition);
        state2.addIncoming(transition);
        state.addOutgoing(transition);
    }

    static class Transition {
        final Condition mCondition;
        final Event mEvent;
        final State mFromState;
        int mState = 0;
        final State mToState;

        Transition(State state, State state2, Event event) {
            if (event != null) {
                this.mFromState = state;
                this.mToState = state2;
                this.mEvent = event;
                this.mCondition = null;
                return;
            }
            throw new IllegalArgumentException();
        }

        public String toString() {
            String str;
            Event event = this.mEvent;
            if (event != null) {
                str = event.mName;
            } else {
                Condition condition = this.mCondition;
                if (condition != null) {
                    str = condition.mName;
                } else {
                    str = "auto";
                }
            }
            return "[" + this.mFromState.mName + " -> " + this.mToState.mName + " <" + str + ">]";
        }

        Transition(State state, State state2) {
            this.mFromState = state;
            this.mToState = state2;
            this.mEvent = null;
            this.mCondition = null;
        }

        Transition(State state, State state2, Condition condition) {
            if (condition != null) {
                this.mFromState = state;
                this.mToState = state2;
                this.mEvent = null;
                this.mCondition = condition;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public void addTransition(State state, State state2) {
        Transition transition = new Transition(state, state2);
        state2.addIncoming(transition);
        state.addOutgoing(transition);
    }
}
