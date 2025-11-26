package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import androidx.appcompat.R;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class TrackFragment {
    public long atomPosition;
    public long auxiliaryDataPosition;
    public long dataPosition;
    public boolean definesEncryptionData;
    public DefaultSampleValues header;
    public long nextFragmentDecodeTime;
    public int[] sampleCompositionTimeOffsetTable;
    public int sampleCount;
    public long[] sampleDecodingTimeTable;
    public ParsableByteArray sampleEncryptionData;
    public int sampleEncryptionDataLength;
    public boolean sampleEncryptionDataNeedsFill;
    public boolean[] sampleHasSubsampleEncryptionTable;
    public boolean[] sampleIsSyncFrameTable;
    public int[] sampleSizeTable;
    public TrackEncryptionBox trackEncryptionBox;
    public int trunCount;
    public long[] trunDataPosition;
    public int[] trunLength;

    TrackFragment() {
    }

    public final void fillEncryptionData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        extractorInput.readFully(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public final long getSamplePresentationTime(int i5) {
        return this.sampleDecodingTimeTable[i5] + ((long) this.sampleCompositionTimeOffsetTable[i5]);
    }

    public final void initEncryptionData(int i5) {
        ParsableByteArray parsableByteArray = this.sampleEncryptionData;
        if (parsableByteArray == null || parsableByteArray.limit() < i5) {
            this.sampleEncryptionData = new ParsableByteArray(i5);
        }
        this.sampleEncryptionDataLength = i5;
        this.definesEncryptionData = true;
        this.sampleEncryptionDataNeedsFill = true;
    }

    public final void initTables(int i5, int i6) {
        this.trunCount = i5;
        this.sampleCount = i6;
        int[] iArr = this.trunLength;
        if (iArr == null || iArr.length < i5) {
            this.trunDataPosition = new long[i5];
            this.trunLength = new int[i5];
        }
        int[] iArr2 = this.sampleSizeTable;
        if (iArr2 == null || iArr2.length < i6) {
            int i7 = (i6 * R.styleable.AppCompatTheme_windowMinWidthMinor) / 100;
            this.sampleSizeTable = new int[i7];
            this.sampleCompositionTimeOffsetTable = new int[i7];
            this.sampleDecodingTimeTable = new long[i7];
            this.sampleIsSyncFrameTable = new boolean[i7];
            this.sampleHasSubsampleEncryptionTable = new boolean[i7];
        }
    }

    public final void reset() {
        this.trunCount = 0;
        this.nextFragmentDecodeTime = 0;
        this.definesEncryptionData = false;
        this.sampleEncryptionDataNeedsFill = false;
        this.trackEncryptionBox = null;
    }

    public final void fillEncryptionData(ParsableByteArray parsableByteArray) {
        parsableByteArray.readBytes(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }
}
