package q;

import android.util.SparseArray;

public enum x {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);
    

    /* renamed from: h  reason: collision with root package name */
    private static final SparseArray f15878h = null;

    /* renamed from: a  reason: collision with root package name */
    private final int f15880a;

    static {
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        x xVar5;
        x xVar6;
        SparseArray sparseArray = new SparseArray();
        f15878h = sparseArray;
        sparseArray.put(0, xVar);
        sparseArray.put(1, xVar2);
        sparseArray.put(2, xVar3);
        sparseArray.put(3, xVar4);
        sparseArray.put(4, xVar5);
        sparseArray.put(-1, xVar6);
    }

    private x(int i5) {
        this.f15880a = i5;
    }
}
