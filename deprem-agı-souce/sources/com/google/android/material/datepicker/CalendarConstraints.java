package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import j$.util.Objects;
import java.util.Arrays;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() {
        @NonNull
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            Class<Month> cls = Month.class;
            return new CalendarConstraints((Month) parcel.readParcelable(cls.getClassLoader()), (Month) parcel.readParcelable(cls.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(cls.getClassLoader()), parcel.readInt());
        }

        @NonNull
        public CalendarConstraints[] newArray(int i5) {
            return new CalendarConstraints[i5];
        }
    };
    /* access modifiers changed from: private */
    @NonNull
    public final Month end;
    /* access modifiers changed from: private */
    public final int firstDayOfWeek;
    private final int monthSpan;
    /* access modifiers changed from: private */
    @Nullable
    public Month openAt;
    /* access modifiers changed from: private */
    @NonNull
    public final Month start;
    /* access modifiers changed from: private */
    @NonNull
    public final DateValidator validator;
    private final int yearSpan;

    public interface DateValidator extends Parcelable {
        boolean isValid(long j5);
    }

    /* access modifiers changed from: package-private */
    public Month clamp(Month month) {
        if (month.compareTo(this.start) < 0) {
            return this.start;
        }
        if (month.compareTo(this.end) > 0) {
            return this.end;
        }
        return month;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (!this.start.equals(calendarConstraints.start) || !this.end.equals(calendarConstraints.end) || !ObjectsCompat.equals(this.openAt, calendarConstraints.openAt) || this.firstDayOfWeek != calendarConstraints.firstDayOfWeek || !this.validator.equals(calendarConstraints.validator)) {
            return false;
        }
        return true;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month getEnd() {
        return this.end;
    }

    public long getEndMs() {
        return this.end.timeInMillis;
    }

    /* access modifiers changed from: package-private */
    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    /* access modifiers changed from: package-private */
    public int getMonthSpan() {
        return this.monthSpan;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Month getOpenAt() {
        return this.openAt;
    }

    @Nullable
    public Long getOpenAtMs() {
        Month month = this.openAt;
        if (month == null) {
            return null;
        }
        return Long.valueOf(month.timeInMillis);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month getStart() {
        return this.start;
    }

    public long getStartMs() {
        return this.start.timeInMillis;
    }

    /* access modifiers changed from: package-private */
    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, Integer.valueOf(this.firstDayOfWeek), this.validator});
    }

    /* access modifiers changed from: package-private */
    public boolean isWithinBounds(long j5) {
        if (this.start.getDay(1) > j5) {
            return false;
        }
        Month month = this.end;
        if (j5 <= month.getDay(month.daysInMonth)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void setOpenAt(@Nullable Month month) {
        this.openAt = month;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
        parcel.writeInt(this.firstDayOfWeek);
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3, int i5) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.firstDayOfWeek = i5;
        this.validator = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        } else if (i5 < 0 || i5 > UtcDates.getUtcCalendar().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        } else {
            this.monthSpan = month.monthsUntil(month2) + 1;
            this.yearSpan = (month2.year - month.year) + 1;
        }
    }

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
        static final long DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
        private long end = DEFAULT_END;
        private int firstDayOfWeek;
        private Long openAt;
        private long start = DEFAULT_START;
        private DateValidator validator = DateValidatorPointForward.from(Long.MIN_VALUE);

        public Builder() {
        }

        @NonNull
        public CalendarConstraints build() {
            Month create;
            Bundle bundle = new Bundle();
            bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            Month create2 = Month.create(this.start);
            Month create3 = Month.create(this.end);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY);
            Long l5 = this.openAt;
            if (l5 == null) {
                create = null;
            } else {
                create = Month.create(l5.longValue());
            }
            return new CalendarConstraints(create2, create3, dateValidator, create, this.firstDayOfWeek);
        }

        @NonNull
        public Builder setEnd(long j5) {
            this.end = j5;
            return this;
        }

        @NonNull
        public Builder setFirstDayOfWeek(int i5) {
            this.firstDayOfWeek = i5;
            return this;
        }

        @NonNull
        public Builder setOpenAt(long j5) {
            this.openAt = Long.valueOf(j5);
            return this;
        }

        @NonNull
        public Builder setStart(long j5) {
            this.start = j5;
            return this;
        }

        @NonNull
        public Builder setValidator(@NonNull DateValidator dateValidator) {
            Objects.requireNonNull(dateValidator, "validator cannot be null");
            this.validator = dateValidator;
            return this;
        }

        Builder(@NonNull CalendarConstraints calendarConstraints) {
            this.start = calendarConstraints.start.timeInMillis;
            this.end = calendarConstraints.end.timeInMillis;
            this.openAt = Long.valueOf(calendarConstraints.openAt.timeInMillis);
            this.firstDayOfWeek = calendarConstraints.firstDayOfWeek;
            this.validator = calendarConstraints.validator;
        }
    }
}
