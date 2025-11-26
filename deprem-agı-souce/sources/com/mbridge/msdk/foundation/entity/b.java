package com.mbridge.msdk.foundation.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.out.Frame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public abstract class b {
    public static final String JSON_KEY_ADS = "ads";
    public static final String JSON_KEY_AD_HTML = "cam_html";
    public static final String JSON_KEY_AD_TYPE = "ad_type";
    public static final String JSON_KEY_AD_ZIP = "cam_tpl_url";
    public static final String JSON_KEY_BANNER_HTML = "cam_html";
    public static final String JSON_KEY_BANNER_URL = "cam_tpl_url";
    public static final String JSON_KEY_CSP = "csp";
    public static final String JSON_KEY_C_I = "c_i";
    public static final String JSON_KEY_DO = "do";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_END_SCREEN_URL = "end_screen_url";
    public static final String JSON_KEY_FRAME_ADS = "frames";
    public static final String JSON_KEY_HTML_URL = "html_url";
    public static final String JSON_KEY_IA_EXT1 = "ia_all_ext1";
    public static final String JSON_KEY_IA_EXT2 = "ia_all_ext2";
    public static final String JSON_KEY_IA_ICON = "ia_icon";
    public static final String JSON_KEY_IA_ORI = "ia_ori";
    public static final String JSON_KEY_IA_RST = "ia_rst";
    public static final String JSON_KEY_IA_URL = "ia_url";
    public static final String JSON_KEY_JM_DO = "jm_do";
    public static final String JSON_KEY_MOF_TEMPLATE_URL = "mof_template_url";
    public static final String JSON_KEY_MOF_TPLID = "mof_tplid";
    public static final String JSON_KEY_NSCPT = "nscpt";
    public static final String JSON_KEY_ONLY_IMPRESSION_URL = "only_impression_url";
    public static final String JSON_KEY_PARENT_SESSION_ID = "parent_session_id";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_REPLACE_TMP = "replace_tmp";
    public static final String JSON_KEY_REQ_EXT_DATA = "req_ext_data";
    public static final String JSON_KEY_RKS = "rks";
    public static final String JSON_KEY_SECOND_REQUEST_INDEX = "r_index";
    public static final String JSON_KEY_SECOND_SHOW_INDEX = "s_show_index";
    public static final String JSON_KEY_SESSION_ID = "a";
    public static final String JSON_KEY_SH = "sh";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TK_TCP_PORT = "tk_tcp_port";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_UNIT_SIZE = "unit_size";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String KEY_IRLFA = "irlfa";
    private static final String TAG = "b";
    private int activitySwitch = 1;
    private String adHtml;
    private int adType;
    private String adZip;
    public ArrayList<CampaignEx> ads;
    private String bannerHtml;
    private String bannerUrl;
    protected StringBuffer cParams = new StringBuffer();
    private String csp;
    private String domain;
    private double ecppv;
    private String encryptPrice = "";
    private HashMap<String, String> epMap;
    private String htmlUrl;
    private String ia_all_ext1;
    private String ia_all_ext2;
    private String ia_icon;
    private int ia_ori;
    private int ia_rst;
    private String ia_url;
    private int jmDo;
    private List<Frame> listFrames;
    private String localRequestId;
    private c metricsData;
    private String msg = "";
    private String onlyImpressionUrl;
    private String parentSessionId;
    private String requestId;
    private HashMap<String, String> rks;
    private int secondRequestIndex = 0;
    private int secondShowIndex = 0;
    private String sessionId;
    private String sh;
    private int template;
    private int tokenRule;
    private String unitSize;
    private int vcn;

    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|(3:15|16|17)|18|19|(1:54)(4:23|24|25|61)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0056 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[Catch:{ Exception -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void getSysIDAndBKUPID(org.json.JSONObject r9) {
        /*
            java.lang.String r0 = "H+tU+FeXHM=="
            com.mbridge.msdk.foundation.controller.d.a()
            com.mbridge.msdk.foundation.tools.FastKV$Builder r1 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x0019 }
            com.mbridge.msdk.foundation.same.b.c r2 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x0019 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.b.e.a((com.mbridge.msdk.foundation.same.b.c) r2)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0019 }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0019 }
            com.mbridge.msdk.foundation.tools.FastKV r1 = r1.build()     // Catch:{ Exception -> 0x0019 }
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            java.lang.String r2 = "H+tU+Fz8"
            java.lang.String r3 = "H+tU+bfPhM=="
            java.lang.String r4 = "c"
            java.lang.String r5 = "b"
            if (r1 == 0) goto L_0x0084
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x007e }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x007e }
            if (r9 == 0) goto L_0x0104
            if (r0 == 0) goto L_0x0104
            java.lang.String r0 = r9.optString(r5)     // Catch:{ Exception -> 0x007e }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x007e }
            if (r6 != 0) goto L_0x0056
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x007e }
            boolean r6 = android.text.TextUtils.equals(r6, r0)     // Catch:{ Exception -> 0x007e }
            if (r6 != 0) goto L_0x0056
            com.mbridge.msdk.foundation.same.a.f9179V = r0     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.a.a.a r0 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x007e }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x007e }
            r0.a((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x007e }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r3)     // Catch:{ Exception -> 0x0056 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x0056 }
            r1.putString(r0, r3)     // Catch:{ Exception -> 0x0056 }
        L_0x0056:
            java.lang.String r9 = r9.optString(r4)     // Catch:{ Exception -> 0x007e }
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x007e }
            if (r0 != 0) goto L_0x0104
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x007e }
            boolean r0 = android.text.TextUtils.equals(r0, r9)     // Catch:{ Exception -> 0x007e }
            if (r0 != 0) goto L_0x0104
            com.mbridge.msdk.foundation.same.a.f9188g = r9     // Catch:{ Exception -> 0x007e }
            com.mbridge.msdk.foundation.a.a.a r9 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x007e }
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x007e }
            r9.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x007e }
            java.lang.String r9 = com.mbridge.msdk.foundation.tools.z.a(r2)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x0104 }
            r1.putString(r9, r0)     // Catch:{ Exception -> 0x0104 }
            goto L_0x0104
        L_0x007e:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x0104
        L_0x0084:
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0100 }
            android.content.Context r1 = r1.c()     // Catch:{ Exception -> 0x0100 }
            if (r9 == 0) goto L_0x0104
            if (r1 == 0) goto L_0x0104
            java.lang.String r6 = r9.optString(r5)     // Catch:{ Exception -> 0x0100 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0100 }
            r8 = 0
            if (r7 != 0) goto L_0x00c8
            java.lang.String r7 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x0100 }
            boolean r7 = android.text.TextUtils.equals(r7, r6)     // Catch:{ Exception -> 0x0100 }
            if (r7 != 0) goto L_0x00c8
            com.mbridge.msdk.foundation.same.a.f9179V = r6     // Catch:{ Exception -> 0x0100 }
            com.mbridge.msdk.foundation.a.a.a r6 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0100 }
            java.lang.String r7 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x0100 }
            r6.a((java.lang.String) r5, (java.lang.String) r7)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0100 }
            android.content.SharedPreferences r5 = r1.getSharedPreferences(r5, r8)     // Catch:{ Exception -> 0x0100 }
            if (r5 == 0) goto L_0x00c8
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ Exception -> 0x0100 }
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.z.a(r3)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f9179V     // Catch:{ Exception -> 0x0100 }
            r5.putString(r3, r6)     // Catch:{ Exception -> 0x0100 }
            r5.apply()     // Catch:{ Exception -> 0x0100 }
        L_0x00c8:
            java.lang.String r9 = r9.optString(r4)     // Catch:{ Exception -> 0x0100 }
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0100 }
            if (r3 != 0) goto L_0x0104
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x0100 }
            boolean r3 = android.text.TextUtils.equals(r3, r9)     // Catch:{ Exception -> 0x0100 }
            if (r3 != 0) goto L_0x0104
            com.mbridge.msdk.foundation.same.a.f9188g = r9     // Catch:{ Exception -> 0x0100 }
            com.mbridge.msdk.foundation.a.a.a r9 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0100 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x0100 }
            r9.a((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r9 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0100 }
            android.content.SharedPreferences r9 = r1.getSharedPreferences(r9, r8)     // Catch:{ Exception -> 0x0100 }
            if (r9 == 0) goto L_0x0104
            android.content.SharedPreferences$Editor r9 = r9.edit()     // Catch:{ Exception -> 0x0100 }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r2)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.f9188g     // Catch:{ Exception -> 0x0100 }
            r9.putString(r0, r1)     // Catch:{ Exception -> 0x0100 }
            r9.apply()     // Catch:{ Exception -> 0x0100 }
            goto L_0x0104
        L_0x0100:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.entity.b.getSysIDAndBKUPID(org.json.JSONObject):void");
    }

    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject) {
        return parseCampaignUnit(jSONObject, "");
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject) {
        return parseV5CampaignUnit(jSONObject, "");
    }

    public abstract String assembCParams();

    public int getActivitySwitch() {
        return this.activitySwitch;
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public int getAdType() {
        return this.adType;
    }

    public String getAdZip() {
        return this.adZip;
    }

    public ArrayList<CampaignEx> getAds() {
        return this.ads;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getCsp() {
        return this.csp;
    }

    public String getDomain() {
        return this.domain;
    }

    public double getEcppv() {
        return this.ecppv;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public HashMap<String, String> getEpMap() {
        return this.epMap;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getIa_all_ext1() {
        return this.ia_all_ext1;
    }

    public String getIa_all_ext2() {
        return this.ia_all_ext2;
    }

    public String getIa_icon() {
        return this.ia_icon;
    }

    public int getIa_ori() {
        return this.ia_ori;
    }

    public int getIa_rst() {
        return this.ia_rst;
    }

    public String getIa_url() {
        return this.ia_url;
    }

    public int getJmDo() {
        return this.jmDo;
    }

    public List<Frame> getListFrames() {
        return this.listFrames;
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public c getMetricsData() {
        return this.metricsData;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getOnlyImpressionUrl() {
        return this.onlyImpressionUrl;
    }

    public String getParentSessionId() {
        return this.parentSessionId;
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionUrl)) {
                return "";
            }
            Uri parse = Uri.parse(this.onlyImpressionUrl);
            if (parse != null) {
                this.requestId = parse.getQueryParameter(CampaignEx.JSON_KEY_AD_K);
            }
            return this.requestId;
        } catch (Exception unused) {
            return "";
        }
    }

    public HashMap<String, String> getRks() {
        return this.rks;
    }

    public int getSecondRequestIndex() {
        return this.secondRequestIndex;
    }

    public int getSecondShowIndex() {
        return this.secondShowIndex;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSh() {
        return this.sh;
    }

    public int getTemplate() {
        return this.template;
    }

    public int getTokenRule() {
        int i5 = this.tokenRule;
        if (i5 == 1) {
            return i5;
        }
        return 0;
    }

    public String getUnitSize() {
        return this.unitSize;
    }

    public int getVcn() {
        int i5 = this.vcn;
        if (i5 > 1) {
            return i5;
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    public Object nullToEmpty(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj;
    }

    public void setActivitySwitch(int i5) {
        this.activitySwitch = i5;
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public void setAdType(int i5) {
        this.adType = i5;
    }

    public void setAdZip(String str) {
        this.adZip = str;
    }

    public void setAds(ArrayList<CampaignEx> arrayList) {
        this.ads = arrayList;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setCsp(String str) {
        this.csp = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setEcppv(double d5) {
        this.ecppv = d5;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public void setEpMap(HashMap<String, String> hashMap) {
        this.epMap = hashMap;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void setIa_all_ext1(String str) {
        this.ia_all_ext1 = str;
    }

    public void setIa_all_ext2(String str) {
        this.ia_all_ext2 = str;
    }

    public void setIa_icon(String str) {
        this.ia_icon = str;
    }

    public void setIa_ori(int i5) {
        this.ia_ori = i5;
    }

    public void setIa_rst(int i5) {
        this.ia_rst = i5;
    }

    public void setIa_url(String str) {
        this.ia_url = str;
    }

    public void setJmDo(int i5) {
        this.jmDo = i5;
    }

    public void setListFrames(List<Frame> list) {
        this.listFrames = list;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
        ArrayList<CampaignEx> ads2 = getAds();
        int size = ads2.size();
        int i5 = 0;
        while (i5 < size) {
            CampaignEx campaignEx = ads2.get(i5);
            i5++;
            campaignEx.setLocalRequestId(str);
        }
    }

    public void setMetricsData(c cVar) {
        this.metricsData = cVar;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setOnlyImpressionUrl(String str) {
        this.onlyImpressionUrl = str;
    }

    public void setParentSessionId(String str) {
        this.parentSessionId = str;
    }

    public void setRks(HashMap<String, String> hashMap) {
        this.rks = hashMap;
    }

    public void setSecondRequestIndex(int i5) {
        this.secondRequestIndex = i5;
    }

    public void setSecondShowIndex(int i5) {
        this.secondShowIndex = i5;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSh(String str) {
        this.sh = str;
    }

    public void setTemplate(int i5) {
        this.template = i5;
    }

    public void setTokenRule(int i5) {
        this.tokenRule = i5;
    }

    public void setUnitSize(String str) {
        this.unitSize = str;
    }

    public void setVcn(int i5) {
        this.vcn = i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x01b6 A[SYNTHETIC, Splitter:B:50:0x01b6] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x036c A[Catch:{ Exception -> 0x0299 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.foundation.entity.CampaignUnit parseCampaignUnit(org.json.JSONObject r35, java.lang.String r36) {
        /*
            r0 = r35
            java.lang.String r1 = "ads"
            java.lang.String r2 = "template"
            java.lang.String r3 = "ad_type"
            java.lang.String r4 = "parent_session_id"
            java.lang.String r5 = "a"
            java.lang.String r6 = "encrypt_ecppv"
            java.lang.String r7 = "ac_s"
            java.lang.String r8 = "only_impression_url"
            java.lang.String r9 = "html_url"
            if (r0 == 0) goto L_0x03fb
            com.mbridge.msdk.foundation.entity.CampaignUnit r11 = new com.mbridge.msdk.foundation.entity.CampaignUnit     // Catch:{ Exception -> 0x03f6 }
            r11.<init>()     // Catch:{ Exception -> 0x03f6 }
            java.lang.String r12 = "rks"
            java.lang.String r12 = r0.optString(r12)     // Catch:{ Exception -> 0x033e }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x033e }
            if (r13 != 0) goto L_0x0056
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x004d }
            r13.<init>(r12)     // Catch:{ Exception -> 0x004d }
            java.util.Iterator r12 = r13.keys()     // Catch:{ Exception -> 0x004d }
            java.util.HashMap r14 = new java.util.HashMap     // Catch:{ Exception -> 0x004d }
            r14.<init>()     // Catch:{ Exception -> 0x004d }
        L_0x0035:
            if (r12 == 0) goto L_0x0050
            boolean r15 = r12.hasNext()     // Catch:{ Exception -> 0x004d }
            if (r15 == 0) goto L_0x0050
            java.lang.Object r15 = r12.next()     // Catch:{ Exception -> 0x004d }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x004d }
            r16 = 0
            java.lang.String r10 = r13.optString(r15)     // Catch:{ Exception -> 0x004d }
            r14.put(r15, r10)     // Catch:{ Exception -> 0x004d }
            goto L_0x0035
        L_0x004d:
            r10 = r11
            goto L_0x03fa
        L_0x0050:
            r16 = 0
            r11.setRks(r14)     // Catch:{ Exception -> 0x004d }
            goto L_0x0058
        L_0x0056:
            r16 = 0
        L_0x0058:
            boolean r10 = android.text.TextUtils.isEmpty(r36)     // Catch:{ Exception -> 0x033e }
            java.lang.String r12 = "encrypt_p"
            java.lang.String r13 = ""
            if (r10 != 0) goto L_0x0072
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ Exception -> 0x004d }
            r10.<init>()     // Catch:{ Exception -> 0x004d }
            r10.put(r12, r13)     // Catch:{ Exception -> 0x004d }
            java.lang.String r14 = "irlfa"
            r10.put(r14, r13)     // Catch:{ Exception -> 0x004d }
            r11.setEpMap(r10)     // Catch:{ Exception -> 0x004d }
        L_0x0072:
            java.lang.String r10 = "req_ext_data"
            org.json.JSONObject r10 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x033e }
            java.lang.String r14 = "nscpt"
            r15 = 1
            int r14 = r0.optInt(r14, r15)     // Catch:{ Exception -> 0x033e }
            java.lang.String r15 = "mof_template_url"
            java.lang.String r15 = r0.optString(r15, r13)     // Catch:{ Exception -> 0x033e }
            r18 = r10
            java.lang.String r10 = "mof_tplid"
            r19 = r15
            r15 = 0
            int r10 = r0.optInt(r10, r15)     // Catch:{ Exception -> 0x033e }
            if (r18 == 0) goto L_0x0099
            java.lang.String r18 = r18.toString()     // Catch:{ Exception -> 0x004d }
            r20 = r18
            goto L_0x009b
        L_0x0099:
            r20 = r13
        L_0x009b:
            org.json.JSONArray r18 = new org.json.JSONArray     // Catch:{ Exception -> 0x033e }
            r18.<init>()     // Catch:{ Exception -> 0x033e }
            java.lang.String r15 = "pv_urls"
            org.json.JSONArray r15 = r0.optJSONArray(r15)     // Catch:{ Exception -> 0x033e }
            if (r15 == 0) goto L_0x00d0
            int r21 = r15.length()     // Catch:{ Exception -> 0x004d }
            if (r21 <= 0) goto L_0x00d0
            r21 = r14
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x004d }
            r22 = r10
            int r10 = r15.length()     // Catch:{ Exception -> 0x004d }
            r14.<init>(r10)     // Catch:{ Exception -> 0x004d }
            r23 = r13
            r10 = 0
        L_0x00be:
            int r13 = r15.length()     // Catch:{ Exception -> 0x004d }
            if (r10 >= r13) goto L_0x00ce
            java.lang.String r13 = r15.getString(r10)     // Catch:{ Exception -> 0x004d }
            r14.add(r13)     // Catch:{ Exception -> 0x004d }
            int r10 = r10 + 1
            goto L_0x00be
        L_0x00ce:
            r10 = r14
            goto L_0x00d8
        L_0x00d0:
            r22 = r10
            r23 = r13
            r21 = r14
            r10 = r16
        L_0x00d8:
            java.lang.String r13 = "replace_tmp"
            org.json.JSONObject r13 = r0.optJSONObject(r13)     // Catch:{ Exception -> 0x033e }
            com.mbridge.msdk.foundation.db.a.b r14 = com.mbridge.msdk.foundation.db.a.b.a()     // Catch:{ Exception -> 0x033e }
            r15 = 1
            r14.a(r13, r15)     // Catch:{ Exception -> 0x033e }
            getSysIDAndBKUPID(r0)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = r0.optString(r5)     // Catch:{ Exception -> 0x033e }
            r11.setSessionId(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = r0.optString(r4)     // Catch:{ Exception -> 0x033e }
            r11.setParentSessionId(r13)     // Catch:{ Exception -> 0x033e }
            int r13 = r0.optInt(r3)     // Catch:{ Exception -> 0x033e }
            r11.setAdType(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = "unit_size"
            java.lang.String r13 = r0.optString(r13)     // Catch:{ Exception -> 0x033e }
            r11.setUnitSize(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = r0.optString(r9)     // Catch:{ Exception -> 0x033e }
            r11.setHtmlUrl(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = r0.optString(r8)     // Catch:{ Exception -> 0x033e }
            r11.setOnlyImpressionUrl(r13)     // Catch:{ Exception -> 0x033e }
            int r13 = r0.optInt(r7)     // Catch:{ Exception -> 0x033e }
            r11.setActivitySwitch(r13)     // Catch:{ Exception -> 0x033e }
            double r13 = r0.optDouble(r6)     // Catch:{ Exception -> 0x033e }
            r11.setEcppv(r13)     // Catch:{ Exception -> 0x033e }
            int r13 = r0.optInt(r2)     // Catch:{ Exception -> 0x033e }
            r11.setTemplate(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = "jm_do"
            int r13 = r0.optInt(r13)     // Catch:{ Exception -> 0x033e }
            r11.setJmDo(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = "ia_icon"
            java.lang.String r13 = r0.optString(r13)     // Catch:{ Exception -> 0x033e }
            r11.setIa_icon(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = "ia_rst"
            int r13 = r0.optInt(r13)     // Catch:{ Exception -> 0x033e }
            r11.setIa_rst(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = "ia_url"
            java.lang.String r13 = r0.optString(r13)     // Catch:{ Exception -> 0x033e }
            r11.setIa_url(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = "ia_ori"
            int r13 = r0.optInt(r13)     // Catch:{ Exception -> 0x033e }
            r11.setIa_ori(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = "ia_all_ext1"
            java.lang.String r13 = r0.optString(r13)     // Catch:{ Exception -> 0x033e }
            r11.setIa_all_ext1(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = "ia_all_ext2"
            java.lang.String r13 = r0.optString(r13)     // Catch:{ Exception -> 0x033e }
            r11.setIa_all_ext2(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = "vcn"
            int r13 = r0.optInt(r13)     // Catch:{ Exception -> 0x033e }
            r11.setVcn(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = "token_r"
            int r13 = r0.optInt(r13)     // Catch:{ Exception -> 0x033e }
            r11.setTokenRule(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r12 = r0.optString(r12)     // Catch:{ Exception -> 0x033e }
            r11.setEncryptPrice(r12)     // Catch:{ Exception -> 0x033e }
            java.lang.String r12 = "r_index"
            r13 = 0
            int r12 = r0.optInt(r12, r13)     // Catch:{ Exception -> 0x033e }
            r11.setSecondRequestIndex(r12)     // Catch:{ Exception -> 0x033e }
            java.lang.String r12 = "s_show_index"
            int r12 = r0.optInt(r12, r13)     // Catch:{ Exception -> 0x033e }
            r11.setSecondShowIndex(r12)     // Catch:{ Exception -> 0x033e }
            org.json.JSONArray r12 = r0.optJSONArray(r1)     // Catch:{ Exception -> 0x033e }
            java.lang.String r14 = "frames"
            org.json.JSONArray r14 = r0.optJSONArray(r14)     // Catch:{ Exception -> 0x033e }
            java.lang.String r13 = "c_i"
            r15 = r23
            java.lang.String r13 = r0.optString(r13, r15)     // Catch:{ Exception -> 0x033e }
            com.mbridge.msdk.foundation.tools.v r15 = com.mbridge.msdk.foundation.tools.v.a()     // Catch:{ Exception -> 0x033e }
            r15.a(r13)     // Catch:{ Exception -> 0x033e }
            java.lang.String r15 = "web env is not support"
            r16 = r15
            java.lang.String r15 = "end_screen_url"
            if (r14 == 0) goto L_0x0341
            int r23 = r14.length()     // Catch:{ Exception -> 0x033e }
            if (r23 <= 0) goto L_0x0341
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x033e }
            r12.<init>()     // Catch:{ Exception -> 0x033e }
            r23 = r2
            r24 = r11
            r2 = 0
        L_0x01c6:
            int r11 = r14.length()     // Catch:{ Exception -> 0x02c9 }
            if (r2 >= r11) goto L_0x0337
            org.json.JSONObject r11 = r14.optJSONObject(r2)     // Catch:{ Exception -> 0x02c9 }
            r25 = r2
            org.json.JSONArray r2 = r11.getJSONArray(r1)     // Catch:{ Exception -> 0x02c9 }
            r26 = r1
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x02c9 }
            r1.<init>()     // Catch:{ Exception -> 0x02c9 }
            r27 = r5
            r28 = r11
            r5 = 0
        L_0x01e2:
            int r11 = r2.length()     // Catch:{ Exception -> 0x02c9 }
            if (r5 >= r11) goto L_0x02cc
            org.json.JSONObject r11 = r2.optJSONObject(r5)     // Catch:{ Exception -> 0x02c9 }
            r29 = r12
            java.lang.String r12 = r0.optString(r8)     // Catch:{ Exception -> 0x02c9 }
            r30 = r13
            java.lang.String r13 = r0.optString(r9)     // Catch:{ Exception -> 0x02c9 }
            r31 = r14
            java.lang.String r14 = r0.optString(r15)     // Catch:{ Exception -> 0x02c9 }
            r32 = 0
            java.lang.String r18 = r0.optString(r6)     // Catch:{ Exception -> 0x02c9 }
            r33 = r15
            r15 = 0
            r17 = r19
            r19 = r2
            r2 = r21
            r21 = r5
            r5 = r17
            r17 = r36
            r34 = r33
            r33 = r28
            r28 = r9
            r9 = r16
            r16 = r24
            r24 = r6
            r6 = r30
            r30 = r29
            r29 = r8
            r8 = 1
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaign(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x02c6 }
            r13 = r16
            if (r11 == 0) goto L_0x029c
            r11.setNetAddress(r6)     // Catch:{ Exception -> 0x0299 }
            java.lang.String r12 = r13.getIa_url()     // Catch:{ Exception -> 0x0299 }
            r11.setKeyIaUrl(r12)     // Catch:{ Exception -> 0x0299 }
            int r12 = r13.getIa_ori()     // Catch:{ Exception -> 0x0299 }
            r11.setKeyIaOri(r12)     // Catch:{ Exception -> 0x0299 }
            int r12 = r13.getIa_rst()     // Catch:{ Exception -> 0x0299 }
            r11.setKeyIaRst(r12)     // Catch:{ Exception -> 0x0299 }
            java.lang.String r12 = r13.getIa_icon()     // Catch:{ Exception -> 0x0299 }
            r11.setKeyIaIcon(r12)     // Catch:{ Exception -> 0x0299 }
            int r12 = r0.optInt(r3)     // Catch:{ Exception -> 0x0299 }
            r11.setAdType(r12)     // Catch:{ Exception -> 0x0299 }
            java.lang.String r12 = "ia_ext1"
            java.lang.String r12 = r0.optString(r12)     // Catch:{ Exception -> 0x0299 }
            r11.setIa_ext1(r12)     // Catch:{ Exception -> 0x0299 }
            java.lang.String r12 = "ia_ext2"
            java.lang.String r12 = r0.optString(r12)     // Catch:{ Exception -> 0x0299 }
            r11.setIa_ext2(r12)     // Catch:{ Exception -> 0x0299 }
            int r12 = r0.optInt(r7, r8)     // Catch:{ Exception -> 0x0299 }
            r11.setAc_s(r12)     // Catch:{ Exception -> 0x0299 }
            int r12 = r13.getVcn()     // Catch:{ Exception -> 0x0299 }
            r11.setVcn(r12)     // Catch:{ Exception -> 0x0299 }
            int r12 = r13.getTokenRule()     // Catch:{ Exception -> 0x0299 }
            r11.setTokenRule(r12)     // Catch:{ Exception -> 0x0299 }
            java.lang.String r12 = r13.getEncryptPrice()     // Catch:{ Exception -> 0x0299 }
            r11.setEncryptPrice(r12)     // Catch:{ Exception -> 0x0299 }
            r14 = r22
            r11.setMof_tplid(r14)     // Catch:{ Exception -> 0x0299 }
            r11.setMof_template_url(r5)     // Catch:{ Exception -> 0x0299 }
            r11.setNscpt(r2)     // Catch:{ Exception -> 0x0299 }
            r11.setPv_urls(r10)     // Catch:{ Exception -> 0x0299 }
            r15 = r20
            r11.setReq_ext_data(r15)     // Catch:{ Exception -> 0x0299 }
            r1.add(r11)     // Catch:{ Exception -> 0x0299 }
            goto L_0x02a3
        L_0x0299:
            r10 = r13
            goto L_0x03fa
        L_0x029c:
            r15 = r20
            r14 = r22
            r13.setMsg(r9)     // Catch:{ Exception -> 0x0299 }
        L_0x02a3:
            int r11 = r21 + 1
            r8 = r13
            r13 = r6
            r6 = r24
            r24 = r8
            r21 = r2
            r16 = r9
            r22 = r14
            r20 = r15
            r2 = r19
            r9 = r28
            r8 = r29
            r12 = r30
            r14 = r31
            r28 = r33
            r15 = r34
            r19 = r5
            r5 = r11
            goto L_0x01e2
        L_0x02c6:
            r13 = r16
            goto L_0x0299
        L_0x02c9:
            r13 = r24
            goto L_0x0299
        L_0x02cc:
            r2 = r24
            r24 = r6
            r6 = r13
            r13 = r2
            r29 = r8
            r30 = r12
            r31 = r14
            r34 = r15
            r5 = r19
            r15 = r20
            r2 = r21
            r14 = r22
            r33 = r28
            r8 = 1
            r32 = 0
            r28 = r9
            r9 = r16
            com.mbridge.msdk.out.Frame r11 = new com.mbridge.msdk.out.Frame     // Catch:{ Exception -> 0x0299 }
            r11.<init>()     // Catch:{ Exception -> 0x0299 }
            java.lang.String r12 = r0.optString(r4)     // Catch:{ Exception -> 0x0299 }
            r11.setParentSessionId(r12)     // Catch:{ Exception -> 0x0299 }
            r12 = r27
            java.lang.String r8 = r0.optString(r12)     // Catch:{ Exception -> 0x0299 }
            r11.setSessionId(r8)     // Catch:{ Exception -> 0x0299 }
            r11.setCampaigns(r1)     // Catch:{ Exception -> 0x0299 }
            r1 = r23
            r8 = r33
            int r8 = r8.optInt(r1)     // Catch:{ Exception -> 0x0299 }
            r11.setTemplate(r8)     // Catch:{ Exception -> 0x0299 }
            r8 = r30
            r8.add(r11)     // Catch:{ Exception -> 0x0299 }
            int r11 = r25 + 1
            r16 = r13
            r13 = r6
            r6 = r24
            r24 = r16
            r23 = r1
            r21 = r2
            r19 = r5
            r16 = r9
            r2 = r11
            r5 = r12
            r22 = r14
            r20 = r15
            r1 = r26
            r9 = r28
            r14 = r31
            r15 = r34
            r12 = r8
            r8 = r29
            goto L_0x01c6
        L_0x0337:
            r8 = r12
            r13 = r24
            r13.setListFrames(r8)     // Catch:{ Exception -> 0x0299 }
            return r13
        L_0x033e:
            r13 = r11
            goto L_0x0299
        L_0x0341:
            r24 = r6
            r29 = r8
            r28 = r9
            r6 = r13
            r34 = r15
            r9 = r16
            r5 = r19
            r15 = r20
            r2 = r21
            r14 = r22
            r32 = 0
            r13 = r11
            if (r12 == 0) goto L_0x03f5
            int r1 = r12.length()     // Catch:{ Exception -> 0x0299 }
            if (r1 <= 0) goto L_0x03f5
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0299 }
            r1.<init>()     // Catch:{ Exception -> 0x0299 }
            r3 = r32
        L_0x0366:
            int r4 = r12.length()     // Catch:{ Exception -> 0x0299 }
            if (r3 >= r4) goto L_0x03f2
            org.json.JSONObject r11 = r12.optJSONObject(r3)     // Catch:{ Exception -> 0x0299 }
            r8 = r12
            r4 = r29
            java.lang.String r12 = r0.optString(r4)     // Catch:{ Exception -> 0x0299 }
            r17 = r13
            r16 = r15
            r15 = r28
            java.lang.String r13 = r0.optString(r15)     // Catch:{ Exception -> 0x03ee }
            r22 = r14
            r28 = r15
            r15 = r34
            java.lang.String r14 = r0.optString(r15)     // Catch:{ Exception -> 0x03ee }
            r33 = r15
            r15 = r24
            java.lang.String r18 = r0.optString(r15)     // Catch:{ Exception -> 0x03ee }
            r24 = r15
            r15 = 0
            r20 = r3
            r21 = r8
            r3 = r16
            r16 = r17
            r8 = r22
            r17 = r36
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaign(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x02c6 }
            r13 = r16
            if (r11 == 0) goto L_0x03dd
            r11.setNetAddress(r6)     // Catch:{ Exception -> 0x0299 }
            r11.setMof_tplid(r8)     // Catch:{ Exception -> 0x0299 }
            r11.setMof_template_url(r5)     // Catch:{ Exception -> 0x0299 }
            r11.setNscpt(r2)     // Catch:{ Exception -> 0x0299 }
            r11.setPv_urls(r10)     // Catch:{ Exception -> 0x0299 }
            r11.setReq_ext_data(r3)     // Catch:{ Exception -> 0x0299 }
            int r12 = r13.getVcn()     // Catch:{ Exception -> 0x0299 }
            r11.setVcn(r12)     // Catch:{ Exception -> 0x0299 }
            int r12 = r13.getTokenRule()     // Catch:{ Exception -> 0x0299 }
            r11.setTokenRule(r12)     // Catch:{ Exception -> 0x0299 }
            java.lang.String r12 = r13.getEncryptPrice()     // Catch:{ Exception -> 0x0299 }
            r11.setEncryptPrice(r12)     // Catch:{ Exception -> 0x0299 }
            r15 = 1
            int r12 = r0.optInt(r7, r15)     // Catch:{ Exception -> 0x0299 }
            r11.setAc_s(r12)     // Catch:{ Exception -> 0x0299 }
            r1.add(r11)     // Catch:{ Exception -> 0x0299 }
            goto L_0x03e1
        L_0x03dd:
            r15 = 1
            r13.setMsg(r9)     // Catch:{ Exception -> 0x0299 }
        L_0x03e1:
            int r11 = r20 + 1
            r15 = r3
            r29 = r4
            r14 = r8
            r3 = r11
            r12 = r21
            r34 = r33
            goto L_0x0366
        L_0x03ee:
            r13 = r17
            goto L_0x0299
        L_0x03f2:
            r13.setAds(r1)     // Catch:{ Exception -> 0x0299 }
        L_0x03f5:
            return r13
        L_0x03f6:
            r16 = 0
            r10 = r16
        L_0x03fa:
            return r10
        L_0x03fb:
            r16 = 0
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.entity.b.parseCampaignUnit(org.json.JSONObject, java.lang.String):com.mbridge.msdk.foundation.entity.CampaignUnit");
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject, String str) {
        return parseCampaignUnit(jSONObject, str);
    }
}
