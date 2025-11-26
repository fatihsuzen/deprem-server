package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import androidx.leanback.widget.picker.PickerUtility;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DatePicker extends Picker {
    private static final int[] DATE_FIELDS = {5, 2, 1};
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final String LOG_TAG = "DatePicker";
    private int mColDayIndex;
    private int mColMonthIndex;
    private int mColYearIndex;
    private PickerUtility.DateConstant mConstant;
    private Calendar mCurrentDate;
    private final DateFormat mDateFormat;
    private String mDatePickerFormat;
    private PickerColumn mDayColumn;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private PickerColumn mMonthColumn;
    private Calendar mTempDate;
    private PickerColumn mYearColumn;

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }

    private static boolean isAnyOf(char c5, char[] cArr) {
        for (char c6 : cArr) {
            if (c5 == c6) {
                return true;
            }
        }
        return false;
    }

    private boolean isNewDate(int i5, int i6, int i7) {
        if (this.mCurrentDate.get(1) == i5 && this.mCurrentDate.get(2) == i7 && this.mCurrentDate.get(5) == i6) {
            return false;
        }
        return true;
    }

    private boolean parseDate(String str, Calendar calendar) {
        try {
            calendar.setTime(this.mDateFormat.parse(str));
            return true;
        } catch (ParseException unused) {
            Log.w(LOG_TAG, "Date: " + str + " not in format: " + DATE_FORMAT);
            return false;
        }
    }

    private void setDate(int i5, int i6, int i7) {
        setDate(i5, i6, i7, false);
    }

    private void updateCurrentLocale() {
        PickerUtility.DateConstant dateConstantInstance = PickerUtility.getDateConstantInstance(Locale.getDefault(), getContext().getResources());
        this.mConstant = dateConstantInstance;
        this.mTempDate = PickerUtility.getCalendarForLocale(this.mTempDate, dateConstantInstance.locale);
        this.mMinDate = PickerUtility.getCalendarForLocale(this.mMinDate, this.mConstant.locale);
        this.mMaxDate = PickerUtility.getCalendarForLocale(this.mMaxDate, this.mConstant.locale);
        this.mCurrentDate = PickerUtility.getCalendarForLocale(this.mCurrentDate, this.mConstant.locale);
        PickerColumn pickerColumn = this.mMonthColumn;
        if (pickerColumn != null) {
            pickerColumn.setStaticLabels(this.mConstant.months);
            setColumnAt(this.mColMonthIndex, this.mMonthColumn);
        }
    }

    private static boolean updateMax(PickerColumn pickerColumn, int i5) {
        if (i5 == pickerColumn.getMaxValue()) {
            return false;
        }
        pickerColumn.setMaxValue(i5);
        return true;
    }

    private static boolean updateMin(PickerColumn pickerColumn, int i5) {
        if (i5 == pickerColumn.getMinValue()) {
            return false;
        }
        pickerColumn.setMinValue(i5);
        return true;
    }

    private void updateSpinners(final boolean z4) {
        post(new Runnable() {
            public void run() {
                DatePicker.this.updateSpinnersImpl(z4);
            }
        });
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public List<CharSequence> extractSeparators() {
        String bestYearMonthDayPattern = getBestYearMonthDayPattern(this.mDatePickerFormat);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'Y', 'y', 'M', 'm', 'D', 'd'};
        boolean z4 = false;
        char c5 = 0;
        for (int i5 = 0; i5 < bestYearMonthDayPattern.length(); i5++) {
            char charAt = bestYearMonthDayPattern.charAt(i5);
            if (charAt != ' ') {
                if (charAt != '\'') {
                    if (z4) {
                        sb.append(charAt);
                    } else if (!isAnyOf(charAt, cArr)) {
                        sb.append(charAt);
                    } else if (charAt != c5) {
                        arrayList.add(sb.toString());
                        sb.setLength(0);
                    }
                    c5 = charAt;
                } else if (!z4) {
                    sb.setLength(0);
                    z4 = true;
                } else {
                    z4 = false;
                }
            }
        }
        arrayList.add(sb.toString());
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public String getBestYearMonthDayPattern(String str) {
        String bestDateTimePattern = android.text.format.DateFormat.getBestDateTimePattern(this.mConstant.locale, str);
        if (TextUtils.isEmpty(bestDateTimePattern)) {
            return DATE_FORMAT;
        }
        return bestDateTimePattern;
    }

    public long getDate() {
        return this.mCurrentDate.getTimeInMillis();
    }

    public String getDatePickerFormat() {
        return this.mDatePickerFormat;
    }

    public long getMaxDate() {
        return this.mMaxDate.getTimeInMillis();
    }

    public long getMinDate() {
        return this.mMinDate.getTimeInMillis();
    }

    public final void onColumnValueChanged(int i5, int i6) {
        this.mTempDate.setTimeInMillis(this.mCurrentDate.getTimeInMillis());
        int currentValue = getColumnAt(i5).getCurrentValue();
        if (i5 == this.mColDayIndex) {
            this.mTempDate.add(5, i6 - currentValue);
        } else if (i5 == this.mColMonthIndex) {
            this.mTempDate.add(2, i6 - currentValue);
        } else if (i5 == this.mColYearIndex) {
            this.mTempDate.add(1, i6 - currentValue);
        } else {
            throw new IllegalArgumentException();
        }
        setDate(this.mTempDate.get(1), this.mTempDate.get(2), this.mTempDate.get(5));
    }

    public void setDatePickerFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            str = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        if (!TextUtils.equals(this.mDatePickerFormat, str)) {
            this.mDatePickerFormat = str;
            List<CharSequence> extractSeparators = extractSeparators();
            if (extractSeparators.size() == str.length() + 1) {
                setSeparators(extractSeparators);
                this.mDayColumn = null;
                this.mMonthColumn = null;
                this.mYearColumn = null;
                this.mColMonthIndex = -1;
                this.mColDayIndex = -1;
                this.mColYearIndex = -1;
                String upperCase = str.toUpperCase(this.mConstant.locale);
                ArrayList arrayList = new ArrayList(3);
                for (int i5 = 0; i5 < upperCase.length(); i5++) {
                    char charAt = upperCase.charAt(i5);
                    if (charAt != 'D') {
                        if (charAt != 'M') {
                            if (charAt != 'Y') {
                                throw new IllegalArgumentException("datePicker format error");
                            } else if (this.mYearColumn == null) {
                                PickerColumn pickerColumn = new PickerColumn();
                                this.mYearColumn = pickerColumn;
                                arrayList.add(pickerColumn);
                                this.mColYearIndex = i5;
                                this.mYearColumn.setLabelFormat(TimeModel.NUMBER_FORMAT);
                            } else {
                                throw new IllegalArgumentException("datePicker format error");
                            }
                        } else if (this.mMonthColumn == null) {
                            PickerColumn pickerColumn2 = new PickerColumn();
                            this.mMonthColumn = pickerColumn2;
                            arrayList.add(pickerColumn2);
                            this.mMonthColumn.setStaticLabels(this.mConstant.months);
                            this.mColMonthIndex = i5;
                        } else {
                            throw new IllegalArgumentException("datePicker format error");
                        }
                    } else if (this.mDayColumn == null) {
                        PickerColumn pickerColumn3 = new PickerColumn();
                        this.mDayColumn = pickerColumn3;
                        arrayList.add(pickerColumn3);
                        this.mDayColumn.setLabelFormat(TimeModel.ZERO_LEADING_NUMBER_FORMAT);
                        this.mColDayIndex = i5;
                    } else {
                        throw new IllegalArgumentException("datePicker format error");
                    }
                }
                setColumns(arrayList);
                updateSpinners(false);
                return;
            }
            throw new IllegalStateException("Separators size: " + extractSeparators.size() + " must equal the size of datePickerFormat: " + str.length() + " + 1");
        }
    }

    public void setMaxDate(long j5) {
        this.mTempDate.setTimeInMillis(j5);
        if (this.mTempDate.get(1) != this.mMaxDate.get(1) || this.mTempDate.get(6) == this.mMaxDate.get(6)) {
            this.mMaxDate.setTimeInMillis(j5);
            if (this.mCurrentDate.after(this.mMaxDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
            }
            updateSpinners(false);
        }
    }

    public void setMinDate(long j5) {
        this.mTempDate.setTimeInMillis(j5);
        if (this.mTempDate.get(1) != this.mMinDate.get(1) || this.mTempDate.get(6) == this.mMinDate.get(6)) {
            this.mMinDate.setTimeInMillis(j5);
            if (this.mCurrentDate.before(this.mMinDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
            }
            updateSpinners(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateSpinnersImpl(boolean z4) {
        boolean z5;
        boolean updateMax;
        boolean z6;
        int[] iArr = {this.mColDayIndex, this.mColMonthIndex, this.mColYearIndex};
        boolean z7 = true;
        boolean z8 = true;
        for (int length = DATE_FIELDS.length - 1; length >= 0; length--) {
            int i5 = iArr[length];
            if (i5 >= 0) {
                int i6 = DATE_FIELDS[length];
                PickerColumn columnAt = getColumnAt(i5);
                if (z7) {
                    z5 = updateMin(columnAt, this.mMinDate.get(i6));
                } else {
                    z5 = updateMin(columnAt, this.mCurrentDate.getActualMinimum(i6));
                }
                if (z8) {
                    updateMax = updateMax(columnAt, this.mMaxDate.get(i6));
                } else {
                    updateMax = updateMax(columnAt, this.mCurrentDate.getActualMaximum(i6));
                }
                boolean z9 = z5 | updateMax;
                boolean z10 = false;
                if (this.mCurrentDate.get(i6) == this.mMinDate.get(i6)) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 &= z6;
                if (this.mCurrentDate.get(i6) == this.mMaxDate.get(i6)) {
                    z10 = true;
                }
                z8 &= z10;
                if (z9) {
                    setColumnAt(iArr[length], columnAt);
                }
                setColumnValue(iArr[length], this.mCurrentDate.get(i6), z4);
            }
        }
    }

    @SuppressLint({"CustomViewStyleable"})
    public DatePicker(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        updateCurrentLocale();
        int[] iArr = R.styleable.lbDatePicker;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        Context context2 = context;
        ViewCompat.saveAttributeDataForStyleable(this, context2, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        try {
            String string = obtainStyledAttributes.getString(R.styleable.lbDatePicker_android_minDate);
            String string2 = obtainStyledAttributes.getString(R.styleable.lbDatePicker_android_maxDate);
            String string3 = obtainStyledAttributes.getString(R.styleable.lbDatePicker_datePickerFormat);
            obtainStyledAttributes.recycle();
            this.mTempDate.clear();
            if (TextUtils.isEmpty(string)) {
                this.mTempDate.set(1900, 0, 1);
            } else if (!parseDate(string, this.mTempDate)) {
                this.mTempDate.set(1900, 0, 1);
            }
            this.mMinDate.setTimeInMillis(this.mTempDate.getTimeInMillis());
            this.mTempDate.clear();
            if (TextUtils.isEmpty(string2)) {
                this.mTempDate.set(2100, 0, 1);
            } else if (!parseDate(string2, this.mTempDate)) {
                this.mTempDate.set(2100, 0, 1);
            }
            this.mMaxDate.setTimeInMillis(this.mTempDate.getTimeInMillis());
            setDatePickerFormat(TextUtils.isEmpty(string3) ? new String(android.text.format.DateFormat.getDateFormatOrder(context2)) : string3);
        } catch (Throwable th) {
            Throwable th2 = th;
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public void setDate(long j5) {
        this.mTempDate.setTimeInMillis(j5);
        setDate(this.mTempDate.get(1), this.mTempDate.get(2), this.mTempDate.get(5), false);
    }

    public void setDate(int i5, int i6, int i7, boolean z4) {
        if (isNewDate(i5, i6, i7)) {
            this.mCurrentDate.set(i5, i6, i7);
            if (this.mCurrentDate.before(this.mMinDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
            } else if (this.mCurrentDate.after(this.mMaxDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
            }
            updateSpinners(z4);
        }
    }
}
