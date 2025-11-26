package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    ByteBuffer bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        public int read() throws IOException {
            try {
                return this.buf.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i5);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }

    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        public ByteBuffer newByteBuffer(int i5) {
            return ByteBuffer.allocate(i5).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int i5, ByteBufferFactory byteBufferFactory) {
        this(i5, byteBufferFactory, (ByteBuffer) null, Utf8.getDefault());
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    static ByteBuffer growByteBuffer(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int i5;
        int capacity = byteBuffer.capacity();
        if ((-1073741824 & capacity) == 0) {
            if (capacity == 0) {
                i5 = 1;
            } else {
                i5 = capacity << 1;
            }
            byteBuffer.position(0);
            ByteBuffer newByteBuffer = byteBufferFactory.newByteBuffer(i5);
            newByteBuffer.position(newByteBuffer.clear().capacity() - capacity);
            newByteBuffer.put(byteBuffer);
            return newByteBuffer;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    public static boolean isFieldPresent(Table table, int i5) {
        if (table.__offset(i5) != 0) {
            return true;
        }
        return false;
    }

    public void Nested(int i5) {
        if (i5 != offset()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void addBoolean(boolean z4) {
        prep(1, 0);
        putBoolean(z4);
    }

    public void addByte(byte b5) {
        prep(1, 0);
        putByte(b5);
    }

    public void addDouble(double d5) {
        prep(8, 0);
        putDouble(d5);
    }

    public void addFloat(float f5) {
        prep(4, 0);
        putFloat(f5);
    }

    public void addInt(int i5) {
        prep(4, 0);
        putInt(i5);
    }

    public void addLong(long j5) {
        prep(8, 0);
        putLong(j5);
    }

    public void addOffset(int i5) {
        prep(4, 0);
        putInt((offset() - i5) + 4);
    }

    public void addShort(short s5) {
        prep(2, 0);
        putShort(s5);
    }

    public void addStruct(int i5, int i6, int i7) {
        if (i6 != i7) {
            Nested(i6);
            slot(i5);
        }
    }

    public void clear() {
        this.space = this.bb.capacity();
        this.bb.clear();
        this.minalign = 1;
        while (true) {
            int i5 = this.vtable_in_use;
            if (i5 > 0) {
                int[] iArr = this.vtable;
                int i6 = i5 - 1;
                this.vtable_in_use = i6;
                iArr[i6] = 0;
            } else {
                this.vtable_in_use = 0;
                this.nested = false;
                this.finished = false;
                this.object_start = 0;
                this.num_vtables = 0;
                this.vector_num_elems = 0;
                return;
            }
        }
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - length;
        this.space = i5;
        byteBuffer.position(i5);
        this.bb.put(bArr);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t5, int[] iArr) {
        t5.sortTables(iArr, this.bb);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        int encodedLength = this.utf8.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, encodedLength, 1);
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - encodedLength;
        this.space = i5;
        byteBuffer.position(i5);
        this.utf8.encodeUtf8(charSequence, this.bb);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int i5, int i6, int i7) {
        int i8 = i5 * i6;
        startVector(i5, i6, i7);
        ByteBuffer byteBuffer = this.bb;
        int i9 = this.space - i8;
        this.space = i9;
        byteBuffer.position(i9);
        ByteBuffer order = this.bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        order.limit(i8);
        return order;
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            addOffset(iArr[length]);
        }
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.bb;
    }

    public int endTable() {
        int i5;
        int i6;
        if (this.vtable == null || !this.nested) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        addInt(0);
        int offset = offset();
        int i7 = this.vtable_in_use - 1;
        while (i7 >= 0 && this.vtable[i7] == 0) {
            i7--;
        }
        for (int i8 = i7; i8 >= 0; i8--) {
            int i9 = this.vtable[i8];
            if (i9 != 0) {
                i6 = offset - i9;
            } else {
                i6 = 0;
            }
            addShort((short) i6);
        }
        addShort((short) (offset - this.object_start));
        addShort((short) ((i7 + 3) * 2));
        int i10 = 0;
        loop2:
        while (true) {
            if (i10 >= this.num_vtables) {
                i5 = 0;
                break;
            }
            int capacity = this.bb.capacity() - this.vtables[i10];
            int i11 = this.space;
            short s5 = this.bb.getShort(capacity);
            if (s5 == this.bb.getShort(i11)) {
                int i12 = 2;
                while (i12 < s5) {
                    if (this.bb.getShort(capacity + i12) == this.bb.getShort(i11 + i12)) {
                        i12 += 2;
                    }
                }
                i5 = this.vtables[i10];
                break loop2;
            }
            i10++;
        }
        if (i5 != 0) {
            int capacity2 = this.bb.capacity() - offset;
            this.space = capacity2;
            this.bb.putInt(capacity2, i5 - offset);
        } else {
            int i13 = this.num_vtables;
            int[] iArr = this.vtables;
            if (i13 == iArr.length) {
                this.vtables = Arrays.copyOf(iArr, i13 * 2);
            }
            int[] iArr2 = this.vtables;
            int i14 = this.num_vtables;
            this.num_vtables = i14 + 1;
            iArr2[i14] = offset();
            ByteBuffer byteBuffer = this.bb;
            byteBuffer.putInt(byteBuffer.capacity() - offset, offset() - offset);
        }
        this.nested = false;
        return offset;
    }

    public int endVector() {
        if (this.nested) {
            this.nested = false;
            putInt(this.vector_num_elems);
            return offset();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    /* access modifiers changed from: protected */
    public void finish(int i5, boolean z4) {
        prep(this.minalign, (z4 ? 4 : 0) + 4);
        addOffset(i5);
        if (z4) {
            addInt(this.bb.capacity() - this.space);
        }
        this.bb.position(this.space);
        this.finished = true;
    }

    public void finishSizePrefixed(int i5) {
        finish(i5, true);
    }

    public void finished() {
        if (!this.finished) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder forceDefaults(boolean z4) {
        this.force_defaults = z4;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.bb_factory = byteBufferFactory;
        this.bb = byteBuffer;
        byteBuffer.clear();
        this.bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void notNested() {
        if (this.nested) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.bb.capacity() - this.space;
    }

    public void pad(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            ByteBuffer byteBuffer = this.bb;
            int i7 = this.space - 1;
            this.space = i7;
            byteBuffer.put(i7, (byte) 0);
        }
    }

    public void prep(int i5, int i6) {
        if (i5 > this.minalign) {
            this.minalign = i5;
        }
        int i7 = ((~((this.bb.capacity() - this.space) + i6)) + 1) & (i5 - 1);
        while (this.space < i7 + i5 + i6) {
            int capacity = this.bb.capacity();
            ByteBuffer byteBuffer = this.bb;
            ByteBuffer growByteBuffer = growByteBuffer(byteBuffer, this.bb_factory);
            this.bb = growByteBuffer;
            if (byteBuffer != growByteBuffer) {
                this.bb_factory.releaseByteBuffer(byteBuffer);
            }
            this.space += this.bb.capacity() - capacity;
        }
        pad(i7);
    }

    public void putBoolean(boolean z4) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 1;
        this.space = i5;
        byteBuffer.put(i5, z4 ? (byte) 1 : 0);
    }

    public void putByte(byte b5) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 1;
        this.space = i5;
        byteBuffer.put(i5, b5);
    }

    public void putDouble(double d5) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 8;
        this.space = i5;
        byteBuffer.putDouble(i5, d5);
    }

    public void putFloat(float f5) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 4;
        this.space = i5;
        byteBuffer.putFloat(i5, f5);
    }

    public void putInt(int i5) {
        ByteBuffer byteBuffer = this.bb;
        int i6 = this.space - 4;
        this.space = i6;
        byteBuffer.putInt(i6, i5);
    }

    public void putLong(long j5) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 8;
        this.space = i5;
        byteBuffer.putLong(i5, j5);
    }

    public void putShort(short s5) {
        ByteBuffer byteBuffer = this.bb;
        int i5 = this.space - 2;
        this.space = i5;
        byteBuffer.putShort(i5, s5);
    }

    public void required(int i5, int i6) {
        int capacity = this.bb.capacity() - i5;
        if (this.bb.getShort((capacity - this.bb.getInt(capacity)) + i6) == 0) {
            throw new AssertionError("FlatBuffers: field " + i6 + " must be set");
        }
    }

    public byte[] sizedByteArray(int i5, int i6) {
        finished();
        byte[] bArr = new byte[i6];
        this.bb.position(i5);
        this.bb.get(bArr);
        return bArr;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer duplicate = this.bb.duplicate();
        duplicate.position(this.space);
        duplicate.limit(this.bb.capacity());
        return new ByteBufferBackedInputStream(duplicate);
    }

    public void slot(int i5) {
        this.vtable[i5] = offset();
    }

    public void startTable(int i5) {
        notNested();
        int[] iArr = this.vtable;
        if (iArr == null || iArr.length < i5) {
            this.vtable = new int[i5];
        }
        this.vtable_in_use = i5;
        Arrays.fill(this.vtable, 0, i5, 0);
        this.nested = true;
        this.object_start = offset();
    }

    public void startVector(int i5, int i6, int i7) {
        notNested();
        this.vector_num_elems = i6;
        int i8 = i5 * i6;
        prep(4, i8);
        prep(i7, i8);
        this.nested = true;
    }

    public FlatBufferBuilder(int i5, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf82) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        i5 = i5 <= 0 ? 1 : i5;
        this.bb_factory = byteBufferFactory;
        if (byteBuffer != null) {
            this.bb = byteBuffer;
            byteBuffer.clear();
            this.bb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.bb = byteBufferFactory.newByteBuffer(i5);
        }
        this.utf8 = utf82;
        this.space = this.bb.capacity();
    }

    public void addBoolean(int i5, boolean z4, boolean z5) {
        if (this.force_defaults || z4 != z5) {
            addBoolean(z4);
            slot(i5);
        }
    }

    public void addByte(int i5, byte b5, int i6) {
        if (this.force_defaults || b5 != i6) {
            addByte(b5);
            slot(i5);
        }
    }

    public void addDouble(int i5, double d5, double d6) {
        if (this.force_defaults || d5 != d6) {
            addDouble(d5);
            slot(i5);
        }
    }

    public void addFloat(int i5, float f5, double d5) {
        if (this.force_defaults || ((double) f5) != d5) {
            addFloat(f5);
            slot(i5);
        }
    }

    public void addInt(int i5, int i6, int i7) {
        if (this.force_defaults || i6 != i7) {
            addInt(i6);
            slot(i5);
        }
    }

    public void addLong(int i5, long j5, long j6) {
        if (this.force_defaults || j5 != j6) {
            addLong(j5);
            slot(i5);
        }
    }

    public void addShort(int i5, short s5, int i6) {
        if (this.force_defaults || s5 != i6) {
            addShort(s5);
            slot(i5);
        }
    }

    public void finishSizePrefixed(int i5, String str) {
        finish(i5, str, true);
    }

    public void addOffset(int i5, int i6, int i7) {
        if (this.force_defaults || i6 != i7) {
            addOffset(i6);
            slot(i5);
        }
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.bb.capacity() - this.space);
    }

    public int createByteVector(byte[] bArr, int i5, int i6) {
        startVector(1, i6, 1);
        ByteBuffer byteBuffer = this.bb;
        int i7 = this.space - i6;
        this.space = i7;
        byteBuffer.position(i7);
        this.bb.put(bArr, i5, i6);
        return endVector();
    }

    public void finish(int i5) {
        finish(i5, false);
    }

    public int createString(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.bb;
        int i5 = this.space - remaining;
        this.space = i5;
        byteBuffer2.position(i5);
        this.bb.put(byteBuffer);
        return endVector();
    }

    /* access modifiers changed from: protected */
    public void finish(int i5, String str, boolean z4) {
        prep(this.minalign, (z4 ? 4 : 0) + 8);
        if (str.length() == 4) {
            for (int i6 = 3; i6 >= 0; i6--) {
                addByte((byte) str.charAt(i6));
            }
            finish(i5, z4);
            return;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.bb;
        int i5 = this.space - remaining;
        this.space = i5;
        byteBuffer2.position(i5);
        this.bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i5, String str) {
        finish(i5, str, false);
    }

    public FlatBufferBuilder(int i5) {
        this(i5, HeapByteBufferFactory.INSTANCE, (ByteBuffer) null, Utf8.getDefault());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, (ByteBufferFactory) new HeapByteBufferFactory());
    }
}
