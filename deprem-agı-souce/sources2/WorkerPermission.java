package com.finazzi.distquake;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.PowerManager;
import androidx.core.app.m;
import androidx.core.content.a;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.c;

public class WorkerPermission extends Worker {
    public WorkerPermission(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public c.a doWork() {
        boolean z7;
        PendingIntent pendingIntent;
        Class<MainActivity> cls = MainActivity.class;
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(cls.getSimpleName(), 0);
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 31 ? i8 < 29 ? a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 : a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 && a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0 : a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 && a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0 && a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!((PowerManager) getApplicationContext().getSystemService("power")).isIgnoringBatteryOptimizations(getApplicationContext().getPackageName())) {
            z7 = false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (!z7) {
            long j8 = sharedPreferences.getLong("permission_check_time3", -1);
            if (j8 == -1) {
                edit.putLong("permission_check_time3", System.currentTimeMillis());
                edit.apply();
            } else {
                int i9 = sharedPreferences.getInt("permission_notification_shown3", 0);
                long currentTimeMillis = System.currentTimeMillis();
                if (((double) (currentTimeMillis - j8)) / 3600000.0d >= Math.exp((double) (i9 * 2))) {
                    Intent intent = new Intent(getApplicationContext(), cls);
                    intent.putExtra("com.finazzi.distquake.fix", true);
                    if (i8 >= 31) {
                        pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 201326592);
                    } else {
                        pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 134217728);
                    }
                    Notification b8 = new m.e(getApplicationContext(), getApplicationContext().getString(C2030R.string.channel_permission)).i(String.format(getApplicationContext().getString(C2030R.string.location_fix), new Object[]{getApplicationContext().getString(C2030R.string.app_name)})).p(BitmapFactory.decodeResource(getApplicationContext().getResources(), 2131230872)).w(2131230872).z(new m.c().h(String.format(getApplicationContext().getString(C2030R.string.location_fix), new Object[]{getApplicationContext().getString(C2030R.string.app_name)}))).h(pendingIntent).b();
                    NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
                    if (notificationManager != null) {
                        notificationManager.notify(999000, b8);
                    }
                    if (i9 < 5) {
                        edit.putInt("permission_notification_shown3", i9 + 1);
                    }
                    edit.putLong("permission_check_time3", currentTimeMillis);
                    edit.apply();
                }
            }
        } else {
            edit.putInt("permission_notification_shown3", 0);
            edit.apply();
        }
        return c.a.c();
    }

    public void onStopped() {
    }
}
