package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.click.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.same.e.b;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import java.util.concurrent.Semaphore;

public final class n extends e implements a.C0087a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public f f8193a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public JumpLoaderResult f8194b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f8195c = true;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f8196d;

    /* renamed from: e  reason: collision with root package name */
    private Context f8197e;

    /* renamed from: f  reason: collision with root package name */
    private b f8198f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public com.mbridge.msdk.click.entity.a f8199g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f8200h = new Handler(Looper.getMainLooper());

    public n(Context context) {
        this.f8197e = context;
        this.f8198f = new b(context, 2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.mbridge.msdk.click.n$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.mbridge.msdk.click.k} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.mbridge.msdk.click.n$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.mbridge.msdk.click.n$a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r11, com.mbridge.msdk.click.f r12, boolean r13, java.lang.String r14, java.lang.String r15, com.mbridge.msdk.foundation.entity.CampaignEx r16, boolean r17, boolean r18, int r19) {
        /*
            r10 = this;
            r10.f8193a = r12
            r10.f8196d = r13
            com.mbridge.msdk.click.entity.b r2 = new com.mbridge.msdk.click.entity.b
            r2.<init>()
            android.content.Context r4 = r10.f8197e
            r2.a((android.content.Context) r4)
            r2.a((java.lang.String) r11)
            r2.c((boolean) r13)
            r2.b((java.lang.String) r14)
            r2.c((java.lang.String) r15)
            r6 = r16
            r2.a((com.mbridge.msdk.foundation.entity.CampaignEx) r6)
            r7 = r17
            r2.a((boolean) r7)
            r8 = r18
            r2.b((boolean) r8)
            r9 = r19
            r2.a((int) r9)
            java.lang.String r0 = "tcp"
            boolean r0 = r11.startsWith(r0)
            if (r0 == 0) goto L_0x0049
            com.mbridge.msdk.click.k r0 = new com.mbridge.msdk.click.k
            r0.<init>(r2)
            com.mbridge.msdk.click.f r2 = r10.f8193a
            r0.a((com.mbridge.msdk.click.f) r2)
            com.mbridge.msdk.click.n$1 r2 = new com.mbridge.msdk.click.n$1
            r2.<init>()
            r0.a((com.mbridge.msdk.click.j) r2)
            goto L_0x0054
        L_0x0049:
            com.mbridge.msdk.click.n$a r0 = new com.mbridge.msdk.click.n$a
            android.content.Context r2 = r10.f8197e
            r1 = r10
            r3 = r11
            r4 = r14
            r5 = r15
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0054:
            com.mbridge.msdk.foundation.same.e.b r2 = r10.f8198f
            r2.a(r0, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.n.a(java.lang.String, com.mbridge.msdk.click.f, boolean, java.lang.String, java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx, boolean, boolean, int):void");
    }

    public final void a() {
        this.f8195c = false;
    }

    public final void a(a.b bVar) {
        if (bVar == a.b.FINISH && this.f8195c) {
            this.f8200h.post(new Runnable() {
                public final void run() {
                    if (n.this.f8193a == null) {
                        return;
                    }
                    if (n.this.f8194b.isSuccess()) {
                        n.this.f8193a.b(n.this.f8194b);
                    } else {
                        n.this.f8193a.a(n.this.f8194b, n.this.f8194b.getMsg());
                    }
                }
            });
        }
    }

    private class a extends com.mbridge.msdk.foundation.same.e.a {

        /* renamed from: b  reason: collision with root package name */
        private final Semaphore f8204b = new Semaphore(0);

        /* renamed from: c  reason: collision with root package name */
        private final Context f8205c;

        /* renamed from: d  reason: collision with root package name */
        private String f8206d;

        /* renamed from: e  reason: collision with root package name */
        private String f8207e;

        /* renamed from: f  reason: collision with root package name */
        private String f8208f;

        /* renamed from: g  reason: collision with root package name */
        private CampaignEx f8209g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f8210h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f8211i;

        /* renamed from: j  reason: collision with root package name */
        private int f8212j;

        /* renamed from: k  reason: collision with root package name */
        private m.a f8213k = new m.a() {
            public final boolean a(String str) {
                boolean a5 = o.a(str, a.this.f8209g, n.this.f8194b);
                if (a5) {
                    a();
                }
                return a5;
            }

            public final boolean b(String str) {
                boolean a5 = o.a(str, a.this.f8209g, n.this.f8194b);
                if (a5) {
                    a();
                }
                return a5;
            }

            public final boolean c(String str) {
                return false;
            }

            public final void a(String str, boolean z4, String str2) {
                boolean unused = o.a(str, a.this.f8209g, n.this.f8194b);
                n.this.f8194b.setContent(str2);
                a();
            }

            public final void a(int i5, String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    n.this.f8194b.setExceptionMsg(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    n.this.f8194b.setContent(str3);
                }
                boolean unused = o.a(str, a.this.f8209g, n.this.f8194b);
                a();
            }

            private void a() {
                synchronized (n.this) {
                    n.this.f8194b.setSuccess(true);
                    a.this.f8204b.release();
                }
            }
        };

        public a(Context context, String str, String str2, String str3, CampaignEx campaignEx, boolean z4, boolean z5, int i5) {
            this.f8205c = context;
            this.f8206d = str;
            this.f8207e = str2;
            this.f8208f = str3;
            this.f8209g = campaignEx;
            this.f8210h = z4;
            this.f8211i = z5;
            this.f8212j = i5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x01e2 A[EDGE_INSN: B:75:0x01e2->B:72:0x01e2 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.mbridge.msdk.click.entity.JumpLoaderResult a(java.lang.String r14, boolean r15, boolean r16, com.mbridge.msdk.foundation.entity.CampaignEx r17, int r18) {
            /*
                r13 = this;
                java.lang.String r1 = ""
                com.mbridge.msdk.click.n r0 = com.mbridge.msdk.click.n.this
                boolean r0 = r0.f8196d
                if (r0 == 0) goto L_0x0025
                android.content.Context r0 = r13.f8205c
                java.lang.String r0 = com.mbridge.msdk.c.b.a(r0, r14)
                boolean r2 = android.text.TextUtils.isEmpty(r0)
                if (r2 != 0) goto L_0x0025
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r14)
                r2.append(r0)
                java.lang.String r14 = r2.toString()
            L_0x0025:
                com.mbridge.msdk.e.b.a()
                com.mbridge.msdk.click.entity.JumpLoaderResult r2 = new com.mbridge.msdk.click.entity.JumpLoaderResult
                r2.<init>()
                com.mbridge.msdk.click.h r3 = new com.mbridge.msdk.click.h
                r3.<init>()
                boolean r0 = r13.a((java.lang.String) r14)     // Catch:{ Exception -> 0x0047 }
                if (r0 != 0) goto L_0x004a
                java.net.URI r0 = java.net.URI.create(r14)     // Catch:{ Exception -> 0x0047 }
                java.lang.String r4 = r0.getScheme()     // Catch:{ Exception -> 0x0047 }
                java.lang.String r1 = r0.getHost()     // Catch:{ Exception -> 0x0045 }
                goto L_0x004f
            L_0x0045:
                r0 = move-exception
                goto L_0x004c
            L_0x0047:
                r0 = move-exception
                r4 = r1
                goto L_0x004c
            L_0x004a:
                r0 = r1
                goto L_0x0051
            L_0x004c:
                r0.printStackTrace()
            L_0x004f:
                r0 = r1
                r1 = r4
            L_0x0051:
                r4 = 0
                r6 = r14
                r14 = r0
                r5 = r4
            L_0x0055:
                r0 = 10
                if (r5 >= r0) goto L_0x01e2
                com.mbridge.msdk.click.n r0 = com.mbridge.msdk.click.n.this
                boolean r0 = r0.f8195c
                r7 = 0
                if (r0 != 0) goto L_0x0063
                return r7
            L_0x0063:
                com.mbridge.msdk.click.n r0 = com.mbridge.msdk.click.n.this
                r11 = r16
                r8 = r17
                com.mbridge.msdk.click.entity.a r9 = r3.a(r6, r15, r11, r8)
                com.mbridge.msdk.click.entity.a unused = r0.f8199g = r9
                com.mbridge.msdk.click.n r0 = com.mbridge.msdk.click.n.this
                com.mbridge.msdk.click.entity.a r0 = r0.f8199g
                if (r0 != 0) goto L_0x0085
                r2.setUrl(r6)
                r2.setSuccess(r4)
                java.lang.String r14 = "request url is invalided"
                r2.setMsg(r14)
                goto L_0x01e2
            L_0x0085:
                com.mbridge.msdk.click.n r0 = com.mbridge.msdk.click.n.this
                com.mbridge.msdk.click.entity.a r0 = r0.f8199g
                java.lang.String r0 = r0.f8123h
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                r9 = 1
                if (r0 != 0) goto L_0x00cd
                r2.setUrl(r6)
                com.mbridge.msdk.click.n r14 = com.mbridge.msdk.click.n.this
                com.mbridge.msdk.click.entity.a r14 = r14.f8199g
                java.lang.String r14 = r14.f8123h
                r2.setExceptionMsg(r14)
                r2.setType(r9)
                com.mbridge.msdk.click.n r14 = com.mbridge.msdk.click.n.this
                com.mbridge.msdk.click.entity.a r14 = r14.f8199g
                java.lang.String r14 = r14.a()
                r2.setHeader(r14)
                r2.setSuccess(r4)
                if (r5 != 0) goto L_0x01e2
                com.mbridge.msdk.click.a.a r5 = com.mbridge.msdk.click.a.a.a()
                com.mbridge.msdk.click.n r14 = com.mbridge.msdk.click.n.this
                com.mbridge.msdk.click.entity.a r14 = r14.f8199g
                java.lang.String r7 = r14.f8123h
                java.lang.String r9 = r13.f8208f
                r10 = r15
                r12 = r18
                r5.a(r6, r7, r8, r9, r10, r11, r12)
                goto L_0x01e2
            L_0x00cd:
                r2.setSuccess(r9)
                com.mbridge.msdk.click.n r0 = com.mbridge.msdk.click.n.this
                com.mbridge.msdk.click.entity.a r0 = r0.f8199g
                int r0 = r0.f8121f
                r8 = 301(0x12d, float:4.22E-43)
                if (r0 == r8) goto L_0x0137
                r8 = 302(0x12e, float:4.23E-43)
                if (r0 == r8) goto L_0x0137
                r8 = 307(0x133, float:4.3E-43)
                if (r0 != r8) goto L_0x00e5
                goto L_0x0137
            L_0x00e5:
                com.mbridge.msdk.click.n r14 = com.mbridge.msdk.click.n.this
                com.mbridge.msdk.click.entity.a r14 = r14.f8199g
                int r14 = r14.f8121f
                r0 = 200(0xc8, float:2.8E-43)
                if (r14 != r0) goto L_0x0104
                r2.setjumpDone(r9)
                r2.setUrl(r6)
                com.mbridge.msdk.click.n r14 = com.mbridge.msdk.click.n.this
                com.mbridge.msdk.click.entity.a r14 = r14.f8199g
                java.lang.String r14 = r14.f8122g
                r2.setContent(r14)
                goto L_0x01e2
            L_0x0104:
                r2.setjumpDone(r4)
                r2.setUrl(r6)
                if (r5 != 0) goto L_0x01e2
                com.mbridge.msdk.click.a.a r5 = com.mbridge.msdk.click.a.a.a()
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.lang.String r0 = "error code:"
                r14.append(r0)
                com.mbridge.msdk.click.n r0 = com.mbridge.msdk.click.n.this
                com.mbridge.msdk.click.entity.a r0 = r0.f8199g
                int r0 = r0.f8121f
                r14.append(r0)
                java.lang.String r7 = r14.toString()
                java.lang.String r9 = r13.f8208f
                r10 = r15
                r11 = r16
                r8 = r17
                r12 = r18
                r5.a(r6, r7, r8, r9, r10, r11, r12)
                goto L_0x01e2
            L_0x0137:
                r2.setIs302Jump(r9)
                com.mbridge.msdk.click.n r0 = com.mbridge.msdk.click.n.this
                com.mbridge.msdk.click.entity.a r0 = r0.f8199g
                java.lang.String r0 = r0.f8116a
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L_0x0150
                r2.setjumpDone(r9)
                r2.setUrl(r6)
                goto L_0x01e2
            L_0x0150:
                com.mbridge.msdk.click.n r0 = com.mbridge.msdk.click.n.this
                com.mbridge.msdk.click.entity.a r0 = r0.f8199g
                java.lang.String r6 = r0.f8116a
                boolean r0 = r13.a((java.lang.String) r6)
                if (r0 == 0) goto L_0x0193
                java.lang.String r0 = "/"
                boolean r0 = r6.startsWith(r0)
                if (r0 == 0) goto L_0x018c
                boolean r0 = android.text.TextUtils.isEmpty(r1)
                if (r0 != 0) goto L_0x018c
                boolean r0 = android.text.TextUtils.isEmpty(r14)
                if (r0 != 0) goto L_0x018c
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                r0.append(r14)
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                r14 = r7
                r1 = r14
                goto L_0x01aa
            L_0x018c:
                r2.setjumpDone(r9)
                r2.setUrl(r6)
                goto L_0x01e2
            L_0x0193:
                boolean r0 = r13.a((java.lang.String) r6)
                if (r0 != 0) goto L_0x01aa
                java.net.URI r0 = java.net.URI.create(r6)     // Catch:{ Exception -> 0x01a6 }
                java.lang.String r1 = r0.getScheme()     // Catch:{ Exception -> 0x01a6 }
                java.lang.String r14 = r0.getHost()     // Catch:{ Exception -> 0x01a6 }
                goto L_0x01aa
            L_0x01a6:
                r0 = move-exception
                r0.printStackTrace()
            L_0x01aa:
                boolean r0 = com.mbridge.msdk.foundation.tools.aj.a.b((java.lang.String) r6)
                if (r0 == 0) goto L_0x01b7
                r2.setjumpDone(r9)
                r2.setUrl(r6)
                goto L_0x01e2
            L_0x01b7:
                com.mbridge.msdk.click.n r0 = com.mbridge.msdk.click.n.this
                boolean r0 = r0.f8196d
                if (r0 == 0) goto L_0x01db
                android.content.Context r0 = r13.f8205c
                java.lang.String r0 = com.mbridge.msdk.c.b.a(r0, r6)
                boolean r7 = android.text.TextUtils.isEmpty(r0)
                if (r7 != 0) goto L_0x01db
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                r7.append(r6)
                r7.append(r0)
                java.lang.String r0 = r7.toString()
                r6 = r0
            L_0x01db:
                com.mbridge.msdk.e.b.a()
                int r5 = r5 + 1
                goto L_0x0055
            L_0x01e2:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.n.a.a(java.lang.String, boolean, boolean, com.mbridge.msdk.foundation.entity.CampaignEx, int):com.mbridge.msdk.click.entity.JumpLoaderResult");
        }

        public final void cancelTask() {
        }

        public final void pauseTask(boolean z4) {
        }

        public final void runTask() {
            if (n.this.f8193a != null) {
                n.this.f8193a.a((Object) null);
            }
            JumpLoaderResult unused = n.this.f8194b = new JumpLoaderResult();
            n.this.f8194b.setUrl(this.f8206d);
            JumpLoaderResult unused2 = n.this.f8194b = a(this.f8206d, this.f8210h, this.f8211i, this.f8209g, this.f8212j);
            if (!TextUtils.isEmpty(n.this.f8194b.getExceptionMsg())) {
                n.this.f8194b.setSuccess(true);
            }
            if (n.this.f8195c && n.this.f8194b.isSuccess()) {
                if (n.this.f8199g != null) {
                    n.this.f8194b.setStatusCode(n.this.f8199g.f8121f);
                }
                CampaignEx campaignEx = this.f8209g;
                JumpLoaderResult b5 = n.this.f8194b;
                com.mbridge.msdk.click.entity.a d5 = n.this.f8199g;
                String str = this.f8207e;
                String str2 = this.f8208f;
                Context context = this.f8205c;
                m.a aVar = this.f8213k;
                Semaphore semaphore = this.f8204b;
                if (aj.a.b(b5.getUrl()) || 200 != d5.f8121f || TextUtils.isEmpty(b5.getContent()) || b5.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
                    if (d5 != null) {
                        b5.setType(1);
                        b5.setExceptionMsg(d5.f8123h);
                        b5.setStatusCode(d5.f8121f);
                        b5.setHeader(d5.a());
                        b5.setContent(d5.f8122g);
                    }
                    o.a(b5.getUrl(), campaignEx, b5);
                    return;
                }
                b5.setType(2);
                if (!TextUtils.isEmpty(b5.getContent())) {
                    new m().a(str, str2, context, b5.getUrl(), b5.getContent(), aVar);
                } else {
                    try {
                        new m().a(str, str2, context, b5.getUrl(), aVar);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("WebViewSpiderLoaderDiff", e5.getMessage());
                        }
                    }
                }
                semaphore.acquireUninterruptibly();
            }
        }

        private boolean a(String str) {
            return !URLUtil.isNetworkUrl(str);
        }
    }
}
