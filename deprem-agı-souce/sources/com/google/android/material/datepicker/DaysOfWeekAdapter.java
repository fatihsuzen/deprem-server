package com.google.android.material.datepicker;

import android.os.Build;
import android.widget.BaseAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Calendar;

class DaysOfWeekAdapter extends BaseAdapter {
    private static final int CALENDAR_DAY_STYLE;
    private static final int NARROW_FORMAT = 4;
    @NonNull
    private final Calendar calendar;
    private final int daysInWeek;
    private final int firstDayOfWeek;

    static {
        int i5;
        if (Build.VERSION.SDK_INT >= 26) {
            i5 = 4;
        } else {
            i5 = 1;
        }
        CALENDAR_DAY_STYLE = i5;
    }

    public DaysOfWeekAdapter() {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        this.calendar = utcCalendar;
        this.daysInWeek = utcCalendar.getMaximum(7);
        this.firstDayOfWeek = utcCalendar.getFirstDayOfWeek();
    }

    private int positionToDayOfWeek(int i5) {
        int i6 = i5 + this.firstDayOfWeek;
        int i7 = this.daysInWeek;
        if (i6 > i7) {
            return i6 - i7;
        }
        return i6;
    }

    public int getCount() {
        return this.daysInWeek;
    }

    public long getItemId(int i5) {
        return 0;
    }

    /* JADX WARNING: type inference failed for: r6v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"WrongConstant"})
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r5, @androidx.annotation.Nullable android.view.View r6, @androidx.annotation.NonNull android.view.ViewGroup r7) {
        /*
            r4 = this;
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r6 != 0) goto L_0x0017
            android.content.Context r6 = r7.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day_of_week
            android.view.View r6 = r6.inflate(r0, r7, r1)
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0017:
            java.util.Calendar r6 = r4.calendar
            int r5 = r4.positionToDayOfWeek(r5)
            r2 = 7
            r6.set(r2, r5)
            android.content.res.Resources r5 = r0.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            java.util.Locale r5 = r5.locale
            java.util.Calendar r6 = r4.calendar
            int r3 = CALENDAR_DAY_STYLE
            java.lang.String r5 = r6.getDisplayName(r2, r3, r5)
            r0.setText(r5)
            android.content.Context r5 = r7.getContext()
            int r6 = com.google.android.material.R.string.mtrl_picker_day_of_week_column_header
            java.lang.String r5 = r5.getString(r6)
            java.util.Calendar r6 = r4.calendar
            r7 = 2
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r6 = r6.getDisplayName(r2, r7, r3)
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r1] = r6
            java.lang.String r5 = java.lang.String.format(r5, r7)
            r0.setContentDescription(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.DaysOfWeekAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Nullable
    public Integer getItem(int i5) {
        if (i5 >= this.daysInWeek) {
            return null;
        }
        return Integer.valueOf(positionToDayOfWeek(i5));
    }

    public DaysOfWeekAdapter(int i5) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        this.calendar = utcCalendar;
        this.daysInWeek = utcCalendar.getMaximum(7);
        this.firstDayOfWeek = i5;
    }
}
