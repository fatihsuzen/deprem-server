package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import java.io.IOException;

@CheckReturnValue
final class ArrayDecoders {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    /* renamed from: androidx.datastore.preferences.protobuf.ArrayDecoders$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
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
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x003e }
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
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00d8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.AnonymousClass1.<clinit>():void");
        }
    }

    private ArrayDecoders() {
    }

    private static void checkRecursionLimit(int i5) throws InvalidProtocolBufferException {
        if (i5 >= recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    static int decodeBoolList(int i5, byte[] bArr, int i6, int i7, Internal.ProtobufList<?> protobufList, Registers registers) {
        boolean z4;
        boolean z5;
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i6, registers);
        if (registers.long1 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        booleanArrayList.addBoolean(z4);
        while (decodeVarint64 < i7) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i5 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            if (registers.long1 != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            booleanArrayList.addBoolean(z5);
        }
        return decodeVarint64;
    }

    static int decodeBytes(byte[] bArr, int i5, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i6 > bArr.length - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i6 == 0) {
            registers.object1 = ByteString.EMPTY;
            return decodeVarint32;
        } else {
            registers.object1 = ByteString.copyFrom(bArr, decodeVarint32, i6);
            return decodeVarint32 + i6;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[EDGE_INSN: B:30:0x004d->B:22:0x004d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int decodeBytesList(int r2, byte[] r3, int r4, int r5, androidx.datastore.preferences.protobuf.Internal.ProtobufList<?> r6, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r7) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        /*
            int r4 = decodeVarint32(r3, r4, r7)
            int r0 = r7.int1
            if (r0 < 0) goto L_0x0053
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x004e
            if (r0 != 0) goto L_0x0014
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x0014:
            androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
        L_0x001b:
            int r4 = r4 + r0
        L_0x001c:
            if (r4 >= r5) goto L_0x004d
            int r0 = decodeVarint32(r3, r4, r7)
            int r1 = r7.int1
            if (r2 == r1) goto L_0x0027
            goto L_0x004d
        L_0x0027:
            int r4 = decodeVarint32(r3, r0, r7)
            int r0 = r7.int1
            if (r0 < 0) goto L_0x0048
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0043
            if (r0 != 0) goto L_0x003b
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L_0x001c
        L_0x003b:
            androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
            goto L_0x001b
        L_0x0043:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L_0x0048:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        L_0x004d:
            return r4
        L_0x004e:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r2
        L_0x0053:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r2 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.decodeBytesList(int, byte[], int, int, androidx.datastore.preferences.protobuf.Internal$ProtobufList, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    static double decodeDouble(byte[] bArr, int i5) {
        return Double.longBitsToDouble(decodeFixed64(bArr, i5));
    }

    static int decodeDoubleList(int i5, byte[] bArr, int i6, int i7, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.addDouble(decodeDouble(bArr, i6));
        int i8 = i6 + 8;
        while (i8 < i7) {
            int decodeVarint32 = decodeVarint32(bArr, i8, registers);
            if (i5 != registers.int1) {
                break;
            }
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            i8 = decodeVarint32 + 8;
        }
        return i8;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0207, code lost:
        r9 = r11 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0214, code lost:
        r9 = r11 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int decodeExtension(int r7, byte[] r8, int r9, int r10, androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage<?, ?> r11, androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> r12, androidx.datastore.preferences.protobuf.UnknownFieldSchema<androidx.datastore.preferences.protobuf.UnknownFieldSetLite, androidx.datastore.preferences.protobuf.UnknownFieldSetLite> r13, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r14) throws java.io.IOException {
        /*
            androidx.datastore.preferences.protobuf.FieldSet<androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor> r0 = r11.extensions
            int r2 = r7 >>> 3
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.descriptor
            boolean r7 = r7.isRepeated()
            if (r7 == 0) goto L_0x00e2
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.descriptor
            boolean r7 = r7.isPacked()
            if (r7 == 0) goto L_0x00e2
            int[] r7 = androidx.datastore.preferences.protobuf.ArrayDecoders.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r10 = r12.getLiteType()
            int r10 = r10.ordinal()
            r7 = r7[r10]
            switch(r7) {
                case 1: goto L_0x00d3;
                case 2: goto L_0x00c4;
                case 3: goto L_0x00b5;
                case 4: goto L_0x00b5;
                case 5: goto L_0x00a6;
                case 6: goto L_0x00a6;
                case 7: goto L_0x0097;
                case 8: goto L_0x0097;
                case 9: goto L_0x0088;
                case 10: goto L_0x0088;
                case 11: goto L_0x0079;
                case 12: goto L_0x006a;
                case 13: goto L_0x005b;
                case 14: goto L_0x0040;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Type cannot be packed: "
            r8.append(r9)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r9 = r9.getLiteType()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0040:
            androidx.datastore.preferences.protobuf.IntArrayList r3 = new androidx.datastore.preferences.protobuf.IntArrayList
            r3.<init>()
            int r7 = decodePackedVarint32List(r8, r9, r3, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r12.descriptor
            androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r4 = r8.getEnumType()
            r5 = 0
            r1 = r11
            r6 = r13
            androidx.datastore.preferences.protobuf.SchemaUtil.filterUnknownEnumList((java.lang.Object) r1, (int) r2, (java.util.List<java.lang.Integer>) r3, (androidx.datastore.preferences.protobuf.Internal.EnumLiteMap<?>) r4, r5, r6)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r12.descriptor
            r0.setField(r8, r3)
            return r7
        L_0x005b:
            androidx.datastore.preferences.protobuf.LongArrayList r7 = new androidx.datastore.preferences.protobuf.LongArrayList
            r7.<init>()
            int r8 = decodePackedSInt64List(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            return r8
        L_0x006a:
            androidx.datastore.preferences.protobuf.IntArrayList r7 = new androidx.datastore.preferences.protobuf.IntArrayList
            r7.<init>()
            int r8 = decodePackedSInt32List(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            return r8
        L_0x0079:
            androidx.datastore.preferences.protobuf.BooleanArrayList r7 = new androidx.datastore.preferences.protobuf.BooleanArrayList
            r7.<init>()
            int r8 = decodePackedBoolList(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            return r8
        L_0x0088:
            androidx.datastore.preferences.protobuf.IntArrayList r7 = new androidx.datastore.preferences.protobuf.IntArrayList
            r7.<init>()
            int r8 = decodePackedFixed32List(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            return r8
        L_0x0097:
            androidx.datastore.preferences.protobuf.LongArrayList r7 = new androidx.datastore.preferences.protobuf.LongArrayList
            r7.<init>()
            int r8 = decodePackedFixed64List(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            return r8
        L_0x00a6:
            androidx.datastore.preferences.protobuf.IntArrayList r7 = new androidx.datastore.preferences.protobuf.IntArrayList
            r7.<init>()
            int r8 = decodePackedVarint32List(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            return r8
        L_0x00b5:
            androidx.datastore.preferences.protobuf.LongArrayList r7 = new androidx.datastore.preferences.protobuf.LongArrayList
            r7.<init>()
            int r8 = decodePackedVarint64List(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            return r8
        L_0x00c4:
            androidx.datastore.preferences.protobuf.FloatArrayList r7 = new androidx.datastore.preferences.protobuf.FloatArrayList
            r7.<init>()
            int r8 = decodePackedFloatList(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            return r8
        L_0x00d3:
            androidx.datastore.preferences.protobuf.DoubleArrayList r7 = new androidx.datastore.preferences.protobuf.DoubleArrayList
            r7.<init>()
            int r8 = decodePackedDoubleList(r8, r9, r7, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r9 = r12.descriptor
            r0.setField(r9, r7)
            return r8
        L_0x00e2:
            r1 = r11
            r6 = r13
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r7 = r12.getLiteType()
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r11 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM
            r13 = 0
            if (r7 != r11) goto L_0x010d
            int r9 = decodeVarint32(r8, r9, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.descriptor
            androidx.datastore.preferences.protobuf.Internal$EnumLiteMap r7 = r7.getEnumType()
            int r8 = r14.int1
            androidx.datastore.preferences.protobuf.Internal$EnumLite r7 = r7.findValueByNumber(r8)
            if (r7 != 0) goto L_0x0105
            int r7 = r14.int1
            androidx.datastore.preferences.protobuf.SchemaUtil.storeUnknownEnum(r1, r2, r7, r13, r6)
            return r9
        L_0x0105:
            int r7 = r14.int1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r7)
            goto L_0x0249
        L_0x010d:
            int[] r7 = androidx.datastore.preferences.protobuf.ArrayDecoders.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r11 = r12.getLiteType()
            int r11 = r11.ordinal()
            r7 = r7[r11]
            switch(r7) {
                case 1: goto L_0x023e;
                case 2: goto L_0x0233;
                case 3: goto L_0x0225;
                case 4: goto L_0x0225;
                case 5: goto L_0x0217;
                case 6: goto L_0x0217;
                case 7: goto L_0x020a;
                case 8: goto L_0x020a;
                case 9: goto L_0x01fd;
                case 10: goto L_0x01fd;
                case 11: goto L_0x01e6;
                case 12: goto L_0x01d3;
                case 13: goto L_0x01c0;
                case 14: goto L_0x01b8;
                case 15: goto L_0x01ad;
                case 16: goto L_0x01a2;
                case 17: goto L_0x015b;
                case 18: goto L_0x011e;
                default: goto L_0x011c;
            }
        L_0x011c:
            goto L_0x0249
        L_0x011e:
            androidx.datastore.preferences.protobuf.Protobuf r7 = androidx.datastore.preferences.protobuf.Protobuf.getInstance()
            androidx.datastore.preferences.protobuf.MessageLite r11 = r12.getMessageDefaultInstance()
            java.lang.Class r11 = r11.getClass()
            androidx.datastore.preferences.protobuf.Schema r2 = r7.schemaFor(r11)
            boolean r7 = r12.isRepeated()
            if (r7 == 0) goto L_0x0140
            int r7 = decodeMessageField(r2, r8, r9, r10, r14)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r12.descriptor
            java.lang.Object r9 = r14.object1
            r0.addRepeatedField(r8, r9)
            return r7
        L_0x0140:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.descriptor
            java.lang.Object r7 = r0.getField(r7)
            if (r7 != 0) goto L_0x0151
            java.lang.Object r7 = r2.newInstance()
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r11 = r12.descriptor
            r0.setField(r11, r7)
        L_0x0151:
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r6 = r14
            int r7 = mergeMessageField(r1, r2, r3, r4, r5, r6)
            return r7
        L_0x015b:
            r11 = r9
            r4 = r10
            r6 = r14
            r10 = r8
            int r7 = r2 << 3
            r13 = r7 | 4
            androidx.datastore.preferences.protobuf.Protobuf r7 = androidx.datastore.preferences.protobuf.Protobuf.getInstance()
            androidx.datastore.preferences.protobuf.MessageLite r8 = r12.getMessageDefaultInstance()
            java.lang.Class r8 = r8.getClass()
            androidx.datastore.preferences.protobuf.Schema r9 = r7.schemaFor(r8)
            boolean r7 = r12.isRepeated()
            if (r7 == 0) goto L_0x0189
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r13
            int r7 = decodeGroupField(r1, r2, r3, r4, r5, r6)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r12.descriptor
            java.lang.Object r9 = r6.object1
            r0.addRepeatedField(r8, r9)
            return r7
        L_0x0189:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.descriptor
            java.lang.Object r7 = r0.getField(r7)
            if (r7 != 0) goto L_0x019a
            java.lang.Object r7 = r9.newInstance()
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r8 = r12.descriptor
            r0.setField(r8, r7)
        L_0x019a:
            r8 = r7
            r12 = r4
            r14 = r6
            int r7 = mergeGroupField(r8, r9, r10, r11, r12, r13, r14)
            return r7
        L_0x01a2:
            r10 = r8
            r11 = r9
            r6 = r14
            int r9 = decodeString(r10, r11, r6)
            java.lang.Object r13 = r6.object1
            goto L_0x0249
        L_0x01ad:
            r10 = r8
            r11 = r9
            r6 = r14
            int r9 = decodeBytes(r10, r11, r6)
            java.lang.Object r13 = r6.object1
            goto L_0x0249
        L_0x01b8:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Shouldn't reach here."
            r7.<init>(r8)
            throw r7
        L_0x01c0:
            r10 = r8
            r11 = r9
            r6 = r14
            int r9 = decodeVarint64(r10, r11, r6)
            long r7 = r6.long1
            long r7 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag64(r7)
            java.lang.Long r13 = java.lang.Long.valueOf(r7)
            goto L_0x0249
        L_0x01d3:
            r10 = r8
            r11 = r9
            r6 = r14
            int r9 = decodeVarint32(r10, r11, r6)
            int r7 = r6.int1
            int r7 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag32(r7)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r7)
            goto L_0x0249
        L_0x01e6:
            r10 = r8
            r11 = r9
            r6 = r14
            int r9 = decodeVarint64(r10, r11, r6)
            long r7 = r6.long1
            r10 = 0
            int r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r7 == 0) goto L_0x01f7
            r7 = 1
            goto L_0x01f8
        L_0x01f7:
            r7 = 0
        L_0x01f8:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r7)
            goto L_0x0249
        L_0x01fd:
            r10 = r8
            r11 = r9
            int r7 = decodeFixed32(r10, r11)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r7)
        L_0x0207:
            int r9 = r11 + 4
            goto L_0x0249
        L_0x020a:
            r10 = r8
            r11 = r9
            long r7 = decodeFixed64(r10, r11)
            java.lang.Long r13 = java.lang.Long.valueOf(r7)
        L_0x0214:
            int r9 = r11 + 8
            goto L_0x0249
        L_0x0217:
            r10 = r8
            r11 = r9
            r6 = r14
            int r9 = decodeVarint32(r10, r11, r6)
            int r7 = r6.int1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r7)
            goto L_0x0249
        L_0x0225:
            r10 = r8
            r11 = r9
            r6 = r14
            int r9 = decodeVarint64(r10, r11, r6)
            long r7 = r6.long1
            java.lang.Long r13 = java.lang.Long.valueOf(r7)
            goto L_0x0249
        L_0x0233:
            r10 = r8
            r11 = r9
            float r7 = decodeFloat(r10, r11)
            java.lang.Float r13 = java.lang.Float.valueOf(r7)
            goto L_0x0207
        L_0x023e:
            r10 = r8
            r11 = r9
            double r7 = decodeDouble(r10, r11)
            java.lang.Double r13 = java.lang.Double.valueOf(r7)
            goto L_0x0214
        L_0x0249:
            boolean r7 = r12.isRepeated()
            if (r7 == 0) goto L_0x0255
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.descriptor
            r0.addRepeatedField(r7, r13)
            return r9
        L_0x0255:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r12.descriptor
            r0.setField(r7, r13)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.decodeExtension(int, byte[], int, int, androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage, androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    static int decodeExtensionOrUnknownField(int i5, byte[] bArr, int i6, int i7, Object obj, MessageLite messageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension findLiteExtensionByNumber = registers.extensionRegistry.findLiteExtensionByNumber(messageLite, i5 >>> 3);
        if (findLiteExtensionByNumber == null) {
            return decodeUnknownField(i5, bArr, i6, i7, MessageSchema.getMutableUnknownFields(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.ensureExtensionsAreMutable();
        return decodeExtension(i5, bArr, i6, i7, extendableMessage, findLiteExtensionByNumber, unknownFieldSchema, registers);
    }

    static int decodeFixed32(byte[] bArr, int i5) {
        return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
    }

    static int decodeFixed32List(int i5, byte[] bArr, int i6, int i7, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.addInt(decodeFixed32(bArr, i6));
        int i8 = i6 + 4;
        while (i8 < i7) {
            int decodeVarint32 = decodeVarint32(bArr, i8, registers);
            if (i5 != registers.int1) {
                break;
            }
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            i8 = decodeVarint32 + 4;
        }
        return i8;
    }

    static long decodeFixed64(byte[] bArr, int i5) {
        return ((((long) bArr[i5 + 7]) & 255) << 56) | (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48);
    }

    static int decodeFixed64List(int i5, byte[] bArr, int i6, int i7, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.addLong(decodeFixed64(bArr, i6));
        int i8 = i6 + 8;
        while (i8 < i7) {
            int decodeVarint32 = decodeVarint32(bArr, i8, registers);
            if (i5 != registers.int1) {
                break;
            }
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            i8 = decodeVarint32 + 8;
        }
        return i8;
    }

    static float decodeFloat(byte[] bArr, int i5) {
        return Float.intBitsToFloat(decodeFixed32(bArr, i5));
    }

    static int decodeFloatList(int i5, byte[] bArr, int i6, int i7, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.addFloat(decodeFloat(bArr, i6));
        int i8 = i6 + 4;
        while (i8 < i7) {
            int decodeVarint32 = decodeVarint32(bArr, i8, registers);
            if (i5 != registers.int1) {
                break;
            }
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            i8 = decodeVarint32 + 4;
        }
        return i8;
    }

    static int decodeGroupField(Schema schema, byte[] bArr, int i5, int i6, int i7, Registers registers) throws IOException {
        Object newInstance = schema.newInstance();
        Schema schema2 = schema;
        Registers registers2 = registers;
        int mergeGroupField = mergeGroupField(newInstance, schema2, bArr, i5, i6, i7, registers2);
        schema2.makeImmutable(newInstance);
        registers2.object1 = newInstance;
        return mergeGroupField;
    }

    static int decodeGroupList(Schema schema, int i5, byte[] bArr, int i6, int i7, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int i8 = (i5 & -8) | 4;
        Schema schema2 = schema;
        byte[] bArr2 = bArr;
        int i9 = i7;
        Registers registers2 = registers;
        int decodeGroupField = decodeGroupField(schema2, bArr2, i6, i9, i8, registers2);
        protobufList.add(registers2.object1);
        while (decodeGroupField < i9) {
            int decodeVarint32 = decodeVarint32(bArr2, decodeGroupField, registers2);
            if (i5 != registers2.int1) {
                break;
            }
            decodeGroupField = decodeGroupField(schema2, bArr2, decodeVarint32, i9, i8, registers2);
            protobufList.add(registers2.object1);
        }
        return decodeGroupField;
    }

    static int decodeMessageField(Schema schema, byte[] bArr, int i5, int i6, Registers registers) throws IOException {
        Object newInstance = schema.newInstance();
        Schema schema2 = schema;
        Registers registers2 = registers;
        int mergeMessageField = mergeMessageField(newInstance, schema2, bArr, i5, i6, registers2);
        schema2.makeImmutable(newInstance);
        registers2.object1 = newInstance;
        return mergeMessageField;
    }

    static int decodeMessageList(Schema<?> schema, int i5, byte[] bArr, int i6, int i7, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int decodeMessageField = decodeMessageField(schema, bArr, i6, i7, registers);
        protobufList.add(registers.object1);
        while (decodeMessageField < i7) {
            int decodeVarint32 = decodeVarint32(bArr, decodeMessageField, registers);
            if (i5 != registers.int1) {
                break;
            }
            decodeMessageField = decodeMessageField(schema, bArr, decodeVarint32, i7, registers);
            protobufList.add(registers.object1);
        }
        return decodeMessageField;
    }

    static int decodePackedBoolList(byte[] bArr, int i5, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        boolean z4;
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            if (registers.long1 != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            booleanArrayList.addBoolean(z4);
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedDoubleList(byte[] bArr, int i5, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed32List(byte[] bArr, int i5, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed64List(byte[] bArr, int i5, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFloatList(byte[] bArr, int i5, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt32List(byte[] bArr, int i5, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt64List(byte[] bArr, int i5, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedVarint32List(byte[] bArr, int i5, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(registers.int1);
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedVarint64List(byte[] bArr, int i5, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodeSInt32List(int i5, byte[] bArr, int i6, int i7, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i6, registers);
        intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        while (decodeVarint32 < i7) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i5 != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        return decodeVarint32;
    }

    static int decodeSInt64List(int i5, byte[] bArr, int i6, int i7, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i6, registers);
        longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        while (decodeVarint64 < i7) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i5 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        return decodeVarint64;
    }

    static int decodeString(byte[] bArr, int i5, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i6 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        } else {
            registers.object1 = new String(bArr, decodeVarint32, i6, Internal.UTF_8);
            return decodeVarint32 + i6;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[EDGE_INSN: B:21:0x0044->B:17:0x0044 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    static int decodeStringList(int r4, byte[] r5, int r6, int r7, androidx.datastore.preferences.protobuf.Internal.ProtobufList<?> r8, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r9) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        /*
            int r6 = decodeVarint32(r5, r6, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L_0x0045
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r8.add(r1)
            goto L_0x001b
        L_0x0010:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = androidx.datastore.preferences.protobuf.Internal.UTF_8
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
        L_0x001a:
            int r6 = r6 + r0
        L_0x001b:
            if (r6 >= r7) goto L_0x0044
            int r0 = decodeVarint32(r5, r6, r9)
            int r2 = r9.int1
            if (r4 == r2) goto L_0x0026
            goto L_0x0044
        L_0x0026:
            int r6 = decodeVarint32(r5, r0, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L_0x003f
            if (r0 != 0) goto L_0x0034
            r8.add(r1)
            goto L_0x001b
        L_0x0034:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = androidx.datastore.preferences.protobuf.Internal.UTF_8
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
            goto L_0x001a
        L_0x003f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        L_0x0044:
            return r6
        L_0x0045:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.decodeStringList(int, byte[], int, int, androidx.datastore.preferences.protobuf.Internal$ProtobufList, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        r2 = r7 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (androidx.datastore.preferences.protobuf.Utf8.isValidUtf8(r6, r7, r2) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        r9.add(new java.lang.String(r6, r7, r0, androidx.datastore.preferences.protobuf.Internal.UTF_8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidUtf8();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[EDGE_INSN: B:28:0x0059->B:23:0x0059 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int decodeStringListRequireUtf8(int r5, byte[] r6, int r7, int r8, androidx.datastore.preferences.protobuf.Internal.ProtobufList<?> r9, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r10) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
        /*
            int r7 = decodeVarint32(r6, r7, r10)
            int r0 = r10.int1
            if (r0 < 0) goto L_0x005f
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r9.add(r1)
            goto L_0x0023
        L_0x0010:
            int r2 = r7 + r0
            boolean r3 = androidx.datastore.preferences.protobuf.Utf8.isValidUtf8(r6, r7, r2)
            if (r3 == 0) goto L_0x005a
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = androidx.datastore.preferences.protobuf.Internal.UTF_8
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
        L_0x0022:
            r7 = r2
        L_0x0023:
            if (r7 >= r8) goto L_0x0059
            int r0 = decodeVarint32(r6, r7, r10)
            int r2 = r10.int1
            if (r5 == r2) goto L_0x002e
            goto L_0x0059
        L_0x002e:
            int r7 = decodeVarint32(r6, r0, r10)
            int r0 = r10.int1
            if (r0 < 0) goto L_0x0054
            if (r0 != 0) goto L_0x003c
            r9.add(r1)
            goto L_0x0023
        L_0x003c:
            int r2 = r7 + r0
            boolean r3 = androidx.datastore.preferences.protobuf.Utf8.isValidUtf8(r6, r7, r2)
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = androidx.datastore.preferences.protobuf.Internal.UTF_8
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
            goto L_0x0022
        L_0x004f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L_0x0054:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        L_0x0059:
            return r7
        L_0x005a:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.invalidUtf8()
            throw r5
        L_0x005f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r5 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.decodeStringListRequireUtf8(int, byte[], int, int, androidx.datastore.preferences.protobuf.Internal$ProtobufList, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    static int decodeStringRequireUtf8(byte[] bArr, int i5, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i5, registers);
        int i6 = registers.int1;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i6 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        } else {
            registers.object1 = Utf8.decodeUtf8(bArr, decodeVarint32, i6);
            return decodeVarint32 + i6;
        }
    }

    static int decodeUnknownField(int i5, byte[] bArr, int i6, int i7, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i5) != 0) {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                Registers registers2 = registers;
                int decodeVarint64 = decodeVarint64(bArr, i6, registers2);
                unknownFieldSetLite.storeField(i5, Long.valueOf(registers2.long1));
                return decodeVarint64;
            } else if (tagWireType == 1) {
                unknownFieldSetLite.storeField(i5, Long.valueOf(decodeFixed64(bArr, i6)));
                return i6 + 8;
            } else if (tagWireType == 2) {
                byte[] bArr2 = bArr;
                Registers registers3 = registers;
                int decodeVarint32 = decodeVarint32(bArr2, i6, registers3);
                int i8 = registers3.int1;
                if (i8 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                } else if (i8 <= bArr2.length - decodeVarint32) {
                    if (i8 == 0) {
                        unknownFieldSetLite.storeField(i5, ByteString.EMPTY);
                    } else {
                        unknownFieldSetLite.storeField(i5, ByteString.copyFrom(bArr2, decodeVarint32, i8));
                    }
                    return decodeVarint32 + i8;
                } else {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } else if (tagWireType == 3) {
                UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
                int i9 = (i5 & -8) | 4;
                int i10 = registers.recursionDepth + 1;
                registers.recursionDepth = i10;
                checkRecursionLimit(i10);
                int i11 = 0;
                while (true) {
                    if (i6 >= i7) {
                        break;
                    }
                    int decodeVarint322 = decodeVarint32(bArr, i6, registers);
                    i11 = registers.int1;
                    if (i11 == i9) {
                        i6 = decodeVarint322;
                        break;
                    }
                    i6 = decodeUnknownField(i11, bArr, decodeVarint322, i7, newInstance, registers);
                }
                int i12 = i7;
                registers.recursionDepth--;
                if (i6 > i12 || i11 != i9) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
                unknownFieldSetLite.storeField(i5, newInstance);
                return i6;
            } else if (tagWireType == 5) {
                unknownFieldSetLite.storeField(i5, Integer.valueOf(decodeFixed32(bArr, i6)));
                return i6 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }

    static int decodeVarint32(byte[] bArr, int i5, Registers registers) {
        int i6 = i5 + 1;
        byte b5 = bArr[i5];
        if (b5 < 0) {
            return decodeVarint32(b5, bArr, i6, registers);
        }
        registers.int1 = b5;
        return i6;
    }

    static int decodeVarint32List(int i5, byte[] bArr, int i6, int i7, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i6, registers);
        intArrayList.addInt(registers.int1);
        while (decodeVarint32 < i7) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i5 != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(registers.int1);
        }
        return decodeVarint32;
    }

    static int decodeVarint64(byte[] bArr, int i5, Registers registers) {
        int i6 = i5 + 1;
        long j5 = (long) bArr[i5];
        if (j5 < 0) {
            return decodeVarint64(j5, bArr, i6, registers);
        }
        registers.long1 = j5;
        return i6;
    }

    static int decodeVarint64List(int i5, byte[] bArr, int i6, int i7, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i6, registers);
        longArrayList.addLong(registers.long1);
        while (decodeVarint64 < i7) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i5 != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        return decodeVarint64;
    }

    static int mergeGroupField(Object obj, Schema schema, byte[] bArr, int i5, int i6, int i7, Registers registers) throws IOException {
        int i8 = registers.recursionDepth + 1;
        registers.recursionDepth = i8;
        checkRecursionLimit(i8);
        MessageSchema messageSchema = (MessageSchema) schema;
        Object obj2 = obj;
        int parseMessage = messageSchema.parseMessage(obj2, bArr, i5, i6, i7, registers);
        registers.recursionDepth--;
        registers.object1 = obj2;
        return parseMessage;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int mergeMessageField(java.lang.Object r6, androidx.datastore.preferences.protobuf.Schema r7, byte[] r8, int r9, int r10, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = decodeVarint32(r9, r8, r0, r11)
            int r9 = r11.int1
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x002d
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x002d
            int r10 = r11.recursionDepth
            int r10 = r10 + 1
            r11.recursionDepth = r10
            checkRecursionLimit(r10)
            int r4 = r3 + r9
            r1 = r6
            r0 = r7
            r2 = r8
            r5 = r11
            r0.mergeFrom(r1, r2, r3, r4, r5)
            int r6 = r5.recursionDepth
            int r6 = r6 + -1
            r5.recursionDepth = r6
            r5.object1 = r1
            return r4
        L_0x002d:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r6 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.ArrayDecoders.mergeMessageField(java.lang.Object, androidx.datastore.preferences.protobuf.Schema, byte[], int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public static void setRecursionLimit(int i5) {
        recursionLimit = i5;
    }

    static int skipField(int i5, byte[] bArr, int i6, int i7, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i5) != 0) {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                return decodeVarint64(bArr, i6, registers);
            }
            if (tagWireType == 1) {
                return i6 + 8;
            }
            if (tagWireType == 2) {
                return decodeVarint32(bArr, i6, registers) + registers.int1;
            }
            if (tagWireType == 3) {
                int i8 = (i5 & -8) | 4;
                int i9 = 0;
                while (i6 < i7) {
                    i6 = decodeVarint32(bArr, i6, registers);
                    i9 = registers.int1;
                    if (i9 == i8) {
                        break;
                    }
                    i6 = skipField(i9, bArr, i6, i7, registers);
                }
                if (i6 <= i7 && i9 == i8) {
                    return i6;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } else if (tagWireType == 5) {
                return i6 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }

    static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;
        public int recursionDepth;

        Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.extensionRegistry = extensionRegistryLite;
        }
    }

    static int decodeVarint32(int i5, byte[] bArr, int i6, Registers registers) {
        int i7 = i5 & 127;
        int i8 = i6 + 1;
        byte b5 = bArr[i6];
        if (b5 >= 0) {
            registers.int1 = i7 | (b5 << 7);
            return i8;
        }
        int i9 = i7 | ((b5 & Byte.MAX_VALUE) << 7);
        int i10 = i6 + 2;
        byte b6 = bArr[i8];
        if (b6 >= 0) {
            registers.int1 = i9 | (b6 << 14);
            return i10;
        }
        int i11 = i9 | ((b6 & Byte.MAX_VALUE) << 14);
        int i12 = i6 + 3;
        byte b7 = bArr[i10];
        if (b7 >= 0) {
            registers.int1 = i11 | (b7 << 21);
            return i12;
        }
        int i13 = i11 | ((b7 & Byte.MAX_VALUE) << 21);
        int i14 = i6 + 4;
        byte b8 = bArr[i12];
        if (b8 >= 0) {
            registers.int1 = i13 | (b8 << 28);
            return i14;
        }
        int i15 = i13 | ((b8 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i16 = i14 + 1;
            if (bArr[i14] < 0) {
                i14 = i16;
            } else {
                registers.int1 = i15;
                return i16;
            }
        }
    }

    static int decodeVarint64(long j5, byte[] bArr, int i5, Registers registers) {
        int i6 = i5 + 1;
        byte b5 = bArr[i5];
        long j6 = (j5 & 127) | (((long) (b5 & Byte.MAX_VALUE)) << 7);
        int i7 = 7;
        while (b5 < 0) {
            int i8 = i6 + 1;
            byte b6 = bArr[i6];
            i7 += 7;
            j6 |= ((long) (b6 & Byte.MAX_VALUE)) << i7;
            byte b7 = b6;
            i6 = i8;
            b5 = b7;
        }
        registers.long1 = j6;
        return i6;
    }
}
