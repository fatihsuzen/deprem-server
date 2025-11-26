package androidx.datastore.preferences.protobuf;

import java.util.List;

@CheckReturnValue
interface ListFieldSchema {
    void makeImmutableListAt(Object obj, long j5);

    <L> void mergeListsAt(Object obj, Object obj2, long j5);

    <L> List<L> mutableListAt(Object obj, long j5);
}
