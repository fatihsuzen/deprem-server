package q4;

import P3.a;
import P3.b;
import P3.c;
import P3.d;
import P3.g;
import P3.h;
import P3.i;
import P3.j;
import P3.k;
import X2.C2250q;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m implements i {

    /* renamed from: a  reason: collision with root package name */
    public final Locale f25712a;

    public m(Locale locale) {
        t.e(locale, "appLocale");
        this.f25712a = locale;
    }

    public static LinkedHashMap b(JSONObject jSONObject, int i5) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        t.d(keys, "features.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                t.d(next, "key");
                int optInt = optJSONObject.optInt("id");
                String optString = optJSONObject.optString(RewardPlus.NAME);
                t.d(optString, "feature.optString(\"name\")");
                String optString2 = optJSONObject.optString("description");
                t.d(optString2, "feature.optString(\"description\")");
                linkedHashMap.put(next, new c(optInt, optString, optString2, c(optJSONObject, i5)));
            }
        }
        return linkedHashMap;
    }

    public static String c(JSONObject jSONObject, int i5) {
        String str;
        if (i5 > 2) {
            JSONArray optJSONArray = jSONObject.optJSONArray("illustrations");
            if (optJSONArray == null) {
                str = null;
            } else {
                StringBuilder sb = new StringBuilder();
                int length = optJSONArray.length();
                int i6 = 0;
                while (i6 < length) {
                    int i7 = i6 + 1;
                    Q q5 = Q.f24695a;
                    String format = String.format("* %s", Arrays.copyOf(new Object[]{optJSONArray.getString(i6)}, 1));
                    t.d(format, "format(format, *args)");
                    sb.append(format);
                    t.d(sb, "append(value)");
                    sb.append(10);
                    t.d(sb, "append('\\n')");
                    i6 = i7;
                }
                str = sb.toString();
                t.d(str, "str.toString()");
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        String optString = jSONObject.optString("descriptionLegal");
        t.d(optString, "{\n            feature.op…criptionLegal\")\n        }");
        return optString;
    }

    public static LinkedHashMap d(JSONObject jSONObject, int i5) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        t.d(keys, "purposes.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                t.d(next, "key");
                int optInt = optJSONObject.optInt("id");
                String optString = optJSONObject.optString(RewardPlus.NAME);
                t.d(optString, "purpose.optString(\"name\")");
                String optString2 = optJSONObject.optString("description");
                t.d(optString2, "purpose.optString(\"description\")");
                linkedHashMap.put(next, new h(optInt, optString, optString2, c(optJSONObject, i5)));
            }
        }
        return linkedHashMap;
    }

    public final Object a(String str) {
        t.e(str, "jsonString");
        try {
            return a(new JSONObject(str));
        } catch (JSONException unused) {
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
            }
            return new d();
        }
    }

    public final d a(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        g gVar;
        int i5;
        String str4;
        String str5;
        String str6;
        b bVar;
        boolean z4;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        JSONObject jSONObject2 = jSONObject;
        d dVar = new d();
        dVar.f18869a = jSONObject2.optInt("gvlSpecificationVersion");
        dVar.f18870b = Integer.valueOf(jSONObject2.optInt("vendorListVersion"));
        dVar.f18871c = Integer.valueOf(jSONObject2.optInt("tcfPolicyVersion"));
        String optString = jSONObject2.optString("lastUpdated");
        t.d(optString, "vendorListJson.optString(\"lastUpdated\")");
        Locale locale = this.f25712a;
        t.e(optString, "dateString");
        t.e("yyyy-MM-dd'T'HH:mm:ss", "format");
        t.e(locale, "locale");
        Date parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", locale).parse(optString);
        if (parse != null) {
            parse.getTime();
        }
        String str7 = "purposes";
        JSONObject jSONObject3 = jSONObject2.getJSONObject(str7);
        t.d(jSONObject3, "vendorListJson.getJSONObject(\"purposes\")");
        LinkedHashMap d5 = d(jSONObject3, dVar.f18869a);
        t.e(d5, "<set-?>");
        dVar.f18872d = d5;
        String str8 = "specialPurposes";
        JSONObject jSONObject4 = jSONObject2.getJSONObject(str8);
        t.d(jSONObject4, "vendorListJson.getJSONObject(\"specialPurposes\")");
        LinkedHashMap d6 = d(jSONObject4, dVar.f18869a);
        t.e(d6, "<set-?>");
        dVar.f18873e = d6;
        String str9 = "features";
        JSONObject jSONObject5 = jSONObject2.getJSONObject(str9);
        t.d(jSONObject5, "vendorListJson.getJSONObject(\"features\")");
        LinkedHashMap b5 = b(jSONObject5, dVar.f18869a);
        t.e(b5, "<set-?>");
        dVar.f18874f = b5;
        String str10 = "specialFeatures";
        JSONObject jSONObject6 = jSONObject2.getJSONObject(str10);
        t.d(jSONObject6, "vendorListJson.getJSONObject(\"specialFeatures\")");
        LinkedHashMap b6 = b(jSONObject6, dVar.f18869a);
        t.e(b6, "<set-?>");
        dVar.f18875g = b6;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        JSONObject jSONObject7 = jSONObject2.getJSONObject("stacks");
        Iterator<String> keys = jSONObject7.keys();
        t.d(keys, "stacks.keys()");
        while (true) {
            boolean hasNext = keys.hasNext();
            str = RewardPlus.NAME;
            if (!hasNext) {
                break;
            }
            String next = keys.next();
            JSONObject jSONObject8 = jSONObject7.getJSONObject(next);
            t.d(next, "key");
            int optInt = jSONObject8.optInt("id");
            String optString2 = jSONObject8.optString(str);
            t.d(optString2, "stack.optString(\"name\")");
            String optString3 = jSONObject8.optString("description");
            t.d(optString3, "stack.optString(\"description\")");
            t.d(jSONObject8, "stack");
            linkedHashMap3.put(next, new i(optInt, optString2, optString3, C2250q.p0(h.a(jSONObject8, str7)), C2250q.p0(h.a(jSONObject8, str10))));
        }
        t.e(linkedHashMap3, "<set-?>");
        dVar.f18878j = linkedHashMap3;
        JSONObject optJSONObject = jSONObject2.optJSONObject("dataCategories");
        if (optJSONObject == null) {
            str2 = str9;
            str3 = str10;
        } else {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            Iterator<String> keys2 = optJSONObject.keys();
            t.d(keys2, "dataCategories.keys()");
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                JSONObject jSONObject9 = optJSONObject.getJSONObject(next2);
                t.d(next2, "key");
                Iterator<String> it = keys2;
                int optInt2 = jSONObject9.optInt("id");
                String str11 = str10;
                String optString4 = jSONObject9.optString(str);
                String str12 = str9;
                t.d(optString4, "dataCategory.optString(\"name\")");
                String optString5 = jSONObject9.optString("description");
                t.d(optString5, "dataCategory.optString(\n…on\"\n                    )");
                linkedHashMap4.put(next2, new a(optString4, optInt2, optString5));
                optJSONObject = optJSONObject;
                keys2 = it;
                str10 = str11;
                str9 = str12;
            }
            str2 = str9;
            str3 = str10;
            t.e(linkedHashMap4, "<set-?>");
            dVar.f18879k = linkedHashMap4;
        }
        int i6 = dVar.f18869a;
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("vendors");
        if (optJSONObject2 != null) {
            Iterator<String> keys3 = optJSONObject2.keys();
            t.d(keys3, "vendors.keys()");
            while (keys3.hasNext()) {
                String next3 = keys3.next();
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next3);
                if (optJSONObject3 != null) {
                    t.d(next3, "key");
                    int optInt3 = optJSONObject3.optInt("id");
                    String optString6 = optJSONObject3.optString(str);
                    Set q02 = C2250q.q0(h.a(optJSONObject3, str7));
                    Set q03 = C2250q.q0(h.a(optJSONObject3, "legIntPurposes"));
                    Set q04 = C2250q.q0(h.a(optJSONObject3, "flexiblePurposes"));
                    Set q05 = C2250q.q0(h.a(optJSONObject3, str8));
                    Set q06 = C2250q.q0(h.a(optJSONObject3, str2));
                    String str13 = str3;
                    Set q07 = C2250q.q0(h.a(optJSONObject3, str13));
                    JSONObject jSONObject10 = optJSONObject2;
                    Iterator<String> it2 = keys3;
                    String optString7 = optJSONObject3.optString("policyUrl", "");
                    String optString8 = optJSONObject3.optString("deletedDate", "");
                    t.d(optString8, "");
                    LinkedHashSet linkedHashSet = null;
                    String str14 = optString8.length() == 0 ? null : optString8;
                    if (i6 > 2) {
                        optJSONObject3.optInt("overflow");
                        i5 = i6;
                        gVar = new g();
                    } else {
                        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("overflow");
                        if (optJSONObject4 == null) {
                            i5 = i6;
                            gVar = null;
                        } else {
                            i5 = i6;
                            optJSONObject4.optInt("httpGetLimit");
                            gVar = new g();
                        }
                    }
                    int optInt4 = optJSONObject3.optInt("cookieMaxAgeSeconds");
                    boolean optBoolean = optJSONObject3.optBoolean("useCookies", false);
                    boolean optBoolean2 = optJSONObject3.optBoolean("cookieRefresh", false);
                    boolean optBoolean3 = optJSONObject3.optBoolean("usesNonCookieAccess", false);
                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("dataRetention");
                    if (optJSONObject5 == null) {
                        str6 = str7;
                        z4 = optBoolean3;
                        str5 = str13;
                        str4 = str;
                        bVar = null;
                    } else {
                        int optInt5 = optJSONObject5.optInt("stdRetention");
                        z4 = optBoolean3;
                        JSONObject optJSONObject6 = optJSONObject5.optJSONObject(str7);
                        str6 = str7;
                        if (optJSONObject6 == null) {
                            str5 = str13;
                            str4 = str;
                            linkedHashMap = null;
                        } else {
                            str5 = str13;
                            linkedHashMap = new LinkedHashMap();
                            str4 = str;
                            Iterator<String> keys4 = optJSONObject6.keys();
                            t.d(keys4, "purposes.keys()");
                            while (keys4.hasNext()) {
                                Iterator<String> it3 = keys4;
                                String next4 = keys4.next();
                                t.d(next4, "key");
                                linkedHashMap.put(next4, Integer.valueOf(optJSONObject6.optInt(next4)));
                                keys4 = it3;
                                optJSONObject6 = optJSONObject6;
                            }
                        }
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap();
                        }
                        JSONObject optJSONObject7 = optJSONObject5.optJSONObject(str8);
                        if (optJSONObject7 == null) {
                            linkedHashMap2 = null;
                        } else {
                            linkedHashMap2 = new LinkedHashMap();
                            Iterator<String> keys5 = optJSONObject7.keys();
                            t.d(keys5, "purposes.keys()");
                            while (keys5.hasNext()) {
                                String next5 = keys5.next();
                                t.d(next5, "key");
                                linkedHashMap2.put(next5, Integer.valueOf(optJSONObject7.optInt(next5)));
                                optJSONObject7 = optJSONObject7;
                            }
                        }
                        if (linkedHashMap2 == null) {
                            linkedHashMap2 = new LinkedHashMap();
                        }
                        bVar = new b(optInt5, linkedHashMap, linkedHashMap2);
                    }
                    JSONArray optJSONArray = optJSONObject3.optJSONArray("urls");
                    if (optJSONArray != null) {
                        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                        int length = optJSONArray.length();
                        int i7 = 0;
                        while (i7 < length) {
                            int i8 = i7 + 1;
                            JSONObject jSONObject11 = optJSONArray.getJSONObject(i7);
                            JSONArray jSONArray = optJSONArray;
                            String optString9 = jSONObject11.optString("langId");
                            String str15 = str8;
                            t.d(optString9, "url.optString(\"langId\")");
                            String optString10 = jSONObject11.optString("privacy");
                            int i9 = length;
                            t.d(optString10, "url.optString(\"privacy\")");
                            String optString11 = jSONObject11.optString("legIntClaim");
                            t.d(optString11, "url.optString(\"legIntClaim\")");
                            linkedHashSet2.add(new j(optString9, optString10, optString11));
                            i7 = i8;
                            optJSONArray = jSONArray;
                            length = i9;
                            str8 = str15;
                        }
                        linkedHashSet = linkedHashSet2;
                    }
                    String str16 = str8;
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                    }
                    Set q08 = C2250q.q0(h.a(optJSONObject3, "dataDeclaration"));
                    String optString12 = optJSONObject3.optString("deviceStorageDisclosureUrl");
                    t.d(optString6, "optString(\"name\")");
                    t.d(optString7, "optString(\n             …                        )");
                    Boolean valueOf = Boolean.valueOf(z4);
                    t.d(optString12, "optString(\n             …                        )");
                    linkedHashMap5.put(next3, new k(optInt3, optString6, (String) null, q02, q03, q04, q05, q06, q07, optString7, str14, gVar, optInt4, optBoolean, optBoolean2, valueOf, q08, bVar, linkedHashSet, optString12, 4));
                    optJSONObject2 = jSONObject10;
                    keys3 = it2;
                    i6 = i5;
                    str7 = str6;
                    str3 = str5;
                    str = str4;
                    str8 = str16;
                }
            }
        }
        t.e(linkedHashMap5, "<set-?>");
        dVar.f18877i = linkedHashMap5;
        return dVar;
    }
}
