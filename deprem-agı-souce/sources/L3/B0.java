package L3;

import H3.k;
import J3.f;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;
import r3.C2733c;
import r3.C2734d;
import r3.C2743m;
import r3.n;

public abstract class B0 {

    /* renamed from: a  reason: collision with root package name */
    private static final f[] f18427a = new f[0];

    public static final Set a(f fVar) {
        t.e(fVar, "<this>");
        if (fVar instanceof C2102n) {
            return ((C2102n) fVar).b();
        }
        HashSet hashSet = new HashSet(fVar.e());
        int e5 = fVar.e();
        for (int i5 = 0; i5 < e5; i5++) {
            hashSet.add(fVar.f(i5));
        }
        return hashSet;
    }

    public static final f[] b(List list) {
        f[] fVarArr;
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            list = null;
        }
        if (list == null || (fVarArr = (f[]) list.toArray(new f[0])) == null) {
            return f18427a;
        }
        return fVarArr;
    }

    public static final C2733c c(C2743m mVar) {
        t.e(mVar, "<this>");
        C2734d e5 = mVar.e();
        if (e5 instanceof C2733c) {
            return (C2733c) e5;
        }
        throw new IllegalArgumentException("Only KClass supported as classifier, got " + e5);
    }

    public static final String d(String str) {
        t.e(str, "className");
        return "Serializer for class '" + str + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n";
    }

    public static final String e(C2733c cVar) {
        t.e(cVar, "<this>");
        String c5 = cVar.c();
        if (c5 == null) {
            c5 = "<local class name not available>";
        }
        return d(c5);
    }

    public static final Void f(C2733c cVar) {
        t.e(cVar, "<this>");
        throw new k(e(cVar));
    }

    public static final C2743m g(n nVar) {
        t.e(nVar, "<this>");
        throw null;
    }
}
