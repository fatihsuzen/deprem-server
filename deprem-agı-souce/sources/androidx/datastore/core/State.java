package androidx.datastore.core;

import kotlin.jvm.internal.C2633k;

public abstract class State<T> {
    private final int version;

    public /* synthetic */ State(int i5, C2633k kVar) {
        this(i5);
    }

    public final int getVersion() {
        return this.version;
    }

    private State(int i5) {
        this.version = i5;
    }
}
