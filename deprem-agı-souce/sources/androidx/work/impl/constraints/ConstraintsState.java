package androidx.work.impl.constraints;

import kotlin.jvm.internal.C2633k;

public abstract class ConstraintsState {

    public static final class ConstraintsMet extends ConstraintsState {
        public static final ConstraintsMet INSTANCE = new ConstraintsMet();

        private ConstraintsMet() {
            super((C2633k) null);
        }
    }

    public static final class ConstraintsNotMet extends ConstraintsState {
        private final int reason;

        public ConstraintsNotMet(int i5) {
            super((C2633k) null);
            this.reason = i5;
        }

        public static /* synthetic */ ConstraintsNotMet copy$default(ConstraintsNotMet constraintsNotMet, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i5 = constraintsNotMet.reason;
            }
            return constraintsNotMet.copy(i5);
        }

        public final int component1() {
            return this.reason;
        }

        public final ConstraintsNotMet copy(int i5) {
            return new ConstraintsNotMet(i5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConstraintsNotMet) && this.reason == ((ConstraintsNotMet) obj).reason;
        }

        public final int getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason;
        }

        public String toString() {
            return "ConstraintsNotMet(reason=" + this.reason + ')';
        }
    }

    public /* synthetic */ ConstraintsState(C2633k kVar) {
        this();
    }

    private ConstraintsState() {
    }
}
