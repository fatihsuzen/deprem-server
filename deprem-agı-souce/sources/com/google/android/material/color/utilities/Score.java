package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Score {
    private static final int BLUE_500 = -12417548;
    private static final double CUTOFF_CHROMA = 5.0d;
    private static final double CUTOFF_EXCITED_PROPORTION = 0.01d;
    private static final int MAX_COLOR_COUNT = 4;
    private static final double TARGET_CHROMA = 48.0d;
    private static final double WEIGHT_CHROMA_ABOVE = 0.3d;
    private static final double WEIGHT_CHROMA_BELOW = 0.1d;
    private static final double WEIGHT_PROPORTION = 0.7d;

    private static class ScoredComparator implements Comparator<ScoredHCT> {
        public int compare(ScoredHCT scoredHCT, ScoredHCT scoredHCT2) {
            return Double.compare(scoredHCT2.score, scoredHCT.score);
        }
    }

    private static class ScoredHCT {
        public final Hct hct;
        public final double score;

        public ScoredHCT(Hct hct2, double d5) {
            this.hct = hct2;
            this.score = d5;
        }
    }

    private Score() {
    }

    public static List<Integer> score(Map<Integer, Integer> map) {
        return score(map, 4, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i5) {
        return score(map, i5, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i5, int i6) {
        return score(map, i5, i6, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i5, int i6, boolean z4) {
        int i7 = i5;
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[360];
        double d5 = 0.0d;
        for (Map.Entry next : map.entrySet()) {
            Hct fromInt = Hct.fromInt(((Integer) next.getKey()).intValue());
            arrayList.add(fromInt);
            int floor = (int) Math.floor(fromInt.getHue());
            int intValue = ((Integer) next.getValue()).intValue();
            iArr[floor] = iArr[floor] + intValue;
            d5 += (double) intValue;
        }
        double[] dArr = new double[360];
        int i8 = 0;
        for (int i9 = 0; i9 < 360; i9++) {
            double d6 = ((double) iArr[i9]) / d5;
            for (int i10 = i9 - 14; i10 < i9 + 16; i10++) {
                int sanitizeDegreesInt = MathUtils.sanitizeDegreesInt(i10);
                dArr[sanitizeDegreesInt] = dArr[sanitizeDegreesInt] + d6;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            Hct hct = (Hct) obj;
            double d7 = dArr[MathUtils.sanitizeDegreesInt((int) Math.round(hct.getHue()))];
            if (!z4 || (hct.getChroma() >= CUTOFF_CHROMA && d7 > CUTOFF_EXCITED_PROPORTION)) {
                arrayList2.add(new ScoredHCT(hct, (d7 * 100.0d * WEIGHT_PROPORTION) + ((hct.getChroma() - TARGET_CHROMA) * (hct.getChroma() < TARGET_CHROMA ? WEIGHT_CHROMA_BELOW : WEIGHT_CHROMA_ABOVE))));
            }
        }
        Collections.sort(arrayList2, new ScoredComparator());
        ArrayList arrayList3 = new ArrayList();
        for (int i12 = 90; i12 >= 15; i12--) {
            arrayList3.clear();
            int size2 = arrayList2.size();
            int i13 = 0;
            while (i13 < size2) {
                Object obj2 = arrayList2.get(i13);
                i13++;
                Hct hct2 = ((ScoredHCT) obj2).hct;
                int size3 = arrayList3.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size3) {
                        arrayList3.add(hct2);
                        break;
                    }
                    Object obj3 = arrayList3.get(i14);
                    i14++;
                    if (MathUtils.differenceDegrees(hct2.getHue(), ((Hct) obj3).getHue()) < ((double) i12)) {
                        break;
                    }
                }
                if (arrayList3.size() >= i7) {
                    break;
                }
            }
            if (arrayList3.size() >= i7) {
                break;
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList3.isEmpty()) {
            arrayList4.add(Integer.valueOf(i6));
            return arrayList4;
        }
        int size4 = arrayList3.size();
        while (i8 < size4) {
            Object obj4 = arrayList3.get(i8);
            i8++;
            arrayList4.add(Integer.valueOf(((Hct) obj4).toInt()));
        }
        return arrayList4;
    }
}
