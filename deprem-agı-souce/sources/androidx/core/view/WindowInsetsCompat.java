package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import j$.util.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class WindowInsetsCompat {
    @NonNull
    public static final WindowInsetsCompat CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    @RequiresApi(21)
    @SuppressLint({"SoonBlockedPrivateApi"})
    static class Api21ReflectionHolder {
        private static Field sContentInsets;
        private static boolean sReflectionSucceeded = true;
        private static Field sStableInsets;
        private static Field sViewAttachInfoField;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                sViewAttachInfoField = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                sStableInsets = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                sContentInsets = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e5) {
                Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets from AttachInfo " + e5.getMessage(), e5);
            }
        }

        private Api21ReflectionHolder() {
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
            if (sReflectionSucceeded && view.isAttachedToWindow()) {
                try {
                    Object obj = sViewAttachInfoField.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) sStableInsets.get(obj);
                        Rect rect2 = (Rect) sContentInsets.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            WindowInsetsCompat build = new Builder().setStableInsets(Insets.of(rect)).setSystemWindowInsets(Insets.of(rect2)).build();
                            build.setRootWindowInsets(build);
                            build.copyRootViewBounds(view.getRootView());
                            return build;
                        }
                    }
                } catch (IllegalAccessException e5) {
                    Log.w(WindowInsetsCompat.TAG, "Failed to get insets from AttachInfo. " + e5.getMessage(), e5);
                }
            }
            return null;
        }
    }

    private static class BuilderImpl {
        private final WindowInsetsCompat mInsets;
        Insets[] mInsetsTypeMask;

        BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        /* access modifiers changed from: protected */
        public final void applyInsetTypes() {
            Insets[] insetsArr = this.mInsetsTypeMask;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.indexOf(1)];
                Insets insets2 = this.mInsetsTypeMask[Type.indexOf(2)];
                if (insets2 == null) {
                    insets2 = this.mInsets.getInsets(2);
                }
                if (insets == null) {
                    insets = this.mInsets.getInsets(1);
                }
                setSystemWindowInsets(Insets.max(insets, insets2));
                Insets insets3 = this.mInsetsTypeMask[Type.indexOf(16)];
                if (insets3 != null) {
                    setSystemGestureInsets(insets3);
                }
                Insets insets4 = this.mInsetsTypeMask[Type.indexOf(32)];
                if (insets4 != null) {
                    setMandatorySystemGestureInsets(insets4);
                }
                Insets insets5 = this.mInsetsTypeMask[Type.indexOf(64)];
                if (insets5 != null) {
                    setTappableElementInsets(insets5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat build() {
            applyInsetTypes();
            return this.mInsets;
        }

        /* access modifiers changed from: package-private */
        public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        }

        /* access modifiers changed from: package-private */
        public void setInsets(int i5, @NonNull Insets insets) {
            if (this.mInsetsTypeMask == null) {
                this.mInsetsTypeMask = new Insets[9];
            }
            for (int i6 = 1; i6 <= 256; i6 <<= 1) {
                if ((i5 & i6) != 0) {
                    this.mInsetsTypeMask[Type.indexOf(i6)] = insets;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setInsetsIgnoringVisibility(int i5, @NonNull Insets insets) {
            if (i5 == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        /* access modifiers changed from: package-private */
        public void setMandatorySystemGestureInsets(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void setStableInsets(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void setSystemGestureInsets(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void setSystemWindowInsets(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void setTappableElementInsets(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void setVisible(int i5, boolean z4) {
        }

        BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.mInsets = windowInsetsCompat;
        }
    }

    @RequiresApi(30)
    private static class BuilderImpl30 extends BuilderImpl29 {
        BuilderImpl30() {
        }

        /* access modifiers changed from: package-private */
        public void setInsets(int i5, @NonNull Insets insets) {
            WindowInsets.Builder unused = this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(i5), insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setInsetsIgnoringVisibility(int i5, @NonNull Insets insets) {
            WindowInsets.Builder unused = this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl30.toPlatformType(i5), insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setVisible(int i5, boolean z4) {
            WindowInsets.Builder unused = this.mPlatBuilder.setVisible(TypeImpl30.toPlatformType(i5), z4);
        }

        BuilderImpl30(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    private static class Impl {
        @NonNull
        static final WindowInsetsCompat CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        final WindowInsetsCompat mHost;

        Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.mHost = windowInsetsCompat;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        /* access modifiers changed from: package-private */
        public void copyRootViewBounds(@NonNull View view) {
        }

        /* access modifiers changed from: package-private */
        public void copyWindowDataInto(@NonNull WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            if (isRound() != impl.isRound() || isConsumed() != impl.isConsumed() || !ObjectsCompat.equals(getSystemWindowInsets(), impl.getSystemWindowInsets()) || !ObjectsCompat.equals(getStableInsets(), impl.getStableInsets()) || !ObjectsCompat.equals(getDisplayCutout(), impl.getDisplayCutout())) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets getInsets(int i5) {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets getInsetsIgnoringVisibility(int i5) {
            if ((i5 & 8) == 0) {
                return Insets.NONE;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets getStableInsets() {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat inset(int i5, int i6, int i7, int i8) {
            return CONSUMED;
        }

        /* access modifiers changed from: package-private */
        public boolean isConsumed() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isRound() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isVisible(int i5) {
            return true;
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
        }

        /* access modifiers changed from: package-private */
        public void setRootViewData(@NonNull Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        }

        public void setStableInsets(Insets insets) {
        }
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {
        private static Class<?> sAttachInfoClass = null;
        private static Field sAttachInfoField = null;
        private static Method sGetViewRootImplMethod = null;
        private static Field sVisibleInsetsField = null;
        private static boolean sVisibleRectReflectionFetched = false;
        private Insets[] mOverriddenInsets;
        @NonNull
        final WindowInsets mPlatformInsets;
        Insets mRootViewVisibleInsets;
        private WindowInsetsCompat mRootWindowInsets;
        private Insets mSystemWindowInsets;

        Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = windowInsets;
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.getStableInsets();
            }
            return Insets.NONE;
        }

        @Nullable
        private Insets getVisibleInsets(@NonNull View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!sVisibleRectReflectionFetched) {
                    loadReflectionField();
                }
                Method method = sGetViewRootImplMethod;
                if (!(method == null || sAttachInfoClass == null || sVisibleInsetsField == null)) {
                    try {
                        Object invoke = method.invoke(view, (Object[]) null);
                        if (invoke == null) {
                            Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(invoke));
                        if (rect != null) {
                            return Insets.of(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e5) {
                        Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void loadReflectionField() {
            try {
                sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", (Class[]) null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                sAttachInfoClass = cls;
                sVisibleInsetsField = cls.getDeclaredField("mVisibleInsets");
                sAttachInfoField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                sVisibleInsetsField.setAccessible(true);
                sAttachInfoField.setAccessible(true);
            } catch (ReflectiveOperationException e5) {
                Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
            }
            sVisibleRectReflectionFetched = true;
        }

        /* access modifiers changed from: package-private */
        public void copyRootViewBounds(@NonNull View view) {
            Insets visibleInsets = getVisibleInsets(view);
            if (visibleInsets == null) {
                visibleInsets = Insets.NONE;
            }
            setRootViewData(visibleInsets);
        }

        /* access modifiers changed from: package-private */
        public void copyWindowDataInto(@NonNull WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.setRootWindowInsets(this.mRootWindowInsets);
            windowInsetsCompat.setRootViewData(this.mRootViewVisibleInsets);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) obj).mRootViewVisibleInsets);
        }

        @NonNull
        public Insets getInsets(int i5) {
            return getInsets(i5, false);
        }

        /* access modifiers changed from: protected */
        @NonNull
        public Insets getInsetsForType(int i5, boolean z4) {
            int i6;
            DisplayCutoutCompat displayCutoutCompat;
            if (i5 != 1) {
                Insets insets = null;
                if (i5 != 2) {
                    if (i5 == 8) {
                        Insets[] insetsArr = this.mOverriddenInsets;
                        if (insetsArr != null) {
                            insets = insetsArr[Type.indexOf(8)];
                        }
                        if (insets != null) {
                            return insets;
                        }
                        Insets systemWindowInsets = getSystemWindowInsets();
                        Insets rootStableInsets = getRootStableInsets();
                        int i7 = systemWindowInsets.bottom;
                        if (i7 > rootStableInsets.bottom) {
                            return Insets.of(0, 0, 0, i7);
                        }
                        Insets insets2 = this.mRootViewVisibleInsets;
                        if (insets2 == null || insets2.equals(Insets.NONE) || (i6 = this.mRootViewVisibleInsets.bottom) <= rootStableInsets.bottom) {
                            return Insets.NONE;
                        }
                        return Insets.of(0, 0, 0, i6);
                    } else if (i5 == 16) {
                        return getSystemGestureInsets();
                    } else {
                        if (i5 == 32) {
                            return getMandatorySystemGestureInsets();
                        }
                        if (i5 == 64) {
                            return getTappableElementInsets();
                        }
                        if (i5 != 128) {
                            return Insets.NONE;
                        }
                        WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
                        if (windowInsetsCompat != null) {
                            displayCutoutCompat = windowInsetsCompat.getDisplayCutout();
                        } else {
                            displayCutoutCompat = getDisplayCutout();
                        }
                        if (displayCutoutCompat != null) {
                            return Insets.of(displayCutoutCompat.getSafeInsetLeft(), displayCutoutCompat.getSafeInsetTop(), displayCutoutCompat.getSafeInsetRight(), displayCutoutCompat.getSafeInsetBottom());
                        }
                        return Insets.NONE;
                    }
                } else if (z4) {
                    Insets rootStableInsets2 = getRootStableInsets();
                    Insets stableInsets = getStableInsets();
                    return Insets.of(Math.max(rootStableInsets2.left, stableInsets.left), 0, Math.max(rootStableInsets2.right, stableInsets.right), Math.max(rootStableInsets2.bottom, stableInsets.bottom));
                } else {
                    Insets systemWindowInsets2 = getSystemWindowInsets();
                    WindowInsetsCompat windowInsetsCompat2 = this.mRootWindowInsets;
                    if (windowInsetsCompat2 != null) {
                        insets = windowInsetsCompat2.getStableInsets();
                    }
                    int i8 = systemWindowInsets2.bottom;
                    if (insets != null) {
                        i8 = Math.min(i8, insets.bottom);
                    }
                    return Insets.of(systemWindowInsets2.left, 0, systemWindowInsets2.right, i8);
                }
            } else if (z4) {
                return Insets.of(0, Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0);
            } else {
                return Insets.of(0, getSystemWindowInsets().top, 0, 0);
            }
        }

        @NonNull
        public Insets getInsetsIgnoringVisibility(int i5) {
            return getInsets(i5, true);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets == null) {
                this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat inset(int i5, int i6, int i7, int i8) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), i5, i6, i7, i8));
            builder.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), i5, i6, i7, i8));
            return builder.build();
        }

        /* access modifiers changed from: package-private */
        public boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        /* access modifiers changed from: protected */
        public boolean isTypeVisible(int i5) {
            if (!(i5 == 1 || i5 == 2)) {
                if (i5 == 4) {
                    return false;
                }
                if (!(i5 == 8 || i5 == 128)) {
                    return true;
                }
            }
            return !getInsetsForType(i5, false).equals(Insets.NONE);
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean isVisible(int i5) {
            for (int i6 = 1; i6 <= 256; i6 <<= 1) {
                if ((i5 & i6) != 0 && !isTypeVisible(i6)) {
                    return false;
                }
            }
            return true;
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
            this.mOverriddenInsets = insetsArr;
        }

        /* access modifiers changed from: package-private */
        public void setRootViewData(@NonNull Insets insets) {
            this.mRootViewVisibleInsets = insets;
        }

        /* access modifiers changed from: package-private */
        public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
            this.mRootWindowInsets = windowInsetsCompat;
        }

        @SuppressLint({"WrongConstant"})
        @NonNull
        private Insets getInsets(int i5, boolean z4) {
            Insets insets = Insets.NONE;
            for (int i6 = 1; i6 <= 256; i6 <<= 1) {
                if ((i5 & i6) != 0) {
                    insets = Insets.max(insets, getInsetsForType(i6, z4));
                }
            }
            return insets;
        }

        Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.mPlatformInsets));
        }
    }

    @RequiresApi(28)
    private static class Impl28 extends Impl21 {
        Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            if (!Objects.equals(this.mPlatformInsets, impl28.mPlatformInsets) || !Objects.equals(this.mRootViewVisibleInsets, impl28.mRootViewVisibleInsets)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }

        Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl28 impl28) {
            super(windowInsetsCompat, (Impl21) impl28);
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl29 {
        @NonNull
        static final WindowInsetsCompat CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

        Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public final void copyRootViewBounds(@NonNull View view) {
        }

        @NonNull
        public Insets getInsets(int i5) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(i5)));
        }

        @NonNull
        public Insets getInsetsIgnoringVisibility(int i5) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(i5)));
        }

        public boolean isVisible(int i5) {
            return this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(i5));
        }

        Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl30 impl30) {
            super(windowInsetsCompat, (Impl29) impl30);
        }
    }

    public static final class Type {
        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 256;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 9;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface InsetsType {
        }

        private Type() {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        static int indexOf(int i5) {
            if (i5 == 1) {
                return 0;
            }
            if (i5 == 2) {
                return 1;
            }
            if (i5 == 4) {
                return 2;
            }
            if (i5 == 8) {
                return 3;
            }
            if (i5 == 16) {
                return 4;
            }
            if (i5 == 32) {
                return 5;
            }
            if (i5 == 64) {
                return 6;
            }
            if (i5 == 128) {
                return 7;
            }
            if (i5 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i5);
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    @RequiresApi(30)
    private static final class TypeImpl30 {
        private TypeImpl30() {
        }

        static int toPlatformType(int i5) {
            int a5;
            int i6 = 0;
            for (int i7 = 1; i7 <= 256; i7 <<= 1) {
                if ((i5 & i7) != 0) {
                    if (i7 == 1) {
                        a5 = WindowInsets.Type.statusBars();
                    } else if (i7 == 2) {
                        a5 = WindowInsets.Type.navigationBars();
                    } else if (i7 == 4) {
                        a5 = WindowInsets.Type.captionBar();
                    } else if (i7 == 8) {
                        a5 = WindowInsets.Type.ime();
                    } else if (i7 == 16) {
                        a5 = WindowInsets.Type.systemGestures();
                    } else if (i7 == 32) {
                        a5 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i7 == 64) {
                        a5 = WindowInsets.Type.tappableElement();
                    } else if (i7 == 128) {
                        a5 = WindowInsets.Type.displayCutout();
                    }
                    i6 |= a5;
                }
            }
            return i6;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = Impl30.CONSUMED;
        } else {
            CONSUMED = Impl.CONSUMED;
        }
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            this.mImpl = new Impl30(this, windowInsets);
        } else if (i5 >= 29) {
            this.mImpl = new Impl29(this, windowInsets);
        } else if (i5 >= 28) {
            this.mImpl = new Impl28(this, windowInsets);
        } else {
            this.mImpl = new Impl21(this, windowInsets);
        }
    }

    static Insets insetInsets(@NonNull Insets insets, int i5, int i6, int i7, int i8) {
        int max = Math.max(0, insets.left - i5);
        int max2 = Math.max(0, insets.top - i6);
        int max3 = Math.max(0, insets.right - i7);
        int max4 = Math.max(0, insets.bottom - i8);
        if (max == i5 && max2 == i6 && max3 == i7 && max4 == i8) {
            return insets;
        }
        return Insets.of(max, max2, max3, max4);
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, (View) null);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    /* access modifiers changed from: package-private */
    public void copyRootViewBounds(@NonNull View view) {
        this.mImpl.copyRootViewBounds(view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    @NonNull
    public Insets getInsets(int i5) {
        return this.mImpl.getInsets(i5);
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int i5) {
        return this.mImpl.getInsetsIgnoringVisibility(i5);
    }

    @NonNull
    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    @NonNull
    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @NonNull
    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    @NonNull
    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @NonNull
    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        Insets insets = getInsets(Type.all());
        Insets insets2 = Insets.NONE;
        if (!insets.equals(insets2) || !getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(insets2) || getDisplayCutout() != null) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.getStableInsets().equals(Insets.NONE);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.getSystemWindowInsets().equals(Insets.NONE);
    }

    public int hashCode() {
        Impl impl = this.mImpl;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int i5) {
        return this.mImpl.isVisible(i5);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i5, int i6, int i7, int i8) {
        return new Builder(this).setSystemWindowInsets(Insets.of(i5, i6, i7, i8)).build();
    }

    /* access modifiers changed from: package-private */
    public void setOverriddenInsets(Insets[] insetsArr) {
        this.mImpl.setOverriddenInsets(insetsArr);
    }

    /* access modifiers changed from: package-private */
    public void setRootViewData(@NonNull Insets insets) {
        this.mImpl.setRootViewData(insets);
    }

    /* access modifiers changed from: package-private */
    public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.setRootWindowInsets(windowInsetsCompat);
    }

    /* access modifiers changed from: package-private */
    public void setStableInsets(@Nullable Insets insets) {
        this.mImpl.setStableInsets(insets);
    }

    @RequiresApi(20)
    @Nullable
    public WindowInsets toWindowInsets() {
        Impl impl = this.mImpl;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).mPlatformInsets;
        }
        return null;
    }

    @RequiresApi(api = 20)
    private static class BuilderImpl20 extends BuilderImpl {
        private static Constructor<WindowInsets> sConstructor = null;
        private static boolean sConstructorFetched = false;
        private static Field sConsumedField = null;
        private static boolean sConsumedFieldFetched = false;
        private WindowInsets mPlatformInsets;
        private Insets mStableInsets;

        BuilderImpl20() {
            this.mPlatformInsets = createWindowInsetsInstance();
        }

        @Nullable
        private static WindowInsets createWindowInsetsInstance() {
            Class<WindowInsets> cls = WindowInsets.class;
            if (!sConsumedFieldFetched) {
                try {
                    sConsumedField = cls.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e5) {
                    Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets.CONSUMED field", e5);
                }
                sConsumedFieldFetched = true;
            }
            Field field = sConsumedField;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e6) {
                    Log.i(WindowInsetsCompat.TAG, "Could not get value from WindowInsets.CONSUMED field", e6);
                }
            }
            if (!sConstructorFetched) {
                try {
                    sConstructor = cls.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e7) {
                    Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets(Rect) constructor", e7);
                }
                sConstructorFetched = true;
            }
            Constructor<WindowInsets> constructor = sConstructor;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e8) {
                    Log.i(WindowInsetsCompat.TAG, "Could not invoke WindowInsets(Rect) constructor", e8);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            windowInsetsCompat.setStableInsets(this.mStableInsets);
            return windowInsetsCompat;
        }

        /* access modifiers changed from: package-private */
        public void setStableInsets(@Nullable Insets insets) {
            this.mStableInsets = insets;
        }

        /* access modifiers changed from: package-private */
        public void setSystemWindowInsets(@NonNull Insets insets) {
            WindowInsets windowInsets = this.mPlatformInsets;
            if (windowInsets != null) {
                this.mPlatformInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        BuilderImpl20(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.mPlatformInsets = windowInsetsCompat.toWindowInsets();
        }
    }

    @RequiresApi(api = 29)
    private static class BuilderImpl29 extends BuilderImpl {
        final WindowInsets.Builder mPlatBuilder;

        BuilderImpl29() {
            this.mPlatBuilder = C0367t0.a();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            return windowInsetsCompat;
        }

        /* access modifiers changed from: package-private */
        public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            DisplayCutout displayCutout;
            WindowInsets.Builder builder = this.mPlatBuilder;
            if (displayCutoutCompat != null) {
                displayCutout = displayCutoutCompat.unwrap();
            } else {
                displayCutout = null;
            }
            WindowInsets.Builder unused = builder.setDisplayCutout(displayCutout);
        }

        /* access modifiers changed from: package-private */
        public void setMandatorySystemGestureInsets(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setStableInsets(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setSystemGestureInsets(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setSystemWindowInsets(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setTappableElementInsets(@NonNull Insets insets) {
            WindowInsets.Builder unused = this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
        }

        BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder builder;
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                builder = C0365s0.a(windowInsets);
            } else {
                builder = C0367t0.a();
            }
            this.mPlatBuilder = builder;
        }
    }

    @RequiresApi(21)
    private static class Impl21 extends Impl20 {
        private Insets mStableInsets = null;

        Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public final Insets getStableInsets() {
            if (this.mStableInsets == null) {
                this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        /* access modifiers changed from: package-private */
        public boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        public void setStableInsets(@Nullable Insets insets) {
            this.mStableInsets = insets;
        }

        Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl21 impl21) {
            super(windowInsetsCompat, (Impl20) impl21);
            this.mStableInsets = impl21.mStableInsets;
        }
    }

    @RequiresApi(20)
    @NonNull
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets, @Nullable View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            windowInsetsCompat.setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i5, @IntRange(from = 0) int i6, @IntRange(from = 0) int i7, @IntRange(from = 0) int i8) {
        return this.mImpl.inset(i5, i6, i7, i8);
    }

    @RequiresApi(29)
    private static class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets = null;
        private Insets mSystemGestureInsets = null;
        private Insets mTappableElementInsets = null;

        Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets == null) {
                this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
            }
            return this.mMandatorySystemGestureInsets;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets == null) {
                this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
            }
            return this.mSystemGestureInsets;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Insets getTappableElementInsets() {
            if (this.mTappableElementInsets == null) {
                this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
            }
            return this.mTappableElementInsets;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public WindowInsetsCompat inset(int i5, int i6, int i7, int i8) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(i5, i6, i7, i8));
        }

        public void setStableInsets(@Nullable Insets insets) {
        }

        Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl29 impl29) {
            super(windowInsetsCompat, (Impl28) impl29);
        }
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.of(rect)).build();
    }

    public static final class Builder {
        private final BuilderImpl mImpl;

        public Builder() {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 30) {
                this.mImpl = new BuilderImpl30();
            } else if (i5 >= 29) {
                this.mImpl = new BuilderImpl29();
            } else {
                this.mImpl = new BuilderImpl20();
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.mImpl.setDisplayCutout(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder setInsets(int i5, @NonNull Insets insets) {
            this.mImpl.setInsets(i5, insets);
            return this;
        }

        @NonNull
        public Builder setInsetsIgnoringVisibility(int i5, @NonNull Insets insets) {
            this.mImpl.setInsetsIgnoringVisibility(i5, insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.setMandatorySystemGestureInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setStableInsets(@NonNull Insets insets) {
            this.mImpl.setStableInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.setSystemGestureInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            this.mImpl.setSystemWindowInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            this.mImpl.setTappableElementInsets(insets);
            return this;
        }

        @NonNull
        public Builder setVisible(int i5, boolean z4) {
            this.mImpl.setVisible(i5, z4);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 30) {
                this.mImpl = new BuilderImpl30(windowInsetsCompat);
            } else if (i5 >= 29) {
                this.mImpl = new BuilderImpl29(windowInsetsCompat);
            } else {
                this.mImpl = new BuilderImpl20(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.mImpl;
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 30 && (impl instanceof Impl30)) {
                this.mImpl = new Impl30(this, (Impl30) impl);
            } else if (i5 >= 29 && (impl instanceof Impl29)) {
                this.mImpl = new Impl29(this, (Impl29) impl);
            } else if (i5 >= 28 && (impl instanceof Impl28)) {
                this.mImpl = new Impl28(this, (Impl28) impl);
            } else if (impl instanceof Impl21) {
                this.mImpl = new Impl21(this, (Impl21) impl);
            } else if (impl instanceof Impl20) {
                this.mImpl = new Impl20(this, (Impl20) impl);
            } else {
                this.mImpl = new Impl(this);
            }
            impl.copyWindowDataInto(this);
            return;
        }
        this.mImpl = new Impl(this);
    }
}
