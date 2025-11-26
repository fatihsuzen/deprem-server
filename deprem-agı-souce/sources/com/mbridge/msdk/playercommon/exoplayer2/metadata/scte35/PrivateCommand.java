package com.mbridge.msdk.playercommon.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;

public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() {
        public final PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        public final PrivateCommand[] newArray(int i5) {
            return new PrivateCommand[i5];
        }
    };
    public final byte[] commandBytes;
    public final long identifier;
    public final long ptsAdjustment;

    static PrivateCommand parseFromSection(ParsableByteArray parsableByteArray, int i5, long j5) {
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        int i6 = i5 - 4;
        byte[] bArr = new byte[i6];
        parsableByteArray.readBytes(bArr, 0, i6);
        return new PrivateCommand(readUnsignedInt, bArr, j5);
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        parcel.writeLong(this.ptsAdjustment);
        parcel.writeLong(this.identifier);
        parcel.writeInt(this.commandBytes.length);
        parcel.writeByteArray(this.commandBytes);
    }

    private PrivateCommand(long j5, byte[] bArr, long j6) {
        this.ptsAdjustment = j6;
        this.identifier = j5;
        this.commandBytes = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.ptsAdjustment = parcel.readLong();
        this.identifier = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.commandBytes = bArr;
        parcel.readByteArray(bArr);
    }
}
