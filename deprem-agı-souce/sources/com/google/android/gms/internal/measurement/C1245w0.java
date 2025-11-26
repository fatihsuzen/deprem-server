package com.google.android.gms.internal.measurement;

import U.a;
import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.w0  reason: case insensitive filesystem */
public interface C1245w0 extends IInterface {
    void beginAdUnitExposure(String str, long j5);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j5);

    void endAdUnitExposure(String str, long j5);

    void generateEventId(C1270z0 z0Var);

    void getAppInstanceId(C1270z0 z0Var);

    void getCachedAppInstanceId(C1270z0 z0Var);

    void getConditionalUserProperties(String str, String str2, C1270z0 z0Var);

    void getCurrentScreenClass(C1270z0 z0Var);

    void getCurrentScreenName(C1270z0 z0Var);

    void getGmpAppId(C1270z0 z0Var);

    void getMaxUserProperties(String str, C1270z0 z0Var);

    void getSessionId(C1270z0 z0Var);

    void getTestFlag(C1270z0 z0Var, int i5);

    void getUserProperties(String str, String str2, boolean z4, C1270z0 z0Var);

    void initForTests(Map map);

    void initialize(a aVar, J0 j02, long j5);

    void isDataCollectionEnabled(C1270z0 z0Var);

    void logEvent(String str, String str2, Bundle bundle, boolean z4, boolean z5, long j5);

    void logEventAndBundle(String str, String str2, Bundle bundle, C1270z0 z0Var, long j5);

    void logHealthData(int i5, String str, a aVar, a aVar2, a aVar3);

    void onActivityCreated(a aVar, Bundle bundle, long j5);

    void onActivityCreatedByScionActivityInfo(L0 l02, Bundle bundle, long j5);

    void onActivityDestroyed(a aVar, long j5);

    void onActivityDestroyedByScionActivityInfo(L0 l02, long j5);

    void onActivityPaused(a aVar, long j5);

    void onActivityPausedByScionActivityInfo(L0 l02, long j5);

    void onActivityResumed(a aVar, long j5);

    void onActivityResumedByScionActivityInfo(L0 l02, long j5);

    void onActivitySaveInstanceState(a aVar, C1270z0 z0Var, long j5);

    void onActivitySaveInstanceStateByScionActivityInfo(L0 l02, C1270z0 z0Var, long j5);

    void onActivityStarted(a aVar, long j5);

    void onActivityStartedByScionActivityInfo(L0 l02, long j5);

    void onActivityStopped(a aVar, long j5);

    void onActivityStoppedByScionActivityInfo(L0 l02, long j5);

    void performAction(Bundle bundle, C1270z0 z0Var, long j5);

    void registerOnMeasurementEventListener(G0 g02);

    void resetAnalyticsData(long j5);

    void retrieveAndUploadBatches(C0 c02);

    void setConditionalUserProperty(Bundle bundle, long j5);

    void setConsent(Bundle bundle, long j5);

    void setConsentThirdParty(Bundle bundle, long j5);

    void setCurrentScreen(a aVar, String str, String str2, long j5);

    void setCurrentScreenByScionActivityInfo(L0 l02, String str, String str2, long j5);

    void setDataCollectionEnabled(boolean z4);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(G0 g02);

    void setInstanceIdProvider(I0 i02);

    void setMeasurementEnabled(boolean z4, long j5);

    void setMinimumSessionDuration(long j5);

    void setSessionTimeoutDuration(long j5);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j5);

    void setUserProperty(String str, String str2, a aVar, boolean z4, long j5);

    void unregisterOnMeasurementEventListener(G0 g02);
}
