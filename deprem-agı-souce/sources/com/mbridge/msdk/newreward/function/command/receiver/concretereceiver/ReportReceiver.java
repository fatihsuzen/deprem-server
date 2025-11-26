package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.b;

@ReceiverAction(id = "ReportReceiver", type = b.class)
public class ReportReceiver implements b {

    /* renamed from: a  reason: collision with root package name */
    private e f10783a;

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.newreward.b.b f10784b;

    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.ReportReceiver$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10785a;

        static {
            int[] iArr = new int[f.values().length];
            f10785a = iArr;
            try {
                iArr[f.REPORT_LOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public ReportReceiver() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.String r0 = "metrics_report_key"
            java.lang.String r1 = "metrics_data"
            java.lang.String r2 = "adapter_model"
            boolean r3 = r7 instanceof com.mbridge.msdk.newreward.function.command.b
            java.lang.String r4 = ""
            r5 = 0
            if (r3 == 0) goto L_0x015b
            com.mbridge.msdk.newreward.function.command.b r7 = (com.mbridge.msdk.newreward.function.command.b) r7
            java.lang.Object r0 = r7.b()     // Catch:{ Exception -> 0x001e }
            boolean r0 = r0 instanceof java.util.Map     // Catch:{ Exception -> 0x001e }
            if (r0 == 0) goto L_0x0021
            java.lang.Object r0 = r7.b()     // Catch:{ Exception -> 0x001e }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x001e }
            goto L_0x0022
        L_0x001e:
            r7 = move-exception
            goto L_0x0153
        L_0x0021:
            r0 = r5
        L_0x0022:
            com.mbridge.msdk.newreward.a.e r1 = r6.f10783a     // Catch:{ Exception -> 0x001e }
            if (r1 == 0) goto L_0x0139
            com.mbridge.msdk.newreward.function.e.c r1 = r1.z()     // Catch:{ Exception -> 0x001e }
            if (r1 == 0) goto L_0x0139
            int[] r1 = com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.ReportReceiver.AnonymousClass1.f10785a     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.newreward.function.command.f r2 = r7.a()     // Catch:{ Exception -> 0x001e }
            int r2 = r2.ordinal()     // Catch:{ Exception -> 0x001e }
            r1 = r1[r2]     // Catch:{ Exception -> 0x001e }
            r2 = 1
            if (r1 == r2) goto L_0x0052
            com.mbridge.msdk.newreward.a.e r1 = r6.f10783a     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.newreward.function.e.c r1 = r1.z()     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.newreward.a.e r2 = r6.f10783a     // Catch:{ Exception -> 0x001e }
            if (r0 != 0) goto L_0x004a
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x001e }
            r0.<init>()     // Catch:{ Exception -> 0x001e }
        L_0x004a:
            com.mbridge.msdk.newreward.function.command.f r7 = r7.a()     // Catch:{ Exception -> 0x001e }
            r1.a((com.mbridge.msdk.newreward.a.e) r2, (java.util.Map) r0, (com.mbridge.msdk.newreward.function.command.f) r7)     // Catch:{ Exception -> 0x001e }
            return
        L_0x0052:
            com.mbridge.msdk.newreward.a.e r7 = r6.f10783a     // Catch:{ Exception -> 0x001e }
            r7.z()     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.newreward.a.e r7 = r6.f10783a     // Catch:{ Exception -> 0x001e }
            if (r7 != 0) goto L_0x005d
            goto L_0x01ae
        L_0x005d:
            com.mbridge.msdk.newreward.function.e.a r0 = r7.D()     // Catch:{ Exception -> 0x0089 }
            if (r0 == 0) goto L_0x008c
            com.mbridge.msdk.newreward.function.e.a r0 = r7.D()     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.newreward.function.c.a.b r0 = r0.b()     // Catch:{ Exception -> 0x0089 }
            if (r0 == 0) goto L_0x008c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0089 }
            r0.<init>()     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.newreward.function.e.a r1 = r7.D()     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.newreward.function.c.a.b r1 = r1.b()     // Catch:{ Exception -> 0x0089 }
            int r1 = r1.a()     // Catch:{ Exception -> 0x0089 }
            r0.append(r1)     // Catch:{ Exception -> 0x0089 }
            r0.append(r4)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = r0.toString()     // Catch:{ Exception -> 0x0089 }
            goto L_0x008c
        L_0x0089:
            r7 = move-exception
            goto L_0x0130
        L_0x008c:
            com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0089 }
            java.lang.String r1 = r7.G()     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.foundation.same.report.d.c r0 = r0.a((java.lang.String) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x0089 }
            if (r0 != 0) goto L_0x00cb
            com.mbridge.msdk.foundation.same.report.d.c r0 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x0089 }
            r0.<init>()     // Catch:{ Exception -> 0x0089 }
            java.lang.String r1 = r7.G()     // Catch:{ Exception -> 0x0089 }
            r0.c((java.lang.String) r1)     // Catch:{ Exception -> 0x0089 }
            int r1 = r7.h()     // Catch:{ Exception -> 0x0089 }
            r0.b((int) r1)     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.foundation.same.report.d.d r1 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0089 }
            java.util.LinkedHashMap r1 = r1.b()     // Catch:{ Exception -> 0x0089 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0089 }
            r2.<init>()     // Catch:{ Exception -> 0x0089 }
            java.lang.String r3 = r7.G()     // Catch:{ Exception -> 0x0089 }
            r2.append(r3)     // Catch:{ Exception -> 0x0089 }
            r2.append(r4)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0089 }
            r1.put(r2, r0)     // Catch:{ Exception -> 0x0089 }
        L_0x00cb:
            java.lang.String r1 = r7.H()     // Catch:{ Exception -> 0x0089 }
            r0.d((java.lang.String) r1)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r1 = r7.J()     // Catch:{ Exception -> 0x0089 }
            r0.e((java.lang.String) r1)     // Catch:{ Exception -> 0x0089 }
            boolean r1 = r7.R()     // Catch:{ Exception -> 0x0089 }
            if (r1 == 0) goto L_0x00e2
            java.lang.String r1 = "1"
            goto L_0x00e4
        L_0x00e2:
            java.lang.String r1 = "0"
        L_0x00e4:
            r0.i(r1)     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.newreward.function.e.f r1 = r7.x()     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.videocommon.d.a r1 = r1.a()     // Catch:{ Exception -> 0x0089 }
            if (r1 == 0) goto L_0x00ff
            java.lang.String r2 = r1.b()     // Catch:{ Exception -> 0x0089 }
            r0.h(r2)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x0089 }
            r0.f((java.lang.String) r1)     // Catch:{ Exception -> 0x0089 }
        L_0x00ff:
            com.mbridge.msdk.newreward.function.e.f r7 = r7.x()     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.videocommon.d.c r7 = r7.b()     // Catch:{ Exception -> 0x0089 }
            if (r7 == 0) goto L_0x0117
            java.lang.String r1 = r7.l()     // Catch:{ Exception -> 0x0089 }
            r0.g((java.lang.String) r1)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r7 = r7.k()     // Catch:{ Exception -> 0x0089 }
            r0.n(r7)     // Catch:{ Exception -> 0x0089 }
        L_0x0117:
            java.lang.String r7 = "2000123"
            r0.a((java.lang.String) r7)     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.foundation.same.report.d.d r7 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0089 }
            r7.a((com.mbridge.msdk.foundation.same.report.d.c) r0)     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.foundation.same.report.d.d r7 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0089 }
            java.lang.String r1 = r0.c()     // Catch:{ Exception -> 0x0089 }
            r7.a((java.lang.String) r1, (com.mbridge.msdk.foundation.same.report.d.c) r0, (com.mbridge.msdk.foundation.same.report.d.a.a) r5)     // Catch:{ Exception -> 0x0089 }
            goto L_0x01ae
        L_0x0130:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x001e }
            if (r0 == 0) goto L_0x01ae
            r7.printStackTrace()     // Catch:{ Exception -> 0x001e }
            goto L_0x01ae
        L_0x0139:
            com.mbridge.msdk.newreward.b.b r1 = r6.f10784b     // Catch:{ Exception -> 0x001e }
            if (r1 == 0) goto L_0x01ae
            com.mbridge.msdk.newreward.function.e.c r1 = new com.mbridge.msdk.newreward.function.e.c     // Catch:{ Exception -> 0x001e }
            r1.<init>()     // Catch:{ Exception -> 0x001e }
            com.mbridge.msdk.newreward.b.b r2 = r6.f10784b     // Catch:{ Exception -> 0x001e }
            if (r0 != 0) goto L_0x014b
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x001e }
            r0.<init>()     // Catch:{ Exception -> 0x001e }
        L_0x014b:
            com.mbridge.msdk.newreward.function.command.f r7 = r7.a()     // Catch:{ Exception -> 0x001e }
            r1.a((com.mbridge.msdk.newreward.b.b) r2, (java.util.Map) r0, (com.mbridge.msdk.newreward.function.command.f) r7)     // Catch:{ Exception -> 0x001e }
            goto L_0x01ae
        L_0x0153:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x01ae
            r7.printStackTrace()
            goto L_0x01ae
        L_0x015b:
            boolean r3 = r7 instanceof java.util.Map
            if (r3 == 0) goto L_0x01ae
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x0172 }
            java.lang.Object r3 = r7.get(r2)     // Catch:{ Exception -> 0x0172 }
            boolean r3 = r3 instanceof com.mbridge.msdk.newreward.a.e     // Catch:{ Exception -> 0x0172 }
            if (r3 == 0) goto L_0x0174
            java.lang.Object r2 = r7.get(r2)     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.newreward.a.e r2 = (com.mbridge.msdk.newreward.a.e) r2     // Catch:{ Exception -> 0x0172 }
            r6.f10783a = r2     // Catch:{ Exception -> 0x0172 }
            goto L_0x0174
        L_0x0172:
            r7 = move-exception
            goto L_0x01a7
        L_0x0174:
            java.lang.Object r2 = r7.get(r1)     // Catch:{ Exception -> 0x0172 }
            boolean r2 = r2 instanceof java.util.Map     // Catch:{ Exception -> 0x0172 }
            if (r2 == 0) goto L_0x0183
            java.lang.Object r1 = r7.get(r1)     // Catch:{ Exception -> 0x0172 }
            r5 = r1
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0172 }
        L_0x0183:
            java.lang.Object r1 = r7.get(r0)     // Catch:{ Exception -> 0x0172 }
            boolean r1 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x0172 }
            if (r1 == 0) goto L_0x0192
            java.lang.Object r7 = r7.get(r0)     // Catch:{ Exception -> 0x0172 }
            r4 = r7
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0172 }
        L_0x0192:
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0172 }
            if (r7 == 0) goto L_0x0199
            goto L_0x01ae
        L_0x0199:
            com.mbridge.msdk.newreward.a.e r7 = r6.f10783a     // Catch:{ Exception -> 0x0172 }
            if (r7 == 0) goto L_0x01ae
            com.mbridge.msdk.newreward.function.e.c r7 = r7.z()     // Catch:{ Exception -> 0x0172 }
            com.mbridge.msdk.newreward.a.e r0 = r6.f10783a     // Catch:{ Exception -> 0x0172 }
            r7.a((com.mbridge.msdk.newreward.a.e) r0, (java.util.Map<java.lang.String, java.lang.String>) r5, (java.lang.String) r4)     // Catch:{ Exception -> 0x0172 }
            return
        L_0x01a7:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x01ae
            r7.printStackTrace()
        L_0x01ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.ReportReceiver.a(java.lang.Object):void");
    }

    public ReportReceiver(Object obj) {
        if (obj instanceof e) {
            this.f10783a = (e) obj;
        }
        if (obj instanceof com.mbridge.msdk.newreward.b.b) {
            this.f10784b = (com.mbridge.msdk.newreward.b.b) obj;
        }
    }
}
