package com.inmobi.cmp.core.model.mspa;

import J2.v;
import R3.m;
import androidx.annotation.Keep;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@Keep
public final class USRegulationData {
    private int additionalProcessingDataConsent;
    private String gppString;
    private List<Integer> knownChildSensitiveDataConsents;
    private int mspaCoveredTransaction;
    private int mspaOptOutOptionMode;
    private int mspaServiceProviderMode;
    private int personalDataConsents;
    private int processingNotice;
    private int saleOptOut;
    private int saleOptOutNotice;
    private int sensitiveDataLimitUseNotice;
    private List<Integer> sensitiveDataProcessing;
    private int sensitiveDataProcessingOptOutNotice;
    private int sharingNotice;
    private int sharingOptOut;
    private int sharingOptOutNotice;
    private int targetedAdvertisingOptOut;
    private int targetedAdvertisingOptOutNotice;
    private int version;

    public USRegulationData() {
        this(0, (String) null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (List) null, (List) null, 0, 0, 0, 0, 0, 524287, (C2633k) null);
    }

    public static /* synthetic */ USRegulationData copy$default(USRegulationData uSRegulationData, int i5, String str, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, List list, List list2, int i16, int i17, int i18, int i19, int i20, int i21, Object obj) {
        int i22;
        int i23;
        USRegulationData uSRegulationData2 = uSRegulationData;
        int i24 = i21;
        int i25 = (i24 & 1) != 0 ? uSRegulationData2.version : i5;
        String str2 = (i24 & 2) != 0 ? uSRegulationData2.gppString : str;
        int i26 = (i24 & 4) != 0 ? uSRegulationData2.sharingNotice : i6;
        int i27 = (i24 & 8) != 0 ? uSRegulationData2.saleOptOutNotice : i7;
        int i28 = (i24 & 16) != 0 ? uSRegulationData2.sharingOptOutNotice : i8;
        int i29 = (i24 & 32) != 0 ? uSRegulationData2.targetedAdvertisingOptOutNotice : i9;
        int i30 = (i24 & 64) != 0 ? uSRegulationData2.sensitiveDataProcessingOptOutNotice : i10;
        int i31 = (i24 & 128) != 0 ? uSRegulationData2.sensitiveDataLimitUseNotice : i11;
        int i32 = (i24 & 256) != 0 ? uSRegulationData2.processingNotice : i12;
        int i33 = (i24 & 512) != 0 ? uSRegulationData2.saleOptOut : i13;
        int i34 = (i24 & 1024) != 0 ? uSRegulationData2.sharingOptOut : i14;
        int i35 = (i24 & 2048) != 0 ? uSRegulationData2.targetedAdvertisingOptOut : i15;
        List list3 = (i24 & 4096) != 0 ? uSRegulationData2.sensitiveDataProcessing : list;
        List list4 = (i24 & 8192) != 0 ? uSRegulationData2.knownChildSensitiveDataConsents : list2;
        int i36 = i25;
        int i37 = (i24 & 16384) != 0 ? uSRegulationData2.personalDataConsents : i16;
        int i38 = (i24 & 32768) != 0 ? uSRegulationData2.additionalProcessingDataConsent : i17;
        int i39 = (i21 & 65536) != 0 ? uSRegulationData2.mspaCoveredTransaction : i18;
        int i40 = (i21 & 131072) != 0 ? uSRegulationData2.mspaOptOutOptionMode : i19;
        if ((i21 & 262144) != 0) {
            i23 = i40;
            i22 = uSRegulationData2.mspaServiceProviderMode;
        } else {
            i22 = i20;
            i23 = i40;
        }
        return uSRegulationData2.copy(i36, str2, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, list3, list4, i37, i38, i39, i23, i22);
    }

    public final int component1() {
        return this.version;
    }

    public final int component10() {
        return this.saleOptOut;
    }

    public final int component11() {
        return this.sharingOptOut;
    }

    public final int component12() {
        return this.targetedAdvertisingOptOut;
    }

    public final List<Integer> component13() {
        return this.sensitiveDataProcessing;
    }

    public final List<Integer> component14() {
        return this.knownChildSensitiveDataConsents;
    }

    public final int component15() {
        return this.personalDataConsents;
    }

    public final int component16() {
        return this.additionalProcessingDataConsent;
    }

    public final int component17() {
        return this.mspaCoveredTransaction;
    }

    public final int component18() {
        return this.mspaOptOutOptionMode;
    }

    public final int component19() {
        return this.mspaServiceProviderMode;
    }

    public final String component2() {
        return this.gppString;
    }

    public final int component3() {
        return this.sharingNotice;
    }

    public final int component4() {
        return this.saleOptOutNotice;
    }

    public final int component5() {
        return this.sharingOptOutNotice;
    }

    public final int component6() {
        return this.targetedAdvertisingOptOutNotice;
    }

    public final int component7() {
        return this.sensitiveDataProcessingOptOutNotice;
    }

    public final int component8() {
        return this.sensitiveDataLimitUseNotice;
    }

    public final int component9() {
        return this.processingNotice;
    }

    public final USRegulationData copy(int i5, String str, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, List<Integer> list, List<Integer> list2, int i16, int i17, int i18, int i19, int i20) {
        String str2 = str;
        t.e(str2, "gppString");
        List<Integer> list3 = list;
        t.e(list3, "sensitiveDataProcessing");
        List<Integer> list4 = list2;
        t.e(list4, "knownChildSensitiveDataConsents");
        return new USRegulationData(i5, str2, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, list3, list4, i16, i17, i18, i19, i20);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof USRegulationData)) {
            return false;
        }
        USRegulationData uSRegulationData = (USRegulationData) obj;
        return this.version == uSRegulationData.version && t.a(this.gppString, uSRegulationData.gppString) && this.sharingNotice == uSRegulationData.sharingNotice && this.saleOptOutNotice == uSRegulationData.saleOptOutNotice && this.sharingOptOutNotice == uSRegulationData.sharingOptOutNotice && this.targetedAdvertisingOptOutNotice == uSRegulationData.targetedAdvertisingOptOutNotice && this.sensitiveDataProcessingOptOutNotice == uSRegulationData.sensitiveDataProcessingOptOutNotice && this.sensitiveDataLimitUseNotice == uSRegulationData.sensitiveDataLimitUseNotice && this.processingNotice == uSRegulationData.processingNotice && this.saleOptOut == uSRegulationData.saleOptOut && this.sharingOptOut == uSRegulationData.sharingOptOut && this.targetedAdvertisingOptOut == uSRegulationData.targetedAdvertisingOptOut && t.a(this.sensitiveDataProcessing, uSRegulationData.sensitiveDataProcessing) && t.a(this.knownChildSensitiveDataConsents, uSRegulationData.knownChildSensitiveDataConsents) && this.personalDataConsents == uSRegulationData.personalDataConsents && this.additionalProcessingDataConsent == uSRegulationData.additionalProcessingDataConsent && this.mspaCoveredTransaction == uSRegulationData.mspaCoveredTransaction && this.mspaOptOutOptionMode == uSRegulationData.mspaOptOutOptionMode && this.mspaServiceProviderMode == uSRegulationData.mspaServiceProviderMode;
    }

    public final int getAdditionalProcessingDataConsent() {
        return this.additionalProcessingDataConsent;
    }

    public final String getGppString() {
        return this.gppString;
    }

    public final List<Integer> getKnownChildSensitiveDataConsents() {
        return this.knownChildSensitiveDataConsents;
    }

    public final int getMspaCoveredTransaction() {
        return this.mspaCoveredTransaction;
    }

    public final int getMspaOptOutOptionMode() {
        return this.mspaOptOutOptionMode;
    }

    public final int getMspaServiceProviderMode() {
        return this.mspaServiceProviderMode;
    }

    public final int getPersonalDataConsents() {
        return this.personalDataConsents;
    }

    public final int getProcessingNotice() {
        return this.processingNotice;
    }

    public final int getSaleOptOut() {
        return this.saleOptOut;
    }

    public final int getSaleOptOutNotice() {
        return this.saleOptOutNotice;
    }

    public final int getSensitiveDataLimitUseNotice() {
        return this.sensitiveDataLimitUseNotice;
    }

    public final List<Integer> getSensitiveDataProcessing() {
        return this.sensitiveDataProcessing;
    }

    public final int getSensitiveDataProcessingOptOutNotice() {
        return this.sensitiveDataProcessingOptOutNotice;
    }

    public final int getSharingNotice() {
        return this.sharingNotice;
    }

    public final int getSharingOptOut() {
        return this.sharingOptOut;
    }

    public final int getSharingOptOutNotice() {
        return this.sharingOptOutNotice;
    }

    public final int getTargetedAdvertisingOptOut() {
        return this.targetedAdvertisingOptOut;
    }

    public final int getTargetedAdvertisingOptOutNotice() {
        return this.targetedAdvertisingOptOutNotice;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int a5 = v.a(this.gppString, this.version * 31, 31);
        int i5 = this.saleOptOutNotice;
        int i6 = this.sharingOptOutNotice;
        int i7 = this.targetedAdvertisingOptOutNotice;
        int i8 = this.sensitiveDataProcessingOptOutNotice;
        int i9 = this.sensitiveDataLimitUseNotice;
        int i10 = this.processingNotice;
        int i11 = this.saleOptOut;
        int i12 = this.sharingOptOut;
        int i13 = this.targetedAdvertisingOptOut;
        int a6 = m.a(this.knownChildSensitiveDataConsents, m.a(this.sensitiveDataProcessing, (i13 + ((i12 + ((i11 + ((i10 + ((i9 + ((i8 + ((i7 + ((i6 + ((i5 + ((this.sharingNotice + a5) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31), 31);
        int i14 = this.additionalProcessingDataConsent;
        int i15 = this.mspaCoveredTransaction;
        int i16 = this.mspaOptOutOptionMode;
        return this.mspaServiceProviderMode + ((i16 + ((i15 + ((i14 + ((this.personalDataConsents + a6) * 31)) * 31)) * 31)) * 31);
    }

    public final void setAdditionalProcessingDataConsent(int i5) {
        this.additionalProcessingDataConsent = i5;
    }

    public final void setGppString(String str) {
        t.e(str, "<set-?>");
        this.gppString = str;
    }

    public final void setKnownChildSensitiveDataConsents(List<Integer> list) {
        t.e(list, "<set-?>");
        this.knownChildSensitiveDataConsents = list;
    }

    public final void setMspaCoveredTransaction(int i5) {
        this.mspaCoveredTransaction = i5;
    }

    public final void setMspaOptOutOptionMode(int i5) {
        this.mspaOptOutOptionMode = i5;
    }

    public final void setMspaServiceProviderMode(int i5) {
        this.mspaServiceProviderMode = i5;
    }

    public final void setPersonalDataConsents(int i5) {
        this.personalDataConsents = i5;
    }

    public final void setProcessingNotice(int i5) {
        this.processingNotice = i5;
    }

    public final void setSaleOptOut(int i5) {
        this.saleOptOut = i5;
    }

    public final void setSaleOptOutNotice(int i5) {
        this.saleOptOutNotice = i5;
    }

    public final void setSensitiveDataLimitUseNotice(int i5) {
        this.sensitiveDataLimitUseNotice = i5;
    }

    public final void setSensitiveDataProcessing(List<Integer> list) {
        t.e(list, "<set-?>");
        this.sensitiveDataProcessing = list;
    }

    public final void setSensitiveDataProcessingOptOutNotice(int i5) {
        this.sensitiveDataProcessingOptOutNotice = i5;
    }

    public final void setSharingNotice(int i5) {
        this.sharingNotice = i5;
    }

    public final void setSharingOptOut(int i5) {
        this.sharingOptOut = i5;
    }

    public final void setSharingOptOutNotice(int i5) {
        this.sharingOptOutNotice = i5;
    }

    public final void setTargetedAdvertisingOptOut(int i5) {
        this.targetedAdvertisingOptOut = i5;
    }

    public final void setTargetedAdvertisingOptOutNotice(int i5) {
        this.targetedAdvertisingOptOutNotice = i5;
    }

    public final void setVersion(int i5) {
        this.version = i5;
    }

    public String toString() {
        return "USRegulationData(version=" + this.version + ", gppString=" + this.gppString + ", sharingNotice=" + this.sharingNotice + ", saleOptOutNotice=" + this.saleOptOutNotice + ", sharingOptOutNotice=" + this.sharingOptOutNotice + ", targetedAdvertisingOptOutNotice=" + this.targetedAdvertisingOptOutNotice + ", sensitiveDataProcessingOptOutNotice=" + this.sensitiveDataProcessingOptOutNotice + ", sensitiveDataLimitUseNotice=" + this.sensitiveDataLimitUseNotice + ", processingNotice=" + this.processingNotice + ", saleOptOut=" + this.saleOptOut + ", sharingOptOut=" + this.sharingOptOut + ", targetedAdvertisingOptOut=" + this.targetedAdvertisingOptOut + ", sensitiveDataProcessing=" + this.sensitiveDataProcessing + ", knownChildSensitiveDataConsents=" + this.knownChildSensitiveDataConsents + ", personalDataConsents=" + this.personalDataConsents + ", additionalProcessingDataConsent=" + this.additionalProcessingDataConsent + ", mspaCoveredTransaction=" + this.mspaCoveredTransaction + ", mspaOptOutOptionMode=" + this.mspaOptOutOptionMode + ", mspaServiceProviderMode=" + this.mspaServiceProviderMode + ')';
    }

    public USRegulationData(int i5, String str, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, List<Integer> list, List<Integer> list2, int i16, int i17, int i18, int i19, int i20) {
        List<Integer> list3 = list;
        List<Integer> list4 = list2;
        t.e(str, "gppString");
        t.e(list3, "sensitiveDataProcessing");
        t.e(list4, "knownChildSensitiveDataConsents");
        this.version = i5;
        this.gppString = str;
        this.sharingNotice = i6;
        this.saleOptOutNotice = i7;
        this.sharingOptOutNotice = i8;
        this.targetedAdvertisingOptOutNotice = i9;
        this.sensitiveDataProcessingOptOutNotice = i10;
        this.sensitiveDataLimitUseNotice = i11;
        this.processingNotice = i12;
        this.saleOptOut = i13;
        this.sharingOptOut = i14;
        this.targetedAdvertisingOptOut = i15;
        this.sensitiveDataProcessing = list3;
        this.knownChildSensitiveDataConsents = list4;
        this.personalDataConsents = i16;
        this.additionalProcessingDataConsent = i17;
        this.mspaCoveredTransaction = i18;
        this.mspaOptOutOptionMode = i19;
        this.mspaServiceProviderMode = i20;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ USRegulationData(int r21, java.lang.String r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, java.util.List r33, java.util.List r34, int r35, int r36, int r37, int r38, int r39, int r40, kotlin.jvm.internal.C2633k r41) {
        /*
            r20 = this;
            r0 = r40
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r21
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            java.lang.String r3 = ""
            goto L_0x0013
        L_0x0011:
            r3 = r22
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = 0
            goto L_0x001b
        L_0x0019:
            r4 = r23
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = 0
            goto L_0x0023
        L_0x0021:
            r5 = r24
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = 0
            goto L_0x002b
        L_0x0029:
            r6 = r25
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = 0
            goto L_0x0033
        L_0x0031:
            r7 = r26
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = 0
            goto L_0x003b
        L_0x0039:
            r8 = r27
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = 0
            goto L_0x0043
        L_0x0041:
            r9 = r28
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = 0
            goto L_0x004b
        L_0x0049:
            r10 = r29
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = 0
            goto L_0x0053
        L_0x0051:
            r11 = r30
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = 0
            goto L_0x005b
        L_0x0059:
            r12 = r31
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = 0
            goto L_0x0063
        L_0x0061:
            r13 = r32
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006c
            java.util.List r14 = X2.C2250q.g()
            goto L_0x006e
        L_0x006c:
            r14 = r33
        L_0x006e:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0077
            java.util.List r15 = X2.C2250q.g()
            goto L_0x0079
        L_0x0077:
            r15 = r34
        L_0x0079:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x007f
            r2 = 0
            goto L_0x0081
        L_0x007f:
            r2 = r35
        L_0x0081:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x008b
            r16 = 0
            goto L_0x008d
        L_0x008b:
            r16 = r36
        L_0x008d:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0096
            r17 = 0
            goto L_0x0098
        L_0x0096:
            r17 = r37
        L_0x0098:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00a1
            r18 = 0
            goto L_0x00a3
        L_0x00a1:
            r18 = r38
        L_0x00a3:
            r19 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r19
            if (r0 == 0) goto L_0x00d2
            r40 = 0
        L_0x00ab:
            r21 = r20
            r22 = r1
            r36 = r2
            r23 = r3
            r24 = r4
            r25 = r5
            r26 = r6
            r27 = r7
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r11
            r32 = r12
            r33 = r13
            r34 = r14
            r35 = r15
            r37 = r16
            r38 = r17
            r39 = r18
            goto L_0x00d5
        L_0x00d2:
            r40 = r39
            goto L_0x00ab
        L_0x00d5:
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.core.model.mspa.USRegulationData.<init>(int, java.lang.String, int, int, int, int, int, int, int, int, int, int, java.util.List, java.util.List, int, int, int, int, int, int, kotlin.jvm.internal.k):void");
    }
}
