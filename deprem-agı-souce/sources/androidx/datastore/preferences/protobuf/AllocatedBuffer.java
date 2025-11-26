package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
abstract class AllocatedBuffer {
    AllocatedBuffer() {
    }

    public static AllocatedBuffer wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i5, final int i6) {
        return new AllocatedBuffer() {
            private int position;

            public byte[] array() {
                return bArr;
            }

            public int arrayOffset() {
                return i5;
            }

            public boolean hasArray() {
                return true;
            }

            public boolean hasNioBuffer() {
                return false;
            }

            public int limit() {
                return i6;
            }

            public ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            public int position() {
                return this.position;
            }

            public int remaining() {
                return i6 - this.position;
            }

            public AllocatedBuffer position(int i5) {
                if (i5 < 0 || i5 > i6) {
                    throw new IllegalArgumentException("Invalid position: " + i5);
                }
                this.position = i5;
                return this;
            }
        };
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    @CanIgnoreReturnValue
    public abstract AllocatedBuffer position(int i5);

    public abstract int remaining();

    public static AllocatedBuffer wrap(byte[] bArr, int i5, int i6) {
        if (i5 >= 0 && i6 >= 0 && i5 + i6 <= bArr.length) {
            return wrapNoCheck(bArr, i5, i6);
        }
        throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)}));
    }

    public static AllocatedBuffer wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() {
            public byte[] array() {
                return byteBuffer.array();
            }

            public int arrayOffset() {
                return byteBuffer.arrayOffset();
            }

            public boolean hasArray() {
                return byteBuffer.hasArray();
            }

            public boolean hasNioBuffer() {
                return true;
            }

            public int limit() {
                return byteBuffer.limit();
            }

            public ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            public int position() {
                return byteBuffer.position();
            }

            public int remaining() {
                return byteBuffer.remaining();
            }

            public AllocatedBuffer position(int i5) {
                Java8Compatibility.position(byteBuffer, i5);
                return this;
            }
        };
    }
}
