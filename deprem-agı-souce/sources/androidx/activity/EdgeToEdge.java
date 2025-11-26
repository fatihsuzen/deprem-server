package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import androidx.annotation.VisibleForTesting;
import k3.l;
import kotlin.jvm.internal.t;

public final class EdgeToEdge {
    private static final int DefaultDarkScrim = Color.argb(128, 27, 27, 27);
    private static final int DefaultLightScrim = Color.argb(230, 255, 255, 255);
    private static EdgeToEdgeImpl Impl;

    public static final void enable(ComponentActivity componentActivity) {
        t.e(componentActivity, "<this>");
        enable$default(componentActivity, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
    }

    public static /* synthetic */ void enable$default(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, (l) null, 4, (Object) null);
        }
        if ((i5 & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, DefaultLightScrim, DefaultDarkScrim, (l) null, 4, (Object) null);
        }
        enable(componentActivity, systemBarStyle, systemBarStyle2);
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle) {
        t.e(componentActivity, "<this>");
        t.e(systemBarStyle, "statusBarStyle");
        enable$default(componentActivity, systemBarStyle, (SystemBarStyle) null, 2, (Object) null);
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2) {
        t.e(componentActivity, "<this>");
        t.e(systemBarStyle, "statusBarStyle");
        t.e(systemBarStyle2, "navigationBarStyle");
        View decorView = componentActivity.getWindow().getDecorView();
        t.d(decorView, "window.decorView");
        l detectDarkMode$activity_release = systemBarStyle.getDetectDarkMode$activity_release();
        Resources resources = decorView.getResources();
        t.d(resources, "view.resources");
        boolean booleanValue = ((Boolean) detectDarkMode$activity_release.invoke(resources)).booleanValue();
        l detectDarkMode$activity_release2 = systemBarStyle2.getDetectDarkMode$activity_release();
        Resources resources2 = decorView.getResources();
        t.d(resources2, "view.resources");
        boolean booleanValue2 = ((Boolean) detectDarkMode$activity_release2.invoke(resources2)).booleanValue();
        EdgeToEdgeImpl edgeToEdgeImpl = Impl;
        if (edgeToEdgeImpl == null) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 29) {
                edgeToEdgeImpl = new EdgeToEdgeApi29();
            } else if (i5 >= 26) {
                edgeToEdgeImpl = new EdgeToEdgeApi26();
            } else {
                edgeToEdgeImpl = new EdgeToEdgeApi23();
            }
        }
        EdgeToEdgeImpl edgeToEdgeImpl2 = edgeToEdgeImpl;
        Window window = componentActivity.getWindow();
        t.d(window, "window");
        edgeToEdgeImpl2.setUp(systemBarStyle, systemBarStyle2, window, decorView, booleanValue, booleanValue2);
    }
}
