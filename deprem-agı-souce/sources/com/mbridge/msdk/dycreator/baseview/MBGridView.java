package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.a;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

public class MBGridView extends GridView implements InterBase {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f8326a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Boolean> f8327b;

    /* renamed from: c  reason: collision with root package name */
    private String f8328c = "";

    /* renamed from: com.mbridge.msdk.dycreator.baseview.MBGridView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8329a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8329a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8329a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8329a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.fadingEdge     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8329a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.visibility     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBGridView.AnonymousClass1.<clinit>():void");
        }
    }

    public MBGridView(Context context, AttributeSet attributeSet) {
        super(context);
        try {
            this.f8326a = c.a(context, attributeSet);
            a.a(this, attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            c.a(this.f8326a, (View) this);
        } catch (Exception e5) {
            af.b("MBGridView", e5.getMessage());
        }
    }

    public String getActionDes() {
        Map<String, String> map = this.f8326a;
        if (map == null || !map.containsKey("mbridgeAction")) {
            return "";
        }
        return this.f8326a.get("mbridgeAction");
    }

    public String getBindDataDes() {
        Map<String, String> map = this.f8326a;
        if (map == null || !map.containsKey("mbridgeData")) {
            return "";
        }
        return this.f8326a.get("mbridgeData");
    }

    public String getEffectDes() {
        Map<String, String> map = this.f8326a;
        if (map == null || !map.containsKey("mbridgeEffect")) {
            return "";
        }
        return this.f8326a.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.f8326a;
        if (map == null || !map.containsKey("mbridgeReport")) {
            return "";
        }
        return this.f8326a.get("mbridgeReport");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.f8326a;
        if (map == null || !map.containsKey("mbridgeStrategy")) {
            return "";
        }
        return this.f8326a.get("mbridgeStrategy");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f8327b;
        if (map != null && map.containsKey("mbridgeAttached") && this.f8327b.get("mbridgeAttached").booleanValue()) {
            new k.a("mbridgeAttached").a().a(this.f8328c);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f8327b;
        if (map != null && map.containsKey("mbridgeDetached") && this.f8327b.get("mbridgeDetached").booleanValue()) {
            new k.a("mbridgeDetached").a().a(this.f8328c);
        }
    }

    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f8327b = c.a(str);
        if (campaignEx != null) {
            this.f8328c = campaignEx.getCampaignUnitId();
        }
    }

    public AbsListView.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) generateDefaultLayoutParams();
        HashMap<String, com.mbridge.msdk.dycreator.a.c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            com.mbridge.msdk.dycreator.a.c cVar = c5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                int i6 = AnonymousClass1.f8329a[cVar.ordinal()];
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
                } else if (i6 == 3) {
                    setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i5, false));
                } else if (i6 == 4) {
                    String attributeValue3 = attributeSet.getAttributeValue(i5);
                    if (!TextUtils.isEmpty(attributeValue3)) {
                        if (attributeValue3.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue3.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                }
            }
        }
        return layoutParams;
    }
}
