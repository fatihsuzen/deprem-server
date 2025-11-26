package com.mbridge.msdk.foundation.download.download;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.tools.ad;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ResDownloadCheckManager {
    private static ConcurrentHashMap<String, Boolean> recordImageMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Boolean> campaignStateMap;
    private ConcurrentHashMap<String, Boolean> preLoadSuccessedMap;
    private ConcurrentHashMap<String, Boolean> recordVideoMap;
    private ConcurrentHashMap<String, Boolean> recordZipMap;

    private static final class Holder {
        public static ResDownloadCheckManager instance = new ResDownloadCheckManager();

        private Holder() {
        }
    }

    private void addImageUrlToMap(List<String> list) {
        ConcurrentHashMap<String, Boolean> concurrentHashMap;
        if (list != null && list.size() != 0) {
            for (String next : list) {
                if (!TextUtils.isEmpty(next) && (concurrentHashMap = recordImageMap) != null && !concurrentHashMap.containsKey(next)) {
                    boolean b5 = b.a(c.m().c()).b(next);
                    if (!TextUtils.isEmpty(next)) {
                        recordImageMap.put(next, Boolean.valueOf(b5));
                    }
                }
            }
        }
    }

    private void addUrlToMap(CampaignEx campaignEx) {
        List<CampaignEx.c.a> a5;
        ConcurrentHashMap<String, Boolean> concurrentHashMap;
        ConcurrentHashMap<String, Boolean> concurrentHashMap2;
        if (campaignEx != null) {
            String videoUrlEncode = campaignEx.getVideoUrlEncode();
            if (!TextUtils.isEmpty(videoUrlEncode) && (concurrentHashMap2 = this.recordVideoMap) != null && !concurrentHashMap2.containsKey(videoUrlEncode)) {
                this.recordVideoMap.put(videoUrlEncode, Boolean.FALSE);
            }
            String str = campaignEx.getendcard_url();
            if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.recordZipMap) != null && !concurrentHashMap.containsKey(str)) {
                this.recordZipMap.put(str, Boolean.FALSE);
            }
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null && (a5 = rewardTemplateMode.a()) != null) {
                for (CampaignEx.c.a next : a5) {
                    if (next != null) {
                        addImageUrlToMap(next.f9019a);
                    }
                }
            }
        }
    }

    private boolean checkImageUrlState(boolean z4, String str) {
        boolean checkState = checkState(recordImageMap, str);
        if (!checkState && !b.a(c.m().c()).b(str)) {
            return checkState;
        }
        return true;
    }

    private boolean checkState(ConcurrentHashMap<String, Boolean> concurrentHashMap, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (concurrentHashMap == null) {
            new ConcurrentHashMap().put(str, Boolean.FALSE);
            return false;
        } else if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str).booleanValue();
        } else {
            concurrentHashMap.put(str, Boolean.FALSE);
            return false;
        }
    }

    private boolean checkZipState(boolean z4, String str) {
        boolean checkState = checkState(this.recordZipMap, str);
        if (checkState || !z4 || TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str))) {
            return checkState;
        }
        this.recordZipMap.put(str, Boolean.TRUE);
        return true;
    }

    public static ResDownloadCheckManager getInstance() {
        return Holder.instance;
    }

    private boolean getIsEffectivePath(String str) {
        String c5 = ad.c(str);
        File file = new File(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC) + File.separator + c5);
        try {
            if (!file.exists() || !file.isFile() || !file.canRead()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private void updateCampaignState(String str, boolean z4) {
        if (this.campaignStateMap == null) {
            this.campaignStateMap = new ConcurrentHashMap<>();
        }
        if (!TextUtils.isEmpty(str)) {
            this.campaignStateMap.put(str, Boolean.valueOf(z4));
        }
    }

    public boolean checkImageState(boolean z4, CampaignEx.c cVar) {
        List<CampaignEx.c.a> a5;
        List<String> list;
        if (!(cVar == null || (a5 = cVar.a()) == null)) {
            for (CampaignEx.c.a next : a5) {
                if (!(next == null || (list = next.f9019a) == null)) {
                    for (String checkImageUrlState : list) {
                        if (!checkImageUrlState(z4, checkImageUrlState)) {
                            return false;
                        }
                    }
                    continue;
                }
            }
        }
        return true;
    }

    public boolean checkPreLoadState(String str) {
        if (!TextUtils.isEmpty(str) && this.preLoadSuccessedMap.containsKey(str)) {
            return this.preLoadSuccessedMap.get(str).booleanValue();
        }
        return false;
    }

    public boolean containsVideoKey(String str) {
        if (this.recordVideoMap == null || TextUtils.isEmpty(str) || !this.recordVideoMap.containsKey(str)) {
            return false;
        }
        return this.recordVideoMap.get(str).booleanValue();
    }

    public boolean containsZipKey(String str) {
        if (this.recordZipMap == null || TextUtils.isEmpty(str) || !this.recordZipMap.containsKey(str)) {
            return false;
        }
        return this.recordZipMap.get(str).booleanValue();
    }

    public void removePreLoadState(String str) {
        if (this.preLoadSuccessedMap.containsKey(str)) {
            this.preLoadSuccessedMap.remove(str);
        }
    }

    public void setCampaignList(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null) {
                    addUrlToMap(next);
                    updateCampaignState(next.getId(), false);
                }
            }
        }
    }

    public void setImageDownloadDone(String str, boolean z4) {
        if (recordImageMap == null) {
            recordImageMap = new ConcurrentHashMap<>();
        }
        if (!TextUtils.isEmpty(str)) {
            recordImageMap.put(str, Boolean.valueOf(z4));
        }
    }

    public void setTemplatePreLoadDone(String str, boolean z4) {
        if (this.preLoadSuccessedMap == null) {
            this.preLoadSuccessedMap = new ConcurrentHashMap<>();
        }
        if (!TextUtils.isEmpty(str)) {
            this.preLoadSuccessedMap.put(str, Boolean.valueOf(z4));
        }
    }

    public void setVideoDownloadDone(String str, boolean z4) {
        if (this.recordVideoMap == null) {
            this.recordVideoMap = new ConcurrentHashMap<>();
        }
        if (!TextUtils.isEmpty(str)) {
            this.recordVideoMap.put(str, Boolean.valueOf(z4));
        }
    }

    public void setZipDownloadDone(String str, boolean z4) {
        if (this.recordZipMap == null) {
            this.recordZipMap = new ConcurrentHashMap<>();
        }
        if (!TextUtils.isEmpty(str)) {
            this.recordZipMap.put(str, Boolean.valueOf(z4));
        }
    }

    private ResDownloadCheckManager() {
        this.campaignStateMap = new ConcurrentHashMap<>();
        this.preLoadSuccessedMap = new ConcurrentHashMap<>();
        this.recordVideoMap = new ConcurrentHashMap<>();
        this.recordZipMap = new ConcurrentHashMap<>();
    }

    public void setCampaignList(CampaignEx campaignEx) {
        if (campaignEx != null) {
            addUrlToMap(campaignEx);
            updateCampaignState(campaignEx.getId(), false);
        }
    }
}
