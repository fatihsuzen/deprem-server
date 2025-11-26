package androidx.graphics.shapes;

import W2.s;
import W2.y;
import X2.C2250q;
import androidx.graphics.shapes.MeasuredPolygon;
import java.util.ArrayList;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class Morph {
    public static final Companion Companion = new Companion((C2633k) null);
    private final List<s> _morphMatch;
    private final RoundedPolygon end;
    private final RoundedPolygon start;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final List<s> match$graphics_shapes_release(RoundedPolygon roundedPolygon, RoundedPolygon roundedPolygon2) {
            float f5;
            float f6;
            s sVar;
            s sVar2;
            t.e(roundedPolygon, "p1");
            t.e(roundedPolygon2, "p2");
            MeasuredPolygon.Companion companion = MeasuredPolygon.Companion;
            MeasuredPolygon measurePolygon$graphics_shapes_release = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(roundedPolygon.getCenterX(), roundedPolygon.getCenterY()), roundedPolygon);
            MeasuredPolygon measurePolygon$graphics_shapes_release2 = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(roundedPolygon2.getCenterX(), roundedPolygon2.getCenterY()), roundedPolygon2);
            DoubleMapper featureMapper = FeatureMappingKt.featureMapper(measurePolygon$graphics_shapes_release.getFeatures(), measurePolygon$graphics_shapes_release2.getFeatures());
            float map = featureMapper.map(0.0f);
            String unused = MorphKt.LOG_TAG;
            MeasuredPolygon cutAndShift = measurePolygon$graphics_shapes_release2.cutAndShift(map);
            ArrayList arrayList = new ArrayList();
            MeasuredPolygon.MeasuredCubic measuredCubic = (MeasuredPolygon.MeasuredCubic) C2250q.P(measurePolygon$graphics_shapes_release, 0);
            MeasuredPolygon.MeasuredCubic measuredCubic2 = (MeasuredPolygon.MeasuredCubic) C2250q.P(cutAndShift, 0);
            int i5 = 1;
            int i6 = 1;
            while (measuredCubic != null && measuredCubic2 != null) {
                if (i5 == measurePolygon$graphics_shapes_release.size()) {
                    f5 = 1.0f;
                } else {
                    f5 = measuredCubic.getEndOutlineProgress();
                }
                if (i6 == cutAndShift.size()) {
                    f6 = 1.0f;
                } else {
                    f6 = featureMapper.mapBack(Utils.positiveModulo(measuredCubic2.getEndOutlineProgress() + map, 1.0f));
                }
                float min = Math.min(f5, f6);
                String unused2 = MorphKt.LOG_TAG;
                float f7 = 1.0E-6f + min;
                if (f5 > f7) {
                    String unused3 = MorphKt.LOG_TAG;
                    sVar = measuredCubic.cutAtProgress(min);
                } else {
                    sVar = y.a(measuredCubic, C2250q.P(measurePolygon$graphics_shapes_release, i5));
                    i5++;
                }
                MeasuredPolygon.MeasuredCubic measuredCubic3 = (MeasuredPolygon.MeasuredCubic) sVar.a();
                measuredCubic = (MeasuredPolygon.MeasuredCubic) sVar.b();
                if (f6 > f7) {
                    String unused4 = MorphKt.LOG_TAG;
                    sVar2 = measuredCubic2.cutAtProgress(Utils.positiveModulo(featureMapper.map(min) - map, 1.0f));
                } else {
                    sVar2 = y.a(measuredCubic2, C2250q.P(cutAndShift, i6));
                    i6++;
                }
                measuredCubic2 = (MeasuredPolygon.MeasuredCubic) sVar2.b();
                String unused5 = MorphKt.LOG_TAG;
                arrayList.add(y.a(measuredCubic3.getCubic(), ((MeasuredPolygon.MeasuredCubic) sVar2.a()).getCubic()));
            }
            if (measuredCubic == null && measuredCubic2 == null) {
                return arrayList;
            }
            throw new IllegalArgumentException("Expected both Polygon's Cubic to be fully matched");
        }

        private Companion() {
        }
    }

    public Morph(RoundedPolygon roundedPolygon, RoundedPolygon roundedPolygon2) {
        t.e(roundedPolygon, "start");
        t.e(roundedPolygon2, TtmlNode.END);
        this.start = roundedPolygon;
        this.end = roundedPolygon2;
        this._morphMatch = Companion.match$graphics_shapes_release(roundedPolygon, roundedPolygon2);
    }

    public static /* synthetic */ float[] calculateBounds$default(Morph morph, float[] fArr, boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i5 & 2) != 0) {
            z4 = true;
        }
        return morph.calculateBounds(fArr, z4);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(Morph morph, float[] fArr, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            fArr = new float[4];
        }
        return morph.calculateMaxBounds(fArr);
    }

    public static /* synthetic */ void forEachCubic$default(Morph morph, float f5, MutableCubic mutableCubic, l lVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            mutableCubic = new MutableCubic();
        }
        t.e(mutableCubic, "mutableCubic");
        t.e(lVar, "callback");
        int size = morph.getMorphMatch().size();
        for (int i6 = 0; i6 < size; i6++) {
            mutableCubic.interpolate((Cubic) morph.getMorphMatch().get(i6).c(), (Cubic) morph.getMorphMatch().get(i6).d(), f5);
            lVar.invoke(mutableCubic);
        }
    }

    public static /* synthetic */ void getMorphMatch$annotations() {
    }

    public static final List<s> match$graphics_shapes_release(RoundedPolygon roundedPolygon, RoundedPolygon roundedPolygon2) {
        return Companion.match$graphics_shapes_release(roundedPolygon, roundedPolygon2);
    }

    public final List<Cubic> asCubics(float f5) {
        List c5 = C2250q.c();
        int size = this._morphMatch.size();
        Cubic cubic = null;
        Cubic cubic2 = null;
        int i5 = 0;
        while (i5 < size) {
            float[] fArr = new float[8];
            for (int i6 = 0; i6 < 8; i6++) {
                fArr[i6] = Utils.interpolate(((Cubic) this._morphMatch.get(i5).c()).getPoints$graphics_shapes_release()[i6], ((Cubic) this._morphMatch.get(i5).d()).getPoints$graphics_shapes_release()[i6], f5);
            }
            float f6 = f5;
            Cubic cubic3 = new Cubic(fArr);
            if (cubic2 == null) {
                cubic2 = cubic3;
            }
            if (cubic != null) {
                c5.add(cubic);
            }
            i5++;
            cubic = cubic3;
        }
        if (!(cubic == null || cubic2 == null)) {
            c5.add(CubicKt.Cubic(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic2.getAnchor0X(), cubic2.getAnchor0Y()));
        }
        return C2250q.a(c5);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, (float[]) null, false, 3, (Object) null);
    }

    public final float[] calculateMaxBounds(float[] fArr) {
        t.e(fArr, "bounds");
        this.start.calculateMaxBounds(fArr);
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = fArr[2];
        float f8 = fArr[3];
        this.end.calculateMaxBounds(fArr);
        fArr[0] = Math.min(f5, fArr[0]);
        fArr[1] = Math.min(f6, fArr[1]);
        fArr[2] = Math.max(f7, fArr[2]);
        fArr[3] = Math.max(f8, fArr[3]);
        return fArr;
    }

    public final void forEachCubic(float f5, MutableCubic mutableCubic, l lVar) {
        t.e(mutableCubic, "mutableCubic");
        t.e(lVar, "callback");
        int size = getMorphMatch().size();
        for (int i5 = 0; i5 < size; i5++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i5).c(), (Cubic) getMorphMatch().get(i5).d(), f5);
            lVar.invoke(mutableCubic);
        }
    }

    public final List<s> getMorphMatch() {
        return this._morphMatch;
    }

    public final float[] calculateBounds(float[] fArr) {
        t.e(fArr, "bounds");
        return calculateBounds$default(this, fArr, false, 2, (Object) null);
    }

    public final float[] calculateBounds(float[] fArr, boolean z4) {
        t.e(fArr, "bounds");
        this.start.calculateBounds(fArr, z4);
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = fArr[2];
        float f8 = fArr[3];
        this.end.calculateBounds(fArr, z4);
        fArr[0] = Math.min(f5, fArr[0]);
        fArr[1] = Math.min(f6, fArr[1]);
        fArr[2] = Math.max(f7, fArr[2]);
        fArr[3] = Math.max(f8, fArr[3]);
        return fArr;
    }

    public final void forEachCubic(float f5, l lVar) {
        t.e(lVar, "callback");
        MutableCubic mutableCubic = new MutableCubic();
        int size = getMorphMatch().size();
        for (int i5 = 0; i5 < size; i5++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i5).c(), (Cubic) getMorphMatch().get(i5).d(), f5);
            lVar.invoke(mutableCubic);
        }
    }
}
