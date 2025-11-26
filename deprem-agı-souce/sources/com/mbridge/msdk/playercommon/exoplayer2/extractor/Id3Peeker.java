package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;

public final class Id3Peeker {
    private final ParsableByteArray scratch = new ParsableByteArray(10);

    @Nullable
    public final Metadata peekId3Data(ExtractorInput extractorInput, @Nullable Id3Decoder.FramePredicate framePredicate) throws IOException, InterruptedException {
        Metadata metadata = null;
        int i5 = 0;
        while (true) {
            try {
                extractorInput.peekFully(this.scratch.data, 0, 10);
                this.scratch.setPosition(0);
                if (this.scratch.readUnsignedInt24() != Id3Decoder.ID3_TAG) {
                    break;
                }
                this.scratch.skipBytes(3);
                int readSynchSafeInt = this.scratch.readSynchSafeInt();
                int i6 = readSynchSafeInt + 10;
                if (metadata == null) {
                    byte[] bArr = new byte[i6];
                    System.arraycopy(this.scratch.data, 0, bArr, 0, 10);
                    extractorInput.peekFully(bArr, 10, readSynchSafeInt);
                    metadata = new Id3Decoder(framePredicate).decode(bArr, i6);
                } else {
                    extractorInput.advancePeekPosition(readSynchSafeInt);
                }
                i5 += i6;
            } catch (EOFException unused) {
            }
        }
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(i5);
        return metadata;
    }
}
