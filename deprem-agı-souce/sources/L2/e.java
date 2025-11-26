package L2;

import J2.b;
import W2.s;
import W2.y;
import X2.M;
import java.util.Map;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f18404a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map f18405b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map f18406c;

    static {
        s a5 = y.a(b.CMPID, 12);
        s a6 = y.a(b.CMPVERSION, 12);
        s a7 = y.a(b.CONSENTLANGUAGE, 12);
        s a8 = y.a(b.CONSENTSCREEN, 6);
        s a9 = y.a(b.CREATED, 36);
        s a10 = y.a(b.ISSERVICESPECIFIC, 1);
        s a11 = y.a(b.LASTUPDATED, 36);
        s a12 = y.a(b.POLICYVERSION, 6);
        s a13 = y.a(b.PUBLISHERCOUNTRYCODE, 12);
        s a14 = y.a(b.PUBLISHERLEGITIMATEINTERESTS, 24);
        s sVar = a5;
        s sVar2 = a14;
        f18404a = M.k(sVar, a6, a7, a8, a9, a10, a11, a12, a13, sVar2, y.a(b.PUBLISHERCONSENTS, 24), y.a(b.PUBLISHERRESTRICTIONS, 36), y.a(b.PURPOSECONSENTS, 24), y.a(b.PURPOSELEGITIMATEINTERESTS, 24), y.a(b.PURPOSEONETREATMENT, 1), y.a(b.SPECIALFEATUREOPTIONS, 12), y.a(b.USENONSTANDARDSTACKS, 1), y.a(b.VENDORCONSENTS, 24), y.a(b.VENDORLEGITIMATEINTERESTS, 24), y.a(b.VENDORLISTVERSION, 12), y.a(b.VERSION, 6));
        s a15 = y.a(f.ANY_BOOLEAN, 1);
        s a16 = y.a(f.ENCODING_TYPE, 1);
        s a17 = y.a(f.MAX_ID, 16);
        s sVar3 = a15;
        s sVar4 = a17;
        f18405b = M.k(sVar3, a16, sVar4, y.a(f.NUM_CUSTOM_PURPOSES, 6), y.a(f.NUM_ENTRIES, 12), y.a(f.NUM_RESTRICTIONS, 12), y.a(f.PURPOSE_ID, 6), y.a(f.RESTRICTION_TYPE, 2), y.a(f.SEGMENT_TYPE, 3), y.a(f.SINGLE_OR_RANGE, 1), y.a(f.VENDOR_ID, 16));
        s a18 = y.a("cmpId", 12);
        s a19 = y.a("cmpVersion", 12);
        s a20 = y.a("consentLanguage", 12);
        s a21 = y.a("consentScreen", 6);
        s a22 = y.a("created", 36);
        s a23 = y.a("isServiceSpecific", 1);
        s a24 = y.a("lastUpdated", 36);
        s a25 = y.a("policyVersion", 6);
        s sVar5 = a18;
        s a26 = y.a("publisherCountryCode", 12);
        s a27 = y.a("publisherLegitimateInterests", 24);
        s a28 = y.a("publisherConsents", 24);
        s a29 = y.a("publisherRestrictions", 36);
        s a30 = y.a("purposeConsents", 24);
        s sVar6 = a29;
        s a31 = y.a("purposeLegitimateInterests", 24);
        s a32 = y.a("purposeOneTreatment", 1);
        s a33 = y.a("specialFeatureOptions", 12);
        s a34 = y.a("useNonStandardStacks", 1);
        s a35 = y.a("vendorListVersion", 12);
        s a36 = y.a("vendorConsents", 24);
        s a37 = y.a("vendorLegitimateInterests", 24);
        s sVar7 = a37;
        f18406c = M.k(sVar5, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28, sVar6, a30, a31, a32, a33, a34, a35, a36, sVar7, y.a("version", 6), y.a("anyBoolean", 1), y.a("encodingType", 1), y.a("maxId", 16), y.a("numCustomPurposes", 6), y.a("numEntries", 12), y.a("numRestrictions", 12), y.a("purposeId", 6), y.a("restrictionType", 2), y.a("segmentType", 3), y.a("singleOrRange", 1), y.a("vendorId", 16));
    }
}
