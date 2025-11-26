package com.mbridge.msdk.dycreator.baseview.extview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import java.util.HashMap;
import java.util.Map;

public class MBExtMBridgeSegmentsProgressBar extends MBridgeSegmentsProgressBar implements InterBase {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f8534a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Boolean> f8535b;

    /* renamed from: c  reason: collision with root package name */
    private String f8536c = "";

    /* renamed from: com.mbridge.msdk.dycreator.baseview.extview.MBExtMBridgeSegmentsProgressBar$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8537a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8537a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.id     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.background     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.orientation     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.visibility     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.padding     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_centerHorizontal     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_centerVertical     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_weight     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.gravity     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_margin     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginLeft     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginRight     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginTop     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginBottom     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f8537a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_gravity     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.extview.MBExtMBridgeSegmentsProgressBar.AnonymousClass1.<clinit>():void");
        }
    }

    public MBExtMBridgeSegmentsProgressBar(Context context) {
        super(context);
    }

    public String getActionDes() {
        Map<String, String> map = this.f8534a;
        if (map == null || !map.containsKey("mbridgeAction")) {
            return "";
        }
        return this.f8534a.get("mbridgeAction");
    }

    public String getBindDataDes() {
        Map<String, String> map = this.f8534a;
        if (map == null || !map.containsKey("mbridgeData")) {
            return "";
        }
        return this.f8534a.get("mbridgeData");
    }

    public String getEffectDes() {
        Map<String, String> map = this.f8534a;
        if (map == null || !map.containsKey("mbridgeEffect")) {
            return "";
        }
        return this.f8534a.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.f8534a;
        if (map == null || !map.containsKey("mbridgeReport")) {
            return "";
        }
        return this.f8534a.get("mbridgeReport");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.f8534a;
        if (map == null || !map.containsKey("mbridgeStrategy")) {
            return "";
        }
        return this.f8534a.get("mbridgeStrategy");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f8535b;
        if (map != null && map.containsKey("mbridgeAttached") && this.f8535b.get("mbridgeAttached").booleanValue()) {
            new k.a("mbridgeAttached").a().a(this.f8536c);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f8535b;
        if (map != null && map.containsKey("mbridgeDetached") && this.f8535b.get("mbridgeDetached").booleanValue()) {
            new k.a("mbridgeDetached").a().a(this.f8536c);
        }
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        String[] strArr;
        HashMap<String, c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            c cVar = c5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                int i6 = AnonymousClass1.f8537a[cVar.ordinal()];
                if (i6 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i5);
                    if (attributeValue.startsWith("@+id/")) {
                        setId(attributeValue.substring(5).hashCode());
                    }
                } else if (i6 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i5);
                    if (attributeValue2.startsWith("#")) {
                        try {
                            strArr = attributeValue2.split("-");
                        } catch (Exception unused) {
                            strArr = null;
                        }
                        if (strArr == null || strArr.length > 2) {
                            if (strArr != null && strArr.length == 3) {
                                try {
                                    GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArr[2]), new int[]{Color.parseColor(strArr[0]), Color.parseColor(strArr[1])});
                                    gradientDrawable.setGradientType(0);
                                    setBackground(gradientDrawable);
                                } catch (Exception unused2) {
                                }
                            }
                            setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i5)));
                        } else {
                            setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i5)));
                        }
                    } else {
                        if (attributeValue2.startsWith("@drawable/")) {
                            attributeValue2 = attributeValue2.substring(10);
                        }
                        setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeFile(getContext().getFilesDir().toString() + "/" + attributeValue2 + ".png")));
                    }
                } else if (i6 != 3) {
                    if (i6 == 4) {
                        String attributeValue3 = attributeSet.getAttributeValue(i5);
                        if (!TextUtils.isEmpty(attributeValue3)) {
                            if (attributeValue3.equals("invisible")) {
                                setVisibility(4);
                            } else if (attributeValue3.equalsIgnoreCase("gone")) {
                                setVisibility(8);
                            }
                        }
                    } else if (i6 == 5) {
                        int b5 = b.a().b(attributeSet.getAttributeValue(i5));
                        setPadding(b5, b5, b5, b5);
                    }
                } else if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i5))) {
                    setOrientation(0);
                } else {
                    setOrientation(1);
                }
            }
        }
    }

    public void setDynamicReport(String str, CampaignEx campaignEx) {
    }

    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        HashMap b5 = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            c cVar = (c) b5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                switch (AnonymousClass1.f8537a[cVar.ordinal()]) {
                    case 6:
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
                    case 7:
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
                    case 8:
                        generateDefaultLayoutParams.gravity = 1;
                        break;
                    case 9:
                        generateDefaultLayoutParams.gravity = 16;
                        break;
                    case 10:
                        generateDefaultLayoutParams.weight = attributeSet.getAttributeFloatValue(i5, 0.0f);
                        break;
                    case 11:
                        setGravity(b.a().c(attributeSet.getAttributeValue(i5)));
                        break;
                    case 12:
                        int b6 = b.a().b(attributeSet.getAttributeValue(i5));
                        generateDefaultLayoutParams.bottomMargin = b6;
                        generateDefaultLayoutParams.leftMargin = b6;
                        generateDefaultLayoutParams.rightMargin = b6;
                        generateDefaultLayoutParams.topMargin = b6;
                        break;
                    case 13:
                        generateDefaultLayoutParams.leftMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 14:
                        generateDefaultLayoutParams.rightMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 15:
                        generateDefaultLayoutParams.topMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 16:
                        generateDefaultLayoutParams.bottomMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 17:
                        generateDefaultLayoutParams.gravity = b.a().c(attributeSet.getAttributeValue(i5));
                        break;
                }
            }
        }
        return generateDefaultLayoutParams;
    }

    public MBExtMBridgeSegmentsProgressBar(Context context, AttributeSet attributeSet) {
        super(context);
        try {
            this.f8534a = com.mbridge.msdk.dycreator.e.c.a(context, attributeSet);
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            com.mbridge.msdk.dycreator.e.c.a(this.f8534a, (View) this);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public MBExtMBridgeSegmentsProgressBar(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
