package com.mbridge.msdk.newreward.function.command.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.command.a;
import com.mbridge.msdk.newreward.function.command.b;
import com.mbridge.msdk.newreward.function.command.e;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.ReportReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.d;
import com.mbridge.msdk.newreward.function.command.receiver.showreceiver.MoreOfferPreSendTrackingReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f;
import com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.DoReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.NewShowReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.OMSDKReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.PlayFrequenceReceiver;
import com.mbridge.msdk.newreward.function.command.receiver.tagreceiver.SharePreReceiver;
import java.util.Map;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private final String f10678a = "ShowCommand";

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.receiver.c f10679b = new com.mbridge.msdk.newreward.function.command.receiver.c();

    /* renamed from: com.mbridge.msdk.newreward.function.command.a.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10680a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.newreward.function.command.f[] r0 = com.mbridge.msdk.newreward.function.command.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10680a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.TEMP_PLAYER_INIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10680a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.TEMP_PLAY_START_COUNT_DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10680a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.TEMP_PLAY_PROGRESS_COUNT_DOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10680a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CAMPAIGN_REDIRECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10680a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.SHOW_ADD_TEMPLE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10680a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.SHOW_LIFE_CYCLE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f10680a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.SHOW_OR_PRELOAD_WEB_EC     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f10680a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.SHOW_OR_PRELOAD_WEB_TEMPLATE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f10680a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.ADD_SHAKE_VIEW     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f10680a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.ADD_BAIT_CLICK     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f10680a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.REQ_MORE_OFFER_CAMPAIGN     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f10680a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.BUILD_MORE_OFFER     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.a.c.AnonymousClass1.<clinit>():void");
        }
    }

    public final <T extends e> T a(b bVar) {
        Map map;
        T eVar = new e();
        switch (AnonymousClass1.f10680a[bVar.a().ordinal()]) {
            case 1:
            case 2:
            case 3:
                f fVar = (f) d.a().c(bVar.a());
                if (fVar != null) {
                    try {
                        eVar.a(fVar.a(bVar.b()));
                        return eVar;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        break;
                    }
                }
                break;
            case 4:
                d.a().a(com.mbridge.msdk.newreward.function.command.f.CAMPAIGN_REDIRECT).a(bVar.b());
                return eVar;
            case 5:
                d.a().a(com.mbridge.msdk.newreward.function.command.f.SHOW_ADD_TEMPLE).a(bVar.b());
                return eVar;
            case 6:
                d.a().a(com.mbridge.msdk.newreward.function.command.f.SHOW_LIFE_CYCLE).a(bVar.b());
                return eVar;
            case 7:
                d.a().a(com.mbridge.msdk.newreward.function.command.f.SHOW_OR_PRELOAD_WEB_EC).a(bVar.b());
                return eVar;
            case 8:
                try {
                    if ((bVar.b() instanceof Map) && (map = (Map) bVar.b()) != null) {
                        if (map.isEmpty()) {
                            break;
                        } else {
                            Object obj = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                            if (obj instanceof String) {
                                d.a().a(com.mbridge.msdk.newreward.function.command.f.SHOW_OR_PRELOAD_WEB_TEMPLATE, (String) obj).a(bVar.b());
                                return eVar;
                            }
                        }
                    }
                } catch (Throwable th) {
                    af.b("ShowCommand", th.getMessage());
                    break;
                }
                break;
            case 9:
            case 10:
                com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c cVar = (com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c) d.a().c(bVar.a());
                if (cVar != null) {
                    try {
                        eVar.a(cVar.a(bVar.b()));
                        return eVar;
                    } catch (Exception e6) {
                        af.b("ShowCommand", e6.getMessage());
                        break;
                    }
                }
                break;
        }
        return eVar;
    }

    public final void a(b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        com.mbridge.msdk.newreward.function.command.receiver.showreceiver.e eVar;
        int i5 = AnonymousClass1.f10680a[bVar.a().ordinal()];
        if (i5 == 5) {
            com.mbridge.msdk.newreward.a.b.b bVar3 = bVar2;
            com.mbridge.msdk.newreward.function.command.receiver.showreceiver.d dVar = (com.mbridge.msdk.newreward.function.command.receiver.showreceiver.d) d.a().b(bVar.a());
            if (dVar != null) {
                dVar.a(bVar, bVar3);
            }
        } else if (i5 == 11) {
            Object b5 = bVar.b();
            if (b5 instanceof Map) {
                Map map = (Map) b5;
                com.mbridge.msdk.newreward.a.e eVar2 = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
                int intValue = ((Integer) map.get("more_offer_type")).intValue();
                eVar2.E().a(intValue, eVar2, (CampaignEx) map.get("campaign"), com.mbridge.msdk.newreward.function.f.c.a().a(bVar.b(), bVar.a()), bVar2);
                return;
            }
            com.mbridge.msdk.newreward.a.b.b bVar4 = bVar2;
            if (bVar4 != null) {
                bVar4.reqFailed(com.mbridge.msdk.foundation.c.a.b(990001, com.mbridge.msdk.foundation.c.a.a(990001)));
            }
        } else if (i5 == 12 && (eVar = (com.mbridge.msdk.newreward.function.command.receiver.showreceiver.e) d.a().b(bVar.a())) != null) {
            eVar.a(bVar, bVar2);
        }
    }

    public final void a(b bVar, String str) {
        com.mbridge.msdk.newreward.function.command.receiver.b bVar2;
        super.a(bVar, str);
        if (str != null) {
            if ("SharePreReceiver".equals(str)) {
                bVar2 = new SharePreReceiver();
            } else if ("NewShowReceiver".equals(str)) {
                bVar2 = new NewShowReceiver();
            } else if ("PlayFrequenceReceiver".equals(str)) {
                bVar2 = new PlayFrequenceReceiver();
            } else if ("DoReceiver".equals(str)) {
                bVar2 = new DoReceiver();
            } else if ("OMSDKReceiver".equals(str)) {
                bVar2 = new OMSDKReceiver();
            } else if ("MoreOfferPreSendTrackingReceiver".equals(str)) {
                bVar2 = new MoreOfferPreSendTrackingReceiver();
            } else if ("ReportReceiver".equals(str)) {
                bVar2 = new ReportReceiver();
            } else {
                throw new IllegalArgumentException("Unknown id = " + str);
            }
            bVar2.a(bVar.b());
            return;
        }
        throw new IllegalArgumentException("id is null!");
    }
}
