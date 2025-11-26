package androidx.room;

import X2.C2250q;
import X2.J;
import X2.T;
import androidx.annotation.RestrictTo;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import k3.l;
import k3.q;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import q3.C2728d;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class AmbiguousColumnResolver {
    public static final AmbiguousColumnResolver INSTANCE = new AmbiguousColumnResolver();

    private static final class Match {
        private final List<Integer> resultIndices;
        private final C2728d resultRange;

        public Match(C2728d dVar, List<Integer> list) {
            t.e(dVar, "resultRange");
            t.e(list, "resultIndices");
            this.resultRange = dVar;
            this.resultIndices = list;
        }

        public final List<Integer> getResultIndices() {
            return this.resultIndices;
        }

        public final C2728d getResultRange() {
            return this.resultRange;
        }
    }

    private static final class ResultColumn {
        private final int index;
        private final String name;

        public ResultColumn(String str, int i5) {
            t.e(str, RewardPlus.NAME);
            this.name = str;
            this.index = i5;
        }

        public static /* synthetic */ ResultColumn copy$default(ResultColumn resultColumn, String str, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                str = resultColumn.name;
            }
            if ((i6 & 2) != 0) {
                i5 = resultColumn.index;
            }
            return resultColumn.copy(str, i5);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.index;
        }

        public final ResultColumn copy(String str, int i5) {
            t.e(str, RewardPlus.NAME);
            return new ResultColumn(str, i5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return t.a(this.name, resultColumn.name) && this.index == resultColumn.index;
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.index;
        }

        public String toString() {
            return "ResultColumn(name=" + this.name + ", index=" + this.index + ')';
        }
    }

    private static final class Solution implements Comparable<Solution> {
        public static final Companion Companion = new Companion((C2633k) null);
        /* access modifiers changed from: private */
        public static final Solution NO_SOLUTION = new Solution(C2250q.g(), Integer.MAX_VALUE, Integer.MAX_VALUE);
        private final int coverageOffset;
        private final List<Match> matches;
        private final int overlaps;

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final Solution build(List<Match> list) {
                t.e(list, "matches");
                Iterable<Match> iterable = list;
                int i5 = 0;
                int i6 = 0;
                for (Match match : iterable) {
                    i6 += ((match.getResultRange().f() - match.getResultRange().c()) + 1) - match.getResultIndices().size();
                }
                Iterator it = iterable.iterator();
                if (it.hasNext()) {
                    int c5 = ((Match) it.next()).getResultRange().c();
                    while (it.hasNext()) {
                        int c6 = ((Match) it.next()).getResultRange().c();
                        if (c5 > c6) {
                            c5 = c6;
                        }
                    }
                    Iterator it2 = iterable.iterator();
                    if (it2.hasNext()) {
                        int f5 = ((Match) it2.next()).getResultRange().f();
                        while (it2.hasNext()) {
                            int f6 = ((Match) it2.next()).getResultRange().f();
                            if (f5 < f6) {
                                f5 = f6;
                            }
                        }
                        C2728d dVar = new C2728d(c5, f5);
                        if (!(dVar instanceof Collection) || !((Collection) dVar).isEmpty()) {
                            Iterator it3 = dVar.iterator();
                            int i7 = 0;
                            while (it3.hasNext()) {
                                int nextInt = ((J) it3).nextInt();
                                Iterator it4 = iterable.iterator();
                                int i8 = 0;
                                while (true) {
                                    if (!it4.hasNext()) {
                                        break;
                                    }
                                    if (((Match) it4.next()).getResultRange().k(nextInt)) {
                                        i8++;
                                        continue;
                                    }
                                    if (i8 > 1) {
                                        i7++;
                                        if (i7 < 0) {
                                            C2250q.n();
                                        }
                                    }
                                }
                            }
                            i5 = i7;
                        }
                        return new Solution(list, i6, i5);
                    }
                    throw new NoSuchElementException();
                }
                throw new NoSuchElementException();
            }

            public final Solution getNO_SOLUTION() {
                return Solution.NO_SOLUTION;
            }

            private Companion() {
            }
        }

        public Solution(List<Match> list, int i5, int i6) {
            t.e(list, "matches");
            this.matches = list;
            this.coverageOffset = i5;
            this.overlaps = i6;
        }

        public final int getCoverageOffset() {
            return this.coverageOffset;
        }

        public final List<Match> getMatches() {
            return this.matches;
        }

        public final int getOverlaps() {
            return this.overlaps;
        }

        public int compareTo(Solution solution) {
            t.e(solution, "other");
            int g5 = t.g(this.overlaps, solution.overlaps);
            if (g5 != 0) {
                return g5;
            }
            return t.g(this.coverageOffset, solution.coverageOffset);
        }
    }

    private AmbiguousColumnResolver() {
    }

    private final <T> void dfs(List<? extends List<? extends T>> list, List<T> list2, int i5, l lVar) {
        if (i5 == list.size()) {
            lVar.invoke(C2250q.n0(list2));
            return;
        }
        for (Object add : (Iterable) list.get(i5)) {
            list2.add(add);
            INSTANCE.dfs(list, list2, i5 + 1, lVar);
            list2.remove(C2250q.i(list2));
        }
    }

    static /* synthetic */ void dfs$default(AmbiguousColumnResolver ambiguousColumnResolver, List list, List list2, int i5, l lVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            list2 = new ArrayList();
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        ambiguousColumnResolver.dfs(list, list2, i5, lVar);
    }

    private final void rabinKarpSearch(List<ResultColumn> list, String[] strArr, q qVar) {
        int i5 = 0;
        int i6 = 0;
        for (String hashCode : strArr) {
            i6 += hashCode.hashCode();
        }
        int length = strArr.length;
        int i7 = 0;
        for (ResultColumn name : list.subList(0, length)) {
            i7 += name.getName().hashCode();
        }
        while (true) {
            if (i6 == i7) {
                qVar.invoke(Integer.valueOf(i5), Integer.valueOf(length), list.subList(i5, length));
            }
            int i8 = i5 + 1;
            int i9 = length + 1;
            if (i9 <= list.size()) {
                i7 = (i7 - list.get(i5).getName().hashCode()) + list.get(length).getName().hashCode();
                i5 = i8;
                length = i9;
            } else {
                return;
            }
        }
    }

    public static final int[][] resolve(List<String> list, String[][] strArr) {
        t.e(list, "resultColumns");
        t.e(strArr, "mappings");
        return resolve((String[]) list.toArray(new String[0]), strArr);
    }

    /* access modifiers changed from: private */
    public static final W2.J resolve$lambda$16$lambda$15(List list, int i5, List list2) {
        t.e(list2, "indices");
        Iterable iterable = list2;
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            while (it.hasNext()) {
                int intValue2 = ((Number) it.next()).intValue();
                if (intValue > intValue2) {
                    intValue = intValue2;
                }
            }
            Iterator it2 = iterable.iterator();
            if (it2.hasNext()) {
                int intValue3 = ((Number) it2.next()).intValue();
                while (it2.hasNext()) {
                    int intValue4 = ((Number) it2.next()).intValue();
                    if (intValue3 < intValue4) {
                        intValue3 = intValue4;
                    }
                }
                ((List) list.get(i5)).add(new Match(new C2728d(intValue, intValue3), list2));
                return W2.J.f19942a;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: private */
    public static final W2.J resolve$lambda$16$lambda$7(String[] strArr, List list, int i5, int i6, int i7, List list2) {
        Object obj;
        t.e(list2, "resultColumnsSublist");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (t.a(str, ((ResultColumn) obj).component1())) {
                    break;
                }
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            if (resultColumn == null) {
                return W2.J.f19942a;
            }
            arrayList.add(Integer.valueOf(resultColumn.getIndex()));
        }
        ((List) list.get(i5)).add(new Match(new C2728d(i6, i7 - 1), arrayList));
        return W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final W2.J resolve$lambda$19(L l5, List list) {
        t.e(list, "it");
        Solution build = Solution.Companion.build(list);
        if (build.compareTo((Solution) l5.f24690a) < 0) {
            l5.f24690a = build;
        }
        return W2.J.f19942a;
    }

    public static final int[][] resolve(String[] strArr, String[][] strArr2) {
        String[] strArr3 = strArr;
        String[][] strArr4 = strArr2;
        t.e(strArr3, "resultColumns");
        t.e(strArr4, "mappings");
        int length = strArr3.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            String str = strArr3[i6];
            if (str.charAt(0) == '`' && str.charAt(str.length() - 1) == '`') {
                str = str.substring(1, str.length() - 1);
                t.d(str, "substring(...)");
            }
            String lowerCase = str.toLowerCase(Locale.ROOT);
            t.d(lowerCase, "toLowerCase(...)");
            strArr3[i6] = lowerCase;
        }
        int length2 = strArr4.length;
        for (int i7 = 0; i7 < length2; i7++) {
            int length3 = strArr4[i7].length;
            for (int i8 = 0; i8 < length3; i8++) {
                String[] strArr5 = strArr4[i7];
                String lowerCase2 = strArr5[i8].toLowerCase(Locale.ROOT);
                t.d(lowerCase2, "toLowerCase(...)");
                strArr5[i8] = lowerCase2;
            }
        }
        Set b5 = T.b();
        for (String[] v5 : strArr4) {
            C2250q.v(b5, v5);
        }
        Set a5 = T.a(b5);
        List c5 = C2250q.c();
        int length4 = strArr3.length;
        int i9 = 0;
        int i10 = 0;
        while (i9 < length4) {
            String str2 = strArr3[i9];
            int i11 = i10 + 1;
            if (a5.contains(str2)) {
                c5.add(new ResultColumn(str2, i10));
            }
            i9++;
            i10 = i11;
        }
        List<ResultColumn> a6 = C2250q.a(c5);
        int length5 = strArr4.length;
        ArrayList arrayList = new ArrayList(length5);
        for (int i12 = 0; i12 < length5; i12++) {
            arrayList.add(new ArrayList());
        }
        int length6 = strArr4.length;
        int i13 = 0;
        int i14 = 0;
        while (i13 < length6) {
            String[] strArr6 = strArr4[i13];
            int i15 = i14 + 1;
            INSTANCE.rabinKarpSearch(a6, strArr6, new a(strArr6, arrayList, i14));
            if (((List) arrayList.get(i14)).isEmpty()) {
                ArrayList arrayList2 = new ArrayList(strArr6.length);
                int length7 = strArr6.length;
                int i16 = i5;
                while (i16 < length7) {
                    String str3 = strArr6[i16];
                    List c6 = C2250q.c();
                    for (ResultColumn resultColumn : a6) {
                        if (t.a(str3, resultColumn.getName())) {
                            c6.add(Integer.valueOf(resultColumn.getIndex()));
                        }
                    }
                    List a7 = C2250q.a(c6);
                    if (!a7.isEmpty()) {
                        arrayList2.add(a7);
                        i16++;
                    } else {
                        throw new IllegalStateException(("Column " + str3 + " not found in result").toString());
                    }
                }
                dfs$default(INSTANCE, arrayList2, (List) null, 0, new b(arrayList, i14), 6, (Object) null);
            }
            i13++;
            i14 = i15;
            i5 = 0;
        }
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i17 = 0;
            while (i17 < size) {
                Object obj = arrayList.get(i17);
                i17++;
                if (((List) obj).isEmpty()) {
                    throw new IllegalStateException("Failed to find matches for all mappings");
                }
            }
        }
        L l5 = new L();
        l5.f24690a = Solution.Companion.getNO_SOLUTION();
        dfs$default(INSTANCE, arrayList, (List) null, 0, new c(l5), 6, (Object) null);
        Iterable<Match> matches = ((Solution) l5.f24690a).getMatches();
        ArrayList arrayList3 = new ArrayList(C2250q.p(matches, 10));
        for (Match resultIndices : matches) {
            arrayList3.add(C2250q.m0(resultIndices.getResultIndices()));
        }
        return (int[][]) arrayList3.toArray(new int[0][]);
    }
}
