package com.mbridge.msdk.foundation.same.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.c;
import com.mbridge.msdk.foundation.entity.d;
import com.mbridge.msdk.foundation.same.d.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ap;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, List<a>> f9211a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, List<a>> f9212b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, List<a>> f9213c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, c>> f9214d = null;

    /* renamed from: e  reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> f9215e = null;

    /* renamed from: f  reason: collision with root package name */
    public static ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f9216f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Map<String, List<a>> f9217g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, List<a>> f9218h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, List<a>> f9219i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public static Map<String, List<a>> f9220j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    public static Map<String, Long> f9221k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    public static Map<String, List<a>> f9222l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    public static Map<String, List<a>> f9223m = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    private static final String f9224n = "b";

    public static void a(String str, String str2, String str3, long j5, long j6, long j7) {
        if (f9214d == null) {
            f9214d = new ConcurrentHashMap<>();
        }
        try {
            if (f9214d.containsKey(str)) {
                Map map = f9214d.get(str);
                if (map != null) {
                    c cVar = (c) map.get(str2);
                    if (cVar == null) {
                        c cVar2 = new c();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str3);
                        cVar2.a((List<String>) arrayList);
                        cVar2.a(j5);
                        cVar2.b(j6);
                        cVar2.c(j7);
                        map.put(str2, cVar2);
                    } else if (cVar.c() != null) {
                        cVar.a(j5);
                        cVar.b(j6);
                        cVar.c(j7);
                        cVar.c().add(str3);
                    }
                }
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str3);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                c cVar3 = new c();
                cVar3.a((List<String>) arrayList2);
                cVar3.a(j5);
                cVar3.b(j6);
                cVar3.c(j7);
                concurrentHashMap.put(str2, cVar3);
                f9214d.put(str, concurrentHashMap);
            }
        } catch (Throwable th) {
            af.b(f9224n, th.getMessage());
        }
    }

    public static String b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = f9216f) != null && concurrentHashMap.containsKey(str) && (copyOnWriteArrayList = f9216f.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            return (String) copyOnWriteArrayList.get(0);
        }
        return "";
    }

    public static void c(String str, String str2) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, c>> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f9214d) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            f9214d.remove(str);
            return;
        }
        Map map = f9214d.get(str);
        if (map != null && map.containsKey(str2)) {
            map.remove(str2);
        }
    }

    private static Map<String, List<a>> d(String str) {
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1396342996:
                if (str.equals("banner")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1052618729:
                if (str.equals("native")) {
                    c5 = 1;
                    break;
                }
                break;
            case -934326481:
                if (str.equals("reward")) {
                    c5 = 2;
                    break;
                }
                break;
            case -895866265:
                if (str.equals("splash")) {
                    c5 = 3;
                    break;
                }
                break;
            case 538816457:
                if (str.equals("h5_native")) {
                    c5 = 4;
                    break;
                }
                break;
            case 604727084:
                if (str.equals("interstitial")) {
                    c5 = 5;
                    break;
                }
                break;
            case 1844104930:
                if (str.equals("interactive")) {
                    c5 = 6;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return f9212b;
            case 1:
                return f9219i;
            case 2:
                return f9220j;
            case 3:
                return f9222l;
            case 4:
                return f9213c;
            case 5:
                return f9218h;
            case 6:
                return f9217g;
            default:
                return null;
        }
    }

    public static d b(String str, String str2) {
        ConcurrentHashMap concurrentHashMap;
        d dVar = new d();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f9215e;
                if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = f9215e.get(str)) != null && concurrentHashMap.containsKey(str2)) {
                    dVar.a(1);
                    dVar.c((String) concurrentHashMap.get(str2));
                    return dVar;
                }
            } catch (Exception e5) {
                af.a(f9224n, e5.getMessage());
                return dVar;
            }
        }
        return dVar;
    }

    public static void c(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = f9216f) != null && concurrentHashMap.containsKey(str) && (copyOnWriteArrayList = f9216f.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            copyOnWriteArrayList.remove(0);
        }
    }

    public static void d(String str, String str2) {
        ConcurrentHashMap concurrentHashMap;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f9215e;
                if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = f9215e.get(str2)) != null && concurrentHashMap.containsKey(str2)) {
                    concurrentHashMap.remove(str2);
                }
            } catch (Exception e5) {
                af.a(f9224n, e5.getMessage());
            }
        }
    }

    public static void a(String str, String str2, int i5) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (f9216f == null) {
                f9216f = new ConcurrentHashMap<>();
            }
            try {
                if (f9216f.containsKey(str)) {
                    copyOnWriteArrayList = f9216f.get(str);
                    copyOnWriteArrayList.add(str2);
                } else {
                    CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                    copyOnWriteArrayList2.add(str2);
                    f9216f.put(str, copyOnWriteArrayList2);
                    copyOnWriteArrayList = copyOnWriteArrayList2;
                }
                int size = copyOnWriteArrayList.size() - i5;
                if (size >= 0) {
                    for (int i6 = 0; i6 < size; i6++) {
                        copyOnWriteArrayList.remove(i6);
                    }
                }
            } catch (Exception e5) {
                af.a(f9224n, e5.getMessage());
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if (f9215e == null) {
                    f9215e = new ConcurrentHashMap<>();
                }
                if (!f9215e.containsKey(str)) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(str2, str3);
                    f9215e.put(str, concurrentHashMap);
                } else if (f9215e.get(str) == null) {
                    ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                    concurrentHashMap2.put(str2, str3);
                    f9215e.put(str, concurrentHashMap2);
                }
            } catch (Exception e5) {
                af.a(f9224n, e5.getMessage());
            }
        }
    }

    public static String a(String str, String str2) {
        Map<String, List<a>> map;
        List list;
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            map = d(str2);
        } else if (f9219i.containsKey(str)) {
            map = f9219i;
        } else if (f9220j.containsKey(str)) {
            map = f9220j;
        } else if (f9217g.containsKey(str)) {
            map = f9217g;
        } else if (f9223m.containsKey(str)) {
            map = f9223m;
        } else if (f9218h.containsKey(str)) {
            map = f9218h;
        } else if (f9212b.containsKey(str)) {
            map = f9212b;
        } else if (f9222l.containsKey(str)) {
            map = f9222l;
        } else {
            map = f9213c.containsKey(str) ? f9213c : null;
        }
        if (map != null) {
            try {
                if (ap.b(str) && map.containsKey(str) && (list = map.get(str)) != null && list.size() > 0) {
                    for (int i5 = 0; i5 < list.size(); i5++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("2", ((a) list.get(i5)).a());
                        jSONObject.put("1", ((a) list.get(i5)).c());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public static ConcurrentHashMap<String, c> a(String str) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, c>> concurrentHashMap = f9214d;
        if (concurrentHashMap == null) {
            e a5 = e.a((f) g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            if (a5 != null) {
                a5.d(str, "");
                f9214d = new ConcurrentHashMap<>();
                return null;
            }
        } else if (concurrentHashMap.containsKey(str)) {
            return f9214d.get(str);
        }
        return null;
    }

    public static void a(String str, CampaignEx campaignEx, String str2) {
        Map<String, List<a>> d5 = d(str2);
        if (campaignEx != null && d5 != null) {
            try {
                if (!TextUtils.isEmpty(campaignEx.getId())) {
                    a aVar = new a(campaignEx.getId(), campaignEx.getRequestIdNotice());
                    if (d5.containsKey(str)) {
                        List list = d5.get(str);
                        if (list != null && list.size() == 20) {
                            list.remove(0);
                        }
                        if (list != null) {
                            list.add(aVar);
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(aVar);
                    d5.put(str, arrayList);
                }
            } catch (Throwable th) {
                af.b(f9224n, th.getMessage(), th);
            }
        }
    }
}
