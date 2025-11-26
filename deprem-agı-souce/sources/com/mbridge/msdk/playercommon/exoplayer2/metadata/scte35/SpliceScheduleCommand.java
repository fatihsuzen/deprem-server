package com.mbridge.msdk.playercommon.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() {
        public final SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        public final SpliceScheduleCommand[] newArray(int i5) {
            return new SpliceScheduleCommand[i5];
        }
    };
    public final List<Event> events;

    public static final class ComponentSplice {
        public final int componentTag;
        public final long utcSpliceTime;

        /* access modifiers changed from: private */
        public static ComponentSplice createFromParcel(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong());
        }

        /* access modifiers changed from: private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.utcSpliceTime);
        }

        private ComponentSplice(int i5, long j5) {
            this.componentTag = i5;
            this.utcSpliceTime = j5;
        }
    }

    static SpliceScheduleCommand parseFromSection(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        ArrayList arrayList = new ArrayList(readUnsignedByte);
        for (int i5 = 0; i5 < readUnsignedByte; i5++) {
            arrayList.add(Event.parseFromSection(parsableByteArray));
        }
        return new SpliceScheduleCommand((List<Event>) arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i5) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            this.events.get(i6).writeToParcel(parcel);
        }
    }

    private SpliceScheduleCommand(List<Event> list) {
        this.events = DesugarCollections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i5 = 0; i5 < readInt; i5++) {
            arrayList.add(Event.createFromParcel(parcel));
        }
        this.events = DesugarCollections.unmodifiableList(arrayList);
    }

    public static final class Event {
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDurationUs;
        public final List<ComponentSplice> componentSpliceList;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;
        public final long utcSpliceTime;

        private Event(long j5, boolean z4, boolean z5, boolean z6, List<ComponentSplice> list, long j6, boolean z7, long j7, int i5, int i6, int i7) {
            this.spliceEventId = j5;
            this.spliceEventCancelIndicator = z4;
            this.outOfNetworkIndicator = z5;
            this.programSpliceFlag = z6;
            this.componentSpliceList = DesugarCollections.unmodifiableList(list);
            this.utcSpliceTime = j6;
            this.autoReturn = z7;
            this.breakDurationUs = j7;
            this.uniqueProgramId = i5;
            this.availNum = i6;
            this.availsExpected = i7;
        }

        /* access modifiers changed from: private */
        public static Event createFromParcel(Parcel parcel) {
            return new Event(parcel);
        }

        /* access modifiers changed from: private */
        public static Event parseFromSection(ParsableByteArray parsableByteArray) {
            boolean z4;
            int i5;
            int i6;
            int i7;
            long j5;
            boolean z5;
            long j6;
            ArrayList arrayList;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            long j7;
            long j8;
            boolean z11;
            boolean z12;
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            boolean z13 = true;
            if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                z4 = true;
            } else {
                z4 = true;
                z13 = false;
            }
            ArrayList arrayList2 = new ArrayList();
            if (!z13) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                if ((readUnsignedByte & 128) != 0) {
                    z8 = z4;
                } else {
                    z8 = false;
                }
                if ((readUnsignedByte & 64) != 0) {
                    z9 = z4;
                } else {
                    z9 = false;
                }
                if ((readUnsignedByte & 32) != 0) {
                    z10 = z4;
                } else {
                    z10 = false;
                }
                if (z9) {
                    j7 = parsableByteArray.readUnsignedInt();
                } else {
                    j7 = C.TIME_UNSET;
                }
                if (!z9) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    ArrayList arrayList3 = new ArrayList(readUnsignedByte2);
                    int i8 = 0;
                    while (i8 < readUnsignedByte2) {
                        arrayList3.add(new ComponentSplice(parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedInt()));
                        i8++;
                        readUnsignedByte2 = readUnsignedByte2;
                    }
                    arrayList2 = arrayList3;
                }
                if (z10) {
                    long readUnsignedByte3 = (long) parsableByteArray.readUnsignedByte();
                    if ((128 & readUnsignedByte3) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    j8 = ((((readUnsignedByte3 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                    z11 = z12;
                } else {
                    z11 = false;
                    j8 = C.TIME_UNSET;
                }
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                boolean z14 = z8;
                z5 = z11;
                z7 = z14;
                i5 = parsableByteArray.readUnsignedByte();
                long j9 = j7;
                i7 = readUnsignedShort;
                i6 = readUnsignedByte4;
                long j10 = j8;
                arrayList = arrayList2;
                z6 = z9;
                j6 = j9;
                j5 = j10;
            } else {
                arrayList = arrayList2;
                z7 = false;
                z6 = false;
                j6 = C.TIME_UNSET;
                z5 = false;
                j5 = C.TIME_UNSET;
                i7 = 0;
                i6 = 0;
                i5 = 0;
            }
            return new Event(readUnsignedInt, z13, z7, z6, arrayList, j6, z5, j5, i7, i6, i5);
        }

        /* access modifiers changed from: private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeLong(this.spliceEventId);
            parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : 0);
            parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : 0);
            parcel.writeByte(this.programSpliceFlag ? (byte) 1 : 0);
            int size = this.componentSpliceList.size();
            parcel.writeInt(size);
            for (int i5 = 0; i5 < size; i5++) {
                this.componentSpliceList.get(i5).writeToParcel(parcel);
            }
            parcel.writeLong(this.utcSpliceTime);
            parcel.writeByte(this.autoReturn ? (byte) 1 : 0);
            parcel.writeLong(this.breakDurationUs);
            parcel.writeInt(this.uniqueProgramId);
            parcel.writeInt(this.availNum);
            parcel.writeInt(this.availsExpected);
        }

        private Event(Parcel parcel) {
            this.spliceEventId = parcel.readLong();
            boolean z4 = false;
            this.spliceEventCancelIndicator = parcel.readByte() == 1;
            this.outOfNetworkIndicator = parcel.readByte() == 1;
            this.programSpliceFlag = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i5 = 0; i5 < readInt; i5++) {
                arrayList.add(ComponentSplice.createFromParcel(parcel));
            }
            this.componentSpliceList = DesugarCollections.unmodifiableList(arrayList);
            this.utcSpliceTime = parcel.readLong();
            this.autoReturn = parcel.readByte() == 1 ? true : z4;
            this.breakDurationUs = parcel.readLong();
            this.uniqueProgramId = parcel.readInt();
            this.availNum = parcel.readInt();
            this.availsExpected = parcel.readInt();
        }
    }
}
