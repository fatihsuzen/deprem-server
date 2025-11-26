package N3;

import H3.i;
import H3.l;
import J3.d;
import J3.e;
import J3.f;
import J3.n;
import L3.X;
import M3.C2128b;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.t;

public abstract class K {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18742a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                M3.a[] r0 = M3.C2127a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                M3.a r1 = M3.C2127a.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                M3.a r1 = M3.C2127a.POLYMORPHIC     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                M3.a r1 = M3.C2127a.ALL_JSON_OBJECTS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f18742a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: N3.K.a.<clinit>():void");
        }
    }

    public static final void b(n nVar) {
        t.e(nVar, "kind");
        if (nVar instanceof n.b) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        } else if (nVar instanceof e) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        } else if (nVar instanceof d) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself");
        }
    }

    public static final String c(f fVar, C2128b bVar) {
        t.e(fVar, "<this>");
        t.e(bVar, "json");
        for (Annotation annotation : fVar.getAnnotations()) {
            if (annotation instanceof M3.e) {
                return ((M3.e) annotation).discriminator();
            }
        }
        return bVar.c().e();
    }

    /* access modifiers changed from: private */
    public static final void d(l lVar, l lVar2, String str) {
        if ((lVar instanceof i) && X.a(lVar2.getDescriptor()).contains(str)) {
            android.support.v4.media.a.a(lVar);
            throw null;
        }
    }
}
