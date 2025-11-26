package J2;

import X2.C2242i;
import com.inmobi.cmp.core.model.Vector;
import java.util.List;

public abstract class e {
    public static List a(int i5, Vector vector) {
        boolean[] zArr = new boolean[i5];
        for (Number intValue : vector.getAcceptedItems()) {
            int intValue2 = intValue.intValue();
            if (1 <= intValue2 && intValue2 < i5 + 1) {
                zArr[intValue2 - 1] = true;
            }
        }
        return C2242i.r0(zArr);
    }
}
