package R3;

import W2.J;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.p;
import kotlin.jvm.internal.u;

public final class k extends u implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f19020a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(LinkedHashMap linkedHashMap) {
        super(2);
        this.f19020a = linkedHashMap;
    }

    public final Object invoke(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        Boolean bool = (Boolean) obj2;
        bool.booleanValue();
        this.f19020a.put(String.valueOf(intValue), bool);
        return J.f19942a;
    }
}
