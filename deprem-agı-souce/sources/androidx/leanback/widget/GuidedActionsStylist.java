package androidx.leanback.widget;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.leanback.R;
import androidx.leanback.transition.TransitionEpicenterCallback;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import androidx.leanback.widget.GuidedActionAdapter;
import androidx.leanback.widget.GuidedActionsRelativeLayout;
import androidx.leanback.widget.ItemAlignmentFacet;
import androidx.leanback.widget.picker.DatePicker;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class GuidedActionsStylist implements FragmentAnimationProvider {
    private static final String TAG = "GuidedActionsStylist";
    public static final int VIEW_TYPE_DATE_PICKER = 1;
    public static final int VIEW_TYPE_DEFAULT = 0;
    static final ItemAlignmentFacet sGuidedActionItemAlignFacet;
    private VerticalGridView mActionsGridView;
    private boolean mBackToCollapseActivatorView = true;
    private boolean mBackToCollapseSubActions = true;
    private boolean mButtonActions;
    private View mContentView;
    private int mDescriptionMinLines;
    private float mDisabledChevronAlpha;
    private float mDisabledDescriptionAlpha;
    private float mDisabledTextAlpha;
    private int mDisplayHeight;
    private GuidedActionAdapter.EditListener mEditListener;
    private float mEnabledChevronAlpha;
    private float mEnabledDescriptionAlpha;
    private float mEnabledTextAlpha;
    Object mExpandTransition;
    GuidedAction mExpandedAction = null;
    private float mKeyLinePercent;
    ViewGroup mMainView;
    private View mSubActionsBackground;
    VerticalGridView mSubActionsGridView;
    private int mTitleMaxLines;
    private int mTitleMinLines;
    private int mVerticalPadding;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        static void setAutofillHints(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void setImportantForAutofill(View view, int i5) {
            view.setImportantForAutofill(i5);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements FacetProvider {
        GuidedAction mAction;
        View mActivatorView;
        ImageView mCheckmarkView;
        ImageView mChevronView;
        private View mContentView;
        final View.AccessibilityDelegate mDelegate;
        TextView mDescriptionView;
        int mEditingMode;
        ImageView mIconView;
        private final boolean mIsSubAction;
        Animator mPressAnimator;
        TextView mTitleView;

        public ViewHolder(View view) {
            this(view, false);
        }

        public GuidedAction getAction() {
            return this.mAction;
        }

        public ImageView getCheckmarkView() {
            return this.mCheckmarkView;
        }

        public ImageView getChevronView() {
            return this.mChevronView;
        }

        public View getContentView() {
            return this.mContentView;
        }

        public TextView getDescriptionView() {
            return this.mDescriptionView;
        }

        public EditText getEditableDescriptionView() {
            TextView textView = this.mDescriptionView;
            if (textView instanceof EditText) {
                return (EditText) textView;
            }
            return null;
        }

        public EditText getEditableTitleView() {
            TextView textView = this.mTitleView;
            if (textView instanceof EditText) {
                return (EditText) textView;
            }
            return null;
        }

        public View getEditingView() {
            int i5 = this.mEditingMode;
            if (i5 == 1) {
                return this.mTitleView;
            }
            if (i5 == 2) {
                return this.mDescriptionView;
            }
            if (i5 != 3) {
                return null;
            }
            return this.mActivatorView;
        }

        public Object getFacet(Class<?> cls) {
            if (cls == ItemAlignmentFacet.class) {
                return GuidedActionsStylist.sGuidedActionItemAlignFacet;
            }
            return null;
        }

        public ImageView getIconView() {
            return this.mIconView;
        }

        public TextView getTitleView() {
            return this.mTitleView;
        }

        public boolean isInEditing() {
            if (this.mEditingMode != 0) {
                return true;
            }
            return false;
        }

        public boolean isInEditingActivatorView() {
            if (this.mEditingMode == 3) {
                return true;
            }
            return false;
        }

        public boolean isInEditingDescription() {
            if (this.mEditingMode == 2) {
                return true;
            }
            return false;
        }

        public boolean isInEditingText() {
            int i5 = this.mEditingMode;
            if (i5 == 1 || i5 == 2) {
                return true;
            }
            return false;
        }

        public boolean isInEditingTitle() {
            if (this.mEditingMode == 1) {
                return true;
            }
            return false;
        }

        public boolean isSubAction() {
            return this.mIsSubAction;
        }

        /* access modifiers changed from: package-private */
        public void press(boolean z4) {
            int i5;
            Animator animator = this.mPressAnimator;
            if (animator != null) {
                animator.cancel();
                this.mPressAnimator = null;
            }
            if (z4) {
                i5 = R.attr.guidedActionPressedAnimation;
            } else {
                i5 = R.attr.guidedActionUnpressedAnimation;
            }
            Context context = this.itemView.getContext();
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(i5, typedValue, true)) {
                Animator loadAnimator = AnimatorInflater.loadAnimator(context, typedValue.resourceId);
                this.mPressAnimator = loadAnimator;
                loadAnimator.setTarget(this.itemView);
                this.mPressAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        ViewHolder.this.mPressAnimator = null;
                    }
                });
                this.mPressAnimator.start();
            }
        }

        /* access modifiers changed from: package-private */
        public void setActivated(boolean z4) {
            this.mActivatorView.setActivated(z4);
            View view = this.itemView;
            if (view instanceof GuidedActionItemContainer) {
                ((GuidedActionItemContainer) view).setFocusOutAllowed(!z4);
            }
        }

        public ViewHolder(View view, boolean z4) {
            super(view);
            this.mEditingMode = 0;
            AnonymousClass1 r02 = new View.AccessibilityDelegate() {
                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    boolean z4;
                    super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                    GuidedAction guidedAction = ViewHolder.this.mAction;
                    if (guidedAction == null || !guidedAction.isChecked()) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    accessibilityEvent.setChecked(z4);
                }

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    boolean z4;
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    GuidedAction guidedAction = ViewHolder.this.mAction;
                    boolean z5 = false;
                    if (guidedAction == null || guidedAction.getCheckSetId() == 0) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    accessibilityNodeInfo.setCheckable(z4);
                    GuidedAction guidedAction2 = ViewHolder.this.mAction;
                    if (guidedAction2 != null && guidedAction2.isChecked()) {
                        z5 = true;
                    }
                    accessibilityNodeInfo.setChecked(z5);
                }
            };
            this.mDelegate = r02;
            this.mContentView = view.findViewById(R.id.guidedactions_item_content);
            this.mTitleView = (TextView) view.findViewById(R.id.guidedactions_item_title);
            this.mActivatorView = view.findViewById(R.id.guidedactions_activator_item);
            this.mDescriptionView = (TextView) view.findViewById(R.id.guidedactions_item_description);
            this.mIconView = (ImageView) view.findViewById(R.id.guidedactions_item_icon);
            this.mCheckmarkView = (ImageView) view.findViewById(R.id.guidedactions_item_checkmark);
            this.mChevronView = (ImageView) view.findViewById(R.id.guidedactions_item_chevron);
            this.mIsSubAction = z4;
            view.setAccessibilityDelegate(r02);
        }
    }

    static {
        ItemAlignmentFacet itemAlignmentFacet = new ItemAlignmentFacet();
        sGuidedActionItemAlignFacet = itemAlignmentFacet;
        ItemAlignmentFacet.ItemAlignmentDef itemAlignmentDef = new ItemAlignmentFacet.ItemAlignmentDef();
        itemAlignmentDef.setItemAlignmentViewId(R.id.guidedactions_item_title);
        itemAlignmentDef.setAlignedToTextViewBaseline(true);
        itemAlignmentDef.setItemAlignmentOffset(0);
        itemAlignmentDef.setItemAlignmentOffsetWithPadding(true);
        itemAlignmentDef.setItemAlignmentOffsetPercent(0.0f);
        itemAlignmentFacet.setAlignmentDefs(new ItemAlignmentFacet.ItemAlignmentDef[]{itemAlignmentDef});
    }

    private int getDescriptionMaxHeight(TextView textView) {
        return (this.mDisplayHeight - (this.mVerticalPadding * 2)) - ((this.mTitleMaxLines * 2) * textView.getLineHeight());
    }

    private static int getDimension(Context context, TypedValue typedValue, int i5) {
        context.getTheme().resolveAttribute(i5, typedValue, true);
        return context.getResources().getDimensionPixelSize(typedValue.resourceId);
    }

    private static float getFloat(Context context, TypedValue typedValue, int i5) {
        context.getTheme().resolveAttribute(i5, typedValue, true);
        return typedValue.getFloat();
    }

    private static float getFloatValue(Resources resources, TypedValue typedValue, int i5) {
        resources.getValue(i5, typedValue, true);
        return typedValue.getFloat();
    }

    private static int getInteger(Context context, TypedValue typedValue, int i5) {
        context.getTheme().resolveAttribute(i5, typedValue, true);
        return context.getResources().getInteger(typedValue.resourceId);
    }

    private boolean setIcon(ImageView imageView, GuidedAction guidedAction) {
        Drawable drawable;
        if (imageView != null) {
            drawable = guidedAction.getIcon();
            if (drawable != null) {
                imageView.setImageLevel(drawable.getLevel());
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        } else {
            drawable = null;
        }
        if (drawable != null) {
            return true;
        }
        return false;
    }

    private static void setMaxLines(TextView textView, int i5) {
        if (i5 == 1) {
            textView.setSingleLine(true);
            return;
        }
        textView.setSingleLine(false);
        textView.setMaxLines(i5);
    }

    private void setupNextImeOptions(EditText editText) {
        if (editText != null) {
            editText.setImeOptions(5);
        }
    }

    private void updateChevronAndVisibility(ViewHolder viewHolder) {
        if (!viewHolder.isSubAction()) {
            if (this.mExpandedAction == null) {
                viewHolder.itemView.setVisibility(0);
                viewHolder.itemView.setTranslationY(0.0f);
                if (viewHolder.mActivatorView != null) {
                    viewHolder.setActivated(false);
                }
            } else if (viewHolder.getAction() == this.mExpandedAction) {
                viewHolder.itemView.setVisibility(0);
                if (viewHolder.getAction().hasSubActions()) {
                    viewHolder.itemView.setTranslationY((float) (getKeyLine() - viewHolder.itemView.getBottom()));
                } else if (viewHolder.mActivatorView != null) {
                    viewHolder.itemView.setTranslationY(0.0f);
                    viewHolder.setActivated(true);
                }
            } else {
                viewHolder.itemView.setVisibility(4);
                viewHolder.itemView.setTranslationY(0.0f);
            }
        }
        if (viewHolder.mChevronView != null) {
            onBindChevronView(viewHolder, viewHolder.getAction());
        }
    }

    public void collapseAction(boolean z4) {
        boolean z5;
        if (!isInExpandTransition() && this.mExpandedAction != null) {
            if (!isExpandTransitionSupported() || !z4) {
                z5 = false;
            } else {
                z5 = true;
            }
            int indexOf = ((GuidedActionAdapter) getActionsGridView().getAdapter()).indexOf(this.mExpandedAction);
            if (indexOf >= 0) {
                if (this.mExpandedAction.hasEditableActivatorView()) {
                    setEditingMode((ViewHolder) getActionsGridView().findViewHolderForPosition(indexOf), false, z5);
                } else {
                    startExpanded((ViewHolder) null, z5);
                }
            }
        }
    }

    public void expandAction(GuidedAction guidedAction, boolean z4) {
        int indexOf;
        if (!isInExpandTransition() && this.mExpandedAction == null && (indexOf = ((GuidedActionAdapter) getActionsGridView().getAdapter()).indexOf(guidedAction)) >= 0) {
            if (!isExpandTransitionSupported() || !z4) {
                getActionsGridView().setSelectedPosition(indexOf, (ViewHolderTask) new ViewHolderTask() {
                    public void run(RecyclerView.ViewHolder viewHolder) {
                        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
                        if (viewHolder2.getAction().hasEditableActivatorView()) {
                            GuidedActionsStylist.this.setEditingMode(viewHolder2, true, false);
                        } else {
                            GuidedActionsStylist.this.onUpdateExpandedViewHolder(viewHolder2);
                        }
                    }
                });
                if (guidedAction.hasSubActions()) {
                    onUpdateSubActionsGridView(guidedAction, true);
                    return;
                }
                return;
            }
            getActionsGridView().setSelectedPosition(indexOf, (ViewHolderTask) new ViewHolderTask() {
                public void run(RecyclerView.ViewHolder viewHolder) {
                    ViewHolder viewHolder2 = (ViewHolder) viewHolder;
                    if (viewHolder2.getAction().hasEditableActivatorView()) {
                        GuidedActionsStylist.this.setEditingMode(viewHolder2, true, true);
                    } else {
                        GuidedActionsStylist.this.startExpanded(viewHolder2, true);
                    }
                }
            });
        }
    }

    public VerticalGridView getActionsGridView() {
        return this.mActionsGridView;
    }

    public GuidedAction getExpandedAction() {
        return this.mExpandedAction;
    }

    public int getItemViewType(GuidedAction guidedAction) {
        if (guidedAction instanceof GuidedDatePickerAction) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getKeyLine() {
        return (int) ((this.mKeyLinePercent * ((float) this.mActionsGridView.getHeight())) / 100.0f);
    }

    public VerticalGridView getSubActionsGridView() {
        return this.mSubActionsGridView;
    }

    public final boolean isBackKeyToCollapseActivatorView() {
        return this.mBackToCollapseActivatorView;
    }

    public final boolean isBackKeyToCollapseSubActions() {
        return this.mBackToCollapseSubActions;
    }

    public boolean isButtonActions() {
        return this.mButtonActions;
    }

    public boolean isExpandTransitionSupported() {
        return true;
    }

    public boolean isExpanded() {
        if (this.mExpandedAction != null) {
            return true;
        }
        return false;
    }

    public boolean isInExpandTransition() {
        if (this.mExpandTransition != null) {
            return true;
        }
        return false;
    }

    public boolean isSubActionsExpanded() {
        GuidedAction guidedAction = this.mExpandedAction;
        if (guidedAction == null || !guidedAction.hasSubActions()) {
            return false;
        }
        return true;
    }

    public void onAnimateItemChecked(ViewHolder viewHolder, boolean z4) {
        ImageView imageView = viewHolder.mCheckmarkView;
        if (imageView instanceof Checkable) {
            ((Checkable) imageView).setChecked(z4);
        }
    }

    public void onAnimateItemFocused(ViewHolder viewHolder, boolean z4) {
    }

    public void onAnimateItemPressed(ViewHolder viewHolder, boolean z4) {
        viewHolder.press(z4);
    }

    public void onAnimateItemPressedCancelled(ViewHolder viewHolder) {
        viewHolder.press(false);
    }

    public void onBindActivatorView(ViewHolder viewHolder, GuidedAction guidedAction) {
        if (guidedAction instanceof GuidedDatePickerAction) {
            GuidedDatePickerAction guidedDatePickerAction = (GuidedDatePickerAction) guidedAction;
            DatePicker datePicker = (DatePicker) viewHolder.mActivatorView;
            datePicker.setDatePickerFormat(guidedDatePickerAction.getDatePickerFormat());
            if (guidedDatePickerAction.getMinDate() != Long.MIN_VALUE) {
                datePicker.setMinDate(guidedDatePickerAction.getMinDate());
            }
            if (guidedDatePickerAction.getMaxDate() != Long.MAX_VALUE) {
                datePicker.setMaxDate(guidedDatePickerAction.getMaxDate());
            }
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(guidedDatePickerAction.getDate());
            datePicker.setDate(instance.get(1), instance.get(2), instance.get(5), false);
        }
    }

    public void onBindCheckMarkView(ViewHolder viewHolder, GuidedAction guidedAction) {
        int i5;
        Drawable drawable;
        if (guidedAction.getCheckSetId() != 0) {
            viewHolder.mCheckmarkView.setVisibility(0);
            if (guidedAction.getCheckSetId() == -1) {
                i5 = 16843290;
            } else {
                i5 = 16843289;
            }
            Context context = viewHolder.mCheckmarkView.getContext();
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(i5, typedValue, true)) {
                drawable = ContextCompat.getDrawable(context, typedValue.resourceId);
            } else {
                drawable = null;
            }
            viewHolder.mCheckmarkView.setImageDrawable(drawable);
            ImageView imageView = viewHolder.mCheckmarkView;
            if (imageView instanceof Checkable) {
                ((Checkable) imageView).setChecked(guidedAction.isChecked());
                return;
            }
            return;
        }
        viewHolder.mCheckmarkView.setVisibility(8);
    }

    public void onBindChevronView(ViewHolder viewHolder, GuidedAction guidedAction) {
        float f5;
        float f6;
        boolean hasNext = guidedAction.hasNext();
        boolean hasSubActions = guidedAction.hasSubActions();
        if (hasNext || hasSubActions) {
            viewHolder.mChevronView.setVisibility(0);
            ImageView imageView = viewHolder.mChevronView;
            if (guidedAction.isEnabled()) {
                f5 = this.mEnabledChevronAlpha;
            } else {
                f5 = this.mDisabledChevronAlpha;
            }
            imageView.setAlpha(f5);
            if (hasNext) {
                ViewGroup viewGroup = this.mMainView;
                if (viewGroup == null || viewGroup.getLayoutDirection() != 1) {
                    f6 = 0.0f;
                } else {
                    f6 = 180.0f;
                }
                viewHolder.mChevronView.setRotation(f6);
            } else if (guidedAction == this.mExpandedAction) {
                viewHolder.mChevronView.setRotation(270.0f);
            } else {
                viewHolder.mChevronView.setRotation(90.0f);
            }
        } else {
            viewHolder.mChevronView.setVisibility(8);
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, GuidedAction guidedAction) {
        int i5;
        float f5;
        float f6;
        viewHolder.mAction = guidedAction;
        TextView textView = viewHolder.mTitleView;
        if (textView != null) {
            textView.setInputType(guidedAction.getInputType());
            viewHolder.mTitleView.setText(guidedAction.getTitle());
            TextView textView2 = viewHolder.mTitleView;
            if (guidedAction.isEnabled()) {
                f6 = this.mEnabledTextAlpha;
            } else {
                f6 = this.mDisabledTextAlpha;
            }
            textView2.setAlpha(f6);
            viewHolder.mTitleView.setFocusable(false);
            viewHolder.mTitleView.setClickable(false);
            viewHolder.mTitleView.setLongClickable(false);
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 28) {
                if (guidedAction.isEditable()) {
                    Api26Impl.setAutofillHints(viewHolder.mTitleView, guidedAction.getAutofillHints());
                } else {
                    Api26Impl.setAutofillHints(viewHolder.mTitleView, (String[]) null);
                }
            } else if (i6 >= 26) {
                Api26Impl.setImportantForAutofill(viewHolder.mTitleView, 2);
            }
        }
        TextView textView3 = viewHolder.mDescriptionView;
        if (textView3 != null) {
            textView3.setInputType(guidedAction.getDescriptionInputType());
            viewHolder.mDescriptionView.setText(guidedAction.getDescription());
            TextView textView4 = viewHolder.mDescriptionView;
            if (TextUtils.isEmpty(guidedAction.getDescription())) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            textView4.setVisibility(i5);
            TextView textView5 = viewHolder.mDescriptionView;
            if (guidedAction.isEnabled()) {
                f5 = this.mEnabledDescriptionAlpha;
            } else {
                f5 = this.mDisabledDescriptionAlpha;
            }
            textView5.setAlpha(f5);
            viewHolder.mDescriptionView.setFocusable(false);
            viewHolder.mDescriptionView.setClickable(false);
            viewHolder.mDescriptionView.setLongClickable(false);
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 28) {
                if (guidedAction.isDescriptionEditable()) {
                    Api26Impl.setAutofillHints(viewHolder.mDescriptionView, guidedAction.getAutofillHints());
                } else {
                    Api26Impl.setAutofillHints(viewHolder.mDescriptionView, (String[]) null);
                }
            } else if (i7 >= 26) {
                Api26Impl.setImportantForAutofill(viewHolder.mTitleView, 2);
            }
        }
        if (viewHolder.mCheckmarkView != null) {
            onBindCheckMarkView(viewHolder, guidedAction);
        }
        setIcon(viewHolder.mIconView, guidedAction);
        if (guidedAction.hasMultilineDescription()) {
            TextView textView6 = viewHolder.mTitleView;
            if (textView6 != null) {
                setMaxLines(textView6, this.mTitleMaxLines);
                TextView textView7 = viewHolder.mTitleView;
                textView7.setInputType(textView7.getInputType() | 131072);
                TextView textView8 = viewHolder.mDescriptionView;
                if (textView8 != null) {
                    textView8.setInputType(textView8.getInputType() | 131072);
                    viewHolder.mDescriptionView.setMaxHeight(getDescriptionMaxHeight(viewHolder.mTitleView));
                }
            }
        } else {
            TextView textView9 = viewHolder.mTitleView;
            if (textView9 != null) {
                setMaxLines(textView9, this.mTitleMinLines);
            }
            TextView textView10 = viewHolder.mDescriptionView;
            if (textView10 != null) {
                setMaxLines(textView10, this.mDescriptionMinLines);
            }
        }
        if (viewHolder.mActivatorView != null) {
            onBindActivatorView(viewHolder, guidedAction);
        }
        setEditingMode(viewHolder, false, false);
        if (guidedAction.isFocusable()) {
            viewHolder.itemView.setFocusable(true);
            ((ViewGroup) viewHolder.itemView).setDescendantFocusability(131072);
        } else {
            viewHolder.itemView.setFocusable(false);
            ((ViewGroup) viewHolder.itemView).setDescendantFocusability(393216);
        }
        setupImeOptions(viewHolder, guidedAction);
        updateChevronAndVisibility(viewHolder);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i5;
        int i6;
        float f5 = layoutInflater.getContext().getTheme().obtainStyledAttributes(R.styleable.LeanbackGuidedStepTheme).getFloat(R.styleable.LeanbackGuidedStepTheme_guidedStepKeyline, 40.0f);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(onProvideLayoutId(), viewGroup, false);
        this.mMainView = viewGroup2;
        if (this.mButtonActions) {
            i5 = R.id.guidedactions_content2;
        } else {
            i5 = R.id.guidedactions_content;
        }
        this.mContentView = viewGroup2.findViewById(i5);
        ViewGroup viewGroup3 = this.mMainView;
        if (viewGroup3 instanceof VerticalGridView) {
            this.mActionsGridView = (VerticalGridView) viewGroup3;
        } else {
            if (this.mButtonActions) {
                i6 = R.id.guidedactions_list2;
            } else {
                i6 = R.id.guidedactions_list;
            }
            VerticalGridView verticalGridView = (VerticalGridView) viewGroup3.findViewById(i6);
            this.mActionsGridView = verticalGridView;
            if (verticalGridView != null) {
                verticalGridView.setWindowAlignmentOffsetPercent(f5);
                this.mActionsGridView.setWindowAlignment(0);
                if (!this.mButtonActions) {
                    this.mSubActionsGridView = (VerticalGridView) this.mMainView.findViewById(R.id.guidedactions_sub_list);
                    this.mSubActionsBackground = this.mMainView.findViewById(R.id.guidedactions_sub_list_background);
                }
            } else {
                throw new IllegalStateException("No ListView exists.");
            }
        }
        this.mActionsGridView.setFocusable(false);
        this.mActionsGridView.setFocusableInTouchMode(false);
        Context context = this.mMainView.getContext();
        TypedValue typedValue = new TypedValue();
        this.mEnabledChevronAlpha = getFloat(context, typedValue, R.attr.guidedActionEnabledChevronAlpha);
        this.mDisabledChevronAlpha = getFloat(context, typedValue, R.attr.guidedActionDisabledChevronAlpha);
        this.mTitleMinLines = getInteger(context, typedValue, R.attr.guidedActionTitleMinLines);
        this.mTitleMaxLines = getInteger(context, typedValue, R.attr.guidedActionTitleMaxLines);
        this.mDescriptionMinLines = getInteger(context, typedValue, R.attr.guidedActionDescriptionMinLines);
        this.mVerticalPadding = getDimension(context, typedValue, R.attr.guidedActionVerticalPadding);
        this.mDisplayHeight = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
        this.mEnabledTextAlpha = getFloatValue(context.getResources(), typedValue, R.dimen.lb_guidedactions_item_unselected_text_alpha);
        this.mDisabledTextAlpha = getFloatValue(context.getResources(), typedValue, R.dimen.lb_guidedactions_item_disabled_text_alpha);
        this.mEnabledDescriptionAlpha = getFloatValue(context.getResources(), typedValue, R.dimen.lb_guidedactions_item_unselected_description_text_alpha);
        this.mDisabledDescriptionAlpha = getFloatValue(context.getResources(), typedValue, R.dimen.lb_guidedactions_item_disabled_description_text_alpha);
        this.mKeyLinePercent = GuidanceStylingRelativeLayout.getKeyLinePercent(context);
        View view = this.mContentView;
        if (view instanceof GuidedActionsRelativeLayout) {
            ((GuidedActionsRelativeLayout) view).setInterceptKeyEventListener(new GuidedActionsRelativeLayout.InterceptKeyEventListener() {
                public boolean onInterceptKeyEvent(KeyEvent keyEvent) {
                    GuidedAction guidedAction;
                    if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1 || (guidedAction = GuidedActionsStylist.this.mExpandedAction) == null) {
                        return false;
                    }
                    if ((!guidedAction.hasSubActions() || !GuidedActionsStylist.this.isBackKeyToCollapseSubActions()) && (!GuidedActionsStylist.this.mExpandedAction.hasEditableActivatorView() || !GuidedActionsStylist.this.isBackKeyToCollapseActivatorView())) {
                        return false;
                    }
                    GuidedActionsStylist.this.collapseAction(true);
                    return true;
                }
            });
        }
        return this.mMainView;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        boolean z4 = false;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(onProvideItemLayoutId(), viewGroup, false);
        if (viewGroup == this.mSubActionsGridView) {
            z4 = true;
        }
        return new ViewHolder(inflate, z4);
    }

    public void onDestroyView() {
        this.mExpandedAction = null;
        this.mExpandTransition = null;
        this.mActionsGridView = null;
        this.mSubActionsGridView = null;
        this.mSubActionsBackground = null;
        this.mContentView = null;
        this.mMainView = null;
    }

    /* access modifiers changed from: package-private */
    public void onEditActivatorView(final ViewHolder viewHolder, boolean z4, boolean z5) {
        GuidedActionAdapter.EditListener editListener;
        if (z4) {
            startExpanded(viewHolder, z5);
            viewHolder.itemView.setFocusable(false);
            viewHolder.mActivatorView.requestFocus();
            viewHolder.mActivatorView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (!GuidedActionsStylist.this.isInExpandTransition()) {
                        ((GuidedActionAdapter) GuidedActionsStylist.this.getActionsGridView().getAdapter()).performOnActionClick(viewHolder);
                    }
                }
            });
            return;
        }
        if (onUpdateActivatorView(viewHolder, viewHolder.getAction()) && (editListener = this.mEditListener) != null) {
            editListener.onGuidedActionEditedAndProceed(viewHolder.getAction());
        }
        viewHolder.itemView.setFocusable(true);
        viewHolder.itemView.requestFocus();
        startExpanded((ViewHolder) null, z5);
        viewHolder.mActivatorView.setOnClickListener((View.OnClickListener) null);
        viewHolder.mActivatorView.setClickable(false);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onEditingModeChange(ViewHolder viewHolder, GuidedAction guidedAction, boolean z4) {
    }

    public void onImeAppearing(List<Animator> list) {
    }

    public void onImeDisappearing(List<Animator> list) {
    }

    public int onProvideItemLayoutId() {
        return R.layout.lb_guidedactions_item;
    }

    public int onProvideLayoutId() {
        if (this.mButtonActions) {
            return R.layout.lb_guidedbuttonactions;
        }
        return R.layout.lb_guidedactions;
    }

    public boolean onUpdateActivatorView(ViewHolder viewHolder, GuidedAction guidedAction) {
        if (!(guidedAction instanceof GuidedDatePickerAction)) {
            return false;
        }
        GuidedDatePickerAction guidedDatePickerAction = (GuidedDatePickerAction) guidedAction;
        DatePicker datePicker = (DatePicker) viewHolder.mActivatorView;
        if (guidedDatePickerAction.getDate() == datePicker.getDate()) {
            return false;
        }
        guidedDatePickerAction.setDate(datePicker.getDate());
        return true;
    }

    public void onUpdateExpandedViewHolder(ViewHolder viewHolder) {
        if (viewHolder == null) {
            this.mExpandedAction = null;
            this.mActionsGridView.setPruneChild(true);
        } else if (viewHolder.getAction() != this.mExpandedAction) {
            this.mExpandedAction = viewHolder.getAction();
            this.mActionsGridView.setPruneChild(false);
        }
        this.mActionsGridView.setAnimateChildLayout(false);
        int childCount = this.mActionsGridView.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            VerticalGridView verticalGridView = this.mActionsGridView;
            updateChevronAndVisibility((ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i5)));
        }
    }

    /* access modifiers changed from: package-private */
    public void onUpdateSubActionsGridView(GuidedAction guidedAction, boolean z4) {
        VerticalGridView verticalGridView = this.mSubActionsGridView;
        if (verticalGridView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) verticalGridView.getLayoutParams();
            GuidedActionAdapter guidedActionAdapter = (GuidedActionAdapter) this.mSubActionsGridView.getAdapter();
            if (z4) {
                marginLayoutParams.topMargin = -2;
                marginLayoutParams.height = -1;
                this.mSubActionsGridView.setLayoutParams(marginLayoutParams);
                this.mSubActionsGridView.setVisibility(0);
                this.mSubActionsBackground.setVisibility(0);
                this.mSubActionsGridView.requestFocus();
                guidedActionAdapter.setActions(guidedAction.getSubActions());
                return;
            }
            marginLayoutParams.topMargin = this.mActionsGridView.getLayoutManager().findViewByPosition(((GuidedActionAdapter) this.mActionsGridView.getAdapter()).indexOf(guidedAction)).getBottom();
            marginLayoutParams.height = 0;
            this.mSubActionsGridView.setVisibility(4);
            this.mSubActionsBackground.setVisibility(4);
            this.mSubActionsGridView.setLayoutParams(marginLayoutParams);
            guidedActionAdapter.setActions(Collections.EMPTY_LIST);
            this.mActionsGridView.requestFocus();
        }
    }

    public void openInEditMode(GuidedAction guidedAction) {
        final GuidedActionAdapter guidedActionAdapter = (GuidedActionAdapter) getActionsGridView().getAdapter();
        int indexOf = guidedActionAdapter.getActions().indexOf(guidedAction);
        if (indexOf >= 0 && guidedAction.isEditable()) {
            getActionsGridView().setSelectedPosition(indexOf, (ViewHolderTask) new ViewHolderTask() {
                public void run(RecyclerView.ViewHolder viewHolder) {
                    GuidedActionAdapter guidedActionAdapter = guidedActionAdapter;
                    guidedActionAdapter.mGroup.openIme(guidedActionAdapter, (ViewHolder) viewHolder);
                }
            });
        }
    }

    public void setAsButtonActions() {
        if (this.mMainView == null) {
            this.mButtonActions = true;
            return;
        }
        throw new IllegalStateException("setAsButtonActions() must be called before creating views");
    }

    public final void setBackKeyToCollapseActivatorView(boolean z4) {
        this.mBackToCollapseActivatorView = z4;
    }

    public final void setBackKeyToCollapseSubActions(boolean z4) {
        this.mBackToCollapseSubActions = z4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setEditListener(GuidedActionAdapter.EditListener editListener) {
        this.mEditListener = editListener;
    }

    @Deprecated
    public void setEditingMode(ViewHolder viewHolder, GuidedAction guidedAction, boolean z4) {
        if (z4 != viewHolder.isInEditing() && isInExpandTransition()) {
            onEditingModeChange(viewHolder, guidedAction, z4);
        }
    }

    @Deprecated
    public void setExpandedViewHolder(ViewHolder viewHolder) {
        GuidedAction guidedAction;
        if (viewHolder == null) {
            guidedAction = null;
        } else {
            guidedAction = viewHolder.getAction();
        }
        expandAction(guidedAction, isExpandTransitionSupported());
    }

    /* access modifiers changed from: protected */
    public void setupImeOptions(ViewHolder viewHolder, GuidedAction guidedAction) {
        setupNextImeOptions(viewHolder.getEditableTitleView());
        setupNextImeOptions(viewHolder.getEditableDescriptionView());
    }

    /* access modifiers changed from: package-private */
    public void startExpanded(ViewHolder viewHolder, boolean z4) {
        ViewHolder viewHolder2;
        boolean z5;
        float f5;
        ViewHolder viewHolder3 = viewHolder;
        int childCount = this.mActionsGridView.getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                viewHolder2 = null;
                break;
            }
            VerticalGridView verticalGridView = this.mActionsGridView;
            viewHolder2 = (ViewHolder) verticalGridView.getChildViewHolder(verticalGridView.getChildAt(i5));
            if ((viewHolder3 == null && viewHolder2.itemView.getVisibility() == 0) || (viewHolder3 != null && viewHolder2.getAction() == viewHolder3.getAction())) {
                break;
            }
            i5++;
        }
        if (viewHolder2 != null) {
            if (viewHolder3 != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean hasSubActions = viewHolder2.getAction().hasSubActions();
            if (z4) {
                Object createTransitionSet = TransitionHelper.createTransitionSet(false);
                if (hasSubActions) {
                    f5 = (float) viewHolder2.itemView.getHeight();
                } else {
                    f5 = ((float) viewHolder2.itemView.getHeight()) * 0.5f;
                }
                Object createFadeAndShortSlide = TransitionHelper.createFadeAndShortSlide(112, f5);
                TransitionHelper.setEpicenterCallback(createFadeAndShortSlide, new TransitionEpicenterCallback() {
                    Rect mRect = new Rect();

                    public Rect onGetEpicenter(Object obj) {
                        int keyLine = GuidedActionsStylist.this.getKeyLine();
                        this.mRect.set(0, keyLine, 0, keyLine);
                        return this.mRect;
                    }
                });
                Object createChangeTransform = TransitionHelper.createChangeTransform();
                Object createChangeBounds = TransitionHelper.createChangeBounds(false);
                Object createFadeTransition = TransitionHelper.createFadeTransition(3);
                Object createChangeBounds2 = TransitionHelper.createChangeBounds(false);
                if (viewHolder3 == null) {
                    TransitionHelper.setStartDelay(createFadeAndShortSlide, 150);
                    TransitionHelper.setStartDelay(createChangeTransform, 100);
                    TransitionHelper.setStartDelay(createChangeBounds, 100);
                    TransitionHelper.setStartDelay(createChangeBounds2, 100);
                } else {
                    TransitionHelper.setStartDelay(createFadeTransition, 100);
                    TransitionHelper.setStartDelay(createChangeBounds2, 50);
                    TransitionHelper.setStartDelay(createChangeTransform, 50);
                    TransitionHelper.setStartDelay(createChangeBounds, 50);
                }
                for (int i6 = 0; i6 < childCount; i6++) {
                    VerticalGridView verticalGridView2 = this.mActionsGridView;
                    ViewHolder viewHolder4 = (ViewHolder) verticalGridView2.getChildViewHolder(verticalGridView2.getChildAt(i6));
                    if (viewHolder4 != viewHolder2) {
                        TransitionHelper.include(createFadeAndShortSlide, viewHolder4.itemView);
                        TransitionHelper.exclude(createFadeTransition, viewHolder4.itemView, true);
                    } else if (hasSubActions) {
                        TransitionHelper.include(createChangeTransform, viewHolder4.itemView);
                        TransitionHelper.include(createChangeBounds, viewHolder4.itemView);
                    }
                }
                TransitionHelper.include(createChangeBounds2, (View) this.mSubActionsGridView);
                TransitionHelper.include(createChangeBounds2, this.mSubActionsBackground);
                TransitionHelper.addTransition(createTransitionSet, createFadeAndShortSlide);
                if (hasSubActions) {
                    TransitionHelper.addTransition(createTransitionSet, createChangeTransform);
                    TransitionHelper.addTransition(createTransitionSet, createChangeBounds);
                }
                TransitionHelper.addTransition(createTransitionSet, createFadeTransition);
                TransitionHelper.addTransition(createTransitionSet, createChangeBounds2);
                this.mExpandTransition = createTransitionSet;
                TransitionHelper.addTransitionListener(createTransitionSet, new TransitionListener() {
                    public void onTransitionEnd(Object obj) {
                        GuidedActionsStylist.this.mExpandTransition = null;
                    }
                });
                if (z5 && hasSubActions) {
                    int bottom = viewHolder3.itemView.getBottom();
                    VerticalGridView verticalGridView3 = this.mSubActionsGridView;
                    verticalGridView3.offsetTopAndBottom(bottom - verticalGridView3.getTop());
                    View view = this.mSubActionsBackground;
                    view.offsetTopAndBottom(bottom - view.getTop());
                }
                TransitionHelper.beginDelayedTransition(this.mMainView, this.mExpandTransition);
            }
            onUpdateExpandedViewHolder(viewHolder);
            if (hasSubActions) {
                onUpdateSubActionsGridView(viewHolder2.getAction(), z5);
            }
        }
    }

    @Deprecated
    public void startExpandedTransition(ViewHolder viewHolder) {
        GuidedAction guidedAction;
        if (viewHolder == null) {
            guidedAction = null;
        } else {
            guidedAction = viewHolder.getAction();
        }
        expandAction(guidedAction, isExpandTransitionSupported());
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onEditingModeChange(ViewHolder viewHolder, boolean z4, boolean z5) {
        GuidedAction action = viewHolder.getAction();
        TextView titleView = viewHolder.getTitleView();
        TextView descriptionView = viewHolder.getDescriptionView();
        if (z4) {
            CharSequence editTitle = action.getEditTitle();
            if (!(titleView == null || editTitle == null)) {
                titleView.setText(editTitle);
            }
            CharSequence editDescription = action.getEditDescription();
            if (!(descriptionView == null || editDescription == null)) {
                descriptionView.setText(editDescription);
            }
            if (action.isDescriptionEditable()) {
                if (descriptionView != null) {
                    descriptionView.setVisibility(0);
                    descriptionView.setInputType(action.getDescriptionEditInputType());
                    descriptionView.requestFocusFromTouch();
                }
                viewHolder.mEditingMode = 2;
            } else if (action.isEditable()) {
                if (titleView != null) {
                    titleView.setInputType(action.getEditInputType());
                    titleView.requestFocusFromTouch();
                }
                viewHolder.mEditingMode = 1;
            } else if (viewHolder.mActivatorView != null) {
                onEditActivatorView(viewHolder, z4, z5);
                viewHolder.mEditingMode = 3;
            }
        } else {
            if (titleView != null) {
                titleView.setText(action.getTitle());
            }
            if (descriptionView != null) {
                descriptionView.setText(action.getDescription());
            }
            int i5 = viewHolder.mEditingMode;
            if (i5 == 2) {
                if (descriptionView != null) {
                    descriptionView.setVisibility(TextUtils.isEmpty(action.getDescription()) ? 8 : 0);
                    descriptionView.setInputType(action.getDescriptionInputType());
                }
            } else if (i5 == 1) {
                if (titleView != null) {
                    titleView.setInputType(action.getInputType());
                }
            } else if (i5 == 3 && viewHolder.mActivatorView != null) {
                onEditActivatorView(viewHolder, z4, z5);
            }
            viewHolder.mEditingMode = 0;
        }
        onEditingModeChange(viewHolder, action, z4);
    }

    public int onProvideItemLayoutId(int i5) {
        if (i5 == 0) {
            return onProvideItemLayoutId();
        }
        if (i5 == 1) {
            return R.layout.lb_guidedactions_datepicker_item;
        }
        throw new RuntimeException("ViewType " + i5 + " not supported in GuidedActionsStylist");
    }

    /* access modifiers changed from: package-private */
    public void setEditingMode(ViewHolder viewHolder, boolean z4) {
        setEditingMode(viewHolder, z4, true);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        if (i5 == 0) {
            return onCreateViewHolder(viewGroup);
        }
        boolean z4 = false;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(onProvideItemLayoutId(i5), viewGroup, false);
        if (viewGroup == this.mSubActionsGridView) {
            z4 = true;
        }
        return new ViewHolder(inflate, z4);
    }

    /* access modifiers changed from: package-private */
    public void setEditingMode(ViewHolder viewHolder, boolean z4, boolean z5) {
        if (z4 != viewHolder.isInEditing() && !isInExpandTransition()) {
            onEditingModeChange(viewHolder, z4, z5);
        }
    }
}
