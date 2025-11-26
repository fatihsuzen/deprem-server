package com.mbridge.msdk.dycreator.baseview.extview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeImageView;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

public class MBExtMBridgeImageView extends MBridgeImageView implements InterBase {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f8526a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Boolean> f8527b;

    /* renamed from: c  reason: collision with root package name */
    private String f8528c = "";

    /* renamed from: d  reason: collision with root package name */
    private int f8529d;

    /* renamed from: e  reason: collision with root package name */
    private int f8530e;

    /* renamed from: f  reason: collision with root package name */
    private int f8531f;

    /* renamed from: g  reason: collision with root package name */
    private int f8532g;

    /* renamed from: com.mbridge.msdk.dycreator.baseview.extview.MBExtMBridgeImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8533a;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8533a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.id     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.src     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.background     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.contentDescription     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.tag     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.visibility     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.scaleType     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.padding     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingTop     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingBottom     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingLeft     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingRight     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.gravity     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f8533a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_gravity     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.extview.MBExtMBridgeImageView.AnonymousClass1.<clinit>():void");
        }
    }

    public MBExtMBridgeImageView(Context context) {
        super(context);
    }

    public ViewGroup.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HashMap<String, c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            c cVar = c5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                int i6 = AnonymousClass1.f8533a[cVar.ordinal()];
                if (i6 == 6) {
                    String attributeValue = attributeSet.getAttributeValue(i5);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        if (attributeValue.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                } else if (i6 == 13) {
                    String attributeValue2 = attributeSet.getAttributeValue(i5);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue2);
                    }
                } else if (i6 == 14) {
                    String attributeValue3 = attributeSet.getAttributeValue(i5);
                    if (attributeValue3.startsWith("f") || attributeValue3.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue3.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue3);
                    }
                }
            }
        }
        return layoutParams;
    }

    public String getActionDes() {
        Map<String, String> map = this.f8526a;
        if (map == null || !map.containsKey("mbridgeAction")) {
            return "";
        }
        return this.f8526a.get("mbridgeAction");
    }

    public String getBindDataDes() {
        Map<String, String> map = this.f8526a;
        if (map == null || !map.containsKey("mbridgeData")) {
            return "";
        }
        return this.f8526a.get("mbridgeData");
    }

    public String getEffectDes() {
        Map<String, String> map = this.f8526a;
        if (map == null || !map.containsKey("mbridgeEffect")) {
            return "";
        }
        return this.f8526a.get("mbridgeEffect");
    }

    public String getReportDes() {
        Map<String, String> map = this.f8526a;
        if (map == null || !map.containsKey("mbridgeReport")) {
            return "";
        }
        return this.f8526a.get("mbridgeReport");
    }

    public String getStrategyDes() {
        Map<String, String> map = this.f8526a;
        if (map == null || !map.containsKey("mbridgeStrategy")) {
            return "";
        }
        return this.f8526a.get("mbridgeStrategy");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f8527b;
        if (map != null && map.containsKey("mbridgeAttached") && this.f8527b.get("mbridgeAttached").booleanValue()) {
            new k.a("mbridgeAttached").a().a(this.f8528c);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f8527b;
        if (map != null && map.containsKey("mbridgeDetached") && this.f8527b.get("mbridgeDetached").booleanValue()) {
            new k.a("mbridgeDetached").a().a(this.f8528c);
        }
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        String[] strArr;
        HashMap<String, c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            c cVar = c5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                switch (AnonymousClass1.f8533a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i5);
                        if (!attributeValue.startsWith("@+id/")) {
                            break;
                        } else {
                            setId(attributeValue.substring(5).hashCode());
                            break;
                        }
                    case 2:
                        b.a().a(attributeSet.getAttributeValue(i5), (ImageView) this);
                        break;
                    case 3:
                        String attributeValue2 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue2.startsWith("#")) {
                            if (attributeValue2.startsWith("@drawable/")) {
                                attributeValue2 = attributeValue2.substring(10);
                            }
                            setBackgroundResource(getResources().getIdentifier(attributeValue2, "drawable", getContext().getPackageName()));
                            break;
                        } else {
                            try {
                                strArr = attributeValue2.split("-");
                            } catch (Exception unused) {
                                strArr = null;
                            }
                            if (strArr != null && strArr.length <= 2) {
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i5)));
                                break;
                            } else {
                                if (strArr != null && strArr.length == 3) {
                                    try {
                                        GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArr[2]), new int[]{Color.parseColor(strArr[0]), Color.parseColor(strArr[1])});
                                        gradientDrawable.setGradientType(0);
                                        setBackground(gradientDrawable);
                                        break;
                                    } catch (Exception unused2) {
                                    }
                                }
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i5)));
                                break;
                            }
                        }
                        break;
                    case 4:
                        String attributeValue3 = attributeSet.getAttributeValue(i5);
                        if (TextUtils.isEmpty(attributeValue3)) {
                            break;
                        } else {
                            String str = com.mbridge.msdk.dycreator.e.b.f8692a.get(attributeValue3.substring(8));
                            if (TextUtils.isEmpty(str)) {
                                break;
                            } else {
                                setContentDescription(str);
                                break;
                            }
                        }
                    case 5:
                        String attributeValue4 = attributeSet.getAttributeValue(i5);
                        if (!TextUtils.isEmpty(attributeValue4)) {
                            String str2 = com.mbridge.msdk.dycreator.e.b.f8692a.get(attributeValue4.substring(8));
                            if (!TextUtils.isEmpty(str2)) {
                                setTag(str2);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case 6:
                        String attributeValue5 = attributeSet.getAttributeValue(i5);
                        if (!TextUtils.isEmpty(attributeValue5)) {
                            if (!attributeValue5.equals("invisible")) {
                                if (!attributeValue5.equalsIgnoreCase("gone")) {
                                    break;
                                } else {
                                    setVisibility(8);
                                    break;
                                }
                            } else {
                                setVisibility(4);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 7:
                        String attributeValue6 = attributeSet.getAttributeValue(i5);
                        if (!TextUtils.isEmpty(attributeValue6)) {
                            if (!attributeValue6.equals("fitXY")) {
                                if (!attributeValue6.equals("centerInside")) {
                                    if (!attributeValue6.equals("centerCrop")) {
                                        break;
                                    } else {
                                        setScaleType(ImageView.ScaleType.CENTER_CROP);
                                        break;
                                    }
                                } else {
                                    setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                    break;
                                }
                            } else {
                                setScaleType(ImageView.ScaleType.FIT_XY);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 8:
                        int b5 = b.a().b(attributeSet.getAttributeValue(i5));
                        this.f8532g = b5;
                        this.f8531f = b5;
                        this.f8530e = b5;
                        this.f8529d = b5;
                        setPadding(b5, b5, b5, b5);
                        break;
                    case 9:
                        int b6 = b.a().b(attributeSet.getAttributeValue(i5));
                        this.f8530e = b6;
                        setPadding(this.f8529d, b6, this.f8531f, this.f8532g);
                        break;
                    case 10:
                        int b7 = b.a().b(attributeSet.getAttributeValue(i5));
                        this.f8532g = b7;
                        setPadding(this.f8529d, this.f8530e, this.f8531f, b7);
                        break;
                    case 11:
                        int b8 = b.a().b(attributeSet.getAttributeValue(i5));
                        this.f8529d = b8;
                        setPadding(b8, this.f8530e, this.f8531f, this.f8532g);
                        break;
                    case 12:
                        int b9 = b.a().b(attributeSet.getAttributeValue(i5));
                        this.f8531f = b9;
                        setPadding(this.f8529d, this.f8530e, b9, this.f8532g);
                        break;
                }
            }
        }
    }

    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f8527b = com.mbridge.msdk.dycreator.e.c.a(str);
        if (campaignEx != null) {
            this.f8528c = campaignEx.getCampaignUnitId();
        }
    }

    public MBExtMBridgeImageView(Context context, AttributeSet attributeSet) {
        super(context);
        try {
            this.f8526a = com.mbridge.msdk.dycreator.e.c.a(context, attributeSet);
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(context, attributeSet));
            com.mbridge.msdk.dycreator.e.c.a(this.f8526a, (View) this);
        } catch (Exception e5) {
            af.b("MBExtMBridgeImageView", e5.getMessage());
        }
    }

    public MBExtMBridgeImageView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }
}
