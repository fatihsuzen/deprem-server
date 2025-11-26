package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    /* access modifiers changed from: private */
    public static final String TAG = Logger.tagWithPrefix("SystemFgService");
    private static SystemForegroundService sForegroundService = null;
    SystemForegroundDispatcher mDispatcher;
    private boolean mIsShutdown;
    NotificationManager mNotificationManager;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        static void startForeground(Service service, int i5, Notification notification, int i6) {
            service.startForeground(i5, notification, i6);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        static void startForeground(Service service, int i5, Notification notification, int i6) {
            try {
                service.startForeground(i5, notification, i6);
            } catch (ForegroundServiceStartNotAllowedException e5) {
                Logger.get().warning(SystemForegroundService.TAG, "Unable to start foreground service", e5);
            } catch (SecurityException e6) {
                Logger.get().warning(SystemForegroundService.TAG, "Unable to start foreground service", e6);
            }
        }
    }

    public static SystemForegroundService getInstance() {
        return sForegroundService;
    }

    @MainThread
    private void initializeDispatcher() {
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        systemForegroundDispatcher.setCallback(this);
    }

    @MainThread
    public void cancelNotification(int i5) {
        this.mNotificationManager.cancel(i5);
    }

    @RequiresPermission("android.permission.POST_NOTIFICATIONS")
    @MainThread
    public void notify(int i5, Notification notification) {
        this.mNotificationManager.notify(i5, notification);
    }

    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        initializeDispatcher();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    public int onStartCommand(Intent intent, int i5, int i6) {
        super.onStartCommand(intent, i5, i6);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.mDispatcher.onDestroy();
            initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        this.mDispatcher.onStartCommand(intent, i6);
        return 3;
    }

    public void onTimeout(int i5) {
        if (Build.VERSION.SDK_INT < 35) {
            this.mDispatcher.onTimeout(i5, 2048);
        }
    }

    @MainThread
    public void startForeground(int i5, int i6, Notification notification) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31) {
            Api31Impl.startForeground(this, i5, notification, i6);
        } else if (i7 >= 29) {
            Api29Impl.startForeground(this, i5, notification, i6);
        } else {
            startForeground(i5, notification);
        }
    }

    @MainThread
    public void stop(int i5) {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "Shutting down.");
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        sForegroundService = null;
        stopSelf(i5);
    }

    public void onTimeout(int i5, int i6) {
        this.mDispatcher.onTimeout(i5, i6);
    }
}
