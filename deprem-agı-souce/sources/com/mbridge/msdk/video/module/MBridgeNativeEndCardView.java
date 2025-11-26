package com.mbridge.msdk.video.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.shake.MBShakeView;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeNativeEndCardView extends MBridgeNativeEndCardViewDiff {

    /* renamed from: A  reason: collision with root package name */
    private LinearLayout f12409A;

    /* renamed from: B  reason: collision with root package name */
    private Runnable f12410B;

    /* renamed from: C  reason: collision with root package name */
    private Runnable f12411C;
    /* access modifiers changed from: private */

    /* renamed from: D  reason: collision with root package name */
    public RelativeLayout f12412D;

    /* renamed from: E  reason: collision with root package name */
    private b f12413E;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public boolean f12414F = false;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public boolean f12415G = false;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public boolean f12416H = false;
    /* access modifiers changed from: private */

    /* renamed from: I  reason: collision with root package name */
    public boolean f12417I = false;

    /* renamed from: J  reason: collision with root package name */
    private int f12418J = 0;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public AlphaAnimation f12419K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public int f12420L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public int f12421M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public int f12422N;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public int f12423O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public Bitmap f12424P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public View f12425Q;

    /* renamed from: R  reason: collision with root package name */
    private FeedBackButton f12426R;

    /* renamed from: S  reason: collision with root package name */
    private String f12427S;

    /* renamed from: T  reason: collision with root package name */
    private CampaignUnit f12428T;

    /* renamed from: U  reason: collision with root package name */
    private MBShakeView f12429U;

    /* renamed from: V  reason: collision with root package name */
    private com.mbridge.msdk.shake.b f12430V;

    /* renamed from: W  reason: collision with root package name */
    private MBridgeBaitClickView f12431W;
    /* access modifiers changed from: private */
    public boolean aa = false;
    private int ab = 1;
    private String ac;

    /* renamed from: m  reason: collision with root package name */
    private ViewGroup f12432m;

    /* renamed from: n  reason: collision with root package name */
    private ViewGroup f12433n;

    /* renamed from: o  reason: collision with root package name */
    private RelativeLayout f12434o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public ImageView f12435p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public ImageView f12436q;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f12437r;

    /* renamed from: s  reason: collision with root package name */
    private ImageView f12438s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f12439t;

    /* renamed from: u  reason: collision with root package name */
    private ImageView f12440u;

    /* renamed from: v  reason: collision with root package name */
    private ImageView f12441v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f12442w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f12443x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f12444y;

    /* renamed from: z  reason: collision with root package name */
    private LinearLayout f12445z;

    public MBridgeNativeEndCardView(Context context) {
        super(context);
    }

    static /* synthetic */ void p(MBridgeNativeEndCardView mBridgeNativeEndCardView) {
        CampaignEx campaignEx = mBridgeNativeEndCardView.f12294b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(mBridgeNativeEndCardView.f12427S);
            com.mbridge.msdk.foundation.d.b a5 = com.mbridge.msdk.foundation.d.b.a();
            a5.a(mBridgeNativeEndCardView.f12427S + "_" + 2, mBridgeNativeEndCardView.f12294b);
        }
        if (com.mbridge.msdk.foundation.d.b.a().b()) {
            com.mbridge.msdk.foundation.d.b a6 = com.mbridge.msdk.foundation.d.b.a();
            a6.a(mBridgeNativeEndCardView.f12427S + "_" + 2, (a) new a() {
                public final void close() {
                    boolean unused = MBridgeNativeEndCardView.this.f12417I = false;
                }

                public final void showed() {
                    boolean unused = MBridgeNativeEndCardView.this.f12417I = true;
                }

                public final void summit(String str) {
                    boolean unused = MBridgeNativeEndCardView.this.f12417I = false;
                }
            });
            com.mbridge.msdk.foundation.d.b a7 = com.mbridge.msdk.foundation.d.b.a();
            a7.c(mBridgeNativeEndCardView.f12427S + "_" + 1);
            if (mBridgeNativeEndCardView.f12426R != null) {
                com.mbridge.msdk.foundation.d.b a8 = com.mbridge.msdk.foundation.d.b.a();
                a8.a(mBridgeNativeEndCardView.f12427S + "_" + 2, mBridgeNativeEndCardView.f12426R);
                return;
            }
            return;
        }
        FeedBackButton feedBackButton = mBridgeNativeEndCardView.f12426R;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(8);
        }
    }

    @TargetApi(17)
    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            RenderScript create = RenderScript.create(this.f12293a.getApplicationContext());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(25.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            create.destroy();
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean canBackPress() {
        View view = this.f12425Q;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void clearMoreOfferBitmap() {
        CampaignUnit campaignUnit;
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null && campaignEx.isDynamicView() && (campaignUnit = this.f12428T) != null && campaignUnit.getAds() != null && this.f12428T.getAds().size() > 0) {
            ArrayList<CampaignEx> ads = this.f12428T.getAds();
            int size = ads.size();
            int i5 = 0;
            while (i5 < size) {
                CampaignEx campaignEx2 = ads.get(i5);
                i5++;
                CampaignEx campaignEx3 = campaignEx2;
                if (!TextUtils.isEmpty(campaignEx3.getIconUrl())) {
                    com.mbridge.msdk.foundation.same.c.b.a(c.m().c());
                    campaignEx3.getIconUrl();
                }
            }
        }
    }

    public void init(Context context) {
    }

    public boolean isDyXmlSuccess() {
        return this.aa;
    }

    public void notifyShowListener() {
        this.notifyListener.a(110, "");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i5;
        MBridgeBaitClickView mBridgeBaitClickView;
        super.onAttachedToWindow();
        if (this.f12410B == null) {
            this.f12410B = new Runnable() {
                public final void run() {
                    boolean unused = MBridgeNativeEndCardView.this.f12415G = true;
                    if (MBridgeNativeEndCardView.this.f12425Q != null) {
                        MBridgeNativeEndCardView.this.f12425Q.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.f12410B;
        if (runnable != null) {
            postDelayed(runnable, (long) (this.f12418J * 1000));
            if (!this.f12416H) {
                this.f12416H = true;
            }
            try {
                CampaignEx campaignEx = this.f12294b;
                if (campaignEx != null) {
                    if (campaignEx.isDynamicView()) {
                        String str = this.f12294b.getendcard_url();
                        if (TextUtils.isEmpty(str)) {
                            str = this.f12294b.getEndScreenUrl();
                        }
                        String a5 = aq.a(str, "alac");
                        if (!TextUtils.isEmpty(a5) && a5.equals("1")) {
                            if (this.f12294b.getAutoShowStoreMiniCard() != 1) {
                                postDelayed(new Runnable() {
                                    public final void run() {
                                        MBridgeNativeEndCardView.this.f12294b.setTriggerClickSource(2);
                                        MBridgeNativeEndCardView.this.f12294b.setClickType(1);
                                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 2);
                                    }
                                }, 1000);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                af.b(MBridgeBaseView.TAG, th.getMessage());
            }
        }
        try {
            CampaignEx campaignEx2 = this.f12294b;
            if (campaignEx2 != null) {
                if (campaignEx2.isDynamicView()) {
                    String str2 = this.f12294b.getendcard_url();
                    if (TextUtils.isEmpty(str2)) {
                        str2 = this.f12294b.getEndScreenUrl();
                    }
                    String a6 = aq.a(str2, "bait_click");
                    i5 = Integer.parseInt(a6);
                    if (!(TextUtils.isEmpty(a6) || i5 == 0 || (mBridgeBaitClickView = this.f12431W) == null)) {
                        mBridgeBaitClickView.setVisibility(0);
                        this.f12431W.init(1342177280, i5);
                        if (this.f12294b.getEcTemplateId() == 1302) {
                            GradientDrawable gradientDrawable = new GradientDrawable();
                            gradientDrawable.setShape(0);
                            gradientDrawable.setColor(1342177280);
                            gradientDrawable.setStroke(0, SupportMenu.CATEGORY_MASK);
                            gradientDrawable.setCornerRadius(25.0f);
                            this.f12431W.setBackground(gradientDrawable);
                        }
                        this.f12431W.startAnimation();
                        this.f12431W.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                MBridgeNativeEndCardView.this.f12294b.setTriggerClickSource(2);
                                MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th2) {
            af.b(MBridgeBaseView.TAG, th2.getMessage());
        }
        try {
            CampaignEx campaignEx3 = this.f12294b;
            if (campaignEx3 != null) {
                if (campaignEx3.isDynamicView()) {
                    String str3 = this.f12294b.getendcard_url();
                    if (TextUtils.isEmpty(str3)) {
                        str3 = this.f12294b.getEndScreenUrl();
                    }
                    String a7 = aq.a(str3, "shake_show");
                    String a8 = aq.a(str3, "shake_strength");
                    String a9 = aq.a(str3, "shake_time");
                    if (!TextUtils.isEmpty(a7) && a7.equals("1")) {
                        if (this.f12429U == null) {
                            MBridgeBaitClickView mBridgeBaitClickView2 = this.f12431W;
                            if (mBridgeBaitClickView2 != null) {
                                mBridgeBaitClickView2.setVisibility(8);
                            }
                            MBShakeView mBShakeView = new MBShakeView(getContext());
                            this.f12429U = mBShakeView;
                            mBShakeView.initView(this.f12294b.getAdCall(), true);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            if (!isLandscape()) {
                                layoutParams.addRule(2, filterFindViewId(this.aa, "mbridge_iv_logo"));
                                layoutParams.addRule(14);
                                this.f12429U.setPadding(0, 0, 0, ak.a(getContext(), 20.0f));
                            } else {
                                layoutParams.addRule(13);
                            }
                            this.f12429U.setLayoutParams(layoutParams);
                            RelativeLayout relativeLayout = this.f12434o;
                            if (relativeLayout != null) {
                                if (relativeLayout.isShown()) {
                                    this.f12434o.addView(this.f12429U);
                                    TextView textView = this.ctaView;
                                    if (textView != null) {
                                        textView.setVisibility(4);
                                    }
                                    this.f12429U.setOnClickListener(new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            MBridgeNativeEndCardView.this.f12294b.setTriggerClickSource(5);
                                            MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                                        }
                                    });
                                    int i6 = 10;
                                    if (!TextUtils.isEmpty(a8)) {
                                        int parseInt = Integer.parseInt(a8);
                                        if (parseInt > 0) {
                                            i6 = parseInt;
                                        }
                                    }
                                    boolean isEmpty = TextUtils.isEmpty(a9);
                                    int i7 = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
                                    if (!isEmpty) {
                                        int parseInt2 = Integer.parseInt(a9);
                                        if (parseInt2 > 0) {
                                            i7 = parseInt2 * 1000;
                                        }
                                    }
                                    this.f12430V = new com.mbridge.msdk.shake.b(i6, i7) {
                                        public final void a() {
                                            if ((!com.mbridge.msdk.e.b.a() || !MBridgeNativeEndCardView.this.checkChinaShakeState()) && !MBridgeNativeEndCardView.this.f12417I && MBridgeNativeEndCardView.this.f12416H) {
                                                MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                                                mBridgeNativeEndCardView.f12298f = 0.0f;
                                                mBridgeNativeEndCardView.f12299g = 0.0f;
                                                mBridgeNativeEndCardView.f12294b.setTriggerClickSource(5);
                                                MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 4);
                                            }
                                        }
                                    };
                                    com.mbridge.msdk.shake.a.a().a(this.f12430V);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            af.b(MBridgeBaseView.TAG, th3.getMessage());
        }
        try {
            CampaignEx campaignEx4 = this.f12294b;
            if (campaignEx4 != null) {
                if (campaignEx4.getAutoShowStoreMiniCard() != 0) {
                    if (!TextUtils.isEmpty(this.f12294b.getDeepLinkURL())) {
                        long showStoreMiniCardDelayTime = (long) this.f12294b.getShowStoreMiniCardDelayTime();
                        if (showStoreMiniCardDelayTime == 0) {
                            showStoreMiniCardDelayTime = 1;
                        }
                        if (this.f12411C == null) {
                            this.f12411C = new Runnable() {
                                public final void run() {
                                    MBridgeNativeEndCardView.this.f12294b.setTriggerClickSource(2);
                                    MBridgeNativeEndCardView.this.f12294b.setClickType(1);
                                    MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 2);
                                }
                            };
                        }
                        postDelayed(this.f12411C, showStoreMiniCardDelayTime * 1000);
                    }
                }
            }
        } catch (Throwable th4) {
            af.b(MBridgeBaseView.TAG, th4.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f12410B;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f12411C;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        if (this.f12430V != null) {
            com.mbridge.msdk.shake.a.a().b(this.f12430V);
            this.f12430V = null;
        }
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            RelativeLayout relativeLayout = this.f12412D;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            int i5 = configuration.orientation;
            this.f12296d = i5;
            if (i5 == 2) {
                removeView(this.f12432m);
                a((View) this.f12433n);
                return;
            }
            removeView(this.f12433n);
            a((View) this.f12432m);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0160 A[Catch:{ all -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0192 A[Catch:{ all -> 0x0063 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b r7) {
        /*
            r6 = this;
            r6.f12413E = r7
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r6.f12294b     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x0199
            boolean r7 = r6.f12297e     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x0199
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView$11 r7 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView$11     // Catch:{ all -> 0x0063 }
            r7.<init>()     // Catch:{ all -> 0x0063 }
            android.content.Context r0 = r6.f12293a     // Catch:{ all -> 0x0063 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.same.c.b r0 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r0)     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r6.f12294b     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = r1.getImageUrl()     // Catch:{ all -> 0x0063 }
            r0.a(r1, r7)     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.video.module.a.a.j r7 = new com.mbridge.msdk.video.module.a.a.j     // Catch:{ all -> 0x0063 }
            android.widget.ImageView r0 = r6.f12437r     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0063 }
            android.content.Context r1 = r1.c()     // Catch:{ all -> 0x0063 }
            r2 = 1090519040(0x41000000, float:8.0)
            int r1 = com.mbridge.msdk.foundation.tools.ak.a((android.content.Context) r1, (float) r2)     // Catch:{ all -> 0x0063 }
            r7.<init>(r0, r1)     // Catch:{ all -> 0x0063 }
            android.content.Context r0 = r6.f12293a     // Catch:{ all -> 0x0063 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.same.c.b r0 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r0)     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r6.f12294b     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = r1.getIconUrl()     // Catch:{ all -> 0x0063 }
            r0.a(r1, r7)     // Catch:{ all -> 0x0063 }
            android.widget.TextView r7 = r6.f12442w     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r6.f12294b     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r0.getAppName()     // Catch:{ all -> 0x0063 }
            r7.setText(r0)     // Catch:{ all -> 0x0063 }
            android.widget.TextView r7 = r6.ctaView     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x0067
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r6.f12294b     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r0.getAdCall()     // Catch:{ all -> 0x0063 }
            r7.setText(r0)     // Catch:{ all -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r0 = move-exception
            r7 = r0
            goto L_0x019a
        L_0x0067:
            android.widget.TextView r7 = r6.f12443x     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x0074
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r6.f12294b     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r0.getAppDesc()     // Catch:{ all -> 0x0063 }
            r7.setText(r0)     // Catch:{ all -> 0x0063 }
        L_0x0074:
            android.widget.TextView r7 = r6.f12444y     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x0092
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r0.<init>()     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r6.f12294b     // Catch:{ all -> 0x0063 }
            int r1 = r1.getNumberRating()     // Catch:{ all -> 0x0063 }
            r0.append(r1)     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = ")"
            r0.append(r1)     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0063 }
            r7.setText(r0)     // Catch:{ all -> 0x0063 }
        L_0x0092:
            android.widget.LinearLayout r7 = r6.f12445z     // Catch:{ all -> 0x0063 }
            r7.removeAllViews()     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r6.f12294b     // Catch:{ all -> 0x0063 }
            double r0 = r7.getRating()     // Catch:{ all -> 0x0063 }
            r2 = 0
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 > 0) goto L_0x00a5
            r0 = 4617315517961601024(0x4014000000000000, double:5.0)
        L_0x00a5:
            android.widget.LinearLayout r7 = r6.f12445z     // Catch:{ all -> 0x0063 }
            boolean r2 = r7 instanceof com.mbridge.msdk.videocommon.view.StarLevelView     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x00b0
            com.mbridge.msdk.videocommon.view.StarLevelView r7 = (com.mbridge.msdk.videocommon.view.StarLevelView) r7     // Catch:{ all -> 0x0063 }
            r7.initScore(r0)     // Catch:{ all -> 0x0063 }
        L_0x00b0:
            android.widget.LinearLayout r7 = r6.f12445z     // Catch:{ all -> 0x0063 }
            boolean r2 = r7 instanceof com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x00c1
            com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView r7 = (com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView) r7     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r6.f12294b     // Catch:{ all -> 0x0063 }
            int r2 = r2.getNumberRating()     // Catch:{ all -> 0x0063 }
            r7.setRatingAndUser(r0, r2)     // Catch:{ all -> 0x0063 }
        L_0x00c1:
            android.widget.LinearLayout r7 = r6.f12445z     // Catch:{ all -> 0x0063 }
            boolean r2 = r7 instanceof com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x00cd
            com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView r7 = (com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView) r7     // Catch:{ all -> 0x0063 }
            int r0 = (int) r0     // Catch:{ all -> 0x0063 }
            r7.setRating(r0)     // Catch:{ all -> 0x0063 }
        L_0x00cd:
            android.widget.LinearLayout r7 = r6.f12409A     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x00e0
            boolean r0 = r7 instanceof com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView     // Catch:{ all -> 0x0063 }
            if (r0 == 0) goto L_0x00e0
            com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView r7 = (com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView) r7     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r6.f12294b     // Catch:{ all -> 0x0063 }
            int r0 = r0.getNumberRating()     // Catch:{ all -> 0x0063 }
            r7.setHeatCount(r0)     // Catch:{ all -> 0x0063 }
        L_0x00e0:
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r6.f12294b     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = r7.getendcard_url()     // Catch:{ all -> 0x0063 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0063 }
            if (r7 != 0) goto L_0x00fd
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = r6.f12294b     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = r7.getendcard_url()     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = "alecfc=1"
            boolean r7 = r7.contains(r0)     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x00fd
            r7 = 1
            r6.f12414F = r7     // Catch:{ all -> 0x0063 }
        L_0x00fd:
            java.util.Locale r7 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = r7.getLanguage()     // Catch:{ all -> 0x0063 }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "drawable"
            if (r0 != 0) goto L_0x0139
            java.lang.String r0 = "zh"
            boolean r7 = r7.equals(r0)     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x0139
            android.widget.ImageView r7 = r6.f12438s     // Catch:{ all -> 0x0063 }
            android.content.res.Resources r0 = r6.getResources()     // Catch:{ all -> 0x0063 }
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = "mbridge_reward_flag_cn"
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0063 }
            java.lang.String r4 = r4.g()     // Catch:{ all -> 0x0063 }
            int r1 = r2.getIdentifier(r3, r1, r4)     // Catch:{ all -> 0x0063 }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ all -> 0x0063 }
            r7.setImageDrawable(r0)     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = "广告"
            r6.ac = r7     // Catch:{ all -> 0x0063 }
            goto L_0x015c
        L_0x0139:
            android.widget.ImageView r7 = r6.f12438s     // Catch:{ all -> 0x0063 }
            android.content.res.Resources r0 = r6.getResources()     // Catch:{ all -> 0x0063 }
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = "mbridge_reward_flag_en"
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0063 }
            java.lang.String r4 = r4.g()     // Catch:{ all -> 0x0063 }
            int r1 = r2.getIdentifier(r3, r1, r4)     // Catch:{ all -> 0x0063 }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ all -> 0x0063 }
            r7.setImageDrawable(r0)     // Catch:{ all -> 0x0063 }
            java.lang.String r7 = "AD"
            r6.ac = r7     // Catch:{ all -> 0x0063 }
        L_0x015c:
            int r7 = r6.ab     // Catch:{ all -> 0x0063 }
            if (r7 != 0) goto L_0x017e
            android.widget.ImageView r7 = r6.f12438s     // Catch:{ all -> 0x0063 }
            r0 = 4
            if (r7 == 0) goto L_0x0168
            r7.setVisibility(r0)     // Catch:{ all -> 0x0063 }
        L_0x0168:
            android.widget.ImageView r7 = r6.f12440u     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x016f
            r7.setVisibility(r0)     // Catch:{ all -> 0x0063 }
        L_0x016f:
            android.widget.TextView r7 = r6.f12439t     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x017e
            r0 = 0
            r7.setVisibility(r0)     // Catch:{ all -> 0x0063 }
            android.widget.TextView r7 = r6.f12439t     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r6.ac     // Catch:{ all -> 0x0063 }
            r7.setText(r0)     // Catch:{ all -> 0x0063 }
        L_0x017e:
            android.widget.ImageView r1 = r6.f12441v     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r6.f12294b     // Catch:{ all -> 0x0063 }
            android.content.Context r3 = r6.f12293a     // Catch:{ all -> 0x0063 }
            com.mbridge.msdk.video.module.MBridgeNativeEndCardView$12 r5 = new com.mbridge.msdk.video.module.MBridgeNativeEndCardView$12     // Catch:{ all -> 0x0063 }
            r5.<init>()     // Catch:{ all -> 0x0063 }
            r0 = 2
            r4 = 1
            com.mbridge.msdk.foundation.tools.ak.a(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0063 }
            boolean r7 = r6.f12415G     // Catch:{ all -> 0x0063 }
            if (r7 != 0) goto L_0x0199
            android.view.View r7 = r6.f12425Q     // Catch:{ all -> 0x0063 }
            r0 = 8
            r7.setVisibility(r0)     // Catch:{ all -> 0x0063 }
        L_0x0199:
            return
        L_0x019a:
            java.lang.String r0 = "MBridgeBaseView"
            java.lang.String r7 = r7.getMessage()
            com.mbridge.msdk.foundation.tools.af.a((java.lang.String) r0, (java.lang.String) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.preLoadData(com.mbridge.msdk.video.signal.factory.b):void");
    }

    public void release() {
        try {
            removeAllViews();
            AlphaAnimation alphaAnimation = this.f12419K;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            this.f12410B = null;
        } catch (Exception e5) {
            af.b(MBridgeBaseView.TAG, e5.getMessage());
        }
    }

    public void setCloseBtnDelay(int i5) {
        this.f12418J = i5;
    }

    public void setLayout() {
        String str;
        if (this.f12300h) {
            if (com.mbridge.msdk.e.b.a()) {
                str = "cn_";
            } else {
                str = "en_";
            }
            com.mbridge.msdk.video.dynview.c a5 = new com.mbridge.msdk.video.dynview.j.c().a(getContext(), this.f12294b, this.f12301i, str);
            this.ab = a5.n();
            com.mbridge.msdk.video.dynview.b.a().a(a5, new h() {
                public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                    af.b(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
                }

                public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                    if (aVar != null) {
                        MBridgeNativeEndCardView.this.addView(aVar.a());
                        boolean unused = MBridgeNativeEndCardView.this.aa = aVar.c();
                        if (MBridgeNativeEndCardView.this.ctaViewCanGet(aVar.a(), MBridgeNativeEndCardView.this.aa)) {
                            MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                            mBridgeNativeEndCardView.f12297e = mBridgeNativeEndCardView.b(aVar.a());
                            MBridgeNativeEndCardView.this.b();
                        } else {
                            boolean unused2 = MBridgeNativeEndCardView.this.aa = false;
                            MBridgeNativeEndCardView mBridgeNativeEndCardView2 = MBridgeNativeEndCardView.this;
                            mBridgeNativeEndCardView2.f12300h = false;
                            mBridgeNativeEndCardView2.a();
                        }
                        MBridgeNativeEndCardView mBridgeNativeEndCardView3 = MBridgeNativeEndCardView.this;
                        CampaignEx campaignEx = mBridgeNativeEndCardView3.f12294b;
                        if (campaignEx != null) {
                            campaignEx.setECTemplateRenderSucc(mBridgeNativeEndCardView3.aa);
                        }
                    }
                }
            });
            return;
        }
        a();
    }

    public void setMoreOfferCampaignUnit(CampaignUnit campaignUnit) {
        MBShakeView mBShakeView;
        CampaignEx campaignEx = this.f12294b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            this.f12428T = campaignUnit;
            if (campaignUnit != null && campaignUnit.getAds() != null && this.f12428T.getAds().size() > 5 && (mBShakeView = this.f12429U) != null) {
                mBShakeView.setPadding(0, 0, 0, ak.a(getContext(), 5.0f));
            }
        }
    }

    public void setNotchPadding(int i5, int i6, int i7, int i8) {
        af.b(MBridgeBaseView.TAG, "NOTCH NativeEndCard " + String.format("%1s-%2s-%3s-%4s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}));
        this.f12420L = i5;
        this.f12421M = i6;
        this.f12422N = i7;
        this.f12423O = i8;
        f();
    }

    public void setOnPause() {
        this.f12416H = false;
    }

    public void setOnResume() {
        this.f12416H = true;
    }

    public void setUnitId(String str) {
        this.f12427S = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        if (r6.f12302j != false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r6.f12302j != false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int e() {
        /*
            r6 = this;
            int r0 = r6.f12303k
            java.lang.String r1 = "mbridge_reward_endcard_native_land"
            java.lang.String r2 = "mbridge_reward_endcard_native_half_landscape"
            java.lang.String r3 = "mbridge_reward_endcard_native_hor"
            java.lang.String r4 = "mbridge_reward_endcard_native_half_portrait"
            if (r0 != 0) goto L_0x001e
            boolean r0 = r6.f12302j
            if (r0 == 0) goto L_0x0011
            r3 = r4
        L_0x0011:
            boolean r0 = r6.isLandscape()
            if (r0 == 0) goto L_0x0031
            boolean r0 = r6.f12302j
            if (r0 == 0) goto L_0x001c
        L_0x001b:
            r1 = r2
        L_0x001c:
            r3 = r1
            goto L_0x0031
        L_0x001e:
            r5 = 1
            if (r0 != r5) goto L_0x0027
            boolean r5 = r6.f12302j
            if (r5 == 0) goto L_0x0029
            r3 = r4
            goto L_0x0029
        L_0x0027:
            java.lang.String r3 = ""
        L_0x0029:
            r4 = 2
            if (r0 != r4) goto L_0x0031
            boolean r0 = r6.f12302j
            if (r0 == 0) goto L_0x001c
            goto L_0x001b
        L_0x0031:
            int r0 = r6.findLayout(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.e():int");
    }

    private void f() {
        RelativeLayout relativeLayout;
        if (this.f12297e && (relativeLayout = this.f12412D) != null) {
            relativeLayout.postDelayed(new Runnable() {
                public final void run() {
                    if (MBridgeNativeEndCardView.this.f12412D != null) {
                        CampaignEx campaignEx = MBridgeNativeEndCardView.this.f12294b;
                        if (!(campaignEx == null || campaignEx.isDynamicView() || MBridgeNativeEndCardView.this.f12294b.getAdSpaceT() == 2)) {
                            MBridgeNativeEndCardView.this.f12412D.setPadding(MBridgeNativeEndCardView.this.f12420L, MBridgeNativeEndCardView.this.f12422N, MBridgeNativeEndCardView.this.f12421M, MBridgeNativeEndCardView.this.f12423O);
                            MBridgeNativeEndCardView.this.f12412D.startAnimation(MBridgeNativeEndCardView.this.f12419K);
                        }
                        MBridgeNativeEndCardView.this.f12412D.setVisibility(0);
                    }
                    if (!(MBridgeNativeEndCardView.this.f12425Q == null || MBridgeNativeEndCardView.this.f12425Q.getVisibility() == 0 || !MBridgeNativeEndCardView.this.f12415G)) {
                        MBridgeNativeEndCardView.this.f12425Q.setVisibility(0);
                    }
                    MBridgeNativeEndCardView.p(MBridgeNativeEndCardView.this);
                }
            }, 200);
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (this.f12297e) {
            this.f12434o.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeNativeEndCardView.this.f12414F) {
                        MBridgeNativeEndCardView.this.f12294b.setTriggerClickSource(2);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 1);
                    }
                }
            });
            this.f12425Q.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBridgeNativeEndCardView.this.f12300h) {
                        try {
                            com.mbridge.msdk.video.dynview.moffer.a.a().b();
                        } catch (Exception e5) {
                            af.b(MBridgeBaseView.TAG, e5.getMessage());
                        }
                        try {
                            CampaignEx campaignEx = MBridgeNativeEndCardView.this.f12294b;
                            if (campaignEx != null) {
                                String a5 = aq.a(campaignEx.getendcard_url(), "ecid");
                                String a6 = aq.a(MBridgeNativeEndCardView.this.f12294b.getendcard_url(), "mof");
                                e eVar = new e();
                                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "choseFromTwoClose");
                                eVar.a("endcard_id", a5);
                                eVar.a("mof", a6);
                                com.mbridge.msdk.video.module.b.a.a("2000103", MBridgeNativeEndCardView.this.f12294b, eVar);
                            }
                        } catch (Exception e6) {
                            if (MBridgeConstans.DEBUG) {
                                e6.printStackTrace();
                            }
                        }
                    }
                    try {
                        e eVar2 = new e();
                        eVar2.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                        d.a().a("2000152", eVar2);
                        d.a().a("2000134", MBridgeNativeEndCardView.this.f12294b);
                    } catch (Throwable th) {
                        if (MBridgeConstans.DEBUG) {
                            th.printStackTrace();
                        }
                    }
                    MBridgeNativeEndCardView.this.notifyListener.a(104, "");
                }
            });
            TextView textView = this.ctaView;
            if (textView != null) {
                textView.setOnClickListener(new com.mbridge.msdk.widget.a() {
                    /* access modifiers changed from: protected */
                    public final void onNoDoubleClick(View view) {
                        MBridgeNativeEndCardView.this.f12294b.setTriggerClickSource(1);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                    }
                });
            }
            this.f12437r.setOnClickListener(new com.mbridge.msdk.widget.a() {
                /* access modifiers changed from: protected */
                public final void onNoDoubleClick(View view) {
                    if (MBridgeNativeEndCardView.this.ctaView == null) {
                        return;
                    }
                    if (!com.mbridge.msdk.e.b.a() || MBridgeNativeEndCardView.this.checkProgressBarIntercepted()) {
                        MBridgeNativeEndCardView.this.f12294b.setTriggerClickSource(2);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                    }
                }
            });
            this.f12436q.setOnClickListener(new com.mbridge.msdk.widget.a() {
                /* access modifiers changed from: protected */
                public final void onNoDoubleClick(View view) {
                    if (MBridgeNativeEndCardView.this.ctaView == null) {
                        return;
                    }
                    if (!com.mbridge.msdk.e.b.a() || MBridgeNativeEndCardView.this.checkProgressBarIntercepted()) {
                        MBridgeNativeEndCardView.this.f12294b.setTriggerClickSource(2);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        int e5 = e();
        if (e5 > 0) {
            this.f12297e = b(e5);
            b();
            CampaignEx campaignEx = this.f12294b;
            if (campaignEx != null) {
                campaignEx.setECTemplateRenderSucc(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        c();
        if (!this.f12297e) {
            this.notifyListener.a(104, "");
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.f12419K = alphaAnimation;
        alphaAnimation.setDuration(200);
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view) {
        if (view == null) {
            setLayout();
            preLoadData(this.f12413E);
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
            b(view);
            c();
        }
        f();
    }

    private boolean b(int i5) {
        if (isLandscape()) {
            ViewGroup viewGroup = (ViewGroup) this.f12295c.inflate(i5, (ViewGroup) null);
            this.f12433n = viewGroup;
            addView(viewGroup);
            return b((View) this.f12433n);
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f12295c.inflate(i5, (ViewGroup) null);
        this.f12432m = viewGroup2;
        addView(viewGroup2);
        return b((View) this.f12432m);
    }

    /* access modifiers changed from: private */
    public boolean b(View view) {
        boolean z4;
        View view2 = view;
        try {
            this.f12434o = (RelativeLayout) view2.findViewById(filterFindViewId(this.aa, "mbridge_native_ec_layout"));
            this.f12436q = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_adbanner"));
            this.f12437r = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_icon"));
            this.f12438s = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_flag"));
            this.f12439t = (TextView) view2.findViewById(filterFindViewId(this.aa, "mbridge_tv_flag"));
            this.f12440u = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_logo"));
            this.f12441v = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_link"));
            this.f12442w = (TextView) view2.findViewById(filterFindViewId(this.aa, "mbridge_tv_apptitle"));
            this.f12445z = (LinearLayout) view2.findViewById(filterFindViewId(this.aa, "mbridge_sv_starlevel"));
            this.f12409A = (LinearLayout) view2.findViewById(filterFindViewId(this.aa, "mbridge_sv_heat_count_level"));
            this.f12425Q = view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_close"));
            this.ctaView = (TextView) view2.findViewById(filterFindViewId(this.aa, "mbridge_tv_cta"));
            this.f12426R = (FeedBackButton) view2.findViewById(filterFindViewId(this.aa, "mbridge_native_endcard_feed_btn"));
            this.f12412D = (RelativeLayout) view2.findViewById(filterFindViewId(this.aa, "mbridge_native_ec_controller"));
            this.f12435p = (ImageView) view2.findViewById(filterFindViewId(this.aa, "mbridge_iv_adbanner_bg"));
            this.f12431W = (MBridgeBaitClickView) findViewById(filterFindViewId(this.aa, "mbridge_animation_click_view"));
            this.f12443x = (TextView) view2.findViewById(filterFindViewId(this.aa, "mbridge_tv_appdesc"));
            if (this.f12300h) {
                ImageView imageView = this.f12436q;
                if (imageView != null && (imageView instanceof RoundImageView)) {
                    ((RoundImageView) imageView).setBorderRadius(10);
                }
                ImageView imageView2 = this.f12437r;
                if (imageView2 != null && (imageView2 instanceof RoundImageView)) {
                    ((RoundImageView) imageView2).setBorderRadius(10);
                }
                return isNotNULL(this.f12436q, this.f12437r, this.f12442w, this.f12445z, this.f12425Q, this.ctaView);
            }
            TextView textView = (TextView) view2.findViewById(filterFindViewId(this.aa, "mbridge_tv_number"));
            this.f12444y = textView;
            z4 = false;
            try {
                return isNotNULL(this.f12436q, this.f12437r, this.f12442w, this.f12443x, textView, this.f12445z, this.f12425Q, this.ctaView);
            } catch (Throwable th) {
                th = th;
                af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                return z4;
            }
        } catch (Throwable th2) {
            th = th2;
            z4 = false;
            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return z4;
        }
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet, boolean z4, int i5, boolean z5, int i6, int i7) {
        super(context, attributeSet, z4, i5, z5, i6, i7);
    }

    static /* synthetic */ void a(MBridgeNativeEndCardView mBridgeNativeEndCardView, final Bitmap bitmap) {
        try {
            com.mbridge.msdk.foundation.same.f.a.d().execute(new Runnable() {
                public final void run() {
                    MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                    Bitmap unused = mBridgeNativeEndCardView.f12424P = mBridgeNativeEndCardView.blurBitmap(bitmap);
                    if (MBridgeNativeEndCardView.this.f12424P != null && !MBridgeNativeEndCardView.this.f12424P.isRecycled() && MBridgeNativeEndCardView.this.f12435p != null) {
                        MBridgeNativeEndCardView.this.f12435p.post(new Runnable() {
                            public final void run() {
                                MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                                if (mBridgeNativeEndCardView.f12300h) {
                                    mBridgeNativeEndCardView.f12435p.setBackground((Drawable) null);
                                }
                                af.b("async", "执行异步加载图");
                                MBridgeNativeEndCardView.this.f12435p.setImageBitmap(MBridgeNativeEndCardView.this.f12424P);
                            }
                        });
                    }
                }
            });
        } catch (Exception e5) {
            af.a(MBridgeBaseView.TAG, e5.getMessage());
        }
    }

    static /* synthetic */ void a(MBridgeNativeEndCardView mBridgeNativeEndCardView, int i5) {
        JSONObject jSONObject;
        JSONException jSONException;
        CampaignEx campaignEx = mBridgeNativeEndCardView.f12294b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = mBridgeNativeEndCardView.f12294b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.f() + str;
                }
                i.a(c.m().c(), "end_card_click", mBridgeNativeEndCardView.f12294b.getCampaignUnitId(), mBridgeNativeEndCardView.f12294b.isBidCampaign(), mBridgeNativeEndCardView.f12294b.getRequestId(), mBridgeNativeEndCardView.f12294b.getRequestIdNotice(), mBridgeNativeEndCardView.f12294b.getId(), str);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.f9191j, mBridgeNativeEndCardView.a(i5));
                if (mBridgeNativeEndCardView.f12294b.getDynamicTempCode() == 5) {
                    jSONObject.put("camp_position", 0);
                }
            } catch (JSONException e6) {
                jSONException = e6;
                jSONObject2 = jSONObject;
                jSONException.printStackTrace();
                jSONObject = jSONObject2;
                mBridgeNativeEndCardView.f12294b.setClickTempSource(2);
                mBridgeNativeEndCardView.notifyListener.a(105, jSONObject);
            }
        } catch (JSONException e7) {
            jSONException = e7;
            jSONException.printStackTrace();
            jSONObject = jSONObject2;
            mBridgeNativeEndCardView.f12294b.setClickTempSource(2);
            mBridgeNativeEndCardView.notifyListener.a(105, jSONObject);
        }
        mBridgeNativeEndCardView.f12294b.setClickTempSource(2);
        mBridgeNativeEndCardView.notifyListener.a(105, jSONObject);
    }
}
