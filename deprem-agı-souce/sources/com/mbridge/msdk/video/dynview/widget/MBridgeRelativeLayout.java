package com.mbridge.msdk.video.dynview.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.mbridge.msdk.video.dynview.moffer.b;
import com.mbridge.msdk.video.dynview.moffer.d;

public class MBridgeRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private d f12285a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12286b;

    /* renamed from: c  reason: collision with root package name */
    private AnimatorSet f12287c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12288d;

    /* renamed from: e  reason: collision with root package name */
    private b f12289e;

    public MBridgeRelativeLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AnimatorSet animatorSet = this.f12287c;
        if (animatorSet != null) {
            try {
                animatorSet.start();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        d dVar;
        super.onDetachedFromWindow();
        if (!this.f12286b && (dVar = this.f12285a) != null) {
            this.f12286b = true;
            dVar.a();
        }
        AnimatorSet animatorSet = this.f12287c;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i5) {
        b bVar;
        super.onVisibilityChanged(view, i5);
        if ((view instanceof MBridgeRelativeLayout) && i5 == 0 && (bVar = this.f12289e) != null && !this.f12288d) {
            this.f12288d = true;
            bVar.a();
        }
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.f12287c = animatorSet;
    }

    public void setMoreOfferCacheReportCallBack(b bVar) {
        this.f12289e = bVar;
    }

    public void setMoreOfferShowFailedCallBack(d dVar) {
        this.f12285a = dVar;
    }

    public MBridgeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeRelativeLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
