package androidx.graphics.shapes;

import W2.J;
import W2.s;
import W2.y;
import X2.C2236c;
import X2.C2250q;
import androidx.annotation.FloatRange;
import androidx.collection.FloatList;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class MeasuredPolygon extends C2236c {
    public static final Companion Companion = new Companion((C2633k) null);
    private final List<MeasuredCubic> cubics;
    private final List<ProgressableFeature> features;
    /* access modifiers changed from: private */
    public final Measurer measurer;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final MeasuredPolygon measurePolygon$graphics_shapes_release(Measurer measurer, RoundedPolygon roundedPolygon) {
            List list;
            t.e(measurer, "measurer");
            t.e(roundedPolygon, "polygon");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = roundedPolygon.getFeatures$graphics_shapes_release().size();
            for (int i5 = 0; i5 < size; i5++) {
                Feature feature = roundedPolygon.getFeatures$graphics_shapes_release().get(i5);
                int size2 = feature.getCubics().size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if ((feature instanceof Feature.Corner) && i6 == feature.getCubics().size() / 2) {
                        arrayList2.add(y.a(feature, Integer.valueOf(arrayList.size())));
                    }
                    arrayList.add(feature.getCubics().get(i6));
                }
            }
            Float valueOf = Float.valueOf(0.0f);
            int p5 = C2250q.p(arrayList, 9);
            if (p5 == 0) {
                list = C2250q.d(valueOf);
            } else {
                ArrayList arrayList3 = new ArrayList(p5 + 1);
                arrayList3.add(valueOf);
                int size3 = arrayList.size();
                int i7 = 0;
                while (i7 < size3) {
                    Object obj = arrayList.get(i7);
                    i7++;
                    float floatValue = valueOf.floatValue();
                    float measureCubic = measurer.measureCubic((Cubic) obj);
                    if (measureCubic >= 0.0f) {
                        J j5 = J.f19942a;
                        valueOf = Float.valueOf(floatValue + measureCubic);
                        arrayList3.add(valueOf);
                    } else {
                        throw new IllegalArgumentException("Measured cubic is expected to be greater or equal to zero");
                    }
                }
                list = arrayList3;
            }
            float floatValue2 = ((Number) C2250q.X(list)).floatValue();
            MutableFloatList mutableFloatList = new MutableFloatList(list.size());
            int size4 = list.size();
            for (int i8 = 0; i8 < size4; i8++) {
                mutableFloatList.add(((Number) list.get(i8)).floatValue() / floatValue2);
            }
            String unused = PolygonMeasureKt.LOG_TAG;
            List c5 = C2250q.c();
            int size5 = arrayList2.size();
            for (int i9 = 0; i9 < size5; i9++) {
                int intValue = ((Number) ((s) arrayList2.get(i9)).d()).intValue();
                c5.add(new ProgressableFeature((mutableFloatList.get(intValue) + mutableFloatList.get(intValue + 1)) / ((float) 2), (Feature) ((s) arrayList2.get(i9)).c()));
            }
            return new MeasuredPolygon(measurer, C2250q.a(c5), arrayList, mutableFloatList, (C2633k) null);
        }

        private Companion() {
        }
    }

    public final class MeasuredCubic {
        private final Cubic cubic;
        private float endOutlineProgress;
        private final float measuredSize;
        private float startOutlineProgress;
        final /* synthetic */ MeasuredPolygon this$0;

        public MeasuredCubic(MeasuredPolygon measuredPolygon, @FloatRange(from = 0.0d, to = 1.0d) Cubic cubic2, @FloatRange(from = 0.0d, to = 1.0d) float f5, float f6) {
            t.e(cubic2, "cubic");
            this.this$0 = measuredPolygon;
            this.cubic = cubic2;
            if (f6 >= f5) {
                this.measuredSize = measuredPolygon.measurer.measureCubic(cubic2);
                this.startOutlineProgress = f5;
                this.endOutlineProgress = f6;
                return;
            }
            throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
        }

        public static /* synthetic */ void updateProgressRange$graphics_shapes_release$default(MeasuredCubic measuredCubic, float f5, float f6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                f5 = measuredCubic.startOutlineProgress;
            }
            if ((i5 & 2) != 0) {
                f6 = measuredCubic.endOutlineProgress;
            }
            measuredCubic.updateProgressRange$graphics_shapes_release(f5, f6);
        }

        public final s cutAtProgress(float f5) {
            float g5 = C2729e.g(f5, this.startOutlineProgress, this.endOutlineProgress);
            float f6 = this.endOutlineProgress;
            float f7 = this.startOutlineProgress;
            float findCubicCutPoint = this.this$0.measurer.findCubicCutPoint(this.cubic, ((g5 - f7) / (f6 - f7)) * this.measuredSize);
            if (0.0f > findCubicCutPoint || findCubicCutPoint > 1.0f) {
                throw new IllegalArgumentException("Cubic cut point is expected to be between 0 and 1");
            }
            String unused = PolygonMeasureKt.LOG_TAG;
            s split = this.cubic.split(findCubicCutPoint);
            return y.a(new MeasuredCubic(this.this$0, (Cubic) split.a(), this.startOutlineProgress, g5), new MeasuredCubic(this.this$0, (Cubic) split.b(), g5, this.endOutlineProgress));
        }

        public final Cubic getCubic() {
            return this.cubic;
        }

        public final float getEndOutlineProgress() {
            return this.endOutlineProgress;
        }

        public final float getMeasuredSize() {
            return this.measuredSize;
        }

        public final float getStartOutlineProgress() {
            return this.startOutlineProgress;
        }

        public String toString() {
            return "MeasuredCubic(outlineProgress=[" + this.startOutlineProgress + " .. " + this.endOutlineProgress + "], size=" + this.measuredSize + ", cubic=" + this.cubic + ')';
        }

        public final void updateProgressRange$graphics_shapes_release(float f5, float f6) {
            if (f6 >= f5) {
                this.startOutlineProgress = f5;
                this.endOutlineProgress = f6;
                return;
            }
            throw new IllegalArgumentException("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
        }
    }

    public /* synthetic */ MeasuredPolygon(Measurer measurer2, List list, List list2, FloatList floatList, C2633k kVar) {
        this(measurer2, list, list2, floatList);
    }

    public /* bridge */ boolean contains(MeasuredCubic measuredCubic) {
        return super.contains(measuredCubic);
    }

    public final MeasuredPolygon cutAndShift(float f5) {
        float f6;
        if (0.0f > f5 || f5 > 1.0f) {
            throw new IllegalArgumentException("Cutting point is expected to be between 0 and 1");
        } else if (f5 < 1.0E-4f) {
            return this;
        } else {
            Iterator<MeasuredCubic> it = this.cubics.iterator();
            int i5 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i5 = -1;
                    break;
                }
                MeasuredCubic next = it.next();
                float startOutlineProgress = next.getStartOutlineProgress();
                if (f5 <= next.getEndOutlineProgress() && startOutlineProgress <= f5) {
                    break;
                }
                i5++;
            }
            s cutAtProgress = this.cubics.get(i5).cutAtProgress(f5);
            MeasuredCubic measuredCubic = (MeasuredCubic) cutAtProgress.a();
            String unused = PolygonMeasureKt.LOG_TAG;
            List l5 = C2250q.l(((MeasuredCubic) cutAtProgress.b()).getCubic());
            int size = this.cubics.size();
            for (int i6 = 1; i6 < size; i6++) {
                List<MeasuredCubic> list = this.cubics;
                l5.add(list.get((i6 + i5) % list.size()).getCubic());
            }
            l5.add(measuredCubic.getCubic());
            MutableFloatList mutableFloatList = new MutableFloatList(this.cubics.size() + 2);
            int size2 = this.cubics.size() + 2;
            for (int i7 = 0; i7 < size2; i7++) {
                if (i7 == 0) {
                    f6 = 0.0f;
                } else if (i7 == this.cubics.size() + 1) {
                    f6 = 1.0f;
                } else {
                    f6 = Utils.positiveModulo(this.cubics.get(((i5 + i7) - 1) % this.cubics.size()).getEndOutlineProgress() - f5, 1.0f);
                }
                mutableFloatList.add(f6);
            }
            List c5 = C2250q.c();
            int size3 = this.features.size();
            for (int i8 = 0; i8 < size3; i8++) {
                c5.add(new ProgressableFeature(Utils.positiveModulo(this.features.get(i8).getProgress() - f5, 1.0f), this.features.get(i8).getFeature()));
            }
            return new MeasuredPolygon(this.measurer, C2250q.a(c5), l5, mutableFloatList);
        }
    }

    public final List<ProgressableFeature> getFeatures() {
        return this.features;
    }

    public int getSize() {
        return this.cubics.size();
    }

    public /* bridge */ int indexOf(MeasuredCubic measuredCubic) {
        return super.indexOf(measuredCubic);
    }

    public /* bridge */ int lastIndexOf(MeasuredCubic measuredCubic) {
        return super.lastIndexOf(measuredCubic);
    }

    private MeasuredPolygon(Measurer measurer2, List<ProgressableFeature> list, List<? extends Cubic> list2, FloatList floatList) {
        if (floatList.getSize() != list2.size() + 1) {
            throw new IllegalArgumentException("Outline progress size is expected to be the cubics size + 1");
        } else if (floatList.first() != 0.0f) {
            throw new IllegalArgumentException("First outline progress value is expected to be zero");
        } else if (floatList.last() == 1.0f) {
            this.measurer = measurer2;
            this.features = list;
            ArrayList arrayList = new ArrayList();
            int size = list2.size();
            int i5 = 0;
            float f5 = 0.0f;
            while (i5 < size) {
                int i6 = i5 + 1;
                if (floatList.get(i6) - floatList.get(i5) > 1.0E-4f) {
                    arrayList.add(new MeasuredCubic(this, (Cubic) list2.get(i5), f5, floatList.get(i6)));
                    f5 = floatList.get(i6);
                }
                i5 = i6;
            }
            MeasuredCubic.updateProgressRange$graphics_shapes_release$default((MeasuredCubic) arrayList.get(C2250q.i(arrayList)), 0.0f, 1.0f, 1, (Object) null);
            this.cubics = arrayList;
        } else {
            throw new IllegalArgumentException("Last outline progress value is expected to be one");
        }
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof MeasuredCubic)) {
            return false;
        }
        return contains((MeasuredCubic) obj);
    }

    public MeasuredCubic get(int i5) {
        return this.cubics.get(i5);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof MeasuredCubic)) {
            return -1;
        }
        return indexOf((MeasuredCubic) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof MeasuredCubic)) {
            return -1;
        }
        return lastIndexOf((MeasuredCubic) obj);
    }
}
