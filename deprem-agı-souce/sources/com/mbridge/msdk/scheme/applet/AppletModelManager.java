package com.mbridge.msdk.scheme.applet;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import j$.util.concurrent.ConcurrentHashMap;

public class AppletModelManager {
    private static final String TAG = "AppletModelManager";
    private ConcurrentHashMap<String, AppletsModel> appletsModels;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final AppletModelManager INSTANCE = new AppletModelManager();

        private SingletonHolder() {
        }
    }

    public static AppletModelManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public AppletsModel get(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            String str = campaignEx.getRequestId() + "_" + campaignEx.getId() + "_" + campaignEx.getCampaignUnitId();
            if (this.appletsModels.containsKey(str)) {
                return this.appletsModels.get(str);
            }
            AppletsModel appletsModel = new AppletsModel(campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getRequestId());
            this.appletsModels.put(str, appletsModel);
            return appletsModel;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, e5.getMessage());
            }
            return null;
        }
    }

    public void remove(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                String str = campaignEx.getRequestId() + "_" + campaignEx.getId() + "_" + campaignEx.getCampaignUnitId();
                if (this.appletsModels.containsKey(str)) {
                    this.appletsModels.remove(str);
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(TAG, e5.getMessage());
                }
            }
        }
    }

    public void replace(AppletsModel appletsModel, CampaignEx campaignEx) {
        if (campaignEx != null && appletsModel != null) {
            try {
                String str = campaignEx.getRequestId() + "_" + campaignEx.getId() + "_" + campaignEx.getCampaignUnitId();
                if (this.appletsModels.containsKey(str)) {
                    this.appletsModels.remove(str);
                }
                this.appletsModels.put(str, appletsModel);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(TAG, e5.getMessage());
                }
            }
        }
    }

    private AppletModelManager() {
        this.appletsModels = new ConcurrentHashMap<>();
    }
}
