package androidx.graphics.shapes;

import X2.C2250q;
import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class Feature {
    private final List<Cubic> cubics;

    public static final class Corner extends Feature {
        private final boolean convex;
        private final long roundedCenter;
        private final long vertex;

        public /* synthetic */ Corner(List list, long j5, long j6, boolean z4, C2633k kVar) {
            this(list, j5, j6, z4);
        }

        public final boolean getConvex() {
            return this.convex;
        }

        /* renamed from: getRoundedCenter-1ufDz9w  reason: not valid java name */
        public final long m28getRoundedCenter1ufDz9w() {
            return this.roundedCenter;
        }

        /* renamed from: getVertex-1ufDz9w  reason: not valid java name */
        public final long m29getVertex1ufDz9w() {
            return this.vertex;
        }

        public String toString() {
            return "Corner: vertex=" + FloatFloatPair.m10toStringimpl(this.vertex) + ", center=" + FloatFloatPair.m10toStringimpl(this.roundedCenter) + ", convex=" + this.convex;
        }

        public Feature transformed$graphics_shapes_release(PointTransformer pointTransformer) {
            t.e(pointTransformer, "f");
            List c5 = C2250q.c();
            int size = getCubics().size();
            for (int i5 = 0; i5 < size; i5++) {
                c5.add(getCubics().get(i5).transformed(pointTransformer));
            }
            return new Corner(C2250q.a(c5), PointKt.m46transformedso9K2fw(this.vertex, pointTransformer), PointKt.m46transformedso9K2fw(this.roundedCenter, pointTransformer), this.convex, (C2633k) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Corner(List list, long j5, long j6, boolean z4, int i5, C2633k kVar) {
            this(list, j5, j6, (i5 & 8) != 0 ? true : z4, (C2633k) null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private Corner(List<? extends Cubic> list, long j5, long j6, boolean z4) {
            super(list);
            t.e(list, "cubics");
            this.vertex = j5;
            this.roundedCenter = j6;
            this.convex = z4;
        }
    }

    public static final class Edge extends Feature {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Edge(List<? extends Cubic> list) {
            super(list);
            t.e(list, "cubics");
        }

        public String toString() {
            return "Edge";
        }

        public Edge transformed$graphics_shapes_release(PointTransformer pointTransformer) {
            t.e(pointTransformer, "f");
            List c5 = C2250q.c();
            int size = getCubics().size();
            for (int i5 = 0; i5 < size; i5++) {
                c5.add(getCubics().get(i5).transformed(pointTransformer));
            }
            return new Edge(C2250q.a(c5));
        }
    }

    public Feature(List<? extends Cubic> list) {
        t.e(list, "cubics");
        this.cubics = list;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public abstract Feature transformed$graphics_shapes_release(PointTransformer pointTransformer);
}
