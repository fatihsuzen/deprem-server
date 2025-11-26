package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.e.a.a;
import com.mbridge.msdk.e.a.b;

public class MBCountDownView extends MBTextView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f8316a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public MBCountDownView f8317b = this;

    public MBCountDownView(Context context) {
        super(context);
    }

    public void initView(final String str, final String str2, int i5) {
        this.f8316a = new b().b((long) (i5 * 1000)).a(1000).a((a) new a() {
            public void onFinish() {
                MBCountDownView.this.f8316a.a();
                SplashResData splashResData = new SplashResData();
                splashResData.seteAction(EAction.CLOSE);
                EventBus.getDefault().post(splashResData);
            }

            public void onTick(long j5) {
                if (str2.startsWith("zh")) {
                    MBCountDownView a5 = MBCountDownView.this.f8317b;
                    a5.setText((j5 / 1000) + "s" + str);
                    return;
                }
                MBCountDownView a6 = MBCountDownView.this.f8317b;
                a6.setText(MBCountDownView.this.f8317b + " " + (j5 / 1000) + "s");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f8316a;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f8316a;
        if (bVar != null) {
            bVar.a();
        }
    }

    public MBCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBCountDownView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
