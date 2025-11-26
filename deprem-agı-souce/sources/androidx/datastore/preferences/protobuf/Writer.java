package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CheckReturnValue
interface Writer {

    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    FieldOrder fieldOrder();

    void writeBool(int i5, boolean z4) throws IOException;

    void writeBoolList(int i5, List<Boolean> list, boolean z4) throws IOException;

    void writeBytes(int i5, ByteString byteString) throws IOException;

    void writeBytesList(int i5, List<ByteString> list) throws IOException;

    void writeDouble(int i5, double d5) throws IOException;

    void writeDoubleList(int i5, List<Double> list, boolean z4) throws IOException;

    @Deprecated
    void writeEndGroup(int i5) throws IOException;

    void writeEnum(int i5, int i6) throws IOException;

    void writeEnumList(int i5, List<Integer> list, boolean z4) throws IOException;

    void writeFixed32(int i5, int i6) throws IOException;

    void writeFixed32List(int i5, List<Integer> list, boolean z4) throws IOException;

    void writeFixed64(int i5, long j5) throws IOException;

    void writeFixed64List(int i5, List<Long> list, boolean z4) throws IOException;

    void writeFloat(int i5, float f5) throws IOException;

    void writeFloatList(int i5, List<Float> list, boolean z4) throws IOException;

    @Deprecated
    void writeGroup(int i5, Object obj) throws IOException;

    @Deprecated
    void writeGroup(int i5, Object obj, Schema schema) throws IOException;

    @Deprecated
    void writeGroupList(int i5, List<?> list) throws IOException;

    @Deprecated
    void writeGroupList(int i5, List<?> list, Schema schema) throws IOException;

    void writeInt32(int i5, int i6) throws IOException;

    void writeInt32List(int i5, List<Integer> list, boolean z4) throws IOException;

    void writeInt64(int i5, long j5) throws IOException;

    void writeInt64List(int i5, List<Long> list, boolean z4) throws IOException;

    <K, V> void writeMap(int i5, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException;

    void writeMessage(int i5, Object obj) throws IOException;

    void writeMessage(int i5, Object obj, Schema schema) throws IOException;

    void writeMessageList(int i5, List<?> list) throws IOException;

    void writeMessageList(int i5, List<?> list, Schema schema) throws IOException;

    void writeMessageSetItem(int i5, Object obj) throws IOException;

    void writeSFixed32(int i5, int i6) throws IOException;

    void writeSFixed32List(int i5, List<Integer> list, boolean z4) throws IOException;

    void writeSFixed64(int i5, long j5) throws IOException;

    void writeSFixed64List(int i5, List<Long> list, boolean z4) throws IOException;

    void writeSInt32(int i5, int i6) throws IOException;

    void writeSInt32List(int i5, List<Integer> list, boolean z4) throws IOException;

    void writeSInt64(int i5, long j5) throws IOException;

    void writeSInt64List(int i5, List<Long> list, boolean z4) throws IOException;

    @Deprecated
    void writeStartGroup(int i5) throws IOException;

    void writeString(int i5, String str) throws IOException;

    void writeStringList(int i5, List<String> list) throws IOException;

    void writeUInt32(int i5, int i6) throws IOException;

    void writeUInt32List(int i5, List<Integer> list, boolean z4) throws IOException;

    void writeUInt64(int i5, long j5) throws IOException;

    void writeUInt64List(int i5, List<Long> list, boolean z4) throws IOException;
}
