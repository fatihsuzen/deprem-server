package com.mbridge.msdk.video.dynview.h;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.video.dynview.b.b;
import com.mbridge.msdk.video.dynview.e.e;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.dynview.j.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f12108a = false;

    public a() {
    }

    public a(Context context, List<CampaignEx> list, h hVar, Map<String, Object> map) {
        a(new c().a(context, list), hVar, map);
    }

    private void a(com.mbridge.msdk.video.dynview.c cVar, final h hVar, Map<String, Object> map) {
        View view;
        if (hVar != null) {
            if (cVar == null) {
                hVar.viewInflaterFail(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_VIEWOPTION);
            } else if (cVar.a() == null) {
                hVar.viewInflaterFail(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_CONTEXT);
            } else if (TextUtils.isEmpty(cVar.b())) {
                hVar.viewInflaterFail(com.mbridge.msdk.video.dynview.c.a.NOT_FOUND_LAYOUTNAME);
            } else {
                try {
                    if (cVar.l() != null) {
                        view = DynamicViewCreator.getInstance().createDynamicView(new DyOption.Builder().campaignEx((cVar.g() == null || cVar.g().size() <= 0) ? null : cVar.g().get(0)).fileDirs(cVar.l()).dyAdType(DyAdType.REWARD).orientation(cVar.e()).templateType(cVar.h()).build());
                        if (view != null) {
                            f12108a = true;
                        } else {
                            f12108a = false;
                            view = LayoutInflater.from(cVar.a()).inflate(x.a(cVar.a(), cVar.b(), TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                        }
                    } else {
                        f12108a = false;
                        view = LayoutInflater.from(cVar.a()).inflate(x.a(cVar.a(), cVar.b(), TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                    }
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    map.put("is_dy_success", Boolean.valueOf(f12108a));
                    b.a().a(view, cVar, map);
                    com.mbridge.msdk.video.dynview.b.a.a().a(view, cVar, map, new e() {
                        public final void a(View view, List<View> list) {
                            com.mbridge.msdk.video.dynview.a aVar = new com.mbridge.msdk.video.dynview.a();
                            aVar.a(view);
                            aVar.a(list);
                            aVar.a(a.f12108a);
                            hVar.viewInflaterSuccess(aVar);
                        }

                        public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                            hVar.viewInflaterFail(aVar);
                        }
                    });
                } catch (Exception e5) {
                    af.b("MBridgeUI", e5.getMessage());
                    hVar.viewInflaterFail(com.mbridge.msdk.video.dynview.c.a.VIEW_CREATE_ERROR);
                }
            }
        }
    }

    public a(com.mbridge.msdk.video.dynview.c cVar, h hVar, Map<String, Object> map) {
        a(cVar, hVar, map);
    }
}
