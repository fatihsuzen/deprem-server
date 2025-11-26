package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;

class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList = null;
    private PorterDuff.Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;
    @NonNull
    private final CompoundButton mView;

    AppCompatCompoundButtonHelper(@NonNull CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    /* access modifiers changed from: package-private */
    public void applyButtonTint() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (buttonDrawable == null) {
            return;
        }
        if (this.mHasButtonTint || this.mHasButtonTintMode) {
            Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
            if (this.mHasButtonTint) {
                DrawableCompat.setTintList(mutate, this.mButtonTintList);
            }
            if (this.mHasButtonTintMode) {
                DrawableCompat.setTintMode(mutate, this.mButtonTintMode);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.mView.getDrawableState());
            }
            this.mView.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|(2:6|7)|10|11|(1:15)|16|(1:18)|19|(1:21)|22|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadFromAttributes(@androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CompoundButton r0 = r10.mView
            android.content.Context r0 = r0.getContext()
            int[] r3 = androidx.appcompat.R.styleable.CompoundButton
            r8 = 0
            androidx.appcompat.widget.TintTypedArray r9 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r0, r11, r3, r12, r8)
            android.widget.CompoundButton r1 = r10.mView
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r9.getWrappedTypeArray()
            r7 = 0
            r4 = r11
            r6 = r12
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r1, r2, r3, r4, r5, r6, r7)
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x0039 }
            boolean r12 = r9.hasValue(r11)     // Catch:{ all -> 0x0039 }
            if (r12 == 0) goto L_0x003c
            int r11 = r9.getResourceId(r11, r8)     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x003c
            android.widget.CompoundButton r12 = r10.mView     // Catch:{ NotFoundException -> 0x003c }
            android.content.Context r0 = r12.getContext()     // Catch:{ NotFoundException -> 0x003c }
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r0, r11)     // Catch:{ NotFoundException -> 0x003c }
            r12.setButtonDrawable(r11)     // Catch:{ NotFoundException -> 0x003c }
            goto L_0x0057
        L_0x0039:
            r0 = move-exception
            r11 = r0
            goto L_0x0083
        L_0x003c:
            int r11 = androidx.appcompat.R.styleable.CompoundButton_android_button     // Catch:{ all -> 0x0039 }
            boolean r12 = r9.hasValue(r11)     // Catch:{ all -> 0x0039 }
            if (r12 == 0) goto L_0x0057
            int r11 = r9.getResourceId(r11, r8)     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x0057
            android.widget.CompoundButton r12 = r10.mView     // Catch:{ all -> 0x0039 }
            android.content.Context r0 = r12.getContext()     // Catch:{ all -> 0x0039 }
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r0, r11)     // Catch:{ all -> 0x0039 }
            r12.setButtonDrawable(r11)     // Catch:{ all -> 0x0039 }
        L_0x0057:
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x0039 }
            boolean r12 = r9.hasValue(r11)     // Catch:{ all -> 0x0039 }
            if (r12 == 0) goto L_0x0068
            android.widget.CompoundButton r12 = r10.mView     // Catch:{ all -> 0x0039 }
            android.content.res.ColorStateList r11 = r9.getColorStateList(r11)     // Catch:{ all -> 0x0039 }
            androidx.core.widget.CompoundButtonCompat.setButtonTintList(r12, r11)     // Catch:{ all -> 0x0039 }
        L_0x0068:
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0039 }
            boolean r12 = r9.hasValue(r11)     // Catch:{ all -> 0x0039 }
            if (r12 == 0) goto L_0x007f
            android.widget.CompoundButton r12 = r10.mView     // Catch:{ all -> 0x0039 }
            r0 = -1
            int r11 = r9.getInt(r11, r0)     // Catch:{ all -> 0x0039 }
            r0 = 0
            android.graphics.PorterDuff$Mode r11 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r11, r0)     // Catch:{ all -> 0x0039 }
            androidx.core.widget.CompoundButtonCompat.setButtonTintMode(r12, r11)     // Catch:{ all -> 0x0039 }
        L_0x007f:
            r9.recycle()
            return
        L_0x0083:
            r9.recycle()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCompoundButtonHelper.loadFromAttributes(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }
        this.mSkipNextApply = true;
        applyButtonTint();
    }

    /* access modifiers changed from: package-private */
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    /* access modifiers changed from: package-private */
    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
