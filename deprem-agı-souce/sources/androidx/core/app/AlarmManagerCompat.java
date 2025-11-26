package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class AlarmManagerCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static AlarmManager.AlarmClockInfo createAlarmClockInfo(long j5, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j5, pendingIntent);
        }

        @DoNotInline
        static void setAlarmClock(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void setAndAllowWhileIdle(AlarmManager alarmManager, int i5, long j5, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i5, j5, pendingIntent);
        }

        @DoNotInline
        static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i5, long j5, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i5, j5, pendingIntent);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean canScheduleExactAlarms(AlarmManager alarmManager) {
            return alarmManager.canScheduleExactAlarms();
        }
    }

    private AlarmManagerCompat() {
    }

    public static boolean canScheduleExactAlarms(@NonNull AlarmManager alarmManager) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.canScheduleExactAlarms(alarmManager);
        }
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public static void setAlarmClock(@NonNull AlarmManager alarmManager, long j5, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        Api21Impl.setAlarmClock(alarmManager, Api21Impl.createAlarmClockInfo(j5, pendingIntent), pendingIntent2);
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i5, long j5, @NonNull PendingIntent pendingIntent) {
        Api23Impl.setAndAllowWhileIdle(alarmManager, i5, j5, pendingIntent);
    }

    public static void setExact(@NonNull AlarmManager alarmManager, int i5, long j5, @NonNull PendingIntent pendingIntent) {
        alarmManager.setExact(i5, j5, pendingIntent);
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i5, long j5, @NonNull PendingIntent pendingIntent) {
        Api23Impl.setExactAndAllowWhileIdle(alarmManager, i5, j5, pendingIntent);
    }
}
