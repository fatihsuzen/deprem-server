package com.mbridge.msdk.newreward.player.apt_api;

import android.app.Activity;

public class AptApi {
    public static void bind(Activity activity) {
        try {
            Class.forName(activity.getClass().getCanonicalName() + "BindingGroup").getDeclaredConstructor(new Class[]{activity.getClass()}).newInstance(new Object[]{activity});
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
