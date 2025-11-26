package j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

public final class T extends s0 {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ SortedSet f1277f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public T(SortedSet sortedSet, Collection collection) {
        super(21, collection);
        this.f1277f = sortedSet;
    }

    public final Comparator getComparator() {
        return this.f1277f.comparator();
    }
}
