package com.google.android.material.transition.platform;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.PathParser;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

@RequiresApi(21)
class TransitionUtils {
    @AttrRes
    static final int NO_ATTR_RES_ID = 0;
    static final int NO_DURATION = -1;
    private static final int PATH_TYPE_ARC = 1;
    private static final int PATH_TYPE_LINEAR = 0;
    private static final RectF transformAlphaRectF = new RectF();

    interface CornerSizeBinaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2);
    }

    private TransitionUtils() {
    }

    static float calculateArea(@NonNull RectF rectF) {
        return rectF.width() * rectF.height();
    }

    static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new a(rectF));
    }

    static Shader createColorShader(@ColorInt int i5) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i5, i5, Shader.TileMode.CLAMP);
    }

    @NonNull
    static <T> T defaultIfNull(@Nullable T t5, @NonNull T t6) {
        return t5 != null ? t5 : t6;
    }

    static View findAncestorById(View view, @IdRes int i5) {
        String resourceName = view.getResources().getResourceName(i5);
        while (view != null) {
            if (view.getId() != i5) {
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    static View findDescendantOrAncestorById(View view, @IdRes int i5) {
        View findViewById = view.findViewById(i5);
        if (findViewById != null) {
            return findViewById;
        }
        return findAncestorById(view, i5);
    }

    static RectF getLocationInWindow(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i5 = iArr[0];
        int i6 = iArr[1];
        return new RectF((float) i5, (float) i6, (float) (view.getWidth() + i5), (float) (view.getHeight() + i6));
    }

    static RectF getRelativeBounds(View view) {
        return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
    }

    static Rect getRelativeBoundsRect(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        if (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) {
            return false;
        }
        return true;
    }

    static float lerp(float f5, float f6, float f7) {
        return f5 + (f7 * (f6 - f5));
    }

    static void maybeAddTransition(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    static boolean maybeApplyThemeDuration(Transition transition, Context context, @AttrRes int i5) {
        int resolveThemeDuration;
        if (i5 == 0 || transition.getDuration() != -1 || (resolveThemeDuration = MotionUtils.resolveThemeDuration(context, i5, -1)) == -1) {
            return false;
        }
        transition.setDuration((long) resolveThemeDuration);
        return true;
    }

    static boolean maybeApplyThemeInterpolator(Transition transition, Context context, @AttrRes int i5, TimeInterpolator timeInterpolator) {
        if (i5 == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(MotionUtils.resolveThemeInterpolator(context, i5, timeInterpolator));
        return true;
    }

    static boolean maybeApplyThemePath(Transition transition, Context context, @AttrRes int i5) {
        PathMotion resolveThemePath;
        if (i5 == 0 || (resolveThemePath = resolveThemePath(context, i5)) == null) {
            return false;
        }
        transition.setPathMotion(resolveThemePath);
        return true;
    }

    static void maybeRemoveTransition(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }

    @Nullable
    static PathMotion resolveThemePath(Context context, @AttrRes int i5) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i5, typedValue, true)) {
            return null;
        }
        int i6 = typedValue.type;
        if (i6 == 16) {
            int i7 = typedValue.data;
            if (i7 == 0) {
                return null;
            }
            if (i7 == 1) {
                return new MaterialArcMotion();
            }
            throw new IllegalArgumentException("Invalid motion path type: " + i7);
        } else if (i6 == 3) {
            return new PatternPathMotion(PathParser.createPathFromPathData(String.valueOf(typedValue.string)));
        } else {
            throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }
    }

    private static int saveLayerAlphaCompat(Canvas canvas, Rect rect, int i5) {
        RectF rectF = transformAlphaRectF;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i5);
    }

    static void transform(Canvas canvas, Rect rect, float f5, float f6, float f7, int i5, CanvasCompat.CanvasOperation canvasOperation) {
        if (i5 > 0) {
            int save = canvas.save();
            canvas.translate(f5, f6);
            canvas.scale(f7, f7);
            if (i5 < 255) {
                saveLayerAlphaCompat(canvas, rect, i5);
            }
            canvasOperation.run(canvas);
            canvas.restoreToCount(save);
        }
    }

    static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        ShapeAppearanceModel shapeAppearanceModel3;
        if (isShapeAppearanceSignificant(shapeAppearanceModel, rectF)) {
            shapeAppearanceModel3 = shapeAppearanceModel;
        } else {
            shapeAppearanceModel3 = shapeAppearanceModel2;
        }
        return shapeAppearanceModel3.toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }

    static float lerp(float f5, float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, @FloatRange(from = 0.0d, to = 1.0d) float f8, @FloatRange(from = 0.0d, to = 1.0d) float f9) {
        return lerp(f5, f6, f7, f8, f9, false);
    }

    static float lerp(float f5, float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, @FloatRange(from = 0.0d, to = 1.0d) float f8, @FloatRange(from = 0.0d) float f9, boolean z4) {
        if (z4 && (f9 < 0.0f || f9 > 1.0f)) {
            return lerp(f5, f6, f9);
        }
        if (f9 < f7) {
            return f5;
        }
        if (f9 > f8) {
            return f6;
        }
        return lerp(f5, f6, (f9 - f7) / (f8 - f7));
    }

    static int lerp(int i5, int i6, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7) {
        if (f7 < f5) {
            return i5;
        }
        return f7 > f6 ? i6 : (int) lerp((float) i5, (float) i6, (f7 - f5) / (f6 - f5));
    }

    static ShapeAppearanceModel lerp(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7) {
        if (f7 < f5) {
            return shapeAppearanceModel;
        }
        if (f7 > f6) {
            return shapeAppearanceModel2;
        }
        final RectF rectF3 = rectF;
        final RectF rectF4 = rectF2;
        final float f8 = f5;
        final float f9 = f6;
        final float f10 = f7;
        return transformCornerSizes(shapeAppearanceModel, shapeAppearanceModel2, rectF3, new CornerSizeBinaryOperator() {
            @NonNull
            public CornerSize apply(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2) {
                return new AbsoluteCornerSize(TransitionUtils.lerp(cornerSize.getCornerSize(rectF3), cornerSize2.getCornerSize(rectF4), f8, f9, f10));
            }
        });
    }
}
