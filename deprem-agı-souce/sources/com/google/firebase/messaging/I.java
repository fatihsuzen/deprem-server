package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.k;
import java.util.List;
import o0.f;

class I {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7300a;

    /* renamed from: b  reason: collision with root package name */
    private String f7301b;

    /* renamed from: c  reason: collision with root package name */
    private String f7302c;

    /* renamed from: d  reason: collision with root package name */
    private int f7303d;

    /* renamed from: e  reason: collision with root package name */
    private int f7304e = 0;

    I(Context context) {
        this.f7300a = context;
    }

    static String c(f fVar) {
        String d5 = fVar.n().d();
        if (d5 != null) {
            return d5;
        }
        String c5 = fVar.n().c();
        if (!c5.startsWith("1:")) {
            return c5;
        }
        String[] split = c5.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.f7300a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e5) {
            Log.w("FirebaseMessaging", "Failed to find package " + e5);
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo f5 = f(this.f7300a.getPackageName());
        if (f5 != null) {
            this.f7301b = Integer.toString(f5.versionCode);
            this.f7302c = f5.versionName;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized String a() {
        try {
            if (this.f7301b == null) {
                h();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f7301b;
    }

    /* access modifiers changed from: package-private */
    public synchronized String b() {
        try {
            if (this.f7302c == null) {
                h();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f7302c;
    }

    /* access modifiers changed from: package-private */
    public synchronized int d() {
        PackageInfo f5;
        try {
            if (this.f7303d == 0 && (f5 = f("com.google.android.gms")) != null) {
                this.f7303d = f5.versionCode;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f7303d;
    }

    /* access modifiers changed from: package-private */
    public synchronized int e() {
        int i5 = this.f7304e;
        if (i5 != 0) {
            return i5;
        }
        PackageManager packageManager = this.f7300a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!k.e()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f7304e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
            if (k.e()) {
                this.f7304e = 2;
            } else {
                this.f7304e = 1;
            }
            return this.f7304e;
        }
        this.f7304e = 2;
        return 2;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        if (e() != 0) {
            return true;
        }
        return false;
    }
}
