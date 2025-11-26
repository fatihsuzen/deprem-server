package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.view.ViewGroup;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import com.mbridge.msdk.newreward.function.command.receiver.d;
import com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC;

public final class h implements b {

    /* renamed from: a  reason: collision with root package name */
    WebViewEC f10857a = null;

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0121 A[Catch:{ all -> 0x0020 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.String r0 = "-999"
            java.util.Map r15 = (java.util.Map) r15
            if (r15 == 0) goto L_0x01c5
            boolean r1 = r15.isEmpty()
            if (r1 == 0) goto L_0x000e
            goto L_0x01c5
        L_0x000e:
            java.lang.String r1 = "web_resource_action"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0020 }
            boolean r2 = r1 instanceof java.lang.Integer     // Catch:{ all -> 0x0020 }
            r3 = 1
            if (r2 == 0) goto L_0x0023
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0020 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r15 = move-exception
            goto L_0x01bc
        L_0x0023:
            r1 = r3
        L_0x0024:
            java.lang.String r2 = "parent_temple"
            java.lang.Object r2 = r15.get(r2)     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = "bridge_ids"
            java.lang.Object r4 = r15.get(r4)     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0020 }
            java.lang.String r5 = "adapter_model"
            java.lang.Object r5 = r15.get(r5)     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.a.e r5 = (com.mbridge.msdk.newreward.a.e) r5     // Catch:{ all -> 0x0020 }
            java.lang.String r6 = "command_manager"
            java.lang.Object r15 = r15.get(r6)     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.function.command.c r15 = (com.mbridge.msdk.newreward.function.command.c) r15     // Catch:{ all -> 0x0020 }
            if (r5 == 0) goto L_0x01c5
            if (r2 != 0) goto L_0x004a
            goto L_0x01c5
        L_0x004a:
            java.lang.String r6 = "404"
            com.mbridge.msdk.newreward.function.e.a r7 = r5.D()     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.function.c.a.b r7 = r7.b()     // Catch:{ all -> 0x0020 }
            java.util.List r7 = r7.u()     // Catch:{ all -> 0x0020 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0020 }
        L_0x005c:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x0020 }
            r9 = 4
            java.lang.String r10 = ""
            if (r8 == 0) goto L_0x0130
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.function.c.a.a r8 = (com.mbridge.msdk.newreward.function.c.a.a) r8     // Catch:{ all -> 0x0020 }
            java.lang.String r11 = r8.g()     // Catch:{ all -> 0x0020 }
            boolean r11 = r11.equals(r4)     // Catch:{ all -> 0x0020 }
            if (r11 == 0) goto L_0x005c
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r8.h()     // Catch:{ all -> 0x0020 }
            if (r4 == 0) goto L_0x0087
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r8.h()     // Catch:{ all -> 0x0020 }
            long r6 = r4.getEcTemplateId()     // Catch:{ all -> 0x0020 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0020 }
        L_0x0087:
            com.mbridge.msdk.newreward.function.c.c.h r4 = r8.b()     // Catch:{ all -> 0x0020 }
            if (r4 == 0) goto L_0x0096
            com.mbridge.msdk.newreward.function.c.c.h r4 = r8.b()     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = r4.i()     // Catch:{ all -> 0x0020 }
            goto L_0x0097
        L_0x0096:
            r4 = r10
        L_0x0097:
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r8.h()     // Catch:{ all -> 0x0020 }
            int r7 = r7.getAdType()     // Catch:{ all -> 0x0020 }
            boolean r11 = r8.j()     // Catch:{ all -> 0x0020 }
            if (r11 == 0) goto L_0x00d3
            com.mbridge.msdk.newreward.function.c.c.l r11 = r8.e()     // Catch:{ all -> 0x0020 }
            if (r11 == 0) goto L_0x00d3
            com.mbridge.msdk.newreward.function.c.c.l r4 = r8.e()     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = r4.a()     // Catch:{ all -> 0x0020 }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0020 }
            if (r7 != 0) goto L_0x011e
            java.lang.String r7 = "file:"
            boolean r7 = r4.startsWith(r7)     // Catch:{ all -> 0x0020 }
            if (r7 != 0) goto L_0x011f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0020 }
            r7.<init>()     // Catch:{ all -> 0x0020 }
            java.lang.String r11 = "file:////"
            r7.append(r11)     // Catch:{ all -> 0x0020 }
            r7.append(r4)     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x0020 }
            goto L_0x011f
        L_0x00d3:
            com.mbridge.msdk.newreward.function.c.c.d r11 = r8.f()     // Catch:{ all -> 0x0020 }
            if (r11 == 0) goto L_0x011e
            com.mbridge.msdk.newreward.function.c.c.d r11 = r8.f()     // Catch:{ all -> 0x0020 }
            java.lang.Object r11 = r11.a()     // Catch:{ all -> 0x0020 }
            boolean r12 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0020 }
            if (r12 == 0) goto L_0x00f0
            com.mbridge.msdk.newreward.function.c.c.d r12 = r8.f()     // Catch:{ all -> 0x0020 }
            java.lang.Object r12 = r12.a()     // Catch:{ all -> 0x0020 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0020 }
            goto L_0x00f1
        L_0x00f0:
            r12 = r10
        L_0x00f1:
            boolean r13 = r11 instanceof java.io.File     // Catch:{ all -> 0x0020 }
            if (r13 == 0) goto L_0x00fb
            java.io.File r11 = (java.io.File) r11     // Catch:{ all -> 0x0020 }
            java.lang.String r12 = r11.getAbsolutePath()     // Catch:{ all -> 0x0020 }
        L_0x00fb:
            boolean r11 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0020 }
            if (r11 != 0) goto L_0x011e
            boolean r11 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0020 }
            if (r11 == 0) goto L_0x0108
            goto L_0x0109
        L_0x0108:
            r4 = r12
        L_0x0109:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0020 }
            r11.<init>()     // Catch:{ all -> 0x0020 }
            r11.append(r4)     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = "&native_adtype="
            r11.append(r4)     // Catch:{ all -> 0x0020 }
            r11.append(r7)     // Catch:{ all -> 0x0020 }
            java.lang.String r4 = r11.toString()     // Catch:{ all -> 0x0020 }
            goto L_0x011f
        L_0x011e:
            r4 = r10
        L_0x011f:
            if (r1 != r9) goto L_0x012d
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r8.h()     // Catch:{ all -> 0x0020 }
            java.lang.String r7 = r7.getClickURL()     // Catch:{ all -> 0x0020 }
            java.lang.String r10 = com.mbridge.msdk.click.c.a((java.lang.String) r7, (java.lang.String) r0, (java.lang.String) r0)     // Catch:{ all -> 0x0020 }
        L_0x012d:
            r0 = r10
            r10 = r4
            goto L_0x0131
        L_0x0130:
            r0 = r10
        L_0x0131:
            com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC r4 = r14.f10857a     // Catch:{ all -> 0x0020 }
            r7 = 3
            r8 = 0
            if (r4 != 0) goto L_0x0173
            com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC r4 = new com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC     // Catch:{ all -> 0x0020 }
            android.content.Context r11 = r2.getContext()     // Catch:{ all -> 0x0020 }
            r4.<init>(r11)     // Catch:{ all -> 0x0020 }
            r14.f10857a = r4     // Catch:{ all -> 0x0020 }
            android.view.ViewParent r4 = r4.getParent()     // Catch:{ all -> 0x0020 }
            if (r4 != 0) goto L_0x0158
            com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC r4 = r14.f10857a     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup$LayoutParams r11 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0020 }
            r12 = -1
            r11.<init>(r12, r12)     // Catch:{ all -> 0x0020 }
            r4.setLayoutParams(r11)     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC r4 = r14.f10857a     // Catch:{ all -> 0x0020 }
            r2.addView(r4, r8)     // Catch:{ all -> 0x0020 }
        L_0x0158:
            com.mbridge.msdk.foundation.same.report.d.e r4 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ all -> 0x0020 }
            r4.<init>()     // Catch:{ all -> 0x0020 }
            java.lang.String r11 = "type"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0020 }
            r4.a(r11, r12)     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.function.e.c r11 = r5.z()     // Catch:{ all -> 0x0020 }
            java.util.Map r4 = r4.a()     // Catch:{ all -> 0x0020 }
            java.lang.String r12 = "2000154"
            r11.a((com.mbridge.msdk.newreward.a.e) r5, (java.util.Map<java.lang.String, java.lang.String>) r4, (java.lang.String) r12)     // Catch:{ all -> 0x0020 }
        L_0x0173:
            if (r1 != r3) goto L_0x017a
            com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC r4 = r14.f10857a     // Catch:{ all -> 0x0020 }
            r4.preloadWebContent(r10)     // Catch:{ all -> 0x0020 }
        L_0x017a:
            r4 = 2
            if (r1 != r4) goto L_0x0199
            com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC r11 = r14.f10857a     // Catch:{ all -> 0x0020 }
            int r11 = r11.getRenderStatus()     // Catch:{ all -> 0x0020 }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0020 }
            if (r12 == 0) goto L_0x018a
            r11 = r3
        L_0x018a:
            if (r11 < r4) goto L_0x018d
            goto L_0x018e
        L_0x018d:
            r3 = r8
        L_0x018e:
            if (r3 == 0) goto L_0x0196
            com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC r15 = r14.f10857a     // Catch:{ all -> 0x0020 }
            r15.show(r2)     // Catch:{ all -> 0x0020 }
            return
        L_0x0196:
            r14.a(r15, r6, r5, r2)     // Catch:{ all -> 0x0020 }
        L_0x0199:
            if (r1 != r7) goto L_0x01af
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0020 }
            if (r3 != 0) goto L_0x01ac
            com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC r15 = r14.f10857a     // Catch:{ all -> 0x0020 }
            r15.preloadWebContent(r10)     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC r15 = r14.f10857a     // Catch:{ all -> 0x0020 }
            r15.show(r2)     // Catch:{ all -> 0x0020 }
            goto L_0x01af
        L_0x01ac:
            r14.a(r15, r6, r5, r2)     // Catch:{ all -> 0x0020 }
        L_0x01af:
            if (r1 != r9) goto L_0x01c5
            com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC r15 = r14.f10857a     // Catch:{ all -> 0x0020 }
            r15.preloadWebContent(r0)     // Catch:{ all -> 0x0020 }
            com.mbridge.msdk.newreward.player.view.ectemplate.WebViewEC r15 = r14.f10857a     // Catch:{ all -> 0x0020 }
            r15.show(r2)     // Catch:{ all -> 0x0020 }
            return
        L_0x01bc:
            java.lang.String r0 = "WebECReceiver"
            java.lang.String r15 = r15.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r15)
        L_0x01c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.h.a(java.lang.Object):void");
    }

    private void a(c cVar, String str, e eVar, ViewGroup viewGroup) {
        if (cVar != null) {
            cVar.g(cVar.a("add_temple", str, "template_type", 18, "adapter_model", eVar, "parent_temple", viewGroup), f.SHOW_ADD_TEMPLE);
            this.f10857a.removeTempleFromSuperView(viewGroup);
            d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
        }
    }
}
