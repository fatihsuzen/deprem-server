package m4;

import J2.v;
import kotlin.jvm.internal.t;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final String f25432a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25433b;

    /* renamed from: c  reason: collision with root package name */
    public final String f25434c;

    /* renamed from: d  reason: collision with root package name */
    public final String f25435d;

    /* renamed from: e  reason: collision with root package name */
    public final String f25436e;

    /* renamed from: f  reason: collision with root package name */
    public final String f25437f;

    /* renamed from: g  reason: collision with root package name */
    public final String f25438g;

    /* renamed from: h  reason: collision with root package name */
    public final String f25439h;

    /* renamed from: i  reason: collision with root package name */
    public final String f25440i;

    /* renamed from: j  reason: collision with root package name */
    public final String f25441j;

    /* renamed from: k  reason: collision with root package name */
    public final String f25442k;

    /* renamed from: l  reason: collision with root package name */
    public final String f25443l;

    /* renamed from: m  reason: collision with root package name */
    public final String f25444m;

    /* renamed from: n  reason: collision with root package name */
    public final String f25445n;

    /* renamed from: o  reason: collision with root package name */
    public final String f25446o;

    /* renamed from: p  reason: collision with root package name */
    public final String f25447p;

    /* renamed from: q  reason: collision with root package name */
    public final e f25448q;

    /* renamed from: r  reason: collision with root package name */
    public final a f25449r;

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, e eVar, a aVar) {
        String str17 = str;
        String str18 = str2;
        String str19 = str3;
        String str20 = str4;
        String str21 = str5;
        String str22 = str6;
        String str23 = str7;
        String str24 = str8;
        String str25 = str9;
        String str26 = str10;
        String str27 = str11;
        String str28 = str12;
        String str29 = str13;
        String str30 = str14;
        t.e(str17, "titleText");
        t.e(str18, "bodyText");
        t.e(str19, "legitimateInterestLink");
        t.e(str20, "purposesLabel");
        t.e(str21, "consentLabel");
        t.e(str22, "specialPurposesAndFeaturesLabel");
        t.e(str23, "agreeToAllButtonText");
        t.e(str24, "saveAndExitButtonText");
        t.e(str25, "legalDescriptionTextLabel");
        t.e(str26, "otherPreferencesText");
        t.e(str27, "noneLabel");
        t.e(str28, "someLabel");
        t.e(str29, "allLabel");
        t.e(str30, "closeLabel");
        t.e(str15, "backLabel");
        t.e(str16, "showPartners");
        t.e(eVar, "consentOrPayUILabels");
        a aVar2 = aVar;
        t.e(aVar2, "advancedCustomisationUILabels");
        this.f25432a = str17;
        this.f25433b = str18;
        this.f25434c = str19;
        this.f25435d = str20;
        this.f25436e = str21;
        this.f25437f = str22;
        this.f25438g = str23;
        this.f25439h = str24;
        this.f25440i = str25;
        this.f25441j = str26;
        this.f25442k = str27;
        this.f25443l = str28;
        this.f25444m = str29;
        this.f25445n = str30;
        this.f25446o = str15;
        this.f25447p = str16;
        this.f25448q = eVar;
        this.f25449r = aVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (t.a(this.f25432a, lVar.f25432a) && t.a(this.f25433b, lVar.f25433b) && t.a(this.f25434c, lVar.f25434c) && t.a(this.f25435d, lVar.f25435d) && t.a(this.f25436e, lVar.f25436e) && t.a(this.f25437f, lVar.f25437f) && t.a(this.f25438g, lVar.f25438g) && t.a(this.f25439h, lVar.f25439h) && t.a(this.f25440i, lVar.f25440i) && t.a(this.f25441j, lVar.f25441j) && t.a(this.f25442k, lVar.f25442k) && t.a(this.f25443l, lVar.f25443l) && t.a(this.f25444m, lVar.f25444m) && t.a(this.f25445n, lVar.f25445n) && t.a(this.f25446o, lVar.f25446o) && t.a(this.f25447p, lVar.f25447p) && t.a(this.f25448q, lVar.f25448q) && t.a(this.f25449r, lVar.f25449r)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int a5 = v.a(this.f25447p, v.a(this.f25446o, v.a(this.f25445n, v.a(this.f25444m, v.a(this.f25443l, v.a(this.f25442k, v.a(this.f25441j, v.a(this.f25440i, v.a(this.f25439h, v.a(this.f25438g, v.a(this.f25437f, v.a(this.f25436e, v.a(this.f25435d, v.a(this.f25434c, v.a(this.f25433b, this.f25432a.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
        return this.f25449r.hashCode() + ((this.f25448q.hashCode() + a5) * 31);
    }

    public final String toString() {
        return "OptionsScreen(titleText=" + this.f25432a + ", bodyText=" + this.f25433b + ", legitimateInterestLink=" + this.f25434c + ", purposesLabel=" + this.f25435d + ", consentLabel=" + this.f25436e + ", specialPurposesAndFeaturesLabel=" + this.f25437f + ", agreeToAllButtonText=" + this.f25438g + ", saveAndExitButtonText=" + this.f25439h + ", legalDescriptionTextLabel=" + this.f25440i + ", otherPreferencesText=" + this.f25441j + ", noneLabel=" + this.f25442k + ", someLabel=" + this.f25443l + ", allLabel=" + this.f25444m + ", closeLabel=" + this.f25445n + ", backLabel=" + this.f25446o + ", showPartners=" + this.f25447p + ", consentOrPayUILabels=" + this.f25448q + ", advancedCustomisationUILabels=" + this.f25449r + ')';
    }
}
