package com.mbridge.msdk.foundation.same.report.d;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.b;
import com.mbridge.msdk.foundation.same.report.d.a.a;
import com.mbridge.msdk.tracker.e;
import com.mbridge.msdk.tracker.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class f {
    private Map<String, String> c(String str, c cVar) {
        e eVar = new e();
        try {
            if (str.equals("2000125")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000123")));
            } else if (str.equals("2000126")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000125")));
            } else if (str.equals("2000127")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000123")));
            } else if (str.equals("2000154")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000126")));
            } else if (str.equals("2000047")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000123")));
            } else if (str.equals("2000048")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000123")));
            } else if (str.equals("2000155")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000154")));
            } else if (str.equals("2000146")) {
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(cVar.l("2000130")));
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
        return eVar.a();
    }

    private Map<String, String> d(String str, c cVar) {
        HashMap hashMap = new HashMap();
        try {
            if (Arrays.asList(b.f9463e).contains(str)) {
                String str2 = "";
                if (cVar != null) {
                    str2 = cVar.d();
                }
                hashMap.put("auto_load", str2);
            }
            if (cVar != null) {
                Map<String, Map<String, String>> p5 = cVar.p();
                String str3 = cVar.f() + str;
                if (p5.containsKey(str3) && p5.get(str3) != null) {
                    hashMap.putAll(p5.get(str3));
                }
                try {
                    Map<String, Map<String, String>> q5 = cVar.q();
                    String str4 = cVar.f() + "_" + cVar.b() + "_" + str;
                    if (q5.containsKey(str4) && q5.get(str4) != null) {
                        hashMap.putAll(q5.get(str4));
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        } catch (Exception e6) {
            if (MBridgeConstans.DEBUG) {
                e6.printStackTrace();
            }
        }
        return hashMap;
    }

    public final void a(String str, m mVar, c cVar, a aVar) {
        Map<String, String> c5;
        HashMap hashMap = new HashMap();
        if (cVar != null && !TextUtils.isEmpty(str)) {
            try {
                cVar.a(str);
                Map<String, String> b5 = b(str, cVar);
                if (b5 != null) {
                    hashMap.putAll(b5);
                }
                Map<String, String> a5 = a(str, cVar.i(), mVar);
                if (a5 != null) {
                    hashMap.putAll(a5);
                }
                if (Arrays.asList(b.f9462d).contains(str) && (c5 = c(str, cVar)) != null) {
                    hashMap.putAll(c5);
                }
                Map<String, String> d5 = d(str, cVar);
                if (d5 != null) {
                    hashMap.putAll(d5);
                }
                if (!hashMap.containsKey("lrid") || TextUtils.isEmpty((CharSequence) hashMap.get("lrid"))) {
                    hashMap.put("lrid", cVar.f());
                }
                Map<String, String> a6 = a(str, cVar);
                if (a6 != null) {
                    hashMap.putAll(a6);
                }
                if (cVar.d() == null || !cVar.d().equals("1") || !Arrays.asList(b.f9460b).contains(str) || cVar.j() == 296) {
                    e a7 = a(str, (Map<String, String>) hashMap);
                    if (!(mVar == null || a7 == null)) {
                        mVar.a(a7);
                    }
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void b(String str, m mVar, c cVar, a aVar) {
        if (cVar != null && !TextUtils.isEmpty(str)) {
            try {
                HashMap hashMap = new HashMap();
                cVar.a(str);
                Map<String, String> a5 = a(str, cVar.i(), mVar);
                if (a5 != null) {
                    hashMap.putAll(a5);
                }
                Map<String, String> d5 = d(str, cVar);
                if (d5 != null) {
                    hashMap.putAll(d5);
                }
                Map<String, String> a6 = a(str, cVar);
                if (a6 != null) {
                    hashMap.putAll(a6);
                }
                e a7 = a(str, (Map<String, String>) hashMap);
                if (!(mVar == null || a7 == null)) {
                    mVar.a(a7);
                }
                if (aVar != null) {
                    aVar.a();
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        if (r2.g().getAdType() == 295) goto L_0x0052;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01f4 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x022b A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0271 A[SYNTHETIC, Splitter:B:116:0x0271] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0290 A[SYNTHETIC, Splitter:B:126:0x0290] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x030e A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0365 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03a6 A[SYNTHETIC, Splitter:B:165:0x03a6] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03c7 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03ef A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x03f0 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0408 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0426 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0433 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0451 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x045c A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x047b A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x048a A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x04b5 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04e4 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0536  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0594 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x065f  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cd A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d2 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0186 A[Catch:{ Exception -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01bd A[Catch:{ Exception -> 0x002a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.String> b(java.lang.String r20, com.mbridge.msdk.foundation.same.report.d.c r21) {
        /*
            r19 = this;
            r1 = r20
            r2 = r21
            java.lang.String r3 = "rid_n"
            java.lang.String r4 = "cid"
            java.lang.String r5 = "dspid"
            java.lang.String r6 = "ec_temp_id"
            java.lang.String r7 = "endcard_crid"
            java.lang.String r8 = "video_crid"
            java.lang.String r9 = "crid"
            java.lang.String r10 = "vtid"
            com.mbridge.msdk.foundation.same.report.d.e r11 = new com.mbridge.msdk.foundation.same.report.d.e
            r11.<init>()
            java.lang.String[] r0 = com.mbridge.msdk.foundation.same.report.d.b.f9465g     // Catch:{ Exception -> 0x002a }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Exception -> 0x002a }
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x002d
            java.util.Map r0 = r11.a()     // Catch:{ Exception -> 0x002a }
            return r0
        L_0x002a:
            r0 = move-exception
            goto L_0x065b
        L_0x002d:
            if (r2 != 0) goto L_0x003b
            java.lang.String r0 = "metrics_data_reason"
            java.lang.String r1 = "metrics 上报时意外为空"
            r11.a(r0, r1)     // Catch:{ Exception -> 0x002a }
            java.util.Map r0 = r11.a()     // Catch:{ Exception -> 0x002a }
            return r0
        L_0x003b:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x002a }
            r12.<init>()     // Catch:{ Exception -> 0x002a }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.g()     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x005f
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.g()     // Catch:{ all -> 0x0055 }
            int r0 = r0.getAdType()     // Catch:{ all -> 0x0055 }
            r13 = 295(0x127, float:4.13E-43)
            if (r0 != r13) goto L_0x005f
        L_0x0052:
            r13 = r19
            goto L_0x00a5
        L_0x0055:
            r0 = move-exception
            java.lang.String r13 = "SameMetricsReport"
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x002a }
            com.mbridge.msdk.foundation.tools.af.b(r13, r0)     // Catch:{ Exception -> 0x002a }
        L_0x005f:
            java.lang.String[] r0 = com.mbridge.msdk.foundation.same.report.d.b.f9464f     // Catch:{ Exception -> 0x002a }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Exception -> 0x002a }
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0052
            java.lang.String r0 = "m_download_start"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x00a0 }
            if (r0 != 0) goto L_0x007b
            java.lang.String r0 = "m_download_end"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x007e
        L_0x007b:
            r13 = r19
            goto L_0x009b
        L_0x007e:
            java.util.List r0 = r2.h()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0089
            java.util.List r0 = r2.h()     // Catch:{ Exception -> 0x002a }
            goto L_0x008d
        L_0x0089:
            java.util.List r0 = r2.e()     // Catch:{ Exception -> 0x002a }
        L_0x008d:
            if (r0 == 0) goto L_0x0098
            int r2 = r0.size()     // Catch:{ Exception -> 0x002a }
            if (r2 <= 0) goto L_0x0098
            r12.addAll(r0)     // Catch:{ Exception -> 0x002a }
        L_0x0098:
            r13 = r19
            goto L_0x00c7
        L_0x009b:
            java.util.List r12 = r13.a((com.mbridge.msdk.foundation.same.report.d.c) r2, (java.lang.String) r1)     // Catch:{ Exception -> 0x002a }
            goto L_0x00c7
        L_0x00a0:
            r0 = move-exception
            r13 = r19
            goto L_0x065b
        L_0x00a5:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.g()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x00b3
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r2.g()     // Catch:{ Exception -> 0x002a }
            r12.add(r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x00c7
        L_0x00b3:
            java.util.List r0 = r2.h()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x00be
            java.util.List r0 = r2.h()     // Catch:{ Exception -> 0x002a }
            goto L_0x00c2
        L_0x00be:
            java.util.List r0 = r2.e()     // Catch:{ Exception -> 0x002a }
        L_0x00c2:
            if (r0 == 0) goto L_0x00c7
            r12.addAll(r0)     // Catch:{ Exception -> 0x002a }
        L_0x00c7:
            boolean r0 = r12.isEmpty()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x00d2
            java.util.Map r0 = r11.a()     // Catch:{ Exception -> 0x002a }
            return r0
        L_0x00d2:
            java.util.Iterator r0 = r12.iterator()     // Catch:{ Exception -> 0x002a }
        L_0x00d6:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x002a }
            if (r2 == 0) goto L_0x0662
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x002a }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x002a }
            if (r2 != 0) goto L_0x00e5
            goto L_0x00d6
        L_0x00e5:
            java.lang.String r12 = r2.getNLRid()     // Catch:{ Exception -> 0x002a }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x002a }
            java.lang.String r14 = "lrid"
            if (r12 != 0) goto L_0x0115
            java.lang.String r12 = "n_lrid"
            java.lang.String r15 = r2.getNLRid()     // Catch:{ Exception -> 0x002a }
            r11.a(r12, r15)     // Catch:{ Exception -> 0x002a }
            java.lang.String r12 = r2.getNRid()     // Catch:{ Exception -> 0x002a }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x002a }
            if (r12 != 0) goto L_0x010d
            java.lang.String r12 = "n_rid"
            java.lang.String r15 = r2.getNRid()     // Catch:{ Exception -> 0x002a }
            r11.a(r12, r15)     // Catch:{ Exception -> 0x002a }
        L_0x010d:
            java.lang.String r12 = r2.getLocalRequestId()     // Catch:{ Exception -> 0x002a }
            r11.a(r14, r12)     // Catch:{ Exception -> 0x002a }
            goto L_0x011c
        L_0x0115:
            java.lang.String r12 = r2.getLocalRequestId()     // Catch:{ Exception -> 0x002a }
            r11.a(r14, r12)     // Catch:{ Exception -> 0x002a }
        L_0x011c:
            java.lang.String r12 = "rid"
            java.lang.String r14 = r2.getRequestId()     // Catch:{ Exception -> 0x002a }
            r11.a(r12, r14)     // Catch:{ Exception -> 0x002a }
            int r12 = r2.getMof_tplid()     // Catch:{ Exception -> 0x002a }
            if (r12 == 0) goto L_0x0138
            java.lang.String r12 = "stid"
            int r14 = r2.getMof_tplid()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x002a }
            r11.a(r12, r14)     // Catch:{ Exception -> 0x002a }
        L_0x0138:
            com.mbridge.msdk.foundation.entity.CampaignEx$c r12 = r2.getRewardTemplateMode()     // Catch:{ Exception -> 0x002a }
            java.lang.String r14 = ","
            if (r12 == 0) goto L_0x017a
            int r15 = r12.f()     // Catch:{ Exception -> 0x002a }
            if (r15 == 0) goto L_0x017a
            boolean r15 = r11.a((java.lang.String) r10)     // Catch:{ Exception -> 0x002a }
            if (r15 == 0) goto L_0x016c
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r15.<init>()     // Catch:{ Exception -> 0x002a }
            r21 = r0
            java.lang.Object r0 = r11.b(r10)     // Catch:{ Exception -> 0x002a }
            r15.append(r0)     // Catch:{ Exception -> 0x002a }
            r15.append(r14)     // Catch:{ Exception -> 0x002a }
            int r0 = r12.f()     // Catch:{ Exception -> 0x002a }
            r15.append(r0)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r15.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r10, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x017c
        L_0x016c:
            r21 = r0
            int r0 = r12.f()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x002a }
            r11.a(r10, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x017c
        L_0x017a:
            r21 = r0
        L_0x017c:
            long r15 = r2.getCreativeId()     // Catch:{ Exception -> 0x002a }
            r17 = 0
            int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x01b5
            boolean r0 = r11.a((java.lang.String) r9)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x01aa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r12 = r11.b(r9)     // Catch:{ Exception -> 0x002a }
            r0.append(r12)     // Catch:{ Exception -> 0x002a }
            r0.append(r14)     // Catch:{ Exception -> 0x002a }
            long r12 = r2.getCreativeId()     // Catch:{ Exception -> 0x002a }
            r0.append(r12)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r9, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x01b5
        L_0x01aa:
            long r12 = r2.getCreativeId()     // Catch:{ Exception -> 0x002a }
            java.lang.Long r0 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x002a }
            r11.a(r9, r0)     // Catch:{ Exception -> 0x002a }
        L_0x01b5:
            long r12 = r2.getVidCrtvId()     // Catch:{ Exception -> 0x002a }
            int r0 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x01ec
            boolean r0 = r11.a((java.lang.String) r8)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x01e1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r12 = r11.b(r8)     // Catch:{ Exception -> 0x002a }
            r0.append(r12)     // Catch:{ Exception -> 0x002a }
            r0.append(r14)     // Catch:{ Exception -> 0x002a }
            long r12 = r2.getVidCrtvId()     // Catch:{ Exception -> 0x002a }
            r0.append(r12)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r8, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x01ec
        L_0x01e1:
            long r12 = r2.getVidCrtvId()     // Catch:{ Exception -> 0x002a }
            java.lang.Long r0 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x002a }
            r11.a(r8, r0)     // Catch:{ Exception -> 0x002a }
        L_0x01ec:
            long r12 = r2.getEcCrtvId()     // Catch:{ Exception -> 0x002a }
            int r0 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0223
            boolean r0 = r11.a((java.lang.String) r7)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0218
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r12 = r11.b(r7)     // Catch:{ Exception -> 0x002a }
            r0.append(r12)     // Catch:{ Exception -> 0x002a }
            r0.append(r14)     // Catch:{ Exception -> 0x002a }
            long r12 = r2.getEcCrtvId()     // Catch:{ Exception -> 0x002a }
            r0.append(r12)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r7, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x0223
        L_0x0218:
            long r12 = r2.getEcCrtvId()     // Catch:{ Exception -> 0x002a }
            java.lang.Long r0 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x002a }
            r11.a(r7, r0)     // Catch:{ Exception -> 0x002a }
        L_0x0223:
            long r12 = r2.getEcTemplateId()     // Catch:{ Exception -> 0x002a }
            int r0 = (r12 > r17 ? 1 : (r12 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x025a
            boolean r0 = r11.a((java.lang.String) r6)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x024f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r12 = r11.b(r6)     // Catch:{ Exception -> 0x002a }
            r0.append(r12)     // Catch:{ Exception -> 0x002a }
            r0.append(r14)     // Catch:{ Exception -> 0x002a }
            long r12 = r2.getEcTemplateId()     // Catch:{ Exception -> 0x002a }
            r0.append(r12)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r6, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x025a
        L_0x024f:
            long r12 = r2.getEcTemplateId()     // Catch:{ Exception -> 0x002a }
            java.lang.Long r0 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x002a }
            r11.a(r6, r0)     // Catch:{ Exception -> 0x002a }
        L_0x025a:
            java.lang.String r0 = "bid_tk"
            java.lang.String r12 = r2.getBidToken()     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r12)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r2.getMof_template_url()     // Catch:{ Exception -> 0x002a }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x002a }
            java.lang.String r12 = "2"
            java.lang.String r13 = "1"
            if (r0 != 0) goto L_0x0284
            java.lang.String r0 = r2.getMof_template_url()     // Catch:{ Exception -> 0x002a }
            boolean r0 = com.mbridge.msdk.foundation.tools.ak.i((java.lang.String) r0)     // Catch:{ Exception -> 0x002a }
            java.lang.String r15 = "sdyv"
            if (r0 == 0) goto L_0x0281
            r11.a(r15, r13)     // Catch:{ Exception -> 0x002a }
            goto L_0x0284
        L_0x0281:
            r11.a(r15, r12)     // Catch:{ Exception -> 0x002a }
        L_0x0284:
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r2.getRewardTemplateMode()     // Catch:{ Exception -> 0x002a }
            java.lang.String r15 = ",2"
            r16 = r0
            java.lang.String r0 = ",1"
            if (r16 == 0) goto L_0x02fe
            com.mbridge.msdk.foundation.entity.CampaignEx$c r16 = r2.getRewardTemplateMode()     // Catch:{ Exception -> 0x002a }
            java.lang.String r16 = r16.e()     // Catch:{ Exception -> 0x002a }
            boolean r16 = android.text.TextUtils.isEmpty(r16)     // Catch:{ Exception -> 0x002a }
            if (r16 != 0) goto L_0x02fe
            com.mbridge.msdk.foundation.entity.CampaignEx$c r16 = r2.getRewardTemplateMode()     // Catch:{ Exception -> 0x002a }
            java.lang.String r16 = r16.e()     // Catch:{ Exception -> 0x002a }
            boolean r16 = com.mbridge.msdk.foundation.tools.ak.i((java.lang.String) r16)     // Catch:{ Exception -> 0x002a }
            r17 = r2
            java.lang.String r2 = "vdyv"
            if (r16 == 0) goto L_0x02d9
            boolean r16 = r11.a((java.lang.String) r2)     // Catch:{ Exception -> 0x002a }
            if (r16 == 0) goto L_0x02d1
            r16 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r6.<init>()     // Catch:{ Exception -> 0x002a }
            r18 = r7
            java.lang.Object r7 = r11.b(r2)     // Catch:{ Exception -> 0x002a }
            r6.append(r7)     // Catch:{ Exception -> 0x002a }
            r6.append(r0)     // Catch:{ Exception -> 0x002a }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r2, r6)     // Catch:{ Exception -> 0x002a }
            goto L_0x0304
        L_0x02d1:
            r16 = r6
            r18 = r7
            r11.a(r2, r13)     // Catch:{ Exception -> 0x002a }
            goto L_0x0304
        L_0x02d9:
            r16 = r6
            r18 = r7
            boolean r6 = r11.a((java.lang.String) r2)     // Catch:{ Exception -> 0x002a }
            if (r6 == 0) goto L_0x02fa
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r6.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r7 = r11.b(r2)     // Catch:{ Exception -> 0x002a }
            r6.append(r7)     // Catch:{ Exception -> 0x002a }
            r6.append(r15)     // Catch:{ Exception -> 0x002a }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r2, r6)     // Catch:{ Exception -> 0x002a }
            goto L_0x0304
        L_0x02fa:
            r11.a(r2, r12)     // Catch:{ Exception -> 0x002a }
            goto L_0x0304
        L_0x02fe:
            r17 = r2
            r16 = r6
            r18 = r7
        L_0x0304:
            java.lang.String r2 = r17.getendcard_url()     // Catch:{ Exception -> 0x002a }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x002a }
            if (r2 != 0) goto L_0x035b
            java.lang.String r2 = r17.getendcard_url()     // Catch:{ Exception -> 0x002a }
            boolean r2 = com.mbridge.msdk.foundation.tools.ak.i((java.lang.String) r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r6 = "edyv"
            if (r2 == 0) goto L_0x033b
            boolean r2 = r11.a((java.lang.String) r6)     // Catch:{ Exception -> 0x002a }
            if (r2 == 0) goto L_0x0337
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r2.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r7 = r11.b(r6)     // Catch:{ Exception -> 0x002a }
            r2.append(r7)     // Catch:{ Exception -> 0x002a }
            r2.append(r0)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r6, r2)     // Catch:{ Exception -> 0x002a }
            goto L_0x035b
        L_0x0337:
            r11.a(r6, r13)     // Catch:{ Exception -> 0x002a }
            goto L_0x035b
        L_0x033b:
            boolean r2 = r11.a((java.lang.String) r6)     // Catch:{ Exception -> 0x002a }
            if (r2 == 0) goto L_0x0358
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r2.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r7 = r11.b(r6)     // Catch:{ Exception -> 0x002a }
            r2.append(r7)     // Catch:{ Exception -> 0x002a }
            r2.append(r15)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r6, r2)     // Catch:{ Exception -> 0x002a }
            goto L_0x035b
        L_0x0358:
            r11.a(r6, r12)     // Catch:{ Exception -> 0x002a }
        L_0x035b:
            java.lang.String r2 = r17.getExt_data()     // Catch:{ Exception -> 0x002a }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x002a }
            if (r2 != 0) goto L_0x039d
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x002a }
            java.lang.String r6 = r17.getExt_data()     // Catch:{ Exception -> 0x002a }
            r2.<init>(r6)     // Catch:{ Exception -> 0x002a }
            boolean r6 = r11.a((java.lang.String) r5)     // Catch:{ Exception -> 0x002a }
            if (r6 == 0) goto L_0x0394
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r6.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r7 = r11.b(r5)     // Catch:{ Exception -> 0x002a }
            r6.append(r7)     // Catch:{ Exception -> 0x002a }
            r6.append(r14)     // Catch:{ Exception -> 0x002a }
            java.lang.String r7 = "par_dspid"
            java.lang.String r2 = r2.optString(r7)     // Catch:{ Exception -> 0x002a }
            r6.append(r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r5, r2)     // Catch:{ Exception -> 0x002a }
            goto L_0x039d
        L_0x0394:
            java.lang.String r6 = "par_dspid"
            java.lang.String r2 = r2.optString(r6)     // Catch:{ Exception -> 0x002a }
            r11.a(r5, r2)     // Catch:{ Exception -> 0x002a }
        L_0x039d:
            int r2 = r17.getPlayable_ads_without_video()     // Catch:{ Exception -> 0x002a }
            r6 = 2
            java.lang.String r7 = "only_ec"
            if (r2 != r6) goto L_0x03c7
            boolean r0 = r11.a((java.lang.String) r7)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x03c3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r2 = r11.b(r7)     // Catch:{ Exception -> 0x002a }
            r0.append(r2)     // Catch:{ Exception -> 0x002a }
            r0.append(r15)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r7, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x03e7
        L_0x03c3:
            r11.a(r7, r12)     // Catch:{ Exception -> 0x002a }
            goto L_0x03e7
        L_0x03c7:
            boolean r2 = r11.a((java.lang.String) r7)     // Catch:{ Exception -> 0x002a }
            if (r2 == 0) goto L_0x03e4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r2.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r6 = r11.b(r7)     // Catch:{ Exception -> 0x002a }
            r2.append(r6)     // Catch:{ Exception -> 0x002a }
            r2.append(r0)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r7, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x03e7
        L_0x03e4:
            r11.a(r7, r13)     // Catch:{ Exception -> 0x002a }
        L_0x03e7:
            java.lang.String r0 = "hb"
            boolean r2 = r17.isBidCampaign()     // Catch:{ Exception -> 0x002a }
            if (r2 == 0) goto L_0x03f0
            goto L_0x03f2
        L_0x03f0:
            java.lang.String r13 = "0"
        L_0x03f2:
            r11.a(r0, r13)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = "adspace_t"
            int r2 = r17.getAdSpaceT()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
            boolean r0 = r11.a((java.lang.String) r4)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0426
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r2 = r11.b(r4)     // Catch:{ Exception -> 0x002a }
            r0.append(r2)     // Catch:{ Exception -> 0x002a }
            r0.append(r14)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = r17.getId()     // Catch:{ Exception -> 0x002a }
            r0.append(r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r4, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x042d
        L_0x0426:
            java.lang.String r0 = r17.getId()     // Catch:{ Exception -> 0x002a }
            r11.a(r4, r0)     // Catch:{ Exception -> 0x002a }
        L_0x042d:
            boolean r0 = r11.a((java.lang.String) r3)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0451
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002a }
            r0.<init>()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r2 = r11.b(r3)     // Catch:{ Exception -> 0x002a }
            r0.append(r2)     // Catch:{ Exception -> 0x002a }
            r0.append(r14)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = r17.getRequestIdNotice()     // Catch:{ Exception -> 0x002a }
            r0.append(r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x002a }
            r11.a(r3, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x0458
        L_0x0451:
            java.lang.String r0 = r17.getRequestIdNotice()     // Catch:{ Exception -> 0x002a }
            r11.a(r3, r0)     // Catch:{ Exception -> 0x002a }
        L_0x0458:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.mbridge.msdk.foundation.controller.a.f8822b     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0471
            java.lang.String r2 = r17.getCampaignUnitId()     // Catch:{ Exception -> 0x002a }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x002a }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x002a }
            if (r2 != 0) goto L_0x0471
            java.lang.String r2 = "u_stid"
            r11.a(r2, r0)     // Catch:{ Exception -> 0x002a }
        L_0x0471:
            java.lang.String r0 = r17.getCampaignUnitId()     // Catch:{ Exception -> 0x002a }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x002a }
            if (r0 != 0) goto L_0x0484
            java.lang.String r0 = "unit_id"
            java.lang.String r2 = r17.getCampaignUnitId()     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
        L_0x0484:
            int r0 = r17.getAdType()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0497
            java.lang.String r0 = "adtp"
            int r2 = r17.getAdType()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
        L_0x0497:
            java.lang.String r0 = "hb"
            boolean r2 = r17.isBidCampaign()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = "exp_ids"
            java.lang.String r2 = r17.getExpIds()     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = "2000047"
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x04dc
            int r0 = r17.getTyped()     // Catch:{ Exception -> 0x002a }
            r2 = -1
            if (r0 == r2) goto L_0x04c9
            java.lang.String r0 = "type_d"
            int r2 = r17.getTyped()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
        L_0x04c9:
            java.lang.String r0 = r17.getReasond()     // Catch:{ Exception -> 0x002a }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x002a }
            if (r0 != 0) goto L_0x04dc
            java.lang.String r0 = "reason_d"
            java.lang.String r2 = r17.getReasond()     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
        L_0x04dc:
            java.lang.String r0 = "2000048"
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0518
            int r0 = r17.getTyped()     // Catch:{ Exception -> 0x002a }
            r2 = -1
            if (r0 == r2) goto L_0x04f8
            java.lang.String r0 = "type"
            int r2 = r17.getTyped()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
        L_0x04f8:
            java.lang.String r0 = r17.getReasond()     // Catch:{ Exception -> 0x002a }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x002a }
            if (r0 != 0) goto L_0x050b
            java.lang.String r0 = "reason"
            java.lang.String r2 = r17.getReasond()     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
        L_0x050b:
            java.lang.String r0 = "rtins_type"
            int r2 = r17.getRtinsType()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
        L_0x0518:
            int r0 = r17.getAdType()     // Catch:{ Exception -> 0x002a }
            r2 = 94
            if (r0 == r2) goto L_0x0528
            int r0 = r17.getAdType()     // Catch:{ Exception -> 0x002a }
            r2 = 287(0x11f, float:4.02E-43)
            if (r0 != r2) goto L_0x0651
        L_0x0528:
            java.lang.String[] r0 = com.mbridge.msdk.foundation.same.report.d.b.f9468j     // Catch:{ Exception -> 0x002a }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Exception -> 0x002a }
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "temp_display_type"
            if (r0 == 0) goto L_0x0588
            java.lang.String r0 = "show_index"
            int r6 = r17.getShowIndex()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r6)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = "trigger_show_type"
            int r6 = r17.getShowType()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r6)     // Catch:{ Exception -> 0x002a }
            java.lang.String[] r0 = com.mbridge.msdk.foundation.same.report.d.b.f9470l     // Catch:{ Exception -> 0x002a }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Exception -> 0x002a }
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x056e
            boolean r0 = r17.isTemplateRenderSucc()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0565
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9448e     // Catch:{ Exception -> 0x002a }
            goto L_0x0567
        L_0x0565:
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9449f     // Catch:{ Exception -> 0x002a }
        L_0x0567:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x002a }
            r11.a(r2, r0)     // Catch:{ Exception -> 0x002a }
        L_0x056e:
            java.lang.String r0 = "2000147"
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0588
            boolean r0 = r17.isECTemplateRenderSucc()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x057f
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9448e     // Catch:{ Exception -> 0x002a }
            goto L_0x0581
        L_0x057f:
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9449f     // Catch:{ Exception -> 0x002a }
        L_0x0581:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x002a }
            r11.a(r2, r0)     // Catch:{ Exception -> 0x002a }
        L_0x0588:
            java.lang.String[] r0 = com.mbridge.msdk.foundation.same.report.d.b.f9469k     // Catch:{ Exception -> 0x002a }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Exception -> 0x002a }
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0651
            int r0 = r17.getClickTempSource()     // Catch:{ Exception -> 0x002a }
            r6 = 1
            java.lang.String r7 = "alecfc=1"
            java.lang.String r12 = "full_screen_click"
            if (r0 == r6) goto L_0x05f7
            r6 = 2
            if (r0 == r6) goto L_0x05a4
            goto L_0x062a
        L_0x05a4:
            java.lang.String r0 = r17.getendcard_url()     // Catch:{ Exception -> 0x002a }
            int r6 = r17.getMof_tplid()     // Catch:{ Exception -> 0x002a }
            r13 = 501(0x1f5, float:7.02E-43)
            if (r6 != r13) goto L_0x05c3
            java.lang.String r6 = r17.getMof_template_url()     // Catch:{ Exception -> 0x002a }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x002a }
            if (r6 != 0) goto L_0x05c3
            java.lang.String r0 = r17.getMof_template_url()     // Catch:{ Exception -> 0x002a }
            boolean r0 = r0.contains(r7)     // Catch:{ Exception -> 0x002a }
            goto L_0x05cf
        L_0x05c3:
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x002a }
            if (r6 != 0) goto L_0x05ce
            boolean r0 = r0.contains(r7)     // Catch:{ Exception -> 0x002a }
            goto L_0x05cf
        L_0x05ce:
            r0 = 0
        L_0x05cf:
            if (r0 == 0) goto L_0x05db
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9454k     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x002a }
            r11.a(r12, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x05e4
        L_0x05db:
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9455l     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x002a }
            r11.a(r12, r0)     // Catch:{ Exception -> 0x002a }
        L_0x05e4:
            boolean r0 = r17.isECTemplateRenderSucc()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x05ed
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9448e     // Catch:{ Exception -> 0x002a }
            goto L_0x05ef
        L_0x05ed:
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9449f     // Catch:{ Exception -> 0x002a }
        L_0x05ef:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x002a }
            r11.a(r2, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x062a
        L_0x05f7:
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r17.getRewardTemplateMode()     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = r0.e()     // Catch:{ Exception -> 0x002a }
            boolean r0 = r0.contains(r7)     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x060f
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9454k     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x002a }
            r11.a(r12, r0)     // Catch:{ Exception -> 0x002a }
            goto L_0x0618
        L_0x060f:
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9455l     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x002a }
            r11.a(r12, r0)     // Catch:{ Exception -> 0x002a }
        L_0x0618:
            boolean r0 = r17.isTemplateRenderSucc()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x0621
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9448e     // Catch:{ Exception -> 0x002a }
            goto L_0x0623
        L_0x0621:
            int r0 = com.mbridge.msdk.foundation.same.report.d.a.f9449f     // Catch:{ Exception -> 0x002a }
        L_0x0623:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x002a }
            r11.a(r2, r0)     // Catch:{ Exception -> 0x002a }
        L_0x062a:
            java.lang.String r0 = "click_temp_source"
            int r2 = r17.getClickTempSource()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = "trigger_click_type"
            int r2 = r17.getClickType()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
            java.lang.String r0 = "trigger_click_source"
            int r2 = r17.getTriggerClickSource()     // Catch:{ Exception -> 0x002a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x002a }
            r11.a(r0, r2)     // Catch:{ Exception -> 0x002a }
        L_0x0651:
            r13 = r19
            r0 = r21
            r6 = r16
            r7 = r18
            goto L_0x00d6
        L_0x065b:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L_0x0662
            r0.printStackTrace()
        L_0x0662:
            java.util.Map r0 = r11.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.d.f.b(java.lang.String, com.mbridge.msdk.foundation.same.report.d.c):java.util.Map");
    }

    private Map<String, String> a(String str, c cVar) {
        return (cVar == null || TextUtils.isEmpty(str)) ? new HashMap() : cVar.j(str);
    }

    private e a(String str, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = new e(str);
        try {
            JSONObject jSONObject = new JSONObject(map);
            Boolean b5 = b.a().b();
            if (b5 != null) {
                jSONObject.put("r_v_r", b5.booleanValue() ? 1 : 0);
            }
            eVar.a(jSONObject);
            eVar.a(0);
            eVar.b(0);
            return eVar;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            return eVar;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:(2:41|42)|43|44) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00cc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.String> a(java.lang.String r7, java.lang.String r8, com.mbridge.msdk.tracker.m r9) {
        /*
            r6 = this;
            java.lang.String r0 = "r_stid"
            com.mbridge.msdk.foundation.same.report.d.e r1 = new com.mbridge.msdk.foundation.same.report.d.e
            r1.<init>()
            com.mbridge.msdk.c.h r2 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x0021 }
            com.mbridge.msdk.foundation.controller.c r3 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0021 }
            java.lang.String r3 = r3.k()     // Catch:{ Exception -> 0x0021 }
            com.mbridge.msdk.c.g r2 = r2.b(r3)     // Catch:{ Exception -> 0x0021 }
            if (r2 != 0) goto L_0x0024
            com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x0021 }
            com.mbridge.msdk.c.g r2 = com.mbridge.msdk.c.i.a()     // Catch:{ Exception -> 0x0021 }
            goto L_0x0024
        L_0x0021:
            r7 = move-exception
            goto L_0x00d0
        L_0x0024:
            java.lang.String r3 = r2.an()     // Catch:{ Exception -> 0x0021 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0021 }
            if (r3 != 0) goto L_0x0037
            java.lang.String r3 = "as_rid"
            java.lang.String r4 = r2.an()     // Catch:{ Exception -> 0x0021 }
            r1.a(r3, r4)     // Catch:{ Exception -> 0x0021 }
        L_0x0037:
            java.lang.String r3 = r2.P()     // Catch:{ Exception -> 0x0021 }
            org.json.JSONArray r2 = r2.O()     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0058
            r4 = 0
        L_0x0042:
            int r5 = r2.length()     // Catch:{ Exception -> 0x0021 }
            if (r4 >= r5) goto L_0x0058
            java.lang.String r5 = r2.getString(r4)     // Catch:{ Exception -> 0x0021 }
            boolean r5 = r7.equals(r5)     // Catch:{ Exception -> 0x0021 }
            if (r5 == 0) goto L_0x0055
            java.lang.String r3 = "1.0"
            goto L_0x0058
        L_0x0055:
            int r4 = r4 + 1
            goto L_0x0042
        L_0x0058:
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r2 = "log_rate"
            if (r7 != 0) goto L_0x0064
            r1.a(r2, r3)     // Catch:{ Exception -> 0x0021 }
            goto L_0x006c
        L_0x0064:
            r7 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0021 }
            r1.a(r2, r7)     // Catch:{ Exception -> 0x0021 }
        L_0x006c:
            boolean r7 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0021 }
            if (r7 != 0) goto L_0x00d7
            com.mbridge.msdk.c.h r7 = com.mbridge.msdk.c.h.a()     // Catch:{ Exception -> 0x0021 }
            com.mbridge.msdk.foundation.controller.c r2 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0021 }
            java.lang.String r2 = r2.k()     // Catch:{ Exception -> 0x0021 }
            com.mbridge.msdk.c.k r7 = r7.c(r2, r8)     // Catch:{ Exception -> 0x0021 }
            if (r7 == 0) goto L_0x0097
            java.lang.String r2 = r7.s()     // Catch:{ Exception -> 0x0021 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0021 }
            if (r2 != 0) goto L_0x0097
            java.lang.String r2 = "us_rid"
            java.lang.String r3 = r7.s()     // Catch:{ Exception -> 0x0021 }
            r1.a(r2, r3)     // Catch:{ Exception -> 0x0021 }
        L_0x0097:
            if (r7 == 0) goto L_0x00ac
            java.lang.String r2 = r7.a()     // Catch:{ Exception -> 0x0021 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0021 }
            if (r2 != 0) goto L_0x00ac
            java.lang.String r2 = "u_stid"
            java.lang.String r7 = r7.a()     // Catch:{ Exception -> 0x0021 }
            r1.a(r2, r7)     // Catch:{ Exception -> 0x0021 }
        L_0x00ac:
            com.mbridge.msdk.foundation.same.report.d.d r7 = com.mbridge.msdk.foundation.same.report.d.d.a()     // Catch:{ Exception -> 0x0021 }
            com.mbridge.msdk.foundation.same.report.d.e r7 = r7.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0021 }
            if (r7 == 0) goto L_0x00d7
            if (r9 == 0) goto L_0x00cc
            org.json.JSONObject r8 = r9.g()     // Catch:{ Exception -> 0x0021 }
            if (r8 == 0) goto L_0x00cc
            org.json.JSONObject r8 = r9.g()     // Catch:{ JSONException -> 0x00cc }
            java.lang.Object r9 = r7.b(r0)     // Catch:{ JSONException -> 0x00cc }
            r8.put(r0, r9)     // Catch:{ JSONException -> 0x00cc }
            r7.c(r0)     // Catch:{ JSONException -> 0x00cc }
        L_0x00cc:
            r1.a((com.mbridge.msdk.foundation.same.report.d.e) r7)     // Catch:{ Exception -> 0x0021 }
            goto L_0x00d7
        L_0x00d0:
            boolean r8 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r8 == 0) goto L_0x00d7
            r7.printStackTrace()
        L_0x00d7:
            java.util.Map r7 = r1.a()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.d.f.a(java.lang.String, java.lang.String, com.mbridge.msdk.tracker.m):java.util.Map");
    }

    private List<CampaignEx> a(c cVar, String str) {
        ArrayList arrayList = new ArrayList();
        if (cVar != null) {
            try {
                String str2 = cVar.f() + str;
                Map<String, Map<String, String>> p5 = cVar.p();
                int i5 = -1;
                if (p5 != null && p5.containsKey(str2)) {
                    try {
                        Object obj = p5.get(str2).get("resource_type");
                        if (obj instanceof String) {
                            i5 = Integer.parseInt((String) obj);
                        } else if (obj instanceof Integer) {
                            i5 = ((Integer) obj).intValue();
                        }
                    } catch (NumberFormatException e5) {
                        if (MBridgeConstans.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                }
                if (i5 == 1) {
                    List<CampaignEx> h5 = cVar.h() != null ? cVar.h() : cVar.e();
                    if (h5 != null && h5.size() > 0) {
                        arrayList.addAll(h5);
                    }
                } else if (cVar.g() != null) {
                    arrayList.add(cVar.g());
                } else {
                    List<CampaignEx> h6 = cVar.h() != null ? cVar.h() : cVar.e();
                    if (h6 != null && h6.size() > 0) {
                        arrayList.addAll(h6);
                    }
                }
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    e6.printStackTrace();
                }
            }
        }
        return arrayList;
    }
}
