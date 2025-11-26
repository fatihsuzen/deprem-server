package androidx.datastore.core.handlers;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import b3.C2308e;
import java.io.IOException;
import k3.l;
import kotlin.jvm.internal.t;

public final class ReplaceFileCorruptionHandler<T> implements CorruptionHandler<T> {
    private final l produceNewData;

    public ReplaceFileCorruptionHandler(l lVar) {
        t.e(lVar, "produceNewData");
        this.produceNewData = lVar;
    }

    public Object handleCorruption(CorruptionException corruptionException, C2308e eVar) throws IOException {
        return this.produceNewData.invoke(corruptionException);
    }
}
