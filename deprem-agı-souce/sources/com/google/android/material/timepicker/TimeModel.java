package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.material.R;
import java.util.Arrays;

class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new Parcelable.Creator<TimeModel>() {
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        public TimeModel[] newArray(int i5) {
            return new TimeModel[i5];
        }
    };
    public static final String NUMBER_FORMAT = "%d";
    public static final String ZERO_LEADING_NUMBER_FORMAT = "%02d";
    final int format;
    int hour;
    private final MaxInputValidator hourInputValidator;
    int minute;
    private final MaxInputValidator minuteInputValidator;
    int period;
    int selection;

    public TimeModel() {
        this(0);
    }

    @Nullable
    public static String formatText(Resources resources, CharSequence charSequence) {
        return formatText(resources, charSequence, ZERO_LEADING_NUMBER_FORMAT);
    }

    private static int getPeriod(int i5) {
        return i5 >= 12 ? 1 : 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        if (this.hour == timeModel.hour && this.minute == timeModel.minute && this.format == timeModel.format && this.selection == timeModel.selection) {
            return true;
        }
        return false;
    }

    @StringRes
    public int getHourContentDescriptionResId() {
        if (this.format == 1) {
            return R.string.material_hour_24h_suffix;
        }
        return R.string.material_hour_suffix;
    }

    public int getHourForDisplay() {
        if (this.format == 1) {
            return this.hour % 24;
        }
        int i5 = this.hour;
        if (i5 % 12 == 0) {
            return 12;
        }
        if (this.period == 1) {
            return i5 - 12;
        }
        return i5;
    }

    public MaxInputValidator getHourInputValidator() {
        return this.hourInputValidator;
    }

    public MaxInputValidator getMinuteInputValidator() {
        return this.minuteInputValidator;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.format), Integer.valueOf(this.hour), Integer.valueOf(this.minute), Integer.valueOf(this.selection)});
    }

    public void setHour(int i5) {
        if (this.format == 1) {
            this.hour = i5;
            return;
        }
        int i6 = 12;
        int i7 = i5 % 12;
        if (this.period != 1) {
            i6 = 0;
        }
        this.hour = i7 + i6;
    }

    public void setHourOfDay(int i5) {
        this.period = getPeriod(i5);
        this.hour = i5;
    }

    public void setMinute(@IntRange(from = 0, to = 59) int i5) {
        this.minute = i5 % 60;
    }

    public void setPeriod(int i5) {
        if (i5 != this.period) {
            this.period = i5;
            int i6 = this.hour;
            if (i6 < 12 && i5 == 1) {
                this.hour = i6 + 12;
            } else if (i6 >= 12 && i5 == 0) {
                this.hour = i6 - 12;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minute);
        parcel.writeInt(this.selection);
        parcel.writeInt(this.format);
    }

    public TimeModel(int i5) {
        this(0, 0, 10, i5);
    }

    @Nullable
    public static String formatText(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(charSequence)))});
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public TimeModel(int i5, int i6, int i7, int i8) {
        this.hour = i5;
        this.minute = i6;
        this.selection = i7;
        this.format = i8;
        this.period = getPeriod(i5);
        this.minuteInputValidator = new MaxInputValidator(59);
        this.hourInputValidator = new MaxInputValidator(i8 == 1 ? 23 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
