package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import k3.l;
import kotlin.jvm.internal.t;

public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i5) {
        if (!typedArray.hasValue(i5)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        return typedArray.getBoolean(i5, false);
    }

    @ColorInt
    public static final int getColorOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        return typedArray.getColor(i5, 0);
    }

    public static final ColorStateList getColorStateListOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        ColorStateList colorStateList = typedArray.getColorStateList(i5);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.");
    }

    public static final float getDimensionOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        return typedArray.getDimension(i5, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        return typedArray.getDimensionPixelOffset(i5, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        return typedArray.getDimensionPixelSize(i5, 0);
    }

    public static final Drawable getDrawableOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        Drawable drawable = typedArray.getDrawable(i5);
        t.b(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        return typedArray.getFloat(i5, 0.0f);
    }

    @RequiresApi(26)
    public static final Typeface getFontOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        return TypedArrayApi26ImplKt.getFont(typedArray, i5);
    }

    public static final int getIntOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        return typedArray.getInt(i5, 0);
    }

    public static final int getIntegerOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        return typedArray.getInteger(i5, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        return typedArray.getResourceId(i5, 0);
    }

    public static final String getStringOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        String string = typedArray.getString(i5);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.");
    }

    public static final CharSequence[] getTextArrayOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        return typedArray.getTextArray(i5);
    }

    public static final CharSequence getTextOrThrow(TypedArray typedArray, @StyleableRes int i5) {
        checkAttribute(typedArray, i5);
        CharSequence text = typedArray.getText(i5);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.");
    }

    public static final <R> R use(TypedArray typedArray, l lVar) {
        R invoke = lVar.invoke(typedArray);
        typedArray.recycle();
        return invoke;
    }
}
