package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;

class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {
    private final TimePickerTextInputKeyController controller;
    private final EditText hourEditText;
    private final ChipTextInputComboView hourTextInput;
    private final TextWatcher hourTextWatcher = new TextWatcherAdapter() {
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.time.setHour(0);
                    return;
                }
                TimePickerTextInputPresenter.this.time.setHour(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };
    private final EditText minuteEditText;
    private final ChipTextInputComboView minuteTextInput;
    private final TextWatcher minuteTextWatcher = new TextWatcherAdapter() {
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.time.setMinute(0);
                    return;
                }
                TimePickerTextInputPresenter.this.time.setMinute(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };
    /* access modifiers changed from: private */
    public final TimeModel time;
    private final LinearLayout timePickerView;
    private MaterialButtonToggleGroup toggle;

    public TimePickerTextInputPresenter(LinearLayout linearLayout, TimeModel timeModel) {
        this.timePickerView = linearLayout;
        this.time = timeModel;
        final Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.minuteTextInput = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.hourTextInput = chipTextInputComboView2;
        int i5 = R.id.material_label;
        TextView textView = (TextView) chipTextInputComboView.findViewById(i5);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(i5);
        int i6 = R.string.material_timepicker_minute;
        textView.setText(resources.getString(i6));
        textView.setImportantForAccessibility(2);
        int i7 = R.string.material_timepicker_hour;
        textView2.setText(resources.getString(i7));
        textView2.setImportantForAccessibility(2);
        int i8 = R.id.selection_type;
        chipTextInputComboView.setTag(i8, 12);
        chipTextInputComboView2.setTag(i8, 10);
        if (timeModel.format == 0) {
            setupPeriodToggle();
        }
        AnonymousClass3 r12 = new View.OnClickListener() {
            public void onClick(View view) {
                TimePickerTextInputPresenter.this.onSelectionChanged(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        };
        chipTextInputComboView2.setOnClickListener(r12);
        chipTextInputComboView.setOnClickListener(r12);
        chipTextInputComboView2.addInputFilter(timeModel.getHourInputValidator());
        chipTextInputComboView.addInputFilter(timeModel.getMinuteInputValidator());
        EditText editText = chipTextInputComboView2.getTextInput().getEditText();
        this.hourEditText = editText;
        editText.setAccessibilityDelegate(setTimeUnitAccessiblityLabel(linearLayout.getResources(), i7));
        EditText editText2 = chipTextInputComboView.getTextInput().getEditText();
        this.minuteEditText = editText2;
        editText2.setAccessibilityDelegate(setTimeUnitAccessiblityLabel(linearLayout.getResources(), i6));
        this.controller = new TimePickerTextInputKeyController(chipTextInputComboView2, chipTextInputComboView, timeModel);
        final TimeModel timeModel2 = timeModel;
        chipTextInputComboView2.setChipDelegate(new ClickActionDelegate(linearLayout.getContext(), R.string.material_hour_selection) {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setContentDescription(resources.getString(R.string.material_timepicker_hour) + " " + view.getResources().getString(timeModel2.getHourContentDescriptionResId(), new Object[]{String.valueOf(timeModel2.getHourForDisplay())}));
            }
        });
        chipTextInputComboView.setChipDelegate(new ClickActionDelegate(linearLayout.getContext(), R.string.material_minute_selection) {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setContentDescription(resources.getString(R.string.material_timepicker_minute) + " " + view.getResources().getString(R.string.material_minute_suffix, new Object[]{String.valueOf(timeModel2.minute)}));
            }
        });
        initialize();
    }

    public static /* synthetic */ void a(TimePickerTextInputPresenter timePickerTextInputPresenter, MaterialButtonToggleGroup materialButtonToggleGroup, int i5, boolean z4) {
        int i6;
        timePickerTextInputPresenter.getClass();
        if (z4) {
            if (i5 == R.id.material_clock_period_pm_button) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            timePickerTextInputPresenter.time.setPeriod(i6);
        }
    }

    private void addTextWatchers() {
        this.hourEditText.addTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.addTextChangedListener(this.minuteTextWatcher);
    }

    private void removeTextWatchers() {
        this.hourEditText.removeTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.removeTextChangedListener(this.minuteTextWatcher);
    }

    private void setTime(TimeModel timeModel) {
        removeTextWatchers();
        Locale locale = this.timePickerView.getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(timeModel.minute)});
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(timeModel.getHourForDisplay())});
        this.minuteTextInput.setText(format);
        this.hourTextInput.setText(format2);
        addTextWatchers();
        updateSelection();
    }

    private View.AccessibilityDelegate setTimeUnitAccessiblityLabel(final Resources resources, final int i5) {
        return new View.AccessibilityDelegate() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setText(resources.getString(i5));
            }
        };
    }

    private void setupPeriodToggle() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.timePickerView.findViewById(R.id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new e(this));
        this.toggle.setVisibility(0);
        updateSelection();
    }

    private void updateSelection() {
        int i5;
        MaterialButtonToggleGroup materialButtonToggleGroup = this.toggle;
        if (materialButtonToggleGroup != null) {
            if (this.time.period == 0) {
                i5 = R.id.material_clock_period_am_button;
            } else {
                i5 = R.id.material_clock_period_pm_button;
            }
            materialButtonToggleGroup.check(i5);
        }
    }

    public void clearCheck() {
        this.minuteTextInput.setChecked(false);
        this.hourTextInput.setChecked(false);
    }

    public void hide() {
        View focusedChild = this.timePickerView.getFocusedChild();
        if (focusedChild != null) {
            ViewUtils.hideKeyboard(focusedChild, false);
        }
        this.timePickerView.setVisibility(8);
    }

    public void initialize() {
        addTextWatchers();
        setTime(this.time);
        this.controller.bind();
    }

    public void invalidate() {
        setTime(this.time);
    }

    public void onSelectionChanged(int i5) {
        boolean z4;
        this.time.selection = i5;
        ChipTextInputComboView chipTextInputComboView = this.minuteTextInput;
        boolean z5 = false;
        if (i5 == 12) {
            z4 = true;
        } else {
            z4 = false;
        }
        chipTextInputComboView.setChecked(z4);
        ChipTextInputComboView chipTextInputComboView2 = this.hourTextInput;
        if (i5 == 10) {
            z5 = true;
        }
        chipTextInputComboView2.setChecked(z5);
        updateSelection();
    }

    public void resetChecked() {
        boolean z4;
        ChipTextInputComboView chipTextInputComboView = this.minuteTextInput;
        boolean z5 = false;
        if (this.time.selection == 12) {
            z4 = true;
        } else {
            z4 = false;
        }
        chipTextInputComboView.setChecked(z4);
        ChipTextInputComboView chipTextInputComboView2 = this.hourTextInput;
        if (this.time.selection == 10) {
            z5 = true;
        }
        chipTextInputComboView2.setChecked(z5);
    }

    public void show() {
        this.timePickerView.setVisibility(0);
        onSelectionChanged(this.time.selection);
    }
}
