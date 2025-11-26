package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.c.c.q;
import com.mbridge.msdk.newreward.function.c.c.x;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.io.IOException;
import java.util.Map;

public final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private c f10350a;

    /* renamed from: b  reason: collision with root package name */
    private e f10351b;

    /* renamed from: c  reason: collision with root package name */
    private int f10352c = 0;

    /* renamed from: com.mbridge.msdk.newreward.a.b.d$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10356a;

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
                f10356a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10356a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.d.AnonymousClass2.<clinit>():void");
        }
    }

    public final void a(Object obj, final b bVar) throws IOException {
        b bVar2 = (b) obj;
        final com.mbridge.msdk.newreward.function.c.c.d<?> w4 = bVar2.w();
        if (bVar2.H() != null) {
            if (bVar2.H().containsKey("command_manager")) {
                this.f10350a = (c) bVar2.H().get("command_manager");
            }
            if (bVar2.H().containsKey("adapter_model")) {
                this.f10351b = (e) bVar2.H().get("adapter_model");
            }
        }
        if (w4 == null) {
            bVar.reqSuccessful(bVar2);
            return;
        }
        if (w4.f() == 1) {
            this.f10352c = 1;
        } else {
            this.f10352c = 2;
        }
        a(f.REPORT_DOWNLOAD_START, bVar2, 0, "");
        w4.l().a(0, new x() {
            public final void a(b bVar, a aVar, q qVar) {
            }

            public final void b(b bVar, a aVar, q qVar) {
                if (bVar.y()) {
                    bVar.reqSuccessful(bVar);
                }
                d.this.a(f.REPORT_DOWNLOAD_END, bVar, 1, "");
            }

            public final void a(b bVar, a aVar, q qVar, MBridgeError mBridgeError) {
                String str;
                if (mBridgeError != null) {
                    str = mBridgeError.getErrorMessage();
                } else {
                    str = "";
                }
                d.this.a(f.REPORT_DOWNLOAD_END, bVar, 3, str);
                a(bVar, bVar, mBridgeError, "errorCode: 3203 errorMessage:");
            }

            public final void b(b bVar, a aVar, q qVar, MBridgeError mBridgeError) {
                String str;
                if (mBridgeError != null) {
                    str = mBridgeError.getErrorMessage();
                } else {
                    str = "";
                }
                d.this.a(f.REPORT_DOWNLOAD_END, bVar, 2, str);
                a(bVar, bVar, mBridgeError, "errorCode: 3401 errorMessage: ");
            }

            private void a(b bVar, b bVar2, MBridgeError mBridgeError, String str) {
                String str2;
                int i5;
                if (bVar.y()) {
                    try {
                        bVar2.reqSuccessful(bVar);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("ReqDownBigTempleService", "doReq: ", e5);
                        }
                    }
                } else {
                    if (mBridgeError != null) {
                        try {
                            i5 = mBridgeError.getErrorCode();
                            str2 = mBridgeError.getErrorMessage();
                        } catch (Exception e6) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("ReqDownBigTempleService", "doReq: ", e6);
                                return;
                            }
                            return;
                        }
                    } else {
                        str2 = "big temp load fail ";
                        i5 = -1;
                    }
                    if (!w4.d()) {
                        bVar2.reqFailed(com.mbridge.msdk.foundation.c.a.a(i5, 880005, str + str2));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(f fVar, b bVar, int i5, String str) {
        c cVar = this.f10350a;
        if (cVar != null && this.f10351b != null) {
            try {
                Map a5 = cVar.a("resource_type", 1, "url", bVar.w().j());
                int i6 = AnonymousClass2.f10356a[fVar.ordinal()];
                if (i6 == 1) {
                    a5.put("cache", Integer.valueOf(this.f10352c));
                    this.f10350a.a((Object) this.f10351b, fVar, (Object) a5);
                } else if (i6 == 2) {
                    if (this.f10352c == 2) {
                        a5.put("result", Integer.valueOf(i5));
                        if (i5 != 1) {
                            a5.put("reason", str);
                        }
                        this.f10350a.a((Object) this.f10351b, fVar, (Object) a5);
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
