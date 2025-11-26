package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;

final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;

    public MaterialCalendarGridView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void gainFocus(int i5, Rect rect) {
        if (i5 == 33) {
            setSelection(getAdapter().lastPositionInMonth());
        } else if (i5 == 130) {
            setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.onFocusChanged(true, i5, rect);
        }
    }

    private View getChildAtPosition(int i5) {
        return getChildAt(i5 - getFirstVisiblePosition());
    }

    private static int horizontalMidPoint(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean skipMonth(@Nullable Long l5, @Nullable Long l6, @Nullable Long l7, @Nullable Long l8) {
        if (l5 == null || l6 == null || l7 == null || l8 == null || l7.longValue() > l6.longValue() || l8.longValue() < l5.longValue()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(@NonNull Canvas canvas) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = materialCalendarGridView.getAdapter();
        DateSelector<?> dateSelector = adapter.dateSelector;
        CalendarStyle calendarStyle = adapter.calendarStyle;
        int max = Math.max(adapter.firstPositionInMonth(), materialCalendarGridView.getFirstVisiblePosition());
        int min = Math.min(adapter.lastPositionInMonth(), materialCalendarGridView.getLastVisiblePosition());
        Long item = adapter.getItem(max);
        Long item2 = adapter.getItem(min);
        for (Pair next : dateSelector.getSelectedRanges()) {
            F f5 = next.first;
            if (f5 == null) {
                materialCalendarGridView = this;
            } else if (next.second != null) {
                Long l5 = (Long) f5;
                long longValue = l5.longValue();
                Long l6 = (Long) next.second;
                long longValue2 = l6.longValue();
                if (!skipMonth(item, item2, l5, l6)) {
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(materialCalendarGridView);
                    if (longValue < item.longValue()) {
                        if (adapter.isFirstInRow(max)) {
                            i14 = 0;
                        } else if (!isLayoutRtl) {
                            i14 = materialCalendarGridView.getChildAtPosition(max - 1).getRight();
                        } else {
                            i14 = materialCalendarGridView.getChildAtPosition(max - 1).getLeft();
                        }
                        i5 = i14;
                        i6 = max;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue);
                        i6 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        i5 = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(i6));
                    }
                    if (longValue2 > item2.longValue()) {
                        if (adapter.isLastInRow(min)) {
                            i13 = materialCalendarGridView.getWidth();
                        } else if (!isLayoutRtl) {
                            i13 = materialCalendarGridView.getChildAtPosition(min).getRight();
                        } else {
                            i13 = materialCalendarGridView.getChildAtPosition(min).getLeft();
                        }
                        i7 = i13;
                        i8 = min;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue2);
                        i8 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        i7 = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(i8));
                    }
                    int itemId = (int) adapter.getItemId(i6);
                    int i15 = max;
                    int i16 = min;
                    int itemId2 = (int) adapter.getItemId(i8);
                    while (itemId <= itemId2) {
                        int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                        int numColumns2 = (numColumns + materialCalendarGridView.getNumColumns()) - 1;
                        View childAtPosition = materialCalendarGridView.getChildAtPosition(numColumns);
                        int top = childAtPosition.getTop() + calendarStyle.day.getTopInset();
                        MonthAdapter monthAdapter = adapter;
                        int bottom = childAtPosition.getBottom() - calendarStyle.day.getBottomInset();
                        if (!isLayoutRtl) {
                            if (numColumns > i6) {
                                i10 = 0;
                            } else {
                                i10 = i5;
                            }
                            if (i8 > numColumns2) {
                                i9 = getWidth();
                            } else {
                                i9 = i7;
                            }
                        } else {
                            if (i8 > numColumns2) {
                                i11 = 0;
                            } else {
                                i11 = i7;
                            }
                            if (numColumns > i6) {
                                i12 = getWidth();
                            } else {
                                i12 = i5;
                            }
                            int i17 = i11;
                            i9 = i12;
                            i10 = i17;
                        }
                        canvas.drawRect((float) i10, (float) top, (float) i9, (float) bottom, calendarStyle.rangeFill);
                        itemId++;
                        materialCalendarGridView = this;
                        adapter = monthAdapter;
                    }
                    materialCalendarGridView = this;
                    max = i15;
                    min = i16;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z4, int i5, Rect rect) {
        if (z4) {
            gainFocus(i5, rect);
        } else {
            super.onFocusChanged(false, i5, rect);
        }
    }

    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        if (!super.onKeyDown(i5, keyEvent)) {
            return false;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1 || (selectedItemPosition >= getAdapter().firstPositionInMonth() && selectedItemPosition <= getAdapter().lastPositionInMonth())) {
            return true;
        }
        if (19 != i5) {
            return false;
        }
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    }

    public void onMeasure(int i5, int i6) {
        if (this.nestedScrollable) {
            super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i5, i6);
    }

    public void setSelection(int i5) {
        if (i5 < getAdapter().firstPositionInMonth()) {
            super.setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.setSelection(i5);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof MonthAdapter) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionInfo((Object) null);
            }
        });
    }

    @NonNull
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }
}
