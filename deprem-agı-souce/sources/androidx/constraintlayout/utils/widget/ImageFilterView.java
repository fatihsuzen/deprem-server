package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

public class ImageFilterView extends AppCompatImageView {
    private Drawable mAltDrawable = null;
    private float mCrossfade = 0.0f;
    private Drawable mDrawable = null;
    private ImageMatrix mImageMatrix = new ImageMatrix();
    LayerDrawable mLayer;
    Drawable[] mLayers = new Drawable[2];
    private boolean mOverlay = true;
    float mPanX = Float.NaN;
    float mPanY = Float.NaN;
    private Path mPath;
    RectF mRect;
    float mRotate = Float.NaN;
    /* access modifiers changed from: private */
    public float mRound = Float.NaN;
    /* access modifiers changed from: private */
    public float mRoundPercent = 0.0f;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom = Float.NaN;

    static class ImageMatrix {
        float mBrightness = 1.0f;
        ColorMatrix mColorMatrix = new ColorMatrix();
        float mContrast = 1.0f;
        float[] mMatrix = new float[20];
        float mSaturation = 1.0f;
        ColorMatrix mTmpColorMatrix = new ColorMatrix();
        float mWarmth = 1.0f;

        ImageMatrix() {
        }

        private void brightness(float f5) {
            float[] fArr = this.mMatrix;
            fArr[0] = f5;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f5;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void saturation(float f5) {
            float f6 = 1.0f - f5;
            float f7 = 0.2999f * f6;
            float f8 = 0.587f * f6;
            float f9 = f6 * 0.114f;
            float[] fArr = this.mMatrix;
            fArr[0] = f7 + f5;
            fArr[1] = f8;
            fArr[2] = f9;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f7;
            fArr[6] = f8 + f5;
            fArr[7] = f9;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f7;
            fArr[11] = f8;
            fArr[12] = f9 + f5;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void warmth(float f5) {
            float f6;
            float f7;
            float f8;
            if (f5 <= 0.0f) {
                f5 = 0.01f;
            }
            float f9 = (5000.0f / f5) / 100.0f;
            if (f9 > 66.0f) {
                double d5 = (double) (f9 - 60.0f);
                f7 = ((float) Math.pow(d5, -0.13320475816726685d)) * 329.69873f;
                f6 = ((float) Math.pow(d5, 0.07551485300064087d)) * 288.12216f;
            } else {
                f6 = (((float) Math.log((double) f9)) * 99.4708f) - 161.11957f;
                f7 = 255.0f;
            }
            if (f9 >= 66.0f) {
                f8 = 255.0f;
            } else if (f9 > 19.0f) {
                f8 = (((float) Math.log((double) (f9 - 10.0f))) * 138.51773f) - 305.0448f;
            } else {
                f8 = 0.0f;
            }
            float min = Math.min(255.0f, Math.max(f7, 0.0f));
            float min2 = Math.min(255.0f, Math.max(f6, 0.0f));
            float min3 = Math.min(255.0f, Math.max(f8, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log((double) 50.0f)) * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log((double) 40.0f)) * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.mMatrix;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* access modifiers changed from: package-private */
        public void updateMatrix(ImageView imageView) {
            boolean z4;
            this.mColorMatrix.reset();
            float f5 = this.mSaturation;
            boolean z5 = true;
            if (f5 != 1.0f) {
                saturation(f5);
                this.mColorMatrix.set(this.mMatrix);
                z4 = true;
            } else {
                z4 = false;
            }
            float f6 = this.mContrast;
            if (f6 != 1.0f) {
                this.mTmpColorMatrix.setScale(f6, f6, f6, 1.0f);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z4 = true;
            }
            float f7 = this.mWarmth;
            if (f7 != 1.0f) {
                warmth(f7);
                this.mTmpColorMatrix.set(this.mMatrix);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z4 = true;
            }
            float f8 = this.mBrightness;
            if (f8 != 1.0f) {
                brightness(f8);
                this.mTmpColorMatrix.set(this.mMatrix);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            } else {
                z5 = z4;
            }
            if (z5) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.mAltDrawable = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.mCrossfade = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.mOverlay));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.mPanX));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.mPanY));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.mRotate));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.mZoom));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.mDrawable = drawable;
            if (this.mAltDrawable == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.mDrawable = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.mLayers;
                    Drawable mutate = drawable2.mutate();
                    this.mDrawable = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.mLayers;
            Drawable mutate2 = getDrawable().mutate();
            this.mDrawable = mutate2;
            drawableArr2[0] = mutate2;
            this.mLayers[1] = this.mAltDrawable.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
            this.mLayer = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            super.setImageDrawable(this.mLayer);
        }
    }

    private void setMatrix() {
        float f5;
        float f6;
        float f7;
        float f8;
        if (!Float.isNaN(this.mPanX) || !Float.isNaN(this.mPanY) || !Float.isNaN(this.mZoom) || !Float.isNaN(this.mRotate)) {
            float f9 = 0.0f;
            if (Float.isNaN(this.mPanX)) {
                f5 = 0.0f;
            } else {
                f5 = this.mPanX;
            }
            if (Float.isNaN(this.mPanY)) {
                f6 = 0.0f;
            } else {
                f6 = this.mPanY;
            }
            if (Float.isNaN(this.mZoom)) {
                f7 = 1.0f;
            } else {
                f7 = this.mZoom;
            }
            if (!Float.isNaN(this.mRotate)) {
                f9 = this.mRotate;
            }
            Matrix matrix = new Matrix();
            matrix.reset();
            float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
            float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
            float width = (float) getWidth();
            float height = (float) getHeight();
            if (intrinsicWidth * height < intrinsicHeight * width) {
                f8 = width / intrinsicWidth;
            } else {
                f8 = height / intrinsicHeight;
            }
            float f10 = f7 * f8;
            matrix.postScale(f10, f10);
            float f11 = intrinsicWidth * f10;
            float f12 = f10 * intrinsicHeight;
            matrix.postTranslate((((f5 * (width - f11)) + width) - f11) * 0.5f, (((f6 * (height - f12)) + height) - f12) * 0.5f);
            matrix.postRotate(f9, width / 2.0f, height / 2.0f);
            setImageMatrix(matrix);
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    private void setOverlay(boolean z4) {
        this.mOverlay = z4;
    }

    private void updateViewMatrix() {
        if (!Float.isNaN(this.mPanX) || !Float.isNaN(this.mPanY) || !Float.isNaN(this.mZoom) || !Float.isNaN(this.mRotate)) {
            setMatrix();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getImagePanX() {
        return this.mPanX;
    }

    public float getImagePanY() {
        return this.mPanY;
    }

    public float getImageRotate() {
        return this.mRotate;
    }

    public float getImageZoom() {
        return this.mZoom;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    public void layout(int i5, int i6, int i7, int i8) {
        super.layout(i5, i6, i7, i8);
        setMatrix();
    }

    public void setAltImageDrawable(Drawable drawable) {
        Drawable mutate = drawable.mutate();
        this.mAltDrawable = mutate;
        Drawable[] drawableArr = this.mLayers;
        drawableArr[0] = this.mDrawable;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
        this.mLayer = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.mCrossfade);
    }

    public void setAltImageResource(int i5) {
        Drawable drawable = AppCompatResources.getDrawable(getContext(), i5);
        this.mAltDrawable = drawable;
        setAltImageDrawable(drawable);
    }

    public void setBrightness(float f5) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mBrightness = f5;
        imageMatrix.updateMatrix(this);
    }

    public void setContrast(float f5) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mContrast = f5;
        imageMatrix.updateMatrix(this);
    }

    public void setCrossfade(float f5) {
        this.mCrossfade = f5;
        if (this.mLayers != null) {
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            super.setImageDrawable(this.mLayer);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mAltDrawable == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.mDrawable = mutate;
        Drawable[] drawableArr = this.mLayers;
        drawableArr[0] = mutate;
        drawableArr[1] = this.mAltDrawable;
        LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
        this.mLayer = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.mCrossfade);
    }

    public void setImagePanX(float f5) {
        this.mPanX = f5;
        updateViewMatrix();
    }

    public void setImagePanY(float f5) {
        this.mPanY = f5;
        updateViewMatrix();
    }

    public void setImageResource(int i5) {
        if (this.mAltDrawable != null) {
            Drawable mutate = AppCompatResources.getDrawable(getContext(), i5).mutate();
            this.mDrawable = mutate;
            Drawable[] drawableArr = this.mLayers;
            drawableArr[0] = mutate;
            drawableArr[1] = this.mAltDrawable;
            LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
            this.mLayer = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.mCrossfade);
            return;
        }
        super.setImageResource(i5);
    }

    public void setImageRotate(float f5) {
        this.mRotate = f5;
        updateViewMatrix();
    }

    public void setImageZoom(float f5) {
        this.mZoom = f5;
        updateViewMatrix();
    }

    @RequiresApi(21)
    public void setRound(float f5) {
        boolean z4;
        if (Float.isNaN(f5)) {
            this.mRound = f5;
            float f6 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f6);
            return;
        }
        if (this.mRound != f5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mRound = f5;
        if (f5 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                AnonymousClass2 r5 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.mRound);
                    }
                };
                this.mViewOutlineProvider = r5;
                setOutlineProvider(r5);
            }
            setClipToOutline(true);
            this.mRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.mRect;
            float f7 = this.mRound;
            path.addRoundRect(rectF, f7, f7, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z4) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f5) {
        boolean z4;
        if (this.mRoundPercent != f5) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mRoundPercent = f5;
        if (f5 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            if (this.mViewOutlineProvider == null) {
                AnonymousClass1 r6 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = ImageFilterView.this.getWidth();
                        int height = ImageFilterView.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterView.this.mRoundPercent) / 2.0f);
                    }
                };
                this.mViewOutlineProvider = r6;
                setOutlineProvider(r6);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, (float) width, (float) height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z4) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f5) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mSaturation = f5;
        imageMatrix.updateMatrix(this);
    }

    public void setWarmth(float f5) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.mWarmth = f5;
        imageMatrix.updateMatrix(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        init(context, attributeSet);
    }
}
