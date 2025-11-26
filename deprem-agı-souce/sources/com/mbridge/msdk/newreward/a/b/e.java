package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.c.c.d;
import com.mbridge.msdk.newreward.function.c.c.q;
import com.mbridge.msdk.newreward.function.c.c.x;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.io.IOException;
import java.util.Map;

public final class e implements a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public c f10357a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public com.mbridge.msdk.newreward.a.e f10358b;

    /* renamed from: c  reason: collision with root package name */
    private int f10359c = 0;

    /* renamed from: com.mbridge.msdk.newreward.a.b.e$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10363a;

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
                f10363a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10363a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.e.AnonymousClass2.<clinit>():void");
        }
    }

    public final void a(Object obj, final b bVar) throws IOException {
        a aVar = (a) obj;
        final d<?> c5 = aVar.c();
        if (aVar.i().H() != null) {
            if (aVar.i().H().containsKey("command_manager")) {
                this.f10357a = (c) aVar.i().H().get("command_manager");
            }
            if (aVar.i().H().containsKey("adapter_model")) {
                this.f10358b = (com.mbridge.msdk.newreward.a.e) aVar.i().H().get("adapter_model");
            }
        }
        if (c5 == null) {
            bVar.reqSuccessful(aVar);
            return;
        }
        if (c5.f() == 1) {
            this.f10359c = 1;
        } else {
            this.f10359c = 2;
        }
        a(f.REPORT_DOWNLOAD_START, 0, aVar, (MBridgeError) null);
        c5.l().a(0, new x() {
            public final void a(b bVar, a aVar, q qVar) {
            }

            public final void b(b bVar, a aVar, q qVar) {
                if (bVar.y()) {
                    bVar.reqSuccessful(aVar);
                }
                if (!(e.this.f10357a == null || aVar == null || aVar.c() == null)) {
                    if (!aVar.c().g()) {
                        e.this.f10357a.i(e.this.f10357a.a("web_resource_action", 1, "parent_temple", null, "adapter_model", e.this.f10358b, CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, e.this.f10358b.G(), "bridge_ids", aVar.g()), f.SHOW_OR_PRELOAD_WEB_TEMPLATE);
                    } else {
                        return;
                    }
                }
                e.this.a(f.REPORT_DOWNLOAD_END, 1, aVar, (MBridgeError) null);
            }

            public final void a(b bVar, a aVar, q qVar, MBridgeError mBridgeError) {
                e.this.a(f.REPORT_DOWNLOAD_END, 3, aVar, mBridgeError);
                a(bVar, bVar, aVar, mBridgeError, "errorCode: 3202 errorMessage: ");
            }

            private void a(b bVar, b bVar2, a aVar, MBridgeError mBridgeError, String str) {
                if (bVar.y()) {
                    try {
                        bVar2.reqSuccessful(aVar);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("ReqVideoService", "doReq: ", e5);
                        }
                    }
                } else {
                    try {
                        if (!c5.d()) {
                            int errorCode = mBridgeError.getErrorCode();
                            bVar2.reqFailed(com.mbridge.msdk.foundation.c.a.a(errorCode, 880006, str + mBridgeError.getErrorMessage()));
                        }
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("ReqVideoService", "doReq: ", e6);
                        }
                    }
                }
            }

            public final void b(b bVar, a aVar, q qVar, MBridgeError mBridgeError) {
                e.this.a(f.REPORT_DOWNLOAD_END, 2, aVar, mBridgeError);
                a(bVar, bVar, aVar, mBridgeError, "errorCode: 3401 errorMessage: ");
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(f fVar, int i5, a aVar, MBridgeError mBridgeError) {
        c cVar = this.f10357a;
        if (cVar != null && this.f10358b != null) {
            try {
                Map a5 = cVar.a("resource_type", 2, "scenes", 1, "url", aVar.c().j(), "resumed_breakpoint", "2", CampaignEx.JSON_KEY_READY_RATE, 100, "mraid_type", Integer.valueOf(aVar.j() ? 1 : 0));
                int i6 = AnonymousClass2.f10363a[fVar.ordinal()];
                if (i6 == 1) {
                    a5.put("cache", Integer.valueOf(this.f10359c));
                    this.f10357a.a((Object) this.f10358b, fVar, (Object) a5);
                } else if (i6 == 2) {
                    if (this.f10359c == 2) {
                        a5.put("result", Integer.valueOf(i5));
                        if (!(i5 == 1 || mBridgeError == null)) {
                            a5.put("reason", mBridgeError.getErrorMessage());
                        }
                        this.f10357a.a((Object) this.f10358b, fVar, (Object) a5);
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
