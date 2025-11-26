package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

class TimeSource {
    private static final TimeSource SYSTEM_TIME_SOURCE = new TimeSource((Long) null, (TimeZone) null);
    @Nullable
    private final Long fixedTimeMs;
    @Nullable
    private final TimeZone fixedTimeZone;

    private TimeSource(@Nullable Long l5, @Nullable TimeZone timeZone) {
        this.fixedTimeMs = l5;
        this.fixedTimeZone = timeZone;
    }

    static TimeSource fixed(long j5, @Nullable TimeZone timeZone) {
        return new TimeSource(Long.valueOf(j5), timeZone);
    }

    static TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    /* access modifiers changed from: package-private */
    public Calendar now() {
        return now(this.fixedTimeZone);
    }

    static TimeSource fixed(long j5) {
        return new TimeSource(Long.valueOf(j5), (TimeZone) null);
    }

    /* access modifiers changed from: package-private */
    public Calendar now(@Nullable TimeZone timeZone) {
        Calendar instance = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l5 = this.fixedTimeMs;
        if (l5 != null) {
            instance.setTimeInMillis(l5.longValue());
        }
        return instance;
    }
}
