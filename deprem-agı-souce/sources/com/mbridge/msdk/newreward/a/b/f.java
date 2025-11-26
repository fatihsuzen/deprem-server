package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.c.c.d;
import com.mbridge.msdk.newreward.function.c.c.q;
import com.mbridge.msdk.newreward.function.c.c.x;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.io.IOException;
import java.util.Map;

public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private c f10364a;

    /* renamed from: b  reason: collision with root package name */
    private e f10365b;

    /* renamed from: c  reason: collision with root package name */
    private int f10366c = 0;

    /* renamed from: com.mbridge.msdk.newreward.a.b.f$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10370a;

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
                f10370a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10370a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.f.AnonymousClass2.<clinit>():void");
        }
    }

    public final void a(Object obj, final b bVar) throws IOException {
        a aVar = (a) obj;
        final d<?> f5 = aVar.f();
        if (aVar.i().H() != null) {
            if (aVar.i().H().containsKey("command_manager")) {
                this.f10364a = (c) aVar.i().H().get("command_manager");
            }
            if (aVar.i().H().containsKey("adapter_model")) {
                this.f10365b = (e) aVar.i().H().get("adapter_model");
            }
        }
        if (f5 == null) {
            bVar.reqSuccessful(aVar);
            return;
        }
        if (f5.f() == 1) {
            this.f10366c = 1;
        } else {
            this.f10366c = 2;
        }
        a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START, 0, aVar, (MBridgeError) null);
        f5.l().a(0, new x() {
            public final void a(b bVar, a aVar, q qVar) {
            }

            public final void b(b bVar, a aVar, q qVar) {
                f.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 1, aVar, (MBridgeError) null);
                if (f5.d()) {
                    bVar.reqSuccessful(aVar);
                }
            }

            public final void a(b bVar, a aVar, q qVar, MBridgeError mBridgeError) {
                f.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 3, aVar, mBridgeError);
                a(bVar, bVar, aVar, mBridgeError, "errorCode: 3202 errorMessage: ");
            }

            private void a(b bVar, b bVar2, a aVar, MBridgeError mBridgeError, String str) {
                if (bVar.y()) {
                    try {
                        bVar2.reqSuccessful(aVar);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("ReqEcService", "doReq: ", e5);
                        }
                    }
                } else {
                    try {
                        if (!f5.d()) {
                            int errorCode = mBridgeError.getErrorCode();
                            bVar2.reqFailed(com.mbridge.msdk.foundation.c.a.a(errorCode, 880007, str + mBridgeError.getErrorMessage()));
                        }
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("ReqEcService", "doReq: ", e6);
                        }
                    }
                }
            }

            public final void b(b bVar, a aVar, q qVar, MBridgeError mBridgeError) {
                f.this.a(com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END, 2, aVar, mBridgeError);
                a(bVar, bVar, aVar, mBridgeError, "errorCode: 3401 errorMessage: ");
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.command.f fVar, int i5, a aVar, MBridgeError mBridgeError) {
        if (this.f10364a != null && this.f10365b != null) {
            try {
                d<?> f5 = aVar.f();
                Map a5 = this.f10364a.a("resource_type", 3, "scenes", 1, "url", f5.j(), CampaignEx.JSON_KEY_READY_RATE, 100, "mraid_type", Integer.valueOf(aVar.j() ? 1 : 0));
                int i6 = AnonymousClass2.f10370a[fVar.ordinal()];
                if (i6 == 1) {
                    a5.put("cache", Integer.valueOf(this.f10366c));
                    this.f10364a.a((Object) this.f10365b, fVar, (Object) a5);
                } else if (i6 == 2) {
                    if (this.f10366c == 2) {
                        a5.put("result", Integer.valueOf(i5));
                        if (!(i5 == 1 || mBridgeError == null)) {
                            a5.put("reason", mBridgeError.getErrorMessage());
                        }
                        this.f10364a.a((Object) this.f10365b, fVar, (Object) a5);
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }
}
