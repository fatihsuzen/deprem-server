package com.davemorrissey.labs.subscaleview.decoder;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

public class SkiaPooledImageRegionDecoder implements ImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = "SkiaPooledImageRegionDecoder";
    private static boolean debug = false;
    private final Bitmap.Config bitmapConfig;
    private Context context;
    private final ReadWriteLock decoderLock;
    /* access modifiers changed from: private */
    public DecoderPool decoderPool;
    /* access modifiers changed from: private */
    public long fileLength;
    private final Point imageDimensions;
    private final AtomicBoolean lazyInited;
    private Uri uri;

    private static class DecoderPool {
        private final Semaphore available;
        private final Map<BitmapRegionDecoder, Boolean> decoders;

        private DecoderPool() {
            this.available = new Semaphore(0, true);
            this.decoders = new ConcurrentHashMap();
        }

        /* access modifiers changed from: private */
        public BitmapRegionDecoder acquire() {
            this.available.acquireUninterruptibly();
            return getNextAvailable();
        }

        /* access modifiers changed from: private */
        public synchronized void add(BitmapRegionDecoder bitmapRegionDecoder) {
            this.decoders.put(bitmapRegionDecoder, Boolean.FALSE);
            this.available.release();
        }

        private synchronized BitmapRegionDecoder getNextAvailable() {
            for (Map.Entry next : this.decoders.entrySet()) {
                if (!((Boolean) next.getValue()).booleanValue()) {
                    next.setValue(Boolean.TRUE);
                    return (BitmapRegionDecoder) next.getKey();
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public synchronized boolean isEmpty() {
            return this.decoders.isEmpty();
        }

        private synchronized boolean markAsUnused(BitmapRegionDecoder bitmapRegionDecoder) {
            for (Map.Entry next : this.decoders.entrySet()) {
                if (bitmapRegionDecoder == next.getKey()) {
                    if (!((Boolean) next.getValue()).booleanValue()) {
                        return false;
                    }
                    next.setValue(Boolean.FALSE);
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public synchronized void recycle() {
            while (!this.decoders.isEmpty()) {
                BitmapRegionDecoder acquire = acquire();
                acquire.recycle();
                this.decoders.remove(acquire);
            }
        }

        /* access modifiers changed from: private */
        public void release(BitmapRegionDecoder bitmapRegionDecoder) {
            if (markAsUnused(bitmapRegionDecoder)) {
                this.available.release();
            }
        }

        /* access modifiers changed from: private */
        public synchronized int size() {
            return this.decoders.size();
        }
    }

    @Keep
    public SkiaPooledImageRegionDecoder() {
        this((Bitmap.Config) null);
    }

    /* access modifiers changed from: private */
    public void debug(String str) {
        if (debug) {
            Log.d(TAG, str);
        }
    }

    private int getNumCoresOldPhones() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    private int getNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* access modifiers changed from: private */
    public void initialiseDecoder() throws Exception {
        BitmapRegionDecoder bitmapRegionDecoder;
        Resources resources;
        int i5;
        String uri2 = this.uri.toString();
        long j5 = Long.MAX_VALUE;
        if (uri2.startsWith(RESOURCE_PREFIX)) {
            String authority = this.uri.getAuthority();
            if (this.context.getPackageName().equals(authority)) {
                resources = this.context.getResources();
            } else {
                resources = this.context.getPackageManager().getResourcesForApplication(authority);
            }
            List<String> pathSegments = this.uri.getPathSegments();
            int size = pathSegments.size();
            if (size != 2 || !pathSegments.get(0).equals("drawable")) {
                if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                    try {
                        i5 = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                    }
                }
                i5 = 0;
            } else {
                i5 = resources.getIdentifier(pathSegments.get(1), "drawable", authority);
            }
            try {
                j5 = this.context.getResources().openRawResourceFd(i5).getLength();
            } catch (Exception unused2) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.context.getResources().openRawResource(i5), false);
        } else if (uri2.startsWith(ASSET_PREFIX)) {
            String substring = uri2.substring(22);
            try {
                j5 = this.context.getAssets().openFd(substring).getLength();
            } catch (Exception unused3) {
            }
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(this.context.getAssets().open(substring, 1), false);
        } else if (uri2.startsWith(FILE_PREFIX)) {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
            try {
                File file = new File(uri2);
                if (file.exists()) {
                    j5 = file.length();
                }
            } catch (Exception unused4) {
            }
            bitmapRegionDecoder = newInstance;
        } else {
            InputStream inputStream = null;
            try {
                ContentResolver contentResolver = this.context.getContentResolver();
                inputStream = contentResolver.openInputStream(this.uri);
                BitmapRegionDecoder newInstance2 = BitmapRegionDecoder.newInstance(inputStream, false);
                try {
                    AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.uri, CampaignEx.JSON_KEY_AD_R);
                    if (openAssetFileDescriptor != null) {
                        j5 = openAssetFileDescriptor.getLength();
                    }
                } catch (Exception unused5) {
                }
                bitmapRegionDecoder = newInstance2;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused6) {
                    }
                }
            }
        }
        this.fileLength = j5;
        this.imageDimensions.set(bitmapRegionDecoder.getWidth(), bitmapRegionDecoder.getHeight());
        this.decoderLock.writeLock().lock();
        try {
            DecoderPool decoderPool2 = this.decoderPool;
            if (decoderPool2 != null) {
                decoderPool2.add(bitmapRegionDecoder);
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    private boolean isLowMemory() {
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    private void lazyInit() {
        if (this.lazyInited.compareAndSet(false, true) && this.fileLength < Long.MAX_VALUE) {
            debug("Starting lazy init of additional decoders");
            new Thread() {
                public void run() {
                    while (SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                        SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = SkiaPooledImageRegionDecoder.this;
                        if (skiaPooledImageRegionDecoder.allowAdditionalDecoder(skiaPooledImageRegionDecoder.decoderPool.size(), SkiaPooledImageRegionDecoder.this.fileLength)) {
                            try {
                                if (SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    SkiaPooledImageRegionDecoder.this.debug("Starting decoder");
                                    SkiaPooledImageRegionDecoder.this.initialiseDecoder();
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder2 = SkiaPooledImageRegionDecoder.this;
                                    skiaPooledImageRegionDecoder2.debug("Started decoder, took " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                                }
                            } catch (Exception e5) {
                                SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder3 = SkiaPooledImageRegionDecoder.this;
                                skiaPooledImageRegionDecoder3.debug("Failed to start decoder: " + e5.getMessage());
                            }
                        } else {
                            return;
                        }
                    }
                }
            }.start();
        }
    }

    @Keep
    public static void setDebug(boolean z4) {
        debug = z4;
    }

    /* access modifiers changed from: protected */
    public boolean allowAdditionalDecoder(int i5, long j5) {
        if (i5 >= 4) {
            debug("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j6 = ((long) i5) * j5;
        if (j6 > 20971520) {
            debug("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        } else if (i5 >= getNumberOfCores()) {
            debug("No additional encoders allowed, limited by CPU cores (" + getNumberOfCores() + ")");
            return false;
        } else if (isLowMemory()) {
            debug("No additional encoders allowed, memory is low");
            return false;
        } else {
            debug("Additional decoder allowed, current count is " + i5 + ", estimated native memory " + (j6 / 1048576) + "Mb");
            return true;
        }
    }

    @NonNull
    public Bitmap decodeRegion(@NonNull Rect rect, int i5) {
        BitmapRegionDecoder access$700;
        debug("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if (rect.width() < this.imageDimensions.x || rect.height() < this.imageDimensions.y) {
            lazyInit();
        }
        this.decoderLock.readLock().lock();
        try {
            DecoderPool decoderPool2 = this.decoderPool;
            if (decoderPool2 != null) {
                access$700 = decoderPool2.acquire();
                if (access$700 != null) {
                    if (!access$700.isRecycled()) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = i5;
                        options.inPreferredConfig = this.bitmapConfig;
                        Bitmap decodeRegion = access$700.decodeRegion(rect, options);
                        if (decodeRegion != null) {
                            this.decoderPool.release(access$700);
                            this.decoderLock.readLock().unlock();
                            return decodeRegion;
                        }
                        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                    }
                }
                if (access$700 != null) {
                    this.decoderPool.release(access$700);
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } catch (Throwable th) {
            this.decoderLock.readLock().unlock();
            throw th;
        }
    }

    @NonNull
    public Point init(Context context2, @NonNull Uri uri2) throws Exception {
        this.context = context2;
        this.uri = uri2;
        initialiseDecoder();
        return this.imageDimensions;
    }

    public synchronized boolean isReady() {
        boolean z4;
        DecoderPool decoderPool2 = this.decoderPool;
        if (decoderPool2 == null || decoderPool2.isEmpty()) {
            z4 = false;
        } else {
            z4 = true;
        }
        return z4;
    }

    public synchronized void recycle() {
        this.decoderLock.writeLock().lock();
        try {
            DecoderPool decoderPool2 = this.decoderPool;
            if (decoderPool2 != null) {
                decoderPool2.recycle();
                this.decoderPool = null;
                this.context = null;
                this.uri = null;
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    public SkiaPooledImageRegionDecoder(@Nullable Bitmap.Config config) {
        this.decoderPool = new DecoderPool();
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.fileLength = Long.MAX_VALUE;
        this.imageDimensions = new Point(0, 0);
        this.lazyInited = new AtomicBoolean(false);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = Bitmap.Config.RGB_565;
        }
    }
}
