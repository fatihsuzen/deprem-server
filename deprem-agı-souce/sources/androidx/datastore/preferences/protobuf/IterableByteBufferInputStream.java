package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

class IterableByteBufferInputStream extends InputStream {
    private long currentAddress;
    private byte[] currentArray;
    private int currentArrayOffset;
    private ByteBuffer currentByteBuffer;
    private int currentByteBufferPos;
    private int currentIndex;
    private int dataSize = 0;
    private boolean hasArray;
    private Iterator<ByteBuffer> iterator;

    IterableByteBufferInputStream(Iterable<ByteBuffer> iterable) {
        this.iterator = iterable.iterator();
        for (ByteBuffer next : iterable) {
            this.dataSize++;
        }
        this.currentIndex = -1;
        if (!getNextByteBuffer()) {
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentIndex = 0;
            this.currentByteBufferPos = 0;
            this.currentAddress = 0;
        }
    }

    private boolean getNextByteBuffer() {
        this.currentIndex++;
        if (!this.iterator.hasNext()) {
            return false;
        }
        ByteBuffer next = this.iterator.next();
        this.currentByteBuffer = next;
        this.currentByteBufferPos = next.position();
        if (this.currentByteBuffer.hasArray()) {
            this.hasArray = true;
            this.currentArray = this.currentByteBuffer.array();
            this.currentArrayOffset = this.currentByteBuffer.arrayOffset();
        } else {
            this.hasArray = false;
            this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentArray = null;
        }
        return true;
    }

    private void updateCurrentByteBufferPos(int i5) {
        int i6 = this.currentByteBufferPos + i5;
        this.currentByteBufferPos = i6;
        if (i6 == this.currentByteBuffer.limit()) {
            getNextByteBuffer();
        }
    }

    public int read() throws IOException {
        if (this.currentIndex == this.dataSize) {
            return -1;
        }
        if (this.hasArray) {
            byte b5 = this.currentArray[this.currentByteBufferPos + this.currentArrayOffset] & 255;
            updateCurrentByteBufferPos(1);
            return b5;
        }
        byte b6 = UnsafeUtil.getByte(((long) this.currentByteBufferPos) + this.currentAddress) & 255;
        updateCurrentByteBufferPos(1);
        return b6;
    }

    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (this.currentIndex == this.dataSize) {
            return -1;
        }
        int limit = this.currentByteBuffer.limit();
        int i7 = this.currentByteBufferPos;
        int i8 = limit - i7;
        if (i6 > i8) {
            i6 = i8;
        }
        if (this.hasArray) {
            System.arraycopy(this.currentArray, i7 + this.currentArrayOffset, bArr, i5, i6);
            updateCurrentByteBufferPos(i6);
            return i6;
        }
        int position = this.currentByteBuffer.position();
        Java8Compatibility.position(this.currentByteBuffer, this.currentByteBufferPos);
        this.currentByteBuffer.get(bArr, i5, i6);
        Java8Compatibility.position(this.currentByteBuffer, position);
        updateCurrentByteBufferPos(i6);
        return i6;
    }
}
