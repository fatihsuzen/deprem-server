package com.mbridge.msdk.foundation.download;

import android.os.Parcel;
import android.os.Parcelable;

public class DownloadProgress implements Parcelable {
    public static final Parcelable.Creator<DownloadProgress> CREATOR = new Parcelable.Creator<DownloadProgress>() {
        public final DownloadProgress createFromParcel(Parcel parcel) {
            return new DownloadProgress(parcel);
        }

        public final DownloadProgress[] newArray(int i5) {
            return new DownloadProgress[i5];
        }
    };
    private long current;
    private int currentDownloadRate;
    private long total;

    public DownloadProgress(long j5, long j6, int i5) {
        this.current = j5;
        this.total = j6;
        this.currentDownloadRate = i5;
    }

    public int describeContents() {
        return 0;
    }

    public long getCurrent() {
        return this.current;
    }

    public int getCurrentDownloadRate() {
        return this.currentDownloadRate;
    }

    public long getTotal() {
        return this.total;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeLong(this.current);
        parcel.writeLong(this.total);
        parcel.writeInt(this.currentDownloadRate);
    }

    protected DownloadProgress(Parcel parcel) {
        this.current = parcel.readLong();
        this.total = parcel.readLong();
        this.currentDownloadRate = parcel.readInt();
    }
}
