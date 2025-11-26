package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.view.GravityCompat;
import j$.util.Objects;

public class MotionLabel extends View implements FloatLayout {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    static final String TAG = "MotionLabel";
    private boolean mAutoSize = false;
    private int mAutoSizeTextType = 0;
    float mBackgroundPanX = Float.NaN;
    float mBackgroundPanY = Float.NaN;
    private float mBaseTextSize = Float.NaN;
    private float mDeltaLeft;
    private float mFloatHeight;
    private float mFloatWidth;
    private String mFontFamily;
    private int mGravity = 8388659;
    private Layout mLayout;
    boolean mNotBuilt = true;
    Matrix mOutlinePositionMatrix;
    private int mPaddingBottom = 1;
    private int mPaddingLeft = 1;
    private int mPaddingRight = 1;
    private int mPaddingTop = 1;
    TextPaint mPaint = new TextPaint();
    Paint mPaintCache = new Paint();
    float mPaintTextSize;
    Path mPath = new Path();
    RectF mRect;
    float mRotate = Float.NaN;
    /* access modifiers changed from: private */
    public float mRound = Float.NaN;
    /* access modifiers changed from: private */
    public float mRoundPercent = 0.0f;
    private int mStyleIndex;
    Paint mTempPaint;
    Rect mTempRect;
    private String mText = "Hello World";
    private Drawable mTextBackground;
    private Bitmap mTextBackgroundBitmap;
    private Rect mTextBounds = new Rect();
    private int mTextFillColor = 65535;
    private int mTextOutlineColor = 65535;
    private float mTextOutlineThickness = 0.0f;
    private float mTextPanX = 0.0f;
    private float mTextPanY = 0.0f;
    private BitmapShader mTextShader;
    private Matrix mTextShaderMatrix;
    private float mTextSize = 48.0f;
    private int mTextureEffect = 0;
    private float mTextureHeight = Float.NaN;
    private float mTextureWidth = Float.NaN;
    private int mTypefaceIndex;
    private boolean mUseOutline = false;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom = Float.NaN;

    public MotionLabel(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void adjustTexture(float f5, float f6, float f7, float f8) {
        if (this.mTextShaderMatrix != null) {
            this.mFloatWidth = f7 - f5;
            this.mFloatHeight = f8 - f6;
            updateShaderMatrix();
        }
    }

    private float getHorizontalOffset() {
        float f5;
        float f6;
        if (Float.isNaN(this.mBaseTextSize)) {
            f5 = 1.0f;
        } else {
            f5 = this.mTextSize / this.mBaseTextSize;
        }
        TextPaint textPaint = this.mPaint;
        String str = this.mText;
        float measureText = f5 * textPaint.measureText(str, 0, str.length());
        if (Float.isNaN(this.mFloatWidth)) {
            f6 = (float) getMeasuredWidth();
        } else {
            f6 = this.mFloatWidth;
        }
        return ((((f6 - ((float) getPaddingLeft())) - ((float) getPaddingRight())) - measureText) * (this.mTextPanX + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f5;
        float f6;
        if (Float.isNaN(this.mBaseTextSize)) {
            f5 = 1.0f;
        } else {
            f5 = this.mTextSize / this.mBaseTextSize;
        }
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        if (Float.isNaN(this.mFloatHeight)) {
            f6 = (float) getMeasuredHeight();
        } else {
            f6 = this.mFloatHeight;
        }
        float paddingTop = (f6 - ((float) getPaddingTop())) - ((float) getPaddingBottom());
        float f7 = fontMetrics.descent;
        float f8 = fontMetrics.ascent;
        return (((paddingTop - ((f7 - f8) * f5)) * (1.0f - this.mTextPanY)) / 2.0f) - (f5 * f8);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setUpTheme(context);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R.styleable.MotionLabel_android_fontFamily) {
                    this.mFontFamily = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MotionLabel_scaleFromTextSize) {
                    this.mBaseTextSize = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mBaseTextSize);
                } else if (index == R.styleable.MotionLabel_android_textSize) {
                    this.mTextSize = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mTextSize);
                } else if (index == R.styleable.MotionLabel_android_textStyle) {
                    this.mStyleIndex = obtainStyledAttributes.getInt(index, this.mStyleIndex);
                } else if (index == R.styleable.MotionLabel_android_typeface) {
                    this.mTypefaceIndex = obtainStyledAttributes.getInt(index, this.mTypefaceIndex);
                } else if (index == R.styleable.MotionLabel_android_textColor) {
                    this.mTextFillColor = obtainStyledAttributes.getColor(index, this.mTextFillColor);
                } else if (index == R.styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.mRound);
                    this.mRound = dimension;
                    setRound(dimension);
                } else if (index == R.styleable.MotionLabel_borderRoundPercent) {
                    float f5 = obtainStyledAttributes.getFloat(index, this.mRoundPercent);
                    this.mRoundPercent = f5;
                    setRoundPercent(f5);
                } else if (index == R.styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.mAutoSizeTextType = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.MotionLabel_textOutlineColor) {
                    this.mTextOutlineColor = obtainStyledAttributes.getInt(index, this.mTextOutlineColor);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textOutlineThickness) {
                    this.mTextOutlineThickness = obtainStyledAttributes.getDimension(index, this.mTextOutlineThickness);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textBackground) {
                    this.mTextBackground = obtainStyledAttributes.getDrawable(index);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textBackgroundPanX) {
                    this.mBackgroundPanX = obtainStyledAttributes.getFloat(index, this.mBackgroundPanX);
                } else if (index == R.styleable.MotionLabel_textBackgroundPanY) {
                    this.mBackgroundPanY = obtainStyledAttributes.getFloat(index, this.mBackgroundPanY);
                } else if (index == R.styleable.MotionLabel_textPanX) {
                    this.mTextPanX = obtainStyledAttributes.getFloat(index, this.mTextPanX);
                } else if (index == R.styleable.MotionLabel_textPanY) {
                    this.mTextPanY = obtainStyledAttributes.getFloat(index, this.mTextPanY);
                } else if (index == R.styleable.MotionLabel_textBackgroundRotate) {
                    this.mRotate = obtainStyledAttributes.getFloat(index, this.mRotate);
                } else if (index == R.styleable.MotionLabel_textBackgroundZoom) {
                    this.mZoom = obtainStyledAttributes.getFloat(index, this.mZoom);
                } else if (index == R.styleable.MotionLabel_textureHeight) {
                    this.mTextureHeight = obtainStyledAttributes.getDimension(index, this.mTextureHeight);
                } else if (index == R.styleable.MotionLabel_textureWidth) {
                    this.mTextureWidth = obtainStyledAttributes.getDimension(index, this.mTextureWidth);
                } else if (index == R.styleable.MotionLabel_textureEffect) {
                    this.mTextureEffect = obtainStyledAttributes.getInt(index, this.mTextureEffect);
                }
            }
            obtainStyledAttributes.recycle();
        }
        setupTexture();
        setupPath();
    }

    private void setTypefaceFromAttrs(String str, int i5, int i6) {
        Typeface typeface;
        Typeface typeface2;
        int i7;
        if (str != null) {
            typeface = Typeface.create(str, i6);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        boolean z4 = true;
        if (i5 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i5 == 2) {
            typeface = Typeface.SERIF;
        } else if (i5 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        float f5 = 0.0f;
        if (i6 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i6);
            } else {
                typeface2 = Typeface.create(typeface, i6);
            }
            setTypeface(typeface2);
            if (typeface2 != null) {
                i7 = typeface2.getStyle();
            } else {
                i7 = 0;
            }
            int i8 = (~i7) & i6;
            TextPaint textPaint = this.mPaint;
            if ((i8 & 1) == 0) {
                z4 = false;
            }
            textPaint.setFakeBoldText(z4);
            TextPaint textPaint2 = this.mPaint;
            if ((i8 & 2) != 0) {
                f5 = -0.25f;
            }
            textPaint2.setTextSkewX(f5);
            return;
        }
        this.mPaint.setFakeBoldText(false);
        this.mPaint.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    private void setUpTheme(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.mPaint;
        int i5 = typedValue.data;
        this.mTextFillColor = i5;
        textPaint.setColor(i5);
    }

    private void setupTexture() {
        if (this.mTextBackground != null) {
            this.mTextShaderMatrix = new Matrix();
            int intrinsicWidth = this.mTextBackground.getIntrinsicWidth();
            int intrinsicHeight = this.mTextBackground.getIntrinsicHeight();
            int i5 = 128;
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                if (Float.isNaN(this.mTextureWidth)) {
                    intrinsicWidth = 128;
                } else {
                    intrinsicWidth = (int) this.mTextureWidth;
                }
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                if (!Float.isNaN(this.mTextureHeight)) {
                    i5 = (int) this.mTextureHeight;
                }
                intrinsicHeight = i5;
            }
            if (this.mTextureEffect != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.mTextBackgroundBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.mTextBackgroundBitmap);
            this.mTextBackground.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.mTextBackground.setFilterBitmap(true);
            this.mTextBackground.draw(canvas);
            if (this.mTextureEffect != 0) {
                this.mTextBackgroundBitmap = blur(this.mTextBackgroundBitmap, 4);
            }
            Bitmap bitmap = this.mTextBackgroundBitmap;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.mTextShader = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void updateShaderMatrix() {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11 = 0.0f;
        if (Float.isNaN(this.mBackgroundPanX)) {
            f5 = 0.0f;
        } else {
            f5 = this.mBackgroundPanX;
        }
        if (Float.isNaN(this.mBackgroundPanY)) {
            f6 = 0.0f;
        } else {
            f6 = this.mBackgroundPanY;
        }
        if (Float.isNaN(this.mZoom)) {
            f7 = 1.0f;
        } else {
            f7 = this.mZoom;
        }
        if (!Float.isNaN(this.mRotate)) {
            f11 = this.mRotate;
        }
        this.mTextShaderMatrix.reset();
        float width = (float) this.mTextBackgroundBitmap.getWidth();
        float height = (float) this.mTextBackgroundBitmap.getHeight();
        if (Float.isNaN(this.mTextureWidth)) {
            f8 = this.mFloatWidth;
        } else {
            f8 = this.mTextureWidth;
        }
        if (Float.isNaN(this.mTextureHeight)) {
            f9 = this.mFloatHeight;
        } else {
            f9 = this.mTextureHeight;
        }
        if (width * f9 < height * f8) {
            f10 = f8 / width;
        } else {
            f10 = f9 / height;
        }
        float f12 = f7 * f10;
        this.mTextShaderMatrix.postScale(f12, f12);
        float f13 = width * f12;
        float f14 = f8 - f13;
        float f15 = f12 * height;
        float f16 = f9 - f15;
        if (!Float.isNaN(this.mTextureHeight)) {
            f16 = this.mTextureHeight / 2.0f;
        }
        if (!Float.isNaN(this.mTextureWidth)) {
            f14 = this.mTextureWidth / 2.0f;
        }
        this.mTextShaderMatrix.postTranslate((((f5 * f14) + f8) - f13) * 0.5f, (((f6 * f16) + f9) - f15) * 0.5f);
        this.mTextShaderMatrix.postRotate(f11, f8 / 2.0f, f9 / 2.0f);
        this.mTextShader.setLocalMatrix(this.mTextShaderMatrix);
    }

    /* access modifiers changed from: package-private */
    public Bitmap blur(Bitmap bitmap, int i5) {
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i6 = 0; i6 < i5 && width >= 32 && height >= 32; i6++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    /* access modifiers changed from: package-private */
    public void buildShape(float f5) {
        if (this.mUseOutline || f5 != 1.0f) {
            this.mPath.reset();
            String str = this.mText;
            int length = str.length();
            this.mPaint.getTextBounds(str, 0, length, this.mTextBounds);
            this.mPaint.getTextPath(str, 0, length, 0.0f, 0.0f, this.mPath);
            if (f5 != 1.0f) {
                Log.v(TAG, Debug.getLoc() + " scale " + f5);
                Matrix matrix = new Matrix();
                matrix.postScale(f5, f5);
                this.mPath.transform(matrix);
            }
            Rect rect = this.mTextBounds;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = (float) getHeight();
            rectF.right = (float) getWidth();
            this.mNotBuilt = false;
        }
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getScaleFromTextSize() {
        return this.mBaseTextSize;
    }

    public float getTextBackgroundPanX() {
        return this.mBackgroundPanX;
    }

    public float getTextBackgroundPanY() {
        return this.mBackgroundPanY;
    }

    public float getTextBackgroundRotate() {
        return this.mRotate;
    }

    public float getTextBackgroundZoom() {
        return this.mZoom;
    }

    public int getTextOutlineColor() {
        return this.mTextOutlineColor;
    }

    public float getTextPanX() {
        return this.mTextPanX;
    }

    public float getTextPanY() {
        return this.mTextPanY;
    }

    public float getTextureHeight() {
        return this.mTextureHeight;
    }

    public float getTextureWidth() {
        return this.mTextureWidth;
    }

    public Typeface getTypeface() {
        return this.mPaint.getTypeface();
    }

    public void layout(int i5, int i6, int i7, int i8) {
        float f5;
        super.layout(i5, i6, i7, i8);
        boolean isNaN = Float.isNaN(this.mBaseTextSize);
        if (isNaN) {
            f5 = 1.0f;
        } else {
            f5 = this.mTextSize / this.mBaseTextSize;
        }
        this.mFloatWidth = (float) (i7 - i5);
        this.mFloatHeight = (float) (i8 - i6);
        if (this.mAutoSize) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.mPaintTextSize = this.mTempPaint.getTextSize();
            }
            Paint paint = this.mTempPaint;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            int width = this.mTempRect.width();
            int height = (int) (((float) this.mTempRect.height()) * 1.3f);
            float f6 = (this.mFloatWidth - ((float) this.mPaddingRight)) - ((float) this.mPaddingLeft);
            float f7 = (this.mFloatHeight - ((float) this.mPaddingBottom)) - ((float) this.mPaddingTop);
            if (isNaN) {
                float f8 = (float) width;
                float f9 = (float) height;
                if (f8 * f7 > f9 * f6) {
                    this.mPaint.setTextSize((this.mPaintTextSize * f6) / f8);
                } else {
                    this.mPaint.setTextSize((this.mPaintTextSize * f7) / f9);
                }
            } else {
                float f10 = (float) width;
                float f11 = (float) height;
                f5 = f10 * f7 > f11 * f6 ? f6 / f10 : f7 / f11;
            }
        }
        if (this.mUseOutline || !isNaN) {
            adjustTexture((float) i5, (float) i6, (float) i7, (float) i8);
            buildShape(f5);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        float f5;
        if (Float.isNaN(this.mBaseTextSize)) {
            f5 = 1.0f;
        } else {
            f5 = this.mTextSize / this.mBaseTextSize;
        }
        super.onDraw(canvas);
        if (this.mUseOutline || f5 != 1.0f) {
            if (this.mNotBuilt) {
                buildShape(f5);
            }
            if (this.mOutlinePositionMatrix == null) {
                this.mOutlinePositionMatrix = new Matrix();
            }
            if (this.mUseOutline) {
                this.mPaintCache.set(this.mPaint);
                this.mOutlinePositionMatrix.reset();
                float horizontalOffset = ((float) this.mPaddingLeft) + getHorizontalOffset();
                float verticalOffset = ((float) this.mPaddingTop) + getVerticalOffset();
                this.mOutlinePositionMatrix.postTranslate(horizontalOffset, verticalOffset);
                this.mOutlinePositionMatrix.preScale(f5, f5);
                this.mPath.transform(this.mOutlinePositionMatrix);
                if (this.mTextShader != null) {
                    this.mPaint.setFilterBitmap(true);
                    this.mPaint.setShader(this.mTextShader);
                } else {
                    this.mPaint.setColor(this.mTextFillColor);
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
                canvas.drawPath(this.mPath, this.mPaint);
                if (this.mTextShader != null) {
                    this.mPaint.setShader((Shader) null);
                }
                this.mPaint.setColor(this.mTextOutlineColor);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
                canvas.drawPath(this.mPath, this.mPaint);
                this.mOutlinePositionMatrix.reset();
                this.mOutlinePositionMatrix.postTranslate(-horizontalOffset, -verticalOffset);
                this.mPath.transform(this.mOutlinePositionMatrix);
                this.mPaint.set(this.mPaintCache);
                return;
            }
            float horizontalOffset2 = ((float) this.mPaddingLeft) + getHorizontalOffset();
            float verticalOffset2 = ((float) this.mPaddingTop) + getVerticalOffset();
            this.mOutlinePositionMatrix.reset();
            this.mOutlinePositionMatrix.preTranslate(horizontalOffset2, verticalOffset2);
            this.mPath.transform(this.mOutlinePositionMatrix);
            this.mPaint.setColor(this.mTextFillColor);
            this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
            canvas.drawPath(this.mPath, this.mPaint);
            this.mOutlinePositionMatrix.reset();
            this.mOutlinePositionMatrix.preTranslate(-horizontalOffset2, -verticalOffset2);
            this.mPath.transform(this.mOutlinePositionMatrix);
            return;
        }
        canvas.drawText(this.mText, this.mDeltaLeft + ((float) this.mPaddingLeft) + getHorizontalOffset(), ((float) this.mPaddingTop) + getVerticalOffset(), this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        this.mAutoSize = false;
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.mPaint;
            String str = this.mText;
            textPaint.getTextBounds(str, 0, str.length(), this.mTextBounds);
            if (mode != 1073741824) {
                size = (int) (((float) this.mTextBounds.width()) + 0.99999f);
            }
            size += this.mPaddingLeft + this.mPaddingRight;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (((float) this.mPaint.getFontMetricsInt((Paint.FontMetricsInt) null)) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.mPaddingTop + this.mPaddingBottom + fontMetricsInt;
            }
        } else if (this.mAutoSizeTextType != 0) {
            this.mAutoSize = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i5) {
        if ((i5 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
            i5 |= GravityCompat.START;
        }
        if ((i5 & 112) == 0) {
            i5 |= 48;
        }
        if (i5 != this.mGravity) {
            invalidate();
        }
        this.mGravity = i5;
        int i6 = i5 & 112;
        if (i6 == 48) {
            this.mTextPanY = -1.0f;
        } else if (i6 != 80) {
            this.mTextPanY = 0.0f;
        } else {
            this.mTextPanY = 1.0f;
        }
        int i7 = i5 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i7 != 3) {
            if (i7 != 5) {
                if (i7 != 8388611) {
                    if (i7 != 8388613) {
                        this.mTextPanX = 0.0f;
                        return;
                    }
                }
            }
            this.mTextPanX = 1.0f;
            return;
        }
        this.mTextPanX = -1.0f;
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
                        outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.mRound);
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
                        int width = MotionLabel.this.getWidth();
                        int height = MotionLabel.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionLabel.this.mRoundPercent) / 2.0f);
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

    public void setScaleFromTextSize(float f5) {
        this.mBaseTextSize = f5;
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f5) {
        this.mBackgroundPanX = f5;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundPanY(float f5) {
        this.mBackgroundPanY = f5;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundRotate(float f5) {
        this.mRotate = f5;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundZoom(float f5) {
        this.mZoom = f5;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextFillColor(int i5) {
        this.mTextFillColor = i5;
        invalidate();
    }

    public void setTextOutlineColor(int i5) {
        this.mTextOutlineColor = i5;
        this.mUseOutline = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f5) {
        this.mTextOutlineThickness = f5;
        this.mUseOutline = true;
        if (Float.isNaN(f5)) {
            this.mTextOutlineThickness = 1.0f;
            this.mUseOutline = false;
        }
        invalidate();
    }

    public void setTextPanX(float f5) {
        this.mTextPanX = f5;
        invalidate();
    }

    public void setTextPanY(float f5) {
        this.mTextPanY = f5;
        invalidate();
    }

    public void setTextSize(float f5) {
        float f6;
        this.mTextSize = f5;
        TextPaint textPaint = this.mPaint;
        if (!Float.isNaN(this.mBaseTextSize)) {
            f5 = this.mBaseTextSize;
        }
        textPaint.setTextSize(f5);
        if (Float.isNaN(this.mBaseTextSize)) {
            f6 = 1.0f;
        } else {
            f6 = this.mTextSize / this.mBaseTextSize;
        }
        buildShape(f6);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f5) {
        this.mTextureHeight = f5;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextureWidth(float f5) {
        this.mTextureWidth = f5;
        updateShaderMatrix();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (!Objects.equals(this.mPaint.getTypeface(), typeface)) {
            this.mPaint.setTypeface(typeface);
            if (this.mLayout != null) {
                this.mLayout = null;
                requestLayout();
                invalidate();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setupPath() {
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        setTypefaceFromAttrs(this.mFontFamily, this.mTypefaceIndex, this.mStyleIndex);
        this.mPaint.setColor(this.mTextFillColor);
        this.mPaint.setStrokeWidth(this.mTextOutlineThickness);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setFlags(128);
        setTextSize(this.mTextSize);
        this.mPaint.setAntiAlias(true);
    }

    public void layout(float f5, float f6, float f7, float f8) {
        int i5 = (int) (f5 + 0.5f);
        this.mDeltaLeft = f5 - ((float) i5);
        int i6 = (int) (f7 + 0.5f);
        int i7 = i6 - i5;
        int i8 = (int) (f8 + 0.5f);
        int i9 = (int) (0.5f + f6);
        int i10 = i8 - i9;
        float f9 = f7 - f5;
        this.mFloatWidth = f9;
        float f10 = f8 - f6;
        this.mFloatHeight = f10;
        adjustTexture(f5, f6, f7, f8);
        if (getMeasuredHeight() == i10 && getMeasuredWidth() == i7) {
            super.layout(i5, i9, i6, i8);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
            super.layout(i5, i9, i6, i8);
        }
        if (this.mAutoSize) {
            if (this.mTempRect == null) {
                this.mTempPaint = new Paint();
                this.mTempRect = new Rect();
                this.mTempPaint.set(this.mPaint);
                this.mPaintTextSize = this.mTempPaint.getTextSize();
            }
            this.mFloatWidth = f9;
            this.mFloatHeight = f10;
            Paint paint = this.mTempPaint;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.mTempRect);
            int width = this.mTempRect.width();
            float height = ((float) this.mTempRect.height()) * 1.3f;
            float f11 = (f9 - ((float) this.mPaddingRight)) - ((float) this.mPaddingLeft);
            float f12 = (f10 - ((float) this.mPaddingBottom)) - ((float) this.mPaddingTop);
            float f13 = (float) width;
            if (f13 * f12 > height * f11) {
                this.mPaint.setTextSize((this.mPaintTextSize * f11) / f13);
            } else {
                this.mPaint.setTextSize((this.mPaintTextSize * f12) / height);
            }
            if (this.mUseOutline || !Float.isNaN(this.mBaseTextSize)) {
                buildShape(Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize);
            }
        }
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        init(context, attributeSet);
    }
}
