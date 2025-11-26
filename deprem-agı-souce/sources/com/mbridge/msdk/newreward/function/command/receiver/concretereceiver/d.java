package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.newreward.a.c.a;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class d implements a.C0098a, com.mbridge.msdk.newreward.function.command.receiver.a {

    /* renamed from: a  reason: collision with root package name */
    com.mbridge.msdk.newreward.function.command.a.a f10788a;

    /* renamed from: b  reason: collision with root package name */
    com.mbridge.msdk.newreward.a.b.b f10789b;

    /* renamed from: c  reason: collision with root package name */
    com.mbridge.msdk.newreward.function.command.c f10790c;

    /* renamed from: d  reason: collision with root package name */
    e f10791d;

    /* renamed from: e  reason: collision with root package name */
    com.mbridge.msdk.newreward.function.command.receiver.a.c f10792e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f10793f = UUID.randomUUID().toString();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f10794g = UUID.randomUUID().toString();

    /* renamed from: h  reason: collision with root package name */
    private long f10795h = WorkRequest.MIN_BACKOFF_MILLIS;

    /* renamed from: i  reason: collision with root package name */
    private Map f10796i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f10797j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f10798k = false;

    /* renamed from: l  reason: collision with root package name */
    private final int f10799l = 1;

    /* renamed from: m  reason: collision with root package name */
    private final int f10800m = 1;

    /* renamed from: n  reason: collision with root package name */
    private final int f10801n = 2;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f10802o = false;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Handler f10803p = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(@NonNull Message message) {
            if (message.what == 1) {
                com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880049, "second request reason miss");
                try {
                    Object obj = message.obj;
                    if (obj instanceof com.mbridge.msdk.foundation.c.b) {
                        b5 = (com.mbridge.msdk.foundation.c.b) obj;
                    }
                    if (message.arg1 == 2) {
                        com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f10793f);
                        com.mbridge.msdk.newreward.function.d.c.a().b().a(d.this.f10791d.h(), d.this.f10791d.C(), d.this.f10791d.H(), d.this.f10791d.G(), (int) MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR);
                    } else if (!(b5 == null || b5.a((Object) "campaign_request_error_type") == null)) {
                        com.mbridge.msdk.newreward.function.d.c.a().b().a(d.this.f10791d.h(), d.this.f10791d.C(), d.this.f10791d.H(), d.this.f10791d.G(), ((Integer) b5.a((Object) "campaign_request_error_type")).intValue());
                    }
                } catch (Exception unused) {
                }
                d.this.f10789b.reqFailed(b5);
            }
        }
    };

    private final class a implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: b  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.command.b f10806b;

        /* renamed from: c  reason: collision with root package name */
        private final Map f10807c;

        public a(com.mbridge.msdk.newreward.function.command.b bVar, Map map) {
            this.f10806b = bVar;
            this.f10807c = map;
        }

        private void a(com.mbridge.msdk.newreward.function.c.a.b bVar) {
            int i5;
            int i6;
            try {
                if (bVar.a() > 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, bVar.a() + "");
                    hashMap.put("invalid_ad_ids", d.this.f10791d.b());
                    this.f10807c.put("params_ext_map_key", hashMap);
                    this.f10806b.a((Object) this.f10807c);
                    int a5 = bVar.a();
                    int b5 = bVar.b();
                    if (bVar.E() == null || bVar.E().isEmpty()) {
                        i5 = 0;
                    } else {
                        i5 = bVar.E().get(0).getFilterCallBackState();
                    }
                    d dVar = d.this;
                    com.mbridge.msdk.newreward.function.command.c cVar = dVar.f10790c;
                    e eVar = dVar.f10791d;
                    f fVar = f.REPORT_LOAD_V3_START;
                    if (eVar.I()) {
                        i6 = 2;
                    } else {
                        i6 = 1;
                    }
                    cVar.a((Object) eVar, fVar, (Object) cVar.a("auto_load", Integer.valueOf(i6), "hst", com.mbridge.msdk.foundation.same.net.e.d.f().a(d.this.f10791d.J()), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(a5), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(b5), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(i5)));
                    com.mbridge.msdk.newreward.function.command.b bVar2 = new com.mbridge.msdk.newreward.function.command.b();
                    bVar2.a(this.f10806b);
                    boolean unused = d.this.f10802o = true;
                    d dVar2 = d.this;
                    dVar2.f10788a.a(bVar2, new b(bVar2, this.f10807c));
                }
            } catch (Exception unused2) {
            }
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            int i5;
            int i6;
            com.mbridge.msdk.foundation.c.b bVar2 = bVar;
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar2, dVar.f10791d, dVar.f10790c, 1);
            if (d.this.f10792e.a(eVar)) {
                d.this.f10792e.a(eVar, (com.mbridge.msdk.newreward.a.b.b) this);
                return;
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f10794g);
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f10793f);
            if (!d.this.f10797j) {
                boolean unused = d.this.f10797j = true;
                try {
                    d dVar2 = d.this;
                    com.mbridge.msdk.newreward.function.command.c cVar = dVar2.f10790c;
                    e eVar2 = dVar2.f10791d;
                    f fVar = f.REPORT_LOAD_V3_RES_FAIL;
                    if (eVar2.I()) {
                        i5 = 2;
                    } else {
                        i5 = 1;
                    }
                    Integer valueOf = Integer.valueOf(i5);
                    if (bVar2.m()) {
                        i6 = 1;
                    } else {
                        i6 = 2;
                    }
                    cVar.a((Object) eVar2, fVar, (Object) cVar.a("auto_load", valueOf, "result", Integer.valueOf(i6), "code", Integer.valueOf(bVar2.i()), "reason", bVar2.b(), "timeout", Integer.valueOf(d.this.f10791d.P()), "hst", bVar2.j(), "err_desc", bVar2.l(), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, 0, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, 0, CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, 0));
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                ((MBridgeOffsetManager) d.this.f10790c.a((Object) null, f.CREATE_OFFSET)).resetOffset();
                if (bVar2 != null) {
                    try {
                        if (bVar2.a((Object) "campaign_request_error_type") != null) {
                            com.mbridge.msdk.newreward.function.d.c.a().b().a(d.this.f10791d.h(), d.this.f10791d.C(), d.this.f10791d.H(), d.this.f10791d.G(), ((Integer) bVar2.a((Object) "campaign_request_error_type")).intValue());
                        }
                    } catch (Exception unused2) {
                    }
                }
                d.this.f10789b.reqFailed(bVar2);
            }
        }

        public final void reqSuccessful(Object obj) {
            int i5;
            int i6;
            int i7;
            int i8;
            String str;
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f10794g);
            if (!d.this.f10797j) {
                boolean unused = d.this.f10797j = true;
                com.mbridge.msdk.newreward.function.c.a.b bVar = (com.mbridge.msdk.newreward.function.c.a.b) obj;
                if (bVar != null) {
                    i7 = bVar.a();
                    i6 = bVar.b();
                    if (bVar.E() == null || bVar.E().isEmpty()) {
                        i5 = 0;
                    } else {
                        i5 = bVar.E().get(0).getFilterCallBackState();
                    }
                } else {
                    i7 = 0;
                    i6 = 0;
                    i5 = 0;
                }
                d dVar = d.this;
                com.mbridge.msdk.newreward.function.command.c cVar = dVar.f10790c;
                e eVar = dVar.f10791d;
                f fVar = f.REPORT_LOAD_V3_RES_SUCCESS;
                if (eVar.I()) {
                    i8 = 2;
                } else {
                    i8 = 1;
                }
                Integer valueOf = Integer.valueOf(i8);
                Integer valueOf2 = Integer.valueOf(d.this.f10791d.P());
                Integer valueOf3 = Integer.valueOf(i7);
                Integer valueOf4 = Integer.valueOf(i6);
                Integer valueOf5 = Integer.valueOf(i5);
                if (bVar != null) {
                    str = bVar.J();
                } else {
                    str = "";
                }
                cVar.a((Object) eVar, fVar, (Object) cVar.a("metrics_data", bVar, "auto_load", valueOf, "result", 1, "cache", 2, "timeout", valueOf2, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, valueOf3, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, valueOf4, CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, valueOf5, "hst", str));
                ((MBridgeOffsetManager) d.this.f10790c.a((Object) null, f.CREATE_OFFSET)).increaseOffset(bVar.u().size());
                d dVar2 = d.this;
                com.mbridge.msdk.newreward.function.command.c cVar2 = dVar2.f10790c;
                cVar2.e(cVar2.a("adapter_model", dVar2.f10791d, "campaign", bVar));
                try {
                    d dVar3 = d.this;
                    com.mbridge.msdk.newreward.function.command.c cVar3 = dVar3.f10790c;
                    cVar3.c(cVar3.a("adapter_model", dVar3.f10791d, "campaign", bVar));
                } catch (MBridgeError e5) {
                    com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f10793f);
                    if (e5.getErrorMessage().contains("APP ALREADY INSTALLED")) {
                        com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar.c(), bVar.d(), bVar.e(), bVar.g(), 403);
                        a(bVar);
                        d.this.f10789b.reqFailed(com.mbridge.msdk.foundation.c.a.a(e5.getErrorCode(), 880021, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + e5.getErrorMessage()));
                        return;
                    } else if (e5.getErrorMessage().contains("FILTER BUT CALLBACK SUCCEED")) {
                        a(bVar);
                    } else {
                        com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar.c(), bVar.d(), bVar.e(), bVar.g(), 403);
                        d.this.f10789b.reqFailed(com.mbridge.msdk.foundation.c.a.a(e5.getErrorCode(), 880003, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + e5.getErrorMessage()));
                        return;
                    }
                }
                d dVar4 = d.this;
                dVar4.f10789b.reqSuccessful(dVar4.f10790c.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1, "object", bVar));
                this.f10806b.a(f.REQ_DOWN_CAMPAIGN);
                this.f10807c.put("campaign", bVar);
                this.f10806b.a((Object) this.f10807c);
                d dVar5 = d.this;
                dVar5.f10788a.a(this.f10806b, new c());
            }
        }
    }

    private final class b implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: b  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.command.b f10809b;

        /* renamed from: c  reason: collision with root package name */
        private final Map f10810c;

        public b(com.mbridge.msdk.newreward.function.command.b bVar, Map map) {
            this.f10809b = bVar;
            this.f10810c = map;
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            int i5;
            int i6;
            com.mbridge.msdk.foundation.c.b bVar2 = bVar;
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar2, dVar.f10791d, dVar.f10790c, 1);
            if (d.this.f10792e.a(eVar)) {
                d.this.f10792e.a(eVar, (com.mbridge.msdk.newreward.a.b.b) this);
                return;
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f10794g);
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f10793f);
            if (!d.this.f10798k) {
                boolean unused = d.this.f10798k = true;
                try {
                    d dVar2 = d.this;
                    com.mbridge.msdk.newreward.function.command.c cVar = dVar2.f10790c;
                    e eVar2 = dVar2.f10791d;
                    f fVar = f.REPORT_LOAD_V3_RES_FAIL;
                    if (eVar2.I()) {
                        i5 = 2;
                    } else {
                        i5 = 1;
                    }
                    Integer valueOf = Integer.valueOf(i5);
                    if (bVar2.m()) {
                        i6 = 1;
                    } else {
                        i6 = 2;
                    }
                    cVar.a((Object) eVar2, fVar, (Object) cVar.a("auto_load", valueOf, "result", Integer.valueOf(i6), "code", Integer.valueOf(bVar2.i()), "reason", bVar2.b(), "timeout", Integer.valueOf(d.this.f10791d.P()), "hst", bVar2.j(), "err_desc", bVar2.l(), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, 0, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, 0, CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, 0));
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                ((MBridgeOffsetManager) d.this.f10790c.a((Object) null, f.CREATE_OFFSET)).resetOffset();
                d.a(d.this, bVar2, true, (com.mbridge.msdk.newreward.function.c.a.b) null);
            }
        }

        public final void reqSuccessful(Object obj) {
            int i5;
            int i6;
            int i7;
            int i8;
            String str;
            com.mbridge.msdk.foundation.c.b bVar;
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f10794g);
            if (!d.this.f10798k) {
                boolean unused = d.this.f10798k = true;
                com.mbridge.msdk.newreward.function.c.a.b bVar2 = (com.mbridge.msdk.newreward.function.c.a.b) obj;
                if (bVar2 != null) {
                    i7 = bVar2.a();
                    i6 = bVar2.b();
                    if (bVar2.E() == null || bVar2.E().isEmpty()) {
                        i5 = 0;
                    } else {
                        i5 = bVar2.E().get(0).getFilterCallBackState();
                    }
                } else {
                    i7 = 0;
                    i6 = 0;
                    i5 = 0;
                }
                d dVar = d.this;
                com.mbridge.msdk.newreward.function.command.c cVar = dVar.f10790c;
                e eVar = dVar.f10791d;
                f fVar = f.REPORT_LOAD_V3_RES_SUCCESS;
                if (eVar.I()) {
                    i8 = 2;
                } else {
                    i8 = 1;
                }
                Integer valueOf = Integer.valueOf(i8);
                Integer valueOf2 = Integer.valueOf(d.this.f10791d.P());
                if (bVar2 != null) {
                    str = bVar2.J();
                } else {
                    str = "";
                }
                cVar.a((Object) eVar, fVar, (Object) cVar.a("metrics_data", bVar2, "auto_load", valueOf, "result", 1, "cache", 2, "timeout", valueOf2, "hst", str, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, Integer.valueOf(i7), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, Integer.valueOf(i6), CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(i5)));
                ((MBridgeOffsetManager) d.this.f10790c.a((Object) null, f.CREATE_OFFSET)).increaseOffset(bVar2.u().size());
                d dVar2 = d.this;
                com.mbridge.msdk.newreward.function.command.c cVar2 = dVar2.f10790c;
                cVar2.e(cVar2.a("adapter_model", dVar2.f10791d, "campaign", bVar2));
                try {
                    d dVar3 = d.this;
                    com.mbridge.msdk.newreward.function.command.c cVar3 = dVar3.f10790c;
                    cVar3.d(cVar3.a("adapter_model", dVar3.f10791d, "campaign", bVar2));
                    d dVar4 = d.this;
                    dVar4.f10789b.reqSuccessful(dVar4.f10790c.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1, "object", bVar2));
                    this.f10809b.a(f.REQ_DOWN_CAMPAIGN);
                    this.f10810c.put("campaign", bVar2);
                    this.f10809b.a((Object) this.f10810c);
                    d dVar5 = d.this;
                    dVar5.f10788a.a(this.f10809b, new C0102d(bVar2));
                } catch (MBridgeError e5) {
                    com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f10793f);
                    com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar2.c(), bVar2.d(), bVar2.e(), bVar2.g(), 403);
                    if (e5.getErrorMessage().contains("APP ALREADY INSTALLED")) {
                        bVar = com.mbridge.msdk.foundation.c.a.a(e5.getErrorCode(), 880021, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + e5.getErrorMessage());
                    } else {
                        bVar = com.mbridge.msdk.foundation.c.a.a(e5.getErrorCode(), 880003, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + e5.getErrorMessage());
                    }
                    d.this.f10789b.reqFailed(bVar);
                }
            }
        }
    }

    private class c implements com.mbridge.msdk.newreward.a.b.b {
        private c() {
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar, dVar.f10791d, dVar.f10790c, 2);
            com.mbridge.msdk.newreward.function.command.receiver.a.c cVar = d.this.f10792e;
            if (cVar == null || !cVar.a(eVar)) {
                d.a(d.this, bVar, false, (com.mbridge.msdk.newreward.function.c.a.b) null);
            } else {
                d.this.f10792e.a(eVar, (com.mbridge.msdk.newreward.a.b.b) this);
            }
        }

        public final void reqSuccessful(Object obj) {
            d.this.f10803p.removeMessages(1);
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f10793f);
            d dVar = d.this;
            dVar.f10789b.reqSuccessful(dVar.f10790c.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2, "object", obj));
        }
    }

    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.d$d  reason: collision with other inner class name */
    private class C0102d implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: b  reason: collision with root package name */
        private com.mbridge.msdk.newreward.function.c.a.b f10813b;

        public C0102d(com.mbridge.msdk.newreward.function.c.a.b bVar) {
            this.f10813b = bVar;
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e(bVar, dVar.f10791d, dVar.f10790c, 2);
            com.mbridge.msdk.newreward.function.command.receiver.a.c cVar = d.this.f10792e;
            if (cVar == null || !cVar.a(eVar)) {
                d.a(d.this, bVar, false, this.f10813b);
            } else {
                d.this.f10792e.a(eVar, (com.mbridge.msdk.newreward.a.b.b) this);
            }
        }

        public final void reqSuccessful(Object obj) {
            d.this.f10803p.removeMessages(1);
            com.mbridge.msdk.newreward.function.c.a.b bVar = this.f10813b;
            if (bVar != null && bVar.a() == 0) {
                this.f10813b.c(3);
                d.this.f10791d.D().a(this.f10813b);
                com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f10813b);
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f10793f);
            d dVar = d.this;
            dVar.f10789b.reqSuccessful(dVar.f10790c.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2, "object", obj));
        }
    }

    private int b() {
        com.mbridge.msdk.newreward.function.e.f x4;
        com.mbridge.msdk.videocommon.d.c b5;
        try {
            e eVar = this.f10791d;
            if (eVar == null || (x4 = eVar.x()) == null || (b5 = x4.b()) == null) {
                return MBridgeCommon.DEFAULT_LOAD_TIMEOUT;
            }
            return b5.F() * 1000;
        } catch (Exception unused) {
            return MBridgeCommon.DEFAULT_LOAD_TIMEOUT;
        }
    }

    public final void a(com.mbridge.msdk.newreward.function.command.a.a aVar) {
        this.f10788a = aVar;
        this.f10792e = new com.mbridge.msdk.newreward.function.command.receiver.a.c(aVar);
    }

    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        com.mbridge.msdk.newreward.function.command.b bVar3 = bVar;
        com.mbridge.msdk.newreward.a.b.b bVar4 = bVar2;
        try {
            this.f10789b = bVar4;
            int b5 = b();
            com.mbridge.msdk.newreward.a.c.a.a().a(this.f10793f, (long) b5, this);
            bVar3.a(f.REQ_CAMPAIGN);
            Map map = (Map) bVar3.b();
            this.f10796i = map;
            this.f10790c = (com.mbridge.msdk.newreward.function.command.c) map.get("command_manager");
            e eVar = (e) this.f10796i.get("adapter_model");
            this.f10791d = eVar;
            eVar.g(b5);
            com.mbridge.msdk.newreward.function.command.c cVar = this.f10790c;
            e eVar2 = this.f10791d;
            cVar.a((Object) eVar2, f.REPORT_LOAD_V3_START, (Object) cVar.a("auto_load", Integer.valueOf(eVar2.I() ? 2 : 1), "hst", com.mbridge.msdk.foundation.same.net.e.d.f().a(this.f10791d.J()), com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_REQUEST_INDEX, 0, com.mbridge.msdk.foundation.entity.b.JSON_KEY_SECOND_SHOW_INDEX, 0, CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, 0));
            this.f10788a.a(bVar3, new a(bVar3, this.f10796i));
            long a5 = (long) ah.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY, MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY_CAMPAIGN_RETRY_TIMEOUT, 0);
            this.f10795h = a5;
            if (a5 > 0) {
                com.mbridge.msdk.newreward.a.c.a.a().a(this.f10794g, this.f10795h, this);
            }
            com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f10791d.h(), this.f10791d.C(), this.f10791d.H(), this.f10791d.G(), !TextUtils.isEmpty(this.f10791d.J()), this.f10791d.J(), this.f10791d.T());
        } catch (Exception e5) {
            af.b("LoadControllerReceiver", "action", e5);
            if (this.f10791d != null) {
                com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f10791d.h(), this.f10791d.C(), this.f10791d.H(), this.f10791d.G(), 8);
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(this.f10794g);
            com.mbridge.msdk.newreward.a.c.a.a().a(this.f10793f);
            if (bVar4 != null) {
                bVar4.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e5.getMessage()));
            }
        }
    }

    public final void a(String str, long j5) {
        if (TextUtils.equals(str, this.f10793f)) {
            com.mbridge.msdk.newreward.function.d.c.a().b().a(this.f10791d.h(), this.f10791d.C(), this.f10791d.H(), this.f10791d.G(), (int) MBridgeCommon.CampaignState.STATE_LOAD_FAILED_TIMEOUT);
            String a5 = a();
            com.mbridge.msdk.newreward.a.b.b bVar = this.f10789b;
            bVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880010, "errorCode: 3401 errorMessage: " + a5));
        } else if (TextUtils.equals(str, this.f10794g) && this.f10792e != null) {
            com.mbridge.msdk.newreward.function.command.receiver.a.e eVar = new com.mbridge.msdk.newreward.function.command.receiver.a.e((com.mbridge.msdk.foundation.c.b) null, this.f10791d, this.f10790c, 3);
            com.mbridge.msdk.newreward.function.command.b bVar2 = new com.mbridge.msdk.newreward.function.command.b();
            bVar2.a(f.REQ_CAMPAIGN);
            com.mbridge.msdk.newreward.function.command.c cVar = this.f10790c;
            bVar2.a((Object) cVar.a("adapter_model", this.f10791d, "command_manager", cVar));
            this.f10792e.a(eVar, (com.mbridge.msdk.newreward.a.b.b) new a(bVar2, this.f10796i));
        }
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        try {
            e eVar = this.f10791d;
            if (!(eVar == null || eVar.D() == null)) {
                com.mbridge.msdk.newreward.function.c.a.b b5 = this.f10791d.D().b();
                if (b5 == null || b5.u() == null || b5.u().size() <= 0) {
                    sb.append(" load timeout ");
                } else {
                    for (com.mbridge.msdk.newreward.function.c.a.a next : b5.u()) {
                        if (next != null) {
                            n d5 = next.d();
                            if (d5 != null && !d5.d()) {
                                sb.append(" video timeout ");
                            }
                            com.mbridge.msdk.newreward.function.c.c.d<?> c5 = next.c();
                            if (c5 != null && !c5.d()) {
                                sb.append(" video_template timeout ");
                            }
                            com.mbridge.msdk.newreward.function.c.c.d<?> f5 = next.f();
                            if (f5 != null && !f5.d()) {
                                sb.append(" ec_template timeout ");
                            }
                        }
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return sb.toString();
    }

    static /* synthetic */ void a(d dVar, com.mbridge.msdk.foundation.c.b bVar, boolean z4, com.mbridge.msdk.newreward.function.c.a.b bVar2) {
        e eVar = dVar.f10791d;
        if (!(eVar == null || eVar.D() == null || dVar.f10791d.D().b() == null || dVar.f10791d.D().b().a() == 0 || !dVar.f10802o)) {
            int i5 = 1;
            if (!dVar.f10803p.hasMessages(1)) {
                Message obtainMessage = dVar.f10803p.obtainMessage(1);
                obtainMessage.obj = bVar;
                if (!z4) {
                    i5 = 2;
                }
                obtainMessage.arg1 = i5;
                dVar.f10803p.sendMessageDelayed(obtainMessage, ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
                return;
            }
        }
        if (!z4) {
            if (bVar2 != null && bVar2.a() == 0) {
                dVar.f10791d.D().a(bVar2);
                com.mbridge.msdk.newreward.function.d.c.a().b().a(bVar2);
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(dVar.f10793f);
            com.mbridge.msdk.newreward.function.d.c.a().b().a(dVar.f10791d.h(), dVar.f10791d.C(), dVar.f10791d.H(), dVar.f10791d.G(), (int) MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR);
        } else if (bVar != null) {
            try {
                if (bVar.a((Object) "campaign_request_error_type") != null) {
                    com.mbridge.msdk.newreward.function.d.c.a().b().a(dVar.f10791d.h(), dVar.f10791d.C(), dVar.f10791d.H(), dVar.f10791d.G(), ((Integer) bVar.a((Object) "campaign_request_error_type")).intValue());
                }
            } catch (Exception unused) {
            }
        }
        dVar.f10789b.reqFailed(bVar);
    }
}
