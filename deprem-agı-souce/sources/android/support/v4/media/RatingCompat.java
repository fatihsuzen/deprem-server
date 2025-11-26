package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f128a;

    /* renamed from: b  reason: collision with root package name */
    private final float f129b;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* renamed from: b */
        public RatingCompat[] newArray(int i5) {
            return new RatingCompat[i5];
        }
    }

    RatingCompat(int i5, float f5) {
        this.f128a = i5;
        this.f129b = f5;
    }

    public int describeContents() {
        return this.f128a;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f128a);
        sb.append(" rating=");
        float f5 = this.f129b;
        if (f5 < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(f5);
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.f128a);
        parcel.writeFloat(this.f129b);
    }
}
