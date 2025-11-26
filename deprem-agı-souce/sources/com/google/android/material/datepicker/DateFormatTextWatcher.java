package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    private final CalendarConstraints constraints;
    private final DateFormat dateFormat;
    private final String formatHint;
    private int lastLength = 0;
    private final String outOfRange;
    private final Runnable setErrorCallback;
    private Runnable setRangeErrorCallback;
    @NonNull
    private final TextInputLayout textInputLayout;

    DateFormatTextWatcher(String str, DateFormat dateFormat2, @NonNull TextInputLayout textInputLayout2, CalendarConstraints calendarConstraints) {
        this.formatHint = str;
        this.dateFormat = dateFormat2;
        this.textInputLayout = textInputLayout2;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout2.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.setErrorCallback = new a(this, str);
    }

    public static /* synthetic */ void a(DateFormatTextWatcher dateFormatTextWatcher, long j5) {
        dateFormatTextWatcher.getClass();
        String dateString = DateStrings.getDateString(j5);
        dateFormatTextWatcher.textInputLayout.setError(String.format(dateFormatTextWatcher.outOfRange, new Object[]{dateFormatTextWatcher.sanitizeDateString(dateString)}));
        dateFormatTextWatcher.onInvalidDate();
    }

    public static /* synthetic */ void b(DateFormatTextWatcher dateFormatTextWatcher, String str) {
        TextInputLayout textInputLayout2 = dateFormatTextWatcher.textInputLayout;
        DateFormat dateFormat2 = dateFormatTextWatcher.dateFormat;
        Context context = textInputLayout2.getContext();
        String string = context.getString(R.string.mtrl_picker_invalid_format);
        String format = String.format(context.getString(R.string.mtrl_picker_invalid_format_use), new Object[]{dateFormatTextWatcher.sanitizeDateString(str)});
        String format2 = String.format(context.getString(R.string.mtrl_picker_invalid_format_example), new Object[]{dateFormatTextWatcher.sanitizeDateString(dateFormat2.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis())))});
        textInputLayout2.setError(string + "\n" + format + "\n" + format2);
        dateFormatTextWatcher.onInvalidDate();
    }

    private Runnable createRangeErrorCallback(long j5) {
        return new b(this, j5);
    }

    private String sanitizeDateString(String str) {
        return str.replace(' ', 160);
    }

    public void afterTextChanged(@NonNull Editable editable) {
        if (!Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) && editable.length() != 0 && editable.length() < this.formatHint.length() && editable.length() >= this.lastLength) {
            char charAt = this.formatHint.charAt(editable.length());
            if (!Character.isLetterOrDigit(charAt)) {
                editable.append(charAt);
            }
        }
    }

    public void beforeTextChanged(@NonNull CharSequence charSequence, int i5, int i6, int i7) {
        this.lastLength = charSequence.length();
    }

    /* access modifiers changed from: package-private */
    public void onInvalidDate() {
    }

    public void onTextChanged(@NonNull CharSequence charSequence, int i5, int i6, int i7) {
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        this.textInputLayout.setError((CharSequence) null);
        onValidDate((Long) null);
        if (!TextUtils.isEmpty(charSequence) && charSequence.length() >= this.formatHint.length()) {
            try {
                Date parse = this.dateFormat.parse(charSequence.toString());
                this.textInputLayout.setError((CharSequence) null);
                long time = parse.getTime();
                if (!this.constraints.getDateValidator().isValid(time) || !this.constraints.isWithinBounds(time)) {
                    Runnable createRangeErrorCallback = createRangeErrorCallback(time);
                    this.setRangeErrorCallback = createRangeErrorCallback;
                    runValidation(this.textInputLayout, createRangeErrorCallback);
                    return;
                }
                onValidDate(Long.valueOf(parse.getTime()));
            } catch (ParseException unused) {
                runValidation(this.textInputLayout, this.setErrorCallback);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void onValidDate(@Nullable Long l5);

    public void runValidation(View view, Runnable runnable) {
        view.post(runnable);
    }
}
