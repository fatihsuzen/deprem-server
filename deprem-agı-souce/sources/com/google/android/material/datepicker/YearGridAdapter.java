package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Locale;

class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    public final MaterialCalendar<?> materialCalendar;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        ViewHolder(TextView textView2) {
            super(textView2);
            this.textView = textView2;
        }
    }

    YearGridAdapter(MaterialCalendar<?> materialCalendar2) {
        this.materialCalendar = materialCalendar2;
    }

    @NonNull
    private View.OnClickListener createYearClickListener(final int i5) {
        return new View.OnClickListener() {
            public void onClick(View view) {
                YearGridAdapter.this.materialCalendar.setCurrentMonth(YearGridAdapter.this.materialCalendar.getCalendarConstraints().clamp(Month.create(i5, YearGridAdapter.this.materialCalendar.getCurrentMonth().month)));
                YearGridAdapter.this.materialCalendar.setSelector(MaterialCalendar.CalendarSelector.DAY);
                YearGridAdapter.this.materialCalendar.sendAccessibilityFocusEventToMonthDropdown();
            }
        };
    }

    public int getItemCount() {
        return this.materialCalendar.getCalendarConstraints().getYearSpan();
    }

    /* access modifiers changed from: package-private */
    public int getPositionForYear(int i5) {
        return i5 - this.materialCalendar.getCalendarConstraints().getStart().year;
    }

    /* access modifiers changed from: package-private */
    public int getYearForPosition(int i5) {
        return this.materialCalendar.getCalendarConstraints().getStart().year + i5;
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i5) {
        int yearForPosition = getYearForPosition(i5);
        boolean z4 = true;
        viewHolder.textView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(yearForPosition)}));
        TextView textView = viewHolder.textView;
        textView.setContentDescription(DateStrings.getYearContentDescription(textView.getContext(), yearForPosition));
        CalendarStyle calendarStyle = this.materialCalendar.getCalendarStyle();
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        CalendarItemStyle calendarItemStyle = todayCalendar.get(1) == yearForPosition ? calendarStyle.todayYear : calendarStyle.year;
        for (Long longValue : this.materialCalendar.getDateSelector().getSelectedDays()) {
            todayCalendar.setTimeInMillis(longValue.longValue());
            if (todayCalendar.get(1) == yearForPosition) {
                calendarItemStyle = calendarStyle.selectedYear;
            }
        }
        calendarItemStyle.styleItem(viewHolder.textView);
        TextView textView2 = viewHolder.textView;
        if (calendarItemStyle != calendarStyle.selectedYear) {
            z4 = false;
        }
        textView2.setSelected(z4);
        viewHolder.textView.setOnClickListener(createYearClickListener(yearForPosition));
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i5) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
