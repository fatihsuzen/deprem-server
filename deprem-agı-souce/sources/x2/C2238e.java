package X2;

import java.util.AbstractList;
import java.util.List;
import l3.C2678b;

/* renamed from: X2.e  reason: case insensitive filesystem */
public abstract class C2238e extends AbstractList implements List, C2678b {
    protected C2238e() {
    }

    public abstract int c();

    public abstract Object f(int i5);

    public final /* bridge */ Object remove(int i5) {
        return f(i5);
    }

    public final /* bridge */ int size() {
        return c();
    }
}
