package m;

import W2.J;
import W2.s;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import k3.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

public final class h extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f956a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(ArrayList arrayList) {
        super(2);
        this.f956a = arrayList;
    }

    public final Object invoke(Object obj, Object obj2) {
        String str;
        int intValue = ((Number) obj).intValue();
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        List list = this.f956a;
        Integer valueOf = Integer.valueOf(intValue);
        if (booleanValue) {
            str = GBCConsentValue.GRANTED.getValue().toLowerCase(Locale.ROOT);
            t.d(str, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        } else {
            str = GBCConsentValue.DENIED.getValue().toLowerCase(Locale.ROOT);
            t.d(str, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        list.add(new s(valueOf, str));
        return J.f19942a;
    }
}
