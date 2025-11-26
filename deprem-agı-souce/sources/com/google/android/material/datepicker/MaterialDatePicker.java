package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.Insets;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialDatePicker<S> extends DialogFragment {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    static final Object CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
    static final Object CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    private static final String DAY_VIEW_DECORATOR_KEY = "DAY_VIEW_DECORATOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    private static final String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    private static final String NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY = "NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY";
    private static final String NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY = "NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY";
    private static final String NEGATIVE_BUTTON_TEXT_KEY = "NEGATIVE_BUTTON_TEXT_KEY";
    private static final String NEGATIVE_BUTTON_TEXT_RES_ID_KEY = "NEGATIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    private static final String POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY = "POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY";
    private static final String POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY = "POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY";
    private static final String POSITIVE_BUTTON_TEXT_KEY = "POSITIVE_BUTTON_TEXT_KEY";
    private static final String POSITIVE_BUTTON_TEXT_RES_ID_KEY = "POSITIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
    private static final String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";
    static final Object TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    @Nullable
    private MaterialShapeDrawable background;
    private MaterialCalendar<S> calendar;
    @Nullable
    private CalendarConstraints calendarConstraints;
    /* access modifiers changed from: private */
    public Button confirmButton;
    @Nullable
    private DateSelector<S> dateSelector;
    @Nullable
    private DayViewDecorator dayViewDecorator;
    private boolean edgeToEdgeEnabled;
    @Nullable
    private CharSequence fullTitleText;
    private boolean fullscreen;
    private TextView headerSelectionText;
    private TextView headerTitleTextView;
    private CheckableImageButton headerToggleButton;
    private int inputMode;
    private CharSequence negativeButtonContentDescription;
    @StringRes
    private int negativeButtonContentDescriptionResId;
    private CharSequence negativeButtonText;
    @StringRes
    private int negativeButtonTextResId;
    private final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners = new LinkedHashSet<>();
    private final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners = new LinkedHashSet<>();
    private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners = new LinkedHashSet<>();
    @StyleRes
    private int overrideThemeResId;
    private PickerFragment<S> pickerFragment;
    private CharSequence positiveButtonContentDescription;
    @StringRes
    private int positiveButtonContentDescriptionResId;
    private CharSequence positiveButtonText;
    @StringRes
    private int positiveButtonTextResId;
    @Nullable
    private CharSequence singleLineTitleText;
    private CharSequence titleText;
    @StringRes
    private int titleTextResId;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputMode {
    }

    @NonNull
    private static Drawable createHeaderToggleDrawable(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, AppCompatResources.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private void enableEdgeToEdgeIfNeeded(Window window) {
        if (!this.edgeToEdgeEnabled) {
            final View findViewById = requireView().findViewById(R.id.fullscreen_header);
            EdgeToEdgeUtils.applyEdgeToEdge(window, true, ViewUtils.getBackgroundColor(findViewById), (Integer) null);
            final int paddingTop = findViewById.getPaddingTop();
            final int paddingLeft = findViewById.getPaddingLeft();
            final int paddingRight = findViewById.getPaddingRight();
            final int i5 = findViewById.getLayoutParams().height;
            ViewCompat.setOnApplyWindowInsetsListener(findViewById, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                    if (i5 >= 0) {
                        findViewById.getLayoutParams().height = i5 + insets.top;
                        View view2 = findViewById;
                        view2.setLayoutParams(view2.getLayoutParams());
                    }
                    View view3 = findViewById;
                    view3.setPadding(paddingLeft + insets.left, paddingTop + insets.top, paddingRight + insets.right, view3.getPaddingBottom());
                    return windowInsetsCompat;
                }
            });
            this.edgeToEdgeEnabled = true;
        }
    }

    public static /* synthetic */ void f(MaterialDatePicker materialDatePicker, View view) {
        materialDatePicker.confirmButton.setEnabled(materialDatePicker.getDateSelector().isSelectionComplete());
        materialDatePicker.headerToggleButton.toggle();
        int i5 = 1;
        if (materialDatePicker.inputMode == 1) {
            i5 = 0;
        }
        materialDatePicker.inputMode = i5;
        materialDatePicker.updateToggleContentDescription(materialDatePicker.headerToggleButton);
        materialDatePicker.startPickerFragment();
    }

    /* access modifiers changed from: private */
    public DateSelector<S> getDateSelector() {
        if (this.dateSelector == null) {
            this.dateSelector = (DateSelector) getArguments().getParcelable(DATE_SELECTOR_KEY);
        }
        return this.dateSelector;
    }

    @Nullable
    private static CharSequence getFirstLineBySeparator(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] split = TextUtils.split(String.valueOf(charSequence), "\n");
        if (split.length > 1) {
            return split[0];
        }
        return charSequence;
    }

    private String getHeaderContentDescription() {
        return getDateSelector().getSelectionContentDescription(requireContext());
    }

    private static int getPaddedPickerWidth(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i5 = Month.current().daysInWeek;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i5) + ((i5 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int getThemeResId(Context context) {
        int i5 = this.overrideThemeResId;
        if (i5 != 0) {
            return i5;
        }
        return getDateSelector().getDefaultThemeResId(context);
    }

    private void initHeaderToggle(Context context) {
        boolean z4;
        this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(context));
        CheckableImageButton checkableImageButton = this.headerToggleButton;
        if (this.inputMode != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        checkableImageButton.setChecked(z4);
        ViewCompat.setAccessibilityDelegate(this.headerToggleButton, (AccessibilityDelegateCompat) null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new g(this));
    }

    static boolean isFullscreen(@NonNull Context context) {
        return readMaterialCalendarStyleBoolean(context, 16843277);
    }

    private boolean isLandscape() {
        if (getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    static boolean isNestedScrollable(@NonNull Context context) {
        return readMaterialCalendarStyleBoolean(context, R.attr.nestedScrollable);
    }

    @NonNull
    static <S> MaterialDatePicker<S> newInstance(@NonNull Builder<S> builder) {
        MaterialDatePicker<S> materialDatePicker = new MaterialDatePicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt(OVERRIDE_THEME_RES_ID, builder.overrideThemeResId);
        bundle.putParcelable(DATE_SELECTOR_KEY, builder.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, builder.calendarConstraints);
        bundle.putParcelable(DAY_VIEW_DECORATOR_KEY, builder.dayViewDecorator);
        bundle.putInt(TITLE_TEXT_RES_ID_KEY, builder.titleTextResId);
        bundle.putCharSequence(TITLE_TEXT_KEY, builder.titleText);
        bundle.putInt(INPUT_MODE_KEY, builder.inputMode);
        bundle.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, builder.positiveButtonTextResId);
        bundle.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, builder.positiveButtonText);
        bundle.putInt(POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY, builder.positiveButtonContentDescriptionResId);
        bundle.putCharSequence(POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY, builder.positiveButtonContentDescription);
        bundle.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, builder.negativeButtonTextResId);
        bundle.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, builder.negativeButtonText);
        bundle.putInt(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY, builder.negativeButtonContentDescriptionResId);
        bundle.putCharSequence(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY, builder.negativeButtonContentDescription);
        materialDatePicker.setArguments(bundle);
        return materialDatePicker;
    }

    static boolean readMaterialCalendarStyleBoolean(@NonNull Context context, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i5});
        boolean z4 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z4;
    }

    private void startPickerFragment() {
        int themeResId = getThemeResId(requireContext());
        MaterialCalendar<S> newInstance = MaterialCalendar.newInstance(getDateSelector(), themeResId, this.calendarConstraints, this.dayViewDecorator);
        this.calendar = newInstance;
        PickerFragment pickerFragment2 = newInstance;
        if (this.inputMode == 1) {
            pickerFragment2 = MaterialTextInputPicker.newInstance(getDateSelector(), themeResId, this.calendarConstraints);
        }
        this.pickerFragment = pickerFragment2;
        updateTitle();
        updateHeader(getHeaderText());
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.mtrl_calendar_frame, this.pickerFragment);
        beginTransaction.commitNow();
        this.pickerFragment.addOnSelectionChangedListener(new OnSelectionChangedListener<S>() {
            public void onIncompleteSelectionChanged() {
                MaterialDatePicker.this.confirmButton.setEnabled(false);
            }

            public void onSelectionChanged(S s5) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.updateHeader(materialDatePicker.getHeaderText());
                MaterialDatePicker.this.confirmButton.setEnabled(MaterialDatePicker.this.getDateSelector().isSelectionComplete());
            }
        });
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.current().timeInMillis;
    }

    public static long todayInUtcMilliseconds() {
        return UtcDates.getTodayCalendar().getTimeInMillis();
    }

    private void updateTitle() {
        CharSequence charSequence;
        TextView textView = this.headerTitleTextView;
        if (this.inputMode != 1 || !isLandscape()) {
            charSequence = this.fullTitleText;
        } else {
            charSequence = this.singleLineTitleText;
        }
        textView.setText(charSequence);
    }

    private void updateToggleContentDescription(@NonNull CheckableImageButton checkableImageButton) {
        String str;
        if (this.inputMode == 1) {
            str = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            str = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.headerToggleButton.setContentDescription(str);
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.add(onCancelListener);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.onPositiveButtonClickListeners.add(materialPickerOnPositiveButtonClickListener);
    }

    public void clearOnCancelListeners() {
        this.onCancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.onDismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.onNegativeButtonClickListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.onPositiveButtonClickListeners.clear();
    }

    public String getHeaderText() {
        return getDateSelector().getSelectionDisplayString(getContext());
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @Nullable
    public final S getSelection() {
        return getDateSelector().getSelection();
    }

    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.onCancelListeners.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.overrideThemeResId = bundle.getInt(OVERRIDE_THEME_RES_ID);
        this.dateSelector = (DateSelector) bundle.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.dayViewDecorator = (DayViewDecorator) bundle.getParcelable(DAY_VIEW_DECORATOR_KEY);
        this.titleTextResId = bundle.getInt(TITLE_TEXT_RES_ID_KEY);
        this.titleText = bundle.getCharSequence(TITLE_TEXT_KEY);
        this.inputMode = bundle.getInt(INPUT_MODE_KEY);
        this.positiveButtonTextResId = bundle.getInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY);
        this.positiveButtonText = bundle.getCharSequence(POSITIVE_BUTTON_TEXT_KEY);
        this.positiveButtonContentDescriptionResId = bundle.getInt(POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY);
        this.positiveButtonContentDescription = bundle.getCharSequence(POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY);
        this.negativeButtonTextResId = bundle.getInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY);
        this.negativeButtonText = bundle.getCharSequence(NEGATIVE_BUTTON_TEXT_KEY);
        this.negativeButtonContentDescriptionResId = bundle.getInt(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY);
        this.negativeButtonContentDescription = bundle.getCharSequence(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY);
        CharSequence charSequence = this.titleText;
        if (charSequence == null) {
            charSequence = requireContext().getResources().getText(this.titleTextResId);
        }
        this.fullTitleText = charSequence;
        this.singleLineTitleText = getFirstLineBySeparator(charSequence);
    }

    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), getThemeResId(requireContext()));
        Context context = dialog.getContext();
        this.fullscreen = isFullscreen(context);
        int i5 = R.attr.materialCalendarStyle;
        int i6 = R.style.Widget_MaterialComponents_MaterialCalendar;
        this.background = new MaterialShapeDrawable(context, (AttributeSet) null, i5, i6);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.MaterialCalendar, i5, i6);
        int color = obtainStyledAttributes.getColor(R.styleable.MaterialCalendar_backgroundTint, 0);
        obtainStyledAttributes.recycle();
        this.background.initializeElevationOverlay(context);
        this.background.setFillColor(ColorStateList.valueOf(color));
        this.background.setElevation(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i5;
        if (this.fullscreen) {
            i5 = R.layout.mtrl_picker_fullscreen;
        } else {
            i5 = R.layout.mtrl_picker_dialog;
        }
        View inflate = layoutInflater.inflate(i5, viewGroup);
        Context context = inflate.getContext();
        DayViewDecorator dayViewDecorator2 = this.dayViewDecorator;
        if (dayViewDecorator2 != null) {
            dayViewDecorator2.initialize(context);
        }
        if (this.fullscreen) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -2));
        } else {
            inflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.headerSelectionText = textView;
        textView.setAccessibilityLiveRegion(1);
        this.headerToggleButton = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.headerTitleTextView = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        initHeaderToggle(context);
        this.confirmButton = (Button) inflate.findViewById(R.id.confirm_button);
        if (getDateSelector().isSelectionComplete()) {
            this.confirmButton.setEnabled(true);
        } else {
            this.confirmButton.setEnabled(false);
        }
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        CharSequence charSequence = this.positiveButtonText;
        if (charSequence != null) {
            this.confirmButton.setText(charSequence);
        } else {
            int i6 = this.positiveButtonTextResId;
            if (i6 != 0) {
                this.confirmButton.setText(i6);
            }
        }
        CharSequence charSequence2 = this.positiveButtonContentDescription;
        if (charSequence2 != null) {
            this.confirmButton.setContentDescription(charSequence2);
        } else if (this.positiveButtonContentDescriptionResId != 0) {
            this.confirmButton.setContentDescription(getContext().getResources().getText(this.positiveButtonContentDescriptionResId));
        }
        this.confirmButton.setOnClickListener(new h(this));
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag(CANCEL_BUTTON_TAG);
        CharSequence charSequence3 = this.negativeButtonText;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i7 = this.negativeButtonTextResId;
            if (i7 != 0) {
                button.setText(i7);
            }
        }
        CharSequence charSequence4 = this.negativeButtonContentDescription;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.negativeButtonContentDescriptionResId != 0) {
            button.setContentDescription(getContext().getResources().getText(this.negativeButtonContentDescriptionResId));
        }
        button.setOnClickListener(new i(this));
        return inflate;
    }

    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.onDismissListeners.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public void onNegativeButtonClick(@NonNull View view) {
        Iterator<View.OnClickListener> it = this.onNegativeButtonClickListeners.iterator();
        while (it.hasNext()) {
            it.next().onClick(view);
        }
        dismiss();
    }

    public void onPositiveButtonClick(@NonNull View view) {
        Iterator<MaterialPickerOnPositiveButtonClickListener<? super S>> it = this.onPositiveButtonClickListeners.iterator();
        while (it.hasNext()) {
            it.next().onPositiveButtonClick(getSelection());
        }
        dismiss();
    }

    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        Month month;
        super.onSaveInstanceState(bundle);
        bundle.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
        bundle.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.calendarConstraints);
        MaterialCalendar<S> materialCalendar = this.calendar;
        if (materialCalendar == null) {
            month = null;
        } else {
            month = materialCalendar.getCurrentMonth();
        }
        if (month != null) {
            builder.setOpenAt(month.timeInMillis);
        }
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, builder.build());
        bundle.putParcelable(DAY_VIEW_DECORATOR_KEY, this.dayViewDecorator);
        bundle.putInt(TITLE_TEXT_RES_ID_KEY, this.titleTextResId);
        bundle.putCharSequence(TITLE_TEXT_KEY, this.titleText);
        bundle.putInt(INPUT_MODE_KEY, this.inputMode);
        bundle.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, this.positiveButtonTextResId);
        bundle.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, this.positiveButtonText);
        bundle.putInt(POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY, this.positiveButtonContentDescriptionResId);
        bundle.putCharSequence(POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY, this.positiveButtonContentDescription);
        bundle.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, this.negativeButtonTextResId);
        bundle.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, this.negativeButtonText);
        bundle.putInt(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY, this.negativeButtonContentDescriptionResId);
        bundle.putCharSequence(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY, this.negativeButtonContentDescription);
    }

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.fullscreen) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.background);
            enableEdgeToEdgeIfNeeded(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable(this.background, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        startPickerFragment();
    }

    public void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.onPositiveButtonClickListeners.remove(materialPickerOnPositiveButtonClickListener);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void updateHeader(String str) {
        this.headerSelectionText.setContentDescription(getHeaderContentDescription());
        this.headerSelectionText.setText(str);
    }

    public static final class Builder<S> {
        CalendarConstraints calendarConstraints;
        final DateSelector<S> dateSelector;
        @Nullable
        DayViewDecorator dayViewDecorator;
        int inputMode = 0;
        CharSequence negativeButtonContentDescription = null;
        int negativeButtonContentDescriptionResId = 0;
        CharSequence negativeButtonText = null;
        int negativeButtonTextResId = 0;
        int overrideThemeResId = 0;
        CharSequence positiveButtonContentDescription = null;
        int positiveButtonContentDescriptionResId = 0;
        CharSequence positiveButtonText = null;
        int positiveButtonTextResId = 0;
        @Nullable
        S selection = null;
        CharSequence titleText = null;
        int titleTextResId = 0;

        private Builder(DateSelector<S> dateSelector2) {
            this.dateSelector = dateSelector2;
        }

        private Month createDefaultOpenAt() {
            if (!this.dateSelector.getSelectedDays().isEmpty()) {
                Month create = Month.create(this.dateSelector.getSelectedDays().iterator().next().longValue());
                if (monthInValidRange(create, this.calendarConstraints)) {
                    return create;
                }
            }
            Month current = Month.current();
            if (monthInValidRange(current, this.calendarConstraints)) {
                return current;
            }
            return this.calendarConstraints.getStart();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> Builder<S> customDatePicker(@NonNull DateSelector<S> dateSelector2) {
            return new Builder<>(dateSelector2);
        }

        @NonNull
        public static Builder<Long> datePicker() {
            return new Builder<>(new SingleDateSelector());
        }

        @NonNull
        public static Builder<Pair<Long, Long>> dateRangePicker() {
            return new Builder<>(new RangeDateSelector());
        }

        private static boolean monthInValidRange(Month month, CalendarConstraints calendarConstraints2) {
            if (month.compareTo(calendarConstraints2.getStart()) < 0 || month.compareTo(calendarConstraints2.getEnd()) > 0) {
                return false;
            }
            return true;
        }

        @NonNull
        public MaterialDatePicker<S> build() {
            if (this.calendarConstraints == null) {
                this.calendarConstraints = new CalendarConstraints.Builder().build();
            }
            if (this.titleTextResId == 0) {
                this.titleTextResId = this.dateSelector.getDefaultTitleResId();
            }
            S s5 = this.selection;
            if (s5 != null) {
                this.dateSelector.setSelection(s5);
            }
            if (this.calendarConstraints.getOpenAt() == null) {
                this.calendarConstraints.setOpenAt(createDefaultOpenAt());
            }
            return MaterialDatePicker.newInstance(this);
        }

        @NonNull
        public Builder<S> setCalendarConstraints(CalendarConstraints calendarConstraints2) {
            this.calendarConstraints = calendarConstraints2;
            return this;
        }

        @NonNull
        public Builder<S> setDayViewDecorator(@Nullable DayViewDecorator dayViewDecorator2) {
            this.dayViewDecorator = dayViewDecorator2;
            return this;
        }

        @NonNull
        public Builder<S> setInputMode(int i5) {
            this.inputMode = i5;
            return this;
        }

        @NonNull
        public Builder<S> setNegativeButtonContentDescription(@StringRes int i5) {
            this.negativeButtonContentDescriptionResId = i5;
            this.negativeButtonContentDescription = null;
            return this;
        }

        @NonNull
        public Builder<S> setNegativeButtonText(@StringRes int i5) {
            this.negativeButtonTextResId = i5;
            this.negativeButtonText = null;
            return this;
        }

        @NonNull
        public Builder<S> setPositiveButtonContentDescription(@StringRes int i5) {
            this.positiveButtonContentDescriptionResId = i5;
            this.positiveButtonContentDescription = null;
            return this;
        }

        @NonNull
        public Builder<S> setPositiveButtonText(@StringRes int i5) {
            this.positiveButtonTextResId = i5;
            this.positiveButtonText = null;
            return this;
        }

        @NonNull
        public Builder<S> setSelection(S s5) {
            this.selection = s5;
            return this;
        }

        @NonNull
        public Builder<S> setTextInputFormat(@Nullable SimpleDateFormat simpleDateFormat) {
            this.dateSelector.setTextInputFormat(simpleDateFormat);
            return this;
        }

        @NonNull
        public Builder<S> setTheme(@StyleRes int i5) {
            this.overrideThemeResId = i5;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@StringRes int i5) {
            this.titleTextResId = i5;
            this.titleText = null;
            return this;
        }

        @NonNull
        public Builder<S> setNegativeButtonContentDescription(@Nullable CharSequence charSequence) {
            this.negativeButtonContentDescription = charSequence;
            this.negativeButtonContentDescriptionResId = 0;
            return this;
        }

        @NonNull
        public Builder<S> setNegativeButtonText(@Nullable CharSequence charSequence) {
            this.negativeButtonText = charSequence;
            this.negativeButtonTextResId = 0;
            return this;
        }

        @NonNull
        public Builder<S> setPositiveButtonContentDescription(@Nullable CharSequence charSequence) {
            this.positiveButtonContentDescription = charSequence;
            this.positiveButtonContentDescriptionResId = 0;
            return this;
        }

        @NonNull
        public Builder<S> setPositiveButtonText(@Nullable CharSequence charSequence) {
            this.positiveButtonText = charSequence;
            this.positiveButtonTextResId = 0;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@Nullable CharSequence charSequence) {
            this.titleText = charSequence;
            this.titleTextResId = 0;
            return this;
        }
    }
}
