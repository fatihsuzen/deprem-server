package androidx.savedstate;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.t;

final /* synthetic */ class SavedStateWriterKt__SavedStateWriter_androidKt {
    public static final <T> ArrayList<T> toArrayListUnsafe(Collection<?> collection) {
        t.e(collection, "<this>");
        if (collection instanceof ArrayList) {
            return (ArrayList) collection;
        }
        return new ArrayList<>(collection);
    }
}
