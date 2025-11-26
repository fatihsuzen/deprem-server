package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.List;

final class ListFieldSchemaLite implements ListFieldSchema {
    ListFieldSchemaLite() {
    }

    static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j5) {
        return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j5);
    }

    public void makeImmutableListAt(Object obj, long j5) {
        getProtobufList(obj, j5).makeImmutable();
    }

    public <E> void mergeListsAt(Object obj, Object obj2, long j5) {
        Internal.ProtobufList protobufList = getProtobufList(obj, j5);
        Internal.ProtobufList protobufList2 = getProtobufList(obj2, j5);
        int size = protobufList.size();
        int size2 = protobufList2.size();
        if (size > 0 && size2 > 0) {
            if (!protobufList.isModifiable()) {
                protobufList = protobufList.mutableCopyWithCapacity(size2 + size);
            }
            protobufList.addAll(protobufList2);
        }
        if (size > 0) {
            protobufList2 = protobufList;
        }
        UnsafeUtil.putObject(obj, j5, (Object) protobufList2);
    }

    public <L> List<L> mutableListAt(Object obj, long j5) {
        int i5;
        Internal.ProtobufList protobufList = getProtobufList(obj, j5);
        if (protobufList.isModifiable()) {
            return protobufList;
        }
        int size = protobufList.size();
        if (size == 0) {
            i5 = 10;
        } else {
            i5 = size * 2;
        }
        Internal.ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(i5);
        UnsafeUtil.putObject(obj, j5, (Object) mutableCopyWithCapacity);
        return mutableCopyWithCapacity;
    }
}
