package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public byte[] data() {
        return this.buffer;
    }

    public byte get(int i5) {
        return this.buffer[i5];
    }

    public boolean getBoolean(int i5) {
        if (this.buffer[i5] != 0) {
            return true;
        }
        return false;
    }

    public double getDouble(int i5) {
        return Double.longBitsToDouble(getLong(i5));
    }

    public float getFloat(int i5) {
        return Float.intBitsToFloat(getInt(i5));
    }

    public int getInt(int i5) {
        byte[] bArr = this.buffer;
        return (bArr[i5] & 255) | (bArr[i5 + 3] << 24) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 1] & 255) << 8);
    }

    public long getLong(int i5) {
        byte[] bArr = this.buffer;
        long j5 = (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32);
        int i6 = i5 + 6;
        return (((long) bArr[i5 + 7]) << 56) | j5 | ((((long) bArr[i5 + 5]) & 255) << 40) | ((255 & ((long) bArr[i6])) << 48);
    }

    public short getShort(int i5) {
        byte[] bArr = this.buffer;
        return (short) ((bArr[i5] & 255) | (bArr[i5 + 1] << 8));
    }

    public String getString(int i5, int i6) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i5, i6);
    }

    public int limit() {
        return this.writePos;
    }

    public void put(byte[] bArr, int i5, int i6) {
        set(this.writePos, bArr, i5, i6);
        this.writePos += i6;
    }

    public void putBoolean(boolean z4) {
        setBoolean(this.writePos, z4);
        this.writePos++;
    }

    public void putDouble(double d5) {
        setDouble(this.writePos, d5);
        this.writePos += 8;
    }

    public void putFloat(float f5) {
        setFloat(this.writePos, f5);
        this.writePos += 4;
    }

    public void putInt(int i5) {
        setInt(this.writePos, i5);
        this.writePos += 4;
    }

    public void putLong(long j5) {
        setLong(this.writePos, j5);
        this.writePos += 8;
    }

    public void putShort(short s5) {
        setShort(this.writePos, s5);
        this.writePos += 2;
    }

    public boolean requestCapacity(int i5) {
        byte[] bArr = this.buffer;
        if (bArr.length > i5) {
            return true;
        }
        int length = bArr.length;
        this.buffer = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    public void set(int i5, byte b5) {
        requestCapacity(i5 + 1);
        this.buffer[i5] = b5;
    }

    public void setBoolean(int i5, boolean z4) {
        set(i5, z4 ? (byte) 1 : 0);
    }

    public void setDouble(int i5, double d5) {
        requestCapacity(i5 + 8);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d5);
        int i6 = (int) doubleToRawLongBits;
        byte[] bArr = this.buffer;
        bArr[i5] = (byte) (i6 & 255);
        bArr[i5 + 1] = (byte) ((i6 >> 8) & 255);
        bArr[i5 + 2] = (byte) ((i6 >> 16) & 255);
        bArr[i5 + 3] = (byte) ((i6 >> 24) & 255);
        int i7 = (int) (doubleToRawLongBits >> 32);
        bArr[i5 + 4] = (byte) (i7 & 255);
        bArr[i5 + 5] = (byte) ((i7 >> 8) & 255);
        bArr[i5 + 6] = (byte) ((i7 >> 16) & 255);
        bArr[i5 + 7] = (byte) ((i7 >> 24) & 255);
    }

    public void setFloat(int i5, float f5) {
        requestCapacity(i5 + 4);
        int floatToRawIntBits = Float.floatToRawIntBits(f5);
        byte[] bArr = this.buffer;
        bArr[i5] = (byte) (floatToRawIntBits & 255);
        bArr[i5 + 1] = (byte) ((floatToRawIntBits >> 8) & 255);
        bArr[i5 + 2] = (byte) ((floatToRawIntBits >> 16) & 255);
        bArr[i5 + 3] = (byte) ((floatToRawIntBits >> 24) & 255);
    }

    public void setInt(int i5, int i6) {
        requestCapacity(i5 + 4);
        byte[] bArr = this.buffer;
        bArr[i5] = (byte) (i6 & 255);
        bArr[i5 + 1] = (byte) ((i6 >> 8) & 255);
        bArr[i5 + 2] = (byte) ((i6 >> 16) & 255);
        bArr[i5 + 3] = (byte) ((i6 >> 24) & 255);
    }

    public void setLong(int i5, long j5) {
        requestCapacity(i5 + 8);
        int i6 = (int) j5;
        byte[] bArr = this.buffer;
        bArr[i5] = (byte) (i6 & 255);
        bArr[i5 + 1] = (byte) ((i6 >> 8) & 255);
        bArr[i5 + 2] = (byte) ((i6 >> 16) & 255);
        bArr[i5 + 3] = (byte) ((i6 >> 24) & 255);
        int i7 = (int) (j5 >> 32);
        bArr[i5 + 4] = (byte) (i7 & 255);
        bArr[i5 + 5] = (byte) ((i7 >> 8) & 255);
        bArr[i5 + 6] = (byte) ((i7 >> 16) & 255);
        bArr[i5 + 7] = (byte) ((i7 >> 24) & 255);
    }

    public void setShort(int i5, short s5) {
        requestCapacity(i5 + 2);
        byte[] bArr = this.buffer;
        bArr[i5] = (byte) (s5 & 255);
        bArr[i5 + 1] = (byte) ((s5 >> 8) & 255);
    }

    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(int i5) {
        this(new byte[i5]);
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    public void put(byte b5) {
        set(this.writePos, b5);
        this.writePos++;
    }

    public void set(int i5, byte[] bArr, int i6, int i7) {
        requestCapacity((i7 - i6) + i5);
        System.arraycopy(bArr, i6, this.buffer, i5, i7);
    }

    public ArrayReadWriteBuf(byte[] bArr, int i5) {
        this.buffer = bArr;
        this.writePos = i5;
    }
}
