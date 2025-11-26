package androidx.datastore.preferences.protobuf;

import java.util.List;

public interface FieldMaskOrBuilder extends MessageLiteOrBuilder {
    String getPaths(int i5);

    ByteString getPathsBytes(int i5);

    int getPathsCount();

    List<String> getPathsList();
}
