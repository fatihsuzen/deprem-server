package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.videocommon.d.c;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BTBaseView extends FrameLayout {
    public static final String TAG = "BTBaseView";

    /* renamed from: n  reason: collision with root package name */
    protected static int f11817n = 0;

    /* renamed from: o  reason: collision with root package name */
    protected static int f11818o = 1;

    /* renamed from: a  reason: collision with root package name */
    protected Context f11819a;

    /* renamed from: b  reason: collision with root package name */
    protected CampaignEx f11820b;

    /* renamed from: c  reason: collision with root package name */
    protected String f11821c;

    /* renamed from: d  reason: collision with root package name */
    protected String f11822d;

    /* renamed from: e  reason: collision with root package name */
    protected c f11823e;

    /* renamed from: f  reason: collision with root package name */
    protected LayoutInflater f11824f;

    /* renamed from: g  reason: collision with root package name */
    protected int f11825g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f11826h;

    /* renamed from: i  reason: collision with root package name */
    protected float f11827i;

    /* renamed from: j  reason: collision with root package name */
    protected float f11828j;

    /* renamed from: k  reason: collision with root package name */
    protected Rect f11829k;

    /* renamed from: l  reason: collision with root package name */
    protected int f11830l;

    /* renamed from: m  reason: collision with root package name */
    protected int f11831m;

    public BTBaseView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public void defaultShow() {
        af.a(TAG, "defaultShow");
    }

    public int findColor(String str) {
        return x.a(this.f11819a.getApplicationContext(), str, "color");
    }

    public int findDrawable(String str) {
        return x.a(this.f11819a.getApplicationContext(), str, "drawable");
    }

    public int findID(String str) {
        return x.a(this.f11819a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(this.f11819a.getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public CampaignEx getCampaign() {
        return this.f11820b;
    }

    public String getInstanceId() {
        return this.f11822d;
    }

    public FrameLayout.LayoutParams getParentFrameLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public LinearLayout.LayoutParams getParentLinearLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public RelativeLayout.LayoutParams getParentRelativeLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            return (RelativeLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public Rect getRect() {
        return this.f11829k;
    }

    public String getUnitId() {
        return this.f11821c;
    }

    public int getViewHeight() {
        return this.f11831m;
    }

    public int getViewWidth() {
        return this.f11830l;
    }

    public abstract void init(Context context);

    public boolean isLandscape() {
        if (this.f11819a.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public boolean isNotNULL(View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i5 = 0;
        boolean z4 = false;
        while (i5 < length) {
            if (viewArr[i5] == null) {
                return false;
            }
            i5++;
            z4 = true;
        }
        return z4;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f11825g = configuration.orientation;
        super.onConfigurationChanged(configuration);
    }

    public abstract void onDestory();

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f11827i = motionEvent.getRawX();
        this.f11828j = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.f11825g = configuration.orientation;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f11820b = campaignEx;
    }

    public void setInstanceId(String str) {
        this.f11822d = str;
    }

    public void setLayout(int i5, int i6) {
        this.f11830l = i5;
        this.f11831m = i6;
    }

    public void setLayoutCenter(int i5, int i6) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.addRule(13);
            if (i5 != -999) {
                parentRelativeLayoutParams.width = i5;
            }
            if (i6 != -999) {
                parentRelativeLayoutParams.height = i6;
            }
            setLayoutParams(parentRelativeLayoutParams);
        } else if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.gravity = 17;
            if (i5 != -999) {
                parentLinearLayoutParams.width = i5;
            }
            if (i6 != -999) {
                parentLinearLayoutParams.height = i6;
            }
            setLayoutParams(parentLinearLayoutParams);
        } else if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.gravity = 17;
            if (i5 != -999) {
                parentFrameLayoutParams.width = i5;
            }
            if (i6 != -999) {
                parentFrameLayoutParams.height = i6;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setLayoutParam(int i5, int i6, int i7, int i8) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.topMargin = i6;
            parentRelativeLayoutParams.leftMargin = i5;
            if (i7 != -999) {
                parentRelativeLayoutParams.width = i7;
            }
            if (i8 != -999) {
                parentRelativeLayoutParams.height = i8;
            }
            setLayoutParams(parentRelativeLayoutParams);
        } else if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.topMargin = i6;
            parentLinearLayoutParams.leftMargin = i5;
            if (i7 != -999) {
                parentLinearLayoutParams.width = i7;
            }
            if (i8 != -999) {
                parentLinearLayoutParams.height = i8;
            }
            setLayoutParams(parentLinearLayoutParams);
        } else if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.topMargin = i6;
            parentFrameLayoutParams.leftMargin = i5;
            if (i7 != -999) {
                parentFrameLayoutParams.width = i7;
            }
            if (i8 != -999) {
                parentFrameLayoutParams.height = i8;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
    }

    public void setRect(Rect rect) {
        this.f11829k = rect;
    }

    public void setRewardUnitSetting(c cVar) {
        this.f11823e = cVar;
    }

    public void setUnitId(String str) {
        this.f11821c = str;
    }

    public void setWrapContent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            return;
        }
        layoutParams.height = -2;
        layoutParams.width = -2;
    }

    public BTBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11822d = "";
        this.f11825g = 1;
        this.f11826h = false;
        this.f11819a = context;
        this.f11824f = LayoutInflater.from(context);
        init(context);
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(a.f9189h, ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f11827i));
                jSONObject2.put(a.f9190i, ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f11828j));
                jSONObject2.put(a.f9194m, i5);
                try {
                    this.f11825g = getContext().getResources().getConfiguration().orientation;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                jSONObject2.put(a.f9192k, this.f11825g);
                jSONObject2.put(a.f9193l, (double) ak.d(getContext()));
                return jSONObject2;
            } catch (JSONException e6) {
                e = e6;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e7) {
            e = e7;
            e.printStackTrace();
            return jSONObject;
        }
    }

    protected static void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f11817n);
            jSONObject.put("id", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            d.c().a(webView, e5.getMessage());
            af.a(TAG, e5.getMessage());
        }
    }
}
