package com.google.android.gms.measurement.internal;

import N.C0722p;
import U.a;
import U.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.C0;
import com.google.android.gms.internal.measurement.C1236v0;
import com.google.android.gms.internal.measurement.C1270z0;
import com.google.android.gms.internal.measurement.G0;
import com.google.android.gms.internal.measurement.I0;
import com.google.android.gms.internal.measurement.J0;
import com.google.android.gms.internal.measurement.L0;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import f0.C1634B;
import java.util.Map;

@DynamiteApi
public class AppMeasurementDynamiteService extends C1236v0 {

    /* renamed from: a  reason: collision with root package name */
    X2 f5742a = null;

    /* renamed from: b  reason: collision with root package name */
    private final Map f5743b = new ArrayMap();

    private final void j() {
        if (this.f5742a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void k(C1270z0 z0Var, String str) {
        j();
        this.f5742a.C().a0(z0Var, str);
    }

    public void beginAdUnitExposure(@NonNull String str, long j5) throws RemoteException {
        j();
        this.f5742a.M().i(str, j5);
    }

    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        j();
        this.f5742a.B().O(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j5) throws RemoteException {
        j();
        this.f5742a.B().n0((Boolean) null);
    }

    public void endAdUnitExposure(@NonNull String str, long j5) throws RemoteException {
        j();
        this.f5742a.M().j(str, j5);
    }

    public void generateEventId(C1270z0 z0Var) throws RemoteException {
        j();
        long p02 = this.f5742a.C().p0();
        j();
        this.f5742a.C().b0(z0Var, p02);
    }

    public void getAppInstanceId(C1270z0 z0Var) throws RemoteException {
        j();
        this.f5742a.b().t(new U2(this, z0Var));
    }

    public void getCachedAppInstanceId(C1270z0 z0Var) throws RemoteException {
        j();
        k(z0Var, this.f5742a.B().D());
    }

    public void getConditionalUserProperties(String str, String str2, C1270z0 z0Var) throws RemoteException {
        j();
        this.f5742a.b().t(new K4(this, z0Var, str, str2));
    }

    public void getCurrentScreenClass(C1270z0 z0Var) throws RemoteException {
        j();
        k(z0Var, this.f5742a.B().R());
    }

    public void getCurrentScreenName(C1270z0 z0Var) throws RemoteException {
        j();
        k(z0Var, this.f5742a.B().Q());
    }

    public void getGmpAppId(C1270z0 z0Var) throws RemoteException {
        j();
        k(z0Var, this.f5742a.B().S());
    }

    public void getMaxUserProperties(String str, C1270z0 z0Var) throws RemoteException {
        j();
        this.f5742a.B().L(str);
        j();
        this.f5742a.C().c0(z0Var, 25);
    }

    public void getSessionId(C1270z0 z0Var) throws RemoteException {
        j();
        C1452x4 B4 = this.f5742a.B();
        B4.f5730a.b().t(new C1282a4(B4, z0Var));
    }

    public void getTestFlag(C1270z0 z0Var, int i5) throws RemoteException {
        j();
        if (i5 == 0) {
            this.f5742a.C().a0(z0Var, this.f5742a.B().j0());
        } else if (i5 == 1) {
            this.f5742a.C().b0(z0Var, this.f5742a.B().k0().longValue());
        } else if (i5 == 2) {
            z6 C4 = this.f5742a.C();
            double doubleValue = this.f5742a.B().m0().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble(CampaignEx.JSON_KEY_AD_R, doubleValue);
            try {
                z0Var.W(bundle);
            } catch (RemoteException e5) {
                C4.f5730a.a().r().b("Error returning double value to wrapper", e5);
            }
        } else if (i5 == 3) {
            this.f5742a.C().c0(z0Var, this.f5742a.B().l0().intValue());
        } else if (i5 == 4) {
            this.f5742a.C().e0(z0Var, this.f5742a.B().i0().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z4, C1270z0 z0Var) throws RemoteException {
        j();
        this.f5742a.b().t(new O3(this, z0Var, str, str2, z4));
    }

    public void initForTests(@NonNull Map map) throws RemoteException {
        j();
    }

    public void initialize(a aVar, J0 j02, long j5) throws RemoteException {
        X2 x22 = this.f5742a;
        if (x22 == null) {
            this.f5742a = X2.O((Context) C0722p.k((Context) b.k(aVar)), j02, Long.valueOf(j5));
        } else {
            x22.a().r().a("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(C1270z0 z0Var) throws RemoteException {
        j();
        this.f5742a.b().t(new C1363k5(this, z0Var));
    }

    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z4, boolean z5, long j5) throws RemoteException {
        j();
        this.f5742a.B().q(str, str2, bundle, z4, z5, j5);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, C1270z0 z0Var, long j5) throws RemoteException {
        Bundle bundle2;
        j();
        C0722p.e(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        this.f5742a.b().t(new C1437v3(this, z0Var, new G(str2, new E(bundle), MBridgeConstans.DYNAMIC_VIEW_WX_APP, j5), str));
    }

    public void logHealthData(int i5, @NonNull String str, @NonNull a aVar, @NonNull a aVar2, @NonNull a aVar3) throws RemoteException {
        Object obj;
        Object obj2;
        j();
        Object obj3 = null;
        if (aVar == null) {
            obj = null;
        } else {
            obj = b.k(aVar);
        }
        if (aVar2 == null) {
            obj2 = null;
        } else {
            obj2 = b.k(aVar2);
        }
        if (aVar3 != null) {
            obj3 = b.k(aVar3);
        }
        this.f5742a.a().y(i5, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(@NonNull a aVar, @NonNull Bundle bundle, long j5) throws RemoteException {
        j();
        onActivityCreatedByScionActivityInfo(L0.c((Activity) C0722p.k((Activity) b.k(aVar))), bundle, j5);
    }

    public void onActivityCreatedByScionActivityInfo(L0 l02, Bundle bundle, long j5) {
        j();
        C1369l4 l4Var = this.f5742a.B().f6868c;
        if (l4Var != null) {
            this.f5742a.B().h0();
            l4Var.e(l02, bundle);
        }
    }

    public void onActivityDestroyed(@NonNull a aVar, long j5) throws RemoteException {
        j();
        onActivityDestroyedByScionActivityInfo(L0.c((Activity) C0722p.k((Activity) b.k(aVar))), j5);
    }

    public void onActivityDestroyedByScionActivityInfo(L0 l02, long j5) throws RemoteException {
        j();
        C1369l4 l4Var = this.f5742a.B().f6868c;
        if (l4Var != null) {
            this.f5742a.B().h0();
            l4Var.b(l02);
        }
    }

    public void onActivityPaused(@NonNull a aVar, long j5) throws RemoteException {
        j();
        onActivityPausedByScionActivityInfo(L0.c((Activity) C0722p.k((Activity) b.k(aVar))), j5);
    }

    public void onActivityPausedByScionActivityInfo(L0 l02, long j5) throws RemoteException {
        j();
        C1369l4 l4Var = this.f5742a.B().f6868c;
        if (l4Var != null) {
            this.f5742a.B().h0();
            l4Var.a(l02);
        }
    }

    public void onActivityResumed(@NonNull a aVar, long j5) throws RemoteException {
        j();
        onActivityResumedByScionActivityInfo(L0.c((Activity) C0722p.k((Activity) b.k(aVar))), j5);
    }

    public void onActivityResumedByScionActivityInfo(L0 l02, long j5) throws RemoteException {
        j();
        C1369l4 l4Var = this.f5742a.B().f6868c;
        if (l4Var != null) {
            this.f5742a.B().h0();
            l4Var.d(l02);
        }
    }

    public void onActivitySaveInstanceState(a aVar, C1270z0 z0Var, long j5) throws RemoteException {
        j();
        onActivitySaveInstanceStateByScionActivityInfo(L0.c((Activity) C0722p.k((Activity) b.k(aVar))), z0Var, j5);
    }

    public void onActivitySaveInstanceStateByScionActivityInfo(L0 l02, C1270z0 z0Var, long j5) throws RemoteException {
        j();
        C1369l4 l4Var = this.f5742a.B().f6868c;
        Bundle bundle = new Bundle();
        if (l4Var != null) {
            this.f5742a.B().h0();
            l4Var.c(l02, bundle);
        }
        try {
            z0Var.W(bundle);
        } catch (RemoteException e5) {
            this.f5742a.a().r().b("Error returning bundle value to wrapper", e5);
        }
    }

    public void onActivityStarted(@NonNull a aVar, long j5) throws RemoteException {
        j();
        onActivityStartedByScionActivityInfo(L0.c((Activity) C0722p.k((Activity) b.k(aVar))), j5);
    }

    public void onActivityStartedByScionActivityInfo(L0 l02, long j5) throws RemoteException {
        j();
        if (this.f5742a.B().f6868c != null) {
            this.f5742a.B().h0();
        }
    }

    public void onActivityStopped(@NonNull a aVar, long j5) throws RemoteException {
        j();
        onActivityStoppedByScionActivityInfo(L0.c((Activity) C0722p.k((Activity) b.k(aVar))), j5);
    }

    public void onActivityStoppedByScionActivityInfo(L0 l02, long j5) throws RemoteException {
        j();
        if (this.f5742a.B().f6868c != null) {
            this.f5742a.B().h0();
        }
    }

    public void performAction(Bundle bundle, C1270z0 z0Var, long j5) throws RemoteException {
        j();
        z0Var.W((Bundle) null);
    }

    public void registerOnMeasurementEventListener(G0 g02) throws RemoteException {
        C1634B b5;
        j();
        Map map = this.f5743b;
        synchronized (map) {
            try {
                b5 = (C1634B) map.get(Integer.valueOf(g02.c()));
                if (b5 == null) {
                    b5 = new A6(this, g02);
                    map.put(Integer.valueOf(g02.c()), b5);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.f5742a.B().J(b5);
    }

    public void resetAnalyticsData(long j5) throws RemoteException {
        j();
        this.f5742a.B().G(j5);
    }

    public void retrieveAndUploadBatches(C0 c02) {
        j();
        this.f5742a.B().r0(new K5(this, c02));
    }

    public void setConditionalUserProperty(@NonNull Bundle bundle, long j5) throws RemoteException {
        j();
        if (bundle == null) {
            this.f5742a.a().o().a("Conditional user property must not be null");
        } else {
            this.f5742a.B().N(bundle, j5);
        }
    }

    public void setConsent(@NonNull Bundle bundle, long j5) throws RemoteException {
    }

    public void setConsentThirdParty(@NonNull Bundle bundle, long j5) throws RemoteException {
        j();
        this.f5742a.B().o0(bundle, -20, j5);
    }

    public void setCurrentScreen(@NonNull a aVar, @NonNull String str, @NonNull String str2, long j5) throws RemoteException {
        j();
        setCurrentScreenByScionActivityInfo(L0.c((Activity) C0722p.k((Activity) b.k(aVar))), str, str2, j5);
    }

    public void setCurrentScreenByScionActivityInfo(L0 l02, String str, String str2, long j5) throws RemoteException {
        j();
        this.f5742a.I().t(l02, str, str2);
    }

    public void setDataCollectionEnabled(boolean z4) throws RemoteException {
        j();
        C1452x4 B4 = this.f5742a.B();
        B4.j();
        B4.f5730a.b().t(new M3(B4, z4));
    }

    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        Bundle bundle2;
        j();
        C1452x4 B4 = this.f5742a.B();
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
        }
        B4.f5730a.b().t(new C1424t4(B4, bundle2));
    }

    public void setEventInterceptor(G0 g02) throws RemoteException {
        j();
        C1356j6 j6Var = new C1356j6(this, g02);
        if (this.f5742a.b().p()) {
            this.f5742a.B().I(j6Var);
        } else {
            this.f5742a.b().t(new C1383n4(this, j6Var));
        }
    }

    public void setInstanceIdProvider(I0 i02) throws RemoteException {
        j();
    }

    public void setMeasurementEnabled(boolean z4, long j5) throws RemoteException {
        j();
        this.f5742a.B().n0(Boolean.valueOf(z4));
    }

    public void setMinimumSessionDuration(long j5) throws RemoteException {
        j();
    }

    public void setSessionTimeoutDuration(long j5) throws RemoteException {
        j();
        C1452x4 B4 = this.f5742a.B();
        B4.f5730a.b().t(new P3(B4, j5));
    }

    public void setSgtmDebugInfo(@NonNull Intent intent) throws RemoteException {
        j();
        C1452x4 B4 = this.f5742a.B();
        Uri data = intent.getData();
        if (data == null) {
            B4.f5730a.a().u().a("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals("1")) {
            X2 x22 = B4.f5730a;
            x22.a().u().a("[sgtm] Preview Mode was not enabled.");
            x22.w().Q((String) null);
            return;
        }
        String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
        if (!TextUtils.isEmpty(queryParameter2)) {
            X2 x23 = B4.f5730a;
            x23.a().u().b("[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            x23.w().Q(queryParameter2);
        }
    }

    public void setUserId(@NonNull String str, long j5) throws RemoteException {
        j();
        C1452x4 B4 = this.f5742a.B();
        if (str == null || !TextUtils.isEmpty(str)) {
            B4.f5730a.b().t(new C1431u4(B4, str));
            B4.z((String) null, "_id", str, true, j5);
            return;
        }
        B4.f5730a.a().r().a("User ID must be non-empty or null");
    }

    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull a aVar, boolean z4, long j5) throws RemoteException {
        j();
        this.f5742a.B().z(str, str2, b.k(aVar), z4, j5);
    }

    public void unregisterOnMeasurementEventListener(G0 g02) throws RemoteException {
        C1634B b5;
        j();
        Map map = this.f5743b;
        synchronized (map) {
            b5 = (C1634B) map.remove(Integer.valueOf(g02.c()));
        }
        if (b5 == null) {
            b5 = new A6(this, g02);
        }
        this.f5742a.B().K(b5);
    }
}
