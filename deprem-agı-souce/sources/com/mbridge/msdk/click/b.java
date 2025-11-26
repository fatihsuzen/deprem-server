package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.click.a.a;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;

public final class b {
    public static void a(Context context, String str, CampaignEx campaignEx, String str2, int i5) {
        if (!TextUtils.isEmpty(str2)) {
            CampaignEx campaignEx2 = campaignEx;
            a.a(context, campaignEx2, str, str2, true, false, a.f8071i);
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, JumpLoaderResult jumpLoaderResult, Boolean bool, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
        aj.a(context, jumpLoaderResult.getUrl(), (BaseTrackingListener) nativeTrackingListener, campaignEx, list);
    }
}
