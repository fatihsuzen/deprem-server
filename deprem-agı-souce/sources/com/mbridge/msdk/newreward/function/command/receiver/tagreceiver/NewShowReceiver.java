package com.mbridge.msdk.newreward.function.command.receiver.tagreceiver;

import android.app.Activity;
import android.content.Intent;
import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.a;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import com.mbridge.msdk.newreward.player.MBRewardVideoActivity;

@ReceiverAction(id = "NewShowReceiver", type = b.class)
public class NewShowReceiver implements b {

    /* renamed from: a  reason: collision with root package name */
    e f10868a;

    public final void a(Object obj) {
        e eVar = (e) obj;
        this.f10868a = eVar;
        if (eVar != null) {
            Intent intent = new Intent(c.m().c(), MBRewardVideoActivity.class);
            intent.putExtra(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, this.f10868a.G());
            if (!(this.f10868a.D() == null || this.f10868a.D().a() == null || this.f10868a.D().a().size() != 1)) {
                e eVar2 = this.f10868a;
                eVar2.a(eVar2.D().a().get(0));
            }
            try {
                this.f10868a.p(a.b(c.m().c()));
            } catch (Throwable th) {
                af.b("NewShowReceiver", th.getMessage());
            }
            try {
                if (!(c.m() == null || c.m().e() == null)) {
                    ((Activity) c.m().e()).startActivity(intent);
                    return;
                }
            } catch (Throwable th2) {
                af.b("NewShowReceiver", th2.getMessage());
            }
            intent.addFlags(268435456);
            c.m().c().startActivity(intent);
        }
    }
}
