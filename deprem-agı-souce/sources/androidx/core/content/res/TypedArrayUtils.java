package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(@NonNull Context context, int i5, int i6) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i5, typedValue, true);
        if (typedValue.resourceId != 0) {
            return i5;
        }
        return i6;
    }

    public static boolean getBoolean(@NonNull TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6, boolean z4) {
        return typedArray.getBoolean(i5, typedArray.getBoolean(i6, z4));
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6) {
        Drawable drawable = typedArray.getDrawable(i5);
        if (drawable == null) {
            return typedArray.getDrawable(i6);
        }
        return drawable;
    }

    public static int getInt(@NonNull TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6, int i7) {
        return typedArray.getInt(i5, typedArray.getInt(i6, i7));
    }

    public static boolean getNamedBoolean(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i5, boolean z4) {
        if (!hasAttribute(xmlPullParser, str)) {
            return z4;
        }
        return typedArray.getBoolean(i5, z4);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i5, @ColorInt int i6) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i6;
        }
        return typedArray.getColor(i5, i6);
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i5) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i5, typedValue);
        int i6 = typedValue.type;
        if (i6 == 2) {
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i5 + ": " + typedValue);
        } else if (i6 < 28 || i6 > 31) {
            return ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme);
        } else {
            return getNamedColorStateListFromInt(typedValue);
        }
    }

    @NonNull
    private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i5, @ColorInt int i6) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i5, typedValue);
            int i7 = typedValue.type;
            if (i7 >= 28 && i7 <= 31) {
                return ComplexColorCompat.from(typedValue.data);
            }
            ComplexColorCompat inflate = ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme);
            if (inflate != null) {
                return inflate;
            }
        }
        return ComplexColorCompat.from(i6);
    }

    public static float getNamedFloat(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i5, float f5) {
        if (!hasAttribute(xmlPullParser, str)) {
            return f5;
        }
        return typedArray.getFloat(i5, f5);
    }

    public static int getNamedInt(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i5, int i6) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i6;
        }
        return typedArray.getInt(i5, i6);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i5, @AnyRes int i6) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i6;
        }
        return typedArray.getResourceId(i5, i6);
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i5) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i5);
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6, @AnyRes int i7) {
        return typedArray.getResourceId(i5, typedArray.getResourceId(i6, i7));
    }

    @Nullable
    public static String getString(@NonNull TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6) {
        String string = typedArray.getString(i5);
        if (string == null) {
            return typedArray.getString(i6);
        }
        return string;
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6) {
        CharSequence text = typedArray.getText(i5);
        if (text == null) {
            return typedArray.getText(i6);
        }
        return text;
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray typedArray, @StyleableRes int i5, @StyleableRes int i6) {
        CharSequence[] textArray = typedArray.getTextArray(i5);
        if (textArray == null) {
            return typedArray.getTextArray(i6);
        }
        return textArray;
    }

    public static boolean hasAttribute(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        if (xmlPullParser.getAttributeValue(NAMESPACE, str) != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i5) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i5);
    }
}
