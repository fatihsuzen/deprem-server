package com.mbridge.msdk.video.bt.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.videocommon.view.StarLevelView;
import com.mbridge.msdk.widget.a;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeBTNativeEC extends MBridgeBTNativeECDiff {

    /* renamed from: A  reason: collision with root package name */
    private TextView f11923A;

    /* renamed from: B  reason: collision with root package name */
    private StarLevelView f11924B;
    /* access modifiers changed from: private */

    /* renamed from: C  reason: collision with root package name */
    public boolean f11925C = false;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public boolean f11926D = false;

    /* renamed from: E  reason: collision with root package name */
    private int f11927E = 0;

    /* renamed from: F  reason: collision with root package name */
    private Runnable f11928F;

    /* renamed from: G  reason: collision with root package name */
    private boolean f11929G = false;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public View f11930H;
    /* access modifiers changed from: private */

    /* renamed from: I  reason: collision with root package name */
    public String f11931I;

    /* renamed from: J  reason: collision with root package name */
    private k f11932J;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public WebView f11933K;

    /* renamed from: p  reason: collision with root package name */
    private ViewGroup f11934p;

    /* renamed from: q  reason: collision with root package name */
    private ViewGroup f11935q;

    /* renamed from: r  reason: collision with root package name */
    private RelativeLayout f11936r;

    /* renamed from: s  reason: collision with root package name */
    private ImageView f11937s;

    /* renamed from: t  reason: collision with root package name */
    private RoundImageView f11938t;

    /* renamed from: u  reason: collision with root package name */
    private ImageView f11939u;

    /* renamed from: v  reason: collision with root package name */
    private ImageView f11940v;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f11941w;

    /* renamed from: x  reason: collision with root package name */
    private ImageView f11942x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f11943y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f11944z;

    public MBridgeBTNativeEC(Context context) {
        super(context);
    }

    @TargetApi(17)
    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            RenderScript create = RenderScript.create(this.f11819a.getApplicationContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(10.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            bitmap.recycle();
            create.destroy();
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void init(Context context) {
        String str;
        boolean z4;
        if (isLandscape()) {
            str = "mbridge_reward_endcard_native_land";
        } else {
            str = "mbridge_reward_endcard_native_hor";
        }
        int findLayout = findLayout(str);
        if (findLayout > 0) {
            if (isLandscape()) {
                ViewGroup viewGroup = (ViewGroup) this.f11824f.inflate(findLayout, (ViewGroup) null);
                this.f11935q = viewGroup;
                addView(viewGroup);
                z4 = b((View) this.f11935q);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) this.f11824f.inflate(findLayout, (ViewGroup) null);
                this.f11934p = viewGroup2;
                addView(viewGroup2);
                z4 = b((View) this.f11934p);
            }
            this.f11826h = z4;
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f11928F == null) {
            this.f11928F = new Runnable() {
                public final void run() {
                    boolean unused = MBridgeBTNativeEC.this.f11926D = true;
                    if (MBridgeBTNativeEC.this.f11930H != null) {
                        MBridgeBTNativeEC.this.f11930H.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.f11928F;
        if (runnable != null) {
            postDelayed(runnable, (long) (this.f11927E * 1000));
        }
        if (!this.f11826h && this.f11933K != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f11822d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f11931I);
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                af.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
            } catch (JSONException e5) {
                af.a(BTBaseView.TAG, e5.getMessage());
            }
            g.a().a(this.f11933K, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        }
        if (this.f11933K != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", this.f11822d);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f11931I);
                jSONObject3.put(DataSchemeDataSource.SCHEME_DATA, jSONObject4);
                af.a(BTBaseView.TAG, "NativeEC Call H5 onEndCardShow " + jSONObject3.toString());
            } catch (JSONException e6) {
                af.a(BTBaseView.TAG, e6.getMessage());
            }
            g.a().a(this.f11933K, "onNativeECShow", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
        }
    }

    public void onDestory() {
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f11928F;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        int i5 = configuration.orientation;
        this.f11825g = i5;
        if (i5 == 2) {
            removeView(this.f11934p);
            a((View) this.f11935q);
            return;
        }
        removeView(this.f11935q);
        a((View) this.f11934p);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r7.f11937s.setVisibility(8);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00da */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0173 A[Catch:{ all -> 0x0018 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x018e A[Catch:{ all -> 0x0018 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preLoadData() {
        /*
            r7 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.f11820b     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x019d
            boolean r1 = r7.f11826h     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x019d
            int r0 = r0.getCbd()     // Catch:{ all -> 0x0018 }
            r1 = -2
            if (r0 <= r1) goto L_0x001b
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.f11820b     // Catch:{ all -> 0x0018 }
            int r0 = r0.getCbd()     // Catch:{ all -> 0x0018 }
            r7.f11927E = r0     // Catch:{ all -> 0x0018 }
            goto L_0x0025
        L_0x0018:
            r0 = move-exception
            goto L_0x0194
        L_0x001b:
            com.mbridge.msdk.videocommon.d.c r0 = r7.f11823e     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0025
            int r0 = r0.p()     // Catch:{ all -> 0x0018 }
            r7.f11927E = r0     // Catch:{ all -> 0x0018 }
        L_0x0025:
            com.mbridge.msdk.video.module.a.a.e r0 = new com.mbridge.msdk.video.module.a.a.e     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.videocommon.view.RoundImageView r1 = r7.f11938t     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.f11820b     // Catch:{ all -> 0x0018 }
            java.lang.String r3 = r7.f11931I     // Catch:{ all -> 0x0018 }
            r0.<init>(r1, r2, r3)     // Catch:{ all -> 0x0018 }
            android.content.Context r1 = r7.f11819a     // Catch:{ all -> 0x0018 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.same.c.b r1 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r1)     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.f11820b     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = r2.getImageUrl()     // Catch:{ all -> 0x0018 }
            r1.a(r2, r0)     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.video.module.a.a.j r0 = new com.mbridge.msdk.video.module.a.a.j     // Catch:{ all -> 0x0018 }
            android.widget.ImageView r1 = r7.f11939u     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0018 }
            android.content.Context r2 = r2.c()     // Catch:{ all -> 0x0018 }
            r3 = 1090519040(0x41000000, float:8.0)
            int r2 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r2, (float) r3)     // Catch:{ all -> 0x0018 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0018 }
            android.content.Context r1 = r7.f11819a     // Catch:{ all -> 0x0018 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.same.c.b r1 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r1)     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.f11820b     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = r2.getIconUrl()     // Catch:{ all -> 0x0018 }
            r1.a(r2, r0)     // Catch:{ all -> 0x0018 }
            android.widget.TextView r0 = r7.f11943y     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.f11820b     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = r1.getAppName()     // Catch:{ all -> 0x0018 }
            r0.setText(r1)     // Catch:{ all -> 0x0018 }
            android.widget.TextView r0 = r7.f11944z     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.f11820b     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = r1.getAppDesc()     // Catch:{ all -> 0x0018 }
            r0.setText(r1)     // Catch:{ all -> 0x0018 }
            android.widget.TextView r0 = r7.f11923A     // Catch:{ all -> 0x0018 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0018 }
            r1.<init>()     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r7.f11820b     // Catch:{ all -> 0x0018 }
            int r2 = r2.getNumberRating()     // Catch:{ all -> 0x0018 }
            r1.append(r2)     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0018 }
            r0.setText(r1)     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.videocommon.view.StarLevelView r0 = r7.f11924B     // Catch:{ all -> 0x0018 }
            r0.removeAllViews()     // Catch:{ all -> 0x0018 }
            boolean r0 = com.mbridge.msdk.e.b.a()     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x00ad
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.f11820b     // Catch:{ all -> 0x0018 }
            r7.setChinaCTAData(r0)     // Catch:{ all -> 0x0018 }
        L_0x00ad:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r7.f11820b     // Catch:{ all -> 0x0018 }
            double r0 = r0.getRating()     // Catch:{ all -> 0x0018 }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x00bb
            r0 = 4617315517961601024(0x4014000000000000, double:5.0)
        L_0x00bb:
            com.mbridge.msdk.videocommon.view.StarLevelView r2 = r7.f11924B     // Catch:{ all -> 0x0018 }
            r2.initScore(r0)     // Catch:{ all -> 0x0018 }
            r0 = 8
            com.mbridge.msdk.videocommon.view.RoundImageView r1 = r7.f11938t     // Catch:{ all -> 0x00da }
            android.graphics.drawable.Drawable r1 = r1.getDrawable()     // Catch:{ all -> 0x00da }
            android.graphics.Bitmap r1 = r7.a((android.graphics.drawable.Drawable) r1)     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00df
            android.graphics.Bitmap r1 = r7.blurBitmap(r1)     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00df
            android.widget.ImageView r2 = r7.f11937s     // Catch:{ all -> 0x00da }
            r2.setImageBitmap(r1)     // Catch:{ all -> 0x00da }
            goto L_0x00df
        L_0x00da:
            android.widget.ImageView r1 = r7.f11937s     // Catch:{ all -> 0x0018 }
            r1.setVisibility(r0)     // Catch:{ all -> 0x0018 }
        L_0x00df:
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.f11820b     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x0018 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0018 }
            r2 = 1
            if (r1 != 0) goto L_0x00fc
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.f11820b     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x0018 }
            java.lang.String r3 = "alecfc=1"
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x00fc
            r7.f11925C = r2     // Catch:{ all -> 0x0018 }
        L_0x00fc:
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.f11820b     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x0018 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x0118
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r7.f11820b     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = r1.getendcard_url()     // Catch:{ all -> 0x0018 }
            java.lang.String r3 = "wlgo=1"
            boolean r1 = r1.contains(r3)     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0118
            r7.f11929G = r2     // Catch:{ all -> 0x0018 }
        L_0x0118:
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = r1.getLanguage()     // Catch:{ all -> 0x0018 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0018 }
            java.lang.String r3 = "drawable"
            if (r2 != 0) goto L_0x0150
            java.lang.String r2 = "zh"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0150
            android.widget.ImageView r1 = r7.f11940v     // Catch:{ all -> 0x0018 }
            android.content.res.Resources r2 = r7.getResources()     // Catch:{ all -> 0x0018 }
            android.content.res.Resources r4 = r7.getResources()     // Catch:{ all -> 0x0018 }
            java.lang.String r5 = "mbridge_reward_flag_cn"
            com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0018 }
            java.lang.String r6 = r6.g()     // Catch:{ all -> 0x0018 }
            int r3 = r4.getIdentifier(r5, r3, r6)     // Catch:{ all -> 0x0018 }
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ all -> 0x0018 }
            r1.setImageDrawable(r2)     // Catch:{ all -> 0x0018 }
            goto L_0x016f
        L_0x0150:
            android.widget.ImageView r1 = r7.f11940v     // Catch:{ all -> 0x0018 }
            android.content.res.Resources r2 = r7.getResources()     // Catch:{ all -> 0x0018 }
            android.content.res.Resources r4 = r7.getResources()     // Catch:{ all -> 0x0018 }
            java.lang.String r5 = "mbridge_reward_flag_en"
            com.mbridge.msdk.foundation.controller.c r6 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0018 }
            java.lang.String r6 = r6.g()     // Catch:{ all -> 0x0018 }
            int r3 = r4.getIdentifier(r5, r3, r6)     // Catch:{ all -> 0x0018 }
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ all -> 0x0018 }
            r1.setImageDrawable(r2)     // Catch:{ all -> 0x0018 }
        L_0x016f:
            boolean r1 = r7.f11929G     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x017e
            android.widget.ImageView r1 = r7.f11940v     // Catch:{ all -> 0x0018 }
            r2 = 4
            r1.setVisibility(r2)     // Catch:{ all -> 0x0018 }
            android.widget.ImageView r1 = r7.f11942x     // Catch:{ all -> 0x0018 }
            r1.setVisibility(r2)     // Catch:{ all -> 0x0018 }
        L_0x017e:
            android.widget.ImageView r2 = r7.f11941w     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r7.f11820b     // Catch:{ all -> 0x0018 }
            android.content.Context r4 = r7.f11819a     // Catch:{ all -> 0x0018 }
            r5 = 1
            r6 = 0
            r1 = 2
            com.mbridge.msdk.foundation.tools.ak.a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0018 }
            boolean r1 = r7.f11926D     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x019d
            android.view.View r1 = r7.f11930H     // Catch:{ all -> 0x0018 }
            r1.setVisibility(r0)     // Catch:{ all -> 0x0018 }
            goto L_0x019d
        L_0x0194:
            java.lang.String r1 = "BTBaseView"
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r1, (java.lang.String) r0)
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.preLoadData():void");
    }

    public void setCreateWebView(WebView webView) {
        this.f11933K = webView;
    }

    public void setJSCommon(k kVar) {
        this.f11932J = kVar;
    }

    public void setUnitId(String str) {
        this.f11931I = str;
    }

    private boolean b(View view) {
        try {
            this.f11936r = (RelativeLayout) view.findViewById(findID("mbridge_native_ec_layout"));
            this.f11937s = (ImageView) view.findViewById(findID("mbridge_iv_adbanner_bg"));
            this.f11938t = (RoundImageView) view.findViewById(findID("mbridge_iv_adbanner"));
            this.f11939u = (ImageView) view.findViewById(findID("mbridge_iv_icon"));
            this.f11940v = (ImageView) view.findViewById(findID("mbridge_iv_flag"));
            this.f11941w = (ImageView) view.findViewById(findID("mbridge_iv_link"));
            this.f11943y = (TextView) view.findViewById(findID("mbridge_tv_apptitle"));
            this.f11944z = (TextView) view.findViewById(findID("mbridge_tv_appdesc"));
            this.f11923A = (TextView) view.findViewById(findID("mbridge_tv_number"));
            this.f11924B = (StarLevelView) view.findViewById(findID("mbridge_sv_starlevel"));
            this.f11930H = view.findViewById(findID("mbridge_iv_close"));
            this.ctaView = view.findViewById(findID("mbridge_tv_cta"));
            this.f11942x = (ImageView) view.findViewById(findID("mbridge_iv_logo"));
            return isNotNULL(this.f11937s, this.f11938t, this.f11939u, this.f11943y, this.f11944z, this.f11923A, this.f11924B, this.f11930H, this.ctaView);
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    private void a(View view) {
        if (view == null) {
            init(this.f11819a);
            preLoadData();
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        addView(view);
        b(view);
        a();
    }

    public MBridgeBTNativeEC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        if (this.f11826h) {
            this.f11936r.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTNativeEC.this.f11925C) {
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 1, view.getContext());
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                    }
                }
            });
            this.f11930H.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeBTNativeEC.this.f11933K != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", MBridgeBTNativeEC.this.f11822d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, MBridgeBTNativeEC.this.f11931I);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            af.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
                        } catch (JSONException e5) {
                            af.a(BTBaseView.TAG, e5.getMessage());
                        }
                        g.a().a(MBridgeBTNativeEC.this.f11933K, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }
            });
            this.ctaView.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void onNoDoubleClick(View view) {
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0, view.getContext());
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.f11939u.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void onNoDoubleClick(View view) {
                    if (!b.a() || MBridgeBTNativeEC.this.checkChinaProgressBarStatus()) {
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0, view.getContext());
                    }
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.f11938t.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void onNoDoubleClick(View view) {
                    if (!b.a() || MBridgeBTNativeEC.this.checkChinaProgressBarStatus()) {
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0, view.getContext());
                    }
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
        }
    }

    private Bitmap a(Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c A[Catch:{ all -> 0x0037 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC r2, int r3, android.content.Context r4) {
        /*
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0013 }
            r1.<init>()     // Catch:{ JSONException -> 0x0013 }
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.f9191j     // Catch:{ JSONException -> 0x0010 }
            org.json.JSONObject r3 = r2.a(r3)     // Catch:{ JSONException -> 0x0010 }
            r1.put(r0, r3)     // Catch:{ JSONException -> 0x0010 }
            goto L_0x0018
        L_0x0010:
            r3 = move-exception
            r0 = r1
            goto L_0x0014
        L_0x0013:
            r3 = move-exception
        L_0x0014:
            r3.printStackTrace()     // Catch:{ all -> 0x0037 }
            r1 = r0
        L_0x0018:
            com.mbridge.msdk.video.signal.a.k r3 = r2.f11932J     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0041
            boolean r3 = com.mbridge.msdk.e.b.a()     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0027
            com.mbridge.msdk.video.signal.a.k r3 = r2.f11932J     // Catch:{ all -> 0x0037 }
            r2.doChinaJumpClick(r4, r3)     // Catch:{ all -> 0x0037 }
        L_0x0027:
            com.mbridge.msdk.video.signal.a.k r2 = r2.f11932J     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x0030
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x0037 }
            goto L_0x0032
        L_0x0030:
            java.lang.String r3 = ""
        L_0x0032:
            r4 = 1
            r2.click(r4, r3)     // Catch:{ all -> 0x0037 }
            goto L_0x0041
        L_0x0037:
            r2 = move-exception
            java.lang.String r3 = "BTBaseView"
            java.lang.String r2 = r2.getMessage()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r3, (java.lang.String) r2)
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.a(com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC, int, android.content.Context):void");
    }

    static /* synthetic */ void a(MBridgeBTNativeEC mBridgeBTNativeEC, float f5, float f6) {
        if (mBridgeBTNativeEC.f11933K != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", BTBaseView.f11817n);
                jSONObject.put("id", mBridgeBTNativeEC.f11822d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", String.valueOf(f5));
                jSONObject2.put("y", String.valueOf(f6));
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                g.a().a(mBridgeBTNativeEC.f11933K, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception unused) {
                d.c().a(mBridgeBTNativeEC.f11933K, "onClicked", mBridgeBTNativeEC.f11822d);
            }
        }
    }
}
