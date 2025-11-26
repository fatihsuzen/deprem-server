package com.mbridge.msdk.newreward.function.command.a;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.command.b;
import com.mbridge.msdk.newreward.function.command.e;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.c;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.f;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.h;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.k;
import com.mbridge.msdk.newreward.function.command.receiver.d;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a extends com.mbridge.msdk.newreward.function.command.a {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f10675a = new HashMap();

    /* renamed from: com.mbridge.msdk.newreward.function.command.a.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10676a;

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.newreward.function.command.f[] r0 = com.mbridge.msdk.newreward.function.command.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10676a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CHECK_IS_READY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CHECK_CAMPAIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CHECK_CAMPAIGN_EXCLUDE_INS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.HANDLER_ALREADY_INSTALL_CAMPAIGN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CREATE_OFFSET     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CREATE_DAILY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CREATE_BIDS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.SHOW     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CHECK_IS_REQUEST_CONTROL     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.UPDATE_CAM_TOKEN_RULE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.START_LOAD_CHECK     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CANDIDATE_LOAD_ACTION     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REQ_SETTING     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REQ_CAMPAIGN     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REQ_DOWN_CAMPAIGN     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.RESTORE_DB     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.SMART_LOAD     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.NORMAL_LOAD     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.PRE_HANDLE_LOAD     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = f10676a     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.UNIT_INIT     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.a.a.AnonymousClass1.<clinit>():void");
        }
    }

    public final e a(b bVar) {
        e eVar = new e();
        switch (AnonymousClass1.f10676a[bVar.a().ordinal()]) {
            case 1:
                eVar.a(((com.mbridge.msdk.newreward.a.e) bVar.b()).D().c());
                return eVar;
            case 2:
                Map map = (Map) bVar.b();
                try {
                    ((com.mbridge.msdk.newreward.a.e) map.get("adapter_model")).D().a((com.mbridge.msdk.newreward.function.c.a.b) map.get("campaign"), false);
                    eVar.a(true);
                    return eVar;
                } catch (MBridgeError e5) {
                    eVar.a(false);
                    eVar.a((Object) e5);
                    break;
                }
            case 3:
                Map map2 = (Map) bVar.b();
                try {
                    ((com.mbridge.msdk.newreward.a.e) map2.get("adapter_model")).D().a((com.mbridge.msdk.newreward.function.c.a.b) map2.get("campaign"), true);
                    eVar.a(true);
                    return eVar;
                } catch (MBridgeError e6) {
                    eVar.a(false);
                    eVar.a((Object) e6);
                    break;
                }
            case 4:
                Map map3 = (Map) bVar.b();
                ((com.mbridge.msdk.newreward.a.e) map3.get("adapter_model")).D().b((com.mbridge.msdk.newreward.function.c.a.b) map3.get("campaign"));
                return eVar;
            case 5:
                a(bVar, eVar, TypedValues.CycleType.S_WAVE_OFFSET);
                return eVar;
            case 6:
                a(bVar, eVar, "daily");
                return eVar;
            case 7:
                a(bVar, eVar, "bridge_ids");
                return eVar;
            case 8:
                new h().a(bVar);
                return eVar;
            case 9:
                f fVar = (f) d.a().c(com.mbridge.msdk.newreward.function.command.f.CHECK_IS_REQUEST_CONTROL);
                if (fVar != null) {
                    try {
                        eVar.a(fVar.a(bVar.b()));
                        return eVar;
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        break;
                    }
                }
                break;
            case 10:
                if (((k) d.a().c(com.mbridge.msdk.newreward.function.command.f.UPDATE_CAM_TOKEN_RULE)) != null) {
                    try {
                        Object b5 = bVar.b();
                        Map map4 = null;
                        Map map5 = b5 instanceof Map ? (Map) b5 : null;
                        if (map5 != null) {
                            com.mbridge.msdk.newreward.a.e eVar2 = (com.mbridge.msdk.newreward.a.e) map5.get("adapter_model");
                            com.mbridge.msdk.newreward.function.e.a D4 = ((com.mbridge.msdk.newreward.a.e) map5.get("queue_first_adapter_model")).D();
                            if (D4 != null) {
                                List<CampaignEx> a5 = D4.a();
                                if (a5 != null) {
                                    if (a5.size() != 0) {
                                        String encryptPrice = a5.get(0).getEncryptPrice();
                                        if (!TextUtils.isEmpty(encryptPrice)) {
                                            com.mbridge.msdk.newreward.function.e.a D5 = eVar2.D();
                                            if (!(D5 == null || D5.a() == null)) {
                                                if (D5.a().size() != 0) {
                                                    List<CampaignEx> a6 = eVar2.D().a();
                                                    HashMap hashMap = new HashMap();
                                                    hashMap.put("encrypt_p=", "encrypt_p=" + encryptPrice);
                                                    hashMap.put("irlfa=", "irlfa=1");
                                                    for (CampaignEx next : a6) {
                                                        for (Map.Entry entry : hashMap.entrySet()) {
                                                            String str = (String) entry.getKey();
                                                            String str2 = (String) entry.getValue();
                                                            if (next != null) {
                                                                next.setImpressionURL(next.getImpressionURL().replaceAll(str, str2));
                                                                next.setOnlyImpressionURL(next.getOnlyImpressionURL().replaceAll(str, str2));
                                                            }
                                                        }
                                                    }
                                                    map4 = map5;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        eVar.a((Object) map4);
                        return eVar;
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        break;
                    }
                }
                break;
            case 11:
                ((c) d.a().c(com.mbridge.msdk.newreward.function.command.f.START_LOAD_CHECK)).a(bVar.b());
                return eVar;
            case 12:
                eVar.a(((com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.a) d.a().c(com.mbridge.msdk.newreward.function.command.f.CANDIDATE_LOAD_ACTION)).a(bVar.b()));
                return eVar;
        }
        return eVar;
    }

    private void a(b bVar, e eVar, String str) {
        if (bVar != null) {
            com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.b bVar2 = new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.b();
            Map map = (Map) bVar.b();
            if (map == null) {
                map = new HashMap();
            }
            map.put("obj_map", this.f10675a);
            map.put("result", eVar);
            map.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
            bVar2.a(map);
        }
    }

    public final void a(b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        com.mbridge.msdk.newreward.a.e eVar = bVar.b() instanceof com.mbridge.msdk.newreward.a.e ? (com.mbridge.msdk.newreward.a.e) bVar.b() : null;
        switch (AnonymousClass1.f10676a[bVar.a().ordinal()]) {
            case 13:
                if (eVar == null) {
                    new com.mbridge.msdk.newreward.function.e.f().a((Object) com.mbridge.msdk.newreward.function.f.c.a().a(bVar, bVar.a()), bVar2);
                    return;
                } else {
                    eVar.x().a((Object) com.mbridge.msdk.newreward.function.f.c.a().a(bVar, bVar.a()), bVar2);
                    return;
                }
            case 14:
                com.mbridge.msdk.newreward.a.e eVar2 = (com.mbridge.msdk.newreward.a.e) ((Map) bVar.b()).get("adapter_model");
                eVar2.D().a(eVar2, com.mbridge.msdk.newreward.function.f.c.a().a(bVar.b(), bVar.a()), bVar2);
                return;
            case 15:
                Map map = (Map) bVar.b();
                com.mbridge.msdk.newreward.function.c.a.b bVar3 = (com.mbridge.msdk.newreward.function.c.a.b) map.get("campaign");
                bVar3.H().putAll(map);
                ((com.mbridge.msdk.newreward.a.e) map.get("adapter_model")).F().a(bVar3, bVar2);
                return;
            case 16:
                d.a().b(com.mbridge.msdk.newreward.function.command.f.RESTORE_DB).a(bVar, bVar2);
                return;
            case 17:
                bVar.b();
                d.a().b(com.mbridge.msdk.newreward.function.command.f.SMART_LOAD).a(bVar, bVar2);
                return;
            case 18:
                com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d dVar = (com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d) d.a().b(com.mbridge.msdk.newreward.function.command.f.NORMAL_LOAD);
                dVar.a(this);
                dVar.a(bVar, bVar2);
                return;
            case 19:
                d.a().b(com.mbridge.msdk.newreward.function.command.f.PRE_HANDLE_LOAD).a(bVar, bVar2);
                return;
            case 20:
                d.a().b(com.mbridge.msdk.newreward.function.command.f.UNIT_INIT).a(bVar, bVar2);
                return;
            default:
                return;
        }
    }
}
