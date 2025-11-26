package com.google.android.gms.internal.measurement;

import U.a;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.measurement.u0  reason: case insensitive filesystem */
public final class C1227u0 extends P implements C1245w0 {
    C1227u0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String str, long j5) {
        Parcel j6 = j();
        j6.writeString(str);
        j6.writeLong(j5);
        k(23, j6);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel j5 = j();
        j5.writeString(str);
        j5.writeString(str2);
        S.c(j5, bundle);
        k(9, j5);
    }

    public final void endAdUnitExposure(String str, long j5) {
        Parcel j6 = j();
        j6.writeString(str);
        j6.writeLong(j5);
        k(24, j6);
    }

    public final void generateEventId(C1270z0 z0Var) {
        Parcel j5 = j();
        S.d(j5, z0Var);
        k(22, j5);
    }

    public final void getCachedAppInstanceId(C1270z0 z0Var) {
        Parcel j5 = j();
        S.d(j5, z0Var);
        k(19, j5);
    }

    public final void getConditionalUserProperties(String str, String str2, C1270z0 z0Var) {
        Parcel j5 = j();
        j5.writeString(str);
        j5.writeString(str2);
        S.d(j5, z0Var);
        k(10, j5);
    }

    public final void getCurrentScreenClass(C1270z0 z0Var) {
        Parcel j5 = j();
        S.d(j5, z0Var);
        k(17, j5);
    }

    public final void getCurrentScreenName(C1270z0 z0Var) {
        Parcel j5 = j();
        S.d(j5, z0Var);
        k(16, j5);
    }

    public final void getGmpAppId(C1270z0 z0Var) {
        Parcel j5 = j();
        S.d(j5, z0Var);
        k(21, j5);
    }

    public final void getMaxUserProperties(String str, C1270z0 z0Var) {
        Parcel j5 = j();
        j5.writeString(str);
        S.d(j5, z0Var);
        k(6, j5);
    }

    public final void getUserProperties(String str, String str2, boolean z4, C1270z0 z0Var) {
        Parcel j5 = j();
        j5.writeString(str);
        j5.writeString(str2);
        int i5 = S.f5169b;
        j5.writeInt(z4 ? 1 : 0);
        S.d(j5, z0Var);
        k(5, j5);
    }

    public final void initialize(a aVar, J0 j02, long j5) {
        Parcel j6 = j();
        S.d(j6, aVar);
        S.c(j6, j02);
        j6.writeLong(j5);
        k(1, j6);
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z4, boolean z5, long j5) {
        Parcel j6 = j();
        j6.writeString(str);
        j6.writeString(str2);
        S.c(j6, bundle);
        j6.writeInt(z4 ? 1 : 0);
        j6.writeInt(z5 ? 1 : 0);
        j6.writeLong(j5);
        k(2, j6);
    }

    public final void logHealthData(int i5, String str, a aVar, a aVar2, a aVar3) {
        Parcel j5 = j();
        j5.writeInt(5);
        j5.writeString(str);
        S.d(j5, aVar);
        S.d(j5, aVar2);
        S.d(j5, aVar3);
        k(33, j5);
    }

    public final void onActivityCreatedByScionActivityInfo(L0 l02, Bundle bundle, long j5) {
        Parcel j6 = j();
        S.c(j6, l02);
        S.c(j6, bundle);
        j6.writeLong(j5);
        k(53, j6);
    }

    public final void onActivityDestroyedByScionActivityInfo(L0 l02, long j5) {
        Parcel j6 = j();
        S.c(j6, l02);
        j6.writeLong(j5);
        k(54, j6);
    }

    public final void onActivityPausedByScionActivityInfo(L0 l02, long j5) {
        Parcel j6 = j();
        S.c(j6, l02);
        j6.writeLong(j5);
        k(55, j6);
    }

    public final void onActivityResumedByScionActivityInfo(L0 l02, long j5) {
        Parcel j6 = j();
        S.c(j6, l02);
        j6.writeLong(j5);
        k(56, j6);
    }

    public final void onActivitySaveInstanceStateByScionActivityInfo(L0 l02, C1270z0 z0Var, long j5) {
        Parcel j6 = j();
        S.c(j6, l02);
        S.d(j6, z0Var);
        j6.writeLong(j5);
        k(57, j6);
    }

    public final void onActivityStartedByScionActivityInfo(L0 l02, long j5) {
        Parcel j6 = j();
        S.c(j6, l02);
        j6.writeLong(j5);
        k(51, j6);
    }

    public final void onActivityStoppedByScionActivityInfo(L0 l02, long j5) {
        Parcel j6 = j();
        S.c(j6, l02);
        j6.writeLong(j5);
        k(52, j6);
    }

    public final void registerOnMeasurementEventListener(G0 g02) {
        Parcel j5 = j();
        S.d(j5, g02);
        k(35, j5);
    }

    public final void retrieveAndUploadBatches(C0 c02) {
        Parcel j5 = j();
        S.d(j5, c02);
        k(58, j5);
    }

    public final void setConditionalUserProperty(Bundle bundle, long j5) {
        Parcel j6 = j();
        S.c(j6, bundle);
        j6.writeLong(j5);
        k(8, j6);
    }

    public final void setCurrentScreenByScionActivityInfo(L0 l02, String str, String str2, long j5) {
        Parcel j6 = j();
        S.c(j6, l02);
        j6.writeString(str);
        j6.writeString(str2);
        j6.writeLong(j5);
        k(50, j6);
    }

    public final void setDataCollectionEnabled(boolean z4) {
        Parcel j5 = j();
        int i5 = S.f5169b;
        j5.writeInt(z4 ? 1 : 0);
        k(39, j5);
    }

    public final void setMeasurementEnabled(boolean z4, long j5) {
        Parcel j6 = j();
        int i5 = S.f5169b;
        j6.writeInt(z4 ? 1 : 0);
        j6.writeLong(j5);
        k(11, j6);
    }

    public final void setUserProperty(String str, String str2, a aVar, boolean z4, long j5) {
        Parcel j6 = j();
        j6.writeString(str);
        j6.writeString(str2);
        S.d(j6, aVar);
        j6.writeInt(z4 ? 1 : 0);
        j6.writeLong(j5);
        k(4, j6);
    }
}
