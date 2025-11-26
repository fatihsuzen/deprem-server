package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class DateStrings {
    private DateStrings() {
    }

    static Pair<String, String> getDateRangeString(@Nullable Long l5, @Nullable Long l6) {
        return getDateRangeString(l5, l6, (SimpleDateFormat) null);
    }

    static String getDateString(long j5) {
        return getDateString(j5, (SimpleDateFormat) null);
    }

    static String getDayContentDescription(Context context, long j5, boolean z4, boolean z5, boolean z6) {
        String optionalYearMonthDayOfWeekDay = getOptionalYearMonthDayOfWeekDay(j5);
        if (z4) {
            optionalYearMonthDayOfWeekDay = String.format(context.getString(R.string.mtrl_picker_today_description), new Object[]{optionalYearMonthDayOfWeekDay});
        }
        if (z5) {
            return String.format(context.getString(R.string.mtrl_picker_start_date_description), new Object[]{optionalYearMonthDayOfWeekDay});
        } else if (!z6) {
            return optionalYearMonthDayOfWeekDay;
        } else {
            return String.format(context.getString(R.string.mtrl_picker_end_date_description), new Object[]{optionalYearMonthDayOfWeekDay});
        }
    }

    static String getMonthDay(long j5) {
        return getMonthDay(j5, Locale.getDefault());
    }

    static String getMonthDayOfWeekDay(long j5) {
        return getMonthDayOfWeekDay(j5, Locale.getDefault());
    }

    static String getOptionalYearMonthDayOfWeekDay(long j5) {
        if (isDateWithinCurrentYear(j5)) {
            return getMonthDayOfWeekDay(j5);
        }
        return getYearMonthDayOfWeekDay(j5);
    }

    static String getYearContentDescription(Context context, int i5) {
        if (UtcDates.getTodayCalendar().get(1) == i5) {
            return String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), new Object[]{Integer.valueOf(i5)});
        }
        return String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), new Object[]{Integer.valueOf(i5)});
    }

    static String getYearMonth(long j5) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(j5));
        }
        return DateUtils.formatDateTime((Context) null, j5, 8228);
    }

    static String getYearMonthDay(long j5) {
        return getYearMonthDay(j5, Locale.getDefault());
    }

    static String getYearMonthDayOfWeekDay(long j5) {
        return getYearMonthDayOfWeekDay(j5, Locale.getDefault());
    }

    private static boolean isDateWithinCurrentYear(long j5) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j5);
        if (todayCalendar.get(1) == utcCalendar.get(1)) {
            return true;
        }
        return false;
    }

    static Pair<String, String> getDateRangeString(@Nullable Long l5, @Nullable Long l6, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l5 == null && l6 == null) {
            return Pair.create(null, null);
        }
        if (l5 == null) {
            return Pair.create(null, getDateString(l6.longValue(), simpleDateFormat));
        }
        if (l6 == null) {
            return Pair.create(getDateString(l5.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l5.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l6.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l5.longValue())), simpleDateFormat.format(new Date(l6.longValue())));
        } else if (utcCalendar.get(1) != utcCalendar2.get(1)) {
            return Pair.create(getYearMonthDay(l5.longValue(), Locale.getDefault()), getYearMonthDay(l6.longValue(), Locale.getDefault()));
        } else {
            if (utcCalendar.get(1) == todayCalendar.get(1)) {
                return Pair.create(getMonthDay(l5.longValue(), Locale.getDefault()), getMonthDay(l6.longValue(), Locale.getDefault()));
            }
            return Pair.create(getMonthDay(l5.longValue(), Locale.getDefault()), getYearMonthDay(l6.longValue(), Locale.getDefault()));
        }
    }

    static String getDateString(long j5, @Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j5));
        }
        if (isDateWithinCurrentYear(j5)) {
            return getMonthDay(j5);
        }
        return getYearMonthDay(j5);
    }

    static String getMonthDay(long j5, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j5));
        }
        return UtcDates.getMediumNoYear(locale).format(new Date(j5));
    }

    static String getMonthDayOfWeekDay(long j5, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getMonthWeekdayDayFormat(locale).format(new Date(j5));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j5));
    }

    static String getYearMonthDay(long j5, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j5));
        }
        return UtcDates.getMediumFormat(locale).format(new Date(j5));
    }

    static String getYearMonthDayOfWeekDay(long j5, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearMonthWeekdayDayFormat(locale).format(new Date(j5));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j5));
    }
}
