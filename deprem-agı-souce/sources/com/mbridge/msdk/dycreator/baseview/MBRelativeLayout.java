package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.a;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

public class MBRelativeLayout extends RelativeLayout implements InterBase {

    /* renamed from: a  reason: collision with root package name */
    private float f8358a;

    /* renamed from: b  reason: collision with root package name */
    private float f8359b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f8360c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Boolean> f8361d;

    /* renamed from: e  reason: collision with root package name */
    private String f8362e = "";

    /* renamed from: com.mbridge.msdk.dycreator.baseview.MBRelativeLayout$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8363a;

        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|(3:47|48|50)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(50:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8363a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_centerHorizontal     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_alignParentBottom     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_alignParentTop     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_centerVertical     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_below     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_above     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_toLeftOf     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_toRightOf     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_toEndOf     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_margin     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginLeft     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginRight     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginTop     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginBottom     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_alignParentRight     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_alignParentLeft     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_alignTop     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_alignLeft     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_alignRight     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_alignBottom     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_centerInParent     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = f8363a     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_alignParentEnd     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBRelativeLayout.AnonymousClass1.<clinit>():void");
        }
    }

    public MBRelativeLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }

    public String getActionDes() {
        Map<String, String> map = this.f8360c;
        if (map == null || !map.containsKey("mbridgeAction")) {
            return "";
        }
        return this.f8360c.get("mbridgeAction");
    }

    public String getBindDataDes() {
        Map<String, String> map = this.f8360c;
        if (map == null || !map.containsKey("mbridgeData")) {
            return "";
        }
        return this.f8360c.get("mbridgeData");
    }

    public String getEffectDes() {
        Map<String, String> map = this.f8360c;
        if (map == null || !map.containsKey("mbridgeEffect")) {
            return "";
        }
        return this.f8360c.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.f8360c;
        if (map == null || !map.containsKey("mbridgeReport")) {
            return "";
        }
        return this.f8360c.get("mbridgeReport");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.f8360c;
        if (map == null || !map.containsKey("mbridgeStrategy")) {
            return "";
        }
        return this.f8360c.get("mbridgeStrategy");
    }

    public float getxInScreen() {
        return this.f8358a;
    }

    public float getyInScreen() {
        return this.f8359b;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f8361d;
        if (map != null && map.containsKey("mbridgeAttached") && this.f8361d.get("mbridgeAttached").booleanValue()) {
            new k.a("mbridgeAttached").a().a(this.f8362e);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f8361d;
        if (map != null && map.containsKey("mbridgeDetached") && this.f8361d.get("mbridgeDetached").booleanValue()) {
            new k.a("mbridgeDetached").a().a(this.f8362e);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f8358a = motionEvent.getRawX();
        this.f8359b = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9 = 0;
        while (i9 < getChildCount()) {
            try {
                View childAt = getChildAt(i9);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                if (childAt instanceof MBLinearLayout) {
                    MBLinearLayout mBLinearLayout = (MBLinearLayout) childAt;
                    for (int i10 = 0; i10 < mBLinearLayout.getChildCount(); i10++) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) mBLinearLayout.getChildAt(i10).getLayoutParams();
                    }
                }
                i9++;
            } catch (Exception e5) {
                af.b("MBRelativeLayouts", e5.getMessage());
            }
        }
        super.onLayout(z4, i5, i6, i7, i8);
    }

    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f8361d = c.a(str);
        if (campaignEx != null) {
            this.f8362e = campaignEx.getCampaignUnitId();
        }
    }

    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        HashMap b5 = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            com.mbridge.msdk.dycreator.a.c cVar = (com.mbridge.msdk.dycreator.a.c) b5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                switch (AnonymousClass1.f8363a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i5);
                        if (!attributeValue.startsWith("fill") && !attributeValue.startsWith("match")) {
                            if (!attributeValue.startsWith("w")) {
                                layoutParams.width = b.a().b(attributeValue);
                                break;
                            } else {
                                layoutParams.width = -2;
                                break;
                            }
                        } else {
                            layoutParams.width = -1;
                            break;
                        }
                        break;
                    case 2:
                        String attributeValue2 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue2.startsWith("fill") && !attributeValue2.startsWith("match")) {
                            if (!attributeValue2.startsWith("wrap")) {
                                layoutParams.height = b.a().b(attributeValue2);
                                break;
                            } else {
                                layoutParams.height = -2;
                                break;
                            }
                        } else {
                            layoutParams.height = -1;
                            break;
                        }
                        break;
                    case 3:
                        if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                            break;
                        } else {
                            layoutParams.addRule(14, -1);
                            break;
                        }
                    case 4:
                        if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                            break;
                        } else {
                            layoutParams.addRule(12, -1);
                            break;
                        }
                    case 5:
                        if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                            break;
                        } else {
                            layoutParams.addRule(10, -1);
                            break;
                        }
                    case 6:
                        if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                            break;
                        } else {
                            layoutParams.addRule(15, -1);
                            break;
                        }
                    case 7:
                        String attributeValue3 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue3.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(3, attributeValue3.substring(5).hashCode());
                            break;
                        }
                    case 8:
                        String attributeValue4 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue4.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(2, attributeValue4.substring(5).hashCode());
                            break;
                        }
                    case 9:
                        String attributeValue5 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue5.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(0, attributeValue5.substring(5).hashCode());
                            break;
                        }
                    case 10:
                        String attributeValue6 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue6.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(1, attributeValue6.substring(5).hashCode());
                            break;
                        }
                    case 11:
                        String attributeValue7 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue7.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(17, attributeValue7.substring(5).hashCode());
                            break;
                        }
                    case 12:
                        int b6 = b.a().b(attributeSet.getAttributeValue(i5));
                        layoutParams.setMargins(b6, b6, b6, b6);
                        break;
                    case 13:
                        layoutParams.leftMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 14:
                        layoutParams.rightMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 15:
                        layoutParams.topMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 16:
                        layoutParams.bottomMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 17:
                        if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                            break;
                        } else {
                            layoutParams.addRule(11, -1);
                            break;
                        }
                    case 18:
                        if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                            break;
                        } else {
                            layoutParams.addRule(9, -1);
                            break;
                        }
                    case 19:
                        String attributeValue8 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue8.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(6, attributeValue8.substring(5).hashCode());
                            break;
                        }
                    case 20:
                        String attributeValue9 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue9.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(5, attributeValue9.substring(5).hashCode());
                            break;
                        }
                    case 21:
                        String attributeValue10 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue10.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(7, attributeValue10.substring(5).hashCode());
                            break;
                        }
                    case 22:
                        String attributeValue11 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue11.startsWith("@+id")) {
                            break;
                        } else {
                            layoutParams.addRule(8, attributeValue11.substring(5).hashCode());
                            break;
                        }
                    case 23:
                        if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                            break;
                        } else {
                            layoutParams.addRule(13, -1);
                            break;
                        }
                    case 24:
                        if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                            break;
                        } else {
                            layoutParams.addRule(21, -1);
                            break;
                        }
                }
            }
        }
        return layoutParams;
    }

    public MBRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context);
        try {
            this.f8360c = c.a(context, attributeSet);
            a.a(this, attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            c.a(this.f8360c, (View) this);
        } catch (Exception e5) {
            af.b("MBRelativeLayouts", e5.getMessage());
        }
    }

    public MBRelativeLayout(Context context) {
        super(context);
    }
}
