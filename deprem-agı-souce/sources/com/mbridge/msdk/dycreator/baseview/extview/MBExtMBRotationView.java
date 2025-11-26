package com.mbridge.msdk.dycreator.baseview.extview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.dycreator.baseview.cusview.MBRotationView;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

public class MBExtMBRotationView extends MBRotationView implements InterBase {

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f8520b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Boolean> f8521c;

    /* renamed from: d  reason: collision with root package name */
    private String f8522d = "";

    /* renamed from: com.mbridge.msdk.dycreator.baseview.extview.MBExtMBRotationView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8523a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8523a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.id     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8523a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.background     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8523a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.contentDescription     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8523a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.visibility     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8523a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8523a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8523a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_gravity     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8523a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_marginLeft     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8523a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_margin     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.extview.MBExtMBRotationView.AnonymousClass1.<clinit>():void");
        }
    }

    public MBExtMBRotationView(Context context) {
        super(context);
    }

    public String getActionDes() {
        Map<String, String> map = this.f8520b;
        if (map == null || !map.containsKey("mbridgeAction")) {
            return "";
        }
        return this.f8520b.get("mbridgeAction");
    }

    public String getBindDataDes() {
        Map<String, String> map = this.f8520b;
        if (map == null || !map.containsKey("mbridgeData")) {
            return "";
        }
        return this.f8520b.get("mbridgeData");
    }

    public String getEffectDes() {
        Map<String, String> map = this.f8520b;
        if (map == null || !map.containsKey("mbridgeEffect")) {
            return "";
        }
        return this.f8520b.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.f8520b;
        if (map == null || !map.containsKey("mbridgeReport")) {
            return "";
        }
        return this.f8520b.get("mbridgeReport");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.f8520b;
        if (map == null || !map.containsKey("mbridgeStrategy")) {
            return "";
        }
        return this.f8520b.get("mbridgeStrategy");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f8521c;
        if (map != null && map.containsKey("mbridgeAttached") && this.f8521c.get("mbridgeAttached").booleanValue()) {
            new k.a("mbridgeAttached").a().a(this.f8522d);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f8521c;
        if (map != null && map.containsKey("mbridgeDetached") && this.f8521c.get("mbridgeDetached").booleanValue()) {
            new k.a("mbridgeDetached").a().a(this.f8522d);
        }
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        String[] strArr;
        HashMap<String, c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            c cVar = c5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                int i6 = AnonymousClass1.f8523a[cVar.ordinal()];
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
                    } else if (attributeValue2.startsWith("@color/")) {
                        setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i5)));
                    } else {
                        if (attributeValue2.startsWith("@drawable/")) {
                            attributeValue2 = attributeValue2.substring(10);
                        }
                        setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeFile(getContext().getFilesDir().toString() + "/" + attributeValue2 + ".png")));
                    }
                } else if (i6 == 3) {
                    setContentDescription(attributeSet.getAttributeValue(i5));
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
    }

    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f8521c = com.mbridge.msdk.dycreator.e.c.a(str);
        if (campaignEx != null) {
            this.f8522d = campaignEx.getCampaignUnitId();
        }
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        HashMap b5 = b.a().b();
        layoutParams.width = -2;
        layoutParams.height = -2;
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            c cVar = (c) b5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                switch (AnonymousClass1.f8523a[cVar.ordinal()]) {
                    case 5:
                        String attributeValue = attributeSet.getAttributeValue(i5);
                        if (!attributeValue.startsWith("f") && !attributeValue.startsWith("m")) {
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
                    case 6:
                        String attributeValue2 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue2.startsWith("f") && !attributeValue2.startsWith("m")) {
                            if (!attributeValue2.startsWith("w")) {
                                layoutParams.height = b.a().b(attributeValue2);
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
                    case 7:
                        layoutParams.gravity = b.a().c(attributeSet.getAttributeValue(i5));
                        break;
                    case 8:
                        layoutParams.leftMargin = b.a().b(attributeSet.getAttributeValue(i5));
                        break;
                    case 9:
                        int b6 = b.a().b(attributeSet.getAttributeValue(i5));
                        layoutParams.setMargins(b6, b6, b6, b6);
                        break;
                }
            }
        }
        return layoutParams;
    }

    public MBExtMBRotationView(Context context, AttributeSet attributeSet) {
        super(context);
        try {
            this.f8520b = com.mbridge.msdk.dycreator.e.c.a(context, attributeSet);
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            com.mbridge.msdk.dycreator.e.c.a(this.f8520b, (View) this);
        } catch (Exception e5) {
            af.b("MBExtMBRotationView", e5.getMessage());
        }
    }

    public MBExtMBRotationView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
