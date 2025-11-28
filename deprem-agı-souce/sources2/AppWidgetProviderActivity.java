package com.finazzi.distquake;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;

public class AppWidgetProviderActivity extends AppWidgetProvider {
    private PendingIntent a(Context context, String str) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(str);
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getBroadcast(context, 0, intent, 67108864);
        }
        return PendingIntent.getBroadcast(context, 0, intent, 33554432);
    }

    private void b(Context context) {
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        Class<MainActivity> cls = MainActivity.class;
        Intent intent = new Intent(context, cls);
        intent.setFlags(805306368);
        intent.putExtra("com.finazzi.distquake.open_from_widget", true);
        intent.setAction("action_open_from_widget");
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 31) {
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 67108864);
        } else {
            pendingIntent = PendingIntent.getActivity(context, 0, intent, 33554432);
        }
        Intent intent2 = new Intent(context, cls);
        intent2.putExtra("com.finazzi.distquake.send_report", true);
        intent2.setFlags(805306368);
        intent2.setAction("action_send_report");
        if (i8 >= 31) {
            pendingIntent2 = PendingIntent.getActivity(context, 0, intent2, 67108864);
        } else {
            pendingIntent2 = PendingIntent.getActivity(context, 0, intent2, 33554432);
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C2030R.layout.appwidget);
        remoteViews.setOnClickPendingIntent(C2030R.id.widgetframe, pendingIntent);
        remoteViews.setOnClickPendingIntent(C2030R.id.button1, pendingIntent2);
        AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, AppWidgetProviderActivity.class), remoteViews);
    }

    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i8, Bundle bundle) {
    }

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C2030R.layout.appwidget);
        ComponentName componentName = new ComponentName(context, AppWidgetProviderActivity.class);
        remoteViews.setOnClickPendingIntent(C2030R.id.button1, a(context, "button_report"));
        appWidgetManager.updateAppWidget(componentName, remoteViews);
        b(context);
    }
}
