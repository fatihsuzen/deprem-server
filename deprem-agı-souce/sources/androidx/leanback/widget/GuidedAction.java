package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.leanback.R;
import java.util.List;

public class GuidedAction extends Action {
    public static final long ACTION_ID_CANCEL = -5;
    public static final long ACTION_ID_CONTINUE = -7;
    public static final long ACTION_ID_CURRENT = -3;
    public static final long ACTION_ID_FINISH = -6;
    public static final long ACTION_ID_NEXT = -2;
    public static final long ACTION_ID_NO = -9;
    public static final long ACTION_ID_OK = -4;
    public static final long ACTION_ID_YES = -8;
    public static final int CHECKBOX_CHECK_SET_ID = -1;
    public static final int DEFAULT_CHECK_SET_ID = 1;
    static final int EDITING_ACTIVATOR_VIEW = 3;
    static final int EDITING_DESCRIPTION = 2;
    static final int EDITING_NONE = 0;
    static final int EDITING_TITLE = 1;
    public static final int NO_CHECK_SET = 0;
    static final int PF_AUTORESTORE = 64;
    static final int PF_CHECKED = 1;
    static final int PF_ENABLED = 16;
    static final int PF_FOCUSABLE = 32;
    static final int PF_HAS_NEXT = 4;
    static final int PF_INFO_ONLY = 8;
    static final int PF_MULTI_LINE_DESCRIPTION = 2;
    private static final String TAG = "GuidedAction";
    int mActionFlags;
    String[] mAutofillHints;
    int mCheckSetId;
    int mDescriptionEditInputType;
    int mDescriptionInputType;
    private CharSequence mEditDescription;
    int mEditInputType;
    private CharSequence mEditTitle;
    int mEditable;
    int mInputType;
    Intent mIntent;
    List<GuidedAction> mSubActions;

    public static class Builder extends BuilderBase<Builder> {
        @Deprecated
        public Builder() {
            super((Context) null);
        }

        public GuidedAction build() {
            GuidedAction guidedAction = new GuidedAction();
            applyValues(guidedAction);
            return guidedAction;
        }

        public Builder(Context context) {
            super(context);
        }
    }

    public static abstract class BuilderBase<B extends BuilderBase> {
        private int mActionFlags;
        private String[] mAutofillHints;
        private int mCheckSetId = 0;
        private Context mContext;
        private CharSequence mDescription;
        private int mDescriptionEditInputType = 1;
        private int mDescriptionInputType = 524289;
        private CharSequence mEditDescription;
        private int mEditInputType = 1;
        private CharSequence mEditTitle;
        private int mEditable = 0;
        private Drawable mIcon;
        private long mId;
        private int mInputType = 524289;
        private Intent mIntent;
        private List<GuidedAction> mSubActions;
        private CharSequence mTitle;

        public BuilderBase(Context context) {
            this.mContext = context;
            this.mActionFlags = 112;
        }

        private boolean isChecked() {
            if ((this.mActionFlags & 1) == 1) {
                return true;
            }
            return false;
        }

        private void setFlags(int i5, int i6) {
            this.mActionFlags = (i5 & i6) | (this.mActionFlags & (~i6));
        }

        /* access modifiers changed from: protected */
        public final void applyValues(GuidedAction guidedAction) {
            guidedAction.setId(this.mId);
            guidedAction.setLabel1(this.mTitle);
            guidedAction.setEditTitle(this.mEditTitle);
            guidedAction.setLabel2(this.mDescription);
            guidedAction.setEditDescription(this.mEditDescription);
            guidedAction.setIcon(this.mIcon);
            guidedAction.mIntent = this.mIntent;
            guidedAction.mEditable = this.mEditable;
            guidedAction.mInputType = this.mInputType;
            guidedAction.mDescriptionInputType = this.mDescriptionInputType;
            guidedAction.mAutofillHints = this.mAutofillHints;
            guidedAction.mEditInputType = this.mEditInputType;
            guidedAction.mDescriptionEditInputType = this.mDescriptionEditInputType;
            guidedAction.mActionFlags = this.mActionFlags;
            guidedAction.mCheckSetId = this.mCheckSetId;
            guidedAction.mSubActions = this.mSubActions;
        }

        public B autoSaveRestoreEnabled(boolean z4) {
            int i5;
            if (z4) {
                i5 = 64;
            } else {
                i5 = 0;
            }
            setFlags(i5, 64);
            return this;
        }

        public B autofillHints(String... strArr) {
            this.mAutofillHints = strArr;
            return this;
        }

        public B checkSetId(int i5) {
            this.mCheckSetId = i5;
            if (this.mEditable == 0) {
                return this;
            }
            throw new IllegalArgumentException("Editable actions cannot also be in check sets");
        }

        public B checked(boolean z4) {
            setFlags(z4 ? 1 : 0, 1);
            if (this.mEditable == 0) {
                return this;
            }
            throw new IllegalArgumentException("Editable actions cannot also be checked");
        }

        public B clickAction(long j5) {
            if (j5 == -4) {
                this.mId = -4;
                this.mTitle = this.mContext.getString(17039370);
                return this;
            } else if (j5 == -5) {
                this.mId = -5;
                this.mTitle = this.mContext.getString(17039360);
                return this;
            } else if (j5 == -6) {
                this.mId = -6;
                this.mTitle = this.mContext.getString(R.string.lb_guidedaction_finish_title);
                return this;
            } else if (j5 == -7) {
                this.mId = -7;
                this.mTitle = this.mContext.getString(R.string.lb_guidedaction_continue_title);
                return this;
            } else if (j5 == -8) {
                this.mId = -8;
                this.mTitle = this.mContext.getString(17039370);
                return this;
            } else {
                if (j5 == -9) {
                    this.mId = -9;
                    this.mTitle = this.mContext.getString(17039360);
                }
                return this;
            }
        }

        public B description(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public B descriptionEditInputType(int i5) {
            this.mDescriptionEditInputType = i5;
            return this;
        }

        public B descriptionEditable(boolean z4) {
            if (z4) {
                this.mEditable = 2;
                if (isChecked() || this.mCheckSetId != 0) {
                    throw new IllegalArgumentException("Editable actions cannot also be checked");
                }
            } else if (this.mEditable == 2) {
                this.mEditable = 0;
                return this;
            }
            return this;
        }

        public B descriptionInputType(int i5) {
            this.mDescriptionInputType = i5;
            return this;
        }

        public B editDescription(CharSequence charSequence) {
            this.mEditDescription = charSequence;
            return this;
        }

        public B editInputType(int i5) {
            this.mEditInputType = i5;
            return this;
        }

        public B editTitle(CharSequence charSequence) {
            this.mEditTitle = charSequence;
            return this;
        }

        public B editable(boolean z4) {
            if (z4) {
                this.mEditable = 1;
                if (isChecked() || this.mCheckSetId != 0) {
                    throw new IllegalArgumentException("Editable actions cannot also be checked");
                }
            } else if (this.mEditable == 1) {
                this.mEditable = 0;
                return this;
            }
            return this;
        }

        public B enabled(boolean z4) {
            int i5;
            if (z4) {
                i5 = 16;
            } else {
                i5 = 0;
            }
            setFlags(i5, 16);
            return this;
        }

        public B focusable(boolean z4) {
            int i5;
            if (z4) {
                i5 = 32;
            } else {
                i5 = 0;
            }
            setFlags(i5, 32);
            return this;
        }

        public Context getContext() {
            return this.mContext;
        }

        public B hasEditableActivatorView(boolean z4) {
            if (z4) {
                this.mEditable = 3;
                if (isChecked() || this.mCheckSetId != 0) {
                    throw new IllegalArgumentException("Editable actions cannot also be checked");
                }
            } else if (this.mEditable == 3) {
                this.mEditable = 0;
                return this;
            }
            return this;
        }

        public B hasNext(boolean z4) {
            int i5;
            if (z4) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            setFlags(i5, 4);
            return this;
        }

        public B icon(Drawable drawable) {
            this.mIcon = drawable;
            return this;
        }

        @Deprecated
        public B iconResourceId(@DrawableRes int i5, Context context) {
            return icon(ContextCompat.getDrawable(context, i5));
        }

        public B id(long j5) {
            this.mId = j5;
            return this;
        }

        public B infoOnly(boolean z4) {
            int i5;
            if (z4) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            setFlags(i5, 8);
            return this;
        }

        public B inputType(int i5) {
            this.mInputType = i5;
            return this;
        }

        public B intent(Intent intent) {
            this.mIntent = intent;
            return this;
        }

        public B multilineDescription(boolean z4) {
            int i5;
            if (z4) {
                i5 = 2;
            } else {
                i5 = 0;
            }
            setFlags(i5, 2);
            return this;
        }

        public B subActions(List<GuidedAction> list) {
            this.mSubActions = list;
            return this;
        }

        public B title(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        public B description(@StringRes int i5) {
            this.mDescription = getContext().getString(i5);
            return this;
        }

        public B editDescription(@StringRes int i5) {
            this.mEditDescription = getContext().getString(i5);
            return this;
        }

        public B editTitle(@StringRes int i5) {
            this.mEditTitle = getContext().getString(i5);
            return this;
        }

        public B icon(@DrawableRes int i5) {
            return icon(ContextCompat.getDrawable(getContext(), i5));
        }

        public B title(@StringRes int i5) {
            this.mTitle = getContext().getString(i5);
            return this;
        }
    }

    protected GuidedAction() {
        super(0);
    }

    static boolean isPasswordVariant(int i5) {
        int i6 = i5 & 4080;
        return i6 == 128 || i6 == 144 || i6 == 224;
    }

    private void setFlags(int i5, int i6) {
        this.mActionFlags = (i5 & i6) | (this.mActionFlags & (~i6));
    }

    public String[] getAutofillHints() {
        return this.mAutofillHints;
    }

    public int getCheckSetId() {
        return this.mCheckSetId;
    }

    public CharSequence getDescription() {
        return getLabel2();
    }

    public int getDescriptionEditInputType() {
        return this.mDescriptionEditInputType;
    }

    public int getDescriptionInputType() {
        return this.mDescriptionInputType;
    }

    public CharSequence getEditDescription() {
        return this.mEditDescription;
    }

    public int getEditInputType() {
        return this.mEditInputType;
    }

    public CharSequence getEditTitle() {
        return this.mEditTitle;
    }

    public int getInputType() {
        return this.mInputType;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    @SuppressLint({"NullableCollection"})
    public List<GuidedAction> getSubActions() {
        return this.mSubActions;
    }

    public CharSequence getTitle() {
        return getLabel1();
    }

    public boolean hasEditableActivatorView() {
        if (this.mEditable == 3) {
            return true;
        }
        return false;
    }

    public boolean hasMultilineDescription() {
        if ((this.mActionFlags & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if ((this.mActionFlags & 4) == 4) {
            return true;
        }
        return false;
    }

    public boolean hasSubActions() {
        if (this.mSubActions != null) {
            return true;
        }
        return false;
    }

    public boolean hasTextEditable() {
        int i5 = this.mEditable;
        if (i5 == 1 || i5 == 2) {
            return true;
        }
        return false;
    }

    public boolean infoOnly() {
        if ((this.mActionFlags & 8) == 8) {
            return true;
        }
        return false;
    }

    public final boolean isAutoSaveRestoreEnabled() {
        if ((this.mActionFlags & 64) == 64) {
            return true;
        }
        return false;
    }

    public boolean isChecked() {
        if ((this.mActionFlags & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean isDescriptionEditable() {
        if (this.mEditable == 2) {
            return true;
        }
        return false;
    }

    public boolean isEditTitleUsed() {
        if (this.mEditTitle != null) {
            return true;
        }
        return false;
    }

    public boolean isEditable() {
        if (this.mEditable == 1) {
            return true;
        }
        return false;
    }

    public boolean isEnabled() {
        if ((this.mActionFlags & 16) == 16) {
            return true;
        }
        return false;
    }

    public boolean isFocusable() {
        if ((this.mActionFlags & 32) == 32) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean needAutoSaveDescription() {
        if (!isDescriptionEditable() || isPasswordVariant(getDescriptionEditInputType())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean needAutoSaveTitle() {
        if (!isEditable() || isPasswordVariant(getEditInputType())) {
            return false;
        }
        return true;
    }

    public void onRestoreInstanceState(Bundle bundle, String str) {
        if (needAutoSaveTitle()) {
            String string = bundle.getString(str);
            if (string != null) {
                setTitle(string);
            }
        } else if (needAutoSaveDescription()) {
            String string2 = bundle.getString(str);
            if (string2 != null) {
                setDescription(string2);
            }
        } else if (getCheckSetId() != 0) {
            setChecked(bundle.getBoolean(str, isChecked()));
        }
    }

    public void onSaveInstanceState(Bundle bundle, String str) {
        if (needAutoSaveTitle() && getTitle() != null) {
            bundle.putString(str, getTitle().toString());
        } else if (needAutoSaveDescription() && getDescription() != null) {
            bundle.putString(str, getDescription().toString());
        } else if (getCheckSetId() != 0) {
            bundle.putBoolean(str, isChecked());
        }
    }

    public void setChecked(boolean z4) {
        setFlags(z4 ? 1 : 0, 1);
    }

    public void setDescription(CharSequence charSequence) {
        setLabel2(charSequence);
    }

    public void setEditDescription(CharSequence charSequence) {
        this.mEditDescription = charSequence;
    }

    public void setEditTitle(CharSequence charSequence) {
        this.mEditTitle = charSequence;
    }

    public void setEnabled(boolean z4) {
        int i5;
        if (z4) {
            i5 = 16;
        } else {
            i5 = 0;
        }
        setFlags(i5, 16);
    }

    public void setFocusable(boolean z4) {
        int i5;
        if (z4) {
            i5 = 32;
        } else {
            i5 = 0;
        }
        setFlags(i5, 32);
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setSubActions(List<GuidedAction> list) {
        this.mSubActions = list;
    }

    public void setTitle(CharSequence charSequence) {
        setLabel1(charSequence);
    }
}
