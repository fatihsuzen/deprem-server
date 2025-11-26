package M3;

import H3.b;
import H3.j;
import X2.C2250q;
import j$.lang.Iterable$CC;
import j$.util.Collection;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import k3.l;
import kotlin.jvm.internal.C2632j;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l3.C2677a;

@j(with = C2130d.class)
/* renamed from: M3.c  reason: case insensitive filesystem */
public final class C2129c extends h implements List<h>, C2677a, j$.util.List {
    public static final a Companion = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final List f18669a;

    /* renamed from: M3.c$a */
    public static final class a {
        private a() {
        }

        public final b serializer() {
            return C2130d.f18670a;
        }

        public /* synthetic */ a(C2633k kVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2129c(List list) {
        super((C2633k) null);
        t.e(list, "content");
        this.f18669a = list;
    }

    public /* bridge */ /* synthetic */ void add(int i5, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int i5, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean c(h hVar) {
        t.e(hVar, "element");
        return this.f18669a.contains(hVar);
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        return c((h) obj);
    }

    public boolean containsAll(Collection collection) {
        t.e(collection, "elements");
        return this.f18669a.containsAll(collection);
    }

    public boolean equals(Object obj) {
        return t.a(this.f18669a, obj);
    }

    /* renamed from: f */
    public h get(int i5) {
        return (h) this.f18669a.get(i5);
    }

    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable$CC.$default$forEach(this, consumer);
    }

    public int g() {
        return this.f18669a.size();
    }

    public int hashCode() {
        return this.f18669a.hashCode();
    }

    public int i(h hVar) {
        t.e(hVar, "element");
        return this.f18669a.indexOf(hVar);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof h)) {
            return -1;
        }
        return i((h) obj);
    }

    public boolean isEmpty() {
        return this.f18669a.isEmpty();
    }

    public Iterator iterator() {
        return this.f18669a.iterator();
    }

    public int j(h hVar) {
        t.e(hVar, "element");
        return this.f18669a.lastIndexOf(hVar);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof h)) {
            return -1;
        }
        return j((h) obj);
    }

    public ListIterator listIterator() {
        return this.f18669a.listIterator();
    }

    public /* bridge */ /* synthetic */ Object remove(int i5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.CC.$default$removeIf(this, predicate);
    }

    public void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(java.util.Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object set(int i5, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return g();
    }

    public void sort(Comparator comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List subList(int i5, int i6) {
        return this.f18669a.subList(i5, i6);
    }

    public Object[] toArray() {
        return C2632j.a(this);
    }

    public String toString() {
        return C2250q.V(this.f18669a, ",", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(java.util.Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public ListIterator listIterator(int i5) {
        return this.f18669a.listIterator(i5);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.CC.$default$toArray(this, intFunction);
    }

    public Object[] toArray(Object[] objArr) {
        t.e(objArr, "array");
        return C2632j.b(this, objArr);
    }
}
