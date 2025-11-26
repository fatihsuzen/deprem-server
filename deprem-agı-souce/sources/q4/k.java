package q4;

import H2.d;
import T3.b;
import T3.c;
import T3.f;
import T3.h;
import T3.i;
import T3.j;
import T3.l;
import android.graphics.Color;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.data.model.ChoiceColor;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import kotlin.jvm.internal.t;
import m4.g;
import m4.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k implements i {

    /* renamed from: a  reason: collision with root package name */
    public final ChoiceCmpCallback f25707a;

    /* renamed from: b  reason: collision with root package name */
    public final c f25708b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f25709c;

    public k(ChoiceCmpCallback choiceCmpCallback, c cVar) {
        t.e(cVar, "coreUiLabelsResolver");
        this.f25707a = choiceCmpCallback;
        this.f25708b = cVar;
    }

    public static ChoiceColor b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ChoiceColor choiceColor = new ChoiceColor();
        choiceColor.setDividerColor(Integer.valueOf(Color.parseColor(jSONObject.optString("dividerColor"))));
        choiceColor.setTabBackgroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("tabBackgroundColor"))));
        choiceColor.setSearchBarBackgroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("searchBarBackgroundColor"))));
        choiceColor.setSearchBarForegroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("searchBarForegroundColor"))));
        choiceColor.setToggleActiveColor(Integer.valueOf(Color.parseColor(jSONObject.optString("toggleActiveColor"))));
        choiceColor.setToggleInactiveColor(Integer.valueOf(Color.parseColor(jSONObject.optString("toggleInactiveColor"))));
        choiceColor.setGlobalBackgroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("globalBackgroundColor"))));
        choiceColor.setTitleTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("titleTextColor"))));
        choiceColor.setBodyTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("bodyTextColor"))));
        choiceColor.setTabTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("tabTextColor"))));
        choiceColor.setMenuTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("menuTextColor"))));
        choiceColor.setLinkTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("linkTextColor"))));
        choiceColor.setButtonTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("buttonTextColor"))));
        choiceColor.setButtonDisabledTextColor(Integer.valueOf(Color.parseColor(jSONObject.optString("buttonDisabledTextColor"))));
        choiceColor.setButtonBackgroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("buttonBackgroundColor"))));
        choiceColor.setButtonDisabledBackgroundColor(Integer.valueOf(Color.parseColor(jSONObject.optString("buttonDisabledBackgroundColor"))));
        return choiceColor;
    }

    public final Object a(String str) {
        t.e(str, "jsonString");
        try {
            this.f25709c = new JSONObject(str);
            j d5 = d();
            c a5 = a();
            h c5 = c();
            this.f25708b.getClass();
            g b5 = c.b(str);
            p e5 = e();
            l f5 = f();
            JSONObject jSONObject = this.f25709c;
            if (jSONObject == null) {
                t.w("json");
                jSONObject = null;
            }
            return new i(d5, a5, c5, b5, e5, f5, jSONObject.getLong("currentTimeStamp"), 16);
        } catch (JSONException e6) {
            d.c("Choice", t.n("Error parsing portal config: ", e6.getMessage()), (Exception) null, (Boolean) null, 12);
            ChoiceCmpCallback choiceCmpCallback = this.f25707a;
            if (choiceCmpCallback != null) {
                choiceCmpCallback.onCmpError(ChoiceError.UNKNOWN_CONFIG);
            }
            return new i((j) null, (c) null, (h) null, (g) null, (p) null, (l) null, 0, 255);
        }
    }

    public final h c() {
        JSONObject jSONObject = this.f25709c;
        if (jSONObject == null) {
            t.w("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("nonIabVendorsInfo");
        JSONArray optJSONArray = jSONObject2.optJSONArray("nonIabVendorList");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 + 1;
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i5);
                int optInt = jSONObject3.optInt("vendorId");
                String optString = jSONObject3.optString("pCode");
                t.d(optString, "nonIABVendor.optString(\"pCode\")");
                String optString2 = jSONObject3.optString(RewardPlus.NAME);
                t.d(optString2, "nonIABVendor.optString(\"name\")");
                String optString3 = jSONObject3.optString("description", "");
                t.d(optString3, "nonIABVendor.optString(\"description\", EMPTY)");
                String optString4 = jSONObject3.optString("privacyPolicyUrl", "");
                t.d(optString4, "nonIABVendor.optString(\"privacyPolicyUrl\", EMPTY)");
                t.d(jSONObject3, "nonIABVendor");
                arrayList.add(new T3.g(optInt, optString, optString2, optString3, optString4, h.a(jSONObject3, "nonIabPurposeConsentIds"), h.a(jSONObject3, "nonIabPurposeLegitimateInterestIds")));
                i5 = i6;
            }
        }
        String optString5 = jSONObject2.optString("updateAt");
        t.d(optString5, "nonIabVendors.optString(\"updateAt\")");
        String optString6 = jSONObject2.optString("nonIabVendorsHash");
        t.d(optString6, "nonIabVendors.optString(\"nonIabVendorsHash\")");
        return new h(arrayList, optString5, optString6);
    }

    public final j d() {
        JSONObject jSONObject = this.f25709c;
        if (jSONObject == null) {
            t.w("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("premiumProperties");
        t.d(jSONObject2, "premiumProperties");
        return new j(h.a(jSONObject2, "vendorBlacklist"), h.a(jSONObject2, "vendorWhitelist"), h.a(jSONObject2, "googleWhitelist"));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: m4.p} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: m4.p} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: m4.p} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: m4.p} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: m4.p} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: m4.p} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: m4.p} */
    /* JADX WARNING: type inference failed for: r1v10, types: [java.util.ArrayList] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final m4.p e() {
        /*
            r14 = this;
            org.json.JSONObject r0 = r14.f25709c
            r1 = 0
            if (r0 != 0) goto L_0x000b
            java.lang.String r0 = "json"
            kotlin.jvm.internal.t.w(r0)
            r0 = r1
        L_0x000b:
            java.lang.String r2 = "premiumUiLabels"
            org.json.JSONObject r0 = r0.optJSONObject(r2)
            if (r0 != 0) goto L_0x0015
            goto L_0x0096
        L_0x0015:
            java.lang.String r2 = "initScreenCustomLinks"
            org.json.JSONArray r2 = r0.optJSONArray(r2)
            if (r2 != 0) goto L_0x001e
            goto L_0x0050
        L_0x001e:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r3 = r2.length()
            r4 = 0
        L_0x0028:
            if (r4 >= r3) goto L_0x0050
            int r5 = r4 + 1
            org.json.JSONObject r4 = r2.optJSONObject(r4)
            m4.q r6 = new m4.q
            java.lang.String r7 = "label"
            java.lang.String r7 = r4.optString(r7)
            java.lang.String r8 = "initScreenCustomLink.optString(\"label\")"
            kotlin.jvm.internal.t.d(r7, r8)
            java.lang.String r8 = "link"
            java.lang.String r4 = r4.optString(r8)
            java.lang.String r8 = "initScreenCustomLink.optString(\"link\")"
            kotlin.jvm.internal.t.d(r4, r8)
            r6.<init>(r7, r4)
            r1.add(r6)
            r4 = r5
            goto L_0x0028
        L_0x0050:
            if (r1 != 0) goto L_0x0057
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0057:
            r12 = r1
            java.lang.String r1 = "uspDnsTitle"
            java.lang.String r5 = r0.optString(r1)
            java.lang.String r1 = "uspDnsText"
            java.util.ArrayList r6 = q4.h.b(r0, r1)
            java.lang.String r1 = "uspDeleteDataLinkText"
            java.lang.String r9 = r0.optString(r1)
            java.lang.String r1 = "uspAccessDataLinkText"
            java.lang.String r10 = r0.optString(r1)
            java.lang.String r1 = "uspPrivacyPolicyLinkText"
            java.lang.String r8 = r0.optString(r1)
            m4.p r2 = new m4.p
            java.lang.String r0 = "optString(\"uspDnsTitle\")"
            kotlin.jvm.internal.t.d(r5, r0)
            java.lang.String r0 = "optString(\"uspPrivacyPolicyLinkText\")"
            kotlin.jvm.internal.t.d(r8, r0)
            java.lang.String r0 = "optString(\"uspDeleteDataLinkText\")"
            kotlin.jvm.internal.t.d(r9, r0)
            java.lang.String r0 = "optString(\"uspAccessDataLinkText\")"
            kotlin.jvm.internal.t.d(r10, r0)
            r11 = 0
            r13 = 275(0x113, float:3.85E-43)
            r3 = 0
            r4 = 0
            r7 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r1 = r2
        L_0x0096:
            if (r1 != 0) goto L_0x00aa
            m4.p r2 = new m4.p
            r12 = 0
            r13 = 1023(0x3ff, float:1.434E-42)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r2
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.k.e():m4.p");
    }

    public final l f() {
        JSONObject jSONObject = this.f25709c;
        if (jSONObject == null) {
            t.w("json");
            jSONObject = null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("theme");
        if (optJSONObject == null) {
            return null;
        }
        String optString = optJSONObject.optString("themeMode");
        t.d(optString, "optString(\"themeMode\")");
        return new l(optString, b(optJSONObject.optJSONObject("lightModeColors")), b(optJSONObject.optJSONObject("darkModeColors")));
    }

    public final c a() {
        c cVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str;
        c cVar2;
        T3.d dVar;
        String str2;
        String str3;
        String str4;
        T3.d dVar2;
        f fVar;
        b bVar;
        boolean z4;
        boolean z5;
        boolean z6;
        JSONObject jSONObject = this.f25709c;
        if (jSONObject == null) {
            t.w("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("coreConfig");
        String optString = jSONObject2.optString("inmobiAccountId");
        t.d(optString, "coreConfig.optString(\"inmobiAccountId\")");
        t.d(jSONObject2, "coreConfig");
        ArrayList b5 = h.b(jSONObject2, "privacyMode");
        ArrayList b6 = h.b(jSONObject2, "uspJurisdiction");
        String optString2 = jSONObject2.optString("uspLspact");
        t.d(optString2, "coreConfig.optString(\"uspLspact\")");
        String optString3 = jSONObject2.optString("hashCode");
        t.d(optString3, "coreConfig.optString(\"hashCode\")");
        String optString4 = jSONObject2.optString("publisherCountryCode");
        t.d(optString4, "coreConfig.optString(\"publisherCountryCode\")");
        String optString5 = jSONObject2.optString("publisherName");
        t.d(optString5, "coreConfig.optString(\"publisherName\")");
        ArrayList a5 = h.a(jSONObject2, "vendorPurposeIds");
        ArrayList a6 = h.a(jSONObject2, "vendorFeaturesIds");
        ArrayList a7 = h.a(jSONObject2, "vendorPurposeLegitimateInterestIds");
        ArrayList a8 = h.a(jSONObject2, "vendorSpecialFeaturesIds");
        ArrayList a9 = h.a(jSONObject2, "vendorSpecialPurposesIds");
        boolean optBoolean = jSONObject2.optBoolean("googleEnabled");
        String optString6 = jSONObject2.optString("consentScope");
        t.d(optString6, "coreConfig.optString(\"consentScope\")");
        String optString7 = jSONObject2.optString("lang_");
        String str5 = optString6;
        t.d(optString7, "coreConfig.optString(\"lang_\")");
        String optString8 = jSONObject2.optString("displayUi");
        String str6 = optString7;
        t.d(optString8, "coreConfig.optString(\"displayUi\")");
        boolean optBoolean2 = jSONObject2.optBoolean("initScreenRejectButtonShowing");
        String optString9 = jSONObject2.optString("publisherLogo");
        String str7 = optString8;
        t.d(optString9, "coreConfig.optString(\"publisherLogo\")");
        ArrayList a10 = h.a(jSONObject2, "publisherPurposeIds");
        ArrayList a11 = h.a(jSONObject2, "publisherPurposeLegitimateInterestIds");
        ArrayList a12 = h.a(jSONObject2, "publisherSpecialPurposesIds");
        ArrayList a13 = h.a(jSONObject2, "publisherFeaturesIds");
        ArrayList a14 = h.a(jSONObject2, "publisherSpecialFeaturesIds");
        ArrayList a15 = h.a(jSONObject2, "publisherConsentRestrictionIds");
        ArrayList a16 = h.a(jSONObject2, "publisherLIRestrictionIds");
        ArrayList a17 = h.a(jSONObject2, "stacks");
        int optInt = jSONObject2.optInt("vendorListUpdateFreq");
        String optString10 = jSONObject2.optString("thirdPartyStorageType");
        String str8 = optString9;
        t.d(optString10, "coreConfig.optString(\"thirdPartyStorageType\")");
        String str9 = optString10;
        boolean optBoolean3 = jSONObject2.optBoolean("suppressCcpaLinks", false);
        String optString11 = jSONObject2.optString("uspDeleteDataLink");
        t.d(optString11, "coreConfig.optString(\"uspDeleteDataLink\")");
        String optString12 = jSONObject2.optString("uspAccessDataLink");
        String str10 = optString11;
        t.d(optString12, "coreConfig.optString(\"uspAccessDataLink\")");
        String optString13 = jSONObject2.optString("uspPrivacyPolicyLink");
        String str11 = optString12;
        t.d(optString13, "coreConfig.optString(\"uspPrivacyPolicyLink\")");
        String str12 = optString13;
        int optInt2 = jSONObject2.optInt("gvlVersion", 2);
        Integer valueOf = Integer.valueOf(jSONObject2.optInt("totalVendors"));
        String optString14 = jSONObject2.optString("gdprEncodingMode");
        String optString15 = jSONObject2.optString("mspaJurisdiction");
        int i5 = optInt2;
        boolean optBoolean4 = jSONObject2.optBoolean("isCoveredTransaction", false);
        String optString16 = jSONObject2.optString("mspaSignalMode");
        boolean z7 = optBoolean4;
        boolean optBoolean5 = jSONObject2.optBoolean("ccpaViaUsp", false);
        ArrayList a18 = h.a(jSONObject2, "mspaOptOutPurposeIds");
        ArrayList a19 = h.a(jSONObject2, "mspaSensitiveDataPurposeIds");
        String optString17 = jSONObject2.optString("cmpVersion");
        ArrayList b7 = h.b(jSONObject2, "consentLocations");
        boolean z8 = optBoolean5;
        boolean optBoolean6 = jSONObject2.optBoolean("mspaAutoPopUp", false);
        boolean optBoolean7 = jSONObject2.optBoolean("gdprEnabledInUS", false);
        String optString18 = jSONObject2.optString("siteUuid");
        String optString19 = jSONObject2.optString("themeUuid");
        JSONObject optJSONObject = jSONObject2.optJSONObject("features");
        boolean z9 = optBoolean7;
        if (optJSONObject == null) {
            cVar2 = cVar;
            Boolean bool = Boolean.FALSE;
            dVar = new T3.d(bool, bool, bool);
            str = optString;
            arrayList2 = b5;
            arrayList = b6;
        } else {
            cVar2 = cVar;
            str = optString;
            arrayList2 = b5;
            arrayList = b6;
            dVar = new T3.d(Boolean.valueOf(optJSONObject.optBoolean("visitEvents", false)), Boolean.valueOf(optJSONObject.optBoolean("advancedCustomizations", false)), Boolean.valueOf(optJSONObject.optBoolean("consentOrPay", false)));
        }
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("gbcConfig");
        if (optJSONObject2 == null) {
            new f
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01e4: CONSTRUCTOR  (r3v7 ? I:T3.f) =  call: T3.f.<init>():void type: CONSTRUCTOR in method: q4.k.a():T3.c, dex: classes4.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v7 ?
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	... 34 more
                */
            /*
                this = this;
                r0 = r63
                org.json.JSONObject r1 = r0.f25709c
                if (r1 != 0) goto L_0x000c
                java.lang.String r1 = "json"
                kotlin.jvm.internal.t.w(r1)
                r1 = 0
            L_0x000c:
                java.lang.String r2 = "coreConfig"
                org.json.JSONObject r1 = r1.getJSONObject(r2)
                T3.c r3 = new T3.c
                java.lang.String r4 = "inmobiAccountId"
                java.lang.String r4 = r1.optString(r4)
                java.lang.String r5 = "coreConfig.optString(\"inmobiAccountId\")"
                kotlin.jvm.internal.t.d(r4, r5)
                kotlin.jvm.internal.t.d(r1, r2)
                java.lang.String r2 = "privacyMode"
                java.util.ArrayList r5 = q4.h.b(r1, r2)
                java.lang.String r2 = "uspJurisdiction"
                java.util.ArrayList r6 = q4.h.b(r1, r2)
                java.lang.String r2 = "uspLspact"
                java.lang.String r7 = r1.optString(r2)
                java.lang.String r2 = "coreConfig.optString(\"uspLspact\")"
                kotlin.jvm.internal.t.d(r7, r2)
                java.lang.String r2 = "hashCode"
                java.lang.String r8 = r1.optString(r2)
                java.lang.String r2 = "coreConfig.optString(\"hashCode\")"
                kotlin.jvm.internal.t.d(r8, r2)
                java.lang.String r2 = "publisherCountryCode"
                java.lang.String r9 = r1.optString(r2)
                java.lang.String r2 = "coreConfig.optString(\"publisherCountryCode\")"
                kotlin.jvm.internal.t.d(r9, r2)
                java.lang.String r2 = "publisherName"
                java.lang.String r10 = r1.optString(r2)
                java.lang.String r2 = "coreConfig.optString(\"publisherName\")"
                kotlin.jvm.internal.t.d(r10, r2)
                java.lang.String r2 = "vendorPurposeIds"
                java.util.ArrayList r11 = q4.h.a(r1, r2)
                java.lang.String r2 = "vendorFeaturesIds"
                java.util.ArrayList r12 = q4.h.a(r1, r2)
                java.lang.String r2 = "vendorPurposeLegitimateInterestIds"
                java.util.ArrayList r13 = q4.h.a(r1, r2)
                java.lang.String r2 = "vendorSpecialFeaturesIds"
                java.util.ArrayList r14 = q4.h.a(r1, r2)
                java.lang.String r2 = "vendorSpecialPurposesIds"
                java.util.ArrayList r15 = q4.h.a(r1, r2)
                java.lang.String r2 = "googleEnabled"
                boolean r16 = r1.optBoolean(r2)
                java.lang.String r2 = "consentScope"
                java.lang.String r2 = r1.optString(r2)
                java.lang.String r0 = "coreConfig.optString(\"consentScope\")"
                kotlin.jvm.internal.t.d(r2, r0)
                java.lang.String r0 = "lang_"
                java.lang.String r0 = r1.optString(r0)
                r17 = r2
                java.lang.String r2 = "coreConfig.optString(\"lang_\")"
                kotlin.jvm.internal.t.d(r0, r2)
                java.lang.String r2 = "displayUi"
                java.lang.String r2 = r1.optString(r2)
                r18 = r0
                java.lang.String r0 = "coreConfig.optString(\"displayUi\")"
                kotlin.jvm.internal.t.d(r2, r0)
                java.lang.String r0 = "initScreenRejectButtonShowing"
                boolean r20 = r1.optBoolean(r0)
                java.lang.String r0 = "publisherLogo"
                java.lang.String r0 = r1.optString(r0)
                r19 = r2
                java.lang.String r2 = "coreConfig.optString(\"publisherLogo\")"
                kotlin.jvm.internal.t.d(r0, r2)
                java.lang.String r2 = "publisherPurposeIds"
                java.util.ArrayList r22 = q4.h.a(r1, r2)
                java.lang.String r2 = "publisherPurposeLegitimateInterestIds"
                java.util.ArrayList r23 = q4.h.a(r1, r2)
                java.lang.String r2 = "publisherSpecialPurposesIds"
                java.util.ArrayList r24 = q4.h.a(r1, r2)
                java.lang.String r2 = "publisherFeaturesIds"
                java.util.ArrayList r25 = q4.h.a(r1, r2)
                java.lang.String r2 = "publisherSpecialFeaturesIds"
                java.util.ArrayList r26 = q4.h.a(r1, r2)
                java.lang.String r2 = "publisherConsentRestrictionIds"
                java.util.ArrayList r27 = q4.h.a(r1, r2)
                java.lang.String r2 = "publisherLIRestrictionIds"
                java.util.ArrayList r28 = q4.h.a(r1, r2)
                java.lang.String r2 = "stacks"
                java.util.ArrayList r29 = q4.h.a(r1, r2)
                java.lang.String r2 = "vendorListUpdateFreq"
                int r30 = r1.optInt(r2)
                java.lang.String r2 = "thirdPartyStorageType"
                java.lang.String r2 = r1.optString(r2)
                r21 = r0
                java.lang.String r0 = "coreConfig.optString(\"thirdPartyStorageType\")"
                kotlin.jvm.internal.t.d(r2, r0)
                java.lang.String r0 = "suppressCcpaLinks"
                r31 = r2
                r2 = 0
                boolean r32 = r1.optBoolean(r0, r2)
                java.lang.String r0 = "uspDeleteDataLink"
                java.lang.String r0 = r1.optString(r0)
                java.lang.String r2 = "coreConfig.optString(\"uspDeleteDataLink\")"
                kotlin.jvm.internal.t.d(r0, r2)
                java.lang.String r2 = "uspAccessDataLink"
                java.lang.String r2 = r1.optString(r2)
                r34 = r0
                java.lang.String r0 = "coreConfig.optString(\"uspAccessDataLink\")"
                kotlin.jvm.internal.t.d(r2, r0)
                java.lang.String r0 = "uspPrivacyPolicyLink"
                java.lang.String r0 = r1.optString(r0)
                r35 = r2
                java.lang.String r2 = "coreConfig.optString(\"uspPrivacyPolicyLink\")"
                kotlin.jvm.internal.t.d(r0, r2)
                java.lang.String r2 = "gvlVersion"
                r36 = r0
                r0 = 2
                int r0 = r1.optInt(r2, r0)
                java.lang.String r2 = "totalVendors"
                int r2 = r1.optInt(r2)
                java.lang.Integer r37 = java.lang.Integer.valueOf(r2)
                java.lang.String r2 = "gdprEncodingMode"
                java.lang.String r38 = r1.optString(r2)
                java.lang.String r2 = "mspaJurisdiction"
                java.lang.String r39 = r1.optString(r2)
                java.lang.String r2 = "isCoveredTransaction"
                r40 = r0
                r0 = 0
                boolean r2 = r1.optBoolean(r2, r0)
                java.lang.String r0 = "mspaSignalMode"
                java.lang.String r41 = r1.optString(r0)
                java.lang.String r0 = "ccpaViaUsp"
                r42 = r2
                r2 = 0
                boolean r0 = r1.optBoolean(r0, r2)
                java.lang.String r2 = "mspaOptOutPurposeIds"
                java.util.ArrayList r43 = q4.h.a(r1, r2)
                java.lang.String r2 = "mspaSensitiveDataPurposeIds"
                java.util.ArrayList r44 = q4.h.a(r1, r2)
                java.lang.String r2 = "cmpVersion"
                java.lang.String r45 = r1.optString(r2)
                java.lang.String r2 = "consentLocations"
                java.util.ArrayList r46 = q4.h.b(r1, r2)
                java.lang.String r2 = "mspaAutoPopUp"
                r47 = r0
                r0 = 0
                boolean r2 = r1.optBoolean(r2, r0)
                r48 = r2
                java.lang.String r2 = "gdprEnabledInUS"
                boolean r2 = r1.optBoolean(r2, r0)
                java.lang.String r0 = "siteUuid"
                java.lang.String r49 = r1.optString(r0)
                java.lang.String r0 = "themeUuid"
                java.lang.String r50 = r1.optString(r0)
                java.lang.String r0 = "features"
                org.json.JSONObject r0 = r1.optJSONObject(r0)
                r51 = r2
                java.lang.String r2 = "consentOrPay"
                if (r0 != 0) goto L_0x01af
                T3.d r0 = new T3.d
                r52 = r3
                java.lang.Boolean r3 = java.lang.Boolean.FALSE
                r0.<init>(r3, r3, r3)
                r53 = r4
                r54 = r5
                r55 = r6
                goto L_0x01da
            L_0x01af:
                r52 = r3
                T3.d r3 = new T3.d
                r53 = r4
                java.lang.String r4 = "visitEvents"
                r54 = r5
                r5 = 0
                boolean r4 = r0.optBoolean(r4, r5)
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                r55 = r6
                java.lang.String r6 = "advancedCustomizations"
                boolean r6 = r0.optBoolean(r6, r5)
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
                boolean r0 = r0.optBoolean(r2, r5)
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                r3.<init>(r4, r6, r0)
                r0 = r3
            L_0x01da:
                java.lang.String r3 = "gbcConfig"
                org.json.JSONObject r3 = r1.optJSONObject(r3)
                if (r3 != 0) goto L_0x01f0
                T3.f r3 = new T3.f
                r3.<init>()
                r56 = r0
                r57 = r7
                r58 = r8
                r62 = r9
                goto L_0x0256
            L_0x01f0:
                T3.f r4 = new T3.f
                java.lang.String r5 = "enabled"
                r6 = 0
                boolean r5 = r3.optBoolean(r5, r6)
                java.lang.String r6 = "locations"
                java.util.ArrayList r6 = q4.h.b(r3, r6)
                r56 = r0
                java.lang.String r0 = "applicablePurposes"
                org.json.JSONArray r0 = r3.optJSONArray(r0)
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                if (r0 != 0) goto L_0x0215
                r57 = r7
                r58 = r8
            L_0x0212:
                r62 = r9
                goto L_0x0252
            L_0x0215:
                r57 = r7
                int r7 = r0.length()
                r58 = r8
                r8 = 0
            L_0x021e:
                if (r8 >= r7) goto L_0x0212
                int r59 = r8 + 1
                org.json.JSONObject r8 = r0.getJSONObject(r8)
                r60 = r0
                T3.e r0 = new T3.e
                r61 = r7
                java.lang.String r7 = "id"
                int r7 = r8.optInt(r7)
                r62 = r9
                java.lang.String r9 = "defaultValue"
                java.lang.String r8 = r8.optString(r9)
                java.lang.String r9 = "gbcPurpose.optString(\"defaultValue\")"
                kotlin.jvm.internal.t.d(r8, r9)
                com.inmobi.cmp.core.model.portalconfig.GBCConsentValue r8 = com.inmobi.cmp.core.model.portalconfig.GBCConsentValue.valueOf(r8)
                r0.<init>(r7, r8)
                r3.add(r0)
                r8 = r59
                r0 = r60
                r7 = r61
                r9 = r62
                goto L_0x021e
            L_0x0252:
                r4.<init>(r5, r6, r3)
                r3 = r4
            L_0x0256:
                org.json.JSONObject r0 = r1.optJSONObject(r2)
                if (r0 != 0) goto L_0x0262
                T3.b r0 = new T3.b
                r0.<init>()
                goto L_0x028f
            L_0x0262:
                java.lang.String r2 = "actionButtonSettings"
                org.json.JSONObject r2 = r0.optJSONObject(r2)
                T3.b r4 = new T3.b
                java.lang.String r5 = "countries"
                java.util.ArrayList r0 = q4.h.b(r0, r5)
                T3.a r5 = new T3.a
                if (r2 != 0) goto L_0x0277
                r6 = 0
                r7 = 0
                goto L_0x027e
            L_0x0277:
                java.lang.String r6 = "action1Enabled"
                r7 = 0
                boolean r6 = r2.optBoolean(r6, r7)
            L_0x027e:
                if (r2 != 0) goto L_0x0282
                r2 = r7
                goto L_0x0288
            L_0x0282:
                java.lang.String r8 = "action2Enabled"
                boolean r2 = r2.optBoolean(r8, r7)
            L_0x0288:
                r5.<init>(r6, r2)
                r4.<init>(r0, r5)
                r0 = r4
            L_0x028f:
                java.lang.String r2 = "translationUrls"
                org.json.JSONObject r2 = r1.getJSONObject(r2)
                java.lang.String r4 = "coreConfig.getJSONObject(\"translationUrls\")"
                kotlin.jvm.internal.t.d(r2, r4)
                java.lang.String r4 = "all"
                java.lang.String r4 = r2.optString(r4)
                java.lang.String r5 = "theme"
                java.lang.String r5 = r2.optString(r5)
                java.lang.String r6 = "common"
                java.lang.String r2 = r2.optString(r6)
                T3.m r6 = new T3.m
                r6.<init>(r2, r5, r4)
                java.lang.String r2 = "supportedLanguages"
                java.util.ArrayList r1 = q4.h.b(r1, r2)
                r4 = r52
                r52 = r3
                r3 = r4
                r33 = r34
                r34 = r35
                r35 = r36
                r36 = r40
                r40 = r42
                r42 = r47
                r47 = r48
                r48 = r51
                r4 = r53
                r5 = r54
                r51 = r56
                r7 = r57
                r8 = r58
                r9 = r62
                r53 = r0
                r54 = r6
                r6 = r55
                r55 = r1
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: q4.k.a():T3.c");
        }
    }
