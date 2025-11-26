package androidx.leanback.graphics;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.leanback.graphics.BoundsRule;
import java.util.ArrayList;

public class CompositeDrawable extends Drawable implements Drawable.Callback {
    boolean mMutated;
    CompositeState mState;

    public CompositeDrawable() {
        this.mMutated = false;
        this.mState = new CompositeState();
    }

    public void addChildDrawable(Drawable drawable) {
        this.mState.mChildren.add(new ChildDrawable(drawable, this));
    }

    public void draw(Canvas canvas) {
        ArrayList<ChildDrawable> arrayList = this.mState.mChildren;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            arrayList.get(i5).mDrawable.draw(canvas);
        }
    }

    public int getAlpha() {
        Drawable firstNonNullDrawable = getFirstNonNullDrawable();
        if (firstNonNullDrawable != null) {
            return DrawableCompat.getAlpha(firstNonNullDrawable);
        }
        return 255;
    }

    public ChildDrawable getChildAt(int i5) {
        return this.mState.mChildren.get(i5);
    }

    public int getChildCount() {
        return this.mState.mChildren.size();
    }

    public Drawable.ConstantState getConstantState() {
        return this.mState;
    }

    public Drawable getDrawable(int i5) {
        return this.mState.mChildren.get(i5).mDrawable;
    }

    /* access modifiers changed from: package-private */
    public final Drawable getFirstNonNullDrawable() {
        ArrayList<ChildDrawable> arrayList = this.mState.mChildren;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            Drawable drawable = arrayList.get(i5).mDrawable;
            if (drawable != null) {
                return drawable;
            }
        }
        return null;
    }

    public int getOpacity() {
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            CompositeState compositeState = new CompositeState(this.mState, this, (Resources) null);
            this.mState = compositeState;
            ArrayList<ChildDrawable> arrayList = compositeState.mChildren;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                Drawable drawable = arrayList.get(i5).mDrawable;
                if (drawable != null) {
                    drawable.mutate();
                }
            }
            this.mMutated = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updateBounds(rect);
    }

    public void removeChild(int i5) {
        this.mState.mChildren.remove(i5);
    }

    public void removeDrawable(Drawable drawable) {
        ArrayList<ChildDrawable> arrayList = this.mState.mChildren;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            if (drawable == arrayList.get(i5).mDrawable) {
                arrayList.get(i5).mDrawable.setCallback((Drawable.Callback) null);
                arrayList.remove(i5);
                return;
            }
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        scheduleSelf(runnable, j5);
    }

    public void setAlpha(int i5) {
        ArrayList<ChildDrawable> arrayList = this.mState.mChildren;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            arrayList.get(i6).mDrawable.setAlpha(i5);
        }
    }

    public void setChildDrawableAt(int i5, Drawable drawable) {
        this.mState.mChildren.set(i5, new ChildDrawable(drawable, this));
    }

    public void setColorFilter(ColorFilter colorFilter) {
        ArrayList<ChildDrawable> arrayList = this.mState.mChildren;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            arrayList.get(i5).mDrawable.setColorFilter(colorFilter);
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* access modifiers changed from: package-private */
    public void updateBounds(Rect rect) {
        ArrayList<ChildDrawable> arrayList = this.mState.mChildren;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            arrayList.get(i5).updateBounds(rect);
        }
    }

    static class CompositeState extends Drawable.ConstantState {
        final ArrayList<ChildDrawable> mChildren;

        CompositeState() {
            this.mChildren = new ArrayList<>();
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new CompositeDrawable(this);
        }

        CompositeState(CompositeState compositeState, CompositeDrawable compositeDrawable, Resources resources) {
            int size = compositeState.mChildren.size();
            this.mChildren = new ArrayList<>(size);
            for (int i5 = 0; i5 < size; i5++) {
                this.mChildren.add(new ChildDrawable(compositeState.mChildren.get(i5), compositeDrawable, resources));
            }
        }
    }

    CompositeDrawable(CompositeState compositeState) {
        this.mMutated = false;
        this.mState = compositeState;
    }

    public static final class ChildDrawable {
        public static final Property<ChildDrawable, Integer> BOTTOM_ABSOLUTE;
        public static final Property<ChildDrawable, Float> BOTTOM_FRACTION;
        public static final Property<ChildDrawable, Integer> LEFT_ABSOLUTE;
        public static final Property<ChildDrawable, Float> LEFT_FRACTION;
        public static final Property<ChildDrawable, Integer> RIGHT_ABSOLUTE;
        public static final Property<ChildDrawable, Float> RIGHT_FRACTION;
        public static final Property<ChildDrawable, Integer> TOP_ABSOLUTE;
        public static final Property<ChildDrawable, Float> TOP_FRACTION;
        private final Rect adjustedBounds = new Rect();
        private final BoundsRule mBoundsRule;
        final Drawable mDrawable;
        final CompositeDrawable mParent;

        static {
            Class<Integer> cls = Integer.class;
            TOP_ABSOLUTE = new Property<ChildDrawable, Integer>(cls, "absoluteTop") {
                public Integer get(ChildDrawable childDrawable) {
                    if (childDrawable.getBoundsRule().top == null) {
                        return Integer.valueOf(childDrawable.mParent.getBounds().top);
                    }
                    return Integer.valueOf(childDrawable.getBoundsRule().top.getAbsoluteValue());
                }

                public void set(ChildDrawable childDrawable, Integer num) {
                    if (childDrawable.getBoundsRule().top == null) {
                        childDrawable.getBoundsRule().top = BoundsRule.ValueRule.absoluteValue(num.intValue());
                    } else {
                        childDrawable.getBoundsRule().top.setAbsoluteValue(num.intValue());
                    }
                    childDrawable.recomputeBounds();
                }
            };
            BOTTOM_ABSOLUTE = new Property<ChildDrawable, Integer>(cls, "absoluteBottom") {
                public Integer get(ChildDrawable childDrawable) {
                    if (childDrawable.getBoundsRule().bottom == null) {
                        return Integer.valueOf(childDrawable.mParent.getBounds().bottom);
                    }
                    return Integer.valueOf(childDrawable.getBoundsRule().bottom.getAbsoluteValue());
                }

                public void set(ChildDrawable childDrawable, Integer num) {
                    if (childDrawable.getBoundsRule().bottom == null) {
                        childDrawable.getBoundsRule().bottom = BoundsRule.ValueRule.absoluteValue(num.intValue());
                    } else {
                        childDrawable.getBoundsRule().bottom.setAbsoluteValue(num.intValue());
                    }
                    childDrawable.recomputeBounds();
                }
            };
            LEFT_ABSOLUTE = new Property<ChildDrawable, Integer>(cls, "absoluteLeft") {
                public Integer get(ChildDrawable childDrawable) {
                    if (childDrawable.getBoundsRule().left == null) {
                        return Integer.valueOf(childDrawable.mParent.getBounds().left);
                    }
                    return Integer.valueOf(childDrawable.getBoundsRule().left.getAbsoluteValue());
                }

                public void set(ChildDrawable childDrawable, Integer num) {
                    if (childDrawable.getBoundsRule().left == null) {
                        childDrawable.getBoundsRule().left = BoundsRule.ValueRule.absoluteValue(num.intValue());
                    } else {
                        childDrawable.getBoundsRule().left.setAbsoluteValue(num.intValue());
                    }
                    childDrawable.recomputeBounds();
                }
            };
            RIGHT_ABSOLUTE = new Property<ChildDrawable, Integer>(cls, "absoluteRight") {
                public Integer get(ChildDrawable childDrawable) {
                    if (childDrawable.getBoundsRule().right == null) {
                        return Integer.valueOf(childDrawable.mParent.getBounds().right);
                    }
                    return Integer.valueOf(childDrawable.getBoundsRule().right.getAbsoluteValue());
                }

                public void set(ChildDrawable childDrawable, Integer num) {
                    if (childDrawable.getBoundsRule().right == null) {
                        childDrawable.getBoundsRule().right = BoundsRule.ValueRule.absoluteValue(num.intValue());
                    } else {
                        childDrawable.getBoundsRule().right.setAbsoluteValue(num.intValue());
                    }
                    childDrawable.recomputeBounds();
                }
            };
            Class<Float> cls2 = Float.class;
            TOP_FRACTION = new Property<ChildDrawable, Float>(cls2, "fractionTop") {
                public Float get(ChildDrawable childDrawable) {
                    if (childDrawable.getBoundsRule().top == null) {
                        return Float.valueOf(0.0f);
                    }
                    return Float.valueOf(childDrawable.getBoundsRule().top.getFraction());
                }

                public void set(ChildDrawable childDrawable, Float f5) {
                    if (childDrawable.getBoundsRule().top == null) {
                        childDrawable.getBoundsRule().top = BoundsRule.ValueRule.inheritFromParent(f5.floatValue());
                    } else {
                        childDrawable.getBoundsRule().top.setFraction(f5.floatValue());
                    }
                    childDrawable.recomputeBounds();
                }
            };
            BOTTOM_FRACTION = new Property<ChildDrawable, Float>(cls2, "fractionBottom") {
                public Float get(ChildDrawable childDrawable) {
                    if (childDrawable.getBoundsRule().bottom == null) {
                        return Float.valueOf(1.0f);
                    }
                    return Float.valueOf(childDrawable.getBoundsRule().bottom.getFraction());
                }

                public void set(ChildDrawable childDrawable, Float f5) {
                    if (childDrawable.getBoundsRule().bottom == null) {
                        childDrawable.getBoundsRule().bottom = BoundsRule.ValueRule.inheritFromParent(f5.floatValue());
                    } else {
                        childDrawable.getBoundsRule().bottom.setFraction(f5.floatValue());
                    }
                    childDrawable.recomputeBounds();
                }
            };
            LEFT_FRACTION = new Property<ChildDrawable, Float>(cls2, "fractionLeft") {
                public Float get(ChildDrawable childDrawable) {
                    if (childDrawable.getBoundsRule().left == null) {
                        return Float.valueOf(0.0f);
                    }
                    return Float.valueOf(childDrawable.getBoundsRule().left.getFraction());
                }

                public void set(ChildDrawable childDrawable, Float f5) {
                    if (childDrawable.getBoundsRule().left == null) {
                        childDrawable.getBoundsRule().left = BoundsRule.ValueRule.inheritFromParent(f5.floatValue());
                    } else {
                        childDrawable.getBoundsRule().left.setFraction(f5.floatValue());
                    }
                    childDrawable.recomputeBounds();
                }
            };
            RIGHT_FRACTION = new Property<ChildDrawable, Float>(cls2, "fractionRight") {
                public Float get(ChildDrawable childDrawable) {
                    if (childDrawable.getBoundsRule().right == null) {
                        return Float.valueOf(1.0f);
                    }
                    return Float.valueOf(childDrawable.getBoundsRule().right.getFraction());
                }

                public void set(ChildDrawable childDrawable, Float f5) {
                    if (childDrawable.getBoundsRule().right == null) {
                        childDrawable.getBoundsRule().right = BoundsRule.ValueRule.inheritFromParent(f5.floatValue());
                    } else {
                        childDrawable.getBoundsRule().right.setFraction(f5.floatValue());
                    }
                    childDrawable.recomputeBounds();
                }
            };
        }

        public ChildDrawable(Drawable drawable, CompositeDrawable compositeDrawable) {
            this.mDrawable = drawable;
            this.mParent = compositeDrawable;
            this.mBoundsRule = new BoundsRule();
            drawable.setCallback(compositeDrawable);
        }

        public BoundsRule getBoundsRule() {
            return this.mBoundsRule;
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        public void recomputeBounds() {
            updateBounds(this.mParent.getBounds());
        }

        /* access modifiers changed from: package-private */
        public void updateBounds(Rect rect) {
            this.mBoundsRule.calculateBounds(rect, this.adjustedBounds);
            this.mDrawable.setBounds(this.adjustedBounds);
        }

        ChildDrawable(ChildDrawable childDrawable, CompositeDrawable compositeDrawable, Resources resources) {
            Drawable drawable;
            Drawable drawable2 = childDrawable.mDrawable;
            if (drawable2 != null) {
                Drawable.ConstantState constantState = drawable2.getConstantState();
                if (resources != null) {
                    drawable = constantState.newDrawable(resources);
                } else {
                    drawable = constantState.newDrawable();
                }
                drawable.setCallback(compositeDrawable);
                DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(drawable2));
                drawable.setBounds(drawable2.getBounds());
                drawable.setLevel(drawable2.getLevel());
            } else {
                drawable = null;
            }
            BoundsRule boundsRule = childDrawable.mBoundsRule;
            if (boundsRule != null) {
                this.mBoundsRule = new BoundsRule(boundsRule);
            } else {
                this.mBoundsRule = new BoundsRule();
            }
            this.mDrawable = drawable;
            this.mParent = compositeDrawable;
        }
    }
}
