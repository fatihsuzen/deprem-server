package t3;

import k3.l;

abstract class t {
    public static void a(Appendable appendable, Object obj, l lVar) {
        boolean z4;
        kotlin.jvm.internal.t.e(appendable, "<this>");
        if (lVar != null) {
            appendable.append((CharSequence) lVar.invoke(obj));
            return;
        }
        if (obj == null) {
            z4 = true;
        } else {
            z4 = obj instanceof CharSequence;
        }
        if (z4) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(obj.toString());
        }
    }
}
