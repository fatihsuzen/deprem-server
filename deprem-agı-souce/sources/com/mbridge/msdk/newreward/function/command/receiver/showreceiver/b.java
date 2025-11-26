package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.view.ViewGroup;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.d;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.player.view.Template102;
import com.mbridge.msdk.newreward.player.view.Template202;
import com.mbridge.msdk.newreward.player.view.Template302;
import com.mbridge.msdk.newreward.player.view.Template5002010;
import com.mbridge.msdk.newreward.player.view.Template802;
import com.mbridge.msdk.newreward.player.view.Template902;
import com.mbridge.msdk.newreward.player.view.Template904;
import com.mbridge.msdk.newreward.player.view.bigtemplate.Template201;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateEC1302;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateEC404;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateEC704;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateHalfEC;
import com.mbridge.msdk.newreward.player.view.ectemplate.TemplateVastEC;
import com.mbridge.msdk.newreward.player.view.halfoffer.TemplateEndCover;
import com.mbridge.msdk.newreward.player.view.halfoffer.TemplateHalf;
import java.util.Map;

public final class b implements com.mbridge.msdk.newreward.function.command.receiver.b {
    public final void a(Object obj) {
        String str;
        Map map = (Map) obj;
        String valueOf = String.valueOf(map.get("add_temple"));
        ViewGroup viewGroup = (ViewGroup) map.get("parent_temple");
        e eVar = (e) map.get("adapter_model");
        c b5 = d.a().b();
        char c5 = 65535;
        switch (valueOf.hashCode()) {
            case -1738448503:
                if (valueOf.equals("WEB_EC")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1623688923:
                if (valueOf.equals("WEB_TEMPLATE")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1517363552:
                if (valueOf.equals("HALF_END_CARD")) {
                    c5 = 2;
                    break;
                }
                break;
            case -1207348799:
                if (valueOf.equals("ONLY_PLAYABLE")) {
                    c5 = 3;
                    break;
                }
                break;
            case -298533114:
                if (valueOf.equals("HALF_TEMPLATE")) {
                    c5 = 4;
                    break;
                }
                break;
            case 48627:
                if (valueOf.equals(MBridgeCommon.DYNAMIC_VIEW_TEMPLATE_VALUE)) {
                    c5 = 5;
                    break;
                }
                break;
            case 49587:
                if (valueOf.equals("201")) {
                    c5 = 6;
                    break;
                }
                break;
            case 49588:
                if (valueOf.equals("202")) {
                    c5 = 7;
                    break;
                }
                break;
            case 50549:
                if (valueOf.equals("302")) {
                    c5 = 8;
                    break;
                }
                break;
            case 51512:
                if (valueOf.equals("404")) {
                    c5 = 9;
                    break;
                }
                break;
            case 54395:
                if (valueOf.equals("704")) {
                    c5 = 10;
                    break;
                }
                break;
            case 55354:
                if (valueOf.equals("802")) {
                    c5 = 11;
                    break;
                }
                break;
            case 56315:
                if (valueOf.equals("902")) {
                    c5 = 12;
                    break;
                }
                break;
            case 56317:
                if (valueOf.equals("904")) {
                    c5 = 13;
                    break;
                }
                break;
            case 1510308:
                if (valueOf.equals("1302")) {
                    c5 = 14;
                    break;
                }
                break;
            case 2627148:
                if (valueOf.equals("VAST")) {
                    c5 = 15;
                    break;
                }
                break;
            case 563693366:
                if (valueOf.equals("SHOW_CLICK_URL")) {
                    c5 = 16;
                    break;
                }
                break;
            case 1213120338:
                if (valueOf.equals("5002010")) {
                    c5 = 17;
                    break;
                }
                break;
            case 1277364343:
                if (valueOf.equals("HALF_TEMPLATE_EC")) {
                    c5 = 18;
                    break;
                }
                break;
        }
        String str2 = "";
        switch (c5) {
            case 0:
                if (eVar != null) {
                    str2 = eVar.V();
                }
                b5.i(b5.a("web_resource_action", 2, "parent_temple", viewGroup, "adapter_model", eVar, "command_manager", b5, "bridge_ids", str2), f.SHOW_OR_PRELOAD_WEB_EC);
                return;
            case 1:
                if (eVar != null) {
                    str = eVar.G();
                } else {
                    str = str2;
                }
                if (eVar != null) {
                    str2 = eVar.V();
                }
                b5.i(b5.a("web_resource_action", 2, "parent_temple", viewGroup, "adapter_model", eVar, "command_manager", b5, CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str, "bridge_ids", str2), f.SHOW_OR_PRELOAD_WEB_TEMPLATE);
                return;
            case 2:
                new TemplateHalfEC(viewGroup.getContext()).show(viewGroup);
                return;
            case 3:
                if (eVar != null) {
                    str2 = eVar.V();
                }
                b5.i(b5.a("web_resource_action", 3, "parent_temple", viewGroup, "adapter_model", eVar, "command_manager", b5, "bridge_ids", str2), f.SHOW_OR_PRELOAD_WEB_EC);
                return;
            case 4:
                new TemplateHalf(viewGroup.getContext()).show(viewGroup);
                return;
            case 5:
                new Template102(viewGroup.getContext()).show(viewGroup);
                return;
            case 6:
                new Template201(viewGroup.getContext()).show(viewGroup);
                return;
            case 7:
                new Template202(viewGroup.getContext()).show(viewGroup);
                return;
            case 8:
                new Template302(viewGroup.getContext()).show(viewGroup);
                return;
            case 9:
                new TemplateEC404(viewGroup.getContext()).show(viewGroup);
                return;
            case 10:
                new TemplateEC704(viewGroup.getContext()).show(viewGroup);
                return;
            case 11:
                new Template802(viewGroup.getContext()).show(viewGroup);
                return;
            case 12:
                new Template902(viewGroup.getContext()).show(viewGroup);
                return;
            case 13:
                new Template904(viewGroup.getContext()).show(viewGroup);
                return;
            case 14:
                new TemplateEC1302(viewGroup.getContext()).show(viewGroup);
                return;
            case 15:
                new TemplateVastEC(viewGroup.getContext()).show(viewGroup);
                return;
            case 16:
                if (eVar != null) {
                    str2 = eVar.V();
                }
                b5.i(b5.a("web_resource_action", 4, "parent_temple", viewGroup, "adapter_model", eVar, "command_manager", b5, "bridge_ids", str2), f.SHOW_OR_PRELOAD_WEB_EC);
                return;
            case 17:
                new Template5002010(viewGroup.getContext()).show(viewGroup);
                return;
            case 18:
                new TemplateEndCover(viewGroup.getContext()).show(viewGroup);
                return;
            default:
                Object obj2 = map.get("template_type");
                if (obj2 instanceof Integer) {
                    int intValue = ((Integer) obj2).intValue();
                    if (intValue == 17) {
                        new Template904(viewGroup.getContext()).show(viewGroup);
                        return;
                    } else if (intValue == 18) {
                        new TemplateEC404(viewGroup.getContext()).show(viewGroup);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
        }
    }
}
