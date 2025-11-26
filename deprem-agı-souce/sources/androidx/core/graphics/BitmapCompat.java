package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

public final class BitmapCompat {

    @RequiresApi(27)
    static class Api27Impl {
        private Api27Impl() {
        }

        @DoNotInline
        static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                config = Api31Impl.getHardwareBitmapConfig(bitmap);
            }
            return bitmap.copy(config, true);
        }

        @DoNotInline
        static Bitmap createBitmapWithSourceColorspace(int i5, int i6, Bitmap bitmap, boolean z4) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z4 && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(bitmap);
                }
            }
            return Bitmap.createBitmap(i5, i6, config, bitmap.hasAlpha(), colorSpace);
        }

        @DoNotInline
        static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            ColorSpace colorSpace = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (bitmap.getConfig() != Bitmap.Config.RGBA_F16 || !bitmap.getColorSpace().equals(colorSpace)) {
                return false;
            }
            return true;
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            if (bitmap.getHardwareBuffer().getFormat() == 22) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01a4, code lost:
        if (androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r4) == false) goto L_0x01b5;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap createScaledBitmap(@androidx.annotation.NonNull android.graphics.Bitmap r20, int r21, int r22, @androidx.annotation.Nullable android.graphics.Rect r23, boolean r24) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            if (r1 <= 0) goto L_0x0203
            if (r2 <= 0) goto L_0x0203
            if (r3 == 0) goto L_0x0035
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x002d
            int r4 = r3.left
            if (r4 < 0) goto L_0x002d
            int r4 = r3.right
            int r5 = r0.getWidth()
            if (r4 > r5) goto L_0x002d
            int r4 = r3.top
            if (r4 < 0) goto L_0x002d
            int r4 = r3.bottom
            int r5 = r0.getHeight()
            if (r4 > r5) goto L_0x002d
            goto L_0x0035
        L_0x002d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "srcRect must be contained by srcBm!"
            r0.<init>(r1)
            throw r0
        L_0x0035:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 27
            if (r4 < r5) goto L_0x0040
            android.graphics.Bitmap r6 = androidx.core.graphics.BitmapCompat.Api27Impl.copyBitmapIfHardware(r0)
            goto L_0x0041
        L_0x0040:
            r6 = r0
        L_0x0041:
            if (r3 == 0) goto L_0x0048
            int r7 = r3.width()
            goto L_0x004c
        L_0x0048:
            int r7 = r0.getWidth()
        L_0x004c:
            if (r3 == 0) goto L_0x0053
            int r8 = r3.height()
            goto L_0x0057
        L_0x0053:
            int r8 = r0.getHeight()
        L_0x0057:
            float r9 = (float) r1
            float r10 = (float) r7
            float r9 = r9 / r10
            float r10 = (float) r2
            float r11 = (float) r8
            float r10 = r10 / r11
            if (r3 == 0) goto L_0x0062
            int r12 = r3.left
            goto L_0x0063
        L_0x0062:
            r12 = 0
        L_0x0063:
            if (r3 == 0) goto L_0x0068
            int r3 = r3.top
            goto L_0x0069
        L_0x0068:
            r3 = 0
        L_0x0069:
            r13 = 1
            if (r12 != 0) goto L_0x008c
            if (r3 != 0) goto L_0x008c
            int r14 = r0.getWidth()
            if (r1 != r14) goto L_0x008c
            int r14 = r0.getHeight()
            if (r2 != r14) goto L_0x008c
            boolean r1 = r0.isMutable()
            if (r1 == 0) goto L_0x008b
            if (r0 != r6) goto L_0x008b
            android.graphics.Bitmap$Config r1 = r0.getConfig()
            android.graphics.Bitmap r0 = r0.copy(r1, r13)
            return r0
        L_0x008b:
            return r6
        L_0x008c:
            android.graphics.Paint r14 = new android.graphics.Paint
            r14.<init>(r13)
            r14.setFilterBitmap(r13)
            r15 = 29
            if (r4 < r15) goto L_0x009c
            androidx.core.graphics.BitmapCompat.Api29Impl.setPaintBlendMode(r14)
            goto L_0x00a6
        L_0x009c:
            android.graphics.PorterDuffXfermode r15 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r11 = android.graphics.PorterDuff.Mode.SRC
            r15.<init>(r11)
            r14.setXfermode(r15)
        L_0x00a6:
            if (r7 != r1) goto L_0x00bf
            if (r8 != r2) goto L_0x00bf
            android.graphics.Bitmap$Config r0 = r6.getConfig()
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r2, r0)
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r0)
            int r2 = -r12
            float r2 = (float) r2
            int r3 = -r3
            float r3 = (float) r3
            r1.drawBitmap(r6, r2, r3, r14)
            return r0
        L_0x00bf:
            r16 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r16 = java.lang.Math.log(r16)
            r11 = 1065353216(0x3f800000, float:1.0)
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 <= 0) goto L_0x00db
            r23 = r11
            r15 = r12
            double r11 = (double) r9
            double r11 = java.lang.Math.log(r11)
            double r11 = r11 / r16
            double r11 = java.lang.Math.ceil(r11)
        L_0x00d9:
            int r9 = (int) r11
            goto L_0x00ea
        L_0x00db:
            r23 = r11
            r15 = r12
            double r11 = (double) r9
            double r11 = java.lang.Math.log(r11)
            double r11 = r11 / r16
            double r11 = java.lang.Math.floor(r11)
            goto L_0x00d9
        L_0x00ea:
            int r11 = (r10 > r23 ? 1 : (r10 == r23 ? 0 : -1))
            if (r11 <= 0) goto L_0x00fb
            double r10 = (double) r10
            double r10 = java.lang.Math.log(r10)
            double r10 = r10 / r16
            double r10 = java.lang.Math.ceil(r10)
        L_0x00f9:
            int r10 = (int) r10
            goto L_0x0107
        L_0x00fb:
            double r10 = (double) r10
            double r10 = java.lang.Math.log(r10)
            double r10 = r10 / r16
            double r10 = java.lang.Math.floor(r10)
            goto L_0x00f9
        L_0x0107:
            if (r24 == 0) goto L_0x0138
            if (r4 < r5) goto L_0x0138
            boolean r4 = androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r0)
            if (r4 != 0) goto L_0x0138
            if (r9 <= 0) goto L_0x0118
            int r4 = sizeAtStep(r7, r1, r13, r9)
            goto L_0x0119
        L_0x0118:
            r4 = r7
        L_0x0119:
            if (r10 <= 0) goto L_0x0120
            int r11 = sizeAtStep(r8, r2, r13, r10)
            goto L_0x0121
        L_0x0120:
            r11 = r8
        L_0x0121:
            android.graphics.Bitmap r4 = androidx.core.graphics.BitmapCompat.Api27Impl.createBitmapWithSourceColorspace(r4, r11, r0, r13)
            android.graphics.Canvas r11 = new android.graphics.Canvas
            r11.<init>(r4)
            int r12 = -r15
            float r12 = (float) r12
            int r3 = -r3
            float r3 = (float) r3
            r11.drawBitmap(r6, r12, r3, r14)
            r3 = r6
            r6 = r4
            r4 = r3
            r11 = r13
            r3 = 0
            r12 = 0
            goto L_0x013b
        L_0x0138:
            r4 = 0
            r12 = r15
            r11 = 0
        L_0x013b:
            android.graphics.Rect r15 = new android.graphics.Rect
            r15.<init>(r12, r3, r7, r8)
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            r12 = r9
            r16 = r10
        L_0x0148:
            if (r12 != 0) goto L_0x0155
            if (r16 == 0) goto L_0x014d
            goto L_0x0155
        L_0x014d:
            if (r4 == r0) goto L_0x0154
            if (r4 == 0) goto L_0x0154
            r4.recycle()
        L_0x0154:
            return r6
        L_0x0155:
            if (r12 >= 0) goto L_0x015a
            int r12 = r12 + 1
            goto L_0x015e
        L_0x015a:
            if (r12 <= 0) goto L_0x015e
            int r12 = r12 + -1
        L_0x015e:
            if (r16 >= 0) goto L_0x0165
            int r16 = r16 + 1
        L_0x0162:
            r13 = r16
            goto L_0x016a
        L_0x0165:
            if (r16 <= 0) goto L_0x0162
            int r16 = r16 + -1
            goto L_0x0162
        L_0x016a:
            int r5 = sizeAtStep(r7, r1, r12, r9)
            r17 = r11
            int r11 = sizeAtStep(r8, r2, r13, r10)
            r18 = r12
            r12 = 0
            r3.set(r12, r12, r5, r11)
            if (r18 != 0) goto L_0x0180
            if (r13 != 0) goto L_0x0180
            r5 = 1
            goto L_0x0181
        L_0x0180:
            r5 = r12
        L_0x0181:
            if (r4 == 0) goto L_0x0191
            int r11 = r4.getWidth()
            if (r11 != r1) goto L_0x0191
            int r11 = r4.getHeight()
            if (r11 != r2) goto L_0x0191
            r11 = 1
            goto L_0x0192
        L_0x0191:
            r11 = r12
        L_0x0192:
            if (r4 == 0) goto L_0x01b3
            if (r4 == r0) goto L_0x01b3
            if (r24 == 0) goto L_0x01a7
            int r12 = android.os.Build.VERSION.SDK_INT
            r19 = r5
            r5 = 27
            if (r12 < r5) goto L_0x01a9
            boolean r5 = androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r4)
            if (r5 == 0) goto L_0x01b5
            goto L_0x01a9
        L_0x01a7:
            r19 = r5
        L_0x01a9:
            if (r19 == 0) goto L_0x01b0
            if (r11 == 0) goto L_0x01b5
            if (r17 == 0) goto L_0x01b0
            goto L_0x01b5
        L_0x01b0:
            r12 = 27
            goto L_0x01eb
        L_0x01b3:
            r19 = r5
        L_0x01b5:
            if (r4 == r0) goto L_0x01bc
            if (r4 == 0) goto L_0x01bc
            r4.recycle()
        L_0x01bc:
            if (r18 <= 0) goto L_0x01c1
            r4 = r17
            goto L_0x01c3
        L_0x01c1:
            r4 = r18
        L_0x01c3:
            int r4 = sizeAtStep(r7, r1, r4, r9)
            if (r13 <= 0) goto L_0x01cc
            r5 = r17
            goto L_0x01cd
        L_0x01cc:
            r5 = r13
        L_0x01cd:
            int r5 = sizeAtStep(r8, r2, r5, r10)
            int r11 = android.os.Build.VERSION.SDK_INT
            r12 = 27
            if (r11 < r12) goto L_0x01e3
            if (r24 == 0) goto L_0x01dd
            if (r19 != 0) goto L_0x01dd
            r11 = 1
            goto L_0x01de
        L_0x01dd:
            r11 = 0
        L_0x01de:
            android.graphics.Bitmap r4 = androidx.core.graphics.BitmapCompat.Api27Impl.createBitmapWithSourceColorspace(r4, r5, r0, r11)
            goto L_0x01eb
        L_0x01e3:
            android.graphics.Bitmap$Config r11 = r6.getConfig()
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r11)
        L_0x01eb:
            android.graphics.Canvas r5 = new android.graphics.Canvas
            r5.<init>(r4)
            r5.drawBitmap(r6, r15, r3, r14)
            r15.set(r3)
            r5 = r6
            r6 = r4
            r4 = r5
            r5 = r12
            r16 = r13
            r11 = r17
            r12 = r18
            r13 = 1
            goto L_0x0148
        L_0x0203:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "dstW and dstH must be > 0!"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapCompat.createScaledBitmap(android.graphics.Bitmap, int, int, android.graphics.Rect, boolean):android.graphics.Bitmap");
    }

    public static int getAllocationByteCount(@NonNull Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    public static boolean hasMipMap(@NonNull Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    public static void setHasMipMap(@NonNull Bitmap bitmap, boolean z4) {
        bitmap.setHasMipMap(z4);
    }

    @VisibleForTesting
    static int sizeAtStep(int i5, int i6, int i7, int i8) {
        return i7 == 0 ? i6 : i7 > 0 ? i5 * (1 << (i8 - i7)) : i6 << ((-i7) - 1);
    }
}
