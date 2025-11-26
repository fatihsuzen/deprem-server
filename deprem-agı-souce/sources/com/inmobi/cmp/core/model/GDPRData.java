package com.inmobi.cmp.core.model;

import F2.a;
import J2.j;
import J2.k;
import J2.l;
import J2.m;
import J2.u;
import X2.C2250q;
import androidx.annotation.Keep;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.core.cmpapi.map.ConsentMap;
import com.inmobi.cmp.core.cmpapi.map.OutOfBandMap;
import com.inmobi.cmp.core.cmpapi.map.PublisherMap;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r4.b;
import s4.c;

@Keep
public final class GDPRData {
    private Integer cmpId;
    private CmpStatus cmpStatus;
    private Integer cmpVersion;
    private Boolean gdprApplies;
    private String gppString;
    private boolean isServiceSpecific;
    private final OutOfBandMap outOfBand;
    private PrivacyEncodingMode privacyEncodingMode;
    private final PublisherMap publisher;
    private String publisherCC;
    private final ConsentMap purpose;
    private boolean purposeOneTreatment;
    private Map<String, Boolean> specialFeaturesOptions;
    private String tcString;
    private final int tcfPolicyVersion;
    private boolean useNonStandardStacks;
    private final ConsentMap vendor;

    public GDPRData() {
        this((Set) null, 1, (C2633k) null);
    }

    private final Map<String, Map<String, m>> createRestrictions(l lVar) {
        int i5;
        int i6;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i7 = 0;
        for (Map.Entry value : lVar.f18287c.entrySet()) {
            Integer num = (Integer) C2250q.Z((Iterable) value.getValue());
            if (num == null) {
                i6 = 0;
            } else {
                i6 = num.intValue();
            }
            i7 = Math.max(i7, i6);
        }
        if (i7 > 0) {
            int i8 = 0;
            for (Map.Entry value2 : lVar.f18287c.entrySet()) {
                Integer num2 = (Integer) C2250q.Z((Iterable) value2.getValue());
                if (num2 == null) {
                    i5 = 0;
                } else {
                    i5 = num2.intValue();
                }
                i8 = Math.max(i8, i5);
            }
            int i9 = 1;
            if (1 <= i8) {
                while (true) {
                    int i10 = i9 + 1;
                    Integer valueOf = Integer.valueOf(i9);
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry entry : lVar.f18287c.entrySet()) {
                        if (((Set) entry.getValue()).contains(valueOf)) {
                            arrayList.add(j.a((String) entry.getKey()));
                        }
                    }
                    int size = arrayList.size();
                    int i11 = 0;
                    while (i11 < size) {
                        Object obj = arrayList.get(i11);
                        i11++;
                        k kVar = (k) obj;
                        if (!linkedHashMap.containsKey(String.valueOf(kVar.f18283a))) {
                            linkedHashMap.put(String.valueOf(kVar.f18283a), new LinkedHashMap());
                        }
                        Map map = (Map) linkedHashMap.get(String.valueOf(kVar.f18283a));
                        if (map != null) {
                            m mVar = (m) map.put(String.valueOf(i9), kVar.f18284b);
                        }
                    }
                    if (i9 == i8) {
                        break;
                    }
                    i9 = i10;
                }
            }
        }
        return linkedHashMap;
    }

    private final int getPublisherVendorId() {
        int i5 = a.f18101a;
        return -1;
    }

    public final Integer getCmpId() {
        return this.cmpId;
    }

    public final CmpStatus getCmpStatus() {
        return this.cmpStatus;
    }

    public final Integer getCmpVersion() {
        return this.cmpVersion;
    }

    public final Boolean getGdprApplies() {
        return this.gdprApplies;
    }

    public final String getGppString() {
        return this.gppString;
    }

    public final OutOfBandMap getOutOfBand() {
        return this.outOfBand;
    }

    public final PrivacyEncodingMode getPrivacyEncodingMode() {
        return this.privacyEncodingMode;
    }

    public final PublisherMap getPublisher() {
        return this.publisher;
    }

    public final String getPublisherCC() {
        return this.publisherCC;
    }

    public final ConsentMap getPurpose() {
        return this.purpose;
    }

    public final boolean getPurposeOneTreatment() {
        return this.purposeOneTreatment;
    }

    public final Map<String, Boolean> getSpecialFeaturesOptions() {
        return this.specialFeaturesOptions;
    }

    public final String getTcString() {
        return this.tcString;
    }

    public final int getTcfPolicyVersion() {
        return this.tcfPolicyVersion;
    }

    public final boolean getUseNonStandardStacks() {
        return this.useNonStandardStacks;
    }

    public final ConsentMap getVendor() {
        return this.vendor;
    }

    public final boolean isServiceSpecific() {
        return this.isServiceSpecific;
    }

    public final void setCmpId(Integer num) {
        this.cmpId = num;
    }

    public final void setCmpStatus(CmpStatus cmpStatus2) {
        t.e(cmpStatus2, "<set-?>");
        this.cmpStatus = cmpStatus2;
    }

    public final void setCmpVersion(Integer num) {
        this.cmpVersion = num;
    }

    public final void setGdprApplies(Boolean bool) {
        this.gdprApplies = bool;
    }

    public final void setGppString(String str) {
        this.gppString = str;
    }

    public final void setPrivacyEncodingMode(PrivacyEncodingMode privacyEncodingMode2) {
        this.privacyEncodingMode = privacyEncodingMode2;
    }

    public final void setPublisherCC(String str) {
        this.publisherCC = str;
    }

    public final void setPurposeOneTreatment(boolean z4) {
        this.purposeOneTreatment = z4;
    }

    public final void setServiceSpecific(boolean z4) {
        this.isServiceSpecific = z4;
    }

    public final void setSpecialFeaturesOptions(Map<String, Boolean> map) {
        t.e(map, "<set-?>");
        this.specialFeaturesOptions = map;
    }

    public final void setTcString(String str) {
        this.tcString = str;
    }

    public final void setUseNonStandardStacks(boolean z4) {
        this.useNonStandardStacks = z4;
    }

    public GDPRData(Set<Integer> set) {
        this.tcfPolicyVersion = 2;
        this.cmpStatus = CmpStatus.LOADING;
        this.purpose = new ConsentMap((Map) null, (Map) null, 3, (C2633k) null);
        this.vendor = new ConsentMap((Map) null, (Map) null, 3, (C2633k) null);
        this.specialFeaturesOptions = new LinkedHashMap();
        this.publisher = new PublisherMap(0, (Map) null, (Map) null, (ConsentMap) null, (Map) null, 31, (C2633k) null);
        this.outOfBand = new OutOfBandMap((Map) null, (Map) null, 3, (C2633k) null);
        u tcModel$app_release = ChoiceCmp.INSTANCE.getTcModel$app_release();
        r4.a l5 = c.l();
        if (tcModel$app_release != null) {
            setPrivacyEncodingMode(R3.l.a(c.j().a().a()));
            PrivacyEncodingMode privacyEncodingMode2 = getPrivacyEncodingMode();
            int i5 = privacyEncodingMode2 == null ? -1 : J2.c.f18270a[privacyEncodingMode2.ordinal()];
            boolean z4 = true;
            if (i5 == 1) {
                setTcString(l5.k(b.TC_STRING));
            } else if (i5 != 2) {
                setTcString(l5.k(b.TC_STRING));
                setGppString(l5.k(b.HDR_GPP_STRING));
            } else {
                setGppString(l5.k(b.HDR_GPP_STRING));
            }
            setServiceSpecific(tcModel$app_release.v());
            setUseNonStandardStacks(tcModel$app_release.q());
            setPurposeOneTreatment(tcModel$app_release.o());
            setPublisherCC(tcModel$app_release.h());
            setCmpId(Integer.valueOf(tcModel$app_release.a()));
            setCmpVersion(Integer.valueOf(tcModel$app_release.e()));
            setGdprApplies(Boolean.valueOf(l5.a() != 1 ? false : z4));
            OutOfBandMap outOfBand2 = getOutOfBand();
            outOfBand2.setAllowedVendors(R3.l.c(tcModel$app_release.t(), set));
            outOfBand2.setDisclosedVendors(R3.l.c(tcModel$app_release.u(), set));
            ConsentMap purpose2 = getPurpose();
            purpose2.setConsents(R3.l.b(tcModel$app_release.m()));
            purpose2.setLegitimateInterests(R3.l.b(tcModel$app_release.n()));
            ConsentMap vendor2 = getVendor();
            vendor2.setConsents(R3.l.b(tcModel$app_release.r()));
            vendor2.setLegitimateInterests(R3.l.b(tcModel$app_release.s()));
            setSpecialFeaturesOptions(R3.l.b(tcModel$app_release.p()));
            PublisherMap publisher2 = getPublisher();
            publisher2.setVendorId(getPublisherVendorId());
            publisher2.setConsents(R3.l.b(tcModel$app_release.g()));
            publisher2.setLegitimateInterests(R3.l.b(tcModel$app_release.k()));
            ConsentMap customPurpose = publisher2.getCustomPurpose();
            customPurpose.setConsents(R3.l.b(tcModel$app_release.i()));
            customPurpose.setLegitimateInterests(R3.l.b(tcModel$app_release.j()));
            publisher2.setRestrictions(createRestrictions(tcModel$app_release.l()));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GDPRData(Set set, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? null : set);
    }
}
