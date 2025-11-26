package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.a;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import java.util.HashMap;
import java.util.Map;

public class MBLinearLayout extends LinearLayout implements InterBase {

    /* renamed from: a  reason: collision with root package name */
    private float f8342a;

    /* renamed from: b  reason: collision with root package name */
    private float f8343b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f8344c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Boolean> f8345d;

    /* renamed from: e  reason: collision with root package name */
    private String f8346e = "";

    /* renamed from: com.mbridge.msdk.dycreator.baseview.MBLinearLayout$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8347a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8347a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8347a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8347a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_centerHorizontal     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8347a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_centerVertical     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8347a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_weight     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8347a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.gravity     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8347a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_margin     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8347a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginLeft     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8347a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginRight     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f8347a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginTop     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f8347a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginBottom     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f8347a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_gravity     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.MBLinearLayout.AnonymousClass1.<clinit>():void");
        }
    }

    public MBLinearLayout(Context context) {
        super(context);
    }

    public String getActionDes() {
        Map<String, String> map = this.f8344c;
        if (map == null || !map.containsKey("mbridgeAction")) {
            return "";
        }
        return this.f8344c.get("mbridgeAction");
    }

    public String getBindDataDes() {
        Map<String, String> map = this.f8344c;
        if (map == null || !map.containsKey("mbridgeData")) {
            return "";
        }
        return this.f8344c.get("mbridgeData");
    }

    public String getEffectDes() {
        Map<String, String> map = this.f8344c;
        if (map == null || !map.containsKey("mbridgeEffect")) {
            return "";
        }
        return this.f8344c.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.f8344c;
        if (map == null || !map.containsKey("mbridgeReport")) {
            return "";
        }
        return this.f8344c.get("mbridgeReport");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.f8344c;
        if (map == null || !map.containsKey("mbridgeStrategy")) {
            return "";
        }
        return this.f8344c.get("mbridgeStrategy");
    }

    public float getxInScreen() {
        return this.f8342a;
    }

    public float getyInScreen() {
        return this.f8343b;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f8345d;
        if (map != null && map.containsKey("mbridgeAttached") && this.f8345d.get("mbridgeAttached").booleanValue()) {
            new k.a("mbridgeAttached").a().a(this.f8346e);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f8345d;
        if (map != null && map.containsKey("mbridgeDetached") && this.f8345d.get("mbridgeDetached").booleanValue()) {
            new k.a("mbridgeDetached").a().a(this.f8346e);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f8342a = motionEvent.getRawX();
        this.f8343b = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
    }

    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f8345d = c.a(str);
        if (campaignEx != null) {
            this.f8346e = campaignEx.getCampaignUnitId();
        }
    }

    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        HashMap b5 = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            com.mbridge.msdk.dycreator.a.c cVar = (com.mbridge.msdk.dycreator.a.c) b5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                switch (AnonymousClass1.f8347a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i5);
                        if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
                            if (!attributeValue.startsWith("wrap")) {
                                generateDefaultLayoutParams.width = b.a().b(attributeValue);
                                break;
                            } else {
                                generateDefaultLayoutParams.width = -2;
                                break;
                            }
                        } else {
                            generateDefaultLayoutParams.width = -1;
                            break;
                        }
                    case 2:
                        String attributeValue2 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
                            if (!attributeValue2.startsWith("wrap")) {
                                generateDefaultLayoutParams.height = b.a().b(attributeValue2);
                                break;
                            } else {
                                generateDefaultLayoutParams.height = -2;
                                break;
                            }
                        } else {
                            generateDefaultLayoutParams.height = -1;
                            break;
                        }
                        break;
                    case 3:
                        generateDefaultLayoutParams.gravity = 1;
                        break;
                    case 4:
                        generateDefaultLayoutParams.gravity = 16;
                        break;
                    case 5:
                        generateDefaultLayoutParams.weight = attributeSet.getAttributeFloatValue(i5, 0.0f);
                        break;
                    case 6:
                        setGravity(b.a().c(attributeSet.getAttributeValue(i5)));
                        break;
                    case 7:
                        int b6 = b.a().b(attributeSet.getAttributeValue(i5));
                        generateDefaultLayoutParams.bottomMargin = b6;
                        generateDefaultLayoutParams.leftMargin = b6;
                        generateDefaultLayoutParams.rightMargin = b6;
                        generateDefaultLayoutParams.topMargin = b6;
                        break;
                    case 8:
                        generateDefaultLayoutParams.leftMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 9:
                        generateDefaultLayoutParams.rightMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 10:
                        generateDefaultLayoutParams.topMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 11:
                        generateDefaultLayoutParams.bottomMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 12:
                        generateDefaultLayoutParams.gravity = b.a().c(attributeSet.getAttributeValue(i5));
                        break;
                }
            }
        }
        return generateDefaultLayoutParams;
    }

    public MBLinearLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.f8344c = c.a(context, attributeSet);
        a.a(this, attributeSet);
        setLayoutParams(generateLayoutParams(attributeSet));
        c.a(this.f8344c, (View) this);
    }

    public MBLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
