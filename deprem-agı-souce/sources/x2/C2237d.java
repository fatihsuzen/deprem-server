package X2;

import java.util.AbstractCollection;
import java.util.Collection;
import l3.C2678b;

/* renamed from: X2.d  reason: case insensitive filesystem */
public abstract class C2237d extends AbstractCollection implements Collection, C2678b {
    protected C2237d() {
    }

    public abstract int c();

    public final /* bridge */ int size() {
        return c();
    }
}
