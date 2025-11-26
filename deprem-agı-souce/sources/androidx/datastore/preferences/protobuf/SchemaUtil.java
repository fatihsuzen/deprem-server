package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

@CheckReturnValue
final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_FULL_SCHEMA = getUnknownFieldSetSchema();
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    private SchemaUtil() {
    }

    static int computeSizeBoolList(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z4) {
            return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
        }
        return size * CodedOutputStream.computeBoolSize(i5, true);
    }

    static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    static int computeSizeByteStringList(int i5, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = size * CodedOutputStream.computeTagSize(i5);
        for (int i6 = 0; i6 < list.size(); i6++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i6));
        }
        return computeTagSize;
    }

    static int computeSizeEnumList(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeEnumListNoTag);
        }
        return computeSizeEnumListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    static int computeSizeEnumListNoTag(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += CodedOutputStream.computeEnumSizeNoTag(list.get(i5).intValue());
            i5++;
        }
        return i7;
    }

    static int computeSizeFixed32List(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z4) {
            return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 4);
        }
        return size * CodedOutputStream.computeFixed32Size(i5, 0);
    }

    static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    static int computeSizeFixed64List(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z4) {
            return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 8);
        }
        return size * CodedOutputStream.computeFixed64Size(i5, 0);
    }

    static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    static int computeSizeGroupList(int i5, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i6 += CodedOutputStream.computeGroupSize(i5, list.get(i7));
        }
        return i6;
    }

    static int computeSizeInt32List(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt32ListNoTag);
        }
        return computeSizeInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    static int computeSizeInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += CodedOutputStream.computeInt32SizeNoTag(list.get(i5).intValue());
            i5++;
        }
        return i7;
    }

    static int computeSizeInt64List(int i5, List<Long> list, boolean z4) {
        if (list.size() == 0) {
            return 0;
        }
        int computeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt64ListNoTag);
        }
        return computeSizeInt64ListNoTag + (list.size() * CodedOutputStream.computeTagSize(i5));
    }

    static int computeSizeInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += CodedOutputStream.computeInt64SizeNoTag(list.get(i5).longValue());
            i5++;
        }
        return i7;
    }

    static int computeSizeMessage(int i5, Object obj, Schema schema) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.computeLazyFieldSize(i5, (LazyFieldLite) obj);
        }
        return CodedOutputStream.computeMessageSize(i5, (MessageLite) obj, schema);
    }

    static int computeSizeMessageList(int i5, List<?> list) {
        int computeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i5) * size;
        for (int i6 = 0; i6 < size; i6++) {
            Object obj = list.get(i6);
            if (obj instanceof LazyFieldLite) {
                computeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                computeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            }
            computeTagSize += computeMessageSizeNoTag;
        }
        return computeTagSize;
    }

    static int computeSizeSInt32List(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt32ListNoTag);
        }
        return computeSizeSInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i5).intValue());
            i5++;
        }
        return i7;
    }

    static int computeSizeSInt64List(int i5, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt64ListNoTag);
        }
        return computeSizeSInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    static int computeSizeSInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i5).longValue());
            i5++;
        }
        return i7;
    }

    static int computeSizeStringList(int i5, List<?> list) {
        int computeStringSizeNoTag;
        int computeStringSizeNoTag2;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i5) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i6 < size) {
                Object raw = lazyStringList.getRaw(i6);
                if (raw instanceof ByteString) {
                    computeStringSizeNoTag2 = CodedOutputStream.computeBytesSizeNoTag((ByteString) raw);
                } else {
                    computeStringSizeNoTag2 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                computeTagSize += computeStringSizeNoTag2;
                i6++;
            }
            return computeTagSize;
        }
        while (i6 < size) {
            Object obj = list.get(i6);
            if (obj instanceof ByteString) {
                computeStringSizeNoTag = CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
            } else {
                computeStringSizeNoTag = CodedOutputStream.computeStringSizeNoTag((String) obj);
            }
            computeTagSize += computeStringSizeNoTag;
            i6++;
        }
        return computeTagSize;
    }

    static int computeSizeUInt32List(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt32ListNoTag);
        }
        return computeSizeUInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i5).intValue());
            i5++;
        }
        return i7;
    }

    static int computeSizeUInt64List(int i5, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt64ListNoTag);
        }
        return computeSizeUInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    static int computeSizeUInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int i6 = 0;
            while (i5 < size) {
                i6 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i5));
                i5++;
            }
            return i6;
        }
        int i7 = 0;
        while (i5 < size) {
            i7 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i5).longValue());
            i5++;
        }
        return i7;
    }

    @CanIgnoreReturnValue
    static <UT, UB> UB filterUnknownEnumList(Object obj, int i5, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                Integer num = list.get(i7);
                int intValue = num.intValue();
                if (enumLiteMap.findValueByNumber(intValue) != null) {
                    if (i7 != i6) {
                        list.set(i6, num);
                    }
                    i6++;
                } else {
                    ub = storeUnknownEnum(obj, i5, intValue, ub, unknownFieldSchema);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = it.next().intValue();
            if (enumLiteMap.findValueByNumber(intValue2) == null) {
                ub = storeUnknownEnum(obj, i5, intValue2, ub, unknownFieldSchema);
                it.remove();
            }
        }
        return ub;
    }

    private static Class<?> getGeneratedMessageClass() {
        if (Protobuf.assumeLiteRuntime) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return UnsafeUtil.getStaticObject(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema() {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        if (Protobuf.assumeLiteRuntime) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t5, T t6) {
        FieldSet<FT> extensions = extensionSchema.getExtensions(t6);
        if (!extensions.isEmpty()) {
            extensionSchema.getMutableExtensions(t5).mergeFrom(extensions);
        }
    }

    static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t5, T t6, long j5) {
        UnsafeUtil.putObject((Object) t5, j5, mapFieldSchema.mergeFrom(UnsafeUtil.getObject((Object) t5, j5), UnsafeUtil.getObject((Object) t6, j5)));
    }

    static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t5, T t6) {
        unknownFieldSchema.setToMessage(t5, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t5), unknownFieldSchema.getFromMessage(t6)));
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && !Protobuf.assumeLiteRuntime && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean safeEquals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static boolean shouldUseTableSwitch(int i5, int i6, int i7) {
        if (i6 < 40) {
            return true;
        }
        long j5 = ((long) i6) - ((long) i5);
        long j6 = (long) i7;
        return j5 + 10 <= ((2 * j6) + 3) + ((j6 + 3) * 3);
    }

    @CanIgnoreReturnValue
    static <UT, UB> UB storeUnknownEnum(Object obj, int i5, int i6, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.getBuilderFromMessage(obj);
        }
        unknownFieldSchema.addVarint(ub, i5, (long) i6);
        return ub;
    }

    static String toCamelCase(String str, boolean z4) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if ('a' > charAt || charAt > 'z') {
                if ('A' > charAt || charAt > 'Z') {
                    if ('0' <= charAt && charAt <= '9') {
                        sb.append(charAt);
                    }
                    z4 = true;
                } else if (i5 != 0 || z4) {
                    sb.append(charAt);
                } else {
                    sb.append((char) (charAt + ' '));
                }
            } else if (z4) {
                sb.append((char) (charAt - ' '));
            } else {
                sb.append(charAt);
            }
            z4 = false;
        }
        return sb.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetFullSchema() {
        return UNKNOWN_FIELD_SET_FULL_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int i5, boolean z4, Writer writer) throws IOException {
        if (z4) {
            writer.writeBool(i5, true);
        }
    }

    public static void writeBoolList(int i5, List<Boolean> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBoolList(i5, list, z4);
        }
    }

    public static void writeBytes(int i5, ByteString byteString, Writer writer) throws IOException {
        if (byteString != null && !byteString.isEmpty()) {
            writer.writeBytes(i5, byteString);
        }
    }

    public static void writeBytesList(int i5, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBytesList(i5, list);
        }
    }

    public static void writeDouble(int i5, double d5, Writer writer) throws IOException {
        if (Double.doubleToRawLongBits(d5) != 0) {
            writer.writeDouble(i5, d5);
        }
    }

    public static void writeDoubleList(int i5, List<Double> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeDoubleList(i5, list, z4);
        }
    }

    public static void writeEnum(int i5, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeEnum(i5, i6);
        }
    }

    public static void writeEnumList(int i5, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeEnumList(i5, list, z4);
        }
    }

    public static void writeFixed32(int i5, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeFixed32(i5, i6);
        }
    }

    public static void writeFixed32List(int i5, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed32List(i5, list, z4);
        }
    }

    public static void writeFixed64(int i5, long j5, Writer writer) throws IOException {
        if (j5 != 0) {
            writer.writeFixed64(i5, j5);
        }
    }

    public static void writeFixed64List(int i5, List<Long> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed64List(i5, list, z4);
        }
    }

    public static void writeFloat(int i5, float f5, Writer writer) throws IOException {
        if (Float.floatToRawIntBits(f5) != 0) {
            writer.writeFloat(i5, f5);
        }
    }

    public static void writeFloatList(int i5, List<Float> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFloatList(i5, list, z4);
        }
    }

    public static void writeGroupList(int i5, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeGroupList(i5, list);
        }
    }

    public static void writeInt32(int i5, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeInt32(i5, i6);
        }
    }

    public static void writeInt32List(int i5, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt32List(i5, list, z4);
        }
    }

    public static void writeInt64(int i5, long j5, Writer writer) throws IOException {
        if (j5 != 0) {
            writer.writeInt64(i5, j5);
        }
    }

    public static void writeInt64List(int i5, List<Long> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt64List(i5, list, z4);
        }
    }

    public static void writeLazyFieldList(int i5, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                ((LazyFieldLite) it.next()).writeTo(writer, i5);
            }
        }
    }

    public static void writeMessage(int i5, Object obj, Writer writer) throws IOException {
        if (obj != null) {
            writer.writeMessage(i5, obj);
        }
    }

    public static void writeMessageList(int i5, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeMessageList(i5, list);
        }
    }

    public static void writeSFixed32(int i5, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeSFixed32(i5, i6);
        }
    }

    public static void writeSFixed32List(int i5, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed32List(i5, list, z4);
        }
    }

    public static void writeSFixed64(int i5, long j5, Writer writer) throws IOException {
        if (j5 != 0) {
            writer.writeSFixed64(i5, j5);
        }
    }

    public static void writeSFixed64List(int i5, List<Long> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed64List(i5, list, z4);
        }
    }

    public static void writeSInt32(int i5, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeSInt32(i5, i6);
        }
    }

    public static void writeSInt32List(int i5, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt32List(i5, list, z4);
        }
    }

    public static void writeSInt64(int i5, long j5, Writer writer) throws IOException {
        if (j5 != 0) {
            writer.writeSInt64(i5, j5);
        }
    }

    public static void writeSInt64List(int i5, List<Long> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt64List(i5, list, z4);
        }
    }

    public static void writeString(int i5, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writeStringInternal(i5, (String) obj, writer);
        } else {
            writeBytes(i5, (ByteString) obj, writer);
        }
    }

    private static void writeStringInternal(int i5, String str, Writer writer) throws IOException {
        if (str != null && !str.isEmpty()) {
            writer.writeString(i5, str);
        }
    }

    public static void writeStringList(int i5, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeStringList(i5, list);
        }
    }

    public static void writeUInt32(int i5, int i6, Writer writer) throws IOException {
        if (i6 != 0) {
            writer.writeUInt32(i5, i6);
        }
    }

    public static void writeUInt32List(int i5, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt32List(i5, list, z4);
        }
    }

    public static void writeUInt64(int i5, long j5, Writer writer) throws IOException {
        if (j5 != 0) {
            writer.writeUInt64(i5, j5);
        }
    }

    public static void writeUInt64List(int i5, List<Long> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt64List(i5, list, z4);
        }
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    static int computeSizeGroupList(int i5, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i6 += CodedOutputStream.computeGroupSize(i5, list.get(i7), schema);
        }
        return i6;
    }

    public static void writeGroupList(int i5, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeGroupList(i5, list, schema);
        }
    }

    public static void writeMessageList(int i5, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeMessageList(i5, list, schema);
        }
    }

    static int computeSizeMessageList(int i5, List<?> list, Schema schema) {
        int computeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i5) * size;
        for (int i6 = 0; i6 < size; i6++) {
            Object obj = list.get(i6);
            if (obj instanceof LazyFieldLite) {
                computeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                computeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, schema);
            }
            computeTagSize += computeMessageSizeNoTag;
        }
        return computeTagSize;
    }

    @CanIgnoreReturnValue
    static <UT, UB> UB filterUnknownEnumList(Object obj, int i5, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                Integer num = list.get(i7);
                int intValue = num.intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i7 != i6) {
                        list.set(i6, num);
                    }
                    i6++;
                } else {
                    ub = storeUnknownEnum(obj, i5, intValue, ub, unknownFieldSchema);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = it.next().intValue();
            if (!enumVerifier.isInRange(intValue2)) {
                ub = storeUnknownEnum(obj, i5, intValue2, ub, unknownFieldSchema);
                it.remove();
            }
        }
        return ub;
    }
}
