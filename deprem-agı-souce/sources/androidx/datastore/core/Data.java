package androidx.datastore.core;

import kotlin.jvm.internal.C2633k;

public final class Data<T> extends State<T> {
    private final int hashCode;
    private final T value;

    public Data(T t5, int i5, int i6) {
        super(i6, (C2633k) null);
        this.value = t5;
        this.hashCode = i5;
    }

    public final void checkHashCode() {
        int i5;
        T t5 = this.value;
        if (t5 != null) {
            i5 = t5.hashCode();
        } else {
            i5 = 0;
        }
        if (i5 != this.hashCode) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
        }
    }

    public final int getHashCode() {
        return this.hashCode;
    }

    public final T getValue() {
        return this.value;
    }
}
