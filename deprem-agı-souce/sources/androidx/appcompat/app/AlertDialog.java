package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;

    public static class Builder {

        /* renamed from: P  reason: collision with root package name */
        private final AlertController.AlertParams f194P;
        private final int mTheme;

        public Builder(@NonNull Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, 0));
        }

        @NonNull
        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f194P.mContext, this.mTheme);
            this.f194P.apply(alertDialog.mAlert);
            alertDialog.setCancelable(this.f194P.mCancelable);
            if (this.f194P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f194P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.f194P.mOnDismissListener);
            DialogInterface.OnKeyListener onKeyListener = this.f194P.mOnKeyListener;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        @NonNull
        public Context getContext() {
            return this.f194P.mContext;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z4) {
            this.f194P.mCancelable = z4;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mCursor = cursor;
            alertParams.mLabelColumn = str;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCustomTitle(@Nullable View view) {
            this.f194P.mCustomTitleView = view;
            return this;
        }

        public Builder setIcon(@DrawableRes int i5) {
            this.f194P.mIconId = i5;
            return this;
        }

        public Builder setIconAttribute(@AttrRes int i5) {
            TypedValue typedValue = new TypedValue();
            this.f194P.mContext.getTheme().resolveAttribute(i5, typedValue, true);
            this.f194P.mIconId = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z4) {
            this.f194P.mForceInverseBackground = z4;
            return this;
        }

        public Builder setItems(@ArrayRes int i5, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i5);
            this.f194P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMessage(@StringRes int i5) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mMessage = alertParams.mContext.getText(i5);
            return this;
        }

        public Builder setMultiChoiceItems(@ArrayRes int i5, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i5);
            AlertController.AlertParams alertParams2 = this.f194P;
            alertParams2.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams2.mCheckedItems = zArr;
            alertParams2.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(@StringRes int i5, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i5);
            this.f194P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable drawable) {
            this.f194P.mNegativeButtonIcon = drawable;
            return this;
        }

        public Builder setNeutralButton(@StringRes int i5, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i5);
            this.f194P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable drawable) {
            this.f194P.mNeutralButtonIcon = drawable;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f194P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f194P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f194P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f194P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setPositiveButton(@StringRes int i5, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i5);
            this.f194P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable drawable) {
            this.f194P.mPositiveButtonIcon = drawable;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setRecycleOnMeasureEnabled(boolean z4) {
            this.f194P.mRecycleOnMeasure = z4;
            return this;
        }

        public Builder setSingleChoiceItems(@ArrayRes int i5, int i6, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i5);
            AlertController.AlertParams alertParams2 = this.f194P;
            alertParams2.mOnClickListener = onClickListener;
            alertParams2.mCheckedItem = i6;
            alertParams2.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(@StringRes int i5) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mTitle = alertParams.mContext.getText(i5);
            return this;
        }

        public Builder setView(int i5) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mView = null;
            alertParams.mViewLayoutResId = i5;
            alertParams.mViewSpacingSpecified = false;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }

        public Builder(@NonNull Context context, @StyleRes int i5) {
            this.f194P = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i5)));
            this.mTheme = i5;
        }

        public Builder setIcon(@Nullable Drawable drawable) {
            this.f194P.mIcon = drawable;
            return this;
        }

        public Builder setMessage(@Nullable CharSequence charSequence) {
            this.f194P.mMessage = charSequence;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.f194P.mTitle = charSequence;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mNegativeButtonText = charSequence;
            alertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mNeutralButtonText = charSequence;
            alertParams.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mPositiveButtonText = charSequence;
            alertParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setView(View view) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mView = view;
            alertParams.mViewLayoutResId = 0;
            alertParams.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mCheckedItems = zArr;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i5, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mCursor = cursor;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i5;
            alertParams.mLabelColumn = str;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setView(View view, int i5, int i6, int i7, int i8) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mView = view;
            alertParams.mViewLayoutResId = 0;
            alertParams.mViewSpacingSpecified = true;
            alertParams.mViewSpacingLeft = i5;
            alertParams.mViewSpacingTop = i6;
            alertParams.mViewSpacingRight = i7;
            alertParams.mViewSpacingBottom = i8;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mCursor = cursor;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mIsCheckedColumn = str;
            alertParams.mLabelColumn = str2;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i5, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i5;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i5, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f194P;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i5;
            alertParams.mIsSingleChoice = true;
            return this;
        }
    }

    protected AlertDialog(@NonNull Context context) {
        this(context, 0);
    }

    static int resolveDialogTheme(@NonNull Context context, @StyleRes int i5) {
        if (((i5 >>> 24) & 255) >= 1) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i5) {
        return this.mAlert.getButton(i5);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        if (this.mAlert.onKeyDown(i5, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i5, keyEvent);
    }

    public boolean onKeyUp(int i5, KeyEvent keyEvent) {
        if (this.mAlert.onKeyUp(i5, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i5, keyEvent);
    }

    public void setButton(int i5, CharSequence charSequence, Message message) {
        this.mAlert.setButton(i5, charSequence, (DialogInterface.OnClickListener) null, message, (Drawable) null);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setButtonPanelLayoutHint(int i5) {
        this.mAlert.setButtonPanelLayoutHint(i5);
    }

    public void setCustomTitle(View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setIcon(int i5) {
        this.mAlert.setIcon(i5);
    }

    public void setIconAttribute(int i5) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i5, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setView(View view) {
        this.mAlert.setView(view);
    }

    protected AlertDialog(@NonNull Context context, @StyleRes int i5) {
        super(context, resolveDialogTheme(context, i5));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    public void setButton(int i5, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(i5, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setView(View view, int i5, int i6, int i7, int i8) {
        this.mAlert.setView(view, i5, i6, i7, i8);
    }

    public void setButton(int i5, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(i5, charSequence, onClickListener, (Message) null, drawable);
    }

    protected AlertDialog(@NonNull Context context, boolean z4, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z4);
        setOnCancelListener(onCancelListener);
    }
}
