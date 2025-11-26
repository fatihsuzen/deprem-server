package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

public class ShapeAppearancePathProvider {
    protected static final int BOTTOM_LEFT_CORNER_INDEX = 2;
    protected static final int BOTTOM_RIGHT_CORNER_INDEX = 1;
    protected static final int TOP_LEFT_CORNER_INDEX = 3;
    protected static final int TOP_RIGHT_CORNER_INDEX = 0;
    private final Path boundsPath = new Path();
    private final Path cornerPath = new Path();
    private final ShapePath[] cornerPaths = new ShapePath[4];
    private final Matrix[] cornerTransforms = new Matrix[4];
    private boolean edgeIntersectionCheckEnabled = true;
    private final Path edgePath = new Path();
    private final Matrix[] edgeTransforms = new Matrix[4];
    private final Path overlappedEdgePath = new Path();
    private final PointF pointF = new PointF();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private final ShapePath shapePath = new ShapePath();

    private static class Lazy {
        static final ShapeAppearancePathProvider INSTANCE = new ShapeAppearancePathProvider();

        private Lazy() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i5);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i5);
    }

    static final class ShapeAppearancePathSpec {
        @NonNull
        public final RectF bounds;
        public final float interpolation;
        @NonNull
        public final Path path;
        @Nullable
        public final PathListener pathListener;
        @NonNull
        public final ShapeAppearanceModel shapeAppearanceModel;

        ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel shapeAppearanceModel2, float f5, RectF rectF, @Nullable PathListener pathListener2, Path path2) {
            this.pathListener = pathListener2;
            this.shapeAppearanceModel = shapeAppearanceModel2;
            this.interpolation = f5;
            this.bounds = rectF;
            this.path = path2;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i5 = 0; i5 < 4; i5++) {
            this.cornerPaths[i5] = new ShapePath();
            this.cornerTransforms[i5] = new Matrix();
            this.edgeTransforms[i5] = new Matrix();
        }
    }

    private float angleOfEdge(int i5) {
        return (float) (((i5 + 1) % 4) * 90);
    }

    private void appendCornerPath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i5) {
        this.scratch[0] = this.cornerPaths[i5].getStartX();
        this.scratch[1] = this.cornerPaths[i5].getStartY();
        this.cornerTransforms[i5].mapPoints(this.scratch);
        if (i5 == 0) {
            Path path = shapeAppearancePathSpec.path;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.path;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[i5].applyToPath(this.cornerTransforms[i5], shapeAppearancePathSpec.path);
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onCornerPathCreated(this.cornerPaths[i5], this.cornerTransforms[i5], i5);
        }
    }

    private void appendEdgePath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i5) {
        int i6 = (i5 + 1) % 4;
        this.scratch[0] = this.cornerPaths[i5].getEndX();
        this.scratch[1] = this.cornerPaths[i5].getEndY();
        this.cornerTransforms[i5].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i6].getStartX();
        this.scratch2[1] = this.cornerPaths[i6].getStartY();
        this.cornerTransforms[i6].mapPoints(this.scratch2);
        float[] fArr = this.scratch;
        float f5 = fArr[0];
        float[] fArr2 = this.scratch2;
        float max = Math.max(((float) Math.hypot((double) (f5 - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i5);
        this.shapePath.reset(0.0f, 0.0f);
        EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(i5, shapeAppearancePathSpec.shapeAppearanceModel);
        edgeTreatmentForIndex.getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        this.edgePath.reset();
        this.shapePath.applyToPath(this.edgeTransforms[i5], this.edgePath);
        if (!this.edgeIntersectionCheckEnabled || (!edgeTreatmentForIndex.forceIntersection() && !pathOverlapsCorner(this.edgePath, i5) && !pathOverlapsCorner(this.edgePath, i6))) {
            this.shapePath.applyToPath(this.edgeTransforms[i5], shapeAppearancePathSpec.path);
        } else {
            Path path = this.edgePath;
            path.op(path, this.boundsPath, Path.Op.DIFFERENCE);
            this.scratch[0] = this.shapePath.getStartX();
            this.scratch[1] = this.shapePath.getStartY();
            this.edgeTransforms[i5].mapPoints(this.scratch);
            Path path2 = this.overlappedEdgePath;
            float[] fArr3 = this.scratch;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.shapePath.applyToPath(this.edgeTransforms[i5], this.overlappedEdgePath);
        }
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i5], i5);
        }
    }

    private void getCoordinatesOfCorner(int i5, @NonNull RectF rectF, @NonNull PointF pointF2) {
        if (i5 == 1) {
            pointF2.set(rectF.right, rectF.bottom);
        } else if (i5 == 2) {
            pointF2.set(rectF.left, rectF.bottom);
        } else if (i5 != 3) {
            pointF2.set(rectF.right, rectF.top);
        } else {
            pointF2.set(rectF.left, rectF.top);
        }
    }

    private CornerTreatment getCornerTreatmentForIndex(int i5, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i5 == 1) {
            return shapeAppearanceModel.getBottomRightCorner();
        }
        if (i5 == 2) {
            return shapeAppearanceModel.getBottomLeftCorner();
        }
        if (i5 != 3) {
            return shapeAppearanceModel.getTopRightCorner();
        }
        return shapeAppearanceModel.getTopLeftCorner();
    }

    private float getEdgeCenterForIndex(@NonNull RectF rectF, int i5) {
        float[] fArr = this.scratch;
        ShapePath shapePath2 = this.cornerPaths[i5];
        fArr[0] = shapePath2.endX;
        fArr[1] = shapePath2.endY;
        this.cornerTransforms[i5].mapPoints(fArr);
        if (i5 == 1 || i5 == 3) {
            return Math.abs(rectF.centerX() - this.scratch[0]);
        }
        return Math.abs(rectF.centerY() - this.scratch[1]);
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int i5, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i5 == 1) {
            return shapeAppearanceModel.getBottomEdge();
        }
        if (i5 == 2) {
            return shapeAppearanceModel.getLeftEdge();
        }
        if (i5 != 3) {
            return shapeAppearanceModel.getRightEdge();
        }
        return shapeAppearanceModel.getTopEdge();
    }

    @UiThread
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static ShapeAppearancePathProvider getInstance() {
        return Lazy.INSTANCE;
    }

    private boolean pathOverlapsCorner(Path path, int i5) {
        this.cornerPath.reset();
        this.cornerPaths[i5].applyToPath(this.cornerTransforms[i5], this.cornerPath);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.cornerPath.computeBounds(rectF, true);
        path.op(this.cornerPath, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f)) {
            return true;
        }
        return false;
    }

    private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i5, @Nullable float[] fArr) {
        ClampedCornerSize clampedCornerSize;
        if (fArr == null) {
            clampedCornerSize = getCornerSizeForIndex(i5, shapeAppearancePathSpec.shapeAppearanceModel);
        } else {
            clampedCornerSize = new ClampedCornerSize(fArr[i5]);
        }
        getCornerTreatmentForIndex(i5, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i5], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, clampedCornerSize);
        float angleOfEdge = angleOfEdge(i5);
        this.cornerTransforms[i5].reset();
        getCoordinatesOfCorner(i5, shapeAppearancePathSpec.bounds, this.pointF);
        Matrix matrix = this.cornerTransforms[i5];
        PointF pointF2 = this.pointF;
        matrix.setTranslate(pointF2.x, pointF2.y);
        this.cornerTransforms[i5].preRotate(angleOfEdge);
    }

    private void setEdgePathAndTransform(int i5) {
        this.scratch[0] = this.cornerPaths[i5].getEndX();
        this.scratch[1] = this.cornerPaths[i5].getEndY();
        this.cornerTransforms[i5].mapPoints(this.scratch);
        float angleOfEdge = angleOfEdge(i5);
        this.edgeTransforms[i5].reset();
        Matrix matrix = this.edgeTransforms[i5];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[i5].preRotate(angleOfEdge);
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f5, RectF rectF, @NonNull Path path) {
        calculatePath(shapeAppearanceModel, f5, rectF, (PathListener) null, path);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CornerSize getCornerSizeForIndex(int i5, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i5 == 1) {
            return shapeAppearanceModel.getBottomRightCornerSize();
        }
        if (i5 == 2) {
            return shapeAppearanceModel.getBottomLeftCornerSize();
        }
        if (i5 != 3) {
            return shapeAppearanceModel.getTopRightCornerSize();
        }
        return shapeAppearanceModel.getTopLeftCornerSize();
    }

    /* access modifiers changed from: package-private */
    public void setEdgeIntersectionCheckEnable(boolean z4) {
        this.edgeIntersectionCheckEnabled = z4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f5, RectF rectF, PathListener pathListener, @NonNull Path path) {
        calculatePath(shapeAppearanceModel, (float[]) null, f5, rectF, pathListener, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(@NonNull ShapeAppearanceModel shapeAppearanceModel, @Nullable float[] fArr, float f5, RectF rectF, PathListener pathListener, @NonNull Path path) {
        path.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(rectF, Path.Direction.CW);
        Path path2 = path;
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f5, rectF, pathListener, path2);
        for (int i5 = 0; i5 < 4; i5++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, i5, fArr);
            setEdgePathAndTransform(i5);
        }
        for (int i6 = 0; i6 < 4; i6++) {
            appendCornerPath(shapeAppearancePathSpec, i6);
            appendEdgePath(shapeAppearancePathSpec, i6);
        }
        path2.close();
        this.overlappedEdgePath.close();
        if (!this.overlappedEdgePath.isEmpty()) {
            path2.op(this.overlappedEdgePath, Path.Op.UNION);
        }
    }
}
