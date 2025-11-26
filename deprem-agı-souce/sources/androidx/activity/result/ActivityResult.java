package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() {
        public ActivityResult createFromParcel(@NonNull Parcel parcel) {
            return new ActivityResult(parcel);
        }

        public ActivityResult[] newArray(int i5) {
            return new ActivityResult[i5];
        }
    };
    @Nullable
    private final Intent mData;
    private final int mResultCode;

    public ActivityResult(int i5, @Nullable Intent intent) {
        this.mResultCode = i5;
        this.mData = intent;
    }

    @NonNull
    public static String resultCodeToString(int i5) {
        if (i5 == -1) {
            return "RESULT_OK";
        }
        if (i5 != 0) {
            return String.valueOf(i5);
        }
        return "RESULT_CANCELED";
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public Intent getData() {
        return this.mData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.mResultCode) + ", data=" + this.mData + '}';
    }

    public void writeToParcel(@NonNull Parcel parcel, int i5) {
        int i6;
        parcel.writeInt(this.mResultCode);
        if (this.mData == null) {
            i6 = 0;
        } else {
            i6 = 1;
        }
        parcel.writeInt(i6);
        Intent intent = this.mData;
        if (intent != null) {
            intent.writeToParcel(parcel, i5);
        }
    }

    ActivityResult(Parcel parcel) {
        this.mResultCode = parcel.readInt();
        this.mData = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
