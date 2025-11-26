package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.measurement.v0  reason: case insensitive filesystem */
public abstract class C1236v0 extends Q implements C1245w0 {
    public C1236v0() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static C1245w0 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof C1245w0) {
            return (C1245w0) queryLocalInterface;
        }
        return new C1227u0(iBinder);
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v3, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v9, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v14, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v19, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v25, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v29, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v33, types: [com.google.android.gms.internal.measurement.I0] */
    /* JADX WARNING: type inference failed for: r4v37, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v41, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v45, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v49, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v53, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v58, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v65, types: [com.google.android.gms.internal.measurement.G0] */
    /* JADX WARNING: type inference failed for: r4v69, types: [com.google.android.gms.internal.measurement.G0] */
    /* JADX WARNING: type inference failed for: r4v73, types: [com.google.android.gms.internal.measurement.G0] */
    /* JADX WARNING: type inference failed for: r4v77, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v81, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v85, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v91, types: [com.google.android.gms.internal.measurement.z0] */
    /* JADX WARNING: type inference failed for: r4v96, types: [com.google.android.gms.internal.measurement.C0] */
    /* JADX WARNING: type inference failed for: r4v101 */
    /* JADX WARNING: type inference failed for: r4v102 */
    /* JADX WARNING: type inference failed for: r4v103 */
    /* JADX WARNING: type inference failed for: r4v104 */
    /* JADX WARNING: type inference failed for: r4v105 */
    /* JADX WARNING: type inference failed for: r4v106 */
    /* JADX WARNING: type inference failed for: r4v107 */
    /* JADX WARNING: type inference failed for: r4v108 */
    /* JADX WARNING: type inference failed for: r4v109 */
    /* JADX WARNING: type inference failed for: r4v110 */
    /* JADX WARNING: type inference failed for: r4v111 */
    /* JADX WARNING: type inference failed for: r4v112 */
    /* JADX WARNING: type inference failed for: r4v113 */
    /* JADX WARNING: type inference failed for: r4v114 */
    /* JADX WARNING: type inference failed for: r4v115 */
    /* JADX WARNING: type inference failed for: r4v116 */
    /* JADX WARNING: type inference failed for: r4v117 */
    /* JADX WARNING: type inference failed for: r4v118 */
    /* JADX WARNING: type inference failed for: r4v119 */
    /* JADX WARNING: type inference failed for: r4v120 */
    /* JADX WARNING: type inference failed for: r4v121 */
    /* JADX WARNING: type inference failed for: r4v122 */
    /* JADX WARNING: type inference failed for: r4v123 */
    /* JADX WARNING: type inference failed for: r4v124 */
    /* JADX WARNING: type inference failed for: r4v125 */
    /* JADX WARNING: type inference failed for: r4v126 */
    /* JADX WARNING: type inference failed for: r4v127 */
    /* JADX WARNING: type inference failed for: r4v128 */
    /* JADX WARNING: type inference failed for: r4v129 */
    /* JADX WARNING: type inference failed for: r4v130 */
    /* JADX WARNING: type inference failed for: r4v131 */
    /* JADX WARNING: type inference failed for: r4v132 */
    /* JADX WARNING: type inference failed for: r4v133 */
    /* JADX WARNING: type inference failed for: r4v134 */
    /* JADX WARNING: type inference failed for: r4v135 */
    /* JADX WARNING: type inference failed for: r4v136 */
    /* JADX WARNING: type inference failed for: r4v137 */
    /* JADX WARNING: type inference failed for: r4v138 */
    /* JADX WARNING: type inference failed for: r4v139 */
    /* JADX WARNING: type inference failed for: r4v140 */
    /* JADX WARNING: type inference failed for: r4v141 */
    /* JADX WARNING: type inference failed for: r4v142 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) {
        /*
            r8 = this;
            java.lang.String r2 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy"
            java.lang.String r3 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            r4 = 0
            switch(r9) {
                case 1: goto L_0x05a9;
                case 2: goto L_0x0584;
                case 3: goto L_0x054f;
                case 4: goto L_0x052e;
                case 5: goto L_0x0502;
                case 6: goto L_0x04de;
                case 7: goto L_0x04ce;
                case 8: goto L_0x04ba;
                case 9: goto L_0x04a2;
                case 10: goto L_0x047a;
                case 11: goto L_0x046a;
                case 12: goto L_0x045e;
                case 13: goto L_0x0452;
                case 14: goto L_0x0446;
                case 15: goto L_0x0429;
                case 16: goto L_0x0409;
                case 17: goto L_0x03e9;
                case 18: goto L_0x03c7;
                case 19: goto L_0x03a7;
                case 20: goto L_0x0387;
                case 21: goto L_0x0367;
                case 22: goto L_0x0347;
                case 23: goto L_0x0337;
                case 24: goto L_0x0327;
                case 25: goto L_0x0313;
                case 26: goto L_0x02ff;
                case 27: goto L_0x02e3;
                case 28: goto L_0x02cf;
                case 29: goto L_0x02bb;
                case 30: goto L_0x02a7;
                case 31: goto L_0x027b;
                case 32: goto L_0x024f;
                case 33: goto L_0x0226;
                case 34: goto L_0x0206;
                case 35: goto L_0x01e6;
                case 36: goto L_0x01c6;
                case 37: goto L_0x01ba;
                case 38: goto L_0x0196;
                case 39: goto L_0x018a;
                case 40: goto L_0x016a;
                case 41: goto L_0x0008;
                case 42: goto L_0x015a;
                case 43: goto L_0x014e;
                case 44: goto L_0x013a;
                case 45: goto L_0x0126;
                case 46: goto L_0x0106;
                case 47: goto L_0x0008;
                case 48: goto L_0x00f6;
                case 49: goto L_0x0008;
                case 50: goto L_0x00d8;
                case 51: goto L_0x00c4;
                case 52: goto L_0x00b0;
                case 53: goto L_0x0094;
                case 54: goto L_0x0080;
                case 55: goto L_0x006c;
                case 56: goto L_0x0058;
                case 57: goto L_0x002c;
                case 58: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            r1 = 0
            return r1
        L_0x000a:
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x0011
            goto L_0x0024
        L_0x0011:
            java.lang.String r3 = "com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.C0
            if (r4 == 0) goto L_0x001f
            r4 = r3
            com.google.android.gms.internal.measurement.C0 r4 = (com.google.android.gms.internal.measurement.C0) r4
            goto L_0x0024
        L_0x001f:
            com.google.android.gms.internal.measurement.A0 r4 = new com.google.android.gms.internal.measurement.A0
            r4.<init>(r2)
        L_0x0024:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.retrieveAndUploadBatches(r4)
            goto L_0x05c3
        L_0x002c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.L0> r2 = com.google.android.gms.internal.measurement.L0.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.S.b(r10, r2)
            com.google.android.gms.internal.measurement.L0 r2 = (com.google.android.gms.internal.measurement.L0) r2
            android.os.IBinder r5 = r10.readStrongBinder()
            if (r5 != 0) goto L_0x003b
            goto L_0x004c
        L_0x003b:
            android.os.IInterface r3 = r5.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r4 == 0) goto L_0x0047
            r4 = r3
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x004c
        L_0x0047:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r5)
        L_0x004c:
            long r5 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivitySaveInstanceStateByScionActivityInfo(r2, r4, r5)
            goto L_0x05c3
        L_0x0058:
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.L0> r2 = com.google.android.gms.internal.measurement.L0.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.S.b(r10, r2)
            com.google.android.gms.internal.measurement.L0 r2 = (com.google.android.gms.internal.measurement.L0) r2
            long r3 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityResumedByScionActivityInfo(r2, r3)
            goto L_0x05c3
        L_0x006c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.L0> r2 = com.google.android.gms.internal.measurement.L0.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.S.b(r10, r2)
            com.google.android.gms.internal.measurement.L0 r2 = (com.google.android.gms.internal.measurement.L0) r2
            long r3 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityPausedByScionActivityInfo(r2, r3)
            goto L_0x05c3
        L_0x0080:
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.L0> r2 = com.google.android.gms.internal.measurement.L0.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.S.b(r10, r2)
            com.google.android.gms.internal.measurement.L0 r2 = (com.google.android.gms.internal.measurement.L0) r2
            long r3 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityDestroyedByScionActivityInfo(r2, r3)
            goto L_0x05c3
        L_0x0094:
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.L0> r2 = com.google.android.gms.internal.measurement.L0.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.S.b(r10, r2)
            com.google.android.gms.internal.measurement.L0 r2 = (com.google.android.gms.internal.measurement.L0) r2
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.S.b(r10, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            long r4 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityCreatedByScionActivityInfo(r2, r3, r4)
            goto L_0x05c3
        L_0x00b0:
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.L0> r2 = com.google.android.gms.internal.measurement.L0.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.S.b(r10, r2)
            com.google.android.gms.internal.measurement.L0 r2 = (com.google.android.gms.internal.measurement.L0) r2
            long r3 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityStoppedByScionActivityInfo(r2, r3)
            goto L_0x05c3
        L_0x00c4:
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.L0> r2 = com.google.android.gms.internal.measurement.L0.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.S.b(r10, r2)
            com.google.android.gms.internal.measurement.L0 r2 = (com.google.android.gms.internal.measurement.L0) r2
            long r3 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityStartedByScionActivityInfo(r2, r3)
            goto L_0x05c3
        L_0x00d8:
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.L0> r2 = com.google.android.gms.internal.measurement.L0.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.S.b(r10, r2)
            com.google.android.gms.internal.measurement.L0 r2 = (com.google.android.gms.internal.measurement.L0) r2
            r1 = r2
            java.lang.String r2 = r10.readString()
            java.lang.String r3 = r10.readString()
            long r4 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r0 = r8
            r0.setCurrentScreenByScionActivityInfo(r1, r2, r3, r4)
            goto L_0x05c3
        L_0x00f6:
            android.os.Parcelable$Creator r1 = android.content.Intent.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.S.b(r10, r1)
            android.content.Intent r1 = (android.content.Intent) r1
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setSgtmDebugInfo(r1)
            goto L_0x05c3
        L_0x0106:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x010d
            goto L_0x011e
        L_0x010d:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r3 == 0) goto L_0x0119
            r4 = r2
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x011e
        L_0x0119:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r1)
        L_0x011e:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.getSessionId(r4)
            goto L_0x05c3
        L_0x0126:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.S.b(r10, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setConsentThirdParty(r1, r2)
            goto L_0x05c3
        L_0x013a:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.S.b(r10, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setConsent(r1, r2)
            goto L_0x05c3
        L_0x014e:
            long r1 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.clearMeasurementEnabled(r1)
            goto L_0x05c3
        L_0x015a:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.S.b(r10, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setDefaultEventParameters(r1)
            goto L_0x05c3
        L_0x016a:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x0171
            goto L_0x0182
        L_0x0171:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r3 == 0) goto L_0x017d
            r4 = r2
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x0182
        L_0x017d:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r1)
        L_0x0182:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.isDataCollectionEnabled(r4)
            goto L_0x05c3
        L_0x018a:
            boolean r1 = com.google.android.gms.internal.measurement.S.a(r10)
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setDataCollectionEnabled(r1)
            goto L_0x05c3
        L_0x0196:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x019d
            goto L_0x01ae
        L_0x019d:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r3 == 0) goto L_0x01a9
            r4 = r2
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x01ae
        L_0x01a9:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r1)
        L_0x01ae:
            int r1 = r10.readInt()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.getTestFlag(r4, r1)
            goto L_0x05c3
        L_0x01ba:
            java.util.HashMap r1 = com.google.android.gms.internal.measurement.S.e(r10)
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.initForTests(r1)
            goto L_0x05c3
        L_0x01c6:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x01cd
            goto L_0x01de
        L_0x01cd:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.G0
            if (r3 == 0) goto L_0x01d9
            r4 = r2
            com.google.android.gms.internal.measurement.G0 r4 = (com.google.android.gms.internal.measurement.G0) r4
            goto L_0x01de
        L_0x01d9:
            com.google.android.gms.internal.measurement.D0 r4 = new com.google.android.gms.internal.measurement.D0
            r4.<init>(r1)
        L_0x01de:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.unregisterOnMeasurementEventListener(r4)
            goto L_0x05c3
        L_0x01e6:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x01ed
            goto L_0x01fe
        L_0x01ed:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.G0
            if (r3 == 0) goto L_0x01f9
            r4 = r2
            com.google.android.gms.internal.measurement.G0 r4 = (com.google.android.gms.internal.measurement.G0) r4
            goto L_0x01fe
        L_0x01f9:
            com.google.android.gms.internal.measurement.D0 r4 = new com.google.android.gms.internal.measurement.D0
            r4.<init>(r1)
        L_0x01fe:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.registerOnMeasurementEventListener(r4)
            goto L_0x05c3
        L_0x0206:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x020d
            goto L_0x021e
        L_0x020d:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.G0
            if (r3 == 0) goto L_0x0219
            r4 = r2
            com.google.android.gms.internal.measurement.G0 r4 = (com.google.android.gms.internal.measurement.G0) r4
            goto L_0x021e
        L_0x0219:
            com.google.android.gms.internal.measurement.D0 r4 = new com.google.android.gms.internal.measurement.D0
            r4.<init>(r1)
        L_0x021e:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setEventInterceptor(r4)
            goto L_0x05c3
        L_0x0226:
            int r1 = r10.readInt()
            java.lang.String r2 = r10.readString()
            android.os.IBinder r3 = r10.readStrongBinder()
            U.a r3 = U.a.C0060a.j(r3)
            android.os.IBinder r4 = r10.readStrongBinder()
            U.a r4 = U.a.C0060a.j(r4)
            android.os.IBinder r5 = r10.readStrongBinder()
            U.a r5 = U.a.C0060a.j(r5)
            com.google.android.gms.internal.measurement.S.f(r10)
            r0 = r8
            r0.logHealthData(r1, r2, r3, r4, r5)
            goto L_0x05c3
        L_0x024f:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.S.b(r10, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x025e
            goto L_0x026f
        L_0x025e:
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r4 == 0) goto L_0x026a
            r4 = r3
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x026f
        L_0x026a:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r2)
        L_0x026f:
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.performAction(r1, r4, r2)
            goto L_0x05c3
        L_0x027b:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0060a.j(r1)
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x028a
            goto L_0x029b
        L_0x028a:
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r4 == 0) goto L_0x0296
            r4 = r3
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x029b
        L_0x0296:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r2)
        L_0x029b:
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivitySaveInstanceState(r1, r4, r2)
            goto L_0x05c3
        L_0x02a7:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0060a.j(r1)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityResumed(r1, r2)
            goto L_0x05c3
        L_0x02bb:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0060a.j(r1)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityPaused(r1, r2)
            goto L_0x05c3
        L_0x02cf:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0060a.j(r1)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityDestroyed(r1, r2)
            goto L_0x05c3
        L_0x02e3:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0060a.j(r1)
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.S.b(r10, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            long r3 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityCreated(r1, r2, r3)
            goto L_0x05c3
        L_0x02ff:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0060a.j(r1)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityStopped(r1, r2)
            goto L_0x05c3
        L_0x0313:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0060a.j(r1)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.onActivityStarted(r1, r2)
            goto L_0x05c3
        L_0x0327:
            java.lang.String r1 = r10.readString()
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.endAdUnitExposure(r1, r2)
            goto L_0x05c3
        L_0x0337:
            java.lang.String r1 = r10.readString()
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.beginAdUnitExposure(r1, r2)
            goto L_0x05c3
        L_0x0347:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x034e
            goto L_0x035f
        L_0x034e:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r3 == 0) goto L_0x035a
            r4 = r2
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x035f
        L_0x035a:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r1)
        L_0x035f:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.generateEventId(r4)
            goto L_0x05c3
        L_0x0367:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x036e
            goto L_0x037f
        L_0x036e:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r3 == 0) goto L_0x037a
            r4 = r2
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x037f
        L_0x037a:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r1)
        L_0x037f:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.getGmpAppId(r4)
            goto L_0x05c3
        L_0x0387:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x038e
            goto L_0x039f
        L_0x038e:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r3 == 0) goto L_0x039a
            r4 = r2
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x039f
        L_0x039a:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r1)
        L_0x039f:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.getAppInstanceId(r4)
            goto L_0x05c3
        L_0x03a7:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x03ae
            goto L_0x03bf
        L_0x03ae:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r3 == 0) goto L_0x03ba
            r4 = r2
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x03bf
        L_0x03ba:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r1)
        L_0x03bf:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.getCachedAppInstanceId(r4)
            goto L_0x05c3
        L_0x03c7:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x03ce
            goto L_0x03e1
        L_0x03ce:
            java.lang.String r2 = "com.google.android.gms.measurement.api.internal.IStringProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.I0
            if (r3 == 0) goto L_0x03dc
            r4 = r2
            com.google.android.gms.internal.measurement.I0 r4 = (com.google.android.gms.internal.measurement.I0) r4
            goto L_0x03e1
        L_0x03dc:
            com.google.android.gms.internal.measurement.H0 r4 = new com.google.android.gms.internal.measurement.H0
            r4.<init>(r1)
        L_0x03e1:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setInstanceIdProvider(r4)
            goto L_0x05c3
        L_0x03e9:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x03f0
            goto L_0x0401
        L_0x03f0:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r3 == 0) goto L_0x03fc
            r4 = r2
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x0401
        L_0x03fc:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r1)
        L_0x0401:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.getCurrentScreenClass(r4)
            goto L_0x05c3
        L_0x0409:
            android.os.IBinder r1 = r10.readStrongBinder()
            if (r1 != 0) goto L_0x0410
            goto L_0x0421
        L_0x0410:
            android.os.IInterface r2 = r1.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r3 == 0) goto L_0x041c
            r4 = r2
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x0421
        L_0x041c:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r1)
        L_0x0421:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.getCurrentScreenName(r4)
            goto L_0x05c3
        L_0x0429:
            android.os.IBinder r1 = r10.readStrongBinder()
            U.a r1 = U.a.C0060a.j(r1)
            java.lang.String r2 = r10.readString()
            java.lang.String r3 = r10.readString()
            long r4 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r0 = r8
            r0.setCurrentScreen(r1, r2, r3, r4)
            goto L_0x05c3
        L_0x0446:
            long r1 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setSessionTimeoutDuration(r1)
            goto L_0x05c3
        L_0x0452:
            long r1 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setMinimumSessionDuration(r1)
            goto L_0x05c3
        L_0x045e:
            long r1 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.resetAnalyticsData(r1)
            goto L_0x05c3
        L_0x046a:
            boolean r1 = com.google.android.gms.internal.measurement.S.a(r10)
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setMeasurementEnabled(r1, r2)
            goto L_0x05c3
        L_0x047a:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.IBinder r5 = r10.readStrongBinder()
            if (r5 != 0) goto L_0x0489
            goto L_0x049a
        L_0x0489:
            android.os.IInterface r3 = r5.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r4 == 0) goto L_0x0495
            r4 = r3
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x049a
        L_0x0495:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r5)
        L_0x049a:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.getConditionalUserProperties(r1, r2, r4)
            goto L_0x05c3
        L_0x04a2:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.S.b(r10, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.clearConditionalUserProperty(r1, r2, r3)
            goto L_0x05c3
        L_0x04ba:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.S.b(r10, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setConditionalUserProperty(r1, r2)
            goto L_0x05c3
        L_0x04ce:
            java.lang.String r1 = r10.readString()
            long r2 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.setUserId(r1, r2)
            goto L_0x05c3
        L_0x04de:
            java.lang.String r1 = r10.readString()
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x04e9
            goto L_0x04fa
        L_0x04e9:
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r4 == 0) goto L_0x04f5
            r4 = r3
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x04fa
        L_0x04f5:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r2)
        L_0x04fa:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.getMaxUserProperties(r1, r4)
            goto L_0x05c3
        L_0x0502:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            boolean r5 = com.google.android.gms.internal.measurement.S.a(r10)
            android.os.IBinder r7 = r10.readStrongBinder()
            if (r7 != 0) goto L_0x0515
            goto L_0x0526
        L_0x0515:
            android.os.IInterface r3 = r7.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r4 == 0) goto L_0x0521
            r4 = r3
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x0526
        L_0x0521:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r7)
        L_0x0526:
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.getUserProperties(r1, r2, r5, r4)
            goto L_0x05c3
        L_0x052e:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.IBinder r3 = r10.readStrongBinder()
            U.a r3 = U.a.C0060a.j(r3)
            boolean r4 = com.google.android.gms.internal.measurement.S.a(r10)
            long r5 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r0 = r8
            r0.setUserProperty(r1, r2, r3, r4, r5)
            goto L_0x05c3
        L_0x054f:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.S.b(r10, r0)
            android.os.Bundle r0 = (android.os.Bundle) r0
            android.os.IBinder r5 = r10.readStrongBinder()
            if (r5 != 0) goto L_0x0566
            goto L_0x0577
        L_0x0566:
            android.os.IInterface r3 = r5.queryLocalInterface(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.C1270z0
            if (r4 == 0) goto L_0x0572
            r4 = r3
            com.google.android.gms.internal.measurement.z0 r4 = (com.google.android.gms.internal.measurement.C1270z0) r4
            goto L_0x0577
        L_0x0572:
            com.google.android.gms.internal.measurement.x0 r4 = new com.google.android.gms.internal.measurement.x0
            r4.<init>(r5)
        L_0x0577:
            long r5 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r3 = r0
            r0 = r8
            r0.logEventAndBundle(r1, r2, r3, r4, r5)
            goto L_0x05c3
        L_0x0584:
            java.lang.String r1 = r10.readString()
            java.lang.String r2 = r10.readString()
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.S.b(r10, r0)
            r3 = r0
            android.os.Bundle r3 = (android.os.Bundle) r3
            boolean r4 = com.google.android.gms.internal.measurement.S.a(r10)
            boolean r5 = com.google.android.gms.internal.measurement.S.a(r10)
            long r6 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r0 = r8
            r0.logEvent(r1, r2, r3, r4, r5, r6)
            goto L_0x05c3
        L_0x05a9:
            android.os.IBinder r2 = r10.readStrongBinder()
            U.a r2 = U.a.C0060a.j(r2)
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.J0> r3 = com.google.android.gms.internal.measurement.J0.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.S.b(r10, r3)
            com.google.android.gms.internal.measurement.J0 r3 = (com.google.android.gms.internal.measurement.J0) r3
            long r4 = r10.readLong()
            com.google.android.gms.internal.measurement.S.f(r10)
            r8.initialize(r2, r3, r4)
        L_0x05c3:
            r11.writeNoException()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1236v0.i(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
