package androidx.datastore.core.okio;

import b3.C2308e;
import e4.C2357f;
import e4.C2358g;

public interface OkioSerializer<T> {
    T getDefaultValue();

    Object readFrom(C2358g gVar, C2308e eVar);

    Object writeTo(T t5, C2357f fVar, C2308e eVar);
}
