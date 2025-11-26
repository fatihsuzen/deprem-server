package androidx.datastore.core;

import b3.C2308e;
import java.io.InputStream;
import java.io.OutputStream;

public interface Serializer<T> {
    T getDefaultValue();

    Object readFrom(InputStream inputStream, C2308e eVar);

    Object writeTo(T t5, OutputStream outputStream, C2308e eVar);
}
