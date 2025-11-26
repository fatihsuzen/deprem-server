package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Track {
    public static final int TRANSFORMATION_CEA608_CDAT = 1;
    public static final int TRANSFORMATION_NONE = 0;
    public final long durationUs;
    @Nullable
    public final long[] editListDurations;
    @Nullable
    public final long[] editListMediaTimes;
    public final Format format;
    public final int id;
    public final long movieTimescale;
    public final int nalUnitLengthFieldLength;
    @Nullable
    private final TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;
    public final int sampleTransformation;
    public final long timescale;
    public final int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Transformation {
    }

    public Track(int i5, int i6, long j5, long j6, long j7, Format format2, int i7, @Nullable TrackEncryptionBox[] trackEncryptionBoxArr, int i8, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.id = i5;
        this.type = i6;
        this.timescale = j5;
        this.movieTimescale = j6;
        this.durationUs = j7;
        this.format = format2;
        this.sampleTransformation = i7;
        this.sampleDescriptionEncryptionBoxes = trackEncryptionBoxArr;
        this.nalUnitLengthFieldLength = i8;
        this.editListDurations = jArr;
        this.editListMediaTimes = jArr2;
    }

    public final TrackEncryptionBox getSampleDescriptionEncryptionBox(int i5) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.sampleDescriptionEncryptionBoxes;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i5];
    }
}
