package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;

public abstract class TwoStatePreference extends Preference {
    protected boolean mChecked;
    private boolean mCheckedSet;
    private boolean mDisableDependentsState;
    private CharSequence mSummaryOff;
    private CharSequence mSummaryOn;

    public TwoStatePreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }

    public boolean getDisableDependentsState() {
        return this.mDisableDependentsState;
    }

    @Nullable
    public CharSequence getSummaryOff() {
        return this.mSummaryOff;
    }

    @Nullable
    public CharSequence getSummaryOn() {
        return this.mSummaryOn;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    /* access modifiers changed from: protected */
    public void onClick() {
        super.onClick();
        boolean z4 = !isChecked();
        if (callChangeListener(Boolean.valueOf(z4))) {
            setChecked(z4);
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object onGetDefaultValue(@NonNull TypedArray typedArray, int i5) {
        return Boolean.valueOf(typedArray.getBoolean(i5, false));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.mChecked);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.mChecked = isChecked();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        setChecked(getPersistedBoolean(((Boolean) obj).booleanValue()));
    }

    public void setChecked(boolean z4) {
        boolean z5;
        if (this.mChecked != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 || !this.mCheckedSet) {
            this.mChecked = z4;
            this.mCheckedSet = true;
            persistBoolean(z4);
            if (z5) {
                notifyDependencyChange(shouldDisableDependents());
                notifyChanged();
            }
        }
    }

    public void setDisableDependentsState(boolean z4) {
        this.mDisableDependentsState = z4;
    }

    public void setSummaryOff(@Nullable CharSequence charSequence) {
        this.mSummaryOff = charSequence;
        if (!isChecked()) {
            notifyChanged();
        }
    }

    public void setSummaryOn(@Nullable CharSequence charSequence) {
        this.mSummaryOn = charSequence;
        if (isChecked()) {
            notifyChanged();
        }
    }

    public boolean shouldDisableDependents() {
        boolean z4;
        if (this.mDisableDependentsState) {
            z4 = this.mChecked;
        } else if (!this.mChecked) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 || super.shouldDisableDependents()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void syncSummaryView(@NonNull PreferenceViewHolder preferenceViewHolder) {
        syncSummaryView(preferenceViewHolder.findViewById(16908304));
    }

    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }
        };
        boolean mChecked;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mChecked = parcel.readInt() != 1 ? false : true;
        }

        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.mChecked ? 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public TwoStatePreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void syncSummaryView(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L_0x0005
            goto L_0x004c
        L_0x0005:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.mChecked
            r1 = 0
            if (r0 == 0) goto L_0x001b
            java.lang.CharSequence r0 = r4.mSummaryOn
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001b
            java.lang.CharSequence r0 = r4.mSummaryOn
            r5.setText(r0)
        L_0x0019:
            r0 = r1
            goto L_0x002e
        L_0x001b:
            boolean r0 = r4.mChecked
            if (r0 != 0) goto L_0x002d
            java.lang.CharSequence r0 = r4.mSummaryOff
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x002d
            java.lang.CharSequence r0 = r4.mSummaryOff
            r5.setText(r0)
            goto L_0x0019
        L_0x002d:
            r0 = 1
        L_0x002e:
            if (r0 == 0) goto L_0x003e
            java.lang.CharSequence r2 = r4.getSummary()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x003e
            r5.setText(r2)
            r0 = r1
        L_0x003e:
            if (r0 != 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r1 = 8
        L_0x0043:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L_0x004c
            r5.setVisibility(r1)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.syncSummaryView(android.view.View):void");
    }

    public TwoStatePreference(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void setSummaryOff(int i5) {
        setSummaryOff((CharSequence) getContext().getString(i5));
    }

    public void setSummaryOn(int i5) {
        setSummaryOn((CharSequence) getContext().getString(i5));
    }
}
