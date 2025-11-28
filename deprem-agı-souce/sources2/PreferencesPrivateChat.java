package com.finazzi.distquake;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.C0768d;
import androidx.core.view.C0832r0;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import u2.C1905z3;

public class PreferencesPrivateChat extends C0768d {

    public static class MyPreferenceFragment extends PreferenceFragmentCompat {
        public static /* synthetic */ boolean K0(MyPreferenceFragment myPreferenceFragment, Preference preference) {
            NotificationChannel a8;
            NotificationManager notificationManager = (NotificationManager) myPreferenceFragment.getActivity().getSystemService("notification");
            if (notificationManager == null || (a8 = notificationManager.getNotificationChannel(myPreferenceFragment.getString(C2030R.string.channel_chat_private))) == null) {
                return true;
            }
            Intent intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.CHANNEL_ID", a8.getId());
            intent.putExtra("android.provider.extra.APP_PACKAGE", myPreferenceFragment.getActivity().getApplication().getPackageName());
            myPreferenceFragment.startActivity(intent);
            return true;
        }

        public void A0(Bundle bundle, String str) {
            Preference a8;
            I0(C2030R.xml.preferences_privatechat, str);
            Preference a9 = v0().a("chat_notify_channel_change_settings_new_messages_personal");
            if (a9 != null && Build.VERSION.SDK_INT >= 26) {
                a9.v0(new C1905z3(this));
            }
            if (Build.VERSION.SDK_INT < 26 && (a8 = v0().a("vibration_and_sound")) != null) {
                a8.B0(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        getSupportFragmentManager().o().r(16908290, new MyPreferenceFragment()).j();
    }
}
