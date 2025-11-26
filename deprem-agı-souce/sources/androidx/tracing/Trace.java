package androidx.tracing;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Trace {
    static final int MAX_TRACE_LABEL_LENGTH = 127;
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static boolean sHasAppTracingEnabled;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    private Trace() {
    }

    public static void beginAsyncSection(@NonNull String str, int i5) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.beginAsyncSection(truncatedTraceSectionLabel(str), i5);
        } else {
            beginAsyncSectionFallback(truncatedTraceSectionLabel(str), i5);
        }
    }

    private static void beginAsyncSectionFallback(@NonNull String str, int i5) {
        try {
            if (sAsyncTraceBeginMethod == null) {
                sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            }
            sAsyncTraceBeginMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i5)});
        } catch (Exception e5) {
            handleException("asyncTraceBegin", e5);
        }
    }

    public static void beginSection(@NonNull String str) {
        TraceApi18Impl.beginSection(truncatedTraceSectionLabel(str));
    }

    public static void endAsyncSection(@NonNull String str, int i5) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.endAsyncSection(truncatedTraceSectionLabel(str), i5);
        } else {
            endAsyncSectionFallback(truncatedTraceSectionLabel(str), i5);
        }
    }

    private static void endAsyncSectionFallback(@NonNull String str, int i5) {
        try {
            if (sAsyncTraceEndMethod == null) {
                sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            }
            sAsyncTraceEndMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i5)});
        } catch (Exception e5) {
            handleException("asyncTraceEnd", e5);
        }
    }

    public static void endSection() {
        TraceApi18Impl.endSection();
    }

    public static void forceEnableAppTracing() {
        if (Build.VERSION.SDK_INT < 31) {
            try {
                if (!sHasAppTracingEnabled) {
                    sHasAppTracingEnabled = true;
                    android.os.Trace.class.getMethod("setAppTracingAllowed", new Class[]{Boolean.TYPE}).invoke((Object) null, new Object[]{Boolean.TRUE});
                }
            } catch (Exception e5) {
                handleException("setAppTracingAllowed", e5);
            }
        }
    }

    private static void handleException(@NonNull String str, @NonNull Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v(TAG, "Unable to call " + str + " via reflection", exc);
    }

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return TraceApi29Impl.isEnabled();
        }
        return isEnabledFallback();
    }

    private static boolean isEnabledFallback() {
        Class<android.os.Trace> cls = android.os.Trace.class;
        try {
            if (sIsTagEnabledMethod == null) {
                sTraceTagApp = cls.getField("TRACE_TAG_APP").getLong((Object) null);
                sIsTagEnabledMethod = cls.getMethod("isTagEnabled", new Class[]{Long.TYPE});
            }
            return ((Boolean) sIsTagEnabledMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
        } catch (Exception e5) {
            handleException("isTagEnabled", e5);
            return false;
        }
    }

    public static void setCounter(@NonNull String str, int i5) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.setCounter(truncatedTraceSectionLabel(str), i5);
        } else {
            setCounterFallback(truncatedTraceSectionLabel(str), i5);
        }
    }

    private static void setCounterFallback(@NonNull String str, int i5) {
        try {
            if (sTraceCounterMethod == null) {
                sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            }
            sTraceCounterMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i5)});
        } catch (Exception e5) {
            handleException("traceCounter", e5);
        }
    }

    @NonNull
    private static String truncatedTraceSectionLabel(@NonNull String str) {
        if (str.length() <= MAX_TRACE_LABEL_LENGTH) {
            return str;
        }
        return str.substring(0, MAX_TRACE_LABEL_LENGTH);
    }
}
