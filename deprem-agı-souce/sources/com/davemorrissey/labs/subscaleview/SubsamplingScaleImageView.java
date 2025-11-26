package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    /* access modifiers changed from: private */
    public static final String TAG = "SubsamplingScaleImageView";
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public static final List<Integer> VALID_EASING_STYLES = Arrays.asList(new Integer[]{2, 1});
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(new Integer[]{0, 90, Integer.valueOf(ORIENTATION_180), Integer.valueOf(ORIENTATION_270), -1});
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(new Integer[]{1, 2, 3});
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(new Integer[]{2, 1, 3, 4});
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(new Integer[]{1, 2, 3});
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static Bitmap.Config preferredBitmapConfig;
    /* access modifiers changed from: private */
    public Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private ImageRegionDecoder decoder;
    /* access modifiers changed from: private */
    public final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    /* access modifiers changed from: private */
    public boolean isQuickScaling;
    /* access modifiers changed from: private */
    public boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    /* access modifiers changed from: private */
    public int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    /* access modifiers changed from: private */
    public OnImageEventListener onImageEventListener;
    /* access modifiers changed from: private */
    public View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    /* access modifiers changed from: private */
    public boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    /* access modifiers changed from: private */
    public boolean quickScaleEnabled;
    /* access modifiers changed from: private */
    public float quickScaleLastDistance;
    /* access modifiers changed from: private */
    public boolean quickScaleMoved;
    /* access modifiers changed from: private */
    public PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    /* access modifiers changed from: private */
    public PointF quickScaleVLastPoint;
    /* access modifiers changed from: private */
    public PointF quickScaleVStart;
    /* access modifiers changed from: private */
    public boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    /* access modifiers changed from: private */
    public Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    /* access modifiers changed from: private */
    public float scale;
    /* access modifiers changed from: private */
    public float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    /* access modifiers changed from: private */
    public PointF vCenterStart;
    private float vDistStart;
    /* access modifiers changed from: private */
    public PointF vTranslate;
    private PointF vTranslateBefore;
    /* access modifiers changed from: private */
    public PointF vTranslateStart;
    /* access modifiers changed from: private */
    public boolean zoomEnabled;

    private static class Anim {
        /* access modifiers changed from: private */
        public long duration;
        /* access modifiers changed from: private */
        public int easing;
        /* access modifiers changed from: private */
        public boolean interruptible;
        /* access modifiers changed from: private */
        public OnAnimationEventListener listener;
        /* access modifiers changed from: private */
        public int origin;
        /* access modifiers changed from: private */
        public PointF sCenterEnd;
        /* access modifiers changed from: private */
        public PointF sCenterEndRequested;
        /* access modifiers changed from: private */
        public PointF sCenterStart;
        /* access modifiers changed from: private */
        public float scaleEnd;
        /* access modifiers changed from: private */
        public float scaleStart;
        /* access modifiers changed from: private */
        public long time;
        /* access modifiers changed from: private */
        public PointF vFocusEnd;
        /* access modifiers changed from: private */
        public PointF vFocusStart;

        private Anim() {
            this.duration = 500;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }
    }

    private static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z4) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z4;
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new Object[0]);
                this.bitmap = ((ImageDecoder) decoderFactory.make()).decode(context, this.source);
                return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(context, uri));
            } catch (Exception e5) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e5);
                this.exception = e5;
                return null;
            } catch (OutOfMemoryError e6) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e6);
                this.exception = new RuntimeException(e6);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 == null || num == null) {
                    if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                        if (this.preview) {
                            subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                        } else {
                            subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                        }
                    }
                } else if (this.preview) {
                    subsamplingScaleImageView.onPreviewLoaded(bitmap2);
                } else {
                    subsamplingScaleImageView.onImageLoaded(bitmap2, num.intValue(), false);
                }
            }
        }
    }

    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        public void onComplete() {
        }

        public void onInterruptedByNewAnim() {
        }

        public void onInterruptedByUser() {
        }
    }

    public static class DefaultOnImageEventListener implements OnImageEventListener {
        public void onImageLoadError(Exception exc) {
        }

        public void onImageLoaded() {
        }

        public void onPreviewLoadError(Exception exc) {
        }

        public void onPreviewReleased() {
        }

        public void onReady() {
        }

        public void onTileLoadError(Exception exc) {
        }
    }

    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        public void onCenterChanged(PointF pointF, int i5) {
        }

        public void onScaleChanged(float f5, int i5) {
        }
    }

    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    public interface OnStateChangedListener {
        void onCenterChanged(PointF pointF, int i5);

        void onScaleChanged(float f5, int i5);
    }

    private static class ScaleAndTranslate {
        /* access modifiers changed from: private */
        public float scale;
        /* access modifiers changed from: private */
        public final PointF vTranslate;

        private ScaleAndTranslate(float f5, PointF pointF) {
            this.scale = f5;
            this.vTranslate = pointF;
        }
    }

    private static class Tile {
        /* access modifiers changed from: private */
        public Bitmap bitmap;
        /* access modifiers changed from: private */
        public Rect fileSRect;
        /* access modifiers changed from: private */
        public boolean loading;
        /* access modifiers changed from: private */
        public Rect sRect;
        /* access modifiers changed from: private */
        public int sampleSize;
        /* access modifiers changed from: private */
        public Rect vRect;
        /* access modifiers changed from: private */
        public boolean visible;

        private Tile() {
        }
    }

    private static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            boolean unused = tile.loading = true;
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(Void... voidArr) {
            SubsamplingScaleImageView subsamplingScaleImageView;
            try {
                subsamplingScaleImageView = this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = this.decoderRef.get();
                Tile tile = this.tileRef.get();
                if (imageRegionDecoder != null && tile != null && subsamplingScaleImageView != null && imageRegionDecoder.isReady() && tile.visible) {
                    subsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, Integer.valueOf(tile.sampleSize));
                    subsamplingScaleImageView.decoderLock.readLock().lock();
                    if (imageRegionDecoder.isReady()) {
                        subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                        if (subsamplingScaleImageView.sRegion != null) {
                            tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                        }
                        Bitmap decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                        subsamplingScaleImageView.decoderLock.readLock().unlock();
                        return decodeRegion;
                    }
                    boolean unused = tile.loading = false;
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                    return null;
                } else if (tile == null) {
                    return null;
                } else {
                    boolean unused2 = tile.loading = false;
                    return null;
                }
            } catch (Exception e5) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e5);
                this.exception = e5;
                return null;
            } catch (OutOfMemoryError e6) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e6);
                this.exception = new RuntimeException(e6);
                return null;
            } catch (Throwable th) {
                subsamplingScaleImageView.decoderLock.readLock().unlock();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            Tile tile = this.tileRef.get();
            if (subsamplingScaleImageView != null && tile != null) {
                if (bitmap != null) {
                    Bitmap unused = tile.bitmap = bitmap;
                    boolean unused2 = tile.loading = false;
                    subsamplingScaleImageView.onTileLoaded();
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
                }
            }
        }
    }

    private static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        /* access modifiers changed from: protected */
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("TilesInitTask.doInBackground", new Object[0]);
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) decoderFactory.make();
                this.decoder = imageRegionDecoder;
                Point init = imageRegionDecoder.init(context, this.source);
                int i5 = init.x;
                int i6 = init.y;
                int access$5200 = subsamplingScaleImageView.getExifOrientation(context, uri);
                if (subsamplingScaleImageView.sRegion != null) {
                    subsamplingScaleImageView.sRegion.left = Math.max(0, subsamplingScaleImageView.sRegion.left);
                    subsamplingScaleImageView.sRegion.top = Math.max(0, subsamplingScaleImageView.sRegion.top);
                    subsamplingScaleImageView.sRegion.right = Math.min(i5, subsamplingScaleImageView.sRegion.right);
                    subsamplingScaleImageView.sRegion.bottom = Math.min(i6, subsamplingScaleImageView.sRegion.bottom);
                    i5 = subsamplingScaleImageView.sRegion.width();
                    i6 = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{i5, i6, access$5200};
            } catch (Exception e5) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e5);
                this.exception = e5;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message.what == 1 && SubsamplingScaleImageView.this.onLongClickListener != null) {
                    int unused = SubsamplingScaleImageView.this.maxTouchCount = 0;
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.super.setOnLongClickListener((View.OnLongClickListener) null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            int i5 = R.styleable.SubsamplingScaleImageView_assetName;
            if (obtainStyledAttributes.hasValue(i5) && (string = obtainStyledAttributes.getString(i5)) != null && string.length() > 0) {
                setImage(ImageSource.asset(string).tilingEnabled());
            }
            int i6 = R.styleable.SubsamplingScaleImageView_src;
            if (obtainStyledAttributes.hasValue(i6) && (resourceId = obtainStyledAttributes.getResourceId(i6, 0)) > 0) {
                setImage(ImageSource.resource(resourceId).tilingEnabled());
            }
            int i7 = R.styleable.SubsamplingScaleImageView_panEnabled;
            if (obtainStyledAttributes.hasValue(i7)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(i7, true));
            }
            int i8 = R.styleable.SubsamplingScaleImageView_zoomEnabled;
            if (obtainStyledAttributes.hasValue(i8)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(i8, true));
            }
            int i9 = R.styleable.SubsamplingScaleImageView_quickScaleEnabled;
            if (obtainStyledAttributes.hasValue(i9)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(i9, true));
            }
            int i10 = R.styleable.SubsamplingScaleImageView_tileBackgroundColor;
            if (obtainStyledAttributes.hasValue(i10)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(i10, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int calculateInSampleSize(float f5) {
        int i5;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f5 *= ((float) this.minimumTileDpi) / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth2 = (int) (((float) sWidth()) * f5);
        int sHeight2 = (int) (((float) sHeight()) * f5);
        if (sWidth2 == 0 || sHeight2 == 0) {
            return 32;
        }
        int i6 = 1;
        if (sHeight() > sHeight2 || sWidth() > sWidth2) {
            i5 = Math.round(((float) sHeight()) / ((float) sHeight2));
            int round = Math.round(((float) sWidth()) / ((float) sWidth2));
            if (i5 >= round) {
                i5 = round;
            }
        } else {
            i5 = 1;
        }
        while (true) {
            int i7 = i6 * 2;
            if (i7 >= i5) {
                return i6;
            }
            i6 = i7;
        }
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onImageLoaded();
            }
        }
        return isBaseLayerReady;
    }

    private boolean checkReady() {
        boolean z4;
        if (getWidth() <= 0 || getHeight() <= 0 || this.sWidth <= 0 || this.sHeight <= 0 || (this.bitmap == null && !isBaseLayerReady())) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!this.readySent && z4) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onReady();
            }
        }
        return z4;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            Paint paint = new Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            Paint paint2 = new Paint();
            this.debugTextPaint = paint2;
            paint2.setTextSize((float) px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.debugLinePaint = paint3;
            paint3.setColor(-65281);
            this.debugLinePaint.setStyle(Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth((float) px(1));
        }
    }

    /* access modifiers changed from: private */
    @AnyThread
    public void debug(String str, Object... objArr) {
        if (this.debug) {
            Log.d(TAG, String.format(str, objArr));
        }
    }

    private float distance(float f5, float f6, float f7, float f8) {
        float f9 = f5 - f6;
        float f10 = f7 - f8;
        return (float) Math.sqrt((double) ((f9 * f9) + (f10 * f10)));
    }

    /* access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        boolean z4;
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = (float) (sWidth() / 2);
                pointF.y = (float) (sHeight() / 2);
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        float f5 = this.scale;
        if (((double) f5) <= ((double) min) * 0.9d || f5 == this.minScale) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            min = minScale();
        }
        float f6 = min;
        int i5 = this.doubleTapZoomStyle;
        if (i5 == 3) {
            setScaleAndCenter(f6, pointF);
        } else if (i5 == 2 || !z4 || !this.panEnabled) {
            new AnimationBuilder(f6, pointF).withInterruptible(false).withDuration((long) this.doubleTapZoomDuration).withOrigin(4).start();
            invalidate();
        } else if (i5 == 1) {
            new AnimationBuilder(f6, pointF, pointF2).withInterruptible(false).withDuration((long) this.doubleTapZoomDuration).withOrigin(4).start();
            invalidate();
        }
        invalidate();
    }

    private float ease(int i5, long j5, float f5, float f6, long j6) {
        if (i5 == 1) {
            return easeOutQuad(j5, f5, f6, j6);
        }
        if (i5 == 2) {
            return easeInOutQuad(j5, f5, f6, j6);
        }
        throw new IllegalStateException("Unexpected easing type: " + i5);
    }

    private float easeInOutQuad(long j5, float f5, float f6, long j6) {
        float f7;
        float f8 = ((float) j5) / (((float) j6) / 2.0f);
        if (f8 < 1.0f) {
            f7 = (f6 / 2.0f) * f8;
        } else {
            float f9 = f8 - 1.0f;
            f7 = (-f6) / 2.0f;
            f8 = (f9 * (f9 - 2.0f)) - 1.0f;
        }
        return (f7 * f8) + f5;
    }

    private float easeOutQuad(long j5, float f5, float f6, long j6) {
        float f7 = ((float) j5) / ((float) j6);
        return ((-f6) * f7 * (f7 - 2.0f)) + f5;
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new Void[0]);
    }

    /* access modifiers changed from: private */
    @AnyThread
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            int i5 = rect.top;
            int i6 = this.sHeight;
            rect2.set(i5, i6 - rect.right, rect.bottom, i6 - rect.left);
        } else if (getRequiredRotation() == 180) {
            int i7 = this.sWidth;
            int i8 = this.sHeight;
            rect2.set(i7 - rect.right, i8 - rect.bottom, i7 - rect.left, i8 - rect.top);
        } else {
            int i9 = this.sWidth;
            rect2.set(i9 - rect.bottom, rect.left, i9 - rect.top, rect.right);
        }
    }

    /* access modifiers changed from: private */
    public void fitToBounds(boolean z4, ScaleAndTranslate scaleAndTranslate) {
        float f5;
        float f6;
        int max;
        if (this.panLimit == 2 && isReady()) {
            z4 = false;
        }
        PointF access$4800 = scaleAndTranslate.vTranslate;
        float limitedScale = limitedScale(scaleAndTranslate.scale);
        float sWidth2 = ((float) sWidth()) * limitedScale;
        float sHeight2 = ((float) sHeight()) * limitedScale;
        if (this.panLimit == 3 && isReady()) {
            access$4800.x = Math.max(access$4800.x, ((float) (getWidth() / 2)) - sWidth2);
            access$4800.y = Math.max(access$4800.y, ((float) (getHeight() / 2)) - sHeight2);
        } else if (z4) {
            access$4800.x = Math.max(access$4800.x, ((float) getWidth()) - sWidth2);
            access$4800.y = Math.max(access$4800.y, ((float) getHeight()) - sHeight2);
        } else {
            access$4800.x = Math.max(access$4800.x, -sWidth2);
            access$4800.y = Math.max(access$4800.y, -sHeight2);
        }
        float f7 = 0.5f;
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight())) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f7 = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        }
        if (this.panLimit == 3 && isReady()) {
            f5 = (float) Math.max(0, getWidth() / 2);
            max = Math.max(0, getHeight() / 2);
        } else if (z4) {
            f5 = Math.max(0.0f, (((float) getWidth()) - sWidth2) * paddingLeft);
            f6 = Math.max(0.0f, (((float) getHeight()) - sHeight2) * f7);
            access$4800.x = Math.min(access$4800.x, f5);
            access$4800.y = Math.min(access$4800.y, f6);
            float unused = scaleAndTranslate.scale = limitedScale;
        } else {
            f5 = (float) Math.max(0, getWidth());
            max = Math.max(0, getHeight());
        }
        f6 = (float) max;
        access$4800.x = Math.min(access$4800.x, f5);
        access$4800.y = Math.min(access$4800.y, f6);
        float unused2 = scaleAndTranslate.scale = limitedScale;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
        if (r2 != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        android.util.Log.w(TAG, "Could not get orientation of image from media store");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        if (r2 == null) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        if (r2 != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        throw r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x005c */
    @androidx.annotation.AnyThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getExifOrientation(android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "content"
            boolean r0 = r11.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x006c
            r2 = 0
            java.lang.String r0 = "orientation"
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x005c }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x005c }
            android.net.Uri r4 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x005c }
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005c }
            if (r2 == 0) goto L_0x0056
            boolean r10 = r2.moveToFirst()     // Catch:{ Exception -> 0x005c }
            if (r10 == 0) goto L_0x0056
            int r10 = r2.getInt(r1)     // Catch:{ Exception -> 0x005c }
            java.util.List<java.lang.Integer> r11 = VALID_ORIENTATIONS     // Catch:{ Exception -> 0x005c }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x005c }
            boolean r11 = r11.contains(r0)     // Catch:{ Exception -> 0x005c }
            if (r11 == 0) goto L_0x003c
            r11 = -1
            if (r10 == r11) goto L_0x003c
            r1 = r10
            goto L_0x0056
        L_0x003c:
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x005c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005c }
            r0.<init>()     // Catch:{ Exception -> 0x005c }
            java.lang.String r3 = "Unsupported orientation: "
            r0.append(r3)     // Catch:{ Exception -> 0x005c }
            r0.append(r10)     // Catch:{ Exception -> 0x005c }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x005c }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x005c }
            goto L_0x0056
        L_0x0053:
            r0 = move-exception
            r10 = r0
            goto L_0x0066
        L_0x0056:
            if (r2 == 0) goto L_0x00c3
        L_0x0058:
            r2.close()
            goto L_0x00c3
        L_0x005c:
            java.lang.String r10 = TAG     // Catch:{ all -> 0x0053 }
            java.lang.String r11 = "Could not get orientation of image from media store"
            android.util.Log.w(r10, r11)     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x00c3
            goto L_0x0058
        L_0x0066:
            if (r2 == 0) goto L_0x006b
            r2.close()
        L_0x006b:
            throw r10
        L_0x006c:
            java.lang.String r10 = "file:///"
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x00c3
            java.lang.String r10 = "file:///android_asset/"
            boolean r10 = r11.startsWith(r10)
            if (r10 != 0) goto L_0x00c3
            androidx.exifinterface.media.ExifInterface r10 = new androidx.exifinterface.media.ExifInterface     // Catch:{ Exception -> 0x00bc }
            r0 = 7
            java.lang.String r11 = r11.substring(r0)     // Catch:{ Exception -> 0x00bc }
            r10.<init>((java.lang.String) r11)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r11 = "Orientation"
            r0 = 1
            int r10 = r10.getAttributeInt(r11, r0)     // Catch:{ Exception -> 0x00bc }
            if (r10 == r0) goto L_0x00bb
            if (r10 != 0) goto L_0x0092
            goto L_0x00bb
        L_0x0092:
            r11 = 6
            if (r10 != r11) goto L_0x0098
            r10 = 90
            return r10
        L_0x0098:
            r11 = 3
            if (r10 != r11) goto L_0x009e
            r10 = 180(0xb4, float:2.52E-43)
            return r10
        L_0x009e:
            r11 = 8
            if (r10 != r11) goto L_0x00a5
            r10 = 270(0x10e, float:3.78E-43)
            return r10
        L_0x00a5:
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x00bc }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bc }
            r0.<init>()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r2 = "Unsupported EXIF orientation: "
            r0.append(r2)     // Catch:{ Exception -> 0x00bc }
            r0.append(r10)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x00bc }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x00bc }
        L_0x00bb:
            return r1
        L_0x00bc:
            java.lang.String r10 = TAG
            java.lang.String r11 = "Could not get EXIF orientation of image"
            android.util.Log.w(r10, r11)
        L_0x00c3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.getExifOrientation(android.content.Context, java.lang.String):int");
    }

    @NonNull
    private Point getMaxBitmapDimensions(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    @AnyThread
    private int getRequiredRotation() {
        int i5 = this.orientation;
        if (i5 == -1) {
            return this.sOrientation;
        }
        return i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ac, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void initialiseBaseLayer(@androidx.annotation.NonNull android.graphics.Point r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            java.lang.String r0 = "initialiseBaseLayer maxTileDimensions=%dx%d"
            int r1 = r13.x     // Catch:{ all -> 0x0078 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0078 }
            int r2 = r13.y     // Catch:{ all -> 0x0078 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0078 }
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0078 }
            r5 = 0
            r4[r5] = r1     // Catch:{ all -> 0x0078 }
            r1 = 1
            r4[r1] = r2     // Catch:{ all -> 0x0078 }
            r12.debug(r0, r4)     // Catch:{ all -> 0x0078 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$ScaleAndTranslate r0 = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$ScaleAndTranslate     // Catch:{ all -> 0x0078 }
            android.graphics.PointF r2 = new android.graphics.PointF     // Catch:{ all -> 0x0078 }
            r4 = 0
            r2.<init>(r4, r4)     // Catch:{ all -> 0x0078 }
            r5 = 0
            r0.<init>(r4, r2)     // Catch:{ all -> 0x0078 }
            r12.satTemp = r0     // Catch:{ all -> 0x0078 }
            r12.fitToBounds(r1, r0)     // Catch:{ all -> 0x0078 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$ScaleAndTranslate r0 = r12.satTemp     // Catch:{ all -> 0x0078 }
            float r0 = r0.scale     // Catch:{ all -> 0x0078 }
            int r0 = r12.calculateInSampleSize(r0)     // Catch:{ all -> 0x0078 }
            r12.fullImageSampleSize = r0     // Catch:{ all -> 0x0078 }
            if (r0 <= r1) goto L_0x0043
            int r0 = r0 / r3
            r12.fullImageSampleSize = r0     // Catch:{ all -> 0x003e }
            goto L_0x0043
        L_0x003e:
            r0 = move-exception
            r13 = r0
            r7 = r12
            goto L_0x00ad
        L_0x0043:
            int r0 = r12.fullImageSampleSize     // Catch:{ all -> 0x0078 }
            if (r0 != r1) goto L_0x007b
            android.graphics.Rect r0 = r12.sRegion     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x007b
            int r0 = r12.sWidth()     // Catch:{ all -> 0x0078 }
            int r2 = r13.x     // Catch:{ all -> 0x0078 }
            if (r0 >= r2) goto L_0x007b
            int r0 = r12.sHeight()     // Catch:{ all -> 0x0078 }
            int r2 = r13.y     // Catch:{ all -> 0x0078 }
            if (r0 >= r2) goto L_0x007b
            com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder r13 = r12.decoder     // Catch:{ all -> 0x0078 }
            r13.recycle()     // Catch:{ all -> 0x0078 }
            r12.decoder = r5     // Catch:{ all -> 0x0078 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$BitmapLoadTask r6 = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$BitmapLoadTask     // Catch:{ all -> 0x0078 }
            android.content.Context r8 = r12.getContext()     // Catch:{ all -> 0x0078 }
            com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageDecoder> r9 = r12.bitmapDecoderFactory     // Catch:{ all -> 0x0078 }
            android.net.Uri r10 = r12.uri     // Catch:{ all -> 0x0078 }
            r11 = 0
            r7 = r12
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0075 }
            r12.execute(r6)     // Catch:{ all -> 0x0075 }
            goto L_0x00ab
        L_0x0075:
            r0 = move-exception
        L_0x0076:
            r13 = r0
            goto L_0x00ad
        L_0x0078:
            r0 = move-exception
            r7 = r12
            goto L_0x0076
        L_0x007b:
            r7 = r12
            r12.initialiseTileMap(r13)     // Catch:{ all -> 0x0075 }
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r13 = r7.tileMap     // Catch:{ all -> 0x0075 }
            int r0 = r7.fullImageSampleSize     // Catch:{ all -> 0x0075 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0075 }
            java.lang.Object r13 = r13.get(r0)     // Catch:{ all -> 0x0075 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x0075 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x0075 }
        L_0x0091:
            boolean r0 = r13.hasNext()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x00a8
            java.lang.Object r0 = r13.next()     // Catch:{ all -> 0x0075 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile r0 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile) r0     // Catch:{ all -> 0x0075 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$TileLoadTask r2 = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$TileLoadTask     // Catch:{ all -> 0x0075 }
            com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder r3 = r7.decoder     // Catch:{ all -> 0x0075 }
            r2.<init>(r12, r3, r0)     // Catch:{ all -> 0x0075 }
            r12.execute(r2)     // Catch:{ all -> 0x0075 }
            goto L_0x0091
        L_0x00a8:
            r12.refreshRequiredTiles(r1)     // Catch:{ all -> 0x0075 }
        L_0x00ab:
            monitor-exit(r12)
            return
        L_0x00ad:
            monitor-exit(r12)     // Catch:{ all -> 0x0075 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.initialiseBaseLayer(android.graphics.Point):void");
    }

    private void initialiseTileMap(Point point) {
        boolean z4;
        int i5;
        int i6;
        Point point2 = point;
        boolean z5 = false;
        boolean z6 = true;
        debug("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point2.x), Integer.valueOf(point2.y));
        this.tileMap = new LinkedHashMap();
        int i7 = this.fullImageSampleSize;
        int i8 = 1;
        int i9 = 1;
        while (true) {
            int sWidth2 = sWidth() / i8;
            int sHeight2 = sHeight() / i9;
            int i10 = sWidth2 / i7;
            int i11 = sHeight2 / i7;
            while (true) {
                if (i10 + i8 + (z6 ? 1 : 0) > point2.x || (((double) i10) > ((double) getWidth()) * 1.25d && i7 < this.fullImageSampleSize)) {
                    i8++;
                    sWidth2 = sWidth() / i8;
                    i10 = sWidth2 / i7;
                }
            }
            while (true) {
                if (i11 + i9 + z6 > point2.y || (((double) i11) > ((double) getHeight()) * 1.25d && i7 < this.fullImageSampleSize)) {
                    i9++;
                    sHeight2 = sHeight() / i9;
                    i11 = sHeight2 / i7;
                }
            }
            ArrayList arrayList = new ArrayList(i8 * i9);
            int i12 = z5;
            while (i12 < i8) {
                int i13 = z5;
                while (i13 < i9) {
                    Tile tile = new Tile();
                    int unused = tile.sampleSize = i7;
                    if (i7 == this.fullImageSampleSize) {
                        z4 = z6;
                    } else {
                        z4 = z5;
                    }
                    boolean unused2 = tile.visible = z4;
                    int i14 = i12 * sWidth2;
                    int i15 = i13 * sHeight2;
                    if (i12 == i8 - 1) {
                        i5 = sWidth();
                    } else {
                        i5 = (i12 + 1) * sWidth2;
                    }
                    if (i13 == i9 - 1) {
                        i6 = sHeight();
                    } else {
                        i6 = (i13 + 1) * sHeight2;
                    }
                    Rect unused3 = tile.sRect = new Rect(i14, i15, i5, i6);
                    z5 = false;
                    Rect unused4 = tile.vRect = new Rect(0, 0, 0, 0);
                    Rect unused5 = tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i13++;
                    z6 = true;
                }
                i12++;
                z6 = true;
            }
            this.tileMap.put(Integer.valueOf(i7), arrayList);
            z6 = true;
            if (i7 != 1) {
                i7 /= 2;
            } else {
                return;
            }
        }
    }

    private boolean isBaseLayerReady() {
        boolean z4 = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (((Integer) next.getKey()).intValue() == this.fullImageSampleSize) {
                for (Tile tile : (List) next.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z4 = false;
                    }
                }
            }
        }
        return z4;
    }

    /* access modifiers changed from: private */
    @NonNull
    public PointF limitedSCenter(float f5, float f6, float f7, @NonNull PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f5, f6, f7);
        pointF.set((((float) (getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2))) - vTranslateForSCenter.x) / f7, (((float) (getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2))) - vTranslateForSCenter.y) / f7);
        return pointF;
    }

    /* access modifiers changed from: private */
    public float limitedScale(float f5) {
        return Math.min(this.maxScale, Math.max(minScale(), f5));
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i5 = this.minimumScaleType;
        if (i5 == 2 || i5 == 4) {
            return Math.max(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
        }
        if (i5 == 3) {
            float f5 = this.minScale;
            if (f5 > 0.0f) {
                return f5;
            }
        }
        return Math.min(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onPreviewLoaded(android.graphics.Bitmap r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "onPreviewLoaded"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x002b }
            r4.debug(r0, r1)     // Catch:{ all -> 0x002b }
            android.graphics.Bitmap r0 = r4.bitmap     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0040
            boolean r0 = r4.imageLoadedSent     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0012
            goto L_0x0040
        L_0x0012:
            android.graphics.Rect r0 = r4.pRegion     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x002d
            int r1 = r0.left     // Catch:{ all -> 0x002b }
            int r2 = r0.top     // Catch:{ all -> 0x002b }
            int r0 = r0.width()     // Catch:{ all -> 0x002b }
            android.graphics.Rect r3 = r4.pRegion     // Catch:{ all -> 0x002b }
            int r3 = r3.height()     // Catch:{ all -> 0x002b }
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r1, r2, r0, r3)     // Catch:{ all -> 0x002b }
            r4.bitmap = r5     // Catch:{ all -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r5 = move-exception
            goto L_0x0045
        L_0x002d:
            r4.bitmap = r5     // Catch:{ all -> 0x002b }
        L_0x002f:
            r5 = 1
            r4.bitmapIsPreview = r5     // Catch:{ all -> 0x002b }
            boolean r5 = r4.checkReady()     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x003e
            r4.invalidate()     // Catch:{ all -> 0x002b }
            r4.requestLayout()     // Catch:{ all -> 0x002b }
        L_0x003e:
            monitor-exit(r4)
            return
        L_0x0040:
            r5.recycle()     // Catch:{ all -> 0x002b }
            monitor-exit(r4)
            return
        L_0x0045:
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onPreviewLoaded(android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        Bitmap bitmap2;
        try {
            debug("onTileLoaded", new Object[0]);
            checkReady();
            checkImageLoaded();
            if (isBaseLayerReady() && (bitmap2 = this.bitmap) != null) {
                if (!this.bitmapIsCached) {
                    bitmap2.recycle();
                }
                this.bitmap = null;
                OnImageEventListener onImageEventListener2 = this.onImageEventListener;
                if (onImageEventListener2 != null && this.bitmapIsCached) {
                    onImageEventListener2.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
            invalidate();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        try {
            debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(this.orientation));
            int i11 = this.sWidth;
            if (i11 > 0 && (i10 = this.sHeight) > 0 && !(i11 == i5 && i10 == i6)) {
                reset(false);
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 != null) {
                    if (!this.bitmapIsCached) {
                        bitmap2.recycle();
                    }
                    this.bitmap = null;
                    OnImageEventListener onImageEventListener2 = this.onImageEventListener;
                    if (onImageEventListener2 != null && this.bitmapIsCached) {
                        onImageEventListener2.onPreviewReleased();
                    }
                    this.bitmapIsPreview = false;
                    this.bitmapIsCached = false;
                }
            }
            this.decoder = imageRegionDecoder;
            this.sWidth = i5;
            this.sHeight = i6;
            this.sOrientation = i7;
            checkReady();
            if (!checkImageLoaded() && (i8 = this.maxTileWidth) > 0 && i8 != Integer.MAX_VALUE && (i9 = this.maxTileHeight) > 0 && i9 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
                initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));
            }
            invalidate();
            requestLayout();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r1 != 262) goto L_0x03a4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean onTouchEventInternal(@androidx.annotation.NonNull android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getPointerCount()
            int r1 = r12.getAction()
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0411
            if (r1 == r5) goto L_0x03a5
            if (r1 == r3) goto L_0x0023
            r6 = 5
            if (r1 == r6) goto L_0x0411
            r6 = 6
            if (r1 == r6) goto L_0x03a5
            r6 = 261(0x105, float:3.66E-43)
            if (r1 == r6) goto L_0x0411
            r2 = 262(0x106, float:3.67E-43)
            if (r1 == r2) goto L_0x03a5
            goto L_0x03a4
        L_0x0023:
            int r1 = r11.maxTouchCount
            if (r1 <= 0) goto L_0x03a4
            r1 = 1084227584(0x40a00000, float:5.0)
            if (r0 < r3) goto L_0x017f
            float r0 = r12.getX(r4)
            float r6 = r12.getX(r5)
            float r7 = r12.getY(r4)
            float r8 = r12.getY(r5)
            float r0 = r11.distance(r0, r6, r7, r8)
            float r6 = r12.getX(r4)
            float r7 = r12.getX(r5)
            float r6 = r6 + r7
            float r6 = r6 / r2
            float r7 = r12.getY(r4)
            float r12 = r12.getY(r5)
            float r7 = r7 + r12
            float r7 = r7 / r2
            boolean r12 = r11.zoomEnabled
            if (r12 == 0) goto L_0x03a4
            android.graphics.PointF r12 = r11.vCenterStart
            float r2 = r12.x
            float r12 = r12.y
            float r12 = r11.distance(r2, r6, r12, r7)
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0075
            float r12 = r11.vDistStart
            float r12 = r0 - r12
            float r12 = java.lang.Math.abs(r12)
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0075
            boolean r12 = r11.isPanning
            if (r12 == 0) goto L_0x03a4
        L_0x0075:
            r11.isZooming = r5
            r11.isPanning = r5
            float r12 = r11.scale
            double r1 = (double) r12
            float r12 = r11.maxScale
            float r4 = r11.vDistStart
            float r4 = r0 / r4
            float r8 = r11.scaleStart
            float r4 = r4 * r8
            float r12 = java.lang.Math.min(r12, r4)
            r11.scale = r12
            float r4 = r11.minScale()
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 > 0) goto L_0x00a9
            r11.vDistStart = r0
            float r12 = r11.minScale()
            r11.scaleStart = r12
            android.graphics.PointF r12 = r11.vCenterStart
            r12.set(r6, r7)
            android.graphics.PointF r12 = r11.vTranslateStart
            android.graphics.PointF r0 = r11.vTranslate
            r12.set(r0)
            goto L_0x0175
        L_0x00a9:
            boolean r12 = r11.panEnabled
            if (r12 == 0) goto L_0x0124
            android.graphics.PointF r12 = r11.vCenterStart
            float r3 = r12.x
            android.graphics.PointF r4 = r11.vTranslateStart
            float r8 = r4.x
            float r3 = r3 - r8
            float r12 = r12.y
            float r4 = r4.y
            float r12 = r12 - r4
            float r4 = r11.scale
            float r8 = r11.scaleStart
            float r9 = r4 / r8
            float r3 = r3 * r9
            float r4 = r4 / r8
            float r12 = r12 * r4
            android.graphics.PointF r4 = r11.vTranslate
            float r3 = r6 - r3
            r4.x = r3
            float r12 = r7 - r12
            r4.y = r12
            int r12 = r11.sHeight()
            double r3 = (double) r12
            double r3 = r3 * r1
            int r12 = r11.getHeight()
            double r8 = (double) r12
            int r12 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x00ee
            float r12 = r11.scale
            int r3 = r11.sHeight()
            float r3 = (float) r3
            float r12 = r12 * r3
            int r3 = r11.getHeight()
            float r3 = (float) r3
            int r12 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x010e
        L_0x00ee:
            int r12 = r11.sWidth()
            double r3 = (double) r12
            double r1 = r1 * r3
            int r12 = r11.getWidth()
            double r3 = (double) r12
            int r12 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x0175
            float r12 = r11.scale
            int r1 = r11.sWidth()
            float r1 = (float) r1
            float r12 = r12 * r1
            int r1 = r11.getWidth()
            float r1 = (float) r1
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 < 0) goto L_0x0175
        L_0x010e:
            r11.fitToBounds(r5)
            android.graphics.PointF r12 = r11.vCenterStart
            r12.set(r6, r7)
            android.graphics.PointF r12 = r11.vTranslateStart
            android.graphics.PointF r1 = r11.vTranslate
            r12.set(r1)
            float r12 = r11.scale
            r11.scaleStart = r12
            r11.vDistStart = r0
            goto L_0x0175
        L_0x0124:
            android.graphics.PointF r12 = r11.sRequestedCenter
            if (r12 == 0) goto L_0x014d
            android.graphics.PointF r12 = r11.vTranslate
            int r0 = r11.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r11.scale
            android.graphics.PointF r2 = r11.sRequestedCenter
            float r2 = r2.x
            float r1 = r1 * r2
            float r0 = r0 - r1
            r12.x = r0
            android.graphics.PointF r12 = r11.vTranslate
            int r0 = r11.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r11.scale
            android.graphics.PointF r2 = r11.sRequestedCenter
            float r2 = r2.y
            float r1 = r1 * r2
            float r0 = r0 - r1
            r12.y = r0
            goto L_0x0175
        L_0x014d:
            android.graphics.PointF r12 = r11.vTranslate
            int r0 = r11.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r11.scale
            int r2 = r11.sWidth()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r12.x = r0
            android.graphics.PointF r12 = r11.vTranslate
            int r0 = r11.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r11.scale
            int r2 = r11.sHeight()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r12.y = r0
        L_0x0175:
            r11.fitToBounds(r5)
            boolean r12 = r11.eagerLoadingEnabled
            r11.refreshRequiredTiles(r12)
            goto L_0x039b
        L_0x017f:
            boolean r0 = r11.isQuickScaling
            if (r0 == 0) goto L_0x02cc
            android.graphics.PointF r0 = r11.quickScaleVStart
            float r0 = r0.y
            float r1 = r12.getY()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            float r0 = r0 * r2
            float r1 = r11.quickScaleThreshold
            float r0 = r0 + r1
            float r1 = r11.quickScaleLastDistance
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x019e
            r11.quickScaleLastDistance = r0
        L_0x019e:
            float r1 = r12.getY()
            android.graphics.PointF r2 = r11.quickScaleVLastPoint
            float r6 = r2.y
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x01ab
            r4 = r5
        L_0x01ab:
            float r12 = r12.getY()
            r1 = 0
            r2.set(r1, r12)
            float r12 = r11.quickScaleLastDistance
            float r12 = r0 / r12
            r2 = 1065353216(0x3f800000, float:1.0)
            float r12 = r2 - r12
            float r12 = java.lang.Math.abs(r12)
            r6 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 * r6
            r6 = 1022739087(0x3cf5c28f, float:0.03)
            int r6 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x01cd
            boolean r6 = r11.quickScaleMoved
            if (r6 == 0) goto L_0x02c0
        L_0x01cd:
            r11.quickScaleMoved = r5
            float r6 = r11.quickScaleLastDistance
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x01db
            if (r4 == 0) goto L_0x01da
            float r12 = r12 + r2
            r2 = r12
            goto L_0x01db
        L_0x01da:
            float r2 = r2 - r12
        L_0x01db:
            float r12 = r11.scale
            double r6 = (double) r12
            float r12 = r11.minScale()
            float r4 = r11.maxScale
            float r8 = r11.scale
            float r8 = r8 * r2
            float r2 = java.lang.Math.min(r4, r8)
            float r12 = java.lang.Math.max(r12, r2)
            r11.scale = r12
            boolean r2 = r11.panEnabled
            if (r2 == 0) goto L_0x026f
            android.graphics.PointF r2 = r11.vCenterStart
            float r3 = r2.x
            android.graphics.PointF r4 = r11.vTranslateStart
            float r8 = r4.x
            float r8 = r3 - r8
            float r2 = r2.y
            float r4 = r4.y
            float r4 = r2 - r4
            float r9 = r11.scaleStart
            float r10 = r12 / r9
            float r8 = r8 * r10
            float r12 = r12 / r9
            float r4 = r4 * r12
            android.graphics.PointF r12 = r11.vTranslate
            float r3 = r3 - r8
            r12.x = r3
            float r2 = r2 - r4
            r12.y = r2
            int r12 = r11.sHeight()
            double r2 = (double) r12
            double r2 = r2 * r6
            int r12 = r11.getHeight()
            double r8 = (double) r12
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x0234
            float r12 = r11.scale
            int r2 = r11.sHeight()
            float r2 = (float) r2
            float r12 = r12 * r2
            int r2 = r11.getHeight()
            float r2 = (float) r2
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x0254
        L_0x0234:
            int r12 = r11.sWidth()
            double r2 = (double) r12
            double r6 = r6 * r2
            int r12 = r11.getWidth()
            double r2 = (double) r12
            int r12 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x02c0
            float r12 = r11.scale
            int r2 = r11.sWidth()
            float r2 = (float) r2
            float r12 = r12 * r2
            int r2 = r11.getWidth()
            float r2 = (float) r2
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x02c0
        L_0x0254:
            r11.fitToBounds(r5)
            android.graphics.PointF r12 = r11.vCenterStart
            android.graphics.PointF r0 = r11.quickScaleSCenter
            android.graphics.PointF r0 = r11.sourceToViewCoord(r0)
            r12.set(r0)
            android.graphics.PointF r12 = r11.vTranslateStart
            android.graphics.PointF r0 = r11.vTranslate
            r12.set(r0)
            float r12 = r11.scale
            r11.scaleStart = r12
            r0 = r1
            goto L_0x02c0
        L_0x026f:
            android.graphics.PointF r12 = r11.sRequestedCenter
            if (r12 == 0) goto L_0x0298
            android.graphics.PointF r12 = r11.vTranslate
            int r1 = r11.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r11.scale
            android.graphics.PointF r4 = r11.sRequestedCenter
            float r4 = r4.x
            float r2 = r2 * r4
            float r1 = r1 - r2
            r12.x = r1
            android.graphics.PointF r12 = r11.vTranslate
            int r1 = r11.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r11.scale
            android.graphics.PointF r3 = r11.sRequestedCenter
            float r3 = r3.y
            float r2 = r2 * r3
            float r1 = r1 - r2
            r12.y = r1
            goto L_0x02c0
        L_0x0298:
            android.graphics.PointF r12 = r11.vTranslate
            int r1 = r11.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r11.scale
            int r4 = r11.sWidth()
            int r4 = r4 / r3
            float r4 = (float) r4
            float r2 = r2 * r4
            float r1 = r1 - r2
            r12.x = r1
            android.graphics.PointF r12 = r11.vTranslate
            int r1 = r11.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r11.scale
            int r4 = r11.sHeight()
            int r4 = r4 / r3
            float r3 = (float) r4
            float r2 = r2 * r3
            float r1 = r1 - r2
            r12.y = r1
        L_0x02c0:
            r11.quickScaleLastDistance = r0
            r11.fitToBounds(r5)
            boolean r12 = r11.eagerLoadingEnabled
            r11.refreshRequiredTiles(r12)
            goto L_0x039b
        L_0x02cc:
            boolean r0 = r11.isZooming
            if (r0 != 0) goto L_0x03a4
            float r0 = r12.getX()
            android.graphics.PointF r2 = r11.vCenterStart
            float r2 = r2.x
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r12.getY()
            android.graphics.PointF r3 = r11.vCenterStart
            float r3 = r3.y
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            float r3 = r11.density
            float r3 = r3 * r1
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x02f9
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x02f9
            boolean r6 = r11.isPanning
            if (r6 == 0) goto L_0x03a4
        L_0x02f9:
            android.graphics.PointF r6 = r11.vTranslate
            android.graphics.PointF r7 = r11.vTranslateStart
            float r7 = r7.x
            float r8 = r12.getX()
            android.graphics.PointF r9 = r11.vCenterStart
            float r9 = r9.x
            float r8 = r8 - r9
            float r7 = r7 + r8
            r6.x = r7
            android.graphics.PointF r6 = r11.vTranslate
            android.graphics.PointF r7 = r11.vTranslateStart
            float r7 = r7.y
            float r12 = r12.getY()
            android.graphics.PointF r8 = r11.vCenterStart
            float r8 = r8.y
            float r12 = r12 - r8
            float r7 = r7 + r12
            r6.y = r7
            android.graphics.PointF r12 = r11.vTranslate
            float r6 = r12.x
            float r12 = r12.y
            r11.fitToBounds(r5)
            android.graphics.PointF r7 = r11.vTranslate
            float r8 = r7.x
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0330
            r6 = r5
            goto L_0x0331
        L_0x0330:
            r6 = r4
        L_0x0331:
            float r7 = r7.y
            int r8 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x0339
            r8 = r5
            goto L_0x033a
        L_0x0339:
            r8 = r4
        L_0x033a:
            if (r6 == 0) goto L_0x0346
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x0346
            boolean r9 = r11.isPanning
            if (r9 != 0) goto L_0x0346
            r9 = r5
            goto L_0x0347
        L_0x0346:
            r9 = r4
        L_0x0347:
            if (r8 == 0) goto L_0x0353
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0353
            boolean r0 = r11.isPanning
            if (r0 != 0) goto L_0x0353
            r0 = r5
            goto L_0x0354
        L_0x0353:
            r0 = r4
        L_0x0354:
            int r12 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x0361
            r12 = 1077936128(0x40400000, float:3.0)
            float r12 = r12 * r3
            int r12 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x0361
            r12 = r5
            goto L_0x0362
        L_0x0361:
            r12 = r4
        L_0x0362:
            if (r9 != 0) goto L_0x0373
            if (r0 != 0) goto L_0x0373
            if (r6 == 0) goto L_0x0370
            if (r8 == 0) goto L_0x0370
            if (r12 != 0) goto L_0x0370
            boolean r12 = r11.isPanning
            if (r12 == 0) goto L_0x0373
        L_0x0370:
            r11.isPanning = r5
            goto L_0x0383
        L_0x0373:
            if (r1 > 0) goto L_0x0379
            int r12 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r12 <= 0) goto L_0x0383
        L_0x0379:
            r11.maxTouchCount = r4
            android.os.Handler r12 = r11.handler
            r12.removeMessages(r5)
            r11.requestDisallowInterceptTouchEvent(r4)
        L_0x0383:
            boolean r12 = r11.panEnabled
            if (r12 != 0) goto L_0x0396
            android.graphics.PointF r12 = r11.vTranslate
            android.graphics.PointF r0 = r11.vTranslateStart
            float r1 = r0.x
            r12.x = r1
            float r0 = r0.y
            r12.y = r0
            r11.requestDisallowInterceptTouchEvent(r4)
        L_0x0396:
            boolean r12 = r11.eagerLoadingEnabled
            r11.refreshRequiredTiles(r12)
        L_0x039b:
            android.os.Handler r12 = r11.handler
            r12.removeMessages(r5)
            r11.invalidate()
            return r5
        L_0x03a4:
            return r4
        L_0x03a5:
            android.os.Handler r1 = r11.handler
            r1.removeMessages(r5)
            boolean r1 = r11.isQuickScaling
            if (r1 == 0) goto L_0x03bb
            r11.isQuickScaling = r4
            boolean r1 = r11.quickScaleMoved
            if (r1 != 0) goto L_0x03bb
            android.graphics.PointF r1 = r11.quickScaleSCenter
            android.graphics.PointF r2 = r11.vCenterStart
            r11.doubleTapZoom(r1, r2)
        L_0x03bb:
            int r1 = r11.maxTouchCount
            if (r1 <= 0) goto L_0x0408
            boolean r1 = r11.isZooming
            if (r1 != 0) goto L_0x03c7
            boolean r2 = r11.isPanning
            if (r2 == 0) goto L_0x0408
        L_0x03c7:
            if (r1 == 0) goto L_0x03f9
            if (r0 != r3) goto L_0x03f9
            r11.isPanning = r5
            android.graphics.PointF r1 = r11.vTranslateStart
            android.graphics.PointF r2 = r11.vTranslate
            float r6 = r2.x
            float r2 = r2.y
            r1.set(r6, r2)
            int r1 = r12.getActionIndex()
            if (r1 != r5) goto L_0x03ec
            android.graphics.PointF r1 = r11.vCenterStart
            float r2 = r12.getX(r4)
            float r12 = r12.getY(r4)
            r1.set(r2, r12)
            goto L_0x03f9
        L_0x03ec:
            android.graphics.PointF r1 = r11.vCenterStart
            float r2 = r12.getX(r5)
            float r12 = r12.getY(r5)
            r1.set(r2, r12)
        L_0x03f9:
            r12 = 3
            if (r0 >= r12) goto L_0x03fe
            r11.isZooming = r4
        L_0x03fe:
            if (r0 >= r3) goto L_0x0404
            r11.isPanning = r4
            r11.maxTouchCount = r4
        L_0x0404:
            r11.refreshRequiredTiles(r5)
            return r5
        L_0x0408:
            if (r0 != r5) goto L_0x0410
            r11.isZooming = r4
            r11.isPanning = r4
            r11.maxTouchCount = r4
        L_0x0410:
            return r5
        L_0x0411:
            r1 = 0
            r11.anim = r1
            r11.requestDisallowInterceptTouchEvent(r5)
            int r1 = r11.maxTouchCount
            int r1 = java.lang.Math.max(r1, r0)
            r11.maxTouchCount = r1
            if (r0 < r3) goto L_0x046c
            boolean r0 = r11.zoomEnabled
            if (r0 == 0) goto L_0x0464
            float r0 = r12.getX(r4)
            float r1 = r12.getX(r5)
            float r3 = r12.getY(r4)
            float r6 = r12.getY(r5)
            float r0 = r11.distance(r0, r1, r3, r6)
            float r1 = r11.scale
            r11.scaleStart = r1
            r11.vDistStart = r0
            android.graphics.PointF r0 = r11.vTranslateStart
            android.graphics.PointF r1 = r11.vTranslate
            float r3 = r1.x
            float r1 = r1.y
            r0.set(r3, r1)
            android.graphics.PointF r0 = r11.vCenterStart
            float r1 = r12.getX(r4)
            float r3 = r12.getX(r5)
            float r1 = r1 + r3
            float r1 = r1 / r2
            float r3 = r12.getY(r4)
            float r12 = r12.getY(r5)
            float r3 = r3 + r12
            float r3 = r3 / r2
            r0.set(r1, r3)
            goto L_0x0466
        L_0x0464:
            r11.maxTouchCount = r4
        L_0x0466:
            android.os.Handler r12 = r11.handler
            r12.removeMessages(r5)
            goto L_0x048f
        L_0x046c:
            boolean r0 = r11.isQuickScaling
            if (r0 != 0) goto L_0x048f
            android.graphics.PointF r0 = r11.vTranslateStart
            android.graphics.PointF r1 = r11.vTranslate
            float r2 = r1.x
            float r1 = r1.y
            r0.set(r2, r1)
            android.graphics.PointF r0 = r11.vCenterStart
            float r1 = r12.getX()
            float r12 = r12.getY()
            r0.set(r1, r12)
            android.os.Handler r12 = r11.handler
            r0 = 600(0x258, double:2.964E-321)
            r12.sendEmptyMessageDelayed(r5, r0)
        L_0x048f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void preDraw() {
        Float f5;
        if (getWidth() != 0 && getHeight() != 0 && this.sWidth > 0 && this.sHeight > 0) {
            if (!(this.sPendingCenter == null || (f5 = this.pendingScale) == null)) {
                this.scale = f5.floatValue();
                if (this.vTranslate == null) {
                    this.vTranslate = new PointF();
                }
                this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * this.sPendingCenter.x);
                this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * this.sPendingCenter.y);
                this.sPendingCenter = null;
                this.pendingScale = null;
                fitToBounds(true);
                refreshRequiredTiles(true);
            }
            fitToBounds(false);
        }
    }

    private int px(int i5) {
        return (int) (this.density * ((float) i5));
    }

    private void refreshRequiredTiles(boolean z4) {
        if (this.decoder != null && this.tileMap != null) {
            int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
            for (Map.Entry<Integer, List<Tile>> value : this.tileMap.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                        boolean unused = tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            Bitmap unused2 = tile.bitmap = null;
                        }
                    }
                    if (tile.sampleSize == min) {
                        if (tileVisible(tile)) {
                            boolean unused3 = tile.visible = true;
                            if (!tile.loading && tile.bitmap == null && z4) {
                                execute(new TileLoadTask(this, this.decoder, tile));
                            }
                        } else if (tile.sampleSize != this.fullImageSampleSize) {
                            boolean unused4 = tile.visible = false;
                            if (tile.bitmap != null) {
                                tile.bitmap.recycle();
                                Bitmap unused5 = tile.bitmap = null;
                            }
                        }
                    } else if (tile.sampleSize == this.fullImageSampleSize) {
                        boolean unused6 = tile.visible = true;
                    }
                }
            }
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean z4) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z4);
        }
    }

    /* JADX INFO: finally extract failed */
    private void reset(boolean z4) {
        OnImageEventListener onImageEventListener2;
        debug("reset newImage=" + z4, new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z4) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null) {
                    imageRegionDecoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 != null && !this.bitmapIsCached) {
                    bitmap2.recycle();
                }
                if (!(this.bitmap == null || !this.bitmapIsCached || (onImageEventListener2 = this.onImageEventListener) == null)) {
                    onImageEventListener2.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (Throwable th) {
                this.decoderLock.writeLock().unlock();
                throw th;
            }
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            for (Map.Entry<Integer, List<Tile>> value : map.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    boolean unused = tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        Bitmap unused2 = tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientation = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sWidth;
        }
        return this.sHeight;
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sHeight;
        }
        return this.sWidth;
    }

    private void sendStateChanged(float f5, PointF pointF, int i5) {
        OnStateChangedListener onStateChangedListener2 = this.onStateChangedListener;
        if (onStateChangedListener2 != null) {
            float f6 = this.scale;
            if (f6 != f5) {
                onStateChangedListener2.onScaleChanged(f6, i5);
            }
        }
        if (this.onStateChangedListener != null && !this.vTranslate.equals(pointF)) {
            this.onStateChangedListener.onCenterChanged(getCenter(), i5);
        }
    }

    /* access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!SubsamplingScaleImageView.this.zoomEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                SubsamplingScaleImageView.this.setGestureDetector(context);
                if (SubsamplingScaleImageView.this.quickScaleEnabled) {
                    PointF unused = SubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused2 = SubsamplingScaleImageView.this.vTranslateStart = new PointF(SubsamplingScaleImageView.this.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y);
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    float unused3 = subsamplingScaleImageView.scaleStart = subsamplingScaleImageView.scale;
                    boolean unused4 = SubsamplingScaleImageView.this.isQuickScaling = true;
                    boolean unused5 = SubsamplingScaleImageView.this.isZooming = true;
                    float unused6 = SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                    SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                    PointF unused7 = subsamplingScaleImageView2.quickScaleSCenter = subsamplingScaleImageView2.viewToSourceCoord(subsamplingScaleImageView2.vCenterStart);
                    PointF unused8 = SubsamplingScaleImageView.this.quickScaleVStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused9 = SubsamplingScaleImageView.this.quickScaleVLastPoint = new PointF(SubsamplingScaleImageView.this.quickScaleSCenter.x, SubsamplingScaleImageView.this.quickScaleSCenter.y);
                    boolean unused10 = SubsamplingScaleImageView.this.quickScaleMoved = false;
                    return false;
                }
                SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView3.doubleTapZoom(subsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
                if (!SubsamplingScaleImageView.this.panEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f5) <= 500.0f && Math.abs(f6) <= 500.0f) || SubsamplingScaleImageView.this.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f5, f6);
                }
                PointF pointF = new PointF(SubsamplingScaleImageView.this.vTranslate.x + (f5 * 0.25f), SubsamplingScaleImageView.this.vTranslate.y + (f6 * 0.25f));
                new AnimationBuilder(new PointF((((float) (SubsamplingScaleImageView.this.getWidth() / 2)) - pointF.x) / SubsamplingScaleImageView.this.scale, (((float) (SubsamplingScaleImageView.this.getHeight() / 2)) - pointF.y) / SubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
        this.singleDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    private void setMatrixArray(float[] fArr, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        fArr[0] = f5;
        fArr[1] = f6;
        fArr[2] = f7;
        fArr[3] = f8;
        fArr[4] = f9;
        fArr[5] = f10;
        fArr[6] = f11;
        fArr[7] = f12;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    private void sourceToViewRect(@NonNull Rect rect, @NonNull Rect rect2) {
        rect2.set((int) sourceToViewX((float) rect.left), (int) sourceToViewY((float) rect.top), (int) sourceToViewX((float) rect.right), (int) sourceToViewY((float) rect.bottom));
    }

    private float sourceToViewX(float f5) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f5 * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f5) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f5 * this.scale) + pointF.y;
    }

    private boolean tileVisible(Tile tile) {
        float viewToSourceX = viewToSourceX(0.0f);
        float viewToSourceX2 = viewToSourceX((float) getWidth());
        float viewToSourceY = viewToSourceY(0.0f);
        float viewToSourceY2 = viewToSourceY((float) getHeight());
        if (viewToSourceX > ((float) tile.sRect.right) || ((float) tile.sRect.left) > viewToSourceX2 || viewToSourceY > ((float) tile.sRect.bottom) || ((float) tile.sRect.top) > viewToSourceY2) {
            return false;
        }
        return true;
    }

    @NonNull
    private PointF vTranslateForSCenter(float f5, float f6, float f7) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.satTemp.scale = f7;
        this.satTemp.vTranslate.set(((float) paddingLeft) - (f5 * f7), ((float) paddingTop) - (f6 * f7));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    private float viewToSourceX(float f5) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f5 - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f5) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f5 - pointF.y) / this.scale;
    }

    @Nullable
    public AnimationBuilder animateCenter(PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(pointF);
    }

    @Nullable
    public AnimationBuilder animateScale(float f5) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f5);
    }

    @Nullable
    public AnimationBuilder animateScaleAndCenter(float f5, PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f5, pointF);
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    @Nullable
    public final PointF getCenter() {
        return viewToSourceCoord((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void getPanRemaining(RectF rectF) {
        if (isReady()) {
            float sWidth2 = this.scale * ((float) sWidth());
            float sHeight2 = this.scale * ((float) sHeight());
            int i5 = this.panLimit;
            if (i5 == 3) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - ((float) (getHeight() / 2))));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - ((float) (getWidth() / 2))));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y - (((float) (getHeight() / 2)) - sHeight2));
                rectF.right = Math.max(0.0f, this.vTranslate.x - (((float) (getWidth() / 2)) - sWidth2));
            } else if (i5 == 2) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - ((float) getHeight())));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - ((float) getWidth())));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y + sHeight2);
                rectF.right = Math.max(0.0f, this.vTranslate.x + sWidth2);
            } else {
                rectF.top = Math.max(0.0f, -this.vTranslate.y);
                rectF.left = Math.max(0.0f, -this.vTranslate.x);
                rectF.bottom = Math.max(0.0f, (sHeight2 + this.vTranslate.y) - ((float) getHeight()));
                rectF.right = Math.max(0.0f, (sWidth2 + this.vTranslate.x) - ((float) getWidth()));
            }
        }
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    @Nullable
    public final ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public boolean hasImage() {
        if (this.uri == null && this.bitmap == null) {
            return false;
        }
        return true;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        char c5;
        int i5;
        float f5;
        int i6;
        int i7;
        int i8;
        int i9;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        createPaints();
        if (this.sWidth != 0 && this.sHeight != 0 && getWidth() != 0 && getHeight() != 0) {
            if (this.tileMap == null && this.decoder != null) {
                initialiseBaseLayer(getMaxBitmapDimensions(canvas));
            }
            if (checkReady()) {
                preDraw();
                Anim anim2 = this.anim;
                if (!(anim2 == null || anim2.vFocusStart == null)) {
                    float f6 = this.scale;
                    if (this.vTranslateBefore == null) {
                        this.vTranslateBefore = new PointF(0.0f, 0.0f);
                    }
                    this.vTranslateBefore.set(this.vTranslate);
                    long currentTimeMillis = System.currentTimeMillis() - this.anim.time;
                    boolean z4 = currentTimeMillis > this.anim.duration;
                    long min = Math.min(currentTimeMillis, this.anim.duration);
                    this.scale = ease(this.anim.easing, min, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                    float ease = ease(this.anim.easing, min, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                    float ease2 = ease(this.anim.easing, min, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                    this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - ease;
                    this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - ease2;
                    fitToBounds(z4 || this.anim.scaleStart == this.anim.scaleEnd);
                    sendStateChanged(f6, this.vTranslateBefore, this.anim.origin);
                    refreshRequiredTiles(z4);
                    if (z4) {
                        if (this.anim.listener != null) {
                            try {
                                this.anim.listener.onComplete();
                            } catch (Exception e5) {
                                Log.w(TAG, "Error thrown by animation listener", e5);
                            }
                        }
                        this.anim = null;
                    }
                    invalidate();
                }
                Map<Integer, List<Tile>> map = this.tileMap;
                int i10 = ORIENTATION_270;
                int i11 = ORIENTATION_180;
                int i12 = 90;
                int i13 = 5;
                if (map == null || !isBaseLayerReady()) {
                    i5 = 5;
                    c5 = 0;
                    Bitmap bitmap2 = this.bitmap;
                    if (bitmap2 != null) {
                        float f7 = this.scale;
                        if (this.bitmapIsPreview) {
                            f7 *= ((float) this.sWidth) / ((float) bitmap2.getWidth());
                            f5 = this.scale * (((float) this.sHeight) / ((float) this.bitmap.getHeight()));
                        } else {
                            f5 = f7;
                        }
                        if (this.matrix == null) {
                            this.matrix = new Matrix();
                        }
                        this.matrix.reset();
                        this.matrix.postScale(f7, f5);
                        this.matrix.postRotate((float) getRequiredRotation());
                        Matrix matrix2 = this.matrix;
                        PointF pointF = this.vTranslate;
                        matrix2.postTranslate(pointF.x, pointF.y);
                        if (getRequiredRotation() == 180) {
                            Matrix matrix3 = this.matrix;
                            float f8 = this.scale;
                            matrix3.postTranslate(((float) this.sWidth) * f8, f8 * ((float) this.sHeight));
                        } else if (getRequiredRotation() == 90) {
                            this.matrix.postTranslate(this.scale * ((float) this.sHeight), 0.0f);
                        } else if (getRequiredRotation() == 270) {
                            this.matrix.postTranslate(0.0f, this.scale * ((float) this.sWidth));
                        }
                        if (this.tileBgPaint != null) {
                            if (this.sRect == null) {
                                this.sRect = new RectF();
                            }
                            this.sRect.set(0.0f, 0.0f, (float) (this.bitmapIsPreview ? this.bitmap.getWidth() : this.sWidth), (float) (this.bitmapIsPreview ? this.bitmap.getHeight() : this.sHeight));
                            this.matrix.mapRect(this.sRect);
                            canvas2.drawRect(this.sRect, this.tileBgPaint);
                        }
                        canvas2.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
                    }
                } else {
                    int min2 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                    boolean z5 = false;
                    for (Map.Entry next : this.tileMap.entrySet()) {
                        if (((Integer) next.getKey()).intValue() == min2) {
                            for (Tile tile : (List) next.getValue()) {
                                if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                    z5 = true;
                                }
                            }
                        }
                    }
                    for (Map.Entry next2 : this.tileMap.entrySet()) {
                        if (((Integer) next2.getKey()).intValue() == min2 || z5) {
                            for (Tile tile2 : (List) next2.getValue()) {
                                sourceToViewRect(tile2.sRect, tile2.vRect);
                                if (tile2.loading || tile2.bitmap == null) {
                                    i9 = i10;
                                    i8 = i11;
                                    i7 = i12;
                                    i6 = i13;
                                    if (tile2.loading && this.debug) {
                                        canvas2.drawText("LOADING", (float) (tile2.vRect.left + px(i6)), (float) (tile2.vRect.top + px(35)), this.debugTextPaint);
                                    }
                                } else {
                                    if (this.tileBgPaint != null) {
                                        canvas2.drawRect(tile2.vRect, this.tileBgPaint);
                                    }
                                    if (this.matrix == null) {
                                        this.matrix = new Matrix();
                                    }
                                    this.matrix.reset();
                                    i8 = i11;
                                    i7 = i12;
                                    i9 = i10;
                                    i6 = i13;
                                    setMatrixArray(this.srcArray, 0.0f, 0.0f, (float) tile2.bitmap.getWidth(), 0.0f, (float) tile2.bitmap.getWidth(), (float) tile2.bitmap.getHeight(), 0.0f, (float) tile2.bitmap.getHeight());
                                    if (getRequiredRotation() == 0) {
                                        setMatrixArray(this.dstArray, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom);
                                    } else if (getRequiredRotation() == i7) {
                                        setMatrixArray(this.dstArray, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top);
                                    } else if (getRequiredRotation() == i8) {
                                        setMatrixArray(this.dstArray, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top);
                                    } else if (getRequiredRotation() == i9) {
                                        setMatrixArray(this.dstArray, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom);
                                    }
                                    this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                                    canvas2.drawBitmap(tile2.bitmap, this.matrix, this.bitmapPaint);
                                    if (this.debug) {
                                        canvas2.drawRect(tile2.vRect, this.debugLinePaint);
                                    }
                                }
                                if (tile2.visible && this.debug) {
                                    canvas2.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + "," + tile2.sRect.left + "," + tile2.sRect.bottom + "," + tile2.sRect.right, (float) (tile2.vRect.left + px(i6)), (float) (tile2.vRect.top + px(15)), this.debugTextPaint);
                                }
                                i10 = i9;
                                i11 = i8;
                                i12 = i7;
                                i13 = i6;
                            }
                        }
                        i10 = i10;
                        i11 = i11;
                        i12 = i12;
                        i13 = i13;
                    }
                    i5 = i13;
                    c5 = 0;
                }
                if (this.debug) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Scale: ");
                    Locale locale = Locale.ENGLISH;
                    Object[] objArr = new Object[1];
                    objArr[c5] = Float.valueOf(this.scale);
                    sb.append(String.format(locale, "%.2f", objArr));
                    sb.append(" (");
                    Object[] objArr2 = new Object[1];
                    objArr2[c5] = Float.valueOf(minScale());
                    sb.append(String.format(locale, "%.2f", objArr2));
                    sb.append(" - ");
                    Object[] objArr3 = new Object[1];
                    objArr3[c5] = Float.valueOf(this.maxScale);
                    sb.append(String.format(locale, "%.2f", objArr3));
                    sb.append(")");
                    canvas2.drawText(sb.toString(), (float) px(i5), (float) px(15), this.debugTextPaint);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Translate: ");
                    Object[] objArr4 = new Object[1];
                    objArr4[c5] = Float.valueOf(this.vTranslate.x);
                    sb2.append(String.format(locale, "%.2f", objArr4));
                    sb2.append(":");
                    Object[] objArr5 = new Object[1];
                    objArr5[c5] = Float.valueOf(this.vTranslate.y);
                    sb2.append(String.format(locale, "%.2f", objArr5));
                    canvas2.drawText(sb2.toString(), (float) px(i5), (float) px(30), this.debugTextPaint);
                    PointF center = getCenter();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Source center: ");
                    Object[] objArr6 = new Object[1];
                    objArr6[c5] = Float.valueOf(center.x);
                    sb3.append(String.format(locale, "%.2f", objArr6));
                    sb3.append(":");
                    Object[] objArr7 = new Object[1];
                    objArr7[c5] = Float.valueOf(center.y);
                    sb3.append(String.format(locale, "%.2f", objArr7));
                    canvas2.drawText(sb3.toString(), (float) px(i5), (float) px(45), this.debugTextPaint);
                    Anim anim3 = this.anim;
                    if (anim3 != null) {
                        PointF sourceToViewCoord = sourceToViewCoord(anim3.sCenterStart);
                        PointF sourceToViewCoord2 = sourceToViewCoord(this.anim.sCenterEndRequested);
                        PointF sourceToViewCoord3 = sourceToViewCoord(this.anim.sCenterEnd);
                        canvas2.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, (float) px(10), this.debugLinePaint);
                        this.debugLinePaint.setColor(SupportMenu.CATEGORY_MASK);
                        canvas2.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, (float) px(20), this.debugLinePaint);
                        this.debugLinePaint.setColor(-16776961);
                        canvas2.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, (float) px(25), this.debugLinePaint);
                        this.debugLinePaint.setColor(-16711681);
                        canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) px(30), this.debugLinePaint);
                    }
                    if (this.vCenterStart != null) {
                        this.debugLinePaint.setColor(SupportMenu.CATEGORY_MASK);
                        PointF pointF2 = this.vCenterStart;
                        canvas2.drawCircle(pointF2.x, pointF2.y, (float) px(20), this.debugLinePaint);
                    }
                    if (this.quickScaleSCenter != null) {
                        this.debugLinePaint.setColor(-16776961);
                        canvas2.drawCircle(sourceToViewX(this.quickScaleSCenter.x), sourceToViewY(this.quickScaleSCenter.y), (float) px(35), this.debugLinePaint);
                    }
                    if (this.quickScaleVStart != null && this.isQuickScaling) {
                        this.debugLinePaint.setColor(-16711681);
                        PointF pointF3 = this.quickScaleVStart;
                        canvas2.drawCircle(pointF3.x, pointF3.y, (float) px(30), this.debugLinePaint);
                    }
                    this.debugLinePaint.setColor(-65281);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onImageLoaded() {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        boolean z4;
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        boolean z5 = false;
        if (mode != 1073741824) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (mode2 != 1073741824) {
            z5 = true;
        }
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z4 && z5) {
                size = sWidth();
                size2 = sHeight();
            } else if (z5) {
                size2 = (int) ((((double) sHeight()) / ((double) sWidth())) * ((double) size));
            } else if (z4) {
                size = (int) ((((double) sWidth()) / ((double) sHeight())) * ((double) size2));
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    /* access modifiers changed from: protected */
    public void onReady() {
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        debug("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i5), Integer.valueOf(i6));
        PointF center = getCenter();
        if (this.readySent && center != null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = center;
        }
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim2 = this.anim;
        if (anim2 == null || anim2.interruptible) {
            Anim anim3 = this.anim;
            if (!(anim3 == null || anim3.listener == null)) {
                try {
                    this.anim.listener.onInterruptedByUser();
                } catch (Exception e5) {
                    Log.w(TAG, "Error thrown by animation listener", e5);
                }
            }
            this.anim = null;
            if (this.vTranslate == null) {
                GestureDetector gestureDetector2 = this.singleDetector;
                if (gestureDetector2 != null) {
                    gestureDetector2.onTouchEvent(motionEvent);
                }
                return true;
            } else if (this.isQuickScaling || ((gestureDetector = this.detector) != null && !gestureDetector.onTouchEvent(motionEvent))) {
                if (this.vTranslateStart == null) {
                    this.vTranslateStart = new PointF(0.0f, 0.0f);
                }
                if (this.vTranslateBefore == null) {
                    this.vTranslateBefore = new PointF(0.0f, 0.0f);
                }
                if (this.vCenterStart == null) {
                    this.vCenterStart = new PointF(0.0f, 0.0f);
                }
                float f5 = this.scale;
                this.vTranslateBefore.set(this.vTranslate);
                boolean onTouchEventInternal = onTouchEventInternal(motionEvent);
                sendStateChanged(f5, this.vTranslateBefore, 2);
                if (onTouchEventInternal || super.onTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            } else {
                this.isZooming = false;
                this.isPanning = false;
                this.maxTouchCount = 0;
                return true;
            }
        } else {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF((float) (sWidth() / 2), (float) (sHeight() / 2));
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void setBitmapDecoderClass(@NonNull Class<? extends ImageDecoder> cls) {
        if (cls != null) {
            this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(@NonNull DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.bitmapDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean z4) {
        this.debug = z4;
    }

    public final void setDoubleTapZoomDpi(int i5) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i5));
    }

    public final void setDoubleTapZoomDuration(int i5) {
        this.doubleTapZoomDuration = Math.max(0, i5);
    }

    public final void setDoubleTapZoomScale(float f5) {
        this.doubleTapZoomScale = f5;
    }

    public final void setDoubleTapZoomStyle(int i5) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i5))) {
            this.doubleTapZoomStyle = i5;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i5);
    }

    public void setEagerLoadingEnabled(boolean z4) {
        this.eagerLoadingEnabled = z4;
    }

    public void setExecutor(@NonNull Executor executor2) {
        if (executor2 != null) {
            this.executor = executor2;
            return;
        }
        throw new NullPointerException("Executor must not be null");
    }

    public final void setImage(@NonNull ImageSource imageSource) {
        setImage(imageSource, (ImageSource) null, (ImageViewState) null);
    }

    public final void setMaxScale(float f5) {
        this.maxScale = f5;
    }

    public void setMaxTileSize(int i5) {
        this.maxTileWidth = i5;
        this.maxTileHeight = i5;
    }

    public final void setMaximumDpi(int i5) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i5));
    }

    public final void setMinScale(float f5) {
        this.minScale = f5;
    }

    public final void setMinimumDpi(int i5) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i5));
    }

    public final void setMinimumScaleType(int i5) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(i5))) {
            this.minimumScaleType = i5;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i5);
    }

    public void setMinimumTileDpi(int i5) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, (float) i5);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener2) {
        this.onImageEventListener = onImageEventListener2;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener2) {
        this.onLongClickListener = onLongClickListener2;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener2) {
        this.onStateChangedListener = onStateChangedListener2;
    }

    public final void setOrientation(int i5) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i5))) {
            this.orientation = i5;
            reset(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i5);
    }

    public final void setPanEnabled(boolean z4) {
        PointF pointF;
        this.panEnabled = z4;
        if (!z4 && (pointF = this.vTranslate) != null) {
            pointF.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (sWidth() / 2)));
            this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (sHeight() / 2)));
            if (isReady()) {
                refreshRequiredTiles(true);
                invalidate();
            }
        }
    }

    public final void setPanLimit(int i5) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(i5))) {
            this.panLimit = i5;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i5);
    }

    public final void setQuickScaleEnabled(boolean z4) {
        this.quickScaleEnabled = z4;
    }

    public final void setRegionDecoderClass(@NonNull Class<? extends ImageRegionDecoder> cls) {
        if (cls != null) {
            this.regionDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(@NonNull DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.regionDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setScaleAndCenter(float f5, @Nullable PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f5);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i5) {
        if (Color.alpha(i5) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint = new Paint();
            this.tileBgPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i5);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z4) {
        this.zoomEnabled = z4;
    }

    @Nullable
    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public void viewToFileRect(Rect rect, Rect rect2) {
        if (this.vTranslate != null && this.readySent) {
            rect2.set((int) viewToSourceX((float) rect.left), (int) viewToSourceY((float) rect.top), (int) viewToSourceX((float) rect.right), (int) viewToSourceY((float) rect.bottom));
            fileSRect(rect2, rect2);
            rect2.set(Math.max(0, rect2.left), Math.max(0, rect2.top), Math.min(this.sWidth, rect2.right), Math.min(this.sHeight, rect2.bottom));
            Rect rect3 = this.sRegion;
            if (rect3 != null) {
                rect2.offset(rect3.left, rect3.top);
            }
        }
    }

    @Nullable
    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public void visibleFileRect(Rect rect) {
        if (this.vTranslate != null && this.readySent) {
            rect.set(0, 0, getWidth(), getHeight());
            viewToFileRect(rect, rect);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap2, int i5, boolean z4) {
        OnImageEventListener onImageEventListener2;
        try {
            debug("onImageLoaded", new Object[0]);
            int i6 = this.sWidth;
            if (i6 > 0 && this.sHeight > 0) {
                if (i6 == bitmap2.getWidth()) {
                    if (this.sHeight != bitmap2.getHeight()) {
                    }
                }
                reset(false);
            }
            Bitmap bitmap3 = this.bitmap;
            if (bitmap3 != null && !this.bitmapIsCached) {
                bitmap3.recycle();
            }
            if (!(this.bitmap == null || !this.bitmapIsCached || (onImageEventListener2 = this.onImageEventListener) == null)) {
                onImageEventListener2.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = z4;
            this.bitmap = bitmap2;
            this.sWidth = bitmap2.getWidth();
            this.sHeight = bitmap2.getHeight();
            this.sOrientation = i5;
            boolean checkReady = checkReady();
            boolean checkImageLoaded = checkImageLoaded();
            if (checkReady || checkImageLoaded) {
                invalidate();
                requestLayout();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, (ImageSource) null, imageViewState);
    }

    @Nullable
    public final PointF sourceToViewCoord(float f5, float f6) {
        return sourceToViewCoord(f5, f6, new PointF());
    }

    @Nullable
    public final PointF viewToSourceCoord(float f5, float f6) {
        return viewToSourceCoord(f5, f6, new PointF());
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, (ImageViewState) null);
    }

    public void setMaxTileSize(int i5, int i6) {
        this.maxTileWidth = i5;
        this.maxTileHeight = i6;
    }

    @Nullable
    public final PointF sourceToViewCoord(PointF pointF, @NonNull PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    @Nullable
    public final PointF viewToSourceCoord(PointF pointF, @NonNull PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        /* access modifiers changed from: private */
        @NonNull
        public AnimationBuilder withOrigin(int i5) {
            this.origin = i5;
            return this;
        }

        /* access modifiers changed from: private */
        @NonNull
        public AnimationBuilder withPanLimited(boolean z4) {
            this.panLimited = z4;
            return this;
        }

        public void start() {
            PointF pointF;
            if (!(SubsamplingScaleImageView.this.anim == null || SubsamplingScaleImageView.this.anim.listener == null)) {
                try {
                    SubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (Exception e5) {
                    Log.w(SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e5);
                }
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float access$6500 = SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            if (this.panLimited) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF2 = this.targetSCenter;
                pointF = subsamplingScaleImageView.limitedSCenter(pointF2.x, pointF2.y, access$6500, new PointF());
            } else {
                pointF = this.targetSCenter;
            }
            Anim unused = SubsamplingScaleImageView.this.anim = new Anim();
            float unused2 = SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
            float unused3 = SubsamplingScaleImageView.this.anim.scaleEnd = access$6500;
            long unused4 = SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            PointF unused5 = SubsamplingScaleImageView.this.anim.sCenterEndRequested = pointF;
            PointF unused6 = SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
            PointF unused7 = SubsamplingScaleImageView.this.anim.sCenterEnd = pointF;
            PointF unused8 = SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord(pointF);
            PointF unused9 = SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF((float) paddingLeft, (float) paddingTop);
            long unused10 = SubsamplingScaleImageView.this.anim.duration = this.duration;
            boolean unused11 = SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            int unused12 = SubsamplingScaleImageView.this.anim.easing = this.easing;
            int unused13 = SubsamplingScaleImageView.this.anim.origin = this.origin;
            long unused14 = SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            OnAnimationEventListener unused15 = SubsamplingScaleImageView.this.anim.listener = this.listener;
            PointF pointF3 = this.vFocus;
            if (pointF3 != null) {
                float f5 = pointF3.x - (SubsamplingScaleImageView.this.anim.sCenterStart.x * access$6500);
                float f6 = this.vFocus.y - (SubsamplingScaleImageView.this.anim.sCenterStart.y * access$6500);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(access$6500, new PointF(f5, f6));
                SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                PointF unused16 = SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f5), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f6));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        @NonNull
        public AnimationBuilder withDuration(long j5) {
            this.duration = j5;
            return this;
        }

        @NonNull
        public AnimationBuilder withEasing(int i5) {
            if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i5))) {
                this.easing = i5;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i5);
        }

        @NonNull
        public AnimationBuilder withInterruptible(boolean z4) {
            this.interruptible = z4;
            return this;
        }

        @NonNull
        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        private AnimationBuilder(PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f5) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f5;
            this.targetSCenter = SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f5, PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f5;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f5, PointF pointF, PointF pointF2) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f5;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        if (imageSource != null) {
            reset(true);
            if (imageViewState != null) {
                restoreState(imageViewState);
            }
            if (imageSource2 != null) {
                if (imageSource.getBitmap() != null) {
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                } else if (imageSource.getSWidth() <= 0 || imageSource.getSHeight() <= 0) {
                    throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                } else {
                    this.sWidth = imageSource.getSWidth();
                    this.sHeight = imageSource.getSHeight();
                    this.pRegion = imageSource2.getSRegion();
                    if (imageSource2.getBitmap() != null) {
                        this.bitmapIsCached = imageSource2.isCached();
                        onPreviewLoaded(imageSource2.getBitmap());
                    } else {
                        Uri uri2 = imageSource2.getUri();
                        if (uri2 == null && imageSource2.getResource() != null) {
                            uri2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                        }
                        execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri2, true));
                    }
                }
            }
            if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
                onImageLoaded(Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
            } else if (imageSource.getBitmap() != null) {
                onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
            } else {
                this.sRegion = imageSource.getSRegion();
                Uri uri3 = imageSource.getUri();
                this.uri = uri3;
                if (uri3 == null && imageSource.getResource() != null) {
                    this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
                }
                if (imageSource.getTile() || this.sRegion != null) {
                    execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
                    return;
                }
                execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
            }
        } else {
            throw new NullPointerException("imageSource must not be null");
        }
    }

    @Nullable
    public final PointF sourceToViewCoord(float f5, float f6, @NonNull PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f5), sourceToViewY(f6));
        return pointF;
    }

    @Nullable
    public final PointF viewToSourceCoord(float f5, float f6, @NonNull PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f5), viewToSourceY(f6));
        return pointF;
    }

    private void fitToBounds(boolean z4) {
        boolean z5;
        if (this.vTranslate == null) {
            this.vTranslate = new PointF(0.0f, 0.0f);
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z4, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (z5 && this.minimumScaleType != 4) {
            this.vTranslate.set(vTranslateForSCenter((float) (sWidth() / 2), (float) (sHeight() / 2), this.scale));
        }
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, (AttributeSet) null);
    }
}
