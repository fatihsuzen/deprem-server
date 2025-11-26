package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import com.mbridge.msdk.newreward.function.command.e;
import java.util.Map;

public final class b implements com.mbridge.msdk.newreward.function.command.receiver.b {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008f A[Catch:{ Exception -> 0x003e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r11) {
        /*
            r10 = this;
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Exception -> 0x003e }
            java.lang.String r0 = "result"
            java.lang.Object r0 = r11.get(r0)     // Catch:{ Exception -> 0x003e }
            com.mbridge.msdk.newreward.function.command.e r0 = (com.mbridge.msdk.newreward.function.command.e) r0     // Catch:{ Exception -> 0x003e }
            java.lang.String r1 = "obj_map"
            java.lang.Object r1 = r11.get(r1)     // Catch:{ Exception -> 0x003e }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = "type"
            java.lang.Object r2 = r11.get(r2)     // Catch:{ Exception -> 0x003e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x003e }
            int r3 = r2.hashCode()     // Catch:{ Exception -> 0x003e }
            r4 = -2057274110(0xffffffff85607d02, float:-1.055539E-35)
            r5 = 2
            r6 = 1
            java.lang.String r7 = "bridge_ids"
            java.lang.String r8 = "offset"
            java.lang.String r9 = "daily"
            if (r3 == r4) goto L_0x0049
            r4 = -1019779949(0xffffffffc3376493, float:-183.39287)
            if (r3 == r4) goto L_0x0041
            r4 = 95346201(0x5aede19, float:1.6444467E-35)
            if (r3 == r4) goto L_0x0036
            goto L_0x0051
        L_0x0036:
            boolean r2 = r2.equals(r9)     // Catch:{ Exception -> 0x003e }
            if (r2 == 0) goto L_0x0051
            r2 = 0
            goto L_0x0052
        L_0x003e:
            r11 = move-exception
            goto L_0x00ba
        L_0x0041:
            boolean r2 = r2.equals(r8)     // Catch:{ Exception -> 0x003e }
            if (r2 == 0) goto L_0x0051
            r2 = r6
            goto L_0x0052
        L_0x0049:
            boolean r2 = r2.equals(r7)     // Catch:{ Exception -> 0x003e }
            if (r2 == 0) goto L_0x0051
            r2 = r5
            goto L_0x0052
        L_0x0051:
            r2 = -1
        L_0x0052:
            java.lang.String r3 = "mb_ad_unit_id"
            java.lang.String r4 = "mb_ad_pid"
            if (r2 == 0) goto L_0x008f
            if (r2 == r6) goto L_0x007c
            if (r2 == r5) goto L_0x005d
            goto L_0x0095
        L_0x005d:
            boolean r2 = r10.a(r7, r0, r1)     // Catch:{ Exception -> 0x003e }
            if (r2 == 0) goto L_0x0064
            goto L_0x0095
        L_0x0064:
            com.mbridge.msdk.out.MBridgeIds r2 = new com.mbridge.msdk.out.MBridgeIds     // Catch:{ Exception -> 0x003e }
            java.lang.Object r4 = r11.get(r4)     // Catch:{ Exception -> 0x003e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x003e }
            java.lang.Object r11 = r11.get(r3)     // Catch:{ Exception -> 0x003e }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x003e }
            r2.<init>(r4, r11)     // Catch:{ Exception -> 0x003e }
            r1.put(r7, r2)     // Catch:{ Exception -> 0x003e }
            r0.a((java.lang.Object) r2)     // Catch:{ Exception -> 0x003e }
            return
        L_0x007c:
            boolean r11 = r10.a(r8, r0, r1)     // Catch:{ Exception -> 0x003e }
            if (r11 == 0) goto L_0x0083
            goto L_0x0095
        L_0x0083:
            com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager r11 = new com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager     // Catch:{ Exception -> 0x003e }
            r11.<init>()     // Catch:{ Exception -> 0x003e }
            r1.put(r8, r11)     // Catch:{ Exception -> 0x003e }
            r0.a((java.lang.Object) r11)     // Catch:{ Exception -> 0x003e }
            return
        L_0x008f:
            boolean r2 = r10.a(r9, r0, r1)     // Catch:{ Exception -> 0x003e }
            if (r2 == 0) goto L_0x0096
        L_0x0095:
            return
        L_0x0096:
            com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel r2 = new com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel     // Catch:{ Exception -> 0x003e }
            java.lang.String r5 = "mb_ad_type"
            java.lang.Object r5 = r11.get(r5)     // Catch:{ Exception -> 0x003e }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ Exception -> 0x003e }
            int r5 = r5.intValue()     // Catch:{ Exception -> 0x003e }
            java.lang.Object r4 = r11.get(r4)     // Catch:{ Exception -> 0x003e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x003e }
            java.lang.Object r11 = r11.get(r3)     // Catch:{ Exception -> 0x003e }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x003e }
            r2.<init>(r5, r4, r11)     // Catch:{ Exception -> 0x003e }
            r1.put(r9, r2)     // Catch:{ Exception -> 0x003e }
            r0.a((java.lang.Object) r2)     // Catch:{ Exception -> 0x003e }
            return
        L_0x00ba:
            java.lang.String r0 = "CreateObjectReceiver"
            java.lang.String r1 = "action"
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.b.a(java.lang.Object):void");
    }

    private boolean a(String str, e eVar, Map map) {
        if (map.get(str) == null) {
            return false;
        }
        eVar.a(map.get(str));
        return true;
    }
}
