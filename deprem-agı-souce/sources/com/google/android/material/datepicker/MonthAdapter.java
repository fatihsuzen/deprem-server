package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import java.util.Collection;

class MonthAdapter extends BaseAdapter {
    private static final int MAXIMUM_GRID_CELLS = ((UtcDates.getUtcCalendar().getMaximum(5) + UtcDates.getUtcCalendar().getMaximum(7)) - 1);
    static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    private static final int NO_DAY_NUMBER = -1;
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;
    @Nullable
    final DayViewDecorator dayViewDecorator;
    final Month month;
    private Collection<Long> previouslySelectedDates;

    MonthAdapter(Month month2, DateSelector<?> dateSelector2, CalendarConstraints calendarConstraints2, @Nullable DayViewDecorator dayViewDecorator2) {
        this.month = month2;
        this.dateSelector = dateSelector2;
        this.calendarConstraints = calendarConstraints2;
        this.dayViewDecorator = dayViewDecorator2;
        this.previouslySelectedDates = dateSelector2.getSelectedDays();
    }

    private String getDayContentDescription(Context context, long j5) {
        return DateStrings.getDayContentDescription(context, j5, isToday(j5), isStartOfRange(j5), isEndOfRange(j5));
    }

    private void initializeStyles(Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
    }

    private boolean isSelected(long j5) {
        for (Long longValue : this.dateSelector.getSelectedDays()) {
            if (UtcDates.canonicalYearMonthDay(j5) == UtcDates.canonicalYearMonthDay(longValue.longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean isToday(long j5) {
        if (UtcDates.getTodayCalendar().getTimeInMillis() == j5) {
            return true;
        }
        return false;
    }

    private void updateSelectedState(@Nullable TextView textView, long j5, int i5) {
        boolean z4;
        CalendarItemStyle calendarItemStyle;
        if (textView != null) {
            Context context = textView.getContext();
            String dayContentDescription = getDayContentDescription(context, j5);
            textView.setContentDescription(dayContentDescription);
            boolean isValid = this.calendarConstraints.getDateValidator().isValid(j5);
            if (isValid) {
                textView.setEnabled(true);
                z4 = isSelected(j5);
                textView.setSelected(z4);
                if (z4) {
                    calendarItemStyle = this.calendarStyle.selectedDay;
                } else if (isToday(j5)) {
                    calendarItemStyle = this.calendarStyle.todayDay;
                } else {
                    calendarItemStyle = this.calendarStyle.day;
                }
            } else {
                z4 = false;
                textView.setEnabled(false);
                calendarItemStyle = this.calendarStyle.invalidDay;
            }
            boolean z5 = z4;
            DayViewDecorator dayViewDecorator2 = this.dayViewDecorator;
            if (dayViewDecorator2 == null || i5 == -1) {
                calendarItemStyle.styleItem(textView);
                return;
            }
            Month month2 = this.month;
            int i6 = month2.year;
            int i7 = month2.month;
            int i8 = i5;
            calendarItemStyle.styleItem(textView, dayViewDecorator2.getBackgroundColor(context, i6, i7, i8, isValid, z5), this.dayViewDecorator.getTextColor(context, i6, i7, i8, isValid, z5));
            textView.setCompoundDrawables(this.dayViewDecorator.getCompoundDrawableLeft(context, i6, i7, i8, isValid, z5), this.dayViewDecorator.getCompoundDrawableTop(context, i6, i7, i8, isValid, z5), this.dayViewDecorator.getCompoundDrawableRight(context, i6, i7, i8, isValid, z5), this.dayViewDecorator.getCompoundDrawableBottom(context, i6, i7, i8, isValid, z5));
            textView.setContentDescription(this.dayViewDecorator.getContentDescription(context, i6, i7, i8, isValid, z5, dayContentDescription));
        }
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView materialCalendarGridView, long j5) {
        if (Month.create(j5).equals(this.month)) {
            int dayOfMonth = this.month.getDayOfMonth(j5);
            updateSelectedState((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().dayToPosition(dayOfMonth) - materialCalendarGridView.getFirstVisiblePosition()), j5, dayOfMonth);
        }
    }

    /* access modifiers changed from: package-private */
    public int dayToPosition(int i5) {
        return firstPositionInMonth() + (i5 - 1);
    }

    /* access modifiers changed from: package-private */
    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth(this.calendarConstraints.getFirstDayOfWeek());
    }

    public int getCount() {
        return MAXIMUM_GRID_CELLS;
    }

    public long getItemId(int i5) {
        return (long) (i5 / this.month.daysInWeek);
    }

    public boolean hasStableIds() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isEndOfRange(long j5) {
        for (Pair<Long, Long> pair : this.dateSelector.getSelectedRanges()) {
            S s5 = pair.second;
            if (s5 != null && ((Long) s5).longValue() == j5) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isFirstInRow(int i5) {
        if (i5 % this.month.daysInWeek == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isLastInRow(int i5) {
        if ((i5 + 1) % this.month.daysInWeek == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isStartOfRange(long j5) {
        for (Pair<Long, Long> pair : this.dateSelector.getSelectedRanges()) {
            F f5 = pair.first;
            if (f5 != null && ((Long) f5).longValue() == j5) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int lastPositionInMonth() {
        return (firstPositionInMonth() + this.month.daysInMonth) - 1;
    }

    /* access modifiers changed from: package-private */
    public int positionToDay(int i5) {
        return (i5 - firstPositionInMonth()) + 1;
    }

    public void updateSelectedStates(MaterialCalendarGridView materialCalendarGridView) {
        for (Long longValue : this.previouslySelectedDates) {
            updateSelectedStateForDate(materialCalendarGridView, longValue.longValue());
        }
        DateSelector<?> dateSelector2 = this.dateSelector;
        if (dateSelector2 != null) {
            for (Long longValue2 : dateSelector2.getSelectedDays()) {
                updateSelectedStateForDate(materialCalendarGridView, longValue2.longValue());
            }
            this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean withinMonth(int i5) {
        if (i5 < firstPositionInMonth() || i5 > lastPositionInMonth()) {
            return false;
        }
        return true;
    }

    @Nullable
    public Long getItem(int i5) {
        if (i5 < firstPositionInMonth() || i5 > lastPositionInMonth()) {
            return null;
        }
        return Long.valueOf(this.month.getDay(positionToDay(i5)));
    }

    /* JADX WARNING: type inference failed for: r7v9, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0064  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.initializeStyles(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L_0x001e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x001e:
            int r7 = r5.firstPositionInMonth()
            int r7 = r6 - r7
            if (r7 < 0) goto L_0x0054
            com.google.android.material.datepicker.Month r8 = r5.month
            int r2 = r8.daysInMonth
            if (r7 < r2) goto L_0x002d
            goto L_0x0054
        L_0x002d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r4[r1] = r3
            java.lang.String r3 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r3, r4)
            r0.setText(r8)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L_0x005d
        L_0x0054:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
            r7 = -1
        L_0x005d:
            java.lang.Long r6 = r5.getItem((int) r6)
            if (r6 != 0) goto L_0x0064
            return r0
        L_0x0064:
            long r1 = r6.longValue()
            r5.updateSelectedState(r0, r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }
}
