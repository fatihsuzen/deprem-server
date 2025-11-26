package N3;

import J3.f;
import W2.C2219h;
import kotlin.jvm.internal.t;
import q3.C2729e;

public abstract class z {
    public static final C2151v a(Number number, String str, String str2) {
        t.e(number, "value");
        t.e(str, "key");
        t.e(str2, "output");
        return d(-1, l(number, str, str2));
    }

    public static final x b(Number number, String str) {
        t.e(number, "value");
        t.e(str, "output");
        return new x("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + j(str, 0, 1, (Object) null));
    }

    public static final x c(f fVar) {
        t.e(fVar, "keyDescriptor");
        return new x("Value of type '" + fVar.a() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + fVar.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final C2151v d(int i5, String str) {
        t.e(str, "message");
        if (i5 >= 0) {
            str = "Unexpected JSON token at offset " + i5 + ": " + str;
        }
        return new C2151v(str);
    }

    public static final C2151v e(int i5, String str, CharSequence charSequence) {
        t.e(str, "message");
        t.e(charSequence, "input");
        return d(i5, str + "\nJSON input: " + i(charSequence, i5));
    }

    public static final C2151v f(String str, String str2) {
        t.e(str, "key");
        t.e(str2, "input");
        return d(-1, "Encountered an unknown key '" + str + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + j(str2, 0, 1, (Object) null));
    }

    public static final Void g(C2131a aVar, String str) {
        t.e(aVar, "<this>");
        t.e(str, "entity");
        aVar.w("Trailing comma before the end of JSON " + str, aVar.f18775a - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw new C2219h();
    }

    public static /* synthetic */ Void h(C2131a aVar, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = "object";
        }
        return g(aVar, str);
    }

    public static final CharSequence i(CharSequence charSequence, int i5) {
        String str;
        t.e(charSequence, "<this>");
        if (charSequence.length() >= 200) {
            String str2 = ".....";
            if (i5 == -1) {
                int length = charSequence.length() - 60;
                if (length > 0) {
                    return str2 + charSequence.subSequence(length, charSequence.length()).toString();
                }
            } else {
                int i6 = i5 - 30;
                int i7 = i5 + 30;
                if (i6 <= 0) {
                    str = "";
                } else {
                    str = str2;
                }
                if (i7 >= charSequence.length()) {
                    str2 = "";
                }
                return str + charSequence.subSequence(C2729e.c(i6, 0), C2729e.e(i7, charSequence.length())).toString() + str2;
            }
        }
        return charSequence;
    }

    public static /* synthetic */ CharSequence j(CharSequence charSequence, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = -1;
        }
        return i(charSequence, i5);
    }

    public static final Void k(C2131a aVar, Number number) {
        t.e(aVar, "<this>");
        t.e(number, "result");
        C2131a.x(aVar, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2, (Object) null);
        throw new C2219h();
    }

    private static final String l(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + j(str2, 0, 1, (Object) null);
    }
}
