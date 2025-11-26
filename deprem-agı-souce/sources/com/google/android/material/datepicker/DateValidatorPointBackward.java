package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

public class DateValidatorPointBackward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointBackward> CREATOR = new Parcelable.Creator<DateValidatorPointBackward>() {
        @NonNull
        public DateValidatorPointBackward createFromParcel(@NonNull Parcel parcel) {
            return new DateValidatorPointBackward(parcel.readLong());
        }

        @NonNull
        public DateValidatorPointBackward[] newArray(int i5) {
            return new DateValidatorPointBackward[i5];
        }
    };
    private final long point;

    @NonNull
    public static DateValidatorPointBackward before(long j5) {
        return new DateValidatorPointBackward(j5);
    }

    @NonNull
    public static DateValidatorPointBackward now() {
        return before(UtcDates.getTodayCalendar().getTimeInMillis());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DateValidatorPointBackward) && this.point == ((DateValidatorPointBackward) obj).point) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }

    public boolean isValid(long j5) {
        if (j5 <= this.point) {
            return true;
        }
        return false;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i5) {
        parcel.writeLong(this.point);
    }

    private DateValidatorPointBackward(long j5) {
        this.point = j5;
    }
}
