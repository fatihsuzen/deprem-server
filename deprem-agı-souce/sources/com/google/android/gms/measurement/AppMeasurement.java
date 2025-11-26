package com.google.android.gms.measurement;

import N.C0722p;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.measurement.internal.X2;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import f0.C1640H;
import f0.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
public class AppMeasurement {

    /* renamed from: b  reason: collision with root package name */
    private static volatile AppMeasurement f5714b;

    /* renamed from: a  reason: collision with root package name */
    private final c f5715a;

    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @NonNull
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @NonNull
        @Keep
        public String mExpiredEventName;
        @NonNull
        @Keep
        public Bundle mExpiredEventParams;
        @NonNull
        @Keep
        public String mName;
        @NonNull
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @NonNull
        @Keep
        public String mTimedOutEventName;
        @NonNull
        @Keep
        public Bundle mTimedOutEventParams;
        @NonNull
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @NonNull
        @Keep
        public String mTriggeredEventName;
        @NonNull
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @NonNull
        @Keep
        public Object mValue;

        ConditionalUserProperty(Bundle bundle) {
            C0722p.k(bundle);
            Class<String> cls = String.class;
            this.mAppId = (String) u.b(bundle, MBridgeConstans.APP_ID, cls, (Object) null);
            this.mOrigin = (String) u.b(bundle, TtmlNode.ATTR_TTS_ORIGIN, cls, (Object) null);
            this.mName = (String) u.b(bundle, RewardPlus.NAME, cls, (Object) null);
            this.mValue = u.b(bundle, "value", Object.class, (Object) null);
            this.mTriggerEventName = (String) u.b(bundle, "trigger_event_name", cls, (Object) null);
            Class<Long> cls2 = Long.class;
            this.mTriggerTimeout = ((Long) u.b(bundle, "trigger_timeout", cls2, 0L)).longValue();
            this.mTimedOutEventName = (String) u.b(bundle, "timed_out_event_name", cls, (Object) null);
            Class<Bundle> cls3 = Bundle.class;
            this.mTimedOutEventParams = (Bundle) u.b(bundle, "timed_out_event_params", cls3, (Object) null);
            this.mTriggeredEventName = (String) u.b(bundle, "triggered_event_name", cls, (Object) null);
            this.mTriggeredEventParams = (Bundle) u.b(bundle, "triggered_event_params", cls3, (Object) null);
            this.mTimeToLive = ((Long) u.b(bundle, "time_to_live", cls2, 0L)).longValue();
            this.mExpiredEventName = (String) u.b(bundle, "expired_event_name", cls, (Object) null);
            this.mExpiredEventParams = (Bundle) u.b(bundle, "expired_event_params", cls3, (Object) null);
            this.mActive = ((Boolean) u.b(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) u.b(bundle, "creation_timestamp", cls2, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) u.b(bundle, "triggered_timestamp", cls2, 0L)).longValue();
        }
    }

    public AppMeasurement(X2 x22) {
        this.f5715a = new a(x22);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @androidx.annotation.Keep
    @androidx.annotation.RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @androidx.annotation.NonNull
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.measurement.AppMeasurement getInstance(@androidx.annotation.NonNull android.content.Context r10) {
        /*
            com.google.android.gms.measurement.AppMeasurement r0 = f5714b
            if (r0 != 0) goto L_0x0057
            java.lang.Class<com.google.android.gms.measurement.AppMeasurement> r1 = com.google.android.gms.measurement.AppMeasurement.class
            monitor-enter(r1)
            com.google.android.gms.measurement.AppMeasurement r0 = f5714b     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0053
            r0 = 0
            java.lang.Class<com.google.firebase.analytics.FirebaseAnalytics> r2 = com.google.firebase.analytics.FirebaseAnalytics.class
            java.lang.String r3 = "getScionFrontendApiImplementation"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{  }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r7 = 0
            r5[r7] = r6     // Catch:{  }
            java.lang.Class<android.os.Bundle> r6 = android.os.Bundle.class
            r8 = 1
            r5[r8] = r6     // Catch:{  }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r5)     // Catch:{  }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{  }
            r3[r7] = r10     // Catch:{  }
            r3[r8] = r0     // Catch:{  }
            java.lang.Object r2 = r2.invoke(r0, r3)     // Catch:{  }
            f0.H r2 = (f0.C1640H) r2     // Catch:{  }
            goto L_0x0032
        L_0x002e:
            r0 = move-exception
            r10 = r0
            goto L_0x0055
        L_0x0031:
            r2 = r0
        L_0x0032:
            if (r2 == 0) goto L_0x003c
            com.google.android.gms.measurement.AppMeasurement r10 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x002e }
            r10.<init>((f0.C1640H) r2)     // Catch:{ all -> 0x002e }
            f5714b = r10     // Catch:{ all -> 0x002e }
            goto L_0x0053
        L_0x003c:
            com.google.android.gms.internal.measurement.J0 r2 = new com.google.android.gms.internal.measurement.J0     // Catch:{ all -> 0x002e }
            r8 = 0
            r9 = 0
            r3 = 0
            r5 = 0
            r7 = 1
            r2.<init>(r3, r5, r7, r8, r9)     // Catch:{ all -> 0x002e }
            com.google.android.gms.measurement.internal.X2 r10 = com.google.android.gms.measurement.internal.X2.O(r10, r2, r0)     // Catch:{ all -> 0x002e }
            com.google.android.gms.measurement.AppMeasurement r0 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x002e }
            r0.<init>((com.google.android.gms.measurement.internal.X2) r10)     // Catch:{ all -> 0x002e }
            f5714b = r0     // Catch:{ all -> 0x002e }
        L_0x0053:
            monitor-exit(r1)     // Catch:{ all -> 0x002e }
            goto L_0x0057
        L_0x0055:
            monitor-exit(r1)     // Catch:{ all -> 0x002e }
            throw r10
        L_0x0057:
            com.google.android.gms.measurement.AppMeasurement r10 = f5714b
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurement.getInstance(android.content.Context):com.google.android.gms.measurement.AppMeasurement");
    }

    @Keep
    public void beginAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.f5715a.f(str);
    }

    @Keep
    public void clearConditionalUserProperty(@Size(max = 24, min = 1) @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.f5715a.j(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(@Size(min = 1) @NonNull String str) {
        this.f5715a.d(str);
    }

    @Keep
    public long generateEventId() {
        return this.f5715a.g();
    }

    @NonNull
    @Keep
    public String getAppInstanceId() {
        return this.f5715a.h();
    }

    @WorkerThread
    @Keep
    @NonNull
    public List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Size(max = 23, min = 1) @NonNull String str2) {
        int i5;
        List<Bundle> k5 = this.f5715a.k(str, str2);
        if (k5 == null) {
            i5 = 0;
        } else {
            i5 = k5.size();
        }
        ArrayList arrayList = new ArrayList(i5);
        for (Bundle conditionalUserProperty : k5) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    @NonNull
    @Keep
    public String getCurrentScreenClass() {
        return this.f5715a.e();
    }

    @NonNull
    @Keep
    public String getCurrentScreenName() {
        return this.f5715a.a();
    }

    @NonNull
    @Keep
    public String getGmpAppId() {
        return this.f5715a.i();
    }

    @WorkerThread
    @Keep
    public int getMaxUserProperties(@Size(min = 1) @NonNull String str) {
        return this.f5715a.l(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @Keep
    @VisibleForTesting
    @NonNull
    public Map<String, Object> getUserProperties(@NonNull String str, @Size(max = 24, min = 1) @NonNull String str2, boolean z4) {
        return this.f5715a.m(str, str2, z4);
    }

    @Keep
    public void logEventInternal(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.f5715a.b(str, str2, bundle);
    }

    @Keep
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        C0722p.k(conditionalUserProperty);
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString(MBridgeConstans.APP_ID, str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString(TtmlNode.ATTR_TTS_ORIGIN, str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString(RewardPlus.NAME, str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            u.a(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        c cVar = this.f5715a;
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        cVar.c(bundle);
    }

    public AppMeasurement(C1640H h5) {
        this.f5715a = new b(h5);
    }
}
