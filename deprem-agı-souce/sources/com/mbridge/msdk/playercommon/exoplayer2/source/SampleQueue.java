package com.mbridge.msdk.playercommon.exoplayer2.source;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.CryptoInfo;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleMetadataQueue;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocation;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SampleQueue implements TrackOutput {
    public static final int ADVANCE_FAILED = -1;
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private Format downstreamFormat;
    private final SampleMetadataQueue.SampleExtrasHolder extrasHolder = new SampleMetadataQueue.SampleExtrasHolder();
    private AllocationNode firstAllocationNode;
    private Format lastUnadjustedFormat;
    private final SampleMetadataQueue metadataQueue = new SampleMetadataQueue();
    private boolean pendingFormatAdjustment;
    private boolean pendingSplice;
    private AllocationNode readAllocationNode;
    private long sampleOffsetUs;
    private final ParsableByteArray scratch = new ParsableByteArray(32);
    private long totalBytesWritten;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private AllocationNode writeAllocationNode;

    private static final class AllocationNode {
        @Nullable
        public Allocation allocation;
        public final long endPosition;
        @Nullable
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long j5, int i5) {
            this.startPosition = j5;
            this.endPosition = j5 + ((long) i5);
        }

        public final AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }

        public final void initialize(Allocation allocation2, AllocationNode allocationNode) {
            this.allocation = allocation2;
            this.next = allocationNode;
            this.wasInitialized = true;
        }

        public final int translateOffset(long j5) {
            return ((int) (j5 - this.startPosition)) + this.allocation.offset;
        }
    }

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator2) {
        this.allocator = allocator2;
        int individualAllocationLength = allocator2.getIndividualAllocationLength();
        this.allocationLength = individualAllocationLength;
        AllocationNode allocationNode = new AllocationNode(0, individualAllocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    private void advanceReadTo(long j5) {
        while (true) {
            AllocationNode allocationNode = this.readAllocationNode;
            if (j5 >= allocationNode.endPosition) {
                this.readAllocationNode = allocationNode.next;
            } else {
                return;
            }
        }
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (allocationNode.wasInitialized) {
            AllocationNode allocationNode2 = this.writeAllocationNode;
            int i5 = (allocationNode2.wasInitialized ? 1 : 0) + (((int) (allocationNode2.startPosition - allocationNode.startPosition)) / this.allocationLength);
            Allocation[] allocationArr = new Allocation[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                allocationArr[i6] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private void discardDownstreamTo(long j5) {
        AllocationNode allocationNode;
        if (j5 != -1) {
            while (true) {
                allocationNode = this.firstAllocationNode;
                if (j5 < allocationNode.endPosition) {
                    break;
                }
                this.allocator.release(allocationNode.allocation);
                this.firstAllocationNode = this.firstAllocationNode.clear();
            }
            if (this.readAllocationNode.startPosition < allocationNode.startPosition) {
                this.readAllocationNode = allocationNode;
            }
        }
    }

    private static Format getAdjustedSampleFormat(Format format, long j5) {
        if (format == null) {
            return null;
        }
        if (j5 == 0) {
            return format;
        }
        long j6 = format.subsampleOffsetUs;
        if (j6 != Long.MAX_VALUE) {
            return format.copyWithSubsampleOffsetUs(j6 + j5);
        }
        return format;
    }

    private void postAppend(int i5) {
        long j5 = this.totalBytesWritten + ((long) i5);
        this.totalBytesWritten = j5;
        AllocationNode allocationNode = this.writeAllocationNode;
        if (j5 == allocationNode.endPosition) {
            this.writeAllocationNode = allocationNode.next;
        }
    }

    private int preAppend(int i5) {
        AllocationNode allocationNode = this.writeAllocationNode;
        if (!allocationNode.wasInitialized) {
            allocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(i5, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void readData(long j5, ByteBuffer byteBuffer, int i5) {
        advanceReadTo(j5);
        while (i5 > 0) {
            int min = Math.min(i5, (int) (this.readAllocationNode.endPosition - j5));
            AllocationNode allocationNode = this.readAllocationNode;
            byteBuffer.put(allocationNode.allocation.data, allocationNode.translateOffset(j5), min);
            i5 -= min;
            j5 += (long) min;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j5 == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        boolean z4;
        DecoderInputBuffer decoderInputBuffer2 = decoderInputBuffer;
        SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder2 = sampleExtrasHolder;
        long j5 = sampleExtrasHolder2.offset;
        int i5 = 1;
        this.scratch.reset(1);
        readData(j5, this.scratch.data, 1);
        long j6 = j5 + 1;
        byte b5 = this.scratch.data[0];
        if ((b5 & 128) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        byte b6 = b5 & Byte.MAX_VALUE;
        CryptoInfo cryptoInfo = decoderInputBuffer2.cryptoInfo;
        if (cryptoInfo.iv == null) {
            cryptoInfo.iv = new byte[16];
        }
        readData(j6, cryptoInfo.iv, (int) b6);
        long j7 = j6 + ((long) b6);
        if (z4) {
            this.scratch.reset(2);
            readData(j7, this.scratch.data, 2);
            j7 += 2;
            i5 = this.scratch.readUnsignedShort();
        }
        int i6 = i5;
        CryptoInfo cryptoInfo2 = decoderInputBuffer2.cryptoInfo;
        int[] iArr = cryptoInfo2.numBytesOfClearData;
        if (iArr == null || iArr.length < i6) {
            iArr = new int[i6];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo2.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i6) {
            iArr3 = new int[i6];
        }
        int[] iArr4 = iArr3;
        if (z4) {
            int i7 = i6 * 6;
            this.scratch.reset(i7);
            readData(j7, this.scratch.data, i7);
            j7 += (long) i7;
            this.scratch.setPosition(0);
            for (int i8 = 0; i8 < i6; i8++) {
                iArr2[i8] = this.scratch.readUnsignedShort();
                iArr4[i8] = this.scratch.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder2.size - ((int) (j7 - sampleExtrasHolder2.offset));
        }
        TrackOutput.CryptoData cryptoData = sampleExtrasHolder2.cryptoData;
        CryptoInfo cryptoInfo3 = decoderInputBuffer2.cryptoInfo;
        cryptoInfo3.set(i6, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo3.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        long j8 = sampleExtrasHolder2.offset;
        int i9 = (int) (j7 - j8);
        sampleExtrasHolder2.offset = j8 + ((long) i9);
        sampleExtrasHolder2.size -= i9;
    }

    public final int advanceTo(long j5, boolean z4, boolean z5) {
        return this.metadataQueue.advanceTo(j5, z4, z5);
    }

    public final int advanceToEnd() {
        return this.metadataQueue.advanceToEnd();
    }

    public final void discardTo(long j5, boolean z4, boolean z5) {
        discardDownstreamTo(this.metadataQueue.discardTo(j5, z4, z5));
    }

    public final void discardToEnd() {
        discardDownstreamTo(this.metadataQueue.discardToEnd());
    }

    public final void discardToRead() {
        discardDownstreamTo(this.metadataQueue.discardToRead());
    }

    public final void discardUpstreamSamples(int i5) {
        long discardUpstreamSamples = this.metadataQueue.discardUpstreamSamples(i5);
        this.totalBytesWritten = discardUpstreamSamples;
        if (discardUpstreamSamples != 0) {
            AllocationNode allocationNode = this.firstAllocationNode;
            if (discardUpstreamSamples != allocationNode.startPosition) {
                while (this.totalBytesWritten > allocationNode.endPosition) {
                    allocationNode = allocationNode.next;
                }
                AllocationNode allocationNode2 = allocationNode.next;
                clearAllocationNodes(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.endPosition, this.allocationLength);
                allocationNode.next = allocationNode3;
                if (this.totalBytesWritten == allocationNode.endPosition) {
                    allocationNode = allocationNode3;
                }
                this.writeAllocationNode = allocationNode;
                if (this.readAllocationNode == allocationNode2) {
                    this.readAllocationNode = allocationNode3;
                    return;
                }
                return;
            }
        }
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode4 = new AllocationNode(this.totalBytesWritten, this.allocationLength);
        this.firstAllocationNode = allocationNode4;
        this.readAllocationNode = allocationNode4;
        this.writeAllocationNode = allocationNode4;
    }

    public final void format(Format format) {
        Format adjustedSampleFormat = getAdjustedSampleFormat(format, this.sampleOffsetUs);
        boolean format2 = this.metadataQueue.format(adjustedSampleFormat);
        this.lastUnadjustedFormat = format;
        this.pendingFormatAdjustment = false;
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener != null && format2) {
            upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedSampleFormat);
        }
    }

    public final int getFirstIndex() {
        return this.metadataQueue.getFirstIndex();
    }

    public final long getFirstTimestampUs() {
        return this.metadataQueue.getFirstTimestampUs();
    }

    public final long getLargestQueuedTimestampUs() {
        return this.metadataQueue.getLargestQueuedTimestampUs();
    }

    public final int getReadIndex() {
        return this.metadataQueue.getReadIndex();
    }

    public final Format getUpstreamFormat() {
        return this.metadataQueue.getUpstreamFormat();
    }

    public final int getWriteIndex() {
        return this.metadataQueue.getWriteIndex();
    }

    public final boolean hasNextSample() {
        return this.metadataQueue.hasNextSample();
    }

    public final int peekSourceId() {
        return this.metadataQueue.peekSourceId();
    }

    public final int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z4, boolean z5, long j5) {
        FormatHolder formatHolder2 = formatHolder;
        DecoderInputBuffer decoderInputBuffer2 = decoderInputBuffer;
        int read = this.metadataQueue.read(formatHolder2, decoderInputBuffer2, z4, z5, this.downstreamFormat, this.extrasHolder);
        if (read == -5) {
            this.downstreamFormat = formatHolder2.format;
            return -5;
        } else if (read == -4) {
            if (!decoderInputBuffer2.isEndOfStream()) {
                if (decoderInputBuffer2.timeUs < j5) {
                    decoderInputBuffer2.addFlag(Integer.MIN_VALUE);
                }
                if (decoderInputBuffer2.isEncrypted()) {
                    readEncryptionData(decoderInputBuffer2, this.extrasHolder);
                }
                decoderInputBuffer2.ensureSpaceForWrite(this.extrasHolder.size);
                SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder = this.extrasHolder;
                readData(sampleExtrasHolder.offset, decoderInputBuffer2.data, sampleExtrasHolder.size);
            }
            return -4;
        } else if (read == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    public final void reset() {
        reset(false);
    }

    public final void rewind() {
        this.metadataQueue.rewind();
        this.readAllocationNode = this.firstAllocationNode;
    }

    public final int sampleData(ExtractorInput extractorInput, int i5, boolean z4) throws IOException, InterruptedException {
        int preAppend = preAppend(i5);
        AllocationNode allocationNode = this.writeAllocationNode;
        int read = extractorInput.read(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
        if (read != -1) {
            postAppend(read);
            return read;
        } else if (z4) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void sampleMetadata(long j5, int i5, int i6, int i7, TrackOutput.CryptoData cryptoData) {
        if (this.pendingFormatAdjustment) {
            format(this.lastUnadjustedFormat);
        }
        if (this.pendingSplice) {
            if ((i5 & 1) != 0 && this.metadataQueue.attemptSplice(j5)) {
                this.pendingSplice = false;
            } else {
                return;
            }
        }
        this.metadataQueue.commitSample(j5 + this.sampleOffsetUs, i5, (this.totalBytesWritten - ((long) i6)) - ((long) i7), i6, cryptoData);
    }

    public final boolean setReadPosition(int i5) {
        return this.metadataQueue.setReadPosition(i5);
    }

    public final void setSampleOffsetUs(long j5) {
        if (this.sampleOffsetUs != j5) {
            this.sampleOffsetUs = j5;
            this.pendingFormatAdjustment = true;
        }
    }

    public final void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public final void sourceId(int i5) {
        this.metadataQueue.sourceId(i5);
    }

    public final void splice() {
        this.pendingSplice = true;
    }

    public final void reset(boolean z4) {
        this.metadataQueue.reset(z4);
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode = new AllocationNode(0, this.allocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0;
        this.allocator.trim();
    }

    private void readData(long j5, byte[] bArr, int i5) {
        advanceReadTo(j5);
        int i6 = i5;
        while (i6 > 0) {
            int min = Math.min(i6, (int) (this.readAllocationNode.endPosition - j5));
            AllocationNode allocationNode = this.readAllocationNode;
            System.arraycopy(allocationNode.allocation.data, allocationNode.translateOffset(j5), bArr, i5 - i6, min);
            i6 -= min;
            j5 += (long) min;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j5 == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    public final void sampleData(ParsableByteArray parsableByteArray, int i5) {
        while (i5 > 0) {
            int preAppend = preAppend(i5);
            AllocationNode allocationNode = this.writeAllocationNode;
            parsableByteArray.readBytes(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
            i5 -= preAppend;
            postAppend(preAppend);
        }
    }
}
