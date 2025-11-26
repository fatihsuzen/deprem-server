package com.google.android.material.drawable;

import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DrawableUtils {
    public static final int INTRINSIC_SIZE = -1;
    private static final int UNSPECIFIED_HEIGHT = -1;
    private static final int UNSPECIFIED_WIDTH = -1;

    private static class OutlineCompatL {
        private OutlineCompatL() {
        }

        @DoNotInline
        static void setConvexPath(@NonNull Outline outline, @NonNull Path path) {
            outline.setConvexPath(path);
        }
    }

    @RequiresApi(30)
    private static class OutlineCompatR {
        private OutlineCompatR() {
        }

        @DoNotInline
        static void setPath(@NonNull Outline outline, @NonNull Path path) {
            outline.setPath(path);
        }
    }

    private DrawableUtils() {
    }

    @Nullable
    public static Drawable compositeTwoLayeredDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        return compositeTwoLayeredDrawable(drawable, drawable2, -1, -1);
    }

    @Nullable
    public static Drawable createTintableDrawableIfNeeded(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        return createTintableMutatedDrawableIfNeeded(drawable, colorStateList, mode, false);
    }

    @Nullable
    public static Drawable createTintableMutatedDrawableIfNeeded(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        return createTintableMutatedDrawableIfNeeded(drawable, colorStateList, mode, false);
    }

    @NonNull
    public static int[] getCheckedState(@NonNull int[] iArr) {
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            if (i6 == 16842912) {
                return iArr;
            }
            if (i6 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i5] = 16842912;
                return iArr2;
            }
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[iArr.length] = 16842912;
        return copyOf;
    }

    @Nullable
    public static ColorStateList getColorStateListOrNull(@Nullable Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !a.a(drawable)) {
            return null;
        }
        return b.a(drawable).getColorStateList();
    }

    private static int getTopLayerIntrinsicHeight(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        if (intrinsicHeight != -1) {
            return intrinsicHeight;
        }
        return drawable.getIntrinsicHeight();
    }

    private static int getTopLayerIntrinsicWidth(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        if (intrinsicWidth != -1) {
            return intrinsicWidth;
        }
        return drawable.getIntrinsicWidth();
    }

    @NonNull
    public static int[] getUncheckedState(@NonNull int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i5 = 0;
        for (int i6 : iArr) {
            if (i6 != 16842912) {
                iArr2[i5] = i6;
                i5++;
            }
        }
        return iArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043 A[Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014 A[Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.AttributeSet parseDrawableXml(@androidx.annotation.NonNull android.content.Context r3, @androidx.annotation.XmlRes int r4, @androidx.annotation.NonNull java.lang.CharSequence r5) {
        /*
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            android.content.res.XmlResourceParser r3 = r3.getXml(r4)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
        L_0x0008:
            int r0 = r3.next()     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            r1 = 2
            if (r0 == r1) goto L_0x0012
            r2 = 1
            if (r0 != r2) goto L_0x0008
        L_0x0012:
            if (r0 != r1) goto L_0x0043
            java.lang.String r0 = r3.getName()     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            boolean r0 = android.text.TextUtils.equals(r0, r5)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            if (r0 == 0) goto L_0x0027
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r3)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            return r3
        L_0x0023:
            r3 = move-exception
            goto L_0x004b
        L_0x0025:
            r3 = move-exception
            goto L_0x004b
        L_0x0027:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            r0.<init>()     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            java.lang.String r1 = "Must have a <"
            r0.append(r1)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            r0.append(r5)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            java.lang.String r5 = "> start tag"
            r0.append(r5)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            java.lang.String r5 = r0.toString()     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            r3.<init>(r5)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            throw r3     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
        L_0x0043:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            java.lang.String r5 = "No start tag found"
            r3.<init>(r5)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            throw r3     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
        L_0x004b:
            android.content.res.Resources$NotFoundException r5 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Can't load badge resource ID #0x"
            r0.append(r1)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            r5.initCause(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.drawable.DrawableUtils.parseDrawableXml(android.content.Context, int, java.lang.CharSequence):android.util.AttributeSet");
    }

    public static void setOutlineToPath(@NonNull Outline outline, @NonNull Path path) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            OutlineCompatR.setPath(outline, path);
        } else if (i5 >= 29) {
            try {
                OutlineCompatL.setConvexPath(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            OutlineCompatL.setConvexPath(outline, path);
        }
    }

    public static void setRippleDrawableRadius(@Nullable RippleDrawable rippleDrawable, int i5) {
        rippleDrawable.setRadius(i5);
    }

    public static void setTint(@NonNull Drawable drawable, @ColorInt int i5) {
        boolean z4;
        if (i5 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            drawable.setTint(i5);
        } else {
            drawable.setTintList((ColorStateList) null);
        }
    }

    @Nullable
    public static PorterDuffColorFilter updateTintFilter(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    @Nullable
    public static Drawable compositeTwoLayeredDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Px int i5, @Px int i6) {
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        if (i5 == -1) {
            i5 = getTopLayerIntrinsicWidth(drawable, drawable2);
        }
        if (i6 == -1) {
            i6 = getTopLayerIntrinsicHeight(drawable, drawable2);
        }
        if (i5 > drawable.getIntrinsicWidth() || i6 > drawable.getIntrinsicHeight()) {
            float f5 = ((float) i5) / ((float) i6);
            if (f5 >= ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight())) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int i7 = intrinsicWidth;
                i6 = (int) (((float) intrinsicWidth) / f5);
                i5 = i7;
            } else {
                i6 = drawable.getIntrinsicHeight();
                i5 = (int) (f5 * ((float) i6));
            }
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
        layerDrawable.setLayerSize(1, i5, i6);
        layerDrawable.setLayerGravity(1, 17);
        return layerDrawable;
    }

    @Nullable
    private static Drawable createTintableMutatedDrawableIfNeeded(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, boolean z4) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            if (mode != null) {
                mutate.setTintMode(mode);
            }
            return mutate;
        }
        if (z4) {
            drawable.mutate();
        }
        return drawable;
    }
}
