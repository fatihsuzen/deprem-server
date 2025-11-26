package j3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.C2630h;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import r3.C2733c;

/* renamed from: j3.a  reason: case insensitive filesystem */
public abstract class C2582a {
    public static final Class a(C2733c cVar) {
        t.e(cVar, "<this>");
        Class g5 = ((C2630h) cVar).g();
        t.c(g5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return g5;
    }

    public static final Class b(C2733c cVar) {
        t.e(cVar, "<this>");
        Class g5 = ((C2630h) cVar).g();
        if (!g5.isPrimitive()) {
            t.c(g5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return g5;
        }
        String name = g5.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    g5 = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    g5 = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    g5 = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    g5 = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    g5 = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    g5 = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    g5 = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals(TypedValues.Custom.S_FLOAT)) {
                    g5 = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    g5 = Short.class;
                    break;
                }
                break;
        }
        t.c(g5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return g5;
    }

    public static final C2733c c(Class cls) {
        t.e(cls, "<this>");
        return M.b(cls);
    }
}
