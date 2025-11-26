package androidx.savedstate.serialization.serializers;

import H3.b;
import H3.j;
import H3.l;
import J3.f;
import K3.d;
import K3.e;
import L3.C0;
import L3.C2086f;
import L3.H0;
import L3.M;
import L3.R0;
import L3.W;
import W2.C2223l;
import W2.m;
import W2.p;
import android.annotation.SuppressLint;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class SparseArraySerializer<T> implements b {
    private final f descriptor;
    private final b surrogateSerializer;

    @SuppressLint({"UnsafeOptInUsageError"})
    @j
    private static final class SparseArraySurrogate<T> {
        private static final f $cachedDescriptor;
        /* access modifiers changed from: private */
        public static final C2223l[] $childSerializers = {m.a(p.PUBLICATION, new a()), null};
        public static final Companion Companion = new Companion((C2633k) null);
        private final List<Integer> keys;
        private final List<T> values;

        public static final class Companion {
            private Companion() {
            }

            public final <T> b serializer(b bVar) {
                t.e(bVar, "typeSerial0");
                return new SparseArraySerializer$SparseArraySurrogate$$serializer(bVar);
            }

            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }
        }

        static {
            H0 h02 = new H0("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", (M) null, 2);
            h02.o("keys", false);
            h02.o("values", false);
            $cachedDescriptor = h02;
        }

        public /* synthetic */ SparseArraySurrogate(int i5, List list, List list2, R0 r02) {
            if (3 != (i5 & 3)) {
                C0.a(i5, 3, $cachedDescriptor);
            }
            this.keys = list;
            this.values = list2;
        }

        /* access modifiers changed from: private */
        public static final /* synthetic */ b _childSerializers$_anonymous_() {
            return new C2086f(W.f18492a);
        }

        public static final /* synthetic */ void write$Self$savedstate_release(SparseArraySurrogate sparseArraySurrogate, d dVar, f fVar, b bVar) {
            dVar.encodeSerializableElement(fVar, 0, (l) $childSerializers[0].getValue(), sparseArraySurrogate.keys);
            dVar.encodeSerializableElement(fVar, 1, new C2086f(bVar), sparseArraySurrogate.values);
        }

        public final List<Integer> getKeys() {
            return this.keys;
        }

        public final List<T> getValues() {
            return this.values;
        }

        public SparseArraySurrogate(List<Integer> list, List<? extends T> list2) {
            t.e(list, "keys");
            t.e(list2, "values");
            this.keys = list;
            this.values = list2;
        }
    }

    public SparseArraySerializer(b bVar) {
        t.e(bVar, "elementSerializer");
        b serializer = SparseArraySurrogate.Companion.serializer(bVar);
        this.surrogateSerializer = serializer;
        this.descriptor = serializer.getDescriptor();
    }

    public f getDescriptor() {
        return this.descriptor;
    }

    public SparseArray<T> deserialize(e eVar) {
        t.e(eVar, "decoder");
        SparseArraySurrogate sparseArraySurrogate = (SparseArraySurrogate) eVar.decodeSerializableValue(this.surrogateSerializer);
        if (sparseArraySurrogate.getKeys().size() == sparseArraySurrogate.getValues().size()) {
            SparseArray<T> sparseArray = new SparseArray<>(sparseArraySurrogate.getKeys().size());
            int size = sparseArraySurrogate.getKeys().size();
            for (int i5 = 0; i5 < size; i5++) {
                sparseArray.append(sparseArraySurrogate.getKeys().get(i5).intValue(), sparseArraySurrogate.getValues().get(i5));
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public void serialize(K3.f fVar, SparseArray<T> sparseArray) {
        t.e(fVar, "encoder");
        t.e(sparseArray, "value");
        int size = sparseArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i5)));
        }
        int size2 = sparseArray.size();
        ArrayList arrayList2 = new ArrayList(size2);
        for (int i6 = 0; i6 < size2; i6++) {
            arrayList2.add(sparseArray.valueAt(i6));
        }
        fVar.encodeSerializableValue(this.surrogateSerializer, new SparseArraySurrogate(arrayList, arrayList2));
    }
}
