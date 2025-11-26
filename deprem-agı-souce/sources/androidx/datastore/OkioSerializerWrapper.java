package androidx.datastore;

import W2.J;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.okio.OkioSerializer;
import b3.C2308e;
import c3.C2316b;
import e4.C2357f;
import e4.C2358g;
import kotlin.jvm.internal.t;

public final class OkioSerializerWrapper<T> implements OkioSerializer<T> {
    private final Serializer<T> delegate;

    public OkioSerializerWrapper(Serializer<T> serializer) {
        t.e(serializer, "delegate");
        this.delegate = serializer;
    }

    public T getDefaultValue() {
        return this.delegate.getDefaultValue();
    }

    public Object readFrom(C2358g gVar, C2308e eVar) {
        return this.delegate.readFrom(gVar.inputStream(), eVar);
    }

    public Object writeTo(T t5, C2357f fVar, C2308e eVar) {
        Object writeTo = this.delegate.writeTo(t5, fVar.outputStream(), eVar);
        if (writeTo == C2316b.f()) {
            return writeTo;
        }
        return J.f19942a;
    }
}
