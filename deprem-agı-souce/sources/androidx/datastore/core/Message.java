package androidx.datastore.core;

import b3.C2312i;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2901v;

public abstract class Message<T> {

    public static final class Read<T> extends Message<T> {
        private final State<T> lastState;

        public Read(State<T> state) {
            super((C2633k) null);
            this.lastState = state;
        }

        public State<T> getLastState() {
            return this.lastState;
        }
    }

    public static final class Update<T> extends Message<T> {
        private final C2901v ack;
        private final C2312i callerContext;
        private final State<T> lastState;
        private final p transform;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Update(p pVar, C2901v vVar, State<T> state, C2312i iVar) {
            super((C2633k) null);
            t.e(pVar, "transform");
            t.e(vVar, "ack");
            t.e(iVar, "callerContext");
            this.transform = pVar;
            this.ack = vVar;
            this.lastState = state;
            this.callerContext = iVar;
        }

        public final C2901v getAck() {
            return this.ack;
        }

        public final C2312i getCallerContext() {
            return this.callerContext;
        }

        public State<T> getLastState() {
            return this.lastState;
        }

        public final p getTransform() {
            return this.transform;
        }
    }

    public /* synthetic */ Message(C2633k kVar) {
        this();
    }

    public abstract State<T> getLastState();

    private Message() {
    }
}
