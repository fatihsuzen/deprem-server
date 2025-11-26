package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* renamed from: androidx.datastore.preferences.protobuf.CodedOutputStreamWriter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedOutputStreamWriter.AnonymousClass1.<clinit>():void");
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        if (codedOutputStreamWriter != null) {
            return codedOutputStreamWriter;
        }
        return new CodedOutputStreamWriter(codedOutputStream);
    }

    private void writeBoolListInternal(int i5, BooleanArrayList booleanArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < booleanArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeBoolSizeNoTag(booleanArrayList.getBoolean(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < booleanArrayList.size()) {
                this.output.writeBoolNoTag(booleanArrayList.getBoolean(i6));
                i6++;
            }
            return;
        }
        while (i6 < booleanArrayList.size()) {
            this.output.writeBool(i5, booleanArrayList.getBoolean(i6));
            i6++;
        }
    }

    private <V> void writeDeterministicBooleanMapEntry(int i5, boolean z4, V v5, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.output.writeTag(i5, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z4), v5));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z4), v5);
    }

    private <V> void writeDeterministicIntegerMap(int i5, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        int i6 = 0;
        for (Integer intValue : map.keySet()) {
            iArr[i6] = intValue.intValue();
            i6++;
        }
        Arrays.sort(iArr);
        for (int i7 = 0; i7 < size; i7++) {
            int i8 = iArr[i7];
            V v5 = map.get(Integer.valueOf(i8));
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i8), v5));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i8), v5);
        }
    }

    private <V> void writeDeterministicLongMap(int i5, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        int i6 = 0;
        for (Long longValue : map.keySet()) {
            jArr[i6] = longValue.longValue();
            i6++;
        }
        Arrays.sort(jArr);
        for (int i7 = 0; i7 < size; i7++) {
            long j5 = jArr[i7];
            V v5 = map.get(Long.valueOf(j5));
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j5), v5));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j5), v5);
        }
    }

    private <K, V> void writeDeterministicMap(int i5, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v5 = map.get(Boolean.FALSE);
                if (v5 != null) {
                    writeDeterministicBooleanMapEntry(i5, false, v5, metadata);
                }
                V v6 = map.get(Boolean.TRUE);
                if (v6 != null) {
                    writeDeterministicBooleanMapEntry(i5, true, v6, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i5, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i5, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(i5, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
        }
    }

    private <V> void writeDeterministicStringMap(int i5, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        int i6 = 0;
        for (String str : map.keySet()) {
            strArr[i6] = str;
            i6++;
        }
        Arrays.sort(strArr);
        for (int i7 = 0; i7 < size; i7++) {
            String str2 = strArr[i7];
            V v5 = map.get(str2);
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str2, v5));
            MapEntryLite.writeTo(this.output, metadata, str2, v5);
        }
    }

    private void writeDoubleListInternal(int i5, DoubleArrayList doubleArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < doubleArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeDoubleSizeNoTag(doubleArrayList.getDouble(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < doubleArrayList.size()) {
                this.output.writeDoubleNoTag(doubleArrayList.getDouble(i6));
                i6++;
            }
            return;
        }
        while (i6 < doubleArrayList.size()) {
            this.output.writeDouble(i5, doubleArrayList.getDouble(i6));
            i6++;
        }
    }

    private void writeEnumListInternal(int i5, IntArrayList intArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < intArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < intArrayList.size()) {
                this.output.writeEnumNoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeEnum(i5, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeFixed32ListInternal(int i5, IntArrayList intArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < intArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeFixed32SizeNoTag(intArrayList.getInt(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < intArrayList.size()) {
                this.output.writeFixed32NoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeFixed32(i5, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeFixed64ListInternal(int i5, LongArrayList longArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < longArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeFixed64SizeNoTag(longArrayList.getLong(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < longArrayList.size()) {
                this.output.writeFixed64NoTag(longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        while (i6 < longArrayList.size()) {
            this.output.writeFixed64(i5, longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeFloatListInternal(int i5, FloatArrayList floatArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < floatArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeFloatSizeNoTag(floatArrayList.getFloat(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < floatArrayList.size()) {
                this.output.writeFloatNoTag(floatArrayList.getFloat(i6));
                i6++;
            }
            return;
        }
        while (i6 < floatArrayList.size()) {
            this.output.writeFloat(i5, floatArrayList.getFloat(i6));
            i6++;
        }
    }

    private void writeInt32ListInternal(int i5, IntArrayList intArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < intArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < intArrayList.size()) {
                this.output.writeInt32NoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeInt32(i5, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeInt64ListInternal(int i5, LongArrayList longArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < longArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < longArrayList.size()) {
                this.output.writeInt64NoTag(longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        while (i6 < longArrayList.size()) {
            this.output.writeInt64(i5, longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeLazyString(int i5, Object obj) throws IOException {
        if (obj instanceof String) {
            this.output.writeString(i5, (String) obj);
        } else {
            this.output.writeBytes(i5, (ByteString) obj);
        }
    }

    private void writeSFixed32ListInternal(int i5, IntArrayList intArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < intArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeSFixed32SizeNoTag(intArrayList.getInt(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < intArrayList.size()) {
                this.output.writeSFixed32NoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeSFixed32(i5, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeSFixed64ListInternal(int i5, LongArrayList longArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < longArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeSFixed64SizeNoTag(longArrayList.getLong(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < longArrayList.size()) {
                this.output.writeSFixed64NoTag(longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        while (i6 < longArrayList.size()) {
            this.output.writeSFixed64(i5, longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeSInt32ListInternal(int i5, IntArrayList intArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < intArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < intArrayList.size()) {
                this.output.writeSInt32NoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeSInt32(i5, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeSInt64ListInternal(int i5, LongArrayList longArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < longArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < longArrayList.size()) {
                this.output.writeSInt64NoTag(longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        while (i6 < longArrayList.size()) {
            this.output.writeSInt64(i5, longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeUInt32ListInternal(int i5, IntArrayList intArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < intArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < intArrayList.size()) {
                this.output.writeUInt32NoTag(intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        while (i6 < intArrayList.size()) {
            this.output.writeUInt32(i5, intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeUInt64ListInternal(int i5, LongArrayList longArrayList, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < longArrayList.size(); i8++) {
                i7 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i8));
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < longArrayList.size()) {
                this.output.writeUInt64NoTag(longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        while (i6 < longArrayList.size()) {
            this.output.writeUInt64(i5, longArrayList.getLong(i6));
            i6++;
        }
    }

    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    public void writeBool(int i5, boolean z4) throws IOException {
        this.output.writeBool(i5, z4);
    }

    public void writeBoolList(int i5, List<Boolean> list, boolean z4) throws IOException {
        if (list instanceof BooleanArrayList) {
            writeBoolListInternal(i5, (BooleanArrayList) list, z4);
        } else {
            writeBoolListInternal(i5, list, z4);
        }
    }

    public void writeBytes(int i5, ByteString byteString) throws IOException {
        this.output.writeBytes(i5, byteString);
    }

    public void writeBytesList(int i5, List<ByteString> list) throws IOException {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.output.writeBytes(i5, list.get(i6));
        }
    }

    public void writeDouble(int i5, double d5) throws IOException {
        this.output.writeDouble(i5, d5);
    }

    public void writeDoubleList(int i5, List<Double> list, boolean z4) throws IOException {
        if (list instanceof DoubleArrayList) {
            writeDoubleListInternal(i5, (DoubleArrayList) list, z4);
        } else {
            writeDoubleListInternal(i5, list, z4);
        }
    }

    @Deprecated
    public void writeEndGroup(int i5) throws IOException {
        this.output.writeTag(i5, 4);
    }

    public void writeEnum(int i5, int i6) throws IOException {
        this.output.writeEnum(i5, i6);
    }

    public void writeEnumList(int i5, List<Integer> list, boolean z4) throws IOException {
        if (list instanceof IntArrayList) {
            writeEnumListInternal(i5, (IntArrayList) list, z4);
        } else {
            writeEnumListInternal(i5, list, z4);
        }
    }

    public void writeFixed32(int i5, int i6) throws IOException {
        this.output.writeFixed32(i5, i6);
    }

    public void writeFixed32List(int i5, List<Integer> list, boolean z4) throws IOException {
        if (list instanceof IntArrayList) {
            writeFixed32ListInternal(i5, (IntArrayList) list, z4);
        } else {
            writeFixed32ListInternal(i5, list, z4);
        }
    }

    public void writeFixed64(int i5, long j5) throws IOException {
        this.output.writeFixed64(i5, j5);
    }

    public void writeFixed64List(int i5, List<Long> list, boolean z4) throws IOException {
        if (list instanceof LongArrayList) {
            writeFixed64ListInternal(i5, (LongArrayList) list, z4);
        } else {
            writeFixed64ListInternal(i5, list, z4);
        }
    }

    public void writeFloat(int i5, float f5) throws IOException {
        this.output.writeFloat(i5, f5);
    }

    public void writeFloatList(int i5, List<Float> list, boolean z4) throws IOException {
        if (list instanceof FloatArrayList) {
            writeFloatListInternal(i5, (FloatArrayList) list, z4);
        } else {
            writeFloatListInternal(i5, list, z4);
        }
    }

    @Deprecated
    public void writeGroup(int i5, Object obj) throws IOException {
        this.output.writeGroup(i5, (MessageLite) obj);
    }

    @Deprecated
    public void writeGroupList(int i5, List<?> list) throws IOException {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeGroup(i5, list.get(i6));
        }
    }

    public void writeInt32(int i5, int i6) throws IOException {
        this.output.writeInt32(i5, i6);
    }

    public void writeInt32List(int i5, List<Integer> list, boolean z4) throws IOException {
        if (list instanceof IntArrayList) {
            writeInt32ListInternal(i5, (IntArrayList) list, z4);
        } else {
            writeInt32ListInternal(i5, list, z4);
        }
    }

    public void writeInt64(int i5, long j5) throws IOException {
        this.output.writeInt64(i5, j5);
    }

    public void writeInt64List(int i5, List<Long> list, boolean z4) throws IOException {
        if (list instanceof LongArrayList) {
            writeInt64ListInternal(i5, (LongArrayList) list, z4);
        } else {
            writeInt64ListInternal(i5, list, z4);
        }
    }

    public <K, V> void writeMap(int i5, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i5, metadata, map);
            return;
        }
        for (Map.Entry next : map.entrySet()) {
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, next.getKey(), next.getValue()));
            MapEntryLite.writeTo(this.output, metadata, next.getKey(), next.getValue());
        }
    }

    public void writeMessage(int i5, Object obj) throws IOException {
        this.output.writeMessage(i5, (MessageLite) obj);
    }

    public void writeMessageList(int i5, List<?> list) throws IOException {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeMessage(i5, list.get(i6));
        }
    }

    public final void writeMessageSetItem(int i5, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i5, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i5, (MessageLite) obj);
        }
    }

    public void writeSFixed32(int i5, int i6) throws IOException {
        this.output.writeSFixed32(i5, i6);
    }

    public void writeSFixed32List(int i5, List<Integer> list, boolean z4) throws IOException {
        if (list instanceof IntArrayList) {
            writeSFixed32ListInternal(i5, (IntArrayList) list, z4);
        } else {
            writeSFixed32ListInternal(i5, list, z4);
        }
    }

    public void writeSFixed64(int i5, long j5) throws IOException {
        this.output.writeSFixed64(i5, j5);
    }

    public void writeSFixed64List(int i5, List<Long> list, boolean z4) throws IOException {
        if (list instanceof LongArrayList) {
            writeSFixed64ListInternal(i5, (LongArrayList) list, z4);
        } else {
            writeSFixed64ListInternal(i5, list, z4);
        }
    }

    public void writeSInt32(int i5, int i6) throws IOException {
        this.output.writeSInt32(i5, i6);
    }

    public void writeSInt32List(int i5, List<Integer> list, boolean z4) throws IOException {
        if (list instanceof IntArrayList) {
            writeSInt32ListInternal(i5, (IntArrayList) list, z4);
        } else {
            writeSInt32ListInternal(i5, list, z4);
        }
    }

    public void writeSInt64(int i5, long j5) throws IOException {
        this.output.writeSInt64(i5, j5);
    }

    public void writeSInt64List(int i5, List<Long> list, boolean z4) throws IOException {
        if (list instanceof LongArrayList) {
            writeSInt64ListInternal(i5, (LongArrayList) list, z4);
        } else {
            writeSInt64ListInternal(i5, list, z4);
        }
    }

    @Deprecated
    public void writeStartGroup(int i5) throws IOException {
        this.output.writeTag(i5, 3);
    }

    public void writeString(int i5, String str) throws IOException {
        this.output.writeString(i5, str);
    }

    public void writeStringList(int i5, List<String> list) throws IOException {
        int i6 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i6 < list.size()) {
                writeLazyString(i5, lazyStringList.getRaw(i6));
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeString(i5, list.get(i6));
            i6++;
        }
    }

    public void writeUInt32(int i5, int i6) throws IOException {
        this.output.writeUInt32(i5, i6);
    }

    public void writeUInt32List(int i5, List<Integer> list, boolean z4) throws IOException {
        if (list instanceof IntArrayList) {
            writeUInt32ListInternal(i5, (IntArrayList) list, z4);
        } else {
            writeUInt32ListInternal(i5, list, z4);
        }
    }

    public void writeUInt64(int i5, long j5) throws IOException {
        this.output.writeUInt64(i5, j5);
    }

    public void writeUInt64List(int i5, List<Long> list, boolean z4) throws IOException {
        if (list instanceof LongArrayList) {
            writeUInt64ListInternal(i5, (LongArrayList) list, z4);
        } else {
            writeUInt64ListInternal(i5, list, z4);
        }
    }

    public void writeGroup(int i5, Object obj, Schema schema) throws IOException {
        this.output.writeGroup(i5, (MessageLite) obj, schema);
    }

    public void writeMessage(int i5, Object obj, Schema schema) throws IOException {
        this.output.writeMessage(i5, (MessageLite) obj, schema);
    }

    public void writeGroupList(int i5, List<?> list, Schema schema) throws IOException {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeGroup(i5, list.get(i6), schema);
        }
    }

    public void writeMessageList(int i5, List<?> list, Schema schema) throws IOException {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeMessage(i5, list.get(i6), schema);
        }
    }

    private void writeBoolListInternal(int i5, List<Boolean> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeBoolSizeNoTag(list.get(i8).booleanValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeBoolNoTag(list.get(i6).booleanValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeBool(i5, list.get(i6).booleanValue());
            i6++;
        }
    }

    private void writeDoubleListInternal(int i5, List<Double> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeDoubleSizeNoTag(list.get(i8).doubleValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeDoubleNoTag(list.get(i6).doubleValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeDouble(i5, list.get(i6).doubleValue());
            i6++;
        }
    }

    private void writeEnumListInternal(int i5, List<Integer> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeEnumSizeNoTag(list.get(i8).intValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeEnumNoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeEnum(i5, list.get(i6).intValue());
            i6++;
        }
    }

    private void writeFixed32ListInternal(int i5, List<Integer> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeFixed32SizeNoTag(list.get(i8).intValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeFixed32NoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeFixed32(i5, list.get(i6).intValue());
            i6++;
        }
    }

    private void writeFixed64ListInternal(int i5, List<Long> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeFixed64SizeNoTag(list.get(i8).longValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeFixed64NoTag(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeFixed64(i5, list.get(i6).longValue());
            i6++;
        }
    }

    private void writeFloatListInternal(int i5, List<Float> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeFloatSizeNoTag(list.get(i8).floatValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeFloatNoTag(list.get(i6).floatValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeFloat(i5, list.get(i6).floatValue());
            i6++;
        }
    }

    private void writeInt32ListInternal(int i5, List<Integer> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeInt32SizeNoTag(list.get(i8).intValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeInt32NoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeInt32(i5, list.get(i6).intValue());
            i6++;
        }
    }

    private void writeInt64ListInternal(int i5, List<Long> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeInt64SizeNoTag(list.get(i8).longValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeInt64NoTag(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeInt64(i5, list.get(i6).longValue());
            i6++;
        }
    }

    private void writeSFixed32ListInternal(int i5, List<Integer> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i8).intValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeSFixed32NoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeSFixed32(i5, list.get(i6).intValue());
            i6++;
        }
    }

    private void writeSFixed64ListInternal(int i5, List<Long> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i8).longValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeSFixed64NoTag(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeSFixed64(i5, list.get(i6).longValue());
            i6++;
        }
    }

    private void writeSInt64ListInternal(int i5, List<Long> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i8).longValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeSInt64NoTag(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeSInt64(i5, list.get(i6).longValue());
            i6++;
        }
    }

    private void writeUInt64ListInternal(int i5, List<Long> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i8).longValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeUInt64NoTag(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeUInt64(i5, list.get(i6).longValue());
            i6++;
        }
    }

    public void writeSInt32ListInternal(int i5, List<Integer> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i8).intValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeSInt32NoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeSInt32(i5, list.get(i6).intValue());
            i6++;
        }
    }

    public void writeUInt32ListInternal(int i5, List<Integer> list, boolean z4) throws IOException {
        int i6 = 0;
        if (z4) {
            this.output.writeTag(i5, 2);
            int i7 = 0;
            for (int i8 = 0; i8 < list.size(); i8++) {
                i7 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i8).intValue());
            }
            this.output.writeUInt32NoTag(i7);
            while (i6 < list.size()) {
                this.output.writeUInt32NoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeUInt32(i5, list.get(i6).intValue());
            i6++;
        }
    }
}
