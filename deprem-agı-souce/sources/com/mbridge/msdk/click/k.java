package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.click.entity.b;
import com.mbridge.msdk.click.m;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import java.util.concurrent.Semaphore;

public final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Semaphore f8143a = new Semaphore(0);

    /* renamed from: b  reason: collision with root package name */
    private Context f8144b;

    /* renamed from: c  reason: collision with root package name */
    private String f8145c;

    /* renamed from: d  reason: collision with root package name */
    private String f8146d;

    /* renamed from: e  reason: collision with root package name */
    private String f8147e;

    /* renamed from: f  reason: collision with root package name */
    private CampaignEx f8148f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8149g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8150h;

    /* renamed from: i  reason: collision with root package name */
    private int f8151i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8152j;

    /* renamed from: k  reason: collision with root package name */
    private com.mbridge.msdk.click.entity.a f8153k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public JumpLoaderResult f8154l;

    /* renamed from: m  reason: collision with root package name */
    private f f8155m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public j f8156n;

    /* renamed from: o  reason: collision with root package name */
    private final m.a f8157o = new m.a() {
        public final boolean a(String str) {
            boolean a5 = k.a(k.this, str);
            if (a5) {
                a();
            }
            return a5;
        }

        public final boolean b(String str) {
            boolean a5 = k.a(k.this, str);
            if (a5) {
                a();
            }
            return a5;
        }

        public final boolean c(String str) {
            return false;
        }

        public final void a(String str, boolean z4, String str2) {
            k.a(k.this, str);
            k.this.f8154l.setContent(str2);
            a();
        }

        private void a() {
            synchronized (this) {
                try {
                    k.this.f8154l.setSuccess(true);
                    if (k.this.f8156n != null) {
                        k.this.f8156n.a(k.this.f8154l);
                    }
                    k.this.f8143a.release();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void a(int i5, String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str2)) {
                k.this.f8154l.setExceptionMsg(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                k.this.f8154l.setContent(str3);
            }
            k.a(k.this, str);
            a();
        }
    };

    public k(b bVar) {
        this.f8144b = bVar.a();
        this.f8145c = bVar.b();
        this.f8146d = bVar.c();
        this.f8147e = bVar.d();
        this.f8148f = bVar.e();
        this.f8149g = bVar.f();
        this.f8150h = bVar.g();
        this.f8151i = bVar.i();
        this.f8152j = bVar.h();
    }

    public final void cancelTask() {
    }

    public final void pauseTask(boolean z4) {
    }

    public final void runTask() {
        f fVar = this.f8155m;
        if (fVar != null) {
            fVar.a((Object) null);
        }
        JumpLoaderResult jumpLoaderResult = new JumpLoaderResult();
        this.f8154l = jumpLoaderResult;
        jumpLoaderResult.setUrl(this.f8145c);
        JumpLoaderResult a5 = a(this.f8145c);
        this.f8154l = a5;
        if (a5 != null && !TextUtils.isEmpty(a5.getExceptionMsg())) {
            this.f8154l.setSuccess(true);
        }
        if (this.mState != a.b.RUNNING) {
            j jVar = this.f8156n;
            if (jVar != null) {
                jVar.a(this.f8154l);
            }
        } else if (!this.f8154l.isSuccess()) {
            j jVar2 = this.f8156n;
            if (jVar2 != null) {
                jVar2.a(this.f8154l);
            }
        } else {
            com.mbridge.msdk.click.entity.a aVar = this.f8153k;
            if (aVar != null) {
                this.f8154l.setStatusCode(aVar.f8121f);
            }
            JumpLoaderResult jumpLoaderResult2 = this.f8154l;
            com.mbridge.msdk.click.entity.a aVar2 = this.f8153k;
            String str = this.f8146d;
            String str2 = this.f8147e;
            Context context = this.f8144b;
            m.a aVar3 = this.f8157o;
            j jVar3 = this.f8156n;
            Semaphore semaphore = this.f8143a;
            if (aj.a.b(jumpLoaderResult2.getUrl()) || 200 != aVar2.f8121f || TextUtils.isEmpty(jumpLoaderResult2.getContent()) || jumpLoaderResult2.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
                if (aVar2 != null) {
                    jumpLoaderResult2.setType(1);
                    jumpLoaderResult2.setExceptionMsg(aVar2.f8123h);
                    jumpLoaderResult2.setStatusCode(aVar2.f8121f);
                    jumpLoaderResult2.setHeader(aVar2.a());
                    jumpLoaderResult2.setContent(aVar2.f8122g);
                }
                String url = jumpLoaderResult2.getUrl();
                if (aj.a.b(url)) {
                    jumpLoaderResult2.setCode(1);
                    jumpLoaderResult2.setUrl(url);
                    jumpLoaderResult2.setjumpDone(true);
                } else {
                    jumpLoaderResult2.setCode(2);
                    jumpLoaderResult2.setUrl(url);
                }
                if (jVar3 != null) {
                    jVar3.a(jumpLoaderResult2);
                    return;
                }
                return;
            }
            jumpLoaderResult2.setType(2);
            if (!TextUtils.isEmpty(jumpLoaderResult2.getContent())) {
                new m().a(str, str2, context, jumpLoaderResult2.getUrl(), jumpLoaderResult2.getContent(), aVar3);
            } else {
                try {
                    new m().a(str, str2, context, jumpLoaderResult2.getUrl(), aVar3);
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("TAG", "webview spider start error");
                    }
                }
            }
            semaphore.acquireUninterruptibly();
        }
    }

    private String b(String str) {
        if (this.f8152j) {
            String a5 = com.mbridge.msdk.c.b.a(this.f8144b, str);
            if (!TextUtils.isEmpty(a5)) {
                str = str + a5;
            }
        }
        com.mbridge.msdk.e.b.a();
        return str;
    }

    public final void a(f fVar) {
        this.f8155m = fVar;
    }

    public final void a(j jVar) {
        this.f8156n = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x016a A[EDGE_INSN: B:74:0x016a->B:63:0x016a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.click.entity.JumpLoaderResult a(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r15 = r14.b((java.lang.String) r15)
            com.mbridge.msdk.click.entity.JumpLoaderResult r1 = new com.mbridge.msdk.click.entity.JumpLoaderResult
            r1.<init>()
            com.mbridge.msdk.click.l r2 = new com.mbridge.msdk.click.l
            r2.<init>()
            com.mbridge.msdk.click.h r3 = new com.mbridge.msdk.click.h
            r3.<init>()
            java.lang.String r4 = ""
            boolean r0 = android.webkit.URLUtil.isNetworkUrl(r15)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x002d
            java.net.URI r0 = java.net.URI.create(r15)     // Catch:{ Exception -> 0x002a }
            java.lang.String r5 = r0.getScheme()     // Catch:{ Exception -> 0x002a }
            java.lang.String r4 = r0.getHost()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0038
        L_0x0028:
            r0 = move-exception
            goto L_0x002f
        L_0x002a:
            r0 = move-exception
            r5 = r4
            goto L_0x002f
        L_0x002d:
            r0 = r4
            goto L_0x003a
        L_0x002f:
            java.lang.String r6 = "SocketRequestTask"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r6, r0)
        L_0x0038:
            r0 = r4
            r4 = r5
        L_0x003a:
            r5 = 0
            r7 = r15
            r15 = r5
        L_0x003d:
            r6 = 10
            if (r15 >= r6) goto L_0x016a
            com.mbridge.msdk.foundation.same.e.a$b r6 = r14.mState
            com.mbridge.msdk.foundation.same.e.a$b r8 = com.mbridge.msdk.foundation.same.e.a.b.RUNNING
            r9 = 0
            if (r6 == r8) goto L_0x0049
            return r9
        L_0x0049:
            java.lang.String r6 = "tcp"
            boolean r6 = r7.startsWith(r6)
            r8 = 1
            if (r6 == 0) goto L_0x0060
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r14.f8148f
            boolean r10 = r14.f8149g
            boolean r11 = r14.f8150h
            com.mbridge.msdk.click.entity.a r6 = r2.a(r7, r6, r10, r11)
            r14.f8153k = r6
            r6 = 3
            goto L_0x006d
        L_0x0060:
            boolean r6 = r14.f8149g
            boolean r10 = r14.f8150h
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r14.f8148f
            com.mbridge.msdk.click.entity.a r6 = r3.a(r7, r6, r10, r11)
            r14.f8153k = r6
            r6 = r8
        L_0x006d:
            com.mbridge.msdk.click.entity.a r10 = r14.f8153k
            if (r10 != 0) goto L_0x0079
            r1.setUrl(r7)
            r1.setSuccess(r5)
            goto L_0x016a
        L_0x0079:
            java.lang.String r10 = r10.f8123h
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x00b3
            r1.setUrl(r7)
            com.mbridge.msdk.click.entity.a r0 = r14.f8153k
            java.lang.String r0 = r0.f8123h
            r1.setExceptionMsg(r0)
            r1.setType(r6)
            com.mbridge.msdk.click.entity.a r0 = r14.f8153k
            java.lang.String r0 = r0.a()
            r1.setHeader(r0)
            r1.setSuccess(r5)
            if (r15 != 0) goto L_0x016a
            com.mbridge.msdk.click.a.a r6 = com.mbridge.msdk.click.a.a.a()
            com.mbridge.msdk.click.entity.a r15 = r14.f8153k
            java.lang.String r8 = r15.f8123h
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r14.f8148f
            java.lang.String r10 = r14.f8147e
            boolean r11 = r14.f8149g
            boolean r12 = r14.f8150h
            int r13 = r14.f8151i
            r6.a(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x016a
        L_0x00b3:
            com.mbridge.msdk.click.entity.a r6 = r14.f8153k
            int r6 = r6.f8121f
            r10 = 200(0xc8, float:2.8E-43)
            if (r6 != r10) goto L_0x00d1
            r1.setjumpDone(r8)
            r1.setUrl(r7)
            r1.setSuccess(r8)
            com.mbridge.msdk.click.entity.a r15 = r14.f8153k
            java.lang.String r15 = r15.f8122g
            if (r15 != 0) goto L_0x00cb
            goto L_0x00cc
        L_0x00cb:
            r9 = r15
        L_0x00cc:
            r1.setContent(r9)
            goto L_0x016a
        L_0x00d1:
            r10 = 301(0x12d, float:4.22E-43)
            if (r6 == r10) goto L_0x00fd
            r10 = 302(0x12e, float:4.23E-43)
            if (r6 == r10) goto L_0x00fd
            r10 = 307(0x133, float:4.3E-43)
            if (r6 != r10) goto L_0x00de
            goto L_0x00fd
        L_0x00de:
            r1.setjumpDone(r5)
            r1.setUrl(r7)
            if (r15 != 0) goto L_0x016a
            com.mbridge.msdk.click.a.a r6 = com.mbridge.msdk.click.a.a.a()
            com.mbridge.msdk.click.entity.a r15 = r14.f8153k
            java.lang.String r8 = r15.f8123h
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r14.f8148f
            java.lang.String r10 = r14.f8147e
            boolean r11 = r14.f8149g
            boolean r12 = r14.f8150h
            int r13 = r14.f8151i
            r6.a(r7, r8, r9, r10, r11, r12, r13)
            goto L_0x016a
        L_0x00fd:
            r1.setSuccess(r8)
            r1.setIs302Jump(r8)
            com.mbridge.msdk.click.entity.a r6 = r14.f8153k
            java.lang.String r6 = r6.f8116a
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x0114
            r1.setjumpDone(r8)
            r1.setUrl(r7)
            goto L_0x016a
        L_0x0114:
            com.mbridge.msdk.click.entity.a r6 = r14.f8153k
            java.lang.String r6 = r6.f8116a
            java.lang.String r7 = "http"
            boolean r7 = r6.startsWith(r7)
            if (r7 != 0) goto L_0x0155
            java.lang.String r7 = "/"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L_0x014e
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 != 0) goto L_0x014e
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L_0x014e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r4 = "://"
            r7.append(r4)
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r0 = r9
            r4 = r0
            goto L_0x0155
        L_0x014e:
            r1.setjumpDone(r8)
            r1.setUrl(r6)
            goto L_0x016a
        L_0x0155:
            boolean r7 = com.mbridge.msdk.foundation.tools.aj.a.b((java.lang.String) r6)
            if (r7 == 0) goto L_0x0162
            r1.setjumpDone(r8)
            r1.setUrl(r6)
            goto L_0x016a
        L_0x0162:
            java.lang.String r7 = r14.b((java.lang.String) r6)
            int r15 = r15 + 1
            goto L_0x003d
        L_0x016a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.k.a(java.lang.String):com.mbridge.msdk.click.entity.JumpLoaderResult");
    }

    static /* synthetic */ boolean a(k kVar, String str) {
        CampaignEx campaignEx = kVar.f8148f;
        JumpLoaderResult jumpLoaderResult = kVar.f8154l;
        if (aj.a.b(jumpLoaderResult.getUrl())) {
            jumpLoaderResult.setCode(1);
            jumpLoaderResult.setUrl(str);
            jumpLoaderResult.setjumpDone(true);
            return true;
        }
        jumpLoaderResult.setCode(2);
        jumpLoaderResult.setUrl(str);
        return false;
    }
}
