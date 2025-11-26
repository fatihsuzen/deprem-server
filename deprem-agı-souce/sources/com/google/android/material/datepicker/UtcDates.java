package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

class UtcDates {
    static final String UTC = "UTC";
    static AtomicReference<TimeSource> timeSourceRef = new AtomicReference<>();

    private UtcDates() {
    }

    static long canonicalYearMonthDay(long j5) {
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.setTimeInMillis(j5);
        return getDayCopy(utcCalendar).getTimeInMillis();
    }

    private static int findCharactersInDateFormatPattern(@NonNull String str, @NonNull String str2, int i5, int i6) {
        while (i6 >= 0 && i6 < str.length() && str2.indexOf(str.charAt(i6)) == -1) {
            if (str.charAt(i6) == '\'') {
                do {
                    i6 += i5;
                    if (i6 < 0) {
                        break;
                    } else if (i6 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i6) == '\'');
            }
            i6 += i5;
        }
        return i6;
    }

    @TargetApi(24)
    static DateFormat getAbbrMonthDayFormat(Locale locale) {
        return getAndroidFormat("MMMd", locale);
    }

    @TargetApi(24)
    private static DateFormat getAndroidFormat(String str, Locale locale) {
        DateFormat a5 = DateFormat.getInstanceForSkeleton(str, locale);
        a5.setTimeZone(getUtcAndroidTimeZone());
        a5.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return a5;
    }

    @NonNull
    static String getDatePatternAsInputFormat(@NonNull String str) {
        return str.replaceAll("[^dMy/\\-.]", "").replaceAll("d{1,2}", "dd").replaceAll("M{1,2}", "MM").replaceAll("y{1,4}", "yyyy").replaceAll("\\.$", "").replaceAll("My", "M/y");
    }

    static Calendar getDayCopy(Calendar calendar) {
        Calendar utcCalendarOf = getUtcCalendarOf(calendar);
        Calendar utcCalendar = getUtcCalendar();
        utcCalendar.set(utcCalendarOf.get(1), utcCalendarOf.get(2), utcCalendarOf.get(5));
        return utcCalendar;
    }

    static SimpleDateFormat getDefaultTextInputFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getDatePatternAsInputFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern()), Locale.getDefault());
        simpleDateFormat.setTimeZone(getTimeZone());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    static String getDefaultTextInputHint(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R.string.mtrl_picker_text_input_year_abbr);
        String string2 = resources.getString(R.string.mtrl_picker_text_input_month_abbr);
        String string3 = resources.getString(R.string.mtrl_picker_text_input_day_abbr);
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage())) {
            pattern = pattern.replaceAll("d+", "d").replaceAll("M+", "M").replaceAll("y+", "y");
        }
        return pattern.replace("d", string3).replace("M", string2).replace("y", string);
    }

    private static java.text.DateFormat getFormat(int i5, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i5, locale);
        dateInstance.setTimeZone(getTimeZone());
        return dateInstance;
    }

    static java.text.DateFormat getFullFormat() {
        return getFullFormat(Locale.getDefault());
    }

    static java.text.DateFormat getMediumFormat() {
        return getMediumFormat(Locale.getDefault());
    }

    static java.text.DateFormat getMediumNoYear() {
        return getMediumNoYear(Locale.getDefault());
    }

    @TargetApi(24)
    static DateFormat getMonthWeekdayDayFormat(Locale locale) {
        return getAndroidFormat("MMMMEEEEd", locale);
    }

    static java.text.DateFormat getNormalizedFormat(@NonNull java.text.DateFormat dateFormat) {
        java.text.DateFormat dateFormat2 = (java.text.DateFormat) dateFormat.clone();
        dateFormat2.setTimeZone(getTimeZone());
        return dateFormat2;
    }

    static SimpleDateFormat getSimpleFormat(String str) {
        return getSimpleFormat(str, Locale.getDefault());
    }

    static TimeSource getTimeSource() {
        TimeSource timeSource = timeSourceRef.get();
        if (timeSource == null) {
            return TimeSource.system();
        }
        return timeSource;
    }

    private static TimeZone getTimeZone() {
        return DesugarTimeZone.getTimeZone(UTC);
    }

    static Calendar getTodayCalendar() {
        Calendar now = getTimeSource().now();
        now.set(11, 0);
        now.set(12, 0);
        now.set(13, 0);
        now.set(14, 0);
        now.setTimeZone(getTimeZone());
        return now;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone getUtcAndroidTimeZone() {
        return android.icu.util.TimeZone.getTimeZone(UTC);
    }

    static Calendar getUtcCalendar() {
        return getUtcCalendarOf((Calendar) null);
    }

    static Calendar getUtcCalendarOf(@Nullable Calendar calendar) {
        Calendar instance = Calendar.getInstance(getTimeZone());
        if (calendar == null) {
            instance.clear();
            return instance;
        }
        instance.setTimeInMillis(calendar.getTimeInMillis());
        return instance;
    }

    @TargetApi(24)
    static DateFormat getYearAbbrMonthDayFormat(Locale locale) {
        return getAndroidFormat("yMMMd", locale);
    }

    @TargetApi(24)
    static DateFormat getYearMonthFormat(Locale locale) {
        return getAndroidFormat("yMMMM", locale);
    }

    @TargetApi(24)
    static DateFormat getYearMonthWeekdayDayFormat(Locale locale) {
        return getAndroidFormat("yMMMMEEEEd", locale);
    }

    @NonNull
    private static String removeYearFromDateFormatPattern(@NonNull String str) {
        int findCharactersInDateFormatPattern = findCharactersInDateFormatPattern(str, "yY", 1, 0);
        if (findCharactersInDateFormatPattern >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int findCharactersInDateFormatPattern2 = findCharactersInDateFormatPattern(str, str2, 1, findCharactersInDateFormatPattern);
        if (findCharactersInDateFormatPattern2 < str.length()) {
            str2 = str2 + ",";
        }
        return str.replace(str.substring(findCharactersInDateFormatPattern(str, str2, -1, findCharactersInDateFormatPattern) + 1, findCharactersInDateFormatPattern2), " ").trim();
    }

    static void setTimeSource(@Nullable TimeSource timeSource) {
        timeSourceRef.set(timeSource);
    }

    static java.text.DateFormat getFullFormat(Locale locale) {
        return getFormat(0, locale);
    }

    static java.text.DateFormat getMediumFormat(Locale locale) {
        return getFormat(2, locale);
    }

    static java.text.DateFormat getMediumNoYear(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) getMediumFormat(locale);
        simpleDateFormat.applyPattern(removeYearFromDateFormatPattern(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    private static SimpleDateFormat getSimpleFormat(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(getTimeZone());
        return simpleDateFormat;
    }
}
