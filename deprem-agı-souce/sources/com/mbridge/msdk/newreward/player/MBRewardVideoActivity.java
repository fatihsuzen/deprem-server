package com.mbridge.msdk.newreward.player;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.d;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.iview.IMetaData;
import com.mbridge.msdk.newreward.player.presenter.ActivityPresenter;

public class MBRewardVideoActivity extends BaseActivity implements IMetaData {
    Object data;
    ViewGroup viewGroup;

    public void activityReport(String str) {
    }

    public Object getDate() {
        return this.data;
    }

    public ViewGroup getRootViewGroup() {
        return this.viewGroup;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ViewGroup viewGroup2 = (ViewGroup) getLayoutInflater().inflate(x.a(getApplicationContext(), "mbridge_activity", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        this.viewGroup = viewGroup2;
        setContentView(viewGroup2);
        this.activityPresenter = new ActivityPresenter(this, getIntent().getStringExtra(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
    }

    public void onShowFail(@BridgeParameter(key = "reason") String str, @BridgeParameter(key = "code") int i5) {
        try {
            e a5 = d.a().a(getIntent().getStringExtra(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID));
            if (a5 != null && !a5.Y()) {
                a5.j(true);
                if (a5.K() != null) {
                    a5.K().onShowFail(a5.S(), str);
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        finish();
    }

    public void setDate(Object obj) {
        this.data = obj;
    }

    public void activityReport(String str, com.mbridge.msdk.foundation.same.report.d.e eVar) {
    }
}
