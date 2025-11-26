package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.d.c;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a implements Serializable {

    /* renamed from: A  reason: collision with root package name */
    private int f13092A;

    /* renamed from: B  reason: collision with root package name */
    private File f13093B;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public int f13094C;

    /* renamed from: D  reason: collision with root package name */
    private int f13095D;

    /* renamed from: E  reason: collision with root package name */
    private int f13096E;

    /* renamed from: F  reason: collision with root package name */
    private int f13097F;

    /* renamed from: G  reason: collision with root package name */
    private boolean f13098G;

    /* renamed from: H  reason: collision with root package name */
    private k f13099H;

    /* renamed from: I  reason: collision with root package name */
    private c f13100I;

    /* renamed from: J  reason: collision with root package name */
    private k f13101J;

    /* renamed from: K  reason: collision with root package name */
    private boolean f13102K;

    /* renamed from: L  reason: collision with root package name */
    private boolean f13103L;

    /* renamed from: M  reason: collision with root package name */
    private boolean f13104M;

    /* renamed from: N  reason: collision with root package name */
    private boolean f13105N;

    /* renamed from: O  reason: collision with root package name */
    private boolean f13106O;

    /* renamed from: P  reason: collision with root package name */
    private boolean f13107P;

    /* renamed from: Q  reason: collision with root package name */
    private boolean f13108Q;

    /* renamed from: R  reason: collision with root package name */
    private OnDownloadStateListener f13109R;

    /* renamed from: S  reason: collision with root package name */
    private OnProgressStateListener f13110S;

    /* renamed from: a  reason: collision with root package name */
    private boolean f13111a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f13112b = 1;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f13113c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f13114d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public volatile int f13115e = 0;

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<c> f13116f = new CopyOnWriteArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f13117g;

    /* renamed from: h  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f13118h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CampaignEx f13119i;

    /* renamed from: j  reason: collision with root package name */
    private String f13120j;

    /* renamed from: k  reason: collision with root package name */
    private Context f13121k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public long f13122l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f13123m;

    /* renamed from: n  reason: collision with root package name */
    private String f13124n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public long f13125o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f13126p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f13127q = false;

    /* renamed from: r  reason: collision with root package name */
    private long f13128r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f13129s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f13130t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public n f13131u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f13132v;

    /* renamed from: w  reason: collision with root package name */
    private String f13133w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public DownloadRequest f13134x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public int f13135y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public boolean f13136z;

    /* JADX WARNING: Can't wrap try/catch for region: R(7:99|100|101|102|(4:104|(1:106)|107|(1:109))|110|119) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x02e3 */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02e8 A[Catch:{ Exception -> 0x012c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r18, com.mbridge.msdk.foundation.entity.CampaignEx r19, java.lang.String r20, int r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            java.lang.String r2 = "cache"
            java.lang.String r3 = ""
            r1.<init>()
            r4 = 0
            r1.f13111a = r4
            r5 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r1.f13112b = r5
            r1.f13114d = r4
            r1.f13115e = r4
            java.util.concurrent.CopyOnWriteArrayList r7 = new java.util.concurrent.CopyOnWriteArrayList
            r7.<init>()
            r1.f13116f = r7
            r7 = 0
            r1.f13125o = r7
            r1.f13127q = r4
            r9 = 100
            r1.f13129s = r9
            r1.f13130t = r4
            r1.f13132v = r4
            r1.f13094C = r5
            r1.f13098G = r4
            r1.f13102K = r4
            r1.f13103L = r4
            r1.f13104M = r4
            r1.f13105N = r4
            r1.f13106O = r4
            r1.f13107P = r4
            r1.f13108Q = r4
            com.mbridge.msdk.videocommon.download.a$1 r10 = new com.mbridge.msdk.videocommon.download.a$1
            r10.<init>()
            r1.f13109R = r10
            com.mbridge.msdk.videocommon.download.a$2 r10 = new com.mbridge.msdk.videocommon.download.a$2
            r10.<init>()
            r1.f13110S = r10
            if (r18 != 0) goto L_0x0054
            if (r0 != 0) goto L_0x0054
            goto L_0x032e
        L_0x0054:
            com.mbridge.msdk.c.h r10 = com.mbridge.msdk.c.h.a()
            com.mbridge.msdk.foundation.controller.c r11 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r11 = r11.k()
            com.mbridge.msdk.c.g r10 = r10.a(r11)
            if (r10 == 0) goto L_0x006c
            boolean r10 = r10.aG()
            r1.f13098G = r10
        L_0x006c:
            int r10 = com.mbridge.msdk.foundation.same.a.f9202u
            r1.f13095D = r10
            int r10 = com.mbridge.msdk.foundation.same.a.f9203v
            r1.f13096E = r10
            int r10 = com.mbridge.msdk.foundation.same.a.f9201t
            r1.f13097F = r10
            long r10 = java.lang.System.currentTimeMillis()
            r1.f13128r = r10
            com.mbridge.msdk.foundation.controller.c r10 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r10 = r10.c()
            r1.f13121k = r10
            r1.f13119i = r0
            r10 = r20
            r1.f13120j = r10
            r10 = r21
            r1.f13112b = r10
            if (r0 == 0) goto L_0x009a
            java.lang.String r0 = r0.getVideoUrlEncode()
            r1.f13123m = r0
        L_0x009a:
            java.lang.String r0 = r1.f13123m
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.ad.c((java.lang.String) r0)
            r1.f13133w = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.mbridge.msdk.foundation.same.b.c r10 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC
            java.lang.String r10 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r10)
            r0.append(r10)
            java.lang.String r10 = java.io.File.separator
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r1.f13124n = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = r1.f13124n
            r0.append(r10)
            java.lang.String r10 = r1.f13133w
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r1.f13126p = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r1.f13119i
            java.lang.String r10 = r10.getAppName()
            r0.append(r10)
            java.lang.String r10 = " videoLocalPath:"
            r0.append(r10)
            java.lang.String r10 = r1.f13126p
            r0.append(r10)
            java.lang.String r10 = " videoUrl: "
            r0.append(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r1.f13119i
            java.lang.String r10 = r10.getVideoUrlEncode()
            r0.append(r10)
            java.lang.String r10 = " "
            r0.append(r10)
            int r10 = r1.f13129s
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r10 = "CampaignDownLoadTask"
            com.mbridge.msdk.foundation.tools.af.c(r10, r0)
            java.lang.String r0 = r1.f13123m     // Catch:{ Exception -> 0x012c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x0113
            goto L_0x032e
        L_0x0113:
            java.lang.String r0 = r1.f13124n     // Catch:{ Exception -> 0x012c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x012c }
            if (r0 != 0) goto L_0x012f
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f13124n     // Catch:{ Exception -> 0x012c }
            r0.<init>(r11)     // Catch:{ Exception -> 0x012c }
            boolean r11 = r0.exists()     // Catch:{ Exception -> 0x012c }
            if (r11 != 0) goto L_0x0130
            r0.mkdirs()     // Catch:{ Exception -> 0x012c }
            goto L_0x0130
        L_0x012c:
            r0 = move-exception
            goto L_0x0327
        L_0x012f:
            r0 = 0
        L_0x0130:
            if (r0 == 0) goto L_0x0165
            boolean r11 = r0.exists()     // Catch:{ Exception -> 0x012c }
            if (r11 == 0) goto L_0x0165
            java.io.File r11 = r1.f13093B     // Catch:{ Exception -> 0x012c }
            if (r11 == 0) goto L_0x0142
            boolean r11 = r11.exists()     // Catch:{ Exception -> 0x012c }
            if (r11 != 0) goto L_0x0165
        L_0x0142:
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x012c }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012c }
            r12.<init>()     // Catch:{ Exception -> 0x012c }
            r12.append(r0)     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = "/.nomedia"
            r12.append(r0)     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = r12.toString()     // Catch:{ Exception -> 0x012c }
            r11.<init>(r0)     // Catch:{ Exception -> 0x012c }
            r1.f13093B = r11     // Catch:{ Exception -> 0x012c }
            boolean r0 = r11.exists()     // Catch:{ Exception -> 0x012c }
            if (r0 != 0) goto L_0x0165
            java.io.File r0 = r1.f13093B     // Catch:{ Exception -> 0x012c }
            r0.createNewFile()     // Catch:{ Exception -> 0x012c }
        L_0x0165:
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x012c }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.db.g r0 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r0)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.db.n r0 = com.mbridge.msdk.foundation.db.n.a((com.mbridge.msdk.foundation.db.f) r0)     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f13123m     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.entity.m r11 = r0.a((java.lang.String) r11, (java.lang.String) r3)     // Catch:{ Exception -> 0x012c }
            r12 = 5
            if (r11 == 0) goto L_0x0204
            long r13 = r11.c()     // Catch:{ Exception -> 0x012c }
            r1.f13125o = r13     // Catch:{ Exception -> 0x012c }
            int r0 = r1.f13115e     // Catch:{ Exception -> 0x012c }
            r13 = 2
            if (r0 == r13) goto L_0x018f
            int r0 = r11.b()     // Catch:{ Exception -> 0x012c }
            r1.f13115e = r0     // Catch:{ Exception -> 0x012c }
        L_0x018f:
            int r0 = r1.f13115e     // Catch:{ Exception -> 0x012c }
            if (r0 != r5) goto L_0x0195
            r1.f13115e = r13     // Catch:{ Exception -> 0x012c }
        L_0x0195:
            int r0 = r11.d()     // Catch:{ Exception -> 0x012c }
            long r13 = (long) r0     // Catch:{ Exception -> 0x012c }
            r1.f13122l = r13     // Catch:{ Exception -> 0x012c }
            long r13 = r11.a()     // Catch:{ Exception -> 0x012c }
            int r0 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x01aa
            long r13 = r11.a()     // Catch:{ Exception -> 0x012c }
            r1.f13128r = r13     // Catch:{ Exception -> 0x012c }
        L_0x01aa:
            int r0 = r1.f13115e     // Catch:{ Exception -> 0x012c }
            if (r0 != r12) goto L_0x01ea
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x012c }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012c }
            r11.<init>()     // Catch:{ Exception -> 0x012c }
            java.lang.String r13 = r1.f13124n     // Catch:{ Exception -> 0x012c }
            r11.append(r13)     // Catch:{ Exception -> 0x012c }
            java.lang.String r13 = r1.f13133w     // Catch:{ Exception -> 0x012c }
            r11.append(r13)     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x012c }
            r0.<init>(r11)     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f13124n     // Catch:{ Exception -> 0x012c }
            java.lang.String r13 = r1.f13133w     // Catch:{ Exception -> 0x012c }
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.exists(r0, r11, r13)     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x01e6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012c }
            r0.<init>()     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f13124n     // Catch:{ Exception -> 0x012c }
            r0.append(r11)     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f13133w     // Catch:{ Exception -> 0x012c }
            r0.append(r11)     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x012c }
            r1.f13126p = r0     // Catch:{ Exception -> 0x012c }
            goto L_0x020b
        L_0x01e6:
            r1.u()     // Catch:{ Exception -> 0x012c }
            goto L_0x020b
        L_0x01ea:
            int r0 = r1.f13115e     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x020b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012c }
            r0.<init>()     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f13124n     // Catch:{ Exception -> 0x012c }
            r0.append(r11)     // Catch:{ Exception -> 0x012c }
            java.lang.String r11 = r1.f13133w     // Catch:{ Exception -> 0x012c }
            r0.append(r11)     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x012c }
            r1.f13126p = r0     // Catch:{ Exception -> 0x012c }
            goto L_0x020b
        L_0x0204:
            java.lang.String r11 = r1.f13123m     // Catch:{ Exception -> 0x012c }
            long r13 = r1.f13128r     // Catch:{ Exception -> 0x012c }
            r0.a((java.lang.String) r11, (long) r13)     // Catch:{ Exception -> 0x012c }
        L_0x020b:
            long r13 = r1.f13122l     // Catch:{ Exception -> 0x022f }
            int r0 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0246
            long r7 = r1.f13125o     // Catch:{ Exception -> 0x022f }
            r15 = 100
            long r7 = r7 * r15
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f13119i     // Catch:{ Exception -> 0x022f }
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ Exception -> 0x022f }
            long r4 = (long) r0     // Catch:{ Exception -> 0x022f }
            long r13 = r13 * r4
            int r0 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r0 < 0) goto L_0x0246
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f13119i     // Catch:{ Exception -> 0x022f }
            int r0 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ Exception -> 0x022f }
            if (r0 == r9) goto L_0x0231
            int r0 = r1.f13115e     // Catch:{ Exception -> 0x022f }
            if (r0 != r12) goto L_0x0246
            goto L_0x0231
        L_0x022f:
            r0 = move-exception
            goto L_0x023f
        L_0x0231:
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x022f }
            r0.<init>()     // Catch:{ Exception -> 0x022f }
            r0.a(r2, r6)     // Catch:{ Exception -> 0x022f }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r1.f13119i     // Catch:{ Exception -> 0x022f }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r4, (com.mbridge.msdk.foundation.same.report.d.e) r0)     // Catch:{ Exception -> 0x022f }
            goto L_0x0246
        L_0x023f:
            boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x012c }
            if (r4 == 0) goto L_0x0246
            r0.printStackTrace()     // Catch:{ Exception -> 0x012c }
        L_0x0246:
            java.lang.String r4 = r1.f13123m     // Catch:{ Exception -> 0x012c }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x0257
            com.mbridge.msdk.videocommon.listener.a r0 = r1.f13118h     // Catch:{ Exception -> 0x012c }
            java.lang.String r2 = "VideoUrl is NULL, Please check it."
            r0.a(r2, r3)     // Catch:{ Exception -> 0x012c }
            goto L_0x032e
        L_0x0257:
            int r0 = r1.f13115e     // Catch:{ Exception -> 0x012c }
            r5 = 1
            if (r0 != r5) goto L_0x0263
            java.lang.String r0 = "Run : Task is RUNNING, Will return."
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x012c }
            goto L_0x032e
        L_0x0263:
            int r0 = r1.f13115e     // Catch:{ Exception -> 0x012c }
            if (r0 != r12) goto L_0x02bf
            long r7 = r1.f13122l     // Catch:{ Exception -> 0x012c }
            long r12 = r1.f13125o     // Catch:{ Exception -> 0x012c }
            int r0 = com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r7, r12)     // Catch:{ Exception -> 0x012c }
            int r5 = r1.f13129s     // Catch:{ Exception -> 0x012c }
            if (r0 < r5) goto L_0x02bf
            java.lang.String r0 = "Run : Video Done, Will callback."
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.videocommon.listener.a r0 = r1.f13117g     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x0281
            java.lang.String r3 = r1.f13123m     // Catch:{ Exception -> 0x012c }
            r0.a(r3)     // Catch:{ Exception -> 0x012c }
        L_0x0281:
            com.mbridge.msdk.videocommon.listener.a r0 = r1.f13118h     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x028a
            java.lang.String r3 = r1.f13123m     // Catch:{ Exception -> 0x012c }
            r0.a(r3)     // Catch:{ Exception -> 0x012c }
        L_0x028a:
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x02a9 }
            java.lang.String r3 = r1.f13126p     // Catch:{ Exception -> 0x02a9 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x02a9 }
            java.lang.String r3 = r1.f13124n     // Catch:{ Exception -> 0x02a9 }
            java.lang.String r4 = r1.f13133w     // Catch:{ Exception -> 0x02a9 }
            boolean r3 = com.mbridge.msdk.foundation.download.utils.Objects.exists(r0, r3, r4)     // Catch:{ Exception -> 0x02a9 }
            if (r3 == 0) goto L_0x02b1
            boolean r3 = r0.isFile()     // Catch:{ Exception -> 0x02a9 }
            if (r3 == 0) goto L_0x02b1
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02a9 }
            r0.setLastModified(r3)     // Catch:{ Exception -> 0x02a9 }
            goto L_0x02b1
        L_0x02a9:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.tools.af.b(r10, r0)     // Catch:{ Exception -> 0x012c }
        L_0x02b1:
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x012c }
            r0.<init>()     // Catch:{ Exception -> 0x012c }
            r0.a(r2, r6)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.f13119i     // Catch:{ Exception -> 0x012c }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.foundation.same.report.d.e) r0)     // Catch:{ Exception -> 0x012c }
            goto L_0x032e
        L_0x02bf:
            int r0 = r1.f13112b     // Catch:{ Exception -> 0x012c }
            r5 = 3
            if (r0 != r5) goto L_0x02dd
            java.lang.String r0 = "Run : Dlnet is 3, Will callback."
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r10, (java.lang.String) r0)     // Catch:{ Exception -> 0x012c }
            r4 = 0
            r11 = 0
            r1.a((long) r4, (boolean) r11, (java.lang.String) r3)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.same.report.d.e r0 = new com.mbridge.msdk.foundation.same.report.d.e     // Catch:{ Exception -> 0x012c }
            r0.<init>()     // Catch:{ Exception -> 0x012c }
            r0.a(r2, r6)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.f13119i     // Catch:{ Exception -> 0x012c }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r2, (com.mbridge.msdk.foundation.same.report.d.e) r0)     // Catch:{ Exception -> 0x012c }
            goto L_0x032e
        L_0x02dd:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f13119i     // Catch:{ Exception -> 0x02e3 }
            int r9 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ Exception -> 0x02e3 }
        L_0x02e3:
            r1.c((int) r9)     // Catch:{ Exception -> 0x012c }
            if (r9 != 0) goto L_0x02fa
            com.mbridge.msdk.videocommon.listener.a r0 = r1.f13117g     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x02f1
            java.lang.String r2 = r1.f13123m     // Catch:{ Exception -> 0x012c }
            r0.a(r2)     // Catch:{ Exception -> 0x012c }
        L_0x02f1:
            com.mbridge.msdk.videocommon.listener.a r0 = r1.f13118h     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x02fa
            java.lang.String r2 = r1.f13123m     // Catch:{ Exception -> 0x012c }
            r0.a(r2)     // Catch:{ Exception -> 0x012c }
        L_0x02fa:
            com.mbridge.msdk.foundation.download.DownloadMessage r2 = new com.mbridge.msdk.foundation.download.DownloadMessage     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.f13119i     // Catch:{ Exception -> 0x012c }
            java.lang.String r5 = r1.f13133w     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.download.DownloadResourceType r7 = com.mbridge.msdk.foundation.download.DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO     // Catch:{ Exception -> 0x012c }
            r6 = 100
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.f13119i     // Catch:{ Exception -> 0x012c }
            int r0 = r1.e((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ Exception -> 0x012c }
            r2.setUseCronetDownload(r0)     // Catch:{ Exception -> 0x012c }
            java.lang.String r0 = "resource_type"
            r3 = 4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x012c }
            r2.addExtra(r0, r3)     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.download.OnDownloadStateListener r0 = r1.f13109R     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.foundation.download.OnProgressStateListener r3 = r1.f13110S     // Catch:{ Exception -> 0x012c }
            java.lang.String r4 = "1"
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r1.a((com.mbridge.msdk.foundation.download.DownloadMessage) r2, (com.mbridge.msdk.foundation.download.OnDownloadStateListener) r0, (com.mbridge.msdk.foundation.download.OnProgressStateListener) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x012c }
            r1.f13134x = r0     // Catch:{ Exception -> 0x012c }
            goto L_0x032e
        L_0x0327:
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.c(r10, r0)
        L_0x032e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.a.<init>(android.content.Context, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, int):void");
    }

    private void u() {
        if (this.f13131u == null) {
            this.f13131u = n.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        try {
            this.f13131u.b(this.f13123m);
            if (!ah.a().a("r_d_v_b_l", true)) {
                File file = new File(this.f13126p);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
            af.b("CampaignDownLoadTask", "del DB or file failed");
        } finally {
            this.f13115e = 0;
        }
    }

    /* access modifiers changed from: private */
    public void v() {
        Class<CampaignEx> cls = CampaignEx.class;
        Class<String> cls2 = String.class;
        Class<com.mbridge.msdk.reward.b.a> cls3 = com.mbridge.msdk.reward.b.a.class;
        try {
            String str = com.mbridge.msdk.reward.b.a.f11295b;
            com.mbridge.msdk.reward.b.a newInstance = cls3.newInstance();
            cls3.getMethod("insertExcludeId", new Class[]{cls2, cls}).invoke(newInstance, new Object[]{this.f13120j, this.f13119i});
            Class<?> cls4 = Class.forName("com.mbridge.msdk.mbnative.controller.NativeController");
            Object newInstance2 = cls4.newInstance();
            cls4.getMethod("insertExcludeId", new Class[]{cls2, cls}).invoke(newInstance2, new Object[]{this.f13120j, this.f13119i});
        } catch (Exception e5) {
            af.b("CampaignDownLoadTask", e5.getMessage());
        }
    }

    public final void o() {
        af.b("CampaignDownLoadTask", "start()");
        try {
            if (!TextUtils.isEmpty(this.f13123m)) {
                if (this.f13123m != null) {
                    af.b("CampaignDownLoadTask", new URL(this.f13123m).getPath());
                }
                if (this.f13129s == 0 && this.f13094C == 2) {
                    af.b("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                    return;
                }
                DownloadRequest downloadRequest = this.f13134x;
                if (downloadRequest != null) {
                    downloadRequest.start();
                }
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.f13117g;
            if (aVar != null) {
                aVar.a("VideoUrl is not illegal, Please check it.", "");
            }
            com.mbridge.msdk.videocommon.listener.a aVar2 = this.f13118h;
            if (aVar2 != null) {
                aVar2.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final void p() {
        if (!this.f13108Q) {
            try {
                this.f13136z = true;
                if (this.f13094C == 1) {
                    af.b("CampaignDownLoadTask", "Can not call resume(), because videoCtnType = " + this.f13094C);
                } else if (this.f13112b == 3) {
                    af.b("CampaignDownLoadTask", "Can not call resume(), because dlnet = " + this.f13112b);
                } else {
                    af.b("CampaignDownLoadTask", "resume()");
                    this.f13106O = false;
                    this.f13107P = false;
                    DownloadMessage downloadMessage = new DownloadMessage(new Object(), this.f13123m, this.f13133w, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
                    downloadMessage.setUseCronetDownload(e(this.f13119i));
                    DownloadRequest<?> a5 = a(downloadMessage, this.f13109R, this.f13110S, "2");
                    this.f13134x = a5;
                    a5.start();
                }
            } catch (Exception e5) {
                af.b("CampaignDownLoadTask", e5.getMessage());
            }
        }
    }

    public final String q() {
        String str = "";
        if (this.f13112b == 3) {
            return str;
        }
        String str2 = this.f13124n + this.f13133w;
        File file = new File(str2);
        try {
            if (!Objects.exists(file, this.f13124n, this.f13133w)) {
                str = "file is not exist ";
            } else if (!file.isFile()) {
                str = "file is not file ";
            } else if (!file.canRead()) {
                str = "file can not read ";
            } else if (file.length() > 0) {
                this.f13126p = str2;
            } else {
                str = "file length is 0 ";
            }
        } catch (Throwable th) {
            af.b("CampaignDownLoadTask", th.getMessage());
            str = th.getMessage();
        }
        if (this.f13115e == 5 && !TextUtils.isEmpty(str)) {
            u();
        }
        return str;
    }

    public final void r() {
        if (this.f13116f != null) {
            this.f13116f = null;
        }
    }

    public final void s() {
        try {
            u();
            CampaignEx campaignEx = this.f13119i;
            if (campaignEx == null || campaignEx.getPlayable_ads_without_video() != 2) {
                com.mbridge.msdk.videocommon.a.a a5 = com.mbridge.msdk.videocommon.a.a.a();
                if (a5 != null) {
                    a5.a(this.f13119i);
                }
                this.f13115e = 0;
            }
        } catch (Exception unused) {
            af.b("CampaignDownLoadTask", "del file is failed");
        } finally {
            this.f13115e = 0;
        }
    }

    public final String t() {
        if (this.f13108Q) {
            try {
                File file = new File(this.f13126p);
                if (!file.exists() || !file.isFile()) {
                    return this.f13123m;
                }
                return this.f13126p;
            } catch (Exception e5) {
                af.b("CampaignDownLoadTask", e5.getMessage());
                return this.f13123m;
            }
        } else {
            try {
                File file2 = new File(this.f13126p);
                if (Objects.exists(file2, this.f13124n, this.f13133w) && file2.isFile()) {
                    return this.f13126p;
                }
            } catch (Exception e6) {
                af.b("CampaignDownLoadTask", e6.getMessage());
            }
            return this.f13123m;
        }
    }

    public final void c(boolean z4) {
        this.f13104M = z4;
    }

    public final void d(boolean z4) {
        this.f13105N = z4;
    }

    public final String e() {
        return this.f13123m;
    }

    public final boolean f() {
        return this.f13132v;
    }

    public final long g() {
        return this.f13128r;
    }

    public final String h() {
        return this.f13126p;
    }

    public final boolean i() {
        return this.f13108Q;
    }

    public final long j() {
        return this.f13122l;
    }

    public final int k() {
        return this.f13115e;
    }

    public final CampaignEx l() {
        return this.f13119i;
    }

    public final long m() {
        return this.f13125o;
    }

    public final void n() {
        af.b("CampaignDownLoadTask", "startForLoadRefactor()");
        try {
            if (TextUtils.isEmpty(this.f13123m)) {
                com.mbridge.msdk.videocommon.listener.a aVar = this.f13117g;
                if (aVar != null) {
                    aVar.a(this.f13123m);
                    return;
                }
                return;
            }
            if (this.f13123m != null) {
                af.b("CampaignDownLoadTask", new URL(this.f13123m).getPath());
            }
            if (this.f13112b == 3) {
                af.b("CampaignDownLoadTask", "startForLoadRefactor: Dlnet is 3, Will callback.");
                com.mbridge.msdk.videocommon.listener.a aVar2 = this.f13117g;
                if (aVar2 != null) {
                    aVar2.a(this.f13123m);
                }
            } else if (this.f13129s == 0 && this.f13094C == 2) {
                af.b("CampaignDownLoadTask", "Can not start download because readyRate is 0 and videoCtnType is 2");
                com.mbridge.msdk.videocommon.listener.a aVar3 = this.f13117g;
                if (aVar3 != null) {
                    aVar3.a(this.f13123m);
                }
            } else {
                try {
                    if (this.f13115e == 5 && Utils.getDownloadRate(this.f13122l, this.f13125o) >= this.f13129s) {
                        if (Objects.exists(new File(this.f13124n + this.f13133w), this.f13124n, this.f13133w)) {
                            this.f13126p = this.f13124n + this.f13133w;
                            com.mbridge.msdk.videocommon.listener.a aVar4 = this.f13117g;
                            if (aVar4 != null) {
                                aVar4.a(this.f13123m);
                                return;
                            }
                            return;
                        }
                    }
                } catch (Exception e5) {
                    af.b("CampaignDownLoadTask", "startForLoadRefactor: " + e5.getMessage());
                }
                DownloadRequest downloadRequest = this.f13134x;
                if (downloadRequest != null) {
                    downloadRequest.start();
                }
            }
        } catch (Throwable unused) {
            com.mbridge.msdk.videocommon.listener.a aVar5 = this.f13117g;
            if (aVar5 != null) {
                aVar5.a("VideoUrl is not illegal, Please check it.", "");
            }
        }
    }

    public final boolean c() {
        return this.f13104M;
    }

    public final boolean d() {
        return this.f13105N;
    }

    public final void e(boolean z4) {
        this.f13132v = z4;
    }

    public final void f(boolean z4) {
        this.f13127q = z4;
    }

    public final void b(boolean z4) {
        this.f13103L = z4;
    }

    public final void c(int i5) {
        af.a("CampaignDownLoadTask", "set ready rate: " + i5);
        this.f13129s = i5;
    }

    public final void d(int i5) {
        this.f13092A = i5;
    }

    public final void e(int i5) {
        this.f13094C = i5;
    }

    private int d(CampaignEx campaignEx) {
        try {
            k kVar = this.f13101J;
            if (kVar != null) {
                return kVar.p();
            }
            return 100;
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            af.b("CampaignDownLoadTask", e5.getMessage());
            return 100;
        }
    }

    private int e(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getAabEntity() != null) {
                    return campaignEx.getAabEntity().h3c;
                }
            } catch (Throwable th) {
                af.b("CampaignDownLoadTask", th.getMessage());
            }
        }
        return 0;
    }

    public final boolean b() {
        return this.f13103L;
    }

    private int c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 100;
        }
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.f13099H == null) {
                    this.f13099H = h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f13120j);
                }
                return this.f13099H.p();
            } else if (campaignEx.getAdType() == 42) {
                if (this.f13101J == null) {
                    this.f13101J = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f13120j);
                }
                return d((CampaignEx) null);
            } else {
                if (this.f13100I == null) {
                    this.f13100I = b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f13120j, false);
                }
                return this.f13100I.r();
            }
        } catch (Throwable th) {
            af.b("CampaignDownLoadTask", th.getMessage(), th);
            return 100;
        }
    }

    public final void b(int i5) {
        this.f13113c = i5;
    }

    private int b(CampaignEx campaignEx) {
        int i5;
        if (campaignEx == null) {
            return 100;
        }
        if (campaignEx.getReady_rate() != -1) {
            i5 = campaignEx.getReady_rate();
            af.a("CampaignDownLoadTask", "ready_rate(campaign): " + i5);
        } else {
            i5 = c(campaignEx);
            af.a("CampaignDownLoadTask", "ready_rate(reward_unit_setting): " + i5);
        }
        try {
            return Math.max(i5, 0);
        } catch (Exception unused) {
            return 100;
        }
    }

    public final void a(boolean z4) {
        this.f13102K = z4;
    }

    public final boolean a() {
        return this.f13102K;
    }

    public final void d(String str) {
        this.f13123m = str;
    }

    public final void a(int i5) {
        this.f13112b = i5;
    }

    public final void a(int i5, int i6) {
        this.f13115e = i5;
        if (this.f13131u == null) {
            this.f13131u = n.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        }
        this.f13131u.a(this.f13123m, (long) i6, i5);
    }

    public final void b(String str) {
        v();
        a(2, str, "");
        this.f13115e = 4;
    }

    public final void a(CampaignEx campaignEx) {
        this.f13119i = campaignEx;
    }

    private DownloadRequest<?> a(DownloadMessage downloadMessage, OnDownloadStateListener onDownloadStateListener, OnProgressStateListener onProgressStateListener, String str) {
        return MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout((long) this.f13095D).withConnectTimeout((long) this.f13097F).withWriteTimeout((long) this.f13096E).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(this.f13124n).withDownloadStateListener(onDownloadStateListener).withProgressStateListener(onProgressStateListener).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).with("do_us_fi_re", Boolean.toString(this.f13098G)).with("download_scene", "download_video").with(CampaignEx.JSON_KEY_READY_RATE, String.valueOf(this.f13129s)).with("scenes", str).build();
    }

    public final void b(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f13118h = aVar;
    }

    public final void c(String str) {
        this.f13126p = str;
    }

    public final void a(long j5, boolean z4, String str) {
        n nVar;
        af.b("CampaignDownLoadTask", "setStateToDone 下载完成  ： mProgressSize" + this.f13125o + "  progressSize " + j5 + "  " + this.f13135y + "%   FileSize : " + this.f13122l + "  " + this.f13119i.getAppName());
        long j6 = 0;
        if (this.f13129s != 100 || this.f13112b == 3 || j5 == this.f13122l || z4) {
            this.f13115e = 5;
            if (j5 == this.f13122l) {
                a(1, "", str);
            }
            long j7 = this.f13122l;
            if (!(j7 == 0 || (nVar = this.f13131u) == null)) {
                nVar.b(this.f13123m, j7);
            }
            this.f13111a = false;
            a(j5, this.f13115e);
            return;
        }
        File file = new File(this.f13126p);
        if (Objects.exists(file, this.f13124n, this.f13133w)) {
            j6 = file.length();
        }
        af.b("CampaignDownLoadTask", "progressSize = " + j5 + " fileSize = " + this.f13122l + " " + z4 + " absFileSize = " + j6);
        a("File size is not match witch download size.");
    }

    public final void a(String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = this.f13117g;
        if (aVar != null) {
            aVar.a(str, this.f13123m);
        }
        com.mbridge.msdk.videocommon.listener.a aVar2 = this.f13118h;
        if (aVar2 != null) {
            aVar2.a(str, this.f13123m);
        }
        af.b("CampaignDownLoadTask", "Video download stop : " + str);
        if (this.f13115e != 4 && this.f13115e != 2 && this.f13115e != 5) {
            this.f13115e = 4;
            CampaignEx campaignEx = this.f13119i;
            if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || this.f13119i.getRsIgnoreCheckRule().size() <= 0 || !this.f13119i.getRsIgnoreCheckRule().contains(0)) {
                a(this.f13125o, this.f13115e);
            } else {
                af.c("CampaignDownLoadTask", "Is not check video download status");
            }
        }
    }

    public final void a(c cVar) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f13116f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(cVar);
        }
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f13117g = aVar;
    }

    private void a(long j5, int i5) {
        this.f13125o = j5;
        int i6 = this.f13129s;
        if (100 * j5 >= ((long) i6) * this.f13122l && !this.f13130t && i5 != 4) {
            if (i6 != 100 || i5 == 5) {
                this.f13130t = true;
                af.b("CampaignDownLoadTask", "UpdateListener : state: " + i5 + " progress : " + j5);
                String q5 = q();
                if (TextUtils.isEmpty(q5)) {
                    com.mbridge.msdk.videocommon.listener.a aVar = this.f13117g;
                    if (aVar != null) {
                        aVar.a(this.f13123m);
                    }
                    com.mbridge.msdk.videocommon.listener.a aVar2 = this.f13118h;
                    if (aVar2 != null) {
                        aVar2.a(this.f13123m);
                    }
                } else {
                    com.mbridge.msdk.videocommon.listener.a aVar3 = this.f13117g;
                    if (aVar3 != null) {
                        aVar3.a("file is not effective " + q5, this.f13123m);
                    }
                    com.mbridge.msdk.videocommon.listener.a aVar4 = this.f13118h;
                    if (aVar4 != null) {
                        aVar4.a("file is not effective " + q5, this.f13123m);
                    }
                }
            } else {
                this.f13115e = 5;
                return;
            }
        }
        if (!this.f13111a && j5 > 0) {
            this.f13111a = true;
            if (this.f13131u == null) {
                this.f13131u = n.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            }
            this.f13131u.a(this.f13123m, j5, this.f13115e);
        }
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f13116f;
        if (copyOnWriteArrayList != null) {
            Iterator<c> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    next.a(j5, i5);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i5, String str, String str2) {
        long j5 = 0;
        if (this.f13128r != 0) {
            j5 = System.currentTimeMillis() - this.f13128r;
        }
        com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n(this.f13121k, this.f13119i, i5, Long.toString(j5), this.f13122l, this.f13092A);
        nVar.e(this.f13119i.getId());
        nVar.m(this.f13119i.getVideoUrlEncode());
        nVar.h(str);
        nVar.f(this.f13119i.getRequestId());
        nVar.s(this.f13119i.getCurrentLocalRid());
        nVar.g(this.f13119i.getRequestIdNotice());
        nVar.c(this.f13120j);
        nVar.t(str2);
        nVar.a(CampaignEx.JSON_KEY_READY_RATE, String.valueOf(this.f13129s));
        nVar.a("url", this.f13119i.getVideoUrlEncode());
        nVar.e(4);
        DownloadRequest downloadRequest = this.f13134x;
        if (downloadRequest != null) {
            nVar.a("scenes", downloadRequest.get("scenes", ""));
            nVar.a("resumed_breakpoint", this.f13134x.get("resumed_breakpoint", ""));
        }
        int i6 = this.f13092A;
        if (i6 != 94 && i6 != 287) {
            o.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(nVar);
        }
    }

    /* access modifiers changed from: private */
    public void a(CampaignEx campaignEx, e eVar) {
        if (!this.f13106O && campaignEx != null && eVar != null) {
            this.f13106O = true;
            try {
                eVar.a("resource_type", 4);
                DownloadRequest downloadRequest = this.f13134x;
                if (downloadRequest != null) {
                    eVar.a("scenes", downloadRequest.get("scenes", "1"));
                    eVar.a("resumed_breakpoint", this.f13134x.get("resumed_breakpoint", "2"));
                } else {
                    eVar.a("scenes", "1");
                    eVar.a("resumed_breakpoint", "1");
                }
                eVar.a("url", campaignEx.getVideoUrlEncode());
                eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(this.f13129s));
                d.a().a("m_download_start", campaignEx, eVar);
            } catch (Exception e5) {
                af.b("CampaignDownLoadTask", e5.getMessage());
            }
        }
    }

    static /* synthetic */ void a(a aVar, int i5, boolean z4, String str) {
        if (!aVar.f13107P) {
            try {
                aVar.f13107P = true;
                e eVar = new e();
                DownloadRequest downloadRequest = aVar.f13134x;
                if (downloadRequest != null) {
                    eVar.a("scenes", downloadRequest.get("scenes", ""));
                    eVar.a("url", aVar.f13123m);
                    eVar.a("resumed_breakpoint", aVar.f13134x.get("resumed_breakpoint", ""));
                    eVar.a("h3c", "");
                }
                eVar.a("resource_type", 4);
                eVar.a("file_size", Long.valueOf(aVar.f13122l));
                eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(aVar.f13129s));
                eVar.a("result", Integer.valueOf(i5));
                eVar.a("reason", str);
                d.a().a("m_download_end", aVar.f13119i, eVar);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }
}
