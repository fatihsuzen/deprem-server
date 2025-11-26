package androidx.core.util;

import androidx.annotation.RequiresApi;
import b3.C2308e;
import java.util.function.Consumer;

@RequiresApi(24)
public final class ConsumerKt {
    @RequiresApi(24)
    public static final <T> Consumer<T> asConsumer(C2308e eVar) {
        return new ContinuationConsumer(eVar);
    }
}
