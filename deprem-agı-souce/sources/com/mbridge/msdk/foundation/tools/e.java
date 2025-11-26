package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;

public class e {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Resources resources = context.getResources();
            if (resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            af.b("DomainSameTool", th.getMessage(), th);
            return false;
        }
    }
}
