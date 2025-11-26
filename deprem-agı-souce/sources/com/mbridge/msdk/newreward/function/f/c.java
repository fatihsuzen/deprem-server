package com.mbridge.msdk.newreward.function.f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.b;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f10981a;

    /* renamed from: com.mbridge.msdk.newreward.function.f.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10982a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.mbridge.msdk.newreward.function.command.f[] r0 = com.mbridge.msdk.newreward.function.command.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10982a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REQ_SETTING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10982a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REQ_CAMPAIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10982a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REQ_MORE_OFFER_CAMPAIGN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.f.c.AnonymousClass1.<clinit>():void");
        }
    }

    private c() {
    }

    public static c a() {
        if (f10981a == null) {
            synchronized (c.class) {
                try {
                    if (f10981a == null) {
                        f10981a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10981a;
    }

    public final <T extends a> a a(Object obj, f fVar) {
        int i5 = AnonymousClass1.f10982a[fVar.ordinal()];
        if (i5 == 1) {
            d dVar = new d();
            b bVar = (b) obj;
            if (bVar.b() instanceof Map) {
                Map map = (Map) bVar.b();
                dVar.a(((Integer) map.get("mb_ad_type")).intValue());
                dVar.a((String) map.get("mb_ad_unit_id"));
            }
            return dVar;
        } else if (i5 == 2) {
            Map map2 = (Map) obj;
            e eVar = (e) map2.get("adapter_model");
            MBridgeOffsetManager mBridgeOffsetManager = (MBridgeOffsetManager) ((com.mbridge.msdk.newreward.function.command.c) map2.get("command_manager")).a((Object) null, f.CREATE_OFFSET);
            if (mBridgeOffsetManager == null) {
                eVar.a(0);
            } else {
                eVar.a(mBridgeOffsetManager.getOffset());
            }
            e eVar2 = new e(eVar.h(), eVar.C(), eVar.H(), !TextUtils.isEmpty(eVar.J()), eVar.J());
            eVar2.a(eVar.L());
            eVar2.e(eVar.G());
            eVar2.c(eVar.M());
            eVar2.b(eVar.N());
            eVar2.a(eVar.n());
            String str = "";
            if (com.mbridge.msdk.e.b.a()) {
                eVar.H();
                com.mbridge.msdk.foundation.controller.c.m().c();
                TextUtils.isEmpty(str);
                eVar2.c(str);
            }
            String a5 = ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), eVar.H());
            if (TextUtils.isEmpty(a5)) {
                a5 = str;
            }
            eVar2.a(a5);
            eVar2.b(str);
            if (!TextUtils.isEmpty(MBridgeGlobalCommon.SESSION_ID)) {
                str = MBridgeGlobalCommon.SESSION_ID;
            }
            eVar2.d(str);
            Object obj2 = map2.get("params_ext_map_key");
            if (obj2 instanceof Map) {
                eVar2.a((Map<String, String>) (Map) obj2);
            }
            return eVar2;
        } else if (i5 != 3) {
            return null;
        } else {
            b bVar2 = new b();
            if (obj instanceof Map) {
                bVar2.a((CampaignEx) ((Map) obj).get("campaign"));
            }
            return bVar2;
        }
    }
}
