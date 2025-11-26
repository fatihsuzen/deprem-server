package com.mbridge.msdk.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.b.a;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.reward.player.MBRewardVideoActivity;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.download.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public final class c {
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public boolean f11188A;

    /* renamed from: B  reason: collision with root package name */
    private String f11189B = "";
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public String f11190C;

    /* renamed from: D  reason: collision with root package name */
    private int f11191D;

    /* renamed from: E  reason: collision with root package name */
    private int f11192E;

    /* renamed from: F  reason: collision with root package name */
    private int f11193F;

    /* renamed from: G  reason: collision with root package name */
    private CampaignUnit f11194G;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public CopyOnWriteArrayList<CampaignEx> f11195H;
    /* access modifiers changed from: private */

    /* renamed from: I  reason: collision with root package name */
    public boolean f11196I = false;
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public long f11197J = 0;

    /* renamed from: K  reason: collision with root package name */
    private String f11198K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public a f11199L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public boolean f11200M = false;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public boolean f11201N = false;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public Handler f11202O = new Handler(Looper.getMainLooper()) {
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x036e, code lost:
            if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x0370;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x0370, code lost:
            com.mbridge.msdk.foundation.tools.af.b("RewardMVVideoAdapter", r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x0526, code lost:
            com.mbridge.msdk.foundation.tools.af.a("RewardMVVideoAdapter", r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x052e, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d6, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d9, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b1, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x02ea A[Catch:{ Exception -> 0x02b1, all -> 0x00d6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x02ec A[ADDED_TO_REGION, Catch:{ Exception -> 0x02b1, all -> 0x00d6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x0355 A[Catch:{ Exception -> 0x02b1, all -> 0x00d6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:128:0x0357 A[Catch:{ Exception -> 0x02b1, all -> 0x00d6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00d6 A[Catch:{ Exception -> 0x00d9, all -> 0x00d6 }, ExcHandler: all (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{ Exception -> 0x00d9, all -> 0x00d6 }]), Splitter:B:1:0x000e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r18) {
            /*
                r17 = this;
                r1 = r17
                r0 = r18
                java.lang.String r2 = "_"
                java.lang.String r3 = "RewardMVVideoAdapter"
                com.mbridge.msdk.reward.adapter.c r4 = com.mbridge.msdk.reward.adapter.c.this
                com.mbridge.msdk.foundation.same.report.d.c r4 = r4.a((android.os.Message) r0)
                int r5 = r0.what     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r6 = ""
                r7 = 5
                r8 = 6
                r9 = 1
                switch(r5) {
                    case 1: goto L_0x051c;
                    case 2: goto L_0x051c;
                    case 3: goto L_0x04e8;
                    case 4: goto L_0x0379;
                    case 5: goto L_0x013d;
                    case 6: goto L_0x00e3;
                    case 7: goto L_0x0018;
                    case 8: goto L_0x001a;
                    default: goto L_0x0018;
                }
            L_0x0018:
                goto L_0x0531
            L_0x001a:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.f11228t     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r2 == 0) goto L_0x0531
                java.lang.Object r0 = r0.obj     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x0531
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r2 = r2.f11220l     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r2 != 0) goto L_0x0531
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                android.content.Context r2 = r2.f11219k     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r4 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r4 = r4.f11220l     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r2 == 0) goto L_0x00dc
                boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0084 }
                if (r5 != 0) goto L_0x00dc
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0084 }
                r5.<init>()     // Catch:{ all -> 0x0084 }
                java.lang.String r6 = "key"
                java.lang.String r7 = "2000048"
                r5.put(r6, r7)     // Catch:{ all -> 0x0084 }
                java.lang.String r6 = "st"
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0084 }
                r5.put(r6, r7)     // Catch:{ all -> 0x0084 }
                java.lang.String r6 = "cid"
                java.lang.String r7 = r0.getId()     // Catch:{ all -> 0x0084 }
                r5.put(r6, r7)     // Catch:{ all -> 0x0084 }
                java.lang.String r6 = "network_type"
                int r2 = com.mbridge.msdk.foundation.tools.ab.m(r2)     // Catch:{ all -> 0x0084 }
                r5.put(r6, r2)     // Catch:{ all -> 0x0084 }
                java.lang.String r2 = "unit_id"
                r5.put(r2, r4)     // Catch:{ all -> 0x0084 }
                boolean r2 = com.mbridge.msdk.foundation.tools.ak.c((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ all -> 0x0084 }
                if (r2 == 0) goto L_0x0086
                java.lang.String r2 = "rtins_type"
                int r4 = r0.getRtinsType()     // Catch:{ all -> 0x0084 }
                r5.put(r2, r4)     // Catch:{ all -> 0x0084 }
                goto L_0x0086
            L_0x0084:
                r0 = move-exception
                goto L_0x00cc
            L_0x0086:
                java.lang.String r2 = "hb"
                boolean r4 = r0.isBidCampaign()     // Catch:{ all -> 0x0084 }
                r5.put(r2, r4)     // Catch:{ all -> 0x0084 }
                java.lang.String r2 = "rid"
                java.lang.String r4 = r0.getRequestId()     // Catch:{ all -> 0x0084 }
                r5.put(r2, r4)     // Catch:{ all -> 0x0084 }
                java.lang.String r2 = "rid_n"
                java.lang.String r4 = r0.getRequestIdNotice()     // Catch:{ all -> 0x0084 }
                r5.put(r2, r4)     // Catch:{ all -> 0x0084 }
                java.lang.String r2 = "adspace_t"
                int r4 = r0.getAdSpaceT()     // Catch:{ all -> 0x0084 }
                r5.put(r2, r4)     // Catch:{ all -> 0x0084 }
                com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = r0.getRewardTemplateMode()     // Catch:{ all -> 0x0084 }
                if (r2 == 0) goto L_0x00c4
                com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = r0.getRewardTemplateMode()     // Catch:{ all -> 0x0084 }
                java.lang.String r2 = r2.e()     // Catch:{ all -> 0x0084 }
                int r0 = com.mbridge.msdk.foundation.same.d.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.lang.String) r2)     // Catch:{ all -> 0x0084 }
                r2 = -1
                if (r0 == r2) goto L_0x00c4
                java.lang.String r2 = "dyview"
                r5.put(r2, r0)     // Catch:{ all -> 0x0084 }
            L_0x00c4:
                com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ all -> 0x0084 }
                r0.a((org.json.JSONObject) r5)     // Catch:{ all -> 0x0084 }
                goto L_0x00dc
            L_0x00cc:
                java.lang.String r2 = "RewardReport"
                java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.foundation.tools.af.b(r2, r0)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                goto L_0x00dc
            L_0x00d6:
                r0 = move-exception
                goto L_0x0526
            L_0x00d9:
                r0 = move-exception
                goto L_0x052e
            L_0x00dc:
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r0.b()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                goto L_0x0531
            L_0x00e3:
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r2 = r0.f11220l     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r5 = r5.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r6 = r6.f11208U     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r10 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r10 = r10.f11188A     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c.a((com.mbridge.msdk.reward.adapter.c) r0, (java.lang.String) r2, (java.util.List) r5, (java.util.List) r6, (boolean) r10)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r0 = r0.f11228t     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x0531
                r1.removeMessages(r8)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                android.os.Handler r0 = r0.f11202O     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x011a
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                android.os.Handler r0 = r0.f11202O     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r0.removeMessages(r7)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            L_0x011a:
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r0 = r0.f11228t     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x0531
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r0 = r0.f11216h     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 != 0) goto L_0x0531
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r0.f11216h = r9     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r0 = r0.f11228t     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.f11195H     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r2, (com.mbridge.msdk.foundation.same.report.d.c) r4)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                goto L_0x0531
            L_0x013d:
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r0 = r0.f11228t     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x0531
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r0 = r0.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r5 = 0
                if (r0 == 0) goto L_0x01be
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r0 = r0.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                int r0 = r0.size()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 <= 0) goto L_0x01be
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r0 = r0.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r10 = r0.getCMPTEntryUrl()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r13 = r10 ^ 1
                int r14 = r0.getNscpt()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r11 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.concurrent.CopyOnWriteArrayList r12 = r11.f11195H     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r15 = 1
                r16 = 0
                boolean r0 = r11.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r12, (boolean) r13, (int) r14, (boolean) r15, (boolean) r16)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x01be
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r2 = r0.f11220l     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r5 = r5.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r6 = r6.f11208U     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r10 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r10 = r10.f11188A     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c.a((com.mbridge.msdk.reward.adapter.c) r0, (java.lang.String) r2, (java.util.List) r5, (java.util.List) r6, (boolean) r10)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r1.sendEmptyMessage(r8)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r1.removeMessages(r7)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r0 = r0.f11216h     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 != 0) goto L_0x0531
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r0.f11216h = r9     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r0 = r0.f11228t     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.f11195H     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r2, (com.mbridge.msdk.foundation.same.report.d.c) r4)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                return
            L_0x01be:
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r10 = r0.f11220l     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r11 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r11 = r11.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r12 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r12 = r12.f11188A     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c.a((com.mbridge.msdk.reward.adapter.c) r0, (java.lang.String) r10, (java.util.List) r11, (boolean) r12, (java.lang.String) r6)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                android.os.Handler r0 = r0.f11202O     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x01ed
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                android.os.Handler r0 = r0.f11202O     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r0.removeMessages(r7)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                android.os.Handler r0 = r0.f11202O     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r0.removeMessages(r8)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            L_0x01ed:
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r0 = r0.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x020e
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r0 = r0.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                int r0 = r0.size()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 <= 0) goto L_0x020e
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r0 = r0.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                goto L_0x020f
            L_0x020e:
                r0 = 0
            L_0x020f:
                if (r0 != 0) goto L_0x0231
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.concurrent.CopyOnWriteArrayList r6 = r6.f11207T     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r6 == 0) goto L_0x0231
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.concurrent.CopyOnWriteArrayList r6 = r6.f11207T     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                int r6 = r6.size()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r6 <= 0) goto L_0x0231
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.concurrent.CopyOnWriteArrayList r0 = r0.f11207T     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            L_0x0231:
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r6 = r6.f11217i     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r6 == 0) goto L_0x0249
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r6 = r6.f11218j     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r6 == 0) goto L_0x0531
                if (r0 == 0) goto L_0x0531
                java.lang.String r0 = r0.getNLRid()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 != 0) goto L_0x0531
            L_0x0249:
                java.lang.String r0 = "errorCode: 3401 errorMessage: resource load timeout"
                r6 = 880010(0xd6d8a, float:1.233157E-39)
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.b(r6, r0)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r6.f11217i = r9     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r4 == 0) goto L_0x025b
                r4.a((com.mbridge.msdk.foundation.c.b) r0)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            L_0x025b:
                com.mbridge.msdk.reward.adapter.c r6 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r6 = r6.f11228t     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r7 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r7 = r7.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r6.a(r7, r0, r4)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.concurrent.CopyOnWriteArrayList r0 = r0.f11195H     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x0531
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.concurrent.CopyOnWriteArrayList r0 = r0.f11195H     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                int r0 = r0.size()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 <= 0) goto L_0x0531
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.concurrent.CopyOnWriteArrayList r0 = r0.f11195H     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.Iterator r4 = r0.iterator()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r6 = r5
            L_0x0289:
                boolean r0 = r4.hasNext()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x0531
                java.lang.Object r0 = r4.next()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x02b4
                java.lang.String r7 = r0.getVideoUrlEncode()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r7 != 0) goto L_0x02b4
                com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r7 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                java.lang.String r8 = r0.getVideoUrlEncode()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                boolean r7 = r7.containsVideoKey(r8)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r7 != 0) goto L_0x02b4
                r7 = r9
                goto L_0x02b5
            L_0x02b1:
                r0 = move-exception
                goto L_0x036c
            L_0x02b4:
                r7 = r5
            L_0x02b5:
                if (r0 == 0) goto L_0x02d0
                java.lang.String r8 = r0.getendcard_url()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r8 != 0) goto L_0x02d0
                com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r8 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                java.lang.String r10 = r0.getendcard_url()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                boolean r8 = r8.containsZipKey(r10)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r8 != 0) goto L_0x02d0
                r7 = r9
            L_0x02d0:
                if (r0 == 0) goto L_0x031d
                java.lang.String r8 = r0.getCMPTEntryUrl()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r8 != 0) goto L_0x031d
                com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r8 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                java.lang.String r10 = r0.getCMPTEntryUrl()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                boolean r8 = r8.containsZipKey(r10)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r8 != 0) goto L_0x02ec
                r7 = r9
                goto L_0x031d
            L_0x02ec:
                if (r6 != 0) goto L_0x031d
                if (r7 != 0) goto L_0x031d
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                r8.<init>()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r10 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                java.lang.String r10 = r10.f11220l     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                r8.append(r10)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                r8.append(r2)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                java.lang.String r10 = r0.getRequestId()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                r8.append(r10)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                r8.append(r2)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                java.lang.String r10 = r0.getCMPTEntryUrl()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                r8.append(r10)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                com.mbridge.msdk.videocommon.a$a r8 = com.mbridge.msdk.videocommon.a.a(r8)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r8 != 0) goto L_0x031d
                r6 = r9
            L_0x031d:
                if (r0 == 0) goto L_0x0289
                com.mbridge.msdk.foundation.entity.CampaignEx$c r8 = r0.getRewardTemplateMode()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r8 == 0) goto L_0x0289
                com.mbridge.msdk.foundation.entity.CampaignEx$c r8 = r0.getRewardTemplateMode()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                java.lang.String r8 = r8.e()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r8 != 0) goto L_0x0289
                com.mbridge.msdk.foundation.entity.CampaignEx$c r8 = r0.getRewardTemplateMode()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                java.lang.String r8 = r8.e()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                java.lang.String r10 = "cmpt=1"
                boolean r8 = r8.contains(r10)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r8 != 0) goto L_0x0289
                com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager r8 = com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager.getInstance()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                com.mbridge.msdk.foundation.entity.CampaignEx$c r10 = r0.getRewardTemplateMode()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                java.lang.String r10 = r10.e()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                boolean r8 = r8.containsZipKey(r10)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r8 != 0) goto L_0x0357
                goto L_0x0289
            L_0x0357:
                java.lang.String r8 = r0.getCMPTEntryUrl()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                if (r8 == 0) goto L_0x0289
                if (r7 != 0) goto L_0x0289
                int r7 = r0.getAdType()     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                com.mbridge.msdk.videocommon.a.a(r7, r0)     // Catch:{ Exception -> 0x02b1, all -> 0x00d6 }
                goto L_0x0289
            L_0x036c:
                boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r7 == 0) goto L_0x0289
                java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.foundation.tools.af.b(r3, r0)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                goto L_0x0289
            L_0x0379:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.f11228t     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r2 == 0) goto L_0x0531
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r5 = r2.f11220l     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r10 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r10 = r10.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r11 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r11 = r11.f11188A     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c.a((com.mbridge.msdk.reward.adapter.c) r2, (java.lang.String) r5, (java.util.List) r10, (boolean) r11, (java.lang.String) r6)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r2 = 880002(0xd6d82, float:1.233145E-39)
                java.lang.String r5 = "unknow error in load failed"
                com.mbridge.msdk.foundation.c.b r5 = com.mbridge.msdk.foundation.c.a.b(r2, r5)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                java.lang.Object r10 = r0.obj     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                if (r10 != 0) goto L_0x03d2
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                android.os.Handler r0 = r0.f11202O     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                if (r0 == 0) goto L_0x03b8
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                android.os.Handler r0 = r0.f11202O     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.removeMessages(r7)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                goto L_0x03b8
            L_0x03b5:
                r0 = move-exception
                goto L_0x0488
            L_0x03b8:
                r1.removeMessages(r8)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                java.lang.String r0 = "=====================onVideoLoadFail=====================00000"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                boolean r0 = r0.f11217i     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                if (r0 != 0) goto L_0x045a
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.f11217i = r9     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                java.lang.String r0 = "errorCode: 3506 errorMessage: data load failed"
                com.mbridge.msdk.foundation.c.b r5 = com.mbridge.msdk.foundation.c.a.b(r2, r0)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                goto L_0x045a
            L_0x03d2:
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                int r0 = r0.arg1     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                if (r11 == 0) goto L_0x0406
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                android.os.Handler r0 = r0.f11202O     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                if (r0 == 0) goto L_0x03ed
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                android.os.Handler r0 = r0.f11202O     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.removeMessages(r7)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
            L_0x03ed:
                r1.removeMessages(r8)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                java.lang.String r0 = "=====================onVideoLoadFail=====================11111"
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                boolean r0 = r0.f11217i     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                if (r0 != 0) goto L_0x045a
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.f11217i = r9     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                java.lang.String r0 = "errorCode: 3507 errorMessage: data load failed, errorMsg null"
                com.mbridge.msdk.foundation.c.b r5 = com.mbridge.msdk.foundation.c.a.b(r2, r0)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                goto L_0x045a
            L_0x0406:
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                android.os.Handler r5 = r5.f11202O     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                if (r5 == 0) goto L_0x0417
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                android.os.Handler r5 = r5.f11202O     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r5.removeMessages(r7)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
            L_0x0417:
                r1.removeMessages(r8)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r5 = 880021(0xd6d95, float:1.233172E-39)
                if (r0 != r5) goto L_0x0426
                java.lang.String r0 = "errorCode: 3507 errorMessage: data load failed, errorMsg is APP ALREADY INSTALLED"
                com.mbridge.msdk.foundation.c.b r5 = com.mbridge.msdk.foundation.c.a.b(r5, r0)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                goto L_0x045a
            L_0x0426:
                java.lang.String r5 = "errorCode: 3507 errorMessage: data load failed, errorMsg is "
                r11 = 880003(0xd6d83, float:1.233147E-39)
                if (r0 == r11) goto L_0x0447
                if (r0 == r8) goto L_0x0447
                r12 = 7
                if (r0 != r12) goto L_0x0433
                goto L_0x0447
            L_0x0433:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.<init>()     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.append(r5)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.append(r10)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                com.mbridge.msdk.foundation.c.b r5 = com.mbridge.msdk.foundation.c.a.b(r2, r0)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                goto L_0x045a
            L_0x0447:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.<init>()     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.append(r5)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.append(r10)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                com.mbridge.msdk.foundation.c.b r5 = com.mbridge.msdk.foundation.c.a.b(r11, r0)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
            L_0x045a:
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.f11217i = r9     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                if (r4 == 0) goto L_0x0477
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                java.util.List r0 = r0.f11206S     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r4.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                com.mbridge.msdk.foundation.c.b r0 = r4.o()     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                if (r0 != 0) goto L_0x0473
                r4.a((com.mbridge.msdk.foundation.c.b) r5)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                goto L_0x0477
            L_0x0473:
                com.mbridge.msdk.foundation.c.b r5 = r4.o()     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
            L_0x0477:
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r0 = r0.f11228t     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r9 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                java.util.List r9 = r9.f11206S     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                r0.a(r9, r5, r4)     // Catch:{ Exception -> 0x03b5, all -> 0x00d6 }
                goto L_0x0531
            L_0x0488:
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                android.os.Handler r5 = r5.f11202O     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r5 == 0) goto L_0x0499
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                android.os.Handler r5 = r5.f11202O     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r5.removeMessages(r7)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            L_0x0499:
                r1.removeMessages(r8)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r7 = r5.f11220l     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r8 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r8 = r8.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r9 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                boolean r9 = r9.f11188A     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c.a((com.mbridge.msdk.reward.adapter.c) r5, (java.lang.String) r7, (java.util.List) r8, (boolean) r9, (java.lang.String) r6)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r5.<init>()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r6 = "errorCode: 3508 errorMessage: data load failed, exception is: "
                r5.append(r6)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r5.append(r0)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.foundation.c.b r0 = com.mbridge.msdk.foundation.c.a.b(r2, r0)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r4 == 0) goto L_0x04d8
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r2 = r2.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r4.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r2)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r4.a((com.mbridge.msdk.foundation.c.b) r0)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            L_0x04d8:
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r2 = r2.f11228t     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r5 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.util.List r5 = r5.f11206S     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r2.a(r5, r0, r4)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                goto L_0x0531
            L_0x04e8:
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r0 = r0.f11228t     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r0 == 0) goto L_0x04fb
                com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.a r0 = r0.f11228t     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r2 = "campaign is ok"
                r0.a((java.lang.String) r2, (com.mbridge.msdk.foundation.same.report.d.c) r4)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            L_0x04fb:
                android.os.Message r0 = new android.os.Message     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r0.<init>()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r0.what = r7     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                if (r4 == 0) goto L_0x0515
                android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r2.<init>()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r5 = "metrics_data_lrid"
                java.lang.String r4 = r4.f()     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r2.putString(r5, r4)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r0.setData(r2)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
            L_0x0515:
                int r2 = com.mbridge.msdk.foundation.same.a.f9169L     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                long r4 = (long) r2     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r1.sendMessageDelayed(r0, r4)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                goto L_0x0531
            L_0x051c:
                java.lang.Object r0 = r0.obj     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                r2.a((java.lang.String) r0, (com.mbridge.msdk.foundation.same.report.d.c) r4)     // Catch:{ Exception -> 0x00d9, all -> 0x00d6 }
                goto L_0x0531
            L_0x0526:
                java.lang.String r0 = r0.getMessage()
                com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r0)
                goto L_0x0531
            L_0x052e:
                r0.printStackTrace()
            L_0x0531:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public boolean f11203P = false;

    /* renamed from: Q  reason: collision with root package name */
    private long f11204Q = 0;

    /* renamed from: R  reason: collision with root package name */
    private String f11205R = "";
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public List<CampaignEx> f11206S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public CopyOnWriteArrayList<CampaignEx> f11207T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public List<CampaignEx> f11208U;

    /* renamed from: a  reason: collision with root package name */
    public Object f11209a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public String f11210b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f11211c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f11212d = "";

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f11213e = false;

    /* renamed from: f  reason: collision with root package name */
    volatile boolean f11214f = false;

    /* renamed from: g  reason: collision with root package name */
    volatile boolean f11215g = false;

    /* renamed from: h  reason: collision with root package name */
    volatile boolean f11216h = false;

    /* renamed from: i  reason: collision with root package name */
    volatile boolean f11217i = false;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f11218j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Context f11219k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public String f11220l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f11221m;

    /* renamed from: n  reason: collision with root package name */
    private int f11222n;

    /* renamed from: o  reason: collision with root package name */
    private int f11223o;

    /* renamed from: p  reason: collision with root package name */
    private int f11224p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f11225q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public String f11226r;

    /* renamed from: s  reason: collision with root package name */
    private h f11227s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public volatile a f11228t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public com.mbridge.msdk.videocommon.d.c f11229u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f11230v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f11231w = false;

    /* renamed from: x  reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f11232x = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public int f11233y = 2;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public boolean f11234z;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private String f11283b;

        /* renamed from: c  reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.d.c f11284c;

        public a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            this.f11283b = str;
            this.f11284c = cVar;
        }

        public final void run() {
            try {
                if (!c.this.f11200M) {
                    boolean unused = c.this.f11201N = true;
                    if (c.this.f11202O != null) {
                        Message obtainMessage = c.this.f11202O.obtainMessage();
                        obtainMessage.obj = this.f11283b;
                        obtainMessage.what = 2;
                        if (this.f11284c != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("metrics_data_lrid", this.f11284c.f());
                            obtainMessage.setData(bundle);
                        }
                        c.this.f11202O.sendMessage(obtainMessage);
                    }
                }
            } catch (Exception e5) {
                af.b("RewardMVVideoAdapter", e5.getMessage());
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private String f11286b;

        /* renamed from: c  reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.d.c f11287c;

        public b(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
            this.f11286b = str;
            this.f11287c = cVar;
        }

        public final void run() {
            try {
                if (com.mbridge.msdk.e.b.a()) {
                    c cVar = c.this;
                    String unused = cVar.f11220l;
                    Context unused2 = c.this.f11219k;
                    String unused3 = cVar.f11190C = "";
                }
                c cVar2 = c.this;
                String unused4 = cVar2.f11226r = ak.a(cVar2.f11219k, c.this.f11220l);
                if (!c.this.f11201N) {
                    if (!(c.this.f11199L == null || c.this.f11202O == null)) {
                        c.this.f11202O.removeCallbacks(c.this.f11199L);
                    }
                    boolean unused5 = c.this.f11200M = true;
                    if (c.this.f11202O != null) {
                        Message obtainMessage = c.this.f11202O.obtainMessage();
                        obtainMessage.obj = this.f11286b;
                        obtainMessage.what = 1;
                        if (this.f11287c != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("metrics_data_lrid", this.f11287c.f());
                            obtainMessage.setData(bundle);
                        }
                        c.this.f11202O.sendMessage(obtainMessage);
                    }
                    if (!TextUtils.isEmpty(c.this.f11226r)) {
                        af.b("RewardMVVideoAdapter", "excludeId : " + c.this.f11226r);
                    }
                }
            } catch (Exception e5) {
                af.b("RewardMVVideoAdapter", e5.getMessage());
            }
        }
    }

    public c(Context context, String str, String str2) {
        try {
            this.f11219k = context.getApplicationContext();
            this.f11220l = str2;
            this.f11221m = str;
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081 A[Catch:{ Exception -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r0 = r0.c()
            com.mbridge.msdk.foundation.db.b r0 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r0)
            java.lang.String r1 = r4.f11220l
            java.lang.String r2 = r4.f11211c
            java.util.List r0 = r0.a((java.lang.String) r1, (java.lang.String) r2)
            if (r0 == 0) goto L_0x00a8
            int r1 = r0.size()
            java.lang.String r2 = r4.f11220l
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.b.b(r2)
            if (r1 != 0) goto L_0x0024
            goto L_0x00a8
        L_0x0024:
            r3 = 1
            if (r1 != r3) goto L_0x0045
            r1 = 0
            java.lang.Object r3 = r0.get(r1)     // Catch:{ Exception -> 0x0043 }
            if (r3 == 0) goto L_0x0070
            java.lang.Object r3 = r0.get(r1)     // Catch:{ Exception -> 0x0043 }
            com.mbridge.msdk.foundation.entity.d r3 = (com.mbridge.msdk.foundation.entity.d) r3     // Catch:{ Exception -> 0x0043 }
            java.lang.String r3 = r3.d()     // Catch:{ Exception -> 0x0043 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x0043 }
            com.mbridge.msdk.foundation.entity.d r0 = (com.mbridge.msdk.foundation.entity.d) r0     // Catch:{ Exception -> 0x0043 }
            java.lang.String r0 = r0.b()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0073
        L_0x0043:
            r0 = move-exception
            goto L_0x009f
        L_0x0045:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0043 }
            if (r1 != 0) goto L_0x0070
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0043 }
        L_0x004f:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0043 }
            if (r1 == 0) goto L_0x0070
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0043 }
            com.mbridge.msdk.foundation.entity.d r1 = (com.mbridge.msdk.foundation.entity.d) r1     // Catch:{ Exception -> 0x0043 }
            if (r1 == 0) goto L_0x004f
            java.lang.String r3 = r1.a()     // Catch:{ Exception -> 0x0043 }
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x0043 }
            if (r3 == 0) goto L_0x004f
            java.lang.String r3 = r1.d()     // Catch:{ Exception -> 0x0043 }
            java.lang.String r0 = r1.b()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0073
        L_0x0070:
            java.lang.String r3 = ""
            r0 = r3
        L_0x0073:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0043 }
            if (r1 != 0) goto L_0x00a8
            java.lang.String r1 = r4.f11211c     // Catch:{ Exception -> 0x0043 }
            boolean r1 = r3.equals(r1)     // Catch:{ Exception -> 0x0043 }
            if (r1 == 0) goto L_0x00a8
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0043 }
            android.content.Context r1 = r1.c()     // Catch:{ Exception -> 0x0043 }
            com.mbridge.msdk.foundation.db.b r1 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r1)     // Catch:{ Exception -> 0x0043 }
            java.lang.String r3 = r4.f11220l     // Catch:{ Exception -> 0x0043 }
            r1.b(r2, r3)     // Catch:{ Exception -> 0x0043 }
            java.lang.String r1 = r4.f11220l     // Catch:{ Exception -> 0x0043 }
            java.lang.String r2 = r4.f11211c     // Catch:{ Exception -> 0x0043 }
            com.mbridge.msdk.foundation.same.a.b.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0043 }
            java.lang.String r0 = r4.f11220l     // Catch:{ Exception -> 0x0043 }
            com.mbridge.msdk.foundation.same.a.b.c(r0)     // Catch:{ Exception -> 0x0043 }
            return
        L_0x009f:
            java.lang.String r1 = "RewardMVVideoAdapter"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r0)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.g():void");
    }

    private String h() {
        int i5;
        g a5 = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        if (TextUtils.isEmpty(this.f11198K)) {
            i5 = a5.as();
        } else {
            i5 = a5.I();
        }
        return d.f().a(this.f11198K, i5);
    }

    private void i() {
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            try {
                g b5 = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                if (b5 == null) {
                    com.mbridge.msdk.c.h.a();
                    b5 = i.a();
                }
                com.mbridge.msdk.videocommon.a.a.a().a(b5.ad() * 1000, this.f11220l);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        try {
            if (ap.b(this.f11220l)) {
                com.mbridge.msdk.reward.b.a.a(this.f11220l, 0);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private String k() {
        try {
            if (ap.b(com.mbridge.msdk.reward.b.a.f11296d)) {
                return com.mbridge.msdk.reward.b.a.f11296d;
            }
            return "";
        } catch (Exception e5) {
            e5.printStackTrace();
            return "";
        }
    }

    private void l() {
        try {
            Map<String, Long> map = com.mbridge.msdk.foundation.same.a.b.f9221k;
            if (map != null && map.size() > 0) {
                com.mbridge.msdk.foundation.same.a.b.f9221k.clear();
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    private void m() {
        try {
            com.mbridge.msdk.foundation.db.i.a((f) com.mbridge.msdk.foundation.db.g.a(this.f11219k)).a(this.f11220l);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public final void c(boolean z4) {
        this.f11188A = z4;
    }

    public final boolean d(boolean z4) {
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        CopyOnWriteArrayList<CampaignEx> a5 = com.mbridge.msdk.videocommon.a.a.a().a(this.f11220l, 1, this.f11188A, this.f11189B);
        if (a5 == null || a5.size() <= 0) {
            af.a("RewardVideoController", "database has not can use data");
            if (z4) {
                e eVar = new e();
                eVar.a("event_name", "is_ready_cse");
                eVar.a("reason", "no effective campaign list");
            }
            return false;
        }
        CampaignEx campaignEx = a5.get(0);
        int b5 = com.mbridge.msdk.videocommon.a.a.a().b(this.f11220l, 1, this.f11188A, this.f11189B);
        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || a5.size() >= b5) {
            return a((List<CampaignEx>) a5, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt(), z4);
        }
        if (z4) {
            e eVar2 = new e();
            eVar2.a("event_name", "is_ready_cltr");
            eVar2.a("reason", "nscpt error");
            a(cVar, eVar2, (List<CampaignEx>) a5);
        }
        return false;
    }

    public final void e(boolean z4) {
        this.f11203P = z4;
    }

    public final void f(boolean z4) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList;
        if (!z4 && (copyOnWriteArrayList = this.f11195H) != null && copyOnWriteArrayList.size() > 0) {
            com.mbridge.msdk.videocommon.a.a.a().a(this.f11220l, (List<CampaignEx>) this.f11195H);
        }
    }

    public final boolean c() {
        List<CampaignEx> c5 = com.mbridge.msdk.videocommon.a.a.a().c(this.f11220l, 1, this.f11188A, this.f11189B);
        if (c5 == null || c5.size() <= 0) {
            af.a("test_isReay_db", "database has not can use data");
            return false;
        }
        CampaignEx campaignEx = c5.get(0);
        int b5 = com.mbridge.msdk.videocommon.a.a.a().b(this.f11220l, 1, this.f11188A, this.f11189B);
        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || c5.size() >= b5) {
            return a(c5, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt());
        }
        return false;
    }

    public final CopyOnWriteArrayList<CampaignEx> e() {
        return this.f11207T;
    }

    public final void b(boolean z4) {
        this.f11234z = z4;
    }

    public final String f() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f11195H;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return com.mbridge.msdk.foundation.same.c.a(this.f11208U);
        }
        return com.mbridge.msdk.foundation.same.c.a((List<CampaignEx>) this.f11195H);
    }

    public final boolean b() {
        return d(false);
    }

    /* access modifiers changed from: private */
    public void b(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f11202O != null) {
            if (TextUtils.isEmpty(str)) {
                str = "load fail exception";
            }
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = str;
            if (cVar != null) {
                cVar.c(true);
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", cVar.f());
                obtain.setData(bundle);
            }
            if (str.contains("exception")) {
                this.f11202O.sendMessageAtFrontOfQueue(obtain);
            } else {
                this.f11202O.sendMessage(obtain);
            }
        }
    }

    public final boolean h(boolean z4) {
        if (z4) {
            List<CampaignEx> list = this.f11208U;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (CampaignEx next : this.f11208U) {
                if (next != null) {
                    next.setLoadTimeoutState(1);
                    if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                        ResDownloadCheckManager instance = ResDownloadCheckManager.getInstance();
                        instance.setTemplatePreLoadDone(this.f11220l + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e(), true);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.f11220l, this.f11208U, "load_timeout", 1);
            return true;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f11195H;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        Iterator<CampaignEx> it = this.f11195H.iterator();
        while (it.hasNext()) {
            CampaignEx next2 = it.next();
            if (next2 != null) {
                next2.setLoadTimeoutState(1);
                if (next2.getRewardTemplateMode() != null && !TextUtils.isEmpty(next2.getRewardTemplateMode().e())) {
                    ResDownloadCheckManager instance2 = ResDownloadCheckManager.getInstance();
                    instance2.setTemplatePreLoadDone(this.f11220l + "_" + next2.getRequestId() + "_" + next2.getRewardTemplateMode().e(), true);
                }
            }
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.f11220l, (List<CampaignEx>) this.f11195H, "load_timeout", 1);
        return true;
    }

    public final String a(boolean z4) {
        CopyOnWriteArrayList<CampaignEx> a5;
        CampaignEx campaignEx;
        if (!z4) {
            return this.f11210b;
        }
        if (TextUtils.isEmpty(this.f11211c) && (a5 = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f11220l)) != null && a5.size() > 0 && (campaignEx = a5.get(0)) != null) {
            this.f11211c = campaignEx.getRequestId();
        }
        return this.f11211c;
    }

    private com.mbridge.msdk.foundation.same.report.d.c c(List<CampaignEx> list) {
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        String str = "";
        if (list != null) {
            try {
                if (list.size() > 0) {
                    if (list.get(0) != null) {
                        str = list.get(0).getLocalRequestId();
                    }
                    cVar.c(str);
                    cVar.b(list);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
        e eVar = new e();
        eVar.a("cache", 1);
        eVar.a(CampaignEx.JSON_KEY_HB, 1);
        eVar.a("auto_load", 2);
        cVar.a("2000127", eVar);
        cVar.a("2000048", eVar);
        cVar.b(this.f11234z ? 287 : 94);
        cVar.i("1");
        cVar.b("2");
        if (!TextUtils.isEmpty(str) && !com.mbridge.msdk.foundation.same.report.d.d.a().b().containsKey(str)) {
            com.mbridge.msdk.foundation.same.report.d.d.a().b().put(str, cVar);
            return cVar;
        }
        return cVar;
    }

    public final void a(String str) {
        this.f11189B = str;
    }

    public final void a(int i5) {
        this.f11233y = i5;
    }

    public final String a() {
        return this.f11220l;
    }

    public final boolean a(CampaignEx campaignEx, boolean z4, com.mbridge.msdk.foundation.c.b bVar, int i5, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        c cVar2;
        com.mbridge.msdk.foundation.b.c cVar3;
        com.mbridge.msdk.foundation.same.report.d.c cVar4;
        com.mbridge.msdk.foundation.b.c cVar5 = new com.mbridge.msdk.foundation.b.c();
        com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(this.f11220l, this.f11234z);
        boolean z5 = false;
        if (aVar.a(this.f11198K)) {
            return false;
        }
        if (!this.f11218j) {
            this.f11218j = true;
            com.mbridge.msdk.foundation.c.b bVar2 = bVar;
            com.mbridge.msdk.foundation.same.report.d.c cVar6 = cVar;
            cVar5 = aVar.a(this.f11198K, cVar6, campaignEx, bVar2, i5, this);
            cVar4 = cVar6;
            cVar2 = this;
            if (cVar5 != null && cVar5.g() > com.mbridge.msdk.foundation.b.c.f8790a) {
                if (cVar5.a() != null && cVar5.a().size() > 0) {
                    a(cVar5.a(), true, true);
                } else if (cVar5.g() == com.mbridge.msdk.foundation.b.c.f8792c && bVar2 != null) {
                    bVar2.a(com.mbridge.msdk.foundation.c.a.b(880038));
                    bVar2.c(cVar5.b());
                }
            }
            cVar3 = cVar5;
            aVar.a(cVar4, cVar2.f11198K, cVar3, (List<a.C0084a>) null, (JSONObject) null, 3);
            return z5;
        }
        cVar2 = this;
        cVar4 = cVar;
        cVar5.d("isCandidate:false");
        cVar5.a(com.mbridge.msdk.foundation.b.c.f8792c);
        cVar3 = cVar5;
        z5 = true;
        aVar.a(cVar4, cVar2.f11198K, cVar3, (List<a.C0084a>) null, (JSONObject) null, 3);
        return z5;
    }

    public final void g(boolean z4) {
        if (z4) {
            List<CampaignEx> list = this.f11208U;
            if (list != null && list.size() > 0) {
                for (CampaignEx next : this.f11208U) {
                    if (next != null) {
                        next.setLoadTimeoutState(0);
                        if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                            ResDownloadCheckManager instance = ResDownloadCheckManager.getInstance();
                            instance.setTemplatePreLoadDone(this.f11220l + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e(), false);
                        }
                    }
                }
                com.mbridge.msdk.videocommon.a.a.a().a(this.f11220l, this.f11208U, "load_timeout", 0);
                return;
            }
            return;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f11195H;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<CampaignEx> it = this.f11195H.iterator();
            while (it.hasNext()) {
                CampaignEx next2 = it.next();
                if (next2 != null) {
                    next2.setLoadTimeoutState(0);
                    if (next2.getRewardTemplateMode() != null && !TextUtils.isEmpty(next2.getRewardTemplateMode().e())) {
                        ResDownloadCheckManager instance2 = ResDownloadCheckManager.getInstance();
                        instance2.setTemplatePreLoadDone(this.f11220l + "_" + next2.getRequestId() + "_" + next2.getRewardTemplateMode().e(), false);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.f11220l, (List<CampaignEx>) this.f11195H, "load_timeout", 0);
        }
    }

    private void b(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.f11222n += list.size();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                return;
            }
        }
        com.mbridge.msdk.videocommon.d.c cVar = this.f11229u;
        if (cVar == null || this.f11222n > cVar.v()) {
            this.f11222n = 0;
        }
        if (ap.b(this.f11220l)) {
            com.mbridge.msdk.reward.b.a.a(this.f11220l, this.f11222n);
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> d() {
        return this.f11195H;
    }

    private void b(String str) {
        if (ap.b(str)) {
            com.mbridge.msdk.reward.b.a.f11296d = str;
        }
    }

    private boolean b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private void b(String str, boolean z4, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        com.mbridge.msdk.foundation.same.f.a.f().execute(new b(str, cVar));
        if (this.f11202O != null) {
            a aVar = new a(str, cVar);
            this.f11199L = aVar;
            this.f11202O.postDelayed(aVar, 90000);
            return;
        }
        a(str, z4, cVar);
    }

    public final void a(com.mbridge.msdk.videocommon.d.c cVar) {
        try {
            this.f11229u = cVar;
            if (cVar != null && cVar.D() * 1000 != com.mbridge.msdk.foundation.same.a.f9169L) {
                com.mbridge.msdk.foundation.same.a.f9169L = this.f11229u.D() * 1000;
            }
        } catch (Throwable th) {
            af.b("RewardMVVideoAdapter", th.getMessage(), th);
        }
    }

    private boolean a(List<CampaignEx> list, boolean z4, int i5, boolean z5) {
        return a(list, z4, i5, false, z5);
    }

    static /* synthetic */ void b(c cVar, CampaignUnit campaignUnit) {
        cVar.f11194G = campaignUnit;
        CopyOnWriteArrayList<CampaignEx> a5 = cVar.a(campaignUnit);
        new com.mbridge.msdk.reward.a.a(cVar.f11220l, cVar.f11234z).a((List<CampaignEx>) a5, cVar.f11198K, cVar, cVar.f11220l);
        cVar.a(a5, true, false);
    }

    public final boolean a(List<CampaignEx> list, boolean z4, int i5) {
        return a(list, z4, i5, false, false);
    }

    public final boolean a(List<CampaignEx> list, boolean z4) {
        if (list == null || list.size() <= 0) {
            af.a("RewardVideoController", "数据为空");
        } else {
            CampaignEx campaignEx = list.get(0);
            if (campaignEx == null) {
                return false;
            }
            com.mbridge.msdk.videocommon.download.b instance = com.mbridge.msdk.videocommon.download.b.getInstance();
            String str = this.f11220l;
            j c5 = instance.c(str);
            if (c5 == null) {
                c5 = instance.createUnitCache(com.mbridge.msdk.foundation.controller.c.m().c(), str, (CopyOnWriteArrayList<CampaignEx>) (CopyOnWriteArrayList) list, 94, (com.mbridge.msdk.videocommon.listener.a) null);
            }
            if (c5 != null ? c5.a(list, str) : false) {
                if (z4) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            af.c("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        } else if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            af.c("RewardMVVideoAdapter", "Is not check big template ENDCARD download status");
                            return true;
                        }
                    }
                    ResDownloadCheckManager instance2 = ResDownloadCheckManager.getInstance();
                    if (instance2.checkPreLoadState(this.f11220l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        af.a("RewardVideoController", "大模板业务，开始检查大模板预加载情况，大模板预加载成功");
                        return true;
                    }
                } else if (campaignEx.isDynamicView()) {
                    return true;
                } else {
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        af.c("RewardMVVideoAdapter", "Is not check template download status");
                        return true;
                    } else if (campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        af.a("RewardVideoController", "非大模板 没有 template");
                        return true;
                    } else {
                        ResDownloadCheckManager instance3 = ResDownloadCheckManager.getInstance();
                        if (instance3.checkPreLoadState(this.f11220l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e())) {
                            af.a("RewardVideoController", "非大模板业务，存在播放模板，播放模板预加载成功");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean a(List<CampaignEx> list, boolean z4, int i5, boolean z5, boolean z6) {
        List<CampaignEx> list2 = list;
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        e eVar = new e();
        if (list2 == null || list2.size() <= 0) {
            eVar.a("event_name", "is_ready_crwtpl_empty");
            eVar.a("reason", "campaign list is empty error");
        } else {
            CampaignEx campaignEx = list2.get(0);
            boolean a5 = com.mbridge.msdk.videocommon.download.b.getInstance().a(94, this.f11220l, this.f11188A, list2.size(), z4, i5, list2, z5, eVar);
            eVar.a("event_name", "is_ready_crwtpl_" + a5);
            if (z6) {
                a(cVar, eVar, list2);
            }
            if (a5) {
                if (z4) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            af.c("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        } else if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            af.c("RewardMVVideoAdapter", "Is not check big template of ENDCARD download status");
                            return true;
                        }
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(this.f11220l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        return true;
                    }
                    if (z6) {
                        eVar.a("event_name", "is_ready_crwtpl_" + a5);
                        eVar.a("reason", "h5 big template checkPreLoadState error");
                        a(cVar, eVar, list2);
                    }
                } else if (campaignEx != null && campaignEx.isDynamicView()) {
                    return true;
                } else {
                    if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        af.c("RewardMVVideoAdapter", "Is not check template download status");
                        return true;
                    } else if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        return true;
                    } else {
                        String str = this.f11220l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e();
                        if (z6) {
                            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str, true);
                        }
                        if (ResDownloadCheckManager.getInstance().checkPreLoadState(str)) {
                            return true;
                        }
                        if (z6) {
                            eVar.a("event_name", "is_ready_crwtpl_" + a5);
                            eVar.a("reason", "h5 template checkPreLoadState error");
                            a(cVar, eVar, list2);
                        }
                    }
                }
            }
        }
        a(cVar, eVar, list2);
        return false;
    }

    public final void a(h hVar, String str, String str2, int i5, String str3, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        try {
            this.f11227s = hVar;
            if (this.f11219k != null) {
                if (!ap.a(this.f11220l)) {
                    Intent intent = new Intent(this.f11219k, MBRewardVideoActivity.class);
                    intent.putExtra(MBRewardVideoActivity.INTENT_UNITID, this.f11220l);
                    intent.putExtra(MBridgeConstans.PLACEMENT_ID, this.f11221m);
                    intent.putExtra(MBRewardVideoActivity.INTENT_REWARD, str);
                    intent.putExtra(MBRewardVideoActivity.INTENT_MUTE, i5);
                    intent.putExtra(MBRewardVideoActivity.INTENT_ISIV, this.f11234z);
                    intent.putExtra(MBRewardVideoActivity.INTENT_ISBID, this.f11188A);
                    intent.putExtra(MBRewardVideoActivity.INTENT_EXTRADATA, str3);
                    CopyOnWriteArrayList<CampaignEx> a5 = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f11220l);
                    boolean z4 = false;
                    if (a5 == null || a5.size() <= 0) {
                        h hVar2 = this.f11227s;
                        if (hVar2 != null) {
                            hVar2.a(cVar, "load failed");
                            return;
                        }
                    } else {
                        CampaignEx campaignEx = a5.get(0);
                        if (campaignEx != null) {
                            this.f11211c = campaignEx.getRequestId();
                        }
                        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                            z4 = true;
                        }
                        g();
                    }
                    intent.putExtra(MBRewardVideoActivity.INTENT_ISBIG_OFFER, z4);
                    if (this.f11234z) {
                        intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_MODETYPE, this.f11191D);
                        intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUETYPE, this.f11192E);
                        intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUE, this.f11193F);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        intent.putExtra(MBRewardVideoActivity.INTENT_USERID, str2);
                    }
                    RewardUnitCacheManager.getInstance().add(this.f11221m, this.f11220l, this.f11229u);
                    try {
                        if (!(com.mbridge.msdk.foundation.controller.c.m() == null || com.mbridge.msdk.foundation.controller.c.m().e() == null)) {
                            ((Activity) com.mbridge.msdk.foundation.controller.c.m().e()).startActivity(intent);
                            return;
                        }
                    } catch (Throwable th) {
                        af.b("RewardMVVideoAdapter", th.getMessage());
                    }
                    intent.addFlags(268435456);
                    this.f11219k.startActivity(intent);
                    return;
                }
            }
            h hVar3 = this.f11227s;
            if (hVar3 != null) {
                hVar3.a(cVar, "context or unitid is null");
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            h hVar4 = this.f11227s;
            if (hVar4 != null) {
                hVar4.a(cVar, "show failed, exception is " + e5.getMessage());
            }
        }
    }

    public final void a(int i5, int i6, boolean z4, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        a(i5, i6, z4, "", this.f11196I, cVar);
    }

    public final void a(int i5, int i6, boolean z4, String str, boolean z5, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        CampaignEx campaignEx;
        this.f11223o = i5;
        this.f11224p = i6;
        this.f11225q = z4;
        this.f11198K = str;
        this.f11196I = z5;
        boolean z6 = false;
        this.f11218j = false;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f11195H;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0 && (campaignEx = this.f11195H.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
            this.f11195H.clear();
        }
        List<CampaignEx> list = this.f11206S;
        if (list != null) {
            list.clear();
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.f11207T;
        if (copyOnWriteArrayList2 != null) {
            copyOnWriteArrayList2.clear();
        }
        this.f11213e = false;
        this.f11214f = false;
        synchronized (this.f11209a) {
            try {
                if (this.f11215g) {
                    this.f11215g = false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.f11217i = false;
        this.f11216h = false;
        try {
            z6 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(this.f11219k);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardMVVideoAdapter", e5.getMessage());
            }
        }
        if (!z6) {
            com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + "WebView is not available");
            if (cVar != null) {
                cVar.a(b5);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is " + "WebView is not available", cVar);
        } else if (this.f11219k == null) {
            com.mbridge.msdk.foundation.c.b b6 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + "Context is null");
            if (cVar != null) {
                cVar.a(b6);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is " + "Context is null", cVar);
        } else if (ap.a(this.f11220l)) {
            com.mbridge.msdk.foundation.c.b b7 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + "UnitId is null");
            if (cVar != null) {
                cVar.a(b7);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is " + "UnitId is null", cVar);
        } else if (this.f11229u == null) {
            com.mbridge.msdk.foundation.c.b b8 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + "RewardUnitSetting is null");
            if (cVar != null) {
                cVar.a(b8);
            }
            b("RewardUnitSetting is null", cVar);
        } else {
            l();
            m();
            af.c("RewardMVVideoAdapter", "load 开始清除过期数据");
            i();
            b(str, z5, cVar);
        }
    }

    private void a(String str, boolean z4, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        boolean z5;
        final com.mbridge.msdk.foundation.same.report.d.c cVar2 = cVar;
        try {
            if (this.f11219k == null) {
                com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + "Context is null");
                if (cVar2 != null) {
                    cVar2.a(b5);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is " + "Context is null", cVar2);
            } else if (ap.a(this.f11220l)) {
                com.mbridge.msdk.foundation.c.b b6 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + "UnitId is null");
                if (cVar2 != null) {
                    cVar2.a(b6);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is " + "UnitId is null", cVar2);
            } else if (this.f11229u == null) {
                com.mbridge.msdk.foundation.c.b b7 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + "RewardUnitSetting is null");
                if (cVar2 != null) {
                    cVar2.a(b7);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is " + "RewardUnitSetting is null", cVar2);
            } else if (!TextUtils.isEmpty(str) || System.currentTimeMillis() - this.f11197J >= ((long) (this.f11229u.a() * 1000))) {
                String str2 = "";
                if (cVar2 != null) {
                    str2 = cVar2.f();
                }
                d dVar = new d(this.f11221m, this.f11220l, this.f11234z, this.f11229u, str2);
                d dVar2 = dVar;
                com.mbridge.msdk.foundation.same.net.f.e a5 = dVar2.a(this.f11225q, this.f11226r, this.f11222n, k(), "", this.f11190C, str, z4, this.f11191D);
                if (a5 == null) {
                    com.mbridge.msdk.foundation.c.b b8 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + "Load param is null");
                    if (cVar2 != null) {
                        cVar2.a(b8);
                    }
                    b("errorCode: 3507 errorMessage: data load failed, errorMsg is " + "Load param is null", cVar2);
                    return;
                }
                this.f11204Q = System.currentTimeMillis();
                com.mbridge.msdk.reward.d.b bVar = new com.mbridge.msdk.reward.d.b(this.f11219k);
                AnonymousClass2 r5 = new com.mbridge.msdk.reward.d.a() {
                    public final void a(CampaignUnit campaignUnit) {
                        CampaignEx campaignEx;
                        try {
                            c.a(c.this, campaignUnit);
                            c.b(c.this, campaignUnit);
                            if (campaignUnit != null) {
                                c.this.f11210b = campaignUnit.getRequestId();
                            }
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                e5.printStackTrace();
                            }
                            if (c.this.f11195H != null && c.this.f11195H.size() > 0 && (campaignEx = (CampaignEx) c.this.f11195H.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
                                c.this.f11195H.clear();
                            }
                            if (c.this.f11206S != null) {
                                c.this.f11206S.clear();
                            }
                            c.this.f11213e = false;
                            c.this.f11214f = false;
                            synchronized (c.this.f11209a) {
                                if (c.this.f11215g) {
                                    c.this.f11215g = false;
                                }
                                c.this.f11217i = false;
                                c.this.f11216h = false;
                                c.this.b("exception after load success", cVar2);
                                c.this.j();
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }

                    public final void a(int i5, String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
                        CampaignEx campaignEx;
                        if (i5 == -1) {
                            long unused = c.this.f11197J = System.currentTimeMillis();
                        }
                        if (c.this.f11195H != null && c.this.f11195H.size() > 0 && (campaignEx = (CampaignEx) c.this.f11195H.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
                            c.this.f11195H.clear();
                        }
                        if (c.this.f11206S != null) {
                            c.this.f11206S.clear();
                        }
                        c.this.f11213e = false;
                        c.this.f11214f = false;
                        synchronized (c.this.f11209a) {
                            try {
                                if (c.this.f11215g) {
                                    c.this.f11215g = false;
                                }
                            } catch (Throwable th) {
                                while (true) {
                                    throw th;
                                }
                            }
                        }
                        c.a(c.this, cVar, i5);
                        c.this.f11217i = false;
                        c.this.f11216h = false;
                        if (!c.this.f11203P) {
                            c.this.a(i5, str, cVar);
                        }
                        c.this.j();
                    }
                };
                String str3 = str;
                r5.a(str3);
                r5.setUnitId(this.f11220l);
                r5.setPlacementId(this.f11221m);
                int i5 = 94;
                r5.setAdType(this.f11234z ? 287 : 94);
                r5.a(cVar2);
                try {
                    com.mbridge.msdk.videocommon.download.h a6 = com.mbridge.msdk.videocommon.download.h.a();
                    if (this.f11234z) {
                        i5 = 287;
                    }
                    z5 = a6.b(i5);
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardMVVideoAdapter", "isRewardVideoRefactorForCampaignRequest exception " + e5.getMessage());
                    }
                    z5 = false;
                }
                boolean z6 = z5;
                try {
                    if (com.mbridge.msdk.foundation.same.net.e.c.a().a(a5) == null) {
                        e eVar = new e();
                        eVar.a("hst", h());
                        cVar2.a("2000125", eVar);
                        com.mbridge.msdk.reward.c.a.a.a().a("2000125", cVar2);
                    }
                } catch (Exception e6) {
                    if (MBridgeConstans.DEBUG) {
                        e6.printStackTrace();
                    }
                }
                if (z6) {
                    com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_t_c", com.mbridge.msdk.foundation.same.a.f9197p);
                    com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_t_r", com.mbridge.msdk.foundation.same.a.f9198q);
                    com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_t_w", com.mbridge.msdk.foundation.same.a.f9198q);
                    com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_r_c", com.mbridge.msdk.foundation.same.a.f9199r);
                    bVar.getCampaign(1, str3, a5, r5, com.mbridge.msdk.foundation.same.c.a((long) (this.f11224p * 1000), (long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS));
                    return;
                }
                AnonymousClass2 r16 = r5;
                String str4 = com.mbridge.msdk.foundation.same.a.f9182a;
                try {
                    g a7 = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                    if (a7 != null) {
                        a7.f();
                        a7.h();
                        a7.e();
                        a7.g();
                    }
                } catch (Exception e7) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("RewardMVVideoAdapter", e7.getMessage());
                    }
                }
                bVar.choiceV3OrV5BySetting(1, a5, r16, str, com.mbridge.msdk.foundation.same.c.a((long) (this.f11224p * 1000), (long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS));
            } else {
                com.mbridge.msdk.foundation.c.b b9 = com.mbridge.msdk.foundation.c.a.b(880018, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + "EXCEPTION_RETURN_EMPTY");
                if (cVar2 != null) {
                    cVar2.a(b9);
                    cVar2.c(true);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is " + "EXCEPTION_RETURN_EMPTY", cVar2);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            b("Load exception", cVar2);
            j();
        }
    }

    private void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f11202O != null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            if (cVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", cVar.f());
                obtain.setData(bundle);
            }
            this.f11202O.sendMessage(obtain);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i5, String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f11202O != null) {
            if (TextUtils.isEmpty(str)) {
                str = "load fail exception";
            }
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = str;
            obtain.arg1 = i5;
            if (cVar != null) {
                cVar.c(true);
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", cVar.f());
                obtain.setData(bundle);
            }
            if (str.contains("exception")) {
                this.f11202O.sendMessageAtFrontOfQueue(obtain);
            } else {
                this.f11202O.sendMessage(obtain);
            }
        }
    }

    private void a(com.mbridge.msdk.foundation.db.j jVar, CampaignEx campaignEx) {
        if (jVar != null && !jVar.b(campaignEx.getId())) {
            com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
            gVar.a(campaignEx.getId());
            gVar.b(campaignEx.getFca());
            gVar.c(campaignEx.getFcb());
            gVar.a(0);
            gVar.d(0);
            gVar.a(System.currentTimeMillis());
            jVar.a(gVar);
        }
    }

    private void a(String str, String str2, List<CampaignEx> list) {
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            com.mbridge.msdk.videocommon.a.a.a().a(str, str2, list);
        }
    }

    public final void a(a aVar) {
        this.f11228t = aVar;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, boolean z4, boolean z5) {
        com.mbridge.msdk.foundation.same.report.d.c cVar;
        if (z5) {
            try {
                this.f11206S = copyOnWriteArrayList;
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
                this.f11207T = copyOnWriteArrayList2;
                cVar = c((List<CampaignEx>) copyOnWriteArrayList2);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardMVVideoAdapter", e5.getMessage());
                }
                cVar = null;
            }
        } else {
            cVar = this.f11194G.getMetricsData();
        }
        a(this.f11194G, (List<CampaignEx>) copyOnWriteArrayList);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            af.c("RewardMVVideoAdapter", "onload load fail, callback campaign have not video");
            if (TextUtils.isEmpty(this.f11205R)) {
                this.f11205R = "APP ALREADY INSTALLED";
            }
            a(this.f11205R.contains("INSTALL") ? 880021 : 880003, this.f11205R, cVar);
            return;
        }
        af.c("RewardMVVideoAdapter", "onload load success size:" + copyOnWriteArrayList.size());
        if (z4) {
            e eVar = new e();
            if (z5) {
                eVar.a("cache", 1);
            } else {
                eVar.a("cache", 2);
            }
            if (cVar != null) {
                cVar.a("2000127", eVar);
                cVar.a("2000048", eVar);
            }
            a(cVar);
        }
        CampaignUnit campaignUnit = this.f11194G;
        if (campaignUnit != null) {
            b(campaignUnit.getSessionId());
        }
        b((List<CampaignEx>) copyOnWriteArrayList);
        if (copyOnWriteArrayList.size() > 0) {
            af.c("RewardMVVideoAdapter", "#######onload 把广告存在本地 size:" + copyOnWriteArrayList.size());
            a(this.f11221m, this.f11220l, (List<CampaignEx>) copyOnWriteArrayList);
        }
        this.f11195H = copyOnWriteArrayList;
        a(copyOnWriteArrayList.get(0));
    }

    private void a(CampaignEx campaignEx) {
        boolean isEmpty = TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        boolean z4 = !isEmpty;
        int nscpt = campaignEx.getNscpt();
        this.f11213e = false;
        this.f11214f = false;
        synchronized (this.f11209a) {
            try {
                if (this.f11215g) {
                    this.f11215g = false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.f11217i = false;
        this.f11216h = false;
        if (this.f11188A) {
            com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getBidToken(), campaignEx.getCampaignUnitId(), campaignEx.getEncryptPrice());
        }
        b.m.f11187a.a(this.f11219k, z4, nscpt, this.f11188A, this.f11234z ? 287 : 94, this.f11221m, this.f11220l, campaignEx.getRequestId(), this.f11195H, new b.c(campaignEx, z4, nscpt) {

            /* renamed from: a  reason: collision with root package name */
            com.mbridge.msdk.foundation.same.report.d.c f11238a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CampaignEx f11239b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f11240c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f11241d;

            {
                this.f11239b = r2;
                this.f11240c = r3;
                this.f11241d = r4;
                this.f11238a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(r2.getLocalRequestId());
            }

            public final void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
                final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2;
                final String str4;
                final String str5;
                final String str6;
                c.this.f11213e = true;
                if (!this.f11240c) {
                    Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        final CampaignEx next = it.next();
                        if (next == null || next.getRewardTemplateMode() == null || TextUtils.isEmpty(next.getRewardTemplateMode().e()) || next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || c.this.f11202O == null) {
                            str6 = str;
                            str5 = str2;
                            str4 = str3;
                            copyOnWriteArrayList2 = copyOnWriteArrayList;
                            c cVar = c.this;
                            if (cVar.a((List<CampaignEx>) cVar.f11195H, this.f11240c, this.f11241d)) {
                                c cVar2 = c.this;
                                c.a(cVar2, cVar2.f11220l, (List) copyOnWriteArrayList2, c.this.f11208U, c.this.f11188A);
                                if (c.this.f11202O != null) {
                                    c.this.f11202O.removeMessages(5);
                                }
                                if (c.this.f11228t != null && !c.this.f11216h) {
                                    c.this.f11216h = true;
                                    com.mbridge.msdk.foundation.same.report.d.c cVar3 = this.f11238a;
                                    if (cVar3 != null) {
                                        cVar3.b((List<CampaignEx>) c.this.f11195H);
                                    }
                                    c.this.f11228t.a((List<CampaignEx>) c.this.f11195H, this.f11238a);
                                }
                            } else {
                                c cVar4 = c.this;
                                c.a(cVar4, str5, cVar4.f11206S, c.this.f11188A, str4);
                                if (c.this.f11202O != null) {
                                    c.this.f11202O.removeMessages(5);
                                }
                                if (c.this.f11228t != null && !c.this.f11217i) {
                                    c.this.f11217i = true;
                                    com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3503 errorMessage: have no temp but isReady false");
                                    if (this.f11238a == null) {
                                        this.f11238a = new com.mbridge.msdk.foundation.same.report.d.c();
                                    }
                                    this.f11238a.b((List<CampaignEx>) c.this.f11195H);
                                    this.f11238a.a(b5);
                                    c.this.f11228t.a(c.this.f11195H, b5, this.f11238a);
                                    af.a("RewardMVVideoAdapter", "Campaign 下载成功： 非大模板，不存在播放模板,isReay false onVideoLoadFail");
                                }
                            }
                        } else {
                            str6 = str;
                            str5 = str2;
                            str4 = str3;
                            copyOnWriteArrayList2 = copyOnWriteArrayList;
                            c.this.f11202O.post(new Runnable() {
                                public final void run() {
                                    b a5 = b.m.f11187a;
                                    boolean l5 = c.this.f11196I;
                                    Handler g5 = c.this.f11202O;
                                    boolean m5 = c.this.f11234z;
                                    boolean f5 = c.this.f11188A;
                                    String e5 = next.getRewardTemplateMode().e();
                                    int n5 = c.this.f11233y;
                                    AnonymousClass3 r6 = AnonymousClass3.this;
                                    a5.a(l5, g5, m5, f5, (WindVaneWebView) null, e5, n5, r6.f11239b, c.this.f11195H, H5DownLoadManager.getInstance().getH5ResAddress(next.getRewardTemplateMode().e()), str6, str5, str4, next.getRequestIdNotice(), c.this.f11229u, new b.j() {
                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0114a aVar) {
                                            c cVar = c.this;
                                            CopyOnWriteArrayList c5 = cVar.f11195H;
                                            AnonymousClass3 r6 = AnonymousClass3.this;
                                            if (cVar.a((List<CampaignEx>) c5, r6.f11240c, r6.f11241d)) {
                                                c cVar2 = c.this;
                                                String d5 = cVar2.f11220l;
                                                AnonymousClass1 r5 = AnonymousClass1.this;
                                                c.a(cVar2, d5, (List) copyOnWriteArrayList2, c.this.f11208U, c.this.f11188A);
                                                if (c.this.f11202O != null) {
                                                    c.this.f11202O.removeMessages(5);
                                                }
                                                if (c.this.f11228t != null && !c.this.f11216h) {
                                                    c.this.f11216h = true;
                                                    AnonymousClass3 r22 = AnonymousClass3.this;
                                                    com.mbridge.msdk.foundation.same.report.d.c cVar3 = r22.f11238a;
                                                    if (cVar3 != null) {
                                                        cVar3.b((List<CampaignEx>) c.this.f11195H);
                                                    }
                                                    c.this.f11228t.a((List<CampaignEx>) c.this.f11195H, AnonymousClass3.this.f11238a);
                                                    return;
                                                }
                                                return;
                                            }
                                            c cVar4 = c.this;
                                            c.a(cVar4, str3, cVar4.f11206S, c.this.f11188A, str4);
                                            if (c.this.f11202O != null) {
                                                c.this.f11202O.removeMessages(5);
                                            }
                                            if (c.this.f11228t != null && !c.this.f11217i) {
                                                c.this.f11217i = true;
                                                com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                                AnonymousClass3 r32 = AnonymousClass3.this;
                                                if (r32.f11238a == null) {
                                                    r32.f11238a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                }
                                                AnonymousClass3 r33 = AnonymousClass3.this;
                                                r33.f11238a.b((List<CampaignEx>) c.this.f11195H);
                                                AnonymousClass3.this.f11238a.a(b5);
                                                c.this.f11228t.a(c.this.f11195H, b5, AnonymousClass3.this.f11238a);
                                                af.a("RewardMVVideoAdapter", "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay false onVideoLoadFail");
                                            }
                                        }

                                        public final void a(String str, String str2, String str3, a.C0114a aVar, com.mbridge.msdk.foundation.c.b bVar) {
                                            if (bVar != null) {
                                                bVar.a("his_reason", "preload template failed is tpl :" + AnonymousClass3.this.f11240c);
                                            }
                                            if (AnonymousClass3.this.f11239b.getRsIgnoreCheckRule() == null || AnonymousClass3.this.f11239b.getRsIgnoreCheckRule().size() <= 0 || !AnonymousClass3.this.f11239b.getRsIgnoreCheckRule().contains(1)) {
                                                AnonymousClass1 r42 = AnonymousClass1.this;
                                                c cVar = c.this;
                                                c.a(cVar, str5, cVar.f11206S, c.this.f11188A, str2);
                                                if (c.this.f11202O != null) {
                                                    c.this.f11202O.removeMessages(5);
                                                }
                                                if (c.this.f11228t != null && !c.this.f11217i) {
                                                    c.this.f11217i = true;
                                                    AnonymousClass3 r43 = AnonymousClass3.this;
                                                    if (r43.f11238a == null) {
                                                        r43.f11238a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                    }
                                                    AnonymousClass3 r44 = AnonymousClass3.this;
                                                    r44.f11238a.b((List<CampaignEx>) c.this.f11195H);
                                                    AnonymousClass3.this.f11238a.a(bVar);
                                                    c.this.f11228t.a(c.this.f11206S, bVar, AnonymousClass3.this.f11238a);
                                                    af.a("RewardMVVideoAdapter", "Campaign 下载失败： 非大模板，播放模板预加载失败 onVideoLoadFail");
                                                    return;
                                                }
                                                return;
                                            }
                                            af.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                                        }
                                    });
                                }
                            });
                        }
                        str = str6;
                        str2 = str5;
                        str3 = str4;
                        copyOnWriteArrayList = copyOnWriteArrayList2;
                    }
                    return;
                }
                final String str7 = str2;
                final String str8 = str3;
                final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = copyOnWriteArrayList;
                if (c.this.f11214f && !c.this.f11215g && c.this.f11202O != null) {
                    synchronized (c.this.f11209a) {
                        try {
                            if (!c.this.f11215g) {
                                c.this.f11215g = true;
                                c.this.f11202O.post(new Runnable() {
                                    public final void run() {
                                        b a5 = b.m.f11187a;
                                        boolean l5 = c.this.f11196I;
                                        Handler g5 = c.this.f11202O;
                                        boolean m5 = c.this.f11234z;
                                        boolean f5 = c.this.f11188A;
                                        String str = str8;
                                        String requestIdNotice = AnonymousClass3.this.f11239b.getRequestIdNotice();
                                        String p5 = c.this.f11221m;
                                        String str2 = str7;
                                        String cMPTEntryUrl = AnonymousClass3.this.f11239b.getCMPTEntryUrl();
                                        int n5 = c.this.f11233y;
                                        AnonymousClass3 r12 = AnonymousClass3.this;
                                        CampaignEx campaignEx = r12.f11239b;
                                        CopyOnWriteArrayList c5 = c.this.f11195H;
                                        String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass3.this.f11239b.getCMPTEntryUrl());
                                        String str3 = str7;
                                        com.mbridge.msdk.videocommon.d.c o5 = c.this.f11229u;
                                        b bVar = a5;
                                        com.mbridge.msdk.videocommon.d.c cVar = o5;
                                        CampaignEx campaignEx2 = campaignEx;
                                        CopyOnWriteArrayList copyOnWriteArrayList = c5;
                                        bVar.a(l5, g5, m5, f5, str, requestIdNotice, p5, str2, cMPTEntryUrl, n5, campaignEx2, copyOnWriteArrayList, h5ResAddress, str3, cVar, new b.j() {
                                            public final void a(String str, String str2, String str3, String str4, String str5, a.C0114a aVar) {
                                                c cVar = c.this;
                                                CopyOnWriteArrayList c5 = cVar.f11195H;
                                                AnonymousClass3 r6 = AnonymousClass3.this;
                                                if (cVar.a((List<CampaignEx>) c5, r6.f11240c, r6.f11241d)) {
                                                    c cVar2 = c.this;
                                                    String d5 = cVar2.f11220l;
                                                    AnonymousClass2 r5 = AnonymousClass2.this;
                                                    c.a(cVar2, d5, (List) copyOnWriteArrayList3, c.this.f11208U, c.this.f11188A);
                                                    if (c.this.f11202O != null) {
                                                        c.this.f11202O.removeMessages(5);
                                                    }
                                                    if (c.this.f11228t != null && !c.this.f11216h) {
                                                        c.this.f11216h = true;
                                                        AnonymousClass3 r22 = AnonymousClass3.this;
                                                        com.mbridge.msdk.foundation.same.report.d.c cVar3 = r22.f11238a;
                                                        if (cVar3 != null) {
                                                            cVar3.b((List<CampaignEx>) c.this.f11195H);
                                                        }
                                                        c.this.f11228t.a((List<CampaignEx>) c.this.f11195H, AnonymousClass3.this.f11238a);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                c cVar4 = c.this;
                                                c.a(cVar4, str3, cVar4.f11206S, c.this.f11188A, str4);
                                                if (c.this.f11202O != null) {
                                                    c.this.f11202O.removeMessages(5);
                                                }
                                                if (c.this.f11228t != null && !c.this.f11217i) {
                                                    c.this.f11217i = true;
                                                    com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                                    AnonymousClass3 r32 = AnonymousClass3.this;
                                                    if (r32.f11238a == null) {
                                                        r32.f11238a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                    }
                                                    AnonymousClass3 r33 = AnonymousClass3.this;
                                                    r33.f11238a.b((List<CampaignEx>) c.this.f11195H);
                                                    AnonymousClass3.this.f11238a.a(b5);
                                                    c.this.f11228t.a(c.this.f11206S, b5, AnonymousClass3.this.f11238a);
                                                    af.a("RewardMVVideoAdapter", "Campaign 下载成功： 大模板预加载成功,isReady false onVideoLoadFail");
                                                }
                                            }

                                            public final void a(String str, String str2, String str3, a.C0114a aVar, com.mbridge.msdk.foundation.c.b bVar) {
                                                if (bVar != null) {
                                                    bVar.a("his_reason", "errorCode: 3303 errorMessage: tpl temp preload failed");
                                                }
                                                if (AnonymousClass3.this.f11239b.getRsIgnoreCheckRule() == null || AnonymousClass3.this.f11239b.getRsIgnoreCheckRule().size() <= 0 || !AnonymousClass3.this.f11239b.getRsIgnoreCheckRule().contains(3)) {
                                                    AnonymousClass2 r32 = AnonymousClass2.this;
                                                    c cVar = c.this;
                                                    c.a(cVar, str7, cVar.f11206S, c.this.f11188A, str2);
                                                    if (c.this.f11202O != null) {
                                                        c.this.f11202O.removeMessages(5);
                                                    }
                                                    if (c.this.f11228t != null && !c.this.f11217i) {
                                                        c.this.f11217i = true;
                                                        AnonymousClass3 r33 = AnonymousClass3.this;
                                                        if (r33.f11238a == null) {
                                                            r33.f11238a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                        }
                                                        AnonymousClass3 r34 = AnonymousClass3.this;
                                                        r34.f11238a.b((List<CampaignEx>) c.this.f11195H);
                                                        AnonymousClass3.this.f11238a.a(bVar);
                                                        c.this.f11228t.a(c.this.f11206S, bVar, AnonymousClass3.this.f11238a);
                                                        af.a("RewardMVVideoAdapter", "Campaign 下载成功： 大模板预加载失败 onVideoLoadFail");
                                                        return;
                                                    }
                                                    return;
                                                }
                                                af.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                                            }
                                        }, false);
                                    }
                                });
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                }
            }

            public final void a(final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, final com.mbridge.msdk.foundation.c.b bVar) {
                c.this.f11213e = false;
                if (c.this.f11228t != null && c.this.f11202O != null) {
                    c.this.f11202O.post(new Runnable() {
                        public final void run() {
                            c cVar = c.this;
                            c.a(cVar, cVar.f11220l, (List) copyOnWriteArrayList, c.this.f11188A, "");
                            if (c.this.f11202O != null) {
                                c.this.f11202O.removeMessages(5);
                            }
                            if (!c.this.f11217i && c.this.f11228t != null) {
                                c.this.f11217i = true;
                                AnonymousClass3 r02 = AnonymousClass3.this;
                                if (r02.f11238a == null) {
                                    r02.f11238a = new com.mbridge.msdk.foundation.same.report.d.c();
                                }
                                AnonymousClass3 r03 = AnonymousClass3.this;
                                r03.f11238a.b((List<CampaignEx>) c.this.f11195H);
                                com.mbridge.msdk.foundation.c.b bVar = bVar;
                                if (bVar != null) {
                                    bVar.a("errorCode: 3201 errorMessage: campaign resource download failed");
                                }
                                AnonymousClass3.this.f11238a.a(bVar);
                                c.this.f11228t.a(copyOnWriteArrayList, bVar, AnonymousClass3.this.f11238a);
                                af.a("RewardMVVideoAdapter", "Campaign 下载失败：onVideoLoadFail");
                            }
                        }
                    });
                }
            }
        }, new b.i(campaignEx, z4, nscpt) {

            /* renamed from: a  reason: collision with root package name */
            com.mbridge.msdk.foundation.same.report.d.c f11258a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CampaignEx f11259b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f11260c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f11261d;

            {
                this.f11259b = r2;
                this.f11260c = r3;
                this.f11261d = r4;
                this.f11258a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(r2.getLocalRequestId());
            }

            public final void a(String str, String str2, String str3, String str4) {
            }

            public final void a(String str, final String str2, final com.mbridge.msdk.foundation.c.b bVar) {
                af.a("RewardMVVideoAdapter", "template 下载失败： ");
                if (bVar != null) {
                    bVar.a("errorCode: 3202 errorMessage: temp resource download failed");
                }
                if (!this.f11260c && c.this.f11228t != null && c.this.f11202O != null) {
                    af.a("RewardMVVideoAdapter", "播放模板下载失败，非大模板");
                    if (this.f11259b.getRsIgnoreCheckRule() == null || this.f11259b.getRsIgnoreCheckRule().size() <= 0 || !this.f11259b.getRsIgnoreCheckRule().contains(1)) {
                        c.this.f11202O.post(new Runnable() {
                            public final void run() {
                                c cVar = c.this;
                                c.a(cVar, cVar.f11220l, c.this.f11206S, c.this.f11188A, str2);
                                if (c.this.f11202O != null) {
                                    c.this.f11202O.removeMessages(5);
                                }
                                if (!c.this.f11217i && c.this.f11228t != null) {
                                    c.this.f11217i = true;
                                    com.mbridge.msdk.foundation.c.b bVar = bVar;
                                    if (bVar != null) {
                                        bVar.a("errorCode: 3202 errorMessage: temp resource download failed");
                                    }
                                    AnonymousClass4 r02 = AnonymousClass4.this;
                                    if (r02.f11258a == null) {
                                        r02.f11258a = new com.mbridge.msdk.foundation.same.report.d.c();
                                    }
                                    AnonymousClass4 r03 = AnonymousClass4.this;
                                    r03.f11258a.b((List<CampaignEx>) c.this.f11195H);
                                    AnonymousClass4.this.f11258a.a(bVar);
                                    c.this.f11228t.a(c.this.f11206S, bVar, AnonymousClass4.this.f11258a);
                                    af.a("RewardMVVideoAdapter", "播放模板下载失败，非大模板 onVideoLoadFail");
                                }
                            }
                        });
                    } else {
                        af.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                    }
                } else if (this.f11261d == 1) {
                    if (this.f11259b.getRsIgnoreCheckRule() != null && this.f11259b.getRsIgnoreCheckRule().size() > 0) {
                        if (this.f11259b.getRsIgnoreCheckRule().contains(3)) {
                            af.c("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                            return;
                        } else if (this.f11259b.getCMPTEntryUrl().equals(this.f11259b.getendcard_url()) && this.f11259b.getRsIgnoreCheckRule().contains(2)) {
                            af.c("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                            return;
                        }
                    }
                    if (c.this.f11228t != null && c.this.f11202O != null) {
                        c.this.f11202O.post(new Runnable() {
                            public final void run() {
                                c cVar = c.this;
                                c.a(cVar, cVar.f11220l, c.this.f11206S, c.this.f11188A, str2);
                                if (c.this.f11202O != null) {
                                    c.this.f11202O.removeMessages(5);
                                }
                                if (!c.this.f11217i && c.this.f11228t != null) {
                                    c.this.f11217i = true;
                                    com.mbridge.msdk.foundation.c.b bVar = bVar;
                                    if (bVar != null) {
                                        bVar.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
                                    }
                                    AnonymousClass4 r02 = AnonymousClass4.this;
                                    if (r02.f11258a == null) {
                                        r02.f11258a = new com.mbridge.msdk.foundation.same.report.d.c();
                                    }
                                    AnonymousClass4 r03 = AnonymousClass4.this;
                                    r03.f11258a.b((List<CampaignEx>) c.this.f11195H);
                                    AnonymousClass4.this.f11258a.a(bVar);
                                    c.this.f11228t.a(c.this.f11206S, bVar, AnonymousClass4.this.f11258a);
                                    af.a("RewardMVVideoAdapter", "播放模板下载失败，大模板，nscpt 1 onVideoLoadFail");
                                }
                            }
                        });
                    }
                }
            }
        });
        if (!isEmpty) {
            b.m.f11187a.a(this.f11219k, campaignEx, this.f11221m, this.f11220l, campaignEx.getRequestId(), new b.i(campaignEx, z4, nscpt) {

                /* renamed from: a  reason: collision with root package name */
                com.mbridge.msdk.foundation.same.report.d.c f11269a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ CampaignEx f11270b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ boolean f11271c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ int f11272d;

                {
                    this.f11270b = r2;
                    this.f11271c = r3;
                    this.f11272d = r4;
                    this.f11269a = com.mbridge.msdk.foundation.same.report.d.d.a().b().get(r2.getLocalRequestId());
                }

                public final void a(final String str, final String str2, final String str3, String str4) {
                    af.a("RewardMVVideoAdapter", "大模板业务，大模板下载成功");
                    c.this.f11214f = true;
                    if (c.this.f11213e && !c.this.f11215g && c.this.f11202O != null) {
                        synchronized (c.this.f11209a) {
                            try {
                                if (!c.this.f11215g) {
                                    c.this.f11215g = true;
                                    c.this.f11202O.post(new Runnable() {
                                        public final void run() {
                                            b a5 = b.m.f11187a;
                                            boolean l5 = c.this.f11196I;
                                            Handler g5 = c.this.f11202O;
                                            boolean m5 = c.this.f11234z;
                                            boolean f5 = c.this.f11188A;
                                            String str = str3;
                                            String requestIdNotice = AnonymousClass5.this.f11270b.getRequestIdNotice();
                                            String str2 = str;
                                            String str3 = str2;
                                            String cMPTEntryUrl = AnonymousClass5.this.f11270b.getCMPTEntryUrl();
                                            int n5 = c.this.f11233y;
                                            AnonymousClass5 r12 = AnonymousClass5.this;
                                            CampaignEx campaignEx = r12.f11270b;
                                            CopyOnWriteArrayList c5 = c.this.f11195H;
                                            String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass5.this.f11270b.getCMPTEntryUrl());
                                            String str4 = str2;
                                            com.mbridge.msdk.videocommon.d.c o5 = c.this.f11229u;
                                            b bVar = a5;
                                            com.mbridge.msdk.videocommon.d.c cVar = o5;
                                            CampaignEx campaignEx2 = campaignEx;
                                            CopyOnWriteArrayList copyOnWriteArrayList = c5;
                                            bVar.a(l5, g5, m5, f5, str, requestIdNotice, str2, str3, cMPTEntryUrl, n5, campaignEx2, copyOnWriteArrayList, h5ResAddress, str4, cVar, new b.j() {
                                                public final void a(String str, String str2, String str3, String str4, String str5, a.C0114a aVar) {
                                                    af.a("HBOPTIMIZE", "模板加载成功 requestId " + str4);
                                                    c cVar = c.this;
                                                    CopyOnWriteArrayList c5 = cVar.f11195H;
                                                    AnonymousClass5 r5 = AnonymousClass5.this;
                                                    if (cVar.a((List<CampaignEx>) c5, r5.f11271c, r5.f11272d)) {
                                                        c cVar2 = c.this;
                                                        c.a(cVar2, cVar2.f11220l, c.this.f11206S, c.this.f11208U, c.this.f11188A);
                                                        if (c.this.f11202O != null) {
                                                            c.this.f11202O.removeMessages(5);
                                                        }
                                                        if (c.this.f11228t != null && !c.this.f11216h) {
                                                            c.this.f11216h = true;
                                                            AnonymousClass5 r22 = AnonymousClass5.this;
                                                            com.mbridge.msdk.foundation.same.report.d.c cVar3 = r22.f11269a;
                                                            if (cVar3 != null) {
                                                                cVar3.b((List<CampaignEx>) c.this.f11195H);
                                                            }
                                                            c.this.f11228t.a((List<CampaignEx>) c.this.f11195H, AnonymousClass5.this.f11269a);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    c cVar4 = c.this;
                                                    c.a(cVar4, str3, cVar4.f11206S, c.this.f11188A, str3);
                                                    if (c.this.f11202O != null) {
                                                        c.this.f11202O.removeMessages(5);
                                                    }
                                                    if (c.this.f11228t != null && !c.this.f11217i) {
                                                        c.this.f11217i = true;
                                                        com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880008, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                                        AnonymousClass5 r32 = AnonymousClass5.this;
                                                        if (r32.f11269a == null) {
                                                            r32.f11269a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                        }
                                                        AnonymousClass5 r33 = AnonymousClass5.this;
                                                        r33.f11269a.b((List<CampaignEx>) c.this.f11195H);
                                                        AnonymousClass5.this.f11269a.a(b5);
                                                        c.this.f11228t.a(c.this.f11206S, b5, AnonymousClass5.this.f11269a);
                                                        af.a("RewardMVVideoAdapter", "大模板业务，大模板预加载成功 isReady false  onVideoLoadFail");
                                                    }
                                                }

                                                public final void a(String str, String str2, String str3, a.C0114a aVar, com.mbridge.msdk.foundation.c.b bVar) {
                                                    af.a("RewardMVVideoAdapter", "大模板业务，大模板预加载失败");
                                                    af.b("HBOPTIMIZE", "模板加载失败 requestId " + str2);
                                                    AnonymousClass1 r32 = AnonymousClass1.this;
                                                    c cVar = c.this;
                                                    c.a(cVar, str2, cVar.f11206S, c.this.f11188A, str2);
                                                    if (c.this.f11202O != null) {
                                                        c.this.f11202O.removeMessages(5);
                                                    }
                                                    if (c.this.f11228t != null && !c.this.f11217i) {
                                                        c.this.f11217i = true;
                                                        AnonymousClass5 r33 = AnonymousClass5.this;
                                                        if (r33.f11269a == null) {
                                                            r33.f11269a = new com.mbridge.msdk.foundation.same.report.d.c();
                                                        }
                                                        AnonymousClass5 r34 = AnonymousClass5.this;
                                                        r34.f11269a.b((List<CampaignEx>) c.this.f11195H);
                                                        AnonymousClass5.this.f11269a.a(bVar);
                                                        c.this.f11228t.a(c.this.f11206S, bVar, AnonymousClass5.this.f11269a);
                                                        af.a("RewardMVVideoAdapter", "大模板业务，大模板预加载失败 onVideoLoadFail");
                                                    }
                                                }
                                            }, false);
                                        }
                                    });
                                }
                            } catch (Throwable th) {
                                while (true) {
                                    throw th;
                                }
                            }
                        }
                    }
                }

                public final void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar) {
                    af.a("RewardMVVideoAdapter", "大模板业务，大模板下载失败");
                    if (this.f11270b.getRsIgnoreCheckRule() != null && this.f11270b.getRsIgnoreCheckRule().size() > 0) {
                        if (this.f11270b.getRsIgnoreCheckRule().contains(3)) {
                            af.c("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                            return;
                        } else if (this.f11270b.getCMPTEntryUrl().equals(this.f11270b.getendcard_url()) && this.f11270b.getRsIgnoreCheckRule().contains(2)) {
                            af.c("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                            return;
                        }
                    }
                    c cVar = c.this;
                    c.a(cVar, cVar.f11220l, c.this.f11206S, c.this.f11188A, str2);
                    c.this.f11214f = false;
                    if (c.this.f11202O != null) {
                        c.this.f11202O.removeMessages(5);
                    }
                    if (c.this.f11228t != null && !c.this.f11217i) {
                        c.this.f11217i = true;
                        if (bVar != null) {
                            bVar.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
                        }
                        if (this.f11269a == null) {
                            this.f11269a = new com.mbridge.msdk.foundation.same.report.d.c();
                        }
                        this.f11269a.b((List<CampaignEx>) c.this.f11195H);
                        this.f11269a.a(bVar);
                        c.this.f11228t.a(c.this.f11206S, bVar, this.f11269a);
                        af.a("RewardMVVideoAdapter", "大模板业务，大模板下载失败 onVideoLoadFail");
                    }
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a1 A[Catch:{ Exception -> 0x002e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r11, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r12, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r13) {
        /*
            r10 = this;
            java.lang.String r0 = ""
            if (r12 == 0) goto L_0x0032
            int r1 = r12.size()     // Catch:{ Exception -> 0x002e }
            if (r1 <= 0) goto L_0x0032
            r1 = 0
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x002e }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x0032
            java.lang.String r2 = r1.getRequestId()     // Catch:{ Exception -> 0x002e }
            int r3 = r1.getVcn()     // Catch:{ Exception -> 0x002e }
            java.lang.String r4 = r1.getBidToken()     // Catch:{ Exception -> 0x002e }
            java.lang.String r5 = r1.getNLRid()     // Catch:{ Exception -> 0x002e }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x002e }
            if (r5 == 0) goto L_0x0035
            java.lang.String r0 = r1.getLocalRequestId()     // Catch:{ Exception -> 0x002e }
            goto L_0x0035
        L_0x002e:
            r0 = move-exception
            r11 = r0
            goto L_0x00c8
        L_0x0032:
            r3 = 1
            r2 = r0
            r4 = r2
        L_0x0035:
            com.mbridge.msdk.videocommon.a.a r1 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x0049
            com.mbridge.msdk.videocommon.a.a r1 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x002e }
            r1.b((java.lang.String) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x002e }
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x002e }
            r0.b(r11)     // Catch:{ Exception -> 0x002e }
        L_0x0049:
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x002e }
            if (r0 == 0) goto L_0x0056
            com.mbridge.msdk.videocommon.a.a r0 = com.mbridge.msdk.videocommon.a.a.a()     // Catch:{ Exception -> 0x002e }
            r0.b((java.lang.String) r11, (int) r3)     // Catch:{ Exception -> 0x002e }
        L_0x0056:
            if (r12 == 0) goto L_0x008f
            int r0 = r12.size()     // Catch:{ Exception -> 0x002e }
            if (r0 <= 0) goto L_0x008f
            com.mbridge.msdk.reward.b.a.a((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ Exception -> 0x002e }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x002e }
        L_0x0065:
            boolean r0 = r12.hasNext()     // Catch:{ Exception -> 0x002e }
            if (r0 == 0) goto L_0x008f
            java.lang.Object r0 = r12.next()     // Catch:{ Exception -> 0x002e }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ Exception -> 0x002e }
            if (r0 == 0) goto L_0x0065
            java.lang.String r1 = r0.getCampaignUnitId()     // Catch:{ Exception -> 0x002e }
            java.lang.String r2 = r0.getRequestId()     // Catch:{ Exception -> 0x002e }
            java.lang.String r3 = r0.getId()     // Catch:{ Exception -> 0x002e }
            long r4 = r0.getPlct()     // Catch:{ Exception -> 0x002e }
            long r6 = r0.getPlctb()     // Catch:{ Exception -> 0x002e }
            long r8 = r0.getTimestamp()     // Catch:{ Exception -> 0x002e }
            com.mbridge.msdk.foundation.same.a.b.a(r1, r2, r3, r4, r6, r8)     // Catch:{ Exception -> 0x002e }
            goto L_0x0065
        L_0x008f:
            if (r13 == 0) goto L_0x00b5
            int r12 = r13.size()     // Catch:{ Exception -> 0x002e }
            if (r12 <= 0) goto L_0x00b5
            java.util.Iterator r12 = r13.iterator()     // Catch:{ Exception -> 0x002e }
        L_0x009b:
            boolean r13 = r12.hasNext()     // Catch:{ Exception -> 0x002e }
            if (r13 == 0) goto L_0x00b5
            java.lang.Object r13 = r12.next()     // Catch:{ Exception -> 0x002e }
            com.mbridge.msdk.foundation.entity.CampaignEx r13 = (com.mbridge.msdk.foundation.entity.CampaignEx) r13     // Catch:{ Exception -> 0x002e }
            if (r13 == 0) goto L_0x009b
            java.lang.String r0 = r13.getCampaignUnitId()     // Catch:{ Exception -> 0x002e }
            java.lang.String r13 = r13.getRequestId()     // Catch:{ Exception -> 0x002e }
            com.mbridge.msdk.foundation.same.a.b.c(r0, r13)     // Catch:{ Exception -> 0x002e }
            goto L_0x009b
        L_0x00b5:
            com.mbridge.msdk.foundation.same.a.b.c(r11)     // Catch:{ Exception -> 0x002e }
            com.mbridge.msdk.foundation.controller.c r11 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x002e }
            android.content.Context r11 = r11.c()     // Catch:{ Exception -> 0x002e }
            com.mbridge.msdk.foundation.db.b r11 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r11)     // Catch:{ Exception -> 0x002e }
            r11.a()     // Catch:{ Exception -> 0x002e }
            return
        L_0x00c8:
            boolean r12 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r12 == 0) goto L_0x00cf
            r11.printStackTrace()
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(java.lang.String, java.util.List, java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0205, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG == false) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0207, code lost:
        com.mbridge.msdk.foundation.tools.af.b("RewardMVVideoAdapter", r13.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x021b, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG == false) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01a9, code lost:
        if (com.mbridge.msdk.foundation.tools.ap.a(r13.getVideoUrlEncode()) != false) goto L_0x01ab;
     */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0214 A[SYNTHETIC, Splitter:B:131:0x0214] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0221 A[SYNTHETIC, Splitter:B:138:0x0221] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0153 A[SYNTHETIC, Splitter:B:76:0x0153] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x017a A[Catch:{ Exception -> 0x001d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> a(com.mbridge.msdk.foundation.entity.CampaignUnit r13) {
        /*
            r12 = this;
            java.lang.String r0 = "RewardMVVideoAdapter"
            java.util.concurrent.CopyOnWriteArrayList r1 = new java.util.concurrent.CopyOnWriteArrayList
            r1.<init>()
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x0011
            boolean r2 = com.mbridge.msdk.e.e.f8766a
            if (r2 == 0) goto L_0x0011
            goto L_0x021e
        L_0x0011:
            r2 = 0
            com.mbridge.msdk.videocommon.d.c r3 = r12.f11229u     // Catch:{ Exception -> 0x001d }
            if (r3 == 0) goto L_0x0020
            r3.u()     // Catch:{ Exception -> 0x001d }
            goto L_0x0020
        L_0x001a:
            r13 = move-exception
            goto L_0x021f
        L_0x001d:
            r13 = move-exception
            goto L_0x020f
        L_0x0020:
            if (r13 == 0) goto L_0x01fc
            java.util.ArrayList r3 = r13.getAds()     // Catch:{ Exception -> 0x001d }
            if (r3 == 0) goto L_0x01fc
            java.util.ArrayList r3 = r13.getAds()     // Catch:{ Exception -> 0x001d }
            int r3 = r3.size()     // Catch:{ Exception -> 0x001d }
            if (r3 <= 0) goto L_0x01fc
            java.util.ArrayList r3 = r13.getAds()     // Catch:{ Exception -> 0x001d }
            r12.f11206S = r3     // Catch:{ Exception -> 0x001d }
            java.util.ArrayList r4 = r13.getAds()     // Catch:{ Exception -> 0x001d }
            r5 = 0
            if (r4 == 0) goto L_0x0077
            java.util.ArrayList r4 = r13.getAds()     // Catch:{ Exception -> 0x001d }
            int r4 = r4.size()     // Catch:{ Exception -> 0x001d }
            if (r4 <= 0) goto L_0x0077
            java.util.ArrayList r4 = r13.getAds()     // Catch:{ Exception -> 0x001d }
            r6 = r5
        L_0x004e:
            int r7 = r4.size()     // Catch:{ Exception -> 0x001d }
            if (r6 >= r7) goto L_0x0065
            java.lang.Object r7 = r4.get(r6)     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7     // Catch:{ Exception -> 0x001d }
            java.lang.String r8 = r12.f11220l     // Catch:{ Exception -> 0x001d }
            r7.setCampaignUnitId(r8)     // Catch:{ Exception -> 0x001d }
            r4.set(r6, r7)     // Catch:{ Exception -> 0x001d }
            int r6 = r6 + 1
            goto L_0x004e
        L_0x0065:
            com.mbridge.msdk.foundation.same.report.d.c r6 = r13.getMetricsData()     // Catch:{ Exception -> 0x001d }
            if (r6 != 0) goto L_0x0073
            com.mbridge.msdk.foundation.same.report.d.c r6 = new com.mbridge.msdk.foundation.same.report.d.c     // Catch:{ Exception -> 0x001d }
            r6.<init>()     // Catch:{ Exception -> 0x001d }
            r13.setMetricsData(r6)     // Catch:{ Exception -> 0x001d }
        L_0x0073:
            r6.b((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4)     // Catch:{ Exception -> 0x001d }
            goto L_0x0078
        L_0x0077:
            r6 = r2
        L_0x0078:
            int r13 = r3.size()     // Catch:{ Exception -> 0x001d }
            if (r5 >= r13) goto L_0x01fc
            r13 = 2147483647(0x7fffffff, float:NaN)
            if (r5 >= r13) goto L_0x01fc
            java.lang.Object r13 = r3.get(r5)     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.foundation.entity.CampaignEx r13 = (com.mbridge.msdk.foundation.entity.CampaignEx) r13     // Catch:{ Exception -> 0x001d }
            boolean r4 = r13.isMraid()     // Catch:{ Exception -> 0x001d }
            if (r4 == 0) goto L_0x017e
            java.lang.String r4 = r13.getMraid()     // Catch:{ Exception -> 0x001d }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x001d }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x001d }
            if (r4 != 0) goto L_0x01f8
            int r4 = r13.getAdType()     // Catch:{ Exception -> 0x001d }
            r7 = 287(0x11f, float:4.02E-43)
            java.lang.String r8 = ""
            if (r4 != r7) goto L_0x00aa
            java.lang.String r4 = "3"
            goto L_0x00c1
        L_0x00aa:
            int r4 = r13.getAdType()     // Catch:{ Exception -> 0x001d }
            r7 = 94
            if (r4 != r7) goto L_0x00b5
            java.lang.String r4 = "1"
            goto L_0x00c1
        L_0x00b5:
            int r4 = r13.getAdType()     // Catch:{ Exception -> 0x001d }
            r7 = 42
            if (r4 != r7) goto L_0x00c0
            java.lang.String r4 = "2"
            goto L_0x00c1
        L_0x00c0:
            r4 = r8
        L_0x00c1:
            com.mbridge.msdk.foundation.same.b.c r7 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r7 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r7)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r9 = r13.getMraid()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r9 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r9)     // Catch:{ Exception -> 0x00e1 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x00e1 }
            if (r10 == 0) goto L_0x00e3
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x00e3
        L_0x00de:
            r13 = move-exception
            goto L_0x0178
        L_0x00e1:
            r7 = move-exception
            goto L_0x0142
        L_0x00e3:
            java.lang.String r10 = ".html"
            java.lang.String r9 = r9.concat(r10)     // Catch:{ Exception -> 0x00e1 }
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x00e1 }
            r10.<init>(r7, r9)     // Catch:{ Exception -> 0x00e1 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00e1 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x00e1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r2.<init>()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r9 = "<script>"
            r2.append(r9)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            com.mbridge.msdk.c.b.a r9 = com.mbridge.msdk.c.b.a.a()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r9 = r9.b()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r2.append(r9)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r9 = "</script>"
            r2.append(r9)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r9 = r13.getMraid()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r2.append(r9)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r7.write(r2)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r7.flush()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r2 = r10.getAbsolutePath()     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r13.setMraid(r2)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            java.lang.String r2 = r12.f11220l     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            com.mbridge.msdk.foundation.same.report.g.a(r13, r8, r2, r4)     // Catch:{ Exception -> 0x013e, all -> 0x013b }
            r7.close()     // Catch:{ Exception -> 0x0137, all -> 0x0133 }
            r2 = r7
            goto L_0x0156
        L_0x0133:
            r13 = move-exception
            r2 = r7
            goto L_0x021f
        L_0x0137:
            r13 = move-exception
            r2 = r7
            goto L_0x020f
        L_0x013b:
            r13 = move-exception
            r2 = r7
            goto L_0x0178
        L_0x013e:
            r2 = move-exception
            r11 = r7
            r7 = r2
            r2 = r11
        L_0x0142:
            r7.printStackTrace()     // Catch:{ all -> 0x00de }
            r13.setMraid(r8)     // Catch:{ all -> 0x00de }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x00de }
            java.lang.String r8 = r12.f11220l     // Catch:{ all -> 0x00de }
            com.mbridge.msdk.foundation.same.report.g.a(r13, r7, r8, r4)     // Catch:{ all -> 0x00de }
            if (r2 == 0) goto L_0x0156
            r2.close()     // Catch:{ Exception -> 0x001d }
        L_0x0156:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x001d }
            java.lang.String r7 = r13.getMraid()     // Catch:{ Exception -> 0x001d }
            r4.<init>(r7)     // Catch:{ Exception -> 0x001d }
            boolean r7 = r4.exists()     // Catch:{ Exception -> 0x001d }
            if (r7 == 0) goto L_0x0171
            boolean r7 = r4.isFile()     // Catch:{ Exception -> 0x001d }
            if (r7 == 0) goto L_0x0171
            boolean r4 = r4.canRead()     // Catch:{ Exception -> 0x001d }
            if (r4 != 0) goto L_0x017e
        L_0x0171:
            java.lang.String r13 = "mraid resource write fail"
            r12.b((java.lang.String) r13, (com.mbridge.msdk.foundation.same.report.d.c) r6)     // Catch:{ Exception -> 0x001d }
            goto L_0x01f8
        L_0x0178:
            if (r2 == 0) goto L_0x017d
            r2.close()     // Catch:{ Exception -> 0x001d }
        L_0x017d:
            throw r13     // Catch:{ Exception -> 0x001d }
        L_0x017e:
            int r4 = r13.getOfferType()     // Catch:{ Exception -> 0x001d }
            r7 = 99
            if (r4 == r7) goto L_0x01f8
            boolean r4 = r12.b((com.mbridge.msdk.foundation.entity.CampaignEx) r13)     // Catch:{ Exception -> 0x001d }
            if (r4 == 0) goto L_0x01a1
            java.lang.String r4 = r13.getendcard_url()     // Catch:{ Exception -> 0x001d }
            boolean r4 = com.mbridge.msdk.foundation.tools.ap.a(r4)     // Catch:{ Exception -> 0x001d }
            if (r4 == 0) goto L_0x01b0
            java.lang.String r4 = r13.getMraid()     // Catch:{ Exception -> 0x001d }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x001d }
            if (r4 == 0) goto L_0x01b0
            goto L_0x01ab
        L_0x01a1:
            java.lang.String r4 = r13.getVideoUrlEncode()     // Catch:{ Exception -> 0x001d }
            boolean r4 = com.mbridge.msdk.foundation.tools.ap.a(r4)     // Catch:{ Exception -> 0x001d }
            if (r4 == 0) goto L_0x01b0
        L_0x01ab:
            java.lang.String r13 = "No video campaign"
            r12.f11205R = r13     // Catch:{ Exception -> 0x001d }
            goto L_0x01f8
        L_0x01b0:
            boolean r4 = com.mbridge.msdk.e.b.a()     // Catch:{ Exception -> 0x001d }
            if (r4 == 0) goto L_0x01ce
            boolean r4 = com.mbridge.msdk.foundation.tools.ak.c((com.mbridge.msdk.foundation.entity.CampaignEx) r13)     // Catch:{ Exception -> 0x001d }
            if (r4 == 0) goto L_0x01ce
            android.content.Context r4 = r12.f11219k     // Catch:{ Exception -> 0x001d }
            java.lang.String r7 = r13.getPackageName()     // Catch:{ Exception -> 0x001d }
            boolean r4 = com.mbridge.msdk.foundation.tools.ak.c((android.content.Context) r4, (java.lang.String) r7)     // Catch:{ Exception -> 0x001d }
            if (r4 == 0) goto L_0x01ca
            r4 = 1
            goto L_0x01cb
        L_0x01ca:
            r4 = 2
        L_0x01cb:
            r13.setRtinsType(r4)     // Catch:{ Exception -> 0x001d }
        L_0x01ce:
            android.content.Context r4 = r12.f11219k     // Catch:{ Exception -> 0x001d }
            boolean r4 = com.mbridge.msdk.foundation.same.c.a((android.content.Context) r4, (com.mbridge.msdk.foundation.entity.CampaignEx) r13)     // Catch:{ Exception -> 0x001d }
            if (r4 == 0) goto L_0x01da
            r1.add(r13)     // Catch:{ Exception -> 0x001d }
            goto L_0x01e5
        L_0x01da:
            java.lang.String r4 = r12.f11220l     // Catch:{ Exception -> 0x001d }
            int r7 = com.mbridge.msdk.foundation.same.a.f9205x     // Catch:{ Exception -> 0x001d }
            com.mbridge.msdk.foundation.tools.ak.a((java.lang.String) r4, (com.mbridge.msdk.foundation.entity.CampaignEx) r13, (int) r7)     // Catch:{ Exception -> 0x001d }
            java.lang.String r4 = "APP ALREADY INSTALLED"
            r12.f11205R = r4     // Catch:{ Exception -> 0x001d }
        L_0x01e5:
            android.content.Context r4 = r12.f11219k     // Catch:{ Exception -> 0x01f0 }
            com.mbridge.msdk.reward.adapter.c$6 r7 = new com.mbridge.msdk.reward.adapter.c$6     // Catch:{ Exception -> 0x01f0 }
            r7.<init>()     // Catch:{ Exception -> 0x01f0 }
            com.mbridge.msdk.foundation.same.c.a(r13, r4, r6, r7)     // Catch:{ Exception -> 0x01f0 }
            goto L_0x01f8
        L_0x01f0:
            r13 = move-exception
            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x001d }
            if (r4 == 0) goto L_0x01f8
            r13.printStackTrace()     // Catch:{ Exception -> 0x001d }
        L_0x01f8:
            int r5 = r5 + 1
            goto L_0x0078
        L_0x01fc:
            if (r2 == 0) goto L_0x021e
            r2.close()     // Catch:{ IOException -> 0x0202 }
            goto L_0x021e
        L_0x0202:
            r13 = move-exception
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x021e
        L_0x0207:
            java.lang.String r13 = r13.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r13)
            goto L_0x021e
        L_0x020f:
            r13.printStackTrace()     // Catch:{ all -> 0x001a }
            if (r2 == 0) goto L_0x021e
            r2.close()     // Catch:{ IOException -> 0x0218 }
            goto L_0x021e
        L_0x0218:
            r13 = move-exception
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x021e
            goto L_0x0207
        L_0x021e:
            return r1
        L_0x021f:
            if (r2 == 0) goto L_0x0231
            r2.close()     // Catch:{ IOException -> 0x0225 }
            goto L_0x0231
        L_0x0225:
            r1 = move-exception
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x0231
            java.lang.String r1 = r1.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r1)
        L_0x0231:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(com.mbridge.msdk.foundation.entity.CampaignUnit):java.util.concurrent.CopyOnWriteArrayList");
    }

    private void a(final CampaignUnit campaignUnit, List<CampaignEx> list) {
        com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
            public final void run() {
                com.mbridge.msdk.foundation.db.j.a((f) com.mbridge.msdk.foundation.db.g.a(c.this.f11219k)).a();
                CampaignUnit campaignUnit = campaignUnit;
                if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    c.a(c.this, (List) campaignUnit.getAds());
                }
            }
        });
    }

    public final void a(List<CampaignEx> list) {
        this.f11208U = list;
    }

    public final void a(int i5, int i6, int i7) {
        this.f11191D = i5;
        this.f11192E = i6;
        this.f11193F = i7;
    }

    public final void a(String str, com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f11229u != null && TextUtils.isEmpty(str)) {
            int b5 = this.f11229u.b() * 1000;
            List<CampaignEx> list = this.f11208U;
            if (list != null && list.size() > 0) {
                if (System.currentTimeMillis() - this.f11208U.get(0).getTimestamp() < ((long) b5)) {
                    b("hit ltorwc", cVar);
                    return;
                }
            }
        }
        a(str, this.f11196I, cVar);
    }

    /* access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.d.c a(Message message) {
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    return com.mbridge.msdk.foundation.same.report.d.d.a().a(data.getString("metrics_data_lrid"), "");
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
        return cVar;
    }

    private void a(com.mbridge.msdk.foundation.same.report.d.c cVar, e eVar, List<CampaignEx> list) {
        if (cVar != null) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        cVar.b(list);
                        CampaignEx campaignEx = list.get(0);
                        if (campaignEx != null) {
                            cVar.c(campaignEx.getLocalRequestId());
                        }
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            cVar.d(this.f11220l);
            cVar.b(this.f11234z ? 287 : 94);
            if (eVar != null) {
                cVar.a("m_temp_is_ready_check", eVar);
            }
            com.mbridge.msdk.reward.c.a.a.a().a("m_temp_is_ready_check", cVar);
        }
    }

    static /* synthetic */ void a(c cVar, String str, List list, List list2, boolean z4) {
        com.mbridge.msdk.foundation.db.e.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2, z4);
        if (list2 != null && list2.size() > 0) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                CampaignEx campaignEx = (CampaignEx) it.next();
                if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                    com.mbridge.msdk.videocommon.a.b(str + "_" + campaignEx.getId() + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                }
            }
        }
        if (z4) {
            cVar.a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2);
        }
        if (list != null && list.size() > 0) {
            try {
                CampaignEx campaignEx2 = (CampaignEx) list.get(0);
                com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(str, cVar.f11234z);
                if (campaignEx2 != null && TextUtils.isEmpty(campaignEx2.getNLRid())) {
                    aVar.a(campaignEx2.getLocalRequestId(), campaignEx2.getRequestId(), 1, campaignEx2.getEcppv());
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(c cVar, String str, List list, boolean z4, String str2) {
        CampaignEx campaignEx;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || ((campaignEx = (CampaignEx) list.get(0)) != null && !TextUtils.isEmpty(campaignEx.getEcppv()) && !TextUtils.isEmpty(str2))) {
            com.mbridge.msdk.foundation.db.e.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(str, (CampaignEx) null, z4, str2);
        } else {
            com.mbridge.msdk.foundation.db.e.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(str, (List<CampaignEx>) list, z4);
        }
    }

    static /* synthetic */ void a(c cVar, CampaignUnit campaignUnit) {
        if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
            try {
                com.mbridge.msdk.foundation.same.report.d.c metricsData = campaignUnit.getMetricsData();
                if (metricsData != null) {
                    e eVar = new e();
                    eVar.a("result", 1);
                    eVar.a("timeout", Integer.valueOf(cVar.f11224p));
                    eVar.a("hst", cVar.h());
                    metricsData.b((List<CampaignEx>) campaignUnit.getAds());
                    metricsData.a("2000126", eVar);
                    campaignUnit.setLocalRequestId(metricsData.f());
                    com.mbridge.msdk.reward.c.a.a.a().a("2000126", metricsData);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("RewardMVVideoAdapter", e5.getMessage());
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, com.mbridge.msdk.foundation.same.report.d.c cVar2, int i5) {
        Object a5;
        if (cVar2 != null) {
            try {
                if (!cVar2.r()) {
                    e eVar = new e();
                    if (!(i5 == 3 || i5 == 880023 || i5 == 880041)) {
                        switch (i5) {
                            case 10:
                            case 11:
                            case 12:
                                break;
                            default:
                                eVar.a("result", "1");
                                break;
                        }
                    }
                    eVar.a("result", "2");
                    eVar.a("timeout", cVar.f11224p + "");
                    com.mbridge.msdk.foundation.c.b o5 = cVar2.o();
                    if (!(o5 == null || (a5 = o5.a((Object) "campaign_request_error")) == null || !(a5 instanceof com.mbridge.msdk.foundation.same.net.a.a))) {
                        if (((com.mbridge.msdk.foundation.same.net.a.a) a5).f9306c != null) {
                            eVar.a("code", Integer.valueOf(((com.mbridge.msdk.foundation.same.net.a.a) a5).f9306c.f9315d));
                        } else {
                            eVar.a("code", Integer.valueOf(o5.a()));
                        }
                        eVar.a("reason", o5.b());
                        eVar.a("err_desc", o5.l());
                        cVar2.a((com.mbridge.msdk.foundation.c.b) null);
                    }
                    eVar.a("hst", cVar.h());
                    cVar2.a("2000126", eVar);
                    com.mbridge.msdk.reward.c.a.a.a().a("2000126", cVar2);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, List list) {
        if (cVar.f11219k != null && list != null && list.size() != 0) {
            com.mbridge.msdk.foundation.db.j a5 = com.mbridge.msdk.foundation.db.j.a((f) com.mbridge.msdk.foundation.db.g.a(cVar.f11219k));
            for (int i5 = 0; i5 < list.size(); i5++) {
                CampaignEx campaignEx = (CampaignEx) list.get(i5);
                if (campaignEx != null) {
                    if (!com.mbridge.msdk.e.b.a()) {
                        cVar.a(a5, campaignEx);
                    } else if (!ak.c(cVar.f11219k, campaignEx.getPackageName())) {
                        cVar.a(a5, campaignEx);
                    }
                }
            }
        }
    }
}
