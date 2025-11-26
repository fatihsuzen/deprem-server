package com.mbridge.msdk.newreward.function.command.receiver;

import android.text.TextUtils;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.a;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.c;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.e;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.g;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.i;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.j;
import com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.k;
import com.mbridge.msdk.newreward.function.command.receiver.showreceiver.b;
import com.mbridge.msdk.newreward.function.command.receiver.showreceiver.h;
import j$.util.concurrent.ConcurrentHashMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f10824a;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<f, Object> f10825b;

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f10826c;

    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.d$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10827a;

        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|(3:37|38|40)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|40) */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.newreward.function.command.f[] r0 = com.mbridge.msdk.newreward.function.command.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10827a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.RESTORE_DB     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.SMART_LOAD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CAMPAIGN_REDIRECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.SHOW_ADD_TEMPLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.SHOW_LIFE_CYCLE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.SHOW_OR_PRELOAD_WEB_EC     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.NORMAL_LOAD     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.PRE_HANDLE_LOAD     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.UNIT_INIT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.BUILD_MORE_OFFER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CHECK_IS_REQUEST_CONTROL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.UPDATE_CAM_TOKEN_RULE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.START_LOAD_CHECK     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.CANDIDATE_LOAD_ACTION     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.TEMP_PLAYER_INIT     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.TEMP_PLAY_START_COUNT_DOWN     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.TEMP_PLAY_PROGRESS_COUNT_DOWN     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.ADD_SHAKE_VIEW     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f10827a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.ADD_BAIT_CLICK     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.d.AnonymousClass1.<clinit>():void");
        }
    }

    private d() {
    }

    public static d a() {
        if (f10824a == null) {
            synchronized (d.class) {
                try {
                    if (f10824a == null) {
                        f10824a = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10824a;
    }

    public final <T extends a> T b(f fVar) {
        int i5 = AnonymousClass1.f10827a[fVar.ordinal()];
        if (i5 == 1) {
            return new g();
        }
        if (i5 == 2) {
            return new i();
        }
        if (i5 == 4) {
            return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.d();
        }
        switch (i5) {
            case 7:
                return new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d();
            case 8:
                return new e();
            case 9:
                return new j();
            case 10:
                return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.e();
            default:
                return null;
        }
    }

    public final <T extends e> T c(f fVar) {
        T t5 = null;
        switch (AnonymousClass1.f10827a[fVar.ordinal()]) {
            case 11:
                return new com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.f();
            case 12:
                return new k();
            case 13:
                return new c();
            case 14:
                if (this.f10825b == null) {
                    this.f10825b = new ConcurrentHashMap<>();
                }
                ConcurrentHashMap<f, Object> concurrentHashMap = this.f10825b;
                f fVar2 = f.CANDIDATE_LOAD_ACTION;
                if (concurrentHashMap.containsKey(fVar2)) {
                    t5 = (e) this.f10825b.get(fVar2);
                }
                if (t5 != null) {
                    return t5;
                }
                T aVar = new a();
                this.f10825b.put(fVar2, aVar);
                return aVar;
            case 15:
            case 16:
            case 17:
                return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.f(fVar);
            case 18:
            case 19:
                return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c(fVar);
            default:
                return null;
        }
    }

    public final void d(f fVar) {
        ConcurrentHashMap<f, Object> concurrentHashMap;
        if (fVar != null && (concurrentHashMap = this.f10825b) != null) {
            concurrentHashMap.remove(fVar);
        }
    }

    public final <T extends b> T a(f fVar) {
        int i5 = AnonymousClass1.f10827a[fVar.ordinal()];
        if (i5 == 3) {
            return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.g();
        }
        if (i5 == 4) {
            return new b();
        }
        if (i5 == 5) {
            return new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.a();
        }
        T t5 = null;
        if (i5 != 6) {
            return null;
        }
        if (this.f10825b == null) {
            this.f10825b = new ConcurrentHashMap<>();
        }
        ConcurrentHashMap<f, Object> concurrentHashMap = this.f10825b;
        f fVar2 = f.SHOW_OR_PRELOAD_WEB_EC;
        if (concurrentHashMap.containsKey(fVar2)) {
            t5 = (h) this.f10825b.get(fVar2);
        }
        if (t5 != null) {
            return t5;
        }
        T hVar = new h();
        this.f10825b.put(fVar2, hVar);
        return hVar;
    }

    public final <T extends b> T a(f fVar, String str) {
        T t5 = null;
        if (fVar == f.SHOW_OR_PRELOAD_WEB_TEMPLATE) {
            if (this.f10826c == null) {
                this.f10826c = new ConcurrentHashMap<>();
            }
            if (this.f10826c.containsKey(str)) {
                t5 = (com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i) this.f10826c.get(str);
            }
            if (t5 == null) {
                T iVar = new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.i();
                this.f10826c.put(str, iVar);
                return iVar;
            }
        }
        return t5;
    }

    public final void a(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.f10826c) != null) {
            concurrentHashMap.remove(str);
        }
    }
}
