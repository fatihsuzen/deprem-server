package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f157a;

    /* renamed from: b  reason: collision with root package name */
    public int f158b;

    /* renamed from: c  reason: collision with root package name */
    public int f159c;

    /* renamed from: d  reason: collision with root package name */
    public int f160d;

    /* renamed from: e  reason: collision with root package name */
    public int f161e;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: b */
        public ParcelableVolumeInfo[] newArray(int i5) {
            return new ParcelableVolumeInfo[i5];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f157a = parcel.readInt();
        this.f159c = parcel.readInt();
        this.f160d = parcel.readInt();
        this.f161e = parcel.readInt();
        this.f158b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f157a);
        parcel.writeInt(this.f159c);
        parcel.writeInt(this.f160d);
        parcel.writeInt(this.f161e);
        parcel.writeInt(this.f158b);
    }
}
