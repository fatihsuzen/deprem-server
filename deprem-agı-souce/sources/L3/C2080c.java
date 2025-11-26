package L3;

import H3.k;
import W2.C2219h;
import kotlin.jvm.internal.t;
import r3.C2733c;

/* renamed from: L3.c  reason: case insensitive filesystem */
public abstract class C2080c {
    public static final Void a(String str, C2733c cVar) {
        String str2;
        t.e(cVar, "baseClass");
        String str3 = "in the polymorphic scope of '" + cVar.c() + '\'';
        if (str == null) {
            str2 = "Class discriminator was missing and no default serializers were registered " + str3 + '.';
        } else {
            str2 = "Serializer for subclass '" + str + "' is not found " + str3 + ".\nCheck if class with serial name '" + str + "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '" + str + "' has to be '@Serializable', and the base class '" + cVar.c() + "' has to be sealed and '@Serializable'.";
        }
        throw new k(str2);
    }

    public static final Void b(C2733c cVar, C2733c cVar2) {
        t.e(cVar, "subClass");
        t.e(cVar2, "baseClass");
        String c5 = cVar.c();
        if (c5 == null) {
            c5 = String.valueOf(cVar);
        }
        a(c5, cVar2);
        throw new C2219h();
    }
}
