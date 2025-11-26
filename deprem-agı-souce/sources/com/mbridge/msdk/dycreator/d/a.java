package com.mbridge.msdk.dycreator.d;

import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f8684a;

    /* renamed from: com.mbridge.msdk.dycreator.d.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8685a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.mbridge.msdk.dycreator.d.a$a[] r0 = com.mbridge.msdk.dycreator.d.a.C0083a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8685a = r0
                com.mbridge.msdk.dycreator.d.a$a r1 = com.mbridge.msdk.dycreator.d.a.C0083a.VIEW_OBSERVER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8685a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.d.a$a r1 = com.mbridge.msdk.dycreator.d.a.C0083a.CLICK_OBSERVER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8685a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.d.a$a r1 = com.mbridge.msdk.dycreator.d.a.C0083a.EFFECT_OBSERVER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8685a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.d.a$a r1 = com.mbridge.msdk.dycreator.d.a.C0083a.REPORT_OBSERVER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.d.a.AnonymousClass1.<clinit>():void");
        }
    }

    /* renamed from: com.mbridge.msdk.dycreator.d.a$a  reason: collision with other inner class name */
    public enum C0083a {
        VIEW_OBSERVER,
        CLICK_OBSERVER,
        EFFECT_OBSERVER,
        REPORT_OBSERVER
    }

    private a() {
    }

    public static a a() {
        if (f8684a == null) {
            synchronized (a.class) {
                try {
                    if (f8684a == null) {
                        f8684a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8684a;
    }

    public final <T extends com.mbridge.msdk.dycreator.g.a> T a(C0083a aVar) {
        int i5 = AnonymousClass1.f8685a[aVar.ordinal()];
        if (i5 == 1) {
            return new d();
        }
        if (i5 == 2) {
            return new c();
        }
        if (i5 == 3) {
            return new f();
        }
        if (i5 != 4) {
            return null;
        }
        return new h();
    }
}
