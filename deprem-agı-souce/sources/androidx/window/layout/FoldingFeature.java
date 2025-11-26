package androidx.window.layout;

import kotlin.jvm.internal.C2633k;

public interface FoldingFeature extends DisplayFeature {

    public static final class OcclusionType {
        public static final Companion Companion = new Companion((C2633k) null);
        public static final OcclusionType FULL = new OcclusionType("FULL");
        public static final OcclusionType NONE = new OcclusionType("NONE");
        private final String description;

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            private Companion() {
            }
        }

        private OcclusionType(String str) {
            this.description = str;
        }

        public String toString() {
            return this.description;
        }
    }

    public static final class Orientation {
        public static final Companion Companion = new Companion((C2633k) null);
        public static final Orientation HORIZONTAL = new Orientation("HORIZONTAL");
        public static final Orientation VERTICAL = new Orientation("VERTICAL");
        private final String description;

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            private Companion() {
            }
        }

        private Orientation(String str) {
            this.description = str;
        }

        public String toString() {
            return this.description;
        }
    }

    public static final class State {
        public static final Companion Companion = new Companion((C2633k) null);
        public static final State FLAT = new State("FLAT");
        public static final State HALF_OPENED = new State("HALF_OPENED");
        private final String description;

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            private Companion() {
            }
        }

        private State(String str) {
            this.description = str;
        }

        public String toString() {
            return this.description;
        }
    }

    OcclusionType getOcclusionType();

    Orientation getOrientation();

    State getState();

    boolean isSeparating();
}
