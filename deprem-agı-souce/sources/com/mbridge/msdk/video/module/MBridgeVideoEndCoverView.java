package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.video.module.a.a.j;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeVideoEndCoverView extends MBridgeBaseView {

    /* renamed from: m  reason: collision with root package name */
    private final String f12470m = "MBridgeVideoEndCoverView";

    /* renamed from: n  reason: collision with root package name */
    private View f12471n;

    /* renamed from: o  reason: collision with root package name */
    private ImageView f12472o;

    /* renamed from: p  reason: collision with root package name */
    private ImageView f12473p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f12474q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f12475r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f12476s;

    /* renamed from: t  reason: collision with root package name */
    private b f12477t;

    public MBridgeVideoEndCoverView(Context context) {
        super(context);
    }

    private boolean a(View view) {
        if (view == null) {
            return true;
        }
        try {
            this.f12472o = (ImageView) view.findViewById(findID("mbridge_vec_iv_icon"));
            this.f12473p = (ImageView) view.findViewById(findID("mbridge_vec_iv_close"));
            this.f12474q = (TextView) view.findViewById(findID("mbridge_vec_tv_title"));
            this.f12475r = (TextView) view.findViewById(findID("mbridge_vec_tv_desc"));
            this.f12476s = (TextView) view.findViewById(findID("mbridge_vec_btn"));
            return true;
        } catch (Throwable th) {
            af.b("MBridgeVideoEndCoverView", th.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        this.f12473p.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.notifyListener.a(104, "");
            }
        });
        this.f12472o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
        this.f12476s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_videoend_cover");
        if (findLayout >= 0) {
            View inflate = this.f12295c.inflate(findLayout, (ViewGroup) null);
            this.f12471n = inflate;
            if (inflate != null) {
                this.f12297e = a(inflate);
                addView(this.f12471n, -1, -1);
                c();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f12298f = motionEvent.getRawX();
        this.f12299g = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f12296d = configuration.orientation;
        removeView(this.f12471n);
        View view = this.f12471n;
        if (view == null) {
            init(this.f12293a);
            preLoadData(this.f12477t);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f12471n.getParent()).removeView(this.f12471n);
        }
        addView(this.f12471n);
        a(this.f12471n);
        c();
    }

    public void preLoadData(b bVar) {
        ImageView imageView;
        this.f12477t = bVar;
        try {
            CampaignEx campaignEx = this.f12294b;
            if (campaignEx != null && this.f12297e && campaignEx != null) {
                if (!TextUtils.isEmpty(campaignEx.getIconUrl()) && (imageView = this.f12472o) != null) {
                    com.mbridge.msdk.foundation.same.c.b.a(this.f12293a.getApplicationContext()).a(this.f12294b.getIconUrl(), new j(imageView, ak.a(c.m().c(), 8.0f)));
                }
                TextView textView = this.f12474q;
                if (textView != null) {
                    textView.setText(this.f12294b.getAppName());
                }
                TextView textView2 = this.f12476s;
                if (textView2 != null) {
                    textView2.setText(this.f12294b.getAdCall());
                }
                TextView textView3 = this.f12475r;
                if (textView3 != null) {
                    textView3.setText(this.f12294b.getAppDesc());
                }
            }
        } catch (Throwable th) {
            af.a("MBridgeVideoEndCoverView", th.getMessage());
        }
    }

    public MBridgeVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        JSONObject jSONObject;
        JSONException e5;
        JSONObject jSONObject2;
        JSONException e6;
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(a.f9189h, ak.b(c.m().c(), this.f12298f));
                    jSONObject2.put(a.f9190i, ak.b(c.m().c(), this.f12299g));
                    jSONObject2.put(a.f9194m, 0);
                    try {
                        this.f12296d = getContext().getResources().getConfiguration().orientation;
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                    jSONObject2.put(a.f9192k, this.f12296d);
                    jSONObject2.put(a.f9193l, (double) ak.d(getContext()));
                } catch (JSONException e8) {
                    e6 = e8;
                    af.b("MBridgeVideoEndCoverView", e6.getMessage());
                    jSONObject = new JSONObject();
                    jSONObject.put(a.f9191j, jSONObject2);
                    this.notifyListener.a(105, jSONObject);
                }
            } catch (JSONException e9) {
                JSONException jSONException = e9;
                jSONObject2 = jSONObject3;
                e6 = jSONException;
                af.b("MBridgeVideoEndCoverView", e6.getMessage());
                jSONObject = new JSONObject();
                jSONObject.put(a.f9191j, jSONObject2);
                this.notifyListener.a(105, jSONObject);
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put(a.f9191j, jSONObject2);
            } catch (JSONException e10) {
                e5 = e10;
            }
        } catch (JSONException e11) {
            JSONException jSONException2 = e11;
            jSONObject = null;
            e5 = jSONException2;
            e5.printStackTrace();
            this.notifyListener.a(105, jSONObject);
        }
        this.notifyListener.a(105, jSONObject);
    }
}
