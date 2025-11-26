package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.core.view.ViewCompat;
import androidx.leanback.R;
import androidx.leanback.widget.picker.PickerUtility;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TimePicker extends Picker {
    private static final int AM_INDEX = 0;
    private static final int HOURS_IN_HALF_DAY = 12;
    private static final int PM_INDEX = 1;
    static final String TAG = "TimePicker";
    PickerColumn mAmPmColumn;
    int mColAmPmIndex;
    int mColHourIndex;
    int mColMinuteIndex;
    private final PickerUtility.TimeConstant mConstant;
    private int mCurrentAmPmIndex;
    private int mCurrentHour;
    private int mCurrentMinute;
    PickerColumn mHourColumn;
    private boolean mIs24hFormat;
    PickerColumn mMinuteColumn;
    private String mTimePickerFormat;

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.timePickerStyle);
    }

    private String extractTimeFields() {
        boolean z4;
        String str;
        StringBuilder sb;
        String bestHourMinutePattern = getBestHourMinutePattern();
        boolean z5 = false;
        if (TextUtils.getLayoutDirectionFromLocale(this.mConstant.locale) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (bestHourMinutePattern.indexOf(97) < 0 || bestHourMinutePattern.indexOf("a") > bestHourMinutePattern.indexOf("m")) {
            z5 = true;
        }
        if (z4) {
            str = "mh";
        } else {
            str = "hm";
        }
        if (is24Hour()) {
            return str;
        }
        if (z5) {
            sb.append(str);
            sb.append("a");
        } else {
            sb = new StringBuilder();
            sb.append("a");
            sb.append(str);
        }
        return sb.toString();
    }

    private static boolean isAnyOf(char c5, char[] cArr) {
        for (char c6 : cArr) {
            if (c5 == c6) {
                return true;
            }
        }
        return false;
    }

    private void setAmPmValue() {
        if (!is24Hour()) {
            setColumnValue(this.mColAmPmIndex, this.mCurrentAmPmIndex, false);
        }
    }

    private void updateColumns() {
        String bestHourMinutePattern = getBestHourMinutePattern();
        if (!TextUtils.equals(bestHourMinutePattern, this.mTimePickerFormat)) {
            this.mTimePickerFormat = bestHourMinutePattern;
            String extractTimeFields = extractTimeFields();
            List<CharSequence> extractSeparators = extractSeparators();
            if (extractSeparators.size() == extractTimeFields.length() + 1) {
                setSeparators(extractSeparators);
                String upperCase = extractTimeFields.toUpperCase(this.mConstant.locale);
                this.mAmPmColumn = null;
                this.mMinuteColumn = null;
                this.mHourColumn = null;
                this.mColAmPmIndex = -1;
                this.mColMinuteIndex = -1;
                this.mColHourIndex = -1;
                ArrayList arrayList = new ArrayList(3);
                for (int i5 = 0; i5 < upperCase.length(); i5++) {
                    char charAt = upperCase.charAt(i5);
                    if (charAt == 'A') {
                        PickerColumn pickerColumn = new PickerColumn();
                        this.mAmPmColumn = pickerColumn;
                        arrayList.add(pickerColumn);
                        this.mAmPmColumn.setStaticLabels(this.mConstant.ampm);
                        this.mColAmPmIndex = i5;
                        updateMin(this.mAmPmColumn, 0);
                        updateMax(this.mAmPmColumn, 1);
                    } else if (charAt == 'H') {
                        PickerColumn pickerColumn2 = new PickerColumn();
                        this.mHourColumn = pickerColumn2;
                        arrayList.add(pickerColumn2);
                        this.mHourColumn.setStaticLabels(this.mConstant.hours24);
                        this.mColHourIndex = i5;
                    } else if (charAt == 'M') {
                        PickerColumn pickerColumn3 = new PickerColumn();
                        this.mMinuteColumn = pickerColumn3;
                        arrayList.add(pickerColumn3);
                        this.mMinuteColumn.setStaticLabels(this.mConstant.minutes);
                        this.mColMinuteIndex = i5;
                    } else {
                        throw new IllegalArgumentException("Invalid time picker format.");
                    }
                }
                setColumns(arrayList);
                return;
            }
            throw new IllegalStateException("Separators size: " + extractSeparators.size() + " must equal the size of timeFieldsPattern: " + extractTimeFields.length() + " + 1");
        }
    }

    private void updateColumnsRange() {
        int i5;
        updateMin(this.mHourColumn, this.mIs24hFormat ^ true ? 1 : 0);
        PickerColumn pickerColumn = this.mHourColumn;
        if (this.mIs24hFormat) {
            i5 = 23;
        } else {
            i5 = 12;
        }
        updateMax(pickerColumn, i5);
        updateMin(this.mMinuteColumn, 0);
        updateMax(this.mMinuteColumn, 59);
        PickerColumn pickerColumn2 = this.mAmPmColumn;
        if (pickerColumn2 != null) {
            updateMin(pickerColumn2, 0);
            updateMax(this.mAmPmColumn, 1);
        }
    }

    private static void updateMax(PickerColumn pickerColumn, int i5) {
        if (i5 != pickerColumn.getMaxValue()) {
            pickerColumn.setMaxValue(i5);
        }
    }

    private static void updateMin(PickerColumn pickerColumn, int i5) {
        if (i5 != pickerColumn.getMinValue()) {
            pickerColumn.setMinValue(i5);
        }
    }

    /* access modifiers changed from: package-private */
    public List<CharSequence> extractSeparators() {
        String bestHourMinutePattern = getBestHourMinutePattern();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'H', 'h', 'K', 'k', 'm', 'M', 'a'};
        boolean z4 = false;
        char c5 = 0;
        for (int i5 = 0; i5 < bestHourMinutePattern.length(); i5++) {
            char charAt = bestHourMinutePattern.charAt(i5);
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
    public String getBestHourMinutePattern() {
        String str;
        Locale locale = this.mConstant.locale;
        if (this.mIs24hFormat) {
            str = "Hma";
        } else {
            str = "hma";
        }
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(locale, str);
        if (TextUtils.isEmpty(bestDateTimePattern)) {
            return "h:mma";
        }
        return bestDateTimePattern;
    }

    public int getHour() {
        if (this.mIs24hFormat) {
            return this.mCurrentHour;
        }
        if (this.mCurrentAmPmIndex == 0) {
            return this.mCurrentHour % 12;
        }
        return (this.mCurrentHour % 12) + 12;
    }

    public int getMinute() {
        return this.mCurrentMinute;
    }

    public boolean is24Hour() {
        return this.mIs24hFormat;
    }

    public boolean isPm() {
        if (this.mCurrentAmPmIndex == 1) {
            return true;
        }
        return false;
    }

    public void onColumnValueChanged(int i5, int i6) {
        if (i5 == this.mColHourIndex) {
            this.mCurrentHour = i6;
        } else if (i5 == this.mColMinuteIndex) {
            this.mCurrentMinute = i6;
        } else if (i5 == this.mColAmPmIndex) {
            this.mCurrentAmPmIndex = i6;
        } else {
            throw new IllegalArgumentException("Invalid column index.");
        }
    }

    public void setHour(@IntRange(from = 0, to = 23) int i5) {
        if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException("hour: " + i5 + " is not in [0-23] range in");
        }
        this.mCurrentHour = i5;
        if (!is24Hour()) {
            int i6 = this.mCurrentHour;
            if (i6 >= 12) {
                this.mCurrentAmPmIndex = 1;
                if (i6 > 12) {
                    this.mCurrentHour = i6 - 12;
                }
            } else {
                this.mCurrentAmPmIndex = 0;
                if (i6 == 0) {
                    this.mCurrentHour = 12;
                }
            }
            setAmPmValue();
        }
        setColumnValue(this.mColHourIndex, this.mCurrentHour, false);
    }

    public void setIs24Hour(boolean z4) {
        if (this.mIs24hFormat != z4) {
            int hour = getHour();
            int minute = getMinute();
            this.mIs24hFormat = z4;
            updateColumns();
            updateColumnsRange();
            setHour(hour);
            setMinute(minute);
            setAmPmValue();
        }
    }

    public void setMinute(@IntRange(from = 0, to = 59) int i5) {
        if (i5 < 0 || i5 > 59) {
            throw new IllegalArgumentException("minute: " + i5 + " is not in [0-59] range.");
        }
        this.mCurrentMinute = i5;
        setColumnValue(this.mColMinuteIndex, i5, false);
    }

    @SuppressLint({"CustomViewStyleable"})
    public TimePicker(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        PickerUtility.TimeConstant timeConstantInstance = PickerUtility.getTimeConstantInstance(Locale.getDefault(), context.getResources());
        this.mConstant = timeConstantInstance;
        int[] iArr = R.styleable.lbTimePicker;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        Context context2 = context;
        ViewCompat.saveAttributeDataForStyleable(this, context2, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        try {
            this.mIs24hFormat = obtainStyledAttributes.getBoolean(R.styleable.lbTimePicker_is24HourFormat, DateFormat.is24HourFormat(context2));
            boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.lbTimePicker_useCurrentTime, true);
            obtainStyledAttributes.recycle();
            updateColumns();
            updateColumnsRange();
            if (z4) {
                Calendar calendarForLocale = PickerUtility.getCalendarForLocale((Calendar) null, timeConstantInstance.locale);
                setHour(calendarForLocale.get(11));
                setMinute(calendarForLocale.get(12));
                setAmPmValue();
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
