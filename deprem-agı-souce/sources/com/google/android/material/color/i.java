package com.google.android.material.color;

import android.os.Build;

public abstract /* synthetic */ class i {
    public static ColorResourcesOverride a() {
        int i5 = Build.VERSION.SDK_INT;
        if (30 <= i5 && i5 <= 33) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        if (i5 >= 34) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        return null;
    }
}
