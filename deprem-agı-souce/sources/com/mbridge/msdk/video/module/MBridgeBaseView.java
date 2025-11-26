package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.video.module.a.a;
import com.mbridge.msdk.video.module.a.a.f;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class MBridgeBaseView extends RelativeLayout {
    public static final String TAG = "MBridgeBaseView";
    /* access modifiers changed from: protected */

    /* renamed from: a  reason: collision with root package name */
    public Context f12293a;

    /* renamed from: b  reason: collision with root package name */
    protected CampaignEx f12294b;

    /* renamed from: c  reason: collision with root package name */
    protected LayoutInflater f12295c;

    /* renamed from: d  reason: collision with root package name */
    protected int f12296d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f12297e;

    /* renamed from: f  reason: collision with root package name */
    protected float f12298f;

    /* renamed from: g  reason: collision with root package name */
    protected float f12299g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f12300h;

    /* renamed from: i  reason: collision with root package name */
    protected int f12301i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f12302j;

    /* renamed from: k  reason: collision with root package name */
    protected int f12303k;

    /* renamed from: l  reason: collision with root package name */
    protected int f12304l;
    public a notifyListener;

    public MBridgeBaseView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f9189h, ak.b(c.m().c(), this.f12298f));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f9190i, ak.b(c.m().c(), this.f12299g));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f9194m, i5);
                try {
                    this.f12296d = getContext().getResources().getConfiguration().orientation;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f9192k, this.f12296d);
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f9193l, (double) ak.d(getContext()));
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

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: protected */
    public final String d() {
        return a(0).toString();
    }

    public void defaultShow() {
        af.a(TAG, "defaultShow");
    }

    public int filterFindViewId(boolean z4, String str) {
        if (z4) {
            return findDyID(str);
        }
        return findID(str);
    }

    public int findColor(String str) {
        return x.a(this.f12293a.getApplicationContext(), str, "color");
    }

    public int findDrawable(String str) {
        return x.a(this.f12293a.getApplicationContext(), str, "drawable");
    }

    public int findDyID(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.hashCode();
        }
        return -1;
    }

    public int findID(String str) {
        return x.a(this.f12293a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(this.f12293a.getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public CampaignEx getCampaign() {
        return this.f12294b;
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

    public abstract void init(Context context);

    public boolean isLandscape() {
        if (this.f12293a.getResources().getConfiguration().orientation == 2) {
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
        this.f12296d = configuration.orientation;
        super.onConfigurationChanged(configuration);
        Log.d(TAG, "onConfigurationChanged:" + configuration.orientation);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f12298f = motionEvent.getRawX();
        this.f12299g = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.f12296d = configuration.orientation;
        Log.d(TAG, "onSelfConfigurationChanged:" + configuration.orientation);
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f12294b = campaignEx;
    }

    public void setLayoutCenter(int i5, int i6) {
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
        }
    }

    public void setLayoutParam(int i5, int i6, int i7, int i8) {
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

    public void setNotifyListener(a aVar) {
        this.notifyListener = aVar;
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

    public MBridgeBaseView(Context context, AttributeSet attributeSet, boolean z4, int i5, boolean z5, int i6, int i7) {
        super(context, attributeSet);
        this.f12296d = 1;
        this.notifyListener = new f();
        this.f12297e = false;
        this.f12303k = 1;
        this.f12304l = 0;
        this.f12293a = context;
        this.f12295c = LayoutInflater.from(context);
        this.f12300h = z4;
        this.f12301i = i5;
        this.f12302j = z5;
        this.f12303k = i6;
        this.f12304l = i7;
        init(context);
    }

    public MBridgeBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12296d = 1;
        this.notifyListener = new f();
        this.f12297e = false;
        this.f12303k = 1;
        this.f12304l = 0;
        this.f12293a = context;
        this.f12295c = LayoutInflater.from(context);
        init(context);
    }
}
