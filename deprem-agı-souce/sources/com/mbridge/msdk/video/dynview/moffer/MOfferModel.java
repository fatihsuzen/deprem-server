package com.mbridge.msdk.video.dynview.moffer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.system.NoProGuard;
import com.mbridge.msdk.tracker.network.h;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.dynview.endcard.expose.OnItemExposeListener;
import com.mbridge.msdk.video.dynview.h.b;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.video.dynview.widget.ObservableScrollView;
import com.mbridge.msdk.video.module.a.a;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class MOfferModel implements NoProGuard {
    private static final String MOF_LOAD_RESULT_CODE_OFFER_LESS_THAN_5 = "12930014";
    private static final String MOF_LOAD_RESULT_FAILED = "2";
    private static final String MOF_LOAD_RESULT_SUCCESS = "1";
    private static final String TAG = "MOfferModel";
    private final String AD_NUM = "ad_num";
    private final String API_VERSION = "api_version";
    private final String APP_ID = MBridgeConstans.APP_ID;
    private final String CATEGORY = "category";
    private final String COUNTRY_CODE = "country_code";
    private final String CRT_CID = "crt_cid";
    private final String CRT_RID = "crt_rid";
    private final String DEFAULT_PATH_V3 = "/openapi/ad/v3";
    private final int DO_ACTION_IMPRESSION = 0;
    private final int DO_ACTION_ONLY_IMPRESSION = 1;
    private final String DY_VIEW = "dy_view";

    /* renamed from: E  reason: collision with root package name */
    private final String f12215E = "e";
    private final String EC_ID = "ecid";
    private final String H5_T = "h5_t";
    private final String H5_TYPE = "h5_type";
    private final String HTTP_REQ = "http_req";
    private final String I_FMD5 = "i_fmd5";

    /* renamed from: K  reason: collision with root package name */
    private final String f12216K = CampaignEx.JSON_KEY_AD_K;
    private final String MCC = "mcc";
    private final String MNC = "mnc";
    private final String MOF = "mof";
    private final String MOF_CALLBACK_DATE = "mcd";
    private final String MOF_DATA = "mof_data";
    private final String MOF_DOMAIN = "mof_domain";
    private final String MOF_PARENT_ID = "mof_parent_id";
    private final String MOF_T = "mof_t";
    private final String MOF_TEST_UID = "mof_testuid";
    private final String MOF_TYPE = "mof_type";
    private final String MOF_UID = "mof_uid";
    private final String MOF_VER = "mof_ver";
    private final String MORE_OFFER_CLICK = "more offer click";
    private final String MORE_OFFER_DEFAULT_APP_ID = "92762";
    private final String MORE_OFFER_DEFAULT_APP_KEY = "936dcbdd57fe235fd7cf61c2e93da3c4";
    private final String MORE_OFFER_DEFAULT_UNIT_ID = "117361";
    private final String MORE_OFFER_LOAD_FAILED = "more offer load failed";
    private final String MORE_OFFER_LOAD_SUCCESS = "more offer load success";
    private final String MORE_OFFER_SHOW = "more offer show";
    private final String MORE_OFFER_SHOW_FAILED = "more offer show fail";
    private final String OFFER_ID = "offer_id";
    private final String OFF_SET = TypedValues.CycleType.S_WAVE_OFFSET;
    private final String ONE_ID = "oneId";
    private final String ONLY_IMPRESSION = "only_impression";
    private final String PARENT_AD_TYPE = "parent_ad_type";
    private final String PARENT_EXCHANGE = "parent_exchange";
    private final String PARENT_ID = "parent_id";
    private final String PARENT_TEMPLATE_ID = "parent_template_id";
    private final String PARENT_UNIT = "parent_unit";
    private final String PING_MODE = "ping_mode";
    private final String RV_TID = "rv_tid";
    private final String R_ID = "r_id";
    private final String SIGN = "sign";
    private final String TNUM = "tnum";
    private final String TP_LGP = "tplgp";
    private final String UC_PARENT_UNIT = "uc_parent_unit";
    private final String UNIT_ID = MBridgeConstans.PROPERTIES_UNIT_ID;
    private final String VALUE_AD_NUM = "20";
    private final String VALUE_API_VERSION = "2.3";
    private final String VALUE_CATEGORY = "0";
    private final String VALUE_COUNTRY_CODE = "CN";
    private final String VALUE_DEFAULT_VIDEO_TEMP_ID = "404";
    private final String VALUE_H5_TYPE = "1";
    private final String VALUE_HTTP_REQ = "2";
    private final String VALUE_MOF = "1";
    private final String VALUE_MOF_TYPE = "1";
    private final String VALUE_MOF_VER = "1";
    private final String VALUE_OFF_SET = "0";
    private final String VALUE_ONLY_IMPRESSION = "1";
    private final String VALUE_PING_MODE = "1";
    private final String VALUE_TNUM = "20";
    private final String V_FMD5 = "v_fmd5";
    /* access modifiers changed from: private */
    public int admf;
    /* access modifiers changed from: private */
    public int admftm;
    /* access modifiers changed from: private */
    public int bitmapSuccessCount = 0;
    /* access modifiers changed from: private */
    public List<Integer> cacheImpressionReportList;
    /* access modifiers changed from: private */
    public List<Integer> cacheOnlyImpressionReportList;
    /* access modifiers changed from: private */
    public volatile boolean hasReportMoreOfferLoad = false;
    /* access modifiers changed from: private */
    public volatile boolean hasReportMoreOfferShow = false;
    /* access modifiers changed from: private */
    public boolean isOnlyImpShow = false;
    /* access modifiers changed from: private */
    public boolean isShowMoreOffer;
    /* access modifiers changed from: private */
    public CampaignUnit mCampaignUnit;
    /* access modifiers changed from: private */
    public Context mContext;
    private int mControlShowSize = 0;
    private int mFromType = 0;
    private boolean mHasReportMofScenes = false;
    private List<Integer> mImpressionId = new ArrayList();
    /* access modifiers changed from: private */
    public boolean mIsRetry = false;
    /* access modifiers changed from: private */
    public LinearLayout mLinearLayout;
    /* access modifiers changed from: private */
    public CampaignEx mMainOfferCampaignEx;
    /* access modifiers changed from: private */
    public g mMoreOfferLayoutListener;
    /* access modifiers changed from: private */
    public c mMoreOfferShowCallBack = new c() {
        public final void a(List<View> list) {
            TextView textView;
            if (MOfferModel.this.viewMofferLayout != null && (textView = (TextView) MOfferModel.this.viewMofferLayout.findViewById(MOfferModel.this.findID("mbridge_reward_end_card_like_tv"))) != null) {
                textView.setVisibility(0);
            }
        }
    };
    /* access modifiers changed from: private */
    public a mNotifyListener;
    /* access modifiers changed from: private */
    public ObservableScrollView mObservableScrollView;
    /* access modifiers changed from: private */
    public e mParam;
    /* access modifiers changed from: private */
    public String mRid;
    /* access modifiers changed from: private */
    public String mUnitId;
    private OnItemExposeListener onItemExposeListener = new OnItemExposeListener() {
        public final void onItemViewFirstVisible() {
            if (MOfferModel.this.viewMofferLayout != null && MOfferModel.this.isOnlyImpShow) {
                if (MOfferModel.this.viewMofferLayout.getVisibility() == 0) {
                    try {
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mCampaignUnit, 0, 1, "117361");
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                } else {
                    if (MOfferModel.this.cacheOnlyImpressionReportList == null) {
                        List unused = MOfferModel.this.cacheOnlyImpressionReportList = new ArrayList();
                    }
                    MOfferModel.this.cacheOnlyImpressionReportList.add(0);
                }
            }
        }

        public final void onItemViewVisible(boolean z4, int i5) {
            if (MOfferModel.this.viewMofferLayout != null) {
                if (MOfferModel.this.viewMofferLayout.getVisibility() == 0) {
                    if (!MOfferModel.this.hasReportMoreOfferShow) {
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, c.m().c(), "more offer show", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                        boolean unused = MOfferModel.this.hasReportMoreOfferShow = true;
                    }
                    try {
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mCampaignUnit, i5, 0, "117361");
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                } else {
                    if (MOfferModel.this.cacheImpressionReportList == null) {
                        List unused2 = MOfferModel.this.cacheImpressionReportList = new ArrayList();
                    }
                    if (!MOfferModel.this.cacheImpressionReportList.contains(Integer.valueOf(i5))) {
                        MOfferModel.this.cacheImpressionReportList.add(Integer.valueOf(i5));
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public MBridgeRelativeLayout viewMofferLayout;

    static /* synthetic */ int access$2208(MOfferModel mOfferModel) {
        int i5 = mOfferModel.bitmapSuccessCount;
        mOfferModel.bitmapSuccessCount = i5 + 1;
        return i5;
    }

    private void addLikeTextView() {
        TextView textView;
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout != null && (textView = (TextView) mBridgeRelativeLayout.findViewById(findID("mbridge_reward_end_card_like_tv"))) != null) {
            textView.setTextColor(Color.parseColor("#FF000000"));
            textView.setTextSize(10.0f);
            if (ab.t(c.m().c()).contains("zh")) {
                textView.setEms(1);
                textView.getLayoutParams().width = ak.a(c.m().c(), 30.0f);
                textView.setText("猜你喜欢");
            } else {
                textView.setText("Just\nfor\nYou");
            }
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MOfferModel.this.mObservableScrollView != null) {
                        if (MOfferModel.this.mObservableScrollView.getVisibility() == 0) {
                            MOfferModel.this.mObservableScrollView.setVisibility(8);
                        } else {
                            MOfferModel.this.mObservableScrollView.setVisibility(0);
                        }
                    }
                    try {
                        new b().a((View) MOfferModel.this.mLinearLayout, 300);
                    } catch (Exception e5) {
                        af.b(MOfferModel.TAG, e5.getMessage());
                    }
                }
            });
        }
    }

    private View buildItemView(final int i5) {
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        final View inflate = LayoutInflater.from(this.mContext).inflate(x.a(context, "mbridge_reward_end_card_more_offer_item", TtmlNode.TAG_LAYOUT), (ViewGroup) null, false);
        int a5 = x.a(this.mContext, "mbridge_reward_end_card_item_iv", "id");
        if (inflate == null) {
            return null;
        }
        setOfferData(this.mCampaignUnit.getAds(), i5, (RoundImageView) inflate.findViewById(a5), (TextView) inflate.findViewById(x.a(this.mContext, "mbridge_reward_end_card_item_title_tv", "id")));
        inflate.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CampaignEx campaignEx;
                try {
                    if (MOfferModel.this.mCampaignUnit != null && MOfferModel.this.mCampaignUnit.ads != null && MOfferModel.this.mCampaignUnit.ads.size() > 0 && (campaignEx = MOfferModel.this.mCampaignUnit.ads.get(i5)) != null) {
                        if (MOfferModel.this.mNotifyListener != null) {
                            MOfferModel mOfferModel = MOfferModel.this;
                            mOfferModel.callBackClick(mOfferModel.mNotifyListener);
                        }
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, c.m().c(), "more offer click", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                        com.mbridge.msdk.video.dynview.f.a.a(c.m().c(), campaignEx, MOfferModel.this.mUnitId, inflate);
                    }
                } catch (Exception e5) {
                    af.b(MOfferModel.TAG, e5.getMessage());
                }
            }
        });
        return inflate;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0262  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void buildRequestParams(com.mbridge.msdk.foundation.entity.CampaignEx r28) {
        /*
            r27 = this;
            r1 = r27
            java.lang.String r0 = "CN"
            if (r28 != 0) goto L_0x0007
            return
        L_0x0007:
            com.mbridge.msdk.foundation.same.net.f.e r2 = new com.mbridge.msdk.foundation.same.net.f.e
            r2.<init>()
            r1.mParam = r2
            java.lang.String r2 = r28.getCampaignUnitId()
            java.lang.String r3 = r28.getId()
            java.lang.String r4 = r28.getRequestIdNotice()
            r28.getRequestId()
            java.lang.String r5 = r28.getendcard_url()
            java.lang.String r6 = "mof_testuid"
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.aq.a(r5, r6)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L_0x0037
            java.lang.String r5 = r28.getendcard_url()
            java.lang.String r6 = "mof_uid"
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.aq.a(r5, r6)
        L_0x0037:
            com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r6 = r6.k()
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x005c }
            if (r7 != 0) goto L_0x005c
            com.mbridge.msdk.c.h r7 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x005c }
            com.mbridge.msdk.c.g r7 = r7.b(r6)     // Catch:{ Exception -> 0x005c }
            if (r7 == 0) goto L_0x005c
            com.mbridge.msdk.c.h r7 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x005c }
            com.mbridge.msdk.c.g r7 = r7.b(r6)     // Catch:{ Exception -> 0x005c }
            java.lang.String r7 = r7.r()     // Catch:{ Exception -> 0x005c }
            goto L_0x005d
        L_0x005c:
            r7 = r0
        L_0x005d:
            java.lang.String r8 = r28.getendcard_url()
            java.lang.String r9 = "mcc"
            java.lang.String r8 = com.mbridge.msdk.foundation.tools.aq.a(r8, r9)
            java.lang.String r10 = r28.getendcard_url()
            java.lang.String r11 = "mnc"
            java.lang.String r10 = com.mbridge.msdk.foundation.tools.aq.a(r10, r11)
            java.lang.String r12 = r28.getendcard_url()
            java.lang.String r13 = "rv_tid"
            java.lang.String r12 = com.mbridge.msdk.foundation.tools.aq.a(r12, r13)
            java.lang.String r14 = r28.getendcard_url()
            java.lang.String r15 = "ecid"
            boolean r14 = r14.contains(r15)
            if (r14 == 0) goto L_0x0092
            java.lang.String r14 = r28.getendcard_url()
            java.lang.String r14 = com.mbridge.msdk.foundation.tools.aq.a(r14, r15)
        L_0x008f:
            r16 = r0
            goto L_0x009b
        L_0x0092:
            long r16 = r28.getEcTemplateId()
            java.lang.String r14 = java.lang.String.valueOf(r16)
            goto L_0x008f
        L_0x009b:
            java.lang.String r0 = r28.getendcard_url()
            r17 = r5
            java.lang.String r5 = "tplgp"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.aq.a(r0, r5)
            r18 = r7
            java.lang.String r7 = r28.getendcard_url()
            r19 = r0
            java.lang.String r0 = "v_fmd5"
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.aq.a(r7, r0)
            r20 = r0
            java.lang.String r0 = r28.getendcard_url()
            r21 = r7
            java.lang.String r7 = "i_fmd5"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.aq.a(r0, r7)
            r22 = r0
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            com.mbridge.msdk.foundation.controller.c r23 = com.mbridge.msdk.foundation.controller.c.m()
            r24 = r7
            java.lang.String r7 = r23.k()
            r23 = r5
            java.lang.String r5 = "app_id"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r5, r7)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()
            java.lang.String r6 = r6.b()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r6 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r6)
            java.lang.String r7 = "sign"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r7, r6)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            r25 = r6
            java.lang.String r6 = ""
            if (r25 == 0) goto L_0x010c
            r25 = r7
            r7 = r6
        L_0x0109:
            r26 = r5
            goto L_0x0110
        L_0x010c:
            r25 = r7
            r7 = r4
            goto L_0x0109
        L_0x0110:
            java.lang.String r5 = "r_id"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r5, r7)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String[] r5 = new java.lang.String[]{r3}
            java.lang.String r5 = java.util.Arrays.toString(r5)
            java.lang.String r7 = "e"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r7, r5)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r5 = "mof_type"
            java.lang.String r7 = "1"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r5, r7)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r5 = "h5_type"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r5, r7)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r5 = "mof"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r5, r7)
            boolean r0 = android.text.TextUtils.isEmpty(r18)
            if (r0 == 0) goto L_0x0144
            r0 = r16
            goto L_0x0146
        L_0x0144:
            r0 = r18
        L_0x0146:
            com.mbridge.msdk.foundation.same.net.f.e r5 = r1.mParam
            r16 = r15
            java.lang.String r15 = "country_code"
            com.mbridge.msdk.foundation.same.net.e.b.a(r5, r15, r0)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r5 = "mof_ver"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r5, r7)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r5 = "parent_exchange"
            r0.a(r5, r6)
            int r0 = r28.getAdType()
            r5 = 94
            if (r0 == r5) goto L_0x016d
            r5 = 287(0x11f, float:4.02E-43)
            if (r0 == r5) goto L_0x016a
            goto L_0x016f
        L_0x016a:
            java.lang.String r6 = "interstitial_video"
            goto L_0x016f
        L_0x016d:
            java.lang.String r6 = "rewarded_video"
        L_0x016f:
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r5 = "parent_ad_type"
            r0.a(r5, r6)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r5 = "oneId"
            java.lang.String r6 = r28.getReq_ext_data()
            r0.a(r5, r6)
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            java.lang.String r5 = "parent_template_id"
            if (r0 != 0) goto L_0x018f
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            r0.a(r5, r14)
            goto L_0x0196
        L_0x018f:
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r6 = "404"
            r0.a(r5, r6)
        L_0x0196:
            boolean r0 = android.text.TextUtils.isEmpty(r17)
            if (r0 == 0) goto L_0x01a4
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r5 = "uc_parent_unit"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r5, r2)
            goto L_0x01ab
        L_0x01a4:
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r5 = "parent_unit"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r5, r2)
        L_0x01ab:
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r11, r10)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r9, r8)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r0 = "crt_cid"
            r2.put(r0, r3)     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = "crt_rid"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x01ed }
            r2.put(r13, r12)     // Catch:{ Exception -> 0x01ed }
            r0 = r16
            r2.put(r0, r14)     // Catch:{ Exception -> 0x01ed }
            r0 = r19
            r4 = r23
            r2.put(r4, r0)     // Catch:{ Exception -> 0x01ed }
            r4 = r20
            r0 = r21
            r2.put(r4, r0)     // Catch:{ Exception -> 0x01ed }
            r0 = r22
            r4 = r24
            r2.put(r4, r0)     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = "h5_t"
            r4 = 1
            r2.put(r0, r4)     // Catch:{ Exception -> 0x01ed }
            java.lang.String r0 = "mof_t"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x01ed }
            goto L_0x01f1
        L_0x01ed:
            r0 = move-exception
            r0.printStackTrace()
        L_0x01f1:
            java.lang.String r0 = r2.toString()
            com.mbridge.msdk.foundation.same.net.f.e r2 = r1.mParam
            java.lang.String r4 = "mof_data"
            com.mbridge.msdk.foundation.same.net.e.b.a(r2, r4, r0)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "offer_id"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "offset"
            java.lang.String r3 = "0"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "category"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "only_impression"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r2, r7)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "ping_mode"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r2, r7)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "http_req"
            java.lang.String r3 = "2"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "ad_num"
            java.lang.String r3 = "20"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "tnum"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r2, r3)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "api_version"
            java.lang.String r3 = "2.3"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r2, r3)
            boolean r0 = android.text.TextUtils.isEmpty(r17)
            if (r0 == 0) goto L_0x0262
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "92762"
            r3 = r26
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r3, r2)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "92762936dcbdd57fe235fd7cf61c2e93da3c4"
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r2)
            r3 = r25
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r3, r2)
            java.lang.String r5 = "117361"
            goto L_0x0264
        L_0x0262:
            r5 = r17
        L_0x0264:
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "unit_id"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r2, r5)
            com.mbridge.msdk.foundation.same.net.f.e r0 = r1.mParam
            java.lang.String r2 = "dy_view"
            com.mbridge.msdk.foundation.same.net.e.b.a(r0, r2, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.moffer.MOfferModel.buildRequestParams(com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    private void buildScrollViewGroup() {
        if (this.mContext != null && this.viewMofferLayout != null && this.mMainOfferCampaignEx != null) {
            this.mLinearLayout = new LinearLayout(this.mContext);
            this.mLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
            this.mLinearLayout.setOrientation(0);
            this.mLinearLayout.setGravity(17);
            for (int i5 = 0; i5 < this.mCampaignUnit.ads.size(); i5++) {
                View buildItemView = buildItemView(i5);
                if (buildItemView != null) {
                    this.mLinearLayout.addView(buildItemView);
                }
            }
            this.mObservableScrollView.addView(this.mLinearLayout);
            this.mObservableScrollView.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    MOfferModel.this.checkViewVisiableState();
                    return false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void callBackClick(a aVar) {
        if (aVar != null) {
            aVar.a(128, "");
        }
    }

    private void createMoreOfferList() {
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout != null) {
            this.mObservableScrollView = (ObservableScrollView) mBridgeRelativeLayout.findViewById(findID("mbridge_moreoffer_hls"));
            buildScrollViewGroup();
            addLikeTextView();
            showView();
        }
    }

    /* access modifiers changed from: private */
    public void createMoreOfferView() {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit != null && this.mContext != null && campaignUnit.getAds() != null && this.mCampaignUnit.getAds().size() != 0) {
            setMoreOfferLayoutCallBack();
            createMoreOfferList();
        }
    }

    private void doAdmfContorl() {
        JSONObject jSONObject;
        try {
            CampaignEx campaignEx = this.mMainOfferCampaignEx;
            if (campaignEx == null) {
                return;
            }
            if (!TextUtils.isEmpty(campaignEx.getMoreOfferJsonData())) {
                JSONObject jSONObject2 = new JSONObject(this.mMainOfferCampaignEx.getMoreOfferJsonData());
                int i5 = this.mFromType;
                if (i5 == 1) {
                    jSONObject = jSONObject2.getJSONObject("template_url");
                } else if (i5 != 2) {
                    jSONObject = null;
                } else {
                    jSONObject = jSONObject2.getJSONObject(CampaignEx.ENDCARD_URL);
                }
                if (jSONObject != null) {
                    if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM)) {
                        this.admftm = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
                    }
                    if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF)) {
                        this.admf = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
                    }
                }
            }
        } catch (Exception e5) {
            af.b(TAG, e5.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void doControllableImpOnRequest() {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit != null) {
            try {
                com.mbridge.msdk.video.dynview.f.a.a(campaignUnit, 0, 1, "117361");
                this.isOnlyImpShow = true;
                if (this.mCampaignUnit.getAds() != null) {
                    int size = this.mCampaignUnit.getAds().size();
                    if (this.admf >= size) {
                        this.admf = size;
                    }
                    if (this.mImpressionId == null) {
                        this.mImpressionId = new ArrayList();
                    }
                    for (int i5 = 0; i5 < this.admf; i5++) {
                        if (!this.mImpressionId.contains(Integer.valueOf(i5))) {
                            com.mbridge.msdk.video.dynview.f.a.a(this.mCampaignUnit, i5, 0, "117361");
                            this.mImpressionId.add(Integer.valueOf(i5));
                        }
                    }
                }
            } catch (Exception e5) {
                af.b(TAG, e5.getMessage());
            }
        }
    }

    private void doControllableImpOnShow(int i5) {
        CampaignUnit campaignUnit = this.mCampaignUnit;
        if (campaignUnit != null && campaignUnit.getAds() != null) {
            try {
                int size = this.mCampaignUnit.getAds().size();
                if (this.mControlShowSize == 0) {
                    this.mControlShowSize = this.admf + i5;
                }
                if (this.mControlShowSize >= size) {
                    this.mControlShowSize = size;
                }
                while (i5 < this.mControlShowSize) {
                    if (!this.mImpressionId.contains(Integer.valueOf(i5))) {
                        com.mbridge.msdk.video.dynview.f.a.a(this.mCampaignUnit, i5, 0, "117361");
                        this.mImpressionId.add(Integer.valueOf(i5));
                    }
                    i5++;
                }
            } catch (Exception e5) {
                af.b(TAG, e5.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public int findID(String str) {
        return x.a(c.m().c(), str, "id");
    }

    private void initData() {
        CampaignEx campaignEx = this.mMainOfferCampaignEx;
        if (campaignEx != null && this.mContext != null) {
            buildRequestParams(campaignEx);
            if (this.mParam != null) {
                com.mbridge.msdk.video.dynview.f.b bVar = new com.mbridge.msdk.video.dynview.f.b(this.mContext);
                AnonymousClass3 r7 = new com.mbridge.msdk.video.dynview.f.a.a() {
                    public final void a(List<h> list, CampaignUnit campaignUnit) {
                        if (MOfferModel.this.mParam == null || campaignUnit == null) {
                            a.a().b();
                            return;
                        }
                        try {
                            MOfferModel mOfferModel = MOfferModel.this;
                            String unused = mOfferModel.mUnitId = mOfferModel.mParam.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
                            MOfferModel mOfferModel2 = MOfferModel.this;
                            String unused2 = mOfferModel2.mRid = mOfferModel2.mParam.a().get("r_id");
                            if (campaignUnit.getAds() != null) {
                                if (campaignUnit.getAds().size() >= 5) {
                                    CampaignUnit unused3 = MOfferModel.this.mCampaignUnit = campaignUnit;
                                    if (MOfferModel.this.admf > 0 && MOfferModel.this.admftm == 1) {
                                        MOfferModel.this.doControllableImpOnRequest();
                                    }
                                    if (!MOfferModel.this.hasReportMoreOfferLoad) {
                                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, c.m().c(), "more offer load success", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                                        boolean unused4 = MOfferModel.this.hasReportMoreOfferLoad = true;
                                    }
                                    com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                                    eVar.a("result", "1");
                                    if (MOfferModel.this.mIsRetry) {
                                        eVar.a("retry", "1");
                                    }
                                    d.a().a("m_mof_req_result", MOfferModel.this.mMainOfferCampaignEx, eVar);
                                    MOfferModel.this.createMoreOfferView();
                                    return;
                                }
                            }
                            if (!MOfferModel.this.hasReportMoreOfferLoad) {
                                com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, c.m().c(), "more offer load failed errorCode: -999 errorMsg: The campaign quantity less than 5.", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                                boolean unused5 = MOfferModel.this.hasReportMoreOfferLoad = true;
                            }
                            com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                            eVar2.a("result", "2");
                            eVar2.a("code", MOfferModel.MOF_LOAD_RESULT_CODE_OFFER_LESS_THAN_5);
                            if (MOfferModel.this.mIsRetry) {
                                eVar2.a("retry", "1");
                            }
                            d.a().a("m_mof_req_result", MOfferModel.this.mMainOfferCampaignEx, eVar2);
                            a.a().b();
                        } catch (Exception e5) {
                            af.b(MOfferModel.TAG, e5.getMessage());
                            a.a().b();
                        }
                    }

                    public final void a(int i5, String str) {
                        if (MOfferModel.this.mParam == null) {
                            a.a().b();
                            return;
                        }
                        try {
                            MOfferModel mOfferModel = MOfferModel.this;
                            String unused = mOfferModel.mUnitId = mOfferModel.mParam.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
                            MOfferModel mOfferModel2 = MOfferModel.this;
                            String unused2 = mOfferModel2.mRid = mOfferModel2.mParam.a().get("r_id");
                            if (!MOfferModel.this.hasReportMoreOfferLoad) {
                                CampaignEx access$200 = MOfferModel.this.mMainOfferCampaignEx;
                                Context c5 = c.m().c();
                                com.mbridge.msdk.video.dynview.f.a.a(access$200, c5, "more offer load failed errorCode:" + i5 + "errorMsg:" + str, MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                                boolean unused3 = MOfferModel.this.hasReportMoreOfferLoad = true;
                            }
                            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                            eVar.a("result", "2");
                            eVar.a("code", i5 + "");
                            if (MOfferModel.this.mIsRetry) {
                                eVar.a("retry", "1");
                            }
                            d.a().a("m_mof_req_result", MOfferModel.this.mMainOfferCampaignEx, eVar);
                            a.a().b();
                        } catch (Exception e5) {
                            af.b(MOfferModel.TAG, e5.getMessage());
                            a.a().b();
                        }
                    }
                };
                String str = com.mbridge.msdk.foundation.same.net.e.d.f().f9352M;
                if (!TextUtils.isEmpty(this.mMainOfferCampaignEx.getReq_ext_data())) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.mMainOfferCampaignEx.getReq_ext_data());
                        String optString = jSONObject.optString("mof_domain");
                        if (!TextUtils.isEmpty(optString)) {
                            str = optString + "/openapi/ad/v3";
                        }
                        String optString2 = jSONObject.optString("parent_id");
                        if (!TextUtils.isEmpty(optString2)) {
                            com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "mof_parent_id", optString2);
                        }
                        String optString3 = jSONObject.optString("oneId");
                        if (!TextUtils.isEmpty(optString3)) {
                            com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "oneId", optString3);
                        }
                        String optString4 = jSONObject.optString("mcd");
                        if (!TextUtils.isEmpty(optString4)) {
                            com.mbridge.msdk.foundation.same.net.e.b.a(this.mParam, "mcd", optString4);
                        }
                        r7.setUnitId(this.mMainOfferCampaignEx.getCampaignUnitId());
                    } catch (Exception e5) {
                        af.b(TAG, e5.getMessage());
                        str = com.mbridge.msdk.foundation.same.net.e.d.f().f9352M;
                    }
                }
                String str2 = str;
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                if (this.mIsRetry) {
                    eVar.a("retry", "1");
                }
                d.a().a("m_mof_initiate", this.mMainOfferCampaignEx, eVar);
                bVar.getLoadOrSetting(1, str2, this.mParam, r7, true, "more_offer", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                doAdmfContorl();
            }
        }
    }

    private void initView() {
        Context context = this.mContext;
        if (context != null) {
            this.viewMofferLayout = (MBridgeRelativeLayout) LayoutInflater.from(this.mContext).inflate(x.a(context, "mbridge_reward_more_offer_view", TtmlNode.TAG_LAYOUT), (ViewGroup) null, false);
        }
    }

    /* access modifiers changed from: private */
    public void release() {
        List<Integer> list = this.cacheImpressionReportList;
        if (list != null) {
            list.clear();
            this.cacheImpressionReportList = null;
        }
        List<Integer> list2 = this.cacheOnlyImpressionReportList;
        if (list2 != null) {
            list2.clear();
            this.cacheOnlyImpressionReportList = null;
        }
    }

    private void setCallbackForLogicVisibleView(View view, int i5) {
        boolean z4;
        if (view != null) {
            try {
                Rect rect = new Rect();
                boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
                if (rect.width() > view.getMeasuredWidth() / 5) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (globalVisibleRect && z4) {
                    List<Integer> list = this.mImpressionId;
                    if (list != null && this.onItemExposeListener != null) {
                        if (!list.contains(Integer.valueOf(i5))) {
                            this.mImpressionId.add(Integer.valueOf(i5));
                            this.onItemExposeListener.onItemViewVisible(true, i5);
                        }
                    }
                } else if (this.admf != 0) {
                    doControllableImpOnShow(i5);
                }
            } catch (Exception e5) {
                af.b(TAG, e5.getMessage());
            }
        }
    }

    private void setMoreOfferLayoutCallBack() {
        MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
        if (mBridgeRelativeLayout != null) {
            mBridgeRelativeLayout.setMoreOfferCacheReportCallBack(new b() {
                public final void a() {
                    try {
                        if (MOfferModel.this.cacheImpressionReportList != null) {
                            for (int i5 = 0; i5 < MOfferModel.this.cacheImpressionReportList.size(); i5++) {
                                if (!MOfferModel.this.hasReportMoreOfferShow) {
                                    com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, MOfferModel.this.mContext, "more offer show", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                                    boolean unused = MOfferModel.this.hasReportMoreOfferShow = true;
                                }
                                com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mCampaignUnit, ((Integer) MOfferModel.this.cacheImpressionReportList.get(i5)).intValue(), 0, "117361");
                            }
                        }
                        if (!MOfferModel.this.isOnlyImpShow && MOfferModel.this.cacheOnlyImpressionReportList != null) {
                            for (int i6 = 0; i6 < MOfferModel.this.cacheOnlyImpressionReportList.size(); i6++) {
                                com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mCampaignUnit, ((Integer) MOfferModel.this.cacheOnlyImpressionReportList.get(i6)).intValue(), 1, "117361");
                            }
                        }
                        MOfferModel.this.release();
                    } catch (Exception e5) {
                        af.b(MOfferModel.TAG, e5.getMessage());
                    }
                }
            });
            this.viewMofferLayout.setMoreOfferShowFailedCallBack(new d() {
                public final void a() {
                    if (!(MOfferModel.this.viewMofferLayout == null || MOfferModel.this.viewMofferLayout.getVisibility() == 0)) {
                        com.mbridge.msdk.video.dynview.f.a.a(MOfferModel.this.mMainOfferCampaignEx, MOfferModel.this.mContext, "more offer show fail", MOfferModel.this.mUnitId, MOfferModel.this.mRid);
                    }
                    MOfferModel.this.release();
                }
            });
        }
    }

    private void setOfferData(List<CampaignEx> list, int i5, final RoundImageView roundImageView, TextView textView) {
        CampaignEx campaignEx;
        if (roundImageView != null && textView != null && list != null && this.mContext != null && this.mMainOfferCampaignEx != null && list.size() > 0 && (campaignEx = list.get(i5)) != null) {
            roundImageView.setImageDrawable((Drawable) null);
            com.mbridge.msdk.foundation.same.c.b.a(this.mContext).a(campaignEx.getIconUrl(), new com.mbridge.msdk.foundation.same.c.c() {
                public final void onFailedLoad(String str, String str2) {
                }

                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    try {
                        if (!(roundImageView == null || bitmap == null || bitmap.isRecycled())) {
                            roundImageView.setBorderRadius(13);
                            roundImageView.setImageBitmap(bitmap);
                        }
                        MOfferModel.access$2208(MOfferModel.this);
                        if (!MOfferModel.this.isShowMoreOffer && MOfferModel.this.bitmapSuccessCount >= 5 && MOfferModel.this.mMoreOfferShowCallBack != null) {
                            boolean unused = MOfferModel.this.isShowMoreOffer = true;
                            MOfferModel.this.mMoreOfferShowCallBack.a((List<View>) null);
                        }
                    } catch (Exception e5) {
                        af.b(MOfferModel.TAG, e5.getMessage());
                    }
                }
            });
            if (!TextUtils.isEmpty(campaignEx.getAppName())) {
                String a5 = aq.a(this.mMainOfferCampaignEx.getendcard_url(), "mof_textmod");
                if (TextUtils.isEmpty(a5) || !a5.equals("1")) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(campaignEx.getAppName());
                }
            }
        }
    }

    public void buildMofferAd(CampaignEx campaignEx) {
        Context c5 = c.m().c();
        this.mContext = c5;
        if (c5 != null) {
            this.mMainOfferCampaignEx = campaignEx;
            initView();
            initData();
        }
    }

    public void checkViewVisiableState() {
        if (this.mLinearLayout != null) {
            int i5 = 0;
            while (i5 < this.mLinearLayout.getChildCount()) {
                try {
                    setCallbackForLogicVisibleView(this.mLinearLayout.getChildAt(i5), i5);
                    i5++;
                } catch (Exception e5) {
                    af.b(TAG, e5.getMessage());
                    return;
                }
            }
        }
    }

    public long getECParentTemplateCode() {
        String str = "";
        try {
            e eVar = this.mParam;
            if (eVar != null) {
                str = eVar.a().get("parent_template_id");
            }
            if (TextUtils.isEmpty(str)) {
                return 404;
            }
            return Long.parseLong(str);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return 404;
        }
    }

    public CampaignEx getmMainOfferCampaignEx() {
        return this.mMainOfferCampaignEx;
    }

    public void mofDestroy() {
        if (this.mMoreOfferLayoutListener != null) {
            this.mMoreOfferLayoutListener = null;
        }
        if (this.onItemExposeListener != null) {
            this.onItemExposeListener = null;
        }
        if (this.mMoreOfferShowCallBack != null) {
            this.mMoreOfferShowCallBack = null;
        }
        if (this.mNotifyListener != null) {
            this.mNotifyListener = null;
        }
    }

    public void setFromType(int i5) {
        this.mFromType = i5;
    }

    public void setIsRetry(boolean z4) {
        this.mIsRetry = z4;
    }

    public void setMoreOfferListener(g gVar, a aVar) {
        this.mMoreOfferLayoutListener = gVar;
        this.mNotifyListener = aVar;
    }

    public void showView() {
        CampaignUnit campaignUnit;
        g gVar = this.mMoreOfferLayoutListener;
        if (gVar != null) {
            MBridgeRelativeLayout mBridgeRelativeLayout = this.viewMofferLayout;
            if (mBridgeRelativeLayout == null || (campaignUnit = this.mCampaignUnit) == null) {
                gVar.a(-1, "more Offer create fail");
                return;
            }
            gVar.a((ViewGroup) mBridgeRelativeLayout, campaignUnit);
            if (!this.isOnlyImpShow) {
                com.mbridge.msdk.video.dynview.f.a.a(this.mCampaignUnit, 0, 1, "117361");
            }
            if (!this.mHasReportMofScenes) {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("scene", this.mFromType + "");
                d.a().a("m_mof_scenes", this.mMainOfferCampaignEx, eVar);
            }
        }
    }
}
