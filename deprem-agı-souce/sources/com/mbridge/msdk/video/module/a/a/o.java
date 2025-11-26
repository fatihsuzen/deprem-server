package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.module.a.a.k;
import com.mbridge.msdk.video.module.b.b;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.util.Map;

public class o extends k {

    /* renamed from: k  reason: collision with root package name */
    protected int f12618k = 0;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12619l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f12620m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12621n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f12622o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12623p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12624q = false;

    /* renamed from: r  reason: collision with root package name */
    private Map<Integer, String> f12625r;

    /* renamed from: s  reason: collision with root package name */
    private MBridgeVideoView.a f12626s;

    /* renamed from: t  reason: collision with root package name */
    private int f12627t = -1;

    public o(CampaignEx campaignEx, c cVar, a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i5, boolean z4) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i5, z4);
        if (this.f12581a) {
            this.f12625r = campaignEx.getAdvImpList();
        }
        this.f12618k = campaignEx.getVideoCompleteTime();
    }

    public void a(int i5, final Object obj) {
        int i6;
        CampaignEx campaignEx;
        if (i5 != 2) {
            int i7 = 0;
            if (i5 != 20) {
                if (i5 != 130) {
                    if (i5 != 6) {
                        if (i5 != 7) {
                            if (i5 == 15) {
                                g();
                                f();
                                e();
                                if (ah.a().a("i_l_s_t_r_i", false) && !this.f12622o) {
                                    this.f12622o = true;
                                    MBridgeVideoView.a aVar = this.f12626s;
                                    if (aVar != null) {
                                        aVar.a();
                                    }
                                }
                                if (obj == null || !(obj instanceof MBridgeVideoView.b)) {
                                    i6 = 0;
                                } else {
                                    int i8 = ((MBridgeVideoView.b) obj).f12549a;
                                    i7 = ((MBridgeVideoView.b) obj).f12550b;
                                    i6 = i8;
                                }
                                if (i7 == 0 && (campaignEx = this.f12582b) != null) {
                                    i7 = campaignEx.getVideoLength();
                                }
                                b.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f12582b, i6, i7, this.f12590j);
                                b.a(this.f12582b, this.f12625r, this.f12587g, i6);
                                if (!this.f12623p) {
                                    this.f12623p = true;
                                    b.a(this.f12582b, this.f12587g);
                                }
                                if (!this.f12624q) {
                                    int i9 = this.f12618k;
                                    if (i9 != 0) {
                                        i7 = i9;
                                    }
                                    if (i6 >= i7) {
                                        this.f12624q = true;
                                        i5 = 17;
                                    }
                                }
                                af.b("NotifyListener", "onPlayProgress:" + i6);
                                this.f12627t = i6;
                            } else if (i5 != 16) {
                                switch (i5) {
                                    case 11:
                                        com.mbridge.msdk.videocommon.download.b.getInstance().b(false);
                                        d();
                                        break;
                                    case 12:
                                        AnonymousClass1 r12 = new Runnable() {
                                            public final void run() {
                                                Object obj = obj;
                                                if (obj instanceof String) {
                                                    o.this.a((String) obj);
                                                }
                                            }
                                        };
                                        d.a();
                                        com.mbridge.msdk.foundation.same.f.a.b().execute(r12);
                                        d();
                                        b();
                                        c();
                                        k.AnonymousClass4 r13 = new Runnable() {
                                            public final void run(
/*
Method generation error in method: com.mbridge.msdk.video.module.a.a.k.4.run():void, dex: classes3.dex
                                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.mbridge.msdk.video.module.a.a.k.4.run():void, class status: UNLOADED
                                            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
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
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:298)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                            
*/
                                        };
                                        d.a();
                                        com.mbridge.msdk.foundation.same.f.a.b().execute(r13);
                                        com.mbridge.msdk.videocommon.download.b.getInstance().b(false);
                                        break;
                                    case 13:
                                        try {
                                            b();
                                            c();
                                            break;
                                        } catch (Throwable th) {
                                            af.b("NotifyListener", th.getMessage(), th);
                                            return;
                                        }
                                }
                            }
                        } else if (this.f12581a && obj != null && (obj instanceof Integer)) {
                            int intValue = ((Integer) obj).intValue();
                            if (intValue == 2) {
                                if (!this.f12620m) {
                                    this.f12620m = true;
                                    b.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f12582b);
                                }
                            } else if (intValue == 1 && !this.f12619l) {
                                this.f12619l = true;
                                b.c(com.mbridge.msdk.foundation.controller.c.m().c(), this.f12582b);
                            }
                        }
                    }
                } else if (obj instanceof Integer) {
                    this.f12618k = ((Integer) obj).intValue();
                }
            } else if (ah.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.a)) {
                this.f12626s = (MBridgeVideoView.a) obj;
            }
            this.f12589i.a(i5, obj);
        }
        if (this.f12581a && !this.f12621n) {
            this.f12621n = true;
            d();
            b.e(com.mbridge.msdk.foundation.controller.c.m().c(), this.f12582b);
        }
        this.f12589i.a(i5, obj);
    }
}
