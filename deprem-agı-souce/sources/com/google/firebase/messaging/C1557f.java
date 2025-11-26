package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.k;
import com.google.firebase.messaging.C1555d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k0.C1701o;

/* renamed from: com.google.firebase.messaging.f  reason: case insensitive filesystem */
class C1557f {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f7410a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7411b;

    /* renamed from: c  reason: collision with root package name */
    private final J f7412c;

    public C1557f(Context context, J j5, ExecutorService executorService) {
        this.f7410a = executorService;
        this.f7411b = context;
        this.f7412c = j5;
    }

    private boolean b() {
        if (((KeyguardManager) this.f7411b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!k.c()) {
            SystemClock.sleep(10);
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f7411b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    if (next.importance == 100) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void c(C1555d.a aVar) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f7411b.getSystemService("notification")).notify(aVar.f7398b, aVar.f7399c, aVar.f7397a.build());
    }

    private F d() {
        F m5 = F.m(this.f7412c.p("gcm.n.image"));
        if (m5 != null) {
            m5.o(this.f7410a);
        }
        return m5;
    }

    private void e(NotificationCompat.Builder builder, F f5) {
        if (f5 != null) {
            try {
                Bitmap bitmap = (Bitmap) C1701o.b(f5.n(), 5, TimeUnit.SECONDS);
                builder.setLargeIcon(bitmap);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon((Bitmap) null));
            } catch (ExecutionException e5) {
                Log.w("FirebaseMessaging", "Failed to download image: " + e5.getCause());
            } catch (InterruptedException unused) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                f5.close();
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                f5.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if (this.f7412c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        F d5 = d();
        C1555d.a e5 = C1555d.e(this.f7411b, this.f7412c);
        e(e5.f7397a, d5);
        c(e5);
        return true;
    }
}
