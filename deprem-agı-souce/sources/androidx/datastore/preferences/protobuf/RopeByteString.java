package androidx.datastore.preferences.protobuf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.datastore.preferences.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class RopeByteString extends ByteString {
    static final int[] minLengthByDepth = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final ByteString left;
    private final int leftLength;
    /* access modifiers changed from: private */
    public final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    private static class Balancer {
        private final ArrayDeque<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new ArrayDeque<>();
        }

        /* access modifiers changed from: private */
        public ByteString balance(ByteString byteString, ByteString byteString2) {
            doBalance(byteString);
            doBalance(byteString2);
            ByteString pop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty()) {
                pop = new RopeByteString(this.prefixesStack.pop(), pop);
            }
            return pop;
        }

        private void doBalance(ByteString byteString) {
            if (byteString.isBalanced()) {
                insert(byteString);
            } else if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                doBalance(ropeByteString.left);
                doBalance(ropeByteString.right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private int getDepthBinForLength(int i5) {
            int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i5);
            if (binarySearch < 0) {
                return (-(binarySearch + 1)) - 1;
            }
            return binarySearch;
        }

        private void insert(ByteString byteString) {
            int depthBinForLength = getDepthBinForLength(byteString.size());
            int minLength = RopeByteString.minLength(depthBinForLength + 1);
            if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= minLength) {
                this.prefixesStack.push(byteString);
                return;
            }
            int minLength2 = RopeByteString.minLength(depthBinForLength);
            ByteString pop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty() && this.prefixesStack.peek().size() < minLength2) {
                pop = new RopeByteString(this.prefixesStack.pop(), pop);
            }
            RopeByteString ropeByteString = new RopeByteString(pop, byteString);
            while (!this.prefixesStack.isEmpty() && this.prefixesStack.peek().size() < RopeByteString.minLength(getDepthBinForLength(ropeByteString.size()) + 1)) {
                ropeByteString = new RopeByteString(this.prefixesStack.pop(), ropeByteString);
            }
            this.prefixesStack.push(ropeByteString);
        }
    }

    private static final class PieceIterator implements Iterator<ByteString.LeafByteString> {
        private final ArrayDeque<RopeByteString> breadCrumbs;
        private ByteString.LeafByteString next;

        private ByteString.LeafByteString getLeafByLeft(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.breadCrumbs.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (ByteString.LeafByteString) byteString;
        }

        private ByteString.LeafByteString getNextNonEmptyLeaf() {
            ByteString.LeafByteString leafByLeft;
            do {
                ArrayDeque<RopeByteString> arrayDeque = this.breadCrumbs;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                leafByLeft = getLeafByLeft(this.breadCrumbs.pop().right);
            } while (leafByLeft.isEmpty());
            return leafByLeft;
        }

        public boolean hasNext() {
            if (this.next != null) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private PieceIterator(ByteString byteString) {
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                ArrayDeque<RopeByteString> arrayDeque = new ArrayDeque<>(ropeByteString.getTreeDepth());
                this.breadCrumbs = arrayDeque;
                arrayDeque.push(ropeByteString);
                this.next = getLeafByLeft(ropeByteString.left);
                return;
            }
            this.breadCrumbs = null;
            this.next = (ByteString.LeafByteString) byteString;
        }

        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.next;
            if (leafByteString != null) {
                this.next = getNextNonEmptyLeaf();
                return leafByteString;
            }
            throw new NoSuchElementException();
        }
    }

    static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return concatenateBytes(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.right.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
            } else if (ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        if (size >= minLength(Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1)) {
            return new RopeByteString(byteString, byteString2);
        }
        return new Balancer().balance(byteString, byteString2);
    }

    private static ByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.wrap(bArr);
    }

    private boolean equalsFragments(ByteString byteString) {
        boolean z4;
        PieceIterator pieceIterator = new PieceIterator(this);
        ByteString.LeafByteString leafByteString = (ByteString.LeafByteString) pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        ByteString.LeafByteString leafByteString2 = (ByteString.LeafByteString) pieceIterator2.next();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int size = leafByteString.size() - i5;
            int size2 = leafByteString2.size() - i6;
            int min = Math.min(size, size2);
            if (i5 == 0) {
                z4 = leafByteString.equalsRange(leafByteString2, i6, min);
            } else {
                z4 = leafByteString2.equalsRange(leafByteString, i5, min);
            }
            if (!z4) {
                return false;
            }
            i7 += min;
            int i8 = this.totalLength;
            if (i7 < i8) {
                if (min == size) {
                    leafByteString = (ByteString.LeafByteString) pieceIterator.next();
                    i5 = 0;
                } else {
                    i5 += min;
                }
                if (min == size2) {
                    leafByteString2 = (ByteString.LeafByteString) pieceIterator2.next();
                    i6 = 0;
                } else {
                    i6 += min;
                }
            } else if (i7 == i8) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    static int minLength(int i5) {
        int[] iArr = minLengthByDepth;
        if (i5 >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i5];
    }

    static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        PieceIterator pieceIterator = new PieceIterator(this);
        while (pieceIterator.hasNext()) {
            arrayList.add(pieceIterator.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    public byte byteAt(int i5) {
        ByteString.checkIndex(i5, this.totalLength);
        return internalByteAt(i5);
    }

    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    /* access modifiers changed from: protected */
    public void copyToInternal(byte[] bArr, int i5, int i6, int i7) {
        int i8 = i5 + i7;
        int i9 = this.leftLength;
        if (i8 <= i9) {
            this.left.copyToInternal(bArr, i5, i6, i7);
        } else if (i5 >= i9) {
            this.right.copyToInternal(bArr, i5 - i9, i6, i7);
        } else {
            int i10 = i9 - i5;
            this.left.copyToInternal(bArr, i5, i6, i10);
            this.right.copyToInternal(bArr, 0, i6 + i10, i7 - i10);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int peekCachedHashCode = peekCachedHashCode();
        int peekCachedHashCode2 = byteString.peekCachedHashCode();
        if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
            return equalsFragments(byteString);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int getTreeDepth() {
        return this.treeDepth;
    }

    /* access modifiers changed from: package-private */
    public byte internalByteAt(int i5) {
        int i6 = this.leftLength;
        if (i5 < i6) {
            return this.left.internalByteAt(i5);
        }
        return this.right.internalByteAt(i5 - i6);
    }

    /* access modifiers changed from: protected */
    public boolean isBalanced() {
        if (this.totalLength >= minLength(this.treeDepth)) {
            return true;
        }
        return false;
    }

    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        if (byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) == 0) {
            return true;
        }
        return false;
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance((Iterable<ByteBuffer>) asReadOnlyByteBufferList(), true);
    }

    public InputStream newInput() {
        return new RopeInputStream();
    }

    /* access modifiers changed from: protected */
    public int partialHash(int i5, int i6, int i7) {
        int i8 = i6 + i7;
        int i9 = this.leftLength;
        if (i8 <= i9) {
            return this.left.partialHash(i5, i6, i7);
        }
        if (i6 >= i9) {
            return this.right.partialHash(i5, i6 - i9, i7);
        }
        int i10 = i9 - i6;
        return this.right.partialHash(this.left.partialHash(i5, i6, i10), 0, i7 - i10);
    }

    /* access modifiers changed from: protected */
    public int partialIsValidUtf8(int i5, int i6, int i7) {
        int i8 = i6 + i7;
        int i9 = this.leftLength;
        if (i8 <= i9) {
            return this.left.partialIsValidUtf8(i5, i6, i7);
        }
        if (i6 >= i9) {
            return this.right.partialIsValidUtf8(i5, i6 - i9, i7);
        }
        int i10 = i9 - i6;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i5, i6, i10), 0, i7 - i10);
    }

    public int size() {
        return this.totalLength;
    }

    public ByteString substring(int i5, int i6) {
        int checkRange = ByteString.checkRange(i5, i6, this.totalLength);
        if (checkRange == 0) {
            return ByteString.EMPTY;
        }
        if (checkRange == this.totalLength) {
            return this;
        }
        int i7 = this.leftLength;
        if (i6 <= i7) {
            return this.left.substring(i5, i6);
        }
        if (i5 >= i7) {
            return this.right.substring(i5 - i7, i6 - i7);
        }
        return new RopeByteString(this.left.substring(i5), this.right.substring(0, i6 - this.leftLength));
    }

    /* access modifiers changed from: protected */
    public String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    /* access modifiers changed from: package-private */
    public void writeToInternal(OutputStream outputStream, int i5, int i6) throws IOException {
        int i7 = i5 + i6;
        int i8 = this.leftLength;
        if (i7 <= i8) {
            this.left.writeToInternal(outputStream, i5, i6);
        } else if (i5 >= i8) {
            this.right.writeToInternal(outputStream, i5 - i8, i6);
        } else {
            int i9 = i8 - i5;
            this.left.writeToInternal(outputStream, i5, i9);
            this.right.writeToInternal(outputStream, 0, i6 - i9);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeToReverse(ByteOutput byteOutput) throws IOException {
        this.right.writeToReverse(byteOutput);
        this.left.writeToReverse(byteOutput);
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    public ByteString.ByteIterator iterator() {
        return new ByteString.AbstractByteIterator() {
            ByteString.ByteIterator current = nextPiece();
            final PieceIterator pieces;

            {
                this.pieces = new PieceIterator(RopeByteString.this);
            }

            private ByteString.ByteIterator nextPiece() {
                if (this.pieces.hasNext()) {
                    return this.pieces.next().iterator();
                }
                return null;
            }

            public boolean hasNext() {
                if (this.current != null) {
                    return true;
                }
                return false;
            }

            public byte nextByte() {
                ByteString.ByteIterator byteIterator = this.current;
                if (byteIterator != null) {
                    byte nextByte = byteIterator.nextByte();
                    if (!this.current.hasNext()) {
                        this.current = nextPiece();
                    }
                    return nextByte;
                }
                throw new NoSuchElementException();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void writeTo(ByteOutput byteOutput) throws IOException {
        this.left.writeTo(byteOutput);
        this.right.writeTo(byteOutput);
    }

    private class RopeInputStream extends InputStream {
        private ByteString.LeafByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;

        public RopeInputStream() {
            initialize();
        }

        private void advanceIfCurrentPieceFullyRead() {
            int i5;
            if (this.currentPiece != null && this.currentPieceIndex == (i5 = this.currentPieceSize)) {
                this.currentPieceOffsetInRope += i5;
                this.currentPieceIndex = 0;
                if (this.pieceIterator.hasNext()) {
                    ByteString.LeafByteString next = this.pieceIterator.next();
                    this.currentPiece = next;
                    this.currentPieceSize = next.size();
                    return;
                }
                this.currentPiece = null;
                this.currentPieceSize = 0;
            }
        }

        private int availableInternal() {
            return RopeByteString.this.size() - (this.currentPieceOffsetInRope + this.currentPieceIndex);
        }

        private void initialize() {
            PieceIterator pieceIterator2 = new PieceIterator(RopeByteString.this);
            this.pieceIterator = pieceIterator2;
            ByteString.LeafByteString next = pieceIterator2.next();
            this.currentPiece = next;
            this.currentPieceSize = next.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte[] bArr, int i5, int i6) {
            int i7 = i6;
            while (i7 > 0) {
                advanceIfCurrentPieceFullyRead();
                if (this.currentPiece == null) {
                    break;
                }
                int min = Math.min(this.currentPieceSize - this.currentPieceIndex, i7);
                if (bArr != null) {
                    this.currentPiece.copyTo(bArr, this.currentPieceIndex, i5, min);
                    i5 += min;
                }
                this.currentPieceIndex += min;
                i7 -= min;
            }
            return i6 - i7;
        }

        public int available() throws IOException {
            return availableInternal();
        }

        public void mark(int i5) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        public boolean markSupported() {
            return true;
        }

        public int read(byte[] bArr, int i5, int i6) {
            bArr.getClass();
            if (i5 < 0 || i6 < 0 || i6 > bArr.length - i5) {
                throw new IndexOutOfBoundsException();
            }
            int readSkipInternal = readSkipInternal(bArr, i5, i6);
            if (readSkipInternal != 0) {
                return readSkipInternal;
            }
            if (i6 > 0 || availableInternal() == 0) {
                return -1;
            }
            return readSkipInternal;
        }

        public synchronized void reset() {
            initialize();
            readSkipInternal((byte[]) null, 0, this.mark);
        }

        public long skip(long j5) {
            if (j5 >= 0) {
                if (j5 > 2147483647L) {
                    j5 = 2147483647L;
                }
                return (long) readSkipInternal((byte[]) null, 0, (int) j5);
            }
            throw new IndexOutOfBoundsException();
        }

        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            ByteString.LeafByteString leafByteString = this.currentPiece;
            if (leafByteString == null) {
                return -1;
            }
            int i5 = this.currentPieceIndex;
            this.currentPieceIndex = i5 + 1;
            return leafByteString.byteAt(i5) & 255;
        }
    }
}
