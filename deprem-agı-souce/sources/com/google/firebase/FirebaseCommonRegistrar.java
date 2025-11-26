package com.google.firebase;

import P0.f;
import Z0.c;
import Z0.e;
import Z0.h;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import o0.i;
import o0.j;
import o0.k;
import o0.l;

public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static /* synthetic */ String a(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (installerPackageName != null) {
            return e(installerPackageName);
        }
        return "";
    }

    public static /* synthetic */ String b(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null || Build.VERSION.SDK_INT < 24) {
            return "";
        }
        return String.valueOf(applicationInfo.minSdkVersion);
    }

    public static /* synthetic */ String c(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            return String.valueOf(applicationInfo.targetSdkVersion);
        }
        return "";
    }

    public static /* synthetic */ String d(Context context) {
        int i5 = Build.VERSION.SDK_INT;
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
            return "tv";
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
            return "watch";
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            return "auto";
        }
        if (i5 < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
            return "";
        }
        return "embedded";
    }

    private static String e(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    public List getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.c());
        arrayList.add(f.g());
        arrayList.add(h.b("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(h.b("fire-core", "22.0.1"));
        arrayList.add(h.b("device-name", e(Build.PRODUCT)));
        arrayList.add(h.b("device-model", e(Build.DEVICE)));
        arrayList.add(h.b("device-brand", e(Build.BRAND)));
        arrayList.add(h.c("android-target-sdk", new i()));
        arrayList.add(h.c("android-min-sdk", new j()));
        arrayList.add(h.c("android-platform", new k()));
        arrayList.add(h.c("android-installer", new l()));
        String a5 = e.a();
        if (a5 != null) {
            arrayList.add(h.b("kotlin", a5));
        }
        return arrayList;
    }
}
