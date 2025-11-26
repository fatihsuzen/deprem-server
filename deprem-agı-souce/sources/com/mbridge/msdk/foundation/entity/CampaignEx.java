package com.mbridge.msdk.foundation.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CampaignEx extends DomainCampaignEx implements NoProGuard, Serializable {
    public static final int CAMPAIN_NV_T2_VALUE_3 = 3;
    public static final int CAMPAIN_NV_T2_VALUE_4 = 4;
    public static final String CLICKMODE_ON = "5";
    public static final int CLICK_TIMEOUT_INTERVAL_DEFAULT_VALUE = 2;
    public static final int C_UA_DEFAULT_VALUE = 1;
    private static final int DEFAULT_READY_RATE = 100;
    public static final String ENDCARD_URL = "endcard_url";
    public static final int FLAG_DEFAULT_SPARE_OFFER = -1;
    public static final int FLAG_IS_SPARE_OFFER = 1;
    public static final int FLAG_NOT_SPARE_OFFER = 0;
    public static final int IMP_UA_DEFAULT_VALUE = 1;
    public static final int IV_RV_DEFAULT_PROGRESS_BAR_SHOW_STATE = 0;
    public static final int IV_RV_DEFAULT_USE_SKIP_TIME = 0;
    public static final String JSON_AD_IMP_KEY = "sec";
    public static final String JSON_AD_IMP_VALUE = "url";
    public static final String JSON_KEY_AAB = "aab";
    public static final String JSON_KEY_ADVIMP = "adv_imp";
    public static final String JSON_KEY_AD_AKS = "aks";
    public static final String JSON_KEY_AD_AL = "al";
    public static final String JSON_KEY_AD_HTML = "ad_html";
    public static final String JSON_KEY_AD_K = "k";
    public static final String JSON_KEY_AD_MP = "mp";
    public static final String JSON_KEY_AD_Q = "q";
    public static final String JSON_KEY_AD_R = "r";
    public static final String JSON_KEY_AD_SOURCE_ID = "ad_source_id";
    public static final String JSON_KEY_AD_TMP_IDS = "tmp_ids";
    public static final String JSON_KEY_AD_TRACKING_DROPOUT_TRACK = "dropout_track";
    public static final String JSON_KEY_AD_TRACKING_IMPRESSION_T2 = "impression_t2";
    public static final String JSON_KEY_AD_TRACKING_PLYCMPT_TRACK = "plycmpt_track";
    public static final String JSON_KEY_AD_URL_LIST = "ad_url_list";
    public static final String JSON_KEY_AD_ZIP = "ad_tpl_url";
    public static final String JSON_KEY_APP_SIZE = "app_size";
    public static final String JSON_KEY_AUTO_SHOW_MINI_CARD = "auto_mc";
    public static final String JSON_KEY_BANNER_HTML = "banner_html";
    public static final String JSON_KEY_BANNER_URL = "banner_url";
    public static final String JSON_KEY_BTY = "ctype";
    public static final String JSON_KEY_CAMPAIGN_UNITID = "unitId";
    public static final String JSON_KEY_CLICK_INTERVAL = "c_ct";
    public static final String JSON_KEY_CLICK_MODE = "click_mode";
    public static final String JSON_KEY_CLICK_TIMEOUT_INTERVAL = "c_toi";
    public static final String JSON_KEY_CLICK_URL = "click_url";
    public static final String JSON_KEY_CREATIVE_ID = "creative_id";
    public static final String JSON_KEY_CTA_TEXT = "ctatext";
    public static final String JSON_KEY_C_C_TIME = "c_c_time";
    public static final String JSON_KEY_C_UA = "c_ua";
    public static final String JSON_KEY_DEEP_LINK_URL = "deep_link";
    public static final String JSON_KEY_DESC = "desc";
    public static final String JSON_KEY_ECPPV = "encrypt_ecppv";
    public static final String JSON_KEY_EC_CREATIVE_ID = "ec_crtv_id";
    public static final String JSON_KEY_EC_TEMP_ID = "ec_temp_id";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_ENDCARD_CLICK = "endcard_click_result";
    public static final String JSON_KEY_EXT_DATA = "ext_data";
    public static final String JSON_KEY_FAC = "fac";
    public static final String JSON_KEY_FCA = "fca";
    public static final String JSON_KEY_FCB = "fcb";
    public static final String JSON_KEY_FLB = "flb";
    public static final String JSON_KEY_FLB_SKIP_TIME = "flb_skiptime";
    public static final String JSON_KEY_GIF_URL = "gif_url";
    public static final String JSON_KEY_GUIDELINES = "guidelines";
    public static final String JSON_KEY_HASMBTPLMARK = "hasMBTplMark";
    public static final String JSON_KEY_HB = "hb";
    public static final String JSON_KEY_ICON_URL = "icon_url";
    public static final String JSON_KEY_ID = "id";
    public static final String JSON_KEY_IMAGE_SIZE = "image_size";
    public static final String JSON_KEY_IMAGE_URL = "image_url";
    public static final String JSON_KEY_IMPRESSION_URL = "impression_url";
    public static final String JSON_KEY_IMP_REPORT_TYPE = "imp_report_type";
    public static final String JSON_KEY_IMP_UA = "imp_ua";
    public static final String JSON_KEY_JM_PD = "jm_pd";
    public static final String JSON_KEY_LANDING_TYPE = "landing_type";
    public static final String JSON_KEY_LINK_TYPE = "link_type";
    public static final String JSON_KEY_LOCAL_REQUEST_ID = "local_rid";
    public static final String JSON_KEY_MAITVE = "maitve";
    public static final String JSON_KEY_MAITVESRC = "maitve_src";
    public static final String JSON_KEY_MRAID = "mraid";
    public static final String JSON_KEY_MRAIDFORH5 = "mraid_src";
    public static final String JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T = "adspace_t";
    public static final String JSON_KEY_NEW_INTERSTITIAL_CBD = "cbd";
    public static final String JSON_KEY_NEW_INTERSTITIAL_VST = "vst";
    public static final String JSON_KEY_NOTICE_URL = "notice_url";
    public static final String JSON_KEY_NUMBER_RATING = "number_rating";
    public static final String JSON_KEY_NV_T2 = "nv_t2";
    public static final String JSON_KEY_OFFER_TYPE = "offer_type";
    public static final String JSON_KEY_PACKAGE_NAME = "package_name";
    public static final String JSON_KEY_PLCT = "plct";
    public static final String JSON_KEY_PLCTB = "plctb";
    public static final String JSON_KEY_PRIVACY_URL = "privacy_url";
    public static final String JSON_KEY_PROG_BAR = "prog_bar";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_READY_RATE = "ready_rate";
    public static final String JSON_KEY_RETARGET_OFFER = "retarget_offer";
    public static final String JSON_KEY_RETARGET_TYPE = "rtins_type";
    public static final String JSON_KEY_REWARD_AMOUNT = "reward_amount";
    public static final String JSON_KEY_REWARD_NAME = "reward_name";
    public static final String JSON_KEY_REWARD_PLUS = "rw_pl";
    public static final String JSON_KEY_REWARD_TEMPLATE = "rv";
    public static final String JSON_KEY_REWARD_VIDEO_MD5 = "md5_file";
    public static final String JSON_KEY_RS_IGNORE_CHECK_RULE = "rs_ignc_r";
    public static final String JSON_KEY_SHOW_MINI_CARD_DELAY_TIME = "mc_trig_t";
    public static final String JSON_KEY_STAR = "rating";
    public static final String JSON_KEY_ST_IEX = "iex";
    public static final String JSON_KEY_ST_TS = "ts";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TIMESTAMP = "timestamp";
    public static final String JSON_KEY_TITLE = "title";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_TP_OFFER = "tp_offer";
    public static final String JSON_KEY_T_IMP = "t_imp";
    public static final String JSON_KEY_USER_ACTIVATION = "user_activation";
    public static final String JSON_KEY_USE_SKIP_TIME = "use_skip_time";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String JSON_KEY_VIDEO_CHECK_TYPE = "vck_t";
    public static final String JSON_KEY_VIDEO_COMPLETE_TIME = "view_com_time";
    public static final String JSON_KEY_VIDEO_CREATIVE_ID = "vid_crtv_id";
    public static final String JSON_KEY_VIDEO_CTN_TYPE = "vctn_t";
    public static final String JSON_KEY_VIDEO_LENGTHL = "video_length";
    public static final String JSON_KEY_VIDEO_RESOLUTION = "video_resolution";
    public static final String JSON_KEY_VIDEO_SIZE = "video_size";
    public static final String JSON_KEY_VIDEO_URL = "video_url";
    public static final String JSON_KEY_WATCH_MILE = "watch_mile";
    public static final String JSON_KEY_WITHOUT_INSTALL_CHECK = "wtick";
    public static final String JSON_NATIVE_VIDEO_AD_TRACKING = "ad_tracking";
    public static final String JSON_NATIVE_VIDEO_CLICK = "click";
    public static final String JSON_NATIVE_VIDEO_CLOSE = "close";
    public static final String JSON_NATIVE_VIDEO_COMPLETE = "complete";
    public static final String JSON_NATIVE_VIDEO_ENDCARD = "endcard";
    public static final String JSON_NATIVE_VIDEO_ENDCARD_SHOW = "endcard_show";
    public static final String JSON_NATIVE_VIDEO_ERROR = "error";
    public static final String JSON_NATIVE_VIDEO_FIRST_QUARTILE = "first_quartile";
    public static final String JSON_NATIVE_VIDEO_MIDPOINT = "midpoint";
    public static final String JSON_NATIVE_VIDEO_MUTE = "mute";
    public static final String JSON_NATIVE_VIDEO_PAUSE = "pause";
    public static final String JSON_NATIVE_VIDEO_PLAY_PERCENTAGE = "play_percentage";
    public static final String JSON_NATIVE_VIDEO_RESUME = "resume";
    public static final String JSON_NATIVE_VIDEO_START = "start";
    public static final String JSON_NATIVE_VIDEO_THIRD_QUARTILE = "third_quartile";
    public static final String JSON_NATIVE_VIDEO_UNMUTE = "unmute";
    public static final String JSON_NATIVE_VIDEO_VIDEO_CLICK = "video_click";
    public static final String JSON_NATIVE_VIDOE_IMPRESSION = "impression";
    public static final String KEY_ACTIVITY_CHECK_SWITCH = "ac_s";
    public static final String KEY_ACTIVITY_PATH_AND_NAME = "ac";
    public static final String KEY_ADCHOICE = "adchoice";
    public static final String KEY_AD_TYPE = "ad_type";
    public static final String KEY_CLICK_TEMP_SOURCE = "click_temp_source";
    public static final String KEY_EC_TEMP_DISPLAY_TYPE = "ec_temp_display_type";
    public static final String KEY_IA_CACHE = "ia_cache";
    public static final String KEY_IA_EXT1 = "ia_ext1";
    public static final String KEY_IA_EXT2 = "ia_ext2";
    public static final String KEY_IA_ICON = "ia_icon";
    public static final String KEY_IA_ORI = "ia_ori";
    public static final String KEY_IA_RST = "ia_rst";
    public static final String KEY_IA_URL = "ia_url";
    public static final String KEY_IS_CMPT_ENTRY = "cmpt=1";
    public static final String KEY_IS_DOWNLOAD = "is_download_zip";
    public static final String KEY_OC_TIME = "oc_time";
    public static final String KEY_OC_TYPE = "oc_type";
    public static final String KEY_OMID = "omid";
    public static final String KEY_PLAY_TEMP_DISPLAY_TYPE = "play_temp_display_type";
    public static final String KEY_SECOND_REQUEST_CALLBACK_STATE = "i_s_c_t";
    public static final String KEY_SHOW_INDEX = "show_index";
    public static final String KEY_SHOW_TYPE = "show_type";
    public static final String KEY_TRIGGER_CLICK_SOURCE = "trigger_click_source";
    public static final String KEY_T_LIST = "t_list";
    public static final int LANDING_TYPE_VALUE_OPEN_BROWSER = 1;
    public static final int LANDING_TYPE_VALUE_OPEN_GP_BY_PACKAGE = 3;
    public static final int LANDING_TYPE_VALUE_OPEN_WEBVIEW = 2;
    public static final int LINK_TYPE_1 = 1;
    public static final int LINK_TYPE_2 = 2;
    public static final int LINK_TYPE_3 = 3;
    public static final int LINK_TYPE_4 = 4;
    public static final int LINK_TYPE_8 = 8;
    public static final int LINK_TYPE_9 = 9;
    public static final int LINK_TYPE_MINI_PROGRAM = 12;
    public static final int NEW_INTERSTITIAL_DEFAULT_AD_SPACE_T = 1;
    public static final int NEW_INTERSTITIAL_DEFAULT_CBD = -2;
    public static final int NEW_INTERSTITIAL_DEFAULT_VST = -2;
    public static final String PLAYABLE_ADS_WITHOUT_VIDEO = "playable_ads_without_video";
    public static final int PLAYABLE_ADS_WITHOUT_VIDEO_DEFAULT = 1;
    public static final int PLAYABLE_ADS_WITHOUT_VIDEO_ENDCARD = 2;
    public static final String PRIVACY_BUTTON_VIDEO_TEMPLATE_SWITCH = "show_privacy_btn";
    public static final int RETAR_GETING_IS = 1;
    public static final int RETAR_GETING_NOT = 2;
    public static final int RTINS_TYPE_DONE = 1;
    public static final int RTINS_TYPE_NOT_DONE = 2;
    public static final String TAG = "CampaignEx";
    public static final String URL_KEY_EXP_IDS = "exp_ids";
    public static final String VIDEO_END_TYPE = "video_end_type";
    public static final int VIDEO_END_TYPE_BROWSER = 5;
    public static final int VIDEO_END_TYPE_DEFAULT = 2;
    public static final int VIDEO_END_TYPE_FINISH = 1;
    public static final int VIDEO_END_TYPE_NATIVE = 100;
    public static final int VIDEO_END_TYPE_REULSE = 2;
    public static final int VIDEO_END_TYPE_VAST = 3;
    public static final int VIDEO_END_TYPE_WEBVIEW = 4;
    private static final long serialVersionUID = 1;
    private String CMPTEntryUrl;
    private AabEntity aabEntity;
    private String ac = "";
    private int ac_s = 1;
    private String adHtml = "";
    private int adSpaceT;
    private int adType;
    private String adZip = "";
    private String ad_url_list;
    private a adchoice;
    private String advImp;
    private HashMap<String, String> aks;
    private String al;
    private int autoShowStoreMiniCard;
    private String bannerHtml = "";
    private String bannerUrl = "";
    private String bidToken = "";
    private int bty;
    private int cUA = 1;
    private long cVersionCode;
    private int cacheLevel;
    private boolean campaignIsFiltered = false;
    private String campaignUnitId;
    private boolean canStart2C1Anim = false;
    private boolean canStartMoreOfferAnim = false;
    private long candidateCacheTime = 0;
    private int cbd = -2;
    private int cbt;
    private int clickInterval;
    private int clickTempSource = 0;
    private int clickTimeOutInterval = 2;
    private int clickType = 2;
    private String clickURL = "";
    private String click_mode;
    private long creativeId = 0;
    private String deepLinkUrl = "";
    private int dynamicTempCode = 0;
    private long ecCrtvId = 0;
    private long ecTemplateId = 0;
    private String ecppv;
    private String encryptPrice = "";
    private String endScreenUrl;
    private int endcard_click_result;
    private String endcard_url;
    private String expIds;
    private String ext_data;
    private int fac = 0;
    private int fca;
    private int fcb;
    private int filterCallBackState = 0;
    private int flb;
    private int flbSkipTime;
    private String gifUrl;
    private String guidelines;
    private boolean hasMBTplMark;
    private boolean hasReportAdTrackPause = false;
    private String htmlUrl;
    private String ia_ext1;
    private String ia_ext2;
    private int iex;
    private String imageSize = "";
    private int impReportType = 0;
    private int impUA = 1;
    private String impressionURL = "";
    private String interactiveCache;
    private int isAddSuccesful;
    private boolean isBidCampaign;
    private boolean isCallBackImpression = false;
    private boolean isCallbacked;
    private int isClick;
    private int isDeleted;
    private int isDownLoadZip;
    private boolean isDynamicView = false;
    private boolean isECTemplateRenderSucc = true;
    private boolean isMraid;
    private boolean isReady = false;
    private boolean isReport;
    private boolean isReportClick;
    public boolean isRewardPopViewShowed = false;
    private boolean isTemplateRenderSucc = true;
    private int isTimeoutCheckVideoStatus = -1;
    private int jmPd;
    private JumpLoaderResult jumpResult;

    /* renamed from: k  reason: collision with root package name */
    private String f8987k;
    private String keyIaIcon;
    private int keyIaOri;
    private int keyIaRst;
    private String keyIaUrl;
    private String label;
    private String landingType;
    private int linkType;
    private int loadTimeoutState = 0;
    private String localRequestId;
    public boolean mMoreOfferImpShow = false;
    private int maitve;
    private String maitve_src;
    private b mediaViewHolder;
    private String mof_template_url;
    private int mof_tplid;
    private String moreOfferJsonData = "";
    private String mp;
    private String mraid;
    private String n_lrid;
    private String n_rid;
    private j nativeVideoTracking;
    private String nativeVideoTrackingString;
    private String netAddress = "";
    private String noticeUrl = "";
    private int nscpt = 1;
    private int nvT2 = 6;
    private int oc_time;
    private int oc_type = 0;
    private int offerType;
    private String omid = null;
    private String onlyImpressionURL = "";
    private String pkgSource;
    private String placementId;
    private int playable_ads_without_video = 1;
    private long plct = 0;
    private long plctb = 0;
    private int privacyButtonTemplateVisibility = 0;
    private String privacyUrl = "";
    private int progressBarShow;
    private List<String> pv_urls;

    /* renamed from: q  reason: collision with root package name */
    private String f8988q;

    /* renamed from: r  reason: collision with root package name */
    private String f8989r;
    private int readyState = 1;
    private int ready_rate = -1;
    private String reasond;
    private String req_ext_data;
    private String requestId;
    private String requestIdNotice;
    private int retarget_offer;
    private int rewardAmount;
    private int rewardPlayStatus;
    public RewardPlus rewardPlus;
    private c rewardTemplateMode;
    private String reward_name;
    private ArrayList<Integer> rsIgnoreCheckRule;
    private int rtinsType;
    private int showCount;
    private int showIndex = com.mbridge.msdk.foundation.same.report.d.a.f9444a;
    private int showStoreMiniCardDelayTime;
    private int showType = com.mbridge.msdk.foundation.same.report.d.a.f9446c;
    private int spareOfferFlag = -1;
    private int t_imp;
    private String t_list;
    private int tab = -1;
    private int template;
    private int tokenRule = 0;
    private int tpOffer = 0;
    private int trackingTcpPort = 9377;
    private int triggerClickSource = 0;
    private long ts;
    private int typed = -1;
    private int useSkipTime;
    private boolean userActivation = false;
    private int vcn = 0;
    private long vidCrtvId = 0;
    private int videoCheckType = 2;
    private int videoCompleteTime = 0;
    private int videoCtnType = 1;
    public String videoMD5Value = "";
    private int videoPlayProgress = 0;
    private String videoResolution;
    private int videoSize;
    private String videoUrlEncode = "";
    private int video_end_type = 2;
    private int vst = -2;
    private int watchMile;
    private int wtick = 0;

    public static final class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private String f8990a = "";

        /* renamed from: b  reason: collision with root package name */
        private String f8991b = "";

        /* renamed from: c  reason: collision with root package name */
        private String f8992c = "";

        /* renamed from: d  reason: collision with root package name */
        private String f8993d = "";

        /* renamed from: e  reason: collision with root package name */
        private String f8994e = "";

        /* renamed from: f  reason: collision with root package name */
        private int f8995f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f8996g = 0;

        /* renamed from: h  reason: collision with root package name */
        private String f8997h = "";

        /* renamed from: i  reason: collision with root package name */
        private String f8998i = "";

        /* renamed from: j  reason: collision with root package name */
        private String f8999j = "";

        /* renamed from: k  reason: collision with root package name */
        private String f9000k = "";

        public static a a(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return a(new JSONObject(str));
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
                return null;
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
                return null;
            }
        }

        private static int c(String str) {
            String[] split;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (split = str.split("x")) != null && split.length > 1) {
                    return Integer.parseInt(split[1]);
                }
            } catch (Exception | NumberFormatException unused) {
            }
            return 0;
        }

        private static int d(String str) {
            String[] split;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (split = str.split("x")) != null && split.length > 0) {
                    return Integer.parseInt(split[0]);
                }
            } catch (Exception | NumberFormatException unused) {
            }
            return 0;
        }

        public final String b() {
            return this.f8992c;
        }

        public final int e() {
            return this.f8995f;
        }

        public final int f() {
            return this.f8996g;
        }

        public final void b(String str) {
            this.f8993d = str;
        }

        public final String c() {
            return this.f8993d;
        }

        public final String d() {
            return this.f8994e;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0069  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0071  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static com.mbridge.msdk.foundation.entity.CampaignEx.a a(org.json.JSONObject r3) {
            /*
                r0 = 0
                if (r3 == 0) goto L_0x0074
                com.mbridge.msdk.foundation.entity.CampaignEx$a r1 = new com.mbridge.msdk.foundation.entity.CampaignEx$a     // Catch:{ Exception -> 0x0063, all -> 0x0061 }
                r1.<init>()     // Catch:{ Exception -> 0x0063, all -> 0x0061 }
                java.lang.String r0 = "adchoice_icon"
                java.lang.String r0 = r3.optString(r0)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                r1.f8992c = r0     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                java.lang.String r0 = "adchoice_link"
                java.lang.String r0 = r3.optString(r0)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                r1.f8993d = r0     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                java.lang.String r0 = "adchoice_size"
                java.lang.String r0 = r3.optString(r0)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                r1.f8994e = r0     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                java.lang.String r2 = "ad_logo_link"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                r1.f8990a = r2     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                java.lang.String r2 = "adv_logo"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                r1.f8997h = r2     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                java.lang.String r2 = "adv_name"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                r1.f8998i = r2     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                java.lang.String r2 = "platform_logo"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                r1.f8999j = r2     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                java.lang.String r2 = "platform_name"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                r1.f9000k = r2     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                int r2 = c(r0)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                r1.f8995f = r2     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                int r0 = d(r0)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                r1.f8996g = r0     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                r1.f8991b = r3     // Catch:{ Exception -> 0x005e, all -> 0x005b }
                return r1
            L_0x005b:
                r3 = move-exception
                r0 = r1
                goto L_0x0065
            L_0x005e:
                r3 = move-exception
                r0 = r1
                goto L_0x006d
            L_0x0061:
                r3 = move-exception
                goto L_0x0065
            L_0x0063:
                r3 = move-exception
                goto L_0x006d
            L_0x0065:
                boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r1 == 0) goto L_0x0074
                r3.printStackTrace()
                goto L_0x0074
            L_0x006d:
                boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r1 == 0) goto L_0x0074
                r3.printStackTrace()
            L_0x0074:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.entity.CampaignEx.a.a(org.json.JSONObject):com.mbridge.msdk.foundation.entity.CampaignEx$a");
        }

        public final String a() {
            return this.f8991b;
        }
    }

    public static final class b implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public Map<Integer, String> f9001a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f9002b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9003c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9004d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9005e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9006f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f9007g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f9008h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f9009i = false;

        /* renamed from: j  reason: collision with root package name */
        public boolean f9010j = false;

        /* renamed from: k  reason: collision with root package name */
        public boolean f9011k = false;

        /* renamed from: l  reason: collision with root package name */
        public boolean f9012l = false;
    }

    public static final class c implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private List<a> f9013a;

        /* renamed from: b  reason: collision with root package name */
        private int f9014b;

        /* renamed from: c  reason: collision with root package name */
        private String f9015c;

        /* renamed from: d  reason: collision with root package name */
        private String f9016d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public String f9017e;

        /* renamed from: f  reason: collision with root package name */
        private int f9018f;

        public static final class a implements Serializable {

            /* renamed from: a  reason: collision with root package name */
            public List<String> f9019a = new ArrayList();

            /* renamed from: b  reason: collision with root package name */
            public String f9020b;
        }

        private c(String str) {
            this.f9016d = str;
        }

        public final int b() {
            return this.f9014b;
        }

        public final String c() {
            return this.f9015c;
        }

        public final String d() {
            return this.f9016d;
        }

        public final String e() {
            return this.f9017e;
        }

        public final int f() {
            return this.f9018f;
        }

        public static c a(String str) {
            try {
                if (ap.b(str)) {
                    return a(new JSONObject(str));
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final void b(String str) {
            this.f9017e = str;
        }

        public static c a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                if (!ap.b(jSONObject.toString())) {
                    return null;
                }
                c cVar = new c(jSONObject.toString());
                cVar.f9018f = jSONObject.optInt("video_template", 1);
                cVar.f9017e = jSONObject.optString("template_url");
                cVar.f9014b = jSONObject.optInt("orientation");
                cVar.f9015c = jSONObject.optString("paused_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("image");
                if (optJSONObject != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        List<String> b5 = ak.b(optJSONObject.optJSONArray(next));
                        if (b5 != null && b5.size() > 0) {
                            a aVar = new a();
                            aVar.f9020b = next;
                            aVar.f9019a.addAll(b5);
                            arrayList.add(aVar);
                        }
                    }
                    cVar.f9013a = arrayList;
                }
                return cVar;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final List<a> a() {
            return this.f9013a;
        }
    }

    public static j TrackingStr2Object(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                j jVar = new j();
                jVar.o(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDOE_IMPRESSION)));
                jVar.d(processNativeVideoTrackingArray(jSONObject.optJSONArray("start")));
                jVar.e(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_FIRST_QUARTILE)));
                jVar.f(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_MIDPOINT)));
                jVar.g(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_THIRD_QUARTILE)));
                jVar.h(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_COMPLETE)));
                jVar.a(parsePlayCentage(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_PLAY_PERCENTAGE)));
                jVar.i(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_MUTE)));
                jVar.j(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_UNMUTE)));
                jVar.k(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_CLICK)));
                jVar.l(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_PAUSE)));
                jVar.m(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_RESUME)));
                jVar.n(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ERROR)));
                jVar.p(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ENDCARD)));
                jVar.r(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_CLOSE)));
                jVar.q(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ENDCARD_SHOW)));
                jVar.s(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_VIDEO_CLICK)));
                jVar.c(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_IMPRESSION_T2)));
                jVar.a(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_DROPOUT_TRACK)));
                jVar.b(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_PLYCMPT_TRACK)));
                return DomainCampaignEx.trackingStr2Object(jSONObject, jVar);
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    public static JSONObject campaignToJsonObject(CampaignEx campaignEx, boolean z4, boolean z5) throws JSONException {
        JSONObject campaignToJsonObject = campaignToJsonObject(campaignEx);
        campaignToJsonObject.put("isReady", z4);
        campaignToJsonObject.put("expired", z5);
        return campaignToJsonObject;
    }

    private void checkAndReSetDynamicViewState(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.mof_template_url) || !this.isDynamicView) {
                boolean i5 = ak.i(str);
                int b5 = ak.b(str);
                if (i5) {
                    setDynamicView(true);
                    setDynamicTempCode(b5);
                }
            }
        }
    }

    private static JSONObject dealV5Temp(JSONObject jSONObject) {
        JSONArray optJSONArray;
        try {
            if (jSONObject.has(JSON_KEY_AD_TMP_IDS) && (optJSONArray = jSONObject.optJSONArray(JSON_KEY_AD_TMP_IDS)) != null && optJSONArray.length() > 0) {
                jSONObject.remove(JSON_KEY_AD_TMP_IDS);
                for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                    JSONObject a5 = com.mbridge.msdk.foundation.db.a.b.a().a(optJSONArray.getString(i5));
                    if (a5 != null) {
                        Iterator<String> keys = a5.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject.put(next, a5.opt(next));
                        }
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private Map<Integer, String> generateAdImpression(String str) {
        HashMap hashMap = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    HashMap hashMap2 = new HashMap();
                    int i5 = 0;
                    while (i5 < jSONArray.length()) {
                        try {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                            int optInt = optJSONObject.optInt(JSON_AD_IMP_KEY);
                            hashMap2.put(Integer.valueOf(optInt), optJSONObject.optString("url"));
                            i5++;
                        } catch (Exception e5) {
                            e = e5;
                            hashMap = hashMap2;
                            e.printStackTrace();
                            return hashMap;
                        }
                    }
                    return hashMap2;
                }
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
                return hashMap;
            }
        }
        return hashMap;
    }

    private static boolean isBreakCampainOrSetItByEndCard(CampaignEx campaignEx, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.mbridge.msdk.foundation.controller.c.m().j() == 2 && "1".equals(Uri.parse(str).getQueryParameter("dpwgl"))) {
            return true;
        }
        campaignEx.setendcard_url(str);
        return false;
    }

    public static String object2TrackingStr(j jVar) {
        if (jVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (jVar.p() != null) {
                    jSONObject.put(JSON_NATIVE_VIDOE_IMPRESSION, processNativeVideoTrackingArray2Json(jVar.p()));
                }
                if (jVar.d() != null) {
                    jSONObject.put("start", processNativeVideoTrackingArray2Json(jVar.d()));
                }
                if (jVar.e() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_FIRST_QUARTILE, processNativeVideoTrackingArray2Json(jVar.e()));
                }
                if (jVar.f() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_MIDPOINT, processNativeVideoTrackingArray2Json(jVar.f()));
                }
                if (jVar.g() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_THIRD_QUARTILE, processNativeVideoTrackingArray2Json(jVar.g()));
                }
                if (jVar.h() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_COMPLETE, processNativeVideoTrackingArray2Json(jVar.h()));
                }
                if (jVar.i() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_PLAY_PERCENTAGE, reparsePlayCentage(jVar.i()));
                }
                if (jVar.j() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_MUTE, processNativeVideoTrackingArray2Json(jVar.j()));
                }
                if (jVar.k() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_UNMUTE, processNativeVideoTrackingArray2Json(jVar.k()));
                }
                if (jVar.l() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_CLICK, processNativeVideoTrackingArray2Json(jVar.l()));
                }
                if (jVar.m() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_PAUSE, processNativeVideoTrackingArray2Json(jVar.m()));
                }
                if (jVar.n() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_RESUME, processNativeVideoTrackingArray2Json(jVar.n()));
                }
                if (jVar.o() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_ERROR, processNativeVideoTrackingArray2Json(jVar.o()));
                }
                if (jVar.q() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_ENDCARD, processNativeVideoTrackingArray2Json(jVar.q()));
                }
                if (jVar.s() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_CLOSE, processNativeVideoTrackingArray2Json(jVar.s()));
                }
                if (jVar.r() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_ENDCARD_SHOW, processNativeVideoTrackingArray2Json(jVar.r()));
                }
                if (jVar.t() != null) {
                    jSONObject.put(JSON_NATIVE_VIDEO_VIDEO_CLICK, processNativeVideoTrackingArray2Json(jVar.q()));
                }
                if (jVar.c() != null) {
                    jSONObject.put(JSON_KEY_AD_TRACKING_IMPRESSION_T2, processNativeVideoTrackingArray2Json(jVar.c()));
                }
                if (jVar.a() != null) {
                    jSONObject.put(JSON_KEY_AD_TRACKING_DROPOUT_TRACK, processNativeVideoTrackingArray2Json(jVar.a()));
                }
                if (jVar.b() != null) {
                    jSONObject.put(JSON_KEY_AD_TRACKING_PLYCMPT_TRACK, processNativeVideoTrackingArray2Json(jVar.b()));
                }
                JSONObject object2TrackingStr = DomainCampaignEx.object2TrackingStr(jSONObject, jVar);
                if (object2TrackingStr == null) {
                    return "";
                }
                return object2TrackingStr.toString();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return "";
    }

    public static CampaignEx parseCampaign(JSONObject jSONObject, String str, String str2, String str3, boolean z4, CampaignUnit campaignUnit) {
        return parseCampaign(jSONObject, str, str2, str3, z4, campaignUnit, "", "");
    }

    public static CampaignEx parseCampaignWithBackData(JSONObject jSONObject) {
        CampaignEx campaignEx;
        String str;
        ArrayList arrayList;
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null) {
            return null;
        }
        try {
            CampaignEx campaignEx2 = new CampaignEx();
            try {
                campaignEx2.setId(jSONObject2.optString("id"));
                campaignEx2.setAppName(jSONObject2.optString(JSON_KEY_TITLE));
                campaignEx2.setAppDesc(jSONObject2.optString(JSON_KEY_DESC));
                campaignEx2.setPackageName(jSONObject2.optString(JSON_KEY_PACKAGE_NAME));
                campaignEx2.setRtinsType(jSONObject2.optInt(JSON_KEY_RETARGET_TYPE));
                campaignEx2.setIconUrl(jSONObject2.optString(JSON_KEY_ICON_URL));
                campaignEx2.setImageUrl(jSONObject2.optString(JSON_KEY_IMAGE_URL));
                campaignEx2.setSize(jSONObject2.optString(JSON_KEY_APP_SIZE));
                campaignEx2.setImageSize(jSONObject2.optString(JSON_KEY_IMAGE_SIZE));
                campaignEx2.setImpressionURL(jSONObject2.optString(JSON_KEY_IMPRESSION_URL));
                campaignEx2.setClickURL(jSONObject2.optString(JSON_KEY_CLICK_URL));
                campaignEx2.setRewardPlus(RewardPlus.parseByString(jSONObject2.optString(JSON_KEY_REWARD_PLUS)));
                campaignEx2.setWtick(jSONObject2.optInt(JSON_KEY_WITHOUT_INSTALL_CHECK));
                campaignEx2.setDeepLinkUrl(jSONObject2.optString(JSON_KEY_DEEP_LINK_URL));
                campaignEx2.setUserActivation(jSONObject2.optBoolean(JSON_KEY_USER_ACTIVATION, false));
                campaignEx2.setNoticeUrl(jSONObject2.optString(JSON_KEY_NOTICE_URL));
                campaignEx2.setTemplate(jSONObject2.optInt("template"));
                campaignEx2.setType(jSONObject2.optInt(JSON_KEY_AD_SOURCE_ID, 1));
                campaignEx2.setFca(jSONObject2.optInt(JSON_KEY_FCA));
                campaignEx2.setFcb(jSONObject2.optInt(JSON_KEY_FCB));
                campaignEx2.setEndcard_click_result(jSONObject2.optInt(JSON_KEY_ENDCARD_CLICK));
                if (!TextUtils.isEmpty(jSONObject2.optString(JSON_KEY_STAR))) {
                    String optString = jSONObject2.optString(JSON_KEY_STAR, "0");
                    str = JSON_KEY_NOTICE_URL;
                    campaignEx2.setRating(Double.parseDouble(optString));
                } else {
                    str = JSON_KEY_NOTICE_URL;
                }
                if (!TextUtils.isEmpty(jSONObject2.optString(JSON_KEY_NUMBER_RATING))) {
                    campaignEx2.setNumberRating(jSONObject2.optInt(JSON_KEY_NUMBER_RATING, 333333));
                }
                campaignEx2.setClick_mode(jSONObject2.optString(JSON_KEY_CLICK_MODE));
                campaignEx2.setLandingType(jSONObject2.optString(JSON_KEY_LANDING_TYPE));
                campaignEx2.setLinkType(jSONObject2.optInt(JSON_KEY_LINK_TYPE, 4));
                campaignEx2.setClickInterval(jSONObject2.optInt(JSON_KEY_CLICK_INTERVAL));
                campaignEx2.setAdCall(jSONObject2.optString(JSON_KEY_CTA_TEXT));
                campaignEx2.setAd_url_list(jSONObject2.optString(JSON_KEY_AD_URL_LIST));
                campaignEx2.setRetarget_offer(jSONObject2.optInt(JSON_KEY_RETARGET_OFFER, 2));
                campaignEx2.setVideoUrlEncode(jSONObject2.optString(JSON_KEY_VIDEO_URL));
                campaignEx2.setVideoLength(jSONObject2.optInt(JSON_KEY_VIDEO_LENGTHL));
                campaignEx2.setVideoSize(jSONObject2.optInt(JSON_KEY_VIDEO_SIZE));
                campaignEx2.setVideoResolution(jSONObject2.optString(JSON_KEY_VIDEO_RESOLUTION));
                campaignEx2.setWatchMile(jSONObject2.optInt(JSON_KEY_WATCH_MILE));
                campaignEx2.setTimestamp(System.currentTimeMillis());
                campaignEx2.setBty(jSONObject2.optInt(JSON_KEY_BTY));
                campaignEx2.setAdvImp(jSONObject2.optString(JSON_KEY_ADVIMP));
                campaignEx2.setTImp(jSONObject2.optInt(JSON_KEY_T_IMP));
                campaignEx2.setHtmlUrl(jSONObject2.optString(b.JSON_KEY_HTML_URL));
                campaignEx2.setEndScreenUrl(jSONObject2.optString(b.JSON_KEY_END_SCREEN_URL));
                campaignEx2.setGuidelines(jSONObject2.optString(JSON_KEY_GUIDELINES));
                campaignEx2.setOfferType(jSONObject2.optInt(JSON_KEY_OFFER_TYPE));
                campaignEx2.setRewardName(jSONObject2.optString(JSON_KEY_REWARD_NAME));
                campaignEx2.setRewardAmount(jSONObject2.optInt(JSON_KEY_REWARD_AMOUNT));
                try {
                    if (jSONObject2.has(JSON_NATIVE_VIDEO_AD_TRACKING)) {
                        String optString2 = jSONObject2.optString(JSON_NATIVE_VIDEO_AD_TRACKING);
                        if (!TextUtils.isEmpty(optString2)) {
                            campaignEx2.setNativeVideoTrackingString(optString2);
                            campaignEx2.setNativeVideoTracking(TrackingStr2Object(optString2));
                        }
                    }
                } catch (Exception unused) {
                }
                try {
                    campaignEx2.setReady_rate(jSONObject2.optInt(JSON_KEY_READY_RATE, -1));
                    JSONObject optJSONObject = jSONObject2.optJSONObject(JSON_KEY_EXT_DATA);
                    if (optJSONObject != null) {
                        campaignEx2.setExt_data(optJSONObject.toString());
                    } else {
                        String optString3 = jSONObject2.optString(JSON_KEY_EXT_DATA);
                        if (!TextUtils.isEmpty(optString3)) {
                            campaignEx2.setExt_data(optString3);
                        }
                    }
                    campaignEx2.setMof_tplid(jSONObject2.optInt(b.JSON_KEY_MOF_TPLID));
                    campaignEx2.setMof_template_url(jSONObject2.optString(b.JSON_KEY_MOF_TEMPLATE_URL));
                    campaignEx2.setNscpt(jSONObject2.optInt(b.JSON_KEY_NSCPT));
                    new JSONArray();
                    JSONArray optJSONArray = jSONObject2.optJSONArray("pv_urls");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(optJSONArray.length());
                        for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                            arrayList.add(optJSONArray.optString(i5));
                        }
                    }
                    campaignEx2.setPv_urls(arrayList);
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject(b.JSON_KEY_REQ_EXT_DATA);
                    if (optJSONObject2 != null) {
                        campaignEx2.setReq_ext_data(optJSONObject2.toString());
                    }
                } catch (Exception unused2) {
                }
                campaignEx2.setVideo_end_type(jSONObject2.optInt(VIDEO_END_TYPE, 2));
                if (isBreakCampainOrSetItByEndCard(campaignEx2, jSONObject2.optString(ENDCARD_URL))) {
                    return null;
                }
                campaignEx2.setPlayable_ads_without_video(jSONObject2.optInt(PLAYABLE_ADS_WITHOUT_VIDEO, 1));
                campaignEx2.setVideoMD5Value("");
                if (jSONObject2.has(JSON_KEY_NV_T2)) {
                    campaignEx2.setNvT2(jSONObject2.optInt(JSON_KEY_NV_T2));
                }
                if (jSONObject2.has(JSON_KEY_GIF_URL)) {
                    campaignEx2.setGifUrl(jSONObject2.optString(JSON_KEY_GIF_URL));
                }
                try {
                    JSONObject optJSONObject3 = jSONObject2.optJSONObject(JSON_KEY_REWARD_TEMPLATE);
                    if (optJSONObject3 != null) {
                        campaignEx2.setRewardTemplateMode(c.a(optJSONObject3));
                    } else {
                        String optString4 = jSONObject2.optString(JSON_KEY_REWARD_TEMPLATE);
                        if (!TextUtils.isEmpty(optString4)) {
                            campaignEx2.setRewardTemplateMode(c.a(new JSONObject(optString4)));
                        }
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
                campaignEx2.setClickTimeOutInterval(jSONObject2.optInt(JSON_KEY_CLICK_TIMEOUT_INTERVAL, 2));
                campaignEx2.setImpUA(jSONObject2.optInt(JSON_KEY_IMP_UA, 1));
                campaignEx2.setcUA(jSONObject2.optInt(JSON_KEY_C_UA, 1));
                campaignEx2.setJmPd(jSONObject2.optInt(JSON_KEY_JM_PD));
                campaignEx2.setKeyIaIcon(jSONObject2.optString("ia_icon"));
                campaignEx2.setKeyIaRst(jSONObject2.optInt("ia_rst"));
                campaignEx2.setKeyIaUrl(jSONObject2.optString("ia_url"));
                campaignEx2.setKeyIaOri(jSONObject2.optInt("ia_ori"));
                campaignEx2.setAdType(jSONObject2.optInt("ad_type"));
                campaignEx2.setTpOffer(jSONObject2.optInt(JSON_KEY_TP_OFFER));
                campaignEx2.setFac(jSONObject2.optInt(JSON_KEY_FAC));
                campaignEx2.setIa_ext1(jSONObject2.optString(KEY_IA_EXT1));
                campaignEx2.setIa_ext2(jSONObject2.optString(KEY_IA_EXT2));
                campaignEx2.setIsDownLoadZip(jSONObject2.optInt(KEY_IS_DOWNLOAD));
                campaignEx2.setInteractiveCache(jSONObject2.optString(KEY_IA_CACHE));
                campaignEx2.setOc_time(jSONObject2.optInt(KEY_OC_TIME));
                campaignEx2.setOc_type(jSONObject2.optInt(KEY_OC_TYPE));
                campaignEx2.setT_list(jSONObject2.optString(KEY_T_LIST));
                campaignEx2.setAdchoice(a.a(jSONObject2.optString(KEY_ADCHOICE, "")));
                campaignEx2.setPlct(jSONObject2.optLong(JSON_KEY_PLCT));
                campaignEx2.setPlctb(jSONObject2.optLong(JSON_KEY_PLCTB));
                campaignEx2.setCandidateCacheTime(jSONObject2.optLong(JSON_KEY_C_C_TIME));
                JSONArray optJSONArray2 = jSONObject2.optJSONArray(KEY_OMID);
                if (optJSONArray2 != null) {
                    campaignEx2.setOmid(optJSONArray2.toString());
                } else if (!TextUtils.isEmpty(jSONObject2.optString(KEY_OMID))) {
                    campaignEx2.setOmid(jSONObject2.optString(KEY_OMID));
                } else {
                    campaignEx2.setOmid((String) null);
                }
                campaignEx2.setCreativeId(jSONObject2.optLong(JSON_KEY_CREATIVE_ID));
                campaignEx2.setVidCrtvId(jSONObject2.optLong(JSON_KEY_VIDEO_CREATIVE_ID));
                campaignEx2.setEcCrtvId(jSONObject2.optLong(JSON_KEY_EC_CREATIVE_ID));
                campaignEx2.setEcTemplateId(jSONObject2.optLong(JSON_KEY_EC_TEMP_ID));
                campaignEx2.setLocalRequestId(jSONObject2.optString(JSON_KEY_LOCAL_REQUEST_ID, ""));
                String optString5 = jSONObject2.optString("cam_tpl_url");
                Uri parse = Uri.parse(optString5);
                if (TextUtils.isEmpty(parse.getPath()) || (!parse.getPath().endsWith(".zip") && !parse.getPath().endsWith(".ZIP"))) {
                    campaignEx2.setBannerUrl(optString5);
                } else {
                    campaignEx2.setAdZip(optString5);
                }
                campaignEx2.setBannerHtml(jSONObject2.optString("cam_html"));
                campaignEx2.setAdHtml(jSONObject2.optString("cam_html"));
                campaignEx2.setCampaignUnitId(jSONObject2.optString(JSON_KEY_CAMPAIGN_UNITID));
                String optString6 = jSONObject2.optString(JSON_KEY_MRAID);
                if (TextUtils.isEmpty(optString6)) {
                    optString6 = jSONObject2.optString(JSON_KEY_MRAIDFORH5);
                }
                if (!TextUtils.isEmpty(optString6)) {
                    campaignEx2.setIsMraid(true);
                    campaignEx2.setMraid(optString6);
                } else if (TextUtils.isEmpty(campaignEx2.getAdHtml()) || campaignEx2.getAdHtml().contains("<MBTPLMARK>")) {
                    campaignEx2.setIsMraid(false);
                } else {
                    campaignEx2.setIsMraid(true);
                }
                campaignEx2.setNetAddress(jSONObject2.optString(b.JSON_KEY_C_I));
                try {
                    String optString7 = jSONObject2.optString(b.JSON_KEY_ONLY_IMPRESSION_URL);
                    if (!TextUtils.isEmpty(optString7)) {
                        campaignEx2.setOnlyImpressionURL(optString7);
                        Uri parse2 = Uri.parse(optString7);
                        if (parse2 != null) {
                            campaignEx2.setRequestId(parse2.getQueryParameter(JSON_KEY_AD_K));
                        }
                    }
                    String optString8 = jSONObject2.optString(str);
                    if (!TextUtils.isEmpty(optString8)) {
                        campaignEx2.setNoticeUrl(optString8);
                        Uri parse3 = Uri.parse(optString8);
                        if (parse3 != null) {
                            campaignEx2.setRequestIdNotice(parse3.getQueryParameter(JSON_KEY_AD_K));
                        }
                    }
                    try {
                        String optString9 = jSONObject2.optString(JSON_KEY_ECPPV);
                        if (!TextUtils.isEmpty(optString9)) {
                            campaignEx2.setEcppv(optString9);
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    campaignEx2.setAc_s(jSONObject2.optInt(KEY_ACTIVITY_CHECK_SWITCH, 1));
                } catch (Exception unused3) {
                }
                campaignEx2.setIsBidCampaign(jSONObject2.optBoolean(JSON_KEY_HB, false));
                campaignEx2.setPlacementId(jSONObject2.optString(MBridgeConstans.PLACEMENT_ID));
                campaignEx2.setMaitve(jSONObject2.optInt(JSON_KEY_MAITVE));
                campaignEx2.setMaitve_src(jSONObject2.optString(JSON_KEY_MAITVESRC));
                campaignEx2.setFlb(jSONObject2.optInt(JSON_KEY_FLB));
                campaignEx2.setFlbSkipTime(jSONObject2.optInt(JSON_KEY_FLB_SKIP_TIME));
                campaignEx2.setCbd(jSONObject2.optInt(JSON_KEY_NEW_INTERSTITIAL_CBD, -2));
                campaignEx2.setVst(jSONObject2.optInt(JSON_KEY_NEW_INTERSTITIAL_VST, -2));
                campaignEx2.setUseSkipTime(jSONObject2.optInt(JSON_KEY_USE_SKIP_TIME, 0));
                campaignEx2.setProgressBarShow(jSONObject2.optInt(JSON_KEY_PROG_BAR, 0));
                campaignEx2.setAdSpaceT(jSONObject2.optInt(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, 1));
                CampaignEx parseCampaignWithBackData = DomainCampaignEx.parseCampaignWithBackData(jSONObject2, campaignEx2);
                try {
                    parseCampaignWithBackData.setVcn(jSONObject2.optInt("vcn"));
                    parseCampaignWithBackData.setTokenRule(jSONObject2.optInt("token_r"));
                    parseCampaignWithBackData.setEncryptPrice(jSONObject2.optString("encrypt_p"));
                    parseCampaignWithBackData.setVideoCompleteTime(jSONObject2.optInt(JSON_KEY_VIDEO_COMPLETE_TIME));
                    parseCampaignWithBackData.setVideoCheckType(jSONObject2.optInt(JSON_KEY_VIDEO_CHECK_TYPE, 2));
                    parseCampaignWithBackData.setVideoCtnType(jSONObject2.optInt(JSON_KEY_VIDEO_CTN_TYPE, 1));
                    JSONArray optJSONArray3 = jSONObject2.optJSONArray(JSON_KEY_RS_IGNORE_CHECK_RULE);
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                            arrayList2.add(Integer.valueOf(optJSONArray3.optInt(i6)));
                        }
                        if (arrayList2.size() > 0) {
                            parseCampaignWithBackData.setRsIgnoreCheckRule(arrayList2);
                        }
                    }
                    if (jSONObject2.has(JSON_KEY_AAB)) {
                        parseCampaignWithBackData.setAabEntity(AabEntity.parser(jSONObject2.getString(JSON_KEY_AAB)));
                    }
                    try {
                        parseCampaignWithBackData.setPrivacyUrl(jSONObject2.optString(JSON_KEY_PRIVACY_URL, ""));
                        parseCampaignWithBackData.setPrivacyButtonTemplateVisibility(jSONObject2.optInt(PRIVACY_BUTTON_VIDEO_TEMPLATE_SWITCH, 0));
                    } catch (Exception e7) {
                        af.b("campaign", e7.getMessage());
                    }
                    parseCampaignWithBackData.setImpReportType(jSONObject2.optInt(JSON_KEY_IMP_REPORT_TYPE, 0));
                    parseCampaignWithBackData.setTrackingTcpPort(jSONObject2.optInt(b.JSON_KEY_TK_TCP_PORT, 9377));
                    parseCampaignWithBackData.setAutoShowStoreMiniCard(jSONObject2.optInt(JSON_KEY_AUTO_SHOW_MINI_CARD, 0));
                    parseCampaignWithBackData.setShowStoreMiniCardDelayTime(jSONObject2.optInt(JSON_KEY_SHOW_MINI_CARD_DELAY_TIME, 0));
                    parseCampaignWithBackData.setShowIndex(jSONObject2.optInt(KEY_SHOW_INDEX, 1));
                    parseCampaignWithBackData.setShowType(jSONObject2.optInt(KEY_SHOW_TYPE, 1));
                    parseCampaignWithBackData.setClickTempSource(jSONObject2.optInt(KEY_CLICK_TEMP_SOURCE));
                    parseCampaignWithBackData.setTemplateRenderSucc(jSONObject2.optBoolean(KEY_PLAY_TEMP_DISPLAY_TYPE));
                    parseCampaignWithBackData.setECTemplateRenderSucc(jSONObject2.optBoolean(KEY_EC_TEMP_DISPLAY_TYPE));
                    parseCampaignWithBackData.setTriggerClickSource(jSONObject2.optInt(KEY_TRIGGER_CLICK_SOURCE));
                    String optString10 = jSONObject2.optString(KEY_ACTIVITY_PATH_AND_NAME);
                    if (!TextUtils.isEmpty(optString10)) {
                        try {
                            parseCampaignWithBackData.setAc(optString10);
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                    parseCampaignWithBackData.setFilterCallBackState(jSONObject2.optInt(KEY_SECOND_REQUEST_CALLBACK_STATE, 2));
                    return parseCampaignWithBackData;
                } catch (Exception e9) {
                    e = e9;
                    campaignEx = parseCampaignWithBackData;
                    e.printStackTrace();
                    return campaignEx;
                }
            } catch (Exception e10) {
                e = e10;
                campaignEx = campaignEx2;
                e.printStackTrace();
                return campaignEx;
            }
        } catch (Exception e11) {
            e = e11;
            campaignEx = null;
            e.printStackTrace();
            return campaignEx;
        }
    }

    public static JSONArray parseCamplistToJson(List<CampaignEx> list) {
        JSONArray jSONArray = null;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    try {
                        for (CampaignEx campaignToJsonObject : list) {
                            try {
                                jSONArray2.put(campaignToJsonObject(campaignToJsonObject));
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        return jSONArray2;
                    } catch (Exception e5) {
                        e = e5;
                        jSONArray = jSONArray2;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                e.printStackTrace();
                return jSONArray;
            }
        }
        return jSONArray;
    }

    private static List<Map<Integer, String>> parsePlayCentage(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i5 = 0;
            while (i5 < jSONArray.length()) {
                try {
                    String string = jSONArray.getString(i5);
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        HashMap hashMap = new HashMap();
                        int i6 = jSONObject.getInt("rate");
                        hashMap.put(Integer.valueOf(i6), jSONObject.getString("url"));
                        arrayList.add(hashMap);
                    }
                    i5++;
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    public static CampaignEx parseSettingCampaign(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CampaignEx campaignEx = new CampaignEx();
        campaignEx.setId(jSONObject.optString("campaignid"));
        campaignEx.setPackageName(jSONObject.optString("packageName"));
        campaignEx.setAppName(jSONObject.optString(JSON_KEY_TITLE));
        campaignEx.setAdCall(jSONObject.optString("cta"));
        campaignEx.setAppDesc(jSONObject.optString(JSON_KEY_DESC));
        campaignEx.setImpressionURL(jSONObject.optString(JSON_KEY_IMPRESSION_URL));
        campaignEx.setImageUrl(jSONObject.optString(JSON_KEY_IMAGE_URL));
        campaignEx.setPlct(jSONObject.optLong(JSON_KEY_PLCT));
        campaignEx.setPlctb(jSONObject.optLong(JSON_KEY_PLCTB));
        campaignEx.setCandidateCacheTime(jSONObject.optLong(JSON_KEY_C_C_TIME));
        campaignEx.setAdHtml(jSONObject.optString(JSON_KEY_AD_HTML));
        campaignEx.setAdZip(jSONObject.optString(JSON_KEY_AD_ZIP));
        campaignEx.setBannerUrl(jSONObject.optString(JSON_KEY_BANNER_URL));
        campaignEx.setBannerHtml(jSONObject.optString(JSON_KEY_BANNER_HTML));
        campaignEx.setCreativeId(jSONObject.optLong(JSON_KEY_CREATIVE_ID));
        campaignEx.setVidCrtvId(jSONObject.optLong(JSON_KEY_VIDEO_CREATIVE_ID));
        campaignEx.setEcCrtvId(jSONObject.optLong(JSON_KEY_EC_CREATIVE_ID));
        campaignEx.setEcTemplateId(jSONObject.optLong(JSON_KEY_EC_TEMP_ID));
        campaignEx.setPlacementId(jSONObject.optString(MBridgeConstans.PLACEMENT_ID));
        return campaignEx;
    }

    protected static String[] processNativeVideoTrackingArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            strArr[i5] = jSONArray.optString(i5);
        }
        return strArr;
    }

    protected static JSONArray processNativeVideoTrackingArray2Json(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : strArr) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    private static JSONArray reparsePlayCentage(List<Map<Integer, String>> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            int i5 = 0;
            while (i5 < list.size()) {
                try {
                    Map map = list.get(i5);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("rate", map.keySet().iterator().next());
                    jSONObject.put("url", map.values().iterator().next());
                    jSONArray.put(jSONObject);
                    i5++;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
        return jSONArray;
    }

    private void setMoreOfferAdControl(String str, String str2) {
        JSONObject jSONObject;
        try {
            int c5 = ak.c(str, MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
            if (c5 != 0) {
                if (TextUtils.isEmpty(this.moreOfferJsonData)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(this.moreOfferJsonData);
                }
                int c6 = ak.c(str, MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF, c5);
                jSONObject2.put(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM, c6);
                jSONObject.put(str2, jSONObject2);
                this.moreOfferJsonData = jSONObject.toString();
            }
        } catch (Exception e5) {
            af.a(TAG, e5.getMessage());
        }
    }

    public AabEntity getAabEntity() {
        return this.aabEntity;
    }

    public String getAc() {
        return this.ac;
    }

    public int getAc_s() {
        return this.ac_s;
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public int getAdSpaceT() {
        return this.adSpaceT;
    }

    public int getAdType() {
        return this.adType;
    }

    public List<String> getAdUrlList() {
        Exception e5;
        ArrayList arrayList;
        String ad_url_list2 = getAd_url_list();
        try {
            if (TextUtils.isEmpty(ad_url_list2)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(ad_url_list2);
            arrayList = new ArrayList();
            int i5 = 0;
            while (i5 < jSONArray.length()) {
                try {
                    arrayList.add(jSONArray.optString(i5));
                    i5++;
                } catch (Exception e6) {
                    e5 = e6;
                    e5.printStackTrace();
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Exception e7) {
            e5 = e7;
            arrayList = null;
            e5.printStackTrace();
            return arrayList;
        }
    }

    public String getAdZip() {
        return this.adZip;
    }

    public String getAd_url_list() {
        return this.ad_url_list;
    }

    public a getAdchoice() {
        return this.adchoice;
    }

    public String getAdvImp() {
        return this.advImp;
    }

    public Map<Integer, String> getAdvImpList() {
        return generateAdImpression(this.advImp);
    }

    public HashMap<String, String> getAks() {
        return this.aks;
    }

    public String getAl() {
        return this.al;
    }

    public int getAutoShowStoreMiniCard() {
        return this.autoShowStoreMiniCard;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public int getBty() {
        return this.bty;
    }

    public String getCMPTEntryUrl() {
        return this.CMPTEntryUrl;
    }

    public int getCacheLevel() {
        return this.cacheLevel;
    }

    public String getCampaignUnitId() {
        return this.campaignUnitId;
    }

    public boolean getCanStart2C1Anim() {
        return this.canStart2C1Anim;
    }

    public boolean getCanStartMoreOfferAnim() {
        return this.canStartMoreOfferAnim;
    }

    public long getCandidateCacheTime() {
        return this.candidateCacheTime;
    }

    public int getCbd() {
        return this.cbd;
    }

    public int getCbt() {
        return this.cbt;
    }

    public int getClickInterval() {
        return this.clickInterval;
    }

    public int getClickTempSource() {
        return this.clickTempSource;
    }

    public int getClickTimeOutInterval() {
        return this.clickTimeOutInterval;
    }

    public int getClickType() {
        return this.clickType;
    }

    public String getClickURL() {
        return this.clickURL;
    }

    public String getClick_mode() {
        return this.click_mode;
    }

    public long getCreativeId() {
        return this.creativeId;
    }

    public String getCurrentLocalRid() {
        if (TextUtils.isEmpty(this.n_lrid)) {
            return this.localRequestId;
        }
        return this.n_lrid;
    }

    public String getDeepLinkURL() {
        return this.deepLinkUrl;
    }

    public int getDynamicTempCode() {
        return this.dynamicTempCode;
    }

    public long getEcCrtvId() {
        return this.ecCrtvId;
    }

    public long getEcTemplateId() {
        return this.ecTemplateId;
    }

    public String getEcppv() {
        return this.ecppv;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public String getEndScreenUrl() {
        return this.endScreenUrl;
    }

    public int getEndcard_click_result() {
        return this.endcard_click_result;
    }

    public String getExpIds() {
        return this.expIds;
    }

    public String getExt_data() {
        return this.ext_data;
    }

    public int getFac() {
        return this.fac;
    }

    public int getFca() {
        return this.fca;
    }

    public int getFcb() {
        return this.fcb;
    }

    public int getFilterCallBackState() {
        return this.filterCallBackState;
    }

    public int getFlb() {
        return this.flb;
    }

    public int getFlbSkipTime() {
        return this.flbSkipTime;
    }

    public String getGifUrl() {
        return this.gifUrl;
    }

    public String getGuidelines() {
        return this.guidelines;
    }

    public String getHost() {
        if (TextUtils.isEmpty(getNoticeUrl())) {
            return "";
        }
        try {
            Uri parse = Uri.parse(getNoticeUrl());
            if (parse == null) {
                return "";
            }
            return parse.getScheme() + "://" + parse.getHost();
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
            return "";
        }
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getIa_ext1() {
        return this.ia_ext1;
    }

    public String getIa_ext2() {
        return this.ia_ext2;
    }

    public int getIex() {
        return this.iex;
    }

    public String getImageSize() {
        return this.imageSize;
    }

    public int getImpReportType() {
        return this.impReportType;
    }

    public int getImpUA() {
        return this.impUA;
    }

    public String getImpressionURL() {
        try {
            if (ah.a().a("v_a_d_p", false)) {
                String str = this.impressionURL;
                String a5 = ak.a(str, "&tun=", ab.q() + "");
                this.impressionURL = a5;
                return a5;
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
        return this.impressionURL;
    }

    public String getInteractiveCache() {
        return this.interactiveCache;
    }

    public int getIsAddSuccesful() {
        return this.isAddSuccesful;
    }

    public int getIsClick() {
        return this.isClick;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public int getIsDownLoadZip() {
        return this.isDownLoadZip;
    }

    public int getIsTimeoutCheckVideoStatus() {
        return this.isTimeoutCheckVideoStatus;
    }

    public int getJmPd() {
        return this.jmPd;
    }

    public JumpLoaderResult getJumpResult() {
        return this.jumpResult;
    }

    public String getK() {
        return this.f8987k;
    }

    public String getKeyIaIcon() {
        return this.keyIaIcon;
    }

    public int getKeyIaOri() {
        return this.keyIaOri;
    }

    public int getKeyIaRst() {
        return this.keyIaRst;
    }

    public String getKeyIaUrl() {
        return this.keyIaUrl;
    }

    public String getLabel() {
        return this.label;
    }

    public String getLandingType() {
        return this.landingType;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public int getLoadTimeoutState() {
        return this.loadTimeoutState;
    }

    public String getLocalRequestId() {
        return this.localRequestId;
    }

    public int getMaitve() {
        return this.maitve;
    }

    public String getMaitve_src() {
        return this.maitve_src;
    }

    public b getMediaViewHolder() {
        return this.mediaViewHolder;
    }

    public String getMof_template_url() {
        return this.mof_template_url;
    }

    public int getMof_tplid() {
        return this.mof_tplid;
    }

    public String getMoreOfferJsonData() {
        return this.moreOfferJsonData;
    }

    public String getMp() {
        return this.mp;
    }

    public String getMraid() {
        return this.mraid;
    }

    public String getNLRid() {
        return this.n_lrid;
    }

    public String getNRid() {
        return this.n_rid;
    }

    public j getNativeVideoTracking() {
        return this.nativeVideoTracking;
    }

    public String getNativeVideoTrackingString() {
        return this.nativeVideoTrackingString;
    }

    public String getNetAddress() {
        return this.netAddress;
    }

    public String getNoticeUrl() {
        try {
            if (ah.a().a("v_a_d_p", false)) {
                String str = this.noticeUrl;
                String a5 = ak.a(str, "&tun=", ab.q() + "");
                this.noticeUrl = a5;
                return a5;
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
        return this.noticeUrl;
    }

    public int getNscpt() {
        return this.nscpt;
    }

    public int getNvT2() {
        return this.nvT2;
    }

    public int getOc_time() {
        return this.oc_time;
    }

    public int getOc_type() {
        return this.oc_type;
    }

    public int getOfferType() {
        return this.offerType;
    }

    public String getOmid() {
        return this.omid;
    }

    public String getOnlyImpressionURL() {
        try {
            if (ah.a().a("v_a_d_p", false)) {
                String str = this.onlyImpressionURL;
                String a5 = ak.a(str, "&tun=", ab.q() + "");
                this.onlyImpressionURL = a5;
                return a5;
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
        return this.onlyImpressionURL;
    }

    public String getPkgSource() {
        return this.pkgSource;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public int getPlayable_ads_without_video() {
        return this.playable_ads_without_video;
    }

    public long getPlct() {
        return this.plct;
    }

    public long getPlctb() {
        return this.plctb;
    }

    public int getPrivacyButtonTemplateVisibility() {
        return this.privacyButtonTemplateVisibility;
    }

    public String getPrivacyUrl() {
        return this.privacyUrl;
    }

    public int getProgressBarShow() {
        return this.progressBarShow;
    }

    public List<String> getPv_urls() {
        return this.pv_urls;
    }

    public String getQ() {
        return this.f8988q;
    }

    public String getR() {
        return this.f8989r;
    }

    public int getReadyState() {
        return this.readyState;
    }

    public int getReady_rate() {
        return this.ready_rate;
    }

    public String getReasond() {
        return this.reasond;
    }

    public String getReq_ext_data() {
        return this.req_ext_data;
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionURL)) {
                return null;
            }
            Uri parse = Uri.parse(this.onlyImpressionURL);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(JSON_KEY_AD_K);
                this.requestId = queryParameter;
                setRequestId(queryParameter);
            }
            return this.requestId;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getRequestIdNotice() {
        try {
            if (!TextUtils.isEmpty(this.requestIdNotice)) {
                return this.requestIdNotice;
            }
            if (TextUtils.isEmpty(this.noticeUrl)) {
                return "";
            }
            Uri parse = Uri.parse(this.noticeUrl);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(JSON_KEY_AD_K);
                this.requestIdNotice = queryParameter;
                setRequestIdNotice(queryParameter);
            }
            return this.requestIdNotice;
        } catch (Exception unused) {
            return "";
        }
    }

    public int getRetarget_offer() {
        return this.retarget_offer;
    }

    public int getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardName() {
        return this.reward_name;
    }

    public int getRewardPlayStatus() {
        return this.rewardPlayStatus;
    }

    public RewardPlus getRewardPlus() {
        return this.rewardPlus;
    }

    public c getRewardTemplateMode() {
        return this.rewardTemplateMode;
    }

    public ArrayList<Integer> getRsIgnoreCheckRule() {
        return this.rsIgnoreCheckRule;
    }

    public String getRsIgnoreCheckRuleString() {
        if (getRsIgnoreCheckRule() == null || getRsIgnoreCheckRule().size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            ArrayList<Integer> rsIgnoreCheckRule2 = getRsIgnoreCheckRule();
            int size = rsIgnoreCheckRule2.size();
            int i5 = 0;
            while (i5 < size) {
                Integer num = rsIgnoreCheckRule2.get(i5);
                i5++;
                sb.append(num);
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
            if (!TextUtils.isEmpty(sb)) {
                return sb.toString();
            }
            return "";
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            return "";
        }
    }

    public int getRtinsType() {
        return this.rtinsType;
    }

    public int getShowCount() {
        return this.showCount;
    }

    public int getShowIndex() {
        return this.showIndex;
    }

    public int getShowStoreMiniCardDelayTime() {
        return this.showStoreMiniCardDelayTime;
    }

    public int getShowType() {
        return this.showType;
    }

    public int getSpareOfferFlag() {
        return this.spareOfferFlag;
    }

    public int getTImp() {
        return this.t_imp;
    }

    public String getT_list() {
        return this.t_list;
    }

    public int getTab() {
        return this.tab;
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

    public int getTpOffer() {
        return this.tpOffer;
    }

    public int getTrackingTcpPort() {
        return this.trackingTcpPort;
    }

    public int getTriggerClickSource() {
        return this.triggerClickSource;
    }

    public long getTs() {
        return this.ts;
    }

    public int getTyped() {
        return this.typed;
    }

    public int getUseSkipTime() {
        return this.useSkipTime;
    }

    public boolean getUserActivation() {
        return this.userActivation;
    }

    public int getVcn() {
        int i5 = this.vcn;
        if (i5 > 0) {
            return i5;
        }
        return 1;
    }

    public long getVidCrtvId() {
        return this.vidCrtvId;
    }

    public int getVideoCheckType() {
        return this.videoCheckType;
    }

    public int getVideoCompleteTime() {
        return this.videoCompleteTime;
    }

    public int getVideoCtnType() {
        return this.videoCtnType;
    }

    public String getVideoMD5Value() {
        return this.videoMD5Value;
    }

    public int getVideoPlayProgress() {
        return this.videoPlayProgress;
    }

    public String getVideoResolution() {
        return this.videoResolution;
    }

    public int getVideoSize() {
        return this.videoSize;
    }

    public String getVideoUrlEncode() {
        return this.videoUrlEncode;
    }

    public int getVideo_end_type() {
        return this.video_end_type;
    }

    public int getVst() {
        return this.vst;
    }

    public int getWatchMile() {
        return this.watchMile;
    }

    public int getWtick() {
        return this.wtick;
    }

    public int getcUA() {
        return this.cUA;
    }

    public long getcVersionCode() {
        return this.cVersionCode;
    }

    public String getendcard_url() {
        return this.endcard_url;
    }

    public boolean isActiveOm() {
        if (TextUtils.isEmpty(this.omid) || TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_URL)) {
            return false;
        }
        return true;
    }

    public boolean isBidCampaign() {
        return this.isBidCampaign;
    }

    public boolean isCallBackImpression() {
        return this.isCallBackImpression;
    }

    public boolean isCallbacked() {
        return this.isCallbacked;
    }

    public boolean isCampaignIsFiltered() {
        return this.campaignIsFiltered;
    }

    public boolean isDynamicView() {
        return this.isDynamicView;
    }

    public boolean isECTemplateRenderSucc() {
        return this.isECTemplateRenderSucc;
    }

    public boolean isEffectiveOffer(long j5) {
        long currentTimeMillis = System.currentTimeMillis();
        if (getPlct() > 0) {
            if (getTimestamp() + (getPlct() * 1000) >= currentTimeMillis) {
                return true;
            }
            return false;
        } else if (getTimestamp() + j5 >= currentTimeMillis) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isHasMBTplMark() {
        return this.hasMBTplMark;
    }

    public boolean isHasReportAdTrackPause() {
        return this.hasReportAdTrackPause;
    }

    public boolean isMraid() {
        return this.isMraid;
    }

    public boolean isReady() {
        return this.isReady;
    }

    public boolean isReport() {
        return this.isReport;
    }

    public boolean isReportClick() {
        return this.isReportClick;
    }

    public boolean isSpareOffer(long j5, long j6) {
        if (isEffectiveOffer(j5)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (getPlctb() > 0) {
            if (getTimestamp() + (getPlctb() * 1000) >= currentTimeMillis) {
                return true;
            }
            return false;
        } else if (getTimestamp() + j6 >= currentTimeMillis) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTemplateRenderSucc() {
        return this.isTemplateRenderSucc;
    }

    public boolean needShowIDialog() {
        return super.needShowIDialog(this);
    }

    public void setAabEntity(AabEntity aabEntity2) {
        this.aabEntity = aabEntity2;
    }

    public void setAc(String str) {
        this.ac = str;
    }

    public void setAc_s(int i5) {
        this.ac_s = i5;
    }

    public void setAdCall(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.linkType != 2) {
                str = "Learn more";
            } else {
                str = "Install";
            }
        }
        super.setAdCall(str);
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public void setAdSpaceT(int i5) {
        this.adSpaceT = i5;
    }

    public void setAdType(int i5) {
        this.adType = i5;
    }

    public void setAdZip(String str) {
        this.adZip = str;
        boolean i5 = ak.i(str);
        int b5 = ak.b(str);
        if (i5) {
            setDynamicView(true);
            setDynamicTempCode(b5);
        }
    }

    public void setAd_url_list(String str) {
        this.ad_url_list = str;
    }

    public void setAdchoice(a aVar) {
        this.adchoice = aVar;
    }

    public void setAdvImp(String str) {
        this.advImp = str;
    }

    public void setAks(HashMap<String, String> hashMap) {
        this.aks = hashMap;
    }

    public void setAl(String str) {
        this.al = str;
    }

    public void setAutoShowStoreMiniCard(int i5) {
        this.autoShowStoreMiniCard = i5;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public void setBty(int i5) {
        this.bty = i5;
    }

    public void setCMPTEntryUrl(String str) {
        this.CMPTEntryUrl = str;
    }

    public void setCacheLevel(int i5) {
        this.cacheLevel = i5;
    }

    public void setCallBackImpression(boolean z4) {
        this.isCallBackImpression = z4;
    }

    public void setCallbacked(boolean z4) {
        this.isCallbacked = z4;
    }

    public void setCampaignIsFiltered(boolean z4) {
        this.campaignIsFiltered = z4;
    }

    public void setCampaignUnitId(String str) {
        this.campaignUnitId = str;
    }

    public void setCanStart2C1Anim(boolean z4) {
        this.canStart2C1Anim = z4;
    }

    public void setCanStartMoreOfferAnim(boolean z4) {
        this.canStartMoreOfferAnim = z4;
    }

    public void setCandidateCacheTime(long j5) {
        this.candidateCacheTime = j5;
    }

    public void setCbd(int i5) {
        this.cbd = i5;
    }

    public void setCbt(int i5) {
        this.cbt = i5;
    }

    public void setClickInterval(int i5) {
        this.clickInterval = i5;
    }

    public void setClickTempSource(int i5) {
        this.clickTempSource = i5;
    }

    public void setClickTimeOutInterval(int i5) {
        this.clickTimeOutInterval = i5;
    }

    public void setClickType(int i5) {
        this.clickType = i5;
    }

    public void setClickURL(String str) {
        this.clickURL = str;
    }

    public void setClick_mode(String str) {
        this.click_mode = str;
    }

    public void setCreativeId(long j5) {
        this.creativeId = j5;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }

    public void setDynamicTempCode(int i5) {
        this.dynamicTempCode = ak.a(i5);
    }

    public void setDynamicView(boolean z4) {
        this.isDynamicView = z4;
    }

    public void setECTemplateRenderSucc(boolean z4) {
        this.isECTemplateRenderSucc = z4;
    }

    public void setEcCrtvId(long j5) {
        this.ecCrtvId = j5;
    }

    public void setEcTemplateId(long j5) {
        this.ecTemplateId = j5;
    }

    public void setEcppv(String str) {
        this.ecppv = str;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public void setEndScreenUrl(String str) {
        this.endScreenUrl = str;
    }

    public void setEndcard_click_result(int i5) {
        this.endcard_click_result = i5;
    }

    public void setExpIds(String str) {
        this.expIds = str;
    }

    public void setExt_data(String str) {
        this.ext_data = str;
    }

    public void setFac(int i5) {
        this.fac = i5;
    }

    public void setFca(int i5) {
        this.fca = i5;
    }

    public void setFcb(int i5) {
        this.fcb = i5;
    }

    public void setFilterCallBackState(int i5) {
        if (i5 == 2) {
            if (this.retarget_offer == 1) {
                i5 = 1;
            } else {
                i5 = 0;
            }
        }
        this.filterCallBackState = i5;
    }

    public void setFlb(int i5) {
        this.flb = i5;
    }

    public void setFlbSkipTime(int i5) {
        this.flbSkipTime = i5;
    }

    public void setGifUrl(String str) {
        this.gifUrl = str;
    }

    public void setGuidelines(String str) {
        this.guidelines = str;
    }

    public void setHasMBTplMark(boolean z4) {
        this.hasMBTplMark = z4;
    }

    public void setHasReportAdTrackPause(boolean z4) {
        this.hasReportAdTrackPause = z4;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public void setIa_ext1(String str) {
        this.ia_ext1 = str;
    }

    public void setIa_ext2(String str) {
        this.ia_ext2 = str;
    }

    public void setIex(int i5) {
        this.iex = i5;
    }

    public void setImageSize(String str) {
        this.imageSize = str;
    }

    public void setImpReportType(int i5) {
        this.impReportType = i5;
        if (i5 == 1) {
            int i6 = this.adType;
            if (i6 == 296 || i6 == 42) {
                String impressionURL2 = getImpressionURL();
                String onlyImpressionURL2 = getOnlyImpressionURL();
                if (!TextUtils.isEmpty(impressionURL2) && !impressionURL2.contains(JSON_KEY_IMP_REPORT_TYPE)) {
                    setImpressionURL(impressionURL2 + "&imp_report_type=" + i5);
                }
                if (!TextUtils.isEmpty(onlyImpressionURL2) && !onlyImpressionURL2.contains(JSON_KEY_IMP_REPORT_TYPE)) {
                    setOnlyImpressionURL(onlyImpressionURL2 + "&imp_report_type=" + i5);
                }
            }
        }
    }

    public void setImpUA(int i5) {
        this.impUA = i5;
    }

    public void setImpressionURL(String str) {
        this.impressionURL = str;
    }

    public void setInteractiveCache(String str) {
        this.interactiveCache = str;
    }

    public void setIsAddSuccesful(int i5) {
        this.isAddSuccesful = i5;
    }

    public void setIsBidCampaign(boolean z4) {
        this.isBidCampaign = z4;
    }

    public void setIsClick(int i5) {
        this.isClick = i5;
    }

    public void setIsDeleted(int i5) {
        this.isDeleted = i5;
    }

    public void setIsDownLoadZip(int i5) {
        this.isDownLoadZip = i5;
    }

    public void setIsMraid(boolean z4) {
        this.isMraid = z4;
    }

    public void setIsTimeoutCheckVideoStatus(int i5) {
        this.isTimeoutCheckVideoStatus = i5;
    }

    public void setJmPd(int i5) {
        this.jmPd = i5;
    }

    public void setJumpResult(JumpLoaderResult jumpLoaderResult) {
        this.jumpResult = jumpLoaderResult;
    }

    public void setK(String str) {
        this.f8987k = str;
    }

    public void setKeyIaIcon(String str) {
        this.keyIaIcon = str;
    }

    public void setKeyIaOri(int i5) {
        this.keyIaOri = i5;
    }

    public void setKeyIaRst(int i5) {
        this.keyIaRst = i5;
    }

    public void setKeyIaUrl(String str) {
        this.keyIaUrl = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLandingType(String str) {
        this.landingType = str;
    }

    public void setLinkType(int i5) {
        this.linkType = i5;
    }

    public void setLoadTimeoutState(int i5) {
        this.loadTimeoutState = i5;
    }

    public void setLocalRequestId(String str) {
        this.localRequestId = str;
    }

    public void setMaitve(int i5) {
        this.maitve = i5;
    }

    public void setMaitve_src(String str) {
        this.maitve_src = str;
    }

    public void setMediaViewHolder(b bVar) {
        this.mediaViewHolder = bVar;
    }

    public void setMof_template_url(String str) {
        this.mof_template_url = str;
        if (!TextUtils.isEmpty(str)) {
            setCMPTEntryUrl(str);
            boolean i5 = ak.i(str);
            int b5 = ak.b(str);
            if (i5) {
                setDynamicView(true);
                setDynamicTempCode(b5);
            }
            setCanStart2C1Anim(ak.h(str));
        }
    }

    public void setMof_tplid(int i5) {
        this.mof_tplid = i5;
    }

    public void setMp(String str) {
        this.mp = str;
    }

    public void setMraid(String str) {
        this.mraid = str;
    }

    public void setNLRid(String str) {
        this.n_lrid = str;
    }

    public void setNRid(String str) {
        this.n_rid = str;
    }

    public void setNativeVideoTracking(j jVar) {
        this.nativeVideoTracking = jVar;
    }

    public void setNativeVideoTrackingString(String str) {
        this.nativeVideoTrackingString = str;
    }

    public void setNetAddress(String str) {
        this.netAddress = str;
    }

    public void setNoticeUrl(String str) {
        this.noticeUrl = str;
    }

    public void setNscpt(int i5) {
        this.nscpt = i5;
    }

    public void setNvT2(int i5) {
        this.nvT2 = i5;
    }

    public void setOc_time(int i5) {
        this.oc_time = i5;
    }

    public void setOc_type(int i5) {
        this.oc_type = i5;
    }

    public void setOfferType(int i5) {
        this.offerType = i5;
    }

    public void setOmid(String str) {
        this.omid = str;
    }

    public void setOnlyImpressionURL(String str) {
        Uri parse;
        this.onlyImpressionURL = str;
        try {
            if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
                String queryParameter = parse.getQueryParameter(URL_KEY_EXP_IDS);
                if (!TextUtils.isEmpty(queryParameter)) {
                    setExpIds(queryParameter);
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public void setPkgSource(String str) {
        this.pkgSource = str;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setPlayable_ads_without_video(int i5) {
        this.playable_ads_without_video = i5;
    }

    public void setPlct(long j5) {
        this.plct = j5;
    }

    public void setPlctb(long j5) {
        this.plctb = j5;
    }

    public void setPrivacyButtonTemplateVisibility(int i5) {
        this.privacyButtonTemplateVisibility = i5;
    }

    public void setPrivacyUrl(String str) {
        this.privacyUrl = str;
    }

    public void setProgressBarShow(int i5) {
        this.progressBarShow = i5;
    }

    public void setPv_urls(List<String> list) {
        this.pv_urls = list;
    }

    public void setQ(String str) {
        this.f8988q = str;
    }

    public void setR(String str) {
        this.f8989r = str;
    }

    public void setReady(boolean z4) {
        this.isReady = z4;
    }

    public void setReadyState(int i5) {
        this.readyState = i5;
    }

    public void setReady_rate(int i5) {
        this.ready_rate = i5;
    }

    public void setReasond(String str) {
        this.reasond = str;
    }

    public void setReport(boolean z4) {
        this.isReport = z4;
    }

    public void setReportClick(boolean z4) {
        this.isReportClick = z4;
    }

    public void setReq_ext_data(String str) {
        this.req_ext_data = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setRequestIdNotice(String str) {
        this.requestIdNotice = str;
    }

    public void setRetarget_offer(int i5) {
        this.retarget_offer = i5;
    }

    public void setRewardAmount(int i5) {
        this.rewardAmount = i5;
    }

    public void setRewardName(String str) {
        this.reward_name = str;
    }

    public void setRewardPlayStatus(int i5) {
        this.rewardPlayStatus = i5;
    }

    public void setRewardPlus(RewardPlus rewardPlus2) {
        this.rewardPlus = rewardPlus2;
    }

    public void setRewardTemplateMode(c cVar) {
        this.rewardTemplateMode = cVar;
        if (cVar != null && !TextUtils.isEmpty(cVar.e())) {
            if (TextUtils.isEmpty(this.mof_template_url) && cVar.e().contains(KEY_IS_CMPT_ENTRY)) {
                setCMPTEntryUrl(cVar.e());
            }
            boolean i5 = ak.i(cVar.e());
            int b5 = ak.b(cVar.e());
            if (i5) {
                setDynamicView(true);
                setDynamicTempCode(b5);
            }
            setMoreOfferAdControl(cVar.e(), "template_url");
        }
    }

    public void setRsIgnoreCheckRule(ArrayList<Integer> arrayList) {
        this.rsIgnoreCheckRule = arrayList;
    }

    public void setRsIgnoreCheckRuleByString(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (String parseInt : split) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
                }
                setRsIgnoreCheckRule(arrayList);
            }
        }
    }

    public void setRtinsType(int i5) {
        this.rtinsType = i5;
    }

    public void setShowCount(int i5) {
        this.showCount = i5;
    }

    public void setShowIndex(int i5) {
        this.showIndex = i5;
    }

    public void setShowStoreMiniCardDelayTime(int i5) {
        this.showStoreMiniCardDelayTime = i5;
    }

    public void setShowType(int i5) {
        this.showType = i5;
    }

    public void setSpareOfferFlag(int i5) {
        this.spareOfferFlag = i5;
    }

    public void setTImp(int i5) {
        this.t_imp = i5;
    }

    public void setT_list(String str) {
        this.t_list = str;
    }

    public void setTab(int i5) {
        this.tab = i5;
    }

    public void setTemplate(int i5) {
        this.template = i5;
    }

    public void setTemplateRenderSucc(boolean z4) {
        this.isTemplateRenderSucc = z4;
    }

    public void setTokenRule(int i5) {
        this.tokenRule = i5;
    }

    public void setTpOffer(int i5) {
        this.tpOffer = i5;
    }

    public void setTrackingTcpPort(int i5) {
        this.trackingTcpPort = i5;
    }

    public void setTriggerClickSource(int i5) {
        this.triggerClickSource = i5;
    }

    public void setTs(long j5) {
        this.ts = j5;
    }

    public void setTyped(int i5) {
        this.typed = i5;
    }

    public void setUseSkipTime(int i5) {
        this.useSkipTime = i5;
    }

    public void setUserActivation(boolean z4) {
        this.userActivation = z4;
    }

    public void setVcn(int i5) {
        this.vcn = i5;
    }

    public void setVidCrtvId(long j5) {
        this.vidCrtvId = j5;
    }

    public void setVideoCheckType(int i5) {
        if (i5 > 2 || i5 < 1) {
            this.videoCheckType = 2;
        } else {
            this.videoCheckType = i5;
        }
    }

    public void setVideoCompleteTime(int i5) {
        this.videoCompleteTime = i5;
    }

    public void setVideoCtnType(int i5) {
        if (i5 > 2 || i5 < 1) {
            this.videoCtnType = 1;
        } else {
            this.videoCtnType = i5;
        }
    }

    public void setVideoMD5Value(String str) {
        this.videoMD5Value = str;
    }

    public void setVideoPlayProgress(int i5) {
        this.videoPlayProgress = i5;
    }

    public void setVideoResolution(String str) {
        this.videoResolution = str;
    }

    public void setVideoSize(int i5) {
        this.videoSize = i5;
    }

    public void setVideoUrlEncode(String str) {
        this.videoUrlEncode = str;
    }

    public void setVideo_end_type(int i5) {
        this.video_end_type = i5;
    }

    public void setVst(int i5) {
        this.vst = i5;
    }

    public void setWatchMile(int i5) {
        this.watchMile = i5;
    }

    public void setWtick(int i5) {
        this.wtick = i5;
    }

    public void setcUA(int i5) {
        this.cUA = i5;
    }

    public void setcVersionCode(long j5) {
        this.cVersionCode = j5;
    }

    public void setendcard_url(String str) {
        c cVar;
        this.endcard_url = str;
        if (TextUtils.isEmpty(this.mof_template_url) && (((cVar = this.rewardTemplateMode) == null || TextUtils.isEmpty(cVar.f9017e)) && !TextUtils.isEmpty(str) && str.contains(KEY_IS_CMPT_ENTRY))) {
            setCMPTEntryUrl(str);
        }
        setCanStartMoreOfferAnim(ak.h(str));
        setMoreOfferAdControl(str, ENDCARD_URL);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: com.mbridge.msdk.foundation.entity.CampaignEx} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: com.mbridge.msdk.foundation.entity.CampaignEx} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: com.mbridge.msdk.foundation.entity.CampaignEx} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r15v1, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r15v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.foundation.entity.CampaignEx parseCampaign(org.json.JSONObject r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21, com.mbridge.msdk.foundation.entity.CampaignUnit r22, java.lang.String r23, java.lang.String r24) {
        /*
            r1 = r22
            java.lang.String r2 = "aab"
            java.lang.String r3 = "campaign"
            java.lang.String r4 = "cam_html"
            java.lang.String r5 = "gif_url"
            java.lang.String r6 = "nv_t2"
            java.lang.String r0 = "number_rating"
            java.lang.String r7 = "rating"
            java.lang.String r8 = "omid"
            java.lang.String r9 = ""
            org.json.JSONObject r10 = dealV5Temp(r17)
            if (r10 == 0) goto L_0x0608
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = new com.mbridge.msdk.foundation.entity.CampaignEx     // Catch:{ Exception -> 0x0602 }
            r12.<init>()     // Catch:{ Exception -> 0x0602 }
            java.lang.String r13 = "aks"
            java.lang.String r13 = r10.optString(r13)     // Catch:{ Exception -> 0x0057 }
            boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0057 }
            if (r14 != 0) goto L_0x0061
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x0057 }
            r14.<init>(r13)     // Catch:{ Exception -> 0x0057 }
            java.util.Iterator r13 = r14.keys()     // Catch:{ Exception -> 0x0057 }
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ Exception -> 0x0057 }
            r15.<init>()     // Catch:{ Exception -> 0x0057 }
        L_0x0039:
            if (r13 == 0) goto L_0x005b
            boolean r16 = r13.hasNext()     // Catch:{ Exception -> 0x0057 }
            if (r16 == 0) goto L_0x005b
            java.lang.Object r16 = r13.next()     // Catch:{ Exception -> 0x0057 }
            r17 = 0
            r11 = r16
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0057 }
            r16 = r13
            java.lang.String r13 = r14.optString(r11)     // Catch:{ Exception -> 0x0057 }
            r15.put(r11, r13)     // Catch:{ Exception -> 0x0057 }
            r13 = r16
            goto L_0x0039
        L_0x0057:
            r0 = move-exception
            r11 = r12
            goto L_0x0604
        L_0x005b:
            r17 = 0
            r12.setAks(r15)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0063
        L_0x0061:
            r17 = 0
        L_0x0063:
            boolean r11 = android.text.TextUtils.isEmpty(r23)     // Catch:{ Exception -> 0x0057 }
            r13 = 1
            if (r11 != 0) goto L_0x0072
            r11 = r23
            r12.setBidToken(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setIsBidCampaign(r13)     // Catch:{ Exception -> 0x0057 }
        L_0x0072:
            java.lang.String r14 = "ready_rate"
            r15 = -1
            int r14 = r10.optInt(r14, r15)     // Catch:{ Exception -> 0x00e7 }
            r12.setReady_rate(r14)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r14 = "ext_data"
            org.json.JSONObject r14 = r10.optJSONObject(r14)     // Catch:{ Exception -> 0x00e7 }
            if (r14 == 0) goto L_0x008b
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x00e7 }
            r12.setExt_data(r14)     // Catch:{ Exception -> 0x00e7 }
        L_0x008b:
            java.lang.String r14 = "mof_tplid"
            int r14 = r10.optInt(r14)     // Catch:{ Exception -> 0x00e7 }
            r12.setMof_tplid(r14)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r14 = "mof_template_url"
            java.lang.String r14 = r10.optString(r14)     // Catch:{ Exception -> 0x00e7 }
            r12.setMof_template_url(r14)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r14 = "nscpt"
            int r14 = r10.optInt(r14)     // Catch:{ Exception -> 0x00e7 }
            r12.setNscpt(r14)     // Catch:{ Exception -> 0x00e7 }
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ Exception -> 0x00e7 }
            r14.<init>()     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r14 = "pv_urls"
            org.json.JSONArray r14 = r10.optJSONArray(r14)     // Catch:{ Exception -> 0x00e7 }
            if (r14 == 0) goto L_0x00d3
            int r15 = r14.length()     // Catch:{ Exception -> 0x00e7 }
            if (r15 <= 0) goto L_0x00d3
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ Exception -> 0x00e7 }
            int r13 = r14.length()     // Catch:{ Exception -> 0x00e7 }
            r15.<init>(r13)     // Catch:{ Exception -> 0x00e7 }
            r13 = 0
        L_0x00c3:
            int r11 = r14.length()     // Catch:{ Exception -> 0x00e7 }
            if (r13 >= r11) goto L_0x00d5
            java.lang.String r11 = r14.optString(r13)     // Catch:{ Exception -> 0x00e7 }
            r15.add(r11)     // Catch:{ Exception -> 0x00e7 }
            int r13 = r13 + 1
            goto L_0x00c3
        L_0x00d3:
            r15 = r17
        L_0x00d5:
            r12.setPv_urls(r15)     // Catch:{ Exception -> 0x00e7 }
            java.lang.String r11 = "req_ext_data"
            org.json.JSONObject r11 = r10.optJSONObject(r11)     // Catch:{ Exception -> 0x00e7 }
            if (r11 == 0) goto L_0x00e7
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x00e7 }
            r12.setReq_ext_data(r11)     // Catch:{ Exception -> 0x00e7 }
        L_0x00e7:
            java.lang.String r11 = "id"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setId(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "title"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setAppName(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "unitId"
            java.lang.String r11 = r10.optString(r11, r9)     // Catch:{ Exception -> 0x0057 }
            r12.setCampaignUnitId(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "desc"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setAppDesc(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "package_name"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setPackageName(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "rtins_type"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setRtinsType(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "icon_url"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setIconUrl(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "image_url"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setImageUrl(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "app_size"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setSize(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "image_size"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setImageSize(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "impression_url"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = com.mbridge.msdk.foundation.entity.DomainCampaignEx.replaceValueByKey(r1, r12, r11)     // Catch:{ Exception -> 0x0057 }
            r12.setImpressionURL(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "click_url"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = com.mbridge.msdk.foundation.entity.DomainCampaignEx.replaceValueByKey(r1, r12, r11)     // Catch:{ Exception -> 0x0057 }
            r12.setClickURL(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "rw_pl"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            com.mbridge.msdk.foundation.entity.RewardPlus r11 = com.mbridge.msdk.foundation.entity.RewardPlus.parseByString(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setRewardPlus(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "wtick"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setWtick(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "deep_link"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = com.mbridge.msdk.foundation.entity.DomainCampaignEx.replaceValueByKey(r1, r12, r11)     // Catch:{ Exception -> 0x0057 }
            r12.setDeepLinkUrl(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "user_activation"
            r13 = 0
            boolean r11 = r10.optBoolean(r11, r13)     // Catch:{ Exception -> 0x0057 }
            r12.setUserActivation(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "notice_url"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = com.mbridge.msdk.foundation.entity.DomainCampaignEx.replaceValueByKey(r1, r12, r11)     // Catch:{ Exception -> 0x0057 }
            r12.setNoticeUrl(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "template"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setTemplate(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "ad_source_id"
            r13 = 1
            int r11 = r10.optInt(r11, r13)     // Catch:{ Exception -> 0x0057 }
            r12.setType(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "fca"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setFca(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "fcb"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setFcb(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = "endcard_click_result"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x0057 }
            r12.setEndcard_click_result(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r11 = r10.optString(r7)     // Catch:{ Exception -> 0x0057 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0057 }
            if (r11 != 0) goto L_0x01da
            java.lang.String r11 = "0"
            java.lang.String r7 = r10.optString(r7, r11)     // Catch:{ Exception -> 0x0057 }
            double r13 = java.lang.Double.parseDouble(r7)     // Catch:{ Exception -> 0x0057 }
            r12.setRating(r13)     // Catch:{ Exception -> 0x0057 }
        L_0x01da:
            java.lang.String r7 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0057 }
            if (r7 != 0) goto L_0x01ee
            r7 = 333333(0x51615, float:4.67099E-40)
            int r0 = r10.optInt(r0, r7)     // Catch:{ Exception -> 0x0057 }
            r12.setNumberRating(r0)     // Catch:{ Exception -> 0x0057 }
        L_0x01ee:
            java.lang.String r0 = "click_mode"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setClick_mode(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "landing_type"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setLandingType(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "link_type"
            r7 = 4
            int r0 = r10.optInt(r0, r7)     // Catch:{ Exception -> 0x0057 }
            r12.setLinkType(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "c_ct"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setClickInterval(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ctatext"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setAdCall(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ad_url_list"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setAd_url_list(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "retarget_offer"
            r7 = 2
            int r0 = r10.optInt(r0, r7)     // Catch:{ Exception -> 0x0057 }
            r12.setRetarget_offer(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "video_url"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0057 }
            if (r11 != 0) goto L_0x0248
            if (r21 == 0) goto L_0x0241
            r12.setVideoUrlEncode(r0)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0248
        L_0x0241:
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.z.a(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setVideoUrlEncode(r0)     // Catch:{ Exception -> 0x0057 }
        L_0x0248:
            java.lang.String r0 = "view_com_time"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setVideoCompleteTime(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "video_length"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setVideoLength(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "video_size"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setVideoSize(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "video_resolution"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setVideoResolution(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "watch_mile"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setWatchMile(r0)     // Catch:{ Exception -> 0x0057 }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0057 }
            r12.setTimestamp(r13)     // Catch:{ Exception -> 0x0057 }
            r0 = r18
            java.lang.String r0 = com.mbridge.msdk.foundation.entity.DomainCampaignEx.replaceValueByKey(r1, r12, r0)     // Catch:{ Exception -> 0x0057 }
            r12.setOnlyImpressionURL(r0)     // Catch:{ Exception -> 0x0057 }
            boolean r0 = android.text.TextUtils.isEmpty(r24)     // Catch:{ Exception -> 0x0291 }
            if (r0 != 0) goto L_0x0293
            r0 = r24
            r12.setEcppv(r0)     // Catch:{ Exception -> 0x0291 }
            goto L_0x0293
        L_0x0291:
            r0 = move-exception
            goto L_0x029e
        L_0x0293:
            java.lang.String r0 = "ac_s"
            r13 = 1
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x0291 }
            r12.setAc_s(r0)     // Catch:{ Exception -> 0x0291 }
            goto L_0x02a1
        L_0x029e:
            r0.printStackTrace()     // Catch:{ Exception -> 0x0057 }
        L_0x02a1:
            java.lang.String r0 = "ctype"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setBty(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "adv_imp"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setAdvImp(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "t_imp"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setTImp(r0)     // Catch:{ Exception -> 0x0057 }
            r11 = r19
            r12.setHtmlUrl(r11)     // Catch:{ Exception -> 0x0057 }
            r11 = r20
            r12.setEndScreenUrl(r11)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "guidelines"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setGuidelines(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "offer_type"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setOfferType(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "reward_name"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setRewardName(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "reward_amount"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setRewardAmount(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ad_tracking"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0304 }
            java.lang.String r0 = com.mbridge.msdk.foundation.entity.DomainCampaignEx.replaceValueByKey(r1, r12, r0)     // Catch:{ Exception -> 0x0304 }
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0304 }
            if (r11 != 0) goto L_0x0304
            r12.setNativeVideoTrackingString(r0)     // Catch:{ Exception -> 0x0304 }
            com.mbridge.msdk.foundation.entity.j r0 = TrackingStr2Object(r0)     // Catch:{ Exception -> 0x0304 }
            r12.setNativeVideoTracking(r0)     // Catch:{ Exception -> 0x0304 }
        L_0x0304:
            java.lang.String r0 = "video_end_type"
            int r0 = r10.optInt(r0, r7)     // Catch:{ Exception -> 0x0057 }
            r12.setVideo_end_type(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "endcard_url"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            boolean r0 = isBreakCampainOrSetItByEndCard(r12, r0)     // Catch:{ Exception -> 0x0057 }
            if (r0 == 0) goto L_0x031a
            return r17
        L_0x031a:
            java.lang.String r0 = "playable_ads_without_video"
            r13 = 1
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x0057 }
            r12.setPlayable_ads_without_video(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setVideoMD5Value(r9)     // Catch:{ Exception -> 0x0057 }
            boolean r0 = r10.has(r6)     // Catch:{ Exception -> 0x0057 }
            if (r0 == 0) goto L_0x0334
            int r0 = r10.optInt(r6)     // Catch:{ Exception -> 0x0057 }
            r12.setNvT2(r0)     // Catch:{ Exception -> 0x0057 }
        L_0x0334:
            boolean r0 = r10.has(r5)     // Catch:{ Exception -> 0x0057 }
            if (r0 == 0) goto L_0x0341
            java.lang.String r0 = r10.optString(r5)     // Catch:{ Exception -> 0x0057 }
            r12.setGifUrl(r0)     // Catch:{ Exception -> 0x0057 }
        L_0x0341:
            java.lang.String r0 = "rv"
            org.json.JSONObject r0 = r10.optJSONObject(r0)     // Catch:{ Exception -> 0x0057 }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = com.mbridge.msdk.foundation.entity.CampaignEx.c.a((org.json.JSONObject) r0)     // Catch:{ Exception -> 0x0057 }
            r12.setRewardTemplateMode(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "c_toi"
            int r0 = r10.optInt(r0, r7)     // Catch:{ Exception -> 0x0057 }
            r12.setClickTimeOutInterval(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "imp_ua"
            r13 = 1
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x0057 }
            r12.setImpUA(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "c_ua"
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x0057 }
            r12.setcUA(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "jm_pd"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setJmPd(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ia_icon"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setKeyIaIcon(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ia_rst"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setKeyIaRst(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ia_url"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setKeyIaUrl(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ia_ori"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setKeyIaOri(r0)     // Catch:{ Exception -> 0x0057 }
            int r0 = r1.getAdType()     // Catch:{ Exception -> 0x0057 }
            r12.setAdType(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "tp_offer"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setTpOffer(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "fac"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setFac(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ia_ext1"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setIa_ext1(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ia_ext2"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setIa_ext2(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "is_download_zip"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setIsDownLoadZip(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ia_cache"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setInteractiveCache(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "oc_time"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setOc_time(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "oc_type"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setOc_type(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "t_list"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setT_list(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "adchoice"
            java.lang.String r0 = r10.optString(r0, r9)     // Catch:{ Exception -> 0x0057 }
            com.mbridge.msdk.foundation.entity.CampaignEx$a r0 = com.mbridge.msdk.foundation.entity.CampaignEx.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0057 }
            r12.setAdchoice(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "plct"
            long r0 = r10.optLong(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setPlct(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "c_c_time"
            long r0 = r10.optLong(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setCandidateCacheTime(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "plctb"
            long r0 = r10.optLong(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setPlctb(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "creative_id"
            long r0 = r10.optLong(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setCreativeId(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "vid_crtv_id"
            long r0 = r10.optLong(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setVidCrtvId(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ec_crtv_id"
            long r0 = r10.optLong(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setEcCrtvId(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "ec_temp_id"
            long r0 = r10.optLong(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setEcTemplateId(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "cam_tpl_url"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r5 = r1.getPath()     // Catch:{ Exception -> 0x0057 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0057 }
            if (r5 != 0) goto L_0x046b
            java.lang.String r5 = r1.getPath()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r6 = ".zip"
            boolean r5 = r5.endsWith(r6)     // Catch:{ Exception -> 0x0057 }
            if (r5 != 0) goto L_0x0467
            java.lang.String r1 = r1.getPath()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r5 = ".ZIP"
            boolean r1 = r1.endsWith(r5)     // Catch:{ Exception -> 0x0057 }
            if (r1 == 0) goto L_0x046b
        L_0x0467:
            r12.setAdZip(r0)     // Catch:{ Exception -> 0x0057 }
            goto L_0x046e
        L_0x046b:
            r12.setBannerUrl(r0)     // Catch:{ Exception -> 0x0057 }
        L_0x046e:
            java.lang.String r0 = r10.optString(r4)     // Catch:{ Exception -> 0x0057 }
            r12.setBannerHtml(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = r10.optString(r4)     // Catch:{ Exception -> 0x0057 }
            r12.setAdHtml(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "mraid"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0057 }
            if (r1 != 0) goto L_0x0490
            r13 = 1
            r12.setIsMraid(r13)     // Catch:{ Exception -> 0x0057 }
            r12.setMraid(r0)     // Catch:{ Exception -> 0x0057 }
            goto L_0x04af
        L_0x0490:
            java.lang.String r0 = r12.getAdHtml()     // Catch:{ Exception -> 0x0057 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0057 }
            if (r0 != 0) goto L_0x04ab
            java.lang.String r0 = r12.getAdHtml()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r1 = "<MBTPLMARK>"
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x0057 }
            if (r0 != 0) goto L_0x04ab
            r13 = 1
            r12.setIsMraid(r13)     // Catch:{ Exception -> 0x0057 }
            goto L_0x04af
        L_0x04ab:
            r13 = 0
            r12.setIsMraid(r13)     // Catch:{ Exception -> 0x0057 }
        L_0x04af:
            org.json.JSONArray r0 = r10.optJSONArray(r8)     // Catch:{ Exception -> 0x0057 }
            if (r0 != 0) goto L_0x04cd
            java.lang.String r0 = r10.optString(r8)     // Catch:{ Exception -> 0x0057 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0057 }
            if (r0 != 0) goto L_0x04c7
            java.lang.String r0 = r10.optString(r8)     // Catch:{ Exception -> 0x0057 }
            r12.setOmid(r0)     // Catch:{ Exception -> 0x0057 }
            goto L_0x04d4
        L_0x04c7:
            r1 = r17
            r12.setOmid(r1)     // Catch:{ Exception -> 0x0057 }
            goto L_0x04d4
        L_0x04cd:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0057 }
            r12.setOmid(r0)     // Catch:{ Exception -> 0x0057 }
        L_0x04d4:
            java.lang.String r0 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setPlacementId(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "maitve"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setMaitve(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "maitve_src"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setMaitve_src(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "flb"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setFlb(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "cbd"
            r1 = -2
            int r0 = r10.optInt(r0, r1)     // Catch:{ Exception -> 0x0057 }
            r12.setCbd(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "vst"
            int r0 = r10.optInt(r0, r1)     // Catch:{ Exception -> 0x0057 }
            r12.setVst(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "use_skip_time"
            r13 = 0
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x0057 }
            r12.setUseSkipTime(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "prog_bar"
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x0057 }
            r12.setProgressBarShow(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "adspace_t"
            r13 = 1
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x0057 }
            r12.setAdSpaceT(r0)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r0 = "flb_skiptime"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x0057 }
            r12.setFlbSkipTime(r0)     // Catch:{ Exception -> 0x0057 }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = com.mbridge.msdk.foundation.entity.DomainCampaignEx.parseCampaign(r10, r12)     // Catch:{ Exception -> 0x0057 }
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x054d }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x054d }
            java.lang.String r1 = r11.getPackageName()     // Catch:{ Exception -> 0x054d }
            java.lang.String r4 = r11.getImpressionURL()     // Catch:{ Exception -> 0x054d }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x054d }
            r11.setImpressionURL(r0)     // Catch:{ Exception -> 0x054d }
            goto L_0x0555
        L_0x054d:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0590 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r0)     // Catch:{ Exception -> 0x0590 }
        L_0x0555:
            java.lang.String r0 = "vck_t"
            int r0 = r10.optInt(r0, r7)     // Catch:{ Exception -> 0x0590 }
            r11.setVideoCheckType(r0)     // Catch:{ Exception -> 0x0590 }
            java.lang.String r0 = "vctn_t"
            r13 = 1
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x0590 }
            r11.setVideoCtnType(r0)     // Catch:{ Exception -> 0x0590 }
            java.lang.String r0 = "rs_ignc_r"
            org.json.JSONArray r0 = r10.optJSONArray(r0)     // Catch:{ Exception -> 0x0590 }
            if (r0 == 0) goto L_0x059b
            int r1 = r0.length()     // Catch:{ Exception -> 0x0590 }
            if (r1 <= 0) goto L_0x059b
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0590 }
            r1.<init>()     // Catch:{ Exception -> 0x0590 }
            r4 = 0
        L_0x057c:
            int r5 = r0.length()     // Catch:{ Exception -> 0x0590 }
            if (r4 >= r5) goto L_0x0592
            int r5 = r0.optInt(r4)     // Catch:{ Exception -> 0x0590 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0590 }
            r1.add(r5)     // Catch:{ Exception -> 0x0590 }
            int r4 = r4 + 1
            goto L_0x057c
        L_0x0590:
            r0 = move-exception
            goto L_0x0604
        L_0x0592:
            int r0 = r1.size()     // Catch:{ Exception -> 0x0590 }
            if (r0 <= 0) goto L_0x059b
            r11.setRsIgnoreCheckRule(r1)     // Catch:{ Exception -> 0x0590 }
        L_0x059b:
            boolean r0 = r10.has(r2)     // Catch:{ Exception -> 0x0590 }
            if (r0 == 0) goto L_0x05ac
            java.lang.String r0 = r10.getString(r2)     // Catch:{ Exception -> 0x0590 }
            com.mbridge.msdk.foundation.entity.AabEntity r0 = com.mbridge.msdk.foundation.entity.AabEntity.parser(r0)     // Catch:{ Exception -> 0x0590 }
            r11.setAabEntity(r0)     // Catch:{ Exception -> 0x0590 }
        L_0x05ac:
            java.lang.String r0 = "privacy_url"
            java.lang.String r0 = r10.optString(r0, r9)     // Catch:{ Exception -> 0x05c0 }
            r11.setPrivacyUrl(r0)     // Catch:{ Exception -> 0x05c0 }
            java.lang.String r0 = "show_privacy_btn"
            r13 = 0
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x05c0 }
            r11.setPrivacyButtonTemplateVisibility(r0)     // Catch:{ Exception -> 0x05c0 }
            goto L_0x05c8
        L_0x05c0:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0590 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r0)     // Catch:{ Exception -> 0x0590 }
        L_0x05c8:
            java.lang.String r0 = "imp_report_type"
            r13 = 0
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x0590 }
            r11.setImpReportType(r0)     // Catch:{ Exception -> 0x0590 }
            java.lang.String r0 = "auto_mc"
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x0590 }
            r11.setAutoShowStoreMiniCard(r0)     // Catch:{ Exception -> 0x0590 }
            java.lang.String r0 = "mc_trig_t"
            int r0 = r10.optInt(r0, r13)     // Catch:{ Exception -> 0x0590 }
            r11.setShowStoreMiniCardDelayTime(r0)     // Catch:{ Exception -> 0x0590 }
            java.lang.String r0 = "ac"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x0590 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0590 }
            if (r1 != 0) goto L_0x05f8
            r11.setAc(r0)     // Catch:{ Exception -> 0x05f4 }
            goto L_0x05f8
        L_0x05f4:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0590 }
        L_0x05f8:
            java.lang.String r0 = "i_s_c_t"
            int r0 = r10.optInt(r0, r7)     // Catch:{ Exception -> 0x0590 }
            r11.setFilterCallBackState(r0)     // Catch:{ Exception -> 0x0590 }
            return r11
        L_0x0602:
            r0 = move-exception
            r11 = 0
        L_0x0604:
            r0.printStackTrace()
            return r11
        L_0x0608:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaign(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, boolean, com.mbridge.msdk.foundation.entity.CampaignUnit, java.lang.String, java.lang.String):com.mbridge.msdk.foundation.entity.CampaignEx");
    }

    public static JSONObject campaignToJsonObject(CampaignEx campaignEx) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", campaignEx.getId());
        jSONObject.put(JSON_KEY_FLB, campaignEx.getFlb());
        jSONObject.put(JSON_KEY_FLB_SKIP_TIME, campaignEx.getFlbSkipTime());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_VST, campaignEx.getVst());
        jSONObject.put(JSON_KEY_USE_SKIP_TIME, campaignEx.getUseSkipTime());
        jSONObject.put(JSON_KEY_PROG_BAR, campaignEx.getProgressBarShow());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_CBD, campaignEx.getCbd());
        if (!TextUtils.isEmpty(campaignEx.getCampaignUnitId())) {
            jSONObject.put(JSON_KEY_CAMPAIGN_UNITID, campaignEx.getCampaignUnitId());
        }
        if (!TextUtils.isEmpty(campaignEx.getExt_data())) {
            try {
                jSONObject.put(JSON_KEY_EXT_DATA, new JSONObject(campaignEx.getExt_data()));
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(campaignEx.getReq_ext_data())) {
            try {
                jSONObject.put(b.JSON_KEY_REQ_EXT_DATA, new JSONObject(campaignEx.getReq_ext_data()));
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
        if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String put : campaignEx.getPv_urls()) {
                    jSONArray.put(put);
                }
                jSONObject.put("pv_urls", jSONArray);
            } catch (JSONException e7) {
                e7.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
            jSONObject.put(b.JSON_KEY_MOF_TPLID, campaignEx.getMof_tplid());
            jSONObject.put(b.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            jSONObject.put(b.JSON_KEY_NSCPT, campaignEx.getNscpt());
        }
        jSONObject.put(JSON_KEY_READY_RATE, campaignEx.getReady_rate());
        jSONObject.put(JSON_KEY_TITLE, campaignEx.getAppName());
        jSONObject.put(JSON_KEY_DESC, campaignEx.getAppDesc());
        jSONObject.put(JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
        jSONObject.put(JSON_KEY_RETARGET_TYPE, campaignEx.getRtinsType());
        jSONObject.put(JSON_KEY_ICON_URL, campaignEx.getIconUrl());
        jSONObject.put(JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
        jSONObject.put(JSON_KEY_APP_SIZE, campaignEx.getSize());
        jSONObject.put(JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
        jSONObject.put(JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
        jSONObject.put(JSON_KEY_CLICK_URL, campaignEx.getClickURL());
        if (campaignEx.getRewardPlus() != null) {
            jSONObject.put(JSON_KEY_REWARD_PLUS, campaignEx.getRewardPlus().toJsonObject());
        }
        jSONObject.put(JSON_KEY_WITHOUT_INSTALL_CHECK, campaignEx.getWtick());
        jSONObject.put(JSON_KEY_DEEP_LINK_URL, campaignEx.getDeepLinkURL());
        jSONObject.put(JSON_KEY_USER_ACTIVATION, campaignEx.getUserActivation());
        jSONObject.put(JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
        jSONObject.put("template", campaignEx.getTemplate());
        jSONObject.put(JSON_KEY_AD_SOURCE_ID, campaignEx.getType());
        jSONObject.put(JSON_KEY_FCA, campaignEx.getFca());
        jSONObject.put(JSON_KEY_FCB, campaignEx.getFcb());
        jSONObject.put(JSON_KEY_STAR, campaignEx.getRating() + "");
        jSONObject.put(JSON_KEY_NUMBER_RATING, campaignEx.getNumberRating());
        jSONObject.put(JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
        jSONObject.put(JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
        jSONObject.put(JSON_KEY_LINK_TYPE, campaignEx.getLinkType());
        jSONObject.put(JSON_KEY_CLICK_INTERVAL, campaignEx.getClickInterval());
        jSONObject.put(JSON_KEY_CTA_TEXT, campaignEx.getAdCall());
        jSONObject.put(JSON_KEY_ENDCARD_CLICK, campaignEx.getEndcard_click_result());
        jSONObject.put(JSON_KEY_RETARGET_OFFER, campaignEx.getRetarget_offer());
        jSONObject.put(JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
        jSONObject.put(JSON_KEY_VIDEO_LENGTHL, campaignEx.getVideoLength());
        jSONObject.put(JSON_KEY_VIDEO_SIZE, campaignEx.getVideoSize());
        jSONObject.put(JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
        jSONObject.put(JSON_KEY_WATCH_MILE, campaignEx.getWatchMile());
        jSONObject.put(JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
        jSONObject.put(b.JSON_KEY_ONLY_IMPRESSION_URL, campaignEx.getOnlyImpressionURL());
        jSONObject.put(b.JSON_KEY_C_I, campaignEx.getNetAddress());
        jSONObject.put(KEY_ACTIVITY_CHECK_SWITCH, campaignEx.getAc_s());
        jSONObject.put(JSON_KEY_ECPPV, campaignEx.getEcppv());
        jSONObject.put(JSON_KEY_BTY, campaignEx.getBty());
        jSONObject.put(JSON_KEY_T_IMP, campaignEx.getTImp());
        jSONObject.put(JSON_KEY_ADVIMP, campaignEx.getAdvImp());
        jSONObject.put(b.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
        jSONObject.put(b.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
        jSONObject.put(JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
        jSONObject.put(JSON_KEY_OFFER_TYPE, campaignEx.getOfferType());
        jSONObject.put(JSON_KEY_REWARD_AMOUNT, campaignEx.getRewardAmount());
        jSONObject.put(JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
        jSONObject.put(JSON_KEY_GIF_URL, campaignEx.getGifUrl());
        if (ap.b(campaignEx.getNativeVideoTrackingString())) {
            jSONObject.put(JSON_NATIVE_VIDEO_AD_TRACKING, new JSONObject(campaignEx.getNativeVideoTrackingString()));
        }
        jSONObject.put(VIDEO_END_TYPE, campaignEx.getVideo_end_type());
        jSONObject.put(ENDCARD_URL, campaignEx.getendcard_url());
        jSONObject.put(PLAYABLE_ADS_WITHOUT_VIDEO, campaignEx.getPlayable_ads_without_video());
        if (campaignEx.getRewardTemplateMode() != null && ap.b(campaignEx.getRewardTemplateMode().d())) {
            jSONObject.put(JSON_KEY_REWARD_TEMPLATE, new JSONObject(campaignEx.getRewardTemplateMode().d()));
        }
        jSONObject.put(JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
        jSONObject.put(JSON_KEY_CLICK_TIMEOUT_INTERVAL, campaignEx.getClickTimeOutInterval());
        jSONObject.put(JSON_KEY_C_UA, campaignEx.getcUA());
        jSONObject.put(JSON_KEY_IMP_UA, campaignEx.getImpUA());
        jSONObject.put(JSON_KEY_JM_PD, campaignEx.getJmPd());
        jSONObject.put("ia_icon", campaignEx.getKeyIaIcon());
        jSONObject.put("ia_rst", campaignEx.getKeyIaRst());
        jSONObject.put("ia_url", campaignEx.getKeyIaUrl());
        jSONObject.put("ia_ori", campaignEx.getKeyIaOri());
        jSONObject.put("ad_type", campaignEx.getAdType());
        jSONObject.put(KEY_IA_EXT1, campaignEx.getIa_ext1());
        jSONObject.put(KEY_IA_EXT2, campaignEx.getIa_ext2());
        jSONObject.put(KEY_IS_DOWNLOAD, campaignEx.getIsDownLoadZip());
        jSONObject.put(KEY_IA_CACHE, campaignEx.getInteractiveCache());
        jSONObject.put(KEY_OC_TYPE, campaignEx.getOc_type());
        jSONObject.put(KEY_OC_TIME, campaignEx.getOc_time());
        jSONObject.put(KEY_T_LIST, campaignEx.getT_list());
        a adchoice2 = campaignEx.getAdchoice();
        if (adchoice2 != null) {
            jSONObject.put(KEY_ADCHOICE, new JSONObject(adchoice2.a()));
        }
        jSONObject.put(JSON_KEY_PLCT, campaignEx.getPlct());
        jSONObject.put(JSON_KEY_PLCTB, campaignEx.getPlctb());
        jSONObject.put(JSON_KEY_C_C_TIME, campaignEx.getCandidateCacheTime());
        jSONObject.put(KEY_OMID, campaignEx.getOmid());
        jSONObject.put(JSON_KEY_CREATIVE_ID, campaignEx.getCreativeId());
        jSONObject.put("cam_html", campaignEx.getBannerHtml());
        jSONObject.put("cam_tpl_url", campaignEx.getBannerUrl() != null ? campaignEx.getBannerUrl() : campaignEx.getAdZip());
        jSONObject.put(JSON_KEY_MRAID, campaignEx.getMraid());
        jSONObject.put(JSON_KEY_MRAIDFORH5, campaignEx.getMraid());
        jSONObject.put(JSON_KEY_TIMESTAMP, campaignEx.getTimestamp());
        jSONObject.put(JSON_KEY_HB, campaignEx.isBidCampaign);
        jSONObject.put(MBridgeConstans.PLACEMENT_ID, campaignEx.getPlacementId());
        jSONObject.put(JSON_KEY_MAITVE, campaignEx.getMaitve());
        jSONObject.put(JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
        jSONObject.put("vcn", campaignEx.getVcn());
        jSONObject.put("token_r", campaignEx.getTokenRule());
        jSONObject.put("encrypt_p", campaignEx.getEncryptPrice());
        jSONObject.put(JSON_KEY_VIDEO_COMPLETE_TIME, campaignEx.getVideoCompleteTime());
        jSONObject.put(JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRule());
        jSONObject.put(JSON_KEY_VIDEO_CHECK_TYPE, campaignEx.getVideoCheckType());
        jSONObject.put(JSON_KEY_VIDEO_CTN_TYPE, campaignEx.getVideoCtnType());
        jSONObject.put(JSON_KEY_TP_OFFER, campaignEx.getTpOffer());
        jSONObject.put(JSON_KEY_FAC, campaignEx.getFac());
        jSONObject.put(JSON_KEY_LOCAL_REQUEST_ID, campaignEx.getLocalRequestId());
        jSONObject.put(JSON_KEY_PRIVACY_URL, campaignEx.getPrivacyUrl());
        jSONObject.put(PRIVACY_BUTTON_VIDEO_TEMPLATE_SWITCH, campaignEx.getPrivacyButtonTemplateVisibility());
        try {
            jSONObject.put("misk_spt", ak.a());
            jSONObject.put("misk_spt_det", ak.c());
        } catch (JSONException unused) {
        }
        if (campaignEx.getAabEntity() != null) {
            jSONObject.put(JSON_KEY_AAB, campaignEx.getAabEntity().toJson());
        }
        jSONObject.put(JSON_KEY_VIDEO_CREATIVE_ID, campaignEx.getVidCrtvId());
        jSONObject.put(JSON_KEY_EC_CREATIVE_ID, campaignEx.getEcCrtvId());
        jSONObject.put(JSON_KEY_EC_TEMP_ID, campaignEx.getEcTemplateId());
        jSONObject.put(JSON_KEY_IMP_REPORT_TYPE, campaignEx.getImpReportType());
        jSONObject.put(b.JSON_KEY_TK_TCP_PORT, campaignEx.getTrackingTcpPort());
        jSONObject.put(JSON_KEY_AUTO_SHOW_MINI_CARD, campaignEx.getAutoShowStoreMiniCard());
        jSONObject.put(JSON_KEY_SHOW_MINI_CARD_DELAY_TIME, campaignEx.getShowStoreMiniCardDelayTime());
        jSONObject.put(KEY_SHOW_INDEX, campaignEx.getShowIndex());
        jSONObject.put(KEY_SHOW_TYPE, campaignEx.getShowType());
        jSONObject.put(KEY_CLICK_TEMP_SOURCE, campaignEx.getClickTempSource());
        jSONObject.put(KEY_PLAY_TEMP_DISPLAY_TYPE, campaignEx.isTemplateRenderSucc());
        jSONObject.put(KEY_EC_TEMP_DISPLAY_TYPE, campaignEx.isECTemplateRenderSucc());
        jSONObject.put(KEY_TRIGGER_CLICK_SOURCE, campaignEx.getTriggerClickSource());
        jSONObject.put(KEY_ACTIVITY_PATH_AND_NAME, campaignEx.getAc());
        jSONObject.put(KEY_SECOND_REQUEST_CALLBACK_STATE, campaignEx.getFilterCallBackState());
        return DomainCampaignEx.campaignToJsonObject(jSONObject, campaignEx);
    }
}
