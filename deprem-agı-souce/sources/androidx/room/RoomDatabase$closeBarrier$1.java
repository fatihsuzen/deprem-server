package androidx.room;

import k3.C2616a;
import kotlin.jvm.internal.C2639q;

/* synthetic */ class RoomDatabase$closeBarrier$1 extends C2639q implements C2616a {
    RoomDatabase$closeBarrier$1(Object obj) {
        super(0, obj, RoomDatabase.class, "onClosed", "onClosed()V", 0);
    }

    public final void invoke() {
        ((RoomDatabase) this.receiver).onClosed();
    }
}
