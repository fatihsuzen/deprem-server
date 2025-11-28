package com.finazzi.distquake;

import H3.c;
import H3.e;
import H3.f;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.C0768d;
import androidx.core.view.C0832r0;
import androidx.fragment.app.C0891s;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import java.io.File;
import u2.C1803i3;

public class Preferences extends C0768d {

    public static class MyPreferenceFragment extends PreferenceFragmentCompat {
        public static /* synthetic */ void L0(e eVar) {
        }

        public void A0(Bundle bundle, String str) {
            Preference a8;
            I0(C2030R.xml.preferences_general_menu, str);
            Preference a9 = v0().a("eqn_privacy_options");
            if (a9 != null) {
                a9.B0(false);
            }
            C0891s activity = getActivity();
            if (activity != null && f.a(activity).getPrivacyOptionsRequirementStatus() == c.C0390c.REQUIRED && (a8 = v0().a("eqn_privacy_options")) != null) {
                a8.B0(true);
                a8.o0(true);
                a8.v0(new C1803i3(activity));
            }
        }

        public void onPause() {
            super.onPause();
            C0891s activity = getActivity();
            if (activity != null) {
                activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit().apply();
                String str = activity.getApplicationInfo().dataDir;
                if (!new File(str + "/files/cache_automatic13.txt").delete()) {
                    Log.d("EQN", "Cannot delete");
                }
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
        TextView textView = (TextView) findViewById(C2030R.id.textView);
    }
}
