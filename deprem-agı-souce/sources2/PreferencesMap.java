package com.finazzi.distquake;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.C0768d;
import androidx.core.view.C0832r0;
import androidx.preference.PreferenceFragmentCompat;

public class PreferencesMap extends C0768d {

    public static class MyPreferenceFragment extends PreferenceFragmentCompat {
        public void A0(Bundle bundle, String str) {
            I0(C2030R.xml.preferences_map, str);
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
