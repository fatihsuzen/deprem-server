package N2;

import W2.s;
import W2.y;
import X2.M;
import java.util.Map;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f18704a;

    static {
        s a5 = y.a(J2.b.VERSION, "IntEncoder");
        s a6 = y.a(J2.b.CREATED, "DateEncoder");
        s a7 = y.a(J2.b.LASTUPDATED, "DateEncoder");
        s a8 = y.a(J2.b.CMPID, "IntEncoder");
        s a9 = y.a(J2.b.CMPVERSION, "IntEncoder");
        s sVar = a6;
        s sVar2 = a9;
        M.k(a5, sVar, a7, a8, sVar2, y.a(J2.b.CONSENTSCREEN, "IntEncoder"), y.a(J2.b.CONSENTLANGUAGE, "LangEncoder"), y.a(J2.b.VENDORLISTVERSION, "IntEncoder"), y.a(J2.b.POLICYVERSION, "IntEncoder"), y.a(J2.b.ISSERVICESPECIFIC, "BooleanEncoder"), y.a(J2.b.USENONSTANDARDSTACKS, "BooleanEncoder"), y.a(J2.b.SPECIALFEATUREOPTIONS, "FixedVectorEncoder"), y.a(J2.b.PURPOSECONSENTS, "FixedVectorEncoder"), y.a(J2.b.PURPOSELEGITIMATEINTERESTS, "FixedVectorEncoder"), y.a(J2.b.PURPOSEONETREATMENT, "BooleanEncoder"), y.a(J2.b.PUBLISHERCOUNTRYCODE, "LangEncoder"), y.a(J2.b.VENDORCONSENTS, "VendorVectorEncoder"), y.a(J2.b.VENDORLEGITIMATEINTERESTS, "VendorVectorEncoder"), y.a(J2.b.PUBLISHERRESTRICTIONS, "PurposeRestrictionVectorEncoder"), y.a(J2.b.VENDORSDISCLOSED, "VendorVectorEncoder"), y.a(J2.b.VENDORSALLOWED, "VendorVectorEncoder"), y.a(J2.b.PUBLISHERCONSENTS, "FixedVectorEncoder"), y.a(J2.b.PUBLISHERLEGITIMATEINTERESTS, "FixedVectorEncoder"), y.a(J2.b.NUMCUSTOMPURPOSES, "IntEncoder"), y.a(J2.b.PUBLISHERCUSTOMCONSENTS, "FixedVectorEncoder"), y.a(J2.b.PUBLISHERCUSTOMLEGITIMATEINTERESTS, "FixedVectorEncoder"));
        s a10 = y.a("version", "IntEncoder");
        s a11 = y.a("created", "DateEncoder");
        s a12 = y.a("lastUpdated", "DateEncoder");
        s a13 = y.a("cmpId", "IntEncoder");
        s a14 = y.a("cmpVersion", "IntEncoder");
        s a15 = y.a("consentScreen", "IntEncoder");
        s a16 = y.a("consentLanguage", "LangEncoder");
        s a17 = y.a("vendorListVersion", "IntEncoder");
        s a18 = y.a("policyVersion", "IntEncoder");
        s a19 = y.a("isServiceSpecific", "BooleanEncoder");
        s sVar3 = a11;
        s a20 = y.a("useNonStandardStacks", "BooleanEncoder");
        s a21 = y.a("specialFeatureOptions", "FixedVectorEncoder");
        s a22 = y.a("purposeConsents", "FixedVectorEncoder");
        s a23 = y.a("purposeLegitimateInterests", "FixedVectorEncoder");
        s a24 = y.a("purposeOneTreatment", "BooleanEncoder");
        s a25 = y.a("publisherCountryCode", "LangEncoder");
        s a26 = y.a("vendorConsents", "VendorVectorEncoder");
        s sVar4 = a24;
        s a27 = y.a("vendorLegitimateInterests", "VendorVectorEncoder");
        s a28 = y.a("publisherRestrictions", "PurposeRestrictionVectorEncoder");
        s a29 = y.a("segmentType", "IntEncoder");
        s sVar5 = a28;
        s a30 = y.a("vendorsDisclosed", "VendorVectorEncoder");
        s a31 = y.a("vendorsAllowed", "VendorVectorEncoder");
        s a32 = y.a("publisherConsents", "FixedVectorEncoder");
        s a33 = y.a("publisherLegitimateInterests", "FixedVectorEncoder");
        s a34 = y.a("numCustomPurposes", "IntEncoder");
        s sVar6 = a34;
        f18704a = M.k(a10, sVar3, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, sVar4, a25, a26, a27, sVar5, a29, a30, a31, a32, a33, sVar6, y.a("publisherCustomConsents", "FixedVectorEncoder"), y.a("publisherCustomLegitimateInterests", "FixedVectorEncoder"));
    }
}
