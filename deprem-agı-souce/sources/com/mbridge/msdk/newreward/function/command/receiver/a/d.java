package com.mbridge.msdk.newreward.function.command.receiver.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private int f10773a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f10774b = 0;

    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.a.d$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10778a;

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
                f10778a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_V3_RETRY_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10778a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REPORT_V3_RETRY_END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.a.d.AnonymousClass2.<clinit>():void");
        }
    }

    public final void a(final e eVar, final b bVar) {
        e b5;
        com.mbridge.msdk.newreward.function.c.a.b b6;
        if (eVar != null && (b5 = eVar.b()) != null && b5.D() != null && (b6 = b5.D().b()) != null) {
            a(f.REPORT_V3_RETRY_START, eVar, "", false);
            b5.m();
            b5.F().a(b6, new b() {
                public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                    String str;
                    if (bVar != null) {
                        d dVar = d.this;
                        f fVar = f.REPORT_V3_RETRY_END;
                        e eVar = eVar;
                        if (bVar != null) {
                            str = bVar.b();
                        } else {
                            str = "";
                        }
                        dVar.a(fVar, eVar, str, false);
                        bVar.reqFailed(bVar);
                    }
                }

                public final void reqSuccessful(Object obj) {
                    if (bVar != null) {
                        d.this.a(f.REPORT_V3_RETRY_END, eVar, "", true);
                        bVar.reqSuccessful(obj);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        if (((java.lang.Boolean) r2).booleanValue() == false) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.mbridge.msdk.newreward.function.command.receiver.a.e r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L_0x008b
            com.mbridge.msdk.foundation.c.b r1 = r11.a()
            if (r1 == 0) goto L_0x008b
            com.mbridge.msdk.newreward.a.e r1 = r11.b()
            if (r1 == 0) goto L_0x008b
            com.mbridge.msdk.foundation.c.b r1 = r11.a()
            int r1 = r1.a()
            r2 = 2
            if (r1 != r2) goto L_0x001b
            goto L_0x008b
        L_0x001b:
            com.mbridge.msdk.newreward.a.e r1 = r11.b()
            com.mbridge.msdk.newreward.function.e.a r1 = r1.D()
            if (r1 != 0) goto L_0x0026
            return r0
        L_0x0026:
            com.mbridge.msdk.newreward.function.c.a.b r1 = r1.b()
            if (r1 != 0) goto L_0x002d
            return r0
        L_0x002d:
            com.mbridge.msdk.newreward.a.e r1 = r11.b()
            com.mbridge.msdk.newreward.function.e.e r1 = r1.F()
            if (r1 != 0) goto L_0x0038
            return r0
        L_0x0038:
            com.mbridge.msdk.foundation.tools.ah r1 = com.mbridge.msdk.foundation.tools.ah.a()
            java.lang.String r2 = "retry_strategy"
            java.lang.String r3 = "download_retry_max"
            int r1 = r1.a((java.lang.String) r2, (java.lang.String) r3, (int) r0)
            if (r1 != 0) goto L_0x0047
            return r0
        L_0x0047:
            com.mbridge.msdk.foundation.c.b r2 = r11.a()
            java.lang.String r3 = "can_retry"
            java.lang.Object r2 = r2.a((java.lang.Object) r3)
            if (r2 == 0) goto L_0x005c
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x005b }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x005b }
            if (r2 != 0) goto L_0x005c
        L_0x005b:
            return r0
        L_0x005c:
            int r2 = r10.f10773a
            if (r2 != 0) goto L_0x0066
            long r2 = java.lang.System.currentTimeMillis()
            r10.f10774b = r2
        L_0x0066:
            int r2 = r10.f10773a
            r3 = 1
            int r2 = r2 + r3
            r10.f10773a = r2
            com.mbridge.msdk.newreward.a.e r2 = r11.b()
            int r2 = r2.Q()
            long r4 = (long) r2
            com.mbridge.msdk.newreward.a.e r11 = r11.b()
            long r6 = r11.o()
            long r8 = android.os.SystemClock.elapsedRealtime()
            long r8 = r8 - r6
            int r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r11 >= 0) goto L_0x008b
            int r11 = r10.f10773a
            if (r11 > r1) goto L_0x008b
            return r3
        L_0x008b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.a.d.a(com.mbridge.msdk.newreward.function.command.receiver.a.e):boolean");
    }

    /* access modifiers changed from: private */
    public void a(f fVar, e eVar, String str, boolean z4) {
        if (eVar != null) {
            c d5 = eVar.d();
            e b5 = eVar.b();
            if (d5 != null && b5 != null) {
                try {
                    int i5 = 1;
                    Map a5 = d5.a("retry_count", Integer.valueOf(this.f10773a), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 3);
                    int i6 = AnonymousClass2.f10778a[fVar.ordinal()];
                    if (i6 == 1) {
                        d5.a((Object) b5, f.REPORT_V3_RETRY_START, (Object) a5);
                    } else if (i6 == 2) {
                        a5.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - this.f10774b));
                        if (!z4) {
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
