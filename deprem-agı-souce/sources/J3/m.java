package J3;

import J3.o;
import L3.O0;
import W2.J;
import X2.C2242i;
import k3.l;
import kotlin.jvm.internal.t;
import t3.s;

public abstract class m {
    public static final f c(String str, e eVar) {
        t.e(str, "serialName");
        t.e(eVar, "kind");
        if (!s.h0(str)) {
            return O0.a(str, eVar);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited");
    }

    public static final f d(String str, f fVar) {
        t.e(str, "serialName");
        t.e(fVar, "original");
        if (s.h0(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        } else if (fVar.getKind() instanceof e) {
            throw new IllegalArgumentException("For primitive descriptors please use 'PrimitiveSerialDescriptor' instead");
        } else if (!t.a(str, fVar.a())) {
            return new p(str, fVar);
        } else {
            throw new IllegalArgumentException(("The name of the wrapped descriptor (" + str + ") cannot be the same as the name of the original descriptor (" + fVar.a() + ')').toString());
        }
    }

    public static final f e(String str, f[] fVarArr, l lVar) {
        t.e(str, "serialName");
        t.e(fVarArr, "typeParameters");
        t.e(lVar, "builderAction");
        if (!s.h0(str)) {
            a aVar = new a(str);
            lVar.invoke(aVar);
            return new i(str, o.a.f18390a, aVar.f().size(), C2242i.q0(fVarArr), aVar);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited");
    }

    public static /* synthetic */ f f(String str, f[] fVarArr, l lVar, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            new k
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r2v2 ? I:J3.k) =  call: J3.k.<init>():void type: CONSTRUCTOR in method: J3.m.f(java.lang.String, J3.f[], k3.l, int, java.lang.Object):J3.f, dex: classes4.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v2 ?
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	... 34 more
                */
            /*
                r3 = r3 & 4
                if (r3 == 0) goto L_0x0009
                J3.k r2 = new J3.k
                r2.<init>()
            L_0x0009:
                J3.f r0 = e(r0, r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.m.f(java.lang.String, J3.f[], k3.l, int, java.lang.Object):J3.f");
        }

        /* access modifiers changed from: private */
        public static final J g(a aVar) {
            t.e(aVar, "<this>");
            return J.f19942a;
        }

        public static final f h(String str, n nVar, f[] fVarArr, l lVar) {
            t.e(str, "serialName");
            t.e(nVar, "kind");
            t.e(fVarArr, "typeParameters");
            t.e(lVar, "builder");
            if (s.h0(str)) {
                throw new IllegalArgumentException("Blank serial names are prohibited");
            } else if (!t.a(nVar, o.a.f18390a)) {
                a aVar = new a(str);
                lVar.invoke(aVar);
                return new i(str, nVar, aVar.f().size(), C2242i.q0(fVarArr), aVar);
            } else {
                throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
            }
        }

        public static /* synthetic */ f i(String str, n nVar, f[] fVarArr, l lVar, int i5, Object obj) {
            if ((i5 & 8) != 0) {
                new l
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r3v2 ? I:J3.l) =  call: J3.l.<init>():void type: CONSTRUCTOR in method: J3.m.i(java.lang.String, J3.n, J3.f[], k3.l, int, java.lang.Object):J3.f, dex: classes4.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r3v2 ?
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 34 more
                    */
                /*
                    r4 = r4 & 8
                    if (r4 == 0) goto L_0x0009
                    J3.l r3 = new J3.l
                    r3.<init>()
                L_0x0009:
                    J3.f r0 = h(r0, r1, r2, r3)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: J3.m.i(java.lang.String, J3.n, J3.f[], k3.l, int, java.lang.Object):J3.f");
            }

            /* access modifiers changed from: private */
            public static final J j(a aVar) {
                t.e(aVar, "<this>");
                return J.f19942a;
            }
        }
