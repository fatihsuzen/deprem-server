package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import com.mbridge.msdk.newreward.player.model.WebTemplateModel;
import com.mbridge.msdk.newreward.player.view.hybrid.MBWebView;

public final class i implements b {

    /* renamed from: a  reason: collision with root package name */
    MBWebView f10858a = null;

    /* renamed from: b  reason: collision with root package name */
    WebTemplateModel f10859b = null;

    /* renamed from: c  reason: collision with root package name */
    Handler f10860c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private final String f10861d = "WebTemplateReceiver";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.String r0 = "parent_temple"
            java.util.Map r11 = (java.util.Map) r11
            if (r11 == 0) goto L_0x010d
            boolean r1 = r11.isEmpty()
            if (r1 == 0) goto L_0x000e
            goto L_0x010d
        L_0x000e:
            java.lang.String r1 = "web_resource_action"
            java.lang.Object r1 = r11.get(r1)     // Catch:{ all -> 0x0020 }
            boolean r2 = r1 instanceof java.lang.Integer     // Catch:{ all -> 0x0020 }
            r3 = 1
            if (r2 == 0) goto L_0x0023
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0020 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r11 = move-exception
            goto L_0x0104
        L_0x0023:
            r1 = r3
        L_0x0024:
            boolean r2 = r11.containsKey(r0)     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r11.get(r0)     // Catch:{ all -> 0x0020 }
            boolean r2 = r2 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x0039
            java.lang.Object r0 = r11.get(r0)     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ all -> 0x0020 }
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            java.lang.String r2 = "bridge_ids"
            java.lang.Object r2 = r11.get(r2)     // Catch:{ all -> 0x0020 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = "adapter_model"
            java.lang.Object r4 = r11.get(r4)     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.a.e r4 = (com.mbridge.msdk.newreward.a.e) r4     // Catch:{ all -> 0x0020 }
            java.lang.String r5 = "command_manager"
            java.lang.Object r11 = r11.get(r5)     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.function.command.c r11 = (com.mbridge.msdk.newreward.function.command.c) r11     // Catch:{ all -> 0x0020 }
            if (r4 != 0) goto L_0x0056
            goto L_0x010d
        L_0x0056:
            java.lang.String r5 = ""
            com.mbridge.msdk.newreward.function.e.a r6 = r4.D()     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.function.c.a.b r6 = r6.b()     // Catch:{ all -> 0x0020 }
            java.util.List r6 = r6.u()     // Catch:{ all -> 0x0020 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0020 }
        L_0x0068:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0020 }
            r8 = 904(0x388, float:1.267E-42)
            if (r7 == 0) goto L_0x00bc
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.function.c.a.a r7 = (com.mbridge.msdk.newreward.function.c.a.a) r7     // Catch:{ all -> 0x0020 }
            java.lang.String r9 = r7.g()     // Catch:{ all -> 0x0020 }
            boolean r9 = r9.equals(r2)     // Catch:{ all -> 0x0020 }
            if (r9 == 0) goto L_0x0068
            com.mbridge.msdk.newreward.function.c.c.d r2 = r7.c()     // Catch:{ all -> 0x0020 }
            java.lang.Object r2 = r2.a()     // Catch:{ all -> 0x0020 }
            boolean r6 = r2 instanceof java.lang.String     // Catch:{ all -> 0x0020 }
            if (r6 == 0) goto L_0x008f
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0020 }
        L_0x008f:
            boolean r6 = r2 instanceof java.io.File     // Catch:{ all -> 0x0020 }
            if (r6 == 0) goto L_0x00a0
            java.io.File r2 = (java.io.File) r2     // Catch:{ all -> 0x0020 }
            boolean r6 = r2.exists()     // Catch:{ all -> 0x0020 }
            if (r6 == 0) goto L_0x00a0
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0020 }
            r5 = r2
        L_0x00a0:
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.h()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x00bc
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.h()     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = r2.getRewardTemplateMode()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x00bc
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.h()     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = r2.getRewardTemplateMode()     // Catch:{ all -> 0x0020 }
            int r8 = r2.f()     // Catch:{ all -> 0x0020 }
        L_0x00bc:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0020 }
            r6 = 2
            if (r2 == 0) goto L_0x00c9
            if (r1 != r6) goto L_0x010d
            r10.a(r8, r11, r4, r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x00c9:
            if (r1 != r3) goto L_0x00d5
            android.os.Handler r2 = r10.f10860c     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i$1 r3 = new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i$1     // Catch:{ all -> 0x0020 }
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0020 }
            r2.post(r3)     // Catch:{ all -> 0x0020 }
        L_0x00d5:
            if (r1 != r6) goto L_0x010d
            com.mbridge.msdk.newreward.player.view.hybrid.MBWebView r1 = r10.f10858a     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0100
            com.mbridge.msdk.newreward.player.model.WebTemplateModel r1 = r10.f10859b     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x00e0
            goto L_0x0100
        L_0x00e0:
            int r1 = r1.getRenderStatus()     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.player.model.WebTemplateModel r2 = r10.f10859b     // Catch:{ all -> 0x0020 }
            java.lang.String r2 = r2.getH5InitCallbackParameter()     // Catch:{ all -> 0x0020 }
            if (r1 == r6) goto L_0x00ef
            r3 = 3
            if (r1 != r3) goto L_0x00fc
        L_0x00ef:
            if (r0 == 0) goto L_0x00fc
            android.os.Handler r11 = r10.f10860c     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i$2 r1 = new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i$2     // Catch:{ all -> 0x0020 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0020 }
            r11.post(r1)     // Catch:{ all -> 0x0020 }
            return
        L_0x00fc:
            r10.a(r8, r11, r4, r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0100:
            r10.a(r8, r11, r4, r0)     // Catch:{ all -> 0x0020 }
            return
        L_0x0104:
            java.lang.String r0 = "WebTemplateReceiver"
            java.lang.String r11 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r11)
        L_0x010d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i.a(java.lang.Object):void");
    }

    private void a(int i5, c cVar, e eVar, ViewGroup viewGroup) {
        if (cVar != null) {
            try {
                cVar.g(cVar.a("add_temple", Integer.valueOf(i5), "template_type", 17, "adapter_model", eVar, "parent_temple", viewGroup), f.SHOW_ADD_TEMPLE);
            } catch (Throwable th) {
                af.b("WebTemplateReceiver", th.getMessage());
            }
        }
    }
}
