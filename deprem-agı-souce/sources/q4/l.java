package q4;

import H2.d;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import java.util.ArrayList;
import kotlin.jvm.internal.t;
import m4.a;
import m4.e;
import m4.k;
import m4.p;
import m4.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l implements i {

    /* renamed from: a  reason: collision with root package name */
    public final c f25710a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f25711b;

    public l(c cVar) {
        t.e(cVar, "coreUiLabelsResolver");
        this.f25710a = cVar;
    }

    public static ArrayList b(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("customFooterLinks");
            int length = jSONArray.length();
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 + 1;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                t.d(jSONObject2, "publisherLinkJsonArray.g…                        )");
                t.e(jSONObject2, "jsonObject");
                String optString = jSONObject2.optString("label");
                t.d(optString, "jsonObject.optString(\"label\")");
                String optString2 = jSONObject2.optString("link");
                t.d(optString2, "jsonObject.optString(\"link\")");
                arrayList.add(new q(optString, optString2));
                i5 = i6;
            }
            return arrayList;
        } catch (Exception unused) {
            d.b("ChoiceCMP", "COP publisher link is null");
            return arrayList;
        }
    }

    public final Object a(String str) {
        t.e(str, "jsonString");
        try {
            this.f25711b = new JSONObject(str);
            this.f25710a.getClass();
            return new m4.t(c.b(str), f(), e(), d(), c());
        } catch (JSONException unused) {
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
            }
            return new m4.t();
        }
    }

    public final a c() {
        try {
            JSONObject jSONObject = this.f25711b;
            if (jSONObject == null) {
                t.w("json");
                jSONObject = null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("advanced");
            String optString = jSONObject2.optString("initScreenSettingsButton");
            t.d(optString, "advancedUILabels.optStri…nitScreenSettingsButton\")");
            String optString2 = jSONObject2.optString("initScreenRejectButton");
            t.d(optString2, "advancedUILabels.optStri…\"initScreenRejectButton\")");
            String optString3 = jSONObject2.optString("privacyBody");
            t.d(optString3, "advancedUILabels.optString(\"privacyBody\")");
            String optString4 = jSONObject2.optString("privacyHeader");
            t.d(optString4, "advancedUILabels.optString(\"privacyHeader\")");
            t.d(jSONObject2, "advancedUILabels");
            return new a(optString, optString2, optString3, optString4, b(jSONObject2));
        } catch (JSONException unused) {
            d.b("ChoiceCMP", "Error in parsing AdvancedUILabels");
            return new a();
        }
    }

    public final e d() {
        try {
            JSONObject jSONObject = this.f25711b;
            if (jSONObject == null) {
                t.w("json");
                jSONObject = null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("consentOrPay");
            String optString = jSONObject2.optString("initScreenSettingsButton");
            t.d(optString, "consentOrPayUILabels.opt…Button\"\n                )");
            String optString2 = jSONObject2.optString("action1");
            t.d(optString2, "consentOrPayUILabels.optString(\"action1\")");
            String optString3 = jSONObject2.optString("action2");
            t.d(optString3, "consentOrPayUILabels.optString(\"action2\")");
            String optString4 = jSONObject2.optString("privacyBody");
            t.d(optString4, "consentOrPayUILabels.optString(\"privacyBody\")");
            String optString5 = jSONObject2.optString("privacyHeader");
            t.d(optString5, "consentOrPayUILabels.optString(\"privacyHeader\")");
            t.d(jSONObject2, "consentOrPayUILabels");
            return new e(optString, optString2, optString3, optString4, optString5, b(jSONObject2));
        } catch (JSONException e5) {
            d.c("ChoiceCMP", "Error in parsing ConsentOrPayUILabels", e5, (Boolean) null, 8);
            return new e();
        }
    }

    public final k e() {
        JSONObject jSONObject = this.f25711b;
        if (jSONObject == null) {
            t.w("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("mobileUiLabels");
        String optString = jSONObject2.optString("doneLabel");
        String optString2 = jSONObject2.optString("searchLabel");
        String optString3 = jSONObject2.optString("cancelLabel");
        String optString4 = jSONObject2.optString("consentLabel");
        String optString5 = jSONObject2.optString("flexPurposesLabel");
        String optString6 = jSONObject2.optString("cookieAccessBodyText");
        String optString7 = jSONObject2.optString("showVendorsLabel");
        String optString8 = jSONObject2.optString("showIabLabel");
        String optString9 = jSONObject2.optString("noneLabel");
        String optString10 = jSONObject2.optString("someLabel");
        String optString11 = jSONObject2.optString("allLabel");
        String optString12 = jSONObject2.optString("closeLabel");
        String optString13 = jSONObject2.optString("allVendorsLabel");
        t.d(jSONObject2, "mobileUiLabels");
        ArrayList b5 = h.b(jSONObject2, "summaryScreenBodyRejectService");
        ArrayList b6 = h.b(jSONObject2, "summaryScreenBodyTextReject");
        ArrayList b7 = h.b(jSONObject2, "summaryScreenBodyTextRejectNew");
        t.d(optString, "optString(\"doneLabel\")");
        t.d(optString2, "optString(\"searchLabel\")");
        t.d(optString3, "optString(\"cancelLabel\")");
        t.d(optString7, "optString(\"showVendorsLabel\")");
        t.d(optString8, "optString(\"showIabLabel\")");
        t.d(optString4, "optString(\"consentLabel\")");
        t.d(optString5, "optString(\"flexPurposesLabel\")");
        t.d(optString6, "optString(\"cookieAccessBodyText\")");
        t.d(optString9, "optString(\"noneLabel\")");
        t.d(optString10, "optString(\"someLabel\")");
        t.d(optString11, "optString(\"allLabel\")");
        t.d(optString12, "optString(\"closeLabel\")");
        t.d(optString13, "optString(\"allVendorsLabel\")");
        return new k(optString, optString2, optString3, optString7, optString8, optString4, optString5, optString6, optString9, optString10, optString11, optString12, optString13, b5, b6, b7);
    }

    public final p f() {
        JSONObject jSONObject = this.f25711b;
        if (jSONObject == null) {
            t.w("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("premiumUiLabels");
        String optString = jSONObject2.optString("linksTitle");
        t.d(optString, "premiumUiLabels.optString(\"linksTitle\")");
        String optString2 = jSONObject2.optString("nonIabVendorsLabel");
        t.d(optString2, "premiumUiLabels.optString(\"nonIabVendorsLabel\")");
        String optString3 = jSONObject2.optString("uspDnsTitle");
        t.d(optString3, "premiumUiLabels.optString(\"uspDnsTitle\")");
        t.d(jSONObject2, "premiumUiLabels");
        ArrayList b5 = h.b(jSONObject2, "uspDnsText");
        String optString4 = jSONObject2.optString("uspDoNotSellToggleText");
        t.d(optString4, "premiumUiLabels.optStrin…\"uspDoNotSellToggleText\")");
        String optString5 = jSONObject2.optString("uspPrivacyPolicyLinkText");
        t.d(optString5, "premiumUiLabels.optStrin…spPrivacyPolicyLinkText\")");
        String optString6 = jSONObject2.optString("uspDeleteDataLinkText");
        t.d(optString6, "premiumUiLabels.optString(\"uspDeleteDataLinkText\")");
        String optString7 = jSONObject2.optString("uspAccessDataLinkText");
        t.d(optString7, "premiumUiLabels.optString(\"uspAccessDataLinkText\")");
        String optString8 = jSONObject2.optString("uspAcceptButton");
        t.d(optString8, "premiumUiLabels.optString(\"uspAcceptButton\")");
        return new p(optString, optString2, optString3, b5, optString4, optString5, optString6, optString7, optString8, (ArrayList) null, 512);
    }
}
