package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new Parcelable.Creator<SingleDateSelector>() {
        @NonNull
        public SingleDateSelector createFromParcel(@NonNull Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            Long unused = singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @NonNull
        public SingleDateSelector[] newArray(int i5) {
            return new SingleDateSelector[i5];
        }
    };
    /* access modifiers changed from: private */
    @Nullable
    public CharSequence error;
    /* access modifiers changed from: private */
    @Nullable
    public Long selectedItem;
    @Nullable
    private SimpleDateFormat textInputFormat;

    /* access modifiers changed from: private */
    public void clearSelection() {
        this.selectedItem = null;
    }

    public int describeContents() {
        return 0;
    }

    public int getDefaultThemeResId(Context context) {
        return MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    @Nullable
    public String getError() {
        if (TextUtils.isEmpty(this.error)) {
            return null;
        }
        return this.error.toString();
    }

    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l5 = this.selectedItem;
        if (l5 != null) {
            arrayList.add(l5);
        }
        return arrayList;
    }

    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    @NonNull
    public String getSelectionContentDescription(@NonNull Context context) {
        String str;
        Resources resources = context.getResources();
        Long l5 = this.selectedItem;
        if (l5 == null) {
            str = resources.getString(R.string.mtrl_picker_announce_current_selection_none);
        } else {
            str = DateStrings.getYearMonthDay(l5.longValue());
        }
        return resources.getString(R.string.mtrl_picker_announce_current_selection, new Object[]{str});
    }

    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l5 = this.selectedItem;
        if (l5 == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        String yearMonthDay = DateStrings.getYearMonthDay(l5.longValue());
        return resources.getString(R.string.mtrl_picker_date_header_selected, new Object[]{yearMonthDay});
    }

    public boolean isSelectionComplete() {
        if (this.selectedItem != null) {
            return true;
        }
        return false;
    }

    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<Long> onSelectionChangedListener) {
        boolean z4;
        String defaultTextInputHint;
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        Integer colorOrNull = MaterialColors.getColorOrNull(inflate.getContext(), R.attr.colorOnSurfaceVariant);
        if (colorOrNull != null) {
            editText.setHintTextColor(colorOrNull.intValue());
        }
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormat = this.textInputFormat;
        if (simpleDateFormat != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            simpleDateFormat = UtcDates.getDefaultTextInputFormat();
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        if (z4) {
            defaultTextInputHint = simpleDateFormat2.toPattern();
        } else {
            defaultTextInputHint = UtcDates.getDefaultTextInputHint(inflate.getResources(), simpleDateFormat2);
        }
        String str = defaultTextInputHint;
        textInputLayout.setPlaceholderText(str);
        Long l5 = this.selectedItem;
        if (l5 != null) {
            editText.setText(simpleDateFormat2.format(l5));
        }
        final TextInputLayout textInputLayout2 = textInputLayout;
        final OnSelectionChangedListener<Long> onSelectionChangedListener2 = onSelectionChangedListener;
        editText.addTextChangedListener(new DateFormatTextWatcher(str, simpleDateFormat2, textInputLayout, calendarConstraints) {
            /* access modifiers changed from: package-private */
            public void onInvalidDate() {
                CharSequence unused = SingleDateSelector.this.error = textInputLayout2.getError();
                onSelectionChangedListener2.onIncompleteSelectionChanged();
            }

            /* access modifiers changed from: package-private */
            public void onValidDate(@Nullable Long l5) {
                if (l5 == null) {
                    SingleDateSelector.this.clearSelection();
                } else {
                    SingleDateSelector.this.select(l5.longValue());
                }
                CharSequence unused = SingleDateSelector.this.error = null;
                onSelectionChangedListener2.onSelectionChanged(SingleDateSelector.this.getSelection());
            }
        });
        if (!e.a(inflate.getContext())) {
            e.d(editText);
        }
        return inflate;
    }

    public void select(long j5) {
        this.selectedItem = Long.valueOf(j5);
    }

    public void setTextInputFormat(@Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            simpleDateFormat = (SimpleDateFormat) UtcDates.getNormalizedFormat(simpleDateFormat);
        }
        this.textInputFormat = simpleDateFormat;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i5) {
        parcel.writeValue(this.selectedItem);
    }

    @Nullable
    public Long getSelection() {
        return this.selectedItem;
    }

    public void setSelection(@Nullable Long l5) {
        this.selectedItem = l5 == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(l5.longValue()));
    }
}
