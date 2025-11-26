package L2;

import W2.J;
import k3.p;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;
import t3.s;

public final class c extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f18403a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(L l5) {
        super(2);
        this.f18403a = l5;
    }

    public final Object invoke(Object obj, Object obj2) {
        char c5;
        int intValue = ((Number) obj).intValue();
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        if (intValue > 0 && intValue <= s.Z((CharSequence) this.f18403a.f24690a) + 1) {
            L l5 = this.f18403a;
            StringBuilder sb = new StringBuilder((String) l5.f24690a);
            int i5 = intValue - 1;
            if (booleanValue) {
                c5 = '1';
            } else {
                c5 = '0';
            }
            sb.setCharAt(i5, c5);
            String sb2 = sb.toString();
            t.d(sb2, "StringBuilder(result).ap…             }.toString()");
            l5.f24690a = sb2;
        }
        return J.f19942a;
    }
}
