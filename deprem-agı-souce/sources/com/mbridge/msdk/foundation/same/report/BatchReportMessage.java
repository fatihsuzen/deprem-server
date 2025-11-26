package com.mbridge.msdk.foundation.same.report;

import android.os.Parcel;
import android.os.Parcelable;

public class BatchReportMessage implements Parcelable {
    public static final Parcelable.Creator<BatchReportMessage> CREATOR = new Parcelable.Creator<BatchReportMessage>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BatchReportMessage(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i5) {
            return new BatchReportMessage[i5];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f9415a;

    /* renamed from: b  reason: collision with root package name */
    private long f9416b;

    /* renamed from: c  reason: collision with root package name */
    private String f9417c;

    public BatchReportMessage(String str, String str2, long j5) {
        this.f9417c = str;
        this.f9415a = str2;
        this.f9416b = j5;
    }

    public int describeContents() {
        return 0;
    }

    public String getReportMessage() {
        return this.f9415a;
    }

    public long getTimestamp() {
        return this.f9416b;
    }

    public String getUuid() {
        return this.f9417c;
    }

    public void setReportMessage(String str) {
        this.f9415a = str;
    }

    public void setTimestamp(long j5) {
        this.f9416b = j5;
    }

    public void setUuid(String str) {
        this.f9417c = str;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.f9417c);
        parcel.writeString(this.f9415a);
        parcel.writeLong(this.f9416b);
    }

    protected BatchReportMessage(Parcel parcel) {
        this.f9417c = parcel.readString();
        this.f9415a = parcel.readString();
        this.f9416b = parcel.readLong();
    }
}
