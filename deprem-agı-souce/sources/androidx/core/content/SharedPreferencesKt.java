package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import k3.l;

public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(SharedPreferences sharedPreferences, boolean z4, l lVar) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        lVar.invoke(edit);
        if (z4) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z4, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        lVar.invoke(edit);
        if (z4) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
