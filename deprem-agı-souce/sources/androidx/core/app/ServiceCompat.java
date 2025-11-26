package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 1073745919;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void stopForeground(Service service, int i5) {
            service.stopForeground(i5);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void startForeground(Service service, int i5, Notification notification, int i6) {
            if (i6 == 0 || i6 == -1) {
                service.startForeground(i5, notification, i6);
            } else {
                service.startForeground(i5, notification, i6 & 255);
            }
        }
    }

    @RequiresApi(34)
    static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static void startForeground(Service service, int i5, Notification notification, int i6) {
            if (i6 == 0 || i6 == -1) {
                service.startForeground(i5, notification, i6);
            } else {
                service.startForeground(i5, notification, i6 & ServiceCompat.FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }

    private ServiceCompat() {
    }

    public static void startForeground(@NonNull Service service, int i5, @NonNull Notification notification, int i6) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 34) {
            Api34Impl.startForeground(service, i5, notification, i6);
        } else if (i7 >= 29) {
            Api29Impl.startForeground(service, i5, notification, i6);
        } else {
            service.startForeground(i5, notification);
        }
    }

    public static void stopForeground(@NonNull Service service, int i5) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.stopForeground(service, i5);
            return;
        }
        boolean z4 = true;
        if ((i5 & 1) == 0) {
            z4 = false;
        }
        service.stopForeground(z4);
    }
}
