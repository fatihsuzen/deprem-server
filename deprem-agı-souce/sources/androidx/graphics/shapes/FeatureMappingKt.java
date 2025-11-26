package androidx.graphics.shapes;

import W2.s;
import W2.y;
import X2.C2250q;
import X2.J;
import androidx.graphics.shapes.Feature;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import q3.C2728d;

public final class FeatureMappingKt {
    private static final String LOG_TAG = "FeatureMapping";

    public static final List<ProgressableFeature> doMapping(List<ProgressableFeature> list, List<ProgressableFeature> list2) {
        t.e(list, "f1");
        t.e(list2, "f2");
        Iterator it = C2250q.h(list2).iterator();
        if (it.hasNext()) {
            J j5 = (J) it;
            int nextInt = j5.nextInt();
            if (!it.hasNext()) {
                int size = list.size();
                int size2 = list2.size();
                int i5 = 1;
                List<ProgressableFeature> l5 = C2250q.l(list2.get(nextInt));
                int i6 = nextInt;
            } else {
                float featureDistSquared = featureDistSquared(list.get(0).getFeature(), list2.get(nextInt).getFeature());
                do {
                    int nextInt2 = j5.nextInt();
                    float featureDistSquared2 = featureDistSquared(list.get(0).getFeature(), list2.get(nextInt2).getFeature());
                    if (Float.compare(featureDistSquared, featureDistSquared2) > 0) {
                        nextInt = nextInt2;
                        featureDistSquared = featureDistSquared2;
                    }
                } while (it.hasNext());
            }
            int size3 = list.size();
            int size22 = list2.size();
            int i52 = 1;
            List<ProgressableFeature> l52 = C2250q.l(list2.get(nextInt));
            int i62 = nextInt;
            while (i52 < size3) {
                int i7 = nextInt - (size3 - i52);
                if (i7 <= i62) {
                    i7 += size22;
                }
                Iterator it2 = new C2728d(i62 + 1, i7).iterator();
                if (it2.hasNext()) {
                    J j6 = (J) it2;
                    int nextInt3 = j6.nextInt();
                    if (!it2.hasNext()) {
                        i62 = nextInt3;
                    } else {
                        float featureDistSquared3 = featureDistSquared(list.get(i52).getFeature(), list2.get(nextInt3 % size22).getFeature());
                        do {
                            int nextInt4 = j6.nextInt();
                            float featureDistSquared4 = featureDistSquared(list.get(i52).getFeature(), list2.get(nextInt4 % size22).getFeature());
                            if (Float.compare(featureDistSquared3, featureDistSquared4) > 0) {
                                nextInt3 = nextInt4;
                                featureDistSquared3 = featureDistSquared4;
                            }
                        } while (it2.hasNext());
                    }
                    i62 = nextInt3;
                    l52.add(list2.get(i62 % size22));
                    i52++;
                } else {
                    throw new NoSuchElementException();
                }
            }
            return l52;
        }
        throw new NoSuchElementException();
    }

    public static final float featureDistSquared(Feature feature, Feature feature2) {
        t.e(feature, "f1");
        t.e(feature2, "f2");
        if ((feature instanceof Feature.Corner) && (feature2 instanceof Feature.Corner) && ((Feature.Corner) feature).getConvex() != ((Feature.Corner) feature2).getConvex()) {
            return Float.MAX_VALUE;
        }
        float anchor0X = ((((Cubic) C2250q.M(feature.getCubics())).getAnchor0X() + ((Cubic) C2250q.X(feature.getCubics())).getAnchor1X()) / 2.0f) - ((((Cubic) C2250q.M(feature2.getCubics())).getAnchor0X() + ((Cubic) C2250q.X(feature2.getCubics())).getAnchor1X()) / 2.0f);
        float anchor0Y = ((((Cubic) C2250q.M(feature.getCubics())).getAnchor0Y() + ((Cubic) C2250q.X(feature.getCubics())).getAnchor1Y()) / 2.0f) - ((((Cubic) C2250q.M(feature2.getCubics())).getAnchor0Y() + ((Cubic) C2250q.X(feature2.getCubics())).getAnchor1Y()) / 2.0f);
        return (anchor0X * anchor0X) + (anchor0Y * anchor0Y);
    }

    public static final DoubleMapper featureMapper(List<ProgressableFeature> list, List<ProgressableFeature> list2) {
        s sVar;
        t.e(list, "features1");
        t.e(list2, "features2");
        List c5 = C2250q.c();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (list.get(i5).getFeature() instanceof Feature.Corner) {
                c5.add(list.get(i5));
            }
        }
        List a5 = C2250q.a(c5);
        List c6 = C2250q.c();
        int size2 = list2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            if (list2.get(i6).getFeature() instanceof Feature.Corner) {
                c6.add(list2.get(i6));
            }
        }
        List a6 = C2250q.a(c6);
        if (a5.size() > a6.size()) {
            sVar = y.a(doMapping(a6, a5), a6);
        } else {
            sVar = y.a(a5, doMapping(a5, a6));
        }
        List list3 = (List) sVar.a();
        List list4 = (List) sVar.b();
        List c7 = C2250q.c();
        int size3 = list3.size();
        int i7 = 0;
        while (i7 < size3 && i7 != list4.size()) {
            c7.add(y.a(Float.valueOf(((ProgressableFeature) list3.get(i7)).getProgress()), Float.valueOf(((ProgressableFeature) list4.get(i7)).getProgress())));
            i7++;
        }
        s[] sVarArr = (s[]) C2250q.a(c7).toArray(new s[0]);
        return new DoubleMapper((s[]) Arrays.copyOf(sVarArr, sVarArr.length));
    }
}
