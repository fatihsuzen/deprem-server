package v4;

import O2.j;
import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.t;

public abstract class k {
    public static p b(String str, String str2, String str3, String str4, String str5, int i5, c.k kVar, boolean z4, j jVar) {
        t.e(str, CampaignEx.JSON_KEY_TITLE);
        t.e(str2, "description");
        t.e(str3, "legalDescription");
        t.e(str4, "legalDescriptionLabel");
        t.e(str5, "closeLabel");
        t.e(kVar, "switchItemType");
        t.e(jVar, "vendorTypeSelected");
        p pVar = new p();
        Bundle bundle = new Bundle();
        bundle.putString(CampaignEx.JSON_KEY_TITLE, str);
        bundle.putString("description", str2);
        bundle.putString("legal_description", str3);
        bundle.putString("legal_description_label", str4);
        bundle.putString("close_button_label", str5);
        bundle.putBoolean("legitimate_interest", z4);
        bundle.putString("vendor_type_selected", jVar.name());
        p.f26091z = i5;
        p.f26089A = kVar;
        pVar.setArguments(bundle);
        return pVar;
    }
}
