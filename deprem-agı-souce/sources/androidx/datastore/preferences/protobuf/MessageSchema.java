package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final ProtoSyntax syntax;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;

    /* renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
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
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.AnonymousClass1.<clinit>():void");
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i5, int i6, MessageLite messageLite, ProtoSyntax protoSyntax, boolean z4, int[] iArr2, int i7, int i8, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i5;
        this.maxFieldNumber = i6;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.syntax = protoSyntax;
        this.hasExtensions = extensionSchema2 != null && extensionSchema2.hasExtensions(messageLite);
        this.useCachedSizeField = z4;
        this.intArray = iArr2;
        this.checkInitializedCount = i7;
        this.repeatedFieldOffsetStart = i8;
        this.newInstanceSchema = newInstanceSchema2;
        this.listFieldSchema = listFieldSchema2;
        this.unknownFieldSchema = unknownFieldSchema2;
        this.extensionSchema = extensionSchema2;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema2;
    }

    private boolean arePresentForEquals(T t5, T t6, int i5) {
        if (isFieldPresent(t5, i5) == isFieldPresent(t6, i5)) {
            return true;
        }
        return false;
    }

    private static <T> boolean booleanAt(T t5, long j5) {
        return UnsafeUtil.getBoolean((Object) t5, j5);
    }

    private static void checkMutable(Object obj) {
        if (!isMutable(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: " + obj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K, V> int decodeMapEntry(byte[] r11, int r12, int r13, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata<K, V> r14, java.util.Map<K, V> r15, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r16) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r16
            int r12 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r11, r12, r6)
            int r0 = r6.int1
            if (r0 < 0) goto L_0x006f
            int r1 = r13 - r12
            if (r0 > r1) goto L_0x006f
            int r7 = r12 + r0
            K r0 = r14.defaultKey
            V r1 = r14.defaultValue
            r8 = r0
            r9 = r1
        L_0x0016:
            if (r12 >= r7) goto L_0x0064
            int r0 = r12 + 1
            byte r12 = r11[r12]
            if (r12 >= 0) goto L_0x0024
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r12, r11, r0, r6)
            int r12 = r6.int1
        L_0x0024:
            r2 = r0
            int r0 = r12 >>> 3
            r1 = r12 & 7
            r3 = 1
            if (r0 == r3) goto L_0x004a
            r3 = 2
            if (r0 == r3) goto L_0x0030
            goto L_0x005f
        L_0x0030:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r0 = r14.valueType
            int r0 = r0.getWireType()
            if (r1 != r0) goto L_0x005f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r14.valueType
            V r12 = r14.defaultValue
            java.lang.Class r5 = r12.getClass()
            r0 = r10
            r1 = r11
            r3 = r13
            int r12 = r0.decodeMapEntryValue(r1, r2, r3, r4, r5, r6)
            java.lang.Object r9 = r6.object1
            goto L_0x0016
        L_0x004a:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r0 = r14.keyType
            int r0 = r0.getWireType()
            if (r1 != r0) goto L_0x005f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r14.keyType
            r5 = 0
            r0 = r10
            r1 = r11
            r3 = r13
            int r12 = r0.decodeMapEntryValue(r1, r2, r3, r4, r5, r6)
            java.lang.Object r8 = r6.object1
            goto L_0x0016
        L_0x005f:
            int r12 = androidx.datastore.preferences.protobuf.ArrayDecoders.skipField(r12, r11, r2, r13, r6)
            goto L_0x0016
        L_0x0064:
            if (r12 != r7) goto L_0x006a
            r15.put(r8, r9)
            return r7
        L_0x006a:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r11 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r11
        L_0x006f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r11 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.decodeMapEntry(byte[], int, int, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, java.util.Map, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    private int decodeMapEntryValue(byte[] bArr, int i5, int i6, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        boolean z4;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i5, registers);
                if (registers.long1 != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                registers.object1 = Boolean.valueOf(z4);
                return decodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i5, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i5));
                return i5 + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i5));
                return i5 + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i5));
                return i5 + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i5));
                return i5 + 4;
            case 9:
            case 10:
            case 11:
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i5, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return decodeVarint32;
            case 12:
            case 13:
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i5, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return decodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(cls), bArr, i5, i6, registers);
            case 15:
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i5, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return decodeVarint322;
            case 16:
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i5, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return decodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i5, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t5, long j5) {
        return UnsafeUtil.getDouble((Object) t5, j5);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i5, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i5);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i5)));
        if (object == null || (enumFieldVerifier = getEnumFieldVerifier(i5)) == null) {
            return ub;
        }
        return filterUnknownEnumMap(i5, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema2, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i5, int i6, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2, Object obj) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i5));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema2.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema2.addLengthDelimited(ub, i6, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e5) {
                    throw new RuntimeException(e5);
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t5, long j5) {
        return UnsafeUtil.getFloat((Object) t5, j5);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i5) {
        return (Internal.EnumVerifier) this.objects[((i5 / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i5) {
        return this.objects[(i5 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i5) {
        int i6 = (i5 / 3) * 2;
        Schema schema = (Schema) this.objects[i6];
        if (schema != null) {
            return schema;
        }
        Schema schemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i6 + 1]);
        this.objects[i6] = schemaFor;
        return schemaFor;
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t5) {
        return unknownFieldSchema2.getSerializedSize(unknownFieldSchema2.getFromMessage(t5));
    }

    private static <T> int intAt(T t5, long j5) {
        return UnsafeUtil.getInt((Object) t5, j5);
    }

    private static boolean isEnforceUtf8(int i5) {
        return (i5 & ENFORCE_UTF8_MASK) != 0;
    }

    private boolean isFieldPresent(T t5, int i5, int i6, int i7, int i8) {
        if (i6 == 1048575) {
            return isFieldPresent(t5, i5);
        }
        return (i7 & i8) != 0;
    }

    private static boolean isLegacyEnumIsClosed(int i5) {
        return (i5 & Integer.MIN_VALUE) != 0;
    }

    private <N> boolean isListInitialized(Object obj, int i5, int i6) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i5));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i6);
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (!messageFieldSchema.isInitialized(list.get(i7))) {
                return false;
            }
        }
        return true;
    }

    private boolean isMapInitialized(T t5, int i5, int i6) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject((Object) t5, offset(i5)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i6)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<?> schema = null;
        for (Object next : forMapData.values()) {
            if (schema == null) {
                schema = Protobuf.getInstance().schemaFor(next.getClass());
            }
            if (!schema.isInitialized(next)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t5, T t6, int i5) {
        long presenceMaskAndOffsetAt = (long) (presenceMaskAndOffsetAt(i5) & 1048575);
        if (UnsafeUtil.getInt((Object) t5, presenceMaskAndOffsetAt) == UnsafeUtil.getInt((Object) t6, presenceMaskAndOffsetAt)) {
            return true;
        }
        return false;
    }

    private boolean isOneofPresent(T t5, int i5, int i6) {
        if (UnsafeUtil.getInt((Object) t5, (long) (presenceMaskAndOffsetAt(i6) & 1048575)) == i5) {
            return true;
        }
        return false;
    }

    private static boolean isRequired(int i5) {
        return (i5 & REQUIRED_MASK) != 0;
    }

    private static <T> long longAt(T t5, long j5) {
        return UnsafeUtil.getLong((Object) t5, j5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v69, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v70, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v71, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v72, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v73, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v74, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v75, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v76, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v77, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v78, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v79, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v80, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v81, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v82, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v83, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v84, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v85, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v87, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v88, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v89, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02aa, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02ab, code lost:
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02af, code lost:
        r2 = r20;
        r4 = r21;
        r6 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02cd, code lost:
        r6 = r22;
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02d0, code lost:
        r1 = r7;
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x035c, code lost:
        r6 = r22;
        r1 = r7;
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0387, code lost:
        r12 = r18;
        r6 = r22;
        r11 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x04bf, code lost:
        r6 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x04c3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x04ef, code lost:
        r6 = r22;
        r1 = r7;
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x06fb, code lost:
        if (r4.skipField() == false) goto L_0x06fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x06fd, code lost:
        r0 = r1.checkInitializedCount;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0702, code lost:
        if (r0 < r1.repeatedFieldOffsetStart) goto L_0x0704;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0704, code lost:
        r4 = r1.filterMapUnknownEnumValues(r2, r1.intArray[r0], r4, r12, r20);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0712, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x071a, code lost:
        if (r5 == null) goto L_0x071c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:?, code lost:
        r5 = r12.getBuilderFromMessage(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x0726, code lost:
        if (r12.mergeOneFieldFrom(r5, r4, 0) == false) goto L_0x0728;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0728, code lost:
        r0 = r1.checkInitializedCount;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x072d, code lost:
        if (r0 < r1.repeatedFieldOffsetStart) goto L_0x072f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x072f, code lost:
        r4 = r1.filterMapUnknownEnumValues(r2, r1.intArray[r0], r4, r12, r20);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x073d, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0741, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x0752, code lost:
        r4 = r1.filterMapUnknownEnumValues(r2, r1.intArray[r7], r4, r12, r20);
        r7 = r7 + 1;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0765, code lost:
        r5.setBuilderToMessage(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a8, code lost:
        r0 = r10.checkInitializedCount;
        r4 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ad, code lost:
        if (r0 >= r10.repeatedFieldOffsetStart) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00af, code lost:
        r4 = r10.filterMapUnknownEnumValues(r2, r10.intArray[r0], r4, r5, r20);
        r7 = r2;
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00be, code lost:
        r7 = r2;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c0, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c2, code lost:
        r5.setBuilderToMessage(r7, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x011b, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[ExcHandler: InvalidWireTypeException (unused androidx.datastore.preferences.protobuf.InvalidProtocolBufferException$InvalidWireTypeException), PHI: r12 
      PHI: (r12v67 androidx.datastore.preferences.protobuf.UnknownFieldSchema) = (r12v66 androidx.datastore.preferences.protobuf.UnknownFieldSchema), (r12v68 androidx.datastore.preferences.protobuf.UnknownFieldSchema), (r12v68 androidx.datastore.preferences.protobuf.UnknownFieldSchema) binds: [B:130:0x02b8, B:122:0x0297, B:123:?] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:122:0x0297] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x04c3 A[Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }, ExcHandler: all (th java.lang.Throwable), PHI: r2 r7 r12 
      PHI: (r2v35 T) = (r2v33 T), (r2v36 T) binds: [B:224:0x04e0, B:215:0x04b2] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r7v8 androidx.datastore.preferences.protobuf.MessageSchema) = (r7v6 androidx.datastore.preferences.protobuf.MessageSchema), (r7v10 androidx.datastore.preferences.protobuf.MessageSchema) binds: [B:224:0x04e0, B:215:0x04b2] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r12v36 androidx.datastore.preferences.protobuf.UnknownFieldSchema) = (r12v34 androidx.datastore.preferences.protobuf.UnknownFieldSchema), (r12v37 androidx.datastore.preferences.protobuf.UnknownFieldSchema) binds: [B:224:0x04e0, B:215:0x04b2] A[DONT_GENERATE, DONT_INLINE], Splitter:B:215:0x04b2] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x06f7 A[Catch:{ all -> 0x0718 }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x071a  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0752 A[LOOP:6: B:292:0x074e->B:294:0x0752, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0765  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <UT, UB, ET extends androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB> r18, androidx.datastore.preferences.protobuf.ExtensionSchema<ET> r19, T r20, androidx.datastore.preferences.protobuf.Reader r21, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r22) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r4 = r22
            r0 = 0
            r5 = 0
        L_0x0006:
            int r2 = r21.getFieldNumber()     // Catch:{ all -> 0x0744 }
            int r3 = r1.positionForFieldNumber(r2)     // Catch:{ all -> 0x0744 }
            r9 = 0
            if (r3 >= 0) goto L_0x00d4
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x003f
            int r0 = r1.checkInitializedCount
            r4 = r5
        L_0x0019:
            int r2 = r1.repeatedFieldOffsetStart
            if (r0 >= r2) goto L_0x0032
            int[] r2 = r1.intArray
            r3 = r2[r0]
            r6 = r20
            r5 = r18
            r2 = r20
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            r10 = r1
            r1 = r2
            r6 = r5
            int r0 = r0 + 1
            r1 = r10
            goto L_0x0019
        L_0x0032:
            r6 = r18
            r10 = r1
            r1 = r20
            if (r4 == 0) goto L_0x003c
            r6.setBuilderToMessage(r1, r4)
        L_0x003c:
            r1 = r10
            goto L_0x0740
        L_0x003f:
            r6 = r18
            r10 = r1
            r1 = r20
            boolean r3 = r10.hasExtensions     // Catch:{ all -> 0x00cc }
            if (r3 != 0) goto L_0x004c
            r7 = r19
            r3 = 0
            goto L_0x0055
        L_0x004c:
            androidx.datastore.preferences.protobuf.MessageLite r3 = r10.defaultInstance     // Catch:{ all -> 0x00cc }
            r7 = r19
            java.lang.Object r2 = r7.findExtensionByNumber(r4, r3, r2)     // Catch:{ all -> 0x00cc }
            r3 = r2
        L_0x0055:
            if (r3 == 0) goto L_0x0081
            if (r0 != 0) goto L_0x005d
            androidx.datastore.preferences.protobuf.FieldSet r0 = r19.getMutableExtensions(r20)     // Catch:{ all -> 0x0065 }
        L_0x005d:
            r2 = r5
            r5 = r0
            r0 = r7
            r7 = r6
            r6 = r2
            r2 = r21
            goto L_0x006b
        L_0x0065:
            r0 = move-exception
            r2 = r1
            r12 = r6
            r1 = r10
            goto L_0x074a
        L_0x006b:
            java.lang.Object r3 = r0.parseExtension(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0078 }
            r6 = r4
            r0 = r5
            r5 = r7
            r4 = r2
            r2 = r1
            r5 = r3
            r4 = r6
            r1 = r10
            goto L_0x0006
        L_0x0078:
            r0 = move-exception
            r2 = r1
            r11 = r6
            r5 = r7
        L_0x007c:
            r12 = r5
            r1 = r10
        L_0x007e:
            r5 = r11
            goto L_0x074a
        L_0x0081:
            r2 = r1
            r11 = r5
            r5 = r6
            r6 = r4
            r4 = r21
            boolean r1 = r5.shouldDiscardUnknownFields(r4)     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x009a
            boolean r1 = r4.skipField()     // Catch:{ all -> 0x0098 }
            if (r1 == 0) goto L_0x00a8
        L_0x0093:
            r4 = r6
            r1 = r10
            r5 = r11
            goto L_0x0006
        L_0x0098:
            r0 = move-exception
            goto L_0x007c
        L_0x009a:
            if (r11 != 0) goto L_0x00a1
            java.lang.Object r1 = r5.getBuilderFromMessage(r2)     // Catch:{ all -> 0x0098 }
            r11 = r1
        L_0x00a1:
            boolean r1 = r5.mergeOneFieldFrom(r11, r4, r9)     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x00a8
            goto L_0x0093
        L_0x00a8:
            int r0 = r10.checkInitializedCount
            r4 = r11
        L_0x00ab:
            int r1 = r10.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x00be
            int[] r1 = r10.intArray
            r3 = r1[r0]
            r6 = r20
            r1 = r10
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            r7 = r2
            int r0 = r0 + 1
            goto L_0x00ab
        L_0x00be:
            r7 = r2
            r1 = r10
            if (r4 == 0) goto L_0x0740
            r5.setBuilderToMessage(r7, r4)
            goto L_0x0740
        L_0x00c7:
            r0 = move-exception
            r7 = r2
            r1 = r10
            r12 = r5
            goto L_0x007e
        L_0x00cc:
            r0 = move-exception
            r7 = r1
            r11 = r5
            r5 = r6
            r1 = r10
        L_0x00d1:
            r12 = r5
        L_0x00d2:
            r2 = r7
            goto L_0x007e
        L_0x00d4:
            r7 = r20
            r6 = r4
            r11 = r5
            r5 = r18
            r4 = r21
            int r10 = r1.typeAndOffsetAt(r3)     // Catch:{ all -> 0x00ef }
            int r12 = type(r10)     // Catch:{ InvalidWireTypeException -> 0x00f1 }
            switch(r12) {
                case 0: goto L_0x06de;
                case 1: goto L_0x06cb;
                case 2: goto L_0x06b8;
                case 3: goto L_0x06a5;
                case 4: goto L_0x0692;
                case 5: goto L_0x067f;
                case 6: goto L_0x066c;
                case 7: goto L_0x0659;
                case 8: goto L_0x064e;
                case 9: goto L_0x063a;
                case 10: goto L_0x0627;
                case 11: goto L_0x0614;
                case 12: goto L_0x05ed;
                case 13: goto L_0x05da;
                case 14: goto L_0x05c7;
                case 15: goto L_0x05b4;
                case 16: goto L_0x05a1;
                case 17: goto L_0x058d;
                case 18: goto L_0x057b;
                case 19: goto L_0x0569;
                case 20: goto L_0x0557;
                case 21: goto L_0x0545;
                case 22: goto L_0x0533;
                case 23: goto L_0x0521;
                case 24: goto L_0x050f;
                case 25: goto L_0x04fd;
                case 26: goto L_0x04f5;
                case 27: goto L_0x04dc;
                case 28: goto L_0x04ca;
                case 29: goto L_0x04ae;
                case 30: goto L_0x0473;
                case 31: goto L_0x0460;
                case 32: goto L_0x044d;
                case 33: goto L_0x043a;
                case 34: goto L_0x0427;
                case 35: goto L_0x0414;
                case 36: goto L_0x0401;
                case 37: goto L_0x03ef;
                case 38: goto L_0x03dd;
                case 39: goto L_0x03cb;
                case 40: goto L_0x03b9;
                case 41: goto L_0x03a7;
                case 42: goto L_0x0395;
                case 43: goto L_0x0376;
                case 44: goto L_0x033b;
                case 45: goto L_0x0328;
                case 46: goto L_0x0315;
                case 47: goto L_0x0302;
                case 48: goto L_0x02e5;
                case 49: goto L_0x02b7;
                case 50: goto L_0x0296;
                case 51: goto L_0x0281;
                case 52: goto L_0x026c;
                case 53: goto L_0x0257;
                case 54: goto L_0x0242;
                case 55: goto L_0x022d;
                case 56: goto L_0x0218;
                case 57: goto L_0x0203;
                case 58: goto L_0x01ee;
                case 59: goto L_0x01e5;
                case 60: goto L_0x01d2;
                case 61: goto L_0x01c1;
                case 62: goto L_0x01ac;
                case 63: goto L_0x0183;
                case 64: goto L_0x016f;
                case 65: goto L_0x015b;
                case 66: goto L_0x0147;
                case 67: goto L_0x0133;
                case 68: goto L_0x011f;
                default: goto L_0x00e7;
            }     // Catch:{ InvalidWireTypeException -> 0x00f1 }
        L_0x00e7:
            if (r11 != 0) goto L_0x00f6
            java.lang.Object r2 = r5.getBuilderFromMessage(r7)     // Catch:{ InvalidWireTypeException -> 0x00f1 }
            r11 = r2
            goto L_0x00f6
        L_0x00ef:
            r0 = move-exception
            goto L_0x00d1
        L_0x00f1:
            r12 = r5
        L_0x00f2:
            r2 = r7
        L_0x00f3:
            r5 = r11
            goto L_0x06f1
        L_0x00f6:
            boolean r2 = r5.mergeOneFieldFrom(r11, r4, r9)     // Catch:{ InvalidWireTypeException -> 0x00f1 }
            if (r2 != 0) goto L_0x011a
            int r0 = r1.checkInitializedCount
            r4 = r11
        L_0x00ff:
            int r2 = r1.repeatedFieldOffsetStart
            if (r0 >= r2) goto L_0x0112
            int[] r2 = r1.intArray
            r3 = r2[r0]
            r6 = r20
            r2 = r7
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            r12 = r5
            int r0 = r0 + 1
            goto L_0x00ff
        L_0x0112:
            r12 = r5
            if (r4 == 0) goto L_0x0740
            r12.setBuilderToMessage(r7, r4)
            goto L_0x0740
        L_0x011a:
            r12 = r5
        L_0x011b:
            r2 = r7
        L_0x011c:
            r5 = r11
            goto L_0x0741
        L_0x011f:
            r12 = r5
            java.lang.Object r5 = r1.mutableOneofMessageFieldForMerge(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.Schema r10 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r4.mergeGroupField(r5, r10, r6)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.storeOneofMessageField(r7, r2, r3, r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0131:
            r0 = move-exception
            goto L_0x00d2
        L_0x0133:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            long r15 = r4.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0147:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            int r5 = r4.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x015b:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            long r15 = r4.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x016f:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            int r5 = r4.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0183:
            r12 = r5
            int r5 = r4.readEnum()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r13 = r1.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            if (r13 == 0) goto L_0x019c
            boolean r13 = r13.isInRange(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            if (r13 == 0) goto L_0x0195
            goto L_0x019c
        L_0x0195:
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.SchemaUtil.storeUnknownEnum(r7, r2, r5, r11, r12)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r2 = r7
            goto L_0x0741
        L_0x019c:
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x01ac:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            int r5 = r4.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x01c1:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.ByteString r5 = r4.readBytes()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x01d2:
            r12 = r5
            java.lang.Object r5 = r1.mutableOneofMessageFieldForMerge(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.Schema r10 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r4.mergeMessageField(r5, r10, r6)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.storeOneofMessageField(r7, r2, r3, r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x01e5:
            r12 = r5
            r1.readString(r7, r10, r4)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x01ee:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            boolean r5 = r4.readBool()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0203:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            int r5 = r4.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0218:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            long r15 = r4.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x022d:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            int r5 = r4.readInt32()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0242:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            long r15 = r4.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0257:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            long r15 = r4.readInt64()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x026c:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            float r5 = r4.readFloat()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0281:
            r12 = r5
            long r13 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            double r15 = r4.readDouble()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Double r5 = java.lang.Double.valueOf(r15)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r13, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0296:
            r12 = r5
            java.lang.Object r4 = r1.getMapFieldDefaultEntry(r3)     // Catch:{ InvalidWireTypeException -> 0x02af, all -> 0x02aa }
            r5 = r6
            r2 = r7
            r6 = r21
            r1.mergeMap(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x02af, all -> 0x02aa }
            r2 = r20
            r4 = r21
            r6 = r22
            goto L_0x011c
        L_0x02aa:
            r0 = move-exception
            r2 = r20
            goto L_0x007e
        L_0x02af:
            r2 = r20
            r4 = r21
            r6 = r22
            goto L_0x00f3
        L_0x02b7:
            r12 = r5
            long r4 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x02af, all -> 0x02df }
            androidx.datastore.preferences.protobuf.Schema r6 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x02af, all -> 0x02df }
            r2 = r20
            r7 = r22
            r3 = r4
            r5 = r21
            r1.readGroupList(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x02da, all -> 0x02d4 }
            r7 = r1
            r1 = r2
            r13 = r5
        L_0x02cd:
            r6 = r22
            r2 = r1
        L_0x02d0:
            r1 = r7
            r4 = r13
            goto L_0x011c
        L_0x02d4:
            r0 = move-exception
            r7 = r1
            r1 = r2
        L_0x02d7:
            r1 = r7
            goto L_0x007e
        L_0x02da:
            r6 = r22
            r4 = r5
            goto L_0x00f3
        L_0x02df:
            r0 = move-exception
            r7 = r1
            r1 = r20
        L_0x02e3:
            r2 = r1
            goto L_0x02d7
        L_0x02e5:
            r12 = r7
            r7 = r1
            r1 = r12
            r13 = r4
            r12 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            r13.readSInt64List(r2)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            goto L_0x02cd
        L_0x02f8:
            r0 = move-exception
            goto L_0x02e3
        L_0x02fa:
            r6 = r22
            r2 = r1
        L_0x02fd:
            r1 = r7
            r5 = r11
        L_0x02ff:
            r4 = r13
            goto L_0x06f1
        L_0x0302:
            r12 = r7
            r7 = r1
            r1 = r12
            r13 = r4
            r12 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            r13.readSInt32List(r2)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            goto L_0x02cd
        L_0x0315:
            r12 = r7
            r7 = r1
            r1 = r12
            r13 = r4
            r12 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            r13.readSFixed64List(r2)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            goto L_0x02cd
        L_0x0328:
            r12 = r7
            r7 = r1
            r1 = r12
            r13 = r4
            r12 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            r13.readSFixed32List(r2)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            goto L_0x02cd
        L_0x033b:
            r12 = r7
            r7 = r1
            r1 = r12
            r13 = r4
            r12 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r4 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0374, all -> 0x0370 }
            long r5 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0374, all -> 0x0370 }
            java.util.List r4 = r4.mutableListAt(r1, r5)     // Catch:{ InvalidWireTypeException -> 0x0374, all -> 0x0370 }
            r13.readEnumList(r4)     // Catch:{ InvalidWireTypeException -> 0x0374, all -> 0x0370 }
            r5 = r4
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r4 = r7.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x0374, all -> 0x0370 }
            r3 = r5
            r5 = r11
            r6 = r12
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.SchemaUtil.filterUnknownEnumList((java.lang.Object) r1, (int) r2, (java.util.List<java.lang.Integer>) r3, (androidx.datastore.preferences.protobuf.Internal.EnumVerifier) r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0369, all -> 0x0362 }
            r2 = r1
            r12 = r18
        L_0x035c:
            r6 = r22
            r1 = r7
            r4 = r13
            goto L_0x0741
        L_0x0362:
            r0 = move-exception
            r2 = r1
        L_0x0364:
            r12 = r18
        L_0x0366:
            r1 = r7
            goto L_0x074a
        L_0x0369:
            r12 = r18
        L_0x036b:
            r6 = r22
            r2 = r1
        L_0x036e:
            r1 = r7
            goto L_0x02ff
        L_0x0370:
            r0 = move-exception
            r2 = r1
            r5 = r11
            goto L_0x0364
        L_0x0374:
            r5 = r11
            goto L_0x0369
        L_0x0376:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
        L_0x0387:
            r12 = r18
            r6 = r22
            r11 = r5
            goto L_0x02d0
        L_0x038e:
            r0 = move-exception
            goto L_0x0364
        L_0x0390:
            r12 = r18
        L_0x0392:
            r6 = r22
            goto L_0x036e
        L_0x0395:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x03a7:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x03b9:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x03cb:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x03dd:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x03ef:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x0401:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x0414:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x0427:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x043a:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x044d:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x0460:
            r13 = r4
            r2 = r7
            r5 = r11
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r13.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x0473:
            r5 = r7
            r7 = r1
            r1 = r2
            r2 = r5
            r13 = r4
            r5 = r11
            androidx.datastore.preferences.protobuf.ListFieldSchema r4 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x04a9, all -> 0x04a3 }
            long r10 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x04a9, all -> 0x04a3 }
            java.util.List r4 = r4.mutableListAt(r2, r10)     // Catch:{ InvalidWireTypeException -> 0x04a9, all -> 0x04a3 }
            r13.readEnumList(r4)     // Catch:{ InvalidWireTypeException -> 0x04a9, all -> 0x04a3 }
            r6 = r4
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r4 = r7.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x04a9, all -> 0x04a3 }
            r3 = r2
            r2 = r1
            r1 = r3
            r3 = r6
            r6 = r18
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.SchemaUtil.filterUnknownEnumList((java.lang.Object) r1, (int) r2, (java.util.List<java.lang.Integer>) r3, (androidx.datastore.preferences.protobuf.Internal.EnumVerifier) r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x049f, all -> 0x0499 }
            r2 = r1
            r12 = r6
            goto L_0x035c
        L_0x0499:
            r0 = move-exception
            r2 = r1
            r11 = r5
            r12 = r6
            goto L_0x0366
        L_0x049f:
            r11 = r5
            r12 = r6
            goto L_0x036b
        L_0x04a3:
            r0 = move-exception
            r12 = r18
            r11 = r5
            goto L_0x0366
        L_0x04a9:
            r12 = r18
            r11 = r5
            goto L_0x0392
        L_0x04ae:
            r13 = r4
            r12 = r5
            r2 = r7
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            r13.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
        L_0x04bf:
            r6 = r22
            goto L_0x02d0
        L_0x04c3:
            r0 = move-exception
            goto L_0x02d7
        L_0x04c6:
            r6 = r22
            goto L_0x02fd
        L_0x04ca:
            r13 = r4
            r12 = r5
            r2 = r7
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            long r3 = offset(r10)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            r13.readBytesList(r1)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            goto L_0x04bf
        L_0x04dc:
            r13 = r4
            r12 = r5
            r2 = r7
            r7 = r1
            androidx.datastore.preferences.protobuf.Schema r5 = r7.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x04ef, all -> 0x04c3 }
            r6 = r22
            r3 = r10
            r1.readMessageList(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x04ec:
            r0 = move-exception
            goto L_0x007e
        L_0x04ef:
            r6 = r22
            r1 = r7
            r4 = r13
            goto L_0x00f3
        L_0x04f5:
            r12 = r5
            r2 = r7
            r5 = r10
            r1.readStringList(r2, r5, r4)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x04fd:
            r12 = r5
            r2 = r7
            r5 = r10
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readBoolList(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x050f:
            r12 = r5
            r2 = r7
            r5 = r10
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readFixed32List(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0521:
            r12 = r5
            r2 = r7
            r5 = r10
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readFixed64List(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0533:
            r12 = r5
            r2 = r7
            r5 = r10
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readInt32List(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0545:
            r12 = r5
            r2 = r7
            r5 = r10
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readUInt64List(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0557:
            r12 = r5
            r2 = r7
            r5 = r10
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readInt64List(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0569:
            r12 = r5
            r2 = r7
            r5 = r10
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readFloatList(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x057b:
            r12 = r5
            r2 = r7
            r5 = r10
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readDoubleList(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x058d:
            r12 = r5
            r2 = r7
            java.lang.Object r5 = r1.mutableMessageFieldForMerge(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.Schema r7 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.mergeGroupField(r5, r7, r6)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.storeMessageField(r2, r3, r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x05a1:
            r12 = r5
            r2 = r7
            r5 = r10
            long r13 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r8 = r4.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r13, (long) r8)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x05b4:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            int r5 = r4.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r8, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x05c7:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = r4.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r8, (long) r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x05da:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            int r5 = r4.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r8, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x05ed:
            r8 = r2
            r12 = r5
            r2 = r7
            r5 = r10
            int r9 = r4.readEnum()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r13 = r1.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            if (r13 == 0) goto L_0x0608
            boolean r13 = r13.isInRange(r9)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            if (r13 == 0) goto L_0x0602
            goto L_0x0608
        L_0x0602:
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.SchemaUtil.storeUnknownEnum(r2, r8, r9, r11, r12)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x0741
        L_0x0608:
            long r13 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r13, (int) r9)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0614:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            int r5 = r4.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r8, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0627:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.ByteString r5 = r4.readBytes()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r2, (long) r8, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x063a:
            r12 = r5
            r2 = r7
            java.lang.Object r5 = r1.mutableMessageFieldForMerge(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.Schema r8 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.mergeMessageField(r5, r8, r6)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.storeMessageField(r2, r3, r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x064e:
            r12 = r5
            r2 = r7
            r5 = r10
            r1.readString(r2, r5, r4)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0659:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            boolean r5 = r4.readBool()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r2, (long) r8, (boolean) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x066c:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            int r5 = r4.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r8, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x067f:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = r4.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r8, (long) r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0692:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            int r5 = r4.readInt32()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r8, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x06a5:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = r4.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r8, (long) r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x06b8:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r13 = r4.readInt64()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r8, (long) r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x06cb:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            float r5 = r4.readFloat()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putFloat((java.lang.Object) r2, (long) r8, (float) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x06de:
            r12 = r5
            r2 = r7
            r5 = r10
            long r8 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            double r13 = r4.readDouble()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putDouble((java.lang.Object) r2, (long) r8, (double) r13)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x06f1:
            boolean r3 = r12.shouldDiscardUnknownFields(r4)     // Catch:{ all -> 0x0718 }
            if (r3 == 0) goto L_0x071a
            boolean r3 = r4.skipField()     // Catch:{ all -> 0x0718 }
            if (r3 != 0) goto L_0x0741
            int r0 = r1.checkInitializedCount
            r4 = r5
        L_0x0700:
            int r3 = r1.repeatedFieldOffsetStart
            if (r0 >= r3) goto L_0x0712
            int[] r3 = r1.intArray
            r3 = r3[r0]
            r6 = r20
            r5 = r12
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0700
        L_0x0712:
            if (r4 == 0) goto L_0x0740
        L_0x0714:
            r12.setBuilderToMessage(r2, r4)
            goto L_0x0740
        L_0x0718:
            r0 = move-exception
            goto L_0x074a
        L_0x071a:
            if (r5 != 0) goto L_0x0721
            java.lang.Object r3 = r12.getBuilderFromMessage(r2)     // Catch:{ all -> 0x0718 }
            r5 = r3
        L_0x0721:
            r7 = 0
            boolean r3 = r12.mergeOneFieldFrom(r5, r4, r7)     // Catch:{ all -> 0x0718 }
            if (r3 != 0) goto L_0x0741
            int r0 = r1.checkInitializedCount
            r4 = r5
        L_0x072b:
            int r3 = r1.repeatedFieldOffsetStart
            if (r0 >= r3) goto L_0x073d
            int[] r3 = r1.intArray
            r3 = r3[r0]
            r6 = r20
            r5 = r12
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x072b
        L_0x073d:
            if (r4 == 0) goto L_0x0740
            goto L_0x0714
        L_0x0740:
            return
        L_0x0741:
            r4 = r6
            goto L_0x0006
        L_0x0744:
            r0 = move-exception
            r12 = r18
            r2 = r20
            r11 = r5
        L_0x074a:
            int r3 = r1.checkInitializedCount
            r7 = r3
            r4 = r5
        L_0x074e:
            int r3 = r1.repeatedFieldOffsetStart
            if (r7 >= r3) goto L_0x0762
            int[] r3 = r1.intArray
            r3 = r3[r7]
            r6 = r20
            r5 = r12
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r7 = r7 + 1
            r1 = r17
            goto L_0x074e
        L_0x0762:
            r5 = r12
            if (r4 == 0) goto L_0x0768
            r5.setBuilderToMessage(r2, r4)
        L_0x0768:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, java.lang.Object, androidx.datastore.preferences.protobuf.Reader, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i5, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(i5));
        Object object = UnsafeUtil.getObject(obj, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private void mergeMessage(T t5, T t6, int i5) {
        if (isFieldPresent(t6, i5)) {
            long offset = offset(typeAndOffsetAt(i5));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t6, offset);
            if (object != null) {
                Schema messageFieldSchema = getMessageFieldSchema(i5);
                if (!isFieldPresent(t5, i5)) {
                    if (!isMutable(object)) {
                        unsafe.putObject(t5, offset, object);
                    } else {
                        Object newInstance = messageFieldSchema.newInstance();
                        messageFieldSchema.mergeFrom(newInstance, object);
                        unsafe.putObject(t5, offset, newInstance);
                    }
                    setFieldPresent(t5, i5);
                    return;
                }
                Object object2 = unsafe.getObject(t5, offset);
                if (!isMutable(object2)) {
                    Object newInstance2 = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance2, object2);
                    unsafe.putObject(t5, offset, newInstance2);
                    object2 = newInstance2;
                }
                messageFieldSchema.mergeFrom(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + numberAt(i5) + " is present but null: " + t6);
        }
    }

    private void mergeOneofMessage(T t5, T t6, int i5) {
        int numberAt = numberAt(i5);
        if (isOneofPresent(t6, numberAt, i5)) {
            long offset = offset(typeAndOffsetAt(i5));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t6, offset);
            if (object != null) {
                Schema messageFieldSchema = getMessageFieldSchema(i5);
                if (!isOneofPresent(t5, numberAt, i5)) {
                    if (!isMutable(object)) {
                        unsafe.putObject(t5, offset, object);
                    } else {
                        Object newInstance = messageFieldSchema.newInstance();
                        messageFieldSchema.mergeFrom(newInstance, object);
                        unsafe.putObject(t5, offset, newInstance);
                    }
                    setOneofPresent(t5, numberAt, i5);
                    return;
                }
                Object object2 = unsafe.getObject(t5, offset);
                if (!isMutable(object2)) {
                    Object newInstance2 = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance2, object2);
                    unsafe.putObject(t5, offset, newInstance2);
                    object2 = newInstance2;
                }
                messageFieldSchema.mergeFrom(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + numberAt(i5) + " is present but null: " + t6);
        }
    }

    private void mergeSingleField(T t5, T t6, int i5) {
        int typeAndOffsetAt = typeAndOffsetAt(i5);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i5);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putDouble((Object) t5, offset, UnsafeUtil.getDouble((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putFloat((Object) t5, offset, UnsafeUtil.getFloat((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putLong((Object) t5, offset, UnsafeUtil.getLong((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putLong((Object) t5, offset, UnsafeUtil.getLong((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt((Object) t5, offset, UnsafeUtil.getInt((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putLong((Object) t5, offset, UnsafeUtil.getLong((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt((Object) t5, offset, UnsafeUtil.getInt((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putBoolean((Object) t5, offset, UnsafeUtil.getBoolean((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putObject((Object) t5, offset, UnsafeUtil.getObject((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 9:
                mergeMessage(t5, t6, i5);
                return;
            case 10:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putObject((Object) t5, offset, UnsafeUtil.getObject((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt((Object) t5, offset, UnsafeUtil.getInt((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt((Object) t5, offset, UnsafeUtil.getInt((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt((Object) t5, offset, UnsafeUtil.getInt((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putLong((Object) t5, offset, UnsafeUtil.getLong((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt((Object) t5, offset, UnsafeUtil.getInt((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putLong((Object) t5, offset, UnsafeUtil.getLong((Object) t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 17:
                mergeMessage(t5, t6, i5);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t5, t6, offset);
                return;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t5, t6, offset);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t6, numberAt, i5)) {
                    UnsafeUtil.putObject((Object) t5, offset, UnsafeUtil.getObject((Object) t6, offset));
                    setOneofPresent(t5, numberAt, i5);
                    return;
                }
                return;
            case 60:
                mergeOneofMessage(t5, t6, i5);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t6, numberAt, i5)) {
                    UnsafeUtil.putObject((Object) t5, offset, UnsafeUtil.getObject((Object) t6, offset));
                    setOneofPresent(t5, numberAt, i5);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(t5, t6, i5);
                return;
            default:
                return;
        }
    }

    private Object mutableMessageFieldForMerge(T t5, int i5) {
        Schema messageFieldSchema = getMessageFieldSchema(i5);
        long offset = offset(typeAndOffsetAt(i5));
        if (!isFieldPresent(t5, i5)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t5, offset);
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    private Object mutableOneofMessageFieldForMerge(T t5, int i5, int i6) {
        Schema messageFieldSchema = getMessageFieldSchema(i6);
        if (!isOneofPresent(t5, i5, i6)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t5, offset(typeAndOffsetAt(i6)));
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        int i5;
        int i6;
        int[] iArr;
        int i7;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            i6 = 0;
            i5 = 0;
        } else {
            i6 = fields[0].getFieldNumber();
            i5 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr2 = new int[(length * 3)];
        Object[] objArr = new Object[(length * 2)];
        int i8 = 0;
        int i9 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i8++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i9++;
            }
        }
        int[] iArr3 = null;
        if (i8 > 0) {
            iArr = new int[i8];
        } else {
            iArr = null;
        }
        if (i9 > 0) {
            iArr3 = new int[i9];
        }
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i10 < fields.length) {
            FieldInfo fieldInfo2 = fields[i10];
            int fieldNumber = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr2, i11, objArr);
            if (i12 < checkInitialized.length && checkInitialized[i12] == fieldNumber) {
                checkInitialized[i12] = i11;
                i12++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr[i13] = i11;
                i13++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i7 = i11;
                iArr3[i14] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                i14++;
                i10++;
                i11 = i7 + 3;
            }
            i7 = i11;
            i10++;
            i11 = i7 + 3;
        }
        if (iArr == null) {
            iArr = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[(checkInitialized.length + iArr.length + iArr3.length)];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr, 0, iArr4, checkInitialized.length, iArr.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr.length, iArr3.length);
        return new MessageSchema<>(iArr2, objArr, i6, i5, structuralMessageInfo.getDefaultInstance(), structuralMessageInfo.getSyntax(), true, iArr4, checkInitialized.length, checkInitialized.length + iArr.length, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0375  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> androidx.datastore.preferences.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(androidx.datastore.preferences.protobuf.RawMessageInfo r33, androidx.datastore.preferences.protobuf.NewInstanceSchema r34, androidx.datastore.preferences.protobuf.ListFieldSchema r35, androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r36, androidx.datastore.preferences.protobuf.ExtensionSchema<?> r37, androidx.datastore.preferences.protobuf.MapFieldSchema r38) {
        /*
            java.lang.String r0 = r33.getStringInfo()
            int r1 = r0.length()
            r2 = 0
            char r3 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r5) goto L_0x001d
            r3 = 1
        L_0x0013:
            int r6 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x001e
            r3 = r6
            goto L_0x0013
        L_0x001d:
            r6 = 1
        L_0x001e:
            int r3 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x003d
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x002a:
            int r9 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x003a
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r8
            r6 = r6 | r3
            int r8 = r8 + 13
            r3 = r9
            goto L_0x002a
        L_0x003a:
            int r3 = r3 << r8
            r6 = r6 | r3
            r3 = r9
        L_0x003d:
            if (r6 != 0) goto L_0x004e
            int[] r6 = EMPTY_INT_ARRAY
            r8 = r2
            r10 = r8
            r11 = r10
            r12 = r11
            r15 = r12
            r17 = r15
            r16 = r6
            r6 = r17
            goto L_0x015a
        L_0x004e:
            int r6 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x006d
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x005a:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x006a
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r3 = r3 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x005a
        L_0x006a:
            int r6 = r6 << r8
            r3 = r3 | r6
            r6 = r9
        L_0x006d:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x008c
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0079:
            int r10 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0089
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r10
            goto L_0x0079
        L_0x0089:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r10
        L_0x008c:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00ab
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0098:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00a8
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r8 = r8 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0098
        L_0x00a8:
            int r9 = r9 << r10
            r8 = r8 | r9
            r9 = r11
        L_0x00ab:
            int r10 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00ca
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00b7:
            int r12 = r10 + 1
            char r10 = r0.charAt(r10)
            if (r10 < r5) goto L_0x00c7
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00b7
        L_0x00c7:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00ca:
            int r11 = r10 + 1
            char r10 = r0.charAt(r10)
            if (r10 < r5) goto L_0x00e9
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00d6:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00e6
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00d6
        L_0x00e6:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00e9:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x0108
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00f5:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0105
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00f5
        L_0x0105:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x0108:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0127
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x0114:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0124
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x0114
        L_0x0124:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0127:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0148
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0133:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0144
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0133
        L_0x0144:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0148:
            int r15 = r13 + r11
            int r15 = r15 + r12
            int[] r12 = new int[r15]
            int r15 = r3 * 2
            int r15 = r15 + r6
            r6 = r11
            r11 = r8
            r8 = r6
            r6 = r3
            r16 = r12
            r17 = r13
            r3 = r14
            r12 = r9
        L_0x015a:
            sun.misc.Unsafe r9 = UNSAFE
            java.lang.Object[] r13 = r33.getObjects()
            androidx.datastore.preferences.protobuf.MessageLite r14 = r33.getDefaultInstance()
            java.lang.Class r14 = r14.getClass()
            int r2 = r10 * 3
            int[] r2 = new int[r2]
            int r10 = r10 * 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            int r8 = r17 + r8
            r22 = r8
            r21 = r17
            r19 = 0
            r20 = 0
        L_0x017a:
            if (r3 >= r1) goto L_0x03d0
            int r23 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a4
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r4 = r23
            r23 = 13
            r24 = 1
        L_0x018c:
            int r25 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x019e
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r23
            r3 = r3 | r4
            int r23 = r23 + 13
            r4 = r25
            goto L_0x018c
        L_0x019e:
            int r4 = r4 << r23
            r3 = r3 | r4
            r4 = r25
            goto L_0x01a8
        L_0x01a4:
            r24 = 1
            r4 = r23
        L_0x01a8:
            int r23 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ce
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r7 = r23
            r23 = 13
        L_0x01b6:
            int r26 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r5) goto L_0x01c8
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r23
            r4 = r4 | r7
            int r23 = r23 + 13
            r7 = r26
            goto L_0x01b6
        L_0x01c8:
            int r7 = r7 << r23
            r4 = r4 | r7
            r7 = r26
            goto L_0x01d0
        L_0x01ce:
            r7 = r23
        L_0x01d0:
            r5 = r4 & 255(0xff, float:3.57E-43)
            r26 = r1
            r1 = r4 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x01de
            int r1 = r19 + 1
            r16[r19] = r20
            r19 = r1
        L_0x01de:
            r1 = 51
            r29 = r2
            if (r5 < r1) goto L_0x0287
            int r1 = r7 + 1
            char r7 = r0.charAt(r7)
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r2) goto L_0x020d
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r31 = 13
        L_0x01f3:
            int r32 = r1 + 1
            char r1 = r0.charAt(r1)
            if (r1 < r2) goto L_0x0208
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r31
            r7 = r7 | r1
            int r31 = r31 + 13
            r1 = r32
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01f3
        L_0x0208:
            int r1 = r1 << r31
            r7 = r7 | r1
            r1 = r32
        L_0x020d:
            int r2 = r5 + -51
            r31 = r1
            r1 = 9
            if (r2 == r1) goto L_0x023c
            r1 = 17
            if (r2 != r1) goto L_0x021a
            goto L_0x023c
        L_0x021a:
            r1 = 12
            if (r2 != r1) goto L_0x0249
            androidx.datastore.preferences.protobuf.ProtoSyntax r1 = r33.getSyntax()
            androidx.datastore.preferences.protobuf.ProtoSyntax r2 = androidx.datastore.preferences.protobuf.ProtoSyntax.PROTO2
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x022e
            r1 = r4 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0249
        L_0x022e:
            int r1 = r20 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            int r2 = r15 + 1
            r15 = r13[r15]
            r10[r1] = r15
        L_0x023a:
            r15 = r2
            goto L_0x0249
        L_0x023c:
            int r1 = r20 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            int r2 = r15 + 1
            r15 = r13[r15]
            r10[r1] = r15
            goto L_0x023a
        L_0x0249:
            int r7 = r7 * 2
            r1 = r13[r7]
            boolean r2 = r1 instanceof java.lang.reflect.Field
            if (r2 == 0) goto L_0x0254
            java.lang.reflect.Field r1 = (java.lang.reflect.Field) r1
            goto L_0x025c
        L_0x0254:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.reflect.Field r1 = reflectField(r14, r1)
            r13[r7] = r1
        L_0x025c:
            long r1 = r9.objectFieldOffset(r1)
            int r1 = (int) r1
            int r7 = r7 + 1
            r2 = r13[r7]
            r27 = r1
            boolean r1 = r2 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x026e
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            goto L_0x0276
        L_0x026e:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = reflectField(r14, r2)
            r13[r7] = r2
        L_0x0276:
            long r1 = r9.objectFieldOffset(r2)
            int r1 = (int) r1
            r30 = r0
            r0 = r1
            r1 = r27
            r7 = 0
            r27 = r3
            r3 = r31
            goto L_0x0392
        L_0x0287:
            int r1 = r15 + 1
            r2 = r13[r15]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = reflectField(r14, r2)
            r31 = r1
            r1 = 9
            if (r5 == r1) goto L_0x029b
            r1 = 17
            if (r5 != r1) goto L_0x029f
        L_0x029b:
            r27 = r3
            goto L_0x030f
        L_0x029f:
            r1 = 27
            if (r5 == r1) goto L_0x02a7
            r1 = 49
            if (r5 != r1) goto L_0x02aa
        L_0x02a7:
            r27 = r3
            goto L_0x0302
        L_0x02aa:
            r1 = 12
            if (r5 == r1) goto L_0x02e6
            r1 = 30
            if (r5 == r1) goto L_0x02e6
            r1 = 44
            if (r5 != r1) goto L_0x02b7
            goto L_0x02e6
        L_0x02b7:
            r1 = 50
            if (r5 != r1) goto L_0x02e3
            int r1 = r21 + 1
            r16[r21] = r20
            int r21 = r20 / 3
            int r21 = r21 * 2
            int r27 = r15 + 2
            r28 = r13[r31]
            r10[r21] = r28
            r28 = r1
            r1 = r4 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x02dc
            int r21 = r21 + 1
            int r1 = r15 + 3
            r15 = r13[r27]
            r10[r21] = r15
            r27 = r3
            r21 = r28
            goto L_0x031d
        L_0x02dc:
            r1 = r27
            r21 = r28
            r27 = r3
            goto L_0x031d
        L_0x02e3:
            r27 = r3
            goto L_0x031b
        L_0x02e6:
            androidx.datastore.preferences.protobuf.ProtoSyntax r1 = r33.getSyntax()
            r27 = r3
            androidx.datastore.preferences.protobuf.ProtoSyntax r3 = androidx.datastore.preferences.protobuf.ProtoSyntax.PROTO2
            if (r1 == r3) goto L_0x02f4
            r1 = r4 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x031b
        L_0x02f4:
            int r1 = r20 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            int r15 = r15 + 2
            r3 = r13[r31]
            r10[r1] = r3
        L_0x0300:
            r1 = r15
            goto L_0x031d
        L_0x0302:
            int r1 = r20 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            int r15 = r15 + 2
            r3 = r13[r31]
            r10[r1] = r3
            goto L_0x0300
        L_0x030f:
            int r1 = r20 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            java.lang.Class r3 = r2.getType()
            r10[r1] = r3
        L_0x031b:
            r1 = r31
        L_0x031d:
            long r2 = r9.objectFieldOffset(r2)
            int r2 = (int) r2
            r3 = r4 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x0375
            r3 = 17
            if (r5 > r3) goto L_0x0375
            int r3 = r7 + 1
            char r7 = r0.charAt(r7)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r15) goto L_0x034f
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r23 = 13
        L_0x0339:
            int r28 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r15) goto L_0x034b
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r23
            r7 = r7 | r3
            int r23 = r23 + 13
            r3 = r28
            goto L_0x0339
        L_0x034b:
            int r3 = r3 << r23
            r7 = r7 | r3
            goto L_0x0351
        L_0x034f:
            r28 = r3
        L_0x0351:
            int r3 = r6 * 2
            int r23 = r7 / 32
            int r3 = r3 + r23
            r15 = r13[r3]
            r30 = r0
            boolean r0 = r15 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0363
            java.lang.reflect.Field r15 = (java.lang.reflect.Field) r15
        L_0x0361:
            r3 = r1
            goto L_0x036c
        L_0x0363:
            java.lang.String r15 = (java.lang.String) r15
            java.lang.reflect.Field r15 = reflectField(r14, r15)
            r13[r3] = r15
            goto L_0x0361
        L_0x036c:
            long r0 = r9.objectFieldOffset(r15)
            int r0 = (int) r0
            int r7 = r7 % 32
        L_0x0373:
            r1 = r0
            goto L_0x037f
        L_0x0375:
            r30 = r0
            r3 = r1
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r28 = r7
            r7 = 0
            goto L_0x0373
        L_0x037f:
            r0 = 18
            if (r5 < r0) goto L_0x038d
            r0 = 49
            if (r5 > r0) goto L_0x038d
            int r0 = r22 + 1
            r16[r22] = r2
            r22 = r0
        L_0x038d:
            r0 = r1
            r1 = r2
            r15 = r3
            r3 = r28
        L_0x0392:
            int r2 = r20 + 1
            r29[r20] = r27
            int r27 = r20 + 2
            r28 = r0
            r0 = r4 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x03a1
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03a2
        L_0x03a1:
            r0 = 0
        L_0x03a2:
            r31 = r0
            r0 = r4 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x03ab
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03ac
        L_0x03ab:
            r0 = 0
        L_0x03ac:
            r0 = r31 | r0
            r4 = r4 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x03b5
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03b6
        L_0x03b5:
            r4 = 0
        L_0x03b6:
            r0 = r0 | r4
            int r4 = r5 << 20
            r0 = r0 | r4
            r0 = r0 | r1
            r29[r2] = r0
            int r20 = r20 + 3
            int r0 = r7 << 20
            r0 = r0 | r28
            r29[r27] = r0
            r1 = r26
            r2 = r29
            r0 = r30
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x017a
        L_0x03d0:
            r29 = r2
            androidx.datastore.preferences.protobuf.MessageSchema r0 = new androidx.datastore.preferences.protobuf.MessageSchema
            androidx.datastore.preferences.protobuf.MessageLite r13 = r33.getDefaultInstance()
            androidx.datastore.preferences.protobuf.ProtoSyntax r14 = r33.getSyntax()
            r15 = 0
            r19 = r34
            r20 = r35
            r21 = r36
            r22 = r37
            r23 = r38
            r18 = r8
            r9 = r29
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.newSchemaForRawMessageInfo(androidx.datastore.preferences.protobuf.RawMessageInfo, androidx.datastore.preferences.protobuf.NewInstanceSchema, androidx.datastore.preferences.protobuf.ListFieldSchema, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, androidx.datastore.preferences.protobuf.MapFieldSchema):androidx.datastore.preferences.protobuf.MessageSchema");
    }

    private int numberAt(int i5) {
        return this.buffer[i5];
    }

    private static long offset(int i5) {
        return (long) (i5 & 1048575);
    }

    private static <T> boolean oneofBooleanAt(T t5, long j5) {
        return ((Boolean) UnsafeUtil.getObject((Object) t5, j5)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t5, long j5) {
        return ((Double) UnsafeUtil.getObject((Object) t5, j5)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t5, long j5) {
        return ((Float) UnsafeUtil.getObject((Object) t5, j5)).floatValue();
    }

    private static <T> int oneofIntAt(T t5, long j5) {
        return ((Integer) UnsafeUtil.getObject((Object) t5, j5)).intValue();
    }

    private static <T> long oneofLongAt(T t5, long j5) {
        return ((Long) UnsafeUtil.getObject((Object) t5, j5)).longValue();
    }

    private <K, V> int parseMapField(T t5, byte[] bArr, int i5, int i6, int i7, long j5, ArrayDecoders.Registers registers) throws IOException {
        long j6 = j5;
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i7);
        Object object = unsafe.getObject(t5, j6);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(t5, j6, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(bArr, i5, i6, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t5, byte[] bArr, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j5, int i12, ArrayDecoders.Registers registers) throws IOException {
        int i13 = i8;
        int i14 = i9;
        long j6 = j5;
        int i15 = i12;
        Unsafe unsafe = UNSAFE;
        long j7 = (long) (this.buffer[i15 + 2] & 1048575);
        boolean z4 = true;
        switch (i11) {
            case 51:
                int i16 = i5;
                if (i14 != 1) {
                    return i16;
                }
                unsafe.putObject(t5, j6, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i5)));
                int i17 = i16 + 8;
                unsafe.putInt(t5, j7, i13);
                return i17;
            case 52:
                int i18 = i5;
                if (i14 != 5) {
                    return i18;
                }
                unsafe.putObject(t5, j6, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i5)));
                int i19 = i18 + 4;
                unsafe.putInt(t5, j7, i13);
                return i19;
            case 53:
            case 54:
                int i20 = i5;
                ArrayDecoders.Registers registers2 = registers;
                if (i14 != 0) {
                    return i20;
                }
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i20, registers2);
                unsafe.putObject(t5, j6, Long.valueOf(registers2.long1));
                unsafe.putInt(t5, j7, i13);
                return decodeVarint64;
            case 55:
            case 62:
                int i21 = i5;
                ArrayDecoders.Registers registers3 = registers;
                if (i14 != 0) {
                    return i21;
                }
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i21, registers3);
                unsafe.putObject(t5, j6, Integer.valueOf(registers3.int1));
                unsafe.putInt(t5, j7, i13);
                return decodeVarint32;
            case 56:
            case 65:
                int i22 = i5;
                if (i14 != 1) {
                    return i22;
                }
                unsafe.putObject(t5, j6, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i5)));
                int i23 = i22 + 8;
                unsafe.putInt(t5, j7, i13);
                return i23;
            case 57:
            case 64:
                int i24 = i5;
                if (i14 != 5) {
                    return i24;
                }
                unsafe.putObject(t5, j6, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i5)));
                int i25 = i24 + 4;
                unsafe.putInt(t5, j7, i13);
                return i25;
            case 58:
                int i26 = i5;
                ArrayDecoders.Registers registers4 = registers;
                if (i14 != 0) {
                    return i26;
                }
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i26, registers4);
                if (registers4.long1 == 0) {
                    z4 = false;
                }
                unsafe.putObject(t5, j6, Boolean.valueOf(z4));
                unsafe.putInt(t5, j7, i13);
                return decodeVarint642;
            case 59:
                int i27 = i5;
                ArrayDecoders.Registers registers5 = registers;
                if (i14 != 2) {
                    return i27;
                }
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i27, registers5);
                int i28 = registers5.int1;
                if (i28 == 0) {
                    unsafe.putObject(t5, j6, "");
                } else if ((i10 & ENFORCE_UTF8_MASK) == 0 || Utf8.isValidUtf8(bArr, decodeVarint322, decodeVarint322 + i28)) {
                    unsafe.putObject(t5, j6, new String(bArr, decodeVarint322, i28, Internal.UTF_8));
                    decodeVarint322 += i28;
                } else {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                unsafe.putInt(t5, j7, i13);
                return decodeVarint322;
            case 60:
                int i29 = i5;
                ArrayDecoders.Registers registers6 = registers;
                if (i14 != 2) {
                    return i29;
                }
                Object mutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t5, i13, i15);
                int mergeMessageField = ArrayDecoders.mergeMessageField(mutableOneofMessageFieldForMerge, getMessageFieldSchema(i15), bArr, i5, i6, registers6);
                storeOneofMessageField(t5, i13, i15, mutableOneofMessageFieldForMerge);
                return mergeMessageField;
            case 61:
                int i30 = i5;
                ArrayDecoders.Registers registers7 = registers;
                if (i14 != 2) {
                    return i30;
                }
                int decodeBytes = ArrayDecoders.decodeBytes(bArr, i30, registers7);
                unsafe.putObject(t5, j6, registers7.object1);
                unsafe.putInt(t5, j7, i13);
                return decodeBytes;
            case 63:
                int i31 = i5;
                int i32 = i7;
                ArrayDecoders.Registers registers8 = registers;
                if (i14 != 0) {
                    return i31;
                }
                int decodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i31, registers8);
                int i33 = registers8.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i15);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i33)) {
                    unsafe.putObject(t5, j6, Integer.valueOf(i33));
                    unsafe.putInt(t5, j7, i13);
                    return decodeVarint323;
                }
                getMutableUnknownFields(t5).storeField(i32, Long.valueOf((long) i33));
                return decodeVarint323;
            case 66:
                int i34 = i5;
                ArrayDecoders.Registers registers9 = registers;
                if (i14 != 0) {
                    return i34;
                }
                int decodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i34, registers9);
                unsafe.putObject(t5, j6, Integer.valueOf(CodedInputStream.decodeZigZag32(registers9.int1)));
                unsafe.putInt(t5, j7, i13);
                return decodeVarint324;
            case 67:
                int i35 = i5;
                ArrayDecoders.Registers registers10 = registers;
                if (i14 != 0) {
                    return i35;
                }
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i35, registers10);
                unsafe.putObject(t5, j6, Long.valueOf(CodedInputStream.decodeZigZag64(registers10.long1)));
                unsafe.putInt(t5, j7, i13);
                return decodeVarint643;
            case 68:
                if (i14 == 3) {
                    Object mutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t5, i13, i15);
                    int mergeGroupField = ArrayDecoders.mergeGroupField(mutableOneofMessageFieldForMerge2, getMessageFieldSchema(i15), bArr, i5, i6, (i7 & -8) | 4, registers);
                    storeOneofMessageField(t5, i13, i15, mutableOneofMessageFieldForMerge2);
                    return mergeGroupField;
                }
                break;
        }
        return i5;
    }

    private int parseRepeatedField(T t5, byte[] bArr, int i5, int i6, int i7, int i8, int i9, int i10, long j5, int i11, long j6, ArrayDecoders.Registers registers) throws IOException {
        int i12;
        int i13 = i10;
        long j7 = j6;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t5, j7);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(t5, j7, protobufList);
        }
        Internal.ProtobufList protobufList2 = protobufList;
        switch (i11) {
            case 18:
            case 35:
                ArrayDecoders.Registers registers2 = registers;
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i5, protobufList2, registers2);
                }
                if (i9 == 1) {
                    return ArrayDecoders.decodeDoubleList(i7, bArr, i5, i6, protobufList2, registers2);
                }
                break;
            case 19:
            case 36:
                ArrayDecoders.Registers registers3 = registers;
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i5, protobufList2, registers3);
                }
                if (i9 == 5) {
                    return ArrayDecoders.decodeFloatList(i7, bArr, i5, i6, protobufList2, registers3);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                ArrayDecoders.Registers registers4 = registers;
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i5, protobufList2, registers4);
                }
                if (i9 == 0) {
                    return ArrayDecoders.decodeVarint64List(i7, bArr, i5, i6, protobufList2, registers4);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                ArrayDecoders.Registers registers5 = registers;
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i5, protobufList2, registers5);
                }
                if (i9 == 0) {
                    return ArrayDecoders.decodeVarint32List(i7, bArr, i5, i6, protobufList2, registers5);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                ArrayDecoders.Registers registers6 = registers;
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i5, protobufList2, registers6);
                }
                if (i9 == 1) {
                    return ArrayDecoders.decodeFixed64List(i7, bArr, i5, i6, protobufList2, registers6);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                ArrayDecoders.Registers registers7 = registers;
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i5, protobufList2, registers7);
                }
                if (i9 == 5) {
                    return ArrayDecoders.decodeFixed32List(i7, bArr, i5, i6, protobufList2, registers7);
                }
                break;
            case 25:
            case 42:
                ArrayDecoders.Registers registers8 = registers;
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i5, protobufList2, registers8);
                }
                if (i9 == 0) {
                    return ArrayDecoders.decodeBoolList(i7, bArr, i5, i6, protobufList2, registers8);
                }
                break;
            case 26:
                if (i9 == 2) {
                    if ((j5 & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(i7, bArr, i5, i6, protobufList2, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(i7, bArr, i5, i6, protobufList2, registers);
                }
                break;
            case 27:
                if (i9 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i13), i7, bArr, i5, i6, protobufList2, registers);
                }
                break;
            case 28:
                if (i9 == 2) {
                    return ArrayDecoders.decodeBytesList(i7, bArr, i5, i6, protobufList2, registers);
                }
                break;
            case 30:
            case 44:
                ArrayDecoders.Registers registers9 = registers;
                if (i9 == 2) {
                    i12 = ArrayDecoders.decodePackedVarint32List(bArr, i5, protobufList2, registers9);
                } else if (i9 == 0) {
                    i12 = ArrayDecoders.decodeVarint32List(i7, bArr, i5, i6, protobufList2, registers9);
                }
                SchemaUtil.filterUnknownEnumList((Object) t5, i8, (List<Integer>) protobufList2, getEnumFieldVerifier(i13), null, this.unknownFieldSchema);
                return i12;
            case 33:
            case 47:
                ArrayDecoders.Registers registers10 = registers;
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i5, protobufList2, registers10);
                }
                if (i9 == 0) {
                    return ArrayDecoders.decodeSInt32List(i7, bArr, i5, i6, protobufList2, registers10);
                }
                break;
            case 34:
            case 48:
                ArrayDecoders.Registers registers11 = registers;
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i5, protobufList2, registers11);
                }
                if (i9 == 0) {
                    return ArrayDecoders.decodeSInt64List(i7, bArr, i5, i6, protobufList2, registers11);
                }
                break;
            case 49:
                if (i9 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i13), i7, bArr, i5, i6, protobufList2, registers);
                }
                break;
        }
        return i5;
    }

    private int positionForFieldNumber(int i5) {
        if (i5 < this.minFieldNumber || i5 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i5, 0);
    }

    private int presenceMaskAndOffsetAt(int i5) {
        return this.buffer[i5 + 2];
    }

    private <E> void readGroupList(Object obj, long j5, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j5), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i5, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i5)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i5, Reader reader) throws IOException {
        if (isEnforceUtf8(i5)) {
            UnsafeUtil.putObject(obj, offset(i5), (Object) reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i5), (Object) reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i5), (Object) reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i5, Reader reader) throws IOException {
        if (isEnforceUtf8(i5)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i5)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i5)));
        }
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void setFieldPresent(T t5, int i5) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i5);
        long j5 = (long) (1048575 & presenceMaskAndOffsetAt);
        if (j5 != 1048575) {
            UnsafeUtil.putInt((Object) t5, j5, (1 << (presenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt((Object) t5, j5));
        }
    }

    private void setOneofPresent(T t5, int i5, int i6) {
        UnsafeUtil.putInt((Object) t5, (long) (presenceMaskAndOffsetAt(i6) & 1048575), i5);
    }

    private int slowPositionForFieldNumber(int i5, int i6) {
        int length = (this.buffer.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int numberAt = numberAt(i8);
            if (i5 == numberAt) {
                return i8;
            }
            if (i5 < numberAt) {
                length = i7 - 1;
            } else {
                i6 = i7 + 1;
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            androidx.datastore.preferences.protobuf.OneofInfo r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L_0x0025
            androidx.datastore.preferences.protobuf.FieldType r2 = r8.getType()
            int r2 = r2.id()
            int r2 = r2 + 51
            java.lang.reflect.Field r3 = r0.getValueField()
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r3)
            int r3 = (int) r3
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
        L_0x0022:
            int r0 = (int) r4
            r4 = r1
            goto L_0x006c
        L_0x0025:
            androidx.datastore.preferences.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r3 = (int) r2
            int r2 = r0.id()
            boolean r4 = r0.isList()
            if (r4 != 0) goto L_0x005a
            boolean r0 = r0.isMap()
            if (r0 != 0) goto L_0x005a
            java.lang.reflect.Field r0 = r8.getPresenceField()
            if (r0 != 0) goto L_0x004c
            r0 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0051
        L_0x004c:
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r4
        L_0x0051:
            int r4 = r8.getPresenceMask()
            int r4 = java.lang.Integer.numberOfTrailingZeros(r4)
            goto L_0x006c
        L_0x005a:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            if (r0 != 0) goto L_0x0063
            r0 = r1
            r4 = r0
            goto L_0x006c
        L_0x0063:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
            goto L_0x0022
        L_0x006c:
            int r5 = r8.getFieldNumber()
            r9[r10] = r5
            int r5 = r10 + 1
            boolean r6 = r8.isEnforceUtf8()
            if (r6 == 0) goto L_0x007d
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x007e
        L_0x007d:
            r6 = r1
        L_0x007e:
            boolean r7 = r8.isRequired()
            if (r7 == 0) goto L_0x0086
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0086:
            r1 = r1 | r6
            int r2 = r2 << 20
            r1 = r1 | r2
            r1 = r1 | r3
            r9[r5] = r1
            int r1 = r10 + 2
            int r2 = r4 << 20
            r0 = r0 | r2
            r9[r1] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r0 = r8.getMapDefaultEntry()
            if (r0 == 0) goto L_0x00be
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r0 = r8.getMapDefaultEntry()
            r11[r10] = r0
            if (r9 == 0) goto L_0x00af
            int r10 = r10 + 1
            r11[r10] = r9
            return
        L_0x00af:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00db
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
            return
        L_0x00be:
            if (r9 == 0) goto L_0x00c9
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r11[r10] = r9
            return
        L_0x00c9:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00db
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private void storeMessageField(T t5, int i5, Object obj) {
        UNSAFE.putObject(t5, offset(typeAndOffsetAt(i5)), obj);
        setFieldPresent(t5, i5);
    }

    private void storeOneofMessageField(T t5, int i5, int i6, Object obj) {
        UNSAFE.putObject(t5, offset(typeAndOffsetAt(i6)), obj);
        setOneofPresent(t5, i5, i6);
    }

    private static int type(int i5) {
        return (i5 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i5) {
        return this.buffer[i5 + 1];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03db, code lost:
        r0 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x04dd, code lost:
        r2 = r2 + 3;
        r5 = r4;
        r4 = r3;
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02ba, code lost:
        r15 = r14;
     */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInAscendingOrder(T r19, androidx.datastore.preferences.protobuf.Writer r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r6 = r20
            boolean r2 = r0.hasExtensions
            if (r2 == 0) goto L_0x0022
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r0.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r2 = r2.getExtensions(r1)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0022
            java.util.Iterator r2 = r2.iterator()
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            r8 = r2
            goto L_0x0024
        L_0x0022:
            r3 = 0
            r8 = 0
        L_0x0024:
            int[] r2 = r0.buffer
            int r9 = r2.length
            sun.misc.Unsafe r10 = UNSAFE
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r11
            r2 = 0
            r5 = 0
        L_0x002f:
            if (r2 >= r9) goto L_0x04e4
            int r13 = r0.typeAndOffsetAt(r2)
            int r14 = r0.numberAt(r2)
            int r15 = type(r13)
            r7 = 17
            if (r15 > r7) goto L_0x0064
            int[] r7 = r0.buffer
            int r16 = r2 + 2
            r7 = r7[r16]
            r16 = 1
            r12 = r7 & r11
            if (r12 == r4) goto L_0x0058
            if (r12 != r11) goto L_0x0051
            r5 = 0
            goto L_0x0057
        L_0x0051:
            long r4 = (long) r12
            int r4 = r10.getInt(r1, r4)
            r5 = r4
        L_0x0057:
            r4 = r12
        L_0x0058:
            int r7 = r7 >>> 20
            int r7 = r16 << r7
            r17 = r7
            r7 = r3
            r3 = r4
            r4 = r5
            r5 = r17
            goto L_0x006a
        L_0x0064:
            r16 = 1
            r7 = r3
            r3 = r4
            r4 = r5
            r5 = 0
        L_0x006a:
            if (r7 == 0) goto L_0x0088
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r12 = r0.extensionSchema
            int r12 = r12.extensionNumber(r7)
            if (r12 > r14) goto L_0x0088
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r12 = r0.extensionSchema
            r12.serializeExtension(r6, r7)
            boolean r7 = r8.hasNext()
            if (r7 == 0) goto L_0x0086
            java.lang.Object r7 = r8.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            goto L_0x006a
        L_0x0086:
            r7 = 0
            goto L_0x006a
        L_0x0088:
            long r12 = offset(r13)
            switch(r15) {
                case 0: goto L_0x04cf;
                case 1: goto L_0x04bf;
                case 2: goto L_0x04af;
                case 3: goto L_0x049f;
                case 4: goto L_0x048f;
                case 5: goto L_0x047f;
                case 6: goto L_0x046f;
                case 7: goto L_0x045f;
                case 8: goto L_0x044f;
                case 9: goto L_0x043b;
                case 10: goto L_0x042a;
                case 11: goto L_0x041b;
                case 12: goto L_0x040c;
                case 13: goto L_0x03fd;
                case 14: goto L_0x03ee;
                case 15: goto L_0x03df;
                case 16: goto L_0x03cd;
                case 17: goto L_0x03b9;
                case 18: goto L_0x03a9;
                case 19: goto L_0x0399;
                case 20: goto L_0x0389;
                case 21: goto L_0x0379;
                case 22: goto L_0x0369;
                case 23: goto L_0x0359;
                case 24: goto L_0x0349;
                case 25: goto L_0x0339;
                case 26: goto L_0x032a;
                case 27: goto L_0x0317;
                case 28: goto L_0x0308;
                case 29: goto L_0x02f9;
                case 30: goto L_0x02ea;
                case 31: goto L_0x02db;
                case 32: goto L_0x02cc;
                case 33: goto L_0x02bd;
                case 34: goto L_0x02ac;
                case 35: goto L_0x029b;
                case 36: goto L_0x028a;
                case 37: goto L_0x0279;
                case 38: goto L_0x0268;
                case 39: goto L_0x0257;
                case 40: goto L_0x0246;
                case 41: goto L_0x0235;
                case 42: goto L_0x0224;
                case 43: goto L_0x0213;
                case 44: goto L_0x0202;
                case 45: goto L_0x01f1;
                case 46: goto L_0x01e0;
                case 47: goto L_0x01cf;
                case 48: goto L_0x01be;
                case 49: goto L_0x01ab;
                case 50: goto L_0x01a2;
                case 51: goto L_0x0193;
                case 52: goto L_0x0184;
                case 53: goto L_0x0175;
                case 54: goto L_0x0166;
                case 55: goto L_0x0157;
                case 56: goto L_0x0148;
                case 57: goto L_0x0139;
                case 58: goto L_0x012a;
                case 59: goto L_0x011b;
                case 60: goto L_0x0108;
                case 61: goto L_0x00f8;
                case 62: goto L_0x00ea;
                case 63: goto L_0x00dc;
                case 64: goto L_0x00ce;
                case 65: goto L_0x00c0;
                case 66: goto L_0x00b2;
                case 67: goto L_0x00a4;
                case 68: goto L_0x0092;
                default: goto L_0x008f;
            }
        L_0x008f:
            r15 = 0
            goto L_0x04dd
        L_0x0092:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r12 = r0.getMessageFieldSchema(r2)
            r6.writeGroup(r14, r5, r12)
            goto L_0x008f
        L_0x00a4:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            long r12 = oneofLongAt(r1, r12)
            r6.writeSInt64(r14, r12)
            goto L_0x008f
        L_0x00b2:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeSInt32(r14, r5)
            goto L_0x008f
        L_0x00c0:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            long r12 = oneofLongAt(r1, r12)
            r6.writeSFixed64(r14, r12)
            goto L_0x008f
        L_0x00ce:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeSFixed32(r14, r5)
            goto L_0x008f
        L_0x00dc:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeEnum(r14, r5)
            goto L_0x008f
        L_0x00ea:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeUInt32(r14, r5)
            goto L_0x008f
        L_0x00f8:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.ByteString r5 = (androidx.datastore.preferences.protobuf.ByteString) r5
            r6.writeBytes(r14, r5)
            goto L_0x008f
        L_0x0108:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r12 = r0.getMessageFieldSchema(r2)
            r6.writeMessage(r14, r5, r12)
            goto L_0x008f
        L_0x011b:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r10.getObject(r1, r12)
            r0.writeString(r14, r5, r6)
            goto L_0x008f
        L_0x012a:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            boolean r5 = oneofBooleanAt(r1, r12)
            r6.writeBool(r14, r5)
            goto L_0x008f
        L_0x0139:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeFixed32(r14, r5)
            goto L_0x008f
        L_0x0148:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            long r12 = oneofLongAt(r1, r12)
            r6.writeFixed64(r14, r12)
            goto L_0x008f
        L_0x0157:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            int r5 = oneofIntAt(r1, r12)
            r6.writeInt32(r14, r5)
            goto L_0x008f
        L_0x0166:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            long r12 = oneofLongAt(r1, r12)
            r6.writeUInt64(r14, r12)
            goto L_0x008f
        L_0x0175:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            long r12 = oneofLongAt(r1, r12)
            r6.writeInt64(r14, r12)
            goto L_0x008f
        L_0x0184:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            float r5 = oneofFloatAt(r1, r12)
            r6.writeFloat(r14, r5)
            goto L_0x008f
        L_0x0193:
            boolean r5 = r0.isOneofPresent(r1, r14, r2)
            if (r5 == 0) goto L_0x008f
            double r12 = oneofDoubleAt(r1, r12)
            r6.writeDouble(r14, r12)
            goto L_0x008f
        L_0x01a2:
            java.lang.Object r5 = r10.getObject(r1, r12)
            r0.writeMapHelper(r6, r14, r5, r2)
            goto L_0x008f
        L_0x01ab:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.Schema r13 = r0.getMessageFieldSchema(r2)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeGroupList(r5, r12, r6, r13)
            goto L_0x008f
        L_0x01be:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            r14 = r16
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x01cf:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x01e0:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x01f1:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0202:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0213:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0224:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0235:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0246:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0257:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0268:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x0279:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r12, r6, r14)
            goto L_0x008f
        L_0x028a:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r12, r6, r14)
            goto L_0x008f
        L_0x029b:
            r14 = r16
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r12, r6, r14)
            goto L_0x008f
        L_0x02ac:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            r14 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r12, r6, r14)
        L_0x02ba:
            r15 = r14
            goto L_0x04dd
        L_0x02bd:
            r14 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r12, r6, r14)
            goto L_0x02ba
        L_0x02cc:
            r14 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r12, r6, r14)
            goto L_0x02ba
        L_0x02db:
            r14 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r12, r6, r14)
            goto L_0x02ba
        L_0x02ea:
            r14 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r12, r6, r14)
            goto L_0x02ba
        L_0x02f9:
            r14 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r12, r6, r14)
            goto L_0x02ba
        L_0x0308:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBytesList(r5, r12, r6)
            goto L_0x008f
        L_0x0317:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.Schema r13 = r0.getMessageFieldSchema(r2)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeMessageList(r5, r12, r6, r13)
            goto L_0x008f
        L_0x032a:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeStringList(r5, r12, r6)
            goto L_0x008f
        L_0x0339:
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            r15 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r12, r6, r15)
            goto L_0x04dd
        L_0x0349:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r12, r6, r15)
            goto L_0x04dd
        L_0x0359:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r12, r6, r15)
            goto L_0x04dd
        L_0x0369:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r12, r6, r15)
            goto L_0x04dd
        L_0x0379:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r12, r6, r15)
            goto L_0x04dd
        L_0x0389:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r12, r6, r15)
            goto L_0x04dd
        L_0x0399:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r12, r6, r15)
            goto L_0x04dd
        L_0x03a9:
            r15 = 0
            int r5 = r0.numberAt(r2)
            java.lang.Object r12 = r10.getObject(r1, r12)
            java.util.List r12 = (java.util.List) r12
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r12, r6, r15)
            goto L_0x04dd
        L_0x03b9:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04dd
            java.lang.Object r5 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r12 = r0.getMessageFieldSchema(r2)
            r6.writeGroup(r14, r5, r12)
            goto L_0x04dd
        L_0x03cd:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            long r12 = r10.getLong(r1, r12)
            r6.writeSInt64(r14, r12)
        L_0x03db:
            r0 = r18
            goto L_0x04dd
        L_0x03df:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            int r0 = r10.getInt(r1, r12)
            r6.writeSInt32(r14, r0)
            goto L_0x03db
        L_0x03ee:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            long r12 = r10.getLong(r1, r12)
            r6.writeSFixed64(r14, r12)
            goto L_0x03db
        L_0x03fd:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            int r0 = r10.getInt(r1, r12)
            r6.writeSFixed32(r14, r0)
            goto L_0x03db
        L_0x040c:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            int r0 = r10.getInt(r1, r12)
            r6.writeEnum(r14, r0)
            goto L_0x03db
        L_0x041b:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            int r0 = r10.getInt(r1, r12)
            r6.writeUInt32(r14, r0)
            goto L_0x03db
        L_0x042a:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            java.lang.Object r0 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.ByteString r0 = (androidx.datastore.preferences.protobuf.ByteString) r0
            r6.writeBytes(r14, r0)
            goto L_0x03db
        L_0x043b:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04dd
            java.lang.Object r5 = r10.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r12 = r0.getMessageFieldSchema(r2)
            r6.writeMessage(r14, r5, r12)
            goto L_0x04dd
        L_0x044f:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04dd
            java.lang.Object r5 = r10.getObject(r1, r12)
            r0.writeString(r14, r5, r6)
            goto L_0x04dd
        L_0x045f:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            boolean r0 = booleanAt(r1, r12)
            r6.writeBool(r14, r0)
            goto L_0x03db
        L_0x046f:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            int r0 = r10.getInt(r1, r12)
            r6.writeFixed32(r14, r0)
            goto L_0x03db
        L_0x047f:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            long r12 = r10.getLong(r1, r12)
            r6.writeFixed64(r14, r12)
            goto L_0x03db
        L_0x048f:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            int r0 = r10.getInt(r1, r12)
            r6.writeInt32(r14, r0)
            goto L_0x03db
        L_0x049f:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            long r12 = r10.getLong(r1, r12)
            r6.writeUInt64(r14, r12)
            goto L_0x03db
        L_0x04af:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            long r12 = r10.getLong(r1, r12)
            r6.writeInt64(r14, r12)
            goto L_0x03db
        L_0x04bf:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03db
            float r0 = floatAt(r1, r12)
            r6.writeFloat(r14, r0)
            goto L_0x03db
        L_0x04cf:
            r15 = 0
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04dd
            double r12 = doubleAt(r1, r12)
            r6.writeDouble(r14, r12)
        L_0x04dd:
            int r2 = r2 + 3
            r5 = r4
            r4 = r3
            r3 = r7
            goto L_0x002f
        L_0x04e4:
            if (r3 == 0) goto L_0x04fb
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r0.extensionSchema
            r2.serializeExtension(r6, r3)
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x04f9
            java.lang.Object r2 = r8.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            r3 = r2
            goto L_0x04e4
        L_0x04f9:
            r3 = 0
            goto L_0x04e4
        L_0x04fb:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            r0.writeUnknownInMessageTo(r2, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInAscendingOrder(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInDescendingOrder(T r11, androidx.datastore.preferences.protobuf.Writer r12) throws java.io.IOException {
        /*
            r10 = this;
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r10.unknownFieldSchema
            r10.writeUnknownInMessageTo(r0, r11, r12)
            boolean r0 = r10.hasExtensions
            r1 = 0
            if (r0 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r10.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r0 = r0.getExtensions(r11)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.buffer
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x058c
            int r4 = r10.typeAndOffsetAt(r3)
            int r5 = r10.numberAt(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            int r6 = r6.extensionNumber(r2)
            if (r6 <= r5) goto L_0x0050
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            r6.serializeExtension(r12, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0032
        L_0x004e:
            r2 = r1
            goto L_0x0032
        L_0x0050:
            int r6 = type(r4)
            r7 = 0
            r8 = 1
            switch(r6) {
                case 0: goto L_0x0577;
                case 1: goto L_0x0565;
                case 2: goto L_0x0553;
                case 3: goto L_0x0541;
                case 4: goto L_0x052f;
                case 5: goto L_0x051d;
                case 6: goto L_0x050b;
                case 7: goto L_0x04f8;
                case 8: goto L_0x04e5;
                case 9: goto L_0x04ce;
                case 10: goto L_0x04b9;
                case 11: goto L_0x04a6;
                case 12: goto L_0x0493;
                case 13: goto L_0x0480;
                case 14: goto L_0x046d;
                case 15: goto L_0x045a;
                case 16: goto L_0x0447;
                case 17: goto L_0x0430;
                case 18: goto L_0x041d;
                case 19: goto L_0x040a;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e4;
                case 22: goto L_0x03d1;
                case 23: goto L_0x03be;
                case 24: goto L_0x03ab;
                case 25: goto L_0x0398;
                case 26: goto L_0x0385;
                case 27: goto L_0x036e;
                case 28: goto L_0x035b;
                case 29: goto L_0x0348;
                case 30: goto L_0x0335;
                case 31: goto L_0x0322;
                case 32: goto L_0x030f;
                case 33: goto L_0x02fc;
                case 34: goto L_0x02e9;
                case 35: goto L_0x02d6;
                case 36: goto L_0x02c3;
                case 37: goto L_0x02b0;
                case 38: goto L_0x029d;
                case 39: goto L_0x028a;
                case 40: goto L_0x0277;
                case 41: goto L_0x0264;
                case 42: goto L_0x0251;
                case 43: goto L_0x023e;
                case 44: goto L_0x022b;
                case 45: goto L_0x0218;
                case 46: goto L_0x0205;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01df;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bb;
                case 51: goto L_0x01a8;
                case 52: goto L_0x0195;
                case 53: goto L_0x0182;
                case 54: goto L_0x016f;
                case 55: goto L_0x015c;
                case 56: goto L_0x0149;
                case 57: goto L_0x0136;
                case 58: goto L_0x0123;
                case 59: goto L_0x0110;
                case 60: goto L_0x00f9;
                case 61: goto L_0x00e4;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00be;
                case 64: goto L_0x00ab;
                case 65: goto L_0x0098;
                case 66: goto L_0x0085;
                case 67: goto L_0x0072;
                case 68: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0588
        L_0x005b:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeGroup(r5, r4, r6)
            goto L_0x0588
        L_0x0072:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x0085:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x0098:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x00ab:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x00be:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x00d1:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x00e4:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x00f9:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x0110:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeString(r5, r4, r12)
            goto L_0x0588
        L_0x0123:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            boolean r4 = oneofBooleanAt(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x0136:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x0149:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x015c:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x016f:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0182:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0195:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            float r4 = oneofFloatAt(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x01a8:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            double r6 = oneofDoubleAt(r11, r6)
            r12.writeDouble(r5, r6)
            goto L_0x0588
        L_0x01bb:
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeMapHelper(r12, r5, r4, r3)
            goto L_0x0588
        L_0x01c8:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeGroupList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x01df:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x01f2:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0205:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0218:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x022b:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x023e:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0251:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0264:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0277:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x028a:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x029d:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02b0:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02c3:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02d6:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02e9:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02fc:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x030f:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0322:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0335:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0348:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x035b:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBytesList(r5, r4, r12)
            goto L_0x0588
        L_0x036e:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeMessageList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x0385:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeStringList(r5, r4, r12)
            goto L_0x0588
        L_0x0398:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03ab:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03be:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03d1:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03e4:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03f7:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x040a:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x041d:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0430:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeGroup(r5, r4, r6)
            goto L_0x0588
        L_0x0447:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x045a:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x046d:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x0480:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x0493:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x04a6:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x04b9:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x04ce:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x04e5:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeString(r5, r4, r12)
            goto L_0x0588
        L_0x04f8:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            boolean r4 = booleanAt(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x050b:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x051d:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x052f:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x0541:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0553:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0565:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            float r4 = floatAt(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x0577:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            double r6 = doubleAt(r11, r6)
            r12.writeDouble(r5, r6)
        L_0x0588:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x058c:
            if (r2 == 0) goto L_0x05a3
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r11 = r10.extensionSchema
            r11.serializeExtension(r12, r2)
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x05a1
            java.lang.Object r11 = r0.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            r2 = r11
            goto L_0x058c
        L_0x05a1:
            r2 = r1
            goto L_0x058c
        L_0x05a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i5, Object obj, int i6) throws IOException {
        if (obj != null) {
            writer.writeMap(i5, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i6)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i5, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i5, (String) obj);
        } else {
            writer.writeBytes(i5, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t5, Writer writer) throws IOException {
        unknownFieldSchema2.writeTo(unknownFieldSchema2.getFromMessage(t5), writer);
    }

    public boolean equals(T t5, T t6) {
        int length = this.buffer.length;
        for (int i5 = 0; i5 < length; i5 += 3) {
            if (!equals(t5, t6, i5)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t5).equals(this.unknownFieldSchema.getFromMessage(t6))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t5).equals(this.extensionSchema.getExtensions(t6));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0435, code lost:
        r9 = r16 + r0;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x043b, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x045a, code lost:
        r9 = r16 + r0;
        r0 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0462, code lost:
        r0 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
        r9 = r16 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0552, code lost:
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0554, code lost:
        r2 = r2 + 3;
        r8 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01b7, code lost:
        r9 = r16 + ((r8 + r9) + r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getSerializedSize(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            sun.misc.Unsafe r6 = UNSAFE
            r7 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r7
            r4 = r2
            r9 = r4
            r3 = r8
        L_0x000e:
            int[] r5 = r0.buffer
            int r5 = r5.length
            if (r2 >= r5) goto L_0x055b
            int r5 = r0.typeAndOffsetAt(r2)
            int r10 = type(r5)
            int r11 = r0.numberAt(r2)
            int[] r12 = r0.buffer
            int r13 = r2 + 2
            r12 = r12[r13]
            r13 = r12 & r8
            r14 = 17
            r15 = 1
            if (r10 > r14) goto L_0x0040
            if (r13 == r3) goto L_0x0039
            if (r13 != r8) goto L_0x0032
            r4 = r7
            goto L_0x0038
        L_0x0032:
            long r3 = (long) r13
            int r3 = r6.getInt(r1, r3)
            r4 = r3
        L_0x0038:
            r3 = r13
        L_0x0039:
            int r12 = r12 >>> 20
            int r12 = r15 << r12
        L_0x003d:
            r16 = r9
            goto L_0x0042
        L_0x0040:
            r12 = r7
            goto L_0x003d
        L_0x0042:
            long r8 = offset(r5)
            androidx.datastore.preferences.protobuf.FieldType r5 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r5 = r5.id()
            if (r10 < r5) goto L_0x0057
            androidx.datastore.preferences.protobuf.FieldType r5 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
            int r5 = r5.id()
            if (r10 > r5) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r13 = r7
        L_0x0058:
            r5 = 0
            r14 = 0
            switch(r10) {
                case 0: goto L_0x0543;
                case 1: goto L_0x0535;
                case 2: goto L_0x0524;
                case 3: goto L_0x0513;
                case 4: goto L_0x0502;
                case 5: goto L_0x04f5;
                case 6: goto L_0x04e8;
                case 7: goto L_0x04da;
                case 8: goto L_0x04bb;
                case 9: goto L_0x04a6;
                case 10: goto L_0x0494;
                case 11: goto L_0x0484;
                case 12: goto L_0x0474;
                case 13: goto L_0x0468;
                case 14: goto L_0x044f;
                case 15: goto L_0x043f;
                case 16: goto L_0x0426;
                case 17: goto L_0x040f;
                case 18: goto L_0x0403;
                case 19: goto L_0x03f7;
                case 20: goto L_0x03eb;
                case 21: goto L_0x03df;
                case 22: goto L_0x03d3;
                case 23: goto L_0x03c7;
                case 24: goto L_0x03bb;
                case 25: goto L_0x03af;
                case 26: goto L_0x03a3;
                case 27: goto L_0x0393;
                case 28: goto L_0x0387;
                case 29: goto L_0x037b;
                case 30: goto L_0x036f;
                case 31: goto L_0x0363;
                case 32: goto L_0x0357;
                case 33: goto L_0x034b;
                case 34: goto L_0x033f;
                case 35: goto L_0x0321;
                case 36: goto L_0x0303;
                case 37: goto L_0x02e5;
                case 38: goto L_0x02c7;
                case 39: goto L_0x02a9;
                case 40: goto L_0x028b;
                case 41: goto L_0x026d;
                case 42: goto L_0x024f;
                case 43: goto L_0x0231;
                case 44: goto L_0x0214;
                case 45: goto L_0x01f7;
                case 46: goto L_0x01da;
                case 47: goto L_0x01bd;
                case 48: goto L_0x019b;
                case 49: goto L_0x018b;
                case 50: goto L_0x017b;
                case 51: goto L_0x016d;
                case 52: goto L_0x0161;
                case 53: goto L_0x0151;
                case 54: goto L_0x0141;
                case 55: goto L_0x0131;
                case 56: goto L_0x0125;
                case 57: goto L_0x0119;
                case 58: goto L_0x010c;
                case 59: goto L_0x00ee;
                case 60: goto L_0x00db;
                case 61: goto L_0x00ca;
                case 62: goto L_0x00bb;
                case 63: goto L_0x00ac;
                case 64: goto L_0x00a1;
                case 65: goto L_0x0096;
                case 66: goto L_0x0087;
                case 67: goto L_0x0078;
                case 68: goto L_0x0060;
                default: goto L_0x005e;
            }
        L_0x005e:
            goto L_0x0552
        L_0x0060:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            java.lang.Object r5 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeGroupSize(r11, r5, r8)
        L_0x0074:
            int r9 = r16 + r5
            goto L_0x0554
        L_0x0078:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            long r8 = oneofLongAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r11, r8)
            goto L_0x0074
        L_0x0087:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            int r5 = oneofIntAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r11, r5)
            goto L_0x0074
        L_0x0096:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r11, r14)
            goto L_0x0074
        L_0x00a1:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r11, r7)
            goto L_0x0074
        L_0x00ac:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            int r5 = oneofIntAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r11, r5)
            goto L_0x0074
        L_0x00bb:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            int r5 = oneofIntAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r11, r5)
            goto L_0x0074
        L_0x00ca:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            java.lang.Object r5 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.ByteString r5 = (androidx.datastore.preferences.protobuf.ByteString) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r11, r5)
            goto L_0x0074
        L_0x00db:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            java.lang.Object r5 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessage(r11, r5, r8)
            goto L_0x0074
        L_0x00ee:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            java.lang.Object r5 = r6.getObject(r1, r8)
            boolean r8 = r5 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r8 == 0) goto L_0x0104
            androidx.datastore.preferences.protobuf.ByteString r5 = (androidx.datastore.preferences.protobuf.ByteString) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r11, r5)
            goto L_0x0074
        L_0x0104:
            java.lang.String r5 = (java.lang.String) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r11, r5)
            goto L_0x0074
        L_0x010c:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            r5 = 1
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r11, r5)
            goto L_0x0074
        L_0x0119:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r11, r7)
            goto L_0x0074
        L_0x0125:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r11, r14)
            goto L_0x0074
        L_0x0131:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            int r5 = oneofIntAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r11, r5)
            goto L_0x0074
        L_0x0141:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            long r8 = oneofLongAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r11, r8)
            goto L_0x0074
        L_0x0151:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            long r8 = oneofLongAt(r1, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r11, r8)
            goto L_0x0074
        L_0x0161:
            boolean r8 = r0.isOneofPresent(r1, r11, r2)
            if (r8 == 0) goto L_0x0552
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r11, r5)
            goto L_0x0074
        L_0x016d:
            boolean r5 = r0.isOneofPresent(r1, r11, r2)
            if (r5 == 0) goto L_0x0552
            r8 = 0
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r11, r8)
            goto L_0x0074
        L_0x017b:
            androidx.datastore.preferences.protobuf.MapFieldSchema r5 = r0.mapFieldSchema
            java.lang.Object r8 = r6.getObject(r1, r8)
            java.lang.Object r9 = r0.getMapFieldDefaultEntry(r2)
            int r5 = r5.getSerializedSize(r11, r8, r9)
            goto L_0x0074
        L_0x018b:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeGroupList(r11, r5, r8)
            goto L_0x0074
        L_0x019b:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt64ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x01af
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x01af:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
        L_0x01b7:
            int r8 = r8 + r9
            int r8 = r8 + r5
            int r9 = r16 + r8
            goto L_0x0554
        L_0x01bd:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt32ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x01d1
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x01d1:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x01da:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x01ee
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x01ee:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x01f7:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x020b
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x020b:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x0214:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeEnumListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x0228
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x0228:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x0231:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt32ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x0245
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x0245:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x024f:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeBoolListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x0263
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x0263:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x026d:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x0281
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x0281:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x028b:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x029f
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x029f:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x02a9:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt32ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x02bd
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x02bd:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x02c7:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt64ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x02db
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x02db:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x02e5:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt64ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x02f9
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x02f9:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x0303:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x0317
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x0317:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x0321:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r5)
            if (r5 <= 0) goto L_0x0552
            boolean r8 = r0.useCachedSizeField
            if (r8 == 0) goto L_0x0335
            long r8 = (long) r13
            r6.putInt(r1, r8, r5)
        L_0x0335:
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r11)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r5)
            goto L_0x01b7
        L_0x033f:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt64List(r11, r5, r7)
            goto L_0x0074
        L_0x034b:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt32List(r11, r5, r7)
            goto L_0x0074
        L_0x0357:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r11, r5, r7)
            goto L_0x0074
        L_0x0363:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r11, r5, r7)
            goto L_0x0074
        L_0x036f:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeEnumList(r11, r5, r7)
            goto L_0x0074
        L_0x037b:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt32List(r11, r5, r7)
            goto L_0x0074
        L_0x0387:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeByteStringList(r11, r5)
            goto L_0x0074
        L_0x0393:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessageList(r11, r5, r8)
            goto L_0x0074
        L_0x03a3:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeStringList(r11, r5)
            goto L_0x0074
        L_0x03af:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeBoolList(r11, r5, r7)
            goto L_0x0074
        L_0x03bb:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r11, r5, r7)
            goto L_0x0074
        L_0x03c7:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r11, r5, r7)
            goto L_0x0074
        L_0x03d3:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt32List(r11, r5, r7)
            goto L_0x0074
        L_0x03df:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt64List(r11, r5, r7)
            goto L_0x0074
        L_0x03eb:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt64List(r11, r5, r7)
            goto L_0x0074
        L_0x03f7:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r11, r5, r7)
            goto L_0x0074
        L_0x0403:
            java.lang.Object r5 = r6.getObject(r1, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r11, r5, r7)
            goto L_0x0074
        L_0x040f:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0552
            java.lang.Object r5 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeGroupSize(r11, r5, r8)
            goto L_0x0074
        L_0x0426:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x043b
            long r8 = r6.getLong(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r11, r8)
        L_0x0435:
            int r9 = r16 + r0
            r0 = r17
            goto L_0x0554
        L_0x043b:
            r0 = r17
            goto L_0x0552
        L_0x043f:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x043b
            int r0 = r6.getInt(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r11, r0)
            goto L_0x0435
        L_0x044f:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0462
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r11, r14)
        L_0x045a:
            int r9 = r16 + r0
            r0 = r17
            r1 = r18
            goto L_0x0554
        L_0x0462:
            r0 = r17
            r1 = r18
            goto L_0x0552
        L_0x0468:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0462
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r11, r7)
            goto L_0x045a
        L_0x0474:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x043b
            int r0 = r6.getInt(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r11, r0)
            goto L_0x0435
        L_0x0484:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x043b
            int r0 = r6.getInt(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r11, r0)
            goto L_0x0435
        L_0x0494:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x043b
            java.lang.Object r0 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.ByteString r0 = (androidx.datastore.preferences.protobuf.ByteString) r0
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r11, r0)
            goto L_0x0435
        L_0x04a6:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0552
            java.lang.Object r5 = r6.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r2)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessage(r11, r5, r8)
            goto L_0x0074
        L_0x04bb:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x043b
            java.lang.Object r0 = r6.getObject(r1, r8)
            boolean r5 = r0 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r5 == 0) goto L_0x04d2
            androidx.datastore.preferences.protobuf.ByteString r0 = (androidx.datastore.preferences.protobuf.ByteString) r0
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r11, r0)
            goto L_0x0435
        L_0x04d2:
            java.lang.String r0 = (java.lang.String) r0
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r11, r0)
            goto L_0x0435
        L_0x04da:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0462
            r5 = 1
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r11, r5)
            goto L_0x045a
        L_0x04e8:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0462
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r11, r7)
            goto L_0x045a
        L_0x04f5:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0462
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r11, r14)
            goto L_0x045a
        L_0x0502:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x043b
            int r0 = r6.getInt(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r11, r0)
            goto L_0x0435
        L_0x0513:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x043b
            long r8 = r6.getLong(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r11, r8)
            goto L_0x0435
        L_0x0524:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x043b
            long r8 = r6.getLong(r1, r8)
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r11, r8)
            goto L_0x0435
        L_0x0535:
            r8 = r5
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0462
            int r0 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r11, r8)
            goto L_0x045a
        L_0x0543:
            r5 = r12
            boolean r5 = r0.isFieldPresent(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0552
            r8 = 0
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r11, r8)
            goto L_0x0074
        L_0x0552:
            r9 = r16
        L_0x0554:
            int r2 = r2 + 3
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000e
        L_0x055b:
            r16 = r9
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            int r2 = r0.getUnknownFieldsSerializedSize(r2, r1)
            int r9 = r16 + r2
            boolean r2 = r0.hasExtensions
            if (r2 == 0) goto L_0x0574
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r0.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r1 = r2.getExtensions(r1)
            int r1 = r1.getSerializedSize()
            int r9 = r9 + r1
        L_0x0574:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.getSerializedSize(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x016b, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0229, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.buffer
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022d
            int r3 = r8.typeAndOffsetAt(r1)
            int r4 = r8.numberAt(r1)
            long r5 = offset(r3)
            int r3 = type(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020d;
                case 2: goto L_0x0201;
                case 3: goto L_0x01f5;
                case 4: goto L_0x01ed;
                case 5: goto L_0x01e1;
                case 6: goto L_0x01d9;
                case 7: goto L_0x01cd;
                case 8: goto L_0x01bf;
                case 9: goto L_0x01b4;
                case 10: goto L_0x01a8;
                case 11: goto L_0x01a0;
                case 12: goto L_0x0198;
                case 13: goto L_0x0190;
                case 14: goto L_0x0184;
                case 15: goto L_0x017c;
                case 16: goto L_0x0170;
                case 17: goto L_0x0161;
                case 18: goto L_0x0155;
                case 19: goto L_0x0155;
                case 20: goto L_0x0155;
                case 21: goto L_0x0155;
                case 22: goto L_0x0155;
                case 23: goto L_0x0155;
                case 24: goto L_0x0155;
                case 25: goto L_0x0155;
                case 26: goto L_0x0155;
                case 27: goto L_0x0155;
                case 28: goto L_0x0155;
                case 29: goto L_0x0155;
                case 30: goto L_0x0155;
                case 31: goto L_0x0155;
                case 32: goto L_0x0155;
                case 33: goto L_0x0155;
                case 34: goto L_0x0155;
                case 35: goto L_0x0155;
                case 36: goto L_0x0155;
                case 37: goto L_0x0155;
                case 38: goto L_0x0155;
                case 39: goto L_0x0155;
                case 40: goto L_0x0155;
                case 41: goto L_0x0155;
                case 42: goto L_0x0155;
                case 43: goto L_0x0155;
                case 44: goto L_0x0155;
                case 45: goto L_0x0155;
                case 46: goto L_0x0155;
                case 47: goto L_0x0155;
                case 48: goto L_0x0155;
                case 49: goto L_0x0155;
                case 50: goto L_0x0149;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x010f;
                case 54: goto L_0x00fd;
                case 55: goto L_0x00ef;
                case 56: goto L_0x00dd;
                case 57: goto L_0x00cf;
                case 58: goto L_0x00bd;
                case 59: goto L_0x00a9;
                case 60: goto L_0x0098;
                case 61: goto L_0x0087;
                case 62: goto L_0x007a;
                case 63: goto L_0x006d;
                case 64: goto L_0x0060;
                case 65: goto L_0x004f;
                case 66: goto L_0x0042;
                case 67: goto L_0x0031;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0229
        L_0x001e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
        L_0x002e:
            int r2 = r2 + r3
            goto L_0x0229
        L_0x0031:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0042:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x004f:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0060:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x006d:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x007a:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x0087:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x0098:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x00a9:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x00bd:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            boolean r3 = oneofBooleanAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashBoolean(r3)
            goto L_0x002e
        L_0x00cf:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x00dd:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x00ef:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x00fd:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x010f:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0121:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            float r3 = oneofFloatAt(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x002e
        L_0x0133:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            double r3 = oneofDoubleAt(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0149:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x0155:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x0161:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            if (r3 == 0) goto L_0x016b
            int r7 = r3.hashCode()
        L_0x016b:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0229
        L_0x0170:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x017c:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x0184:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0190:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x0198:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x01a0:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x01a8:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x01b4:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            if (r3 == 0) goto L_0x016b
            int r7 = r3.hashCode()
            goto L_0x016b
        L_0x01bf:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x01cd:
            int r2 = r2 * 53
            boolean r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getBoolean((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashBoolean(r3)
            goto L_0x002e
        L_0x01d9:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x01e1:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x01ed:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x01f5:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0201:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x020d:
            int r2 = r2 * 53
            float r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getFloat((java.lang.Object) r9, (long) r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x002e
        L_0x0219:
            int r2 = r2 * 53
            double r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getDouble((java.lang.Object) r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0229:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022d:
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r8.unknownFieldSchema
            java.lang.Object r0 = r0.getFromMessage(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.hasExtensions
            if (r0 == 0) goto L_0x024b
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r8.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r9 = r0.getExtensions(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.hashCode(java.lang.Object):int");
    }

    public final boolean isInitialized(T t5) {
        int i5;
        int i6;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i8 < this.checkInitializedCount) {
            int i10 = this.intArray[i8];
            int numberAt = numberAt(i10);
            int typeAndOffsetAt = typeAndOffsetAt(i10);
            int i11 = this.buffer[i10 + 2];
            int i12 = i11 & 1048575;
            int i13 = 1 << (i11 >>> 20);
            if (i12 != i7) {
                if (i12 != 1048575) {
                    i9 = UNSAFE.getInt(t5, (long) i12);
                }
                i5 = i9;
                i6 = i12;
            } else {
                i6 = i7;
                i5 = i9;
            }
            T t6 = t5;
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t6, i10, i6, i5, i13)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t6, numberAt, i10) && !isInitialized(t6, typeAndOffsetAt, getMessageFieldSchema(i10))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t6, typeAndOffsetAt, i10)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t6, typeAndOffsetAt, i10)) {
                    return false;
                }
            } else if (isFieldPresent(t6, i10, i6, i5, i13) && !isInitialized(t6, typeAndOffsetAt, getMessageFieldSchema(i10))) {
                return false;
            }
            i8++;
            t5 = t6;
            i7 = i6;
            i9 = i5;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t5).isInitialized();
    }

    public void makeImmutable(T t5) {
        if (isMutable(t5)) {
            if (t5 instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t5;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i5 = 0; i5 < length; i5 += 3) {
                int typeAndOffsetAt = typeAndOffsetAt(i5);
                long offset = offset(typeAndOffsetAt);
                int type = type(typeAndOffsetAt);
                if (type != 9) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t5, numberAt(i5), i5)) {
                            getMessageFieldSchema(i5).makeImmutable(UNSAFE.getObject(t5, offset));
                        }
                    } else {
                        switch (type) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.listFieldSchema.makeImmutableListAt(t5, offset);
                                continue;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(t5, offset);
                                if (object != null) {
                                    unsafe.putObject(t5, offset, this.mapFieldSchema.toImmutable(object));
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (isFieldPresent(t5, i5)) {
                    getMessageFieldSchema(i5).makeImmutable(UNSAFE.getObject(t5, offset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t5);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t5);
            }
        }
    }

    public void mergeFrom(T t5, T t6) {
        checkMutable(t5);
        t6.getClass();
        for (int i5 = 0; i5 < this.buffer.length; i5 += 3) {
            mergeSingleField(t5, t6, i5);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t5, t6);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t5, t6);
        }
    }

    public T newInstance() {
        return this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSetLite} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v77, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v78, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02e8, code lost:
        r9 = r0;
        r24 = r3;
        r17 = r10;
        r0 = r13;
        r2 = r14;
        r19 = r18;
        r13 = r8;
        r8 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x001e, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x001e, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a3, code lost:
        r3 = r9;
        r14 = r19;
        r9 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d5, code lost:
        r8 = r10;
        r6 = r11;
        r11 = r18;
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0107, code lost:
        r7 = r9;
        r6 = r11;
        r11 = r18;
        r5 = r21;
        r9 = r2;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x010f, code lost:
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0117, code lost:
        r14 = r9;
        r9 = r8;
        r8 = r14;
        r14 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x011b, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0137, code lost:
        r12 = r12 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0139, code lost:
        r4 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01b0, code lost:
        r12 = r12 | r20;
        r4 = r30;
        r7 = r3;
        r6 = r11;
        r11 = r18;
        r5 = r21;
        r3 = r2;
        r2 = r1;
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01ca, code lost:
        r14 = r9;
        r9 = r1;
        r1 = r8;
        r8 = r3;
        r3 = r14;
        r14 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0261, code lost:
        r4 = r30;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0263, code lost:
        r7 = r8;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02ca, code lost:
        r12 = r12 | r20;
        r4 = r3;
        r3 = r2;
        r2 = r9;
        r9 = r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x043e  */
    @androidx.datastore.preferences.protobuf.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseMessage(T r27, byte[] r28, int r29, int r30, int r31, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r15 = r31
            r7 = r32
            checkMutable(r1)
            sun.misc.Unsafe r9 = UNSAFE
            r16 = 0
            r11 = -1
            r3 = r29
            r5 = r11
            r6 = r16
            r12 = r6
            r13 = r12
            r8 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r3 >= r4) goto L_0x045b
            int r13 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x002c
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r3, r2, r13, r7)
            int r3 = r7.int1
        L_0x002c:
            r25 = r13
            r13 = r3
            r3 = r25
            int r14 = r13 >>> 3
            r7 = r13 & 7
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r10 = 3
            if (r14 <= r5) goto L_0x0041
            int r6 = r6 / r10
            int r5 = r0.positionForFieldNumber(r14, r6)
            goto L_0x0045
        L_0x0041:
            int r5 = r0.positionForFieldNumber(r14)
        L_0x0045:
            if (r5 != r11) goto L_0x0058
            r2 = r3
            r17 = r8
            r24 = r9
            r19 = r11
            r21 = r14
            r8 = r16
            r9 = r0
            r0 = r13
        L_0x0054:
            r13 = r32
            goto L_0x040e
        L_0x0058:
            int[] r6 = r0.buffer
            int r18 = r5 + 1
            r6 = r6[r18]
            r18 = r11
            int r11 = type(r6)
            r19 = r3
            long r3 = offset(r6)
            r10 = 17
            if (r11 > r10) goto L_0x02f5
            int[] r10 = r0.buffer
            int r20 = r5 + 2
            r10 = r10[r20]
            int r20 = r10 >>> 20
            r2 = 1
            int r20 = r2 << r20
            r10 = r10 & r17
            if (r10 == r8) goto L_0x0095
            r21 = r14
            r14 = r17
            r22 = r3
            if (r8 == r14) goto L_0x0089
            long r2 = (long) r8
            r9.putInt(r1, r2, r12)
        L_0x0089:
            if (r10 != r14) goto L_0x008e
            r2 = r16
            goto L_0x0093
        L_0x008e:
            long r2 = (long) r10
            int r2 = r9.getInt(r1, r2)
        L_0x0093:
            r12 = r2
            goto L_0x009c
        L_0x0095:
            r22 = r3
            r21 = r14
            r14 = r17
            r10 = r8
        L_0x009c:
            r2 = 5
            switch(r11) {
                case 0: goto L_0x02d1;
                case 1: goto L_0x02b5;
                case 2: goto L_0x028a;
                case 3: goto L_0x028a;
                case 4: goto L_0x026c;
                case 5: goto L_0x0238;
                case 6: goto L_0x0219;
                case 7: goto L_0x01f4;
                case 8: goto L_0x01d2;
                case 9: goto L_0x0189;
                case 10: goto L_0x0172;
                case 11: goto L_0x026c;
                case 12: goto L_0x013c;
                case 13: goto L_0x0219;
                case 14: goto L_0x0238;
                case 15: goto L_0x011e;
                case 16: goto L_0x00e1;
                case 17: goto L_0x00aa;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            r8 = r32
            r11 = r5
        L_0x00a3:
            r3 = r9
            r14 = r19
            r9 = r28
            goto L_0x02e8
        L_0x00aa:
            r2 = 3
            if (r7 != r2) goto L_0x00dd
            java.lang.Object r2 = r0.mutableMessageFieldForMerge(r1, r5)
            int r3 = r21 << 3
            r7 = r3 | 4
            androidx.datastore.preferences.protobuf.Schema r3 = r0.getMessageFieldSchema(r5)
            r4 = r28
            r6 = r30
            r8 = r32
            r11 = r5
            r5 = r19
            int r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.mergeGroupField(r2, r3, r4, r5, r6, r7, r8)
            r25 = r4
            r4 = r2
            r2 = r8
            r8 = r25
            r0.storeMessageField(r1, r11, r4)
            r12 = r12 | r20
            r4 = r30
            r7 = r2
            r2 = r8
        L_0x00d5:
            r8 = r10
            r6 = r11
            r11 = r18
            r5 = r21
            goto L_0x001e
        L_0x00dd:
            r11 = r5
            r8 = r32
            goto L_0x00a3
        L_0x00e1:
            r8 = r28
            r2 = r32
            r11 = r5
            r3 = r19
            if (r7 != 0) goto L_0x0112
            int r7 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r8, r3, r2)
            long r3 = r2.long1
            long r5 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag64(r3)
            r3 = r2
            r2 = r1
            r1 = r9
            r9 = r3
            r3 = r22
            r1.putLong(r2, r3, r5)
            r25 = r2
            r2 = r1
            r1 = r25
            r12 = r12 | r20
            r4 = r30
            r3 = r7
        L_0x0107:
            r7 = r9
            r6 = r11
            r11 = r18
            r5 = r21
            r9 = r2
            r2 = r8
        L_0x010f:
            r8 = r10
            goto L_0x001e
        L_0x0112:
            r25 = r9
            r9 = r2
            r2 = r25
        L_0x0117:
            r14 = r9
            r9 = r8
            r8 = r14
            r14 = r3
        L_0x011b:
            r3 = r2
            goto L_0x02e8
        L_0x011e:
            r8 = r28
            r11 = r5
            r2 = r9
            r3 = r19
            r4 = r22
            r9 = r32
            if (r7 != 0) goto L_0x0117
            int r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r8, r3, r9)
            int r6 = r9.int1
            int r6 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag32(r6)
            r2.putInt(r1, r4, r6)
        L_0x0137:
            r12 = r12 | r20
        L_0x0139:
            r4 = r30
            goto L_0x0107
        L_0x013c:
            r8 = r28
            r11 = r5
            r2 = r9
            r3 = r19
            r4 = r22
            r9 = r32
            if (r7 != 0) goto L_0x0117
            int r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r8, r3, r9)
            int r7 = r9.int1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r14 = r0.getEnumFieldVerifier(r11)
            boolean r6 = isLegacyEnumIsClosed(r6)
            if (r6 == 0) goto L_0x016e
            if (r14 == 0) goto L_0x016e
            boolean r6 = r14.isInRange(r7)
            if (r6 == 0) goto L_0x0161
            goto L_0x016e
        L_0x0161:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = getMutableUnknownFields(r1)
            long r5 = (long) r7
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r4.storeField(r13, r5)
            goto L_0x0139
        L_0x016e:
            r2.putInt(r1, r4, r7)
            goto L_0x0137
        L_0x0172:
            r8 = r28
            r11 = r5
            r2 = r9
            r3 = r19
            r4 = r22
            r14 = 2
            r9 = r32
            if (r7 != r14) goto L_0x0117
            int r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeBytes(r8, r3, r9)
            java.lang.Object r6 = r9.object1
            r2.putObject(r1, r4, r6)
            goto L_0x0137
        L_0x0189:
            r8 = r28
            r11 = r5
            r2 = r9
            r3 = r19
            r14 = 2
            r9 = r32
            if (r7 != r14) goto L_0x01bf
            r4 = r1
            java.lang.Object r1 = r0.mutableMessageFieldForMerge(r4, r11)
            r5 = r2
            androidx.datastore.preferences.protobuf.Schema r2 = r0.getMessageFieldSchema(r11)
            r6 = r4
            r4 = r3
            r3 = r8
            r8 = r6
            r6 = r9
            r9 = r5
            r5 = r30
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.mergeMessageField(r1, r2, r3, r4, r5, r6)
            r4 = r1
            r1 = r3
            r3 = r6
            r0.storeMessageField(r8, r11, r4)
        L_0x01b0:
            r12 = r12 | r20
            r4 = r30
            r7 = r3
            r6 = r11
            r11 = r18
            r5 = r21
            r3 = r2
            r2 = r1
            r1 = r8
            goto L_0x010f
        L_0x01bf:
            r25 = r8
            r8 = r1
            r1 = r25
            r25 = r9
            r9 = r2
            r2 = r3
            r3 = r25
        L_0x01ca:
            r14 = r9
            r9 = r1
            r1 = r8
            r8 = r3
            r3 = r14
            r14 = r2
            goto L_0x02e8
        L_0x01d2:
            r3 = r32
            r8 = r1
            r11 = r5
            r2 = r19
            r4 = r22
            r14 = 2
            r1 = r28
            if (r7 != r14) goto L_0x01ca
            boolean r6 = isEnforceUtf8(r6)
            if (r6 == 0) goto L_0x01ea
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeStringRequireUtf8(r1, r2, r3)
            goto L_0x01ee
        L_0x01ea:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeString(r1, r2, r3)
        L_0x01ee:
            java.lang.Object r6 = r3.object1
            r9.putObject(r8, r4, r6)
            goto L_0x01b0
        L_0x01f4:
            r3 = r32
            r8 = r1
            r11 = r5
            r2 = r19
            r5 = r22
            r1 = r28
            if (r7 != 0) goto L_0x01ca
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r1, r2, r3)
            r22 = r5
            long r4 = r3.long1
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0212
            r4 = 1
        L_0x020f:
            r5 = r22
            goto L_0x0215
        L_0x0212:
            r4 = r16
            goto L_0x020f
        L_0x0215:
            androidx.datastore.preferences.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r8, (long) r5, (boolean) r4)
            goto L_0x01b0
        L_0x0219:
            r3 = r32
            r8 = r1
            r11 = r5
            r14 = r19
            r5 = r22
            r1 = r28
            if (r7 != r2) goto L_0x022f
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFixed32(r1, r14)
            r9.putInt(r8, r5, r2)
            int r2 = r14 + 4
            goto L_0x01b0
        L_0x022f:
            r25 = r9
            r9 = r1
            r1 = r8
            r8 = r3
            r3 = r25
            goto L_0x02e8
        L_0x0238:
            r3 = r32
            r8 = r1
            r11 = r5
            r14 = r19
            r5 = r22
            r4 = 1
            r1 = r28
            if (r7 != r4) goto L_0x0266
            r22 = r5
            long r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFixed64(r1, r14)
            r2 = r9
            r9 = r1
            r1 = r2
            r2 = r8
            r8 = r3
            r3 = r22
            r1.putLong(r2, r3, r5)
            r25 = r2
            r2 = r1
            r1 = r25
            int r3 = r14 + 8
            r12 = r12 | r20
            r4 = r9
            r9 = r2
            r2 = r4
        L_0x0261:
            r4 = r30
        L_0x0263:
            r7 = r8
            goto L_0x00d5
        L_0x0266:
            r2 = r9
            r9 = r1
            r1 = r8
            r8 = r3
            goto L_0x011b
        L_0x026c:
            r8 = r32
            r11 = r5
            r2 = r9
            r14 = r19
            r3 = r22
            r9 = r28
            if (r7 != 0) goto L_0x011b
            int r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r9, r14, r8)
            int r6 = r8.int1
            r2.putInt(r1, r3, r6)
            r12 = r12 | r20
            r3 = r9
            r9 = r2
            r2 = r3
            r4 = r30
            r3 = r5
            goto L_0x0263
        L_0x028a:
            r8 = r32
            r11 = r5
            r2 = r9
            r14 = r19
            r3 = r22
            r9 = r28
            if (r7 != 0) goto L_0x011b
            int r7 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r9, r14, r8)
            long r5 = r8.long1
            r25 = r2
            r2 = r1
            r1 = r25
            r1.putLong(r2, r3, r5)
            r3 = r1
            r1 = r2
            r12 = r12 | r20
            r4 = r30
            r2 = r9
            r6 = r11
            r11 = r18
            r5 = r21
            r9 = r3
            r3 = r7
            r7 = r8
            goto L_0x010f
        L_0x02b5:
            r8 = r32
            r11 = r5
            r3 = r9
            r14 = r19
            r4 = r22
            r9 = r28
            if (r7 != r2) goto L_0x02e8
            float r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFloat(r9, r14)
            androidx.datastore.preferences.protobuf.UnsafeUtil.putFloat((java.lang.Object) r1, (long) r4, (float) r2)
            int r2 = r14 + 4
        L_0x02ca:
            r12 = r12 | r20
            r4 = r3
            r3 = r2
            r2 = r9
            r9 = r4
            goto L_0x0261
        L_0x02d1:
            r8 = r32
            r11 = r5
            r3 = r9
            r14 = r19
            r4 = r22
            r2 = 1
            r9 = r28
            if (r7 != r2) goto L_0x02e8
            double r6 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeDouble(r9, r14)
            androidx.datastore.preferences.protobuf.UnsafeUtil.putDouble((java.lang.Object) r1, (long) r4, (double) r6)
            int r2 = r14 + 8
            goto L_0x02ca
        L_0x02e8:
            r9 = r0
            r24 = r3
            r17 = r10
            r0 = r13
            r2 = r14
            r19 = r18
            r13 = r8
            r8 = r11
            goto L_0x040e
        L_0x02f5:
            r10 = r8
            r21 = r14
            r14 = r19
            r8 = r5
            r4 = r3
            r3 = r9
            r9 = r28
            r2 = 27
            if (r11 != r2) goto L_0x0351
            r2 = 2
            if (r7 != r2) goto L_0x0345
            java.lang.Object r2 = r3.getObject(r1, r4)
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r2 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r2
            boolean r6 = r2.isModifiable()
            if (r6 != 0) goto L_0x0324
            int r6 = r2.size()
            if (r6 != 0) goto L_0x031b
            r6 = 10
            goto L_0x031d
        L_0x031b:
            int r6 = r6 * 2
        L_0x031d:
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r2 = r2.mutableCopyWithCapacity(r6)
            r3.putObject(r1, r4, r2)
        L_0x0324:
            r6 = r2
            androidx.datastore.preferences.protobuf.Schema r1 = r0.getMessageFieldSchema(r8)
            r2 = r9
            r9 = r3
            r3 = r2
            r5 = r30
            r7 = r32
            r2 = r13
            r4 = r14
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeMessageList(r1, r2, r3, r4, r5, r6, r7)
            r4 = r30
            r3 = r1
            r6 = r8
            r8 = r10
            r11 = r18
            r5 = r21
            r1 = r27
            r2 = r28
            goto L_0x001e
        L_0x0345:
            r9 = r3
            r24 = r9
            r17 = r10
            r3 = r14
            r19 = r18
            r18 = r12
            goto L_0x03d9
        L_0x0351:
            r9 = r3
            r2 = r13
            r3 = r14
            r1 = 49
            if (r11 > r1) goto L_0x0396
            r1 = r9
            r13 = r10
            long r9 = (long) r6
            r14 = r32
            r24 = r1
            r17 = r13
            r19 = r18
            r6 = r21
            r1 = r27
            r18 = r12
            r12 = r4
            r4 = r30
            r5 = r2
            r2 = r28
            int r7 = r0.parseRepeatedField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r13 = r5
            if (r7 == r3) goto L_0x038e
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r3 = r7
            r6 = r8
            r8 = r17
            r12 = r18
        L_0x0384:
            r11 = r19
            r5 = r21
            r9 = r24
            r7 = r32
            goto L_0x001e
        L_0x038e:
            r9 = r26
            r2 = r7
        L_0x0391:
            r0 = r13
            r12 = r18
            goto L_0x0054
        L_0x0396:
            r13 = r2
            r22 = r4
            r24 = r9
            r17 = r10
            r9 = r11
            r19 = r18
            r18 = r12
            r0 = 50
            if (r9 != r0) goto L_0x03dd
            r14 = 2
            if (r7 != r14) goto L_0x03d9
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r5 = r8
            r6 = r22
            r8 = r32
            int r6 = r0.parseMapField(r1, r2, r3, r4, r5, r6, r8)
            r8 = r5
            if (r6 == r3) goto L_0x03d5
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r7 = r32
            r3 = r6
            r6 = r8
            r8 = r17
            r12 = r18
            r11 = r19
            r5 = r21
        L_0x03d1:
            r9 = r24
            goto L_0x001e
        L_0x03d5:
            r9 = r26
            r2 = r6
            goto L_0x0391
        L_0x03d9:
            r9 = r26
            r2 = r3
            goto L_0x0391
        L_0x03dd:
            r0 = r26
            r1 = r27
            r2 = r28
            r4 = r30
            r12 = r8
            r5 = r13
            r10 = r22
            r13 = r32
            r8 = r6
            r6 = r21
            int r7 = r0.parseOneofField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            r9 = r0
            r0 = r5
            r8 = r12
            if (r7 == r3) goto L_0x040b
            r1 = r27
            r2 = r28
            r4 = r30
            r3 = r7
            r6 = r8
            r7 = r13
            r8 = r17
            r12 = r18
            r11 = r19
            r5 = r21
            r13 = r0
            r0 = r9
            goto L_0x03d1
        L_0x040b:
            r2 = r7
            r12 = r18
        L_0x040e:
            if (r0 != r15) goto L_0x041e
            if (r15 == 0) goto L_0x041e
            r6 = r27
            r7 = r30
            r13 = r0
            r8 = r2
        L_0x0418:
            r0 = r17
            r14 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0466
        L_0x041e:
            boolean r1 = r9.hasExtensions
            if (r1 == 0) goto L_0x043e
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r1 = r13.extensionRegistry
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r3 = androidx.datastore.preferences.protobuf.ExtensionRegistryLite.getEmptyRegistry()
            if (r1 == r3) goto L_0x043e
            androidx.datastore.preferences.protobuf.MessageLite r5 = r9.defaultInstance
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r6 = r9.unknownFieldSchema
            r4 = r27
            r1 = r28
            r3 = r30
            r7 = r13
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeExtensionOrUnknownField(r0, r1, r2, r3, r4, r5, r6, r7)
            r6 = r4
            r7 = r30
        L_0x043c:
            r3 = r2
            goto L_0x0450
        L_0x043e:
            r6 = r27
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = getMutableUnknownFields(r6)
            r1 = r28
            r3 = r30
            r5 = r32
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeUnknownField(r0, r1, r2, r3, r4, r5)
            r7 = r3
            goto L_0x043c
        L_0x0450:
            r2 = r28
            r13 = r0
            r1 = r6
            r4 = r7
            r6 = r8
            r0 = r9
            r8 = r17
            goto L_0x0384
        L_0x045b:
            r6 = r1
            r7 = r4
            r17 = r8
            r24 = r9
            r18 = r12
            r9 = r0
            r8 = r3
            goto L_0x0418
        L_0x0466:
            if (r0 == r14) goto L_0x046e
            long r0 = (long) r0
            r2 = r24
            r2.putInt(r6, r0, r12)
        L_0x046e:
            int r0 = r9.checkInitializedCount
            r1 = 0
            r10 = r0
            r3 = r1
        L_0x0473:
            int r0 = r9.repeatedFieldOffsetStart
            if (r10 >= r0) goto L_0x048b
            int[] r0 = r9.intArray
            r2 = r0[r10]
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r4 = r9.unknownFieldSchema
            r5 = r27
            r1 = r6
            r0 = r9
            java.lang.Object r2 = r0.filterMapUnknownEnumValues(r1, r2, r3, r4, r5)
            r3 = r2
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r3 = (androidx.datastore.preferences.protobuf.UnknownFieldSetLite) r3
            int r10 = r10 + 1
            goto L_0x0473
        L_0x048b:
            r1 = r6
            r0 = r9
            if (r3 == 0) goto L_0x0494
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            r2.setBuilderToMessage(r1, r3)
        L_0x0494:
            if (r15 != 0) goto L_0x049e
            if (r8 != r7) goto L_0x0499
            goto L_0x04a2
        L_0x0499:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r1 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r1
        L_0x049e:
            if (r8 > r7) goto L_0x04a3
            if (r13 != r15) goto L_0x04a3
        L_0x04a2:
            return r8
        L_0x04a3:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r1 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.parseMessage(java.lang.Object, byte[], int, int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public void writeTo(T t5, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t5, writer);
        } else {
            writeFieldsInAscendingOrder(t5, writer);
        }
    }

    private boolean isFieldPresent(T t5, int i5) {
        boolean equals;
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i5);
        long j5 = (long) (1048575 & presenceMaskAndOffsetAt);
        if (j5 == 1048575) {
            int typeAndOffsetAt = typeAndOffsetAt(i5);
            long offset = offset(typeAndOffsetAt);
            switch (type(typeAndOffsetAt)) {
                case 0:
                    return Double.doubleToRawLongBits(UnsafeUtil.getDouble((Object) t5, offset)) != 0;
                case 1:
                    return Float.floatToRawIntBits(UnsafeUtil.getFloat((Object) t5, offset)) != 0;
                case 2:
                    return UnsafeUtil.getLong((Object) t5, offset) != 0;
                case 3:
                    return UnsafeUtil.getLong((Object) t5, offset) != 0;
                case 4:
                    return UnsafeUtil.getInt((Object) t5, offset) != 0;
                case 5:
                    return UnsafeUtil.getLong((Object) t5, offset) != 0;
                case 6:
                    return UnsafeUtil.getInt((Object) t5, offset) != 0;
                case 7:
                    return UnsafeUtil.getBoolean((Object) t5, offset);
                case 8:
                    Object object = UnsafeUtil.getObject((Object) t5, offset);
                    if (object instanceof String) {
                        equals = ((String) object).isEmpty();
                        break;
                    } else if (object instanceof ByteString) {
                        equals = ByteString.EMPTY.equals(object);
                        break;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    return UnsafeUtil.getObject((Object) t5, offset) != null;
                case 10:
                    equals = ByteString.EMPTY.equals(UnsafeUtil.getObject((Object) t5, offset));
                    break;
                case 11:
                    return UnsafeUtil.getInt((Object) t5, offset) != 0;
                case 12:
                    return UnsafeUtil.getInt((Object) t5, offset) != 0;
                case 13:
                    return UnsafeUtil.getInt((Object) t5, offset) != 0;
                case 14:
                    return UnsafeUtil.getLong((Object) t5, offset) != 0;
                case 15:
                    return UnsafeUtil.getInt((Object) t5, offset) != 0;
                case 16:
                    return UnsafeUtil.getLong((Object) t5, offset) != 0;
                case 17:
                    return UnsafeUtil.getObject((Object) t5, offset) != null;
                default:
                    throw new IllegalArgumentException();
            }
            return !equals;
        }
        return (UnsafeUtil.getInt((Object) t5, j5) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0;
    }

    private int positionForFieldNumber(int i5, int i6) {
        if (i5 < this.minFieldNumber || i5 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i5, i6);
    }

    public void mergeFrom(T t5, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        checkMutable(t5);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t5, reader, extensionRegistryLite);
    }

    private boolean equals(T t5, T t6, int i5) {
        int typeAndOffsetAt = typeAndOffsetAt(i5);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t5, t6, i5) && Double.doubleToLongBits(UnsafeUtil.getDouble((Object) t5, offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble((Object) t6, offset));
            case 1:
                return arePresentForEquals(t5, t6, i5) && Float.floatToIntBits(UnsafeUtil.getFloat((Object) t5, offset)) == Float.floatToIntBits(UnsafeUtil.getFloat((Object) t6, offset));
            case 2:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getLong((Object) t5, offset) == UnsafeUtil.getLong((Object) t6, offset);
            case 3:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getLong((Object) t5, offset) == UnsafeUtil.getLong((Object) t6, offset);
            case 4:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt((Object) t5, offset) == UnsafeUtil.getInt((Object) t6, offset);
            case 5:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getLong((Object) t5, offset) == UnsafeUtil.getLong((Object) t6, offset);
            case 6:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt((Object) t5, offset) == UnsafeUtil.getInt((Object) t6, offset);
            case 7:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getBoolean((Object) t5, offset) == UnsafeUtil.getBoolean((Object) t6, offset);
            case 8:
                return arePresentForEquals(t5, t6, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t5, offset), UnsafeUtil.getObject((Object) t6, offset));
            case 9:
                return arePresentForEquals(t5, t6, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t5, offset), UnsafeUtil.getObject((Object) t6, offset));
            case 10:
                return arePresentForEquals(t5, t6, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t5, offset), UnsafeUtil.getObject((Object) t6, offset));
            case 11:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt((Object) t5, offset) == UnsafeUtil.getInt((Object) t6, offset);
            case 12:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt((Object) t5, offset) == UnsafeUtil.getInt((Object) t6, offset);
            case 13:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt((Object) t5, offset) == UnsafeUtil.getInt((Object) t6, offset);
            case 14:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getLong((Object) t5, offset) == UnsafeUtil.getLong((Object) t6, offset);
            case 15:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt((Object) t5, offset) == UnsafeUtil.getInt((Object) t6, offset);
            case 16:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getLong((Object) t5, offset) == UnsafeUtil.getLong((Object) t6, offset);
            case 17:
                return arePresentForEquals(t5, t6, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t5, offset), UnsafeUtil.getObject((Object) t6, offset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t5, offset), UnsafeUtil.getObject((Object) t6, offset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t5, offset), UnsafeUtil.getObject((Object) t6, offset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return isOneofCaseEqual(t5, t6, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t5, offset), UnsafeUtil.getObject((Object) t6, offset));
            default:
                return true;
        }
    }

    public void mergeFrom(T t5, byte[] bArr, int i5, int i6, ArrayDecoders.Registers registers) throws IOException {
        parseMessage(t5, bArr, i5, i6, 0, registers);
    }

    private static boolean isInitialized(Object obj, int i5, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i5)));
    }
}
