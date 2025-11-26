package com.mbridge.msdk.video.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.widget.a;

public class MBridgeVastEndCardView extends MBridgeBaseView {

    /* renamed from: m  reason: collision with root package name */
    private ViewGroup f12465m;

    /* renamed from: n  reason: collision with root package name */
    private View f12466n;

    /* renamed from: o  reason: collision with root package name */
    private View f12467o;

    public MBridgeVastEndCardView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f12297e) {
            this.f12466n.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBridgeVastEndCardView.this.notifyListener.a(104, "");
                }
            });
            this.f12467o.setOnClickListener(new a() {
                /* access modifiers changed from: protected */
                public final void onNoDoubleClick(View view) {
                    MBridgeVastEndCardView mBridgeVastEndCardView = MBridgeVastEndCardView.this;
                    mBridgeVastEndCardView.notifyListener.a(108, mBridgeVastEndCardView.d());
                }
            });
        }
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_endcard_vast");
        if (findLayout >= 0) {
            this.f12295c.inflate(findLayout, this);
            this.f12465m = (ViewGroup) findViewById(findID("mbridge_rl_content"));
            this.f12466n = findViewById(findID("mbridge_iv_vastclose"));
            View findViewById = findViewById(findID("mbridge_iv_vastok"));
            this.f12467o = findViewById;
            this.f12297e = isNotNULL(this.f12465m, this.f12466n, findViewById);
            c();
            if (this.f12297e) {
                setMatchParent();
                setBackgroundResource(findColor("mbridge_reward_endcard_vast_bg"));
                setClickable(true);
                ((RelativeLayout.LayoutParams) this.f12465m.getLayoutParams()).addRule(13, -1);
            }
        }
    }

    public void notifyShowListener() {
        this.notifyListener.a(111, "");
    }

    public void preLoadData(b bVar) {
    }

    public MBridgeVastEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
