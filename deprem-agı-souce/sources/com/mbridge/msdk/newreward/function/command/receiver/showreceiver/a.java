package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import java.util.Map;

public final class a implements b {
    public final void a(Object obj) {
        ViewGroup viewGroup;
        try {
            Map map = (Map) obj;
            String str = (String) map.get("life_cycle");
            if (map.get("parent_temple") instanceof ViewGroup) {
                viewGroup = (ViewGroup) map.get("parent_temple");
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = viewGroup.getChildAt(i5);
                    if (childAt instanceof IBaseView) {
                        ((IBaseView) childAt).onActivityLifeCycleCallback(str);
                    }
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }
}
