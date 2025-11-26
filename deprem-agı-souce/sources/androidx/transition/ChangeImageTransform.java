package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import java.util.Map;

public class ChangeImageTransform extends Transition {
    private static final Property<ImageView, Matrix> ANIMATED_TRANSFORM_PROPERTY = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
        public Matrix get(ImageView imageView) {
            return null;
        }

        public void set(ImageView imageView, Matrix matrix) {
            ImageViewUtils.animateTransform(imageView, matrix);
        }
    };
    private static final TypeEvaluator<Matrix> NULL_MATRIX_EVALUATOR = new TypeEvaluator<Matrix>() {
        public Matrix evaluate(float f5, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };
    private static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    private static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    private static final String[] sTransitionProperties = {PROPNAME_MATRIX, PROPNAME_BOUNDS};

    /* renamed from: androidx.transition.ChangeImageTransform$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$widget$ImageView$ScaleType = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$android$widget$ImageView$ScaleType     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeImageTransform.AnonymousClass3.<clinit>():void");
        }
    }

    private static class Listener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final Matrix mEndMatrix;
        private final ImageView mImageView;
        private boolean mIsBeforeAnimator = true;
        private final Matrix mStartMatrix;

        Listener(ImageView imageView, Matrix matrix, Matrix matrix2) {
            this.mImageView = imageView;
            this.mStartMatrix = matrix;
            this.mEndMatrix = matrix2;
        }

        private void restoreMatrix() {
            ImageView imageView = this.mImageView;
            int i5 = R.id.transition_image_transform;
            Matrix matrix = (Matrix) imageView.getTag(i5);
            if (matrix != null) {
                ImageViewUtils.animateTransform(this.mImageView, matrix);
                this.mImageView.setTag(i5, (Object) null);
            }
        }

        private void saveMatrix(Matrix matrix) {
            this.mImageView.setTag(R.id.transition_image_transform, matrix);
            ImageViewUtils.animateTransform(this.mImageView, this.mEndMatrix);
        }

        public void onAnimationEnd(@NonNull Animator animator, boolean z4) {
            this.mIsBeforeAnimator = z4;
        }

        public void onAnimationPause(Animator animator) {
            saveMatrix((Matrix) ((ObjectAnimator) animator).getAnimatedValue());
        }

        public void onAnimationResume(Animator animator) {
            restoreMatrix();
        }

        public void onAnimationStart(@NonNull Animator animator, boolean z4) {
            this.mIsBeforeAnimator = false;
        }

        public void onTransitionCancel(@NonNull Transition transition) {
        }

        public void onTransitionEnd(@NonNull Transition transition) {
        }

        public void onTransitionPause(@NonNull Transition transition) {
            if (this.mIsBeforeAnimator) {
                saveMatrix(this.mStartMatrix);
            }
        }

        public void onTransitionResume(@NonNull Transition transition) {
            restoreMatrix();
        }

        public void onTransitionStart(@NonNull Transition transition) {
        }

        public void onAnimationEnd(Animator animator) {
            this.mIsBeforeAnimator = false;
        }

        public void onAnimationStart(Animator animator) {
            this.mIsBeforeAnimator = false;
        }

        public /* synthetic */ void onTransitionEnd(Transition transition, boolean z4) {
            e.a(this, transition, z4);
        }

        public /* synthetic */ void onTransitionStart(Transition transition, boolean z4) {
            e.b(this, transition, z4);
        }
    }

    public ChangeImageTransform() {
    }

    private void captureValues(TransitionValues transitionValues, boolean z4) {
        Matrix matrix;
        View view = transitionValues.view;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Map<String, Object> map = transitionValues.values;
                map.put(PROPNAME_BOUNDS, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                if (z4) {
                    matrix = (Matrix) imageView.getTag(R.id.transition_image_transform);
                } else {
                    matrix = null;
                }
                if (matrix == null) {
                    matrix = copyImageMatrix(imageView);
                }
                map.put(PROPNAME_MATRIX, matrix);
            }
        }
    }

    private static Matrix centerCropMatrix(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = (float) imageView.getWidth();
        float f5 = (float) intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = (float) imageView.getHeight();
        float f6 = (float) intrinsicHeight;
        float max = Math.max(width / f5, height / f6);
        int round = Math.round((width - (f5 * max)) / 2.0f);
        int round2 = Math.round((height - (f6 * max)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(max, max);
        matrix.postTranslate((float) round, (float) round2);
        return matrix;
    }

    @NonNull
    private static Matrix copyImageMatrix(@NonNull ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return new Matrix(imageView.getImageMatrix());
        }
        int i5 = AnonymousClass3.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()];
        if (i5 == 1) {
            return fitXYMatrix(imageView);
        }
        if (i5 != 2) {
            return new Matrix(imageView.getImageMatrix());
        }
        return centerCropMatrix(imageView);
    }

    private ObjectAnimator createMatrixAnimator(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, ANIMATED_TRANSFORM_PROPERTY, new TransitionUtils.MatrixEvaluator(), new Matrix[]{matrix, matrix2});
    }

    @NonNull
    private ObjectAnimator createNullAnimator(@NonNull ImageView imageView) {
        Property<ImageView, Matrix> property = ANIMATED_TRANSFORM_PROPERTY;
        TypeEvaluator<Matrix> typeEvaluator = NULL_MATRIX_EVALUATOR;
        Matrix matrix = MatrixUtils.IDENTITY_MATRIX;
        return ObjectAnimator.ofObject(imageView, property, typeEvaluator, new Matrix[]{matrix, matrix});
    }

    private static Matrix fitXYMatrix(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) imageView.getWidth()) / ((float) drawable.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable.getIntrinsicHeight()));
        return matrix;
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues, false);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues, true);
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        boolean z4;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.values.get(PROPNAME_BOUNDS);
        Rect rect2 = (Rect) transitionValues2.values.get(PROPNAME_BOUNDS);
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) transitionValues.values.get(PROPNAME_MATRIX);
        Matrix matrix2 = (Matrix) transitionValues2.values.get(PROPNAME_MATRIX);
        if (!(matrix == null && matrix2 == null) && (matrix == null || !matrix.equals(matrix2))) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (rect.equals(rect2) && z4) {
            return null;
        }
        ImageView imageView = (ImageView) transitionValues2.view;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return createNullAnimator(imageView);
        }
        if (matrix == null) {
            matrix = MatrixUtils.IDENTITY_MATRIX;
        }
        if (matrix2 == null) {
            matrix2 = MatrixUtils.IDENTITY_MATRIX;
        }
        ANIMATED_TRANSFORM_PROPERTY.set(imageView, matrix);
        ObjectAnimator createMatrixAnimator = createMatrixAnimator(imageView, matrix, matrix2);
        Listener listener = new Listener(imageView, matrix, matrix2);
        createMatrixAnimator.addListener(listener);
        createMatrixAnimator.addPauseListener(listener);
        addListener(listener);
        return createMatrixAnimator;
    }

    @NonNull
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isSeekingSupported() {
        return true;
    }

    public ChangeImageTransform(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
