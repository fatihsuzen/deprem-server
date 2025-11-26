package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;

public final class ResourcesCompat {
    @AnyRes
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final Object sColorStateCacheLock = new Object();
    @GuardedBy("sColorStateCacheLock")
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Drawable getDrawable(Resources resources, int i5, Resources.Theme theme) {
            return resources.getDrawable(i5, theme);
        }

        @DoNotInline
        static Drawable getDrawableForDensity(Resources resources, int i5, int i6, Resources.Theme theme) {
            return resources.getDrawableForDensity(i5, i6, theme);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int getColor(Resources resources, int i5, Resources.Theme theme) {
            return resources.getColor(i5, theme);
        }

        @DoNotInline
        @NonNull
        static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i5, @Nullable Resources.Theme theme) {
            return resources.getColorStateList(i5, theme);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static float getFloat(@NonNull Resources resources, @DimenRes int i5) {
            return resources.getFloat(i5);
        }
    }

    private static class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;

        ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration, @Nullable Resources.Theme theme) {
            int i5;
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
            if (theme == null) {
                i5 = 0;
            } else {
                i5 = theme.hashCode();
            }
            this.mThemeHash = i5;
        }
    }

    private static final class ColorStateListCacheKey {
        final Resources mResources;
        final Resources.Theme mTheme;

        ColorStateListCacheKey(@NonNull Resources resources, @Nullable Resources.Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ColorStateListCacheKey.class == obj.getClass()) {
                ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
                if (!this.mResources.equals(colorStateListCacheKey.mResources) || !ObjectsCompat.equals(this.mTheme, colorStateListCacheKey.mTheme)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mResources, this.mTheme);
        }
    }

    public static abstract class FontCallback {
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler handler) {
            if (handler == null) {
                return new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(int i5, @Nullable Handler handler) {
            getHandler(handler).post(new b(this, i5));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(@NonNull Typeface typeface, @Nullable Handler handler) {
            getHandler(handler).post(new a(this, typeface));
        }

        public abstract void onFontRetrievalFailed(int i5);

        public abstract void onFontRetrieved(@NonNull Typeface typeface);
    }

    public static final class ThemeCompat {

        @RequiresApi(23)
        static class Api23Impl {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = new Object();

            private Api23Impl() {
            }

            @SuppressLint({"BanUncheckedReflection"})
            static void rebase(@NonNull Resources.Theme theme) {
                synchronized (sRebaseMethodLock) {
                    if (!sRebaseMethodFetched) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", (Class[]) null);
                            sRebaseMethod = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e5) {
                            Log.i(ResourcesCompat.TAG, "Failed to retrieve rebase() method", e5);
                        }
                        sRebaseMethodFetched = true;
                    }
                    Method method = sRebaseMethod;
                    if (method != null) {
                        try {
                            method.invoke(theme, (Object[]) null);
                        } catch (IllegalAccessException | InvocationTargetException e6) {
                            Log.i(ResourcesCompat.TAG, "Failed to invoke rebase() method via reflection", e6);
                            sRebaseMethod = null;
                        }
                    }
                }
            }
        }

        @RequiresApi(29)
        static class Api29Impl {
            private Api29Impl() {
            }

            @DoNotInline
            static void rebase(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(@NonNull Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.rebase(theme);
            } else {
                Api23Impl.rebase(theme);
            }
        }
    }

    private ResourcesCompat() {
    }

    private static void addColorStateListToCache(@NonNull ColorStateListCacheKey colorStateListCacheKey, @ColorRes int i5, @NonNull ColorStateList colorStateList, @Nullable Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> weakHashMap = sColorStateCaches;
                SparseArray sparseArray = weakHashMap.get(colorStateListCacheKey);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(colorStateListCacheKey, sparseArray);
                }
                sparseArray.append(i5, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void clearCachesForTheme(@NonNull Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                Iterator<ColorStateListCacheKey> it = sColorStateCaches.keySet().iterator();
                while (it.hasNext()) {
                    ColorStateListCacheKey next = it.next();
                    if (next != null && theme.equals(next.mTheme)) {
                        it.remove();
                    }
                }
            } finally {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (r2.mThemeHash == r5.hashCode()) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList getCachedColorStateList(@androidx.annotation.NonNull androidx.core.content.res.ResourcesCompat.ColorStateListCacheKey r5, @androidx.annotation.ColorRes int r6) {
        /*
            java.lang.Object r0 = sColorStateCacheLock
            monitor-enter(r0)
            java.util.WeakHashMap<androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, android.util.SparseArray<androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry>> r1 = sColorStateCaches     // Catch:{ all -> 0x0032 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0032 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0045
            int r2 = r1.size()     // Catch:{ all -> 0x0032 }
            if (r2 <= 0) goto L_0x0045
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0032 }
            androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry r2 = (androidx.core.content.res.ResourcesCompat.ColorStateListCacheEntry) r2     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0045
            android.content.res.Configuration r3 = r2.mConfiguration     // Catch:{ all -> 0x0032 }
            android.content.res.Resources r4 = r5.mResources     // Catch:{ all -> 0x0032 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0032 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x0042
            android.content.res.Resources$Theme r5 = r5.mTheme     // Catch:{ all -> 0x0032 }
            if (r5 != 0) goto L_0x0034
            int r3 = r2.mThemeHash     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x003e
            goto L_0x0034
        L_0x0032:
            r5 = move-exception
            goto L_0x0048
        L_0x0034:
            if (r5 == 0) goto L_0x0042
            int r3 = r2.mThemeHash     // Catch:{ all -> 0x0032 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x0032 }
            if (r3 != r5) goto L_0x0042
        L_0x003e:
            android.content.res.ColorStateList r5 = r2.mValue     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r5
        L_0x0042:
            r1.remove(r6)     // Catch:{ all -> 0x0032 }
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            r5 = 0
            return r5
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.getCachedColorStateList(androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, int):android.content.res.ColorStateList");
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context context, @FontRes int i5) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i5, new TypedValue(), 0, (FontCallback) null, (Handler) null, false, true);
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i5, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Api23Impl.getColor(resources, i5, theme);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i5, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList cachedColorStateList = getCachedColorStateList(colorStateListCacheKey, i5);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList inflateColorStateList = inflateColorStateList(resources, i5, theme);
        if (inflateColorStateList == null) {
            return Api23Impl.getColorStateList(resources, i5, theme);
        }
        addColorStateListToCache(colorStateListCacheKey, i5, inflateColorStateList, theme);
        return inflateColorStateList;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i5, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.getDrawable(resources, i5, theme);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i5, int i6, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.getDrawableForDensity(resources, i5, i6, theme);
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i5) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getFloat(resources, i5);
        }
        TypedValue typedValue = getTypedValue();
        resources.getValue(i5, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i5) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i5) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i5, new TypedValue(), 0, (FontCallback) null, (Handler) null, false, false);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @Nullable
    private static ColorStateList inflateColorStateList(Resources resources, int i5, @Nullable Resources.Theme theme) {
        if (isColorInt(resources, i5)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i5), theme);
        } catch (Exception e5) {
            Log.w(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e5);
            return null;
        }
    }

    private static boolean isColorInt(@NonNull Resources resources, @ColorRes int i5) {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i5, typedValue, true);
        int i6 = typedValue.type;
        if (i6 < 28 || i6 > 31) {
            return false;
        }
        return true;
    }

    private static Typeface loadFont(@NonNull Context context, int i5, @NonNull TypedValue typedValue, int i6, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z4, boolean z5) {
        Resources resources = context.getResources();
        resources.getValue(i5, typedValue, true);
        Typeface loadFont = loadFont(context, resources, typedValue, i5, i6, fontCallback, handler, z4, z5);
        if (loadFont != null || fontCallback != null || z5) {
            return loadFont;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i5) + " could not be retrieved.");
    }

    public static void getFont(@NonNull Context context, @FontRes int i5, @NonNull FontCallback fontCallback, @Nullable Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
            return;
        }
        loadFont(context, i5, new TypedValue(), 0, fontCallback, handler, false, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface loadFont(@androidx.annotation.NonNull android.content.Context r13, android.content.res.Resources r14, @androidx.annotation.NonNull android.util.TypedValue r15, int r16, int r17, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback r18, @androidx.annotation.Nullable android.os.Handler r19, boolean r20, boolean r21) {
        /*
            r2 = r16
            r7 = r18
            r8 = r19
            java.lang.String r10 = "ResourcesCompat"
            java.lang.CharSequence r0 = r15.string
            if (r0 == 0) goto L_0x00b7
            java.lang.String r3 = r0.toString()
            java.lang.String r0 = "res/"
            boolean r0 = r3.startsWith(r0)
            r11 = 0
            r12 = -3
            if (r0 != 0) goto L_0x0020
            if (r7 == 0) goto L_0x001f
            r7.callbackFailAsync(r12, r8)
        L_0x001f:
            return r11
        L_0x0020:
            int r0 = r15.assetCookie
            r5 = r17
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.findFromCache(r14, r2, r3, r0, r5)
            if (r0 == 0) goto L_0x0030
            if (r7 == 0) goto L_0x002f
            r7.callbackSuccessAsync(r0, r8)
        L_0x002f:
            return r0
        L_0x0030:
            if (r21 == 0) goto L_0x0033
            return r11
        L_0x0033:
            java.lang.String r0 = r3.toLowerCase()     // Catch:{ XmlPullParserException -> 0x0057, IOException -> 0x0054 }
            java.lang.String r1 = ".xml"
            boolean r0 = r0.endsWith(r1)     // Catch:{ XmlPullParserException -> 0x0057, IOException -> 0x0054 }
            if (r0 == 0) goto L_0x0070
            android.content.res.XmlResourceParser r0 = r14.getXml(r2)     // Catch:{ XmlPullParserException -> 0x0057, IOException -> 0x0054 }
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r1 = androidx.core.content.res.FontResourcesParserCompat.parse(r0, r14)     // Catch:{ XmlPullParserException -> 0x0057, IOException -> 0x0054 }
            if (r1 != 0) goto L_0x005b
            java.lang.String r13 = "Failed to find font-family tag"
            android.util.Log.e(r10, r13)     // Catch:{ XmlPullParserException -> 0x0057, IOException -> 0x0054 }
            if (r7 == 0) goto L_0x005a
            r7.callbackFailAsync(r12, r8)     // Catch:{ XmlPullParserException -> 0x0057, IOException -> 0x0054 }
            goto L_0x005a
        L_0x0054:
            r0 = move-exception
        L_0x0055:
            r13 = r0
            goto L_0x0088
        L_0x0057:
            r0 = move-exception
        L_0x0058:
            r13 = r0
            goto L_0x009d
        L_0x005a:
            return r11
        L_0x005b:
            int r5 = r15.assetCookie     // Catch:{ XmlPullParserException -> 0x0057, IOException -> 0x0054 }
            r0 = r13
            r6 = r17
            r9 = r20
            r4 = r3
            r3 = r2
            r2 = r14
            android.graphics.Typeface r13 = androidx.core.graphics.TypefaceCompat.createFromResourcesFamilyXml(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ XmlPullParserException -> 0x006d, IOException -> 0x006a }
            return r13
        L_0x006a:
            r0 = move-exception
            r3 = r4
            goto L_0x0055
        L_0x006d:
            r0 = move-exception
            r3 = r4
            goto L_0x0058
        L_0x0070:
            int r4 = r15.assetCookie     // Catch:{ XmlPullParserException -> 0x0057, IOException -> 0x0054 }
            r0 = r13
            r1 = r14
            r2 = r16
            r5 = r17
            android.graphics.Typeface r13 = androidx.core.graphics.TypefaceCompat.createFromResourcesFontFile(r0, r1, r2, r3, r4, r5)     // Catch:{ XmlPullParserException -> 0x0057, IOException -> 0x0054 }
            if (r7 == 0) goto L_0x0087
            if (r13 == 0) goto L_0x0084
            r7.callbackSuccessAsync(r13, r8)     // Catch:{ XmlPullParserException -> 0x0057, IOException -> 0x0054 }
            return r13
        L_0x0084:
            r7.callbackFailAsync(r12, r8)     // Catch:{ XmlPullParserException -> 0x0057, IOException -> 0x0054 }
        L_0x0087:
            return r13
        L_0x0088:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Failed to read xml resource "
            r14.append(r15)
            r14.append(r3)
            java.lang.String r14 = r14.toString()
            android.util.Log.e(r10, r14, r13)
            goto L_0x00b1
        L_0x009d:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Failed to parse xml resource "
            r14.append(r15)
            r14.append(r3)
            java.lang.String r14 = r14.toString()
            android.util.Log.e(r10, r14, r13)
        L_0x00b1:
            if (r7 == 0) goto L_0x00b6
            r7.callbackFailAsync(r12, r8)
        L_0x00b6:
            return r11
        L_0x00b7:
            android.content.res.Resources$NotFoundException r13 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Resource \""
            r0.append(r3)
            java.lang.String r14 = r14.getResourceName(r2)
            r0.append(r14)
            java.lang.String r14 = "\" ("
            r0.append(r14)
            java.lang.String r14 = java.lang.Integer.toHexString(r2)
            r0.append(r14)
            java.lang.String r14 = ") is not a Font: "
            r0.append(r14)
            r0.append(r15)
            java.lang.String r14 = r0.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.loadFont(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i5, @NonNull TypedValue typedValue, int i6, @Nullable FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i5, typedValue, i6, fontCallback, (Handler) null, true, false);
    }
}
