package com.mbridge.msdk.dycreator.e;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.dycreator.binding.b;
import com.mbridge.msdk.foundation.tools.af;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public static double a(double d5, double d6, int i5) {
        if (i5 < 0) {
            return 1.0d;
        }
        try {
            return new BigDecimal(Double.toString(d5)).divide(new BigDecimal(Double.toString(d6)), i5, 4).doubleValue();
        } catch (Exception e5) {
            af.b("CommUtil", e5.getMessage());
            return 1.0d;
        }
    }

    public static int a(Context context, float f5) {
        if (context == null) {
            return 0;
        }
        try {
            Resources resources = context.getResources();
            if (resources == null) {
                return 0;
            }
            return (int) ((f5 * resources.getDisplayMetrics().density) + 0.5f);
        } catch (Exception e5) {
            af.b("CommUtil", e5.getMessage());
            return 0;
        }
    }

    public static Map<String, String> a(Context context, AttributeSet attributeSet) {
        HashMap hashMap = new HashMap();
        if (!(context == null || attributeSet == null)) {
            int attributeCount = attributeSet.getAttributeCount();
            for (int i5 = 0; i5 < attributeCount; i5++) {
                String attributeName = attributeSet.getAttributeName(i5);
                if (!TextUtils.isEmpty(attributeName)) {
                    if (attributeName.equals("mbridge_data")) {
                        try {
                            hashMap.put("mbridgeData", b.f8692a.get(attributeSet.getAttributeValue(i5).substring(8)));
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_click")) {
                        try {
                            hashMap.put("mbridgeAction", b.f8692a.get(attributeSet.getAttributeValue(i5).substring(8)));
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_strategy")) {
                        try {
                            hashMap.put("mbridgeStrategy", b.f8692a.get(attributeSet.getAttributeValue(i5).substring(8)));
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_effect")) {
                        try {
                            hashMap.put("mbridgeEffect", b.f8692a.get(attributeSet.getAttributeValue(i5).substring(8)));
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_report")) {
                        try {
                            hashMap.put("mbridgeReport", attributeSet.getAttributeValue(i5));
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public static void a(Map<String, String> map, View view) {
        if (map != null && view != null) {
            if (map.containsKey("mbridgeData")) {
                b.a().c(view);
            }
            if (map.containsKey("mbridgeAction")) {
                b.a().d(view);
            }
            if (map.containsKey("mbridgeEffect")) {
                b.a().b(view);
            }
            if (map.containsKey("mbridgeReport")) {
                b.a().a(view);
            }
        }
    }

    public static Map<String, Boolean> a(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\|");
            if (split == null || split.length <= 0) {
                if (str.equals("mbridgeAttached")) {
                    hashMap.put("mbridgeAttached", Boolean.TRUE);
                }
                if (str.equals("mbridgeDetached")) {
                    hashMap.put("mbridgeDetached", Boolean.TRUE);
                }
            } else {
                for (String str2 : split) {
                    if (str2.equals("mbridgeAttached")) {
                        hashMap.put("mbridgeAttached", Boolean.TRUE);
                    }
                    if (str2.equals("mbridgeDetached")) {
                        hashMap.put("mbridgeDetached", Boolean.TRUE);
                    }
                }
            }
        }
        return hashMap;
    }
}
