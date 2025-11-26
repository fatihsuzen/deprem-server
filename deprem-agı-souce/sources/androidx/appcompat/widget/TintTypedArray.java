package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static int getChangingConfigurations(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        @DoNotInline
        static int getType(TypedArray typedArray, int i5) {
            return typedArray.getType(i5);
        }
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i5, boolean z4) {
        return this.mWrapped.getBoolean(i5, z4);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return Api21Impl.getChangingConfigurations(this.mWrapped);
    }

    public int getColor(int i5, int i6) {
        return this.mWrapped.getColor(i5, i6);
    }

    public ColorStateList getColorStateList(int i5) {
        int resourceId;
        ColorStateList colorStateList;
        if (!this.mWrapped.hasValue(i5) || (resourceId = this.mWrapped.getResourceId(i5, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) {
            return this.mWrapped.getColorStateList(i5);
        }
        return colorStateList;
    }

    public float getDimension(int i5, float f5) {
        return this.mWrapped.getDimension(i5, f5);
    }

    public int getDimensionPixelOffset(int i5, int i6) {
        return this.mWrapped.getDimensionPixelOffset(i5, i6);
    }

    public int getDimensionPixelSize(int i5, int i6) {
        return this.mWrapped.getDimensionPixelSize(i5, i6);
    }

    public Drawable getDrawable(int i5) {
        int resourceId;
        if (!this.mWrapped.hasValue(i5) || (resourceId = this.mWrapped.getResourceId(i5, 0)) == 0) {
            return this.mWrapped.getDrawable(i5);
        }
        return AppCompatResources.getDrawable(this.mContext, resourceId);
    }

    public Drawable getDrawableIfKnown(int i5) {
        int resourceId;
        if (!this.mWrapped.hasValue(i5) || (resourceId = this.mWrapped.getResourceId(i5, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().getDrawable(this.mContext, resourceId, true);
    }

    public float getFloat(int i5, float f5) {
        return this.mWrapped.getFloat(i5, f5);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i5, int i6, @Nullable ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.mWrapped.getResourceId(i5, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        return ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i6, fontCallback);
    }

    public float getFraction(int i5, int i6, int i7, float f5) {
        return this.mWrapped.getFraction(i5, i6, i7, f5);
    }

    public int getIndex(int i5) {
        return this.mWrapped.getIndex(i5);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int i5, int i6) {
        return this.mWrapped.getInt(i5, i6);
    }

    public int getInteger(int i5, int i6) {
        return this.mWrapped.getInteger(i5, i6);
    }

    public int getLayoutDimension(int i5, String str) {
        return this.mWrapped.getLayoutDimension(i5, str);
    }

    public String getNonResourceString(int i5) {
        return this.mWrapped.getNonResourceString(i5);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int i5, int i6) {
        return this.mWrapped.getResourceId(i5, i6);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int i5) {
        return this.mWrapped.getString(i5);
    }

    public CharSequence getText(int i5) {
        return this.mWrapped.getText(i5);
    }

    public CharSequence[] getTextArray(int i5) {
        return this.mWrapped.getTextArray(i5);
    }

    public int getType(int i5) {
        return Api21Impl.getType(this.mWrapped, i5);
    }

    public boolean getValue(int i5, TypedValue typedValue) {
        return this.mWrapped.getValue(i5, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int i5) {
        return this.mWrapped.hasValue(i5);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int i5) {
        return this.mWrapped.peekValue(i5);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i5, i6));
    }

    public int getLayoutDimension(int i5, int i6) {
        return this.mWrapped.getLayoutDimension(i5, i6);
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i5, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i5, iArr));
    }
}
