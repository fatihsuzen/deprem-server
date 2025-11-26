package androidx.savedstate.serialization.serializers;

import H3.a;
import H3.b;
import H3.w;
import J3.f;
import K3.c;
import K3.d;
import K3.e;
import L3.C2086f;
import L3.H0;
import L3.M;
import L3.R0;
import W2.C2223l;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import java.util.List;
import kotlin.jvm.internal.t;

public /* synthetic */ class SparseArraySerializer$SparseArraySurrogate$$serializer<T> implements M {
    private final f descriptor;
    private final /* synthetic */ b typeSerial0;

    private SparseArraySerializer$SparseArraySurrogate$$serializer() {
        H0 h02 = new H0("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", this, 2);
        h02.o("keys", false);
        h02.o("values", false);
        this.descriptor = h02;
    }

    private final /* synthetic */ b getTypeSerial0() {
        return this.typeSerial0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: H3.b[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final H3.b[] childSerializers() {
        /*
            r3 = this;
            W2.l[] r0 = androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate.$childSerializers
            r1 = 2
            H3.b[] r1 = new H3.b[r1]
            r2 = 0
            r0 = r0[r2]
            java.lang.Object r0 = r0.getValue()
            r1[r2] = r0
            L3.f r0 = new L3.f
            H3.b r2 = r3.typeSerial0
            r0.<init>(r2)
            r2 = 1
            r1[r2] = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.savedstate.serialization.serializers.SparseArraySerializer$SparseArraySurrogate$$serializer.childSerializers():H3.b[]");
    }

    public final SparseArraySerializer.SparseArraySurrogate<T> deserialize(e eVar) {
        int i5;
        List list;
        List list2;
        t.e(eVar, "decoder");
        f fVar = this.descriptor;
        c beginStructure = eVar.beginStructure(fVar);
        C2223l[] access$get$childSerializers$cp = SparseArraySerializer.SparseArraySurrogate.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            list2 = (List) beginStructure.decodeSerializableElement(fVar, 0, (a) access$get$childSerializers$cp[0].getValue(), (Object) null);
            list = (List) beginStructure.decodeSerializableElement(fVar, 1, new C2086f(this.typeSerial0), (Object) null);
            i5 = 3;
        } else {
            boolean z4 = true;
            int i6 = 0;
            List list3 = null;
            List list4 = null;
            while (z4) {
                int decodeElementIndex = beginStructure.decodeElementIndex(fVar);
                if (decodeElementIndex == -1) {
                    z4 = false;
                } else if (decodeElementIndex == 0) {
                    list3 = (List) beginStructure.decodeSerializableElement(fVar, 0, (a) access$get$childSerializers$cp[0].getValue(), list3);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    list4 = (List) beginStructure.decodeSerializableElement(fVar, 1, new C2086f(this.typeSerial0), list4);
                    i6 |= 2;
                } else {
                    throw new w(decodeElementIndex);
                }
            }
            list2 = list3;
            list = list4;
            i5 = i6;
        }
        beginStructure.endStructure(fVar);
        return new SparseArraySerializer.SparseArraySurrogate<>(i5, list2, list, (R0) null);
    }

    public final f getDescriptor() {
        return this.descriptor;
    }

    public final void serialize(K3.f fVar, SparseArraySerializer.SparseArraySurrogate<T> sparseArraySurrogate) {
        t.e(fVar, "encoder");
        t.e(sparseArraySurrogate, "value");
        f fVar2 = this.descriptor;
        d beginStructure = fVar.beginStructure(fVar2);
        SparseArraySerializer.SparseArraySurrogate.write$Self$savedstate_release(sparseArraySurrogate, beginStructure, fVar2, this.typeSerial0);
        beginStructure.endStructure(fVar2);
    }

    public final b[] typeParametersSerializers() {
        return new b[]{this.typeSerial0};
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SparseArraySerializer$SparseArraySurrogate$$serializer(b bVar) {
        this();
        t.e(bVar, "typeSerial0");
        this.typeSerial0 = bVar;
    }
}
