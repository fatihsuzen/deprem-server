package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

class MaxInputValidator implements InputFilter {
    private int max;

    public MaxInputValidator(int i5) {
        this.max = i5;
    }

    public CharSequence filter(CharSequence charSequence, int i5, int i6, Spanned spanned, int i7, int i8) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i7, i8, charSequence.subSequence(i5, i6).toString());
            if (Integer.parseInt(sb.toString()) <= this.max) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i5) {
        this.max = i5;
    }
}
