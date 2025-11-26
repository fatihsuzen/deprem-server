package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.t;

public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public static final WindowMetricsCalculatorCompat INSTANCE = new WindowMetricsCalculatorCompat();
    private static final String TAG;

    static {
        String simpleName = WindowMetricsCalculatorCompat.class.getSimpleName();
        t.d(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        TAG = simpleName;
    }

    private WindowMetricsCalculatorCompat() {
    }

    @RequiresApi(28)
    @SuppressLint({"BanUncheckedReflection"})
    private final DisplayCutout getCutoutForDisplay(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor((Class[]) null);
            constructor.setAccessible(true);
            Object newInstance = constructor.newInstance((Object[]) null);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", new Class[]{newInstance.getClass()});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, new Object[]{newInstance});
            Field declaredField = newInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(newInstance);
            if (m.a(obj)) {
                return n.a(obj);
            }
        } catch (ClassNotFoundException e5) {
            Log.w(TAG, e5);
        } catch (NoSuchMethodException e6) {
            Log.w(TAG, e6);
        } catch (NoSuchFieldException e7) {
            Log.w(TAG, e7);
        } catch (IllegalAccessException e8) {
            Log.w(TAG, e8);
        } catch (InvocationTargetException e9) {
            Log.w(TAG, e9);
        } catch (InstantiationException e10) {
            Log.w(TAG, e10);
        }
        return null;
    }

    private final int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final void getRectSizeFromDisplay(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }

    public WindowMetrics computeCurrentWindowMetrics(Activity activity) {
        Rect rect;
        t.e(activity, "activity");
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            rect = ActivityCompatHelperApi30.INSTANCE.currentWindowBounds(activity);
        } else if (i5 >= 29) {
            rect = computeWindowBoundsQ$window_release(activity);
        } else if (i5 >= 28) {
            rect = computeWindowBoundsP$window_release(activity);
        } else if (i5 >= 24) {
            rect = computeWindowBoundsN$window_release(activity);
        } else {
            rect = computeWindowBoundsIceCreamSandwich$window_release(activity);
        }
        return new WindowMetrics(rect);
    }

    public WindowMetrics computeMaximumWindowMetrics(Activity activity) {
        Rect rect;
        t.e(activity, "activity");
        if (Build.VERSION.SDK_INT >= 30) {
            rect = ActivityCompatHelperApi30.INSTANCE.maximumWindowBounds(activity);
        } else {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            t.d(defaultDisplay, "display");
            Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
            rect = new Rect(0, 0, realSizeForDisplay$window_release.x, realSizeForDisplay$window_release.y);
        }
        return new WindowMetrics(rect);
    }

    @RequiresApi(14)
    public final Rect computeWindowBoundsIceCreamSandwich$window_release(Activity activity) {
        int i5;
        t.e(activity, "activity");
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        t.d(defaultDisplay, "defaultDisplay");
        Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
        Rect rect = new Rect();
        int i6 = realSizeForDisplay$window_release.x;
        if (i6 == 0 || (i5 = realSizeForDisplay$window_release.y) == 0) {
            defaultDisplay.getRectSize(rect);
            return rect;
        }
        rect.right = i6;
        rect.bottom = i5;
        return rect;
    }

    @RequiresApi(24)
    public final Rect computeWindowBoundsN$window_release(Activity activity) {
        t.e(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
            t.d(defaultDisplay, "defaultDisplay");
            Point realSizeForDisplay$window_release = getRealSizeForDisplay$window_release(defaultDisplay);
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i5 = rect.bottom;
            if (i5 + navigationBarHeight == realSizeForDisplay$window_release.y) {
                rect.bottom = i5 + navigationBarHeight;
                return rect;
            }
            int i6 = rect.right;
            if (i6 + navigationBarHeight == realSizeForDisplay$window_release.x) {
                rect.right = i6 + navigationBarHeight;
            }
        }
        return rect;
    }

    @RequiresApi(28)
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    public final Rect computeWindowBoundsP$window_release(Activity activity) {
        DisplayCutout cutoutForDisplay;
        t.e(activity, "activity");
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity)) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", (Class[]) null).invoke(obj, (Object[]) null);
                if (invoke != null) {
                    rect.set((Rect) invoke);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", (Class[]) null).invoke(obj, (Object[]) null);
                if (invoke2 != null) {
                    rect.set((Rect) invoke2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
                }
            }
        } catch (NoSuchFieldException e5) {
            Log.w(TAG, e5);
            getRectSizeFromDisplay(activity, rect);
        } catch (NoSuchMethodException e6) {
            Log.w(TAG, e6);
            getRectSizeFromDisplay(activity, rect);
        } catch (IllegalAccessException e7) {
            Log.w(TAG, e7);
            getRectSizeFromDisplay(activity, rect);
        } catch (InvocationTargetException e8) {
            Log.w(TAG, e8);
            getRectSizeFromDisplay(activity, rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        DisplayCompatHelperApi17 displayCompatHelperApi17 = DisplayCompatHelperApi17.INSTANCE;
        t.d(defaultDisplay, "currentDisplay");
        displayCompatHelperApi17.getRealSize(defaultDisplay, point);
        ActivityCompatHelperApi24 activityCompatHelperApi24 = ActivityCompatHelperApi24.INSTANCE;
        if (!activityCompatHelperApi24.isInMultiWindowMode(activity)) {
            int navigationBarHeight = getNavigationBarHeight(activity);
            int i5 = rect.bottom;
            if (i5 + navigationBarHeight == point.y) {
                rect.bottom = i5 + navigationBarHeight;
            } else {
                int i6 = rect.right;
                if (i6 + navigationBarHeight == point.x) {
                    rect.right = i6 + navigationBarHeight;
                } else if (rect.left == navigationBarHeight) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activityCompatHelperApi24.isInMultiWindowMode(activity) && (cutoutForDisplay = getCutoutForDisplay(defaultDisplay)) != null) {
            int i7 = rect.left;
            DisplayCompatHelperApi28 displayCompatHelperApi28 = DisplayCompatHelperApi28.INSTANCE;
            if (i7 == displayCompatHelperApi28.safeInsetLeft(cutoutForDisplay)) {
                rect.left = 0;
            }
            if (point.x - rect.right == displayCompatHelperApi28.safeInsetRight(cutoutForDisplay)) {
                rect.right += displayCompatHelperApi28.safeInsetRight(cutoutForDisplay);
            }
            if (rect.top == displayCompatHelperApi28.safeInsetTop(cutoutForDisplay)) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay)) {
                rect.bottom += displayCompatHelperApi28.safeInsetBottom(cutoutForDisplay);
            }
        }
        return rect;
    }

    @RequiresApi(29)
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    public final Rect computeWindowBoundsQ$window_release(Activity activity) {
        t.e(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object invoke = obj.getClass().getDeclaredMethod("getBounds", (Class[]) null).invoke(obj, (Object[]) null);
            if (invoke != null) {
                return new Rect((Rect) invoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.Rect");
        } catch (NoSuchFieldException e5) {
            Log.w(TAG, e5);
            return computeWindowBoundsP$window_release(activity);
        } catch (NoSuchMethodException e6) {
            Log.w(TAG, e6);
            return computeWindowBoundsP$window_release(activity);
        } catch (IllegalAccessException e7) {
            Log.w(TAG, e7);
            return computeWindowBoundsP$window_release(activity);
        } catch (InvocationTargetException e8) {
            Log.w(TAG, e8);
            return computeWindowBoundsP$window_release(activity);
        }
    }

    @RequiresApi(14)
    @VisibleForTesting
    public final Point getRealSizeForDisplay$window_release(Display display) {
        t.e(display, "display");
        Point point = new Point();
        DisplayCompatHelperApi17.INSTANCE.getRealSize(display, point);
        return point;
    }
}
