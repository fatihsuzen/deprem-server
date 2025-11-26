package androidx.datastore.core.handlers;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import b3.C2308e;

public final class NoOpCorruptionHandler<T> implements CorruptionHandler<T> {
    public Object handleCorruption(CorruptionException corruptionException, C2308e eVar) throws CorruptionException {
        throw corruptionException;
    }
}
