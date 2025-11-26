package com.mbridge.msdk.newreward.a.b;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.c.c.h;
import com.mbridge.msdk.newreward.function.c.c.q;
import com.mbridge.msdk.newreward.function.c.c.x;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.io.IOException;
import java.util.Map;

public final class g implements a {

    /* renamed from: a  reason: collision with root package name */
    private c f10371a;

    /* renamed from: b  reason: collision with root package name */
    private e f10372b;

    /* renamed from: c  reason: collision with root package name */
    private int f10373c = 0;

    /* renamed from: com.mbridge.msdk.newreward.a.b.g$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10376a;

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
                f10376a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10376a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_DOWNLOAD_END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.a.b.g.AnonymousClass2.<clinit>():void");
        }
    }

    public final void a(Object obj, final b bVar) throws IOException {
        a aVar = (a) obj;
        if (aVar == null || aVar.h() == null || !aVar.h().isDynamicView()) {
            h b5 = aVar != null ? aVar.b() : null;
            if (!(aVar == null || aVar.i().H() == null)) {
                if (aVar.i().H().containsKey("command_manager")) {
                    this.f10371a = (c) aVar.i().H().get("command_manager");
                }
                if (aVar.i().H().containsKey("adapter_model")) {
                    this.f10372b = (e) aVar.i().H().get("adapter_model");
                }
            }
            if (b5 == null) {
                bVar.reqSuccessful(aVar);
                return;
            }
            if (b5.f() == 1) {
                this.f10373c = 1;
            } else {
                this.f10373c = 2;
            }
            a(f.REPORT_DOWNLOAD_START, 0, aVar, (MBridgeError) null);
            b5.l().a(0, new x() {
                public final void a(b bVar, a aVar, q qVar) {
                }

                public final void b(b bVar, a aVar, q qVar) {
                    if (bVar.y()) {
                        bVar.reqSuccessful(aVar);
                    }
                    g.this.a(f.REPORT_DOWNLOAD_END, 1, aVar, (MBridgeError) null);
                }

                public final void a(b bVar, a aVar, q qVar, MBridgeError mBridgeError) {
                    if (bVar.y()) {
                        bVar.reqSuccessful(aVar);
                    }
                    g.this.a(f.REPORT_DOWNLOAD_END, 3, aVar, mBridgeError);
                }

                public final void b(b bVar, a aVar, q qVar, MBridgeError mBridgeError) {
                    if (bVar.y()) {
                        bVar.reqSuccessful(aVar);
                    }
                    g.this.a(f.REPORT_DOWNLOAD_END, 2, aVar, mBridgeError);
                }
            });
            return;
        }
        bVar.reqSuccessful(aVar);
    }

    /* access modifiers changed from: private */
    public void a(f fVar, int i5, a aVar, MBridgeError mBridgeError) {
        c cVar = this.f10371a;
        if (cVar != null && this.f10372b != null) {
            try {
                Map a5 = cVar.a("resource_type", 6, "scenes", 1, "url", aVar.b().j(), "mraid_type", Integer.valueOf(aVar.j() ? 1 : 0));
                int i6 = AnonymousClass2.f10376a[fVar.ordinal()];
                if (i6 == 1) {
                    a5.put("cache", Integer.valueOf(this.f10373c));
                    this.f10371a.a((Object) this.f10372b, fVar, (Object) a5);
                } else if (i6 == 2) {
                    if (this.f10373c == 2) {
                        a5.put("result", Integer.valueOf(i5));
                        if (!(i5 == 1 || mBridgeError == null)) {
                            a5.put("reason", mBridgeError.getErrorMessage());
                        }
                        this.f10371a.a((Object) this.f10372b, fVar, (Object) a5);
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
