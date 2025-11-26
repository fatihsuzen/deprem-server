package com.mbridge.msdk.newreward.function.command.receiver.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.util.HashMap;
import java.util.Map;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public com.mbridge.msdk.newreward.function.command.a.a f10743a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f10744b = false;

    /* renamed from: c  reason: collision with root package name */
    private long f10745c;

    /* renamed from: d  reason: collision with root package name */
    private int f10746d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f10747e = 0;

    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.a.a$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10753a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mbridge.msdk.newreward.function.command.f[] r0 = com.mbridge.msdk.newreward.function.command.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10753a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_V3_RETRY_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10753a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_V3_RETRY_END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.a.a.AnonymousClass2.<clinit>():void");
        }
    }

    public a(com.mbridge.msdk.newreward.function.command.a.a aVar) {
        this.f10743a = aVar;
    }

    /* access modifiers changed from: package-private */
    public final void b(final e eVar, final b bVar) {
        if (eVar != null) {
            AnonymousClass1 r02 = new Runnable() {
                public final void run() {
                    com.mbridge.msdk.newreward.function.command.b bVar = new com.mbridge.msdk.newreward.function.command.b();
                    bVar.a(f.REQ_CAMPAIGN);
                    HashMap hashMap = new HashMap();
                    final e b5 = eVar.b();
                    hashMap.put("adapter_model", b5);
                    hashMap.put("command_manager", eVar.d());
                    bVar.a((Object) hashMap);
                    b5.l();
                    a.this.f10743a.a(bVar, new b() {
                        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                            String str;
                            af.a("CampaignRetryStrategy", "reqFailed，try retry");
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            if (a.this.a(bVar, eVar, b5)) {
                                eVar.a(bVar);
                                AnonymousClass1 r6 = AnonymousClass1.this;
                                a.this.b(eVar, bVar);
                                return;
                            }
                            boolean unused = a.this.f10744b = true;
                            AnonymousClass1 r03 = AnonymousClass1.this;
                            a aVar = a.this;
                            f fVar = f.REPORT_V3_RETRY_END;
                            e eVar = eVar;
                            if (bVar != null) {
                                str = bVar.b();
                            } else {
                                str = "";
                            }
                            aVar.a(fVar, eVar, str, false);
                            bVar.reqFailed(bVar);
                        }

                        public final void reqSuccessful(Object obj) {
                            AnonymousClass1 r02 = AnonymousClass1.this;
                            a.this.a(f.REPORT_V3_RETRY_END, eVar, "", true);
                            bVar.reqSuccessful(obj);
                        }
                    });
                }
            };
            af.a("CampaignRetryStrategy", "retryReqCampaign，retryReqCampaign: " + this.f10745c);
            MBridgeTaskManager.directorExecute(r02, this.f10745c);
        }
    }

    public final boolean a() {
        return this.f10744b;
    }

    public final void a(e eVar, b bVar) {
        a(f.REPORT_V3_RETRY_START, eVar, "", false);
        b(eVar, bVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (((java.lang.Boolean) r9).booleanValue() == false) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.mbridge.msdk.foundation.c.b r9, com.mbridge.msdk.newreward.function.command.receiver.a.e r10, com.mbridge.msdk.newreward.a.e r11) {
        /*
            r8 = this;
            r0 = 0
            if (r11 == 0) goto L_0x0089
            if (r9 == 0) goto L_0x0089
            if (r10 == 0) goto L_0x0089
            int r10 = r9.a()
            r1 = 2
            if (r10 != r1) goto L_0x0010
            goto L_0x0089
        L_0x0010:
            com.mbridge.msdk.foundation.tools.ah r10 = com.mbridge.msdk.foundation.tools.ah.a()
            java.lang.String r1 = "campaign_request_interval"
            r2 = 3000(0xbb8, float:4.204E-42)
            java.lang.String r3 = "retry_strategy"
            int r10 = r10.a((java.lang.String) r3, (java.lang.String) r1, (int) r2)
            long r1 = (long) r10
            r8.f10745c = r1
            com.mbridge.msdk.foundation.tools.ah r10 = com.mbridge.msdk.foundation.tools.ah.a()
            java.lang.String r1 = "campaign_request_max"
            int r10 = r10.a((java.lang.String) r3, (java.lang.String) r1, (int) r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "campaignRequestRetryInvalidTime = "
            r1.append(r2)
            long r2 = r8.f10745c
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "CampaignRetryStrategy"
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r2, (java.lang.String) r1)
            long r1 = r8.f10745c
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0089
            if (r10 > 0) goto L_0x004e
            goto L_0x0089
        L_0x004e:
            java.lang.String r1 = "can_retry"
            java.lang.Object r9 = r9.a((java.lang.Object) r1)
            if (r9 == 0) goto L_0x005f
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ Exception -> 0x005e }
            boolean r9 = r9.booleanValue()     // Catch:{ Exception -> 0x005e }
            if (r9 != 0) goto L_0x005f
        L_0x005e:
            return r0
        L_0x005f:
            int r9 = r8.f10746d
            if (r9 != 0) goto L_0x0069
            long r1 = java.lang.System.currentTimeMillis()
            r8.f10747e = r1
        L_0x0069:
            int r9 = r8.f10746d
            r1 = 1
            int r9 = r9 + r1
            r8.f10746d = r9
            long r2 = r11.p()
            int r9 = r11.P()
            long r4 = (long) r9
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r6 = r6 - r2
            long r2 = r8.f10745c
            long r4 = r4 - r2
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 >= 0) goto L_0x0089
            int r9 = r8.f10746d
            if (r9 > r10) goto L_0x0089
            return r1
        L_0x0089:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.a.a.a(com.mbridge.msdk.foundation.c.b, com.mbridge.msdk.newreward.function.command.receiver.a.e, com.mbridge.msdk.newreward.a.e):boolean");
    }

    /* access modifiers changed from: private */
    public void a(f fVar, e eVar, String str, boolean z4) {
        if (eVar != null) {
            c d5 = eVar.d();
            e b5 = eVar.b();
            if (d5 != null && b5 != null) {
                try {
                    int i5 = 1;
                    Map a5 = d5.a("retry_count", Integer.valueOf(this.f10746d), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                    int i6 = AnonymousClass2.f10753a[fVar.ordinal()];
                    if (i6 == 1) {
                        d5.a((Object) b5, f.REPORT_V3_RETRY_START, (Object) a5);
                    } else if (i6 == 2) {
                        a5.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - this.f10747e));
                        if (z4) {
                            a5.put("reason", str);
                        }
                        if (!z4) {
                            i5 = 2;
                        }
                        a5.put("result", Integer.valueOf(i5));
                        d5.a((Object) b5, f.REPORT_V3_RETRY_END, (Object) a5);
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }
}
