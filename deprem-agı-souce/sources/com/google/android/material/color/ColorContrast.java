package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.app.UiModeManager$ContrastChangeListener;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import java.util.LinkedHashSet;
import java.util.Set;

public class ColorContrast {
    private static final float HIGH_CONTRAST_THRESHOLD = 0.6666667f;
    private static final float MEDIUM_CONTRAST_THRESHOLD = 0.33333334f;

    @RequiresApi(34)
    private static class ColorContrastActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        /* access modifiers changed from: private */
        public final Set<Activity> activitiesInStack = new LinkedHashSet();
        private final ColorContrastOptions colorContrastOptions;
        @Nullable
        private UiModeManager$ContrastChangeListener contrastChangeListener;

        ColorContrastActivityLifecycleCallbacks(ColorContrastOptions colorContrastOptions2) {
            this.colorContrastOptions = colorContrastOptions2;
        }

        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        public void onActivityDestroyed(@NonNull Activity activity) {
            this.activitiesInStack.remove(activity);
            UiModeManager uiModeManager = (UiModeManager) activity.getSystemService("uimode");
            if (uiModeManager != null && this.contrastChangeListener != null && this.activitiesInStack.isEmpty()) {
                uiModeManager.removeContrastChangeListener(this.contrastChangeListener);
                this.contrastChangeListener = null;
            }
        }

        public void onActivityPaused(@NonNull Activity activity) {
        }

        public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            UiModeManager uiModeManager = (UiModeManager) activity.getSystemService("uimode");
            if (uiModeManager != null && this.activitiesInStack.isEmpty() && this.contrastChangeListener == null) {
                this.contrastChangeListener = new UiModeManager$ContrastChangeListener() {
                    public void onContrastChanged(float f5) {
                        for (Activity recreate : ColorContrastActivityLifecycleCallbacks.this.activitiesInStack) {
                            recreate.recreate();
                        }
                    }
                };
                uiModeManager.addContrastChangeListener(ContextCompat.getMainExecutor(activity.getApplicationContext()), this.contrastChangeListener);
            }
            this.activitiesInStack.add(activity);
            if (uiModeManager != null) {
                ColorContrast.applyToActivityIfAvailable(activity, this.colorContrastOptions);
            }
        }

        public void onActivityResumed(@NonNull Activity activity) {
        }

        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        public void onActivityStarted(@NonNull Activity activity) {
        }

        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    private ColorContrast() {
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application, @NonNull ColorContrastOptions colorContrastOptions) {
        if (isContrastAvailable()) {
            application.registerActivityLifecycleCallbacks(new ColorContrastActivityLifecycleCallbacks(colorContrastOptions));
        }
    }

    public static void applyToActivityIfAvailable(@NonNull Activity activity, @NonNull ColorContrastOptions colorContrastOptions) {
        int contrastThemeOverlayResourceId;
        if (isContrastAvailable() && (contrastThemeOverlayResourceId = getContrastThemeOverlayResourceId(activity, colorContrastOptions)) != 0) {
            ThemeUtils.applyThemeOverlay(activity, contrastThemeOverlayResourceId);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getContrastThemeOverlayResourceId(android.content.Context r3, com.google.android.material.color.ColorContrastOptions r4) {
        /*
            java.lang.String r0 = "uimode"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.app.UiModeManager r3 = (android.app.UiModeManager) r3
            boolean r0 = isContrastAvailable()
            r1 = 0
            if (r0 == 0) goto L_0x0033
            if (r3 != 0) goto L_0x0012
            goto L_0x0033
        L_0x0012:
            float r3 = r3.getContrast()
            int r0 = r4.getMediumContrastThemeOverlay()
            int r4 = r4.getHighContrastThemeOverlay()
            r2 = 1059760811(0x3f2aaaab, float:0.6666667)
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0028
            if (r4 != 0) goto L_0x0031
            goto L_0x0032
        L_0x0028:
            r2 = 1051372203(0x3eaaaaab, float:0.33333334)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 < 0) goto L_0x0033
            if (r0 != 0) goto L_0x0032
        L_0x0031:
            return r4
        L_0x0032:
            return r0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.ColorContrast.getContrastThemeOverlayResourceId(android.content.Context, com.google.android.material.color.ColorContrastOptions):int");
    }

    @ChecksSdkIntAtLeast(api = 34)
    public static boolean isContrastAvailable() {
        if (Build.VERSION.SDK_INT >= 34) {
            return true;
        }
        return false;
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context context, @NonNull ColorContrastOptions colorContrastOptions) {
        int contrastThemeOverlayResourceId;
        if (isContrastAvailable() && (contrastThemeOverlayResourceId = getContrastThemeOverlayResourceId(context, colorContrastOptions)) != 0) {
            return new ContextThemeWrapper(context, contrastThemeOverlayResourceId);
        }
        return context;
    }
}
