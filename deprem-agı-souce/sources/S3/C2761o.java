package s3;

import X2.C2250q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import k3.l;
import kotlin.jvm.internal.t;
import l3.C2677a;
import t3.s;

/* renamed from: s3.o  reason: case insensitive filesystem */
abstract class C2761o extends C2759m {

    /* renamed from: s3.o$a */
    public static final class a implements Iterable, C2677a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2751e f25843a;

        public a(C2751e eVar) {
            this.f25843a = eVar;
        }

        public Iterator iterator() {
            return this.f25843a.iterator();
        }
    }

    public static Iterable j(C2751e eVar) {
        t.e(eVar, "<this>");
        return new a(eVar);
    }

    public static boolean k(C2751e eVar, Object obj) {
        t.e(eVar, "<this>");
        if (q(eVar, obj) >= 0) {
            return true;
        }
        return false;
    }

    public static final C2751e l(C2751e eVar, l lVar) {
        t.e(eVar, "<this>");
        t.e(lVar, "predicate");
        return new C2749c(eVar, false, lVar);
    }

    public static final C2751e m(C2751e eVar) {
        t.e(eVar, "<this>");
        C2751e l5 = l(eVar, new C2760n());
        t.c(l5, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return l5;
    }

    /* access modifiers changed from: private */
    public static final boolean n(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    public static Object o(C2751e eVar) {
        t.e(eVar, "<this>");
        Iterator it = eVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static Object p(C2751e eVar) {
        t.e(eVar, "<this>");
        Iterator it = eVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    public static final int q(C2751e eVar, Object obj) {
        t.e(eVar, "<this>");
        int i5 = 0;
        for (Object next : eVar) {
            if (i5 < 0) {
                C2250q.o();
            }
            if (t.a(obj, next)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final Appendable r(C2751e eVar, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar) {
        t.e(eVar, "<this>");
        t.e(appendable, "buffer");
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i6 = 0;
        for (Object next : eVar) {
            i6++;
            if (i6 > 1) {
                appendable.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            s.a(appendable, next, lVar);
        }
        if (i5 >= 0 && i6 > i5) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String s(C2751e eVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar) {
        t.e(eVar, "<this>");
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        return ((StringBuilder) r(eVar, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
    }

    public static /* synthetic */ String t(C2751e eVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i6 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        l lVar2 = lVar;
        int i7 = i5;
        CharSequence charSequence6 = charSequence2;
        return s(eVar, charSequence, charSequence6, charSequence3, i7, charSequence5, lVar2);
    }

    public static Object u(C2751e eVar) {
        t.e(eVar, "<this>");
        Iterator it = eVar.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static C2751e v(C2751e eVar, l lVar) {
        t.e(eVar, "<this>");
        t.e(lVar, "transform");
        return new C2762p(eVar, lVar);
    }

    public static C2751e w(C2751e eVar, l lVar) {
        t.e(eVar, "<this>");
        t.e(lVar, "transform");
        return m(new C2762p(eVar, lVar));
    }

    public static List x(C2751e eVar) {
        t.e(eVar, "<this>");
        Iterator it = eVar.iterator();
        if (!it.hasNext()) {
            return C2250q.g();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return C2250q.d(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
