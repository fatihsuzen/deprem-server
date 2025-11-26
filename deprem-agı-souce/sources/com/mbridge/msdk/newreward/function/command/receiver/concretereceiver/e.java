package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.newreward.function.command.b;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.receiver.a;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    com.mbridge.msdk.newreward.a.e f10814a;

    /* renamed from: b  reason: collision with root package name */
    c f10815b;

    public final void a(b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        int i5;
        try {
            Map map = (Map) bVar.b();
            this.f10814a = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
            this.f10815b = (c) map.get("command_manager");
            try {
                Map<String, Long> map2 = com.mbridge.msdk.foundation.same.a.b.f9221k;
                if (map2 != null && map2.size() > 0) {
                    com.mbridge.msdk.foundation.same.a.b.f9221k.clear();
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
            try {
                i.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(this.f10814a.H());
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    e6.printStackTrace();
                }
            }
            try {
                com.mbridge.msdk.newreward.a.e eVar = this.f10814a;
                if (eVar.A() == 2) {
                    if (TextUtils.isEmpty(eVar.J())) {
                        com.mbridge.msdk.foundation.c.b b5 = com.mbridge.msdk.foundation.c.a.b(880035, "errorCode: 3507 errorMessage: data load failed, errorMsg is bidToken null");
                        throw new MBridgeError(b5.a(), b5.b());
                    }
                }
                if (com.mbridge.msdk.system.a.map == null) {
                    com.mbridge.msdk.foundation.c.b b6 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is not init sdk");
                    throw new MBridgeError(b6.a(), b6.b());
                } else if (((MBridgeDailyPlayModel) this.f10815b.a((Object) new HashMap(), com.mbridge.msdk.newreward.function.command.f.CREATE_DAILY)).isOverDailyCap()) {
                    bVar2.reqFailed(new com.mbridge.msdk.foundation.c.b(880019));
                } else {
                    com.mbridge.msdk.newreward.a.e eVar2 = this.f10814a;
                    if (eVar2 != null) {
                        com.mbridge.msdk.newreward.function.e.f x4 = eVar2.x();
                        if (x4 != null) {
                            com.mbridge.msdk.videocommon.d.c b7 = x4.b();
                            if (b7 != null) {
                                Queue<Integer> B4 = b7.B();
                                if (B4 != null) {
                                    if (B4.size() != 0) {
                                        Integer poll = B4.poll();
                                        if (poll != null) {
                                            i5 = poll.intValue() * 1000;
                                            eVar2.f(i5);
                                            bVar2.reqSuccessful((Object) null);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i5 = 25000;
                    eVar2.f(i5);
                    bVar2.reqSuccessful((Object) null);
                }
            } catch (MBridgeError e7) {
                bVar2.reqFailed(new com.mbridge.msdk.foundation.c.b(e7.getErrorCode(), e7.getErrorMessage()));
            }
        } catch (Exception e8) {
            bVar2.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e8.getMessage()));
        }
    }
}
