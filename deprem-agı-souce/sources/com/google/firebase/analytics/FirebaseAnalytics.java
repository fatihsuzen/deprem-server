package com.google.firebase.analytics;

import N.C0722p;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.C1237v1;
import com.google.android.gms.internal.measurement.L0;
import com.google.firebase.installations.c;
import f0.C1640H;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k0.C1701o;

public final class FirebaseAnalytics {

    /* renamed from: b  reason: collision with root package name */
    private static volatile FirebaseAnalytics f7150b;

    /* renamed from: a  reason: collision with root package name */
    private final C1237v1 f7151a;

    public FirebaseAnalytics(C1237v1 v1Var) {
        C0722p.k(v1Var);
        this.f7151a = v1Var;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @NonNull
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f7150b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f7150b == null) {
                        f7150b = new FirebaseAnalytics(C1237v1.o(context, (Bundle) null));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7150b;
    }

    @Keep
    @Nullable
    public static C1640H getScionFrontendApiImplementation(Context context, @Nullable Bundle bundle) {
        C1237v1 o5 = C1237v1.o(context, bundle);
        if (o5 == null) {
            return null;
        }
        return new a(o5);
    }

    public void a(String str, Bundle bundle) {
        this.f7151a.s(str, bundle);
    }

    public void b(boolean z4) {
        this.f7151a.z(Boolean.valueOf(z4));
    }

    @NonNull
    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String) C1701o.b(c.p().getId(), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e5) {
            throw new IllegalStateException(e5.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        } catch (InterruptedException e6) {
            throw new IllegalStateException(e6);
        }
    }

    @MainThread
    @Deprecated
    @Keep
    public void setCurrentScreen(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        this.f7151a.y(L0.c(activity), str, str2);
    }
}
