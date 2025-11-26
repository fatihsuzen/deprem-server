package com.mbridge.msdk.dycreator.baseview;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.baseview.inter.InterEffect;
import com.mbridge.msdk.dycreator.e.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

public class MBTextView extends TextView implements InterBase, InterEffect {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8407a = false;
    public AttributeSet attrs;

    /* renamed from: b  reason: collision with root package name */
    private Animator f8408b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f8409c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Boolean> f8410d;

    /* renamed from: e  reason: collision with root package name */
    private String f8411e = "";

    /* renamed from: com.mbridge.msdk.dycreator.baseview.MBTextView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8412a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8412a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8412a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBTextView.AnonymousClass1.<clinit>():void");
        }
    }

    public MBTextView(Context context) {
        super(context);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        HashMap b5 = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            c cVar = (c) b5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                int i6 = AnonymousClass1.f8412a[cVar.ordinal()];
                if (i6 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i5);
                    if (attributeValue.startsWith("f") || attributeValue.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue);
                    }
                } else if (i6 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i5);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue2);
                    }
                }
            }
        }
        return layoutParams;
    }

    public String getActionDes() {
        Map<String, String> map = this.f8409c;
        if (map == null || !map.containsKey("mbridgeAction")) {
            return "";
        }
        return this.f8409c.get("mbridgeAction");
    }

    public String getBindDataDes() {
        Map<String, String> map = this.f8409c;
        if (map == null || !map.containsKey("mbridgeData")) {
            return "";
        }
        return this.f8409c.get("mbridgeData");
    }

    public String getEffectDes() {
        Map<String, String> map = this.f8409c;
        if (map == null || !map.containsKey("mbridgeEffect")) {
            return "";
        }
        return this.f8409c.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.f8409c;
        if (map == null || !map.containsKey("mbridgeReport")) {
            return "";
        }
        return this.f8409c.get("mbridgeReport");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.f8409c;
        if (map == null || !map.containsKey("mbridgeStrategy")) {
            return "";
        }
        return this.f8409c.get("mbridgeStrategy");
    }

    public boolean isFocused() {
        if (this.f8407a) {
            return true;
        }
        return super.isFocused();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Animator animator = this.f8408b;
        if (animator != null) {
            try {
                animator.start();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        Map<String, Boolean> map = this.f8410d;
        if (map != null && map.containsKey("mbridgeAttached") && this.f8410d.get("mbridgeAttached").booleanValue()) {
            new k.a("mbridgeAttached").a().a(this.f8411e);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.f8408b;
        if (animator != null) {
            try {
                animator.cancel();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        Map<String, Boolean> map = this.f8410d;
        if (map != null && map.containsKey("mbridgeDetached") && this.f8410d.get("mbridgeDetached").booleanValue()) {
            new k.a("mbridgeDetached").a().a(this.f8411e);
        }
    }

    public void setAnimator(Animator animator) {
        this.f8408b = animator;
    }

    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f8410d = com.mbridge.msdk.dycreator.e.c.a(str);
        if (campaignEx != null) {
            this.f8411e = campaignEx.getCampaignUnitId();
        }
    }

    public MBTextView(Context context, AttributeSet attributeSet) {
        super(context);
        this.attrs = attributeSet;
        try {
            this.f8409c = com.mbridge.msdk.dycreator.e.c.a(context, attributeSet);
            a.a(this, attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            com.mbridge.msdk.dycreator.e.c.a(this.f8409c, (View) this);
        } catch (Exception e5) {
            af.b("TextView", e5.getMessage());
        }
    }

    public MBTextView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
