package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class DayViewDecorator implements Parcelable {
    @Nullable
    public ColorStateList getBackgroundColor(@NonNull Context context, int i5, int i6, int i7, boolean z4, boolean z5) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableBottom(@NonNull Context context, int i5, int i6, int i7, boolean z4, boolean z5) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableLeft(@NonNull Context context, int i5, int i6, int i7, boolean z4, boolean z5) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableRight(@NonNull Context context, int i5, int i6, int i7, boolean z4, boolean z5) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableTop(@NonNull Context context, int i5, int i6, int i7, boolean z4, boolean z5) {
        return null;
    }

    @Nullable
    public CharSequence getContentDescription(@NonNull Context context, int i5, int i6, int i7, boolean z4, boolean z5, @Nullable CharSequence charSequence) {
        return charSequence;
    }

    @Nullable
    public ColorStateList getTextColor(@NonNull Context context, int i5, int i6, int i7, boolean z4, boolean z5) {
        return null;
    }

    public void initialize(@NonNull Context context) {
    }
}
