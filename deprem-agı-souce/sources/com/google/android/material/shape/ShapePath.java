package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;
    @Deprecated
    public float currentShadowAngle;
    @Deprecated
    public float endShadowAngle;
    @Deprecated
    public float endX;
    @Deprecated
    public float endY;
    private final List<PathOperation> operations = new ArrayList();
    private final List<ShadowCompatOperation> shadowCompatOperations = new ArrayList();
    @Deprecated
    public float startX;
    @Deprecated
    public float startY;

    static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i5, @NonNull Canvas canvas) {
            float access$800 = this.operation.getStartAngle();
            float access$900 = this.operation.getSweepAngle();
            ShadowRenderer shadowRenderer2 = shadowRenderer;
            Canvas canvas2 = canvas;
            shadowRenderer2.drawCornerShadow(canvas2, matrix, new RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), i5, access$800, access$900);
        }
    }

    static class InnerCornerShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation1;
        private final PathLineOperation operation2;
        private final float startX;
        private final float startY;

        public InnerCornerShadowOperation(PathLineOperation pathLineOperation, PathLineOperation pathLineOperation2, float f5, float f6) {
            this.operation1 = pathLineOperation;
            this.operation2 = pathLineOperation2;
            this.startX = f5;
            this.startY = f6;
        }

        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i5, Canvas canvas) {
            int i6;
            Matrix matrix2 = matrix;
            ShadowRenderer shadowRenderer2 = shadowRenderer;
            int i7 = i5;
            Canvas canvas2 = canvas;
            float sweepAngle = getSweepAngle();
            if (sweepAngle <= 0.0f) {
                double hypot = Math.hypot((double) (this.operation1.f7100x - this.startX), (double) (this.operation1.f7101y - this.startY));
                double hypot2 = Math.hypot((double) (this.operation2.f7100x - this.operation1.f7100x), (double) (this.operation2.f7101y - this.operation1.f7101y));
                float min = (float) Math.min((double) i7, Math.min(hypot, hypot2));
                double d5 = (double) min;
                double tan = Math.tan(Math.toRadians((double) ((-sweepAngle) / 2.0f))) * d5;
                if (hypot > tan) {
                    RectF rectF = new RectF(0.0f, 0.0f, (float) (hypot - tan), 0.0f);
                    this.renderMatrix.set(matrix2);
                    this.renderMatrix.preTranslate(this.startX, this.startY);
                    this.renderMatrix.preRotate(getStartAngle());
                    i6 = i5;
                    shadowRenderer2.drawEdgeShadow(canvas2, this.renderMatrix, rectF, i6);
                } else {
                    i6 = i5;
                }
                float f5 = min * 2.0f;
                RectF rectF2 = new RectF(0.0f, 0.0f, f5, f5);
                this.renderMatrix.set(matrix2);
                this.renderMatrix.preTranslate(this.operation1.f7100x, this.operation1.f7101y);
                this.renderMatrix.preRotate(getStartAngle());
                this.renderMatrix.preTranslate((float) ((-tan) - d5), -2.0f * min);
                float[] fArr = {(float) (d5 + tan), f5};
                ShadowRenderer shadowRenderer3 = shadowRenderer;
                double d6 = tan;
                float[] fArr2 = fArr;
                Canvas canvas3 = canvas;
                shadowRenderer3.drawInnerCornerShadow(canvas3, this.renderMatrix, rectF2, (int) min, 450.0f, sweepAngle, fArr2);
                if (hypot2 > d6) {
                    RectF rectF3 = new RectF(0.0f, 0.0f, (float) (hypot2 - d6), 0.0f);
                    this.renderMatrix.set(matrix2);
                    this.renderMatrix.preTranslate(this.operation1.f7100x, this.operation1.f7101y);
                    this.renderMatrix.preRotate(getEndAngle());
                    this.renderMatrix.preTranslate((float) d6, 0.0f);
                    shadowRenderer3.drawEdgeShadow(canvas3, this.renderMatrix, rectF3, i6);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public float getEndAngle() {
            return (float) Math.toDegrees(Math.atan((double) ((this.operation2.f7101y - this.operation1.f7101y) / (this.operation2.f7100x - this.operation1.f7100x))));
        }

        /* access modifiers changed from: package-private */
        public float getStartAngle() {
            return (float) Math.toDegrees(Math.atan((double) ((this.operation1.f7101y - this.startY) / (this.operation1.f7100x - this.startX))));
        }

        /* access modifiers changed from: package-private */
        public float getSweepAngle() {
            float endAngle = ((getEndAngle() - getStartAngle()) + 360.0f) % 360.0f;
            if (endAngle <= ShapePath.ANGLE_LEFT) {
                return endAngle;
            }
            return endAngle - 360.0f;
        }
    }

    static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f5, float f6) {
            this.operation = pathLineOperation;
            this.startX = f5;
            this.startY = f6;
        }

        public void draw(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i5, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.operation.f7101y - this.startY), (double) (this.operation.f7100x - this.startX)), 0.0f);
            this.renderMatrix.set(matrix);
            this.renderMatrix.preTranslate(this.startX, this.startY);
            this.renderMatrix.preRotate(getAngle());
            shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF, i5);
        }

        /* access modifiers changed from: package-private */
        public float getAngle() {
            return (float) Math.toDegrees(Math.atan((double) ((this.operation.f7101y - this.startY) / (this.operation.f7100x - this.startX))));
        }
    }

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = new RectF();
        @Deprecated
        public float bottom;
        @Deprecated
        public float left;
        @Deprecated
        public float right;
        @Deprecated
        public float startAngle;
        @Deprecated
        public float sweepAngle;
        @Deprecated
        public float top;

        public PathArcOperation(float f5, float f6, float f7, float f8) {
            setLeft(f5);
            setTop(f6);
            setRight(f7);
            setBottom(f8);
        }

        /* access modifiers changed from: private */
        public float getBottom() {
            return this.bottom;
        }

        /* access modifiers changed from: private */
        public float getLeft() {
            return this.left;
        }

        /* access modifiers changed from: private */
        public float getRight() {
            return this.right;
        }

        /* access modifiers changed from: private */
        public float getStartAngle() {
            return this.startAngle;
        }

        /* access modifiers changed from: private */
        public float getSweepAngle() {
            return this.sweepAngle;
        }

        /* access modifiers changed from: private */
        public float getTop() {
            return this.top;
        }

        private void setBottom(float f5) {
            this.bottom = f5;
        }

        private void setLeft(float f5) {
            this.left = f5;
        }

        private void setRight(float f5) {
            this.right = f5;
        }

        /* access modifiers changed from: private */
        public void setStartAngle(float f5) {
            this.startAngle = f5;
        }

        /* access modifiers changed from: private */
        public void setSweepAngle(float f5) {
            this.sweepAngle = f5;
        }

        private void setTop(float f5) {
            this.top = f5;
        }

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF2 = rectF;
            rectF2.set(getLeft(), getTop(), getRight(), getBottom());
            path.arcTo(rectF2, getStartAngle(), getSweepAngle(), false);
            path.transform(matrix);
        }
    }

    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float f5, float f6, float f7, float f8, float f9, float f10) {
            setControlX1(f5);
            setControlY1(f6);
            setControlX2(f7);
            setControlY2(f8);
            setEndX(f9);
            setEndY(f10);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX1(float f5) {
            this.controlX1 = f5;
        }

        private void setControlX2(float f5) {
            this.controlX2 = f5;
        }

        private void setControlY1(float f5) {
            this.controlY1 = f5;
        }

        private void setControlY2(float f5) {
            this.controlY2 = f5;
        }

        private void setEndX(float f5) {
            this.endX = f5;
        }

        private void setEndY(float f5) {
            this.endY = f5;
        }

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            Path path2 = path;
            path2.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path2.transform(matrix);
        }
    }

    public static class PathLineOperation extends PathOperation {
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public float f7100x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public float f7101y;

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f7100x, this.f7101y);
            path.transform(matrix);
        }
    }

    public static abstract class PathOperation {
        protected final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix2, Path path);
    }

    public static class PathQuadOperation extends PathOperation {
        @Deprecated
        public float controlX;
        @Deprecated
        public float controlY;
        @Deprecated
        public float endX;
        @Deprecated
        public float endY;

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        /* access modifiers changed from: private */
        public void setControlX(float f5) {
            this.controlX = f5;
        }

        /* access modifiers changed from: private */
        public void setControlY(float f5) {
            this.controlY = f5;
        }

        /* access modifiers changed from: private */
        public void setEndX(float f5) {
            this.endX = f5;
        }

        /* access modifiers changed from: private */
        public void setEndY(float f5) {
            this.endY = f5;
        }

        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }
    }

    static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = new Matrix();
        final Matrix renderMatrix = new Matrix();

        ShadowCompatOperation() {
        }

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i5, Canvas canvas);

        public final void draw(ShadowRenderer shadowRenderer, int i5, Canvas canvas) {
            draw(IDENTITY_MATRIX, shadowRenderer, i5, canvas);
        }
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    private void addConnectingShadowIfNecessary(float f5) {
        if (getCurrentShadowAngle() != f5) {
            float currentShadowAngle2 = ((f5 - getCurrentShadowAngle()) + 360.0f) % 360.0f;
            if (currentShadowAngle2 <= ANGLE_LEFT) {
                PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
                pathArcOperation.setStartAngle(getCurrentShadowAngle());
                pathArcOperation.setSweepAngle(currentShadowAngle2);
                this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
                setCurrentShadowAngle(f5);
            }
        }
    }

    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float f5, float f6) {
        addConnectingShadowIfNecessary(f5);
        this.shadowCompatOperations.add(shadowCompatOperation);
        setCurrentShadowAngle(f6);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float f5) {
        this.currentShadowAngle = f5;
    }

    private void setEndShadowAngle(float f5) {
        this.endShadowAngle = f5;
    }

    private void setEndX(float f5) {
        this.endX = f5;
    }

    private void setEndY(float f5) {
        this.endY = f5;
    }

    private void setStartX(float f5) {
        this.startX = f5;
    }

    private void setStartY(float f5) {
        this.startY = f5;
    }

    public void addArc(float f5, float f6, float f7, float f8, float f9, float f10) {
        boolean z4;
        float f11;
        PathArcOperation pathArcOperation = new PathArcOperation(f5, f6, f7, f8);
        pathArcOperation.setStartAngle(f9);
        pathArcOperation.setSweepAngle(f10);
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f12 = f9 + f10;
        if (f10 < 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            f9 = (f9 + ANGLE_LEFT) % 360.0f;
        }
        if (z4) {
            f11 = (ANGLE_LEFT + f12) % 360.0f;
        } else {
            f11 = f12;
        }
        addShadowCompatOperation(arcShadowOperation, f9, f11);
        double d5 = (double) f12;
        setEndX(((f5 + f7) * 0.5f) + (((f7 - f5) / 2.0f) * ((float) Math.cos(Math.toRadians(d5)))));
        setEndY(((f6 + f8) * 0.5f) + (((f8 - f6) / 2.0f) * ((float) Math.sin(Math.toRadians(d5)))));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.operations.get(i5).applyToPath(matrix, path);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ShadowCompatOperation createShadowCompatOperation(Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.shadowCompatOperations);
        return new ShadowCompatOperation() {
            public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i5, Canvas canvas) {
                for (ShadowCompatOperation draw : arrayList) {
                    draw.draw(matrix2, shadowRenderer, i5, canvas);
                }
            }
        };
    }

    public void cubicToPoint(float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = f9;
        float f12 = f10;
        this.operations.add(new PathCubicOperation(f5, f6, f7, f8, f11, f12));
        this.containsIncompatibleShadowOp = true;
        setEndX(f11);
        setEndY(f12);
    }

    /* access modifiers changed from: package-private */
    public float getEndX() {
        return this.endX;
    }

    /* access modifiers changed from: package-private */
    public float getEndY() {
        return this.endY;
    }

    /* access modifiers changed from: package-private */
    public float getStartX() {
        return this.startX;
    }

    /* access modifiers changed from: package-private */
    public float getStartY() {
        return this.startY;
    }

    public void lineTo(float f5, float f6) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        float unused = pathLineOperation.f7100x = f5;
        float unused2 = pathLineOperation.f7101y = f6;
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + ANGLE_UP, lineShadowOperation.getAngle() + ANGLE_UP);
        setEndX(f5);
        setEndY(f6);
    }

    public void quadToPoint(float f5, float f6, float f7, float f8) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.setControlX(f5);
        pathQuadOperation.setControlY(f6);
        pathQuadOperation.setEndX(f7);
        pathQuadOperation.setEndY(f8);
        this.operations.add(pathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f7);
        setEndY(f8);
    }

    public void reset(float f5, float f6) {
        reset(f5, f6, ANGLE_UP, 0.0f);
    }

    public void reset(float f5, float f6, float f7, float f8) {
        setStartX(f5);
        setStartY(f6);
        setEndX(f5);
        setEndY(f6);
        setCurrentShadowAngle(f7);
        setEndShadowAngle((f7 + f8) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public ShapePath(float f5, float f6) {
        reset(f5, f6);
    }

    public void lineTo(float f5, float f6, float f7, float f8) {
        if ((Math.abs(f5 - getEndX()) >= 0.001f || Math.abs(f6 - getEndY()) >= 0.001f) && (Math.abs(f5 - f7) >= 0.001f || Math.abs(f6 - f8) >= 0.001f)) {
            PathLineOperation pathLineOperation = new PathLineOperation();
            float unused = pathLineOperation.f7100x = f5;
            float unused2 = pathLineOperation.f7101y = f6;
            this.operations.add(pathLineOperation);
            PathLineOperation pathLineOperation2 = new PathLineOperation();
            float unused3 = pathLineOperation2.f7100x = f7;
            float unused4 = pathLineOperation2.f7101y = f8;
            this.operations.add(pathLineOperation2);
            InnerCornerShadowOperation innerCornerShadowOperation = new InnerCornerShadowOperation(pathLineOperation, pathLineOperation2, getEndX(), getEndY());
            if (innerCornerShadowOperation.getSweepAngle() > 0.0f) {
                lineTo(f5, f6);
                lineTo(f7, f8);
                return;
            }
            addShadowCompatOperation(innerCornerShadowOperation, innerCornerShadowOperation.getStartAngle() + ANGLE_UP, innerCornerShadowOperation.getEndAngle() + ANGLE_UP);
            setEndX(f7);
            setEndY(f8);
            return;
        }
        lineTo(f7, f8);
    }
}
