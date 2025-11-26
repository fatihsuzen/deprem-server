package com.mbridge.msdk.playercommon.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.TimestampAdjuster;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator<TimeSignalCommand>() {
        public final TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        public final TimeSignalCommand[] newArray(int i5) {
            return new TimeSignalCommand[i5];
        }
    };
    public final long playbackPositionUs;
    public final long ptsTime;

    static TimeSignalCommand parseFromSection(ParsableByteArray parsableByteArray, long j5, TimestampAdjuster timestampAdjuster) {
        long parseSpliceTime = parseSpliceTime(parsableByteArray, j5);
        return new TimeSignalCommand(parseSpliceTime, timestampAdjuster.adjustTsTimestamp(parseSpliceTime));
    }

    static long parseSpliceTime(ParsableByteArray parsableByteArray, long j5) {
        long readUnsignedByte = (long) parsableByteArray.readUnsignedByte();
        if ((128 & readUnsignedByte) != 0) {
            return 8589934591L & ((((readUnsignedByte & 1) << 32) | parsableByteArray.readUnsignedInt()) + j5);
        }
        return C.TIME_UNSET;
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeLong(this.ptsTime);
        parcel.writeLong(this.playbackPositionUs);
    }

    private TimeSignalCommand(long j5, long j6) {
        this.ptsTime = j5;
        this.playbackPositionUs = j6;
    }
}
