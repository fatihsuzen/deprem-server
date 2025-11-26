package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.FlexBuffers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FlexBuffersBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;
    /* access modifiers changed from: private */
    public final ReadWriteBuf bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    private static class Value {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        Value(int i5, int i6, int i7, long j5) {
            this.key = i5;
            this.type = i6;
            this.minBitWidth = i7;
            this.iValue = j5;
            this.dValue = Double.MIN_VALUE;
        }

        static Value blob(int i5, int i6, int i7, int i8) {
            return new Value(i5, i7, i8, (long) i6);
        }

        static Value bool(int i5, boolean z4) {
            long j5;
            if (z4) {
                j5 = 1;
            } else {
                j5 = 0;
            }
            return new Value(i5, 26, 0, j5);
        }

        /* access modifiers changed from: private */
        public int elemWidth(int i5, int i6) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, i5, i6);
        }

        static Value float32(int i5, float f5) {
            return new Value(i5, 3, 2, (double) f5);
        }

        static Value float64(int i5, double d5) {
            return new Value(i5, 3, 3, d5);
        }

        static Value int16(int i5, int i6) {
            return new Value(i5, 1, 1, (long) i6);
        }

        static Value int32(int i5, int i6) {
            return new Value(i5, 1, 2, (long) i6);
        }

        static Value int64(int i5, long j5) {
            return new Value(i5, 1, 3, j5);
        }

        static Value int8(int i5, int i6) {
            return new Value(i5, 1, 0, (long) i6);
        }

        private static byte packedType(int i5, int i6) {
            return (byte) (i5 | (i6 << 2));
        }

        /* access modifiers changed from: private */
        public static int paddingBytes(int i5, int i6) {
            return ((~i5) + 1) & (i6 - 1);
        }

        /* access modifiers changed from: private */
        public byte storedPackedType() {
            return storedPackedType(0);
        }

        private int storedWidth(int i5) {
            if (FlexBuffers.isTypeInline(this.type)) {
                return Math.max(this.minBitWidth, i5);
            }
            return this.minBitWidth;
        }

        static Value uInt16(int i5, int i6) {
            return new Value(i5, 2, 1, (long) i6);
        }

        static Value uInt32(int i5, int i6) {
            return new Value(i5, 2, 2, (long) i6);
        }

        static Value uInt64(int i5, long j5) {
            return new Value(i5, 2, 3, j5);
        }

        static Value uInt8(int i5, int i6) {
            return new Value(i5, 2, 0, (long) i6);
        }

        /* access modifiers changed from: private */
        public static int elemWidth(int i5, int i6, long j5, int i7, int i8) {
            if (FlexBuffers.isTypeInline(i5)) {
                return i6;
            }
            for (int i9 = 1; i9 <= 32; i9 *= 2) {
                int widthUInBits = FlexBuffersBuilder.widthUInBits((long) ((int) (((long) ((paddingBytes(i7, i9) + i7) + (i8 * i9))) - j5)));
                if ((1 << widthUInBits) == ((long) i9)) {
                    return widthUInBits;
                }
            }
            return 3;
        }

        /* access modifiers changed from: private */
        public byte storedPackedType(int i5) {
            return packedType(storedWidth(i5), this.type);
        }

        Value(int i5, int i6, int i7, double d5) {
            this.key = i5;
            this.type = i6;
            this.minBitWidth = i7;
            this.dValue = d5;
            this.iValue = Long.MIN_VALUE;
        }
    }

    public FlexBuffersBuilder(int i5) {
        this((ReadWriteBuf) new ArrayReadWriteBuf(i5), 1);
    }

    private int align(int i5) {
        int i6 = 1 << i5;
        int access$100 = Value.paddingBytes(this.bb.writePosition(), i6);
        while (true) {
            int i7 = access$100 - 1;
            if (access$100 == 0) {
                return i6;
            }
            this.bb.put((byte) 0);
            access$100 = i7;
        }
    }

    private Value createKeyVector(int i5, int i6) {
        long j5 = (long) i6;
        int max = Math.max(0, widthUInBits(j5));
        int i7 = i5;
        while (i7 < this.stack.size()) {
            int i8 = i7 + 1;
            max = Math.max(max, Value.elemWidth(4, 0, (long) this.stack.get(i7).key, this.bb.writePosition(), i8));
            i7 = i8;
        }
        int align = align(max);
        writeInt(j5, align);
        int writePosition = this.bb.writePosition();
        while (i5 < this.stack.size()) {
            int i9 = this.stack.get(i5).key;
            writeOffset((long) this.stack.get(i5).key, align);
            i5++;
        }
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), max, (long) writePosition);
    }

    private Value createVector(int i5, int i6, int i7, boolean z4, boolean z5, Value value) {
        int i8;
        int i9;
        int i10 = i7;
        Value value2 = value;
        long j5 = (long) i10;
        int max = Math.max(0, widthUInBits(j5));
        if (value2 != null) {
            max = Math.max(max, value2.elemWidth(this.bb.writePosition(), 0));
            i8 = 3;
        } else {
            i8 = 1;
        }
        int i11 = 4;
        int i12 = max;
        for (int i13 = i6; i13 < this.stack.size(); i13++) {
            i12 = Math.max(i12, this.stack.get(i13).elemWidth(this.bb.writePosition(), i13 + i8));
            int i14 = i6;
            if (z4 && i13 == i14) {
                i11 = this.stack.get(i13).type;
                if (!FlexBuffers.isTypedVectorElementType(i11)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i15 = i6;
        int align = align(i12);
        if (value2 != null) {
            writeOffset(value2.iValue, align);
            writeInt(1 << value2.minBitWidth, align);
        }
        if (!z5) {
            writeInt(j5, align);
        }
        int writePosition = this.bb.writePosition();
        for (int i16 = i15; i16 < this.stack.size(); i16++) {
            writeAny(this.stack.get(i16), align);
        }
        if (!z4) {
            while (i15 < this.stack.size()) {
                this.bb.put(this.stack.get(i15).storedPackedType(i12));
                i15++;
            }
        }
        if (value2 != null) {
            i9 = 9;
        } else if (z4) {
            if (!z5) {
                i10 = 0;
            }
            i9 = FlexBuffers.toTypedVector(i11, i10);
        } else {
            i9 = 10;
        }
        return new Value(i5, i9, i12, (long) writePosition);
    }

    private int putKey(String str) {
        if (str == null) {
            return -1;
        }
        int writePosition = this.bb.writePosition();
        if ((this.flags & 1) != 0) {
            Integer num = this.keyPool.get(str);
            if (num != null) {
                return num.intValue();
            }
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.bb.put(bytes, 0, bytes.length);
            this.bb.put((byte) 0);
            this.keyPool.put(str, Integer.valueOf(writePosition));
            return writePosition;
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.bb.put(bytes2, 0, bytes2.length);
        this.bb.put((byte) 0);
        this.keyPool.put(str, Integer.valueOf(writePosition));
        return writePosition;
    }

    static int widthUInBits(long j5) {
        if (j5 <= ((long) FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1))) {
            return 0;
        }
        if (j5 <= ((long) FlexBuffers.Unsigned.shortToUnsignedInt(-1))) {
            return 1;
        }
        if (j5 <= FlexBuffers.Unsigned.intToUnsignedLong(-1)) {
            return 2;
        }
        return 3;
    }

    private void writeAny(Value value, int i5) {
        int i6 = value.type;
        if (!(i6 == 0 || i6 == 1 || i6 == 2)) {
            if (i6 == 3) {
                writeDouble(value.dValue, i5);
                return;
            } else if (i6 != 26) {
                writeOffset(value.iValue, i5);
                return;
            }
        }
        writeInt(value.iValue, i5);
    }

    private Value writeBlob(int i5, byte[] bArr, int i6, boolean z4) {
        int widthUInBits = widthUInBits((long) bArr.length);
        writeInt((long) bArr.length, align(widthUInBits));
        int writePosition = this.bb.writePosition();
        this.bb.put(bArr, 0, bArr.length);
        if (z4) {
            this.bb.put((byte) 0);
        }
        return Value.blob(i5, writePosition, i6, widthUInBits);
    }

    private void writeDouble(double d5, int i5) {
        if (i5 == 4) {
            this.bb.putFloat((float) d5);
        } else if (i5 == 8) {
            this.bb.putDouble(d5);
        }
    }

    private void writeInt(long j5, int i5) {
        if (i5 == 1) {
            this.bb.put((byte) ((int) j5));
        } else if (i5 == 2) {
            this.bb.putShort((short) ((int) j5));
        } else if (i5 == 4) {
            this.bb.putInt((int) j5);
        } else if (i5 == 8) {
            this.bb.putLong(j5);
        }
    }

    private void writeOffset(long j5, int i5) {
        writeInt((long) ((int) (((long) this.bb.writePosition()) - j5)), i5);
    }

    private Value writeString(int i5, String str) {
        return writeBlob(i5, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String str, int i5) {
        int putKey = putKey(str);
        ArrayList<Value> arrayList = this.stack;
        Collections.sort(arrayList.subList(i5, arrayList.size()), this.keyComparator);
        int i6 = i5;
        Value createVector = createVector(putKey, i6, this.stack.size() - i5, false, false, createKeyVector(i5, this.stack.size() - i5));
        while (this.stack.size() > i6) {
            ArrayList<Value> arrayList2 = this.stack;
            arrayList2.remove(arrayList2.size() - 1);
        }
        this.stack.add(createVector);
        return (int) createVector.iValue;
    }

    public int endVector(String str, int i5, boolean z4, boolean z5) {
        int i6 = i5;
        Value createVector = createVector(putKey(str), i6, this.stack.size() - i5, z4, z5, (Value) null);
        while (this.stack.size() > i6) {
            ArrayList<Value> arrayList = this.stack;
            arrayList.remove(arrayList.size() - 1);
        }
        this.stack.add(createVector);
        return (int) createVector.iValue;
    }

    public ByteBuffer finish() {
        int align = align(this.stack.get(0).elemWidth(this.bb.writePosition(), 0));
        writeAny(this.stack.get(0), align);
        this.bb.put(this.stack.get(0).storedPackedType());
        this.bb.put((byte) align);
        this.finished = true;
        return ByteBuffer.wrap(this.bb.data(), 0, this.bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.bb;
    }

    public int putBlob(byte[] bArr) {
        return putBlob((String) null, bArr);
    }

    public void putBoolean(boolean z4) {
        putBoolean((String) null, z4);
    }

    public void putFloat(float f5) {
        putFloat((String) null, f5);
    }

    public void putInt(int i5) {
        putInt((String) null, i5);
    }

    public int putString(String str) {
        return putString((String) null, str);
    }

    public void putUInt(int i5) {
        putUInt((String) null, (long) i5);
    }

    public void putUInt64(BigInteger bigInteger) {
        putUInt64((String) null, bigInteger.longValue());
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    private void putUInt64(String str, long j5) {
        this.stack.add(Value.uInt64(putKey(str), j5));
    }

    public int putBlob(String str, byte[] bArr) {
        Value writeBlob = writeBlob(putKey(str), bArr, 25, false);
        this.stack.add(writeBlob);
        return (int) writeBlob.iValue;
    }

    public void putBoolean(String str, boolean z4) {
        this.stack.add(Value.bool(putKey(str), z4));
    }

    public void putFloat(String str, float f5) {
        this.stack.add(Value.float32(putKey(str), f5));
    }

    public void putInt(String str, int i5) {
        putInt(str, (long) i5);
    }

    public int putString(String str, String str2) {
        int putKey = putKey(str);
        if ((this.flags & 2) != 0) {
            Integer num = this.stringPool.get(str2);
            if (num == null) {
                Value writeString = writeString(putKey, str2);
                this.stringPool.put(str2, Integer.valueOf((int) writeString.iValue));
                this.stack.add(writeString);
                return (int) writeString.iValue;
            }
            this.stack.add(Value.blob(putKey, num.intValue(), 5, widthUInBits((long) str2.length())));
            return num.intValue();
        }
        Value writeString2 = writeString(putKey, str2);
        this.stack.add(writeString2);
        return (int) writeString2.iValue;
    }

    public void putUInt(long j5) {
        putUInt((String) null, j5);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i5) {
        this((ReadWriteBuf) new ArrayReadWriteBuf(byteBuffer.array()), i5);
    }

    private void putUInt(String str, long j5) {
        Value value;
        int putKey = putKey(str);
        int widthUInBits = widthUInBits(j5);
        if (widthUInBits == 0) {
            value = Value.uInt8(putKey, (int) j5);
        } else if (widthUInBits == 1) {
            value = Value.uInt16(putKey, (int) j5);
        } else if (widthUInBits == 2) {
            value = Value.uInt32(putKey, (int) j5);
        } else {
            value = Value.uInt64(putKey, j5);
        }
        this.stack.add(value);
    }

    public void putFloat(double d5) {
        putFloat((String) null, d5);
    }

    public void putInt(String str, long j5) {
        int putKey = putKey(str);
        if (-128 <= j5 && j5 <= 127) {
            this.stack.add(Value.int8(putKey, (int) j5));
        } else if (-32768 <= j5 && j5 <= 32767) {
            this.stack.add(Value.int16(putKey, (int) j5));
        } else if (-2147483648L > j5 || j5 > 2147483647L) {
            this.stack.add(Value.int64(putKey, j5));
        } else {
            this.stack.add(Value.int32(putKey, (int) j5));
        }
    }

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int i5) {
        this.stack = new ArrayList<>();
        this.keyPool = new HashMap<>();
        this.stringPool = new HashMap<>();
        this.finished = false;
        this.keyComparator = new Comparator<Value>() {
            public int compare(Value value, Value value2) {
                byte b5;
                byte b6;
                int i5 = value.key;
                int i6 = value2.key;
                do {
                    b5 = FlexBuffersBuilder.this.bb.get(i5);
                    b6 = FlexBuffersBuilder.this.bb.get(i6);
                    if (b5 == 0) {
                        return b5 - b6;
                    }
                    i5++;
                    i6++;
                } while (b5 == b6);
                return b5 - b6;
            }
        };
        this.bb = readWriteBuf;
        this.flags = i5;
    }

    public void putFloat(String str, double d5) {
        this.stack.add(Value.float64(putKey(str), d5));
    }

    public void putInt(long j5) {
        putInt((String) null, j5);
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }
}
