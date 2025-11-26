package com.mbridge.msdk.newreward.function.command.receiver.tagreceiver;

import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import u1.a;

@ReceiverAction(id = "OMSDKReceiver", type = b.class)
public class OMSDKReceiver implements b {

    /* renamed from: a  reason: collision with root package name */
    e f10869a;

    /* renamed from: b  reason: collision with root package name */
    Object f10870b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f10871c;

    /* renamed from: d  reason: collision with root package name */
    u1.b f10872d;

    /* renamed from: e  reason: collision with root package name */
    a f10873e;

    /* renamed from: f  reason: collision with root package name */
    v1.b f10874f;

    /* renamed from: g  reason: collision with root package name */
    float f10875g = 0.0f;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:312:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.String r0 = "args"
            boolean r1 = r15 instanceof java.util.Map     // Catch:{ Exception -> 0x002f }
            if (r1 == 0) goto L_0x040a
            java.util.Map r15 = (java.util.Map) r15     // Catch:{ Exception -> 0x002f }
            java.lang.String r1 = "methodName"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ Exception -> 0x002f }
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1     // Catch:{ Exception -> 0x002f }
            java.lang.String r2 = "target"
            java.lang.Object r2 = r15.get(r2)     // Catch:{ Exception -> 0x002f }
            r14.f10870b = r2     // Catch:{ Exception -> 0x002f }
            java.lang.Object r2 = r15.get(r0)     // Catch:{ Exception -> 0x002f }
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r15.get(r0)     // Catch:{ Exception -> 0x002f }
            boolean r2 = r2 instanceof java.lang.Object[]     // Catch:{ Exception -> 0x002f }
            if (r2 == 0) goto L_0x0033
            java.lang.Object r0 = r15.get(r0)     // Catch:{ Exception -> 0x002f }
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch:{ Exception -> 0x002f }
            r14.f10871c = r0     // Catch:{ Exception -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r0 = move-exception
            r15 = r0
            goto L_0x0403
        L_0x0033:
            java.lang.String r0 = "adapter_model"
            java.lang.Object r15 = r15.get(r0)     // Catch:{ Exception -> 0x002f }
            com.mbridge.msdk.newreward.a.e r15 = (com.mbridge.msdk.newreward.a.e) r15     // Catch:{ Exception -> 0x002f }
            r14.f10869a = r15     // Catch:{ Exception -> 0x002f }
            u1.b r15 = r15.ad()     // Catch:{ Exception -> 0x002f }
            r14.f10872d = r15     // Catch:{ Exception -> 0x002f }
            com.mbridge.msdk.newreward.a.e r15 = r14.f10869a     // Catch:{ Exception -> 0x002f }
            u1.a r15 = r15.ae()     // Catch:{ Exception -> 0x002f }
            r14.f10873e = r15     // Catch:{ Exception -> 0x002f }
            com.mbridge.msdk.newreward.a.e r15 = r14.f10869a     // Catch:{ Exception -> 0x002f }
            v1.b r15 = r15.af()     // Catch:{ Exception -> 0x002f }
            r14.f10874f = r15     // Catch:{ Exception -> 0x002f }
            java.lang.String r15 = r1.getName()     // Catch:{ Exception -> 0x002f }
            int r0 = r15.hashCode()     // Catch:{ Exception -> 0x002f }
            r1 = 2
            r2 = 1
            r3 = 0
            switch(r0) {
                case -1606280266: goto L_0x00c0;
                case -934426579: goto L_0x00b6;
                case -266309826: goto L_0x00ac;
                case 106440182: goto L_0x00a2;
                case 157935686: goto L_0x0098;
                case 538494296: goto L_0x008e;
                case 1308882881: goto L_0x0083;
                case 1853386019: goto L_0x0078;
                case 2110051743: goto L_0x006e;
                case 2147444528: goto L_0x0063;
                default: goto L_0x0061;
            }     // Catch:{ Exception -> 0x002f }
        L_0x0061:
            goto L_0x00ca
        L_0x0063:
            java.lang.String r0 = "skipped"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00ca
            r15 = 7
            goto L_0x00cb
        L_0x006e:
            java.lang.String r0 = "onBufferingStart"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00ca
            r15 = 4
            goto L_0x00cb
        L_0x0078:
            java.lang.String r0 = "activityReport"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00ca
            r15 = 9
            goto L_0x00cb
        L_0x0083:
            java.lang.String r0 = "checkOMSdkProgress"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00ca
            r15 = 8
            goto L_0x00cb
        L_0x008e:
            java.lang.String r0 = "onBufferingEnd"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00ca
            r15 = 5
            goto L_0x00cb
        L_0x0098:
            java.lang.String r0 = "onAdClick"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00ca
            r15 = 6
            goto L_0x00cb
        L_0x00a2:
            java.lang.String r0 = "pause"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00ca
            r15 = r1
            goto L_0x00cb
        L_0x00ac:
            java.lang.String r0 = "initViews"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00ca
            r15 = r3
            goto L_0x00cb
        L_0x00b6:
            java.lang.String r0 = "resume"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00ca
            r15 = r2
            goto L_0x00cb
        L_0x00c0:
            java.lang.String r0 = "setMuteState"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x002f }
            if (r15 == 0) goto L_0x00ca
            r15 = 3
            goto L_0x00cb
        L_0x00ca:
            r15 = -1
        L_0x00cb:
            r4 = 0
            java.lang.String r5 = "OMSDK_TAG"
            switch(r15) {
                case 0: goto L_0x0330;
                case 1: goto L_0x0313;
                case 2: goto L_0x02f6;
                case 3: goto L_0x02b5;
                case 4: goto L_0x0298;
                case 5: goto L_0x027b;
                case 6: goto L_0x025c;
                case 7: goto L_0x01bb;
                case 8: goto L_0x01d4;
                case 9: goto L_0x00d3;
                default: goto L_0x00d1;
            }
        L_0x00d1:
            goto L_0x040a
        L_0x00d3:
            java.lang.Object[] r15 = r14.f10871c     // Catch:{ Exception -> 0x0185 }
            if (r15 == 0) goto L_0x040a
            int r0 = r15.length     // Catch:{ Exception -> 0x0185 }
            if (r0 <= 0) goto L_0x040a
            r15 = r15[r3]     // Catch:{ Exception -> 0x0185 }
            boolean r0 = r15 instanceof java.lang.String     // Catch:{ Exception -> 0x0185 }
            if (r0 == 0) goto L_0x040a
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x0185 }
            java.lang.String r0 = "onCreate"
            boolean r0 = r15.equals(r0)     // Catch:{ Exception -> 0x0185 }
            if (r0 == 0) goto L_0x0188
            java.lang.String r0 = "onOMSdkCreate"
            com.mbridge.msdk.foundation.tools.af.b(r5, r0)     // Catch:{ all -> 0x0165 }
            com.mbridge.msdk.newreward.a.e r0 = r14.f10869a     // Catch:{ all -> 0x0165 }
            if (r0 == 0) goto L_0x0188
            com.mbridge.msdk.newreward.function.e.a r0 = r0.D()     // Catch:{ all -> 0x0165 }
            if (r0 == 0) goto L_0x0188
            com.mbridge.msdk.newreward.a.e r0 = r14.f10869a     // Catch:{ all -> 0x0165 }
            com.mbridge.msdk.newreward.function.e.a r0 = r0.D()     // Catch:{ all -> 0x0165 }
            java.util.List r0 = r0.a()     // Catch:{ all -> 0x0165 }
            if (r0 != 0) goto L_0x0107
            goto L_0x0188
        L_0x0107:
            com.mbridge.msdk.newreward.a.e r0 = r14.f10869a     // Catch:{ all -> 0x0165 }
            com.mbridge.msdk.newreward.function.e.a r0 = r0.D()     // Catch:{ all -> 0x0165 }
            java.util.List r0 = r0.a()     // Catch:{ all -> 0x0165 }
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0165 }
            if (r1 != 0) goto L_0x0188
            java.lang.Object r1 = r0.get(r3)     // Catch:{ all -> 0x0165 }
            if (r1 != 0) goto L_0x011e
            goto L_0x0188
        L_0x011e:
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0165 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x0165 }
            boolean r1 = r0.isActiveOm()     // Catch:{ all -> 0x0165 }
            if (r1 != 0) goto L_0x012b
            goto L_0x0188
        L_0x012b:
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0165 }
            android.content.Context r6 = r1.c()     // Catch:{ all -> 0x0165 }
            java.lang.String r8 = r0.getOmid()     // Catch:{ all -> 0x0165 }
            java.lang.String r9 = r0.getRequestId()     // Catch:{ all -> 0x0165 }
            java.lang.String r10 = r0.getId()     // Catch:{ all -> 0x0165 }
            com.mbridge.msdk.newreward.a.e r1 = r14.f10869a     // Catch:{ all -> 0x0165 }
            java.lang.String r11 = r1.H()     // Catch:{ all -> 0x0165 }
            java.lang.String r12 = r0.getVideoUrlEncode()     // Catch:{ all -> 0x0165 }
            java.lang.String r13 = r0.getRequestIdNotice()     // Catch:{ all -> 0x0165 }
            r7 = 0
            u1.b r0 = com.mbridge.msdk.a.b.a(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0165 }
            r14.f10872d = r0     // Catch:{ all -> 0x0165 }
            if (r0 == 0) goto L_0x0167
            u1.a r0 = u1.a.a(r0)     // Catch:{ all -> 0x0165 }
            r14.f10873e = r0     // Catch:{ all -> 0x0165 }
            u1.b r0 = r14.f10872d     // Catch:{ all -> 0x0165 }
            v1.b r0 = v1.b.g(r0)     // Catch:{ all -> 0x0165 }
            r14.f10874f = r0     // Catch:{ all -> 0x0165 }
            goto L_0x0167
        L_0x0165:
            r0 = move-exception
            goto L_0x017d
        L_0x0167:
            com.mbridge.msdk.newreward.a.e r0 = r14.f10869a     // Catch:{ all -> 0x0165 }
            u1.b r1 = r14.f10872d     // Catch:{ all -> 0x0165 }
            r0.a((u1.b) r1)     // Catch:{ all -> 0x0165 }
            com.mbridge.msdk.newreward.a.e r0 = r14.f10869a     // Catch:{ all -> 0x0165 }
            u1.a r1 = r14.f10873e     // Catch:{ all -> 0x0165 }
            r0.a((u1.a) r1)     // Catch:{ all -> 0x0165 }
            com.mbridge.msdk.newreward.a.e r0 = r14.f10869a     // Catch:{ all -> 0x0165 }
            v1.b r1 = r14.f10874f     // Catch:{ all -> 0x0165 }
            r0.a((v1.b) r1)     // Catch:{ all -> 0x0165 }
            goto L_0x0188
        L_0x017d:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0185 }
            if (r1 == 0) goto L_0x0188
            r0.printStackTrace()     // Catch:{ Exception -> 0x0185 }
            goto L_0x0188
        L_0x0185:
            r0 = move-exception
            r15 = r0
            goto L_0x01b2
        L_0x0188:
            java.lang.String r0 = "onDestroy"
            boolean r15 = r15.equals(r0)     // Catch:{ Exception -> 0x0185 }
            if (r15 == 0) goto L_0x040a
            u1.b r15 = r14.f10872d     // Catch:{ Exception -> 0x0185 }
            if (r15 == 0) goto L_0x040a
            java.lang.String r15 = "onOMSdkDestory"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x01a7 }
            u1.b r15 = r14.f10872d     // Catch:{ Exception -> 0x01a7 }
            r15.e()     // Catch:{ Exception -> 0x01a7 }
            u1.b r15 = r14.f10872d     // Catch:{ Exception -> 0x01a7 }
            r15.c()     // Catch:{ Exception -> 0x01a7 }
            r14.f10872d = r4     // Catch:{ Exception -> 0x01a7 }
            goto L_0x040a
        L_0x01a7:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x0185 }
            if (r0 == 0) goto L_0x040a
            r15.printStackTrace()     // Catch:{ Exception -> 0x0185 }
            goto L_0x040a
        L_0x01b2:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x040a
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x040a
        L_0x01bb:
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x01c0
            goto L_0x01d4
        L_0x01c0:
            java.lang.String r15 = "onOMSdkSkipped"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x01cb }
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x01cb }
            r15.l()     // Catch:{ Exception -> 0x01cb }
            goto L_0x01d4
        L_0x01cb:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x01d4
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
        L_0x01d4:
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x01da
            goto L_0x040a
        L_0x01da:
            java.lang.Object[] r15 = r14.f10871c     // Catch:{ Exception -> 0x021d }
            if (r15 == 0) goto L_0x040a
            int r0 = r15.length     // Catch:{ Exception -> 0x021d }
            if (r0 != r1) goto L_0x040a
            r0 = r15[r3]     // Catch:{ Exception -> 0x021d }
            boolean r1 = r0 instanceof java.lang.Integer     // Catch:{ Exception -> 0x021d }
            if (r1 == 0) goto L_0x040a
            r15 = r15[r2]     // Catch:{ Exception -> 0x021d }
            boolean r15 = r15 instanceof java.lang.Integer     // Catch:{ Exception -> 0x021d }
            if (r15 == 0) goto L_0x040a
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x021d }
            int r15 = r0.intValue()     // Catch:{ Exception -> 0x021d }
            java.lang.Object[] r0 = r14.f10871c     // Catch:{ Exception -> 0x021d }
            r0 = r0[r2]     // Catch:{ Exception -> 0x021d }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x021d }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x021d }
            if (r15 == 0) goto L_0x0244
            r0 = 25
            if (r15 == r0) goto L_0x0238
            r0 = 50
            if (r15 == r0) goto L_0x022c
            r0 = 75
            if (r15 == r0) goto L_0x0220
            r0 = 100
            if (r15 == r0) goto L_0x0211
            goto L_0x040a
        L_0x0211:
            java.lang.String r15 = "onOMSdkProgress 100"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x021d }
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x021d }
            r15.d()     // Catch:{ Exception -> 0x021d }
            goto L_0x040a
        L_0x021d:
            r0 = move-exception
            r15 = r0
            goto L_0x0253
        L_0x0220:
            java.lang.String r15 = "onOMSdkProgress 75"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x021d }
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x021d }
            r15.n()     // Catch:{ Exception -> 0x021d }
            goto L_0x040a
        L_0x022c:
            java.lang.String r15 = "onOMSdkProgress 50"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x021d }
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x021d }
            r15.i()     // Catch:{ Exception -> 0x021d }
            goto L_0x040a
        L_0x0238:
            java.lang.String r15 = "onOMSdkProgress 25"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x021d }
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x021d }
            r15.h()     // Catch:{ Exception -> 0x021d }
            goto L_0x040a
        L_0x0244:
            java.lang.String r15 = "onOMSdkProgress 0"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x021d }
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x021d }
            float r0 = (float) r0     // Catch:{ Exception -> 0x021d }
            float r1 = r14.f10875g     // Catch:{ Exception -> 0x021d }
            r15.m(r0, r1)     // Catch:{ Exception -> 0x021d }
            goto L_0x040a
        L_0x0253:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x040a
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x040a
        L_0x025c:
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x0262
            goto L_0x040a
        L_0x0262:
            java.lang.String r15 = "onOMSdkClick"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x0270 }
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x0270 }
            v1.a r0 = v1.a.CLICK     // Catch:{ Exception -> 0x0270 }
            r15.a(r0)     // Catch:{ Exception -> 0x0270 }
            goto L_0x040a
        L_0x0270:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x040a
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x040a
        L_0x027b:
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x0281
            goto L_0x040a
        L_0x0281:
            java.lang.String r15 = "onOMSdkBuffEnd"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x028d }
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x028d }
            r15.b()     // Catch:{ Exception -> 0x028d }
            goto L_0x040a
        L_0x028d:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x040a
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x040a
        L_0x0298:
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x029e
            goto L_0x040a
        L_0x029e:
            java.lang.String r15 = "onOMSdkBuffStart"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x02aa }
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x02aa }
            r15.c()     // Catch:{ Exception -> 0x02aa }
            goto L_0x040a
        L_0x02aa:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x040a
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x040a
        L_0x02b5:
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x02bb
            goto L_0x040a
        L_0x02bb:
            java.lang.Object[] r15 = r14.f10871c     // Catch:{ Exception -> 0x02e1 }
            if (r15 == 0) goto L_0x040a
            int r0 = r15.length     // Catch:{ Exception -> 0x02e1 }
            if (r0 <= 0) goto L_0x040a
            r15 = r15[r3]     // Catch:{ Exception -> 0x02e1 }
            boolean r15 = r15 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x02e1 }
            if (r15 == 0) goto L_0x040a
            java.lang.String r15 = "onOMSdkChangeVolume"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x02e1 }
            java.lang.Object[] r15 = r14.f10871c     // Catch:{ Exception -> 0x02e1 }
            r15 = r15[r3]     // Catch:{ Exception -> 0x02e1 }
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ Exception -> 0x02e1 }
            boolean r15 = r15.booleanValue()     // Catch:{ Exception -> 0x02e1 }
            if (r15 == 0) goto L_0x02e4
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x02e1 }
            r0 = 0
            r15.o(r0)     // Catch:{ Exception -> 0x02e1 }
            goto L_0x040a
        L_0x02e1:
            r0 = move-exception
            r15 = r0
            goto L_0x02ed
        L_0x02e4:
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x02e1 }
            r0 = 1065353216(0x3f800000, float:1.0)
            r15.o(r0)     // Catch:{ Exception -> 0x02e1 }
            goto L_0x040a
        L_0x02ed:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x040a
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x040a
        L_0x02f6:
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x02fc
            goto L_0x040a
        L_0x02fc:
            java.lang.String r15 = "onOMSdkPause"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x0308 }
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x0308 }
            r15.j()     // Catch:{ Exception -> 0x0308 }
            goto L_0x040a
        L_0x0308:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x040a
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x040a
        L_0x0313:
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x0319
            goto L_0x040a
        L_0x0319:
            java.lang.String r15 = "onOMSDKResume"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x0325 }
            v1.b r15 = r14.f10874f     // Catch:{ Exception -> 0x0325 }
            r15.k()     // Catch:{ Exception -> 0x0325 }
            goto L_0x040a
        L_0x0325:
            r0 = move-exception
            r15 = r0
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x040a
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x040a
        L_0x0330:
            com.mbridge.msdk.newreward.a.e r15 = r14.f10869a     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x0336
            goto L_0x040a
        L_0x0336:
            u1.b r0 = r14.f10872d     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x040a
            boolean r15 = r15.ag()     // Catch:{ Exception -> 0x002f }
            if (r15 != 0) goto L_0x040a
            java.lang.String r15 = "onOMSdkStart"
            com.mbridge.msdk.foundation.tools.af.b(r5, r15)     // Catch:{ Exception -> 0x0364 }
            u1.b r15 = r14.f10872d     // Catch:{ Exception -> 0x0364 }
            r15.g()     // Catch:{ Exception -> 0x0364 }
            com.mbridge.msdk.newreward.a.e r15 = r14.f10869a     // Catch:{ Exception -> 0x0364 }
            r15.o(r2)     // Catch:{ Exception -> 0x0364 }
            u1.a r15 = r14.f10873e     // Catch:{ Exception -> 0x0364 }
            if (r15 == 0) goto L_0x0368
            v1.c r15 = v1.c.STANDALONE     // Catch:{ Exception -> 0x0364 }
            v1.d r15 = v1.d.b(r2, r15)     // Catch:{ Exception -> 0x0364 }
            u1.a r0 = r14.f10873e     // Catch:{ Exception -> 0x0364 }
            r0.d(r15)     // Catch:{ Exception -> 0x0364 }
            u1.a r15 = r14.f10873e     // Catch:{ Exception -> 0x0364 }
            r15.b()     // Catch:{ Exception -> 0x0364 }
            goto L_0x0368
        L_0x0364:
            r0 = move-exception
            r15 = r0
            goto L_0x03fb
        L_0x0368:
            java.lang.Object r15 = r14.f10870b     // Catch:{ Exception -> 0x0364 }
            boolean r0 = r15 instanceof com.mbridge.msdk.newreward.player.view.BaseTemplate     // Catch:{ Exception -> 0x0364 }
            if (r0 == 0) goto L_0x03bd
            com.mbridge.msdk.newreward.player.view.BaseTemplate r15 = (com.mbridge.msdk.newreward.player.view.BaseTemplate) r15     // Catch:{ Exception -> 0x0364 }
            com.mbridge.msdk.playercommon.PlayerView r0 = r15.getmPlayerView()     // Catch:{ Exception -> 0x0364 }
            if (r0 == 0) goto L_0x0389
            com.mbridge.msdk.playercommon.PlayerView r0 = r15.getmPlayerView()     // Catch:{ Exception -> 0x0364 }
            float r0 = r0.getVolume()     // Catch:{ Exception -> 0x0364 }
            r14.f10875g = r0     // Catch:{ Exception -> 0x0364 }
            u1.b r0 = r14.f10872d     // Catch:{ Exception -> 0x0364 }
            com.mbridge.msdk.playercommon.PlayerView r1 = r15.getmPlayerView()     // Catch:{ Exception -> 0x0364 }
            r0.d(r1)     // Catch:{ Exception -> 0x0364 }
        L_0x0389:
            com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView r0 = r15.getmSoundImageView()     // Catch:{ Exception -> 0x0364 }
            if (r0 == 0) goto L_0x039a
            u1.b r0 = r14.f10872d     // Catch:{ Exception -> 0x0364 }
            com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView r1 = r15.getmSoundImageView()     // Catch:{ Exception -> 0x0364 }
            u1.h r2 = u1.h.OTHER     // Catch:{ Exception -> 0x0364 }
            r0.a(r1, r2, r4)     // Catch:{ Exception -> 0x0364 }
        L_0x039a:
            android.widget.TextView r0 = r15.getmTvCountDown()     // Catch:{ Exception -> 0x0364 }
            if (r0 == 0) goto L_0x03ab
            u1.b r0 = r14.f10872d     // Catch:{ Exception -> 0x0364 }
            android.widget.TextView r1 = r15.getmTvCountDown()     // Catch:{ Exception -> 0x0364 }
            u1.h r2 = u1.h.OTHER     // Catch:{ Exception -> 0x0364 }
            r0.a(r1, r2, r4)     // Catch:{ Exception -> 0x0364 }
        L_0x03ab:
            android.view.View r0 = r15.getmViewPlayingClose()     // Catch:{ Exception -> 0x0364 }
            if (r0 == 0) goto L_0x040a
            u1.b r0 = r14.f10872d     // Catch:{ Exception -> 0x0364 }
            android.view.View r15 = r15.getmViewPlayingClose()     // Catch:{ Exception -> 0x0364 }
            u1.h r1 = u1.h.VIDEO_CONTROLS     // Catch:{ Exception -> 0x0364 }
            r0.a(r15, r1, r4)     // Catch:{ Exception -> 0x0364 }
            goto L_0x040a
        L_0x03bd:
            boolean r0 = r15 instanceof com.mbridge.msdk.newreward.player.view.ectemplate.BaseECTemplate     // Catch:{ Exception -> 0x0364 }
            if (r0 == 0) goto L_0x03eb
            com.mbridge.msdk.newreward.player.view.ectemplate.BaseECTemplate r15 = (com.mbridge.msdk.newreward.player.view.ectemplate.BaseECTemplate) r15     // Catch:{ Exception -> 0x0364 }
            u1.b r0 = r14.f10872d     // Catch:{ Exception -> 0x0364 }
            r0.d(r15)     // Catch:{ Exception -> 0x0364 }
            android.view.View r0 = r15.getCloseView()     // Catch:{ Exception -> 0x0364 }
            if (r0 == 0) goto L_0x03d9
            u1.b r0 = r14.f10872d     // Catch:{ Exception -> 0x0364 }
            android.view.View r1 = r15.getCloseView()     // Catch:{ Exception -> 0x0364 }
            u1.h r2 = u1.h.VIDEO_CONTROLS     // Catch:{ Exception -> 0x0364 }
            r0.a(r1, r2, r4)     // Catch:{ Exception -> 0x0364 }
        L_0x03d9:
            android.widget.ImageView r0 = r15.getNoticeIV()     // Catch:{ Exception -> 0x0364 }
            if (r0 == 0) goto L_0x040a
            u1.b r0 = r14.f10872d     // Catch:{ Exception -> 0x0364 }
            android.widget.ImageView r15 = r15.getNoticeIV()     // Catch:{ Exception -> 0x0364 }
            u1.h r1 = u1.h.VIDEO_CONTROLS     // Catch:{ Exception -> 0x0364 }
            r0.a(r15, r1, r4)     // Catch:{ Exception -> 0x0364 }
            goto L_0x040a
        L_0x03eb:
            boolean r0 = r15 instanceof com.mbridge.msdk.newreward.player.iview.IBaseWebView     // Catch:{ Exception -> 0x0364 }
            if (r0 == 0) goto L_0x040a
            com.mbridge.msdk.newreward.player.iview.IBaseWebView r15 = (com.mbridge.msdk.newreward.player.iview.IBaseWebView) r15     // Catch:{ Exception -> 0x0364 }
            u1.b r0 = r14.f10872d     // Catch:{ Exception -> 0x0364 }
            com.mbridge.msdk.newreward.player.view.hybrid.MBWebView r15 = r15.getWebView()     // Catch:{ Exception -> 0x0364 }
            r0.d(r15)     // Catch:{ Exception -> 0x0364 }
            goto L_0x040a
        L_0x03fb:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x002f }
            if (r0 == 0) goto L_0x040a
            r15.printStackTrace()     // Catch:{ Exception -> 0x002f }
            goto L_0x040a
        L_0x0403:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x040a
            r15.printStackTrace()
        L_0x040a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.OMSDKReceiver.a(java.lang.Object):void");
    }
}
