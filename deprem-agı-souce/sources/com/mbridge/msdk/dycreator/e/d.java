package com.mbridge.msdk.dycreator.e;

import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public final class d {
    public static boolean a(View view, a aVar) {
        String[] split;
        if (view != null) {
            try {
                if ((view instanceof InterBase) && aVar != null) {
                    String actionDes = ((InterBase) view).getActionDes();
                    if (!TextUtils.isEmpty(actionDes) && (split = actionDes.split("\\|")) != null && split.length >= 2 && !TextUtils.isEmpty(split[0]) && split[0].startsWith(CampaignEx.JSON_NATIVE_VIDEO_CLICK) && !TextUtils.isEmpty(split[1]) && split[1].equals("alecfc") && aVar.getEffectData() != null) {
                        return aVar.getEffectData().isClickScreen();
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return true;
    }

    public static void a(String str, View view, boolean z4) {
        if (view != null && (view instanceof InterBase) && !TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("\\|");
                if (split != null && split.length >= 2 && !TextUtils.isEmpty(split[0]) && split[0].startsWith("visible") && !TextUtils.isEmpty(split[1]) && split[1].equals("parent") && z4) {
                    view.setVisibility(8);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|(1:13)|(2:15|16)) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        if ((r3 instanceof com.mbridge.msdk.dycreator.f.a.a) != false) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r1 = ((com.mbridge.msdk.dycreator.f.a.a) r3).getBindData().getClass().getMethod(r4, (java.lang.Class[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (r1 != null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        return r1.invoke(((com.mbridge.msdk.dycreator.f.a.a) r3).getBindData(), (java.lang.Object[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(java.lang.Object r3, java.lang.String r4) {
        /*
            r0 = 0
            java.lang.Class r1 = r3.getClass()     // Catch:{ NoSuchMethodException -> 0x0012 }
            java.lang.reflect.Method r1 = r1.getMethod(r4, r0)     // Catch:{ NoSuchMethodException -> 0x0012 }
            if (r1 == 0) goto L_0x0036
            java.lang.Object r3 = r1.invoke(r3, r0)     // Catch:{ NoSuchMethodException -> 0x0013 }
            return r3
        L_0x0010:
            r3 = move-exception
            goto L_0x0033
        L_0x0012:
            r1 = r0
        L_0x0013:
            boolean r2 = r3 instanceof com.mbridge.msdk.dycreator.f.a.a     // Catch:{ Exception -> 0x0010 }
            if (r2 == 0) goto L_0x0026
            r1 = r3
            com.mbridge.msdk.dycreator.f.a.a r1 = (com.mbridge.msdk.dycreator.f.a.a) r1     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.getBindData()     // Catch:{ Exception -> 0x0010 }
            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x0010 }
            java.lang.reflect.Method r1 = r1.getMethod(r4, r0)     // Catch:{ Exception -> 0x0010 }
        L_0x0026:
            if (r1 == 0) goto L_0x0036
            com.mbridge.msdk.dycreator.f.a.a r3 = (com.mbridge.msdk.dycreator.f.a.a) r3     // Catch:{ Exception -> 0x0010 }
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r3.getBindData()     // Catch:{ Exception -> 0x0010 }
            java.lang.Object r3 = r1.invoke(r3, r0)     // Catch:{ Exception -> 0x0010 }
            return r3
        L_0x0033:
            r3.printStackTrace()
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.e.d.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    public static String a(boolean z4, int i5, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2) || !str2.contains("zh")) {
            return str + " " + i5 + "s";
        } else if (z4) {
            return str + i5 + "s";
        } else {
            return i5 + "s " + str;
        }
    }
}
