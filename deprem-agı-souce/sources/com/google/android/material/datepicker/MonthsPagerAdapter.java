package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;

class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NonNull
    private final CalendarConstraints calendarConstraints;
    private final DateSelector<?> dateSelector;
    @Nullable
    private final DayViewDecorator dayViewDecorator;
    private final int itemHeight;
    /* access modifiers changed from: private */
    public final MaterialCalendar.OnDayClickListener onDayClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        ViewHolder(@NonNull LinearLayout linearLayout, boolean z4) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.monthTitle = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z4) {
                textView.setVisibility(8);
            }
        }
    }

    MonthsPagerAdapter(@NonNull Context context, DateSelector<?> dateSelector2, @NonNull CalendarConstraints calendarConstraints2, @Nullable DayViewDecorator dayViewDecorator2, MaterialCalendar.OnDayClickListener onDayClickListener2) {
        int i5;
        Month start = calendarConstraints2.getStart();
        Month end = calendarConstraints2.getEnd();
        Month openAt = calendarConstraints2.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (openAt.compareTo(end) <= 0) {
            int dayHeight = MonthAdapter.MAXIMUM_WEEKS * MaterialCalendar.getDayHeight(context);
            if (MaterialDatePicker.isFullscreen(context)) {
                i5 = MaterialCalendar.getDayHeight(context);
            } else {
                i5 = 0;
            }
            this.itemHeight = dayHeight + i5;
            this.calendarConstraints = calendarConstraints2;
            this.dateSelector = dateSelector2;
            this.dayViewDecorator = dayViewDecorator2;
            this.onDayClickListener = onDayClickListener2;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    public long getItemId(int i5) {
        return this.calendarConstraints.getStart().monthsLater(i5).getStableId();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Month getPageMonth(int i5) {
        return this.calendarConstraints.getStart().monthsLater(i5);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CharSequence getPageTitle(int i5) {
        return getPageMonth(i5).getLongName();
    }

    /* access modifiers changed from: package-private */
    public int getPosition(@NonNull Month month) {
        return this.calendarConstraints.getStart().monthsUntil(month);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i5) {
        Month monthsLater = this.calendarConstraints.getStart().monthsLater(i5);
        viewHolder.monthTitle.setText(monthsLater.getLongName());
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.monthGrid.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthsLater.equals(materialCalendarGridView.getAdapter().month)) {
            MonthAdapter monthAdapter = new MonthAdapter(monthsLater, this.dateSelector, this.calendarConstraints, this.dayViewDecorator);
            materialCalendarGridView.setNumColumns(monthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().updateSelectedStates(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                if (materialCalendarGridView.getAdapter().withinMonth(i5)) {
                    MonthsPagerAdapter.this.onDayClickListener.onDayClick(materialCalendarGridView.getAdapter().getItem(i5).longValue());
                }
            }
        });
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i5) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
        return new ViewHolder(linearLayout, true);
    }
}
